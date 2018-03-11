import static org.junit.Assert.*;
import org.junit.*;

public class FileTest {
	/* This is for static methods */
	@BeforeClass public static void setupStaticMethod() {
		/* for testing has Overlapping User period */
	}
	
	private File helloWorld42Writeable, helloWorldemptyWriteable, helloWorld42NotWriteable, helloWorld43Writeable;
	/*This is for instance methods */
	/*We'll use to test the size */
	@Before public void setUp() {
		helloWorld42Writeable = new File("helloWorld", 42, true);
		helloWorld43Writeable = new File("helloWorld", 43, true);
		helloWorldemptyWriteable = new File("helloWorld", 0, true);
		helloWorld42NotWriteable = new File("helloWorld" , 42, false);
		
	}
	
	@Test public final void testSmallConstructor() {
		File newFile = new File("helloWorld");
		assertEquals(0, newFile.getSize());
		assertTrue(newFile.isWritable());
	}
	
	@Test (expected = NoWritingRightsException.class)
	public final void testSetNameIllegalCase() {
		helloWorld42Writeable.setName("#42ISTHEONLYANSWER");
		fail("WorkingAsIntended");
	}
	
	public final void testSetNameLegalCase() {
		helloWorld43Writeable.setName("43ISTHEWRONGANSWER.-_azer");
		fail("THISSHOULDNOTHAPPEN");
	}
	
	
}
