// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 13:42:13 PDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  LoginController_2: controllers.LoginController,
  // @LINE:12
  HomeController_0: controllers.HomeController,
  // @LINE:22
  Assets_1: controllers.Assets,
  // @LINE:26
  SubmitApiController_3: controllers.SubmitApiController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    LoginController_2: controllers.LoginController,
    // @LINE:12
    HomeController_0: controllers.HomeController,
    // @LINE:22
    Assets_1: controllers.Assets,
    // @LINE:26
    SubmitApiController_3: controllers.SubmitApiController
  ) = this(errorHandler, LoginController_2, HomeController_0, Assets_1, SubmitApiController_3, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_2, HomeController_0, Assets_1, SubmitApiController_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.LoginController.loginView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signupView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotpassword""", """controllers.LoginController.forgotPwdView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """resetPassword""", """controllers.LoginController.resetPasswordView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.LoginController.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.HomeController.homeView()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotpassword""", """controllers.LoginController.forgotPwd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """resetPassword""", """controllers.LoginController.resetPassword()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitapi""", """controllers.SubmitApiController.submitApi()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createapi""", """controllers.SubmitApiController.apiFormView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchApis""", """controllers.SubmitApiController.searchApiView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.SubmitApiController.searchApis()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_LoginController_loginView0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_LoginController_loginView0_invoker = createInvoker(
    LoginController_2.loginView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "loginView",
      Nil,
      "GET",
      this.prefix + """""",
      """ Signup, login, password reset, ...""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_LoginController_signupView1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_LoginController_signupView1_invoker = createInvoker(
    LoginController_2.signupView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "signupView",
      Nil,
      "GET",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LoginController_forgotPwdView2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotpassword")))
  )
  private[this] lazy val controllers_LoginController_forgotPwdView2_invoker = createInvoker(
    LoginController_2.forgotPwdView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "forgotPwdView",
      Nil,
      "GET",
      this.prefix + """forgotpassword""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_LoginController_resetPasswordView3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("resetPassword")))
  )
  private[this] lazy val controllers_LoginController_resetPasswordView3_invoker = createInvoker(
    LoginController_2.resetPasswordView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "resetPasswordView",
      Nil,
      "GET",
      this.prefix + """resetPassword""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_LoginController_logout4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_LoginController_logout4_invoker = createInvoker(
    LoginController_2.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_homeView5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_HomeController_homeView5_invoker = createInvoker(
    HomeController_0.homeView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "homeView",
      Nil,
      "GET",
      this.prefix + """home""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_LoginController_login6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_login6_invoker = createInvoker(
    LoginController_2.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_LoginController_signup7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_LoginController_signup7_invoker = createInvoker(
    LoginController_2.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "signup",
      Nil,
      "POST",
      this.prefix + """signup""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_LoginController_forgotPwd8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotpassword")))
  )
  private[this] lazy val controllers_LoginController_forgotPwd8_invoker = createInvoker(
    LoginController_2.forgotPwd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "forgotPwd",
      Nil,
      "POST",
      this.prefix + """forgotpassword""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_LoginController_resetPassword9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("resetPassword")))
  )
  private[this] lazy val controllers_LoginController_resetPassword9_invoker = createInvoker(
    LoginController_2.resetPassword(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "resetPassword",
      Nil,
      "POST",
      this.prefix + """resetPassword""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Assets_versioned10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned10_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ LEAVE --- For front end static files""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_SubmitApiController_submitApi11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitapi")))
  )
  private[this] lazy val controllers_SubmitApiController_submitApi11_invoker = createInvoker(
    SubmitApiController_3.submitApi(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubmitApiController",
      "submitApi",
      Nil,
      "POST",
      this.prefix + """submitapi""",
      """api""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_SubmitApiController_apiFormView12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createapi")))
  )
  private[this] lazy val controllers_SubmitApiController_apiFormView12_invoker = createInvoker(
    SubmitApiController_3.apiFormView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubmitApiController",
      "apiFormView",
      Nil,
      "GET",
      this.prefix + """createapi""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_SubmitApiController_searchApiView13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchApis")))
  )
  private[this] lazy val controllers_SubmitApiController_searchApiView13_invoker = createInvoker(
    SubmitApiController_3.searchApiView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubmitApiController",
      "searchApiView",
      Nil,
      "GET",
      this.prefix + """searchApis""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_SubmitApiController_searchApis14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_SubmitApiController_searchApis14_invoker = createInvoker(
    SubmitApiController_3.searchApis(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SubmitApiController",
      "searchApis",
      Nil,
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_LoginController_loginView0_route(params@_) =>
      call { 
        controllers_LoginController_loginView0_invoker.call(LoginController_2.loginView())
      }
  
    // @LINE:7
    case controllers_LoginController_signupView1_route(params@_) =>
      call { 
        controllers_LoginController_signupView1_invoker.call(LoginController_2.signupView())
      }
  
    // @LINE:8
    case controllers_LoginController_forgotPwdView2_route(params@_) =>
      call { 
        controllers_LoginController_forgotPwdView2_invoker.call(LoginController_2.forgotPwdView())
      }
  
    // @LINE:9
    case controllers_LoginController_resetPasswordView3_route(params@_) =>
      call { 
        controllers_LoginController_resetPasswordView3_invoker.call(LoginController_2.resetPasswordView())
      }
  
    // @LINE:11
    case controllers_LoginController_logout4_route(params@_) =>
      call { 
        controllers_LoginController_logout4_invoker.call(LoginController_2.logout())
      }
  
    // @LINE:12
    case controllers_HomeController_homeView5_route(params@_) =>
      call { 
        controllers_HomeController_homeView5_invoker.call(HomeController_0.homeView())
      }
  
    // @LINE:14
    case controllers_LoginController_login6_route(params@_) =>
      call { 
        controllers_LoginController_login6_invoker.call(LoginController_2.login())
      }
  
    // @LINE:15
    case controllers_LoginController_signup7_route(params@_) =>
      call { 
        controllers_LoginController_signup7_invoker.call(LoginController_2.signup())
      }
  
    // @LINE:16
    case controllers_LoginController_forgotPwd8_route(params@_) =>
      call { 
        controllers_LoginController_forgotPwd8_invoker.call(LoginController_2.forgotPwd())
      }
  
    // @LINE:17
    case controllers_LoginController_resetPassword9_route(params@_) =>
      call { 
        controllers_LoginController_resetPassword9_invoker.call(LoginController_2.resetPassword())
      }
  
    // @LINE:22
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:26
    case controllers_SubmitApiController_submitApi11_route(params@_) =>
      call { 
        controllers_SubmitApiController_submitApi11_invoker.call(SubmitApiController_3.submitApi())
      }
  
    // @LINE:27
    case controllers_SubmitApiController_apiFormView12_route(params@_) =>
      call { 
        controllers_SubmitApiController_apiFormView12_invoker.call(SubmitApiController_3.apiFormView())
      }
  
    // @LINE:28
    case controllers_SubmitApiController_searchApiView13_route(params@_) =>
      call { 
        controllers_SubmitApiController_searchApiView13_invoker.call(SubmitApiController_3.searchApiView())
      }
  
    // @LINE:29
    case controllers_SubmitApiController_searchApis14_route(params@_) =>
      call { 
        controllers_SubmitApiController_searchApis14_invoker.call(SubmitApiController_3.searchApis())
      }
  }
}
