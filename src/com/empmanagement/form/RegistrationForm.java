package com.empmanagement.form;

import java.time.LocalDate;
import java.time.Period;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.empmanagement.utility.DataAccessManager;
import com.empmanagement.utility.StringUtil;

public class RegistrationForm extends org.apache.struts.action.ActionForm{
	private String empName;                       
	private long empAadhaarNumber;              
	private String empPermCity;                
	private long empPermPincode;               
	private String empCurrentCity;          
	private long empCurrentPincode;         
	private long empMobile;                  
	private String empEmail;                       
	private String empBloodGroup;             
	private String empJoinDate;                 
	private String empDOB;                          
	private String empDepartment;              
	private String empDesignation;              
	private long empBankAccountNumber;     
	private String empBankName;                   
	private String empIFSCCode;
	private String empGender;
	private String empManager;
	private String empLevel;
	private String empPermAddressLine1;          
	private String empPermAddressLine2;             
	private String empCurrentAddressLine1;          
	private String empCurrentAddressLine2;
	private String empType;
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		System.out.println("RegistrationForm "+empType);
		this.empType = empType;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		System.out.println("RegistrationForm "+empName);
		this.empName = empName;
	}
	public long getEmpAadhaarNumber() {
		return empAadhaarNumber;
	}
	public void setEmpAadhaarNumber(long empAadhaarNumber) {
		this.empAadhaarNumber = empAadhaarNumber;
	}
	public String getEmpPermCity() {
		return empPermCity;
	}
	public void setEmpPermCity(String empPermCity) {
		this.empPermCity = empPermCity;
	}
	public long getEmpPermPincode() {
		return empPermPincode;
	}
	public void setEmpPermPincode(long empPermPincode) {
		this.empPermPincode = empPermPincode;
	}
	public String getEmpCurrentCity() {
		return empCurrentCity;
	}
	public void setEmpCurrentCity(String empCurrentCity) {
		this.empCurrentCity = empCurrentCity;
	}
	public long getEmpCurrentPincode() {
		return empCurrentPincode;
	}
	public void setEmpCurrentPincode(long empCurrentPincode) {
		this.empCurrentPincode = empCurrentPincode;
	}
	public long getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(long empMobile) {
		this.empMobile = empMobile;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpBloodGroup() {
		return empBloodGroup;
	}
	public void setEmpBloodGroup(String empBloodGroup) {
		this.empBloodGroup = empBloodGroup;
	}
	public String getEmpJoinDate() {
		return empJoinDate;
	}
	public void setEmpJoinDate(String empJoinDate) {
		this.empJoinDate = empJoinDate;
	}
	public String getEmpDOB() {
		return empDOB;
	}
	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	public long getEmpBankAccountNumber() {
		return empBankAccountNumber;
	}
	public void setEmpBankAccountNumber(long empBankAccountNumber) {
		this.empBankAccountNumber = empBankAccountNumber;
	}
	public String getEmpBankName() {
		return empBankName;
	}
	public void setEmpBankName(String empBankName) {
		this.empBankName = empBankName;
	}
	public String getEmpIFSCCode() {
		return empIFSCCode;
	}
	public void setEmpIFSCCode(String empIFSCCode) {
		this.empIFSCCode = empIFSCCode;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpManager() {
		return empManager;
	}
	public void setEmpManager(String empManager) {
		this.empManager = empManager;
	}
	public String getEmpLevel() {
		return empLevel;
	}
	public void setEmpLevel(String empLevel) {
		this.empLevel = empLevel;
	}
	public String getEmpPermAddressLine1() {
		return empPermAddressLine1;
	}
	public void setEmpPermAddressLine1(String empPermAddressLine1) {
		this.empPermAddressLine1 = empPermAddressLine1;
	}
	public String getEmpPermAddressLine2() {
		return empPermAddressLine2;
	}
	public void setEmpPermAddressLine2(String empPermAddressLine2) {
		this.empPermAddressLine2 = empPermAddressLine2;
	}
	public String getEmpCurrentAddressLine1() {
		return empCurrentAddressLine1;
	}
	public void setEmpCurrentAddressLine1(String empCurrentAddressLine1) {
		this.empCurrentAddressLine1 = empCurrentAddressLine1;
	}
	public String getEmpCurrentAddressLine2() {
		return empCurrentAddressLine2;
	}
	public void setEmpCurrentAddressLine2(String empCurrentAddressLine2) {
		this.empCurrentAddressLine2 = empCurrentAddressLine2;
	}         
	
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		DataAccessManager dam = new DataAccessManager();
		ActionErrors errors = new ActionErrors();
		System.out.println("VALIDATE STARTED IN REGISTRATION FORM ");
		if(String.valueOf(empAadhaarNumber).length()!=12){
			errors.add("empAadhaarNumber", new ActionMessage("error.aadhaarNumber.length"));
		}
		else if(dam.validateAadhaarNumber(empAadhaarNumber))
		{
			errors.add("empAadhaarNumber", new ActionMessage("error.message.aadhaarnumber"));
		}
		if(Period.between( LocalDate.parse(empDOB) , LocalDate.now()).getYears() < 18)
		{
			System.out.println("DOB IS "+empDOB);
			errors.add("empDOB", new ActionMessage("error.empDOB.minimun"));
		}
		if(LocalDate.parse(empJoinDate).isAfter(LocalDate.now()))
		{
			System.out.println("DOJ IS "+empJoinDate);
			errors.add("empJoinDate", new ActionMessage("error.empJoinDate.greater"));
		}
		if(empName.length() <= 4)
		{
			errors.add("empName", new ActionMessage("error.empName.length"));
		}
		if(String.valueOf(empMobile).length() != 10)
		{
			errors.add("empMobile", new ActionMessage("error.empMobile.lengrh"));
		}
		if(String.valueOf(empCurrentPincode).length() != 6 || String.valueOf(empPermPincode).length()!=6)
		{
			errors.add("empCurrentPincode", new ActionMessage("error.empCurrentPincode.length"));
			errors.add("empPermPincode", new ActionMessage("error.empCurrentPincode.length"));
		}
		if(String.valueOf(empBankAccountNumber).length() < 10 || String.valueOf(empBankAccountNumber).length() > 15)
		{
			errors.add("empBankAccountNumber", new ActionMessage("error.empBankAccountNumber.length"));
		}
		if(StringUtil.checkStringChar(empCurrentCity) || StringUtil.checkStringChar(empPermCity))
		{
			errors.add("empCurrentCity", new ActionMessage("error.City.contains"));
			errors.add("empPermCity", new ActionMessage("error.City.contains"));
		}
		if(StringUtil.checkStringChar(empName) || StringUtil.checkStringChar(empBankName) || StringUtil.checkStringChar(empManager))
		{
			errors.add("empName", new ActionMessage("error.name.contains"));
			errors.add("empBankName", new ActionMessage("error.name.contains"));
			errors.add("empManager", new ActionMessage("error.name.contains"));
		}
		System.out.println("VALIDATE ENDED IN REGISTRATION FORM");
		return errors;
	}
	
}
