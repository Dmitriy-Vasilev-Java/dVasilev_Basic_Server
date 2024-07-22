package com.example.BasicServer.repository;

import com.example.BasicServer.entity.TodoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    @Transactional
    @Modifying
    void deleteByStatus(boolean status);

    Page<TodoEntity> findPaginatedByStatus(Pageable pageable, Boolean status);

}
