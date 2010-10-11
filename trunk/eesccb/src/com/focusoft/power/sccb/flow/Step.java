package com.focusoft.power.sccb.flow;

import java.util.HashMap;
import java.util.Map;

public class Step {
	private String key ;
	
	private Map<String, Branch> branches = new HashMap();
	
	public void addBranch(Branch branch)
	{
		branches.put(branch.getKey(), branch);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Map<String, Branch> getBranches() {
		return branches;
	}

	public void setBranches(Map<String, Branch> branches) {
		this.branches = branches;
	}
	
	
}