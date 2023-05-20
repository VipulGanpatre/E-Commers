package com.finalEcommers.demo.common;

import com.finalEcommers.demo.model.Cart;
import com.finalEcommers.demo.model.Product;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class CartItemDto {
    private int CartItemId;
    private int Quantity;

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

    public void setTotalPrize(double totalPrize) {
        TotalPrize = totalPrize;
    }

    public CartDto getCartDto() {
        return cartDto;
    }

    public void setCartDto(CartDto cartDto) {
        this.cartDto = cartDto;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    private double TotalPrize;
    private CartDto cartDto;
    private ProductDto productDto;
}
