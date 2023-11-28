package vn.edu.iuh.fit.w6.lab6.frontend.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.w6.lab6.backend.repository.PostCommentRepository;
import vn.edu.iuh.fit.w6.lab6.backend.services.PostCommentService;

@Controller
public class PostCommentController {
    @Autowired
    private PostCommentRepository postCommentRepository;
    @Autowired
    private PostCommentService postCommentService;

    @GetMapping("/listComment")
    public String showCommnetList(Model model){
        model.addAttribute("post_Comment", postCommentRepository.findAll());
        return  "PostComment/PostComment";
    }
}
