package Java_Core;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFileExample {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("theory/AWS Cheat sheet.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line); // process each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(Paths.get("theory/AWS Cheat sheet.txt"))) {
            //lines.forEach(System.out.println(line));
        }

        try (FileChannel channel = FileChannel.open(Paths.get("theory/AWS Cheat sheet.txt"))) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            while (buffer.hasRemaining()) {
                byte b = buffer.get();
                // process byte
            }
        }


    }
}
