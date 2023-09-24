package test;

public enum PageURL {
    MAIN("https://vk.com");

    private String value;

    PageURL (String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
