package com.example.mysqlexample.repositories.user;

import com.example.mysqlexample.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends UserRepositoryBasic, UserRepositoryCustom {
}
