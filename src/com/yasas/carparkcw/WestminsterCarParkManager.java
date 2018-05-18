package com.yasas.carparkcw;

import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterCarParkManager implements CarParkManager {

    private static Scanner intReader = new Scanner(System.in);  // Integer scanner
    private static Scanner stringReader = new Scanner(System.in);  // String scanner
    private static int counter = 1;   				
    private static int count = 0;					 //Declare  variable 
    private static String vehicleName;
    private static String ID;
    private static String cargoVolume;
    private static int date;
    private static int month=1;
    private static int hours;
    private static int minutes;
    private ArrayList<Vehicle> Slot; 		//Array list

    public static void main(String[] args) {
        WestminsterCarParkManager obj = new WestminsterCarParkManager(); 
        obj.Slot = new ArrayList<>(20);   // Array list object
        obj.mainMenu();
    }

    public void mainMenu() {

                System.out.println("---------------------------------"
                + "\n        CAR PARKING SYSTEM            " 
                + "\n---------------------------------" 
                + "\nA. Add a vehicle"
                + "\nD. Delete a vehicle" 
                + "\nB. Available space"
                + "\nC. Parking charges of the vehicles" 
                + "\nP. No. of vehicles parked"
                + "\nL. List of vehicle parked"
                + "\nO. Vehicles by order"
                + "\nF. Search vehicles by date"
                + "\nX. Exit" + "\n ---------------------------------\n Enter a number to the process:");
        try{
        do {
            String choice = stringReader.nextLine();
            
            switch (choice.toUpperCase()) {
                case "A":
                    addVehicle();
                    break;
                case "D":
                    deleteVehicle();
                    break;
                case "B":							
                    availableSpace(); 
                    break;
                case "C":
                    parkingChargesOfTheVehicles();
                    break;
                case "P":
                    noOfVehiclesParked(); 
                    break;
                case "L":
                    listOfVehicleParked();
                    break;
                case "O":
                    vehiclesByOrder(); 
                    break;
                case "F":
                    searchTheVehiclesByDate();   
                    break;
                case "X":
                    System.exit(0);
                    break;
                default:
                    System.err.println("Invalid Input! Input the correct number  to  the proceed.");
            }
        } while (counter == 1);
    }catch(Exception e){				// try catch Exception handling 			
        System.err.println("Please insert valid inputs");
        mainMenu();		// this call the mainMenu method and it repeat until user enter the correct input
    }
    }


    @Override
    public void addVehicle() {			// add method
        System.out.print("\n Enter the Vehicle Category:" + "\n c - Car" + "\n v - Van" + "\n m - Motorbike");
        char input = intReader.next().charAt(0);
        if(input=='C' || input=='c' || input=='V' || input=='v' || input=='M' || input=='m' ){
        }else{
            System.err.println("Enter the correct input");
            addVehicle(); 		// after the error msg add vehicle method call
        }

        System.out.print("Enter the vehicle name: "); 
        vehicleName = stringReader.nextLine();

        System.out.print("Enter the VehicleID: ");
        ID = stringReader.nextLine();

        System.out.print("Enter the Date: ");
        date = intReader.nextInt();
        validateDate();
        
        System.out.print("Enter the Month: ");
        month = intReader.nextInt();
        validateDate();
        
        System.out.print("Entry Hour: ");
        hours = intReader.nextInt();
        validateTime();
        
        System.out.print("Entry Minutes: ");
        minutes = intReader.nextInt();
        validateTime();
        
        DateTime DT = new DateTime(date, month, hours, minutes);		// create a new dateTime object

        if (input == 'c' || input == 'C') {
        	
            Car car = new Car();		// new car object
            System.out.print("Enter the Colour: ");
            String colour = stringReader.nextLine();
            System.out.print("Enter the Doors: ");
            int doors = intReader.nextInt();

            car.setVehicleCategory("Car");
            car.setVehicleID(ID);
            car.setVehicleName(vehicleName);
            car.setColour(colour);
            car.setEntryTime(DT);
            System.out.println("Added successfully");

            if (count < 20) {
                Slot.add(car);		// this used to stay in count of 20
                count++;
            } else {
                System.err.println("No Space Availabe");
            }
            mainMenu();
        }

        if (input == 'v' || input == 'V') {
        
            Van van = new Van();		// new van object
            System.out.println("Cargo Volume: ");
            String cargoVolume = stringReader.nextLine();
            van.setVehicleCategory("Van");
            van.setVehicleID(ID);
            van.setVehicleName(vehicleName);
            van.setCargoVolume(cargoVolume);
            van.setEntryTime(DT);
            System.out.println("Added successfully");

            if (count < 20) {
                Slot.add(van);			// this used to stay in count of 20
                count++;
            } else {
                System.err.println("No Space Availabe");
            }
            mainMenu();
        }

        if (input == 'm' || input == 'M') {
        
            Motorbike bike = new Motorbike();		// new motorbike object
            bike.setVehicleCategory("Motorbike");	// 
            bike.setVehicleID(ID);
            bike.setVehicleName(vehicleName);
            bike.setEntryTime(DT);
            System.out.println("Added successfully");

            if (count < 20) {
                Slot.add(bike);			// this used to stay in count of 20
                count++;
            } else {
                System.err.println("No Space Availabe");
            }
            mainMenu();
        }
        }
    

    @Override
    public void deleteVehicle() {   // delete method

        System.out.print("Enter the ID: ");
        String id = stringReader.nextLine();

        for (int i = 0; i < Slot.size(); i++) {
            if (Slot.get(i).vehicleID.equals(id)) {
                System.out.println("Delete Successfully! The vehicle ID: " + Slot.get(i).getVehicleID());
                Slot.remove(i);  	// this used to delete the selected vehicle from the vehicle id
                count--;
                break;		// if the id correct it delete the vehicle and stop the delete vehicle method
            }else{
            	continue;		// if the id wrong the method continue
            }
        }

        mainMenu();  // again mainMenu method call 
    }
    
     @Override
    public void availableSpace() {			//availabe space method
        System.out.println("");
        System.out.println("Available  " + (20 - count) + " spaces");
    }
    
    @Override
    public void parkingChargesOfTheVehicles() {   // parking charge method

        int mins = 0, hours = 0;
        do {
            System.out.print("Enter the hours :");
            hours = intReader.nextInt();
            System.out.print("Enter the minutes : ");
            mins = intReader.nextInt();

        } while (((hours < 00) || (hours > 24)) && ((mins < 00) || (mins > 60)));

        for (int i = 0; i < Slot.size(); i++) {

            int getHour = Slot.get(i).getEntryTime().getHours();
            int getMinute = Slot.get(i).getEntryTime().getMinutes();

            int MinuteDifference;
            if (mins < getMinute) {
                MinuteDifference = 60 + mins - getMinute;
                if (hours == 00) {
                    hours = 23;
                } else {
                    hours--;
                }
            } else {
                MinuteDifference = mins - getMinute;
            }

            int hourDifference;
            if (hours < getHour) {
                hourDifference = hours + 24 - hours;
            } else {
                hourDifference = hours - getHour;
            }

            int Outlay = 0;
            int x = 1;

            double parkedTime = Math.ceil(hourDifference + (MinuteDifference * 1.0 / 60));

            if (parkedTime > 6) {
                Outlay = 30;
            } else {
                if (parkedTime > 3) {
                    Outlay = 9;
                    x = 4;
                }
            }
            for (; x <= parkedTime; x++) {
                if (parkedTime > 3) {
                    Outlay += 3;
                } else {
                    Outlay += 3;
                }
            }
            System.out.println("Vehicle ID No : " + Slot.get(i).getVehicleID() + "\n Outlay : " + Outlay);
        }
    }

    @Override
    public void listOfVehicleParked() {   // list of parked method

        System.out.println("Type" + "\t" + "ID" + "\t" + "Name" + "\t" + "Date" + "\t" + "Month" 
                + "\t" + "Hours" + "\t" + "Minutes");

        for (int i = 0; i < Slot.size(); i++) {

            if ("Car".equals(Slot.get(i).vehicleCategory)) {

                System.out.println(Slot.get(i).getVehicleCategory()
                        + "\t" + Slot.get(i).getVehicleID()
                        + "\t" + Slot.get(i).getVehicleName() 
                        + "\t" + Slot.get(i).getEntryTime().getDate()
                        + "\t" + Slot.get(i).getEntryTime().getMonth() 
                        + "\t" + Slot.get(i).getEntryTime().getHours() + "\t"
                        + Slot.get(i).getEntryTime().getMinutes());
            }

            if ("Van".equals(Slot.get(i).vehicleCategory)) {
                Van van = new Van();
                System.out.println(Slot.get(i).getVehicleCategory() 
                        + "\t" + Slot.get(i).getVehicleID() 
                        + "\t" + Slot.get(i).getVehicleName()
                        + "\t" + Slot.get(i).getEntryTime().getDate() 
                        + "\t" + Slot.get(i).getEntryTime().getMonth() 
                        + "\t" + Slot.get(i).getEntryTime().getHours() 
                        + "\t" + Slot.get(i).getEntryTime().getMinutes());
            }

            if ("Motorbike".equals(Slot.get(i).vehicleCategory)) {
                Motorbike bike = new Motorbike();
                System.out.println(Slot.get(i).getVehicleCategory() 
                        + "\t" + Slot.get(i).getVehicleID() 
                        + "\t" + Slot.get(i).getVehicleName() 
                        + "\t" + Slot.get(i).getEntryTime().getDate() 
                        + "\t" + Slot.get(i).getEntryTime().getMonth() 
                        + "\t" + Slot.get(i).getEntryTime().getHours() 
                        + "\t" + Slot.get(i).getEntryTime().getMinutes());
            }
        }

    }

    @Override
    public void vehiclesByOrder() {			//vehicle by order method
        System.out.println("Type" + "\t" + "ID" + "\t" + "Name");

        for (int i = Slot.size() - 1; i >= 0; i--) {
            System.out.println(Slot.get(i).getVehicleCategory() 
                    + "\t" + Slot.get(i).getVehicleID() 
                    + "\t" + Slot.get(i).getVehicleName());
        }
    }
    
     @Override
    public void noOfVehiclesParked() { 		 // no. of vehicle park method
        System.out.println("");
        System.out.println("Total vehicles: " + count);
    }


    @Override
    public void searchTheVehiclesByDate() {		// search by date method
        System.out.print("date: ");
        int date = intReader.nextInt();
        System.out.print("Month: ");
        int month = intReader.nextInt();

        System.out.println("Type" + "\t" + "ID" + "\t" + "Name");
        for (int i = 0; i < Slot.size(); i++) {
            if (date == Slot.get(i).getEntryTime().getDate() && month == Slot.get(i).getEntryTime().getMonth()) {

                System.out.println(Slot.get(i).getVehicleCategory() 
                        + "\t" + Slot.get(i).getVehicleID() 
                        + "\t" + Slot.get(i).getVehicleName());
            }
        }
    }
    
    //Validation of Date
	
	public void validateDate() {
		
		 if((month==1 ||  month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (date>31 || date<=0)){ 
			System.out.println("##### The day you entered is invalid ####");	
			System.out.print("Enter the current day: ");
			date=intReader.nextInt();
		}else if((month==2 ||  month==4 || month==6 || month==9 || month==11) && (date>30|| date<=0)){		
			System.out.println("##### The day you entered is invalid ####");	
			System.out.print("Enter the current day: ");
			date=intReader.nextInt();
		}
                    
          if(month>12 || month<=0){
			System.out.println("The month you entered is invalid");	
			System.out.print("Enter the current month: ");
			month=intReader.nextInt(); 
		}
	}
        
        //Validation of time
	
	public void validateTime() {
		// TODO Auto-generated method stub
		if(hours<0 || hours>=24){
			System.err.println("#### Hour entered is invalid ####");
			System.out.print("Enter the entrance hour: ");
			hours=intReader.nextInt();
		}else if(minutes>60){
			System.err.println("#### Minutes entered are invalid#### ");
			System.out.print("Enter the entrance minutes: ");
			minutes=intReader.nextInt();
		}

	}
    
    
      
    @Override
    public void menu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

