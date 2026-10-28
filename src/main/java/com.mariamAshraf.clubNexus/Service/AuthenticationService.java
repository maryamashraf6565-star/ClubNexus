package com.mariamAshraf.clubNexus.Service;

import com.mariamAshraf.clubNexus.Model.DTO.user.UserRequestDTO;
import com.mariamAshraf.clubNexus.Model.DTO.user.UserResponseDTO;
import com.mariamAshraf.clubNexus.Model.Entity.User;
import com.mariamAshraf.clubNexus.Repository.UserRepo;
import com.mariamAshraf.clubNexus.Utils.ValidationHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private ValidationHelpers validatorHelper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public UserResponseDTO convert_to_response(UserRequestDTO userDTO_request){
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setEmail(userDTO_request.getEmail());
        userResponseDTO.setUsername(userDTO_request.getUsername());
        userResponseDTO.setRole(userDTO_request.getRole());
        userResponseDTO.setStudentStatus(userDTO_request.getStudentStatus());
        userResponseDTO.setMajor(userDTO_request.getMajor());
        return userResponseDTO;
    }
//----------------------------------------------REGISTER:-------------------------------------------------------
    public UserResponseDTO register_user(UserRequestDTO userDTO_request){
        if(!validatorHelper.is_username_unique(userDTO_request.getUsername())){
            return null;
        }
        if(!validatorHelper.is_graduation_year_valid(userDTO_request)){
            return null;
        }
        User user =new User(); //creating new user

        user.setEmail(userDTO_request.getEmail());
        user.setUsername(userDTO_request.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO_request.getPassword()));
        user.setRole(userDTO_request.getRole());
        user.setStudentStatus(userDTO_request.getStudentStatus());
        user.setMajor(userDTO_request.getMajor());
        user.setGraduationYear(userDTO_request.getGraduationYear());
        user.setEnabled(true);

        userRepo.save(user); //saving new user in the database

        return convert_to_response(userDTO_request);
    }
// ----------------------------------------------LOGIN:-------------------------------------------------------
    public UserResponseDTO Login_user(UserRequestDTO userDTO_request) {
        if(!validatorHelper.is_username_unique(userDTO_request.getUsername())){
            return null;
        }
        if(!validatorHelper.is_password_valid_for_username(userDTO_request)){
            return  null;
        }
        return convert_to_response(userDTO_request);
    }


}
