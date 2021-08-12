package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
   @Query( value = "SELECT * FROM users_table where user_email =:email and user_password =:password",
            nativeQuery = true)
   User getUserByEmailAndPassword(String email,String password);

}
