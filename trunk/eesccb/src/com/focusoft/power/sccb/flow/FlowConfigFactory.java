package com.focusoft.power.sccb.flow;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.xmlrules.DigesterLoader;

/**
 * 流程映射
 * @author ym
 *
 */
public class FlowConfigFactory {
	private FlowConfigFactory() {
	}
	private static Flows flows;
	public static Flows getConfig() throws Exception {
		if (flows == null) {
			try {
				flows = new Flows();
				Digester digester = DigesterLoader
						.createDigester(FlowConfigFactory.class
								.getClassLoader()
								.getResource(
										"com/focusoft/power/sccb/flow/rule.xml"));
				digester.push(flows);
				digester.parse(FlowConfigFactory.class.getClassLoader()
						.getResource("com/focusoft/power/sccb/flow/flowConfig.xml"));
				processRef(flows);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flows;
	}
	
	private static void processRef(Flows configs) throws Exception {
		
	}
}
