package com.csp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csp.services.ICustomerStatementValidationService;

@RestController
public class WelcomeController 
{
	final static Logger logger = Logger.getLogger(WelcomeController.class);

	@Autowired
	private ICustomerStatementValidationService customerStatementValidationService;

	@RequestMapping("/processStmnt/")
	public  Map<String, Object> processStmnt(){
		logger.info("Customer Statement Processing Started");
		Map<String,Object> result = new HashMap<>();
		result.put("result", customerStatementValidationService.processStmnt());
		return result;
	}

}
