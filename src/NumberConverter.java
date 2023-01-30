import java.util.ArrayList;
import java.util.HashMap;

public class NumberConverter {
    int[] digits;
    int number;
    int convertHexa;
    int otherBase;
    int base;
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
        convertHexa=Integer.parseInt(num);
        ArrayList<String> unit = new ArrayList<String>();
        unit.add("0");unit.add("1");
        unit.add("2");unit.add("3");unit.add("4");
        unit.add("5");unit.add("6");
        unit.add("7");unit.add("8");
        unit.add("9");unit.add("10");
        unit.add("A");unit.add("B");
        unit.add("C");unit.add("D");
        unit.add("E");unit.add("F");
        unit.add("G");
        unit.add("H");
        unit.add("I");
        unit.add("J");
        unit.add("K");
        unit.add("L");
        unit.add("M");
        unit.add("N");
        unit.add("O");
        unit.add("P");
        unit.add("Q");
        unit.add("R");
        unit.add("S");
        unit.add("T");
        unit.add("U");
        unit.add("V");
        unit.add("W");
        unit.add("X");
        unit.add("Y");
        unit.add("Z");
        unit.add("a");
        unit.add("b");
        unit.add("c");
        unit.add("d");
        unit.add("e");
        unit.add("f");
        unit.add("g");
        unit.add("h");
        unit.add("i");
        unit.add("j");
        unit.add("k");
        unit.add("l");
        unit.add("m");
        unit.add("n");
        unit.add("o");
        unit.add("p");
        unit.add("q");
        unit.add("r");
        unit.add("s");
        unit.add("t");
        unit.add("u");
        unit.add("v");
        unit.add("w");
        unit.add("x");
        unit.add("y");
        unit.add("z");
        unit.add("+");
        unit.add("/");
    for(int i=0;i<unit.size();i++){
        if(i>=10){
            if(Integer.parseInt(num)>=base){
                num=num;
            }
           num=unit.get(Integer.parseInt(num)+1);
           return num;
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
        return eachTen;
    }

    public String convertToBinary() {
        String binary = "";
        int remainder;
        if (base == 10) {
            int whole = number;
            for (int i = whole; i > 0; i = i / 2) {
                remainder = i % 2;
                if (remainder == 0) {
                    binary += "0";
                } else {
                    binary += "1";

                }
            }
            String[] reverse = new String[binary.length()];
            for (int i = 0; i <= binary.length() - 1; i++) {
                reverse[binary.length() - 1 - i] = binary.substring(i, i + 1);
            }
            String listToNum = "";
            for (int i = 0; i <= binary.length() - 1; i++) {
                listToNum += Integer.parseInt(reverse[i]);
            }
            return listToNum;
        } else if(base==16){
            int whole = number;
            for (int i = whole; i > 0; i = i / 2) {
                remainder = i % 2;
                if (remainder == 0) {
                    binary += "0";
                } else {
                    binary += "1";

                }
            }
            String[] reverse = new String[binary.length()];
            for (int i = 0; i <= binary.length() - 1; i++) {
                reverse[binary.length() - 1 - i] = binary.substring(i, i + 1);
            }
            String reverses = "";
            for (int i = 0; i <= binary.length() - 1; i++) {
                reverses += Integer.parseInt(reverse[i]);
            }
            return reverses;
        }else{
            int whole = convertToDecimal();
            for (int i = whole; i > 0; i = i / 2) {
                remainder = i % 2;
                if (remainder == 0) {
                    binary += "0";
                } else {
                    binary += "1";

                }
            }
            String[] reverse = new String[binary.length()];
            for (int i = 0; i <= binary.length() - 1; i++) {
                reverse[binary.length() - 1 - i] = binary.substring(i, i + 1);
            }
            String reverses = "";
            for (int i = 0; i <= binary.length() - 1; i++) {
                reverses += Integer.parseInt(reverse[i]);
            }
            return reverses;
        }
    }
    public String convertToOctal() {
        String octal = "";
        int num;
        if (base == 10) {
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
        boolean see=true;

        if (base == 8) {
            String numberAs = Integer.toString(numbers);
            if (Integer.toString(numbers).contains("8")||Integer.toString(numbers).contains("9")) {
                this.number = numbers++;
                return false;
            }else {
                return true;
            }
        }
        if(base==2){
            String[] stringList= new String[Integer.toString(numbers).length()];
            for (int i = 0; i <= Integer.toString(numbers).length() - 1; i++) {
                stringList[i] = Integer.toString(numbers).substring(i,i+1);
                if(stringList[i].equals("0")||stringList[i].equals("1")){
                        see=true;
                }else{
                    see=false;
                    return see;
                }
            }
        }
        return see;
    }
    public String convertToHexaDecimal() {
        String Hexa = "";
        String compare = "";
        int num;
        if (base == 10) {
            num = number;
        } else {
            num = convertToDecimal();}
        while (num / 16 > 0) {
            Hexa = num % 16 + Hexa;
            compare = num % 16 + Hexa;
            Hexa = convertHexAlphabet(Hexa);
            num /= 16;
        }
        if (!Hexa.equals(compare)) {
            Hexa = num % 16 + Hexa;
            return Hexa;
        } else {

            Hexa = num % 16 + Hexa;
            compare = num % 16 + compare;
            if(Integer.parseInt(compare)<=10) {
                return compare;
            }
            Hexa = convertHexAlphabet(Hexa);
            return Hexa;
        }
    }
    public String toAnyBase(int targetBase){
        String val=Integer.toString(number);
        int temp=Integer.parseInt(val);
        StringBuilder str= new StringBuilder();
        while(temp!=0){
            int tempValue=temp%targetBase;
            str.insert(0,tempValue);
            temp/=targetBase;
        }
        return str.toString();
    }
    public String displayConvertedNumber() {
        if (base == 8) {
            return "Binary Number: " + convertToBinary() + "\n" + "Decimal Number: " + convertToDecimal()+"\n"+"Hexadecimal number: "+convertToHexaDecimal();
        } else if (base == 2) {
            return "Octal Number: " + convertToOctal() + "\n" + "Decimal Number: " + convertToDecimal()+"\n"+"Hexadecimal number: "+convertToHexaDecimal()+"Desired base: "+otherBase+" "+toAnyBase(otherBase);
        } else if (base == 10) {
            return "Octal Number: " + convertToOctal() + "\n" + "Binary Number: " + convertToBinary()+"\n"+ "Hexadecimal number: "+convertToHexaDecimal()+"\n"+"Desired base: "+otherBase+" "+toAnyBase(otherBase);
        } else if (base==16) {
            return "Bullshit cause I didn't do it yet"+"\n"+"Binary Number: "+convertToBinary();
        } else {
            return "Base: "+base+" "+toAnyBase(base);
        }
    }

}
