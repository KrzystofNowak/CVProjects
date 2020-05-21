package apro1.lab10;

import java.util.ArrayList;

public class Island
{

    private ArrayList<Area> Island=new ArrayList<>();


    public void add(Area area)
    {
        this.Island.add(area);
    }


    public String toString()
    {
        return  Integer.toString(this.Island.size());
    }

}
