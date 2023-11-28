package vn.edu.iuh.fit.w6.lab6.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.w6.lab6.backend.models.PostComment;
import vn.edu.iuh.fit.w6.lab6.backend.repository.PostCommentRepository;

import java.util.List;
@Service
public class PostCommentService {
    @Autowired
    private PostCommentRepository postCommentRepository;

    public List<PostComment> findAll(){
        return postCommentRepository.findAll();
    }
    
}
