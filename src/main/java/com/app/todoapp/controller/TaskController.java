package com.app.todoapp.controller;

import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Task> tasks = taskService.getAllTasks();
        System.out.println("Tasks fetched: " + tasks);
        model.addAttribute("tasks", tasks);
        return "tasks"; // This should match the name of your HTML template
    }

    @PostMapping
    public String CreateTasks(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/"; // Redirect to the tasks page after creating a task
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return "redirect:/"; // This should match the name of your HTML template
    }
    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        taskService.toggleTask(id);
        return "redirect:/"; // This should match the name of your HTML template
    }
}
