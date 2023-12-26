package com.example.kursov23.controllers;

import com.example.kursov23.models.Person;
import com.example.kursov23.models.Tasks;
import com.example.kursov23.repositories.PeopleRepository;
import com.example.kursov23.repositories.TaskRepo;
import com.example.kursov23.services.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private int id_su;
    private int id_gr;

    @Autowired
    private TasksService tasksService;
    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/showNewTask")
    public String createTask(Model model){
        Tasks tasks = new Tasks();
        model.addAttribute("tasks", tasks);
        return "createTask";
    }

    @PostMapping("/saveTask")
    public String saveTasks(@ModelAttribute("tasks") Tasks tasks){
        /*int gr = tasks.getId_group();
        List<Person> person = peopleRepository.findAllUserByGroup(gr);
        System.out.println(person.size());
        if (!person.isEmpty()){
            for (int i = 0; i < person.size(); i++){
                tasks.setId_user(person.get(i).getId());
                tasksService.saveTasks(tasks);
            }
        }*/
        tasksService.saveTasks(tasks);
        return "redirect:/admin";
    }

    @PostMapping("/saveMarkTask")
    public String saveMarkTask(@ModelAttribute("tasks") Tasks tasks){
        tasksService.saveTasks(tasks);
        return "redirect:/listOfTasks";
    }

    @GetMapping("/findTaskPage")
    public String findTaskPage1( Model model) {
        return "findTaskPage";
    }

    @PostMapping("/findTaskPage")
    public String findTaskPage(@RequestParam int id_gr1, int id_su1, Model model){
        try {
            id_gr = id_gr1;
            id_su = id_su1;
        } catch (Exception e) {
            return "admin";
        }
        return "redirect:/listOfTasks";
    }

    @GetMapping("/listOfTasks")
    public String adminPage(Model model){
        model.addAttribute("taskList", taskRepo.finTasksByGroupSub(id_gr, id_su));
        return "listOfTasks";
    }

    @GetMapping("/formForUpdateTask/{id}")
    public String showFormForUpdateUser(@PathVariable(value = "id") int id, Model model){
        Tasks tasks = tasksService.getTaskById(id);
        model.addAttribute("tasks", tasks);
        return "update_tasks";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable (value = "id") int id){
        this.taskRepo.deleteById(id);
        return "redirect:/listOfTasks";
    }
}
