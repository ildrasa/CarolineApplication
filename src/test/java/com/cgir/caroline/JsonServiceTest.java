package com.cgir.caroline;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class JsonServiceTest {

	private Caroline _carolineMock;
	private JsonService _jsonService;

	@Before
	public void init() {
		_carolineMock = Mockito.mock(Caroline.class);
		_jsonService = new JsonService(_carolineMock);
	}

	@Test
	public void test000_getBrunehildeText_shouldNotFail() {
		Mockito.when(_carolineMock.getBrunehildeText()).thenReturn("text");

		String brunehildeText = _jsonService.getBrunehildeText();

		Mockito.verify(_carolineMock, Mockito.times(1)).getBrunehildeText();
		Assert.assertEquals("text", brunehildeText);
	}
	
	@Test
	public void test001_getAliceVersion_shouldNotFail() {
		Mockito.when(_carolineMock.getAliceVersion()).thenReturn("version");

		String aliceVersion = _jsonService.getAliceVersionInJSON();

		Mockito.verify(_carolineMock, Mockito.times(1)).getAliceVersion();
		Assert.assertEquals("version", aliceVersion);
	}
}
