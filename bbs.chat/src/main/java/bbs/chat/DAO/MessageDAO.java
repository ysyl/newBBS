package bbs.chat.DAO;

import org.springframework.stereotype.Repository;

import bbs.chat.mybatis.entity.TMessage;
import bbs.chat.mybatis.mapper.TMessageMapper;

@Repository
public class MessageDAO {
	
	private TMessageMapper tMessageMapper;

	public MessageDAO(TMessageMapper tMessageMapper) {
		super();
		this.tMessageMapper = tMessageMapper;
	}
	
	public Long saveMessage(long senderId, long chatId,String content) {
		TMessage entity = new TMessage();
		entity.setSenderId(senderId);
		entity.setChatId(chatId);
		entity.setContent(content);
		
		tMessageMapper.insertSelective(entity);
		
		return entity.getId();
	};
	
	public void readMessage(long messageId) {
		tMessageMapper.readMessage(messageId);
	}

}
