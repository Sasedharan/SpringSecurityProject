package com.em.ProjectSpringBoot.Service;

import com.em.ProjectSpringBoot.Entity.User;
import com.em.ProjectSpringBoot.Repository.UserRepository;
import com.em.ProjectSpringBoot.dto.ResponseDTO;
import com.em.ProjectSpringBoot.dto.UserDto;
import com.em.ProjectSpringBoot.dto.UserResponseDTO;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public ResponseDTO saveAllMethod(UserDto user) {
        ResponseDTO responseDTO = new ResponseDTO();
        User user1 = modelMapper.map(user,User.class);
        User u = userRepository.save(user1);
        logger.info("The Saved Info is : [" + u +"]");
        responseDTO.setErrorMessage("Inserted Successfully");
        responseDTO.setErrorCode("200 - OK ");
        return responseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllMethod() {
        /*UserResponseDTO userResponseDTO = new UserResponseDTO();
        User user2 = modelMapper.map(" ",User.class);
        List<User> l = userRepository.findAll();
        logger.info("The list of User Info are: [" + l +"]");*/
        return ((List<User>) userRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());

    }
    public UserResponseDTO convertDataIntoDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setAge(user.getAge());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setEmailID(user.getEmailID());
        return userResponseDTO;

    }

    @Override
    public UserResponseDTO getByIdMethod(Long id) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        User user3 = modelMapper.map(id,User.class);
        User u = userRepository.findById(id).get();
        logger.info("The Saved Info in the ID :[" + id +"]" + "is [" + u + "]");
        userResponseDTO.setName(u.getName());
        userResponseDTO.setAge(u.getAge());
        userResponseDTO.setAddress(u.getAddress());
        userResponseDTO.setEmailID(u.getEmailID());
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO updateByIdMethod(Long idno,User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        User u = userRepository.findById(idno).get();
        u.setUserID(user.getUserID());
        u.setName(user.getName());
        u.setPwd(user.getPwd());
        u.setAge(user.getAge());
        u.setEmailID(user.getEmailID());
        u.setAddress(user.getAddress());
        userRepository.save(u);
        userResponseDTO.setName(u.getName());
        userResponseDTO.setAge(u.getAge());
        userResponseDTO.setAddress(u.getAddress());
        userResponseDTO.setEmailID(u.getEmailID());
        logger.info(" The Updated Info is : [" + u +"]");
        return userResponseDTO;

    }

    @Override
    public ResponseDTO deleteAllMethod() {
        ResponseDTO responseDTO = new ResponseDTO();
        userRepository.deleteAll();
        logger.info("[ The User Info - Successfully Deleted from Table ]");
        responseDTO.setErrorMessage("Deleted - Successfully");
        responseDTO.setErrorCode("202 - Accepted");
        return responseDTO;
    }

    @Override
    public ResponseDTO deleteByIdMethod(Long id) {
        ResponseDTO responseDTO = new ResponseDTO();
        userRepository.deleteById(id);
        logger.info("[ The User Info - Deleted by using ID : " + id + "]");
        responseDTO.setErrorMessage("Deleted Successfully by using ID");
        responseDTO.setErrorCode(" 202 - Accepted");
        return responseDTO;
    }


}

