package Probe_test;

public enum ListSelectors {
    ENTRYFIELDLOGIN ("//*[@id='user-name']"),
    ENTRYFIELDPASSWORD ("//*[@id='password']"),
    BUTTONLOGIN ("//*[@id='login-button']");
    private String value;
    ListSelectors (String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
