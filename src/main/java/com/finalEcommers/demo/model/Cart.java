package com.finalEcommers.demo.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int Cartid;

    //    Relationship with other table
    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL)
    private Set<CartItem> items =new HashSet<> ();
    @OneToOne
    private User user;

    public Cart(int cartid, Set<CartItem> items) {
        Cartid = cartid;
        this.items = items;
    }

    public Cart() {
        super();
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public void setItems(Set<CartItem> items) {
        this.items = items;
    }

    //    Getter ANd Setter
    public int getCartid() {
        return Cartid;
    }

    public Cart(int cartid) {
        Cartid = cartid;
    }

    public void setCartid(int cartid) {
        Cartid = cartid;
    }

}
