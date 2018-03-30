
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

object resetPassword extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("Reset password | Service Repository")/*2.45*/ {_display_(Seq[Any](format.raw/*2.47*/("""

    """),format.raw/*4.5*/("""<div class="header red darken-3">
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
            <div class="col s8 offset-s2" id="loginForm">
            """),_display_(/*18.14*/helper/*18.20*/.form(action = routes.LoginController.resetPassword())/*18.74*/ {_display_(Seq[Any](format.raw/*18.76*/("""

                """),format.raw/*20.17*/("""<div class="input-field col s12">
                    <input placeholder="Password" id="password" type="password" name="password">
                    <label for="password">Password</label>
                </div>

                <button id="signupButton" class="btn right" type="submit">Reset my password...
                    <i class="material-icons right">chevron_right</i>
                </button>
            </div>
            """)))}),format.raw/*29.14*/("""
        """),format.raw/*30.9*/("""</div>
    </div>
    """),format.raw/*32.120*/("""
""")))}),format.raw/*33.2*/("""
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 30 04:16:27 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/resetPassword.scala.html
                  HASH: 5ae9a5194cff34f9609fa0dc628228bbac853d85
                  MATRIX: 1038->2|1089->45|1128->47|1160->53|1650->516|1665->522|1728->576|1768->578|1814->596|2282->1033|2318->1042|2369->1179|2401->1181
                  LINES: 33->2|33->2|33->2|35->4|49->18|49->18|49->18|49->18|51->20|60->29|61->30|63->32|64->33
                  -- GENERATED --
              */
          