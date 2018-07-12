package bbs.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload")
public class PostController {

	@PostMapping("/post")
	public void pubPost(HttpServletRequest req, HttpServletResponse res, @RequestParam("imgFile") MultipartFile imgFile) throws UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		String rootPath = req.getSession().getServletContext().getRealPath("/resource/upload");
		
		File filePath = new File(rootPath);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		
		String realFilePath = rootPath + File.pathSeparator + imgFile.getOriginalFilename();
		File realFile = new File(realFilePath);
		try {
			FileUtils.copyInputStreamToFile(imgFile.getInputStream(), realFile);
			res.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/resources/upload/" + imgFile.getOriginalFilename() + "\"}" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
}
