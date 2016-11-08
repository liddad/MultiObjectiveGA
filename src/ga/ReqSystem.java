package ga;

import java.util.ArrayList;
import java.util.List;

public class ReqSystem {

	private List<Customer> customerList;
	private double budget;
	private List<Integer> requirementCosts;
	
	public ReqSystem(List<Customer> cl, double b, List<Integer> rc){
		this.customerList = cl;
		this.budget = b;
		this.requirementCosts = rc;
	}

	public List<Customer> getCustomerList() {
		return new ArrayList<Customer>(customerList);
	}

	public double getBudget() {
		return budget;
	}

	public List<Integer> getRequirementCosts() {
		return new ArrayList<Integer>(requirementCosts);
	}
}
