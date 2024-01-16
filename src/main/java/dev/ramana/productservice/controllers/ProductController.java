package dev.ramana.productservice.controllers;

import dev.ramana.productservice.Services.ProductService;
import dev.ramana.productservice.dtos.GenericProductDTO;
import dev.ramana.productservice.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {


    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<GenericProductDTO> getAllProductsById(){
        return productService.getAllProductsById();
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductById(@PathVariable("id") Long id) throws NotFoundException {

        return productService.getProductById(id);
    }

    @PutMapping("{id}")
    public GenericProductDTO updateProductById(@RequestBody GenericProductDTO genericProductDTO, @PathVariable("id")Long id){
        //@RequestBody annotation is responsible for binding the HTTPRequest body to the body of the web request
        return productService.updateProductById(genericProductDTO, id);
    }
    @PostMapping()
    public  GenericProductDTO createProduct(@RequestBody GenericProductDTO genericProductDTO){
        //@RequestBody annotation is responsible for binding the HTTPRequest body to the body of the web request
        return productService.createProduct(genericProductDTO);

    }

//    @DeleteMapping("{id}")
//    public GenericProductDTO deleteProduct(@PathVariable("id") Long id){
//        return productService.deleteProduct(id);
//    }

    //Let's see how exception handling in deleteProduct?
    // (In case you WANT TO EXECUTE/ RUN THE APPLICATION EITRHER COMMENT OUT ONE OF deleteProduct() )
    @DeleteMapping("{id}")
    public ResponseEntity<GenericProductDTO> deleteProduct(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);

    }


    /*  THIS one HANDLES when there is exception in Controller  AVOID THIS ( In real time , we might be using global or general )
        THIS CODE WILL WORK (SPECIFIC TO MORE CONTROLLER)

        @ExceptionHandler(NotFoundException.class)
       public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException notFoundException){
           return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, notFoundException.getMessage()), HttpStatus.NOT_FOUND);
        }
     */





}
