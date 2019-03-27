package PackageTest.Test;

import javax.swing.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TransformationTabToStr {
    private static final String pathInFile =
            "S:\\Home\\3 Курс\\Интеллектуальный анализ данных\\ЛР5-8\\ЛР7.8(доп. задние)\\program\\input.txt";
    private static final char[] ch = {'A', 'B', 'C', 'D', 'E',
                                        'F','G', 'H', 'I', 'J', 'K',
                                        'L', 'M', 'N', 'O', 'P',
                                        'Q', 'R', 'S', 'T', 'U',
                                        'V', 'W', 'X', 'Y', 'Z'};

    public static void main(String[] args) throws IOException {
        List<String> tab = readFile();
        transfTab(tab);
        System.out.println("End.");
    }

    public static List<String> readFile() throws IOException {
        Path file = Paths.get(pathInFile);
        List<String> list = Files.readAllLines(file, Charset.forName("cp1251"));
        return list;
    }

    public static void transfTab(List<String> list) {
        Iterator<String> it = list.iterator();
        String str = new String();
        int i = 0, k = 1;

        while (it.hasNext()) {
            str += it.next();
            if (!str.equals("")) {
                str = str.replace("\t", "");
                i++;
                if (i == 7) {
                    System.out.println(str);
                    str = "";
                    i = 0;
                    k++;
                }
            }
        }


    }
}
