package Probe_test.stend;

public enum ListSelectors {
    ENTRYFIELDLOGIN ("//*[@id='user-name']"),
    ENTRYFIELDPASSWORD ("//*[@id='password']"),
    BUTTONLOGIN ("//*[@id='login-button']"),

    // For testing negative Login and Password
    MESSAGE_OF_ERROR("//*[@data-test='error']"),

    //html/body/div/div/div[2]/div[1]/div/div/form/div[3]/h3/text()
    //*[@id="login_button_container"]/div/form/div[3]/h3/button
    //MESSAGE_OF_ERROR_PASSWORD("//*[@data-test='error']"),
    TEXT_OF_MESSAGE("//*[@class='error-button']"),
    TITLE_PAGE_MAGAZINE("//*[@class='app_logo']"),
    URL_PAGE_MAGAZINE("https://www.saucedemo.com/inventory.html");


    private String value;
    ListSelectors (String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
