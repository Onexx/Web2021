package ru.itmo.wp.lesson8.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NoticeCredentials {
    @NotNull(message = "Content can't be null")
    @NotEmpty(message = "Content can't be empty")
    @Size(min = 1, max = 255,message = "Content should be 1-255 symbols")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
