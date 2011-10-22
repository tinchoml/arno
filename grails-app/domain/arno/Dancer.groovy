package arno

class Dancer {

	String name
	String surname
	String country
	String picture
	
	static constraints = {
		picture(nullable: true)
	}
	
	static mapping = {
		version false
	}
}
