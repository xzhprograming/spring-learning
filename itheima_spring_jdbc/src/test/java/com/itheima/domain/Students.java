package com.itheima.domain;

/**
 * @author xing
 * @create 2021-05-12 21:47
 */
public class Students {
    private int id;
    private int class_id;
    private String name;
    private String gender;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
////
    public Students(){

    }

//    Failed to instantiate [com.itheima.domain.Students]: No default constructor found;

    public Students(int id, int class_id, String name, String gender, int score) {
        this.id = id;
        this.class_id = class_id;
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", score=" + score +
                '}';
    }
}
