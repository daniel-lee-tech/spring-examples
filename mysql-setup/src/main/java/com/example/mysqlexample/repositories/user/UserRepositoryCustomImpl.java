package com.example.mysqlexample.repositories.user;

import com.example.mysqlexample.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

// this class holds all the functionality of custom repository methods
// add the functionality of JPA repository methods provided by Spring
// it implements custom functionality
// it is injected with spring provided JPA functionality
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private final UserRepositoryBasic userRepositoryBasic;

    UserRepositoryCustomImpl(UserRepositoryBasic userRepositoryBasic) {
        this.userRepositoryBasic = userRepositoryBasic;
    }

    @Override
    public List<UserEntity> findByWhereBothNamesHaveThisLength(int length) {
        List<UserEntity> users = new ArrayList<UserEntity>();
        for (UserEntity userEntity : userRepositoryBasic.findAll()) {
            String firstName = userEntity.getName().split(" ")[0];
            String lastName = userEntity.getName().split(" ")[0];

            if (firstName.length() == length && lastName.length() == length) {
                users.add(userEntity);
            }
        }

        return users;
    }
}
