package ru.cft.shift.repetito.entity;

import ru.cft.shift.repetito.params.request.UserParamsRequest;

import javax.persistence.*;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic") //вообще middle_name надо по идее
    private String patronymic;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "course")
    private int course;

    @Column(name = "degree")
    private String degree;

    @Column(name = "about")
    private String about;

    @Column(name = "teacher")
    private Boolean teacher;

    @Column(name = "price")
    private int price;

    @Column(name = "avg_mark")
    private int avgMark;

    @OneToOne(cascade = CascadeType.ALL)
    private TokenEntity token;

    public UserEntity(UserParamsRequest userParamsRequest){
        this.firstName = userParamsRequest.getFirstName();
        this.lastName = userParamsRequest.getLastName();
        this.patronymic = userParamsRequest.getParonym();
        this.faculty = userParamsRequest.getFaculty();
        this.course = userParamsRequest.getCourse();
        this.teacher =userParamsRequest.getTeacher();
        this.degree = userParamsRequest.getDegree();
        this.about = userParamsRequest.getAbout();
    }

    public UserEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String paronym) {
        this.patronymic = paronym;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Boolean getTeacher() {
        return teacher;
    }

    public void setTeacher(Boolean teacher) {
        this.teacher = teacher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(int avgMark) {
        this.avgMark = avgMark;
    }

    public TokenEntity getToken() {
        return token;
    }

    public void setToken(TokenEntity token) {
        this.token = token;
    }
}
