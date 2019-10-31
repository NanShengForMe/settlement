package cn.speedit.settlement.service;

import cn.speedit.settlement.bean.Record;
import cn.speedit.settlement.bean.msg.*;
import cn.speedit.settlement.bean.rtn.FileDownloadsRtn;
import cn.speedit.settlement.bean.rtn.QueryPrjInfoRtn;
import cn.speedit.settlement.bean.rtn.QueryPrjRecsesRtn;

import java.util.List;



/**
 * 简介：集中结算接口业务Service<br>
 * 详细说明：本接口的所有方法说明中，加粗参数为必须字段
 * 
 * @author 李珂 2017年10月26日 上午9:22:45
 */
public interface SettlementSubService {

	/**
	 * 简介：申请取消结算
	 * 
	 * @author 李珂 2017年10月26日 上午9:37:38
	 * @param provCode
	 *            供应商编码
	 * @param applyNo
	 *            结算申请号
	 * @throws Exception 如果接口调用异常
	 */
	public Record subApplyCancel(String provCode, int applyNo) throws Exception;

	/**
	 * 简介：申请结算
	 * 
	 * @author 李珂 2017年10月26日 上午9:43:38
	 * @param applyJo
	 *            申请结算的BeanJo<br>
	 *            applyJo
	 *            <ul>
	 *            <li><b>provCode</b>：供应商编码</li>
	 *            <li><b>applyUser</b>：结算申请人</li>
	 *            <li><b>remark</b>：备注</li>
	 *            <li><b>applyAmt</b>：申请结算金额</li>
	 *            <li><b>List&lt;String&gt; orderNoList</b>：订单号列表</li>
	 *            <li><b>List&lt;PaymentInvoice&gt; invoiceList</b>：发票列表<br>
	 *            PaymentInvoice
	 *            <ul>
	 *            <li><b>invoice_type</b>：发票类型</li>
	 *            <li><b>invoice_code</b>：发票代码</li>
	 *            <li><b>invoice_no</b>：发票号码</li>
	 *            <li><b>invoice_date</b>：开票日期</li>
	 *            <li><b>invoice_amt</b>：发票金额</li>
	 *            <li><b>invoice_doc</b>：发票附件（调用1399接口生成）</li>
	 *            <li><b>e_invoice</b>：是否电子发票（Y/N）</li>
	 *            </ul>
	 *            </li>
	 *            </ul>
	 * @return Record
	 *         <ul>
	 *         <li>apply_no：结算申请号</li>
	 *         <li>req_no：预约单号</li>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subApply(SettlementApplyJo applyJo) throws Exception;

	/**
	 * 简介：上传文件
	 * 
	 * @author 李珂 2017年10月26日 上午9:49:51
	 * @param files
	 *            SettlementFile的List
	 * @return Record
	 *         <ul>
	 *         <li>file_code：文件统一码</li>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subFileUpload(List<SettlementFile> files) throws Exception;

	/**
	 * 简介：下载文件
	 *
	 * @author 邹及第 2019年9月20日 上午9:23:51
	 * @param fileCode
	 *            文件统一码（对应上传文件返回的统一码）
	 * @return List<Record>
	 *         <ul>
	 *         <li>file_name：文件名</li>
	 *         <li>file_str：Base64加密的字节码String</li>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public FileDownloadsRtn downloadFile(String fileCode) throws Exception;

	/**
	 * 简介：申请取消订单（并释放冻结金额）
	 * 
	 * @author 李珂 2017年10月26日 上午9:53:12
	 * @param orderCancelList
	 *            List&lt;SettleOrderCancel&gt;：包含取消订单Bean的List<br>
	 *            <b>SettleOrderCancel</b>
	 *            <ul>
	 *            <li><b>provCode</b>：供应商编码</li>
	 *            <li><b>orderNo</b>：订单号</li>
	 *            <li><b>cancel_user</b>：取消人</li>
	 *            <ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subOrderCancel(List<SettlementOrderCancel> orderCancelList) throws Exception;

	/**
	 * 简介：申请订单（并冻结项目额度）
	 * 
	 * @author 李珂 2017年10月26日 上午9:57:41
	 * @param orderGenList
	 *            List&lt;SettleOrderGen&gt; orderGenList：包含生成订单Bean的List<br>
	 *            <b>SettleOrderGen</b>
	 *            <ul>
	 *            <li><b>provCode</b>：供应商编码</li>
	 *            <li><b>orderNo</b>：订单号</li>
	 *            <li><b>frozenUser</b>：冻结人</li>
	 *            <li><b>uniPrjCode</b>：项目代码</li>
	 *            <li><b>bu_code</b>：预算项代码</li>
	 *            <li><b>grant_id</b>：授权码</li>
	 *            <li><b>bCode</b>：费用项代码</li>
	 *            <li><b>zc_flag</b>：是否资产预约单（Y/N）</li>
	 *            <li><b>frozenAmt</b>：冻结金额</li>
	 *            <li><b>frozen_remark</b>：冻结原因</li>
	 *            </ul>
	 * @throws Exception 
	 */
	public Record subOrderGen(List<SettlementOrderGen> orderGenList) throws Exception;

	/**
	 * 简介：申请收货确认
	 * 
	 * @author 李珂 2017年10月26日 上午10:05:20
	 * @param orderReceiveVoList
	 *            List&lt;SettleOrderReceiveJo&gt; 包含确认收货BeanVo的List<br>
	 *            SettleOrderReceiveJo
	 *            <ul>
	 *            <li><b>PaymentOrderReceive</b>：订单基本信息
	 *            <ul>
	 *            <li><b>provCode</b>：供应商编码</li>
	 *            <li><b>orderNo</b>：订单号</li>
	 *            <li><b>confirmUser</b>：确认人</li>
	 *            <li><b>orderAmt</b>：确认金额</li>
	 *            <li><b>orderDoc</b>：订单附件（调用1399接口生成）</li>
	 *            </ul>
	 *            </li>
	 *            <li><b>List&lt;PaymentOrderReceiveDetail&gt;
	 *            orderReceiveDetailList</b>：订单明细</li> PaymentOrderReceiveDetai
	 *            <ul>
	 *            <li><b>brand</b>：品牌</li>
	 *            <li><b>itemNo</b>：货号</li>
	 *            <li><b>spec</b>：规格</li>
	 *            <li><b>num</b>：数量</li>
	 *            <li><b>price</b>：单价</li>
	 *            </ul>
	 *            </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subOrderRecieve(List<SettlementOrderReceiveJo> orderReceiveVoList) throws Exception;

	/**
	 * 简介：申请更换项目
	 * 
	 * @author 李珂 2017年10月26日 上午10:14:35
	 * @param prjChangeList
	 *            List&lt;SettlePrjChange&gt; 包含更换项目Bean的List<br>
	 *            <b>SettlePrjChange</b>
	 *            <ul>
	 *            <li><b>provCode</b>：供应商编码</li>
	 *            <li><b>orderNo</b>：订单号</li>
	 *            <li><b>oldUniPrjCode</b>：原项目代码</li>
	 *            <li><b>newUniPrjCode</b>：新项目代码</li>
	 *            </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subPrjChange(List<SettlementPrjChange> prjChangeList) throws Exception;

	/**
	 * 简介：申请供应商注册
	 * 
	 * @author 李珂 2017年10月26日 上午10:20:47
	 * @param prov
	 *            供应商信息Bean
	 *            <ul>
	 *            <li><b>provName</b>：供应商名称</li>
	 *            <li>shortName：供应商简称</li>
	 *            <li>taxNo：税号</li>
	 *            <li>taxAddr：税务登记地址、开票地址</li>
	 *            <li>invoiceName：开票单位名称</li>
	 *            <li><b>acnt</b>：帐号</li>
	 *            <li><b>accbank</b>：开户行</li>
	 *            <li><b>branchcode</b>：联行号</li>
	 *            <li>contactAddr：联系地址</li>
	 *            <li>contact：联系人</li>
	 *            <li>tel：联系电话</li>
	 *            <li>mobilephone：手机</li>
	 *            <li>email：Email</li>
	 *            <li>paymentDays：账期</li>
	 *            <li>deposit：押金</li>
	 *            <li><b>eInvoice</b>：是否开具电子发票（Y/N）</li>
	 *            <li>provDov：供应商附件（调用1399接口生成）</li>
	 *            <li>remark：备注</li>
	 *            <li><b>inputUser</b>：登记人</li>
	 *            </ul>
	 * @return Record
	 *         <ul>
	 *         <li>prov_code：供应商编码</li>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subProvReg(SettlementProvider prov) throws Exception;

	/**
	 * 简介：申请供应商更新
	 * 
	 * @author 李珂 2017年10月26日 上午10:27:05
	 * @param prov
	 *            供应商信息Bean
	 *            <ul>
	 *            <li><b>provCode</b>：供应商编码</li>
	 *            <li><b>provName</b>：供应商名称</li>
	 *            <li>shortName：供应商简称</li>
	 *            <li>taxNo：税号</li>
	 *            <li>taxAddr：税务登记地址、开票地址</li>
	 *            <li>invoiceName：开票单位名称</li>
	 *            <li><b>acnt</b>：帐号</li>
	 *            <li><b>accbank</b>：开户行</li>
	 *            <li><b>branchcode</b>：联行号</li>
	 *            <li>contactAddr：联系地址</li>
	 *            <li>contact：联系人</li>
	 *            <li>tel：联系电话</li>
	 *            <li>mobilephone：手机</li>
	 *            <li>email：Email</li>
	 *            <li>paymentDays：账期</li>
	 *            <li>deposit：押金</li>
	 *            <li><b>eInvoice</b>：是否开具电子发票（Y/N）</li>
	 *            <li>provDov：供应商附件（调用1399接口生成）</li>
	 *            <li>remark：备注</li>
	 *            <li><b>inputUser</b>：登记人</li>
	 *            </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record subProvUpd(SettlementProvider prov) throws Exception;

	/**
	 * 简介：查询结算进度
	 * 
	 * @author 李珂 2017年10月26日 上午10:29:54
	 * @param provCode
	 *            供应商编码
	 * @param applyNo
	 *            结算申请号
	 * @return Record
	 *         <ul>
	 *         <li>prov_code：供应商编码</li>
	 *         <li>apply_no：结算申请号</li>
	 *         <li>prov_name：供应商名称</li>
	 *         <li>acnt：帐号</li>
	 *         <li>accbank：开户行</li>
	 *         <li>branchcode：联行号</li>
	 *         <li>apply_amt：申请结算金额</li>
	 *         <li>apply_user：结算申请人</li>
	 *         <li>apply_date：结算申请时间</li>
	 *         <li>req_no：预约单号</li>
	 *         <li>pz_uni_no：入账凭证号</li>
	 *         <li>pay_status：支付状态（尚未支付/正在支付/支付成功/支付失败）</li>
	 *         <li>pay_date：支付时间</li>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public Record queryApplyProgress(String provCode, int applyNo) throws Exception;

	/**
	 * 简介：根据项目代码获取项目信息
	 * 
	 * @author 李珂 2017年10月26日 上午10:34:15
	 * @param uniPrjCode
	 *            项目代码
	 * @param bcode
	 *            费用项代码
	 * @return Record
	 *         <ul>
	 *         <li>uni_prj_code：项目代码</li>
	 *         <li>uni_prj_name：项目名称</li>
	 *         <li>charge_sno：负责人工号</li>
	 *         <li>charge_name：负责人姓名</li>
	 *         <li>sa_depart：项目所属部门代码</li>
	 *         <li>gk_flag：是否国库项目（Y/N）</li>
	 *         <li>finish_date：结题日期</li>
	 *         <li>max_amt：项目额度</li>
	 *         <ul>budgets：预算项信息（可能多个）
	 *             <li>bu_code：预算代码</li>
	 *             <li>bu_name：预算名称</li>
	 *             <li>max_amt：最大可用额度</li>
	 *             <li>balance：当前剩余额度</li>
	 *         </ul>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public QueryPrjInfoRtn queryPrjRecByPrjCode(String uniPrjCode, String bcode);

	/**
	 * 简介：根据工号获取项目列表
	 * 
	 * @author 李珂 2017年10月26日 上午10:38:50
	 * @param sno
	 *            工号
	 * @param bcode
	 *            费用项代码
	 * @return List&lt;Record&gt;<br>
	 *         <b>Record</b>
	 *         <ul>
	 *         <li>uni_prj_code：项目代码</li>
	 *         <li>uni_prj_name：项目名称</li>
	 *         <li>charge_sno：负责人工号</li>
	 *         <li>charge_name：负责人姓名</li>
	 *         <li>sa_depart：项目所属部门代码</li>
	 *         <li>gk_flag：是否国库项目（Y/N）</li>
	 *         <li>finish_date：结题日期（YYYY-MM-DD）</li>
	 *         <li>bu_code：预算项</li>
	 *         <li>bu_name：预算项名称</li>
	 *         <li>max_amt：项目额度</li>
	 *         <li>grant_id：授权号</li>
	 *         <li>grant_type：身份类型(0-负责人 5-限额经办人; 8-管理员; 9-无限额经办人)</li>
	 *         </ul>
	 * @throws Exception 如果接口调用异常
	 */
	public QueryPrjRecsesRtn queryPrjRecsBySno(String sno, String bcode);

	/**
	 * 测试方法
	 * @param content 传入字符串
	 * @return 返回字符串：Hello,${content}
	 */
	public String sayHello(String content);
}
