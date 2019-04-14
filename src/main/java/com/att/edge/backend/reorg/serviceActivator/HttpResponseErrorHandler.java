/**
 * 
 */
package com.att.edge.backend.reorg.serviceActivator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.att.edge.appcommon.FileLogger;
import com.att.edge.appcommon.GlobalContext;

/**
 * @author pradyumna.k.khadanga
 *
 */
@Component("httpResponseErrorHandler")
public class HttpResponseErrorHandler extends DefaultResponseErrorHandler {
		
	/**
	 * Delegates to {@link #hasError(HttpStatus)} with the response status code.
	 */
	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return hasError(getHttpStatusCode(response));
	}

	private HttpStatus getHttpStatusCode(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode;
		try {
			statusCode = response.getStatusCode();
		}
		catch (IllegalArgumentException ex) {
			throw new UnknownHttpStatusCodeException(response.getRawStatusCode(),
					response.getStatusText(), response.getHeaders(), getResponseBody(response), getCharset(response));
		}
		return statusCode;
	}

	
	protected boolean hasError(HttpStatus statusCode) {
		return (statusCode.series() == HttpStatus.Series.CLIENT_ERROR ||
				statusCode.series() == HttpStatus.Series.SERVER_ERROR);
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus statusCode = getHttpStatusCode(response);
		switch (statusCode.series()) {
			case CLIENT_ERROR:
				throw new HttpClientErrorException(statusCode, response.getStatusText(),
						response.getHeaders(), getResponseBody(response), getCharset(response));
			case SERVER_ERROR:
				throw new HttpServerErrorException(statusCode, response.getStatusText(),
						response.getHeaders(), getResponseBody(response), getCharset(response));
			default:
				throw new RestClientException("Unknown status code [" + statusCode + "]");
		}
	}

	private byte[] getResponseBody(ClientHttpResponse response) {
		try {
			InputStream responseBody = response.getBody();
			if (responseBody != null) {
				return FileCopyUtils.copyToByteArray(responseBody);
			}
		}
		catch (IOException ex) {
			// ignore
		}
		return new byte[0];
	}

	private Charset getCharset(ClientHttpResponse response) {
		HttpHeaders headers = response.getHeaders();
		MediaType contentType = headers.getContentType();
		return contentType != null ? contentType.getCharset() : null;
	}
	    
}
