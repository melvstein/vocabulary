package dev.melvstein.vocabulary.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "vocabularies",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"user_id", "word"})
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(length = 64, nullable = false)
    private String word;

    @Column(length = 32)
    private String partOfSpeech;

    @Column(columnDefinition = "text")
    private String englishDefinition;

    @Column(columnDefinition = "text")
    private String tagalogDefinition;

    @Column(columnDefinition = "json")
    private String englishSynonyms;

    @Column(columnDefinition = "json")
    private String tagalogSynonyms;

    @Column(columnDefinition = "json")
    private String englishAntonyms;

    @Column(columnDefinition = "json")
    private String tagalogAntonyms;

    @Column(columnDefinition = "text")
    private String exampleSentence;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;
}
