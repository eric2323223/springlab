package org.springside.modules.unit.utils.web;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springside.modules.utils.web.ServletUtils;

public class ServletUtilsTest {

	@Test
	public void checkIfModified() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		//未设Header,返回true,需要传输内容
		assertEquals(true, ServletUtils.checkIfModifiedSince(request, response, (new Date().getTime() - 2000)));

		//设置If-Modified-Since Header
		request.addHeader("If-Modified-Since", new Date().getTime());
		//文件修改时间比Header时间小,文件未修改, 返回false.
		assertEquals(false, ServletUtils.checkIfModifiedSince(request, response, (new Date().getTime() - 2000)));
		//文件修改时间比Header时间大,文件已修改, 返回true,需要传输内容.
		assertEquals(true, ServletUtils.checkIfModifiedSince(request, response, (new Date().getTime() + 2000)));
	}

	@Test
	public void checkIfNoneMatch() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		//未设Header,返回true,需要传输内容
		assertEquals(true, ServletUtils.checkIfNoneMatchEtag(request, response, "V1.0"));

		//设置If-None-Match Header
		request.addHeader("If-None-Match", "V1.0,V1.1");
		//存在Etag
		assertEquals(false, ServletUtils.checkIfNoneMatchEtag(request, response, "V1.0"));
		//不存在Etag
		assertEquals(true, ServletUtils.checkIfNoneMatchEtag(request, response, "V2.0"));
	}

	@Test
	public void getParametersStartingWith() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addParameter("pre_a", "aa");
		request.addParameter("pre_b", "bb");
		request.addParameter("c", "c");
		Map<String, Object> result = ServletUtils.getParametersStartingWith(request, "pre_");
		assertEquals(2, result.size());
		assertTrue(result.keySet().contains("a"));
		assertTrue(result.keySet().contains("b"));
		assertTrue(result.values().contains("aa"));
		assertTrue(result.values().contains("bb"));

		result = ServletUtils.getParametersStartingWith(request, "error_");
		assertEquals(0, result.size());

		result = ServletUtils.getParametersStartingWith(request, null);
		assertEquals(3, result.size());

	}

}
