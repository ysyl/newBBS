package bbs.shop.entity;

import java.io.Serializable;

public class KeywordStatistic implements Serializable {
		private static final long serialVersionUID = 1L;
		private Keyword keyword;
		private Integer frequency;
		public Keyword getKeyword() {
			return keyword;
		}
		public void setKeyword(Keyword keyword) {
			this.keyword = keyword;
		}
		public Integer getFrequency() {
			return frequency;
		}
		public void setFrequency(Integer frequency) {
			this.frequency = frequency;
		}
		
		public String toString() {
			return keyword + " " + frequency;
		}
}
