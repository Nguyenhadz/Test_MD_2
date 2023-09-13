package database;

import model.Student;
import service.ClassesManage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    public List<Student> findAll(String filePath){
        List<Student> list = new ArrayList<>();
        try {
            File fileRead = new File("src/file/" + filePath);
            if(!fileRead.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                list.add(splitString(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File students không tồn tại");
        }
        return list;
    }

    public List<Student> findAllByStatus(int status, String filePath) {
        List<Student> result = new ArrayList<>();
        for (Student item : findAll(filePath)) {
            if(item.getStatus() == status){
                result.add(item);
            }
        }
        return result;
    }

    public void writeFile(String filePath, List<Student> list){
        try {
            FileWriter writer = new FileWriter("src/file/" + filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Student item : list) {
                bufferedWriter.write(item.getId() + ",");
                bufferedWriter.write(item.getCode() + ",");
                bufferedWriter.write(item.getName() + ",");
                bufferedWriter.write(item.getAge() + ",");
                bufferedWriter.write(item.getGender() + ",");
                bufferedWriter.write(item.getAvgPoint() + ",");
                bufferedWriter.write(item.getClasses().getId() + ",");
                bufferedWriter.write(item.getStatus() + "");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String filePath, Student student){
        try {
            FileWriter writer = new FileWriter("src/file/" + filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(student.getId() + ",");
            bufferedWriter.write(student.getCode() + ",");
            bufferedWriter.write(student.getName() + ",");
            bufferedWriter.write(student.getAge() + ",");
            bufferedWriter.write(student.getGender() + ",");
            bufferedWriter.write(student.getAvgPoint() + ",");
            bufferedWriter.write(student.getClasses().getId() + ",");
            bufferedWriter.write(student.getStatus() + "");
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student splitString(String str) {
        String[] arrStr = str.split(",");
        Student student = new Student();
        student.setId(Integer.parseInt(arrStr[0]));
        student.setCode(arrStr[1]);
        student.setName(arrStr[2]);
        student.setAge(Integer.parseInt(arrStr[3]));
        student.setGender(Integer.parseInt(arrStr[4]));
        student.setAvgPoint(Float.parseFloat(arrStr[5]));
        ClassesManage classesManage = new ClassesManage();
        student.setClasses(classesManage.getClassesById(Integer.parseInt(arrStr[6])));
        student.setStatus(Integer.parseInt(arrStr[7]));
        return student;
    }


}
