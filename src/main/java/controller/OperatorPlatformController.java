package controller;

import model.AuthorizeRequest;
import model.CancelRequest;
import model.TransferRequest;
import model.VerifyUserRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
    public ResponseEntity<String> authorize(AuthorizeRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.authorize(request, servletRequest);
    }

    @RequestMapping(value = "/api/transfer", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> transfer(TransferRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.transferMoney(request, servletRequest);
    }

    @RequestMapping(value = "/api/cancel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> cancel(CancelRequest request, HttpServletRequest servletRequest) {
        return operatorPlatform.cancel(request, servletRequest);
    }
}
