package bussiness.service;

import bussiness.dao.EmployeeProjectDaoImpl;
import bussiness.dao.IEmployeeProjectDao;

public class EmployeeProjectManager {

    private IEmployeeProjectDao employeeProjectDao =
            new EmployeeProjectDaoImpl();

    public void assignEmployeeToProject(int employeeId, int projectId) {
        employeeProjectDao.assignEmployeeToProject(employeeId, projectId);
    }
}