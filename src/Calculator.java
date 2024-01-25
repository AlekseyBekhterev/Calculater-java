import java.io.IOException;

public class Calculator {

    public static int calculate(int a, int b, String sing) throws IOException{
        if(a >= 1 && a <=10 && b >= 1 && b <=10) {

        } else {
            throw new IOException("строка не является математической операцией");
        }

        int result;
        switch (sing){
            case "\\+":
                result = a+b;
                break;
            case "-":
                result = a-b;
                break;
            case "/":
                result = a/b;
                break;
            case "\\*":
                result = a*b;
                break;
            default:
                throw new IllegalArgumentException("калькулятор считает цифры от 1 - 10 и заки +,-,/,*");

        }
        return result;
    }
}
