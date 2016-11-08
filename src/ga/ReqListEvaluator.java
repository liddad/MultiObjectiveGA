package ga;

import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

public class ReqListEvaluator implements Evaluator<String> {

	private ReqSystem req;
	
	@Override
	public Objectives evaluate(String phenotype) {
		req = FileReader.rs;
		Objectives objectives = new Objectives();
		objectives.add("Cost", Sign.MIN,
				evaluateCostFitness(phenotype));
		objectives.add("Customer Score", Sign.MAX,
				evaluateCScoreFitness(phenotype));
		return objectives;
	}
	

	
	private int evaluateCostFitness(String phenotype){
		int count = 0;
		for(int i = 0; i < phenotype.length(); i++){
			if(phenotype.charAt(i) == '1'){
				count += req.getRequirementCosts().get(i);
			}
		}
		return count;
	}
	
	public double evaluateCScoreFitness(String phenotype){
		double count = 0;
		for(int i = 0; i < phenotype.length(); i++){
			if(phenotype.charAt(i) == '1'){
				for(Customer c:req.getCustomerList()){
					if(c.getRequirements().contains(i)){
						count+=c.getCustomerWeighting()*c.getRequirementWeights().get(c.getRequirements().indexOf(i));
					}
				}
			}
		}
		return count;
	}
}
