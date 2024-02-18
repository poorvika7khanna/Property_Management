package com.mycompany.Property_Management.controller;

import com.mycompany.Property_Management.dto.PropertyDTO;
import com.mycompany.Property_Management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO)
    {
        propertyDTO=propertyService.saveProperty(propertyDTO);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getAllProperties()
    {
        List<PropertyDTO> dtoList = propertyService.getAllProperties();
        return new ResponseEntity<List<PropertyDTO>>(dtoList, HttpStatus.OK);
    }

    @PutMapping("/properties/{id}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable("id") long propId)
    {
        propertyDTO=propertyService.updateProperty(propertyDTO,propId);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.CREATED);
    }

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable("id") long propId)
    {
        propertyDTO=propertyService.updatePropertyDescription(propertyDTO,propId);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
    }

    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<PropertyDTO> updatePropertyPrice(@RequestBody PropertyDTO propertyDTO, @PathVariable("id") long propId)
    {
        propertyDTO=propertyService.updatePropertyPrice(propertyDTO,propId);
        return new ResponseEntity<PropertyDTO>(propertyDTO, HttpStatus.OK);
    }

    @DeleteMapping("/properties/{id}")
    public ResponseEntity<Void> deleteProperty(@PathVariable("id") long propId)
    {
        propertyService.deleteProperty(propId);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
