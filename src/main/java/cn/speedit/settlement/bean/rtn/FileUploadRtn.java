package cn.speedit.settlement.bean.rtn;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author Zoujidi
 * @title: FileUploadRtn
 * @projectName settlement
 * @description: 上传文件返回
 * @date 2019/9/25 16:41
 */
@XStreamAlias("return")
public class FileUploadRtn implements Serializable {

    private final static long serialVersionUID = 1L;
    public static final String FIELD_FILE_CODE = "file_code";

    /** 文件统一码 */
    @Size(max = 4000, message = "fileCode 最大长度不能大于4000")
    @NotNull(message = "fileCode 不能为空")
    @XStreamAlias("file_code")
    private String fileCode;

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
