package ru.ketbiev.course_manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "courses_students"
            , joinColumns = @JoinColumn(name = "students_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id")
    )
    private List<Course> courses;

    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "groups_id")
    private Group group;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "students"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "students_id")
    private List<Progress> progresses;

    public Student() {
    }

    public Student(String name, String surname, List<Course> courses, Group group, List<Progress> progresses) {
        this.name = name;
        this.surname = surname;
        this.courses = courses;
        this.group = group;
        this.progresses = progresses;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }
}
