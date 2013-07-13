
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Project],User,Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(projects: List[Project], user: User)(body: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.51*/("""

<html>
    <head>
        <title>Make A Note</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/main.css"))),format.raw/*7.110*/("""">
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*8.46*/routes/*8.52*/.Assets.at("javascripts/jquery-1.7.1.js"))),format.raw/*8.93*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*9.46*/routes/*9.52*/.Assets.at("javascripts/jquery-play-1.7.1.js"))),format.raw/*9.98*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*10.46*/routes/*10.52*/.Assets.at("javascripts/underscore-min.js"))),format.raw/*10.95*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*11.46*/routes/*11.52*/.Assets.at("javascripts/backbone-min.js"))),format.raw/*11.93*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*12.46*/routes/*12.52*/.Assets.at("javascripts/main.js"))),format.raw/*12.85*/(""""></script>
        <script type="text/javascript" src=""""),_display_(Seq[Any](/*13.46*/routes/*13.52*/.Application.javascriptRoutes)),format.raw/*13.81*/(""""></script>
    </head>
    <body>
        <header>
            <a href=""""),_display_(Seq[Any](/*17.23*/routes/*17.29*/.Projects.index)),format.raw/*17.44*/("""" id="logo"><span>Make</span>ANote</a>
            <dl id="user">
                <dt>"""),_display_(Seq[Any](/*19.22*/user/*19.26*/.name)),format.raw/*19.31*/(""" <span>("""),_display_(Seq[Any](/*19.40*/user/*19.44*/.email)),format.raw/*19.50*/(""")</span></dt>
                <dd>
                    <a href=""""),_display_(Seq[Any](/*21.31*/routes/*21.37*/.Application.logout())),format.raw/*21.58*/("""">Logout</a>
                </dd>
            </dl>
        </header>
        <nav>
            <h4 class="dashboard"><a href="#/">Dashboard</a></h4>
            <ul id="projects">
                """),_display_(Seq[Any](/*28.18*/projects/*28.26*/.groupBy(_.folder).map/*28.48*/ {/*29.21*/case (group, projects) =>/*29.46*/ {_display_(Seq[Any](format.raw/*29.48*/("""
                        """),_display_(Seq[Any](/*30.26*/views/*30.31*/.html.projects.group(group, projects))),format.raw/*30.68*/("""
                    """)))}})),format.raw/*32.18*/("""
            </ul>
            <button id="newGroup">New group</button>
        </nav>
        <section id="main">
            """),_display_(Seq[Any](/*37.14*/body)),format.raw/*37.18*/("""
        </section>
    </body>
</html>

"""))}
    }
    
    def render(projects:List[Project],user:User,body:Html): play.api.templates.Html = apply(projects,user)(body)
    
    def f:((List[Project],User) => (Html) => play.api.templates.Html) = (projects,user) => (body) => apply(projects,user)(body)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 13 01:27:50 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/main.scala.html
                    HASH: 15015e6839648ac5f5adfc44e9280062dac62109
                    MATRIX: 739->1|865->50|1013->163|1027->169|1080->201|1187->273|1201->279|1257->313|1340->361|1354->367|1416->408|1508->465|1522->471|1589->517|1682->574|1697->580|1762->623|1855->680|1870->686|1933->727|2026->784|2041->790|2096->823|2189->880|2204->886|2255->915|2365->989|2380->995|2417->1010|2540->1097|2553->1101|2580->1106|2625->1115|2638->1119|2666->1125|2767->1190|2782->1196|2825->1217|3060->1416|3077->1424|3108->1446|3119->1469|3153->1494|3193->1496|3255->1522|3269->1527|3328->1564|3383->1604|3547->1732|3573->1736
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|39->11|39->11|39->11|40->12|40->12|40->12|41->13|41->13|41->13|45->17|45->17|45->17|47->19|47->19|47->19|47->19|47->19|47->19|49->21|49->21|49->21|56->28|56->28|56->28|56->29|56->29|56->29|57->30|57->30|57->30|58->32|63->37|63->37
                    -- GENERATED --
                */
            