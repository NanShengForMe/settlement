package cn.speedit.settlement.service.impl;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;


import cn.speedit.settlement.bean.DtoSubmitResult;
import cn.speedit.settlement.bean.Record;
import cn.speedit.settlement.bean.msg.*;
import cn.speedit.settlement.bean.rtn.FileDownloadsRtn;
import cn.speedit.settlement.bean.rtn.QueryPrjInfoRtn;
import cn.speedit.settlement.bean.rtn.QueryPrjRecsesRtn;
import cn.speedit.settlement.bean.rtn.QueryPrjRtn;
import cn.speedit.settlement.helper.LogHelper;
import cn.speedit.settlement.service.SettlementSubService;
import cn.speedit.settlement.util.SettlementCallUtil;
import cn.speedit.settlement.util.SettlementMsgBuildUtil;
import cn.speedit.settlement.util.SettlementUtil;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;


/**
 * 简介：集中结算接口业务ServiceImpl
 * 
 * @author 李珂 2017年10月26日 上午9:23:27
 */
public class SettlementSubServiceImpl implements SettlementSubService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subApplyCancel(java.
	 * lang.String, int)
	 */
	@Override
	public DtoSubmitResult<Record> subApplyCancel(String provCode, int applyNo) {
		String xmlData = new SettlementMsgBuildUtil().composeApplyCancelMsg(provCode, applyNo);
		LogHelper.record("[申请取消结算][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[申请取消结算][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subApply(cn.speedit.
	 * blassets.bean.settle.msg.SettleApplyJo)
	 */
	@Override
	public DtoSubmitResult<Record> subApply(SettlementApplyJo applyJo) {
		String xmlData = new SettlementMsgBuildUtil().composeApplyMsg(applyJo);
		LogHelper.record("[申请结算][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[申请结算][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subFileUpload(java.
	 * util.Set)
	 */
	@Override
	public DtoSubmitResult<Record> subFileUpload(List<SettlementFile> files) {
		String xmlData = new SettlementMsgBuildUtil().composeFileUploadMsg(files);
		LogHelper.record("[上传文件][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[上传文件][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	@Override
	public DtoSubmitResult<FileDownloadsRtn> downloadFile(String fileCode) {
		// 字符转义 例如（&转&amp;）
		fileCode = StringEscapeUtils.escapeXml11(fileCode);
		String xmlData = new SettlementMsgBuildUtil().composeFileDownloadMsg(fileCode);
		LogHelper.record("[下载文件][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[下载文件][返回报文]-"+rtnXml);
		List<Record> rtnList = null;
		try {
			rtnList = SettlementCallUtil.parseReturnXml(rtnXml, FileDownloadsRtn.class);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		FileDownloadsRtn fileDownloadsRtn = null;
		if (!rtnList.isEmpty()) {
			Record rtn = rtnList.get(0);
			if ("failure".equals(rtn.get("result")))
				return new DtoSubmitResult<FileDownloadsRtn>(false, rtn.get("type").toString(), rtn.get("msg").toString());

			fileDownloadsRtn = (FileDownloadsRtn) rtn.get("result");
		} else {
			return new DtoSubmitResult<FileDownloadsRtn>(false, "-1", "报文解析异常");
		}

		return new DtoSubmitResult<FileDownloadsRtn>(true, fileDownloadsRtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subOrderCancel(java.
	 * util.List)
	 */
	@Override
	public DtoSubmitResult<Record> subOrderCancel(List<SettlementOrderCancel> orderCancelList) {
		String xmlData = new SettlementMsgBuildUtil().composeOrderCancelMsg(orderCancelList);
		LogHelper.record("[申请取消订单][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[申请取消订单][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subOrderGen(java.util
	 * .List)
	 */
	@Override
	public DtoSubmitResult<Record> subOrderGen(List<SettlementOrderGen> orderGenList) {
		String xmlData = new SettlementMsgBuildUtil().composeOrderGenMsg(orderGenList);
		LogHelper.record("[申请订单][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[申请订单][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subOrderRecieve(java.
	 * util.List)
	 */
	@Override
	public DtoSubmitResult<Record> subOrderRecieve(List<SettlementOrderReceiveJo> orderReceiveVoList) throws Exception {
		// TODO 材料通过接口传    固定资产通过中间库推送
		
		String xmlData = new SettlementMsgBuildUtil().composeOrderReceiveMsg(orderReceiveVoList);
		LogHelper.record("[确认收货][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[确认收货][返回文件报文]-"+rtnXml);
		Record rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subPrjChange(java.
	 * util.List)
	 */
	@Override
	public DtoSubmitResult<Record> subPrjChange(List<SettlementPrjChange> prjChangeList) {
		String xmlData = new SettlementMsgBuildUtil().composePrjChangeMsg(prjChangeList);
		LogHelper.record("[申请更换项目][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[申请更换项目][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subProvReg(cn.speedit
	 * .blassets.bean.settle.msg.SettleProvider)
	 */
	@Override
	public DtoSubmitResult<Record> subProvReg(SettlementProvider prov) {
		String xmlData = new SettlementMsgBuildUtil().composeProvRegMsg(prov);
		LogHelper.record("[注册供应商][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[注册供应商][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#subProvUpd(cn.speedit
	 * .blassets.bean.settle.msg.SettleProvider)
	 */
	@Override
	public DtoSubmitResult<Record> subProvUpd(SettlementProvider prov){
		String xmlData = new SettlementMsgBuildUtil().composeProvUpdMsg(prov);
		LogHelper.record("[更新供应商][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[更新供应商][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#queryApplyProgress(
	 * java.lang.String, int)
	 */
	@Override
	public DtoSubmitResult<Record> queryApplyProgress(String provCode, int applyNo) {
		String xmlData = new SettlementMsgBuildUtil().fetchApplyProgress(provCode, applyNo);
		LogHelper.record("[查询结算进度][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[查询结算进度][返回报文]-"+rtnXml);
		Record rtn = null;
		try {
			rtn = SettlementCallUtil.parseReturnXml(rtnXml, false).get(0);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		if ("failure".equals(rtn.get("result"))){
			return new DtoSubmitResult<Record>(false, rtn.get("type").toString(), rtn.get("msg").toString());
		}
		return new DtoSubmitResult<Record>(true, rtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#queryPrjRecByPrjCode(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public DtoSubmitResult<QueryPrjInfoRtn> queryPrjRecByPrjCode(String uniPrjCode, String bcode){
		String xmlData = new SettlementMsgBuildUtil().fetchPrjRecByPrjCode(uniPrjCode, bcode);
		LogHelper.record("[查询项目详情][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[查询项目详情][返回报文]-"+rtnXml);
		if(StringUtils.isBlank(rtnXml)){
			LogHelper.record("无报文返回，该项目不能报该费用项");
			return null;
		}
		List<Record> rtnList = null;
		try {
			rtnList = SettlementCallUtil.parseReturnXml(rtnXml, QueryPrjInfoRtn.class);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		QueryPrjInfoRtn queryPrjInfoRtn = null;
		if (!rtnList.isEmpty()) {
			Record rtn = rtnList.get(0);
			if ("failure".equals(rtn.get("result"))){
				// throw new Exception(SettlementUtil.composeRrrorMsg(rtn));
				LogHelper.record(SettlementUtil.composeRrrorMsg(rtn));
				return new DtoSubmitResult<QueryPrjInfoRtn>(false, rtn.get("type").toString(), rtn.get("msg").toString());
			}
			queryPrjInfoRtn = (QueryPrjInfoRtn) rtn.get("result");
		} else {
			return new DtoSubmitResult<QueryPrjInfoRtn>(false, "-1", "报文解析异常");
		}

		return new DtoSubmitResult<QueryPrjInfoRtn>(true, queryPrjInfoRtn);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.speedit.blassets.service.settle.SettleSubService#queryPrjRecsBySno(
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public DtoSubmitResult<QueryPrjRecsesRtn> queryPrjRecsBySno(String sno, String bcode){
		String xmlData = new SettlementMsgBuildUtil().fetchPrjRecsBySno(sno, bcode);
		LogHelper.record("[查询项目列表][提交报文]-"+xmlData);
		String rtnXml = SettlementCallUtil.submit(xmlData);
		LogHelper.record("[查询项目列表][返回报文]-"+rtnXml);
		if(StringUtils.isBlank(rtnXml)){
			LogHelper.record("无报文返回");
			return null;
		}
		List<Record> rtnList = null;
		try {
			rtnList = SettlementCallUtil.parseReturnXml(rtnXml, QueryPrjRecsesRtn.class);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		QueryPrjRecsesRtn queryPrjRecsesRtn = null;

		if (!rtnList.isEmpty()) {
			Record rtn = rtnList.get(0);
			if ("failure".equals(rtn.get("result"))) {
				// throw new Exception(SettlementUtil.composeRrrorMsg(rtn));
				LogHelper.record(SettlementUtil.composeRrrorMsg(rtn));
				return new DtoSubmitResult<QueryPrjRecsesRtn>(false, rtn.get("type").toString(), rtn.get("msg").toString());
			}
			queryPrjRecsesRtn = (QueryPrjRecsesRtn) rtn.get("result");
		} else {
			return new DtoSubmitResult<QueryPrjRecsesRtn>(false, "-1", "报文解析异常");
		}

		return new DtoSubmitResult<QueryPrjRecsesRtn>(true, queryPrjRecsesRtn);
	}

	@Override
	public String sayHello(String content) {
		return SettlementCallUtil.sayHello(content);
	}

}
