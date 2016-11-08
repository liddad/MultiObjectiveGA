package singleobj;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private List<Integer> requirements;
	private double customerWeighting;
	private List<Double> requirementWeights;
	
	public Customer(List<Integer> req, double cw, List<Double> reqW){
		this.requirements = req;
		this.customerWeighting = cw;
		this.requirementWeights = reqW;
	}

	public List<Integer> getRequirements() {
		return new ArrayList<Integer>(requirements);
	}

	public double getCustomerWeighting() {
		return customerWeighting;
	}

	public void setCustomerWeighting(double customerWeighting) {
		this.customerWeighting = customerWeighting;
	}

	public List<Double> getRequirementWeights() {
		return new ArrayList<Double>(requirementWeights);
	}
}
