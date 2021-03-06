package jmp.classloading;

import org.apache.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Custom class loader which loads classes from jar file.
 *
 * @author Mikalai_Lohach
 */
public class JarClassLoader extends ClassLoader {

    private static final Logger LOG = Logger.getLogger("JarClassLoader");
    private JarFile file;

    public JarClassLoader(String filename) throws IOException {
        super(JarClassLoader.class.getClassLoader());
        this.file = new JarFile(filename);
    }

    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        JarEntry entry = this.file.getJarEntry(className.replace('.', '/') + ".class");
        if (entry == null) {
            throw new ClassNotFoundException(className);
        }
        try (InputStream in = this.file.getInputStream(entry)) {
            byte[] array = new byte[1024];
            ByteArrayOutputStream out = new ByteArrayOutputStream(array.length);
            int length = in.read(array);

            while (length > 0) {
                out.write(array, 0, length);
                length = in.read(array);
            }
            return defineClass(className, out.toByteArray(), 0, out.size());
        } catch (FileNotFoundException ex) {
            return super.findClass(className);
        } catch (IOException ex) {
            return super.findClass(className);
        }
    }
}
