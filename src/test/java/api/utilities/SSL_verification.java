package api.utilities;

import io.restassured.RestAssured;

public class SSL_verification {
	public void SSL() {
		System.setProperty("javax.net.ssl.trustStore", "E:/keytool/custom-truststore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");

		RestAssured.useRelaxedHTTPSValidation(); // Disables SSL verification, if necessary.
	}
}
