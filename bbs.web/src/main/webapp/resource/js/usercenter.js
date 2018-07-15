    class AvatarInput {
      constructor(fileInput, fileNameDisplay, fileBtn, avatarDisplay) {
        this.fileInput = fileInput;
        this.fileNameDisplay = fileNameDisplay;
        this.fileBtn = fileBtn;
        this.avatarDisplay = avatarDisplay;
        this.fileBtn.click(this.clickBtn.bind(this));
        this.fileInput.change(this.displayFileNameAndImg.bind(this))
      }
      clickBtn(e) {
        this.fileInput.click();
      }
      displayFileNameAndImg(e) {
        let file = e.target.files[0];
        let fileName = file.name;
        let fileUrl = window.URL.createObjectURL(file);
        this.displayFileName(fileName);
        this.displayImage(fileUrl);
      }
      displayFileName(fileName) {
        this.fileNameDisplay.attr("value",fileName);
      }
      displayImage(src) {
        this.avatarDisplay.attr("src", src)
      }
    }
    new AvatarInput($("#file-input"), $("#file-name-display"),  $("#file-btn"), $("#avatar-display"));
