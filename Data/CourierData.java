package Data;
import java.io.*;
import java.util.Scanner;
import CourierF.*;
import CourierListF.*;

public class CourierData{
	
	public static void readFromFile(String fname,CourierList courierList){
		try{
			Scanner sc=new Scanner(new File(fname)); 
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(";");

				int courierId = Integer.parseInt(data[0]);
				int quantity= Integer.parseInt(data[1]);
				double weight= Double.parseDouble(data[2]);
				

				CourierF.Courier C = new CourierF.Courier(quantity,weight,courierId);
				courierList.insertCourier(C);
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("Cannot Read the File");
		}
	}
	
	public static void writeInFile(String line, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		writer.write(line+"\n");
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
	public static void saveCourierListInFile(CourierList courierList, String fname, boolean append){
		try {
		FileWriter writer = new FileWriter(fname,append);
		Courier couriers[] = courierList.getAllCourier();
		
		for(int i=0;i<couriers.length;i++){
			if(couriers[i]!=null){
				writer.write(couriers[i].toString()+"\n");
			}
		}
		
		writer.close();
		} catch (IOException e) {
			System.out.println("Cannot Write in File");
		}
	}
}
