package com.exam.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.exam.payload.CommonViewModel;

public interface ICommonApiService {
	public Map<String, Object> getResponseMap(CommonViewModel commonViewModel, String url);
}

