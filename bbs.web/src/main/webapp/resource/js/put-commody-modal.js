class PutCommodyModal {
	constructor(modal, toggleBtn) {
		this.modal = modal;
		this.toggleBtn = toggleBtn;
		this.classificationId = null;
		this.subClassList = null;
		
		this.ClassificationSelector = $(modal.find("[name='commodyClassificationId']"));
		this.SubClassMultipleSelector = $(modal.find("[name='subClassList']"))
		
		this.toggleBtn.click( e => {
			this.modal.modal("show");
		})
		
		this.ClassificationSelector.on("change", e => {
			this.setClassificationId(e.target.value);
		})
		
		this.setClassificationId(classInfo[0].id);
	}
	
	setClassificationId(classificationId) {
		this.classificationId = classificationId;
		let subClassList = null;
		classInfo.forEach( item => {
			if (item.id+"" === classificationId+"") subClassList = item.subClasses;
		})
		this.setSubClassList(subClassList);
	}
	
	setSubClassList(subClassList) {
		console.log("改变subClass");
		this.subClassList = subClassList;
		
		let subClassOptionTemplate = subClass => `
			<option value="${subClass.id}">${subClass.name}</option>
		`;
		this.SubClassMultipleSelector.html(
			this.subClassList.map( item => subClassOptionTemplate(item)).join()
		);
	}
}