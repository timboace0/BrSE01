package bussiness.service;

import bussiness.dao.ITaskDao;
import bussiness.dao.TaskDaoImpl;
import bussiness.model.Task;
import utils.InputData;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaskService {

    static ITaskDao iTaskDao = new TaskDaoImpl();

    public static void addTask(Scanner scanner) {
        String taskName = InputData.getString(
                scanner,
                "Mời nhập tên công việc: "
        );

        String status = InputData.getString(
                scanner,
                "Mời nhập trạng thái (PENDING/COMPLETED): "
        );

        if (!isValidStatus(status)) {
            System.out.println("Trạng thái không hợp lệ!");
            return;
        }

        iTaskDao.addTask(taskName, status.toUpperCase());

        System.out.println("Thêm công việc thành công!");
    }

    public static void listTasks() {
        List<Task> tasks = iTaskDao.listTasks();

        if (tasks.isEmpty()) {
            System.out.println("Danh sách công việc đang trống!");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public static void updateTaskStatus(Scanner scanner) {
        listTasks();

        int taskId = InputData.getInt(
                scanner,
                "Mời nhập ID công việc cần cập nhật: "
        );

        String status = InputData.getString(
                scanner,
                "Mời nhập trạng thái mới (PENDING/COMPLETED): "
        );

        if (!isValidStatus(status)) {
            System.out.println("Trạng thái không hợp lệ!");
            return;
        }

        List<Task> tasks = iTaskDao.listTasks();

        boolean found = false;

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy ID công việc!");
            return;
        }

        iTaskDao.updateTaskStatus(
                taskId,
                status.toUpperCase()
        );

        System.out.println("Cập nhật trạng thái thành công!");
    }

    public static void deleteTask(Scanner scanner) {
        listTasks();

        int taskId = InputData.getInt(
                scanner,
                "Mời nhập ID công việc cần xóa: "
        );

        List<Task> tasks = iTaskDao.listTasks();

        boolean found = false;

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy ID công việc!");
            return;
        }

        iTaskDao.deleteTask(taskId);

        System.out.println("Xóa công việc thành công!");
    }

    public static void searchTaskByName(Scanner scanner) {
        String taskName = InputData.getString(
                scanner,
                "Mời nhập tên công việc cần tìm: "
        );

        List<Task> tasks =
                iTaskDao.searchTaskByName(taskName);

        if (tasks.isEmpty()) {
            System.out.println("Không tìm thấy công việc!");
            return;
        }

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public static void taskStatistics() {
        Map<String, Integer> statistics =
                iTaskDao.taskStatistics();

        int completed =
                statistics.getOrDefault("COMPLETED", 0);

        int pending =
                statistics.getOrDefault("PENDING", 0);

        System.out.println("Đã hoàn thành: " + completed);
        System.out.println("Chưa hoàn thành: " + pending);
        System.out.println("Tổng số công việc: " + (completed + pending));
    }

    private static boolean isValidStatus(String status) {
        return status.equalsIgnoreCase("PENDING")
                || status.equalsIgnoreCase("COMPLETED");
    }
}