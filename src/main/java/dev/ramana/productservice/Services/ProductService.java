package dev.ramana.productservice.Services;

import dev.ramana.productservice.dtos.GenericProductDTO;
import dev.ramana.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
     public GenericProductDTO getProductById(Long id) throws NotFoundException;

     public GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

     public List<GenericProductDTO> getAllProductsById();

     public GenericProductDTO deleteProduct(Long id) throws NotFoundException;

     public GenericProductDTO updateProductById(GenericProductDTO genericProductDTO,Long id);
}
