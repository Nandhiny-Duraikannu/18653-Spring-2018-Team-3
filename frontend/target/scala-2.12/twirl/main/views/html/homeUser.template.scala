
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

object homeUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Int,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(userId: Int, username: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),_display_(/*4.2*/main("Welcome| Service Repository")/*4.37*/{_display_(Seq[Any](format.raw/*4.38*/("""

    """),_display_(/*6.6*/menu(username)),format.raw/*6.20*/("""

    """),format.raw/*8.5*/("""<div class="container">
        <div class="row">
            <div class="col s12">
                <h2>Welcome """),_display_(/*11.30*/username),format.raw/*11.38*/("""</h2>
                <p>username: """),_display_(/*12.31*/username),format.raw/*12.39*/("""</p>
                <p>id: """),_display_(/*13.25*/userId),format.raw/*13.31*/("""</p>

            </div>
        </div>
    </div>

""")))}),format.raw/*19.2*/("""


"""))
      }
    }
  }

  def render(userId:Int,username:String): play.twirl.api.HtmlFormat.Appendable = apply(userId,username)

  def f:((Int,String) => play.twirl.api.HtmlFormat.Appendable) = (userId,username) => apply(userId,username)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Fri Mar 30 03:46:47 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/homeUser.scala.html
                  HASH: 5b1eaedd832bc08a7752bbd2e72f3d22872827be
                  MATRIX: 955->2|1080->34|1107->36|1150->71|1188->72|1220->79|1254->93|1286->99|1426->212|1455->220|1518->256|1547->264|1603->293|1630->299|1713->352
                  LINES: 28->2|33->3|34->4|34->4|34->4|36->6|36->6|38->8|41->11|41->11|42->12|42->12|43->13|43->13|49->19
                  -- GENERATED --
              */
          