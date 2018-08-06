package bbs.web.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bbs.helper.utils.MyLogger;
import bbs.security.service.BbsSecurityService;
import bbs.security.utils.HasNotLoginException;
import bbs.security.utils.IAuthenticationFacade;
import bbs.shop.entity.Commody;
import bbs.shop.entity.CommodyClassification;
import bbs.shop.entity.Keyword;
import bbs.shop.entity.SubClass;
import bbs.shop.entity.UserPerference;
import bbs.shop.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	
	private ShopService shopService;
	
	private IAuthenticationFacade authenticationFacade;

	@Autowired
	public ShopController(ShopService shopService, IAuthenticationFacade authenticationFacade) {
		super();
		this.shopService = shopService;
		this.authenticationFacade = authenticationFacade;
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
		Map<CommodyClassification, List<Commody>> recommendCommodyResultMap = shopService.getAllClassRecommendCommody(uid);
		//如果用户未访问任何商品，则不存在用户喜好
		if (uid != null) {
			UserPerference userPerference = shopService.getUserPerference(uid);
			if (userPerference != null) {
				MyLogger.infoln(this.getClass(), "获取用户喜好的关键词：" + userPerference.getKeywordStatisticList());
				model.addAttribute("userPerference", userPerference);
			}
		}
		
		model.addAttribute("classInfo", classInfo);
		model.addAttribute("youMayLikeCommodyList", commodyList);
		model.addAttribute("recommendCommodyResultMap", recommendCommodyResultMap);
		return "shop_index";
	}
	
	//目前关键词搜索是直接搜索关键词
	@GetMapping("/commody/search")
	public String searchCommody(@RequestParam("keyword") String keywordContent, Model model) {
		Long uid;
		try {
			uid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			uid = null;
		} 
		List<CommodyClassification> classInfo = shopService.getAllClassification();
		List<Commody> searchCommodyBelongKeyword = shopService.searchByKeyword(uid, keywordContent);
		
		Map<Keyword, Integer> commodyBelongKeywordStatisticMap = new LinkedHashMap<>();
		
		for (Commody commody : searchCommodyBelongKeyword) {
			
			for (Keyword keyword : commody.getKeywordList()) {
				if (commodyBelongKeywordStatisticMap.containsKey(keyword)) {
					Integer num = commodyBelongKeywordStatisticMap.get(keyword);
					commodyBelongKeywordStatisticMap.put(keyword, num+1);
				}
				else {
					commodyBelongKeywordStatisticMap.put(keyword, 1);
				}
			}
		}
		
		model.addAttribute("classInfo", classInfo);
		model.addAttribute("keyword", keywordContent);
		model.addAttribute("searchCommodyBelongKeyword", searchCommodyBelongKeyword);
		model.addAttribute("commodyBelongKeywordStatisticMap", commodyBelongKeywordStatisticMap);
		return "shop_search_keyword";
	}
	
	@GetMapping("/search/commody/classification/{classificationId}")
	public String searchClassification(@PathVariable("classificationId") Integer classificationId,
			Model model) {
		Long uid;
		try {
			uid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			uid = null;
		} 
		CommodyClassification classification = shopService.getCommodyClassificationById(classificationId);
		List<Commody> searchCommodyList = shopService.searchByClassificationId(uid, classificationId);
		List<SubClass> subClassList = classification.getSubClasses();
		List<CommodyClassification> classInfo = shopService.getAllClassification();
		
		Map<SubClass, Integer> subClassCommodyStatistic = new LinkedHashMap<>();
		
		

		for(SubClass subClass : subClassList) {
			subClassCommodyStatistic.put(subClass, 0);
			MyLogger.infoln(this.getClass(), "放置子类初始统计: "+ subClass.getName() + " 初始数量: " + subClassCommodyStatistic.get(subClass.getName()));
		}

		for(Commody commody : searchCommodyList) {
			List<SubClass> subClassListBelongCommody = commody.getSubClassList();
			
			MyLogger.infoln(this.getClass(), "获取子类列表: "+ subClassListBelongCommody.size());
			for(SubClass subClass : subClassListBelongCommody) {
				if (subClassCommodyStatistic.containsKey(subClass)) {
				Integer commodyNum = subClassCommodyStatistic.get(subClass);
				MyLogger.infoln(this.getClass(), "更新子类统计: "+ subClass.getName() + " 原数量: " + commodyNum);
				subClassCommodyStatistic.put(subClass, commodyNum + 1);
				}
			}
		}
		
		for(SubClass subClass : subClassList) {
			if (subClassCommodyStatistic.get(subClass) < 1) {
				MyLogger.infoln(this.getClass(), "移除数量为0的子类： " + subClass.getName());
				subClassCommodyStatistic.remove(subClass);
			}
		}
		
		
		model.addAttribute("classInfo", classInfo);
		model.addAttribute("classification", classification);
		model.addAttribute("searchCommodyList", searchCommodyList);
		model.addAttribute("subClassCommodyStatistic", subClassCommodyStatistic);

		return "shop_search_classification";
	}
	
	@GetMapping("/search/commody/subclass/{subclassId}")
	public String searchCommodyBySubClass(@PathVariable("subclassId") int subClassId,
			Model model) {
		Long uid;
		try {
			uid = authenticationFacade.getUserId();
		} catch (HasNotLoginException e) {
			// TODO Auto-generated catch block
			uid = null;
		}	
		List<Commody> searchCommodyList = shopService.searchBySubClassId(uid, subClassId);
		SubClass subClass = shopService.getSubClass(subClassId);
		List<CommodyClassification> classInfo = shopService.getAllClassification();
		
		Map<Keyword, Integer> searchCommodyKeywordStatisticMap = new LinkedHashMap<>();
		
		for (Commody commody : searchCommodyList) {
			//统计搜索到的商品的关键词
			MyLogger.infoln(this.getClass(), "进行关键词与商品数量统计");
			for (Keyword keyword : commody.getKeywordList()) {
				if (searchCommodyKeywordStatisticMap.containsKey(keyword)) {
					Integer commodyBelongKeywordNum = searchCommodyKeywordStatisticMap.get(keyword);
					searchCommodyKeywordStatisticMap.put(keyword, commodyBelongKeywordNum + 1);
				}
				else {
					searchCommodyKeywordStatisticMap.put(keyword, 1);
				}
			}
		}
		
		model.addAttribute("searchCommodyList", searchCommodyList);
		model.addAttribute("subClass", subClass);
		model.addAttribute("searchCommodyKeywordStatisticMap", searchCommodyKeywordStatisticMap);
		model.addAttribute("classInfo", classInfo);
		return "shop_search_subclass";
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
		return "shop_commody_details";
	}

}
