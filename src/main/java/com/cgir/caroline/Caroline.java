package com.cgir.caroline;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Caroline {

	private Properties _carolineProperties;

	private RestRequester _restRequester;

	/**
	 * constructor for tests
	 * 
	 * @param carolineProperties
	 * 
	 * @param _restRequesterMock
	 */
	Caroline(RestRequester restRequester, Properties carolineProperties) {
		_restRequester = restRequester;
		_carolineProperties = carolineProperties;
	}

	public Caroline() {
		RestRequester restRequester = new RestRequester();
		FileInputStream in;
		Properties carolineProperties = new Properties();
		try {
			in = new FileInputStream("./src/conf/caroline-conf.properties");
			carolineProperties.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Caroline(restRequester, carolineProperties);
	}

	public String getAliceVersion() {
		String aliceVersion = _restRequester.getRequest(_carolineProperties.getProperty("ALICE_URL") + "/version");
		return aliceVersion;
	}

	public String getBrunehildeText() {
		String brunehildeText = _restRequester.getRequest(_carolineProperties.getProperty("BRUNEHILDE_URL"));
		return brunehildeText;
	}
}
