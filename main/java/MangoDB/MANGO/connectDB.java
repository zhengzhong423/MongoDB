package MangoDB.MANGO;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;

public class connectDB {
	
	DBCollection conn;
	
	public  void connect()
	{
		try {
			Mongo mg = new Mongo();
			 for(String name: mg.getDatabaseNames())
		        	System.out.println(name);
		    DB db=mg.getDB("test");
		    conn=db.getCollection("Crawl");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void insert(JavaBean jb)
	{
		BasicDBObject obj1=new BasicDBObject();
		obj1.put("URL", jb.getUrl());
		obj1.append("Status", jb.getStatus());
		conn.update(obj1, obj1, true,false);
	}
	
	public void searchStatus(int num)
	{
		BasicDBObject obj=new BasicDBObject();
		obj.put("Status", String.valueOf(num));
		DBCursor cursor=conn.find(obj);
		while(cursor.hasNext())
		{
			System.out.println(cursor.next());
		}
	}
}
