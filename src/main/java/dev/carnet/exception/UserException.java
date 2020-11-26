package dev.carnet.exception;

public class UserException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private MessageDto message;
	/** Constructor */
	public UserException() {};
	
	public UserException(MessageDto message) {
		super(message.getMessage());
		this.message = message;
	}
	
	public MessageDto getMessageErreur() {
		return this.message;
	}

}
