package com.cgir.caroline;

public class Caroline {

	String ALICE_URL = "http://127.0.0.1:5001/alice/rest/alice";
	String BRUNEHILDE_URL = "http://127.0.0.1:5002/";

	private RestRequester _restRequester;

	public Caroline() {
		_restRequester = new RestRequester();
	}

	/**
	 * constructor for tests
	 * 
	 * @param _restRequesterMock
	 */
	Caroline(RestRequester restRequester) {
		_restRequester = restRequester;
	}

	public String getAliceVersion() {
		String aliceVersion = _restRequester.getRequest(ALICE_URL + "/version");
		return aliceVersion;
	}

	public String getBrunehildeText() {
		String brunehildeText = _restRequester.getRequest(BRUNEHILDE_URL);
		return brunehildeText;
	}
}
