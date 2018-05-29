package payment;

import model.AuthorizeRequest;
import model.CancelRequest;
import model.TransferRequest;
import model.VerifyUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import util.JsonConverter;
import util.WhiteListControl;

import javax.servlet.http.HttpServletRequest;

@Component
public class DummyOperatorPlatform {

    @Autowired
    private JsonConverter converter;

    @Autowired
    private PaymentHandler paymentHandler;

    @Autowired
    private WhiteListControl whiteListControl;

    public ResponseEntity<String> verifyUserResponse(VerifyUserRequest request, HttpServletRequest servletRequest) {
        return whiteListControl.isRequestAuthorized(servletRequest)
                ? responseEntityString(paymentHandler.verifyUser(request.getUserId()))
                : DummyResponseUtil.getClientNotAuthorizedResponse();
    }

    public ResponseEntity<String> authorize(AuthorizeRequest request, HttpServletRequest servletRequest) {
        return whiteListControl.isRequestAuthorized(servletRequest)
                ? responseEntityString(paymentHandler.authorizePayment(request))
                : DummyResponseUtil.getClientNotAuthorizedResponse();
    }

    public ResponseEntity<String> transferMoney(TransferRequest request, HttpServletRequest servletRequest) {
        return whiteListControl.isRequestAuthorized(servletRequest) ?
                responseEntityString(paymentHandler.transferResponse(request)) :
                DummyResponseUtil.getClientNotAuthorizedResponse();
    }

    public ResponseEntity<String> cancel(CancelRequest request, HttpServletRequest servletRequest) {
        return whiteListControl.isRequestAuthorized(servletRequest)
                ? responseEntityString(paymentHandler.cancel(request))
                : DummyResponseUtil.getClientNotAuthorizedResponse();
    }

    private ResponseEntity<String> responseEntityString(Object response) {
        return converter.createResponseEntity(response, HttpStatus.OK);
    }

}


