package singleobj;

import org.opt4j.core.genotype.SelectGenotype;
import org.opt4j.core.problem.Decoder;

public class ReqListDecoder implements Decoder<SelectGenotype<Integer>, String> {
	
	public String decode(SelectGenotype<Integer> genotype) {
		String phenotype = "";
		for (int i = 0; i < FileReader.rs.getRequirementCosts().size(); i++) {
			phenotype += (genotype.contains(i)) ? "1":"0";
		}
		return phenotype;
	}
}
