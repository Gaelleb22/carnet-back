package dev.carnet.exception;

public class MessageDto {
	
	private CodeErreur codeErreur;
	private String message;

	/** Constructor */
	public MessageDto(CodeErreur codeErreur, String message) {
		super();
		this.codeErreur = codeErreur;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CodeErreur getCodeErreur() {
		return codeErreur;
	}

	public void setCodeErreur(CodeErreur codeErreur) {
		this.codeErreur = codeErreur;
	}

}
