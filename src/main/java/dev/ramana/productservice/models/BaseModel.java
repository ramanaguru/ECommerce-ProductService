package dev.ramana.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(generator =  "uuidgenrator")
    @GenericGenerator(name = "uuidgenerator" , strategy = "uuid2")
    @Column(name = "id" , columnDefinition = "binary(16)" , nullable = false, updatable = false)
    private UUID uuid;
}

/*Inherientence involves in our system what to do?

        Oneway ==> use @MappedSuperclass
                what is @MappedSuperClass==> create table for children but not for parent


        2way) ==> Single Table

 */
