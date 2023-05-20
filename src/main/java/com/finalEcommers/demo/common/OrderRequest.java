package com.finalEcommers.demo.common;

public class OrderRequest {
    private String OrderSdress;
    private int Cartid;

    public String getOrderSdress() {
        return OrderSdress;
    }

    public void setOrderSdress(String orderSdress) {
        OrderSdress = orderSdress;
    }

    public int getCartid() {
        return Cartid;
    }

    public void setCartid(int cartid) {
        Cartid = cartid;
    }
}
