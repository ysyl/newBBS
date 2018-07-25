package bbs.shop.DTO;

public class CommodyClassRecommend extends CommodyRecommend {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CommodyClassification classification;

	public CommodyClassification getClassification() {
		return classification;
	}

	public void setClassification(CommodyClassification classification) {
		this.classification = classification;
	}
}
