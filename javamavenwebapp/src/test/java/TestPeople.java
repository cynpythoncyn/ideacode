import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.PeopleTest;

/**
 * @author chenyanan
 * @Date 2021/2/13
 */
public class TestPeople {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        PeopleTest po =  ac.getBean("peopleTest", PeopleTest.class);
        System.out.println(po);
    }
}
