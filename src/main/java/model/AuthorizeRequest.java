package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class AuthorizeRequest {
    private String userId;
    private String txAmount;
    private String txAmountCy;
    private String txId;
    private Number txTypeId;
    private String txName;
    private String provider;
    private String pspService;
    private String originTxId;
    private UUID accountId;
    private String accountHolder;
    private String maskedAccount;
    private String pspFee;
    private String pspFeeCy;
    private String pspFeeBase;
    private String pspFeeBaseCy;
    private Object attributes;

    public AuthorizeRequest(@JsonProperty("userId")String userId,
                            @JsonProperty("txAmount")String txAmount,
                            @JsonProperty("txAmountCy")String txAmountCy,
                            @JsonProperty("txId")String txId,
                            @JsonProperty("txTypeId")Number txTypeId,
                            @JsonProperty("txName")String txName,
                            @JsonProperty("provider")String provider,
                            @JsonProperty("pspService")String pspService,
                            @JsonProperty("originTxId")String originTxId,
                            @JsonProperty("accountId")UUID accountId,
                            @JsonProperty("accountHolder")String accountHolder,
                            @JsonProperty("maskedAccount")String maskedAccount,
                            @JsonProperty("pspFee")String pspFee,
                            @JsonProperty("pspFeeCy")String pspFeeCy,
                            @JsonProperty("pspFeeBase")String pspFeeBase,
                            @JsonProperty("pspFeeBaseCy")String pspFeeBaseCy,
                            @JsonProperty("attributes")Object attributes) {
        this.userId = userId;
        this.txAmount = txAmount;
        this.txAmountCy = txAmountCy;
        this.txId = txId;
        this.txTypeId = txTypeId;
        this.txName = txName;
        this.provider = provider;
        this.pspService = pspService;
        this.originTxId = originTxId;
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.maskedAccount = maskedAccount;
        this.pspFee = pspFee;
        this.pspFeeCy = pspFeeCy;
        this.pspFeeBase = pspFeeBase;
        this.pspFeeBaseCy = pspFeeBaseCy;
        this.attributes = attributes;
    }

    public String getUserId() {
        return userId;
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

    public String getPspService() {
        return pspService;
    }

    public String getOriginTxId() {
        return originTxId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public String getMaskedAccount() {
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

    public Object getAttributes() {
        return attributes;
    }
}
