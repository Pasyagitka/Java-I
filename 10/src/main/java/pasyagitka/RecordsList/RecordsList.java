package pasyagitka.RecordsList;

import java.util.ArrayList;
import java.util.List;

public class RecordsList {
    private static RecordsList instance;
    private final List<Record> recordList;

    private RecordsList()
    {
        recordList = new ArrayList<>();
    }
    public static synchronized RecordsList getInstance()
    {
        if ( instance != null) {
            return instance;
        }
        instance = new RecordsList();
        return instance;
    }
    public List<Record> getRecordList()
    {
        return recordList;
    }
    public void add(Record r)
    {
        recordList.add(r);
    }
    public void remove(Record r)
    {
        recordList.remove(r);
    }
    public void clear(){ recordList.clear(); }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Record r: recordList) {
            result.append(r.toString());
        }
        return result.toString();
    }
}
