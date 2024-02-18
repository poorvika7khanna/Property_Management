package com.mycompany.Property_Management.service;

import com.mycompany.Property_Management.dto.PropertyDTO;

import java.util.List;

public interface PropertyService {

    public PropertyDTO saveProperty(PropertyDTO propertyDTO);
    public List<PropertyDTO> getAllProperties();
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, long propId);
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, long propId);
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, long propId);
    public void deleteProperty(long propId);
}
