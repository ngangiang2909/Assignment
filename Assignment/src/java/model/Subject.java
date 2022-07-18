/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class Subject {
    private int subid;
    private String subcode;
    private String subname;
    private Group group;
    private Student stu;
    private Lecturer lec;

    public Lecturer getLec() {
        return lec;
    }

    public void setLec(Lecturer lec) {
        this.lec = lec;
    }
    
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public int getSubid() {
        return subid;
    }

    public void setSubid(int subid) {
        this.subid = subid;
    }

    public String getSubcode() {
        return subcode;
    }

    public void setSubcode(String subcode) {
        this.subcode = subcode;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }
    
}
