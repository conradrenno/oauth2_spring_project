package com.devrenno.resourceserver.controllers;

import com.devrenno.resourceserver.dto.CategoryDTO;
import com.devrenno.resourceserver.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> categoryDTOS = categoryService.findAll();
        return ResponseEntity.ok(categoryDTOS);
    }

}
