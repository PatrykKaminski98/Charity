package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.category.Category;
import pl.coderslab.charity.category.CategoryRepository;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;

import java.util.List;

@Controller
@RequestMapping("/donation")
@AllArgsConstructor
public class DonationController {

    private final InstitutionRepository institutionRepository;
    private final CategoryRepository categoryRepository;

    private final DonationRepository donationRepository;

    @ModelAttribute("institutions")
    List<Institution> getAllInstitutions(){
        return institutionRepository.findAll();
    }
    @ModelAttribute("categories")
    List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
    @GetMapping("/form")
    public String formGet(Model model){
        model.addAttribute("donation", new Donation());
        return "/donation/form";
    }

    @PostMapping("/form")
    public String formPost(Donation donation){
        donationRepository.save(donation);
        return "/donation/form-confirmation";
    }
}
