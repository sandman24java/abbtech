package UserBackupSystem;

public class PathNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 12352L;
    private String message;
    public PathNotFoundException(String message){
        super(message);
        this.message = message;
    }
    @Override
    public String getMessage()
    {
        return message;
    }
}
