package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
 * @author Zoujidi
 * @title: QueryPrjRecsRtn
 * @projectName settlement
 * @description: 查询项目列表返回
 * @date 2019/9/25 20:06
 */
@XStreamAlias("return")
public class QueryPrjRecsesRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 项目列表 */
    @XStreamAlias("prj_records")
    private List<QueryPrjRecsRtn> queryPrjRecsRtns;

    public void setQueryPrjRecsRtns(List<QueryPrjRecsRtn> queryPrjRecsRtns) {
        this.queryPrjRecsRtns = queryPrjRecsRtns;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public List<QueryPrjRecsRtn> getQueryPrjRecsRtns() {
        return queryPrjRecsRtns;
    }
}
