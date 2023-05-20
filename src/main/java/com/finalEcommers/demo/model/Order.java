package com.finalEcommers.demo.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;
    private String orderStatus;
    private String paymentstatus;
    private double orderAtm;
    private String billingAddres;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private Set<OrderItem> orderitem=new HashSet<>();
    private Date orderGreatAt;

    public Order() {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.paymentstatus = paymentstatus;
        this.orderAtm = orderAtm;
        this.billingAddres = billingAddres;
        this.orderDeliverd = orderDeliverd;
        this.user = user;
        this.orderitem = orderitem;
        this.orderGreatAt = orderGreatAt;
    }

    private Date orderDeliverd;

    public Date getOrderGreatAt() {
        return orderGreatAt;
    }

    public void setOrderGreatAt(Date orderGreatAt) {
        this.orderGreatAt = orderGreatAt;
    }







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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderItem> getOrderitem() {
        return orderitem;
    }

    public void setOrderitem(Set<OrderItem> orderitem) {
        this.orderitem = orderitem;
    }






}
