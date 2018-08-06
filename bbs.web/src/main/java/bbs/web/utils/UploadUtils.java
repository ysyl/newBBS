package bbs.web.utils;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import bbs.helper.utils.MyLogger;
import bbs.web.constant.Constant;

@Component
public class UploadUtils {
	
	public String getAvatarAbsoluteUrl(HttpServletRequest req, String avatar) {
		String absoluteUrl =  req.getSession().getServletContext().getRealPath(Constant.imgBaseUrl);
		File realFilePath = new File(absoluteUrl);
		if (!realFilePath.exists()) {
			realFilePath.mkdirs();
		}
		return absoluteUrl + File.separator + avatar;
	}
	
	public String getClassLogoAbsoluteUrl(HttpServletRequest req, String newLogoFileName) {
		String absoluteUrl = req.getSession().getServletContext().getRealPath(Constant.CLASS_LOGO_URL);
		File realPath = new File(absoluteUrl);
		if (!realPath.exists()) {
			realPath.mkdirs();
		}
		return absoluteUrl + File.separator + newLogoFileName;
	}
	
	public FileUploadResult getImgRealFile(HttpServletRequest req, MultipartFile avatarFile) {
		String newFileUUID = UUID.randomUUID().toString();
		String originalName = avatarFile.getOriginalFilename();
		String extName = originalName.substring(originalName.lastIndexOf('.'));
		String newFileName = newFileUUID + extName;
		String realFilePath = this.getAvatarAbsoluteUrl(req, newFileName);
		MyLogger.info("realFilePath: \n\n\n" + realFilePath);
		File realFile = new File(realFilePath);
		FileUploadResult result = new FileUploadResult(newFileName, realFile);
		return result;
	}
	
	public FileUploadResult getClassFileRealFile(HttpServletRequest req, MultipartFile classFile) {
		String newFileUUID = UUID.randomUUID().toString();
		String originalName = classFile.getOriginalFilename();
		String extName = originalName.substring(originalName.lastIndexOf('.'));
		String newFileName = newFileUUID + extName;
		String realFilePath = this.getClassLogoAbsoluteUrl(req, newFileName);
		MyLogger.info("realFilePath: \n\n\n" + realFilePath);
		File realFile = new File(realFilePath);
		FileUploadResult result = new FileUploadResult(newFileName, realFile);
		return result;
	}
}
