import static org.junit.Assert.*;
import org.junit.*;

public class FileTest {
	/* This is for static methods */
//	@BeforeClass public static void setupStaticMethod() {
//
//		/* for testing has Overlapping User period */
//	}
	
	private File helloWorld42Writeable, helloWorld44Writeable, helloWorld42NotWriteable, 
	helloWorld43Writeable, timeTest1, timeTest2, timeTest3;

	/*This is for instance methods */
	/*We'll use to test the size  */
	@Before public void setUp() {
		helloWorld42Writeable = new File("helloWorld", 42, true);
		helloWorld43Writeable = new File("helloWorld", 43, true);
		helloWorld44Writeable = new File("helloWorld", 44, true);
		
		helloWorld42NotWriteable = new File("helloWorld", 42, false);
		
		timeTest1 = new File("time", 1, true);
		timeTest3 = new File("time", 3, true);
		timeTest1.setName("nextTime");
		timeTest2 = new File("time", 2, true);
	}
	@Test public final void testTrue() {
		assertTrue(true);
	}
	
	@Test public final void testSmallConstructor() {
		File newFile = new File("helloWorld");
		assertEquals(0, newFile.getSize());
		assertTrue(newFile.isWritable());
	}
	

	@Test public final void testSetNameIllegalCase() {
		helloWorld42Writeable.setName("#42ISTHEONLYANSWER");
		assertEquals("name", helloWorld42Writeable.getName());
	}
	
	@Test public final void testSetNameLegalCase() {
		helloWorld43Writeable.setName("43.-_aZer");
		assertEquals("43.-_aZer", helloWorld43Writeable.getName());
	}
	
	@Test (expected = NoWritingRightsException.class)
	public final void testSetNameIllegalCaseNW() {
		helloWorld42NotWriteable.setName("name");
		fail("WorkingAsExpected");
	}
	
	@Test (expected = NoWritingRightsException.class)
	public final void testShortenIllegalCaseNW() {
		helloWorld42NotWriteable.shorten(5);
		fail("WorkingAsExpected");
	}
		
	@Test public final void testShorten() {
		helloWorld42Writeable.shorten(5);
		assertEquals(37, helloWorld42Writeable.getSize());
	}	
	
	@Test public final void testEnlarge() {
		helloWorld43Writeable.enlarge(5);
		assertEquals(48, helloWorld43Writeable.getSize());
	}	
	
	@Test public final void testCanAcceptForEnlarge() {
		assertTrue(helloWorld44Writeable.canAcceptForEnlarge(500));
		assertFalse(helloWorld44Writeable.canAcceptForEnlarge(Integer.MAX_VALUE));
		assertFalse(helloWorld44Writeable.canAcceptForEnlarge(-5));
	}
	
	@Test public final void testCanAcceptForShorten() {
		assertTrue(helloWorld44Writeable.canAcceptForShorten(44));
		assertFalse(helloWorld44Writeable.canAcceptForShorten(45));
		assertFalse(helloWorld44Writeable.canAcceptForShorten(0));
	}
	
	@Test public final void testIsValidFileSize() {
		assertTrue(File.isValidFileSize(0));
		assertFalse(File.isValidFileSize(Integer.MAX_VALUE));
	}
	
	@Test public final void testUserPeriod() {
		assertFalse(timeTest1.hasOverlappingUserperiod(timeTest2));
		assertTrue(timeTest1.hasOverlappingUserperiod(timeTest3));
	}
	
	
	
}
