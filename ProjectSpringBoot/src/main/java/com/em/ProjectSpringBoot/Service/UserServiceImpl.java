package com.em.ProjectSpringBoot.Service;

import com.em.ProjectSpringBoot.Entity.User;
import com.em.ProjectSpringBoot.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService{

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveAllMethod(User user) {
        User u = userRepository.save(user);
        logger.info("The Saved Info is : [" + u +"]");
        return u;
    }

    @Override
    public List<User> getAllMethod() {
        List<User> l = userRepository.findAll();
        logger.info("The list of User Info are: [" + l +"]");
        return l;
    }

    @Override
    public User getByIdMethod(Long id) {
        User u = userRepository.findById(id).get();
        logger.info("The Saved Info in the ID :[" + id +"]" + "is [" + u + "]");
        return u;
    }

    @Override
    public User updateByIdMethod(User user) {
        User u = userRepository.save(user);
        logger.info(" The Updated Info is : [" + u +"]");
        return u;

    }

    @Override
    public void deleteAllMethod() {
        userRepository.deleteAll();
        logger.info("[ The User Info - Successfully Deleted from Table ]");
    }

    @Override
    public void deleteByIdMethod(Long id) {
        userRepository.deleteById(id);
        logger.info("[ The User Info - Deleted by using ID : " + id + "]");
    }

}

