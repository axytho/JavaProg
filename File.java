package practica;
import be.kuleuven.cs.som.annotate.*;
/**
 * Deze klasse stelt een file voor, een file heeft steeds een naam en grootte. 
 * Het moment waarop de klasse werd aangemaakt wordt ook steeds bijgehouden. En een bestand is
 * al dan niet schrijfbaar, afhankelijk van het schrijfrecht. 
 * 
 * @author Jonas
 * @author Frederik
 * 
 */

public class File {
	/**
	 * Maakt een nieuwe file aan met de meegegeven naam, grootte en die al dan niet schrijfbaar is. 
	 * @param 	name 
	 * 			De naam die wordt gegeven aan het bestand.
	 * @param	size
	 * 			De grootte van het bestand, uitgedrukt in bytes. 
	 * @param	writable
	 * 			bepaald of een bestand al dan niet schrijfbaar is. 
	 * @post		Als de meegegeven string enkel bestaat uit: hoofdletters, kleine letters
	 * 			cijfers, underscores, hyphens en punten. Dan wordt deze ingesteld als name. Anders 
	 * 			worden alle karakters die niet aan de beginvoorwaarden voldoen eruit gehaald, 
	 * 			het resultaat hiervan wordt ingesteld. 
	 * @pre 		De groote moet beneden de maximale grootte liggen.
	 * @effect 	De grootte van de file is ingesteld 
	 * 
	 */
	File(String name, int size, boolean writable){
	/*  code nog uitwerken. 	
	 */
		
	}
	
	
	/** Maakt een nieuw leeg en wijzigbaar file aan met de meegegeven naam. 
	 * @param	name
	 * 			De naam die wordt meegegeven aan het bestand. 
	 * @post		Als de meegegeven string enkel bestaat uit: hoofdletters, kleine letters
	 * 			cijfers, underscores, hyphens en punten. Dan wordt deze ingesteld als name. Anders 
	 * 			worden alle karakters die niet aan de beginvoorwaarden voldoen eruit gehaald, 
	 * 			het resultaat hiervan wordt ingesteld. 
	 * @effect 	Een lege file met een gegeven naam, die leeg is en wijzigbaar. Met de meegegeven naam. 
	 */
	File(String name){
	/*  code nog uitwerken. 	
	 */
		
	}
	
	
	/**
	 * Geeft de naam van een file terug
	 */
	
	@basic public String getName() {
		
	}
	
	/** 
	 * Hernoemt een file
	 * @param	name 
	 * 			De naam die gegeven wordt aan het bestand. 
	 * @post 	Als de meegegeven string enkel bestaat uit: hoofdletters, kleine letters
	 * 			cijfers, underscores, hyphens en punten. Dan wordt deze ingesteld als name. Anders 
	 * 			worden alle karakters die niet aan de beginvoorwaarden voldoen eruit gehaald, 
	 * 			het resultaat hiervan wordt ingesteld. 
	 */
	public void setName(String name) {
	/* schrijfrechten controleren 
	 * 
	 * code nog uitwerken. 
	 * modification time aanpassen. 
	 */
		
	}
	
	
	/**
	 * Geeft de grootte van een file terug. 
	 */
	@basic public int getSize() {
		
	}
	
	/**
	 * Past de grootte van een file aan.
	 * @param	bytes 
	 * 			Het aantal bytes die toegevoegd moeten worden. 
	 * @post		In de wijziging van size met bytes resulteert in een aantal bytes boven de maximale waarde of beneden 0. 
	 * 			Dan word respectievelijk de maximale waarde of 0 ingesteld als size. 
	 */
	private void setSize(int bytes) {
	/* @jonas: private gemaakt omdat het de bedoeling is de size aan te passen via enlarge/shorten
	 * 
	 * controleren of maximale grootte niet overschreden, niet beneden 0..
	 * modification time aanpassen 
	 */
		
	}
	
	/** 
	 * Laat de grote van een file toenemen met een meegegeven waarde 'bytes'. 
	 * 
	 *@param		bytes
	 *			Het aantal bytes dat toegevoegd moeten worden. 
	 *@post		De grootte van het bestand zal correct gewijzigd zijn op voorwaarde dat het aantal bytes 
	 *			niet boven het m	aximaal toegelaten aantal bytes is gegaan. In dit geval is de size ingesteld 
	 *			op het maximaal aantal toegelaten aantal bytes. 
	 * 
	 */
	
	public void enlarge(int bytes) {		
	/* schrijfrechten cotroleren 
	 *  
	 * In deze methodes gebruik maken van setsize, op die manier moeten alles rond modification time maar 
	 * 1 keer geimplementeerd worden. ≤	
	 */
			
	}
	
	
	/** 
	 * Laat de grote van een file afnamen met een meegegeven waarde 'bytes'
	 * 
	 * @param	bytes 
	 * 			Het aantal bytes dat verminderd worden. 
	 * @post 	De grootte van het bestand zal correct gewijzigd zijn op voorwaarde dat het aantal bytes 
	 *			niet beneden 0 is gegaan. In dit geval is de size ingesteld 
	 *			op 0. 
	 */
	
	public void shorten(int bytes) {

	}
	
}
