package bbs.chat.service;

import java.util.List;

import bbs.chat.DAO.ChatDAO;
import bbs.chat.DAO.MessageDAO;
import bbs.chat.entity.BaseChat;
import bbs.chat.entity.Message;

public class ChatServiceImp implements ChatService {
	
	private ChatDAO chatDAO;
	
	private MessageDAO messageDAO;

	@Override
	public Long sendMessageToSomebody(long senderId, long recipientId) {
		// TODO Auto-generated method stub
		Long chatId;
		chatId = chatDAO.
		return null;
	}

	@Override
	public void hideChat(long uid, long chatId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void readMessage(long uid, long msgId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Long createGroupChat(long uid, List<Long> recipientsIdList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BaseChat> getAllChatByUid(long uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getAllMessageByChatId(long chatId) {
		// TODO Auto-generated method stub
		return null;
	}

}
