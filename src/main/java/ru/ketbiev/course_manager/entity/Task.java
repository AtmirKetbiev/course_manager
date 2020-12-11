package ru.ketbiev.course_manager.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "softDeadline")
    private String softDeadline;

    @Column(name = "hardDeadline")
    private String hardDeadline;

    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "courses_id")
    private Course course;

    @OneToMany(cascade = CascadeType.ALL
            , mappedBy = "task"
            , fetch = FetchType.EAGER)
    @JoinColumn(name = "task_id")
    private List<Progress> progresses;
}
