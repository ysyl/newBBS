package bbs.chat.service;

import java.util.List;

import bbs.chat.entity.BaseChat;
import bbs.chat.entity.Message;

public interface ChatService {
	//返回消息id
	Long sendMessageToSomebody(long senderId, long recipientId);
	
	void hideChat(long uid, long chatId);
	
	void readMessage(long uid, long msgId);
	
	//返回群组聊天Id
	Long createGroupChat(long uid, List<Long> recipientsIdList);
	
	List<BaseChat> getAllChatByUid(long uid);
	
	List<Message> getAllMessageByChatId(long chatId);
}
