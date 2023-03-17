package Basics;

public class Lesson {
private String name;
private String description;

    @Override
    public String toString() {
        return "Basics.Lesson{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lesson(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
