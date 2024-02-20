package com.mycompany.Property_Management.repository;

import com.mycompany.Property_Management.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity,Long> {

}
