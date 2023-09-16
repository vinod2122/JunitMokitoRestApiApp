package com.vinod.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vinod.model.Task;

@Service
public class TaskServiceImpl implements TaskService {

    private List<Task> tasks = new ArrayList<>();
    private long currentId = 1;

    @Override
    public List<Task> getAllTasks() {
        return tasks;
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> taskOptional = tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst();
        return taskOptional.orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        task.setId(currentId++);
        tasks.add(task);
        return task;
    }

//    @Override
//    public Task updateTask(Long id, Task task) {
//        Optional<Task> taskOptional = tasks.stream()
//                .filter(existingTask -> existingTask.getId().equals(id))
//                .findFirst();
//
//        if (taskOptional.isPresent()) {
//            Task existingTask = taskOptional.get();
//            existingTask.setName(task.getName());
//            return existingTask;
//        }
//        return null;
//    }
    public Task updateTask(Long id, Task task) {
        return tasks.stream()
                .filter(existingTask -> existingTask.getId().equals(id))
                .peek(existingTask -> existingTask.setName(task.getName()))
                .findFirst()
                .orElse(null);
    }


    @Override
    public void deleteTask(Long id) {
        tasks.removeIf(task -> task.getId().equals(id));
    }
}
