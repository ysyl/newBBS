package bbs.shop.service;

import bbs.shop.DTO.Commody;
import bbs.shop.DTO.PrimaryCommodyComment;

import java.util.List;

import bbs.shop.DTO.BaseCommodyComment;
import bbs.shop.form.PubCommodyCommentForm;
import bbs.shop.form.PubCommodyForm;
import bbs.shop.form.UpdateCommodyForm;

public interface ShopService {

	long saveCommody(long uid, PubCommodyForm pubCommodyForm);

	Commody getCommody(long commodyId);

	void updateCommody(long commodyId, UpdateCommodyForm updateCommodyForm);

	long savePrimaryComment(Long uid, PubCommodyCommentForm commentForm);

	BaseCommodyComment getCommodyCommentByCommentId(long commentId);

	List<PrimaryCommodyComment> getAllPrimaryCommentByCommodyId(Long commodyId);

}
