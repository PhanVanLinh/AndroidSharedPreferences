package toong.vn.androidsharedpreferences.model;

public class AccessToken {

    private String token;

    private long expiredTime;

    public AccessToken(String token, long expiredTime) {
        this.token = token;
        this.expiredTime = expiredTime;
    }
}
