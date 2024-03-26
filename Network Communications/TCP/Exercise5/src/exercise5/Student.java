/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise5;

/**
 *
 * @author aimar
 */
import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private int age;
    private float distanceToCollege;

    public Student(String name, int age, float distanceToCollege) {
        this.name = name;
        this.age = age;
        this.distanceToCollege = distanceToCollege;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", distanceToCollege=" + distanceToCollege +
                '}';
    }
}
