package arno

class HomeController {

	def facebookService

	def index = {
	
		//Lo manda a la página principal o a la página de logueo
		if (session.user){
			chain(action:'home')
		} else {
			chain(action:'homeNotLogin')
		}
			
	}
	
	def homeNotLogin = {
		
	}
				
    def login = {
			
		def facebookUser
		
		//Si está en producción obtiene el user de facebook
		if (Environment.getCurrentEnvironment()==Environment.PRODUCTION){
			String accessToken =  facebookService.getAccessToken(params.code)
			facebookUser = facebookService.getUser(accessToken)
		} else {
			facebookUser = new User()
			facebookUser.name='Fer'
			facebookUser.email = 'fer@hotmail.com'
			facebookUser.facebookId = 'Fersca'
		}

		createUser(facebookUser)

		def html = '''
		<html>
		<head>
		</head>
		<body>
		<script type="text/javascript">
		self.close(); window.opener.location.href = 'home';
		</script>
		</body>
		</html>
		'''
				
		render html
			
	 }
	
	def createUser(def json){
								
		def iduser
		
		if (Environment.getCurrentEnvironment()==Environment.PRODUCTION){
			iduser = json.id
		} else { 
			iduser = json.facebookId
		}
		
		User usu = User.findByFacebookId(iduser)
		
		if (!usu){
			usu = new User()
			usu.email = json.email.toLowerCase()
			usu.name= json.name			
			usu.facebookId = iduser
			usu.save(flush:true)
		}

		session.user=usu

	}

	def getUser(){
		def user
		if (Environment.getCurrentEnvironment()==Environment.PRODUCTION){
			user = session.user
		} else {
			user = User.getAt(1)
		}
		return user
	}		
	
	def home = {

		def user = getUser()
		
		def dancers = Dancer.getAll().sort{it.name}
		
		def dancePartners = DancePartners.getAll()
		
		def model = [user:user, dancers:dancers, dancePartners:dancePartners]
			
		render (view:"home", model:model)
		
	}
	
	
	def vote = {
		
		User user = getUser()
		
		Long danceId = new Long(params.dance)
		DancePoint dancePoint = new DancePoint()
		dancePoint.user = session.user
		dancePoint.dance = Dance.findById(danceId)
		dancePoint.point = new Long(params.point)
		
		dancePoint.save(flush:true)
		
		render "Recibimos tu voto!"
	}
	
	
	def play = {
		
		def user = getUser()
		
		Long danceId = new Long(params.dance)
		DanceVote danceVote = new DanceVote()
		danceVote.user = session.user
		danceVote.dance = Dance.findById(danceId)
		
		danceVote.save(flush:true)
					
		render "Recibimos tu voto!"
	}

	
}
