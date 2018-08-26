package com.pactera.spring.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class Paths {

//	@Value("#{systemProperties.myProp}")
	@Resource(name = "includePath")
	public List<String> includePaths;

	public List<String> getIncludePaths() {
		return includePaths;
	}

	public void setIncludePaths(List<String> includePaths) {
		this.includePaths = includePaths;
	}
	
	
}
