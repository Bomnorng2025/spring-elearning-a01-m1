package co.istad.elearning.features.category;

import co.istad.elearning.features.category.dto.CategoryRequest;
import co.istad.elearning.features.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public CategoryResponse createNew(CategoryRequest request) {
        if (categoryRepository.existsByName(request.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category is existed..!");
        }

        Category category = categoryMapper.categoryRequestToCategory(request);

        category = categoryRepository.save(category);

        return categoryMapper.categoryToCategoryResponse(category);
    }

    @Override
    public Page<CategoryResponse> getAllCategories(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);

        return categoryRepository.findAll(pageRequest)
                .map(categoryMapper::categoryToCategoryResponse);
    }

    @Override
    public CategoryResponse getById(Integer id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::categoryToCategoryResponse)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("> Category by id: %s not found..!", id)
                ));
    }

    @Override
    public CategoryResponse updateById(Integer id, CategoryRequest updateCategory) {
        if (categoryRepository.existsByName(updateCategory.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Category is existed..!");
        }

        Category categoryById = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, 
                        "Category not found..!"
                ));

        categoryById.setName(updateCategory.name());
        categoryById.setIsDeleted(updateCategory.isDeleted());

        categoryById = categoryRepository.save(categoryById);

        return categoryMapper.categoryToCategoryResponse(categoryById);
    }

    @Override
    public void deleteById(Integer id) {
        Category categoryById = categoryRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category not found..!"
                ));
        categoryRepository.delete(categoryById);
    }
}
