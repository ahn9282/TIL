package com.example.catalogservice.service.impl;

import com.example.catalogservice.dto.CatalogDto;
import com.example.catalogservice.entity.CatalogEntity;
import com.example.catalogservice.repository.CatalogRepository;
import com.example.catalogservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CatalogServiceImpl implements CatalogService {
    private final CatalogRepository repository;
    private final Environment env;

    @Override
    public List<CatalogDto> getAllCatalogs() {
        List<CatalogEntity> allCatalogs = repository.findAll();
        return allCatalogs.stream().map(c -> new ModelMapper().map(c, CatalogDto.class)).toList();
    }
}
