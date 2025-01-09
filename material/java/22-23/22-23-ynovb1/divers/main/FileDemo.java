package main;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * FileDemo
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        String fileName = "notes.txt";
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        for (String line : lines) {
            System.out.println(line);
        }

    }
}