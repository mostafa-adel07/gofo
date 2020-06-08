package gofosoft;
import java.util.ArrayList;
import java.util.Scanner;


public class administrator extends user{
    Scanner input3 = new Scanner(System.in);
    administrator (String name1,String usertype1,String id1,String emile1,String location1,double phone1,String password1) {

        name = name1;
        usertype = usertype1;
        id = id1;
        emile = emile1;
        location = location1;
        phone = phone1;
        password = password1;

    }

    /**
     *
     * @param nameplayground1
     * @param numoperation
     */
    public  void aprove(String nameplayground1,int numoperation)
    {
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int j=0;j<playgroundownersdata.get(i).witingplaygroundsData.size();j++)
            {
               /* System.out.print(playgroundownersdata.get(i).witingplaygroundsData.get(j).toString());
                System.out.println("chosse num of operation");
                System.out.println("1-if dsta is correct approve it");
                System.out.println("2- if data not corrcet delet it");
                int numoperation = input3.nextInt();*/
                if(nameplayground1.equals( playgroundownersdata.get(i).witingplaygroundsData.get(j).playgroundName)) {

                    if (numoperation == 1) {
                        playgroundownersdata.get(i).playgroundsData.add(playgroundownersdata.get(i).witingplaygroundsData.get(j));
                        playgroundownersdata.get(i).witingplaygroundsData.remove(j);
                        break;
                    } else if (numoperation == 2) {
                        playgroundownersdata.get(i).witingplaygroundsData.remove(j);
                        break;

                    }
                }
            }
        }
    }

    /**
     *
     */
    public  void delet_playground()
    {
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int j=0;j<playgroundownersdata.get(i).playgroundsData.size();j++)
            {
                System.out.print(playgroundownersdata.get(i).playgroundsData.get(j).toString());
                System.out.print("if you want delet this playground?(yes or no)");

              String uwont = input3.next();

                 if(uwont.equals("yes"))
                { playgroundownersdata.get(i).playgroundsData.remove(j);

                }

            }
        }
    }

    /**
     *
     * @param nuame_playground1
     */
    public  void suspend_playground(String nuame_playground1)
    {
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int j=0;j<playgroundownersdata.get(i).playgroundsData.size();j++)
            {
                System.out.print(playgroundownersdata.get(i).playgroundsData.get(j).toString());


                if(nuame_playground1.equals( playgroundownersdata.get(i).playgroundsData.get(j).playgroundName))
                {  playgroundownersdata.get(i).suspendplaygroundsData.add(playgroundownersdata.get(i).playgroundsData.get(j));
                    playgroundownersdata.get(i).playgroundsData.remove(j);

                }

            }
        }
    }

    /**
     *
     * @param nuame_playground1
     */
    public  void active_playground(String nuame_playground1)
    {
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int j=0;j<playgroundownersdata.get(i).suspendplaygroundsData.size();j++)
            {
                System.out.print(playgroundownersdata.get(i).suspendplaygroundsData.get(j).toString());


                if(nuame_playground1.equals( playgroundownersdata.get(i).suspendplaygroundsData.get(j).playgroundName))
                {  playgroundownersdata.get(i).playgroundsData.add(playgroundownersdata.get(i).suspendplaygroundsData.get(j));
                    playgroundownersdata.get(i).suspendplaygroundsData.remove(j);

                }

            }
        }
    }

    /**
     *
     */
    public void print_witing_playground()
    {
        for(int i=0;i<playgroundownersdata.size();i++) {
            for (int j = 0; j < playgroundownersdata.get(i).witingplaygroundsData.size(); j++) {
                System.out.print(playgroundownersdata.get(i).witingplaygroundsData.get(j).toString());
            }
        }
    }

    /**
     *
     */
    public void print_playground()
    {
        for(int i=0;i<playgroundownersdata.size();i++) {
            for (int j = 0; j < playgroundownersdata.get(i).playgroundsData.size(); j++) {
                System.out.print(playgroundownersdata.get(i).playgroundsData.get(j).toString());
            }
        }
    }

    /**
     *
     */
    public void print_complin()
    {
        for(int i=0;i<playerData.size();i++)
        {for(int j=0;j<playerData.get(i).arr_complain.size();j++)
        {
            playerData.get(i).arr_complain.get(j).tostring();
        }

        }
    }
}
