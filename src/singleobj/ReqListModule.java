package singleobj;

import org.opt4j.core.problem.ProblemModule;

public class ReqListModule extends ProblemModule {

	@Override
	protected void config() {
		bindProblem(ReqListCreator.class, ReqListDecoder.class, ReqListEvaluator.class);

	}

}
