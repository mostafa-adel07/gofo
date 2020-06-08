package gofosoft;

public class playground {


    //variables
    protected String playgroundName;
    protected String playgroundLocation;
    protected int size;
    protected String city;
    protected int [][] available_hours = new int[7][24];
    protected float hour_price;
    protected int [][] booking_hours = new int[7][24];



    //setters and getters

    /**
     *
     * @return
     */
    public String getPlaygroundName() {
        return playgroundName;
    }

    /**
     *
     * @param playgroundName
     */
    public void setPlaygroundName(String playgroundName) {
        this.playgroundName = playgroundName;
    }

    /**
     *
     * @return
     */
    public String getPlaygroundLocation() {
        return playgroundLocation;
    }

    /**
     *
     * @param playgroundLocation
     */
    public void setPlaygroundLocation(String playgroundLocation) {
        this.playgroundLocation = playgroundLocation;
    }

    /**
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }

    /**
     *
     * @param day
     * @param hour
     * @return
     */
    public int getAvailable_hours(int day,int hour) {
        return available_hours[day][hour];
    }

    /**
     *
     * @param available_hours
     */
    public void setAvailable_hours(int[][] available_hours) {
        this.available_hours = available_hours;
    }

    /**
     *
     * @return
     */
    public float getPrice_hours() {
        return hour_price;
    }

    /**
     *
     * @param price_hours
     */
    public void setPrice_hours(float price_hours) {
        this.hour_price = price_hours;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public int[][] getBooking_hours() {
        return booking_hours;
    }

    /**
     *
     * @param booking_hours
     */
    public void setBooking_hours(int[][] booking_hours) {
        this.booking_hours = booking_hours;
    }





    //parametrize constructor

    /**
     *
     * @param playgroundName
     * @param playgroundLocation
     * @param city
     * @param size
     * @param available_hours
     * @param price_hours
     * @param booking_hours
     */
    public playground(String playgroundName, String playgroundLocation, String city, int size, int[][] available_hours, float price_hours, int[][] booking_hours) {
        this.playgroundName = playgroundName;
        this.playgroundLocation = playgroundLocation;
        this.size = size;
        this.city = city;
        this.available_hours = available_hours;
        this.hour_price = price_hours;
        this.booking_hours = booking_hours;
    }


    //default constructor

    /**
     *
     */
    public playground() {
        playgroundName = "";
        playgroundLocation = "";
        size =0;
        hour_price = 0;
        city = "";
    }

    /**
     *
     * @param day
     * @param hour
     */
    public void change_available_hour_booking(int day,int hour)
    {
        available_hours[day-1][hour-1]=0;
    }

    /**
     *
     * @param day
     * @param hour
     */
    public void change_booking_hour_booking(int day,int hour)
    {
        booking_hours[day-1][hour-1]=hour;
    }

    /**
     *
     * @param day
     * @param hour
     */
    public void change_booking_hour_cancel(int day,int hour)
    {
        booking_hours[day-1][hour-1]=0;
    }

    /**
     *
     * @param day
     * @param hour
     */
    public void change_available_hour_cancel(int day,int hour)
    {
        available_hours[day-1][hour-1]=hour;
    }

    /**
     *
     * @param Day
     * @param hour
     * @param num_of_hour
     * @return
     */
    public boolean check_available__hour_booking(int Day,int hour,int num_of_hour)
    {
        boolean check=true;
        int hour_test=hour-1;
        int loop=0;
        if(available_hours[Day-1][hour-1]!=0)
        {

            while (loop<num_of_hour)
            {

                if(available_hours[Day-1][hour_test]!=0)
                {
                    check=true;
                }else
                {
                    check=false;
                    break;
                }
                loop++;
                hour_test++;

            }
            return check;
        }else
        {
            check=false;
            return  check;
        }

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "playground Data" + '\n' +
                "playgroundName : " + playgroundName + '\n' +
                "playgroundLocation: " + playgroundLocation + '\n'+
                "Playground City: " + city + '\n' +
                "size: " + size + '\n' +
                "price per hour: " + hour_price + '\n' ;
    }
}
