package com.example.minitestwedding.controller;

import com.example.minitestwedding.model.Category;
import com.example.minitestwedding.model.CountTask;
import com.example.minitestwedding.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ModelAndView listCategory(){
        ModelAndView modelAndView = new ModelAndView("/category/list");
        Iterable<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("categories", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes){
        categoryService.save(category);
        redirectAttributes.addFlashAttribute("message", "Create new province successfully");
        return "redirect:/category";
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        Optional<Category> categories = categoryService.findById(id);
        if (categories.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/category/update");
            modelAndView.addObject("categories", categories.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error_404");
        }
    }
    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("category") Category category){
        categoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        categoryService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/category";
    }
    @GetMapping("/count")
    public ModelAndView count(){
        ModelAndView modelAndView = new ModelAndView("/categorycount");
        Iterable<CountTask> categoryCount = categoryService.countTask();
        modelAndView.addObject("categoryCount", categoryCount);
        return modelAndView;
    }
}
