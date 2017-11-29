package com.cabonline.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabonline.urlshortener.repository.UrlRepository;

@Service
public class UrlShortenerService {
	private final UrlFormatter urlFormatter;
	private final UrlValidator urlValidator;
	private final UrlRepository urlRepository;

	@Autowired
	public UrlShortenerService(UrlFormatter urlFormatter,
			UrlValidator urlValidator, UrlRepository urlRepository) {
		this.urlFormatter = urlFormatter;
		this.urlValidator = urlValidator;
		this.urlRepository = urlRepository;
	}

	public String shortenUrl(String longUrl) {
		String formatedLongUrl = urlFormatter.format(longUrl);

		if (!urlValidator.validate(formatedLongUrl)) {
			throw new IllegalArgumentException(String.format("Bad url %s",
					formatedLongUrl));
		}

		String shortUrl = generateShortenedUrl(formatedLongUrl);
		urlRepository.saveUrl(shortUrl, formatedLongUrl);

		return shortUrl;
	}

	public String getLongUrl(String shortUrl) {
		String longUrl;
		try {
			longUrl = urlRepository.getLongUrl(shortUrl);
		} catch (IllegalArgumentException e) {
			longUrl = "/error/short url not found/";
		}
		return longUrl;
	}

	private String generateShortenedUrl(String longUrl) {
		// TODO: replace with proper short name generation
		return String.valueOf(longUrl.hashCode());
	}
}
