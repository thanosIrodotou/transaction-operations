package com.form3.transactionprocessor.model.exception;

public abstract class MonitoredException extends RuntimeException {

    protected MonitoredException() {
        super();
    }

    protected MonitoredException(final String message) {
        super(message);
    }

    protected MonitoredException(final Throwable cause) {
        super(cause);
    }

    protected MonitoredException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public abstract Family getFamily();

    public abstract Type getType();

    public enum Family {
        SELF,
        API
    }

    public enum Type {
        USER,
        MISSING_RESOURCE,
        UNEXPECTED,
    }

    abstract int getStatusCode();

    abstract String getReason();
}
