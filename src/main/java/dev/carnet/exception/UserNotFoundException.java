package dev.carnet.exception;

public class UserNotFoundException extends UserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Cet utilisateur n'existe pas !";
	}
	

}
