package com.example.BasicServer.repository;

import com.example.BasicServer.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, Long>{

}
