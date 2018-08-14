package bbs.chat.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bbs.chat.entity.BaseChat;
import bbs.chat.enuma.ChatType;
import bbs.chat.mybatis.entity.TChat;
import bbs.chat.mybatis.mapper.TChatMapper;

@Repository
public class ChatDAO {
	
	private TChatMapper tChatMapper;

	@Autowired
	public ChatDAO(TChatMapper tChatMapper) {
		super();
		this.tChatMapper = tChatMapper;
	}
	
	public List<BaseChat> getAllChatByUserId(long uid) {
		
	}

	public Long savePrivateChat(long senderId, long recipientId) {
		TChat entity = new TChat();
		entity.setChatType(ChatType.PRIVATE);
		entity.setSenderId(senderId);
		entity.setRecipientId(recipientId);

		tChatMapper.insertSelective(entity);
		
		return entity.getId();
	}

	@Transactional
	public Long saveGroupChat(long senderId, List<Long> recipientIdList, String groupName) 
		throws DataIntegrityViolationException {
		TChat entity = new TChat();
		entity.setChatType(ChatType.GROUP);
		entity.setGroupName(groupName);
		entity.setSenderId(senderId);
		tChatMapper.insertSelective(entity);
		
		Long groupChatId = entity.getId();
		
		tChatMapper.linkUserToGroupChat(groupChatId, recipientIdList);

		return groupChatId;
	}
	
	//面向用户隐藏该聊天
	public void hidePrivateChat(long userId, long chatId) {
		tChatMapper.hideChatByUserIdAndChatId(userId, chatId);
	}

	public void showPrivateChat(long userId, long chatId) {
		tChatMapper.showChatByUserIdAndChatId(userId, chatId);
	}
	
	public void deleteGroupChat(long organizerId, long groupChatId) {
		tChatMapper.deleteGroupChat(organizerId, groupChatId);
	};
	
}
