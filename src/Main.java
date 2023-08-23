import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int checkHome = 0;
    static Menu menu = new Menu();
    static Scanner scanner = new Scanner(System.in);
    static ClassesManage classesManage = new ClassesManage();
    static StudentManage studentManage = new StudentManage();


    public static void main(String[] args) {

        while (checkHome != -1) {
            menu.getFunctionHome();
            checkHome = scanner.nextInt();
            switch (checkHome) {
                case 1:
                    funcitionStudent();
                    break;
                case 2:
                    funcitionClass();
                    break;
                case 8:

                    break;
                case 9:
                    checkHome = -1;
                    break;
            }
        }
    }


    public static void funcitionClass() {
        int checkClasses = 0;
        while (checkClasses != -1) {
            menu.getFuncitionClass();
            int choiceClasses = scanner.nextInt();
            scanner.nextLine();
            switch (choiceClasses) {
                case 1:
                    System.out.println("Danh sách classes:");
                    classesManage.displayClasses();
                    break;
                case 2:
                    String idClass, nameClass;
                    System.out.print("Nhập mã lớp: ");
                    idClass = scanner.nextLine();
                    System.out.print("Nhập tên class: ");
                    nameClass = scanner.nextLine();
                    classesManage.creatClasses(idClass, nameClass);
                    break;
                case 3:

                    System.out.print("Nhập mã lớp: ");
                    idClass = scanner.nextLine();
                    if(classesManage.checkIdClasses(idClass)) {
                        System.out.print("Nhập tên class: ");
                        nameClass = scanner.nextLine();
                        classesManage.updateClasses(idClass, nameClass);
                    } else {
                        System.out.println("Mã lớp " + idClass + " không tồn tại");
                    }
                    break;
                case 8:
                    checkClasses = -1;
                    break;
                case 9:
                    checkHome = -1;
                    checkClasses = -1;
                    break;
            }
        }
    }

    public static void funcitionStudent() {
        int checkStudent = 0;
        while (checkStudent != -1) {
            menu.getFuncitionStudent();
            int choiceStudent = scanner.nextInt();
            scanner.nextLine();
            switch (choiceStudent) {
                case 1:
                    studentManage.display();
                    break;
                case 2:
                    String nameSinhVien, idClasses, stringGender;
                    float avgPoint;
                    int age, gender;
                    System.out.print("Nhập tên Sinh viên ");
                    nameSinhVien = scanner.nextLine();
                    System.out.print("Nhập mã lớp ");
                    idClasses = scanner.nextLine();
                    System.out.print("Nhập điểm ");
                    avgPoint = scanner.nextFloat();
                    if(classesManage.checkIdClasses(idClasses)) {
                        System.out.print("Tuổi ");
                        age = scanner.nextInt();
                        scanner.nextLine();
                        while (true) {
                            System.out.print("Giới tính Nam/Nữ ");
                            stringGender = scanner.nextLine();
                            if (stringGender.equals("Nam")) {
                                gender = 1;
                                break;
                            } else if(stringGender.equals("Nữ")){
                                gender = 0;
                                break;
                            } else {
                                System.out.println("Bạn nhập sai giới tính");
                            }
                        }

                        studentManage.creatStudent(nameSinhVien, idClasses, age, gender, avgPoint);

                    } else {
                        System.out.println("Mã lớp " + idClasses + " không tồn tại");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sinh viên cần sửa: ");
                    int idSinhvien = scanner.nextInt();
                    scanner.nextLine();
                    if(studentManage.checkIdStudent(idSinhvien)) {
                        System.out.print("Nhập tên Sinh viên ");
                        nameSinhVien = scanner.nextLine();
                        System.out.print("Nhập mã lớp ");
                        idClasses = scanner.nextLine();
                        System.out.print("Tuổi ");
                        age = scanner.nextInt();
                        System.out.print("Nhập điểm ");
                        avgPoint = scanner.nextFloat();
                        scanner.nextLine();
                        while (true) {
                            System.out.print("Giới tính Nam/Nữ ");
                            stringGender = scanner.nextLine();
                            if (stringGender.equals("Nam")) {
                                gender = 1;
                                break;
                            } else if(stringGender.equals("Nữ")){
                                gender = 0;
                                break;
                            } else {
                                System.out.println("Bạn nhập sai giới tính");
                            }
                        }
                        studentManage.updateStudent(idSinhvien, nameSinhVien, idClasses, age, gender, avgPoint);
                    } else {
                        System.out.println("Sinh viên có mã " + idSinhvien + " không tồn tại");
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    idSinhvien = scanner.nextInt();
                    if(studentManage.checkIdStudent(idSinhvien)) {
                        studentManage.deleteStudent(idSinhvien);
                    } else {
                        System.out.println("Sinh viên có mã " + idSinhvien + " không tồn tại");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã sinh viên: ");
                    idSinhvien = scanner.nextInt();
                    studentManage.displayStudent(idSinhvien);
                    break;

                case 6:
                    studentManage.sortAvgPoint();
                    break;
                case 7:
                    studentManage.sortAge();
                case 8:
                    System.out.println("Nhập tìm kiếm");
                    String str = scanner.nextLine();
                    studentManage.searchStr(str);
                    break;
                case 9:
                    checkStudent = -1;
                    break;
                case 10:
//                    System.exit(0);
                    checkHome = -1;
                    checkStudent = -1;
                    break;
            }
        }
    }
}