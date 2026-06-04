package co.istad.elearning.features.comment;

import co.istad.elearning.features.video.Video;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String test;
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parentComment;

    private LocalDateTime createdAt;

    @ManyToOne
    private Video video;
}
