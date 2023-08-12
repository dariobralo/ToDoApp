package com.practica.todoapp.service;

import com.practica.todoapp.dto.TaskInDTO;
import com.practica.todoapp.exceptions.ToDoExceptions;
import com.practica.todoapp.mapper.TaskInDTOToTask;
import com.practica.todoapp.persistence.entity.Task;
import com.practica.todoapp.persistence.entity.TaskStatus;
import com.practica.todoapp.persistence.repository.TaskRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {
    
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;
    
    public TaskServiceImpl(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    @Override
    public List<Task> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    @Override
    public void updateTaskAsFinished(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        
        this.repository.markTaskAsFinished(id);
    }

    @Override
    public void deleteTask(Long id) {
        Optional<Task> optionalTask = this.repository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new ToDoExceptions("Task not found",HttpStatus.NOT_FOUND);
        }
        this.repository.deleteById(id);
    }
    
    
    
}
