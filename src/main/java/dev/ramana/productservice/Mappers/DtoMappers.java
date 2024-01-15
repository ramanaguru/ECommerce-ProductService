package dev.ramana.productservice.Mappers;

import dev.ramana.productservice.dtos.GenericProductDTO;
import dev.ramana.productservice.thirdPartyClients.dtos.FakeStoreApiDTO;

public class DtoMappers {
    public static GenericProductDTO fakeStoreToGenericProductDtoMapper(FakeStoreApiDTO fakeStoreApiDTO){
        GenericProductDTO genericProductDTO = new GenericProductDTO();

        genericProductDTO.setId(fakeStoreApiDTO.getId());
        genericProductDTO.setCategory(fakeStoreApiDTO.getCategory());
        genericProductDTO.setPrice(fakeStoreApiDTO.getPrice());
        genericProductDTO.setImage(fakeStoreApiDTO.getImage());
        genericProductDTO.setDescription(fakeStoreApiDTO.getDescription());
        genericProductDTO.setTitle(fakeStoreApiDTO.getTitle());

        return genericProductDTO;
    }

    public static FakeStoreApiDTO genericProductDtoToFakeStoreProductDtoMapper(GenericProductDTO genericProductDTO){
        FakeStoreApiDTO fakeStoreApiDTO = new FakeStoreApiDTO();

        fakeStoreApiDTO.setCategory(genericProductDTO.getCategory());
        fakeStoreApiDTO.setId(genericProductDTO.getId());
        fakeStoreApiDTO.setTitle(genericProductDTO.getTitle());
        fakeStoreApiDTO.setPrice(genericProductDTO.getPrice());
        fakeStoreApiDTO.setDescription(genericProductDTO.getDescription());
        fakeStoreApiDTO.setImage(genericProductDTO.getImage());

        return fakeStoreApiDTO;
    }


}
