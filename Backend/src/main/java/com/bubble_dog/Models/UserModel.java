package com.bubble_dog.Models;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuarios")
public class UserModel {
    
    //Atributos
    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Integer id;

    @Column(name ="username")
    private @NotBlank String username;
    
    @Column(name ="password")
    private @NotBlank String password;
    
    //Contructor vacio
    public UserModel() {
    }

    public UserModel(@NotBlank String username, @NotBlank String password) {
        this.username = username;
        this.password = password;
        
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }  
    
    @Override
    public boolean equals(Object userObject) {
        if (this == userObject) return true;
        if (!(userObject instanceof UserModel)) return false;
        UserModel user = (UserModel) userObject;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
