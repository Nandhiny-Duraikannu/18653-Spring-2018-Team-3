// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/backend/conf/routes
// @DATE:Fri Mar 30 14:40:59 PDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  LoginController_3: controllers.LoginController,
  // @LINE:13
  UserController_1: controllers.UserController,
  // @LINE:16
  MashupController_0: controllers.MashupController,
  // @LINE:22
  Assets_2: controllers.Assets,
  // @LINE:26
  ApiController_4: controllers.ApiController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    LoginController_3: controllers.LoginController,
    // @LINE:13
    UserController_1: controllers.UserController,
    // @LINE:16
    MashupController_0: controllers.MashupController,
    // @LINE:22
    Assets_2: controllers.Assets,
    // @LINE:26
    ApiController_4: controllers.ApiController
  ) = this(errorHandler, LoginController_3, UserController_1, MashupController_0, Assets_2, ApiController_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_3, UserController_1, MashupController_0, Assets_2, ApiController_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotpassword""", """controllers.LoginController.forgotPwd()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getAllUsers()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups""", """controllers.MashupController.getAllMashups()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup""", """controllers.MashupController.submitMashup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search/mashup""", """controllers.MashupController.searchMashup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitapi""", """controllers.ApiController.submitApi()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getapi""", """controllers.ApiController.getApi()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchAPI""", """controllers.ApiController.searchApi()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_LoginController_login0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_LoginController_login0_invoker = createInvoker(
    LoginController_3.login(),
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

  // @LINE:9
  private[this] lazy val controllers_LoginController_signup1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_LoginController_signup1_invoker = createInvoker(
    LoginController_3.signup(),
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

  // @LINE:11
  private[this] lazy val controllers_LoginController_forgotPwd2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("forgotpassword")))
  )
  private[this] lazy val controllers_LoginController_forgotPwd2_invoker = createInvoker(
    LoginController_3.forgotPwd(),
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

  // @LINE:13
  private[this] lazy val controllers_UserController_getAllUsers3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_getAllUsers3_invoker = createInvoker(
    UserController_1.getAllUsers(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserController",
      "getAllUsers",
      Nil,
      "GET",
      this.prefix + """users""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_MashupController_getAllMashups4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups")))
  )
  private[this] lazy val controllers_MashupController_getAllMashups4_invoker = createInvoker(
    MashupController_0.getAllMashups(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "getAllMashups",
      Nil,
      "GET",
      this.prefix + """mashups""",
      """ Mashup""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_MashupController_submitMashup5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup")))
  )
  private[this] lazy val controllers_MashupController_submitMashup5_invoker = createInvoker(
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

  // @LINE:18
  private[this] lazy val controllers_MashupController_searchMashup6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search/mashup")))
  )
  private[this] lazy val controllers_MashupController_searchMashup6_invoker = createInvoker(
    MashupController_0.searchMashup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.MashupController",
      "searchMashup",
      Nil,
      "GET",
      this.prefix + """search/mashup""",
      """""",
      Seq()
    )
  )

  // @LINE:22
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_ApiController_submitApi8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitapi")))
  )
  private[this] lazy val controllers_ApiController_submitApi8_invoker = createInvoker(
    ApiController_4.submitApi(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "submitApi",
      Nil,
      "POST",
      this.prefix + """submitapi""",
      """Submit API""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_ApiController_getApi9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getapi")))
  )
  private[this] lazy val controllers_ApiController_getApi9_invoker = createInvoker(
    ApiController_4.getApi(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "getApi",
      Nil,
      "GET",
      this.prefix + """getapi""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_ApiController_searchApi10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchAPI")))
  )
  private[this] lazy val controllers_ApiController_searchApi10_invoker = createInvoker(
    ApiController_4.searchApi(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApiController",
      "searchApi",
      Nil,
      "GET",
      this.prefix + """searchAPI""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_LoginController_login0_route(params@_) =>
      call { 
        controllers_LoginController_login0_invoker.call(LoginController_3.login())
      }
  
    // @LINE:9
    case controllers_LoginController_signup1_route(params@_) =>
      call { 
        controllers_LoginController_signup1_invoker.call(LoginController_3.signup())
      }
  
    // @LINE:11
    case controllers_LoginController_forgotPwd2_route(params@_) =>
      call { 
        controllers_LoginController_forgotPwd2_invoker.call(LoginController_3.forgotPwd())
      }
  
    // @LINE:13
    case controllers_UserController_getAllUsers3_route(params@_) =>
      call { 
        controllers_UserController_getAllUsers3_invoker.call(UserController_1.getAllUsers())
      }
  
    // @LINE:16
    case controllers_MashupController_getAllMashups4_route(params@_) =>
      call { 
        controllers_MashupController_getAllMashups4_invoker.call(MashupController_0.getAllMashups())
      }
  
    // @LINE:17
    case controllers_MashupController_submitMashup5_route(params@_) =>
      call { 
        controllers_MashupController_submitMashup5_invoker.call(MashupController_0.submitMashup())
      }
  
    // @LINE:18
    case controllers_MashupController_searchMashup6_route(params@_) =>
      call { 
        controllers_MashupController_searchMashup6_invoker.call(MashupController_0.searchMashup())
      }
  
    // @LINE:22
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:26
    case controllers_ApiController_submitApi8_route(params@_) =>
      call { 
        controllers_ApiController_submitApi8_invoker.call(ApiController_4.submitApi())
      }
  
    // @LINE:28
    case controllers_ApiController_getApi9_route(params@_) =>
      call { 
        controllers_ApiController_getApi9_invoker.call(ApiController_4.getApi())
      }
  
    // @LINE:29
    case controllers_ApiController_searchApi10_route(params@_) =>
      call { 
        controllers_ApiController_searchApi10_invoker.call(ApiController_4.searchApi())
      }
  }
}
