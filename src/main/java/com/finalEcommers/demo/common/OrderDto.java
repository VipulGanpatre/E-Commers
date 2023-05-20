package com.finalEcommers.demo.common;

import com.finalEcommers.demo.model.OrderItem;
import com.finalEcommers.demo.model.User;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderDto {

    private @Nonnull int orderId;
    private Date orderDeliverd;
    private @Nonnull double orderAtm;
    private String billingAddres;

    private UserDto User;

    private Set<OrderItemDto> orderitem=new HashSet<>();

    private String orderStatus;
    private String paymentstatus;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentstatus() {
        return paymentstatus;
    }

    public void setPaymentstatus(String paymentstatus) {
        this.paymentstatus = paymentstatus;
    }

    public Date getOrderDeliverd() {
        return orderDeliverd;
    }

    public void setOrderDeliverd(Date orderDeliverd) {
        this.orderDeliverd = orderDeliverd;
    }

    public double getOrderAtm() {
        return orderAtm;
    }

    public void setOrderAtm(double orderAtm) {
        this.orderAtm = orderAtm;
    }

    public String getBillingAddres() {
        return billingAddres;
    }

    public void setBillingAddres(String billingAddres) {
        this.billingAddres = billingAddres;
    }

    public UserDto getUser() {
        return User;
    }

    public void setUser(UserDto user) {
        User = user;
    }

    public Set<OrderItemDto> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Set<OrderItemDto> orderitem) {
        this.orderitem = orderitem;
    }


}
