package innopolis;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by admin on 24.04.2017.
 */
public class MainClass {
    private static final Logger LOGGER = Logger.getLogger(MainClass.class);
    static int

    public static void main(String[] args) {
        LOGGER.info("Начало");
        File folder = new File("src/testFiles");
        String[] files = folder.list();

        for (int i = 0; i<files.length; i++){
            ThreadRead threadRead = new ThreadRead(files[i]);
            threadRead.run();
        }
    }
}
