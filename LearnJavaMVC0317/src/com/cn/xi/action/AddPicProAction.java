package com.cn.xi.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.cn.xi.service.PicService;
import com.opensymphony.xwork2.ActionSupport;

public class AddPicProAction extends ActionSupport {
	private String picName;
	// 每一个文件上传域，需要三个Field进行上传
	private File pic;// 上传文件的本身
	private String picFileName;// 上传文件的文件名
	private String picContentType;// 上传文件的文件类型

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

	public String getPicContentType() {
		return picContentType;
	}

	public void setPicContentType(String picContentType) {
		this.picContentType = picContentType;
	}
	
	public String getPicName() {
		return picName;
	}

	public void setPicName(String picName) {
		this.picName = picName;
	}

	// 文件上传
	private String uploadFile() throws Exception {
		// 由于此处的pic是我们的文件，因此此处只需要IO流将文件写入磁盘就行
		String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
		String newFileName = UUID.randomUUID().toString() + picFileName.substring(picFileName.lastIndexOf("."));

		FileInputStream is = new FileInputStream(pic);

		FileOutputStream os = new FileOutputStream(uploadPath + "/" + newFileName);

		byte[] buff = new byte[1024];

		int hasRead = 0;

		while ((hasRead = is.read(buff)) > 0) {
			os.write(buff, 0, hasRead);
		}

		is.close();

		os.close();

		return newFileName;

	}

	@Override
	public String execute() throws Exception {

		String newFileName = uploadFile();

		PicService ps = new PicService();

		// 调用业务逻辑组件来管理系统中所有的图片
		ps.addPic(picName, newFileName);

		return SUCCESS;
	}

	

}
