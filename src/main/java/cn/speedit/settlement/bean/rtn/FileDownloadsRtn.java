package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

/**
　　* @description: 文件下载返回对象
　　* @throws
　　* @author Zoujidi
　　* @date 2019/9/25 17:11
　　*/
@XStreamAlias("return")
public class FileDownloadsRtn implements Serializable {

    private final static long serialVersionUID = 1L;

    /** 文件列表 */
    @XStreamAlias("download_files")
    private List<FileDownloadRtn> fileDownloadRtns;

    public List<FileDownloadRtn> getFileDownloadRtns() {
        return fileDownloadRtns;
    }

    public void setFileDownloadRtns(List<FileDownloadRtn> fileDownloadRtns) {
        this.fileDownloadRtns = fileDownloadRtns;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
