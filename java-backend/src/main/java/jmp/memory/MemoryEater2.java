package jmp.memory;

import java.util.ArrayList;
import java.util.List;

import jmp.classloading.JarClassLoader;
import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 *
 */
public class MemoryEater2 {
    static final Logger LOG = Logger.getLogger(MemoryEater2.class);

    public static void main(String[] args) {
        List<Class> classes = new ArrayList<>();
        while (true) {
            try {
                JarClassLoader jarClassLoader = new JarClassLoader(
                        System.getProperty("user.dir") + "/jar/DefaultMessagePrinter-1.jar");
                Class clazz = jarClassLoader.loadClass("jmp.classloading.DefaultMessagePrinter");
                classes.add(clazz);
            } catch (Exception e) {
                LOG.error("Failed to load a class from file");
            }
            System.out.println("classes loadled: " + classes.size());
        }
    }
}
