package com.devrenno.resourceserver.services;

import com.devrenno.resourceserver.dto.CategoryDTO;
import com.devrenno.resourceserver.entities.Category;
import com.devrenno.resourceserver.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;



    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> categories = repository.findAll();
        return categories.stream().map(x -> new CategoryDTO(x)).toList();
    }


}
