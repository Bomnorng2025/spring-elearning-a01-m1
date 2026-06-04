package co.istad.elearning.features.instructor;

import co.istad.elearning.features.course.Course;
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
@Table(name = "instructor_profiles")
public class InstructorProfile {
    @Id
    private String userId;

    private String biography;
    private String jobTitle;
    private String phoneNumber;
    private String githubLink;
    private String facebookLink;

    @OneToMany(mappedBy = "instructorProfile")
    private List<Course> courses;
}
