package com.implemica.loginpage.controller;


import com.implemica.loginpage.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@CrossOrigin
@RestController
public class MainController {

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   private String login = "user";
   private String password = "password";

   @PostMapping("/login")
   public User login(@RequestBody User user) {
      logger.info(user.toString());

      User result;

      if(isRightUser(user)) {
         result = user;
      } else {
         result = null;
      }

      return result;
   }

   private boolean isRightUser(User user) {
      return user.getUsername().equals(login) && user.getPassword().equals(password);
   }
}

