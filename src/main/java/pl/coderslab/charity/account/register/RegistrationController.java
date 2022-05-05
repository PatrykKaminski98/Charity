package pl.coderslab.charity.account.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.account.user.User;
import pl.coderslab.charity.account.user.UserRole;
import pl.coderslab.charity.account.user.UserService;

import javax.validation.Valid;

@Controller
@AllArgsConstructor

public class RegistrationController {

    private final RegistrationService registrationService;

    private final UserService userService;

    @ModelAttribute("userDto")
    UserDto userDto(){
        return new UserDto();
    }

    @RequestMapping("/register")
    public String register(){
        return "/public/registration";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult result){
        try{
            registrationService.register(userDto);
        } catch(IllegalArgumentException e){
            FieldError fieldError = new FieldError("userDto", "email", e.getMessage());
            result.addError(fieldError);
        }

        if(result.hasErrors()){
            return "/public/registration";
        }

        return "redirect:/login";
    }

    @GetMapping(path = "/register/confirm")
    public String confirm(@RequestParam("token") String token, Model model) {
        registrationService.confirmToken(token);
        model.addAttribute("confirmationSuccess", true);
        return "/public/login";
    }

    @GetMapping("/create-admin")
    @ResponseBody
    public String createAdmin() {
        User user = new User();
        user.setPassword("admin");
        user.setEmail("admin@charity.pl");
        user.setEnabled(true);
        user.setUserRole(UserRole.ROLE_ADMIN);
        userService.signUpUser(user);
        return "Admin has been created<br>email:admin@charity.pl<br>password:admin";
    }
}
