package com.example.demo.service.impl;

import com.example.demo.entity.ChucVu;
import com.example.demo.repository.PositionRepository;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<ChucVu> getAll() {
        return positionRepository.findAll();
    }

    @Override
    public List<ChucVu> getAllByTrangThai() {
        return positionRepository.getAllByTrangThai();
    }

    @Override
    public ChucVu add(ChucVu chucVu) {
        return positionRepository.save(chucVu);
    }
}
