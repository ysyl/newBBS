package bbs.shop.keyword.extractor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.tagging.PartOfSpeechTagging;
import org.springframework.stereotype.Component;

import bbs.shop.entity.Keyword;

@Component
public class DefaultKeywordExtractor implements KeywordExtractor {

	@Override
	public Set<Keyword> seg(String text) {
		// TODO Auto-generated method stub  
		//分词，不保留停止词
		List<Word> words = WordSegmenter.seg(text);
		//标注词性
		PartOfSpeechTagging.process(words);
		//分离出名词，返回
		Set<Keyword> result = new HashSet<>();

		for (Word word : words) {
			String partOfSpeech = word.getPartOfSpeech().getPos();
				Keyword keyword = new Keyword(word.getText(), word.getPartOfSpeech().getPos());
				if (keyword.getContent().length() > 1)
				result.add(keyword);
		}
		
		return result;
	}

}
