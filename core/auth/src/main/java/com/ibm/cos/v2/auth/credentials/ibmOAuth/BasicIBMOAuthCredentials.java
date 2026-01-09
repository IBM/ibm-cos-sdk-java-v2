/*
 * Copyright 2017 IBM Corp. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cos.v2.auth.credentials.ibmOAuth;

/**
 * Basic implementation of the IBMOAuthCredentials interface that allows callers to
 * pass in the IBM api key and service instance id in the constructor.
 */
public class BasicIBMOAuthCredentials implements IBMOAuthCredentials {
	private String apiKey;
	private String serviceInstanceId;

	/**
     * Constructs a new BasicIBMOAuthCredentials object, with the specified IBM
     * api key  service instance id.
     *
     * @param apiKey
     *            The API key.
     * @param serviceInstanceId
     *            The service instance id.
     */
    public BasicIBMOAuthCredentials(String apiKey, String serviceInstanceId) {
		this.apiKey = apiKey;
		this.serviceInstanceId = serviceInstanceId;
    }

	@Override
	public String apiKey() {

		return this.apiKey;
	}

	@Override
	public String serviceInstanceId() {

		return this.serviceInstanceId;
	}

	@Override
	public void setIAMToken(String token) {}

	@Override
	public String getIAMToken() {
		return null;
	}


	@Override
	public String accessKeyId() {
		return null;
	}

	@Override
	public String secretAccessKey() {
		return null;
	}

}
