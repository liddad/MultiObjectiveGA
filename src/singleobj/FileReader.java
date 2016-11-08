package singleobj;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	
	public static ReqSystem readData(String filename){
		String val = "";
		Scanner scan;
		int noOfRequirements;

	      try {
	    	 
	         Class cls = Class.forName("ga.FileReader");

	         // returns the ClassLoader object associated with this Class
	         ClassLoader cLoader = cls.getClassLoader();
	         // input stream
	         InputStream is = cLoader.getResourceAsStream(filename);
	         BufferedReader br = new BufferedReader(new InputStreamReader(is));
	         
	         //Read costs of requirements
	         val = br.readLine();
	         scan = new Scanner(val);
	         int levels = scan.nextInt();
	         int totalCost = 0;
	         List<Integer> costs = new ArrayList<Integer>();
	         for(int i = 0; i<levels; i++){
	        	 val = br.readLine();
	        	 scan = new Scanner(val);
	        	 noOfRequirements = scan.nextInt();
	        	 val = br.readLine();
	        	 scan = new Scanner(val);
	        	 for(int j = 0; j < noOfRequirements; j++){
	        		 costs.add(scan.nextInt());
	        		 totalCost+=costs.get(j);
	        	 }
	         }
	         //Skip all the dependencies
	         val = br.readLine();
	         scan = new Scanner(val);
	         int linesToSkip = scan.nextInt();
	         for(int i = 0; i<linesToSkip; i++){
	        	 br.readLine();
	         }
	         
	         //Customer Requirements
	         val = br.readLine();
	         scan = new Scanner(val);
	         
	         int noOfCustomers = scan.nextInt();
	         int noOfCustomerRequirements;
	         double customerWeighting;
	         double weightingTotal = 0;
	         double sum;
	         List<Integer> customerRequirements;
	         List<Double> requirementWeightings;
	         List<Customer> customerList = new ArrayList<Customer>();
	         for(int i = 0; i < noOfCustomers; i++){
	        	 val = br.readLine();
	        	 scan = new Scanner(val);
	        	 customerWeighting = scan.nextDouble();
	        	 weightingTotal += customerWeighting;
	        	 noOfCustomerRequirements = scan.nextInt();
	        	 customerRequirements = new ArrayList<Integer>();
	        	 requirementWeightings = new ArrayList<Double>();
	        	 //Sum of n natural numbers = n(n+1)/2
	        	 sum = noOfCustomerRequirements*((noOfCustomerRequirements+1)/2);
	        	 for (int j = 0; j<noOfCustomerRequirements; j++){
	        		 customerRequirements.add(scan.nextInt());
	        		 //Weightings will add up to 1 for each customer
	        		 requirementWeightings.add((noOfCustomerRequirements-j)/sum);
	        	 }
	        	 customerList.add(new Customer(customerRequirements, customerWeighting, requirementWeightings));
	         }
	         
	         //Ensure the weighting for all of the customers add up to 1.
	         for(Customer c: customerList){
	        	 c.setCustomerWeighting(c.getCustomerWeighting()/weightingTotal);
	         }
	         
	         double budget = totalCost / 0.45;
	         
	         rs = new ReqSystem(customerList, budget, costs);
	         
	         return rs;
	         
	         
	      } catch (Exception e){
	    	  e.printStackTrace();
	    	  return null;
	      }
	}
	
	public static ReqSystem rs;
}
