package org.example.library.services;

import lombok.AllArgsConstructor;
import org.example.library.models.User;
import org.example.library.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

//    private User getUser(User user){
//
//    }
}
