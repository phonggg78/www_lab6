package vn.edu.iuh.fit.w6.lab6.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.w6.lab6.backend.models.User;
import vn.edu.iuh.fit.w6.lab6.backend.repository.UserRepository;


import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

}
