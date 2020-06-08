package gofosoft;


public class complain {
    String playernameemail;
    String nameplayground;
    String complint;

    /**
     *
     */
    complain(){};

    /**
     *
     * @param emil
     * @param nameplayground
     * @param complint
     */
    complain(String emil,String nameplayground,String complint)
    {
        this.playernameemail=emil;
        this.nameplayground=nameplayground;
        this.complint=complint;
    }

    /**
     *
     */
    public void tostring()
    {
        System.out.println("emile of player: "+playernameemail);
        System.out.println("name of playground: "+nameplayground);
        System.out.println("the complain: "+complint);
    }
}
