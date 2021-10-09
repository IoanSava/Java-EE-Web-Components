package ro.uaic.info.webcomponents.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Record {
    private String key;
    private String value;
    private String category;
}
