import static org.junit.Assert.*;
import org.junit.*;

public class FileTest {
	/* This is for static methods */
	@BeforeClass public static void setupStaticMethod() {
		/* for testing has Overlapping User period */
	}
	
	private File helloWorld42Writeable, helloWorldemptyWriteable, helloWorld42NotWriteable;
	/*This is for instance methods */
	/*We'll use to test the size */
	@Before public void setUp() {
		helloWorld42Writeable = new File("helloWorld", 42, true);
		helloWorldemptyWriteable = new File("helloWorld", 0, true);
		helloWorld42NotWriteable = new File("helloWorld" , 42, false);
		
	}
	
}
