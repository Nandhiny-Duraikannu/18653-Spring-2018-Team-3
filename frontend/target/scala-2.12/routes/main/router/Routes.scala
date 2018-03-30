// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
// @DATE:Thu Mar 29 23:54:03 PDT 2018

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
  MashupController_1: controllers.MashupController,
  // @LINE:19
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    LoginController_2: controllers.LoginController,
    // @LINE:12
    MashupController_1: controllers.MashupController,
    // @LINE:19
    Assets_0: controllers.Assets
  ) = this(errorHandler, LoginController_2, MashupController_1, Assets_0, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, LoginController_2, MashupController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.LoginController.loginView"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signupView"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.LoginController.signup"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups""", """controllers.MashupController.mashupListView()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups/all""", """controllers.MashupController.getAllMashups()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashups/search""", """controllers.MashupController.searchMashups()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup/submit""", """controllers.MashupController.submitMashupView()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """mashup""", """controllers.MashupController.submitMashup()"""),
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
    LoginController_2.loginView,
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
    LoginController_2.signupView,
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

  // @LINE:9
  private[this] lazy val controllers_LoginController_signup2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_LoginController_signup2_invoker = createInvoker(
    LoginController_2.signup,
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

  // @LINE:12
  private[this] lazy val controllers_MashupController_mashupListView3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups")))
  )
  private[this] lazy val controllers_MashupController_mashupListView3_invoker = createInvoker(
    MashupController_1.mashupListView(),
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

  // @LINE:13
  private[this] lazy val controllers_MashupController_getAllMashups4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups/all")))
  )
  private[this] lazy val controllers_MashupController_getAllMashups4_invoker = createInvoker(
    MashupController_1.getAllMashups(),
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

  // @LINE:14
  private[this] lazy val controllers_MashupController_searchMashups5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashups/search")))
  )
  private[this] lazy val controllers_MashupController_searchMashups5_invoker = createInvoker(
    MashupController_1.searchMashups(),
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

  // @LINE:15
  private[this] lazy val controllers_MashupController_submitMashupView6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup/submit")))
  )
  private[this] lazy val controllers_MashupController_submitMashupView6_invoker = createInvoker(
    MashupController_1.submitMashupView(),
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

  // @LINE:16
  private[this] lazy val controllers_MashupController_submitMashup7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("mashup")))
  )
  private[this] lazy val controllers_MashupController_submitMashup7_invoker = createInvoker(
    MashupController_1.submitMashup(),
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

  // @LINE:19
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ For front end static files""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_LoginController_loginView0_route(params@_) =>
      call { 
        controllers_LoginController_loginView0_invoker.call(LoginController_2.loginView)
      }
  
    // @LINE:7
    case controllers_LoginController_signupView1_route(params@_) =>
      call { 
        controllers_LoginController_signupView1_invoker.call(LoginController_2.signupView)
      }
  
    // @LINE:9
    case controllers_LoginController_signup2_route(params@_) =>
      call { 
        controllers_LoginController_signup2_invoker.call(LoginController_2.signup)
      }
  
    // @LINE:12
    case controllers_MashupController_mashupListView3_route(params@_) =>
      call { 
        controllers_MashupController_mashupListView3_invoker.call(MashupController_1.mashupListView())
      }
  
    // @LINE:13
    case controllers_MashupController_getAllMashups4_route(params@_) =>
      call { 
        controllers_MashupController_getAllMashups4_invoker.call(MashupController_1.getAllMashups())
      }
  
    // @LINE:14
    case controllers_MashupController_searchMashups5_route(params@_) =>
      call { 
        controllers_MashupController_searchMashups5_invoker.call(MashupController_1.searchMashups())
      }
  
    // @LINE:15
    case controllers_MashupController_submitMashupView6_route(params@_) =>
      call { 
        controllers_MashupController_submitMashupView6_invoker.call(MashupController_1.submitMashupView())
      }
  
    // @LINE:16
    case controllers_MashupController_submitMashup7_route(params@_) =>
      call { 
        controllers_MashupController_submitMashup7_invoker.call(MashupController_1.submitMashup())
      }
  
    // @LINE:19
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
