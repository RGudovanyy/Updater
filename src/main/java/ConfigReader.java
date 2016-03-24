import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConfigReader {

    public List read(File file) throws IOException {
        ArrayList<String> result = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while(line!=null){
                if(line.startsWith("/"))
                    result.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}
