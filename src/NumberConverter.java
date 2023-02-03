import java.util.ArrayList;

public class NumberConverter {
    int[] digits;
    int number;
    int otherBase;
    int base;
    boolean isCalled=false;
    public NumberConverter(int number, int base,int otherBase) {
        this.otherBase=otherBase;
        this.number = number;
        String numberAsString = Integer.toString(number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
        this.base = base;
    }
    public NumberConverter(String number, int base,int otherBase) {
        int length = number.length();
        this.otherBase=otherBase;
        this.base=base;
        int temp;
        for (int i=0;i<=length-1;i++) {
            if (isDigit(number.substring(i,i+1))){
                temp = Integer.parseInt(number.substring(i,i+1));
            }
            else{
                temp = Integer.parseInt( convertHexAlphabet(number.substring(i,i+1)));
            }
            this.number += (temp * Math.pow(16,(double)length- 1 - i));
        }
        String numberAsString = Integer.toString(this.number);
        digits = new int[numberAsString.length()];
        for (int i = 0; i < numberAsString.length(); i++) {
            String single = numberAsString.substring(i, i + 1);
            int d = Integer.parseInt(single);
            digits[i] = d;
        }
    }
    public static boolean isDigit(String input){
        return Character.isDigit(input.charAt(0));}

    public String displayOriginalNumber() {
        String o = "";
        for (int i = 0; i < digits.length; i++) {
            o = o + digits[i];
        }
        o = o + "\n";
        return o;
    }

    public int[] getDigits() {
        return digits;
    }
    public String convertHexAlphabet(String num) {
        ArrayList<String> unit = new ArrayList<>();
        unit.add("0");unit.add("1");unit.add("2");unit.add("3");unit.add("4");
        unit.add("5");unit.add("6");unit.add("7");unit.add("8");unit.add("9");
        unit.add("10");unit.add("A");unit.add("B");unit.add("C");unit.add("D");
        unit.add("E");unit.add("F");unit.add("G");unit.add("H");unit.add("I");
        unit.add("J");unit.add("K");unit.add("L");unit.add("M");unit.add("N");
        unit.add("O");unit.add("P");unit.add("Q");unit.add("R");unit.add("S");
        unit.add("T");unit.add("U");unit.add("V");unit.add("W");unit.add("X");
        unit.add("Y");unit.add("Z");unit.add("a");unit.add("b");unit.add("c");
        unit.add("d");unit.add("e");unit.add("f");unit.add("g");unit.add("h");
        unit.add("i");unit.add("j");unit.add("k");unit.add("l");unit.add("m");
        unit.add("n");unit.add("o");unit.add("p");unit.add("q");unit.add("r");
        unit.add("s");unit.add("t");unit.add("u");unit.add("v");unit.add("w");
        unit.add("x");unit.add("y");unit.add("z");unit.add("+");unit.add("/");
        for(int i=0;i<unit.size();i++){
            if (base == 16&&!isCalled)
            {num = num.toUpperCase();
                if (num.contains(unit.get(i))){
                    num = String.valueOf(unit.indexOf(unit.get(i))-1);
                    return num;
                }

            }
            else if(Integer.parseInt(num)<10){
                return num;
            }else {
                if (i >= 10) {
                    if (Integer.parseInt(num) >= base) {
                        num = num;
                    }
                    num = unit.get(Integer.parseInt(num) + 1);
                    return num;
                }
            }
        }
        return num;
    }

    public int convertToDecimal() {
        int eachTen = 0;
        int exponent = 0;
        if (base == 8) {
            for (int i = digits.length - 1; i > -1; i--) {
                eachTen += digits[i] * (int) Math.pow(8, exponent);
                exponent++;
            }
        }
        if (base == 2) {
            for (int i = digits.length - 1; i > -1; i--) {
                eachTen += digits[i] * (int) Math.pow(2, exponent);
                exponent++;
            }
        }
        if(base==16){
            return number;
        }
        return eachTen;
    }

    public String convertToBinary() {
        String binary;
        int remainder;
        StringBuilder binaryOrient= new StringBuilder();
        int whole;
        if (base == 10||base==16) {
            whole = number;
            for (int i = whole; i > 0; i = i / 2) {
                remainder = i % 2;
                if (remainder == 0) {
                    binary = "0";
                } else {
                    binary = "1";
                }
                binaryOrient.insert(0,binary);
            }
        } else{
            whole = convertToDecimal();
            for (int i = whole; i > 0; i = i / 2) {
                remainder = i % 2;
                if (remainder == 0) {
                    binary = "0";
                } else {
                    binary = "1";

                }
                binaryOrient.insert(0,binary);
            }
        }
        return binaryOrient.toString();
    }
    public String convertToOctal() {
        String octal = "";
        int num;
        if (base == 10||base==16) {
            num = number;
        } else {
            num = convertToDecimal();

        }
        while (num / 8 > 0) {
            octal = num % 8 + octal;
            num /= 8;
        }
        octal = num % 8 + octal;
        return octal;
    }
    public boolean restrict(int numbers, int base) {
        boolean see=false;

        if (base == 8) {
            return !Integer.toString(numbers).contains("8") && !Integer.toString(numbers).contains("9");
        }else if(base==2){
            String[] stringList= new String[Integer.toString(numbers).length()];
            for (int i = 0; i <= Integer.toString(numbers).length() - 1; i++) {
                stringList[i] = Integer.toString(numbers).substring(i,i+1);
                if(stringList[i].equals("0")||stringList[i].equals("1")){
                    see=true;
                }else{
                    return false;
                }
            }
        }else {
            see=true;
            }
        return see;
    }
    public boolean restrictHexa(String number){
    boolean pastAlpha=true;
        String temp;
        for(int i=0;i<number.length();i++){
            if(!isDigit(number.substring(i,i+1))){
                String element=number.substring(i,i+1);
                temp=element.toUpperCase();
                pastAlpha = temp.equals("A") || temp.equals("B") || temp.equals("C") || temp.equals("D") || temp.equals("E") || temp.equals("F");
            }
        }
        return pastAlpha;
    }
    public String convertToHexaDecimal() {
        int num;
        StringBuilder str= new StringBuilder();
        if(base==10||base==16){
            num=number;
        }else{
            num=convertToDecimal();
        }
        while(num>0){
            String Hex=Integer.toString(num%16);
            Hex=convertHexAlphabet(Hex);
            str.insert(0,Hex);
            num/=16;
        }
        return str.toString();
    }

    public String toAnyBase(int targetBase){
        int temp;
        if(base==10){
            temp=number;
        }else{
            temp=convertToDecimal();
        }
        StringBuilder str= new StringBuilder();
        while(temp!=0){
            String tempValue=Integer.toString(temp%targetBase);
            isCalled=true;
            tempValue=convertHexAlphabet(tempValue);
            str.insert(0,tempValue);
            temp/=targetBase;
        }
        return str.toString();
    }
    public String displayConvertedNumber() {
        if (base == 8) {
            return "Binary Number: " + convertToBinary() + "\n" + "Decimal Number: " + convertToDecimal() + "\n" + "Hexadecimal number: " + convertToHexaDecimal()+"\n" +"Base " + otherBase + " converted number: " + toAnyBase(otherBase);
        } else if (base == 2) {
            return "Octal Number: " + convertToOctal() + "\n" + "Decimal Number: " + convertToDecimal() + "\n" + "Hexadecimal number: " + convertToHexaDecimal() + "Base " + otherBase + " converted number: " + toAnyBase(otherBase);
        } else if (base == 10) {
            return "Octal Number: " + convertToOctal() + "\n" + "Binary Number: " + convertToBinary() + "\n" + "Hexadecimal number: " + convertToHexaDecimal() + "\n" + "Base " + otherBase + " converted number: " + toAnyBase(otherBase);
        } else if (base == 16) {
            return "\n" + "Binary Number: " + convertToBinary()+"\n"+"Octal Number: " + convertToOctal() + "\n" + "Decimal Number: " + convertToDecimal()+"\n"+"Base " + otherBase + " converted number: " + toAnyBase(otherBase) ;
        }
        return "Done";
    }
}