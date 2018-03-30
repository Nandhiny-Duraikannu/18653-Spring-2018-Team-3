// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/backend/conf/routes
// @DATE:Fri Mar 30 12:19:26 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/backend/conf/routes
<<<<<<< HEAD
// @DATE:Thu Mar 29 17:00:19 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
// @DATE:Thu Mar 29 22:39:31 PDT 2018
>>>>>>> Add frontend for submitting and searching Mashups

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
<<<<<<< HEAD
  // @LINE:7
  LoginController_3: controllers.LoginController,
  // @LINE:13
  UserController_1: controllers.UserController,
=======
  // @LINE:6
  LoginController_3: controllers.LoginController,
  // @LINE:9
  UserController_0: controllers.UserController,
  // @LINE:12
  MashupController_2: controllers.MashupController,
<<<<<<< HEAD
>>>>>>> Add backend functionalities for submitting and searching a Mashup
  // @LINE:16
  Assets_2: controllers.Assets,
  // @LINE:20
  ApiController_0: controllers.ApiController,
=======
  // @LINE:18
  Assets_1: controllers.Assets,
>>>>>>> Add frontend for submitting and searching Mashups
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
<<<<<<< HEAD
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
=======
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
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """submitapi""", """controllers.ApiController.submitApi()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getapi""", """controllers.ApiController.getApi()"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_LoginController_signup0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
<<<<<<< HEAD
  private[this] lazy val controllers_LoginController_login0_invoker = createInvoker(
    LoginController_3.login(),
=======
  private[this] lazy val controllers_LoginController_signup0_invoker = createInvoker(
    LoginController_3.signup(),
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
<<<<<<< HEAD
  private[this] lazy val controllers_LoginController_signup1_invoker = createInvoker(
    LoginController_3.signup(),
=======
  private[this] lazy val controllers_UserController_getAllUsers1_invoker = createInvoker(
    UserController_0.getAllUsers(),
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
<<<<<<< HEAD
<<<<<<< HEAD
  private[this] lazy val controllers_LoginController_forgotPwd2_invoker = createInvoker(
    LoginController_3.forgotPwd(),
=======
  private[this] lazy val controllers_MashupController_submitMashup2_invoker = createInvoker(
=======
  private[this] lazy val controllers_MashupController_submitMashup3_invoker = createInvoker(
>>>>>>> Add frontend for submitting and searching Mashups
    MashupController_2.submitMashup(),
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
<<<<<<< HEAD
<<<<<<< HEAD
  private[this] lazy val controllers_UserController_getAllUsers3_invoker = createInvoker(
    UserController_1.getAllUsers(),
=======
  private[this] lazy val controllers_MashupController_searchMashup3_invoker = createInvoker(
=======
  private[this] lazy val controllers_MashupController_searchMashup4_invoker = createInvoker(
>>>>>>> Add frontend for submitting and searching Mashups
    MashupController_2.searchMashup(),
>>>>>>> Add backend functionalities for submitting and searching a Mashup
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
<<<<<<< HEAD
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
=======
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
>>>>>>> Add frontend for submitting and searching Mashups
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
  
    // @LINE:6
    case controllers_LoginController_signup0_route(params@_) =>
      call { 
<<<<<<< HEAD
        controllers_LoginController_login0_invoker.call(LoginController_3.login())
=======
        controllers_LoginController_signup0_invoker.call(LoginController_3.signup())
>>>>>>> Add backend functionalities for submitting and searching a Mashup
      }
  
    // @LINE:9
    case controllers_UserController_getAllUsers1_route(params@_) =>
      call { 
<<<<<<< HEAD
        controllers_LoginController_signup1_invoker.call(LoginController_3.signup())
=======
        controllers_UserController_getAllUsers1_invoker.call(UserController_0.getAllUsers())
>>>>>>> Add backend functionalities for submitting and searching a Mashup
      }
  
    // @LINE:12
    case controllers_MashupController_getAllMashups2_route(params@_) =>
      call { 
<<<<<<< HEAD
<<<<<<< HEAD
        controllers_LoginController_forgotPwd2_invoker.call(LoginController_3.forgotPwd())
=======
        controllers_MashupController_submitMashup2_invoker.call(MashupController_2.submitMashup())
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
        controllers_MashupController_getAllMashups2_invoker.call(MashupController_2.getAllMashups())
>>>>>>> Add frontend for submitting and searching Mashups
      }
  
    // @LINE:13
    case controllers_MashupController_submitMashup3_route(params@_) =>
      call { 
        controllers_MashupController_submitMashup3_invoker.call(MashupController_2.submitMashup())
      }
  
    // @LINE:14
    case controllers_MashupController_searchMashup4_route(params@_) =>
      call { 
<<<<<<< HEAD
<<<<<<< HEAD
        controllers_UserController_getAllUsers3_invoker.call(UserController_1.getAllUsers())
=======
        controllers_MashupController_searchMashup3_invoker.call(MashupController_2.searchMashup())
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
        controllers_MashupController_searchMashup4_invoker.call(MashupController_2.searchMashup())
>>>>>>> Add frontend for submitting and searching Mashups
      }
  
    // @LINE:18
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
<<<<<<< HEAD
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
=======
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
>>>>>>> Add frontend for submitting and searching Mashups
      }
  }
}
