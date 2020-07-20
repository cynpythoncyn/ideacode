import java.math.BigDecimal;


public class TestFloatType {
    public static void main(String[] args){
        float a = 3.14F;
        double b = 6.28;
        double c = 628E-2;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println("################################");
        BigDecimal chen = BigDecimal.valueOf(1.0);
        chen = chen.subtract(BigDecimal.valueOf(0.1));
        chen = chen.subtract(BigDecimal.valueOf(0.1));
        chen = chen.subtract(BigDecimal.valueOf(0.1));
        chen = chen.subtract(BigDecimal.valueOf(0.1));
        System.out.println(chen);
        System.out.println(1.0-0.1-0.1-0.1-0.1);
    }

}
