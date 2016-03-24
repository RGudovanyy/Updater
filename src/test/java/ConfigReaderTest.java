import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

public class ConfigReaderTest {
    ConfigReader cfg = new ConfigReader();
    File file = new File("src/test/test.txt");
    ArrayList<String> list = new ArrayList<String>();

    @Test
    public void returningListClass() throws Exception {
        Assert.assertEquals(ArrayList.class, cfg.read(file).getClass());
    }

    @Test
    public void readingFromFile() throws IOException {
        list.add("/test");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("/test");
        writer.close();
        Assert.assertEquals(list, cfg.read(file));
    }


}