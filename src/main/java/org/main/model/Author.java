package org.main.model;

import java.io.Serializable;

public class Author implements Serializable {

    private Integer AuthorId;
    private String Name;
    private Integer Age;

    public Author() {
    }

    public Author(Integer authorId, String name, Integer age) {
        this.AuthorId = authorId;
        this.Name = name;

        this.Age = age;
    }

    public Integer getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Integer authorId) {
        this.AuthorId = authorId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        this.Age = age;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + AuthorId +
                ", name='" + Name + '\'' +
                ", age=" + Age +
                '}';
    }
}
