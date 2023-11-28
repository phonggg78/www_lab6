package vn.edu.iuh.fit.w6.lab6.frontend.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.w6.lab6.backend.models.User;
import vn.edu.iuh.fit.w6.lab6.backend.repository.UserRepository;
import vn.edu.iuh.fit.w6.lab6.backend.services.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/listComment")
    public List<User> showUser(){
        return userService.findAll();
    }
}
