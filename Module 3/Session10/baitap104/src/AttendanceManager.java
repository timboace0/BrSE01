import java.util.ArrayList;
import java.util.List;

public class AttendanceManager implements IManage<Student> {
    private List<Student> studentList = new ArrayList<>();

    @Override
    public void add(Student item) {
        studentList.add(item);
    }

    @Override
    public void update(int index, Student item) {
        studentList.set(index, item);
    }

    @Override
    public void delete(int index) {
        studentList.remove(index);
    }

    @Override
    public void display() {
        for (Student student : studentList) {
            System.out.printf(student.toString());
        }
    }

    public int findIndexById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean isIdExist(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
