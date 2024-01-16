package dev.ramana.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private double price;

    @ManyToOne //One product have many category and one category have one  product  ==> M : 1
    private Category category;

    private String image;
}
