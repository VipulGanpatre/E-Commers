package com.finalEcommers.demo.controller;

import com.finalEcommers.demo.common.UserDto;
import com.finalEcommers.demo.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserServices uservices;

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<UserDto> createuser(@RequestBody UserDto user){
        Date date = new Date();
        user.setDate(date);
           UserDto createuser = this.uservices.createuser(user);
           return new ResponseEntity<UserDto>(createuser, HttpStatus.CREATED);
    }
    @GetMapping("getbyid/{id}")
    public ResponseEntity<UserDto> Getbyid(@PathVariable  int id){
       UserDto user= this.uservices.Getbyid(id);
       return new ResponseEntity<UserDto>(user,HttpStatus.ACCEPTED);

    }

    public ResponseEntity<List<UserDto>>findallUser(){
        List<UserDto> findAll= this.uservices.findallUser();

        return new ResponseEntity<List<UserDto>>(findAll,HttpStatus.OK);
    }
    @DeleteMapping("deleteuder/{userid}")
    public void delete (@PathVariable int userid){
        this.uservices.DeleteUser(userid);

    }



}
