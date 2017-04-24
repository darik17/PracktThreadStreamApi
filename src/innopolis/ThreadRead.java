package innopolis;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by admin on 24.04.2017.
 */
public class ThreadRead implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class);
    private String fileName;
    Integer sumF;

    public ThreadRead(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            sumF = 
        } catch (FileNotFoundException e) {
            LOGGER.error("Ошибка чтения");
        }

        LOGGER.info(getClass().toString());
    }
}
