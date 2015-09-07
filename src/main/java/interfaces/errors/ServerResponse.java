package interfaces.errors;

public class ServerResponse {
    public static enum ResponseType {
        SUCCESS, NULL,
        TOKEN_EXPIRED, TOKEN_INVALID, TOKEN_CREATION_FAILED,
        DB_NOT_FOUND, DB_NOT_EXITS, DB_ERROR,
        SERVER_NO_RESPONE,
        NOT_FOUND, PASSWORD_NO_MATCH,
        INVALID_SEARCH_QUERY,
        EMPTY_QUEUE,
        NO_ROWS_AFFECTED,
        UNKNOWN_TYPE,
        NO_ROWS_FOUND,
        ALREADY_EXIST,
        WRONG_VERIFICATION_CODE, ERROR, SearchEngineException,
        NOT_VERIFIED,
        BAD_REQUEST,
        NOT_AUTHORIZED,
        GOTIME_USER_EXIST_WARNING,
        QUEUES_EXCEEDED, QUEUE_SKIPPED, PHONE_NUMBER_ALREADY_EXIST
    }
}
