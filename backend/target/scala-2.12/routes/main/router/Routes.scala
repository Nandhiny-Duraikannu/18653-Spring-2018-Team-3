// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/backend/conf/routes
// @DATE:Fri Mar 30 12:19:26 PDT 2018

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
  Assets_2: controllers.Assets,
  // @LINE:20
  ApiController_0: controllers.ApiController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    LoginController_3: controllers.LoginController,
    // @LINE:13
    UserController_1: controllers.UserController,
    // @LINE:16
    Assets_2: controllers.Assets,
    // @LINE:20
    ApiController_0: controllers.ApiController
  ) = this(errorHandler, LoginController_3, UserController_1, Assets_2, ApiController_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_3, UserController_1, Assets_2, ApiController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.LoginController.login()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signup()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """forgotpassword""", """controllers.LoginController.forgotPwd()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getAllUsers()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitapi""", """controllers.ApiController.submitApi()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getapi""", """controllers.ApiController.getApi()"""),
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
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
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

  // @LINE:20
  private[this] lazy val controllers_ApiController_submitApi5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("submitapi")))
  )
  private[this] lazy val controllers_ApiController_submitApi5_invoker = createInvoker(
    ApiController_0.submitApi(),
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

  // @LINE:22
  private[this] lazy val controllers_ApiController_getApi6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getapi")))
  )
  private[this] lazy val controllers_ApiController_getApi6_invoker = createInvoker(
    ApiController_0.getApi(),
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
    case controllers_Assets_versioned4_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned4_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:20
    case controllers_ApiController_submitApi5_route(params@_) =>
      call { 
        controllers_ApiController_submitApi5_invoker.call(ApiController_0.submitApi())
      }
  
    // @LINE:22
    case controllers_ApiController_getApi6_route(params@_) =>
      call { 
        controllers_ApiController_getApi6_invoker.call(ApiController_0.getApi())
      }
  }
}
