

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWrite {

    public void write(String s)
    {
        JSONObject obj = new JSONObject();
        obj.put("name", s);
        try (FileWriter file = new FileWriter("c:\\json\\routetaken.json",true)) {//put treu there to ensure new data gets appended
            //file.write(obj.toJSONString(),obj.,(obj.toJSONString()).length())
            
            file.write(obj.toJSONString());
            
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {

            JsonWrite jw = new JsonWrite();
            jw.write("B");

    }

}