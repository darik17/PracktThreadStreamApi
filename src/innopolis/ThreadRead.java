package innopolis;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by admin on 24.04.2017.
 */
public class ThreadRead implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class);
    private String path = "C:\\Users\\admin\\IdeaProjects\\Prackt Thread Stream Api\\src\\testFiles\\";
    private String fileName;
    Integer sumF;

    public ThreadRead(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path+fileName));){

            String temp = null;
            while ((temp=reader.readLine())!=null) {
                String[] mas =temp.split(" ");
            }
        } catch (FileNotFoundException  e) {
            LOGGER.error("Ошибка чтения файла");
        } catch (IOException e) {
            LOGGER.error("Ошибка чтения ");
        }

        LOGGER.info(getClass().toString());
    }
}
