package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author Zoujidi
 * @title: QueryPrjRtn
 * @projectName settlement
 * @description: 查询项目信息
 * @date 2019/9/25 21:06
 */
@XStreamAlias("return")
public class QueryPrjRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 项目信息 */
    @XStreamAlias("prj_record")
    private QueryPrjInfoRtn queryPrjInfoRtn;

    public QueryPrjInfoRtn getQueryPrjInfoRtn() {
        return queryPrjInfoRtn;
    }

    public void setQueryPrjInfoRtn(QueryPrjInfoRtn queryPrjInfoRtn) {
        this.queryPrjInfoRtn = queryPrjInfoRtn;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
