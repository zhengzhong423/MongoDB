package parser;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)

public class JunitTest {
	
	private int param;
	
	private int param2;
	
	private int result;
	
	 @Before  
	    public void before() {   
	        System.out.println("@Before");   
	    }   
	 	
	@Parameters
	public static Collection<?> data()
	{
		return Arrays.asList(new Object[][]{{2,3,6}, {10,5,50},{8,9,72}});
	}
	 
	 public JunitTest(int param, int param2, int result)
	 {
		 this.result=result;
		 this.param=param;
		 this.param2=param2; 
	 }
	    @Test  
	         /**  
	          *Mark your test cases with @Test annotations.   
	          *You don’t need to prefix your test cases with “test”.  
	          *tested class does not need to extend from “TestCase” class.  
	          */  
	    public void test() {   
	        System.out.println("@Test");   
	        assertEquals(param*param2, result);
	        System.out.println(param+"*"+param2+"="+result);
	    }   
	    
	    @Ignore  
	    @Test  
	    public void testIgnore() {   
	        System.out.println("@Ignore");   
	    }   
	    
//	    @Test(timeout = 50)   
//	    public void testTimeout() {   
//	        System.out.println("@Test(timeout = 50)");   
//	        assertEquals(5 + 5, 10);   
//	    }   
//	    
//	    @Test(expected = ArithmeticException.class)   
//	    public void testExpected() {   
//	        System.out.println("@Test(expected = Exception.class)");  
//	        throw new ArithmeticException(); 
//	    }   
//	    
	    @After  
	    public void after() {   
	        System.out.println("@After");   
	    }   
	    
	    @BeforeClass  
	    public static void beforeClass() {   
	        System.out.println("@BeforeClass");   
	    };   
	    
	    @AfterClass  
	    public static void afterClass() {   
	        System.out.println("@AfterClass");   
	    };  
}
