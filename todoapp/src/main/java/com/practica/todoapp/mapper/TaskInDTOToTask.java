package com.practica.todoapp.mapper;

import com.practica.todoapp.dto.TaskInDTO;
import com.practica.todoapp.persistence.entity.Task;
import com.practica.todoapp.persistence.entity.TaskStatus;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
    
}
