
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
            <form class="col s8 offset-s2" id="loginForm">

                <div class="input-field col s12">
                    <input placeholder="Username" id="username" type="text">
                    <label for="username">Username</label>
                </div>
                <div class="col s12" id="usernameRequiredBadge">
                    <span class="new badge" data-badge-caption="USERNAME IS REQUIRED"></span>
                </div>

                <div class="input-field col s6">
                    <input placeholder="Password" id="password" type="password">
                    <label for="password">Password</label>
                </div>
                <div class="input-field col s6">
                    <input placeholder="Repeat Password" id="password2" type="password">
                    <label for="password2">Repeat Password</label>
                </div>
                <div class="col s6" id="password1RequiredBadge">
                    <span class="new badge" data-badge-caption="PASSWORD IS REQUIRED"></span>
                </div>
                <div class="col s6 offset-s6" id="password2RequiredBadge">
                    <span class="new badge" data-badge-caption="PLEASE REPEAT PASSWORD"></span>
                </div>
                <div class="col s12" id="passwordErrorBadge">
                    <span class="new badge" data-badge-caption="PASSWORDS DO NOT MATCH"></span>
                </div>

                <div class="input-field col s12">
                    <select id="securityQuestionSelect">
                        <option value="" disabled selected>Please select a security question</option>
                        <option value="born">Where were you born?</option>
                        <option value="car">What was your first car?</option>
                        <option value="college">Where did you go to college?</option>
                    </select>
                    <label>Security question</label>
                </div>
                <div class="col s12" id="securityQuestionErrorBadge">
                    <span class="new badge" data-badge-caption="PLEASE SELECT A SECURITY QUESTION"></span>
                </div>

                <div class="input-field col s12">
                    <input placeholder="Answer" id="answer" type="text">
                    <label for="answer">Answer</label>
                </div>

                <div class="col s12" id="answerRequiredBadge">
                    <span class="new badge" data-badge-caption="ANSWER IS REQUIRED"></span>
                </div>

                <button id="signupButton" class="btn right" type="submit">Let's go!
                    <i class="material-icons right">chevron_right</i>
                </button>
            </form>
        </div>
    </div>

    <script src=""""),_display_(/*73.19*/routes/*73.25*/.Assets.versioned("javascripts/controllers/signup.js")),format.raw/*73.79*/("""" type="text/javascript"></script>
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
                  DATE: Thu Mar 29 12:45:15 PDT 2018
                  SOURCE: /Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/app/views/signup.scala.html
                  HASH: ee5e80787a77716438f4c5a12fca9d21fe400493
                  MATRIX: 1031->1|1085->47|1124->49|1156->55|4394->3266|4409->3272|4484->3326
                  LINES: 33->1|33->1|33->1|35->3|105->73|105->73|105->73
                  -- GENERATED --
              */
          