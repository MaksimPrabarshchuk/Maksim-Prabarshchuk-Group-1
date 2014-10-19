package jmp.memory;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Ivan_Spresov
 * Date: 3/3/14
 */
public class MemoryEater {
    static final Logger LOG = Logger.getLogger(MemoryEater.class);

    public static void main(String[] args) {
        while (true) {
            byte b[] = new byte[1048576];
            Runtime rt = Runtime.getRuntime();
            System.out.println("free memory: " + rt.freeMemory());
            /*try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
            }*/
        }
    }
}
