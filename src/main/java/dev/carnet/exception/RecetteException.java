package dev.carnet.exception;

public class RecetteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private MessageDto message;
	/** Constructor */
	public RecetteException(MessageDto message) {
		super(message.getMessage());
		this.message = message;
	}
	
	public MessageDto getMessageErreur() {
		return this.message;
	}
	

}
