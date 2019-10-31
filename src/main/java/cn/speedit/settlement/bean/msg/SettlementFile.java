/**
 * Copyright (c) 2017, ChengDu Speed Information 
 *	Technology Co.Ltd. All rights reserved.
 */
package cn.speedit.settlement.bean.msg;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;


/**
　　* @description: 文件信息包装类
　　* @author Zoujidi
　　* @date 2019/10/14 11:10
　　*/
public class SettlementFile implements Serializable {

	private final static long serialVersionUID = 1L;


	/** 文件名称*/
	@Size(max = 50, message = "filename 最大长度不能大于50")
	@NotNull(message = "filename 不能为空")
	private String filename;

	/** 问价对象*/
	@NotNull(message = "file 不能为空")
	private File file;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}