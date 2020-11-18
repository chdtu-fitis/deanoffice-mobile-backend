package ua.edu.chdtu.deanoffice.mobile.backend.security;

public final class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "/api/authenticate";

    public static final String JWT_SECRET = "n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf";

    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_AUDIENCE = "secure-app";

    public static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0IiwiZXhwIjoxNjA2MzkzMDMzLCJpc3MiOiIxIiwicm9sIjpbIlJPTEVfU1RVREVOVCJdfQ.VmpY64FiDg_eDxIMxld2uw59F9BbcPbwCYDeSS4mG7nS1EOhmH8f6ucyaH22uIW5fSxy8D8P5OP_prQoLgXdAw";

    private SecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}

