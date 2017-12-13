import java.awt.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.util.*;
import java.io.*;
import java.util.ArrayList;
public class JsonRead {

    public static void main(String[] args)throws IOException {
            BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
            JsonRead j = new JsonRead();
            /*String s = br.readLine();
            
            System.out.println(j.getNext(s));*/
            System.out.println(j.getNext("A"));
            
    }
        public String getName()
    {
        
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("c:\\json\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray msg = (JSONArray) jsonObject.get("cities");
            Iterator i = msg.iterator();
            if (i.hasNext()) {
                JSONObject city = (JSONObject) i.next();
                String name = (String)city.get("name");
                return name;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
                    return null;
    }
        public String getPre(String curr)
    {
        
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("c:\\json\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            String name = (String) jsonObject.get("name");
            System.out.println(name);

            JSONArray msg = (JSONArray) jsonObject.get("cities");
            Iterator i = msg.iterator();
            while (i.hasNext()) {
                JSONObject city = (JSONObject) i.next();
                if(((String)city.get("name")).equalsIgnoreCase(curr)&&(((String)city.get("flag")).equalsIgnoreCase("no"))){
                    String pre = (String)city.get("pre");
                    return pre;
                }
                
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
                    return null;
    }
           
        public String getNext(String curr)
    {
        
        JSONParser parser = new JSONParser();
        try {

            Object obj = parser.parse(new FileReader("c:\\json\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray arr = (JSONArray) jsonObject.get("cities");
            Iterator i = arr.iterator();
            while (i.hasNext()) {
                JSONObject city = (JSONObject) i.next();
                String next=((String)city.get("name"));
                if(next.equals(curr)&&(!(((String)city.get("flag")).equalsIgnoreCase("no"))))
                {   
                    return next;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
                    return null;
    }
        public long getNumber(){
                    JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("c:\\json\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            long num = (Long) jsonObject.get("number");
            return num;
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
}
        public Set getNameSet()
        {
            JSONParser parser = new JSONParser();
            JsonRead j = new JsonRead();
            Set<String> arr = new HashSet();
            
        try {

            Object obj = parser.parse(new FileReader("c:\\json\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            
            JSONArray cities = (JSONArray) jsonObject.get("cities");
            //System.out.println(cities);
            Iterator i = cities.iterator();
            int c=0;
            while (i.hasNext()) {
                JSONObject city = (JSONObject) i.next();
                //System.out.println(city);
                String n = ((String)city.get("name")); 
                
                arr.add(n);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return arr;
        }
}