
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
object dashboard extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[Project],List[Task],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(projects: List[Project], todoTasks: List[Task], user: User):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.62*/("""

"""),_display_(Seq[Any](/*3.2*/main(projects, user)/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""
    
    <header>
        <hgroup>
            <h1>Dashboard</h1>
            <h2>Tasks over all projects</h2>
        </hgroup>
    </header>
    
    <article  class="tasks">
        """),_display_(Seq[Any](/*13.10*/todoTasks/*13.19*/.groupBy(_.project).map/*13.42*/ {/*14.13*/case (project, tasks) =>/*14.37*/ {_display_(Seq[Any](format.raw/*14.39*/("""
                <div class="folder" data-folder-id=""""),_display_(Seq[Any](/*15.54*/project/*15.61*/.id)),format.raw/*15.64*/("""">
                    <header>
                        <h3><a href="#"""),_display_(Seq[Any](/*17.40*/routes/*17.46*/.Tasks.index(project.id))),format.raw/*17.70*/("""">"""),_display_(Seq[Any](/*17.73*/project/*17.80*/.name)),format.raw/*17.85*/("""</a></h3>
                        <span class="loader">Loading</span>
                    </header>
                    <ul class="list">
                        """),_display_(Seq[Any](/*21.26*/tasks/*21.31*/.map/*21.35*/ { task =>_display_(Seq[Any](format.raw/*21.45*/("""
                            """),_display_(Seq[Any](/*22.30*/views/*22.35*/.html.tasks.item(task, isEditable = false))),format.raw/*22.77*/("""
                        """)))})),format.raw/*23.26*/("""
                    </ul>
                </div>
            """)))}})),format.raw/*27.10*/("""
    </article>
    
""")))})),format.raw/*30.2*/("""

"""))}
    }
    
    def render(projects:List[Project],todoTasks:List[Task],user:User): play.api.templates.Html = apply(projects,todoTasks,user)
    
    def f:((List[Project],List[Task],User) => play.api.templates.Html) = (projects,todoTasks,user) => apply(projects,todoTasks,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 13 01:27:49 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/dashboard.scala.html
                    HASH: 6f09b3d749860f574cf0ced818f319daa33e3c2e
                    MATRIX: 750->1|887->61|924->64|952->84|990->85|1213->272|1231->281|1263->304|1274->319|1307->343|1347->345|1437->399|1453->406|1478->409|1585->480|1600->486|1646->510|1685->513|1701->520|1728->525|1927->688|1941->693|1954->697|2002->707|2068->737|2082->742|2146->784|2204->810|2300->883|2353->905
                    LINES: 26->1|29->1|31->3|31->3|31->3|41->13|41->13|41->13|41->14|41->14|41->14|42->15|42->15|42->15|44->17|44->17|44->17|44->17|44->17|44->17|48->21|48->21|48->21|48->21|49->22|49->22|49->22|50->23|53->27|56->30
                    -- GENERATED --
                */
            