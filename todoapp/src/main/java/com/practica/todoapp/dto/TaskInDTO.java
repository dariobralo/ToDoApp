package com.practica.todoapp.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta;
    
}
