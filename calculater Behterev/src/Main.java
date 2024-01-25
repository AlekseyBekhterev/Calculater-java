import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String[] sings = {"+","-","/","*"};
        String[] regex = {"\\+", "-","/","\\*"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите выражение");
        String string = scanner.nextLine();

        int actionIndex = -1;

        // проверяем какой оператор стоит в выражении
        for(int i = 0; i<sings.length; i++){
            if(string.contains(sings[i])){
                actionIndex = i;
                break;
            }
        }
        // проверка на индекс он не должен быть -1 - означает что нет такого оператора
        if(actionIndex == -1){
            throw new IOException("строка не является математической операцией");
        }
        // делим строку по оператору
        String[] str = string.split(regex[actionIndex]);
        String var1 = str[0];
        String var2 = str[1];
        //если в строке более двух операторов то выбрасываем исключение
        if(str.length >2){
            throw new IOException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int a,b;
        // проверяем есть ли арабские цифры в строках
        if (Character.isDigit(var1.charAt(0)) && Character.isDigit(var2.charAt(0))) {
            try {
                a = Integer.parseInt(var1);
                b = Integer.parseInt(var2);

                System.out.println(Calculator.calculate(a, b , regex[actionIndex]) );

            } catch (NumberFormatException e) {
                System.err.println("Неверный формат строки!");
            }
        } else {
            a = Roma.getValue(var1);
            b = Roma.getValue(var2);
            int romeNumber = Calculator.calculate(a, b , regex[actionIndex]);
            if(romeNumber <= 0){
                throw new IOException("в римской системе нет отрицательных чисел");
            }
            String result = Roma.convertToRoman(romeNumber);
            System.out.println(result);
            }
    }
}
