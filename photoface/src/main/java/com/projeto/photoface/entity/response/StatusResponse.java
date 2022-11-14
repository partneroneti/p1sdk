package com.projeto.photoface.entity.response;

public class StatusResponse {

    private String transactionId;
    private StatusReturn result;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public StatusReturn getResult() {
        return result;
    }

    public void setResult(StatusReturn result) {
        this.result = result;
    }



}
