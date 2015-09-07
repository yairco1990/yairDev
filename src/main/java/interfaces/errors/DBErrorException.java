package interfaces.errors;

public class DBErrorException extends Exception {
    private static final long serialVersionUID = 7255081331940287228L;
    private static final String EXCEPTION = "DB ERROR";

    public DBErrorException() {
        super(EXCEPTION);
    }

    public DBErrorException(Exception e) {
        super(e);
    }

    public DBErrorException(String error) {
        super(error);
    }
}
