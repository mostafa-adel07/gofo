package gofosoft;

import java.util.ArrayList;
import java.util.Scanner;

public class player extends user {
    private ArrayList<String> favorite_team = new ArrayList<String>();
    private ArrayList<booking_data> mybooking=new ArrayList<>();
    public ArrayList<complain> arr_complain=new ArrayList<>();
    static  double  balance=0;
    private String ewallet_pass="00";
    private String acount_num;

    Scanner input = new Scanner(System.in);

    /**
     *
     * @return
     */
    public double getBalance() {
        return balance;
    }

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
        this.acount_num =acount_num;
    }

    /**
     *
     */
    player(){}

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
    player (String name1,String usertype1,String id1,String emile1,String location1,double phone1,String password1)
    {

        name=name1;
        usertype=usertype1;
        id=id1;
        emile=emile1;
        location=location1;
        phone=phone1;
        password=password1;

    }

    /**
     *
     * @param city
     */
    public void searchbylocation(String city)
    { int num=1;
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int k=0;k<playgroundownersdata.get(i).playgroundsData.size();k++)
            {
                if(city.equalsIgnoreCase(playgroundownersdata.get(i).playgroundsData.get(k).city))
                {
                    System.out.println(num +" - "+ playgroundownersdata.get(i).playgroundsData.get(k).playgroundName);
                    System.out.println("price per hour  " + playgroundownersdata.get(i).playgroundsData.get(k).hour_price);
                    System.out.println("Size     " + playgroundownersdata.get(i).playgroundsData.get(k).size);
                    num++;
                }
            }
        }
    }
    //////////////////////////////////////////////////////

    /**
     *
     * @param day
     * @param hours
     */
    public void searchbydate(int day,int hours)
    { int num=1;
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int k=0;k<playgroundownersdata.get(i).playgroundsData.size();k++)
            {
                for (int j=0;j<7;j++)
                {
                    for (int z=0;z<24;z++)
                    {
                        if((playgroundownersdata.get(i).playgroundsData.get(k).getAvailable_hours(j, z) == (hours-1) )&& ((day-1)==j))
                        {
                            System.out.println(num +" - " + playgroundownersdata.get(i).playgroundsData.get(k).playgroundName);
                            System.out.println("price per hour       " + playgroundownersdata.get(i).playgroundsData.get(k).hour_price);
                            System.out.println("Size       " + playgroundownersdata.get(i).playgroundsData.get(k).size);
                            System.out.println("City        " + playgroundownersdata.get(i).playgroundsData.get(k).city);
                            num++;
                            break;
                        }
                    }

                }
            }
        }
    }
    ////////////////////////////////////////////////////////////////

    /**
     *
     * @param Hour
     * @param Day
     * @param num_of_hour
     * @param playgroundname
     */
    public void  booking(int Hour,int Day,int num_of_hour,String playgroundname)
    {
        booking_data add_booking=new booking_data();
        int H=Hour,ii=0;
        boolean check;
        boolean operation;
        double bill;
        String pass;
        int [][] date = new int[7][24];
        int choice;
        for(int i=0;i<playgroundownersdata.size();i++)
        {
            for(int k=0;k<playgroundownersdata.get(i).playgroundsData.size();k++)
            {
                if(playgroundname.equals(playgroundownersdata.get(i).playgroundsData.get(k).playgroundName))
                {
                    check=playgroundownersdata.get(i).playgroundsData.get(k).check_available__hour_booking(Day,Hour,num_of_hour);
                    if(check==true)
                    {
                        bill=calculate_price(num_of_hour,playgroundownersdata.get(i).playgroundsData.get(k).hour_price);
                        System.out.println("This data available,Your bill =  "+ bill +"   Are you want booking ?(yes or no) ");
                        System.out.println("1 - yes .");
                        System.out.println("2 - NO .");
                        choice=input.nextInt();
                        if(choice==1)
                        {
                            System.out.println("Playground owner acountnumber is = "+ playgroundownersdata.get(i).getAcount_num());

                            operation=  send_money_player(playgroundownersdata.get(i),bill);
                            if(operation==true)
                            {
                                for (int m = 0; m < num_of_hour; m++) {

                                    date[Day-1][H-1]=H;
                                    playgroundownersdata.get(i).playgroundsData.get(k).change_available_hour_booking(Day, H);
                                    playgroundownersdata.get(i).playgroundsData.get(k).change_booking_hour_booking(Day, H);
                                    H++;

                                }
                                System.out.println("your bill ="+calculate_price(num_of_hour,playgroundownersdata.get(i).playgroundsData.get(k).hour_price));
                                add_booking.setBooking_hours(date);
                                add_booking.setHour_price(playgroundownersdata.get(i).playgroundsData.get(k).hour_price);
                                add_booking.setNum_of_hour(num_of_hour);
                                add_booking.setPlaygroundName(playgroundname);
                                add_booking.setHour(Hour);
                                add_booking.setDay(Day);
                                add_booking.setBill(bill);
                                mybooking.add(add_booking);
                                System.out.println("Done .");

                            }else {System.out.println("fail booking .");}

                        }


                    }else
                    {
                        System.out.println("Sorry,this date not available .");
                    }


                    break;
                }
            }
        }




    }
    ////////////////////////////////////////////////////////

    /**
     *
     * @param playgroundname
     */
    public void cancel_booking(String playgroundname)
    {
        for(int x=0;x<mybooking.size();x++)
        {
            if(playgroundname.equals(mybooking.get(x).playgroundName))
            {
                int H=mybooking.get(x).getHour();
                for(int i=0;i<playgroundownersdata.size();i++)
                {
                    for(int k=0;k<playgroundownersdata.get(i).playgroundsData.size();k++)
                    {
                        if(playgroundname.equals(playgroundownersdata.get(i).playgroundsData.get(k).playgroundName))
                        {
                            for(int m=0;m<mybooking.get(x).getNum_of_hour();m++)
                            {
                                playgroundownersdata.get(i).playgroundsData.get(k).change_available_hour_cancel(mybooking.get(x).getDay(), H);
                                playgroundownersdata.get(i).playgroundsData.get(k).change_booking_hour_cancel(mybooking.get(x).getDay(), H);
                                H++;
                            }
                            balance=balance+((mybooking.get(x).getNum_of_hour())*(mybooking.get(x).getHour_price()));
                            playgroundownersdata.get(i).balance=(playgroundownersdata.get(i).balance)-((mybooking.get(x).getNum_of_hour())*(mybooking.get(x).getHour_price()));
                            mybooking.remove(x);
                        }
                    }
                }
                System.out.println("Booking cancel Successfully");
            }

        }


    }
    ////////////////////////////////////////////////////////

    /**
     *
     */
    public void add_to_favorit_team()
    {
        String email;
        int loop=1,choice;
        do {
            System.out.println("Please,enter your friend e-mail .");
            email = input.next();
            for (int i = 0; i < playerData.size(); i++) {
                if (playerData.get(i).emile.equals(email))
                {
                    favorite_team.add(email);
                }

            }
            System.out.println("Are you want add more ?");
            System.out.println("1 - yes");
            System.out.println("2 - no");
            choice=input.nextInt();
            if(choice==2)
            {
                loop=0;
            }
        }while (loop==1);

    }
    /////////////////////////////////////////////////

    /**
     *
     */
    public void searchanotherplayer()
    {

        String choice,e_mail;
        System.out.println("Enter player  e-mail");
        e_mail=input.nextLine();
        for(int i=0;i<playerData.size();i++)
        {
            if(e_mail.equals(playerData.get(i).emile))
            {
                System.out.println("player name  : "+playerData.get(i).name);

            }
        }
    }
    //////////////////////////////////////////////////

    /**
     *
     */
    public void displaymyteam()
    {
        int x=1;
        for(int i=0;i<favorite_team.size();i++)
        {
            System.out.println(x +" - "+ favorite_team.get(i));
            x++;
        }
    }
    ///////////////////////////////////////

    /**
     *
     */
    public void  edit_my_info_player()
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
    ////////////////////////////////////////////////////////////

    /**
     *
     * @param num_of_hour
     * @param price_per_hour
     * @return
     */
    public double calculate_price(double num_of_hour,double price_per_hour)
    {
        return num_of_hour*price_per_hour;
    }

    //////////////////////////////////////////////////////////////////

    /**
     *
     * @param acountnum2
     * @return
     */
    public boolean check_acountnum_player(String acountnum2)
    {
        for(int i=0;i<playerData.size();i++)
        {
            if(playerData.get(i).acount_num.equals(acountnum2))
            {
                return true;
            }
        }
        return false;
    }
    /////////////////////////////////////////////////////////////////////

    /**
     *
     */
    public void create_ewallet_player() {
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
                if ( check_acountnum_player(acount_num2)) {
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

    /**
     *
     * @param playgroundowner_account
     * @param bill
     * @return
     */
    public boolean send_money_player(playgroundowner playgroundowner_account,double bill)
    {
        String r_acoount,pass;
        double amount;
        System.out.println("Enter your password .");
        pass=input.next();
        boolean operation=true;
        if(pass.equals(ewallet_pass))
        {
            System.out.println("your balance = " + balance);
            System.out.println("Enter the amount .");
            amount=input.nextDouble();
            System.out.println("Enter recever account num .");
            r_acoount=input.next();
            if(r_acoount.equals(playgroundowner_account.getAcount_num())&&amount==bill)
            {
                if(balance<amount)
                {
                    System.out.println("you didn't have enough balance .");
                    operation=false;
                }else
                {
                    balance=balance-amount;
                    playgroundowner_account.balance=playgroundowner_account.balance+amount;
                    System.out.println("succecful operation your balance = " +balance);
                    operation=true;
                }
            }else
            {System.out.println("Wrong account number or amount is smaller than bill .");
                operation=false;

            }

        }else
        {
            System.out.println("wrong password");
            operation =false;
        }
        return operation;

    }
    ///////////////////////////////////////////////

    /**
     *
     */
    void show_booking()
    {
        for(int i=0;i<mybooking.size();i++)
        {
            System.out.println("///////////////////////////////////////////////////////////////////////");
            System.out.println("Play groundname  ."+mybooking.get(i).getPlaygroundName());
            mybooking.get(i).getBooking_hours();
            System.out.println("Number of hours  ."+mybooking.get(i).getNum_of_hour());
            System.out.println("Day              ."+mybooking.get(i).getDay());
            System.out.println("Price per hour   ."+mybooking.get(i).getHour_price());
            System.out.println("Bill             ."+mybooking.get(i).getBill());
            System.out.println("///////////////////////////////////////////////////////////////////////");
        }
    }

    /**
     *
     */
    public void docomplain()
    {System.out.println("enter your emile ");
        String nameemile3=input.next();
        System.out.println("enter name of playground ");
        String nameplayground3=input.next();
        System.out.println("enter your complain  ");
        String complain4=input.next();
        complain mo=new complain(nameemile3,nameplayground3,complain4);
        arr_complain.add(mo);

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "player{" +
                "favorite_team=" + favorite_team +
                ", mybooking=" + mybooking +
                ", balance=" + balance +
                ", ewallet_pass='" + ewallet_pass + '\'' +
                ", acount_num='" + acount_num + '\'' +
                ", input=" + input +
                '}';
    }
}


