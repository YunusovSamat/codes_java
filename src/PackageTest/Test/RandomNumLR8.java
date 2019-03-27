package PackageTest.Test;

public class RandomNumLR8 {
    public static void main(String[] args) {
        String strNum = new String();
        byte num = 0;

        for (int i = 1; i < 1000; i++) {
            num = ((byte)(Math.random() * 10));
            strNum += String.valueOf(num);
            if (i % 20 == 0) {
                strNum += "\n";
            } else strNum += "\t";
        }
        num = ((byte)(Math.random() * 10));
        strNum += String.valueOf(num);
        System.out.println(strNum);
    }
}
