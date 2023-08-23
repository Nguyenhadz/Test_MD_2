public class Classes {
    private String id;
    private String name;

    public Classes() {
    }

    public Classes(String id) {
        this.id = id;
    }

    public Classes(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayClasses() {
        System.out.println(this.id + " \t\t\t" +  this.name);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
