package com.vinod;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.vinod.model.Task;
import com.vinod.service.TaskServiceImpl;


class JunitAppTest {

	@InjectMocks
    private TaskServiceImpl taskService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTask() {
        Task task = new Task(null, "Sample Task");
        Task createdTask = taskService.createTask(task);

        assertNotNull(createdTask.getId());
        assertEquals("Sample Task", createdTask.getName());
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task(null, "Sample Task");
        Task createdTask = taskService.createTask(task);

        Task updatedTask = new Task(createdTask.getId(), "Updated Task");
        Task result = taskService.updateTask(createdTask.getId(), updatedTask);

        assertNotNull(result);
        assertEquals("Updated Task", result.getName());
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = taskService.getAllTasks();

        assertNotNull(tasks);
        assertEquals(0, tasks.size());
    }

    @Test
    public void testGetTaskById() {
        Task task = new Task(null, "Sample Task");
        Task createdTask = taskService.createTask(task);

        Task result = taskService.getTaskById(createdTask.getId());

        assertNotNull(result);
        assertEquals(createdTask.getId(), result.getId());
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task(null, "Sample Task");
        Task createdTask = taskService.createTask(task);

        taskService.deleteTask(createdTask.getId());
        List<Task> tasks = taskService.getAllTasks();

        assertNull(taskService.getTaskById(createdTask.getId()));
        assertEquals(0, tasks.size());
    }
}
