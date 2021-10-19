package com.mybatis.mybatisCurd;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisCrud {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
            session = factory.openSession();
            //do work
            //insert
//            Student student = new Student();
//            student.setStuId("4");
//            student.setStuName("曾吉鹏");
//            student.setStuBirth("1996-11-21");
//            session.insert("stuInsert",student);
            //update
//            Student student = new Student();
//            student.setStuId("4");
//            student.setStuName("陈宝山");
//            student.setStuBirth("1996-11-21");
//            session.update("stuUpdate",student);
            //selectOne
            Student student = session.selectOne("stuSelect","1");
            System.out.println(student.getStuName());
            //seectList
            //delete
            session.commit();
        } catch (Exception e) {
            if (session != null) {
                session.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
