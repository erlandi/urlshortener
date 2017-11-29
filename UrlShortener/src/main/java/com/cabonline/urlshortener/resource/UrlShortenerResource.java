package com.cabonline.urlshortener.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.cabonline.urlshortener.service.UrlShortenerService;

@RestController
public class UrlShortenerResource {

	private final UrlShortenerService urlShortenerService;

	@Autowired
	public UrlShortenerResource(UrlShortenerService urlShortenerService) {
		this.urlShortenerService = urlShortenerService;
	}

	@RequestMapping(value = "/error/{message}")
	public void error(HttpServletResponse response, @PathVariable String message) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		try {
			response.getWriter().println(message);
		} catch (IOException e) {
			// Intentionally left blank...
		}
	}

	@RequestMapping(value = "/api/{longUrl}/")
	public void shortenUrl(HttpServletResponse response,
			@PathVariable String longUrl) {
		String shortUrl = urlShortenerService.shortenUrl(longUrl);
		respondWithShorterUrl(response, shortUrl);
	}

	@RequestMapping(value = "/{shortUrl}")
	public RedirectView redirect(@PathVariable String shortUrl) {
		String longUrl = urlShortenerService.getLongUrl(shortUrl);
		return getRedirect(longUrl);
	}

	private void respondWithShorterUrl(HttpServletResponse response,
			String shortUrl) {
		try {
			response.getWriter().println(shortUrl);
		} catch (IOException e) {
			// Intentionally left blank...
		}
	}

	private RedirectView getRedirect(String longUrl) {
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(longUrl);
		return redirectView;
	}
}