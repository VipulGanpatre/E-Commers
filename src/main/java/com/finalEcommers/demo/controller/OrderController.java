package com.finalEcommers.demo.controller;

import com.finalEcommers.demo.common.ApiResponse;
import com.finalEcommers.demo.common.OrderDto;
import com.finalEcommers.demo.common.OrderRequest;
import com.finalEcommers.demo.common.OrderResponce;
import com.finalEcommers.demo.model.Order;
import com.finalEcommers.demo.services.OrderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderServices oservices;

@PostMapping("/")
    public ResponseEntity<OrderDto> createorder(@RequestBody OrderRequest ordreq, Principal p){
        String username=p.getName();
       OrderDto order= this.oservices.orderCreate(ordreq,username);
        return new ResponseEntity<OrderDto>(order, HttpStatus.CREATED);

    }
    @DeleteMapping("/{orderid}")
    public ResponseEntity<?> deleteorder(@PathVariable int orderid){
      this.oservices.CancledOrder(orderid);
      return new ResponseEntity<ApiResponse>(new ApiResponse("order deleted",true),HttpStatus.OK);
    }
    @GetMapping("orderid")
    public ResponseEntity<OrderDto> findbyid(@PathVariable int orderid){
        OrderDto order=this.oservices.findbyid(orderid);
        return new ResponseEntity<OrderDto>(order,HttpStatus.ACCEPTED);

    }
    @GetMapping("/findall")
    public OrderResponce findallorder(@RequestParam(defaultValue = "2",value="pagesize") int pagesize,
                                      @RequestParam(defaultValue = "0",value = "pagenuber") int pagenuber){
    return this.oservices.findallorder(pagenuber,pagesize);

    }
}
