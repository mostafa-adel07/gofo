package gofosoft;

import java.util.ArrayList;
import java.util.Scanner;

public class playgroundowner extends user {


    Scanner input = new Scanner(System.in);
    Scanner input2 = new Scanner(System.in);
    int choice1;
    String choice;
    String ewallet_pass="00";
    static double balance=0;
    String acount_num;
    playground obj = new playground();
    /*

     */
    public ArrayList<playground> playgroundsData = new ArrayList<playground>(); //create array list of type playground
    public ArrayList<playground> witingplaygroundsData = new ArrayList<playground>(); //create array list of type playground
    public ArrayList<playground> suspendplaygroundsData = new ArrayList<playground>(); //create array list of type playground

    /**
     *
     * @return
     */
    public String getAcount_num() {
        return acount_num;
    }

    /**
     *
     * @param acount_num
     */
    public void setAcount_num(String acount_num) {
        this.acount_num = acount_num;
    }

    /**
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }



    playgroundowner(){}

    /**
     *
     * @param name1
     * @param usertype1
     * @param id1
     * @param emile1
     * @param location1
     * @param phone1
     * @param password1
     */
    playgroundowner (String name1,String usertype1,String id1,String emile1,String location1,double phone1,String password1)
    {

        name=name1;
        usertype=usertype1;
        id=id1;
        emile=emile1;
        location=location1;
        phone=phone1;
        password=password1;

    }
    /////////////////

    /**
     *
     */
    void display_all_playgrunds()
    {
        if(playgroundsData.isEmpty())
        {
            System.out.println("you don't have any play grounds");
        }else {
            for (int i = 0; i < playgroundsData.size(); i++)
            {
                System.out.println("Playground name :"+playgroundsData.get(i).playgroundName);
                System.out.println("playground size :"+playgroundsData.get(i).size);
                System.out.println("price per hour  :"+playgroundsData.get(i).hour_price);
                System.out.println("city            :"+playgroundsData.get(i).city);
            }
        }
    }
    ///////////////////////////

    /**
     *
     */
    public void change_available_hours() {
        int day,  hour;
        boolean bool = true;
        String name;
        System.out.println("Enter play ground name .");
        name=input.nextLine();
        for(int i=0;i<playgroundsData.size();i++)
        {
            if(playgroundsData.get(i).getPlaygroundName().equals(name))
            {
                while (bool) {
                    System.out.println("Enter the day you want change : ");
                    System.out.println("1-saturday\n2-sunday\n3-monday\n4-tuesday \n5-wednesday\n6-thursday\n7-friday ");
                    day = input2.nextInt();

                    for (int k = 0; k < 24; k++) {
                        System.out.println("Enter the hour you want to change in this day: ");
                        hour = input2.nextInt();
                        playgroundsData.get(i).available_hours[day-1][hour] = hour;
                        System.out.println("do u want to change another hour ? YES/NO");
                        choice = input.nextLine();
                        if (choice.equals("no")) {
                            break;
                        }
                    }
                    System.out.println("do you want change another day ? YES/NO");
                    choice = input.nextLine();
                    if (choice.equals("no")) {
                        bool = false;
                    }
                }
                break;
            }
        }

    }
    ////////////////////////////////////////////////////////

    /**
     *
     */
    public void add_playground() {
        String choice, name, location,city;
        int size1, day, hour;
        int[][] available_hours = new int[7][24];
        int[][] booking_hours = new int[7][24];
        float price;
        boolean bool = true;


        System.out.println("Enter playground name: ");
        name = input.nextLine();
        while (name == null || name.isEmpty()) {
            System.out.println("please enter playground name");
            name = input.nextLine();
        }

        System.out.println("Enter playground location: ");
        location = input.nextLine();
        while (location == null || location.isEmpty()) {
            System.out.println("please enter playground location");
            location = input.nextLine();
        }
        System.out.println("Enter playground city: ");
        city = input.nextLine();
        while (city == null || city.isEmpty()) {
            System.out.println("please enter playground location");
            city = input.nextLine();
        }
        System.out.println("Enter playground size: ");
        size1 = input2.nextInt();

        System.out.println("Enter playground price per hour: ");
        price = input2.nextFloat();
        while (bool) {
            System.out.println("Enter the available days of the playGround: ");
            System.out.println("1-saturday\n2-sunday\n3-monday\n4-tuesday \n5-wednesday\n6-thursday\n7-friday ");
            day = input2.nextInt();

            for (int i = 0; i < 24; i++) {
                System.out.println("Enter the available hours in this day: ");
                hour = input2.nextInt();

                available_hours[day - 1][hour - 1] = hour;
                booking_hours[day - 1][hour - 1] = 0;
                System.out.println("do u want add another hour ? YES/NO");
                choice = input.nextLine();

                if (choice.equals("no")) {
                    break;
                }

            }

            System.out.println("do you want add another day ? YES/NO");
            choice = input.nextLine();
            if (choice.equals("no")) {
                bool = false;
                obj = new playground(name, location,city, size1, available_hours, price, booking_hours);
                witingplaygroundsData.add(obj);
                //  System.out.print(obj.toString());
            }


        }
    }
    ///////////////////////////////////////////////////////////////////

    /**
     *
     */
    public void displayBookingHours() //method to display booking hours
    {
        for(int k=0;k<playgroundsData.size();k++)
        {
            System.out.println("Playground name ." + playgroundsData.get(k).getPlaygroundName());
            System.out.println("The booked hours :");
            System.out.println("1- Saturday ");

            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[0][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[0][i]+":00");
                }
            }
            System.out.println("2- sunday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[1][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[1][i]+":00");
                }
            }
            System.out.println("3- monday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[2][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[2][i]+":00");
                }
            }
            System.out.println("4- tuesday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[3][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[3][i]+":00");
                }
            }
            System.out.println("5- wednesday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[4][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[4][i]+":00");
                }
            }
            System.out.println("6- thursday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[5][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[5][i]+":00");
                }
            }
            System.out.println("7- friday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).booking_hours[6][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).booking_hours[6][i]+":00");
                }
            }
        }

    }
    /////////////////////////////////////////////////////////

    /**
     *
     */
    public void displayAvailableHours() //method to display available hours
    {
        for(int k=0;k<playgroundsData.size();k++)
        {
            System.out.println("Playground name ." + playgroundsData.get(k).getPlaygroundName());
            System.out.println("The available hours :");
            System.out.println("1- Saturday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[0][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[0][i]+":00");
                }
            }
            System.out.println("2- sunday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[1][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[1][i]+":00");
                }
            }
            System.out.println("3- monday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[2][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[2][i]+":00");
                }
            }
            System.out.println("4- tuesday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[3][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[3][i]+":00");
                }
            }
            System.out.println("5- wednesday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[4][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[4][i]+":00");
                }
            }
            System.out.println("6- thursday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[5][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[5][i]+":00");
                }
            }
            System.out.println("7- friday ");
            for (int i=0 ;i < 24 ; i ++)
            {
                if ( playgroundsData.get(k).available_hours[6][i] != 0)
                {
                    System.out.println(playgroundsData.get(k).available_hours[6][i]+":00");
                }
            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////

    /**
     *
     */
    public void update_playground_info()
    {
        boolean reEnter = true;
        String name;
        System.out.println("enter playground name .");
        name=input.nextLine();
        for(int i=0;i<playgroundsData.size();i++)
        {
            if(name.equals(playgroundsData.get(i).playgroundName))
            {
                while (reEnter) {

                    System.out.println("1-Edit playground name\n2-Edit location\n3-Edit size\n4-price per hour");
                    choice1 = input2.nextInt();
                    if (choice1 == 1) {
                        obj.playgroundName= input.nextLine();


                    } else if (choice1 == 2) {
                        obj.playgroundLocation=input.nextLine();


                    } else if (choice1 == 3) {
                        obj.size=input2.nextInt();

                    } else if (choice1 == 4) {
                        obj.hour_price= input2.nextFloat();

                    } else {
                        System.out.println("Enter valid choice ");
                        reEnter = false;
                    }
                }
            }
        }

    }

    ////////////////////////////////////////////////////////////////////

    /**
     *
     */
    public void  edit_my_info_owner()
    {
        int choice;
        boolean reEnter = true;
        while (reEnter) {

            System.out.println("1-Edit  name\n2-Edit id\n3-Edit password\n4-edit phone");
            choice = input.nextInt();
            if (choice == 1) {
            	 System.out.println("enter name");
                name= input.next();
                reEnter = false;

            } else if (choice == 2) {
            	 System.out.println("enter id");
                id=input.next();
                reEnter = false;

            } else if (choice == 3) {
            	 System.out.println("enter password");
                password=input.next();
                reEnter = false;
            } else if (choice == 4) {
            	 System.out.println("enter phone");
                phone= input.nextDouble();
                reEnter = false;
            } else {
                System.out.println("Enter valid choice ");
                reEnter = true;
            }
        }
    }
    //////////////////////////////////////////////////////////////////

    /**
     *
     * @param acountnum2
     * @return
     */
    public boolean check_acountnum_playgroundowner(String acountnum2)
    {
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            if(playgroundownersdata.get(i).acount_num.equals(acountnum2))
            {
                return true;
            }
        }
        return false;
    }
    //////////////////////////////////////////////////////////////////

    /**
     *
     */
    public void create_ewallet_playgroundowner() {
        String pass ;
        String acount_num2;
        double bal = 0;
        int loop = 0;
        if (ewallet_pass != "00") {
            System.out.println("You already have one  ");
        } else if (ewallet_pass.equalsIgnoreCase("00")) {
            System.out.println("Enter your password .");
            pass = input.next();
            System.out.println("Enter your balance .");
            bal = input.nextDouble();
            do {
                System.out.println("Enter your account number ");
                acount_num2 = input.next();
                if ( check_acountnum_playgroundowner(acount_num2)) {
                    System.out.println("This account number is taken .");
                    System.out.println("Ewallet account didn't creating");
                } else {
                    acount_num=acount_num2;
                    balance = bal;
                    ewallet_pass = pass;
                    System.out.println("Ewallet creating succecfully .");
                    loop = 1;
                }
            } while (loop == 0);
        }
    }
    //////////////////////////////////////////////////////////////////////
    /*public boolean send_money_playgroundowner(String player_account)
    {
        String r_acoount,pass;
        Double amount;
        System.out.println("Enter your password .");
        pass=input.nextLine();
        boolean operation=true;
        if(pass.equals(ewallet_pass))
        {
            System.out.println("your balance = " + balance);
            System.out.println("Enter the amount .");
            amount=input.nextDouble();
            System.out.println("Enter recever account num .");
            r_acoount=input.nextLine();

            if(r_acoount.equals(playerData.get(i).getAcount_num()))
            {
                if(balance<amount)
                {
                    System.out.println("you didn't have enough balance .");
                    operation=false;
                }else
                {
                    balance=balance-amount;
                    player_account.balance=player_account.balance+amount;
                    System.out.println("succecful operation your balance = " +balance);
                    operation=true;
                }
            }

        }else { System.out.println("wrong password");}
        return operation;

    }*/

}