package com.steven;

import java.lang.ClassNotFoundException;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Main extends ClassNotFoundException{

    public static void main(String[] args) {
        GregorianCalendar d = new GregorianCalendar();
        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);
        d.set(Calendar.DAY_OF_MONTH,1);
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        int firstdayofweek = d.getFirstDayOfWeek();
        int indent =0;
        while(weekday!=firstdayofweek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }
        String[] weekNames = new DateFormatSymbols().getShortWeekdays();
        do{
            System.out.print(weekNames[weekday]+" ");
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }while(weekday!=firstdayofweek);
        System.out.println();
        for (int i=1;i<=indent;i++){
            System.out.print("   ");
        }
        d.set(Calendar.DAY_OF_MONTH,1);
        do{
            int day = d.get(Calendar.DAY_OF_MONTH);
            if(day<10) System.out.print("0");
            System.out.print(day);
            if(day==today) System.out.print("*");
            else System.out.print(" ");
            d.add(Calendar.DAY_OF_MONTH,1);
            if((d.get(Calendar.DAY_OF_WEEK))==d.getFirstDayOfWeek()) System.out.println();
        }while(d.get(Calendar.MONTH)==month);
        if(d.get(Calendar.DAY_OF_WEEK)!=weekday) System.out.println();

    }
}
