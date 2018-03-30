// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/backend/conf/routes
// @DATE:Thu Mar 29 22:39:31 PDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  LoginController_3: controllers.LoginController,
  // @LINE:9
  UserController_0: controllers.UserController,
  // @LINE:12
  MashupController_2: controllers.MashupController,
  // @LINE:18
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    LoginController_3: controllers.LoginController,
    // @LINE:9
    UserController_0: controllers.UserController,
    // @LINE:12
    MashupController_2: controllers.MashupController,
    // @LINE:18
    Assets_1: controllers.Assets
  ) = this(errorHandler, LoginController_3, UserController_0, MashupController_2, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_3, UserController_0, MashupController_2, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """users""", """controllers.UserController.getAllUsers()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups""", """controllers.MashupController.getAllMashups()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup""", """controllers.MashupController.submitMashup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search/mashup""", """controllers.MashupController.searchMashup()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_LoginController_signup0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_LoginController_signup0_invoker = createInvoker(
    LoginController_3.signup(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LoginController",
      "signup",
      Nil,
      "POST",
      this.prefix + """signup""",
      """ Signup, login, reset password, ...""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UserController_getAllUsers1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("users")))
  )
  private[this] lazy val controllers_UserController_getAllUsers1_invoker = createInvoker(
    UserController_0.getAllUsers(),
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

  // @LINE:12
  private[this] lazy val controllers_MashupController_getAllMashups2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups")))
  )
  private[this] lazy val controllers_MashupController_getAllMashups2_invoker = createInvoker(
    MashupController_2.getAllMashups(),
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

  // @LINE:13
  private[this] lazy val controllers_MashupController_submitMashup3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup")))
  )
  private[this] lazy val controllers_MashupController_submitMashup3_invoker = createInvoker(
    MashupController_2.submitMashup(),
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

  // @LINE:14
  private[this] lazy val controllers_MashupController_searchMashup4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search/mashup")))
  )
  private[this] lazy val controllers_MashupController_searchMashup4_invoker = createInvoker(
    MashupController_2.searchMashup(),
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

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
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


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_LoginController_signup0_route(params@_) =>
      call { 
        controllers_LoginController_signup0_invoker.call(LoginController_3.signup())
      }
  
    // @LINE:9
    case controllers_UserController_getAllUsers1_route(params@_) =>
      call { 
        controllers_UserController_getAllUsers1_invoker.call(UserController_0.getAllUsers())
      }
  
    // @LINE:12
    case controllers_MashupController_getAllMashups2_route(params@_) =>
      call { 
        controllers_MashupController_getAllMashups2_invoker.call(MashupController_2.getAllMashups())
      }
  
    // @LINE:13
    case controllers_MashupController_submitMashup3_route(params@_) =>
      call { 
        controllers_MashupController_submitMashup3_invoker.call(MashupController_2.submitMashup())
      }
  
    // @LINE:14
    case controllers_MashupController_searchMashup4_route(params@_) =>
      call { 
        controllers_MashupController_searchMashup4_invoker.call(MashupController_2.searchMashup())
      }
  
    // @LINE:18
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
