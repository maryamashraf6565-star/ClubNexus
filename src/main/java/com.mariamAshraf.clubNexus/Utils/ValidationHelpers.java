package com.mariamAshraf.clubNexus.Utils;
import com.mariamAshraf.clubNexus.Model.DTO.user.UserRequestDTO;
import com.mariamAshraf.clubNexus.Model.Entity.User;
import com.mariamAshraf.clubNexus.Model.Entity.enums.StudentStatus;
import com.mariamAshraf.clubNexus.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Year;

@Component
public class ValidationHelpers {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

//----------------------------------------------------------------------------------
    public Boolean is_username_unique(String username){
        return !userRepo.existsByUsername(username);
    }
//---------------------------------------------------------------------------------------
    public Boolean is_graduation_year_valid(UserRequestDTO userDTO){
        //getting current year
        int currentYear= Year.now().getValue();
        //checking the validatity of the garduation year entered
        if(userDTO.getStudentStatus()== StudentStatus.UNDERGRADUATE){
            //the entered year must be bigger than the current
            return userDTO.getGraduationYear() >= currentYear;
        }
        else if(userDTO.getStudentStatus()== StudentStatus.GRADUATE){
            return userDTO.getGraduationYear() <= currentYear;
        }
        return true;
    }
//-------------------------------------------------------------------------------------------
    public Boolean is_password_valid_for_username( UserRequestDTO request){
        User user = userRepo.findByUsername(request.getUsername())
                .orElse(null);
        if (user == null) return false;
        return passwordEncoder.matches(request.getPassword(), user.getPassword());
        }

}
