package test_tng;

public enum Selectors {
    INPUT_LOGIN("//*[@id='index_email']"),
    BUTTON_LOGIN("/html/body/div[10]/div/div/div[2]/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/form/button/span/span"),
    BUTTON_PASSWORD_VK("/html/body/div[1]/div/div/div/div/div[1]/div[2]/div/div/div/form/div[4]/div/button[2]/span"),
    INPUT_PASSWORD("/html/body/div[1]/div/div/div/div/div[1]/div[2]/div/div/div/form/div[1]/div[3]/div/div/input"),
    BUTTON_PASSWORD("/html/body/div[1]/div/div/div/div/div[1]/div[2]/div/div/div/form/div[2]/button/span[1]/span"),
    BUTTON_FRIENDS("//*[@id='l_fr']"),
    BUTTON_ANATOLY("/html/body/div[11]/div/div/div[2]/div[2]/div[3]/div/div/div[2]/div/div[2]/div[4]/div[1]/div[1]/div[3]/div[3]/div[1]/a"),
    ELEMENT_QUALITY_FRIENDS ("/html/body//section[1]/a/header//span[2]");

    private String value;

    Selectors (String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
