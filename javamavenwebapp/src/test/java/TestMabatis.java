import mapper.TbUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import pojo.TbUser;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


/**
 * @author chenyanan
 * @Date 2021/1/9
 */
public class TestMabatis {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(TestMabatis.class);
        logger.debug("print debug 日志");

        TestMabatis testMabatis = new TestMabatis();

        testMabatis.testQueryById();
        logger.debug("testmabatis.testQueryByid 执行");
//        testMabatis.testInsertUser();
//        testMabatis.testUpdateUser();
//        testMabatis.testselectAll();


    }
    private void testUpdateUser() throws IOException{

        //获取mybatis全局配置文件
        String resouces = "mybatis-conf.xml";
        InputStream in = Resources.getResourceAsStream(resouces);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            TbUserMapper personMapper = sqlSession.getMapper(TbUserMapper.class);//通过sqlSession得到mapper
            TbUser tbUser = new TbUser();
            tbUser.setId(46);
            tbUser.setUsername("chenyanan0030");
            tbUser.setPassword("pwd2");
            tbUser.setPhone("1580000");
            tbUser.setEmail("j8");
            tbUser.setCreated(Date.valueOf(LocalDate.now()));
            tbUser.setUpdated(Date.valueOf(LocalDate.now()));

            int index =  personMapper.updateUser(tbUser);//调用mapper的方法
            if (index >0){
                System.out.println("sucess!!!");
            }
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    private void testInsertUser() throws IOException{

        //获取mybatis全局配置文件
        String resouces = "mybatis-conf.xml";
        InputStream in = Resources.getResourceAsStream(resouces);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            TbUserMapper personMapper = sqlSession.getMapper(TbUserMapper.class);//通过sqlSession得到mapper
            TbUser tbUser = new TbUser();
            tbUser.setUsername("chenyanan0");
            tbUser.setPassword("pwd2");
            tbUser.setPhone("1582");
            tbUser.setEmail("jdjjdj2");
            tbUser.setCreated(Date.valueOf("2018-09-09"));
            tbUser.setUpdated(Date.valueOf("2018-09-09"));

            personMapper.insertUser(tbUser);//调用mapper的方法
            System.out.println("cheng");
            sqlSession.commit();

        } finally {
            sqlSession.close();
        }

    }

    private void testselectAll() throws IOException {

        //获取mybatis全局配置文件
        String resouces = "mybatis-conf.xml";
        InputStream in = Resources.getResourceAsStream(resouces);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            TbUserMapper personMapper = sqlSession.getMapper(TbUserMapper.class);//通过sqlSession得到mapper
            List<TbUser> persons = personMapper.selectAll();//调用mapper的方法
            //只读操作不需要sqlSession.commit()
            for(TbUser person:persons) {

                System.out.println(person);
            }
        } finally {
            sqlSession.close();
        }

    }

    private void testQueryById() throws IOException {

        //获取mybatis全局配置文件
        String resouces = "mybatis-conf.xml";
        InputStream in = Resources.getResourceAsStream(resouces);
        //读取配置文件的配置信息，利用SqlSessionFactoryBuilder创建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        //利用sqlSessionFactory打开与数据库的会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            TbUserMapper personMapper = sqlSession.getMapper(TbUserMapper.class);//通过sqlSession得到mapper
            TbUser person = personMapper.queryById(7);//调用mapper的方法
            //只读操作不需要sqlSession.commit()
            System.out.println(person);
        } finally {
            sqlSession.close();
        }

    }
}
