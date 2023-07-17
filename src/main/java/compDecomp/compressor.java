/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package compDecomp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Surya
 */
public class compressor {
    public static void method(File file) throws IOException{
        
        String fileDirectory = file.getParent();
        
        FileInputStream fis = new FileInputStream(file); 
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/compressedFile.gz"); 
        GZIPOutputStream gzip = new GZIPOutputStream(fos);
        
        byte [] buffer = new byte[1024];
        int len;
        
        while((len=fis.read(buffer))!=-1)
        {
            gzip.write(buffer,0,len);
            
        }
        
        gzip.close();
        fis.close();
        fos.close();
        
    }
    
    
    public static void main(String[] args) throws IOException
    {
        File path = new File("/Users/Surya/Downloads/compressor/CompressorDecompressor/archive.tar.gz");
        method(path);
        
    }
    
}
