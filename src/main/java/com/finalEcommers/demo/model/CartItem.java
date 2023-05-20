package com.finalEcommers.demo.model;

import jakarta.persistence.*;

@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int CartItemId;
    private int Quantity;
    private double TotalPrize;


//    Relationship with other table
    @ManyToOne
    private Cart cart;


//    cartitem to one side map no map to product table
    @OneToOne
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }
    public void setCart(Cart cart) {
        cart = cart;
    }

    public int getCartItemId() {
        return CartItemId;
    }

    public void setCartItemId(int cartItemId) {
        CartItemId = cartItemId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public double getTotalPrize() {
        return TotalPrize;
    }

    public double setTotalPrize(double totalPrize) {
        TotalPrize = totalPrize;
        return totalPrize;
    }


}
