package com.yasas.carparkcw;

public class DateTime {

    private int date;
    private int month;
    private int hours;		//Declare  variable 
    private int minutes;
    
    public DateTime(int date, int month, int hours, int minutes) {		// Constructer
        super();
        this.date = date;
        this.month = month;
        this.hours = hours;
        this.minutes = minutes;
 
    }

    public int getDate() {						//get the day
        return date;
    }

    public void setDate(int date) { 		//return the date
        this.date = date;
    }

    public int getMonth() {		//get the month
        return month;
    }

    public void setMonth(int month) {			//return the month	
        this.month = month;
    }

    public int getHours() {		
        return hours;						//get the hour
    }

    public void setHours(int hours) {		//return the hour	
        this.hours = hours;
    }

    public int getMinutes() {		//get the minutes
        return minutes;
    }

    public void setMinutes(int minutes) {		//return the minutes
        this.minutes = minutes;
    }

}

