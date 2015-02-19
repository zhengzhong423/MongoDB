package parser;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONparser {
	public static void parseJson(String inputLine)
    {
    	try {
			JSONObject obj=(JSONObject) new JSONParser().parse(inputLine);
			JSONObject a=(JSONObject) obj.get("responseData");
			JSONArray arr=(JSONArray)(a.get("results"));
			for(int i=0; i<a.size(); i++)
			{
				JSONObject o=(JSONObject) arr.get(i);			
				Iterator<?> iter=o.keySet().iterator();
				while(iter.hasNext())
				{
					Object object=iter.next();
					System.out.println(object+ " : " +o.get(object));
				}
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
