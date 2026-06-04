package co.istad.elearning.features.student;

import co.istad.elearning.features.enrollment.Enrollment;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_profiles")
public class StudentProfile {
    @Id
    private String userId;

    private String university;
    private String major;
    private String biography;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "studentProfile")
    private List<Enrollment> enrollments;
}
