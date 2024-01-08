package dev.ramana.productservice.Services;

import dev.ramana.productservice.dtos.FakeStoreApiDTO;
import dev.ramana.productservice.dtos.GenericProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    String productUrl = "https://fakestoreapi.com/products/{id}";
    String createProductUrl = "https://fakestoreapi.com/products";
    String allproductsUrl = "https://fakestoreapi.com/products";

    String deleteproductUrl = "https://fakestoreapi.com/products/{id}";

    String updateProductUrl = "https://fakestoreapi.com/products/{id}";

    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    @Override
    public GenericProductDTO getProductById(Long id) {


        RestTemplate restTemplate = restTemplateBuilder.build();


        ResponseEntity<FakeStoreApiDTO>response = restTemplate.getForEntity(productUrl,FakeStoreApiDTO.class,id);

        //Mapper class(It is like conversion)
        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        GenericProductDTO genericProductDTO = new GenericProductDTO();

        genericProductDTO.setCategory(fakeStoreApiDTO.getCategory());
        genericProductDTO.setImage(fakeStoreApiDTO.getImage());
        genericProductDTO.setDescription(fakeStoreApiDTO.getDescription());
        genericProductDTO.setTitle(fakeStoreApiDTO.getTitle());
        genericProductDTO.setPrice(fakeStoreApiDTO.getPrice());
        genericProductDTO.setId(fakeStoreApiDTO.getId());



        return genericProductDTO;
    }

    @Override
    public GenericProductDTO  createProduct(GenericProductDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO>response = restTemplate.postForEntity(createProductUrl, product, FakeStoreApiDTO.class);

        //we use mapper class
        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        GenericProductDTO genericProductDTO = new GenericProductDTO();

        genericProductDTO.setCategory(fakeStoreApiDTO.getCategory());
        genericProductDTO.setImage(fakeStoreApiDTO.getImage());
        genericProductDTO.setDescription(fakeStoreApiDTO.getDescription());
        genericProductDTO.setTitle(fakeStoreApiDTO.getTitle());
        genericProductDTO.setPrice(fakeStoreApiDTO.getPrice());
        genericProductDTO.setId(fakeStoreApiDTO.getId());

        return genericProductDTO;
    }

    public List<GenericProductDTO> getAllProductsById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO[]>response = restTemplate.getForEntity(allproductsUrl,FakeStoreApiDTO[].class);

        FakeStoreApiDTO[] fakeStoreApiDTOs = response.getBody();

        List<GenericProductDTO>genericProductDTOS = new ArrayList<>();

        for(FakeStoreApiDTO fakeStoreApiDTO : fakeStoreApiDTOs){
            GenericProductDTO genericProductDTO =  new GenericProductDTO();

            genericProductDTO.setCategory(fakeStoreApiDTO.getCategory());
            genericProductDTO.setImage(fakeStoreApiDTO.getImage());
            genericProductDTO.setDescription(fakeStoreApiDTO.getDescription());
            genericProductDTO.setTitle(fakeStoreApiDTO.getTitle());
            genericProductDTO.setPrice(fakeStoreApiDTO.getPrice());
            genericProductDTO.setId(fakeStoreApiDTO.getId());

                    genericProductDTOS.add(genericProductDTO);
        }

        return genericProductDTOS;
    }


    public GenericProductDTO deleteProduct(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO>response = restTemplate.exchange(deleteproductUrl, HttpMethod.DELETE, null,FakeStoreApiDTO.class, id);

        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        GenericProductDTO genericProductDTO = new GenericProductDTO();

        genericProductDTO.setCategory(fakeStoreApiDTO.getCategory());
        genericProductDTO.setImage(fakeStoreApiDTO.getImage());
        genericProductDTO.setDescription(fakeStoreApiDTO.getDescription());
        genericProductDTO.setTitle(fakeStoreApiDTO.getTitle());
        genericProductDTO.setPrice(fakeStoreApiDTO.getPrice());
        genericProductDTO.setId(fakeStoreApiDTO.getId());

        return genericProductDTO;
    }

    public GenericProductDTO updateProductById(GenericProductDTO productDTO, Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO>response = restTemplate.exchange(updateProductUrl,HttpMethod.PUT,new HttpEntity<>(productDTO), FakeStoreApiDTO.class,id);

        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        GenericProductDTO genericProductDTO = new GenericProductDTO();

        genericProductDTO.setCategory(fakeStoreApiDTO.getCategory());
        genericProductDTO.setImage(fakeStoreApiDTO.getImage());
        genericProductDTO.setDescription(fakeStoreApiDTO.getDescription());
        genericProductDTO.setTitle(fakeStoreApiDTO.getTitle());
        genericProductDTO.setPrice(fakeStoreApiDTO.getPrice());
        genericProductDTO.setId(fakeStoreApiDTO.getId());

        return genericProductDTO;
    }


}
