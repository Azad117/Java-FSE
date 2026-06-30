package org.example.Service;

import org.example.Model.User;
import org.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepo;

    public UserService(@Autowired UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User getUserById(Long id)
    {
        return userRepo.findById(id).orElse(null);
    }
}
