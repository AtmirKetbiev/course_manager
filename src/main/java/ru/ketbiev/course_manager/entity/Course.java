package ru.ketbiev.course_manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "teachers_courses"
            , joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "teachers_id"))
    private List<Teacher> teachers;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "course"
            , fetch = FetchType.EAGER)
    //@JoinColumn(name = "courses_id")
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "courses_students"
            , joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "students_id"))
    private List<Student> students;

    public Course() {
    }

    public Course(String name, String description, List<Teacher> teachers, List<Task> tasks, List<Student> students) {
        this.name = name;
        this.description = description;
        this.teachers = teachers;
        this.tasks = tasks;
        this.students = students;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
