package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CancelRequest {
    private final String userId;
    private final String authCode;
    private final String txAmount;
    private final String txAmountCy;
    private final String txId;
    private final Number txTypeId;
    private final String txName;
    private final String provider;
    private final String originTxId;
    private final UUID accountId;
    private final String maskedAccount;
    private final String statusCode;
    private final String pspStatusCode;
    private final String pspFee;
    private final String pspFeeCy;
    private final String pspFeeBase;
    private final String pspFeeBaseCy;
    private final String pspRefId;
    private final String pspStatusMessage;
    private final Object attributes;

    public CancelRequest(@JsonProperty("userId") String userId,
                         @JsonProperty("authCode") String authCode,
                         @JsonProperty("txAmount") String txAmount,
                         @JsonProperty("txAmountCy") String txAmountCy,
                         @JsonProperty("txId") String txId,
                         @JsonProperty("txTypeId") Number txTypeId,
                         @JsonProperty("txName") String txName,
                         @JsonProperty("provider") String provider,
                         @JsonProperty("originTxId") String originTxId,
                         @JsonProperty("accountId") UUID accountId,
                         @JsonProperty("maskedAccount") String maskedAccount,
                         @JsonProperty("statusCode") String statusCode,
                         @JsonProperty("pspStatusCode") String pspStatusCode,
                         @JsonProperty("pspFee") String pspFee,
                         @JsonProperty("pspFeeCy") String pspFeeCy,
                         @JsonProperty("pspFeeBase") String pspFeeBase,
                         @JsonProperty("pspFeeBaseCy") String pspFeeBaseCy,
                         @JsonProperty("pspRefId") String pspRefId,
                         @JsonProperty("pspStatusMessage") String pspStatusMessage,
                         @JsonProperty("attributes") Object attributes) {
        this.userId = userId;
        this.authCode = authCode;
        this.txAmount = txAmount;
        this.txAmountCy = txAmountCy;
        this.txId = txId;
        this.txTypeId = txTypeId;
        this.txName = txName;
        this.provider = provider;
        this.originTxId = originTxId;
        this.accountId = accountId;
        this.maskedAccount = maskedAccount;
        this.statusCode = statusCode;
        this.pspStatusCode = pspStatusCode;
        this.pspFee = pspFee;
        this.pspFeeCy = pspFeeCy;
        this.pspFeeBase = pspFeeBase;
        this.pspFeeBaseCy = pspFeeBaseCy;
        this.pspRefId = pspRefId;
        this.pspStatusMessage = pspStatusMessage;
        this.attributes = attributes;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthCode() {
        return authCode;
    }

    public String getTxAmount() {
        return txAmount;
    }

    public String getTxAmountCy() {
        return txAmountCy;
    }

    public String getTxId() {
        return txId;
    }

    public Number getTxTypeId() {
        return txTypeId;
    }

    public String getTxName() {
        return txName;
    }

    public String getProvider() {
        return provider;
    }

    public String getOriginTxId() {
        return originTxId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getMaskedAccount() {
        return maskedAccount;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public String getPspStatusCode() {
        return pspStatusCode;
    }

    public String getPspFee() {
        return pspFee;
    }

    public String getPspFeeCy() {
        return pspFeeCy;
    }

    public String getPspFeeBase() {
        return pspFeeBase;
    }

    public String getPspFeeBaseCy() {
        return pspFeeBaseCy;
    }

    public String getPspRefId() {
        return pspRefId;
    }

    public String getPspStatusMessage() {
        return pspStatusMessage;
    }

    public Object getAttributes() {
        return attributes;
    }
}
