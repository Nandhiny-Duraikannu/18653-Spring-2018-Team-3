// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 14:37:45 PDT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:36
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:12
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def homeView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "home")
    }
  
  }

  // @LINE:6
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def forgotPwdView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "forgotpassword")
    }
  
    // @LINE:17
    def resetPassword(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "resetPassword")
    }
  
    // @LINE:6
    def loginView(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def resetPasswordView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "resetPassword")
    }
  
    // @LINE:15
    def signup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signup")
    }
  
    // @LINE:7
    def signupView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signup")
    }
  
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

  // @LINE:40
  class ReverseSubmitApiController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def searchApiView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchApis")
    }
  
    // @LINE:40
    def submitApi(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitapi")
    }
  
    // @LINE:41
    def apiFormView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "createapi")
    }
  
    // @LINE:43
    def searchApis(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search")
    }
  
  }

  // @LINE:21
  class ReverseMashupController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def submitMashup(): Call = {
    
      () match {
      
        // @LINE:25
        case ()  =>
          
          Call("POST", _prefix + { _defaultPrefix } + "mashup")
      
      }
    
    }
  
    // @LINE:24
    def submitMashupView(): Call = {
    
      () match {
      
        // @LINE:24
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "mashup/submit")
      
      }
    
    }
  
    // @LINE:21
    def mashupListView(): Call = {
    
      () match {
      
        // @LINE:21
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "mashups")
      
      }
    
    }
  
    // @LINE:22
    def getAllMashups(): Call = {
    
      () match {
      
        // @LINE:22
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "mashups/all")
      
      }
    
    }
  
    // @LINE:23
    def searchMashups(): Call = {
    
      () match {
      
        // @LINE:23
        case ()  =>
          
          Call("GET", _prefix + { _defaultPrefix } + "mashups/search")
      
      }
    
    }
  
  }


}
