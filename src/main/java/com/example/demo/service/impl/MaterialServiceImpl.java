package com.example.demo.service.impl;

import com.example.demo.entity.ChatLieu;
import com.example.demo.repository.MaterialRepository;
import com.example.demo.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialRepository materialRepository;

    @Override
    public List<ChatLieu> getAll() {
        return materialRepository.findAll();
    }

    @Override
    public List<ChatLieu> getAllByTrangThai() {
        return materialRepository.getAllByTrangThai();
    }

    @Override
    public ChatLieu getById(UUID id) {
        return materialRepository.getById(id);
    }

    @Override
    public ChatLieu add(ChatLieu chatLieu) {
        return materialRepository.save(chatLieu);
    }
}
