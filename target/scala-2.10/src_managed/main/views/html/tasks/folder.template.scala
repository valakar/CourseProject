
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
object folder extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Task],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(folder: String, tasks: List[Task]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.37*/("""

<div class="folder" data-folder-id=""""),_display_(Seq[Any](/*3.38*/folder)),format.raw/*3.44*/("""">
    <header>
        <input type="checkbox" />
        <h3>"""),_display_(Seq[Any](/*6.14*/folder)),format.raw/*6.20*/("""</h3>
        <span class="counter"></span>
        <dl class="options">
            <dt>Options</dt>
            <dd>
                <a class="deleteCompleteTasks" href="#">Remove complete tasks</a>
                <a class="deleteAllTasks" href="#">Remove all tasks</a>
                <a class="deleteFolder" href="#">Delete folder</a>
            </dd>
        </dl>
        <span class="loader">Loading</span>
    </header>
    <ul class="list">
        """),_display_(Seq[Any](/*19.10*/tasks/*19.15*/.map/*19.19*/ { task =>_display_(Seq[Any](format.raw/*19.29*/("""
            """),_display_(Seq[Any](/*20.14*/views/*20.19*/.html.tasks.item( task ))),format.raw/*20.43*/("""
        """)))})),format.raw/*21.10*/("""
    </ul>
    <form class="addTask">
        <input type="hidden" name="folder" value=""""),_display_(Seq[Any](/*24.52*/folder)),format.raw/*24.58*/("""" />
        <input type="text" name="taskBody" placeholder="New task..." />
        <input type="text" name="dueDate" class="dueDate" placeholder="Due date: mm/dd/yy" />
        <div class="assignedTo">
            <input type="text" name="assignedTo" placeholder="Assign to..." />
        </div>
        <input type="submit" />
    </form>
</div>

"""))}
    }
    
    def render(folder:String,tasks:List[Task]): play.api.templates.Html = apply(folder,tasks)
    
    def f:((String,List[Task]) => play.api.templates.Html) = (folder,tasks) => apply(folder,tasks)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 13 01:27:50 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/tasks/folder.scala.html
                    HASH: 34a2d16a7c373cb8653dbe6f645eefaf14192af0
                    MATRIX: 741->1|853->36|927->75|954->81|1052->144|1079->150|1576->611|1590->616|1603->620|1651->630|1701->644|1715->649|1761->673|1803->683|1928->772|1956->778
                    LINES: 26->1|29->1|31->3|31->3|34->6|34->6|47->19|47->19|47->19|47->19|48->20|48->20|48->20|49->21|52->24|52->24
                    -- GENERATED --
                */
            