package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Institution.Institution;
import pl.coderslab.charity.Institution.InstitutionRepository;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private InstitutionRepository institutionRepository;


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        model.addAttribute("institutions", institutionList);
        return "index";
    }
}
