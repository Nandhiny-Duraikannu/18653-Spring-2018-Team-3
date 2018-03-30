// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/backend/conf/routes
// @DATE:Fri Mar 30 12:19:26 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/backend/conf/routes
// @DATE:Thu Mar 29 17:00:19 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:12
  class ReverseMashupController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def searchMashup(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search/mashup")
    }
  
    // @LINE:12
    def submitMashup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "mashup")
    }
  
  }

  // @LINE:6
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def signup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signup")
    }
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:9
  class ReverseUserController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getAllUsers(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "users")
    }
  
  }

  // @LINE:20
  class ReverseApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def submitApi(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitapi")
    }
  
    // @LINE:22
    def getApi(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getapi")
    }
  
  }


}
