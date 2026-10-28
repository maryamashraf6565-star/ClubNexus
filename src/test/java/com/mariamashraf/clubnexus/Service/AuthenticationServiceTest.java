package com.mariamashraf.clubnexus.Service;

import com.mariamAshraf.clubNexus.Model.DTO.user.UserRequestDTO;
import com.mariamAshraf.clubNexus.Model.DTO.user.UserResponseDTO;
import com.mariamAshraf.clubNexus.Model.Entity.User;
import com.mariamAshraf.clubNexus.Model.Entity.enums.Role;
import com.mariamAshraf.clubNexus.Model.Entity.enums.StudentStatus;
import com.mariamAshraf.clubNexus.Repository.UserRepo;
import com.mariamAshraf.clubNexus.Service.AuthenticationService;
import com.mariamAshraf.clubNexus.Utils.ValidationHelpers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationServiceTest {
    //the mock DIs needed
    @Mock
    private ValidationHelpers validatorHelper;
    @Mock
    private UserRepo userRepo;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationManager authenticationManager;
    @Captor
    private ArgumentCaptor<User> userCaptor;
    //Which service you want to test and injects the mocks in it:
    @InjectMocks
    private AuthenticationService authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        //telling Mockito to start the mocks for this class
    }

    @Test
    public void should_login_user_succesfully(){
        //given(the function parameters and all the object it will create)

        UserRequestDTO userRequestDTOdto = new UserRequestDTO();
        userRequestDTOdto.setUsername("john_doe");
        userRequestDTOdto.setEmail("john@example.com");
        userRequestDTOdto.setPassword("password123");
        userRequestDTOdto.setRole(Role.MEMBER);          // Assuming you have a STUDENT enum
        userRequestDTOdto.setStudentStatus(StudentStatus.UNDERGRADUATE);
        userRequestDTOdto.setEnabled(true);
        userRequestDTOdto.setMajor("Computer Science");
        userRequestDTOdto.setGraduationYear(2027);

        Boolean same=Boolean.TRUE;
        
//        UserResponseDTO userResponseDto = new UserResponseDTO();
//        userResponseDto.setUsername(userRequestDTOdto.getUsername());
//        userResponseDto.setEmail(userRequestDTOdto.getEmail());
//        userResponseDto.setRole(userRequestDTOdto.getRole());
//        userResponseDto.setStudentStatus(userRequestDTOdto.getStudentStatus());
//        userResponseDto.setMajor(userRequestDTOdto.getMajor());
        //Mock teh calls
        Mockito.when(validatorHelper.is_username_unique(userRequestDTOdto.getUsername())).thenReturn(same);
        Mockito.when(validatorHelper.is_password_valid_for_username(userRequestDTOdto)).thenReturn(same);
        //when(the expected object from the function )
        UserResponseDTO responseDTO = authService.Login_user(userRequestDTOdto);
        // then
        assertEquals(userRequestDTOdto.getEmail(),responseDTO.getEmail());
        assertEquals(userRequestDTOdto.getUsername(),responseDTO.getUsername());
        assertEquals(userRequestDTOdto.getRole(),responseDTO.getRole());
        assertEquals(userRequestDTOdto.getMajor(),responseDTO.getMajor());
        assertEquals(userRequestDTOdto.getStudentStatus(),responseDTO.getStudentStatus());
    }

    @Test
    public void is_register_user_successfully(){
        //given
        UserRequestDTO userRequestDTOdto = new UserRequestDTO();
        userRequestDTOdto.setUsername("john_doe");
        userRequestDTOdto.setEmail("john@example.com");
        userRequestDTOdto.setPassword("password123");
        userRequestDTOdto.setRole(Role.MEMBER);          // Assuming you have a STUDENT enum
        userRequestDTOdto.setStudentStatus(StudentStatus.UNDERGRADUATE);
        userRequestDTOdto.setEnabled(true);
        userRequestDTOdto.setMajor("Computer Science");
        userRequestDTOdto.setGraduationYear(2027);

        Boolean unique=Boolean.TRUE;
        Boolean year=Boolean.TRUE;

        //Mock the inside calls
        Mockito.when(validatorHelper.is_username_unique(userRequestDTOdto.getUsername())).thenReturn(unique);
        Mockito.when(validatorHelper.is_graduation_year_valid(userRequestDTOdto)).thenReturn(year);
        Mockito.when(passwordEncoder.encode(userRequestDTOdto.getPassword())).thenReturn("encodedPassword");
        //when
        UserResponseDTO responseDTO=authService.register_user(userRequestDTOdto);

        //then
        assertEquals(userRequestDTOdto.getEmail(),responseDTO.getEmail());
        assertEquals(userRequestDTOdto.getUsername(),responseDTO.getUsername());
        assertEquals(userRequestDTOdto.getRole(),responseDTO.getRole());
        assertEquals(userRequestDTOdto.getMajor(),responseDTO.getMajor());
        assertEquals(userRequestDTOdto.getStudentStatus(),responseDTO.getStudentStatus());

        //Mockito.verify(userRepo,Mockito.times(1)).save(Mockito.any(User.class));
        // Instead of: Mockito.verify(userRepo, Mockito.times(1)).save(user);

// Use the captor to get the actual User passed to save
        Mockito.verify(userRepo, Mockito.times(1)).save(userCaptor.capture());
        Mockito.verify(passwordEncoder,Mockito.times(1)).encode(userRequestDTOdto.getPassword());
        User actualSavedUser = userCaptor.getValue();

// Now assert that the actual saved user has the correct data
        assertEquals(userRequestDTOdto.getEmail(), actualSavedUser.getEmail());
        assertEquals(userRequestDTOdto.getUsername(), actualSavedUser.getUsername());
        assertEquals(userRequestDTOdto.getRole(), actualSavedUser.getRole());
        assertEquals(userRequestDTOdto.getMajor(), actualSavedUser.getMajor());
        assertEquals(userRequestDTOdto.getStudentStatus(), actualSavedUser.getStudentStatus());
        assertEquals(userRequestDTOdto.getGraduationYear(), actualSavedUser.getGraduationYear());

// Verify the password was encoded before saving
        Mockito.verify(passwordEncoder).encode(userRequestDTOdto.getPassword());
        assertEquals("encodedPassword", actualSavedUser.getPassword()); // Assuming you mock encode()
    }
}