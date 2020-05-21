package apro1.lab10;

public class Area
{
    protected int number;
    protected boolean isIsland;
    protected boolean isChecked=false;
    protected int NumberOfIsland=0;

    protected int height;

    protected int width;


    public Area(int number, int height,int width)
    {
        this.number=number;

        if(number!=0)
        {
            this.isIsland=true;
        }
        else
        {
            this.isIsland=false;
        }

        this.height=height;

        this.width=width;

    }


    public String toString()
    {
        return Integer.toString(this.number);
    }



}
