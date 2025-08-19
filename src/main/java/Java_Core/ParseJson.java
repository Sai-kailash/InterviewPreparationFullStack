package Java_Core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class ParseJson {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream is = new FileInputStream("src/main/resources/large.json")) {
            JsonFactory factory = mapper.getFactory();
            JsonParser parser = factory.createParser(is);

            while (!parser.isClosed()) {
                JsonToken token = parser.nextToken();
                System.out.println(token);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {

            // Read JSON file into JsonNode
            JsonNode rootNode = mapper.readTree(new File("src/main/resources/large.json"));

            // Access specific fields
            String name = rootNode.get("data").asText();
            //int age = rootNode.get("age").asInt();
            //String city = rootNode.get("city").asText();

            // Print values
            System.out.println("Name: " + name);
            //System.out.println("Age: " + age);
            //System.out.println("City: " + city);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
