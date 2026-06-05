package co.istad.elearning.features.course;

import co.istad.elearning.features.category.Category;
import co.istad.elearning.features.category.CategoryRepository;
import co.istad.elearning.features.course.dto.CourseResponse;
import co.istad.elearning.features.course.dto.CreateCourseRequest;
import co.istad.elearning.features.instructor.InstructorProfile;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class CourseServiceImpl implements CourseService {

    private final CategoryRepository categoryRepository;
    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    public CourseServiceImpl(CategoryRepository categoryRepository, CourseRepository courseRepository, CourseMapper courseMapper) {
        this.categoryRepository = categoryRepository;
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
    }

    @Override
    public CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt) {

        if (courseRepository.existsBySlug(createCourseRequest.slug())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Slug has already been used");
        }

        Category category = categoryRepository.findById(createCourseRequest.categoryId().toString())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Category has not found..!"
                ));

        Course course = courseMapper.mapCreateCourseRequestToCourse(createCourseRequest);

        course.setCategory(category);
        course.setCountRating(0);
        course.setStarRating(0F);
        course.setIsDeleted(false);
        course.setIsPublished(false);
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(LocalDateTime.now());

        course.setInstructorProfile(new InstructorProfile(jwt.getSubject()));

        course = courseRepository.save(course);

        return courseMapper.mapCourseToCourseResponse(course);
    }
}
