package com.cabonline.urlshortener.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UrlRepository {
	private static final Map<String, String> urls = new HashMap<String, String>();

	public void saveUrl(String shortUrl, String longUrl) {
		// TODO: replace with jdbc.update(...);
		urls.put(shortUrl, longUrl);
	}

	public String getLongUrl(String shortUrl) {
		// TODO: replace with jdbc.query(...);
		String longUrl = urls.get(shortUrl);
		if (longUrl == null) {
			throw new IllegalArgumentException(String.format(
					"Short url %s does not exist", shortUrl));
		}

		return longUrl;
	}
}
