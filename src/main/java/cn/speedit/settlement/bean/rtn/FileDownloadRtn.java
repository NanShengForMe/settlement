package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
　　* @description: 文件下载返回对象
　　* @throws
　　* @author Zoujidi
　　* @date 2019/9/25 18:34
　　*/
@XStreamAlias("download_file")
public class FileDownloadRtn implements Serializable {

    private final static long serialVersionUID = 1L;
    public static final String FIELD_FILE_NAME = "file_name";
    public static final String FIELD_FILE_STR = "file_str";

    /** 文件名 */
    @Size(max = 50, message = "file_name 最大长度不能大于50")
    @NotNull(message = "fileCode 不能为空")
    @XStreamAlias("file_name")
    private String fileName;

    /** 文件base64加密后的字符串 */
    @NotNull(message = "fileStr 不能为空")
    @XStreamAlias("file_str")
    private String fileStr;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileStr() {
        return fileStr;
    }

    public void setFileStr(String fileStr) {
        this.fileStr = fileStr;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
