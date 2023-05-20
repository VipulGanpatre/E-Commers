package com.finalEcommers.demo.common;

import java.util.List;

public class OrderResponce {
    private int pagesize;
    private int pagenumber;
    private int totalepage;
   private long totalelement ;

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(int pagenumber) {
        this.pagenumber = pagenumber;
    }

    public int getTotalepage() {
        return totalepage;
    }

    public void setTotalepage(int totalepage) {
        this.totalepage = totalepage;
    }

    public long getTotalelement() {
        return totalelement;
    }

    public void setTotalelement(long totalelement) {
        this.totalelement = totalelement;
    }

    public List<OrderDto> getContent() {
        return content;
    }

    public void setContent(List<OrderDto> content) {
        this.content = content;
    }

    public boolean isIslastpage() {
        return islastpage;
    }

    public void setIslastpage(boolean islastpage) {
        this.islastpage = islastpage;
    }

    private List<OrderDto> content;
   private boolean islastpage;
}
