package dev.ramana.productservice.dtos;

import dev.ramana.productservice.models.Category;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class FakeStoreApiDTO {
    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private double price;


}
