package service;

import database.StudentDB;
import model.Classes;
import model.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManage {
    StudentDB studentDB = new StudentDB();

    public StudentManage() {}

    public List<Student> findAll() {
        return studentDB.findAll("Students.txt");
    }

    public List<Student> findAllByStatus(int status) {
        return studentDB.findAllByStatus(status, "Students.txt");
    }

    public void creatStudent(Student student) {
        student.setId(createNewId());
        studentDB.writeFile("Students.txt", student);
    }

    public void updateStudent(Student student) {
        List<Student> list = findAll();
        for (Student item : list) {
            if(item.getCode().equals(student.getCode())){
                item.setName(student.getName());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
                item.setAvgPoint(student.getAvgPoint());
                item.setClasses(student.getClasses());
                break;
            }
        }
        studentDB.writeFile("Students.txt", list);
    }

    public void deleteStudent(String code) {
        List<Student> list = findAll();
        for (Student item : list) {
            if(item.getCode().equals(code)) {
                item.setStatus(0);
                break;
            }
        }
        studentDB.writeFile("Students.txt", list);
    }

    public Student searchStudent(String code) {
        for (Student item : findAllByStatus(1)) {
            if(item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public void sortAvgPoint() {
        List<Student> list = findAll();
        list.sort(Comparator.comparing(Student::getAvgPoint));
        studentDB.writeFile("Students.txt", list);
    }

    public void sortAge() {
        List<Student> list = findAll();
        findAll().sort(Comparator.comparing(Student::getAge).reversed());
        studentDB.writeFile("Students.txt", list);
    }

    public List<Student> searchStr(String str) {
        List<Student> result = new ArrayList<>();
        for (Student item : findAllByStatus(1)) {
            if(item.getName().contains(str)) {
                result.add(item);
            }
        }
        return result;
    }

    public Student getStudentByCode(String code) {
        for (Student item : findAll()) {
            if(item.getCode().equals(code)) {
                return item;
            }
        }
        return new Student();
    }

    private int createNewId() {
        List<Student> list = findAll();
        if(list.isEmpty()) {
            return 1;
        } else {
            list.sort((o1, o2) -> o1.getId() - o2.getId());
            return list.get(list.size() - 1).getId() + 1;
        }
    }

    public boolean existsByCode(String code) {
        for (Student item : findAll()) {
            if(item.getCode().equals(code)) return true;
        }
        return false;
    }

    public boolean existsByCodeAndStatus(String code) {
        for (Student item : findAll()) {
            if(item.getCode().equals(code) && item.getStatus() == 1) return true;
        }
        return false;
    }

}
