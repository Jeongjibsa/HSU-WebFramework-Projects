package kr.ac.hansung.exception;

public class UserDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = -701842509815195305L;	
	private String userName;
	
	public UserDuplicatedException(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}
	
}
