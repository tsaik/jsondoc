package org.jsondoc.core.pojo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jsondoc.core.annotation.Api;

public class ApiDoc implements Comparable<ApiDoc> {
	public String jsondocId = UUID.randomUUID().toString();
	private String name;
	private String description;
	private List<ApiMethodDoc> methods;
	private ApiVersionDoc supportedversions;
	private ApiAuthDoc auth;
	private String group;

	public static ApiDoc buildFromAnnotation(Api api) {
		ApiDoc apiDoc = new ApiDoc();
		apiDoc.setDescription(api.description());
		apiDoc.setName(api.name());
		apiDoc.setGroup(api.group());
		return apiDoc;
	}

	public ApiDoc() {
		this.methods = new ArrayList<ApiMethodDoc>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ApiMethodDoc> getMethods() {
		return methods;
	}

	public void setMethods(List<ApiMethodDoc> methods) {
		this.methods = methods;
	}

	public void addMethod(ApiMethodDoc apiMethod) {
		this.methods.add(apiMethod);
	}

	@Override
	public int compareTo(ApiDoc o) {
		return name.compareTo(o.getName());
	}

	public ApiVersionDoc getSupportedversions() {
		return supportedversions;
	}

	public void setSupportedversions(ApiVersionDoc supportedversions) {
		this.supportedversions = supportedversions;
	}

	public ApiAuthDoc getAuth() {
		return auth;
	}

	public void setAuth(ApiAuthDoc auth) {
		this.auth = auth;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

}
