package payment;

import model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import util.JsonConverter;

public class DummyResponseUtil {

    static VerifyUserResponse getUserNotFoundResponse() {
        return ImmutableVerifyUserResponse.builder()
                .userId("")
                .success(false)
                .firstName("")
                .lastName("")
                .street("")
                .city("")
                .zip("")
                .country("")
                .email("")
                .dob("")
                .mobile("")
                .balance(0)
                .balanceCy("")
                .errCode(404)
                .errMsg("USER NOT FOUND")
                .build();
    }

    static ResponseEntity<String> getClientNotAuthorizedResponse() {
        JsonConverter converter = new JsonConverter();
        ClientNotAuthorizedResponse  notAuthorized = new ClientNotAuthorizedResponse();
        notAuthorized.setCode(HttpStatus.UNAUTHORIZED.value());
        notAuthorized.setErroMsg(HttpStatus.UNAUTHORIZED.name());
        return converter.createResponseEntity(notAuthorized,HttpStatus.UNAUTHORIZED);
    }

    static VerifyUserResponse CreateVerifyUserResponse(DevCodeUserCustomer customer) {
        return ImmutableVerifyUserResponse.builder()
                .userId(customer.getUserId())
                .success(customer.isSuccess())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .street(customer.getStreet())
                .city(customer.getCity())
                .zip(customer.getZip())
                .country(customer.getCountry())
                .email(customer.getEmail())
                .dob(customer.getDob())
                .mobile(customer.getMobile())
                .balance(customer.getBalance())
                .balanceCy(customer.getBalanceCy())
                .build();
    }

     static AuthorizedResponse getCustomerAuthorizedResponse(AuthorizeRequest request) {
        return ImmutableAuthorizedResponse.builder().
                userId(request.getUserId()).success(true).
                merchantTxId("123123123123").
                authCode("550e8400-e29b-41d4-a716-446655440000").build();
    }

     static AuthorizedResponse getCustomerNotAuthorized(AuthorizeRequest request) {
        return ImmutableAuthorizedResponse.builder().
                userId(request.getUserId()).success(false).
                merchantTxId("0").
                authCode("0").errCode(403).errMsg("Account not valid").build();
    }

     static TransferResponse getFailedTransferResponse(TransferRequest request) {
        return ImmutableTransferResponse.builder()
                .userId(request.getUserId())
                .success(false).txId("111111111")
                .merchantTxId("11111")
                .errCode(403)
                .errMsg("Transaction failed").build();
    }

     static TransferResponse getTransferResponse(TransferRequest request) {
        return ImmutableTransferResponse.builder()
                .userId(request.getUserId())
                .success(true)
                .txId("111111111")
                .merchantTxId("11111").build();
    }

     static CancelResponse getFailedCancelResponse(CancelRequest request) {
        return ImmutableCancelResponse.builder().userId(request.getUserId()).success(false).errCode(403).errMsg("Cancel request failed").build();
    }
     static CancelResponse getCancelResponse(CancelRequest request) {
        return ImmutableCancelResponse.builder().userId(request.getUserId()).success(true).build();
    }


}
