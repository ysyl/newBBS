package bbs.shop.service;

import static org.junit.Assert.assertEquals;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import bbs.helper.utils.MyLogger;
import bbs.shop.entity.Keyword;
import bbs.shop.keyword.extractor.KeywordExtractor;

public class KeywordTest extends BaseTest {

	@Autowired
	KeywordExtractor keywordExtractor;
	
	
	public void test() throws UnsupportedEncodingException {
		String text = "《超级马里奥 奥德赛》（日语：スーパーマリオ オデッセイ，英语：Super Mario Odyssey，港台译作“超级玛利欧 奥德赛”，官方简体中文标题译作“超级马力欧 奥德赛”）是一款由任天堂企划制作本部开发并由任天堂发行在任天堂Switch平台上的平台游戏。本作是超级马里奥系列第7款3D平台游戏[1]，也是系列睽违15年继承《超级马里奥64》以及《阳光马里奥》高自由度血脉的“箱庭探索3D马里奥”。《超级马里奥 奥德赛》在E3 2017期间宣布游戏将支持简体中文与繁体中文。[2]游戏于2017年10月27日起在全球发行，并获得了业界极高的评价，多家媒体给出了满分。";
		Set<Keyword> resultKeyword = keywordExtractor.seg(text);
		
		MyLogger.info("test keyword "+resultKeyword);
		MyLogger.info("keyword size "+resultKeyword.size());
		System.out.println(resultKeyword);
		
		assertEquals("测试字符串".hashCode(), "测试字符串".hashCode());
	}
}
