
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * two arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page.
 */
  def apply/*7.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*8.1*/("""
"""),format.raw/*9.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        """),format.raw/*12.62*/("""
        """),format.raw/*13.9*/("""<title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>
        <meta http-equiv="content-security-policy" content="default-src 'self'; style-src 'self' 'unsafe-inline';" />
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(/*15.70*/routes/*15.76*/.Assets.versioned("stylesheets/materialize" +
                ".css")),format.raw/*16.24*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*17.54*/routes/*17.60*/.Assets.versioned("stylesheets/main.css")),format.raw/*17.101*/("""">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*18.54*/routes/*18.60*/.Assets.versioned("stylesheets/materialize-icons.css")),format.raw/*18.114*/("""">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*19.59*/routes/*19.65*/.Assets.versioned("images/favicon.png")),format.raw/*19.104*/("""">
        <script src=""""),_display_(/*20.23*/routes/*20.29*/.Assets.versioned("javascripts/jquery-3.3.1.js")),format.raw/*20.77*/("""" type="text/javascript"></script>
        <script src=""""),_display_(/*21.23*/routes/*21.29*/.Assets.versioned("javascripts/materialize.js")),format.raw/*21.76*/("""" type="text/javascript"></script>

    </head>
    <body>
        """),format.raw/*26.32*/("""
        """),_display_(/*27.10*/content),format.raw/*27.17*/("""

        """),_display_(/*29.10*/footer()),format.raw/*29.18*/("""

        """),format.raw/*31.9*/("""<script src=""""),_display_(/*31.23*/routes/*31.29*/.Assets.versioned("javascripts/main.js")),format.raw/*31.69*/("""" type="text/javascript"></script>
    </body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Thu Mar 29 09:58:26 PDT 2018
                  SOURCE: /Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/app/views/main.scala.html
                  HASH: bbaaaccf01bcd17407680c7076b6752728b1fd85
                  MATRIX: 1206->260|1330->291|1357->292|1437->397|1473->406|1508->414|1534->419|1757->615|1772->621|1862->690|1945->746|1960->752|2023->793|2106->849|2121->855|2197->909|2285->970|2300->976|2361->1015|2413->1040|2428->1046|2497->1094|2581->1151|2596->1157|2664->1204|2759->1361|2796->1371|2824->1378|2862->1389|2891->1397|2928->1407|2969->1421|2984->1427|3045->1467
                  LINES: 33->7|38->8|39->9|42->12|43->13|43->13|43->13|45->15|45->15|46->16|47->17|47->17|47->17|48->18|48->18|48->18|49->19|49->19|49->19|50->20|50->20|50->20|51->21|51->21|51->21|55->26|56->27|56->27|58->29|58->29|60->31|60->31|60->31|60->31
                  -- GENERATED --
              */
          