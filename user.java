package gofosoft;

import java.util.ArrayList;

public class user {

    protected    String emile;
    protected   String id;
    protected String name;
    protected String password;

    protected String location;
    protected  String  usertype;
    protected  double phone ;



    //  user arr1[];


    protected  static ArrayList<player> playerData = new ArrayList<player>();
    protected  static ArrayList<playgroundowner> playgroundownersdata = new ArrayList<playgroundowner>();
    protected  static ArrayList<administrator> administratorsData = new ArrayList<>();

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
    user(String name1,String usertype1,String id1,String emile1,String location1,double phone1,String password1)
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
     * @param c
     */
    user(user c)
    {
        name=c.name;
        usertype=c.usertype;
        id=c.id;
        emile=c.emile;
        location=c.location;
        phone=c.phone;
        password=c.password;

    }

    /**
     *
     */
    user()
    {}

    /**
     *
     * @param email
     * @return
     */
    boolean check_email(String email)
    {
        boolean index_a,index_dot;
        index_a=email.contains("@");
        index_dot=email.contains(".");
        if(index_a && index_dot)
        {
            for(int i=0;i<playerData.size();i++)
            {
                if(playerData.get(i).emile.equals(email))
                {

                    return false;
                }
            }
            for (int i=0;i<playgroundownersdata.size();i++)
            {
                if(playgroundownersdata.get(i).emile.equals(email))
                {
                    return false;
                }
            }
            return true;
        }
        else
        {return false;}


    }





}
