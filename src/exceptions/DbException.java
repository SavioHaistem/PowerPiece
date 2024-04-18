package exceptions;

import java.io.Serial;

public class DbException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 42L;

    public DbException() {}
    public DbException(String error) {
        super(error);
    }
}
