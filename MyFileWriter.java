import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class MyFileWriter {

    private static void printTotalFileSize(String... fileNames) {
        long totalSize = 0;
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if (file.exists()) {
                totalSize += file.length();
            }
        }
        System.out.println("Total size of all files: " + totalSize + " bytes");
    }

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
        printTotalFileSize(fileName3, FolderFileName, FolderName);
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
}