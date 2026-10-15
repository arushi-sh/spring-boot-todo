package com.app.todo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.todo.models.Task;
import com.app.todo.services.TaskService;

@Controller // tells spring to use it to handle HTTP requests
// @RequestMapping ("/tasks")
public class TaskController {

    private final TaskService taskService;// final -> means that this variable can only be assigned once, and it cannot
                                          // be changed after that

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String getTasks(Model model) {// Model -> a container for data that you want to give to your HTML template

        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";// Spring intereprets this as a request to render the tasks.html template
    }

    @PostMapping
    public String createTask(@RequestParam String title) {// Model -> a container for data that you want to give to your
                                                          // HTML template

        taskService.createTask(title);
        // return "h"; -> spring tries to find h.html and since I don't have it thus the
        // error
        return "redirect:/";// after creating task we need to refresh task so we go
        // to
        // root where all tasks are there
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";// GET request and ' / ' -> root path where all tasks are there
    }

}
