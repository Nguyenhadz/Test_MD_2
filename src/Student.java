public class Student{
    private int id;
    private String name;
    private int age;
    private int gender;
    private float avgPoint;

    private Classes classes;

    public Student() {}

    public Student(int id, String name, int age, int gender, float avgPoint, Classes classes) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.avgPoint = avgPoint;
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public float getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(float avgPoint) {
        this.avgPoint = avgPoint;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public void display() {
        System.out.println(id + "\t\t\t" + name + "\t\t\t" + age + "\t\t" + (gender == 1 ? "Nam" : "Nữ") + "\t\t\t\t" + avgPoint + "\t\t" + classes.getId());
    }
}
