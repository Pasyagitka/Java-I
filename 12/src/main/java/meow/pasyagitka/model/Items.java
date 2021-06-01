package meow.pasyagitka.model;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Items {
    String[] items = {"Item1", "Item2", "Item3"};

    public List<String> getItemsAsList()
    {
        return Arrays.asList(items);
    }
    public Date getDate()
    {
        return new Date();
    }
}
