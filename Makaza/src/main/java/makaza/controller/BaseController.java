package makaza.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import makaza.common.CodeDef;
import makaza.model.ReturnEnity;

public class BaseController {

	/**
	 * Controler Exception
	 * 
	 * @param ex Exception
	 * @return ReturnEnity
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ReturnEnity> return400(Exception ex) {
//		ReturnEnity value = this.setReturnValue(CodeDef.FAIL.getCode(), ex.getCause().getMessage());
		ReturnEnity value = this.setReturnValue(CodeDef.FAIL.getCode(), ex.getMessage());
		return new ResponseEntity<ReturnEnity>(value, HttpStatus.OK);
	}

	/**
	 * Setting return object
	 * 
	 * @param code    success
	 * @param message message
	 * @return
	 */
	public ReturnEnity setReturnValue(String code, String message) {
		ReturnEnity value = new ReturnEnity();
		value.setSuccess(code);
		value.setMessage(message);

		return value;
	}
}
