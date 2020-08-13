package main.java.com.yaroslavshchur.user;

import java.util.Objects;

public class User {
    private String name;
    private int age;
    private String city;

    public User(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;

    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User " + getName() + " have " + getAge() + " years old. " + "City: " + getCity();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(city, user.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, city);
    }
}

