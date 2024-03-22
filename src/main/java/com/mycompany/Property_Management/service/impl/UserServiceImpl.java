package com.mycompany.Property_Management.service.impl;

import com.mycompany.Property_Management.converter.UserConverter;
import com.mycompany.Property_Management.dto.UserDTO;
import com.mycompany.Property_Management.entity.UserEntity;
import com.mycompany.Property_Management.exception.BusinessException;
import com.mycompany.Property_Management.exception.ErrorModel;
import com.mycompany.Property_Management.repository.UserRepository;
import com.mycompany.Property_Management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO register(UserDTO userDTO) {
        UserEntity userEntity=userConverter.convertDTOtoEntity(userDTO);
        Optional<UserEntity> optEn = userRepository.findByEmail(userDTO.getEmail());
        if(optEn.isEmpty())
        {
            userEntity=userRepository.save(userEntity);
        }
        else
        {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("EMAIL_ALREADY_EXIST");
            errorModel.setMessage("The email with which you are trying to register already exists");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        userDTO=userConverter.convertEntityToDTO(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO login(String email, String password) {
        Optional<UserEntity> optEn=userRepository.findByEmailAndPassword(email,password);
        UserDTO userDTO=null;
        if(optEn.isPresent())
        {
            UserEntity userEntity=optEn.get();
            userDTO=userConverter.convertEntityToDTO(userEntity);
        }
        else
        {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel=new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect Email or Password");
            errorModelList.add(errorModel);
            throw new BusinessException(errorModelList);
        }
        return userDTO;
    }
}
