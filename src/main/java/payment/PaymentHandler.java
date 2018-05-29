package payment;

import model.*;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentHandler {
    private Map<String, DevCodeUserCustomer> customerList;
    private Map<String, Number> reservedAmountHolder;

    public PaymentHandler() {
        initList();
    }

    private void initList() {
        customerList = new HashMap<>();
        reservedAmountHolder = new HashMap<>();
        DevCodeUserCustomer customer = Customer.create();
        customerList.put(customer.getUserId(), customer);
    }

    public DevCodeUserCustomer getCustomerByUserId(String userId) {
        return customerList.get(userId);
    }


    public VerifyUserResponse verifyUser(String userId) {
            DevCodeUserCustomer customer = getCustomerByUserId(userId);
            if (customer != null) {
                return DummyResponseUtil.CreateVerifyUserResponse(customer);
            } else {
                return DummyResponseUtil.getUserNotFoundResponse();
            }
    }

    public AuthorizedResponse authorizePayment(AuthorizeRequest request) {
        DevCodeUserCustomer customer = getCustomerByUserId(request.getUserId());
        if (customer != null) {
            reserveCustomerAuthorizedPaymentAmount(request);
            return DummyResponseUtil.getCustomerAuthorizedResponse(request);
        }
        return DummyResponseUtil.getCustomerNotAuthorized(request);
    }


    private void reserveCustomerAuthorizedPaymentAmount(AuthorizeRequest request) {
        DevCodeUserCustomer customer = customerList.get(request.getUserId());
        double newUserBalance = customer.getBalance().doubleValue();
        newUserBalance += getAuthorizedTransactionAmount(request).doubleValue();
        reservedAmountHolder.put(request.getTxId(), newUserBalance);
    }

    private Number getAuthorizedMoneyTransfer(String txId) {
        return reservedAmountHolder.get(txId);
    }

    private boolean transferMoneyToUser(TransferRequest request) {
        DevCodeUserCustomer user = customerList.get(request.getUserId());
        if (user != null) {
            Number amount = getAuthorizedMoneyTransfer(request.getTxId());
            if (amount != null) {
                updateUserBalance(amount.doubleValue(), user);
                return true;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }


    public TransferResponse transferResponse(TransferRequest request) {
        if (transferMoneyToUser(request)) {
            return DummyResponseUtil.getTransferResponse(request);
        }else{
            return DummyResponseUtil.getFailedTransferResponse(request);
        }
    }

    private void updateUserBalance(double txAmount, DevCodeUserCustomer user) {
        customerList.replace(user.getUserId(), addNewUserBalance(txAmount, user));
    }

    private DevCodeUserCustomer addNewUserBalance(double txAmount, DevCodeUserCustomer user) {
        double balance = user.getBalance().doubleValue();
        balance += txAmount;
        user.setBalance(balance);
        return user;
    }

    private Number getAuthorizedTransactionAmount(AuthorizeRequest request) {
        String txAmount = request.getTxAmount();
        return Double.parseDouble(txAmount);
    }

    public CancelResponse cancel(CancelRequest request) {
        DevCodeUserCustomer customer = customerList.get(request.getUserId());
        if (customer != null) {
            cancelTransaction(request, customer);
            return DummyResponseUtil.getCancelResponse(request);
        } else {
            return DummyResponseUtil.getFailedCancelResponse(request);
        }
    }

    private void cancelTransaction(CancelRequest request, DevCodeUserCustomer user) {
        Number cancelAmount = reservedAmountHolder.get(request.getTxId());
        user.setBalance(cancelAmount);
        customerList.replace(request.getUserId(), user);
    }
}
