package com.statecensusanalyser;

public class StateAnalyserException extends Exception {
    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY, NO_SUCH_FIELD, NO_SUCH_METHOD, NO_SUCH_CLASS, NO_ACCESS,
        OBJECT_CREATION_ISSUE, METHOD_INVOCATION_ISSUE, FIELD_SETTING_ISSUE, NO_SUCH_FILE
    }
    public ExceptionType type;

    public StateAnalyserException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }

    public StateAnalyserException(ExceptionType type, String s, Throwable throwable) {
        super(s, throwable);
        this.type = type;
    }

    public StateAnalyserException( ExceptionType type, Throwable throwable) {
        super(throwable);
        this.type = type;
    }
}
