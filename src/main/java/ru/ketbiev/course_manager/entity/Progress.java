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

    public Progress() {
    }

    public Progress(int studentId, int taskId, boolean mark, int grade, String comment, Task task, Student student) {
        this.studentId = studentId;
        this.taskId = taskId;
        this.mark = mark;
        this.grade = grade;
        this.comment = comment;
        this.task = task;
        this.student = student;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public boolean isMark() {
        return mark;
    }

    public void setMark(boolean mark) {
        this.mark = mark;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
