package co.istad.elearning.features.video;

import co.istad.elearning.features.comment.Comment;
import co.istad.elearning.features.course.Course;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "videos")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String slug;
    private String title;
    private String thumbnail;
    private String duration;

    private String youtube;

    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "video")
    private List<Comment> comments;

    private Boolean isPublished;
    private Boolean isDeleted;
}
