package multithreding.utils;

import java.util.Random;

public class Utils {

    private Utils(){}
    public static final Utils instance = new Utils();

    Random random = new Random();
    public String getRandomName(){

        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;


        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;

    }

    public int getNumber(int max){
        return random.nextInt(max + 1 - 1) + 1;
    }
}
