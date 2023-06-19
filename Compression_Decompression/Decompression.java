package Compression_Decompression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class Decompression
{
    public static void decomp_method(File file) throws IOException
    {
        String parentDirectory = file.getParent();
        String fileName = file.getName();
        String FileNameWithoutExtension = fileName.substring(0,fileName.lastIndexOf('.'));
        String opFileName = parentDirectory+"/"+FileNameWithoutExtension+"Decompressed";
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzp = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(opFileName);
        byte[] buffer = new byte[1024];
        int len;
        //Reading data from gzp to buffer until we reach end of the file
        //Writting decompressed data to a file of original format from 0 to len
        while((len=gzp.read(buffer)) >-1)
        {
            fos.write(buffer,0,len);
        }
        gzp.close();
        fos.close();
        fis.close();
    }
    /*public static void main(String[] args) throws IOException
    {
        File path = new File("C:/Users/HP/Pictures/CompressedFile.gz");
        decomp_method(path);
    }*/

}
