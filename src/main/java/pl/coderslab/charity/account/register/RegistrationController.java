package pl.coderslab.charity.account.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

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
}
