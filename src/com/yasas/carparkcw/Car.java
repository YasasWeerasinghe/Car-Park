package com.yasas.carparkcw;

public class Car extends Vehicle { 	 // this extended to the vehicle class
    
	   private int door;
	   private String colour;		//Declare  variable 
	  

	    public int getDoor() {							// get the doors count
	        return door;
	    }

	    public void setDoor(int doors) {		// return the doors count
	        this.door = doors;
	    }

	    public String getColour() {		// get the colour
	        return colour;
	    }

	    public void setColour(String colour) {		//return the colour
	        this.colour = colour;
	    }

	    @Override
	    public void VehicleCategory (String vehicleCategory ) {		//  set the vehicle category
	        this.vehicleCategory =vehicleCategory ;
	    }

	    @Override
	    public void vehicleID(String id) {		//  set the vehicle id
	        this.vehicleID=id;
	    } 
	}
