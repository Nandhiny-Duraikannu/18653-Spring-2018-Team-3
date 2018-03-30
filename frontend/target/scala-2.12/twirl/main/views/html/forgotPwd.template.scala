
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

object forgotPwd extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*2.2*/main("Did you forget your password | Service Repository")/*2.59*/ {_display_(Seq[Any](format.raw/*2.61*/("""

    """),format.raw/*4.5*/("""<div class="header red darken-3">
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h2>Please fill out the following fields</h2>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col s8 offset-s2" id="loginForm">
                """),_display_(/*17.18*/helper/*17.24*/.form(action = routes.LoginController.forgotPwd)/*17.72*/ {_display_(Seq[Any](format.raw/*17.74*/("""

                """),format.raw/*19.17*/("""<div class="input-field col s12">
                    <input placeholder="Username" id="username" type="text" name="username" required>
                    <label for="username">Username</label>
                </div>

                <div class="input-field col s12">
                    <select id="securityQuestionSelect" name="securityQuestion">
                        <option value="" disabled selected>Please select your security question</option>
                        <option value="born">Where were you born?</option>
                        <option value="car">What was your first car?</option>
                        <option value="college">Where did you go to college?</option>
                    </select>
                    <label>Security question</label>
                </div>

                <div class="input-field col s12">
                    <input placeholder="Answer" id="answer" name="answer" type="text">
                    <label for="answer">Answer</label>
                </div>

                <a href=""""),_display_(/*39.27*/routes/*39.33*/.LoginController.signupView()),format.raw/*39.62*/("""" class="btn-flat left">Create an account</a>
                <a href=""""),_display_(/*40.27*/routes/*40.33*/.LoginController.loginView()),format.raw/*40.61*/("""" class="btn-flat left">Login</a>
                <button id="resetButton" class="btn right" type="submit" name="action">Reset Password
                    <i class="material-icons right">chevron_right</i>
                </button>
                """)))}),format.raw/*44.18*/("""
            """),format.raw/*45.13*/("""</div>
        </div>
    </div>
    <script src=""""),_display_(/*48.19*/routes/*48.25*/.Assets.versioned("javascripts/controllers/forgotPwd.js")),format.raw/*48.82*/("""" type="text/javascript"></script>
""")))}),format.raw/*49.2*/("""
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
                  DATE: Fri Mar 30 04:07:16 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/forgotPwd.scala.html
                  HASH: f57483f86d43ba40c430bc5fd1df83e925a41f7f
                  MATRIX: 1034->2|1099->59|1138->61|1170->67|1595->465|1610->471|1667->519|1707->521|1753->539|2823->1582|2838->1588|2888->1617|2987->1689|3002->1695|3051->1723|3331->1972|3372->1985|3450->2036|3465->2042|3543->2099|3609->2135
                  LINES: 33->2|33->2|33->2|35->4|48->17|48->17|48->17|48->17|50->19|70->39|70->39|70->39|71->40|71->40|71->40|75->44|76->45|79->48|79->48|79->48|80->49
                  -- GENERATED --
              */
          