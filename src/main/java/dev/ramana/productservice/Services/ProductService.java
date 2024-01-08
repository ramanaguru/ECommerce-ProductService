package dev.ramana.productservice.Services;

import dev.ramana.productservice.dtos.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
     public GenericProductDTO getProductById(Long id);

     public GenericProductDTO createProduct(GenericProductDTO genericProductDTO);

     public List<GenericProductDTO> getAllProductsById(Long id);

     public GenericProductDTO deleteProduct(Long id);

     public GenericProductDTO updateProductById(GenericProductDTO genericProductDTO,Long id);
}
