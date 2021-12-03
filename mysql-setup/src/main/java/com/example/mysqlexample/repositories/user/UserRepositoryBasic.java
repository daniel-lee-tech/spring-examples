package com.example.mysqlexample.repositories.user;

import com.example.mysqlexample.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

// provides commonly used functionality.
// by default all CrudRepository methods will be inherited, but you can manually choose
// which ones to inherit by specifying them here.
public interface UserRepositoryBasic extends CrudRepository<UserEntity, Long> {
}
