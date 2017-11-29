package com.cabonline.urlshortener.service;

import org.springframework.stereotype.Component;

@Component
public class UrlFormatter {
	public String format(String url) {
		StringBuffer sb = new StringBuffer();
		if (!urlContainsProtocol(url)) {
			sb.append("http://");
		}
		sb.append(url);

		return sb.toString();
	}

	private boolean urlContainsProtocol(String url) {
		if (url.startsWith("http://")) {
			return true;
		}

		if (url.startsWith("https://")) {
			return true;
		}

		if (url.startsWith("ftp://")) {
			return true;
		}

		return false;
	}
}
