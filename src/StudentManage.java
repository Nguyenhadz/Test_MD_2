import java.util.ArrayList;
import java.util.Comparator;

public class StudentManage {
    private ArrayList<Student> listStudent = new ArrayList<>();

    public StudentManage() {}

    public ArrayList<Student> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<Student> listStudent) {
        this.listStudent = listStudent;
    }


    public void creatStudent(String name, String idClasses, int age, int gender, float avgPoint) {
        int id;
        if(listStudent.isEmpty()) {
            id = 1;
        } else {
            id = listStudent.get(listStudent.size() - 1).getId() + 1;
        }
        Student student = new Student(id, name, age, gender, avgPoint, new Classes(idClasses));
        this.listStudent.add(student);
    }

    public boolean checkIdStudent(int id) {
        for (Student item : listStudent) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void updateStudent(int id, String name, String idClasses, int age, int gender, float avgPoint) {
        for (Student item : listStudent) {
            if(item.getId() == id) {
                item.setName(name);
                item.setClasses(new Classes(idClasses));
                item.setAge(age);
                item.setGender(gender);
                item.setAvgPoint(avgPoint);
            }
        }
    }

    public void deleteStudent(int id) {
        for (Student item : listStudent) {
            if(item.getId() == id) {
                listStudent.remove(item);
            }
        }
    }

    public void display() {
        System.out.println("Mã SV" + "\t\t" + "Tên" + "\t\t\t" + "Tuổi" + "\t" + "Giới tính" + "\t\t" + "Điểm" + "\t\t" + "Lớp");
        for (Student item : listStudent) {
            item.display();
        }

    }

    public void displayStudent(int id) {
        System.out.println("Mã SV" + "\t\t" + "Tên" + "\t\t\t" + "Tuổi" + "\t" + "Giới tính" + "\t\t\t" + "Lớp");
        for (Student item : listStudent) {
            if(item.getId() == id){
                item.display();
            }
        }
    }

    public void sortAvgPoint() {
        listStudent.sort(Comparator.comparing(Student::getAvgPoint));
    }

    public void sortAge() {
        listStudent.sort(Comparator.comparing(Student::getAge).reversed());
    }

    public void searchStr(String str) {
        ArrayList<Student> result = new ArrayList<>();
        for (Student item : listStudent) {
            if(item.getName().indexOf(str) != -1) {
                result.add(item);
            }
        }

        for (Student item : result) {
            item.display();
        }
    }
}
