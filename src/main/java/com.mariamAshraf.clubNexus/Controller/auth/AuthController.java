package com.mariamAshraf.clubNexus.Controller.auth;
import com.mariamAshraf.clubNexus.Model.DTO.user.UserRequestDTO;
import com.mariamAshraf.clubNexus.Service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    private AuthenticationService authService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public  String viewLoginForm(){
        return "Login";
    }
    @GetMapping("/Login")
    @ResponseStatus(HttpStatus.OK)
    public String LoginMember(){
        return "redirect:/home";
    }

    @GetMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public String viewRegisterForm(){
        return "register";
    }
    @PostMapping("/regitser")
    @ResponseStatus(HttpStatus.CREATED)
    public String registerMember(@ModelAttribute UserRequestDTO userRequestDTO){
        return "redirect:/login";
    }


    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
