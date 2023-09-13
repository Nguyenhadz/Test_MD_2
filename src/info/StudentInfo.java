package info;

import model.Student;
import service.ClassesManage;
import service.StudentManage;

import java.util.List;
import java.util.Scanner;

public class StudentInfo {
    Scanner scanner = new Scanner(System.in);
    ClassesManage classesManage = new ClassesManage();
    ClassesInfo classesInfo = new ClassesInfo();
    StudentManage studentManage = new StudentManage();

    public String inputCode() {
        System.out.print("Nhập mã Sinh viên: ");
        return scanner.nextLine();
    }
    public String inputName() {
        System.out.print("Nhập tên Sinh viên: ");
        return scanner.nextLine();
    }
    public float inputAvgPoint(){
        float avg = 0;
        do {
            System.out.print("Nhập điểm: ");
            String temp = scanner.nextLine();
            if (temp.isEmpty()){
                return -1;
            } else {
                try {
                    avg = Float.parseFloat(temp);
                    if(avg < 0 || avg > 10) {
                        System.out.println("Có lỗi phát sinh, nhập lại điểm không hợp lệ");
                        avg = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Có lỗi phát sinh, nhập lại điểm số");
                }
            }
        } while (avg == 0);
        return avg;
    }
    public int inputAge(){
        int age = 0;
        do {
            System.out.print("Nhập tuổi: ");
            String temp = scanner.nextLine();
            if (temp.isEmpty()){
                return -1;
            } else {
                try {
                    age = Integer.parseInt(temp);
                    if(age < 18 || age > 130) {
                        System.out.println("Có lỗi phát sinh, nhập lại tuổi không hợp lệ");
                        age = 0;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Có lỗi phát sinh, nhập lại tuổi");
                }
            }
        } while (age == 0);
        return age;
    }
    public String inputSearch() {
        String str;
        do {
            System.out.print("Nhập tìm kiếm: ");
            str = scanner.nextLine();
            if(str.isEmpty()) {
                System.out.println("Bạn chưa nhập gợi ý: ");
            }
        } while (str.isEmpty());
        return str;
    }

    public Student infoCreate() {
        Student student = new Student();
        do {
            student.setCode(inputCode());
            if(student.getCode().isEmpty()) {
                System.out.println("Bạn chưa nhập mã sinh viên");
                continue;
            }
            if(studentManage.existsByCode(student.getCode())){
                System.out.println("Mã sinh viên đã tồn tại");
            }
        } while (student.getCode().isEmpty() || studentManage.existsByCode(student.getCode()));

        do {
            student.setName(inputName());
            if(student.getName().isEmpty()) {
                System.out.println("Bạn chưa nhập tên sinh viên");
            }
        } while (student.getName().isEmpty());

        String codeClasses;
        do {
            codeClasses = classesInfo.inputCode();
            if(!classesManage.existsByCode(codeClasses)){
                System.out.println("Mã Classes không tồn tại");
            } else {
                student.setClasses(classesManage.getClassesByCode(codeClasses));
            }

        } while (!classesManage.existsByCode(codeClasses));

        do {
            student.setAvgPoint(inputAvgPoint());
            if(student.getAvgPoint() == -1){
                System.out.println("Bạn chưa nhập điểm, vui lòng nhập lại");
            }
        }while (student.getAvgPoint() == -1);

        do {
            student.setAge(inputAge());
            if(student.getAge() == -1){
                System.out.println("Bạn chưa nhập tuổi, vui lòng nhập lại");
            }
        }while (student.getAge() == -1);

        while (true) {
            System.out.print("Giới tính Nam/Nữ ");
            String stringGender = scanner.nextLine();
            if (stringGender.equals("Nam")) {
                student.setGender(1);
                break;
            } else if(stringGender.equals("Nữ")){
                student.setGender(0);
                break;
            } else {
                System.out.println("Bạn nhập sai giới tính");
            }
        }
        student.setStatus(1);
        return student;
    }
    public Student infoUpdate() {
        String code, name, codeClasses;
        float avgPoint;
        int age;
        do {
            code = inputCode();
            if(code.isEmpty()) {
                System.out.println("Bạn chưa nhập mã sinh viên");
                continue;
            }
            if(!studentManage.existsByCode(code)){
                System.out.println("Mã sinh viên không tồn tại");
            }
        } while (code.isEmpty() || !studentManage.existsByCode(code));
        Student student = studentManage.getStudentByCode(code);

        name = inputName();
        if(!name.isEmpty()) {
            student.setName(name);
        }

        codeClasses = classesInfo.inputCode();
        if(!codeClasses.isEmpty()) {
            student.setClasses(classesManage.getClassesByCode(codeClasses));
        }

        avgPoint = inputAvgPoint();
        if(avgPoint != -1) {
            student.setAvgPoint(avgPoint);
        }

        age = inputAge();
        if(age != -1) {
            student.setAge(age);
        }

        while (true) {
            System.out.print("Giới tính Nam/Nữ ");
            String stringGender = scanner.nextLine();
            if (stringGender.equals("Nam")) {
                student.setGender(1);
                break;
            } else if(stringGender.equals("Nữ")){
                student.setGender(0);
                break;
            } else if (stringGender.isEmpty()) {
                break;
            } else {
                System.out.println("Bạn nhập sai giới tính");
            }
        }
        return student;
    }
    public String infoDelete() {
        String code;
        do {
            System.out.print("Nhập mã Sinh viên: ");
            code = scanner.nextLine();
            if(!studentManage.existsByCodeAndStatus(code)){
                System.out.println("Mã Sinh viên không tồn tại");
            }
        } while (!studentManage.existsByCodeAndStatus(code));
        return code;
    }
    public void displayStudent(Student student) {
        System.out.printf("%-12s%-20s%-12s%-12s%-12s%s\n","Mã SV", "Tên SV", "Tuổi", "Giới tính", "Điểm TB", "Lớp");
        System.out.printf("%-12s%-20s%-12d%-12s%-12f%s\n", student.getCode(), student.getName(), student.getAge(), getStringGender(student.getGender()), student.getAvgPoint(), student.getClasses().getName());
    }
    public void displayListStudent(List<Student> students) {
        System.out.printf("%-12s%-20s%-12s%-12s%-12s%s\n","Mã SV", "Tên SV", "Tuổi", "Giới tính", "Điểm TB", "Lớp");
        for (Student item : students) {
            System.out.printf("%-12s%-20s%-12d%-12s%-12f%s\n", item.getCode(), item.getName(), item.getAge(), getStringGender(item.getGender()), item.getAvgPoint(), item.getClasses().getName());
        }
    }
    private String getStringGender(int gender) {
        if (gender == 1) {
            return "Nam";
        } else {
            return "Nữ";
        }
    }
}
