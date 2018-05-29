package model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;


public class TransferRequest {

    private final String userId;
    private final String authCode;
    private final String txAmount;
    private final String txAmountCy;
    private final String txPspAmount;
    private final String txPspAmountCy;
    private final String fee;
    private final String feeCy;
    private final String feeMode;
    private final String txId;
    private final Number txTypeId;
    private final String txName;
    private final String provider;
    private final String pspService;
    private final String txRefId;
    private final String originTxId;
    private final UUID maskedAccount;
    private final String pspFee;
    private final String pspFeeCy;
    private final String pspFeeBase;
    private final String pspFeeBaseCy;
    private final String pspRefId;
    private final String pspStatusMessage;
    private final Object attributes;

    @JsonCreator
    public TransferRequest(@JsonProperty("userId") String userId,
                           @JsonProperty("authCode") String authCode,
                           @JsonProperty("txAmount") String txAmount,
                           @JsonProperty("txAmountCy") String txAmountCy,
                           @JsonProperty("txPspAmount") String txPspAmount,
                           @JsonProperty("txPspAmountCy") String txPspAmountCy,
                           @JsonProperty("fee") String fee,
                           @JsonProperty("feeCy") String feeCy,
                           @JsonProperty("feeMode") String feeMode,
                           @JsonProperty("txId") String txId,
                           @JsonProperty("txTypeId") Number txTypeId,
                           @JsonProperty("txName") String txName,
                           @JsonProperty("provider") String provider,
                           @JsonProperty("pspService") String pspService,
                           @JsonProperty("txRefId") String txRefId,
                           @JsonProperty("originTxId") String originTxId,
                           @JsonProperty("maskedAccount") UUID maskedAccount,
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
        this.txPspAmount = txPspAmount;
        this.txPspAmountCy = txPspAmountCy;
        this.fee = fee;
        this.feeCy = feeCy;
        this.feeMode = feeMode;
        this.txId = txId;
        this.txTypeId = txTypeId;
        this.txName = txName;
        this.provider = provider;
        this.pspService = pspService;
        this.txRefId = txRefId;
        this.originTxId = originTxId;
        this.maskedAccount = maskedAccount;
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

    public String getTxPspAmount() {
        return txPspAmount;
    }

    public String getTxPspAmountCy() {
        return txPspAmountCy;
    }

    public String getFee() {
        return fee;
    }

    public String getFeeCy() {
        return feeCy;
    }

    public String getFeeMode() {
        return feeMode;
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

    public String getPspService() {
        return pspService;
    }

    public String getTxRefId() {
        return txRefId;
    }

    public String getOriginTxId() {
        return originTxId;
    }

    public UUID getMaskedAccount() {
        return maskedAccount;
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
