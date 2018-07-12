package bbs.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bbs.forum.form.PubPostForm;
import bbs.forum.service.BBSService;
import bbs.helper.service.HelperService;

@Controller
@RequestMapping("/upload")
public class PostController {
	
	private BBSService bbsService;
	
	private HelperService helperService;

	@Autowired
	public PostController(BBSService bbsService, HelperService helperService) {
		super();
		this.bbsService = bbsService;
		this.helperService = helperService;
	}

	@PostMapping("/postWithFile")
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
	
	@PostMapping("/post/{topicId}")
	public String pubPostMd(@PathVariable("topicId") long topicId,
		@RequestParam("editormd-markdown-doc") String mdContent,
		@RequestParam("editormd-html-code") String htmlContent) {
		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent(mdContent);
		pubPostForm.setHtmlContent(htmlContent);
		Long uid = helperService.getCurrentUserId();
		bbsService.savePost(uid, topicId, pubPostForm);
		return "redirect:/topic/"+topicId;
	}
}
