// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/backend/conf/routes
// @DATE:Fri Mar 30 12:19:26 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/backend/conf/routes
// @DATE:Thu Mar 29 17:00:19 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup

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

  
    // @LINE:13
    def searchMashup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.searchMashup",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search/mashup"})
        }
      """
    )
  
    // @LINE:12
    def submitMashup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.submitMashup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mashup"})
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
    def signup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.signup",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseUserController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def getAllUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserController.getAllUsers",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "users"})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def submitApi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.submitApi",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitapi"})
        }
      """
    )
  
    // @LINE:22
    def getApi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.ApiController.getApi",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getapi"})
        }
      """
    )
  
  }


}
