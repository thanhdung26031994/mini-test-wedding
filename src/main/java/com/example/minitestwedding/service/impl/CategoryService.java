package com.example.minitestwedding.service.impl;

import com.example.minitestwedding.model.Category;
import com.example.minitestwedding.model.CountTask;
import com.example.minitestwedding.repository.ICategoryRepository;
import com.example.minitestwedding.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Iterable<CountTask> countTask() {
        return categoryRepository.countTask();
    }
}
