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
    @JoinTable(
            name = "teachers_courses"
            , joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "teachers_id")
    )
    private List<Teacher> teachers;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "course"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "courses_id")
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "courses_students"
            , joinColumns = @JoinColumn(name = "courses_id")
            , inverseJoinColumns = @JoinColumn(name = "students_id")
    )
    private List<Student> students;

}
