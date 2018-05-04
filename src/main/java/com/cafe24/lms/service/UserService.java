package com.cafe24.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.lms.domain.Role;
import com.cafe24.lms.domain.User;
import com.cafe24.lms.repository.UserRepository;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    
    public void save(User user) {
	user.setRole( Role.user );
	userRepository.save(user);
    }

    public User getUser(String email, String password) {
	return userRepository.findByEmailAndPassword( email, password );
    }

}
