package com.finalEcommers.demo.common;

import com.finalEcommers.demo.model.CartItem;
import com.finalEcommers.demo.model.User;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.HashSet;
import java.util.Set;

public class CartDto {
    private  int Cartid;

    public int getCartid() {
        return Cartid;
    }

    public void setCartid(int cartid) {
        Cartid = cartid;
    }

    public Set<CartItemDto> getItems() {
        return items;
    }

    public void setItems(Set<CartItemDto> items) {
        this.items = items;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    private Set<CartItemDto> items =new HashSet<>();

    private UserDto user;
}
