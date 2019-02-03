package com.pinyougou.manager.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.pinyougou.common.DataUtils;
import com.pinyougou.common.Result;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

@Controller
public class UploadController {
	
	
	private final static String returnPath = "http://www.genealogy.zzw777.com/";
	private final static String APPKEY ="r8DLGf0BLmN3QjnAoSCe-PiYzNfARLQZD4BccI2i";
	private final static String SERCET="o8llqqKfAMyd3BU86hGL-IPjtn25IGETLjoADIEl";
	private final static String BUTNAME="genealogy";
	static Auth auth = Auth.create(APPKEY, SERCET);
	// 构造一个带指定Zone对象的配置类
	// zone2华南 zone0华东
	static Configuration cfg = new Configuration(Zone.zone0());
	static UploadManager uploadManager = new UploadManager(cfg);

	@ResponseBody
	@RequestMapping("/upload")
	public Result upload(MultipartFile file){
		
		String originalFilename = file.getOriginalFilename();//获取文件名
		String extName=originalFilename.substring( originalFilename.lastIndexOf(".")+1);//得到扩展名
		
		try {
			// 设置上传的key
			String key = DataUtils.getPicName() + extName;
			// 上传到远程服务器
			doUpLoad(file, key);
			// 设置返回的路径
			String returPath  = returnPath + key ;
			
			return new Result(true, returPath);
		} catch (Exception e) {
			return new Result(false, "上传失败");
		}
		
		
		/*try {
			FastDFSClient client=new FastDFSClient("classpath:config/fdfs_client.conf");
			String fileId = client.uploadFile(file.getBytes(), extName);
			String url=file_server_url+fileId;//图片完整地址
			return new Result(true, url);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "上传失败");
		}*/
		
	}

	private void doUpLoad(MultipartFile file, String key) {
		try {
			Response res  = uploadManager.put(file.getBytes(), key, getUpToken(BUTNAME,key));
		} catch (QiniuException e) {
			Response r = e.response;
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getUpToken(String bucketName, String key) {
		StringMap putPolicy = new StringMap();
		putPolicy.put("insertOnly", 1);
		return auth.uploadToken(bucketName, key, 3600, putPolicy);

	}
	
	
}
