package com.finalEcommers.demo.services;

import com.finalEcommers.demo.common.OrderDto;
import com.finalEcommers.demo.common.OrderRequest;
import com.finalEcommers.demo.common.OrderResponce;
import com.finalEcommers.demo.common.UserDto;
import com.finalEcommers.demo.exception.ResourceNotFoundExceptin;
import com.finalEcommers.demo.model.*;
import com.finalEcommers.demo.repository.CartRepo;
import com.finalEcommers.demo.repository.OrderRepo;
import com.finalEcommers.demo.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class OrderServices {
    @Autowired
     private CartRepo crepo;
    @Autowired
   private UserRepo urepo;
    @Autowired
    private OrderRepo Orepo;
    @Autowired
    ModelMapper mapper;
//    order create Method
     public OrderDto orderCreate(OrderRequest Request, String username){
         User user=this.urepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundExceptin("usernot found"));
                  int Cartid=Request.getCartid();
                  String orderAddress= Request.getOrderSdress();;
//             find cart
                 Cart cart= this.crepo.findById(Cartid).orElseThrow(()->new ResourceNotFoundExceptin("usernot found"));
//     getting cartitem
                 Set<CartItem> Item=cart.getItems();
                 Order order=new Order();
         AtomicReference<Double>totaleorderprise=new AtomicReference<Double>(0.0);
                Set<OrderItem>orderitems= Item.stream().map((CartItem)->{
                     OrderItem orderItem=new OrderItem();

//                     set cartitem into OrderItem
                     orderItem.setProduct(orderItem.getProduct());

//                     set cartitem into OrderItem
                     orderItem.setProductquentity(orderItem.getProductquentity());
                     orderItem.setTotaleproductprise(CartItem.getTotalPrize());
                     orderItem.setOrder(order);
                     totaleorderprise.set(totaleorderprise.get()+orderItem.getTotaleproductprise());
                     int productid=orderItem.getProduct().getId();
                     return orderItem;

                 }).collect(Collectors.toSet());

                 order.setBillingAddres(orderAddress);
                 order.setOrderDeliverd(null);
                 order.setOrderStatus("created");
                 order.setPaymentstatus("Not paid");
                 order.setUser(user);
                 order.setOrderitem(orderitems);
                 order.setOrderAtm(totaleorderprise.get());
                 order.setOrderGreatAt(new Date());
                 Order save;
                if(order.getOrderAtm()<0){
                    save=this.Orepo.save(order);
                    cart.getItems().clear();
                 this.crepo.save(cart);
                }else{
                    throw new ResourceNotFoundExceptin("add cart");
                }

         return this.mapper.map(save,OrderDto.class);
     }
      public void CancledOrder(int orderid){
        Order order=this.Orepo.findById(orderid).orElseThrow(()->new ResourceNotFoundExceptin("order not found"));
        this.Orepo.delete(order);
      }
      public OrderDto findbyid(int orderid){
          Order order=this.Orepo.findById(orderid).orElseThrow(()->new ResourceNotFoundExceptin("order not found"));
         return this.mapper.map(order,OrderDto.class);
      }
//      find all product by page (paginations)
    public OrderResponce findallorder(int pagenumber, int pagesize){
        Pageable pageable=PageRequest.of(pagenumber,pagesize);
                Page<Order> findall=this.Orepo.findAll(pageable);
                List<Order> content=findall.getContent();
//                change order to orderdto
          List<OrderDto>collect= content.stream().map((each)->this.mapper.map(each,OrderDto.class)).collect(Collectors.toList());
          OrderResponce responce=new OrderResponce();
          responce.setContent(collect);
          responce.setPagenumber(findall.getNumber());
          responce.setPagesize(findall.getSize());
          responce.setIslastpage(findall.isLast());
          responce.setTotalelement(findall.getTotalElements());
          responce.setTotalepage(findall.getTotalPages());


          return responce;

    }

}
