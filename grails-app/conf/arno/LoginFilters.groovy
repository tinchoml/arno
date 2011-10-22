package arno

class LoginFilters {

    def filters = {
		
        all(controller:'*', action:'*') {
            before = {
              if (session.usu==null && !actionName.equals('index') && !actionName.equals('homeNotLogin') && !actionName.equals('login')){
                  redirect(controller: 'home', action:'home')
              }
            }
        }
		
    }
    
}
