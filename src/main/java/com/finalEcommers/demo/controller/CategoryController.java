package com.finalEcommers.demo.controller;

import com.finalEcommers.demo.common.ApiResponse;
import com.finalEcommers.demo.common.CategoryDto;
import com.finalEcommers.demo.common.ProductDto;
import com.finalEcommers.demo.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")

public class CategoryController {
    @Autowired
    CategoryServices catservices;
    CategoryDto create;
//    Create Category
    @PostMapping("/create")
    @ResponseBody

    public ResponseEntity<CategoryDto> Create(@RequestBody CategoryDto CatDto){
       CategoryDto Add= this.catservices.Create(CatDto);
       return new ResponseEntity<CategoryDto>(Add,HttpStatus.CREATED);
    }
    //    Update Category
    @PostMapping("update/{catid}")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto CatDto,@PathVariable int catid){
         CategoryDto update=this.catservices.update(CatDto,catid);
         return new ResponseEntity<CategoryDto>(update,HttpStatus.ACCEPTED);
    }
    //    Delete Category
    @DeleteMapping("delete/{Catid}")
    public ResponseEntity<ApiResponse>delete(@PathVariable int Catid){
       this. catservices.delete(Catid);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted ",true),HttpStatus.OK);

    }
    //    read(get) Category
    @GetMapping("readByid/{Cartid}")
      public ResponseEntity<CategoryDto>readByid(@PathVariable int Cartid){
        CategoryDto readbyid=this.catservices.readByid(Cartid);
        return new ResponseEntity<CategoryDto>(readbyid,HttpStatus.OK);
       }
//       readAll(getAll) Category
           @GetMapping("getAll")
       public ResponseEntity<List<CategoryDto>> getAll(){

          List<CategoryDto>getall=this.catservices.getAll();
          return new ResponseEntity<List<CategoryDto>>(getall,HttpStatus.OK);

       }


    }
