package arno

class DancePoint {

	User user
	Dance dance
	int point
	
	static mapping = {
		version false
	}
	
	static constraints = {
		user(nullable:true)
	}
}
