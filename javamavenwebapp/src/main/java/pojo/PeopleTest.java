package pojo;

/**
 * @author chenyanan
 * @Date 2021/2/13
 */
public class PeopleTest {

    private String name;
    private int age;

    public PeopleTest() {
        super();
        System.out.println("执行了构造方法！！！");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
