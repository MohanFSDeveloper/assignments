package com.csp.services;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.csp.custom.annotation.model.ValidationResult;
import com.csp.custom.annotation.validator.AbstractValidator;
import com.csp.custom.annotation.validator.UniqueValidator;
import com.csp.custom.annotation.validator.ValidEndBalanceValidator;
import com.csp.dto.CustomerStatement;
import com.csp.util.CSPUtils;

@Service
public class CustomerStatementValidationService implements ICustomerStatementValidationService{

	final static Logger logger = Logger.getLogger(CustomerStatementValidationService.class);

	List < AbstractValidator > availableValidators;
	
	@Value("${application.customerstatement.path}")
	private String customerStatementPath;

	@PostConstruct
	/*
	 * This will initialize the required validators 
	 */
	private void setupValidators() throws Exception {
		availableValidators = new LinkedList < AbstractValidator > ();
		availableValidators.add(new UniqueValidator());
		availableValidators.add(new ValidEndBalanceValidator());
	}

	/*
	 * Method is used to validate the attributes based on the configured annotations.
	 * Once the validation done the result will be collected as List<ValidationResult>. 
	 */
	private < T > List < Object > applyValidators(T t)throws IllegalArgumentException,IllegalAccessException {
		List < Object > results = new LinkedList < Object > ();
		for (AbstractValidator validator: availableValidators) {
			List < ValidationResult > result = validator.evaluateValidations(t);
			results.addAll(result);
		}
		return results;
	}

	/*
	 * Method to read Customer statement file using CSVParser from Apache Commons CSV
	 */
	public List < Object > processStmnt() {
		logger.info("Customer Statement Processing validation Started ");
		List < Object > validationResults = new LinkedList < Object > ();
		try {
			for (CustomerStatement custStmnt : readStmnt()){
				validationResults.addAll(applyValidators(custStmnt));
			}
			setupValidators();
			logger.info("Validtion REsults : "+validationResults);
		}catch (Exception e) {
			logger.error("Unexcepted error occured while validating Statement"+e.getMessage());
		}
		return validationResults;
	}

	/*
	 * This method is used to parse the given customer statement( csv file ) 
	 * and returns List<CustomerStatement>.
	 */
	public List<CustomerStatement> readStmnt() {
		logger.info("Going to read CSV statement ");
		List<CustomerStatement> customerDetails = new ArrayList<>();
		try(CSVParser parser = new CSVParser(new FileReader(customerStatementPath), CSVFormat.DEFAULT.withHeader())){
			for (CSVRecord record : parser) {
				CustomerStatement custStmnt = new CustomerStatement();
				if(!CSPUtils.isNullOrEmptyOrDefault(record.get("Reference")))
					custStmnt.setTransactionRefNumber(Long.valueOf(record.get("Reference")));
				if(!CSPUtils.isNullOrEmptyOrDefault(record.get("AccountNumber")))
					custStmnt.setAccntNumber(record.get("AccountNumber"));
				if(!CSPUtils.isNullOrEmptyOrDefault(record.get("Description")))
					custStmnt.setDesc(record.get("Description"));
				if(!CSPUtils.isNullOrEmptyOrDefault(record.get("Start Balance")))
					custStmnt.setStartBalance(record.get("Start Balance"));
				if(!CSPUtils.isNullOrEmptyOrDefault(record.get("Mutation")))
					custStmnt.setMutation(record.get("Mutation"));
				if(!CSPUtils.isNullOrEmptyOrDefault(record.get("End Balance")))
					custStmnt.setEndBalance(record.get("End Balance"));
				customerDetails.add(custStmnt);
			}
		}catch(Exception e){
			logger.error("Unexcepted error occured while processing Statement"+e.getMessage());
		}
		return customerDetails;
	}
}

