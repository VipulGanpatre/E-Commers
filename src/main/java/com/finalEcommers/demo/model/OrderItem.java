package com.finalEcommers.demo.model;

import jakarta.persistence.*;



@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    @OneToOne
    private Product product;
    private double totaleproductprise;
    @ManyToOne
    private Order order;
    private int productquentity;

    public OrderItem(int orderItemId, Product product, double totaleproductprise, Order order, int productquentity) {
        this.orderItemId = orderItemId;
        this.product = product;
        this.totaleproductprise = totaleproductprise;
        this.order = order;
        this.productquentity = productquentity;
    }

    public int getProductquentity() {
        return productquentity;
    }

    public void setProductquentity(int productquentity) {
        this.productquentity = productquentity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }




    public OrderItem() {

        super();
        this.orderItemId = orderItemId;

        this.totaleproductprise = totaleproductprise;
        this.order = order;
    }

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }



    public double getTotaleproductprise() {
        return totaleproductprise;
    }

    public void setTotaleproductprise(double totaleproductprise) {
        this.totaleproductprise = totaleproductprise;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }


}
