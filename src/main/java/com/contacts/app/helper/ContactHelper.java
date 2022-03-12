package com.contacts.app.helper;

import com.contacts.app.entity.User;
import com.contacts.app.model.SignUp;
import com.contacts.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContactHelper {
    @Autowired
    UserRepository userRepo;

    public boolean validateFormData(SignUp signUp){

        if (signUp == null || signUp.getEmail() == null
            || signUp.getEmail().isEmpty()
            || signUp.getPassword() == null
            || signUp.getPassword().isEmpty()
            || signUp.getSecret() == null
            || signUp.getSecret().isEmpty()){
            return false;
        }

        Optional<User> byEmail = userRepo.findByEmail(signUp.getEmail());
        if (byEmail != null && byEmail.isPresent()){
            return false;
        }
        return true;
    }
}
