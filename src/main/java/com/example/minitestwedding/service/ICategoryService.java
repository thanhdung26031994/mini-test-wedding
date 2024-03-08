package com.example.minitestwedding.service;

import com.example.minitestwedding.model.Category;
import com.example.minitestwedding.model.CountTask;

public interface ICategoryService extends IGenerateService<Category> {
    Iterable<CountTask> countTask();
}
