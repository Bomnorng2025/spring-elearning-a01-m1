package co.istad.elearning.features.course;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    boolean existsBySlug(String slug);
}
