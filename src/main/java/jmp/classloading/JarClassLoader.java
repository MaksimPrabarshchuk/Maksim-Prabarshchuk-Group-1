package jmp.classloading;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

import org.apache.log4j.Logger;

/**
 * Custom class loader which loads classes from jar file.
 *
 * @author Mikalai_Lohach
 *
 */
public class JarClassLoader extends ClassLoader {

    private static final Logger LOG = Logger.getLogger("JarClassLoader");
    private JarFile file;

    public JarClassLoader(ClassLoader parent, String filename) throws IOException {
        super(parent);
        this.file = new JarFile(filename);
    }

    public Class loadClass(String name) throws ClassNotFoundException {
        JarEntry entry = this.file.getJarEntry(name.replace('.', '/') + ".class");
        if (entry == null) {
            throw new ClassNotFoundException(name);
        }
        try {
            byte[] array = new byte[1024];
            InputStream in = this.file.getInputStream(entry);
            ByteArrayOutputStream out = new ByteArrayOutputStream(array.length);
            int length = in.read(array);
            while (length > 0) {
                out.write(array, 0, length);
                length = in.read(array);
            }
            return defineClass(name, out.toByteArray(), 0, out.size());
        } catch (IOException e) {
            LOG.error(e.getStackTrace());
            throw new ClassNotFoundException(name, e);
        }
    }
}
