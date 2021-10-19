import domain.Students;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) {
        String path = "mybaits-config.xml";
        InputStream inputStream = null;
        SqlSession session = null;
        try {
            inputStream = Resources.getResourceAsStream(path);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //开启事务
            session = sqlSessionFactory.openSession();
            //执行业务逻辑
            List<Students> students = session.selectList("getStudents");
            for(Students students1:students){
                System.out.println(students1.getSid()+","+students1.getSname()+","+students1.getSbirth());
            }
            //事务结束提交
            session.commit();
        } catch (IOException e) {
            //遇到异常后回滚
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
