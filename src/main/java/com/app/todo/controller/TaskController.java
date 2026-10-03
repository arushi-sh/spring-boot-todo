package com.app.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

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

}
