package com.bubble_dog.repository;

import java.util.List;

import javax.validation.Valid;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bubble_dog.Models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    List<UserModel> findAll();

    void save(@Valid UserModel newUser);

    void deleteAll();
    
}
