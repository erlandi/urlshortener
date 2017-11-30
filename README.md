# urlshortener
REST api for making short urls and using them
```
IDE: Eclipse
Requirements: Spring

To build:
Run As -> Maven Install

To run:
Run As -> Java Application


Usage in a browser:

To convert a long url to a short url

   -> http://localhost:8081/api/[long url]/
   
The short url is shown in browser


To use the short url 

   -> http://localhost:8081/[short url]
   
The browser is redirected to the long url
