

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonWrite {

    public void write(String s)
    {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("c:\\json\\routetaken.json"));
            JSONObject jsonObject = (JSONObject)obj;
            JSONArray cityList = (JSONArray) jsonObject.get("cities");
            //TESTING System.out.println(cityList);
            
            cityList.add(s);
            jsonObject.put("cities", cityList);
            
            try (FileWriter file = new FileWriter("c:\\json\\routetaken.json")) {
                
                file.write(jsonObject.toJSONString());
                
                file.flush();
                
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JsonWrite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsonWrite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JsonWrite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public static void main(String[] args) {

            JsonWrite jw = new JsonWrite();
            try{
                jw.write("C");
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }

    }

}