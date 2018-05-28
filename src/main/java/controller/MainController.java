package controller;


import dummy.DummyOperatorPlatform;
import model.VerifyUserResponse;
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
        DummyOperatorPlatform op = new DummyOperatorPlatform();
        VerifyUserResponse user = op.getDummyUser("1");
        model.addAttribute("firstName", user.firstName());
        model.addAttribute("lastName", user.lastName());
        model.addAttribute("Street", user.street());
        model.addAttribute("city", user.city());
        model.addAttribute("country", user.country());
        model.addAttribute("email", user.email());
        model.addAttribute("dob", user.dob());
        model.addAttribute("balance", user.balance());
    }

}
