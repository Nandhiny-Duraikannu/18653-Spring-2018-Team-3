
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

object signup extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main("Create an account | Service Repository")/*1.48*/ {_display_(Seq[Any](format.raw/*1.50*/("""

    """),format.raw/*3.5*/("""<div class="header red darken-3">
        <div class="container">
            <div class="row">
                <div class="col s12">
                    <h2>Let's create your account!</h2>
                    <p>Please fill out the following elements:</p>
                </div>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col s8 offset-s2" id="loginForm">
                """),_display_(/*17.18*/helper/*17.24*/.form(action = routes.LoginController.signup)/*17.69*/ {_display_(Seq[Any](format.raw/*17.71*/("""

                """),format.raw/*19.17*/("""<div class="input-field col s12">
                    <input placeholder="Username" name="username" id="username" type="text">
                    <label for="username">Username</label>
                </div>
                """),format.raw/*23.69*/("""
                    """),format.raw/*24.98*/("""
                """),format.raw/*25.27*/("""

                """),format.raw/*27.17*/("""<div class="input-field col s12">
                    <input placeholder="Password" id="password" type="password" name="password">
                    <label for="password">Password</label>
                </div>
                """),format.raw/*31.53*/("""
                    """),format.raw/*32.110*/("""
                    """),format.raw/*33.71*/("""
                """),format.raw/*34.27*/("""
                """),format.raw/*35.69*/("""
                    """),format.raw/*36.98*/("""
                """),format.raw/*37.27*/("""
                """),format.raw/*38.79*/("""
                    """),format.raw/*39.100*/("""
                """),format.raw/*40.27*/("""
                """),format.raw/*41.66*/("""
                    """),format.raw/*42.100*/("""
                """),format.raw/*43.27*/("""

                """),format.raw/*45.17*/("""<div class="input-field col s12">
                    <select id="securityQuestionSelect" name="securityQuestion">
                        <option value="" disabled selected>Please select a security question</option>
                        <option value="born">Where were you born?</option>
                        <option value="car">What was your first car?</option>
                        <option value="college">Where did you go to college?</option>
                    </select>
                    <label>Security question</label>
                </div>
                """),format.raw/*54.74*/("""
                    """),format.raw/*55.111*/("""
                """),format.raw/*56.27*/("""

                """),format.raw/*58.17*/("""<div class="input-field col s12">
                    <input placeholder="Answer" id="answer" type="text" name="answer">
                    <label for="answer">Answer</label>
                </div>

                """),format.raw/*63.67*/("""
                    """),format.raw/*64.96*/("""
                """),format.raw/*65.27*/("""

                """),format.raw/*67.17*/("""<a href=""""),_display_(/*67.27*/routes/*67.33*/.LoginController.loginView()),format.raw/*67.61*/("""" class="btn-flat left">Already have an account? Login!</a>
                <button id="signupButton" class="btn right" type="submit">Let's go!
                    <i class="material-icons right">chevron_right</i>
                </button>
            </div>
            """)))}),format.raw/*72.14*/("""
        """),format.raw/*73.9*/("""</div>
    </div>

    <script src=""""),_display_(/*76.19*/routes/*76.25*/.Assets.versioned("javascripts/controllers/signup.js")),format.raw/*76.79*/("""" type="text/javascript"></script>
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
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/signup.scala.html
                  HASH: c1fe265791dd37fcfee0018c93529f8c0b572706
                  MATRIX: 1031->1|1085->47|1124->49|1156->55|1638->510|1653->516|1707->561|1747->563|1793->581|2046->858|2095->956|2140->983|2186->1001|2443->1266|2493->1376|2542->1447|2587->1474|2632->1543|2681->1641|2726->1668|2771->1747|2821->1847|2866->1874|2911->1940|2961->2040|3006->2067|3052->2085|3658->2720|3708->2831|3753->2858|3799->2876|4043->3142|4092->3238|4137->3265|4183->3283|4220->3293|4235->3299|4284->3327|4587->3599|4623->3608|4687->3645|4702->3651|4777->3705
                  LINES: 33->1|33->1|33->1|35->3|49->17|49->17|49->17|49->17|51->19|55->23|56->24|57->25|59->27|63->31|64->32|65->33|66->34|67->35|68->36|69->37|70->38|71->39|72->40|73->41|74->42|75->43|77->45|86->54|87->55|88->56|90->58|95->63|96->64|97->65|99->67|99->67|99->67|99->67|104->72|105->73|108->76|108->76|108->76
                  -- GENERATED --
              */
          