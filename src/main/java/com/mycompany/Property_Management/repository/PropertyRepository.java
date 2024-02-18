package com.mycompany.Property_Management.repository;

import com.mycompany.Property_Management.entity.PropertyEntity;
import org.springframework.data.repository.CrudRepository;

public interface PropertyRepository extends CrudRepository<PropertyEntity,Long> {

}
