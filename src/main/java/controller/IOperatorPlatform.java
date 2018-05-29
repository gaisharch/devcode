package controller;

import model.AuthorizeRequest;
import model.CancelRequest;
import model.TransferRequest;
import model.VerifyUserRequest;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface IOperatorPlatform {
    ResponseEntity<String> verifyUser(VerifyUserRequest request, HttpServletRequest servletRequest);

    ResponseEntity<String> authorize(AuthorizeRequest request, HttpServletRequest servletRequest);

    ResponseEntity<String> transfer(TransferRequest request, HttpServletRequest servletRequest);

    ResponseEntity<String> cancel(CancelRequest request, HttpServletRequest servletRequest);
}
