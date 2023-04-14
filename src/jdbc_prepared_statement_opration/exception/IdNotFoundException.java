package jdbc_prepared_statement_opration.exception;

public class IdNotFoundException extends Exception {
String msg;
public IdNotFoundException(String msg) {
	super(msg);
	this.msg=msg;
	
}
}
