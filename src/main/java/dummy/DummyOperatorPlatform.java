package dummy;

import model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import util.JsonConverter;
import util.WhiteListControl;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class DummyOperatorPlatform {

    private Map<String, VerifyUserResponse> userList;
    private JsonConverter converter;

    public DummyOperatorPlatform() {
        converter = new JsonConverter();
        userList = new HashMap<>();
        userList.put("1", ImmutableVerifyUserResponse.builder()
                .userId("1")
                .success(true)
                .firstName("Gais")
                .lastName("Harch")
                .street("Evenemangsgatan 30")
                .city("Stockholm")
                .zip("16956")
                .country("Sweden")
                .email("gais@kth.se")
                .dob("1990-04-23")
                .mobile("+46700874629")
                .balance(1000000.00)
                .balanceCy("SEK")
                .kycStatus("Approved")
                .build());
    }


    public ResponseEntity<String> verifyUserResponseDummy(VerifyUserRequest request, HttpServletRequest servletRequest) {
        WhiteListControl control = new WhiteListControl(servletRequest);
        try {
            if (isCustomerVerified(request) && control.isRequestAuthorized()) {
                return new ResponseEntity<>(converter.serializeToJsonFormat(getDummyUser(request.getUserId())), HttpStatus.OK);
            } else {
                return getUnauthorizedResponse();
            }
        } catch (IOException e) {
            return getUnauthorizedResponse();
        }

    }

    public ResponseEntity<String> authorize(AuthorizeRequest request) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> transferMoney(TransferRequest request) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public ResponseEntity<String> cancel() {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

    public VerifyUserResponse getDummyUser(String userId) {
        if (userList.containsKey(userId)) {
            return userList.get(userId);
        } else {
            return getNoUserFound();
        }

    }

    private ImmutableVerifyUserResponse getNoUserFound() {
        return ImmutableVerifyUserResponse.builder()
                .userId("0")
                .success(true)
                .firstName("")
                .lastName("")
                .street("")
                .city("")
                .zip("")
                .country("")
                .email("")
                .dob("")
                .mobile("")
                .balance(0.00)
                .balanceCy("")
                .build();
    }

    private ResponseEntity<String> getUnauthorizedResponse() {
        StatusObject statusObject = new StatusObject();
        statusObject.setCode(HttpStatus.UNAUTHORIZED.value());
        statusObject.setMessage(HttpStatus.UNAUTHORIZED.name());
        return new ResponseEntity<>(converter.serializeToJsonFormat(statusObject), HttpStatus.UNAUTHORIZED);
    }

    private boolean isCustomerVerified(VerifyUserRequest request) {
        return request.getUserId().equalsIgnoreCase("1");
    }


}


