package ro.uaic.info.webcomponents.daos;

import lombok.Getter;
import ro.uaic.info.webcomponents.models.Record;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RecordsDao {
    private List<Record> records;

    public RecordsDao() {
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        records.add(record);
    }
}
