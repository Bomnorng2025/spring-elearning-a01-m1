package co.istad.elearning.features.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, String> {
    boolean existsBySlug(String slug);

//    use named query
    List<Course> allCourses();
    Course byId(Integer id);
}
