package com.focusoft.power.sccb.flow;

import java.util.HashMap;
import java.util.Map;

public class CoreFlow {
	private String key;
	
	private Map<String,Step> steps = new HashMap();
	
	public void addStep(Step step)
	{
		steps.put(step.getKey(), step);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Map<String, Step> getSteps() {
		return steps;
	}

	public void setSteps(Map<String, Step> steps) {
		this.steps = steps;
	}
}
