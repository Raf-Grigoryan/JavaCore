package book.chapter13;

import java.io.*;
import java.util.Scanner;

public class FileExample {

    private static String filePath = "/Users/raf/IdeaProjects/JavaCore/src/book/chapter13/file.txt";
    private static File file;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // createFile(filePath);
        // deleteFile(filePath);
        //writeTextInFile(filePath);
        //deleteAllInformation(filePath);
        //writeTextUntilStop(filePath);
    }

    private static void createFile(String path) {
        file = new File(path);
        try {
            if (!file.exists()) {
                file.createNewFile();
            } else {
                System.out.println("File is inly exists!!!");
            }
        } catch (IOException e) {
            System.out.println("Error please try again!!!");
        }
    }

    private static void deleteFile(String path) {
        file = new File(path);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File is deleted!!!");
            }
        } else {
            System.out.println("File does not exists");
        }
    }

    private static void readTextInFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File does not exists!!!");
        } catch (IOException e) {
            System.out.println("Cannot read file");
        }
    }

    private static void writeTextInFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            System.out.println("Please input text");
            String text = scanner.nextLine();
            bufferedWriter.write(text);

        } catch (IOException e) {
            System.out.println("Cannot write");
        }
    }

    private static void deleteAllInformation(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Cannot delete information please try again!!!");
        }
    }

    private static void writeTextUntilStop(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            String text = " ";
            System.out.println("Please input text for exit input Stop");
            while (!text.equals("Stop")) {
                text = scanner.nextLine();
                if (!text.equals("Stop")) {
                    bufferedWriter.write(text);
                    bufferedWriter.newLine();
                } else {
                    System.out.println("Exit!!!!");
                }

            }
        } catch (IOException e) {
            System.out.println("Cannot write text!!!");
        }
    }

}
