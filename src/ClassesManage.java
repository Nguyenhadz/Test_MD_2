import java.util.ArrayList;

public class ClassesManage {
    ArrayList<Classes> listClasses = new ArrayList<>();

    public ArrayList<Classes> getListClasses() {
        return listClasses;
    }

    public void setListClasses(ArrayList<Classes> listClasses) {
        this.listClasses = listClasses;
    }

    public void addClasses(Classes classes) {
        this.listClasses.add(classes);
    }


    public void creatClasses(String idClass, String nameClass) {
        Classes classes = new Classes(idClass, nameClass);
        this.listClasses.add(classes);
    }

    public void displayClasses() {
        System.out.println("Mã lớp" + "\t\t\t" +  "Tên lớp");
        for (Classes item : this.listClasses) {
            item.displayClasses();
        }
    }

    public void updateClasses(String idClass, String nameClass) {
        for (Classes item : this.listClasses) {
            if(item.getId().equals(idClass)) {
                item.setName(nameClass);
            }
        }
    }
    public boolean checkIdClasses(String idClass) {
        for (Classes item : this.listClasses) {
            if(item.getId().equals(idClass)) return true;
        }
        return false;
    }

    public String getNameClassesById(String id) {
        for (Classes item : this.listClasses) {
            if (item.getId().equals(id)){
                return item.getName();
            }
        }
        return "";
    }
}
