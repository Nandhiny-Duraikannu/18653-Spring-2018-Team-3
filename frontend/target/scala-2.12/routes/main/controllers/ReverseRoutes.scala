// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 13:42:13 PDT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

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

  // @LINE:22
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:22
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

  
    // @LINE:28
    def searchApiView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchApis")
    }
  
    // @LINE:26
    def submitApi(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "submitapi")
    }
  
    // @LINE:27
    def apiFormView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "createapi")
    }
  
    // @LINE:29
    def searchApis(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search")
    }
  
  }


}
