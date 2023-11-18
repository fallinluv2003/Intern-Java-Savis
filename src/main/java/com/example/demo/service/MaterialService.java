package com.example.demo.service;

import com.example.demo.entity.ChatLieu;

import java.util.List;
import java.util.UUID;

public interface MaterialService {
    List<ChatLieu> getAll();

    List<ChatLieu> getAllByTrangThai();

    ChatLieu getById(UUID id);

    ChatLieu add(ChatLieu chatLieu);
}
