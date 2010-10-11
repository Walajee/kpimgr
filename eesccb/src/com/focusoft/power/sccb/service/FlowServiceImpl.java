package com.focusoft.power.sccb.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.focusoft.power.sccb.dao.bean.AppFlow;
import com.focusoft.power.sccb.dao.bean.FlowHis;
import com.focusoft.power.sccb.dao.sys.AppFlowDao;
import com.focusoft.power.sccb.flow.Branch;
import com.focusoft.power.sccb.flow.CoreFlow;
import com.focusoft.power.sccb.flow.FlowConfigFactory;
import com.focusoft.power.sccb.flow.Flows;
import com.focusoft.power.sccb.flow.Step;

@Service("flowService")
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class FlowServiceImpl implements FlowService{
	@Autowired
	private CounterService counterService;
	@Autowired
	private AppFlowDao appFlowDao;
	@Autowired
	private AppFlowDao flowHisDao;
	
	/**
	 * 流程状态-起始
	 */
	public final static String FLOW_STAT_START = "start";

	@Override
	public void saveStartFlow(String flowType, String creator, String participate,
			String entity) {
		// TODO Auto-generated method stub
		try {
			String currentStat = next(flowType, null, null);
			
			AppFlow flow = new AppFlow();
			flow.setCreator(creator);
			flow.setEntity(entity);
			flow.setFlow(flowType);
			flow.setId(counterService.getNextLong(CounterService.COUNTER_FLOW));
			flow.setLastUpdate(new Date());
			flow.setParticipe(participate);
			flow.setStats(currentStat);
			
			appFlowDao.save(flow);
			
			//添加流程历史记录
			FlowHis fh = new FlowHis();
			fh.setActionDate(new Date());
			fh.setActionRet("创建新流程:"+flowType);
			fh.setCurrStat("new");
			fh.setDesct("创建新流程:"+flowType);
			fh.setHid(counterService.getNextLong(CounterService.COUNTER_FLOW));
			fh.setId(flow.getId());
			fh.setNextStat(currentStat);
			fh.setUser(creator);
			fh.setParticipate(participate);
			
			flowHisDao.save(fh);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 流程流转
	 * 
	 * @param flowType
	 *            流程类型
	 * @param currentStat
	 *            当前状态
	 * @param switchBranch
	 *            分支状态
	 * @return 返回下一状态
	 * @throws Exception
	 */
	private static String next(String flowType, String currentStat,
			String switchBranch) throws Exception {
		if (flowType == null) {
			throw new Exception("流程不存在！");
		} else {
			Flows f = FlowConfigFactory.getConfig();
			Map<String, CoreFlow> flows = f.getFlows();

			if (flows == null)
				throw new Exception("流程解析错误！");
			else {
				CoreFlow flow = flows.get(flowType);
				if (flow == null)
					throw new Exception("流程[" + flowType + "]没有配置！");
				else {
					// 若当前状态为空，默认为启动流程，状态为起始状态
					if (currentStat == null || currentStat.equals(""))
						return FLOW_STAT_START;
					else {
						// 获取当前状态
						Map<String, Step> steps = flow.getSteps();
						Step step = steps.get(currentStat);

						if (step == null)
							throw new Exception("流程异常，请检查流程状态！");
						else {
							Map<String, Branch> branches = step.getBranches();
							Branch branch = branches.get(switchBranch);

							if (branch == null)
								throw new Exception("流程分支问题，不能往下走，请确认流程配置");
							else
								return branch.getGo();
						}
					}
				}
			}
		}
	}
}
