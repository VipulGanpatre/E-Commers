package com.finalEcommers.demo.common;

import com.finalEcommers.demo.model.Product;

import java.util.List;

public class ProductResponce {
    private List<ProductDto> content;
    private int pageNumber;
    private int pageSize;

    public List<ProductDto> getContent() {
        return content;
    }

    public void setContent(List<ProductDto> content) {
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public boolean isLastpage() {
        return lastpage;
    }

    public void setLastpage(boolean lastpage) {
        this.lastpage = lastpage;
    }

    private int totalpage;
    private boolean lastpage;
}
