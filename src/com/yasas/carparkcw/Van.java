package com.yasas.carparkcw;

public class Van extends Vehicle { 	// this extended to the vehicle class
    private String cargoVolume;

    public String getCargoVolume() {  // get cargo volume 
        return cargoVolume;
    }

    public void setCargoVolume(String cargoVolume) {		 // return cargo volume 
        this.cargoVolume = cargoVolume;
    }
    
    @Override
    public void VehicleCategory (String vehicleCategory ) {    //  set the vehicle category
        this.vehicleCategory =vehicleCategory ;
    }
    @Override
    public void vehicleID(String id) {     //  set the vehicle id
        this.vehicleID=id;
    }
    
}
