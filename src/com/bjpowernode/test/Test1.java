package com.bjpowernode.test;

import com.bjpowernode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        //输入流
        InputStream inputStream = null;
        try {
            //通过加载mybatis的主配置文件mybatis-config.xml，创建输入流对象
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*SqlSessionFactoryBuilder:SqlSessionFactory的建造者
        创建出SqlSessionFactory对象
        SqlSessionFactory对象唯一的作用就是为我们创建SqlSession对象*/
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //我们未来所有的操作，使用的都是SqlSession对象Session来完成
        //例如增删改查，处理事务等，都是统一用Session对象去完成
        SqlSession session=sqlSessionFactory.openSession();
        /*需求1：根据id查单条
            如果取得的是单条记录，我们调用selectOne方法
            参数1：根据命名空间.sqlId的形式找到我们需要使用的sql语句
            参数2：我们要为sql语句中的传递的参数


        Student s = session.selectOne("test1.getById","A0001");
        System.out.println(s);
        session.close();//关闭会话//

         */

        /*需求1：查询所有记录

        */
        /*
        List<Student>slist=session.selectList("test1.getAll");
        for(Student s:slist){
            System.out.println(s);
        }

         */
        /*需求2：添加操作
            mybatis默认情况下是手动提交事务
            提交事务，数据库表才会真正发生变化
         */
        /*Student s=new Student();
        s.setId("A0006");
        s.setName("cxk");
        s.setAge(23);
        session.insert("test1.save",s);
        session.commit();
        session.close();*/

         /*需求3：修改操作
            mybatis默认情况下是手动提交事务
            提交事务，数据库表才会真正发生变化
         */
        /*Student s=new Student();
        s.setId("A0005");
        s.setName("lyf1");
        s.setAge(23);
        session.insert("test1.update",s);
        session.commit();
        session.close();*/

        /*需求4：删除操作
            mybatis默认情况下是手动提交事务
            提交事务，数据库表才会真正发生变化
         */
        session.delete("test1.delete","A0006");
        session.commit();
        session.close();
    }
}
