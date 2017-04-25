package innopolis;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Необходимо разработать программу, которая получает на вход список ресурсов, содержащих набор
 * чисел и считает сумму всех положительных четных. Каждый ресурс должен быть обработан в отдельном
 * потоке, набор должен содержать лишь числа, унарный оператор "-" и пробелы. Общая сумма должна
 * отображаться на экране и изменяться в режиме реального времени.
 * Запуск потоков реализовать через ссылки на методы, итоговый подсчет суммы через stream API
 */
public class MainClass {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class);
    private static String path = "C:\\Users\\admin\\IdeaProjects\\Prackt Thread Stream Api\\src\\testFiles\\";
    static Collection<Integer> list = new CopyOnWriteArrayList<>();
    public static void main(String[] args) {
        LOGGER.info("Начало");
        Integer sum;
        File folder = new File("src/testFiles");
        String[] files = folder.list();

        for (int i = 0; i < files.length; i++) {
            final String nameFile = files[i];


            new Thread(
                    () -> readFile(nameFile)
            ).start();

        }

        //list.stream().reduce((s1,s2)->(s1+s2)).orElse(0);
        sum = list.stream().reduce((s1,s2)->s1+s2).orElse(0);
        System.out.println("Length: "+list.size());
        System.out.println("Summa:"+sum);
    }

    public static void readFile(String name) {


        try (BufferedReader reader = new BufferedReader(new FileReader(path + name));) {

            String tempStr = null;
            int tempInt = 0;
            while ((tempStr = reader.readLine()) != null) {
                String[] masStr = tempStr.split(" ");

                // int[] masChisel = new int[masStr.length];
                for (int i = 0; i < masStr.length; i++) {

                    if ((tempInt = Integer.parseInt(masStr[i])) > 0) {
                        list.add(tempInt);
                        System.out.println(tempInt);
                    }
                }
                LOGGER.info("!!!!");
            }
        } catch (FileNotFoundException e) {
            LOGGER.error("Ошибка чтения файла");
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения ");
        }



    }
}
