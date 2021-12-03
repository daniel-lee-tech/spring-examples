package com.example.mysqlexample.repositories.user;

import com.example.mysqlexample.entities.UserEntity;

import java.util.List;

// this holds custom methods that the default repositories interfaces
// from spring does not provide.
// this interface should specify methods that can't be done with SQL,
// since SQL is more efficient with complicated queries.
public interface UserRepositoryCustom {
    // this is a really contrived method but the idea here is:
    // this method encompasses really complicated logic that is specific to the domain logic
    // for this application, it would be easier writing out this query using java instead of SQL
    public List<UserEntity> findByWhereBothNamesHaveThisLength(int length);
}
