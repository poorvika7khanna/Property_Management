package com.mycompany.Property_Management.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PropertyDTO {

    private long id;
    private String title;
    private String description;
    private String owner;
    private String email;
    private Double price;
    private String address;
}
