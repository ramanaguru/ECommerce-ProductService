package dev.ramana.productservice.Services;

import dev.ramana.productservice.Mappers.DtoMappers;
import dev.ramana.productservice.dtos.GenericProductDTO;
import dev.ramana.productservice.exceptions.NotFoundException;
import dev.ramana.productservice.thirdPartyClients.FakeStoreClient;
import dev.ramana.productservice.thirdPartyClients.dtos.FakeStoreApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
   FakeStoreClient fakeStoreClient;


    @Autowired
    public FakeStoreProductService(FakeStoreClient fakeStoreClient) {
        this.fakeStoreClient = fakeStoreClient;
    }


    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {


        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreClient.getProductById(id));

    }


    @Override
    public GenericProductDTO  createProduct(GenericProductDTO product){

        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreClient.createProduct(DtoMappers.genericProductDtoToFakeStoreProductDtoMapper(product)));
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

        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreClient.deleteProduct(id));
    }

    public GenericProductDTO updateProductById(GenericProductDTO productDTO, Long id){

        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreClient.updateProductById(DtoMappers.genericProductDtoToFakeStoreProductDtoMapper(productDTO), id));
    }


}
