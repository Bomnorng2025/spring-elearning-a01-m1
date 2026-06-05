package co.istad.elearning.features.category;

import co.istad.elearning.features.category.dto.CategoryRequest;
import co.istad.elearning.features.category.dto.CategoryResponse;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Page<CategoryResponse> getAllCategories(int pageNumber, int pageSize);
    CategoryResponse getById(Integer id);

    CategoryResponse createNew(CategoryRequest request);

    CategoryResponse updateById(Integer id, CategoryRequest updateCategory);
    void deleteById(Integer id);
}
