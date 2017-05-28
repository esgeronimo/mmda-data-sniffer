package com.eugenegeronimo.mmda.mmdadatasniffer.core.base;

public interface BaseApiClient<T> {

    public static final String QUERY_PARAMS_TIMESTAMP = "_";

    public T get(Long timestamp) throws HttpException;

    public static class HttpException extends Exception {

        public static final int STATUS_INTERNAL_SERVER_ERROR = 500;

        private int statusCode;

        public HttpException(String message, Throwable e, int statusCode) {
            super(message, e);
            this.statusCode = statusCode;
        }

        public HttpException(String message, int statusCode) {
            super(message);
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }
}
