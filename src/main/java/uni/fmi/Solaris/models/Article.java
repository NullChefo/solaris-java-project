package uni.fmi.Solaris.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ARTICLES")
public class Article extends MainModel{
    private String content;
    private String title;
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @ManyToOne()
    @JoinColumn(name = "USER_ID")
    private User owner;

}
