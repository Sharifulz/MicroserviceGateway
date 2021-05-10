package com.exam.model;

import java.sql.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "api_key_endpoints")
public class ApiKeyEndpointsModel {

	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id; // NOT NULL DEFAULT uuid_generate_v4()

	// ------- API client identity details --------------

	@Column(name = "client_code")
	private String clientCode; // DEFAULT 'BDA'

	@Column(name = "client_name")
	private String clientName; // DEFAULT 'Bangladesh Army'

	@Column(name = "company_code")
	private String companyCode;

	@Column(name = "company_name")
	private String companyName;

	// ------- Application details --------------

	@Column(name = "app_code")
	private String appCode; // DEFAULT 'GIS'

	@Column(name = "app_name")
	private String appName; // DEFAULT 'Web GIS'

	// ------- API key -----

	@Column(name = "api_key")
	private String apiKey;

	@Column(name = "endpoint")
	private String endpoint;

	@Column(name = "registration_date")
	private Date registrationDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	// -------- User device trace ----------

	@Column(name = "registered_ip")
	private String registeredIp;

	@Column(name = "registered_wsname")
	private String registeredWsname;

	@Column(name = "registered_latitude")
	private double registeredLatitude; // DEFAULT 23.0

	@Column(name = "registered_longitude")
	private double registeredLongitude; // DEFAULT 90.0

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getRegisteredIp() {
		return registeredIp;
	}

	public void setRegisteredIp(String registeredIp) {
		this.registeredIp = registeredIp;
	}

	public String getRegisteredWsname() {
		return registeredWsname;
	}

	public void setRegisteredWsname(String registeredWsname) {
		this.registeredWsname = registeredWsname;
	}

	public double getRegisteredLatitude() {
		return registeredLatitude;
	}

	public void setRegisteredLatitude(double registeredLatitude) {
		this.registeredLatitude = registeredLatitude;
	}

	public double getRegisteredLongitude() {
		return registeredLongitude;
	}

	public void setRegisteredLongitude(double registeredLongitude) {
		this.registeredLongitude = registeredLongitude;
	}

	public ApiKeyEndpointsModel() {
	}

}
