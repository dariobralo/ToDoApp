package com.practica.todoapp.persistence.repository;

import com.practica.todoapp.persistence.entity.Task;
import com.practica.todoapp.persistence.entity.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
    
    public List<Task> findAllByTaskStatus(TaskStatus status);
    
    @Modifying
    @Query(value="UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
    
}
