
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

object menu extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<nav class="nav-extended">
    <div class="container">
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href=""""),_display_(/*8.31*/routes/*8.37*/.LoginController.logout),format.raw/*8.60*/("""">Logout</a></li>
            </ul>
        </div>
        <div class="nav-content">
            <ul class="tabs tabs-transparent">
                <li class="tab"><a href=""""),_display_(/*13.43*/routes/*13.49*/.SubmitApiController.apiFormView()),format.raw/*13.83*/("""">Add an API</a></li>
                """),format.raw/*14.84*/("""
                """),format.raw/*15.84*/("""
                """),format.raw/*16.69*/("""
            """),format.raw/*17.13*/("""</ul>
        </div>
    </div>
</nav>

"""))
      }
    }
  }

  def render(username:String): play.twirl.api.HtmlFormat.Appendable = apply(username)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (username) => apply(username)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 30 12:54:04 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/menu.scala.html
                  HASH: 6f9be81889605c2a3ce773810affd4109da73d65
                  MATRIX: 947->1|1059->20|1086->21|1351->260|1365->266|1408->289|1609->463|1624->469|1679->503|1745->608|1790->692|1835->761|1876->774
                  LINES: 28->1|33->2|34->3|39->8|39->8|39->8|44->13|44->13|44->13|45->14|46->15|47->16|48->17
                  -- GENERATED --
              */
          