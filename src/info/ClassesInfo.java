package info;

import model.Classes;
import model.Student;
import service.ClassesManage;

import java.util.List;
import java.util.Scanner;

public class ClassesInfo {
    Scanner scanner = new Scanner(System.in);
    ClassesManage classesManage = new ClassesManage();

    public String inputCode() {
        System.out.print("Nhập mã lớp: ");
        return scanner.nextLine();
    }

    public String inputName() {
        System.out.print("Nhập tên class: ");
        return scanner.nextLine();
    }

    public Classes infoCreate() {
        Classes classes = new Classes();
        do {
            classes.setCode(inputCode());
            if(classes.getCode().isEmpty()){
                System.out.println("Bạn chưa nhập mã lớp");
                continue;
            }
            if(classesManage.existsByCode(classes.getCode())){
                System.out.println("Mã Classes đã tồn tại");
            }
        } while (classes.getCode().isEmpty() || classesManage.existsByCode(classes.getCode()));

        do {
            classes.setName(inputName());
            if(classes.getName().isEmpty()){
                System.out.println("Bạn chưa nhập tên lớp");
            }
        }while (classes.getName().isEmpty());
        classes.setStatus(1);
        return classes;
    }

    public Classes infoUpdate() {
        String code, name;
        do {
            code = inputCode();
            if(!classesManage.existsByIdAndStatus(code)){
                System.out.println("Mã Classes không tồn tại");
            }
        } while (!classesManage.existsByIdAndStatus(code));

        Classes classes = classesManage.getClassesByCode(code);
        name = inputName();
        if (!name.isEmpty()) {
            classes.setName(name);
        }
        return classes;
    }

    public String infoDelete() {
        String idClass;
        do {
            System.out.print("Nhập mã lớp: ");
            idClass = scanner.nextLine();
            if(!classesManage.existsByIdAndStatus(idClass)){
                System.out.println("Mã Classes không tồn tại");
            }
        } while (!classesManage.existsByIdAndStatus(idClass));
        return idClass;
    }

    public void displayClasses(Classes classes){
        System.out.printf("%-12s%s\n","Mã lớp", "Tên lớp");
        System.out.printf("%-12s%s\n", classes.getCode(), classes.getName());
    }
    public void displayListClasses(List<Classes> listClasses){
        System.out.printf("%-12s%s\n","Mã lớp", "Tên lớp");
        for (Classes item : listClasses) {
            System.out.printf("%-12s%s\n", item.getCode(), item.getName());
        }
    }
}
