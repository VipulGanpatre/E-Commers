package com.finalEcommers.demo.common;

public class ApiResponse {
    private String massage;
    private boolean  sucess;

    public ApiResponse(String massage, boolean sucess) {
        super();
        this.massage = massage;
        this.sucess = sucess;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public boolean isSucess() {
        return sucess;
    }

    public void setSucess(boolean sucess) {
        this.sucess = sucess;
    }

    public ApiResponse() {
   super();
    }


}
