package ro.uaic.info.webcomponents.daos;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class CategoriesDao {
    private final List<String> categories;

    public CategoriesDao() {
        this.categories = Arrays.asList(
                "Romanian",
                "English",
                "French",
                "German"
        );
    }
}
