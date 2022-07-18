/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author asus
 */
public class Lecturer {
    private int lid;
    private String lmember;
    private String lname;
    private boolean lgender;
    private Group group;
    private Subject sub;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSub() {
        return sub;
    }

    public void setSub(Subject sub) {
        this.sub = sub;
    }
    

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public String getLmember() {
        return lmember;
    }

    public void setLmember(String lmember) {
        this.lmember = lmember;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public boolean isLgender() {
        return lgender;
    }

    public void setLgender(boolean lgender) {
        this.lgender = lgender;
    }
    
}
