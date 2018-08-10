package bbs.forum.DTO;

import java.io.Serializable;
import java.util.Random;

public class Forum implements Serializable {
	
   private Integer id;

   
   private String forumName;

   
   public Integer getId() {
       return id;
   }

   
   public void setId(Integer id) {
       this.id = id;
   }

   
   public String getForumName() {
       return forumName;
   }

   
   public void setForumName(String forumName) {
       this.forumName = forumName;
   }
   
   @Override
   public String toString() {
	   return "Forum: " + this.forumName;
   }


//Forum取由id决定的随机值
@Override
public int hashCode() {
	// TODO Auto-generated method stub
	return new Random(id).nextInt(Integer.MAX_VALUE);
}
}
