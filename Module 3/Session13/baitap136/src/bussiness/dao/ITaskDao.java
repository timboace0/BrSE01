package bussiness.dao;

import bussiness.model.Task;

import java.util.List;
import java.util.Map;

public interface ITaskDao {

    void addTask(String taskName, String status);

    List<Task> listTasks();

    void updateTaskStatus(int taskId, String status);

    void deleteTask(int taskId);

    List<Task> searchTaskByName(String taskName);

    Map<String, Integer> taskStatistics();
}