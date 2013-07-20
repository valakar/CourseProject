
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
object index extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Project,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(project: Project):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""
<header>

    <hgroup>
        <h1>"""),_display_(Seq[Any](/*5.14*/project/*5.21*/.folder)),format.raw/*5.28*/("""</h1>
        <h2>"""),_display_(Seq[Any](/*6.14*/project/*6.21*/.name)),format.raw/*6.26*/("""</h2>
    </hgroup>
	
	<dl class="users">	
		<!-- New note -->
        <dt>Project's team</dt>
        <dd>
            <div class="wrap">
                <h3>Team mates</h3>
                <div class="list">
                    """),_display_(Seq[Any](/*16.22*/project/*16.29*/.members.map/*16.41*/ { user =>_display_(Seq[Any](format.raw/*16.51*/("""
                        <dl data-user-id=""""),_display_(Seq[Any](/*17.44*/user/*17.48*/.email)),format.raw/*17.54*/("""">
                            <dt>"""),_display_(Seq[Any](/*18.34*/user/*18.38*/.name)),format.raw/*18.43*/(""" <span>("""),_display_(Seq[Any](/*18.52*/user/*18.56*/.email)),format.raw/*18.62*/(""")</span></dt>
                            <dd class="action">Action</dd>
                        </dl>
                    """)))})),format.raw/*21.22*/("""
                </div>
                <h3>Add a team mate</h3>
                <div class="addUserList">
                    """),_display_(Seq[Any](/*25.22*/User/*25.26*/.findAll.diff(project.members).map/*25.60*/ { user =>_display_(Seq[Any](format.raw/*25.70*/("""
                        <dl data-user-id=""""),_display_(Seq[Any](/*26.44*/user/*26.48*/.email)),format.raw/*26.54*/("""">
                            <dt>"""),_display_(Seq[Any](/*27.34*/user/*27.38*/.name)),format.raw/*27.43*/(""" <span>("""),_display_(Seq[Any](/*27.52*/user/*27.56*/.email)),format.raw/*27.62*/(""")</span></dt>
                            <dd class="action">Action</dd>
                        </dl>
                    """)))})),format.raw/*30.22*/("""
                </div>
            </div>
        </dd>
		
	</dl>
</header>
<article  class="tasks" id="tasks">
	<!--
	<dl class="users"><a href="#newFolder" class="new newFolder" style="line-height:19px;">New note</a></dl>
    -->
	<dl class="users"><a href=""""),_display_(Seq[Any](/*41.30*/routes/*41.36*/.Notes.add(project.id))),format.raw/*41.58*/("""" class="new newFolder" style="line-height:19px;">New note</a></dl>
    
</article>

"""))}
    }
    
    def render(project:Project): play.api.templates.Html = apply(project)
    
    def f:((Project) => play.api.templates.Html) = (project) => apply(project)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 20 20:19:51 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/tasks/index.scala.html
                    HASH: 2975d95e057e631957acbdfda0452610640eef49
                    MATRIX: 730->1|825->19|897->56|912->63|940->70|994->89|1009->96|1035->101|1302->332|1318->339|1339->351|1387->361|1467->405|1480->409|1508->415|1580->451|1593->455|1620->460|1665->469|1678->473|1706->479|1862->603|2026->731|2039->735|2082->769|2130->779|2210->823|2223->827|2251->833|2323->869|2336->873|2363->878|2408->887|2421->891|2449->897|2605->1021|2903->1283|2918->1289|2962->1311
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6|44->16|44->16|44->16|44->16|45->17|45->17|45->17|46->18|46->18|46->18|46->18|46->18|46->18|49->21|53->25|53->25|53->25|53->25|54->26|54->26|54->26|55->27|55->27|55->27|55->27|55->27|55->27|58->30|69->41|69->41|69->41
                    -- GENERATED --
                */
            