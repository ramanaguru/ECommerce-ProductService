package dev.ramana.productservice.thirdPartyClients;

import dev.ramana.productservice.exceptions.NotFoundException;
import dev.ramana.productservice.thirdPartyClients.dtos.FakeStoreApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.List;

@Component
public class FakeStoreProductClient {

    String productUrl ;
    String createProductUrl;
    String allproductsUrl;

    String deleteproductUrl;

    String updateProductUrl;

    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                  @Value("${fakestore.api.baseurl}") String fakestorebaseUrl,
                                  @Value("${fakestore.api.product}") String productEndpoint){

                this.restTemplateBuilder = restTemplateBuilder;
                this.productUrl = fakestorebaseUrl + productEndpoint + "/{id}";
                this.allproductsUrl = fakestorebaseUrl + allproductsUrl;
                this.createProductUrl = fakestorebaseUrl + productEndpoint;
                this.deleteproductUrl = fakestorebaseUrl + productEndpoint + "/{id}";

    }

    public FakeStoreApiDTO getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO> response = restTemplate.getForEntity(productUrl , FakeStoreApiDTO.class, id );

        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        //How NULL error came ? because we might pass null id or id not existing STRING DEFAULT VALUE IS NULL
        if(fakeStoreApiDTO == null){
            throw new NotFoundException("This ProductID : " + id + " not found");
        }

        return fakeStoreApiDTO;

    }



    public FakeStoreApiDTO  createProduct(FakeStoreApiDTO product){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO>response = restTemplate.postForEntity(createProductUrl, product, FakeStoreApiDTO.class);

        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();


        return fakeStoreApiDTO;
    }

    public List<FakeStoreApiDTO> getAllProductsById(){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO[]>response = restTemplate.getForEntity(allproductsUrl,FakeStoreApiDTO[].class);

        FakeStoreApiDTO[] fakeStoreApiDTOs = response.getBody();

        return Arrays.asList(fakeStoreApiDTOs);
    }


    public FakeStoreApiDTO deleteProduct(Long id) throws NotFoundException{
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO>response = restTemplate.exchange(deleteproductUrl, HttpMethod.DELETE, null,FakeStoreApiDTO.class, id);

        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        return fakeStoreApiDTO;
    }

    public FakeStoreApiDTO updateProductById(FakeStoreApiDTO productDTO, Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreApiDTO>response = restTemplate.exchange(updateProductUrl,HttpMethod.PUT,new HttpEntity<>(productDTO), FakeStoreApiDTO.class,id);

        FakeStoreApiDTO fakeStoreApiDTO = response.getBody();

        return fakeStoreApiDTO;
    }



}
