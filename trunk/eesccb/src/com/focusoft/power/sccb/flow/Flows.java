package com.focusoft.power.sccb.flow;

import java.util.HashMap;
import java.util.Map;

/**
 * 流程实例
 * @author ym
 *
 */
public class Flows {
	private Map<String, CoreFlow> flows = new HashMap();
	
	private String key;
	
	public void addFlow(CoreFlow flow)
	{
		flows.put(flow.getKey(), flow);
	}

	public Map<String, CoreFlow> getFlows() {
		return flows;
	}

	public void setFlows(Map<String, CoreFlow> flows) {
		this.flows = flows;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
