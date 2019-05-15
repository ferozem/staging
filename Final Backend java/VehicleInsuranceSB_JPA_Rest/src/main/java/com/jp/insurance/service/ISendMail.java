/**
 * 
 */
package com.jp.insurance.service;

import com.jp.insurance.exception.PolicyException;

public interface ISendMail {
	public String MailJpmc(String toName , Long custId) throws PolicyException;
}
