package googleGuavaUtiles;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileTest {
    public static void main(String[] args){
        File file = new File("target/classes/test.txt");
        List<String> list = null;
        try {
            List<String> strings = Files.readLines(file, Charsets.UTF_8);
            System.out.println(Joiner.on("\n").join(strings));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
