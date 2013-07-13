
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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Task,Boolean,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(task: Task, isEditable: Boolean = true):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""

<li data-task-id=""""),_display_(Seq[Any](/*3.20*/task/*3.24*/.id)),format.raw/*3.27*/("""">
    
    """),_display_(Seq[Any](/*5.6*/if(isEditable)/*5.20*/ {_display_(Seq[Any](format.raw/*5.22*/("""
        <input class="done" type="checkbox" """),_display_(Seq[Any](/*6.46*/(if(task.done) "checked"))),format.raw/*6.71*/(""" />
    """)))})),format.raw/*7.6*/("""
    
    <h4>"""),_display_(Seq[Any](/*9.10*/task/*9.14*/.title)),format.raw/*9.20*/("""</h4>
    
    """),_display_(Seq[Any](/*11.6*/if(task.dueDate != null)/*11.30*/ {_display_(Seq[Any](format.raw/*11.32*/("""
        <time datetime=""""),_display_(Seq[Any](/*12.26*/task/*12.30*/.dueDate)),format.raw/*12.38*/("""">"""),_display_(Seq[Any](/*12.41*/task/*12.45*/.dueDate.format("MMM dd yyyy"))),format.raw/*12.75*/("""</time>
    """)))})),format.raw/*13.6*/("""
    
    """),_display_(Seq[Any](/*15.6*/if(task.assignedTo != null && task.assignedTo.email != null)/*15.66*/ {_display_(Seq[Any](format.raw/*15.68*/("""
        <span class="assignedTo">"""),_display_(Seq[Any](/*16.35*/task/*16.39*/.assignedTo.email)),format.raw/*16.56*/("""</span>
    """)))})),format.raw/*17.6*/("""
    
    """),_display_(Seq[Any](/*19.6*/if(isEditable)/*19.20*/ {_display_(Seq[Any](format.raw/*19.22*/("""
        <a class="deleteTask" href=""""),_display_(Seq[Any](/*20.38*/routes/*20.44*/.Tasks.delete(task.id))),format.raw/*20.66*/("""">Delete task</a>
        <span class="loader">Loading</span>
    """)))})),format.raw/*22.6*/("""
    
</li>
"""))}
    }
    
    def render(task:Task,isEditable:Boolean): play.api.templates.Html = apply(task,isEditable)
    
    def f:((Task,Boolean) => play.api.templates.Html) = (task,isEditable) => apply(task,isEditable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 13 01:27:50 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/tasks/item.scala.html
                    HASH: 62f5ccf4f484464c33473117df75b39a8985dcc0
                    MATRIX: 734->1|851->41|907->62|919->66|943->69|990->82|1012->96|1051->98|1132->144|1178->169|1217->178|1267->193|1279->197|1306->203|1357->219|1390->243|1430->245|1492->271|1505->275|1535->283|1574->286|1587->290|1639->320|1683->333|1729->344|1798->404|1838->406|1909->441|1922->445|1961->462|2005->475|2051->486|2074->500|2114->502|2188->540|2203->546|2247->568|2345->635
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|34->6|34->6|35->7|37->9|37->9|37->9|39->11|39->11|39->11|40->12|40->12|40->12|40->12|40->12|40->12|41->13|43->15|43->15|43->15|44->16|44->16|44->16|45->17|47->19|47->19|47->19|48->20|48->20|48->20|50->22
                    -- GENERATED --
                */
            