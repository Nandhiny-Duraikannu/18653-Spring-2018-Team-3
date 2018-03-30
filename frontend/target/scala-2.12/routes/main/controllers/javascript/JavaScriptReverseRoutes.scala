// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 13:00:19 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
// @DATE:Thu Mar 29 12:45:14 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

<<<<<<< HEAD
  // @LINE:12
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def homeView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.homeView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
        }
      """
    )
  
  }

=======
>>>>>>> Add backend functionalities for submitting and searching a Mashup
  // @LINE:6
  class ReverseLoginController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
<<<<<<< HEAD
    // @LINE:8
    def forgotPwdView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.forgotPwdView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotpassword"})
        }
      """
    )
  
    // @LINE:17
    def resetPassword: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.resetPassword",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "resetPassword"})
        }
      """
    )
  
=======
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
<<<<<<< HEAD
    def resetPasswordView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.resetPasswordView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "resetPassword"})
        }
      """
    )
  
    // @LINE:15
=======
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
  
<<<<<<< HEAD
    // @LINE:11
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:16
    def forgotPwd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.forgotPwd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "forgotpassword"})
        }
      """
    )
  
    // @LINE:14
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:22
=======
  }

  // @LINE:12
>>>>>>> Add backend functionalities for submitting and searching a Mashup
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
<<<<<<< HEAD
    // @LINE:22
=======
    // @LINE:12
>>>>>>> Add backend functionalities for submitting and searching a Mashup
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:26
  class ReverseSubmitApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:26
    def submitApi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubmitApiController.submitApi",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitapi"})
        }
      """
    )
  
    // @LINE:27
    def apiFormView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubmitApiController.apiFormView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createapi"})
        }
      """
    )
  
  }


}
