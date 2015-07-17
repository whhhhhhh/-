package model;

import android.text.format.Time;

public class MyMessage {
   private int type;
   private String content;
   private Time time;
   private User sender;
   
   public void setType(int type){
       this.type = type;
   }
   
   public void setContent(String content){
       this.content = content;
   }
   
   public void setTime(Time time){
       this.time = time;
   }
   
   public void setSender(User user){
       this.sender = user;
   }
   
   public int getType(){
       return type;
   }
   
   public String getContent(){
      return content;   
   }
   
   public Time getTime(){
       return time;
   }
   
   public User getSender(){
       return sender;
   }
}
