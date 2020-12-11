package ru.ketbiev.course_manager.entity;

import javax.persistence.*;

@Entity
@Table(name = "progresses")
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "students_id")
    private int studentId;

    @Column(name = "tasks_id")
    private int taskId;

    @Column(name = "mark")
    private boolean mark;

    @Column(name = "grade")
    private int grade;

    @Column(name = "id")
    private String comment;

    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "tasks_id")
    private Task task;

    @ManyToOne(cascade =  {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "students_id")
    private Student student;
}
