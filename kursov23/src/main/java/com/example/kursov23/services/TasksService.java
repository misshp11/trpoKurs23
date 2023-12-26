package com.example.kursov23.services;

import com.example.kursov23.models.Tasks;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TasksService {
    Tasks getTaskById(int id);
    List<Tasks> getAllTasks();
    void saveTasks(Tasks tasks);
    void deleteTasksById(int id);
}
