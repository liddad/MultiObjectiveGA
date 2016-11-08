package ga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.opt4j.core.genotype.SelectGenotype;
import org.opt4j.core.problem.Creator;

public class ReqListCreator implements Creator<SelectGenotype<Integer>> {
	private Random random;
	private ReqSystem req;
	private List<Integer> requirements;
	private int SIZE;
	
	public ReqListCreator(){
		super();
		random = new Random();
		requirements = new ArrayList<Integer>();
		req = FileReader.readData("ga/nrp3.txt");
		for(int i = 0; i<req.getRequirementCosts().size(); i++){
			requirements.add(i);
		}
		SIZE = 900;
	}
	
	public SelectGenotype<Integer> create() {
		SelectGenotype<Integer> genotype = new SelectGenotype<Integer>(requirements);
		genotype.init(random, SIZE);
		return genotype;
	}

}
