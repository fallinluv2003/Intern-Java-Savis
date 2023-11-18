package com.example.demo.repository;

import com.example.demo.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MaterialRepository extends JpaRepository<ChatLieu, UUID> {
    @Query(value = "SELECT cl FROM ChatLieu cl WHERE cl.id=:id")
    ChatLieu getById(UUID id);

    @Query(value = "SELECT cl FROM ChatLieu cl WHERE cl.trangThai = 1")
    List<ChatLieu> getAllByTrangThai();
}
