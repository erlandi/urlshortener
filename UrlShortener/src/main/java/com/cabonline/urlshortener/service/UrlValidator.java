package com.cabonline.urlshortener.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.stereotype.Component;

@Component
public class UrlValidator {
	public boolean validate(String urlToBeValidated) {
		try {
			URL url = new URL(urlToBeValidated);
			URLConnection conn = url.openConnection();
			conn.connect();
		} catch (MalformedURLException e) {
			return false;
		} catch (IOException e) {
			return false;
		}

		return true;
	}
}
