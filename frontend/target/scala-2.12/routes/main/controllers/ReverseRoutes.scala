// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 13:00:19 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
<<<<<<< HEAD
// @DATE:Thu Mar 29 12:45:14 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
// @DATE:Thu Mar 29 23:54:03 PDT 2018
>>>>>>> Add frontend for submitting and searching Mashups

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

<<<<<<< HEAD
<<<<<<< HEAD
  // @LINE:12
  class ReverseHomeController(_prefix: => String) {
=======
  // @LINE:12
  class ReverseMashupController(_prefix: => String) {
>>>>>>> Add frontend for submitting and searching Mashups
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
<<<<<<< HEAD
    // @LINE:12
    def homeView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "home")
=======
    // @LINE:16
    def submitMashup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "mashup")
    }
  
    // @LINE:15
    def submitMashupView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "mashup/submit")
    }
  
    // @LINE:12
    def mashupListView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "mashups")
    }
  
    // @LINE:13
    def getAllMashups(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "mashups/all")
    }
  
    // @LINE:14
    def searchMashups(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "mashups/search")
>>>>>>> Add frontend for submitting and searching Mashups
    }
  
  }

<<<<<<< HEAD
=======
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
>>>>>>> Add frontend for submitting and searching Mashups
  // @LINE:6
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
<<<<<<< HEAD
    // @LINE:8
    def forgotPwdView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "forgotpassword")
    }
  
    // @LINE:17
    def resetPassword(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "resetPassword")
    }
  
=======
>>>>>>> Add backend functionalities for submitting and searching a Mashup
    // @LINE:6
    def loginView(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:9
<<<<<<< HEAD
    def resetPasswordView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "resetPassword")
    }
  
    // @LINE:15
=======
>>>>>>> Add backend functionalities for submitting and searching a Mashup
    def signup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signup")
    }
  
    // @LINE:7
    def signupView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signup")
    }
  
<<<<<<< HEAD
    // @LINE:11
    def logout(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:16
    def forgotPwd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "forgotpassword")
    }
  
    // @LINE:14
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:22
=======
  }

<<<<<<< HEAD
  // @LINE:12
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
  // @LINE:19
>>>>>>> Add frontend for submitting and searching Mashups
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
<<<<<<< HEAD
<<<<<<< HEAD
    // @LINE:22
=======
    // @LINE:12
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
    // @LINE:19
>>>>>>> Add frontend for submitting and searching Mashups
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:26
  class ReverseSubmitApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def submitApi(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitapi")
    }
  
    // @LINE:27
    def apiFormView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "createapi")
    }
  
  }


}
