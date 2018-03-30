// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
// @DATE:Thu Mar 29 23:54:03 PDT 2018

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
    }
  
  }

  // @LINE:6
  class ReverseLoginController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def loginView(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:9
    def signup(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "signup")
    }
  
    // @LINE:7
    def signupView(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "signup")
    }
  
  }

  // @LINE:19
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
