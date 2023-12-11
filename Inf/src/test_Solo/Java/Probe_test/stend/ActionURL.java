package Probe_test.stend;

public enum ActionURL {
    SAUSEDEMO ("https://www.saucedemo.com");
    private String value;
    ActionURL(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
