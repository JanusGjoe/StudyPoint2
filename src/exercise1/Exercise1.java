/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Janus
 */
public class Exercise1 implements Runnable
{
    private String url;
    private int bytes;
    
    public Exercise1(String url)
    {
        this.url = url;
        bytes = 0;
    }
    
    @Override
    public void run()
    {
        byte[] array;
        array = getBytesFromUrl(url);
        for (int i = 0; i < array.length; i++)
        {
            bytes = bytes + array[i];
        }
    }
    
    public int getBytes()
    {
        return bytes;
    }
    
    protected byte[] getBytesFromUrl(String url)
    {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        try
        {
            InputStream is = new URL(url).openStream();
            byte[] bytebuff = new byte[4096];
            int read;
            while ((read = is.read(bytebuff)) > 0)
            {
                bis.write(bytebuff, 0, read);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        return bis.toByteArray();
    }
}