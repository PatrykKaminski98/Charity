package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/institutions")
@Secured("ROLE_ADMIN")
@AllArgsConstructor
public class InstitutionController {

    private final InstitutionRepository institutionRepository;

    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping("/list")
    public String listofInstitutions(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        model.addAttribute("institutions", institutionList);
        return "/institutions/list";
    }

    @GetMapping("/add")
    public String addInstitution(Model model){
        model.addAttribute("institution", new Institution());
        return "/institutions/add";
    }

    @PostMapping("/add")
    public String addInstitutionPost(@Valid Institution institution, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/institutions/add";
        }
        institutionRepository.save(institution);
        return "redirect:/institutions/list";
    }

    @GetMapping("/edit/{id}")
    public String editInstitution(Model model, @PathVariable long id){
        model.addAttribute("institution", institutionRepository.findById(id));
        return "/institutions/edit";
    }

    @PostMapping("/edit")
    public String editInstitutionPost(@Valid Institution institution, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/institutions/edit";
        }
        institutionRepository.save(institution);
        return "redirect:/institutions/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteInstitution(@PathVariable long id){
        institutionRepository.delete(institutionRepository.getById(id));
        return "redirect:/institutions/list";
    }
}
