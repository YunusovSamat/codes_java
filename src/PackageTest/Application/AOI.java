package PackageTest.Application;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AOI {
    private static String pathReadFile = "S:\\automation of inventory\\readFile.txt";
    private static String pathWriteFile = "S:\\automation of inventory\\writeFile.txt";

    public static void main(String[] args) throws IOException {
        List<String> list = readFile();
        ArrayList<String> arrNew = reformText(list);
        writeFile(arrNew);

        JOptionPane.showMessageDialog(null, "Преобразование завершено",
                "AOI", JOptionPane.INFORMATION_MESSAGE);
    }


    public static List<String> readFile() throws IOException {
        Path file = Paths.get(pathReadFile);
        List<String> list = Files.readAllLines(file, Charset.forName("cp1251"));
        return list;
    }


    public static ArrayList<String> reformText(List<String> list) {
        Iterator<String> it = list.iterator();

        String s = it.next();
        String[] arrConst = s.split("\t");
        int num = Integer.parseInt(arrConst[0]);

        String prefixDoc, yearDoc, str1, str2, str3, str4;
        prefixDoc = arrConst[1];
        yearDoc = arrConst[2];
        str1 = arrConst[3];
        str2 = arrConst[4];
        str3 = arrConst[5];
        str4 = arrConst[6];

        int count = 0;
        String sNew;
        String[] arr;
        ArrayList<String> arrNew = new ArrayList<>(65);

        while (it.hasNext()) {
            s = it.next();
            arr = s.split("\t");

            sNew = Integer.toString(num) + "\t";
            sNew += prefixDoc + "-" + arr[0] + "-" + yearDoc + "\t";
            sNew += str1 + " " + arr[1] + " " + str2 + " " + arr[2] + " ч." +
                    arr[3] + " КоАП РФ.\t";
            sNew += arrConst[1] + "\t";
            sNew += arrConst[2];

            arrNew.add(sNew);

            num++;
            count++;
        }

        arrNew.add("Итог: " + count);
        return arrNew;
    }


    public static void writeFile(ArrayList<String> arrNew) throws IOException {
        Path file = Paths.get(pathWriteFile);
        Files.write(file, arrNew);
    }
}

