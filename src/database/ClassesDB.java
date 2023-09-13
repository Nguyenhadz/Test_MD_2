package database;

import model.Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClassesDB {
    public List<Classes> findAll(String filePath){
        List<Classes> list = new ArrayList<>();
        try {
            File fileRead = new File("src/file/" + filePath);
            if(!fileRead.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileRead));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                list.add(this.splitString(line));
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại");
        }
        return list;
    }

    public List<Classes> findAllByStatus(int status, String filePath) {
        List<Classes> result = new ArrayList<>();
        for (Classes item : findAll(filePath)) {
            if(item.getStatus() == status) {
                result.add(item);
            }
        }
        return result;
    }

    public void writeFile(String filePath, Classes classes) {
        try {
            FileWriter writer = new FileWriter("src/file/" + filePath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter(bufferedWriter, classes);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String filePath, List<Classes> listClasses){
        try {
            FileWriter writer = new FileWriter("src/file/" + filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (Classes item : listClasses) {
                bufferedWriter(bufferedWriter, item);
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Classes splitString(String str) {
        String[] arrStr = str.split(",");
        Classes classes = new Classes();
        classes.setId(Integer.parseInt(arrStr[0]));
        classes.setCode(arrStr[1]);
        classes.setName(arrStr[2]);
        classes.setStatus(Integer.parseInt(arrStr[3]));
        return classes;
    }
    private void bufferedWriter(BufferedWriter bufferedWriter, Classes classes)  throws IOException{
        bufferedWriter.write(classes.getId() + ",");
        bufferedWriter.write(classes.getCode() + ",");
        bufferedWriter.write(classes.getName() + ",");
        bufferedWriter.write(classes.getStatus() + "");
        bufferedWriter.newLine();
    }
}
