package ru.itmo.wp.lesson8.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.lesson8.form.NoticeCredentials;

@Component
public class NoticeCredentialsValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        return NoticeCredentials.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        if (!errors.hasErrors()) {
            NoticeCredentials noticeForm = (NoticeCredentials) target;
            if (noticeForm.getContent().trim().isEmpty()) {
                errors.rejectValue("content", "content.empty", "Empty content is not allowed");
            }
        }
    }
}
