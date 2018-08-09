package bbs.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bbs.forum.form.PubPostForm;
import bbs.forum.form.PubTopicForm;
import bbs.forum.form.UpdateUserProfileForm;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.PubPrimaryCommodyCommentForm;
import bbs.shop.form.PubReplyCommodyCommentForm;
import bbs.shop.form.UpdateCommodyForm;
import bbs.shop.service.ShopService;
import bbs.usercenter.service.UserCenterService;
import bbs.web.utils.FileUploadResult;
import bbs.web.utils.UploadUtils;

@Controller
@RequestMapping("/upload")
public class PostController {

	private BbsService bbsService;

	private UserCenterService userCenterService;

	private UploadUtils bbsImgUtils;

	private IAuthenticationFacade authenticationFacade;
	
	private ShopService shopService;
	
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


	@PostMapping("/userprofile/{userId}")
	public String updateUserProfile(HttpServletRequest req, @PathVariable("userId") long uid,
			UpdateUserProfileForm updateUserProfileForm)
			throws IllegalStateException, IOException, HasNotLoginException {

		String avatarName = null;
		
		MultipartFile avatarFile = updateUserProfileForm.getAvatarFile();
		
		MyLogger.info("\n avatarFile: " + avatarFile.getSize());

		if (avatarFile != null) {
			FileUploadResult avatarGeneratorResult = bbsImgUtils.getImgRealFile(req, avatarFile);
			avatarName = avatarGeneratorResult.getFileName();
			File realFile = avatarGeneratorResult.getFile();
			avatarFile.transferTo(realFile);
		}
		userCenterService.updateUserProfile(uid, avatarName, updateUserProfileForm.getNickname(), updateUserProfileForm.getSex());

		return "redirect:/user/" + uid;
	}

	public PostController(BbsService bbsService, UserCenterService userCenterService, UploadUtils bbsImgUtils,
			IAuthenticationFacade authenticationFacade, ShopService shopService) {
		super();
		this.bbsService = bbsService;
		this.userCenterService = userCenterService;
		this.bbsImgUtils = bbsImgUtils;
		this.authenticationFacade = authenticationFacade;
		this.shopService = shopService;
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
	
	@PostMapping("/commody")
	public String pubCommody(HttpServletRequest req, PubCommodyForm pubCommodyForm, BindingResult bindResult) throws HasNotLoginException, IllegalStateException, IOException {
		Long uid = authenticationFacade.getUserId();
		List<String> imgFileNames = new ArrayList<>();
		for (MultipartFile imgFile : pubCommodyForm.getImgFile()) {
			FileUploadResult result = bbsImgUtils.getImgRealFile(req, imgFile);
			imgFileNames.add(result.getFileName());
			File realFile = result.getFile();
			imgFile.transferTo(realFile);
		}
		long commodyId = shopService.saveCommody(uid, pubCommodyForm.getTitle(), pubCommodyForm.getDescription(), pubCommodyForm.getPrice(), 
				imgFileNames, pubCommodyForm.getCommodyClassificationId(), pubCommodyForm.getSubClassList());
		return "redirect:/shop/commody/"+commodyId;
	}
	
	//更新商品
	@PostMapping("/commody/put/{commodyId}")
	public String putCommody(@PathVariable("commodyId") long commodyId, 
			UpdateCommodyForm form,
			HttpServletRequest req
			) throws IllegalStateException, IOException, HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		MyLogger.infoln(this.getClass(), "收到的form" + form.toString());
		List<String> imgFileNames = new ArrayList<>();
		
		for (MultipartFile imgFile : form.getImgFiles()) {
			FileUploadResult result = bbsImgUtils.getImgRealFile(req, imgFile);
			imgFileNames.add(result.getFileName());
			File realFile = result.getFile();
			imgFile.transferTo(realFile);
		}
		shopService.updateCommody(commodyId, form.getTitle(), form.getDescription(), form.getPrice(), 
				imgFileNames, form.getClassificationId(), form.getSubClassList());
		return "redirect:/shop/commody/" + commodyId;
	}
	
	@PostMapping("/commodycomment/primary/commody/{commodyId}")
	public String pubCommodyComment(@PathVariable("commodyId") long commodyId, 
			PubPrimaryCommodyCommentForm form) throws HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		shopService.savePrimaryComment(uid, commodyId, form);
		return "redirect:/shop/commody/"+commodyId;
	}

	@PostMapping("/commodycomment/reply/commody/{commodyId}")
	public String pubReplyCommodyComment(@PathVariable("commodyId") long commodyId, 
			PubReplyCommodyCommentForm form) throws HasNotLoginException {
		Long uid = authenticationFacade.getUserId();
		shopService.saveReplyComment(uid, commodyId, form);
		return "redirect:/shop/commody/"+commodyId;
	}
}
