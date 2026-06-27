package co.istad.elearning.features.course;

import co.istad.elearning.features.course.dto.CourseResponse;
import co.istad.elearning.features.course.dto.CreateCourseRequest;
import org.springframework.data.domain.Page;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt);
    Page<CourseResponse> getAllCourse(int pageNumber, int pageSize);
    CourseResponse updateById(Integer id, CreateCourseRequest request);
}
