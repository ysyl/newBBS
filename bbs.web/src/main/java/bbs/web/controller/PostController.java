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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bbs.forum.form.PubPostForm;
import bbs.forum.form.PubTopicForm;
import bbs.forum.form.UpdateUserProfileForm;
import bbs.forum.service.BbsService;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.usercenter.service.UserCenterService;
import bbs.web.utils.AvatarGeneratorResult;
import bbs.web.utils.ImgTransformUtils;

@Controller
@RequestMapping("/upload")
public class PostController {

	private BbsService bbsService;

	private UserCenterService userCenterService;

	private ImgTransformUtils bbsImgUtils;

	private IAuthenticationFacade authenticationFacade;

	// public void pubPost(HttpServletRequest req, HttpServletResponse res,
	// @RequestParam("imgFile") MultipartFile imgFile) throws
	// UnsupportedEncodingException {
	// req.setCharacterEncoding("utf-8");
	// String rootPath =
	// req.getSession().getServletContext().getRealPath("/resource/upload");
	//
	// File filePath = new File(rootPath);
	// if (!filePath.exists()) {
	// filePath.mkdirs();
	// }
	//
	// String realFilePath = rootPath + File.pathSeparator +
	// imgFile.getOriginalFilename();
	// File realFile = new File(realFilePath);
	// try {
	// FileUtils.copyInputStreamToFile(imgFile.getInputStream(), realFile);
	// res.getWriter().write( "{\"success\": 1,
	// \"message\":\"上传成功\",\"url\":\"/resources/upload/" +
	// imgFile.getOriginalFilename() + "\"}" );
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// };
	// }

	@Autowired
	public PostController(BbsService bbsService, UserCenterService userCenterService, ImgTransformUtils imgUtils,
			IAuthenticationFacade authenticationFacade) {
		super();
		this.bbsService = bbsService;
		this.userCenterService = userCenterService;
		this.bbsImgUtils = imgUtils;
		this.authenticationFacade = authenticationFacade;
	}

	@PostMapping("/userprofile/{userId}")
	public String updateUserProfile(HttpServletRequest req, @PathVariable("userId") long uid,
			UpdateUserProfileForm updateUserProfileForm, @RequestParam("avatar") MultipartFile avatarFile)
			throws IllegalStateException, IOException, HasNotLoginException {

		if (avatarFile != null) {
			AvatarGeneratorResult avatarGeneratorResult = bbsImgUtils.getRealFile(req, avatarFile);
			String avatarName = avatarGeneratorResult.getAvatarName();
			File realFile = avatarGeneratorResult.getFile();
			avatarFile.transferTo(realFile);

			updateUserProfileForm.setAvatar(avatarName);
		}
		userCenterService.updateUserProfile(uid, updateUserProfileForm);

		return "redirect:/user/" + uid;
	}

	@PostMapping("/post/{topicId}")
	public String pubPostMd(@PathVariable("topicId") long topicId, PubPostForm pubPostForm)
			throws HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		bbsService.savePost(uid, topicId, pubPostForm);
		return "redirect:/topic/" + topicId;
	}

	@PostMapping("/topic/{forumId}")
	public String pubTopicMd(@PathVariable("forumId") int forumId, PubTopicForm pubTopicForm)
			throws HasNotLoginException {
		pubTopicForm.setForumId(forumId);
		bbsService.saveTopic(authenticationFacade.getUserId(), pubTopicForm);

		return "redirect:/forum/" + forumId;
	}
}
