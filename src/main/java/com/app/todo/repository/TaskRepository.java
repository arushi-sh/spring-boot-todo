package com.app.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.todo.models.Task;

//JpaRepository -> helps in interacting with the database and performing CRUD operations on the Task entity, Long -> type of the primary key of the Task entity
public interface TaskRepository extends JpaRepository<Task, Long> {

}
