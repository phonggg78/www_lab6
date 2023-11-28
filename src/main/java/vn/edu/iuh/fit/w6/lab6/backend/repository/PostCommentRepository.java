package vn.edu.iuh.fit.w6.lab6.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.w6.lab6.backend.models.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
