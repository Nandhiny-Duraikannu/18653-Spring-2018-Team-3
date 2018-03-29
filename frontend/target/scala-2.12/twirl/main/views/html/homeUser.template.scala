
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

object homeUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Int,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(username: String, userId: Int):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.33*/(""" """),format.raw/*2.34*/("""{"""),format.raw/*2.35*/("""
    """),_display_(/*3.6*/main("Welcome| Service Repository")/*3.41*/{_display_(Seq[Any](format.raw/*3.42*/("""

        """),format.raw/*5.9*/("""<h2>Welcome """),_display_(/*5.22*/username),format.raw/*5.30*/("""</h2>
        <p>username: """),_display_(/*6.23*/username),format.raw/*6.31*/("""</p>
        <p>id: """),_display_(/*7.17*/userId),format.raw/*7.23*/("""</p>
    """)))}),format.raw/*8.6*/("""
"""),format.raw/*9.1*/("""}"""),format.raw/*9.2*/("""

"""))
      }
    }
  }

  def render(username:String,userId:Int): play.twirl.api.HtmlFormat.Appendable = apply(username,userId)

  def f:((String,Int) => play.twirl.api.HtmlFormat.Appendable) = (username,userId) => apply(username,userId)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Mar 29 11:28:35 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/homeUser.scala.html
                  HASH: 5493503c8287f324d9a6722d886b9a3523f4fac6
                  MATRIX: 955->2|1081->33|1109->34|1137->35|1168->41|1211->76|1249->77|1285->87|1324->100|1352->108|1406->136|1434->144|1481->165|1507->171|1546->181|1573->182|1600->183
                  LINES: 28->2|33->2|33->2|33->2|34->3|34->3|34->3|36->5|36->5|36->5|37->6|37->6|38->7|38->7|39->8|40->9|40->9
                  -- GENERATED --
              */
          