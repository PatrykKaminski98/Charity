package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.institution.Institution;
import pl.coderslab.charity.institution.InstitutionRepository;
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
        long quantityOfBags = donationRepository.quantityOfBagsQuery();
        long quantityOfDonations = donationRepository.count();
        model.addAttribute("institutions", institutionList);
        model.addAttribute("quantityOfBags", quantityOfBags);
        model.addAttribute("quantityOfDonations", quantityOfDonations);
        return "index";
    }
}
