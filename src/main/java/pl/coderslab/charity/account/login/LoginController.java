package pl.coderslab.charity.account.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        System.out.println("hallo");
        return "/public/login";
    }

}
