package dev.ramana.productservice.dtos;

import dev.ramana.productservice.models.BaseModel;
import dev.ramana.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private double price;
    private String image;
}
