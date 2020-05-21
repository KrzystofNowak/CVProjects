package apro1.lab10;



import java.util.*;
import java.io.*;

public class Map
{


    private int height;

    public ArrayList<Island> islands=new ArrayList<>();

    private int width;



    public Map(String FileInput) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File(FileInput));

            this.height=scanner.nextInt();

            this.width=scanner.nextInt();

        this.NumberOfIslands(height,width,scanner);
    }


    public void NumberOfIslands(int height, int width, Scanner odczyt)
    {
        Area[][] Map = new Area[height+2][width+2];


        for(int i=0; i<width+2; i++)
        {
            Map[0][i]=new Area(0, 0,i);
        }

        for(int i=0; i<width+2; i++)
        {
            Map[height+1][i]=new Area(0,height+1, i);
        }

        for(int i=0; i<height+2; i++)
        {
            Map[i][0]=new Area(0,i,0);
        }

        for(int i=0; i<height+2;i++)
        {
            Map[i][width+1]=new Area(0,i,width+1);
        }

        for(int i=1; i<height+1; i++)
        {
            for(int j=1; j< width+1; j++)
            {
                Map[i][j]=new Area(odczyt.nextInt(),i,j);
            }
        }



        islands.add(new Island());

        ArrayList<Area> set= new ArrayList<>();

        ArrayList SizeOfIsland=new ArrayList<>();

        int NumberOfIsland=1;

        int TempSizeOfIsland=0;



        for(int i=1; i<height+1; i++)
        {
            for(int j=1; j< width+1; j++)
            {
               if (Map[i][j].isIsland && Map[i][j].isChecked==false)
               {
                   TempSizeOfIsland++;
                   Map[i][j].isChecked=true;
                   Map[i][j].NumberOfIsland=NumberOfIsland;
                   islands.get(islands.size()-1).add(Map[i][j]);


                   if(Map[i-1][j-1].isIsland && Map[i-1][j-1].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i-1][j-1].isChecked=true;
                       Map[i-1][j-1].NumberOfIsland=NumberOfIsland;

                       set.add(Map[i-1][j-1]);
                       islands.get(islands.size()-1).add(Map[i-1][j-1]);
                   }

                   if(Map[i-1][j].isIsland && Map[i-1][j].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i-1][j].isChecked=true;
                       Map[i-1][j].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i-1][j]);
                       islands.get(islands.size()-1).add(Map[i-1][j]);
                   }

                   if(Map[i-1][j+1].isIsland && Map[i-1][j+1].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i-1][j+1].isChecked=true;
                       Map[i-1][j+1].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i-1][j+1]);
                       islands.get(islands.size()-1).add(Map[i-1][j+1]);
                   }

                   if(Map[i][j-1].isIsland && Map[i][j-1].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i][j-1].isChecked=true;
                       Map[i][j-1].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i][j-1]);
                       islands.get(islands.size()-1).add(Map[i][j-1]);
                   }

                   if(Map[i][j+1].isIsland && Map[i][j+1].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i][j+1].isChecked=true;
                       Map[i][j+1].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i][j+1]);
                       islands.get(islands.size()-1).add(Map[i][j+1]);
                   }

                   if(Map[i+1][j-1].isIsland && Map[i+1][j-1].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i+1][j-1].isChecked=true;
                       Map[i+1][j-1].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i+1][j-1]);
                       islands.get(islands.size()-1).add(Map[i+1][j-1]);
                   }

                   if(Map[i+1][j].isIsland && Map[i+1][j].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i+1][j].isChecked=true;
                       Map[i+1][j].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i+1][j]);
                       islands.get(islands.size()-1).add(Map[i+1][j]);
                   }

                   if(Map[i+1][j+1].isIsland && Map[i+1][j+1].isChecked==false)
                   {
                       TempSizeOfIsland++;
                       Map[i+1][j+1].isChecked=true;
                       Map[i+1][j+1].NumberOfIsland=NumberOfIsland;
                       set.add(Map[i+1][j+1]);
                       islands.get(islands.size()-1).add(Map[i+1][j+1]);
                   }

                   while(set.size()!=0)
                   {

                       Area area= (Area) set.get(0);
                       set.remove(0);

                       if(Map[area.height-1][area.width-1].isIsland && Map[area.height-1][area.width-1].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height-1][area.width-1].isChecked=true;
                           Map[area.height-1][area.width-1].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height-1][area.width-1]);
                           islands.get(islands.size()-1).add(Map[area.height-1][area.width-1]);
                       }

                       if(Map[area.height-1][area.width].isIsland && Map[area.height-1][area.width].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height-1][area.width].isChecked=true;
                           Map[area.height-1][area.width].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height-1][area.width]);
                           islands.get(islands.size()-1).add(Map[area.height-1][area.width]);
                       }

                       if(Map[area.height-1][area.width+1].isIsland && Map[area.height-1][area.width+1].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height-1][area.width+1].isChecked=true;
                           Map[area.height-1][area.width+1].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height-1][area.width+1]);
                           islands.get(islands.size()-1).add(Map[area.height-1][area.width+1]);
                       }

                       if(Map[area.height][area.width-1].isIsland && Map[area.height][area.width-1].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height][area.width-1].isChecked=true;
                           Map[area.height][area.width-1].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height][area.width-1]);
                           islands.get(islands.size()-1).add(Map[area.height][area.width-1]);
                       }


                       if(Map[area.height][area.width+1].isIsland && Map[area.height][area.width+1].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height][area.width+1].isChecked=true;
                           Map[area.height][area.width+1].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height][area.width+1]);
                           islands.get(islands.size()-1).add(Map[area.height][area.width+1]);
                       }

                       if(Map[area.height+1][area.width-1].isIsland && Map[area.height+1][area.width-1].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height+1][area.width-1].isChecked=true;
                           Map[area.height+1][area.width-1].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height+1][area.width-1]);
                           islands.get(islands.size()-1).add(Map[area.height+1][area.width-1]);

                       }

                       if(Map[area.height+1][area.width].isIsland && Map[area.height+1][area.width].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height+1][area.width].isChecked=true;
                           Map[area.height+1][area.width].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height+1][area.width]);
                           islands.get(islands.size()-1).add(Map[area.height+1][area.width]);

                       }

                       if(Map[area.height+1][area.width+1].isIsland && Map[area.height+1][area.width+1].isChecked==false)
                       {
                           TempSizeOfIsland++;
                           Map[area.height+1][area.width+1].isChecked=true;
                           Map[area.height+1][area.width+1].NumberOfIsland=NumberOfIsland;

                           set.add(Map[area.height+1][area.width+1]);
                           islands.get(islands.size()-1).add(Map[area.height+1][area.width+1]);
                       }

                   }

                   islands.add(new Island());


                   NumberOfIsland++;

                   SizeOfIsland.add(TempSizeOfIsland);

                   TempSizeOfIsland=0;
               }

            }
        }


        NumberOfIsland--;
        islands.remove(islands.get(islands.size()-1));


        System.out.println(NumberOfIsland);

        for(int i=0; i<SizeOfIsland.size();i++)
        {
            System.out.println(SizeOfIsland.get(i));
        }

    }



    public static void main(String [] args) throws FileNotFoundException
    {
        String FileInput="large_input.txt";
        Map map =new Map(FileInput);
    }

}
