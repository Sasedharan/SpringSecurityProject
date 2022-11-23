package com.em.ProjectSpringBoot.Service;

import com.em.ProjectSpringBoot.Entity.User;

import java.util.List;

public interface UserService {
    User saveAllMethod(User user);

    List<User> getAllMethod();

    User getByIdMethod(Long id);

    User updateByIdMethod(User user);

    void deleteAllMethod();

    void deleteByIdMethod(Long id);
}
