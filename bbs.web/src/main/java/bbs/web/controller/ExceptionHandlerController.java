package bbs.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import bbs.usercenter.exception.RepetitiveCollectException;
import bbs.web.msg.ErrorMessage;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(RepetitiveCollectException.class)
	@ResponseBody
	public ErrorMessage handleRepetitiveCollect(RepetitiveCollectException e) {
		return new ErrorMessage(e.getMessage());
	}
}
