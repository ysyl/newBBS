package bbs.web.utils;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import bbs.web.constant.Constant;

@Component
public class ImgTransformUtils {

	public String transAvatarNameToUrl(String avatar) {
		return Constant.imgBaseUrl + File.separator + avatar;
	}
	
	public String getAbsoluteUrl(HttpServletRequest req, String avatar) {
		String absoluteUrl =  req.getSession().getServletContext().getRealPath(Constant.imgBaseUrl);
		File realFilePath = new File(absoluteUrl);
		if (!realFilePath.exists()) {
			realFilePath.mkdirs();
		}
		return absoluteUrl + File.separator + avatar;
	}
	
	public AvatarGeneratorResult getRealFile(HttpServletRequest req, MultipartFile avatarFile) {
		String newFileUUID = UUID.randomUUID().toString();
		String originalName = avatarFile.getOriginalFilename();
		String extName = originalName.substring(originalName.lastIndexOf('.'));
		String newFileName = newFileUUID + extName;
		String realFilePath = this.getAbsoluteUrl(req, newFileName);
		System.out.println("realFilePath: \n\n\n" + realFilePath);
		File realFile = new File(realFilePath);
		AvatarGeneratorResult result = new AvatarGeneratorResult(newFileName, realFile);
		return result;
	}
}
