
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object login extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Login | Service Repository")/*1.36*/ {_display_(Seq[Any](format.raw/*1.38*/("""

    """),format.raw/*3.5*/("""<div class="header red darken-3">
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h2>Welcome to this Service Repository</h2>
                    <p>To access our services, please login below.</p>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col s8 offset-s2">
            """),_display_(/*17.14*/helper/*17.20*/.form(action = routes.LoginController.login)/*17.64*/ {_display_(Seq[Any](format.raw/*17.66*/("""
                """),format.raw/*18.17*/("""<div class="input-field col s12">
                    <input placeholder="Username" type="text" name="username">
                    <label for="username">Username</label>
                </div>
                """),format.raw/*22.69*/("""
                    """),format.raw/*23.98*/("""
                """),format.raw/*24.27*/("""


                """),format.raw/*27.17*/("""<div class="input-field col s12">
                    <input placeholder="Password" id="password" type="password" name="password">
                    <label for="password">Password</label>
                </div>

                """),format.raw/*32.68*/("""
                    """),format.raw/*33.98*/("""
                """),format.raw/*34.27*/("""

                """),format.raw/*36.17*/("""<a href=""""),_display_(/*36.27*/routes/*36.33*/.LoginController.signup),format.raw/*36.56*/("""" class="btn-flat left">Create an account</a>
                <a href=""""),_display_(/*37.27*/routes/*37.33*/.LoginController.forgotPwdView),format.raw/*37.63*/("""" class="btn-flat left">Forgot Password</a>
                <button id="loginButton" class="btn right" type="submit">Login
                    <i class="material-icons right">chevron_right</i>
                </button>

            """)))}),format.raw/*42.14*/("""
            """),format.raw/*43.13*/("""</div>
        </div>
    </div>
""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 30 03:46:47 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/login.scala.html
                  HASH: eb4eea27451c3609693aa5b9dbb92dcf62e49ad9
                  MATRIX: 1030->1|1072->35|1111->37|1143->43|1618->491|1633->497|1686->541|1726->543|1771->560|2010->823|2059->921|2104->948|2151->967|2409->1248|2458->1346|2503->1373|2549->1391|2586->1401|2601->1407|2645->1430|2744->1502|2759->1508|2810->1538|3074->1771|3115->1784
                  LINES: 33->1|33->1|33->1|35->3|49->17|49->17|49->17|49->17|50->18|54->22|55->23|56->24|59->27|64->32|65->33|66->34|68->36|68->36|68->36|68->36|69->37|69->37|69->37|74->42|75->43
                  -- GENERATED --
              */
          