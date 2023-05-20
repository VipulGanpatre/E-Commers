package com.finalEcommers.demo.services;

import com.finalEcommers.demo.common.CartDto;
import com.finalEcommers.demo.common.ItemRequest;
import com.finalEcommers.demo.exception.ResourceNotFoundExceptin;
import com.finalEcommers.demo.model.Cart;
import com.finalEcommers.demo.model.CartItem;
import com.finalEcommers.demo.model.Product;
import com.finalEcommers.demo.model.User;
import com.finalEcommers.demo.repository.CartRepo;
import com.finalEcommers.demo.repository.ProductRepo;
import com.finalEcommers.demo.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
public class CartServices {
    @Autowired
    CartRepo cartRepo;
    @Autowired
    ModelMapper mapper;
    @Autowired
    UserRepo Urepo;
    @Autowired
    ProductRepo prepo;
    public CartDto additme(ItemRequest item,String Username){
      int productid=  item.getProductId();
      int quentity=  item.getQuentity();
//      fetch user
       User user= this.Urepo.findByEmail(Username).orElseThrow(()->new ResourceNotFoundExceptin("user not found Exception"));
//        fetch Product
       Product Product =  this.prepo.findById(productid).orElseThrow(()->new ResourceNotFoundExceptin(" product not found Exception"));
//       here check stick is present or not
        if (!Product.isStock()) {
       new ResourceNotFoundExceptin("Product out of Stocks");
         }
//         create cartitem with Product id Quentity
               CartItem cartItem=new CartItem();

              cartItem.setProduct(Product);
              cartItem.setQuantity(quentity);
              double totaleprize=Product.getProductPrize()*quentity;
              cartItem.setTotalPrize(totaleprize);
//              getting carditem
      Cart cart=  user.getCart();
        if(cart==null){
            Cart cart1=new Cart();
        }
        cartItem.setCart(cart);
        Set<CartItem> Item=cart.getItems();
//        here we check itms is avaliable in cartitem or not
//        then cartitem is avaliable then we increse the quentity else add new product in cartitems
//        bythe fault false asel boolen value
        AtomicReference<Boolean>flag=new AtomicReference();
        Set<CartItem>newProduct=Item.stream().map((i)->{
            if(i.getProduct().getId()==Product.getId()){
                i.setQuantity(quentity);
                i.setTotalPrize(totaleprize);
                flag.set(true);

            }
            return i;
        }).collect(Collectors.toSet());
         if(flag.get()){
         Item.clear();
         Item.addAll(newProduct);
         }
         else {
             cartItem.setCart(cart);
//             Item.addAll(cartItem);
         }
         Cart saveCart=this.cartRepo.save(cart);
         return this.mapper.map(saveCart,CartDto.class);

           }

    public CartDto getcartAll(String email){
        //find user
        User user = this.Urepo.findByEmail(email).orElseThrow(()->new ResourceNotFoundExceptin("User Not Found"));
        //find cart
        Object cart= this.cartRepo.findByUser(user).orElseThrow(()->new ResourceNotFoundExceptin("There is no cart"));

        return this.mapper.map(cart,CartDto.class);

    }
    public CartDto getCartByid(int cartid){
//       User user= this.Urepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundExceptin("There is no cart"));
       Object findbyid= this.cartRepo.findById(cartid).orElseThrow(()->new ResourceNotFoundExceptin("There is no cart"));
       return this.mapper.map(findbyid,CartDto.class);
    }
    public CartDto removecartitem(String username,int productid){
            User user= this.Urepo.findByEmail(username).orElseThrow(()->new ResourceNotFoundExceptin("There is no cart"));
            Cart cart=user.getCart();
            Set <CartItem>Items=cart.getItems();
            boolean removeif=Items.removeIf((i)->i.getProduct().getId()==productid);
            Cart save=this.cartRepo.save(cart);
        return this.mapper.map(save,CartDto.class);
    }




}
