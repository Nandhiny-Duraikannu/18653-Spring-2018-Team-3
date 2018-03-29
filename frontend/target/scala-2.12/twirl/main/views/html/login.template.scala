
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


Seq[Any](_display_(/*2.2*/main("Login | Service Repository")/*2.36*/ {_display_(Seq[Any](format.raw/*2.38*/("""

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
            <form class="col s8 offset-s2" id="loginForm">
                <div class="input-field col s12">
                    <input placeholder="Username" id="username" type="text" required>
                    <label for="username">Username</label>
                </div>

                <div class="input-field col s12">
                    <input placeholder="Password" id="password" type="password" required>
                    <label for="password">Password</label>
                </div>
                <a href="/signup" class="btn-flat left">Create an account</a>
                <button class="btn right" type="submit" name="action">Login
                    <i class="material-icons right">chevron_right</i>
                </button>
            </form>
        </div>
    </div>
""")))}),format.raw/*34.2*/("""
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
                  DATE: Thu Mar 29 09:58:26 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/login.scala.html
                  HASH: 0e77bdc447713c35ef8f9715d77d7b819c56907d
                  MATRIX: 1030->2|1072->36|1111->38|1143->44|2362->1233
                  LINES: 33->2|33->2|33->2|35->4|65->34
                  -- GENERATED --
              */
          