package bussiness.service;

import bussiness.model.Subject;
import utils.InputData;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubjectManager<T extends Subject> {
    List<T> subjectList = new ArrayList<>();

    private int isIdExist(String id){
        for (int i = 0; i < subjectList.size(); i++) {
            if(subjectList.get(i).getCode().equals(id)){
                return i;
            }
        }
        return -1;
    }

    public void addSubject(Scanner scanner){
        String code = InputData.getString(scanner, "Nhập mã môn học: ");
        int index = isIdExist(code);
        if(index != -1){
            System.out.println("Mã môn học đã tồn tại!");
            return;
        }
        String name = InputData.getString(scanner, "Nhập tên môn học: ");

        int credits;
        while (true){
            try {
                credits = InputData.getInt(scanner, "Nhập số tín chỉ: ");
                if(credits < 0 || credits > 10){
                    throw new IllegalArgumentException("Số tín chỉ phải từ 0 đến 10");
                }
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }


        LocalDate date = InputData.getDate(scanner, "Nhập ngày bắt đầu dd/MM/yyyy: ");

        Subject subject = new Subject(code,name,credits,String.valueOf(date));
        subjectList.add((T) subject);
        System.out.println("Thêm môn học thành công!");
    }

    public void removeSubject(Scanner scanner){
        displaySubjects();
        String code = InputData.getString(scanner, "Nhập mã môn học cần xóa: ");
        int index = isIdExist(code);
        if(index == -1){
            System.out.println("Mã môn học không tồn tại!");
        } else {
            subjectList.remove(index);
            System.out.println("Xóa môn học thành công!");
        }
    }

    public void displaySubjects(){
        if(subjectList.isEmpty()){
            System.out.println("Chưa có môn học nào trong danh sách!");
        }
        for (int i = 0; i < subjectList.size(); i++) {
            System.out.println(subjectList.get(i));
        }
    }

    public void searchByName(Scanner scanner){
        boolean found = false;
        String name = InputData.getString(scanner, "Nhập tên môn học cần tìm kiếm: ");
        for (int i = 0; i < subjectList.size(); i++) {
            if(subjectList.get(i).getName().contains(name)){
                System.out.println(subjectList.get(i));
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy môn học!");
        }
    }

    public void filterByCredits(){
        boolean found = false;
        for (int i = 0; i < subjectList.size(); i++) {
            if(subjectList.get(i).getCredits() > 3){
                System.out.println(subjectList.get(i));
                found = true;
            }
        }
        if(!found){
            System.out.println("Không tìm thấy môn học có tín chỉ >3!");
        }
    }
}
