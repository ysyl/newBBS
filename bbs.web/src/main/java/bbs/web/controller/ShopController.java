package bbs.web.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.forum.DTO.User;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;
import bbs.security.service.BbsSecurityService;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.security.utils.PrincipalChecker;
import bbs.shop.entity.Commody;
import bbs.shop.entity.CommodyClassification;
import bbs.shop.entity.Keyword;
import bbs.shop.entity.PrimaryCommodyComment;
import bbs.shop.entity.SubClass;
import bbs.shop.entity.UserPerference;
import bbs.shop.service.ShopService;
import bbs.usercenter.service.UserCenterService;
import bbs.web.enuma.OrderType;
import bbs.web.enuma.SearchType;
import bbs.web.utils.DateUtils;

@Controller
@RequestMapping("/shop")
public class ShopController {

	private ShopService shopService;

	private IAuthenticationFacade authenticationFacade;

	private BbsService bbsService;

	private DateUtils dateUtils;
	
	private PrincipalChecker principalChecker;
	
	private UserCenterService userCenterService;

	@Autowired
	public ShopController(ShopService shopService, IAuthenticationFacade authenticationFacade, BbsService bbsService,
			DateUtils dateUtils, PrincipalChecker principalChecker, UserCenterService userCenterService) {
		super();
		this.shopService = shopService;
		this.authenticationFacade = authenticationFacade;
		this.bbsService = bbsService;
		this.dateUtils = dateUtils;
		this.principalChecker = principalChecker;
		this.userCenterService = userCenterService;
	}

	@GetMapping("/index")
	public String index(Model model) {
		Long uid;
		try {
			uid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			uid = null;
		}
		List<CommodyClassification> classInfo = shopService.getAllClassification();
		List<Commody> commodyList = shopService.getYouMayLikeCommody(uid);
		Map<CommodyClassification, List<Commody>> recommendCommodyResultMap = shopService
				.getAllClassRecommendCommody(uid);
		// 如果用户未访问任何商品，则不存在用户喜好
		if (uid != null) {
			UserPerference userPerference = shopService.getUserPerference(uid);
			if (userPerference != null) {
				MyLogger.infoln(this.getClass(), "获取用户喜好的关键词：" + userPerference.getKeywordStatisticList());
				model.addAttribute("userPerference", userPerference);
			}
		}
		List<Entry<CommodyClassification, List<Commody>>> entryList = new ArrayList<>(
				recommendCommodyResultMap.entrySet());
		
		//商品收藏情况
		List<Long> commodyIdList = commodyList.stream().map(commody -> commody.getId()).collect(Collectors.toList());
		Map<Long, Boolean> commodyCollectedSituation = userCenterService.isCollectedCommodyList(uid, commodyIdList);

		model.addAttribute("classInfo", classInfo);
		model.addAttribute("youMayLikeCommodyList", commodyList);
		model.addAttribute("recommendCommodyResultMap", recommendCommodyResultMap);
		model.addAttribute("recommendCommodyResultMapEntryList", entryList);
		model.addAttribute("dateUtils", dateUtils);
		model.addAttribute("commodyCollectedSituation", commodyCollectedSituation);
		model.addAttribute("principalChecker", principalChecker);
		return "shop_index";
	}

	@GetMapping("/commody/search/total")
	public String searchTotal(@RequestParam("search_type") SearchType searchType,
			@RequestParam(value = "classification_id", required = false) Integer classificationId,
			@RequestParam(value = "subclass_id", required = false) Integer subClassId, 
			@RequestParam(value = "keyword", required = false) String keywordContent,
			@RequestParam(value = "user_id", required = false) Long userId,
			@RequestParam(value = "order_by", defaultValue="NEW") OrderType orderType,
			Model model
			) {
		Long uid;
		try {
			uid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			uid = null;
		}
		MyLogger.infoln(this.getClass(), "搜索类型：" + searchType);
		MyLogger.infoln(this.getClass(), "排序类型：" + orderType);

		List<CommodyClassification> classInfo = shopService.getAllClassification();
		List<Commody> searchCommodyList = null;
		List<SubClass> subClassList = null;
		CommodyClassification classification = null;
		SubClass subClass = null;
		User user = null;
		Keyword keyword = null;

		Map<SubClass, Integer> subClassCommodyStatistic = new LinkedHashMap<>();
		Map<Keyword, Integer> searchCommodyKeywordStatisticMap = new LinkedHashMap<>();
		
		
		switch(searchType) {
		case CLASSIFICATION: {
			MyLogger.infoln(this.getClass(), "搜索类型为Classification");
			classification = shopService.getCommodyClassificationById(classificationId);
			searchCommodyList = shopService.searchByClassificationId(uid, classificationId);
			subClassList = classification.getSubClasses();

			subClassList.stream()
			.forEach( subClassItem -> subClassCommodyStatistic.put(subClassItem, 0));

//			for (Commody commody : searchCommodyList) {
//				List<SubClass> subClassListBelongCommody = commody.getSubClassList();
//
//				MyLogger.infoln(this.getClass(), "获取子类列表: " + subClassListBelongCommody.size());
//				for (SubClass subClassItem : subClassListBelongCommody) {
//					if (subClassCommodyStatistic.containsKey(subClassItem)) {
//						Integer commodyNum = subClassCommodyStatistic.get(subClassItem);
//						MyLogger.infoln(this.getClass(), "更新子类统计: " + subClassItem.getName() + " 原数量: " + commodyNum);
//						subClassCommodyStatistic.put(subClassItem, commodyNum + 1);
//					}
//				}
//			}
			
			searchCommodyList.stream()
			.flatMap( commody -> commody.getSubClassList().stream() )
			.filter( subClassItem -> subClassCommodyStatistic.containsKey(subClassItem))
			.forEach( subClassItem -> {
				Integer commodyNum = subClassCommodyStatistic.get(subClassItem);
				MyLogger.infoln(this.getClass(), "更新子类统计: " + subClassItem.getName() + " 原数量: " + commodyNum);
				subClassCommodyStatistic.put(subClassItem, commodyNum + 1);
			});
			
			subClassList.stream()
			.filter( subClassItem -> subClassCommodyStatistic.get(subClassItem) < 1)
			.forEach( subClassItem -> subClassCommodyStatistic.remove(subClassItem) );
			
			break;
		}
		case SUBCLASS: {
			MyLogger.infoln(this.getClass(), "搜索类型为subClass");
			subClass = shopService.getSubClass(subClassId);
			searchCommodyList = shopService.searchBySubClassId(uid, subClassId);
			
			for (Commody commody : searchCommodyList) {
				// 统计搜索到的商品的关键词
				MyLogger.infoln(this.getClass(), "进行关键词与商品数量统计");
				
				commody.getKeywordList().stream()
				.forEach( keywordItem -> {
					if (searchCommodyKeywordStatisticMap.containsKey(keywordItem)) {
						Integer commodyBelongKeywordNum = searchCommodyKeywordStatisticMap.get(keywordItem);
						searchCommodyKeywordStatisticMap.put(keywordItem, commodyBelongKeywordNum + 1);
					} else {
						searchCommodyKeywordStatisticMap.put(keywordItem, 1);
					}
				});
			}

			break;
		}

		case KEYWORD: {
			MyLogger.infoln(this.getClass(), "搜索类型为keyword");
			searchCommodyList = shopService.searchByKeyword(uid, keywordContent);
			
			for (Commody commody : searchCommodyList) {
				// 统计搜索到的商品的关键词
				MyLogger.infoln(this.getClass(), "进行关键词与商品数量统计");
				for (Keyword keywordItem : commody.getKeywordList()) {
					if (searchCommodyKeywordStatisticMap.containsKey(keywordItem)) {
						Integer commodyBelongKeywordNum = searchCommodyKeywordStatisticMap.get(keywordItem);
						searchCommodyKeywordStatisticMap.put(keywordItem, commodyBelongKeywordNum + 1);
					} else {
						searchCommodyKeywordStatisticMap.put(keywordItem, 1);
					}
				}
			}	

			break;
		}
			
		case SELLER: {
			MyLogger.infoln(this.getClass(), "搜索类型为seller");
			searchCommodyList = shopService.getAllCommodyBySellerId(userId);
			
			for (Commody commody : searchCommodyList) {
				// 统计搜索到的商品的关键词
				MyLogger.infoln(this.getClass(), "进行关键词与商品数量统计");
				for (Keyword keywordItem : commody.getKeywordList()) {
					if (searchCommodyKeywordStatisticMap.containsKey(keywordItem)) {
						Integer commodyBelongKeywordNum = searchCommodyKeywordStatisticMap.get(keywordItem);
						searchCommodyKeywordStatisticMap.put(keywordItem, commodyBelongKeywordNum + 1);
					} else {
						searchCommodyKeywordStatisticMap.put(keywordItem, 1);
					}
				}
			}	
			break;
		}
			
		}
		
		model.addAttribute("classInfo", classInfo);
		model.addAttribute("dateUtils", dateUtils);
		model.addAttribute("searchType", searchType);
		model.addAttribute("orderType", orderType);
		model.addAttribute("keyword", keywordContent);
		model.addAttribute("classification", classification);
		model.addAttribute("subClass", subClass);
		model.addAttribute("user", user);
		model.addAttribute("searchCommodyList", searchCommodyList);
		model.addAttribute("searchCommodyKeywordStatisticMap", searchCommodyKeywordStatisticMap);
		model.addAttribute("subClassCommodyStatistic", subClassCommodyStatistic);
		return "shop_search_commody";
	}


	@GetMapping("/commody/{commodyId}")
	public String viewCommody(@PathVariable("commodyId") long commodyId, Model model) {
		Long uid;
		try {
			uid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			uid = null;
		}
		List<CommodyClassification> classInfo = shopService.getAllClassification();
		Commody commody = shopService.getCommody(uid, commodyId);

		model.addAttribute("commody", commody);
		model.addAttribute("classInfo", classInfo);
		model.addAttribute("dateUtils", dateUtils);
		model.addAttribute("principalChecker", principalChecker);
		return "shop_commody_details";
	}



	@GetMapping("/commodycomment/{commodyId}")
	@ResponseBody
	public List<PrimaryCommodyComment> getComment(@PathVariable("commodyId") Long commodyId, Model model) {
		return shopService.getAllPrimaryCommentByCommodyId(commodyId);
	}

}
