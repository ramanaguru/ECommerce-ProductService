package dev.ramana.productservice.Services;

import dev.ramana.productservice.Mappers.DtoMappers;
import dev.ramana.productservice.dtos.GenericProductDTO;
import dev.ramana.productservice.exceptions.NotFoundException;
import dev.ramana.productservice.thirdPartyClients.FakeStoreProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
   FakeStoreProductClient fakeStoreProductClient;


    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient) {
        this.fakeStoreProductClient = fakeStoreProductClient;
    }


    @Override
    public GenericProductDTO getProductById(Long id) throws NotFoundException {


        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreProductClient.getProductById(id));

    }


    @Override
    public GenericProductDTO  createProduct(GenericProductDTO product){

        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreProductClient.createProduct(DtoMappers.genericProductDtoToFakeStoreProductDtoMapper(product)));
    }


    public List<GenericProductDTO> getAllProductsById(){

        return fakeStoreProductClient.getAllProductsById().stream().map(DtoMappers::fakeStoreToGenericProductDtoMapper).toList();
    }


    public GenericProductDTO deleteProduct(Long id) throws NotFoundException{

        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreProductClient.deleteProduct(id));
    }

    public GenericProductDTO updateProductById(GenericProductDTO productDTO, Long id){

        return DtoMappers.fakeStoreToGenericProductDtoMapper(fakeStoreProductClient.updateProductById(DtoMappers.genericProductDtoToFakeStoreProductDtoMapper(productDTO), id));
    }


}
