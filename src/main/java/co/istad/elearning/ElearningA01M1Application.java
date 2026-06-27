package co.istad.elearning;

import co.istad.elearning.features.course.Course;
import co.istad.elearning.features.course.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class ElearningA01M1Application implements CommandLineRunner {

    private final CourseRepository courseRepository;

    public ElearningA01M1Application(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(ElearningA01M1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        List<Course> courses = courseRepository.allCourses();
        Course course = courseRepository.byId(2);

//        System.out.println(course.getTitle());

    }
}
