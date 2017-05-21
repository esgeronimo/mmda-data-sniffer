package com.eugenegeronimo.mmda.mmdadatasniffer.core.base;

public interface BaseApiClient<T> {

    public static final String QUERY_PARAMS_TIMESTAMP = "_";

    public T get(Long timestamp) throws HttpException;

    public static class HttpException extends Exception {
        public HttpException(String message, Throwable e) {
            super(message, e);
        }
    }
}
