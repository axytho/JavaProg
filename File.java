package practica;
import java.util.Date;

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
	 * 			Depens on whether the file is writeable or not
	 * @post	If the input string consists of upper and lowercase letters, numbers, underscores, hyphens and dots,
	 * 			it will be used as a name, else the characters not conforming the the constrictions will be removed.	
	 * 			 
	 * @pre 	The total size must be lower than the max size.
	 * @effect 	The size of the file is set. 
	 * 
	 */
	File(String name, int size, boolean writable){
		setName(name);
		this.creationTime = timeStamp();  
		
		
		//setWriteable(writable);
		
		
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
		setName(name);
		this.creationTime = timeStamp();  
		setSize(0);
		
		
	}
	
	/** 
	 * private field name
	 */
	private String name; 
	/**
	 * Variable representing the size of the file
	 */
	private int size;
	
	/**
	 * private field for writable
	 */
	private final boolean writable = true; 

	
	private String creationTime = null;
	private String modificationTime = null; 
	
	
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
	 */
	public void setName(String name) {
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
				{this.modificationTime = timeStamp();}
			
	}
	

	public String TimeCreated() {
		return this.creationTime; 
	}
	
	
	/**
	 * 
	 * @return 
	 * 		A string with the current time. 
	 */		
	private String timeStamp() {
		Date date = new Date();
		return date.toString(); 
	}
		
	/**
	 * @return 
	 * 		returns the time on wich the time was last modified. 
	 */
	public String lastModified() {
		return this.modificationTime; 
	}
	

	
	
	/*
	 * All classes related to the size of the file
	 */

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
	 */
	private void setSize(int bytes) {
		this.size = bytes;
	/* @jonas: private gemaakt omdat het de bedoeling is de size aan te passen via enlarge/shorten
	 * 
	 * controleren of maximale grootte niet overschreden, niet beneden 0..
	 * modification time aanpassen 
	 */
		
	}
	
	/** 
	 * Increase the size of the file with the amount of bites given
	 * 
	 *@param		bytes
	 *			The number of bytes to be added
	 *			
	 *@post		The size of the file changed correctly if the number of bytes does not surpass
	 *			the maximum number of bytes. If this is not the case, the resulting number of bytes will be 
	 *			the maximum number of bytes.
	 */
	
	public void enlarge(int bytes) {		
	/* schrijfrechten cotroleren 
	 *  
	 * In deze methodes gebruik maken van setsize, op die manier moeten alles rond modification time maar 
	 * 1 keer geimplementeerd worden. ≤	
	 */
			
	}
	
	
	/** 
	 * Decrease the size of the file with the amount of bites given
	 * 
	 * @param	bytes 
	 * 			Number of bytes to be removed 
	 * @post 	The size of the file changed correctly if the number of bytes is not less than 0.
	 * 			If this is not the case, the resulting number of bytes will be 0. 
	 */
	
	public void shorten(int bytes) {

	}
	
	/**
	 * writable
	 */
	
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

	public static void main(String [ ] args){
		String name = "test";
		File file1 = new File(name);
		String time = file1.TimeCreated();
		System.out.println(time);
		file1.setName("Peter");
		String mod = file1.lastModified(); 
		System.out.println(mod);
	}
		

}

