package ru.itmo.web.lesson4.util;

import ru.itmo.web.lesson4.model.Language;
import ru.itmo.web.lesson4.model.User;
import ru.itmo.web.lesson4.model.Link;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DataUtil {
    private static final List<User> USERS = Arrays.asList(
            new User(1, "MikeMirzayanov", "Mike Mirzayanov"),
            new User(6, "pashka", "Pavel Mavrin"),
            new User(9, "geranazarov555", "Georgiy Nazarov"),
            new User(11, "tourist", "Gennady Korotkevich")
    );

    private static final List<Link> MENU_LINKS = Arrays.asList(
            new Link("Home", "/index"),
            new Link("Help", "/misc/help"),
            new Link("Contests", "/contests")
    );

    private static final List<Language> LANGUAGES = Arrays.asList(
            new Language("In English", "In English", "/img/gb.png"),
            new Language("In Russian", "In Russian", "/img/ru.png")
    );

    public static void addData(HttpServletRequest request, Map<String, Object> data) {
        data.put("users", USERS);
        data.put("menu_links", MENU_LINKS);
        data.put("languages", LANGUAGES);

        for (User user : USERS) {
            if (Long.toString(user.getId()).equals(request.getParameter("logged_user_id"))) {
                data.put("user", user);
            }
        }
    }
}
