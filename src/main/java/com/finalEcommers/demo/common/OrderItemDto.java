package com.finalEcommers.demo.common;

public class OrderItemDto {

    private int orderItemId;

    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    public ProductDto getProduct() {
        return Product;
    }

    public void setProduct(ProductDto product) {
        Product = product;
    }

    public double getTotaleproductprise() {
        return totaleproductprise;
    }

    public void setTotaleproductprise(double totaleproductprise) {
        this.totaleproductprise = totaleproductprise;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
    }

    private ProductDto Product;
    private double totaleproductprise;

    private OrderDto order;
}
