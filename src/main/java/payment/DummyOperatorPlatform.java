package payment;

import model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import util.JsonConverter;
import util.WhiteListControl;

import javax.servlet.http.HttpServletRequest;

public class DummyOperatorPlatform {

    private JsonConverter converter;

    private PaymentHandler paymentHandler;

    private WhiteListControl whiteListControl;

    public DummyOperatorPlatform() {
        converter = new JsonConverter();
        paymentHandler = new PaymentHandler();
        whiteListControl = new WhiteListControl();
    }

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

    public DevCodeUserCustomer getCustomerByUserId(String userId) {
        return paymentHandler.getCustomerByUserId(userId);
    }

    private ResponseEntity<String> responseEntityString(Object response) {
        return converter.createResponseEntity(response, HttpStatus.OK);
    }

}


