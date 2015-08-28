/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janus
 */
public class Tester
{
    public static void main(String[] args)
    {
        /*
        
        Exercise 1C:
        Included in Exercises A and B as "Time spent", and in top with "Available Processors".
        Time spent clearly shows the difference between executing the 3 calculations after each other in sequence,
        or executing all 3 calculations at the same time, using the available processors.
        
        */
        
        try {
            System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
            System.out.println("");
            System.out.println("----------------------------------------");
            
            // Exercise 1A
            Exercise1 exer1 = new Exercise1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
            Exercise1 exer2 = new Exercise1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
            Exercise1 exer3 = new Exercise1("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
            Thread ex1 = new Thread(exer1);
            Thread ex2 = new Thread(exer2);
            Thread ex3 = new Thread(exer3);
            long start1 = System.nanoTime();
            ex1.run();
            ex2.run();
            ex3.run();
            long end1 = System.nanoTime();
            int result1 = exer1.getBytes() + exer2.getBytes() + exer3.getBytes();
            System.out.println("");
            System.out.println("Total sum of bytes after sequential execution: " + result1);
            System.out.println("Time spent: " + (end1 - start1));
            System.out.println("");
            
            // Exercise 1B
            Exercise1 exer4 = new Exercise1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
            Exercise1 exer5 = new Exercise1("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
            Exercise1 exer6 = new Exercise1("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
            Thread ex4 = new Thread(exer4);
            Thread ex5 = new Thread(exer5);
            Thread ex6 = new Thread(exer6);
            long start2 = System.nanoTime();
            ex4.start();
            ex5.start();
            ex6.start();
            ex4.join();
            ex5.join();
            ex6.join();
            long end2 = System.nanoTime();
            int result2 = exer1.getBytes() + exer2.getBytes() + exer3.getBytes();
            System.out.println("Total sum of bytes after parallel execution: " + result2);
            System.out.println("Time spent: " + (end2 - start2));
            System.out.println("");
        } catch (InterruptedException ex) {
            Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
