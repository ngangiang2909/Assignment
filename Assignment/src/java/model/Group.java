/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class Group {
    private int gid;
    private String gname;
    private ArrayList<Student> stu = new ArrayList<>();
    private Subject sub;
    private Lecturer lecture;

    public Lecturer getLecture() {
        return lecture;
    }

    public void setLecture(Lecturer lecture) {
        this.lecture = lecture;
    }
    

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public ArrayList<Student> getStu() {
        return stu;
    }

    public void setStu(ArrayList<Student> stu) {
        this.stu = stu;
    }
    
}
