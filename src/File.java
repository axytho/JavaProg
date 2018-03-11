
/**
 * package practica; @Frederik wat doet dit hier 
 */
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import be.kuleuven.cs.som.annotate.*;
/**
 * This class represents a file, and a file has a name and a size
 * When file is made the date is retained and a file can be write-able or not
 * 
 * 
 * @invar File size must be valid | isValidFileSize(getFileSize())
 * 
 * @invar 
 * 
 * @author Jonas
 * @author Frederik
 * 
 */

public class File {
	/**
	 * Makes a new file with a given name, size, and the abillity to be written by the user
	 * @param 	name 
	 * 			Name given to file.
	 * @param	size
	 * 			Size of file expressed in bytes.
	 * @param	writable
	 * 			Depends on whether the file is writeable or not
	 * 
	 * @pre 	The given size is a valid file size | isValidFileSize()
	 * 
	 * @post	If the input string consists of upper and lowercase letters, numbers, underscores, hyphens and dots,
	 * 			it will be used as a name, else the characters not conforming the the constrictions will be removed.	
	 * 			 
	 * 
	 * @effect 	The size of the file is set. 
	 * 
	 */
	File(String name, int size, boolean writable){
		setWriteable(true);
		setName(name);
		setWriteable(writable);
		
		
		
		/* er moet hier nog de name komen */
		this.size = size;

		this.creationTime = timeStamp();  
		
		

		
	}
	
	
	/** Creates a new writeable file with the given name
	 * @param	name
	 * 			Name given to file 
	 * @post	If the input string consists of upper and lowercase letters, numbers, underscores, hyphens and dots,
	 * 			it will be used as a name, else the characters not conforming the the constrictions will be removed.
	 * @effect 	An empty, writeable file with the given name
	 * 
	 */
	File(String name){
		this(name, 0, true);
		this.creationTime = timeStamp();  
	}
		
		/* @Frederick the right way of making a new constructor */
		
		
		
	
	
	/** 
	 * private field name
	 */
	private String name; 


	
	/**
	 * Returns the name of the file
	 */
	 public String getName() {
		 return this.name; 	
	}
	 

	/** 
	 * Gives the file a new name
	 * @param	name 
	 * 			The name given to the file
	 * @post 	If the input string consists of upper and lowercase letters, numbers, underscores, hyphens and dots,
	 * 			it will be used as a name, else .
	 * 			when the string has length 0, the name will be "name". 
	 * @throws	NoWritingRightsException(true)
	 * 			If the file is not writable, throws an exception with true to indicate that
	 * 			the exception is due to an attempted name change
	 * 			| ! isWritable()
	 * 
	 */
	public void setName(String name) throws NoWritingRightsException {
			if (!this.isWritable()) {
				throw new NoWritingRightsException(true);
			}
			if (name.length() == 0) {
				this.name = "name";
			}else {
				if (name.matches("[a-zA-Z_0-9[-.]]*")) {
					this.name = name; 	
					
				}else {
					this.name = "name";
				}
			}
			if (creationTime != null)
				{this.modificationTime = timeStamp();
				
				
				}
			
	}
	
	
	private Date creationTime = null;
	private Date modificationTime = null; 
	private String userPeriod; 
	
	
	/**
	 * @return
	 * 		Returns the time of creation of some file. 
	 */
	public String TimeCreated() {
		return this.creationTime.toString();
	}
	
	/**
	 * Calculates the time between creation time and modification time. 	
	 * @post		If there is no modification time we return null. 
	 * @return	
	 * 			The time difference
	 * @throws ParseException 
	 */
	
	public long userPeriod() throws ParseException {
		if (this.modificationTime == null) {
			return 0;
		}else {
			long Diff = this.creationTime.getTime() - this.modificationTime.getTime(); 
			return Diff; 
		}
	}
	
	
	
	/**
	 * Checks if two files have overlapping user periods. 
	 * 
	 * @param	other 
	 * 				An other File object 
	 * 
	 * @return	
	 * 			Returns true if the user periods overlap. 
	 */
	public boolean hasOverlappingUserperiod(File other) {
		if (other.modificationTime == null || this.modificationTime == null) {
			return false;}else {
				if (this.modificationTime.before(other.creationTime) || other.modificationTime.before(this.creationTime)) {
					return true; 
				}else {
					return false; 
				}
			}
					
	}
	
	/**
	 * All classes related to writable
	 */
	
	/**
	 * A boolean which states wether a given file is writeable
	 */
	private boolean writable; /* when the file is created it's always writable. @Frederick, you should
	do that in the constructor, not the initialization */
	
	
	/**

	 * Sets the attribute to the boolean 'writeable'
	 * 
	 * @param	writeable
	 * 			Parameter which determines whether a file can be edited.
	 */
	public void setWriteable(boolean writeable) {
		this.writable = writeable;
	}
	
	/**
	 * @return whether the function is writable
	 */
	public boolean isWritable() {
		return writable;
	}
	

	

	
	
	/**
	 * 
	 * @return 
	 * 		A string with the current time. 
	 */		
	private Date timeStamp() {
		Date date = new Date();
		return date; 
	}
		
	/**
	 * @return 
	 * 		returns the time on wich the time was last modified. 
	 */
	public String lastModified() {
		return this.modificationTime.toString(); 
	}
	

	
	
	/*
	 * All classes related to the size of the file
	 */

	
	private int size;
	
	private static final int maxvalue = Integer.MAX_VALUE;



	/**
	 * Returns the  size of our file
	 */
	
	public int getSize() {
		return this.size;
	}
	
	/**
	 * Sets the size of our file
	 * @param	bytes 
	 * 			The new size of the file
	 * 			
	 * @post	If a change of size results in a number of bytes higher than the maximum of lower than zero,
	 * 			then the number of bytes is set to the max or 0 respectively. 
	 * 
	 * @throws	NoWritingRightsException(true)
	 * 			If the file is not writable, throws an exception with false to indicate that
	 * 			the exception is due to an attempted name change
	 * 			| ! isWritable()
	 */
	private void setSize(int bytes) {
		if (!isWritable())	{
			throw new NoWritingRightsException(false);
		}
		this.size = bytes;

		
	}
	
	/** 
	 * Increase the size of the file with the amount of bites given
	 * 
	 *@param		bytes
	 *			The number of bytes to be added
	 *			

	 *@pre 		The new size of the file must be a valid size and must be writable
	 *			| canAcceptForEnlarge(bytes)
	 *
	 *@post		The size of the file changed correctly if the number of bytes does not surpass
	 *			the maximum number of bytes. If this is not the case, the resulting number of bytes will be 
	 *			the maximum number of bytes. 
	 *			| new.getSize() == this.getSize() + bytes
	 *			
	 */
	
	public void enlarge(int bytes) {
		this.setSize(bytes + size);
	}
	
	/** 
	 * Decrease the size of the file with the amount of bites given
	 * 
	 *@param		bytes
	 *			The number of bytes to be added
	 *			
	 *@pre 		The size of the file must be a valid size and must be writable
	 *			| canAcceptForShorten(bytes)
	 *
	 *@post		The size of the file changed correctly if the number of bytes does not surpass
	 *			the maximum number of bytes. If this is not the case, the resulting number of bytes will be 
	 *			the maximum number of bytes. 
	 *			| new.getSize() == this.getSize() - bytes
	 *			
	 */
	public void shorten(int bytes) {
		this.setSize(size - bytes);
	}
	

	/**
	 * @param	bytes
	 * 			The amount of bytes with which the file could be enlarged given a file size
	 * 
	 * @return	True if the new size is valid, the file is writable and the amount of bytes is positive.|
	 * 			result == (isValidFileSize(size + bytes) && isWritable() && bytes>0)
	 */
	
	public boolean canAcceptForEnlarge(int bytes) {
		return (isValidFileSize(size + bytes) && isWritable() && bytes>0);
	}
	/**
	 * @param	bytes
	 * 			The amount of bytes with which the file could be shortened given a file size
	 * 
	 * @return	True if the new size is valid, the file is writable and the amount of bytes is positive.|
	 * 			result == (isValidFileSize(size - bytes) && isWritable() && bytes>0)
	 */
	
	public boolean canAcceptForShorten(int bytes) {
		return (isValidFileSize(size - bytes) && isWritable() && bytes>0);
	}

	/**
	 * Checks whether the given file size is a valid size for the file
	 * 
	 * @param fileSize
	 * 		  The file size to check
	 * 
	 * @return	True if the file size is positive or 0 (file is empty) and less than the maximum value, 
	 * 			False otherwise
	 *			| result == (fileSize >= 0) && (filesize < this.maxvalue)
	 * 
	 * 
	 */
	
	public static boolean isValidFileSize(int fileSize) {
		return (fileSize >= 0) && (fileSize < maxvalue);
	}

	public static void main(String[] args){
		File helloWorld44Writeable = new File("helloWorld", 44, true);
		helloWorld44Writeable.canAcceptForEnlarge(500);
		String name = "testName"; 
		File file1 = new File(name,3,false); 
		String naam = file1.getName(); 
		System.out.println(naam);
		FileTest test = new FileTest();
		test.testSmallConstructor();
		test.testIsValidFileSize();
		test.testSetNameIllegalCase();
		test.testSetNameIllegalCaseNW();
		test.testSetNameLegalCase();
		test.testShortenIllegalCaseNW();
		test.testCanAcceptForEnlarge();
		test.testCanAcceptForShorten();
		test.testEnlarge();
		test.testShorten();	
/*		long period = file1.userPeriod(); */
/*		System.out.println(period); */
	}

}	
//	private boolean writable = true;  /* when the file is created it's always writable. 
//	
//	/**
//	 * gives a 'true' or 'false' to the field writable. 
//	 * 
//	 * @param	writable
//	 * 			paramter that determines if a file is writable or not.
//	 */
//	private boolean setWriteable(boolean writeable) {
//		
//		
//	}
//	
//	/**
//	 * private function returning True or False depending on the file being writable or not. 
//	 */
//	private boolean isWritable() {
//		
//	}


//	public static void main(String [ ] args){
//		String name = "test";
//		File file1 = new File(name);
//		String time = file1.TimeCreated();
//		System.out.println(time);
//		file1.setName("Peter");
//		String mod = file1.lastModified(); 
//		System.out.println(mod);
//	}
		



