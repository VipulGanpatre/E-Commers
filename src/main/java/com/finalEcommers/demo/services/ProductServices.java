package com.finalEcommers.demo.services;

import com.finalEcommers.demo.common.CategoryDto;
import com.finalEcommers.demo.common.ProductDto;
import com.finalEcommers.demo.common.ProductResponce;
import com.finalEcommers.demo.exception.ResourceNotFoundExceptin;
import com.finalEcommers.demo.model.Category;
import com.finalEcommers.demo.model.Product;
import com.finalEcommers.demo.repository.Categoryrepo;
import com.finalEcommers.demo.repository.ProductRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServices {
    @Autowired
    ProductRepo prepo;
    @Autowired
    Categoryrepo catrepo;
    @Autowired
    ModelMapper mapper;
    public ProductDto createproduct( ProductDto productDto,int catid){
//        fetch catgory avaliable or not
        Category cat=this.catrepo.findById(catid).orElseThrow(()->new ResourceNotFoundExceptin("category not found"));
//        productDto to Product;
       Product cat1 =this.mapper.map(productDto,Product.class);
        Product save=this.prepo.save(cat1);

//        Product product=toEntity(productDto);
//        product.setCategory(cat);
//        Product save=this.repo.save(product);

//
//////        product to ProductDto
//        ProductDto dto= toDto(save);
//        return dto;
     return this.mapper.map(save, ProductDto.class);

    }
    public ProductResponce viewAllproduct(int pageNumber, int pagesize, String sortby, String SortDir){
        Sort sort=null;
        if(SortDir.trim().toLowerCase().equals("asc")){
            Sort.by(sortby).ascending();
            System.out.println(sort);
        }
            else {
            sort = Sort.by(sortby).descending();

            System.out.println(sort);

        }
        Pageable pageable = PageRequest.of(pageNumber, pagesize, sort);
        Page<Product> page = this.prepo.findAll(pageable);
        List<Product> pageproduct = page.getContent();
//                    List<Product> Product =pageproduct.stream().filter(P->p.isLive()).collect(Collectors.toList());
//            List<ProductDto> productDto = page.stream().map(product -> this.toDto(product)).collect(Collectors.toList());
        List<ProductDto> productDto = pageproduct.stream().map(product -> this.toDto(product)).collect(Collectors.toList());


        ProductResponce responce= new ProductResponce();
        responce.setContent(productDto);
        responce.setPageNumber(page.getNumber());
        responce.setPageSize(page.getSize());
        responce.setTotalpage(page.getTotalPages());
        responce.setLastpage(page.isLast());
        return responce;


//       List<Product> findAll = repo.findAll();
////       to convert List (product) to
//       List<ProductDto> findAllDto=findAll.stream().map(product-> this.toDto(product)).collect(Collectors.toList());
//       return findAllDto;
    }


    public ProductDto viewproductBYId(int pid){
        Product findbyid =prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundExceptin(+pid + "not found"));
        return this.toDto(findbyid);

    }

    public ProductDto updateproduct(int id, ProductDto product){

        Product oldp= prepo.getById(id);
        oldp.setId(product.getId());
        oldp.setCategoryName(product.getCategoryName());
        oldp.setDescription(product.getDescription());
        oldp.setImageUrl(product.getImageUrl());
        Product save= prepo.save(oldp);
        return toDto(save);
    }
//find  product by Category
//          public List<ProductDto> getProductbyCategory( int catid){
//        Category cat =this.catrepo.findById(catid).orElseThrow(() -> new ResourceNotFoundExceptin( " this is category is not found"));
//        List<Product> findbyCategory=this.prepo.findBYCategory(cat);
//              List<ProductDto> collect= findbyCategory.stream().map(product -> toDto(product)).collect(Collectors.toList());
//            return collect;
//
//          }


    public void deleteproduct( int pid){
       Product byid= prepo.findById(pid).orElseThrow(() -> new ResourceNotFoundExceptin(+pid + "not found"));
        prepo.delete(byid);
    }
//    productDto to Product;
    public Product toEntity(ProductDto pDto){
        Product p=new Product();
        p.setCategoryName(pDto.getCategoryName());
        p.setId(pDto.getId());
        p.setDescription(pDto.getDescription());
        p.setImageUrl(pDto.getImageUrl());
        return p;

    }
    //    product to ProductDto;
    public ProductDto toDto(Product product){
        ProductDto pdto=new ProductDto();
        pdto.setId(product.getId());
        pdto.setCategoryName(product.getCategoryName());
        pdto.setDescription(product.getDescription());
        pdto.setImageUrl(product.getImageUrl());

        CategoryDto catDto= new CategoryDto();


        catDto.setCategoryId(product.getCategory().getCategoryId());
        catDto.setTitle(product.getCategory().getTitle());

//        pdto.setCategory(catDto);

        return pdto;

    }


}

