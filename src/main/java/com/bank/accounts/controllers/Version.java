package com.bank.accounts.controllers;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties("accounts-app")
@Configuration
public class Version {
	private String version;
	
	public Version() {}
	
	public Version(String version) {
		this.version = version;
	}
	
	public String getVersion() {
		return this.version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}
}
