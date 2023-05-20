package com.finalEcommers.demo.controller;

import com.finalEcommers.demo.common.AppConstants;
import com.finalEcommers.demo.common.ProductDto;
import com.finalEcommers.demo.common.ProductResponce;
import com.finalEcommers.demo.model.Product;
import com.finalEcommers.demo.services.FileUpload;
import com.finalEcommers.demo.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductServices pservice;
    @Autowired
    private FileUpload fileupolad;
    @PostMapping("product/images{productid}")
    public ResponseEntity<?>uploadimagesofproduct(@PathVariable int productid,
                                                  @RequestParam ("product_image")MultipartFile file){

        return null;
    }
    @PostMapping("/create/{catid}")
    @ResponseBody
    public ResponseEntity<ProductDto> createproduct(@RequestBody ProductDto product,@PathVariable int catid){
        ProductDto product1= pservice.createproduct(product,catid);
        return new ResponseEntity<ProductDto>( product1,HttpStatus.CREATED);

    }
    //    Read a Product
    @GetMapping("/view")
//                                                                                    Paginations
    public ProductResponce viewAllproduct(@RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER_STRING,required = false)int pageNumber,
                                          @RequestParam(value = "pagesize",defaultValue = AppConstants.PAGE_SIZE_STRING,required = false) int pagesize,
                                          @RequestParam(value = "sortby",defaultValue = AppConstants.SORT_BY_STRING,required = false) String sortby,
                                          @RequestParam(value = "SortDir",defaultValue = AppConstants.SORT_DIR_STRING,required = false) String SortDir){
       ProductResponce responce= pservice.viewAllproduct(pageNumber,pagesize,sortby,SortDir);
        return responce ;

    }
    @GetMapping("/veiw{id}")
    @ResponseBody
//
    public ResponseEntity<ProductDto> viewproductBYId(@PathVariable int pid){
      ProductDto viewbyid=  pservice.viewproductBYId(pid);
        return new ResponseEntity<ProductDto>(viewbyid,HttpStatus.OK);
    }

    //     Update a product
    @PutMapping("/update{pid}")
    public  ResponseEntity<ProductDto> updateproduct(@PathVariable int id,@RequestBody ProductDto product){
        ProductDto updateproduct=pservice.updateproduct(id,product) ;
        return new ResponseEntity<ProductDto>(updateproduct,HttpStatus.ACCEPTED);
    }

//    find  product by Category
//    @GetMapping("/Category/{catid}")
//    public ResponseEntity<List<ProductDto>> getProductbyCategory(@PathVariable int catid){
//        List<ProductDto> getcat =  this.pservice.getProductbyCategory(catid);
//        return new ResponseEntity<List<ProductDto>>(getcat,HttpStatus.ACCEPTED);
//
//    }
//




    //     Delete a product
    @DeleteMapping("/del{id}")
    public ResponseEntity<String> deleteproduct(@PathVariable int id){
        pservice.deleteproduct(id);
        return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);
    }


}
