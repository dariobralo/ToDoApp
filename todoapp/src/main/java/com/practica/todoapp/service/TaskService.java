package com.practica.todoapp.service;

import com.practica.todoapp.dto.TaskInDTO;
import com.practica.todoapp.persistence.entity.Task;
import com.practica.todoapp.persistence.entity.TaskStatus;
import java.util.List;


public interface TaskService {

    public Task createTask(TaskInDTO taskInDTO);
    public List<Task> findAll();
    public List<Task> findAllByTaskStatus(TaskStatus status);
    public void updateTaskAsFinished(Long id);
    public void deleteTask(Long id);
    
}
