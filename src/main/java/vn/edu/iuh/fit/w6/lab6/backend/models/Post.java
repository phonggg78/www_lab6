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
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @ManyToOne(fetch =  FetchType.LAZY, optional = false)
    @JoinColumn(name="authorId",nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="parentId")
    private Post parent;

    @Column(name = "title", nullable = false,length =  75)
    private String title;

    @Column(name = "metaTitle", length = 100)
    private String metaTile;

    @Lob
    @Column(name = "sumary")
    private String sumary;

    @Column(name = "pulished", nullable = false)
    private boolean pulished;

    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;

    @Column(name = "updatedAt")
    private  Instant updateAt;

    @Column(name = "pulishedAt")
    private  Instant pulishedAt;


    @Lob
    @Column(name = "content")
    private String content;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments = new LinkedHashSet<>();

    public Post(Long id, User author, Post parent, String title, String metaTile, String sumary, boolean pulished, Instant createdAt, Instant updateAt, Instant pulishedAt, String content, Set<Post> posts, Set<PostComment> postComments) {
        this.id = id;
        this.author = author;
        this.parent = parent;
        this.title = title;
        this.metaTile = metaTile;
        this.sumary = sumary;
        this.pulished = pulished;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
        this.pulishedAt = pulishedAt;
        this.content = content;
        this.posts = posts;
        this.postComments = postComments;
    }

    public Post() {
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", author=" + author +
                ", parent=" + parent +
                ", title='" + title + '\'' +
                ", metaTile='" + metaTile + '\'' +
                ", sumary='" + sumary + '\'' +
                ", pulished=" + pulished +
                ", createdAt=" + createdAt +
                ", updateAt=" + updateAt +
                ", pulishedAt=" + pulishedAt +
                ", content='" + content + '\'' +
                ", posts=" + posts +
                ", postComments=" + postComments +
                '}';
    }
}
