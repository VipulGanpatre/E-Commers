package com.finalEcommers.demo.common;

public class ItemRequest {
    private  int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ItemRequest(int productId, int quentity) {
        this.productId = productId;
        this.quentity = quentity;
    }

    public int getQuentity() {
        return quentity;
    }

    public void setQuentity(int quentity) {
        this.quentity = quentity;
    }

    private int quentity;
}
