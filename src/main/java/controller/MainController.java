package controller;


import payment.PaymentHandler;
import model.DevCodeUserCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @GetMapping("/index")
    public String greeting(Model model) {
        setUser(model);
        return "index";
    }

    private void setUser(Model model) {
        PaymentHandler op = new PaymentHandler();
        DevCodeUserCustomer user = op.getCustomerByUserId("1");
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("Street", user.getStreet());
        model.addAttribute("city", user.getCity());
        model.addAttribute("country", user.getCountry());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("dob", user.getDob());
        model.addAttribute("balance", user.getBalance());
        
    }

}
