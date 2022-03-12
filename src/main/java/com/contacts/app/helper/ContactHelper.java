package com.contacts.app.helper;

import com.contacts.app.model.SignUp;
import org.springframework.stereotype.Service;

@Service
public class ContactHelper {

    public boolean validateFormData(SignUp signUp){

        if (signUp == null || signUp.getEmail() == null
            || signUp.getEmail().isEmpty()
            || signUp.getPassword() == null
            || signUp.getPassword().isEmpty()
            || signUp.getSecret() == null
            || signUp.getSecret().isEmpty()){
            return false;
        }
        return true;
    }
}
