
package views.html.tasks

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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Project,List[Task],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(project: Project, tasks: List[Task]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.39*/("""

<header>
    <hgroup>
        <h1>"""),_display_(Seq[Any](/*5.14*/project/*5.21*/.folder)),format.raw/*5.28*/("""</h1>
        <h2>"""),_display_(Seq[Any](/*6.14*/project/*6.21*/.name)),format.raw/*6.26*/("""</h2>
    </hgroup>
    <dl class="users">
        <dt>Project's team</dt>
        <dd>
            <div class="wrap">
                <h3>Team mates</h3>
                <div class="list">
                    """),_display_(Seq[Any](/*14.22*/project/*14.29*/.members.map/*14.41*/ { user =>_display_(Seq[Any](format.raw/*14.51*/("""
                        <dl data-user-id=""""),_display_(Seq[Any](/*15.44*/user/*15.48*/.email)),format.raw/*15.54*/("""">
                            <dt>"""),_display_(Seq[Any](/*16.34*/user/*16.38*/.name)),format.raw/*16.43*/(""" <span>("""),_display_(Seq[Any](/*16.52*/user/*16.56*/.email)),format.raw/*16.62*/(""")</span></dt>
                            <dd class="action">Action</dd>
                        </dl>
                    """)))})),format.raw/*19.22*/("""
                </div>
                <h3>Add a team mate</h3>
                <div class="addUserList">
                    """),_display_(Seq[Any](/*23.22*/User/*23.26*/.findAll.diff(project.members).map/*23.60*/ { user =>_display_(Seq[Any](format.raw/*23.70*/("""
                        <dl data-user-id=""""),_display_(Seq[Any](/*24.44*/user/*24.48*/.email)),format.raw/*24.54*/("""">
                            <dt>"""),_display_(Seq[Any](/*25.34*/user/*25.38*/.name)),format.raw/*25.43*/(""" <span>("""),_display_(Seq[Any](/*25.52*/user/*25.56*/.email)),format.raw/*25.62*/(""")</span></dt>
                            <dd class="action">Action</dd>
                        </dl>
                    """)))})),format.raw/*28.22*/("""
                </div>
            </div>
        </dd>
    </dl>
</header>
<article  class="tasks" id="tasks">
    """),_display_(Seq[Any](/*35.6*/tasks/*35.11*/.groupBy(_.folder).map/*35.33*/ {/*36.9*/case (folder, tasks) =>/*36.32*/ {_display_(Seq[Any](format.raw/*36.34*/("""
            """),_display_(Seq[Any](/*37.14*/views/*37.19*/.html.tasks.folder(folder, tasks))),format.raw/*37.52*/("""
        """)))}})),format.raw/*39.6*/("""
    <a href="#newFolder" class="new newFolder">New folder</a>
</article>

"""))}
    }
    
    def render(project:Project,tasks:List[Task]): play.api.templates.Html = apply(project,tasks)
    
    def f:((Project,List[Task]) => play.api.templates.Html) = (project,tasks) => apply(project,tasks)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 13 01:27:50 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/tasks/index.scala.html
                    HASH: ca5808423196986435a6a73d1b2cd9998b7c7393
                    MATRIX: 741->1|855->38|927->75|942->82|970->89|1024->108|1039->115|1065->120|1312->331|1328->338|1349->350|1397->360|1477->404|1490->408|1518->414|1590->450|1603->454|1630->459|1675->468|1688->472|1716->478|1872->602|2036->730|2049->734|2092->768|2140->778|2220->822|2233->826|2261->832|2333->868|2346->872|2373->877|2418->886|2431->890|2459->896|2615->1020|2768->1138|2782->1143|2813->1165|2823->1176|2855->1199|2895->1201|2945->1215|2959->1220|3014->1253|3056->1269
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|42->14|42->14|42->14|42->14|43->15|43->15|43->15|44->16|44->16|44->16|44->16|44->16|44->16|47->19|51->23|51->23|51->23|51->23|52->24|52->24|52->24|53->25|53->25|53->25|53->25|53->25|53->25|56->28|63->35|63->35|63->35|63->36|63->36|63->36|64->37|64->37|64->37|65->39
                    -- GENERATED --
                */
            