package com.example.kursov23.services;

import com.example.kursov23.models.Tasks;
import com.example.kursov23.repositories.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksServiceImpl implements TasksService{

    @Autowired
    private TaskRepo taskRepo;

    @Override
    public Tasks getTaskById(int id) {
        Optional<Tasks> optional = taskRepo.findById(id);
        Tasks tasks = null;
        if (optional.isPresent()){
            tasks = optional.get();
        }else {
            throw  new RuntimeException("Person not Found for id ::" + id);
        }
        return tasks;
    }

    @Override
    public List<Tasks> getAllTasks() {
        return taskRepo.findAll();
    }

    @Override
    public void saveTasks(Tasks tasks) {
        this.taskRepo.save(tasks);
    }

    @Override
    public void deleteTasksById(int id) {
        this.taskRepo.deleteById(id);
    }
}
