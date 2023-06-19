package Compression_Decompression;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class Compression
{
    public static void comp_method(File file) throws IOException
    {
        //To get the parent directory of our current chosen file to store the new output file
        String parentDirectory = file.getParent();
        //Get the file name without the extension
        String fileName = file.getName();
        String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
        // Create the output file name with the existing file name and "Compressed" suffix
        String outputFileName = parentDirectory + "/" + fileNameWithoutExtension + "Compressed.gz";
        //This class reads and holds the byte data from file 'file'
        FileInputStream fis = new FileInputStream(file);
        //This class writes the data in the created a file in the specified directory with the specified name
        FileOutputStream fos = new FileOutputStream(outputFileName);
        //When a method write is called from GZIPOutputStream class the data from the array will be written as compressed data in the
        //given output stream as a gzip file
        GZIPOutputStream gzp = new GZIPOutputStream(fos);
        byte[] buffer = new byte[1024];
        int len;
        //Reading data from fis to buffer until we reach end of the file
        //Writting compressed data to a file of gzip format from 0 to len
        while((len=fis.read(buffer)) >-1)
        {
            gzp.write(buffer,0,len);
        }
        gzp.close();
        fos.close();
        fis.close();
    }
    /*public static void main(String[] args) throws IOException
    {
        //Gets our current chosen file path if we have chosen if we haven't chosen the hardcoded path will be taken
        File path = new File("C:/Users/HP/Pictures/loginD.jpg");
        comp_method(path);
    }*/
}
