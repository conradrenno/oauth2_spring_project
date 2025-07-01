package com.devrenno.resourceserver.services;

import com.devrenno.resourceserver.dto.CategoryDTO;
import com.devrenno.resourceserver.dto.ProductDTO;
import com.devrenno.resourceserver.dto.ProductMinDTO;
import com.devrenno.resourceserver.entities.Category;
import com.devrenno.resourceserver.entities.Product;
import com.devrenno.resourceserver.repositories.ProductRepository;
import com.devrenno.resourceserver.services.exceptions.DatabaseException;
import com.devrenno.resourceserver.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findByid(Long id){
        Product product = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable){
        Page<Product> products = repository.searchByName(name, pageable);
        return products.map(x -> new ProductMinDTO(x));
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO){

        Product product = new Product();
        copyDtoToEntity(productDTO, product);
        product = repository.save(product);

        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO){

        try {
            Product product = repository.getReferenceById(id);
            copyDtoToEntity(productDTO, product);
            product = repository.save(product);
            return new ProductDTO(product);

        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteByid(Long id){
        if (!repository.existsById(id)){
            throw  new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw  new DatabaseException("falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ProductDTO productDTO, Product product) {

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImgUrl(productDTO.getImgUrl());

        product.getCategories().clear();
        for (CategoryDTO catDTO : productDTO.getCategories()) {
            Category cat = new Category();
            cat.setId(catDTO.getId());
            product.getCategories().add(cat);
        }
    }


}
