package wikiatests;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{

	//include test annotations
	@Test(description = "LoginTest")
	public void Test1(){
		System.out.println("got to test1");
		wd.get("http://www.google.com/xhtml");
		System.out.println("ending test1");
	}
	
	
}//End of LoginTest
