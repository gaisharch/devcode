package model;


public class ClientNotAuthorizedResponse {
    private int code;
    private String erroMsg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErroMsg() {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
    }
}
