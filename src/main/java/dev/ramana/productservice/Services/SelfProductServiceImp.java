package dev.ramana.productservice.Services;

import dev.ramana.productservice.dtos.GenericProductDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImp")
public class SelfProductServiceImp implements  ProductService{
    //this is for test
    //what if there are many services
    // what service @Autowired should call for this I creataed this classSelfProductServiceImp
    //Solution :step -1 :  in Services @Service("name")
    //step -2 :  In controllers , while calling the service we needed, use  @Qualifier("call the service name you mentioned @Service")


    @Override
    public GenericProductDTO getProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDTO createProduct(GenericProductDTO genericProductDTO) {
        return null;
    }

    @Override
    public List<GenericProductDTO> getAllProductsById(Long id) {
        return null;
    }

    public GenericProductDTO deleteProduct(Long id){
        return null;
    }

    @Override
    public GenericProductDTO updateProductById(GenericProductDTO genericProductDTO, Long id) {
        return null;
    }
}
