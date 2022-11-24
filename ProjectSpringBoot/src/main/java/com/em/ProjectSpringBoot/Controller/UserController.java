package com.em.ProjectSpringBoot.Controller;

import com.em.ProjectSpringBoot.Entity.User;
import com.em.ProjectSpringBoot.Service.UserService;
import com.em.ProjectSpringBoot.dto.ResponseDTO;
import com.em.ProjectSpringBoot.dto.UserDto;
import com.em.ProjectSpringBoot.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseDTO saveAllMethod(@RequestBody UserDto user){
        return userService.saveAllMethod(user);
    }
    @GetMapping
    public List<UserResponseDTO> getAllMethod(){
        return userService.getAllMethod();

    }
    @GetMapping("/{id}")
    public UserResponseDTO getByIdMethod(@PathVariable Long id){
        return userService.getByIdMethod(id);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateByIdMethod(@PathVariable("id")Long idno, @RequestBody User user){
        return userService.updateByIdMethod(idno,user);
    }
    @DeleteMapping
    public ResponseDTO deleteAllMethod(){
        return userService.deleteAllMethod();
    }
    @DeleteMapping("/{id}")
    public  ResponseDTO deleteByIdMethod(@PathVariable Long id){
    return userService.deleteByIdMethod(id);

    }

    }




