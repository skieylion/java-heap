package project.java;

import java.io.File;
import java.util.Objects;

public class App {

    static void print(File currentFile, StringBuilder result, StringBuilder tab) {
        if (currentFile.isDirectory()) {
            result.append(tab);
            result.append("/");
            result.append(currentFile.getName());
            result.append("\n");
            tab.append("  ");
            for (File file : currentFile.listFiles()) {
                if (file.isFile()) {
                    result.append(tab);
                    result.append("- ");
                    result.append(file.getName());
                    result.append("\n");
                } else {
                    print(file, result, new StringBuilder(tab));
                }
            }
        } else {
            print(currentFile.getParentFile(), result, new StringBuilder(tab));
        }
    }

    public static void main(String[] args) {
        File currentFile = new File("C:\\work\\service-desk-web");
        System.out.println(currentFile.getAbsolutePath());
        long totalSpace = (long) (currentFile.getTotalSpace() / Math.pow(1024, 3));
        long freeSpace = (long) (currentFile.getFreeSpace() / Math.pow(1024, 3));
        String space = String.format("space: %s, free: %s", totalSpace, freeSpace);
        System.out.println(space);
        StringBuilder result = new StringBuilder();
        print(currentFile, result, new StringBuilder());
        System.out.println(result);
    }
}