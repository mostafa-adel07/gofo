package gofosoft;

import java.util.Scanner;
import java.util.Random;




public class Main {
    /**
     *
     * @param playground_owner
     */
    static void playgroundowner_menu(playgroundowner playground_owner)
    {

        Scanner owner = new Scanner(System.in);
        int loop1=0;
        do {
            int choice_owner_menu;
            System.out.println("1 - Add playground .");
            System.out.println("2 - Display all playgrounds .");
            System.out.println("3 - Change available hours .");
            System.out.println("4 - Edit my info . ");
            System.out.println("5 - Update playground info .");
            System.out.println("6 - Display booking hours .");
            System.out.println("7 - Display available hours . ");
            System.out.println("8 - Show my balance .");
            System.out.println("9 - log out .");
            choice_owner_menu = owner.nextInt();
            if (choice_owner_menu == 1) {
                playground_owner.add_playground();
            } else if (choice_owner_menu == 2) {
                playground_owner.display_all_playgrunds();
            } else if (choice_owner_menu == 3) {
                playground_owner.change_available_hours();
            } else if (choice_owner_menu == 4) {
                playground_owner.edit_my_info_owner();
            } else if (choice_owner_menu == 5) {
                playground_owner.update_playground_info();
            } else if (choice_owner_menu == 6) {
                playground_owner.displayBookingHours();
            } else if (choice_owner_menu == 7) {
                playground_owner.displayAvailableHours();
            }else if(choice_owner_menu==8)
            {
                System.out.println("Your balance  =  "+playground_owner.getBalance());  ;
            } else if (choice_owner_menu == 9) {
                loop1=1;
            }else if(choice_owner_menu>9||choice_owner_menu<1)
            {
                System.out.println("Wrong choice ");
                loop1=0;
            }

        }while (loop1==0);

    }
    ////////////////////////////

    /**
     *
     * @param player
     */
    static void player_menu(player player)
    {
        int choice_player_menu;

        Scanner player_in = new Scanner(System.in);
        int loop2=0;
        do{
            System.out.println("1 - Search playground by location .");
            System.out.println("2 - Search playground  by date .");
            System.out.println("3 - Booking .");
            System.out.println("4 - Cancel booking .");
            System.out.println("5 - Add my friend to my favorite team .");
            System.out.println("6 - Search another player .");
            System.out.println("7 - Display my team .");
            System.out.println("8 - Edit my info .");
            System.out.println("9 - Show my bookings .");
            System.out.println("10 - My balance .");
            System.out.println("11 -send complain");
            System.out.println("12 - Log out");
            choice_player_menu=player_in.nextInt();
            if (choice_player_menu==1)
            {
                System.out.println("Please enter city name . ");
                String S_city=player_in.next();
                player.searchbylocation(S_city);
            }
            else if(choice_player_menu==2)
            {
                System.out.println("Please enter enter the date  . ");
                System.out.println("1-saturday\n2-sunday\n3-monday\n4-tuesday \n5-wednesday\n6-thursday\n7-friday ");

                System.out.println("Day :");
                int S_day=player_in.nextInt();
                System.out.println("Hour :");
                int S_hour=player_in.nextInt();

                player.searchbydate(S_day,S_hour);
            }
            else if(choice_player_menu==3)
            {
                System.out.println("please Enter playground name .");
                String name=player_in.next();
                System.out.println("Please enter enter the date  . ");
                System.out.println("1-saturday\n2-sunday\n3-monday\n4-tuesday \n5-wednesday\n6-thursday\n7-friday ");

                System.out.println("Day :");
                int S_day=player_in.nextInt();
                System.out.println("Hour :");
                int S_hour=player_in.nextInt();
                System.out.println("Enter number of hour ");
                int num_of_hours=player_in.nextInt();
                player.booking(S_hour,S_day,num_of_hours,name);

            }
            else if(choice_player_menu==4)
            {
                player.show_booking();
                System.out.println("Enter playground name that uou want cancel .");
                String p_name=player_in.next();
                player.cancel_booking(p_name);

            }
            else if(choice_player_menu==5)
            {

                player.add_to_favorit_team();

            }
            else if(choice_player_menu==6)
            {
                player.searchanotherplayer();
                System.out.println("Are you want add this player to your favorit team ? ");
                System.out.println("1 - yes . ");
                System.out.println("2 - No");
                int choice2=player_in.nextInt();
                if(choice2==1)
                {
                    player.add_to_favorit_team();
                }
            }

            else if(choice_player_menu==7)
            {
                player.displaymyteam();
            }
            else if(choice_player_menu==8)
            {
                player.edit_my_info_player();
            }
            else if(choice_player_menu==9)
            {
                player.show_booking();
            }
            else if(choice_player_menu==10)
            {
                System.out.println("Your balance = "+player.getBalance());
            }
            else if(choice_player_menu==11)
            {
              player.docomplain();
            }
            else if(choice_player_menu==12)
            {
                loop2=1;
            }
            else if(choice_player_menu>12||choice_player_menu<1)
            {
                System.out.println("Wrong choice ");
                loop2=0;
            }



        }while (loop2==0);

    }

    /**
     *
     * @param administrator
     */
   static void administrator_menu(administrator administrator)
    {  Scanner admin = new Scanner(System.in);
        String wont;
       do {
           System.out.println("Welcom as administrator ");
           System.out.println("enter number the operation ");
           System.out.println("1-approve playgrounds ");
           System.out.println("2-delet playgrounds ");
           System.out.println("3-suspend playgrounds ");
           System.out.println("4-active playgrounds ");
           System.out.println("5-show playgrounds ");
           System.out.println("6-show the complains ");
           int numoper = admin.nextInt();
           if (numoper == 1) {
               administrator.print_witing_playground();
               System.out.println("enter name of playground what you approve it ");
               String nameplayground = admin.next();
               System.out.println("enter nameber of operation ");
               System.out.println("1-if data is correct approve it ");
               System.out.println("2-if data not corrcet delet it ");
               int numberoperation5=admin.nextInt();
               administrator.aprove(nameplayground,numberoperation5);

           } else if (numoper == 2) {
               administrator.delet_playground();
           } else if (numoper == 3) {
               System.out.println("enter name of playground what you suspend it ");
               String nameplayground = admin.next();
               administrator.suspend_playground(nameplayground);

           } else if (numoper == 4) {
               System.out.println("enter name of playground what you active it ");
               String nameplayground = admin.next();
               administrator.active_playground(nameplayground);
           }
           else if(numoper==5)
           {
               administrator.print_playground();
           }
           else if(numoper==6)
           {
               administrator.print_complin();
           }
           System.out.println("you want do more operation as admin?(yes or no)");
            wont=admin.next();
       }while (wont.equals("yes"));

    }

    /////////////////////////////////////////////////////////////////////////
    static int tryagain=1;
    /////////////////////////////////

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Scanner cin = new Scanner(System.in);
        user gofo = new user();
        administrator admin=new administrator("ahmed","administrator","3000542664","ahmed@def.com","cairo,helwan.5RailSTRRET",01122334455,"123456789");

        gofo.administratorsData.add(admin);
        String emile;

        int choice,loop1_exit=1,choice_player_menu,loop_email=1;
        int vertfi_code,code;
        boolean bool=true;
       // System.out.print("kkkkkkkkkkkk");
        do {//loop1
            int loop_signout=2;

            System.out.println("welcom in GOFO");
            System.out.println("enter number of operation");
            System.out.println("1-login");
            System.out.println("2-sign up");
            System.out.println("3-exit");
            choice = cin.nextInt();

            if (choice == 1) {
            	 int usertype;
                System.out.println("enter email");
                String email = cin.next();
                do {
                System.out.println("Choice user type");
                System.out.println("1 - playground owner");
                System.out.println("2 - player");
                System.out.println("3 - administrator");
                 usertype = cin.nextInt();
                 if(usertype!=1&&usertype!=2&&usertype!=3)
                 {
                	  System.out.println(" you enter invalide number please inter 1 or 2 or 3");
                 }
                }while(usertype!=1&&usertype!=2&&usertype!=3);
                System.out.println("enter password");
                String password2 = cin.next();
                if (usertype==1 )
                {
                    for (int i = 0; i < gofo.playgroundownersdata.size(); i++)
                    {
                        if (gofo.playgroundownersdata.get(i).password.equals(password2) && gofo.playgroundownersdata.get(i).emile.equals(email)) {
                            playgroundowner_menu(gofo.playgroundownersdata.get(i));



                        }
                    }
                }
                else if(usertype==2)
                {
                    for (int i = 0; i < gofo.playerData.size(); i++)
                    {
                        if (gofo.playerData.get(i).password.equals(password2) && gofo.playerData.get(i).emile.equals(email)) {
                            player_menu(gofo.playerData.get(i));



                        }
                    }
                }
                else if(usertype==3)
                {
                    for (int i = 0; i < gofo.administratorsData.size(); i++)
                    {
                        if (gofo.administratorsData.get(i).password.equals(password2) && gofo.administratorsData.get(i).emile.equals(email)) {
                            administrator_menu(gofo.administratorsData.get(i));



                        }
                    }
                }


            }
            else if (choice == 2) {
            	int usertype;
                System.out.println("enter name");
                String name = cin.next();
                do {
                System.out.println("enter user type");
                System.out.println("1 - playground owner");
                System.out.println("2 - player");
                 usertype = cin.nextInt();
                 if(usertype!=1&&usertype!=2)
                 {
                	  System.out.println(" you enter invalide number please inter 1 or 2");
                 }
                }while(usertype!=1&&usertype!=2);
                System.out.println("enter id");
                String id = cin.next();
                System.out.println("enter phone");
                double phone = cin.nextDouble();
                //////////////
                do {
                    System.out.println("Enter e-mail in this form abc@def.com");
                    emile = cin.next();
                    if(gofo.check_email(emile))
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("E-mail is exist or wrong ");
                        System.out.println("Press( 1 )to try another e-mail ");
                        System.out.println("Press any number to Return to main menu");
                        tryagain=cin.nextInt();
                        if(tryagain==1){loop_email=1;}
                        else{loop_email=0;}

                    }
                }while (loop_email==1);

                if (usertype==1 && tryagain==1) {
                    do {
                        System.out.println("Please enter a verification code");

                        Random rand = new Random();
                        vertfi_code = rand.nextInt(1000);
                        System.out.println("verification code :" + vertfi_code);
                        code = cin.nextInt();
                    }while (code!=vertfi_code);
                    /*System.out.println("Please enter a verification code");

                    Random rand=new Random();
                    int vertfi_code=rand.nextInt(1000);
                    System.out.println("verification code :" + vertfi_code);
                    int code=cin.nextInt();*/
                    System.out.println("enter location");
                    String location = cin.next();
                    System.out.println("enter password");
                    String password = cin.next();
                    playgroundowner user1 = new playgroundowner(name, "playgroundowner", id, emile, location, phone, password);
                    System.out.println("welcome in gofo as playgroundowner");
                    System.out.println("Please create your E - wallet .");
                    user1.create_ewallet_playgroundowner();
                    gofo.playgroundownersdata.add(user1);
                    System.out.println("succced as playgroundowner");
                    int h=gofo.playgroundownersdata.size()-1;
                     playgroundowner_menu(gofo.playgroundownersdata.get(h));
                } else if (usertype==2 && tryagain==1) {
                    /*System.out.println("Please enter a verification code");

                    Random rand2=new Random();
                    int vertfi_code=rand2.nextInt(1000);
                    System.out.println("verification code :" + vertfi_code);
                    int code=cin.nextInt();*/
                    do {
                        System.out.println("Please enter a verification code");

                        Random rand = new Random();
                        vertfi_code = rand.nextInt(1000);
                        System.out.println("verification code :" + vertfi_code);
                        code = cin.nextInt();
                    }while (code!=vertfi_code);
                    System.out.println("enter location");
                    String location = cin.next();
                    System.out.println("enter password");
                    String password = cin.next();
                    player user2 = new player(name, "player", id, emile, location, phone, password);
                    System.out.println("welcom in gofo as player");
                    System.out.println("Please create your E - wallet .");
                    user2.create_ewallet_player();
                    gofo.playerData.add(user2);
                    System.out.println("succced as player");
                    int h=gofo.playerData.size()-1;
                    player_menu(gofo.playerData.get(h));

                }


            }else if(choice==3){loop1_exit=0;}//break loop1

        }while (loop1_exit==1);//loop1
    }




}
