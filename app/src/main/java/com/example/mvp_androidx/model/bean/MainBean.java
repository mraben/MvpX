package com.example.mvp_androidx.model.bean;

/**
 * Description:
 */
public class MainBean {
    private String name;
    private String sec;
    private int age;

    public MainBean(String name, String sec, int age) {
        this.name = name;
        this.sec = sec;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "HomeBean{" +
                "name='" + name + '\'' +
                ", sec='" + sec + '\'' +
                ", age=" + age +
                '}';
    }
}
