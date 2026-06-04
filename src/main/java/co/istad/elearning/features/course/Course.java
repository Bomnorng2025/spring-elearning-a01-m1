package co.istad.elearning.features.course;

import co.istad.elearning.features.category.Category;
import co.istad.elearning.features.enrollment.Enrollment;
import co.istad.elearning.features.instructor.InstructorProfile;
import co.istad.elearning.features.video.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String keyword;
    private String title;
    private String description;
    private String thumbnail;
    private Float starRating;
    private Integer countRating;
    private Float totalHours;
    private String level;
    private BigDecimal price;
    private Float discountPercent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "course")
    private List<Video> videos;

    private Boolean isPublished;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private InstructorProfile instructorProfile;

    @OneToMany(mappedBy = "course")
    private List<Enrollment> enrollments;
}
