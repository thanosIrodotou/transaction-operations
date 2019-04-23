package com.form3.transactionprocessor.model.exception;

public class TransactionNotFoundException extends MonitoredException {

    private String reason;
    private final int statusCode;
    private Throwable cause;

    public TransactionNotFoundException(final String reason, Throwable cause) {
        super(reason);
        this.reason = reason;
        this.statusCode = 404;
        this.cause = cause;
    }

    @Override
    public Family getFamily() {
        return Family.SELF;
    }

    @Override
    public Type getType() {
        return Type.MISSING_RESOURCE;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
