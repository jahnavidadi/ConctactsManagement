package com.contacts.app.controllers;

import com.contacts.app.entity.Contacts;
import com.contacts.app.entity.User;
import com.contacts.app.model.ContactInfo;
import com.contacts.app.model.UserInfo;
import com.contacts.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WelcomeController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/welcome")
    public String getCustomerInfo(@ModelAttribute User user, Model model){
        UserInfo userInfo = new UserInfo();
        if (user != null){
            userInfo.setId(user.getId());
            userInfo.setEmail(user.getEmail());
            userInfo.setContacts(user.getContacts());
        }
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("contact", new ContactInfo());
        return "welcome";
    }

    @PostMapping("/welcome")
    public String getCustomerInfo(@ModelAttribute ContactInfo contactInfo, Model model){
        UserInfo userInfo = new UserInfo();
        if (contactInfo.getId() == null){
            return "redirect:/login";
        }
        Optional<User> userOptional = userRepository.findById(contactInfo.getId());
        if (userOptional != null && userOptional.isPresent()){
            User user = userOptional.get();
            Contacts contact = new Contacts(contactInfo.getName(),contactInfo.getEmail(),contactInfo.getPhoneno());
            List<Contacts> contacts = user.getContacts();
            if (contacts == null){
                contacts = new ArrayList<>();
            }
            contacts.add(contact);
            user.setContacts(contacts);
            userRepository.save(user);
            userInfo.setId(user.getId());
            userInfo.setEmail(user.getEmail());
            userInfo.setContacts(user.getContacts());
        }
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("contact", new ContactInfo());
        return "welcome";
    }
}
