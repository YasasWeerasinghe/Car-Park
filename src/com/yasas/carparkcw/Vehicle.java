package com.yasas.carparkcw;

public abstract class Vehicle {
    
public abstract void VehicleCategory (String vehicleCategory );		
public abstract void vehicleID(String id);		

public String vehicleID;
private String vehicleName;			//Declare  variable 
public String vehicleCategory ;
private DateTime entryTime;

    public String getVehicleID() { 						//  this get the vehicle ID
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {		// this return the vehicle ID
        this.vehicleID = vehicleID;
    }

    public String getVehicleName() {				//  this get the vehicle name
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {		// this return the vehicle name
        this.vehicleName = vehicleName;
    }

    public String getVehicleCategory () {		//  this get the vehicle category
        return vehicleCategory ;
    }

    public void setVehicleCategory (String vehicleCategory ) { 			// this return the vehicle category	
        this.vehicleCategory  = vehicleCategory ;
    }

    public DateTime getEntryTime() {		//  this get the vehicle entry time
        return entryTime;
    }

    public void setEntryTime(DateTime entryTime) {		// this return the vehicle entry time	
        this.entryTime = entryTime;
    }

}



