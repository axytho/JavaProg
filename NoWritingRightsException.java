
public class NoWritingRightsException extends RuntimeException{
	
	


	/**
	 * Error is caused either by name change or content change
	 * @param isNameChange
	 */
	public NoWritingRightsException(boolean isNameChange) {
		this.isNameChange = true;
	}
	
	private boolean isNameChange;
	
	public boolean isNameChange() {
		return isNameChange;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
