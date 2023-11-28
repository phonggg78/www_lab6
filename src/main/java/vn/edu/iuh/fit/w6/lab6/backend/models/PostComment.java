package vn.edu.iuh.fit.w6.lab6.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "post_Comment")
public class PostComment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="parentId")
    private PostComment parent;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Override
    public String toString() {
        return "PostComment{" +
                "id=" + id +
                ", post=" + post +
                ", user=" + user +
                ", parent=" + parent +
                ", title='" + title + '\'' +
                ", pulished=" + pulished +
                ", createdAt=" + createdAt +
                ", pulishedAt=" + pulishedAt +
                ", content='" + content + '\'' +
                ", postComments=" + postComments +
                '}';
    }

    public PostComment() {
    }

    public PostComment(Long id, Post post, User user, PostComment parent, String title, boolean pulished, Instant createdAt, Instant pulishedAt, String content, Set<PostComment> postComments) {
        this.id = id;
        this.post = post;
        this.user = user;
        this.parent = parent;
        this.title = title;
        this.pulished = pulished;
        this.createdAt = createdAt;
        this.pulishedAt = pulishedAt;
        this.content = content;
        this.postComments = postComments;
    }

    @Column(name = "pulished", nullable = false)
    private boolean pulished;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "pulishedAt")
    private  Instant pulishedAt;

    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "parent")
    private Set<PostComment> postComments = new LinkedHashSet<>();
}
