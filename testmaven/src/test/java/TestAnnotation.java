import com.pajk.Annotation.TbField;
import com.pajk.Annotation.TbTable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyanan
 * @Date 2021/1/10
 */
public class TestAnnotation {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.pajk.testchen.TbUser");
            Annotation[] aaaa = clazz.getAnnotations();
            for (Annotation annotation : clazz.getAnnotations()) {
                System.out.println(annotation);
            }

            TbTable annotation = (TbTable) clazz.getAnnotation(TbTable.class);
            System.out.println(annotation.value());

           Field f =  clazz.getDeclaredField("username");
           TbField tbField = f.getAnnotation(TbField.class);
           System.out.println(tbField.columnName()+" "+tbField.type()+" "+tbField.length());

        }catch(Exception e){
            e.printStackTrace();
        }


//        List<String> list = new ArrayList();
//        list.add("chen");
//        list.add("chen1");
//        list.add("chen2");
//        list.add("chen3");
//        list.add("");
//        for (String a:list){
//            System.out.println(a);
//        }
//        list.forEach(System.out::println);
//        System.out.println(list.stream().filter(x->list.isEmpty()).count());
    }
}
