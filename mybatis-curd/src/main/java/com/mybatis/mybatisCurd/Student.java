package com.mybatis.mybatisCurd;

/**
 * @author zhiyitec
 */
public class Student {

    private String stuId;
    private String stuName;
    private String stuBirth;
    public Student() {
    }

    public Student(String stuId, String stuName, String stuBirth) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuBirth = stuBirth;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuBirth() {
        return stuBirth;
    }

    public void setStuBirth(String stuBirth) {
        this.stuBirth = stuBirth;
    }
}
