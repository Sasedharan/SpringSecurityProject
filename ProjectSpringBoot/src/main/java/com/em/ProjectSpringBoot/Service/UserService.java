package com.em.ProjectSpringBoot.Service;

import com.em.ProjectSpringBoot.Entity.User;
import com.em.ProjectSpringBoot.dto.ResponseDTO;
import com.em.ProjectSpringBoot.dto.UserDto;
import com.em.ProjectSpringBoot.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
     ResponseDTO saveAllMethod(UserDto user);

    List<UserResponseDTO> getAllMethod();

    UserResponseDTO getByIdMethod(Long id);

    UserResponseDTO updateByIdMethod(Long idno ,User user);

    ResponseDTO deleteAllMethod();

    ResponseDTO deleteByIdMethod(Long id);
}
