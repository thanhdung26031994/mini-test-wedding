package com.example.minitestwedding.controller;

import com.example.minitestwedding.model.Category;
import com.example.minitestwedding.model.Task;
import com.example.minitestwedding.service.ICategoryService;
import com.example.minitestwedding.service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskService taskService;
    @Autowired
    private ICategoryService categoryService;
    @ModelAttribute("category")
    public Iterable<Category> listCategory(){
        return categoryService.findAll();
    }
    @GetMapping
    public ModelAndView listTask(){
        ModelAndView modelAndView = new ModelAndView("/task/list");
        Iterable<Task> tasks = taskService.findAll();
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("tasks", new Task());
        return modelAndView;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute("task") Task task, RedirectAttributes redirectAttributes){
        taskService.save(task);
        redirectAttributes.addFlashAttribute("message", "Create new province successfully");
        return "redirect:/task";
    }
    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id){
        Optional<Task> task = taskService.findById(id);
        if (task.isPresent()){
            ModelAndView modelAndView = new ModelAndView("/task/update");
            modelAndView.addObject("task", task.get());
            return modelAndView;
        }else {
            return new ModelAndView("/error_404");
        }
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("task") Task task){
        taskService.save(task);
        return "redirect:/task";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,
                         RedirectAttributes redirect) {
        taskService.remove(id);
        redirect.addFlashAttribute("message", "Delete customer successfully");
        return "redirect:/task";
    }
}
