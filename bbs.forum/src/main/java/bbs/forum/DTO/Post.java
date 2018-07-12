package bbs.forum.DTO;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {
	 
   private Long id;

   
   private String content;
   
   private String htmlContent;
   
   private User author;

   
   private Date pubTime;

   
   private Date lastModifiedTime;

   
   private Post replyPost;
   
   private Topic topic;
   
   private User lastReplier;

   

   
   public String getHtmlContent() {
	return htmlContent;
}


public void setHtmlContent(String htmlContent) {
	this.htmlContent = htmlContent;
}


public Long getId() {
       return id;
   }

   
   public void setId(Long id) {
       this.id = id;
   }

   
   public String getContent() {
       return content;
   }

   
   public void setContent(String content) {
       this.content = content;
   }
   

   
   public Date getPubTime() {
       return pubTime;
   }

   
   public void setPubTime(Date pubTime) {
       this.pubTime = pubTime;
   }

   
   public Date getLastModifiedTime() {
       return lastModifiedTime;
   }

   
   public void setLastModifiedTime(Date lastModifiedTime) {
       this.lastModifiedTime = lastModifiedTime;
   }


public User getAuthor() {
	return author;
}


public void setAuthor(User author) {
	this.author = author;
}


public Post getReplyPost() {
	return replyPost;
}


public void setReplyPost(Post replyPost) {
	this.replyPost = replyPost;
}


public Topic getTopic() {
	return topic;
}


public void setTopic(Topic topic) {
	this.topic = topic;
}

public String toString() {
	return "\nPost: {"
				+ "\n\tcontent: " + this.content
				+ "\n\tauthor: " + this.author
				+ this.topic
				+ "\n}";
}

}
