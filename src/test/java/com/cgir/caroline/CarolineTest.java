package com.cgir.caroline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import com.cgir.caroline.Caroline;

public class CarolineTest {

	private RestRequester _restRequesterMock;
	private Caroline _caroline;

	@Before
	public void init() {
		_restRequesterMock = Mockito.mock(RestRequester.class);
		_caroline = new Caroline(_restRequesterMock);
	}

	@Test
	public void test000_getAliceVersion_shouldNotFail() {
		Mockito.when(_restRequesterMock.getRequest(Matchers.anyString())).thenReturn("1.0");

		String aliceVersion = _caroline.getAliceVersion();

		Mockito.verify(_restRequesterMock, Mockito.times(1)).getRequest(Matchers.endsWith("/version"));
		Assert.assertEquals("1.0", aliceVersion);
	}

	@Test
	public void test001_getBrunehildeText_shouldNotFail() {
		Mockito.when(_restRequesterMock.getRequest(Matchers.anyString())).thenReturn("text");

		String brunehildeText = _caroline.getBrunehildeText();

		Mockito.verify(_restRequesterMock, Mockito.times(1)).getRequest(Matchers.anyString());
		Assert.assertEquals("text", brunehildeText);
	}

}
