package com.company;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class Obsluga
{
    public static void main(String[] args)
    {
            Dyspozytor dyspozytor1 = new Dyspozytor("Janek");
            Dyspozytor dyspozytor2 = new Dyspozytor("Michał");
            Dyspozytor dyspozytor3 = new Dyspozytor("Paweł");

            Sortowanie.dyspozytorzy.add(dyspozytor1);
            Sortowanie.dyspozytorzy.add(dyspozytor2);
            Sortowanie.dyspozytorzy.add(dyspozytor3);

            Wykonawca wykonawca1 = new Wykonawca("Czesław");
            Wykonawca wykonawca2 = new Wykonawca("Wiesiek");
            Wykonawca wykonawca3 = new Wykonawca("Zenek");

            Sortowanie.wykonawcy.add(wykonawca1);
            Sortowanie.wykonawcy.add(wykonawca2);
            Sortowanie.wykonawcy.add(wykonawca3);


        while(true)
        {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Wybierz użytkownika");
            System.out.println("1. osoba zgłaszająca");
            System.out.println("2. dyspozytor");
            System.out.println("3. wykonawca");

            int wartość = scanner.nextInt();

            while (wartość != 1 && wartość != 2 && wartość != 3)
            {
                System.out.println("Błędna wartość");
                wartość = scanner.nextInt();
            }

            switch (wartość)
            {
                case 1:
                    osobaZgłaszająca();
                    break;

                case 2:
                    dyspozytor();
                    break;

                case 3:
                   wykonawca();
                    break;
            }
        }


    }



    public static void osobaZgłaszająca()
    {
        System.out.println("Którą osobą zgłaszającą jesteś");

        int ilośćOsóbZgłaszających=Sortowanie.osoby_zgłaszające.size();

        for(int i=0; i<ilośćOsóbZgłaszających; i++)
        {
            System.out.print(i + ". ");
            System.out.println(Sortowanie.osoby_zgłaszające.get(i));
        }

        System.out.println(ilośćOsóbZgłaszających + ". Stwórz nowego użytkownika");
        Scanner scanner = new Scanner(System.in);

        int obecnaOsobaZgłaszająca=scanner.nextInt();

        if(obecnaOsobaZgłaszająca == ilośćOsóbZgłaszających)
        {
            System.out.println("Podaj nick (bez spacji): ");
            Osoba_zglaszajaca osoba_zglaszajaca = new Osoba_zglaszajaca(scanner.next());
            Sortowanie.osoby_zgłaszające.add(osoba_zglaszajaca);
        }

        int rok, miesiąc, dzień;
        String funkcjonalność, opis_błędu;

        Calendar calendar = Calendar.getInstance();

        rok = calendar.get(Calendar.YEAR);
        miesiąc = calendar.get(Calendar.MONTH)+1; //coś tu jest nie tak z wczytywanym miesiącem
        dzień = calendar.get(Calendar.DAY_OF_MONTH);

        boolean zakończProgram=false;

        while(!zakończProgram)
        {
            System.out.println("Podaj co się popsuło w systemie");
            scanner.nextLine();  //ponieważ wczytuje enter podawany, przy wyborze osoby zgłaszającej
            funkcjonalność = scanner.nextLine();

            System.out.println("Opisz błąd");
            opis_błędu = scanner.nextLine();

            Sortowanie.osoby_zgłaszające.get(obecnaOsobaZgłaszająca).zgłośBłąd(rok, miesiąc, dzień, opis_błędu, funkcjonalność);


            System.out.println("Czy chcesz zakończyć \n 0 - zakończ \n 1 - zgłoś kolejny błąd");

            if(scanner.nextInt() == 0) zakończProgram = true;
        }
    }



    public static void dyspozytor() {
        System.out.println("Którym dyspozytorem jesteś:");

        int ilośćDyspozytorów = Sortowanie.dyspozytorzy.size();

        for (int i = 0; i < ilośćDyspozytorów; i++) {
            System.out.print(i + ". ");
            System.out.println(Sortowanie.dyspozytorzy.get(i));
        }

        System.out.println(ilośćDyspozytorów + ". Stwórz nowego użytkownika");
        Scanner scanner = new Scanner(System.in);

        int obecnyDyspozytor = scanner.nextInt();

        if (obecnyDyspozytor == ilośćDyspozytorów) {
            System.out.println("Podaj nick (bez spacji): ");
            Dyspozytor dyspozytor = new Dyspozytor(scanner.next());
            Sortowanie.dyspozytorzy.add(dyspozytor);
        }
        boolean zakończProgram = false;

        while (!zakończProgram)
        {
            System.out.println("Czy chcesz zakończyć pracę \n 0 - zakończ \n 1 - kontynuuj");

            if(scanner.nextInt() == 0) break;


            for (int i = 0; i < Sortowanie.zgłoszenia.size(); i++)
            {

                System.out.print(i + ". ");
                System.out.println(Sortowanie.zgłoszenia.get(i));
                System.out.println();
            }

            System.out.println("Wybierz zgłoszenie");

            int aktualneZgłoszenie = scanner.nextInt();


            System.out.println("Czy chcesz usunąć to zgłoszenie \n 0 - usuń \n 1 - modyfikuj ");

            switch (scanner.nextInt())
            {
                case 0:
                    Sortowanie.dyspozytorzy.get(obecnyDyspozytor).usuńZgłoszenie(aktualneZgłoszenie);
                    break;

                case 1:
                    Sortowanie.zgłoszenia.get(aktualneZgłoszenie).dyspozytor = Sortowanie.dyspozytorzy.get(obecnyDyspozytor).dyspozytor;
                    Sortowanie.dyspozytorzy.get(obecnyDyspozytor).zmieńStatus(aktualneZgłoszenie);

                    System.out.println("podaj priorytet");
                    Sortowanie.dyspozytorzy.get(obecnyDyspozytor).nadajPriorytet(aktualneZgłoszenie, scanner.nextInt());

                    for (int i = 0; i < Sortowanie.wykonawcy.size(); i++)
                    {
                        System.out.print(i + ". ");
                        System.out.println(Sortowanie.wykonawcy.get(i));
                    }

                    System.out.println("Podaj numer wykonawcy");

                    Sortowanie.dyspozytorzy.get(obecnyDyspozytor).przydzielWykonawcę(aktualneZgłoszenie, scanner.nextInt());
                    break;
            }
        }
    }


 public static void wykonawca() {
     System.out.println("Którym wykonawcą jesteś");

     int ilośćWykonawców = Sortowanie.wykonawcy.size();

     for (int i = 0; i < ilośćWykonawców; i++)
     {
         System.out.print(i + ". ");
         System.out.println(Sortowanie.wykonawcy.get(i));
     }

     System.out.println(ilośćWykonawców + ". Stwórz nowego użytkownika");
     Scanner scanner = new Scanner(System.in);

     int obecnyWykonawca = scanner.nextInt();

     if (obecnyWykonawca == ilośćWykonawców) {
         System.out.println("Podaj nick (bez spacji): ");
         Wykonawca wykonawca = new Wykonawca(scanner.next());
         Sortowanie.wykonawcy.add(wykonawca);
     }


     ArrayList<Zgloszenie> zgłoszeniaObecnegoWykonawcy = new ArrayList<>();

     for (int i = 0; i < Sortowanie.zgłoszenia.size(); i++) {
         if (Sortowanie.zgłoszenia.get(i).wykonawca.equals(Sortowanie.wykonawcy.get(obecnyWykonawca).wykonawca))
         {
             zgłoszeniaObecnegoWykonawcy.add(Sortowanie.zgłoszenia.get(i));
         }
     }

     boolean zakończPracę = false;

     while (!zakończPracę)
     {
         System.out.println("Wybierz możliwości: \n 0 - wykonaj zgłoszenie \n 1 - posortuj po priorytecie \n 2 - posortuj po statusie \n 3 - zobacz zgłoszenia danego użytkownika \n 4 - zakończ pracę");
         switch (scanner.nextInt())
         {

             case 0:
                 for (int i = 0; i < zgłoszeniaObecnegoWykonawcy.size(); i++)
                 {
                     System.out.println();
                     System.out.print(i + ". ");
                     System.out.println(zgłoszeniaObecnegoWykonawcy.get(i));
                 }

                 System.out.println("Wybierz zgłoszenie, które wykonałeś");
                 Sortowanie.wykonawcy.get(obecnyWykonawca).zmieńStatus(scanner.nextInt());

                 break;

             case 1:
                Sortowanie.sortowaniePriorytet(zgłoszeniaObecnegoWykonawcy);
                break;


             case 2:
                 Sortowanie.sortowanieStatus(zgłoszeniaObecnegoWykonawcy);
                 break;

             case 3:

                 for(int i=0; i<Sortowanie.osoby_zgłaszające.size(); i++)
                 {
                     System.out.println();
                     System.out.print(i + ". ");
                     System.out.println(Sortowanie.osoby_zgłaszające.get(i));
                 }

                 System.out.println("Wybierz osobę zgłaszającą");

                 Sortowanie.zgłoszeniaUżytkownika(zgłoszeniaObecnegoWykonawcy, Sortowanie.osoby_zgłaszające.get(scanner.nextInt()));
                 break;

             case 4:
                 zakończPracę =true;
                 break;

             default:
                 System.out.println("Niepoprawne żądanie");

         }
     }
 }
}
