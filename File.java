package practica;
import be.kuleuven.cs.som.annotate.*;
/**
 * This class represents a file, and a file has a name and a size
 * When file is made the date is retained and a file can be write-able or not
 * 
 * 
 * @invar File size must be valid | isValidFileSize(getFileSize()
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
	/*  code nog uitwerken. 	
	 */
		
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
	/*  code nog uitwerken. 	
	 */
		
	}
	
	
	/**
	 * Returns the name of the file
	 */
	
	@basic public String getName() {
		
	}
	
	/** 
	 * Gives the file a new name
	 * @param	name 
	 * 			The name given to the file
	 * @post 	If the input string consists of upper and lowercase letters, numbers, underscores, hyphens and dots,
	 * 			it will be used as a name, else the characters not conforming the the constrictions will be removed.
	 */
	public void setName(String name) {
	/* schrijfrechten controleren 
	 * 
	 * code nog uitwerken. 
	 * modification time aanpassen. 
	 */
		
	}
	
	/*
	 * All classes related to the size of the file
	 */
	
	/**
	 * Variable representing the size of the file
	 */
	private int size;
	
	
	

	/**
	 * Returns the  size of our file
	 * The size is the amount of bytes a file takes up on this computer
	 * 
	 * 
	 */
	
	@Raw @basic public int getSize() {
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
	 * Increase the size of the file with the amount of bytes given
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
	 * 1 keer geimplementeerd worden. 	
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
	 * Checks whether the given file size is a valid size for the file
	 * 
	 * @param fileSize
	 * 		  The file size to check
	 * 
	 * @return True if the file size is positive and less than the maximum value, False otherwise
	 * 		   | result == (fileSize > 0) && (filesize < Integer.MAX_VALUE)
	 * 
	 * 
	 */
	
	public static boolean isValidFileSize(int fileSize) {
		return (fileSize > 0) && (filesize < Integer.MAX_VALUE)
	}
	
}
