package dev.ramana.productservice.thirdPartyClients.dtos;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class FakeStoreApiDTO {
        private Long id;
        private String title;
        private String description;
        private String image;
        private String category;
        private double price;


    }

