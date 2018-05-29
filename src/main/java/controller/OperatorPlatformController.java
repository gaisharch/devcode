package controller;

import model.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import payment.DummyOperatorPlatform;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OperatorPlatformController implements IOperatorPlatform {

    private DummyOperatorPlatform operatorPlatform;

    public OperatorPlatformController() {
       operatorPlatform = new DummyOperatorPlatform();
    }

    @RequestMapping(value = "/api/verifyuser", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> verifyUser(@RequestBody VerifyUserRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.verifyUserResponse(request, servletRequest);
    }

    @RequestMapping(value = "/api/authorize", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> authorize(@RequestBody AuthorizeRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.authorize(request, servletRequest);
    }

    @RequestMapping(value = "/api/transfer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> transfer(@RequestBody TransferRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.transferMoney(request, servletRequest);
    }

    @RequestMapping(value = "/api/cancel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> cancel(@RequestBody CancelRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.cancel(request, servletRequest);
    }

    @RequestMapping("/customer")
    public String greeting(Model model) {
        DevCodeUserCustomer user = operatorPlatform.getCustomerByUserId("1");
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("Street", user.getStreet());
        model.addAttribute("city", user.getCity());
        model.addAttribute("country", user.getCountry());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("dob", user.getDob());
        model.addAttribute("balance", user.getBalance());
        return model.toString();
    }
}
