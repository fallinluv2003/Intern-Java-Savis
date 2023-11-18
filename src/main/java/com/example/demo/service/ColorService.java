package com.example.demo.service;

import com.example.demo.entity.MauSac;

import java.util.List;
import java.util.UUID;

public interface ColorService {
    List<MauSac> getAll();

    List<MauSac> getAllByTrangThai();

    MauSac getById(UUID id);

    MauSac add(MauSac mauSac);
}
