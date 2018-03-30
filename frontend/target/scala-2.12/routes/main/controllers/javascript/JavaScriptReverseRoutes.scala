// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 14:37:45 PDT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:36
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:36
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

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

  // @LINE:6
  class ReverseLoginController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
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
    def resetPasswordView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LoginController.resetPasswordView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "resetPassword"})
        }
      """
    )
  
    // @LINE:15
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

  // @LINE:40
  class ReverseSubmitApiController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def searchApiView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubmitApiController.searchApiView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchApis"})
        }
      """
    )
  
    // @LINE:40
    def submitApi: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubmitApiController.submitApi",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "submitapi"})
        }
      """
    )
  
    // @LINE:41
    def apiFormView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubmitApiController.apiFormView",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "createapi"})
        }
      """
    )
  
    // @LINE:43
    def searchApis: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SubmitApiController.searchApis",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseMashupController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:25
    def submitMashup: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.submitMashup",
      """
        function() {
        
          if (true) {
            return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mashup"})
          }
        
        }
      """
    )
  
    // @LINE:24
    def submitMashupView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.submitMashupView",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashup/submit"})
          }
        
        }
      """
    )
  
    // @LINE:21
    def mashupListView: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.mashupListView",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashups"})
          }
        
        }
      """
    )
  
    // @LINE:22
    def getAllMashups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.getAllMashups",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashups/all"})
          }
        
        }
      """
    )
  
    // @LINE:23
    def searchMashups: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.MashupController.searchMashups",
      """
        function() {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "mashups/search"})
          }
        
        }
      """
    )
  
  }


}
