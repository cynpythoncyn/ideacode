import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author chenyanan
 * @Date 2021/1/10
 */
@Target(value = {METHOD,FIELD,TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MySelfAnnotationFirst {

    String  strudent() default " ";
    int age() default -1;

}
