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

}
