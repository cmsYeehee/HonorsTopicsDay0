import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyFileWriter {
    public static void main(String[] args) {
        String data = "The secret Password is: qpdb25";
        String fileName3 = ".thehider.txt";
        String FolderFileName = "Storaging.dat";
        String secret = "Don't look in here";
        String FolderName = ".TheHiderFolder";
        File folder = new File(FolderName);
        File folderFile = new File(folder+ "/" + FolderFileName);
        folder.mkdirs();
        // 3. Using FileOutputStream
        try (FileOutputStream outputStream = new FileOutputStream(fileName3)) {
            outputStream.write(data.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }
       try(FileOutputStream outputStream2 = new FileOutputStream(folderFile)){
            outputStream2.write(secret.getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printFileSize(String FileName)
    {
        try{
        int characterCount = 0;
        File FileToCount = new File(FileName);
        Scanner scannerCounter = new Scanner(FileToCount);
        while(scannerCounter.hasNextLine())
        {
            String line = scannerCounter.nextLine();
            characterCount += line.length();
        }
        System.out.println(characterCount + "");
        scannerCounter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void printTotalFileSize(String... fileNames) {
    
        System.out.println("Total size of all files: ...TBD... bytes");
    }
}