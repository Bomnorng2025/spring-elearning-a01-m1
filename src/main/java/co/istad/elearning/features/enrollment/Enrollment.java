package co.istad.elearning.features.enrollment;

import co.istad.elearning.features.course.Course;
import co.istad.elearning.features.student.StudentProfile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enrollments")
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentProfile studentProfile;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private Boolean paymentStatus;
    private String paymentMethod;
    private LocalDateTime paymentAt;
    private LocalDateTime createdAt;

}
