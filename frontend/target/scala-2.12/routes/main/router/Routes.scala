// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 04:17:27 PDT 2018

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
  // @LINE:11
  HomeController_0: controllers.HomeController,
  // @LINE:25
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    LoginController_2: controllers.LoginController,
    // @LINE:11
    HomeController_0: controllers.HomeController,
    // @LINE:25
    Assets_1: controllers.Assets
  ) = this(errorHandler, LoginController_2, HomeController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_2, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.LoginController.loginView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signupView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotpassword""", """controllers.LoginController.forgotPwdView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """resetPassword""", """controllers.LoginController.resetPasswordView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home/""" + "$" + """id<[^/]+>""", """controllers.HomeController.homeView(id:Int)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotpassword""", """controllers.LoginController.forgotPwd()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """resetPassword""", """controllers.LoginController.resetPassword()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.LoginController.logout()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
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
  private[this] lazy val controllers_HomeController_homeView4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_homeView4_invoker = createInvoker(
    HomeController_0.homeView(fakeValue[Int]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "homeView",
      Seq(classOf[Int]),
      "GET",
      this.prefix + """home/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_LoginController_login5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_login5_invoker = createInvoker(
    LoginController_2.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:16
  private[this] lazy val controllers_LoginController_signup6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_LoginController_signup6_invoker = createInvoker(
    LoginController_2.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "signup",
      Nil,
      "POST",
      this.prefix + """signup""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:18
  private[this] lazy val controllers_LoginController_forgotPwd7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotpassword")))
  )
  private[this] lazy val controllers_LoginController_forgotPwd7_invoker = createInvoker(
    LoginController_2.forgotPwd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "forgotPwd",
      Nil,
      "POST",
      this.prefix + """forgotpassword""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:20
  private[this] lazy val controllers_LoginController_resetPassword8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("resetPassword")))
  )
  private[this] lazy val controllers_LoginController_resetPassword8_invoker = createInvoker(
    LoginController_2.resetPassword(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "resetPassword",
      Nil,
      "POST",
      this.prefix + """resetPassword""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:22
  private[this] lazy val controllers_LoginController_logout9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_LoginController_logout9_invoker = createInvoker(
    LoginController_2.logout(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "logout",
      Nil,
      "POST",
      this.prefix + """logout""",
      """""",
      Seq("""nocsrf""")
    )
  )

  // @LINE:25
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
    case controllers_HomeController_homeView4_route(params@_) =>
      call(params.fromPath[Int]("id", None)) { (id) =>
        controllers_HomeController_homeView4_invoker.call(HomeController_0.homeView(id))
      }
  
    // @LINE:14
    case controllers_LoginController_login5_route(params@_) =>
      call { 
        controllers_LoginController_login5_invoker.call(LoginController_2.login())
      }
  
    // @LINE:16
    case controllers_LoginController_signup6_route(params@_) =>
      call { 
        controllers_LoginController_signup6_invoker.call(LoginController_2.signup())
      }
  
    // @LINE:18
    case controllers_LoginController_forgotPwd7_route(params@_) =>
      call { 
        controllers_LoginController_forgotPwd7_invoker.call(LoginController_2.forgotPwd())
      }
  
    // @LINE:20
    case controllers_LoginController_resetPassword8_route(params@_) =>
      call { 
        controllers_LoginController_resetPassword8_invoker.call(LoginController_2.resetPassword())
      }
  
    // @LINE:22
    case controllers_LoginController_logout9_route(params@_) =>
      call { 
        controllers_LoginController_logout9_invoker.call(LoginController_2.logout())
      }
  
    // @LINE:25
    case controllers_Assets_versioned10_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned10_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
