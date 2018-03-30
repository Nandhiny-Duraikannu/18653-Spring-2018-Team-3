// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 14:37:45 PDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  LoginController_4: controllers.LoginController,
  // @LINE:12
  HomeController_1: controllers.HomeController,
  // @LINE:21
  MashupController_0: controllers.MashupController,
  // @LINE:36
  Assets_3: controllers.Assets,
  // @LINE:40
  SubmitApiController_2: controllers.SubmitApiController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    LoginController_4: controllers.LoginController,
    // @LINE:12
    HomeController_1: controllers.HomeController,
    // @LINE:21
    MashupController_0: controllers.MashupController,
    // @LINE:36
    Assets_3: controllers.Assets,
    // @LINE:40
    SubmitApiController_2: controllers.SubmitApiController
  ) = this(errorHandler, LoginController_4, HomeController_1, MashupController_0, Assets_3, SubmitApiController_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_4, HomeController_1, MashupController_0, Assets_3, SubmitApiController_2, prefix)
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups""", """controllers.MashupController.mashupListView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups/all""", """controllers.MashupController.getAllMashups()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups/search""", """controllers.MashupController.searchMashups()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup/submit""", """controllers.MashupController.submitMashupView()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup""", """controllers.MashupController.submitMashup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups""", """controllers.MashupController.mashupListView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups/all""", """controllers.MashupController.getAllMashups()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups/search""", """controllers.MashupController.searchMashups()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup/submit""", """controllers.MashupController.submitMashupView()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup""", """controllers.MashupController.submitMashup()"""),
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
    LoginController_4.loginView(),
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
    LoginController_4.signupView(),
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
    LoginController_4.forgotPwdView(),
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
    LoginController_4.resetPasswordView(),
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
    LoginController_4.logout(),
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
    HomeController_1.homeView(),
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
    LoginController_4.login(),
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
    LoginController_4.signup(),
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
    LoginController_4.forgotPwd(),
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
    LoginController_4.resetPassword(),
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

  // @LINE:21
  private[this] lazy val controllers_MashupController_mashupListView10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups")))
  )
  private[this] lazy val controllers_MashupController_mashupListView10_invoker = createInvoker(
    MashupController_0.mashupListView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "mashupListView",
      Nil,
      "GET",
      this.prefix + """mashups""",
      """ Mashup""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_MashupController_getAllMashups11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups/all")))
  )
  private[this] lazy val controllers_MashupController_getAllMashups11_invoker = createInvoker(
    MashupController_0.getAllMashups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "getAllMashups",
      Nil,
      "GET",
      this.prefix + """mashups/all""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_MashupController_searchMashups12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups/search")))
  )
  private[this] lazy val controllers_MashupController_searchMashups12_invoker = createInvoker(
    MashupController_0.searchMashups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "searchMashups",
      Nil,
      "GET",
      this.prefix + """mashups/search""",
      """""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_MashupController_submitMashupView13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup/submit")))
  )
  private[this] lazy val controllers_MashupController_submitMashupView13_invoker = createInvoker(
    MashupController_0.submitMashupView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "submitMashupView",
      Nil,
      "GET",
      this.prefix + """mashup/submit""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_MashupController_submitMashup14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup")))
  )
  private[this] lazy val controllers_MashupController_submitMashup14_invoker = createInvoker(
    MashupController_0.submitMashup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "submitMashup",
      Nil,
      "POST",
      this.prefix + """mashup""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_MashupController_mashupListView15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups")))
  )
  private[this] lazy val controllers_MashupController_mashupListView15_invoker = createInvoker(
    MashupController_0.mashupListView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "mashupListView",
      Nil,
      "GET",
      this.prefix + """mashups""",
      """ Mashup""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_MashupController_getAllMashups16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups/all")))
  )
  private[this] lazy val controllers_MashupController_getAllMashups16_invoker = createInvoker(
    MashupController_0.getAllMashups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "getAllMashups",
      Nil,
      "GET",
      this.prefix + """mashups/all""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_MashupController_searchMashups17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups/search")))
  )
  private[this] lazy val controllers_MashupController_searchMashups17_invoker = createInvoker(
    MashupController_0.searchMashups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "searchMashups",
      Nil,
      "GET",
      this.prefix + """mashups/search""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_MashupController_submitMashupView18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup/submit")))
  )
  private[this] lazy val controllers_MashupController_submitMashupView18_invoker = createInvoker(
    MashupController_0.submitMashupView(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "submitMashupView",
      Nil,
      "GET",
      this.prefix + """mashup/submit""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_MashupController_submitMashup19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup")))
  )
  private[this] lazy val controllers_MashupController_submitMashup19_invoker = createInvoker(
    MashupController_0.submitMashup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "submitMashup",
      Nil,
      "POST",
      this.prefix + """mashup""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_Assets_versioned20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned20_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ For front end static files
 LEAVE --- For front end static files""",
      Seq()
    )
  )

  // @LINE:40
  private[this] lazy val controllers_SubmitApiController_submitApi21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitapi")))
  )
  private[this] lazy val controllers_SubmitApiController_submitApi21_invoker = createInvoker(
    SubmitApiController_2.submitApi(),
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

  // @LINE:41
  private[this] lazy val controllers_SubmitApiController_apiFormView22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createapi")))
  )
  private[this] lazy val controllers_SubmitApiController_apiFormView22_invoker = createInvoker(
    SubmitApiController_2.apiFormView(),
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

  // @LINE:42
  private[this] lazy val controllers_SubmitApiController_searchApiView23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchApis")))
  )
  private[this] lazy val controllers_SubmitApiController_searchApiView23_invoker = createInvoker(
    SubmitApiController_2.searchApiView(),
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

  // @LINE:43
  private[this] lazy val controllers_SubmitApiController_searchApis24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_SubmitApiController_searchApis24_invoker = createInvoker(
    SubmitApiController_2.searchApis(),
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
        controllers_LoginController_loginView0_invoker.call(LoginController_4.loginView())
      }
  
    // @LINE:7
    case controllers_LoginController_signupView1_route(params@_) =>
      call { 
        controllers_LoginController_signupView1_invoker.call(LoginController_4.signupView())
      }
  
    // @LINE:8
    case controllers_LoginController_forgotPwdView2_route(params@_) =>
      call { 
        controllers_LoginController_forgotPwdView2_invoker.call(LoginController_4.forgotPwdView())
      }
  
    // @LINE:9
    case controllers_LoginController_resetPasswordView3_route(params@_) =>
      call { 
        controllers_LoginController_resetPasswordView3_invoker.call(LoginController_4.resetPasswordView())
      }
  
    // @LINE:11
    case controllers_LoginController_logout4_route(params@_) =>
      call { 
        controllers_LoginController_logout4_invoker.call(LoginController_4.logout())
      }
  
    // @LINE:12
    case controllers_HomeController_homeView5_route(params@_) =>
      call { 
        controllers_HomeController_homeView5_invoker.call(HomeController_1.homeView())
      }
  
    // @LINE:14
    case controllers_LoginController_login6_route(params@_) =>
      call { 
        controllers_LoginController_login6_invoker.call(LoginController_4.login())
      }
  
    // @LINE:15
    case controllers_LoginController_signup7_route(params@_) =>
      call { 
        controllers_LoginController_signup7_invoker.call(LoginController_4.signup())
      }
  
    // @LINE:16
    case controllers_LoginController_forgotPwd8_route(params@_) =>
      call { 
        controllers_LoginController_forgotPwd8_invoker.call(LoginController_4.forgotPwd())
      }
  
    // @LINE:17
    case controllers_LoginController_resetPassword9_route(params@_) =>
      call { 
        controllers_LoginController_resetPassword9_invoker.call(LoginController_4.resetPassword())
      }
  
    // @LINE:21
    case controllers_MashupController_mashupListView10_route(params@_) =>
      call { 
        controllers_MashupController_mashupListView10_invoker.call(MashupController_0.mashupListView())
      }
  
    // @LINE:22
    case controllers_MashupController_getAllMashups11_route(params@_) =>
      call { 
        controllers_MashupController_getAllMashups11_invoker.call(MashupController_0.getAllMashups())
      }
  
    // @LINE:23
    case controllers_MashupController_searchMashups12_route(params@_) =>
      call { 
        controllers_MashupController_searchMashups12_invoker.call(MashupController_0.searchMashups())
      }
  
    // @LINE:24
    case controllers_MashupController_submitMashupView13_route(params@_) =>
      call { 
        controllers_MashupController_submitMashupView13_invoker.call(MashupController_0.submitMashupView())
      }
  
    // @LINE:25
    case controllers_MashupController_submitMashup14_route(params@_) =>
      call { 
        controllers_MashupController_submitMashup14_invoker.call(MashupController_0.submitMashup())
      }
  
    // @LINE:28
    case controllers_MashupController_mashupListView15_route(params@_) =>
      call { 
        controllers_MashupController_mashupListView15_invoker.call(MashupController_0.mashupListView())
      }
  
    // @LINE:29
    case controllers_MashupController_getAllMashups16_route(params@_) =>
      call { 
        controllers_MashupController_getAllMashups16_invoker.call(MashupController_0.getAllMashups())
      }
  
    // @LINE:30
    case controllers_MashupController_searchMashups17_route(params@_) =>
      call { 
        controllers_MashupController_searchMashups17_invoker.call(MashupController_0.searchMashups())
      }
  
    // @LINE:31
    case controllers_MashupController_submitMashupView18_route(params@_) =>
      call { 
        controllers_MashupController_submitMashupView18_invoker.call(MashupController_0.submitMashupView())
      }
  
    // @LINE:32
    case controllers_MashupController_submitMashup19_route(params@_) =>
      call { 
        controllers_MashupController_submitMashup19_invoker.call(MashupController_0.submitMashup())
      }
  
    // @LINE:36
    case controllers_Assets_versioned20_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned20_invoker.call(Assets_3.versioned(path, file))
      }
  
    // @LINE:40
    case controllers_SubmitApiController_submitApi21_route(params@_) =>
      call { 
        controllers_SubmitApiController_submitApi21_invoker.call(SubmitApiController_2.submitApi())
      }
  
    // @LINE:41
    case controllers_SubmitApiController_apiFormView22_route(params@_) =>
      call { 
        controllers_SubmitApiController_apiFormView22_invoker.call(SubmitApiController_2.apiFormView())
      }
  
    // @LINE:42
    case controllers_SubmitApiController_searchApiView23_route(params@_) =>
      call { 
        controllers_SubmitApiController_searchApiView23_invoker.call(SubmitApiController_2.searchApiView())
      }
  
    // @LINE:43
    case controllers_SubmitApiController_searchApis24_route(params@_) =>
      call { 
        controllers_SubmitApiController_searchApis24_invoker.call(SubmitApiController_2.searchApis())
      }
  }
}
