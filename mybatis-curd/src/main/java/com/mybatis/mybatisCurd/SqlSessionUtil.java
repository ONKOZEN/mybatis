package com.mybatis.mybatisCurd;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author zhiyitec
 */
public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getCurrentSqlSession() {
        SqlSession session = local.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            local.set(session);
        }
        return session;
    }

    public static void close(SqlSession session) {
        if (session != null) {
            session.close();
            //非常重要
            local.remove();
        }
    }
/**
 *
 */
    public static void rollback(SqlSession session) {
        if (session != null) {
            session.rollback();
        }
    }
}
