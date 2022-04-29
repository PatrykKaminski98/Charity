package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Institution.Institution;
import pl.coderslab.charity.Institution.InstitutionRepository;
import pl.coderslab.charity.donation.DonationRepository;

import java.util.List;


@Controller
@AllArgsConstructor
public class HomeController {

    private InstitutionRepository institutionRepository;
    private DonationRepository donationRepository;


    @RequestMapping("/")
    public String homeAction(Model model){
        List<Institution> institutionList = institutionRepository.findAll();
        int quantitySum = donationRepository.quantitySumQuery();
        model.addAttribute("institutions", institutionList);
        model.addAttribute("quantity", quantitySum);
        return "index";
    }
}
