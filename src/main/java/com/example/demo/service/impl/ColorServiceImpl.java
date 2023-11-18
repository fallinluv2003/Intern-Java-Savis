package com.example.demo.service.impl;

import com.example.demo.entity.MauSac;
import com.example.demo.repository.ColorRepository;
import com.example.demo.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ColorServiceImpl implements ColorService {
    
    @Autowired
    private ColorRepository colorRepository;
    
    @Override
    public List<MauSac> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public List<MauSac> getAllByTrangThai() {
        return colorRepository.getAllByTrangThai();
    }

    @Override
    public MauSac getById(UUID id) {
        return colorRepository.getById(id);
    }

    @Override
    public MauSac add(MauSac mauSac) {
        return colorRepository.save(mauSac);
    }
}
