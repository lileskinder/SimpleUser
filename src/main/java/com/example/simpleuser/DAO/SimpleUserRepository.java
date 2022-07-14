package com.example.simpleuser.DAO;

import com.example.simpleuser.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleUserRepository extends MongoRepository<User, String> {

    void deleteUserByUserName(String userName);
}
