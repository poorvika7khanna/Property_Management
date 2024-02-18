package com.mycompany.Property_Management.service.impl;

import com.mycompany.Property_Management.converter.PropertyConverter;
import com.mycompany.Property_Management.dto.PropertyDTO;
import com.mycompany.Property_Management.entity.PropertyEntity;
import com.mycompany.Property_Management.repository.PropertyRepository;
import com.mycompany.Property_Management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;
    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO) {
        PropertyEntity propertyEntity=propertyConverter.convertDTOtoEntity(propertyDTO);
        propertyEntity=propertyRepository.save(propertyEntity);
        propertyDTO=propertyConverter.convertEntityToDTO(propertyEntity);
        return propertyDTO;
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entityList = (List<PropertyEntity>)propertyRepository.findAll();
//        List<PropertyDTO> propList = new ArrayList<>();
//        for(PropertyEntity pe:entityList)
//        {
//            PropertyDTO propDto=propertyConverter.convertEntityToDTO(pe);
//            propList.add(propDto);
//        }
        List<PropertyDTO> propList = entityList.stream()
                .map(propertyConverter::convertEntityToDTO)
                .collect(Collectors.toList());
        return propList;
    }

    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, long propId) {
        Optional<PropertyEntity> opEntity = propertyRepository.findById(propId);
        PropertyDTO propDto = null;
        if(opEntity.isPresent())
        {
            PropertyEntity propertyEntity = opEntity.get();
            propertyEntity.setTitle(propertyDTO.getTitle());
            propertyEntity.setDescription(propertyDTO.getDescription());
            propertyEntity.setOwner(propertyDTO.getOwner());
            propertyEntity.setEmail(propertyDTO.getEmail());
            propertyEntity.setPrice(propertyDTO.getPrice());
            propertyEntity.setAddress(propertyDTO.getAddress());
            propDto=propertyConverter.convertEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return propDto;
    }

    @Override
    public PropertyDTO updatePropertyDescription(PropertyDTO propertyDTO, long propId) {
        Optional<PropertyEntity> opEntity = propertyRepository.findById(propId);
        PropertyDTO propDto = null;
        if(opEntity.isPresent())
        {
            PropertyEntity propertyEntity = opEntity.get();
            propertyEntity.setDescription(propertyDTO.getDescription());
            propDto=propertyConverter.convertEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return propDto;
    }

    @Override
    public PropertyDTO updatePropertyPrice(PropertyDTO propertyDTO, long propId) {
        Optional<PropertyEntity> opEntity = propertyRepository.findById(propId);
        PropertyDTO propDto = null;
        if(opEntity.isPresent())
        {
            PropertyEntity propertyEntity = opEntity.get();
            propertyEntity.setPrice(propertyDTO.getPrice());
            propDto=propertyConverter.convertEntityToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
        }
        return propDto;
    }

    @Override
    public void deleteProperty(long propId) {
        propertyRepository.deleteById(propId);
    }
}
