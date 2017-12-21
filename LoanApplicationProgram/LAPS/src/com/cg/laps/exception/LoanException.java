package com.cg.laps.exception;

public class LoanException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoanException() {
		super();
	}

	public LoanException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public LoanException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public LoanException(String arg0) {
		super(arg0);
	}

	public LoanException(Throwable arg0) {
		super(arg0);
	}

}
