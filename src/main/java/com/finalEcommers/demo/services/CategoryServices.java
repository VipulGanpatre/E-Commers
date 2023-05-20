package com.finalEcommers.demo.services;

import com.finalEcommers.demo.common.ApiResponse;
import com.finalEcommers.demo.common.CategoryDto;
import com.finalEcommers.demo.exception.ResourceNotFoundExceptin;
import com.finalEcommers.demo.model.Category;
import com.finalEcommers.demo.repository.Categoryrepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServices {
    @Autowired
    Categoryrepo repo;
    @Autowired
    ModelMapper mapper;
    public CategoryDto Create(CategoryDto CatDto){
//        ctegoryDto to Category
        Category cat=this.mapper.map(CatDto, Category.class);
        Category save=this.repo.save(cat);

//        ctegory to CategoryDto

        return this.mapper.map(save, CategoryDto.class);
    }
    public CategoryDto update( CategoryDto newCat, int catid){
       Category oldcat= this.repo.findById(catid).orElseThrow(() -> new ResourceNotFoundExceptin( " Category not found"));

       oldcat.setTitle(newCat.getTitle());
        Category save=this.repo.save(oldcat);
       return this.mapper.map(save,CategoryDto.class);

    }
    public void delete(int catid){
        Category cat= this.repo.findById(catid).orElseThrow(() -> new ResourceNotFoundExceptin( " Category is delated"));
        this.repo.delete(cat);
    }
    public CategoryDto readByid( int cartid){
        Category cat= this.repo.findById(cartid).orElseThrow(() -> new ResourceNotFoundExceptin( " Category not found"));
      return this.mapper.map(cat,CategoryDto.class);
    }
    public List<CategoryDto> getAll(){
       List<Category> findAll= this.repo.findAll();
//       to convert List (product) to
      return findAll.stream().map(cat->this.mapper.map(cat,CategoryDto.class)).collect(Collectors.toList());




    }



}
