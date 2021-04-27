package medcenter;

import java.util.ArrayList;
import java.util.List;

public class MedCenter {
    private static MedCenter instance;
    private final List<Med> meds;

    private MedCenter()
    {
        meds = new ArrayList<>();
    }
    public static synchronized MedCenter getInstance()
    {
        if ( instance != null) {
            return instance;
        }
        instance = new MedCenter();
        return instance;
    }
    public List<Med> getMeds()
    {
        return meds;
    }
    public void add(Med med)
    {
        meds.add(med);
    }
    public void remove(Med med)
    {
        meds.remove(med);
    }
    public void clear(){ meds.clear(); }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Med med: meds) {
            result.append(med.toString());
        }
        return result.toString();
    }
}
