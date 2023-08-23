import java.util.ArrayList;

public class Menu {
    ClassesManage classesManage;


    public void getFunctionHome() {
        System.out.println("Menu: Quản lý trung tâm giáo dục");
        System.out.println("1: Quản lý Sinh viên");
        System.out.println("2: Quản lý Classes");
        System.out.println("9: Thoát");
    }
    public void getFuncitionClass() {
        System.out.println("Menu: Quản lý Class");
        System.out.println("1: Danh sách class");
        System.out.println("2: Thêm class mới");
        System.out.println("3: Sửa class");
        System.out.println("8: Home");
        System.out.println("9: Thoát");
    }
    public void getFuncitionStudent() {
        System.out.println("Menu: Quản lý Student");
        System.out.println("1: Danh sách Sinh viên");
        System.out.println("2: Thêm Sinh Viên");
        System.out.println("3: Sửa Sinh Viên");
        System.out.println("4: Xóa Sinh Viên");
        System.out.println("5: Tìm Sinh Viên");
        System.out.println("6: Sắp xếp Sinh Viên theo điểm tăng dần");
        System.out.println("7: Sắp xếp Sinh Viên theo tuổi giảm dần");
        System.out.println("8: Tìm kiếm theo gợi ý");

        System.out.println("9: Home");
        System.out.println("10: Thoát");
    }
}
