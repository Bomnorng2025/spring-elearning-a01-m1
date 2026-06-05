package co.istad.elearning.features.course;

import co.istad.elearning.features.course.dto.CourseResponse;
import co.istad.elearning.features.course.dto.CreateCourseRequest;
import org.springframework.security.oauth2.jwt.Jwt;

public interface CourseService {
    CourseResponse createCourse(CreateCourseRequest createCourseRequest, Jwt jwt);
}
