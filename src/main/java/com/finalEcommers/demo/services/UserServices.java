package com.finalEcommers.demo.services;

import com.finalEcommers.demo.common.UserDto;
import com.finalEcommers.demo.exception.ResourceNotFoundExceptin;
import com.finalEcommers.demo.model.User;
import com.finalEcommers.demo.repository.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    @Autowired
    UserRepo urepo;
    @Autowired
    ModelMapper mapper;
    public  UserDto createuser( UserDto userdto){
        User user = this.mapper.map(userdto, User.class);
      User saveUser=  this.urepo.save(user);
      UserDto saveUserdto =this.mapper.map(saveUser,UserDto.class);
      return saveUserdto;
    }
    public UserDto Getbyid(int id){
       User findbyid= this.urepo.findByuserId(id);
       UserDto userdto=this.mapper.map(findbyid,UserDto.class);
       return userdto;
    }
    public List<UserDto> findallUser(){
        List<User>findall=this.urepo.findAll();
         return findall.stream().map(each->this.mapper.map(each, UserDto.class)).collect(Collectors.toList());

    }
     public void DeleteUser(int userid){
         User findbyid=  this.urepo.findById(userid).orElseThrow(()-> new ResourceNotFoundExceptin("delated"));
           this.urepo.delete(findbyid);

     }
}
