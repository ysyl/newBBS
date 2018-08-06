package bbs.shop.keyword.extractor;

import java.util.List;
import java.util.Set;

import bbs.shop.entity.Keyword;

public interface KeywordExtractor {
	
	Set<Keyword> seg(String text);
	
}
