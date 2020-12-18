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
    //@JoinColumn(name = "tasks_id")
    private List<Progress> progresses;

    public Task() {
    }

    public Task(String name, String description, String softDeadline, String hardDeadline, Course course) {
        this.name = name;
        this.description = description;
        this.softDeadline = softDeadline;
        this.hardDeadline = hardDeadline;
        this.course = course;
        //this.progresses = progresses;
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

    public String getSoftDeadline() {
        return softDeadline;
    }

    public void setSoftDeadline(String softDeadline) {
        this.softDeadline = softDeadline;
    }

    public String getHardDeadline() {
        return hardDeadline;
    }

    public void setHardDeadline(String hardDeadline) {
        this.hardDeadline = hardDeadline;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Progress> getProgresses() {
        return progresses;
    }

    public void setProgresses(List<Progress> progresses) {
        this.progresses = progresses;
    }
}
