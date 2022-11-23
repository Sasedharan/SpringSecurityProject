package com.em.ProjectSpringBoot.Controller;

import com.em.ProjectSpringBoot.Entity.User;
import com.em.ProjectSpringBoot.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    public User saveAllMethod(@RequestBody User user){
        return userService.saveAllMethod(user);
    }
    @GetMapping
    public List<User> getAllMethod(){
        return userService.getAllMethod();

    }
    @GetMapping("/{id}")
    public User getByIdMethod(@PathVariable Long id){
        return userService.getByIdMethod(id);
    }

    @PutMapping("/{id}")
    public User updateByIdMethod(@PathVariable("id")@RequestBody User user){
        return userService.updateByIdMethod(user);
    }
    @DeleteMapping
    public String deleteAllMethod(){
        userService.deleteAllMethod();
        return "The UserInfo - deleted ";
    }
    @DeleteMapping("/{id}")
    public String deleteByIdMethod(@PathVariable Long id){
    userService.deleteByIdMethod(id);

    return "UserInfo deleted in " + id;
    }
}
