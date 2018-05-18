package com.yasas.carparkcw;

public class Motorbike extends Vehicle { 	// this extended to the vehicle class

    private int engineVolume;	//Declare  variable 

    public int getEngineVolume() {		// get the engine volume
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {		// return the engine volume
        this.engineVolume = engineVolume;
    }
   

    @Override
    public void VehicleCategory (String vehicleCategory ) {		//  set the vehicle category
        this.vehicleCategory  = vehicleCategory ;
    }
    @Override
    public void vehicleID(String id) {		//  set the vehicle id
        this.vehicleID=id;
    }

   

}

