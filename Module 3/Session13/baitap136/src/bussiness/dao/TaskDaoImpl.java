package bussiness.dao;

import bussiness.model.Task;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskDaoImpl implements ITaskDao {

    @Override
    public void addTask(String taskName, String status) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL add_task(?,?)}");

            call.setString(1, taskName);
            call.setString(2, status);

            call.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Task> listTasks() {
        List<Task> tasks = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL list_tasks()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("task_name"),
                        rs.getString("status")
                );

                tasks.add(task);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return tasks;
    }

    @Override
    public void updateTaskStatus(int taskId, String status) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL update_task_status(?,?)}");

            call.setInt(1, taskId);
            call.setString(2, status);

            call.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteTask(int taskId) {
        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL delete_task(?)}");

            call.setInt(1, taskId);

            call.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }
    }

    @Override
    public List<Task> searchTaskByName(String taskName) {
        List<Task> tasks = new ArrayList<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL search_task_by_name(?)}");

            call.setString(1, taskName);

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                Task task = new Task(
                        rs.getInt("id"),
                        rs.getString("task_name"),
                        rs.getString("status")
                );

                tasks.add(task);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return tasks;
    }

    @Override
    public Map<String, Integer> taskStatistics() {
        Map<String, Integer> statistics = new HashMap<>();

        Connection conn = ConnectionDB.openConnection();

        try {
            CallableStatement call =
                    conn.prepareCall("{CALL task_statistics()}");

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                statistics.put(
                        rs.getString("status"),
                        rs.getInt("total")
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn);
        }

        return statistics;
    }
}