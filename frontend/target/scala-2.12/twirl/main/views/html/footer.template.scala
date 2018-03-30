
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

object footer extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<footer class="page-footer">
    <div class="footer-copyright red accent-4">
        <div class="container">
            <p>
                Carnegie Mellon University - Software Architecture & Design, Spring 2018
                <br>
                Team 3 - Nandhini Duraikannu, Jerome Kimbrough, Siva Rama Krishna Kuntamukkala, Haonan Zhou
            </p>
        </div>
    </div>
</footer>"""))
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
                  SOURCE: /Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/app/views/footer.scala.html
                  HASH: 1eb1ffa60ea96b31ac0fbb6080d3e36f368ef102
                  MATRIX: 1031->0
                  LINES: 33->1
                  -- GENERATED --
              */
          