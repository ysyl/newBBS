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
import bbs.forum.form.PubTopicForm;
import bbs.forum.form.UpdateUserProfileForm;
import bbs.forum.service.BBSService;
import bbs.security.helper.SecurityHelper;
import bbs.web.utils.AvatarGeneratorResult;
import bbs.web.utils.ImgTransformUtils;

@Controller
@RequestMapping("/upload")
public class PostController {
	
	private BBSService bbsService;
	
	private SecurityHelper helperService;
	
	private ImgTransformUtils imgUtils;


//	public void pubPost(HttpServletRequest req, HttpServletResponse res, @RequestParam("imgFile") MultipartFile imgFile) throws UnsupportedEncodingException {
//		req.setCharacterEncoding("utf-8");
//		String rootPath = req.getSession().getServletContext().getRealPath("/resource/upload");
//		
//		File filePath = new File(rootPath);
//		if (!filePath.exists()) {
//			filePath.mkdirs();
//		}
//		
//		String realFilePath = rootPath + File.pathSeparator + imgFile.getOriginalFilename();
//		File realFile = new File(realFilePath);
//		try {
//			FileUtils.copyInputStreamToFile(imgFile.getInputStream(), realFile);
//			res.getWriter().write( "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/resources/upload/" + imgFile.getOriginalFilename() + "\"}" );
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		};
//	}
	
	@Autowired
	public PostController(BBSService bbsService, SecurityHelper helperService, ImgTransformUtils imgUtils) {
		super();
		this.bbsService = bbsService;
		this.helperService = helperService;
		this.imgUtils = imgUtils;
	}

	@PostMapping("/userprofile")
	public String updateUserProfile(
			HttpServletRequest req,
			@RequestParam("nickname") String nickname,
			@RequestParam MultipartFile avatar) throws IllegalStateException, IOException {
		Long uid = helperService.getCurrentUserId();
		UpdateUserProfileForm updateUserProfileForm = new UpdateUserProfileForm();

		AvatarGeneratorResult avatarGeneratorResult = imgUtils.getRealFile(req, avatar);
		String avatarName = avatarGeneratorResult.getAvatarName();
		File realFile = avatarGeneratorResult.getFile();
		avatar.transferTo(realFile);

		updateUserProfileForm.setNickname(nickname);
		updateUserProfileForm.setAvatar(avatarName);
		bbsService.updateUserProfile(uid, updateUserProfileForm);

		return "redirect:/user/" + uid;
	}
	
	@PostMapping("/post/{topicId}")
	public String pubPostMd(@PathVariable("topicId") long topicId,
		@RequestParam("editormd-markdown-doc") String mdContent,
		@RequestParam("editormd-html-code") String htmlContent,
		@RequestParam(value = "reply-post-id", required=false) Long postId) {
		PubPostForm pubPostForm = new PubPostForm();
		pubPostForm.setContent(mdContent);
		pubPostForm.setHtmlContent(htmlContent);
		pubPostForm.setReplyPostId(postId);
		Long uid = helperService.getCurrentUserId();
		bbsService.savePost(uid, topicId, pubPostForm);
		return "redirect:/topic/"+topicId;
	}
	
	@PostMapping("/topic/{forumId}")
	public String pubTopicMd(@PathVariable("forumId") int forumId,
			@RequestParam("editormd-markdown-doc") String mdContent,
			@RequestParam("editormd-html-code") String htmlContent,
			@RequestParam("title") String title) {
		PubTopicForm pubTopicForm = new PubTopicForm();
		pubTopicForm.setContent(mdContent);
		pubTopicForm.setHtmlContent(htmlContent);
		pubTopicForm.setTitle(title);
		pubTopicForm.setForumId(forumId);
		bbsService.saveTopic(helperService.getCurrentUserId(), pubTopicForm);
		
		return "redirect:/forum/" + forumId;
	}
}
