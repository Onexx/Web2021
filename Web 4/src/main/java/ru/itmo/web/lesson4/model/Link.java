package ru.itmo.web.lesson4.model;

public class Link {
    private final String name;
    private final String href;

    public Link(String name, String href) {
        this.name = name;
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public String getHref() {
        return href;
    }


}
