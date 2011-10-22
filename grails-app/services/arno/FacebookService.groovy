package arno

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import grails.converters.*

class FacebookService {

    static transactional = false

    def getAccessToken(code) {
		
		String oauth = 'http://www.facebook.com/dialog/oauth/'
		String oauthAccessToken = 'https://graph.facebook.com/oauth/access_token'
		String redirectUri = 'http%3A%2F%2Fec2-50-17-146-95.compute-1.amazonaws.com%2Fjurado%2Fhome%2Flogin'
		String clientId = '296010870409590'
		String clientSecret = '8b811b2c0d83ee1a3c1847a51e6ffc26'
				
		String url = oauthAccessToken+"?client_id="+clientId+"&redirect_uri="+redirectUri+"&client_secret="+clientSecret+"&code="+code
		
		String body =  new URL(url).text
		
		def valores = body.split("&") 
		
		def accessTokenPart = valores[0].split("=") 
		
		return accessTokenPart[1]
		
    }
	
	def getUser(accessToken) {
		
		def body =  new URL("https://graph.facebook.com/me?access_token="+accessToken).text
		
		return JSON.parse(body)
		
	}
}
