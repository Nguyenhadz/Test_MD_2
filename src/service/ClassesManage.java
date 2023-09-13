package service;

import database.ClassesDB;
import model.Classes;

import java.util.List;

public class ClassesManage {
    ClassesDB classesDB = new ClassesDB();

    public List<Classes> findAll() {
        return classesDB.findAll("Classes.txt");
    }

    public List<Classes> findAllByStatus(int status) {
        return classesDB.findAllByStatus(status, "Classes.txt");
    }

    public void creatClasses(Classes classes) {
        classes.setId(createNewId());
        classesDB.writeFile("Classes.txt", classes);
    }

    public void updateClasses(Classes classes) {
        List<Classes> lstClasses = findAll();
        for (Classes item : lstClasses) {
            if(item.getCode().equals(classes.getCode())) {
                item.setName(classes.getName());
                break;
            }
        }
        classesDB.writeFile("Classes.txt", lstClasses);
    }
    public void deleteClasses(String code) {

        List<Classes> lstClasses = findAll();
        for (Classes item : lstClasses) {
            if (item.getCode().equals(code)) {
                item.setStatus(0);
                break;
            }
        }
        classesDB.writeFile("Classes.txt", lstClasses);
    }
    public boolean existsByCode(String code) {
        for (Classes item : findAll()) {
            if(item.getCode().equals(code)) return true;
        }
        return false;
    }
    public boolean existsByIdAndStatus(String code) {
        for (Classes item : findAll()) {
            if(item.getCode().equals(code) && item.getStatus() == 1) return true;
        }
        return false;
    }
//    public String getNameClassesById(String id) {
//        for (Classes item : this.list) {
//            if (item.getId().equals(id)){
//                return item.getName();
//            }
//        }
//        return "";
//    }
    public Classes getClassesByCode(String code){
        for (Classes item : findAll()) {
            if(item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
    public Classes getClassesById(int id){
        for (Classes item : findAll()) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    private int createNewId() {
        List<Classes> list = findAll();
        if(list.isEmpty()) {
            return 1;
        } else {
            list.sort((o1, o2) -> o1.getId() - o2.getId());
            return list.get(list.size() - 1).getId() + 1;
        }
    }
}
