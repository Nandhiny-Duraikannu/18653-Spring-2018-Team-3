// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
// @DATE:Thu Mar 29 23:54:03 PDT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:12
  class ReverseMashupController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def submitMashup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.submitMashup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mashup"})
        }
      """
    )
  
    // @LINE:15
    def submitMashupView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.submitMashupView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashup/submit"})
        }
      """
    )
  
    // @LINE:12
    def mashupListView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.mashupListView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashups"})
        }
      """
    )
  
    // @LINE:13
    def getAllMashups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.getAllMashups",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashups/all"})
        }
      """
    )
  
    // @LINE:14
    def searchMashups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.searchMashups",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashups/search"})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseLoginController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def loginView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.loginView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:9
    def signup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.signup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
    // @LINE:7
    def signupView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.signupView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
