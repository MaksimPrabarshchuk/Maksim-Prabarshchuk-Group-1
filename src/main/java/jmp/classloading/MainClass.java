package jmp.classloading;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class MainClass {

    private static final Logger LOG = Logger.getLogger("MainClass");
    private static final String USER_DIRECTORY = "user.dir";
    private static final String DEFAULT_JAR_FOLDER = "/jar";

    public static void main(String[] args) {
        try {
            for (;;) {
                List<Path> files = listFilesFromDirectory();
                renderMenu(files);

                Scanner scanner = new Scanner(System.in);
                int itemNumber = scanner.nextInt();
                if (itemNumber == files.size()) {
                    System.exit(0);
                }
                loadClassFromJar(files.get(itemNumber));
            }
        } catch (Exception e) {
            LOG.error(e.getStackTrace());
        }
    }

    protected static void renderMenu(List<Path> files) {
        System.out.println("--------------------------");
        int[] index = { 0 };
        files.forEach(x -> System.out.println("[" + index[0]++ +"] - " + x.getFileName()));
        System.out.println("[" + index[0] + "] - Exit");
        System.out.println("--------------------------");
        System.out.print("Please enter item number: ");
    }

    protected static List<Path> listFilesFromDirectory() {
        List<Path> files = new ArrayList<>();
        String workingDir = System.getProperty(USER_DIRECTORY);
        Path path = Paths.get(workingDir + DEFAULT_JAR_FOLDER);
        DirectoryStream<Path> stream;
        try {
            stream = Files.newDirectoryStream(path);
            for (Path entry : stream) {
                files.add(entry);
            }
        } catch (IOException e) {
            LOG.error(e.getStackTrace());
        }
        return files;
    }

    protected static void loadClassFromJar(Path path) {
        if (path == null) {
            LOG.error("File path is null");
            return;
        }
        try {
            JarClassLoader jarClassLoader = new JarClassLoader(path.toString());
            Class objectClass = jarClassLoader.loadClass("jmp.classloading.DefaultMessagePrinter");
            MessagePrinter messagePrinter = (MessagePrinter) objectClass.newInstance();
            messagePrinter.printMessage();
        } catch (IOException
                | ClassNotFoundException
                | InstantiationException
                | IllegalAccessException e) {
            LOG.error("Failed to load a class from file");
        }
    }
}
