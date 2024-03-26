/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise5;

/**
 *
 * @author aimar
 */
public class Student {
    private int id;
    private String name;
    private int age;
    private float distanceToCollege;

    public Student() {
    }

    public Student(int id, String name, int age, float distanceToCollege) {
        this.id = id;
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

    public float getDistanceToCollege() {
        return distanceToCollege;
    }

    public void setDistanceToCollege(float distanceToCollege) {
        this.distanceToCollege = distanceToCollege;
    }

    @Override
    public String toString() {
        return  id + "," + name + "," + age + "," + distanceToCollege;
    }
    
}
