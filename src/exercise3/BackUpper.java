/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textwriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Janus
 */
public class BackUpper implements Runnable
{
    TextWriterForm twf;
    FileWriter writer;
    PrintWriter out;
    private int backUpCounter = 1;
    
    public BackUpper(TextWriterForm t)
    {
        twf = t;
    }
    
    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(15000);
                System.out.println("Starting backup " + backUpCounter);
                backUpCounter++;
                
                writer = new FileWriter("backup.txt", false);
                out = new PrintWriter(writer);
                List<String> backUpList = new ArrayList<>();
                backUpList.addAll(twf.getLines());
                
                for(int i = 0; i < backUpList.size(); i++)
                {
                    out.println(backUpList.get(i));
                    System.out.print("Adding line " + i + " - ");
                }
                System.out.println("");
                
                out.close();
            } catch (InterruptedException ex) {
                Logger.getLogger(BackUpper.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(BackUpper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
//    FileWriter writer = new FileWriter("backup.txt", false);
//    PrintWriter out = new PrintWriter(writer);
//    out.println("This is written to the file");
//    out.close();
}
