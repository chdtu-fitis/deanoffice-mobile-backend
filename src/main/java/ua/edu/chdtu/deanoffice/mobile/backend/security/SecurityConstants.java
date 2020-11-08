package ua.edu.chdtu.deanoffice.mobile.backend.security;

public final class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_AUDIENCE = "secure-app";

    public static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA1Njk5MDQ0LCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfREVBTk9GRklDRVIiXX0.0iujRIR2iyx2yrc_BbwJ0zNJBbW4hAxJrWjLUVzQglAeaXUw1GKQRHurE9piNUUm_ScQO21fgDFp4y_pO03FKw";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}

