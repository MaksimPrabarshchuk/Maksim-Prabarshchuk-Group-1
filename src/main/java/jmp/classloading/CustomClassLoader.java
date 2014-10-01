package jmp.classloading;

import org.apache.log4j.Logger;

/**
 * @author Mikalai_Lohach
 */
public class CustomClassLoader extends ClassLoader {

    private static final Logger LOG = Logger.getLogger("CustomClassLoader");

    public CustomClassLoader(ClassLoader parent) {
        super(parent);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        if (!name.endsWith("jar")) {
            return super.loadClass(name);
        }
        // TODO: read class from JAR
        return null;
    }
}
