package com.eugenegeronimo.mmda.mmdadatasniffer.core.base;

public interface BaseApiClient {

    public static final String QUERY_PARAMS_TIMESTAMP = "_";

    public static class HttpException extends Exception {

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
