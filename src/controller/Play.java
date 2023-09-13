package controller;

import info.ClassesInfo;
import info.StudentInfo;
import model.Classes;
import model.Student;
import service.ClassesManage;
import service.StudentManage;
import util.Menu;

import java.util.List;
import java.util.Scanner;

public class Play {
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();

    ClassesInfo classesInfo = new ClassesInfo();
    ClassesManage classesManage = new ClassesManage();
    StudentInfo studentInfo = new StudentInfo();
    StudentManage studentManage = new StudentManage();

    public void play() {
        int checkHome = 0;
        while (checkHome != -1) {
            menu.getFunctionHome();
            checkHome = Integer.parseInt(scanner.nextLine());
            switch (checkHome) {
                case 1:
                    functionStudent();
                    break;
                case 2:
                    functionClass();
                    break;
                case 9:
                    checkHome = -1;
                    break;
            }
        }
    }

    public void functionClass() {
        int choiceClasses;

        do {
            menu.getFuncitionClass();
            choiceClasses = Integer.parseInt(scanner.nextLine());

            switch (choiceClasses) {
                case 1:
                    System.out.println("Danh sách classes:");
                    displayAllClassesByStatus(1);
                    break;
                case 2:
                    creatClasses();
                    break;
                case 3:
                    if(classesManage.findAllByStatus(1).isEmpty()) {
                        System.out.println("Danh sách trống: ");
                        break;
                    } else {
                        updateClasses();
                        break;
                    }
                case 4:
                    if(classesManage.findAllByStatus(1).isEmpty()) {
                        System.out.println("Danh sách trống: ");
                        break;
                    } else {
                        deleteClasses();
                        break;
                    }
                case 9:
                    System.exit(0);
                    break;
            }
        } while (choiceClasses != 0);
    }

    public void functionStudent() {
        int choiceStudent = 0;

        do {
            menu.getFuncitionStudent();
            choiceStudent = Integer.parseInt(scanner.nextLine());
            switch (choiceStudent) {
                case 1:
                    displayAllStudentsByStatus(1);
                    break;
                case 2:
                    createStudent();
                    break;
                case 3:
                    if(studentManage.findAllByStatus(1).isEmpty()) {
                        System.out.println("Danh sách trống: ");
                        break;
                    } else {
                        updateStudent();
                        break;
                    }
                case 4:
                    if(studentManage.findAllByStatus(1).isEmpty()) {
                        System.out.println("Danh sách trống: ");
                        break;
                    } else {
                        deleteStudent();
                        break;
                    }
                case 5:
                    if(studentManage.findAllByStatus(1).isEmpty()) {
                        System.out.println("Danh sách trống: ");
                        break;
                    } else {
                        searchStudent();
                        break;
                    }
                case 6:
                    studentManage.sortAvgPoint();
                    break;
                case 7:
                    studentManage.sortAge();
                    break;
                case 8:
                    searchBySuggest();
                    break;
                case 9:
                    System.exit(0);
                    break;

            }
        } while (choiceStudent != 0);
    }

    private void creatClasses() {
        Classes classes = classesInfo.infoCreate();
        classesManage.creatClasses(classes);
    }
    private void updateClasses() {
        Classes classes = classesInfo.infoUpdate();
        classesManage.updateClasses(classes);
    }
    private void deleteClasses() {
        String idClass = classesInfo.infoDelete();
        classesManage.deleteClasses(idClass);
    }
    private void displayAllClasses(){
        List<Classes> classesList = classesManage.findAll();
        classesInfo.displayListClasses(classesList);
    }
    private void displayAllClassesByStatus(int status){
        List<Classes> classesList = classesManage.findAllByStatus(status);
        classesInfo.displayListClasses(classesList);
    }

    private void displayAllStudents() {
        List<Student> students = studentManage.findAll();
        studentInfo.displayListStudent(students);
    }

    private void displayAllStudentsByStatus(int status){
        List<Student> students = studentManage.findAllByStatus(status);
        studentInfo.displayListStudent(students);
    }

    private void createStudent() {
        Student student = studentInfo.infoCreate();
        studentManage.creatStudent(student);
    }

    private void updateStudent() {
        Student student = studentInfo.infoUpdate();
        studentManage.updateStudent(student);
    }

    private void deleteStudent() {
        String code = studentInfo.infoDelete();
        studentManage.deleteStudent(code);
    }

    private void searchStudent() {
        String code = studentInfo.inputCode();
        Student student = studentManage.searchStudent(code);
        if(student != null) {
            studentInfo.displayStudent(student);
        } else {
            System.out.println("Mã sinh viên không tồn tại");
        }
    }

    private void searchBySuggest() {
        String str = studentInfo.inputSearch();
        studentInfo.displayListStudent(studentManage.searchStr(str));
    }
    private String getStringGender(int gender) {
        if (gender == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
}
