public enum Roma {
    I("I",1),
    II("II",2),
    III("III",3),
    IV("IV",4),
    V("V",5),
    VI("VI",6),
    VII("VII",7),
    VIII("VIII", 8),
    IX("IX", 9),
    X("X", 10);

    private final int value;
    private final String name;

    Roma (String name , int value){
        this.value = value;
        this.name = name;
    }

    //переопределяю римские цифры в арабские
    public static int getValue(String c) {
        int result = 0;
        for (int i = 0; i < Roma.values().length; i++) {
            if(c.equals(Roma.values()[i].name)){
                result = Roma.values()[i].value;
            }
        }
        return result;
    };

    public static String convertToRoman (int value) throws IllegalArgumentException {
        String result = "";
        int hundreds;
        int tens;
        int ones;
/*/ у меня получилось число 10*10 = 100
в римском получается 100 = C
тысячи, сотни, десятки, еденицы
если мы берем число и дробим его 100/ на сотни - 100/100 = 0 без остатка значит это С

например 9*9 = 81
27/ 100 % 10 чтобы убавить до десятков = 0,27 = 0 сотен
27/10 % 10 чтобы убавить до едениц = 2.7 = 2 десятков и остаток 7
27 % 10 чтобы уйти ниже нуля = 7 остаток
/*/

        hundreds = (value / 100) % 10;
        switch (hundreds) {
            case 1:
            result = "C";
            break;
        }

        tens = (value / 10) % 10;
        switch (tens) {
            case 1:
                result = "X";
                break;
            case 2:
                result = "XX";
                break;
            case 3:
                result = "XXX";
                break;
            case 4:
                result = "XL";
                break;
            case 5:
                result = "L";
                break;
            case 6:
                result = "LX";
                break;
            case 7:
                result = "LXX";
                break;
            case 8:
                result = "LXXX";
                break;
            case 9:
                result = "XC";
                break;
        }

        ones = value % 10;
        switch (ones) {
            case 1:
                result += "I";
                break;
            case 2:
                result += "II";
                break;
            case 3:
                result += "III";
                break;
            case 4:
                result += "IV";
                break;
            case 5:
                result += "V";
                break;
            case 6:
                result += "VI";
                break;
            case 7:
                result += "VII";
                break;
            case 8:
                result += "VIII";
                break;
            case 9:
                result += "IX";
                break;
        }
        return result;
    }
}




