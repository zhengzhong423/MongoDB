package MangoDB.MANGO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App 
{
	LinkedList<JavaBean> rs=new LinkedList<JavaBean>();
    public static void main(String[] args) throws Exception
    {
    	App app=new App();
    	app.parseFile(new File("C://part-00000"));
    	connectDB conn=new connectDB();
    	conn.connect();
    	Iterator<JavaBean> iter=app.rs.iterator();
    	while(iter.hasNext())
    	{
    		JavaBean jb=iter.next();
    		conn.insert(jb);
    	}
    	conn.searchStatus(3);
    	System.out.println("DONE");
    }
    public void parseFile(File file)
    {
    	try {
			BufferedReader br=new BufferedReader(new FileReader(file));
			String line="";
			while((line=br.readLine())!=null)
			{
				JavaBean jb=new JavaBean();
				jb.setUrl(line.trim().substring(0,line.trim().length()-11));
				jb.setStatus(br.readLine().replaceFirst("Status: ", "").substring(0,1));
				rs.add(jb);
				while(br.readLine()!=null && br.readLine().length()!=0)
				{}
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
}
