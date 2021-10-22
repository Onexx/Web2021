package ru.itmo.web.lesson4.model;

public class Language {
    private final String alt;
    private final String title;
    private final String src;

    public Language(String alt, String title, String src) {
        this.alt = alt;
        this.title = title;
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public String getTitle() {
        return title;
    }

    public String getSrc() {
        return src;
    }
}
