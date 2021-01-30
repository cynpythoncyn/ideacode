import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author chenyanan
 * @Date 2021/1/10
 */
@MySelfAnnotationFirst()
public class Annotation {


    @Override
    public String toString(){
        return "";
    }

    @SuppressWarnings(value = {"unchecked","all"})
    public static void test01(){
        List list = new ArrayList();
        List lista = new ArrayList();

    }
    @Deprecated
    public void test(){

    }

    public static void main(String[] args) {

        Date dates = new Date();
        dates.getDate();

        Annotation an = new Annotation();
        an.test();
    }



}
