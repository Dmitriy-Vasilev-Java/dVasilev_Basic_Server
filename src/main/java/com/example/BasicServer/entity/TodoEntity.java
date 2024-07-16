package com.example.BasicServer.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //////////////////////Код из гайда
    private Long id;
    private String username;
    private String password;
    public TodoEntity() {
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
//////
}
//Tasks
//Сущнотсь == строка в БД
//Hibernate готовый фреймворк, который реализует ORM(техника преобразовния java объектов  в формат строки БД)
// и JPA (Абстракция ORM - как должна быть устроена система ORM )