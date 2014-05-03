public class pa_Time{
  public int time = 0; //Minutes since Game start
  public int time_minor = 0; //parts of minutes, unimportant
  private Integer day = null;
  private Integer hour = null;
  private Integer minute = null;
  
  public pa_Time(String text){
    String[] Times = text.split("\\.");
    time = Integer.parseInt(Times[0]);
    if (Times.length>1) 
    {
      time_minor = Integer.parseInt(Times[1]);
    }
  }
  
  public pa_Time(int time){
    this.time = time;
  }
  
  public String toDataString(){
    return Integer.toString(time) + "." + Integer.toString(time_minor);
  }
  
  public static int getDay(pa_Time time){
    Double day = (double) time.time/1440;
    return day.intValue() + 1;
  }
  
  public int getDay(){
    if (day == null) 
    {
      day = getDay(this);
    }
    return day;
  }
  
  public static int getHour(pa_Time time){
    int todayMinutes = time.time % 1440;
    Double hour = (double) todayMinutes/60;
    return hour.intValue();
  }
  
  public int getHour(){
    if (hour == null) 
    {
      hour = getHour(this);
    }
    return hour;
  }
  
  public static int getMinute(pa_Time time){
    return time.time % 60; 
  }
  
  public int getMinute(){
    if (minute == null) 
    {
      minute = getMinute(this);
    }
    return minute;
  }
}