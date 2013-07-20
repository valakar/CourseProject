
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Project,Task,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(project: Project, task: Task):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""
<header>

    <hgroup>
        <h1>"""),_display_(Seq[Any](/*5.14*/project/*5.21*/.folder)),format.raw/*5.28*/("""</h1>
        <h2>"""),_display_(Seq[Any](/*6.14*/project/*6.21*/.name)),format.raw/*6.26*/("""</h2>
    </hgroup>
</header>
    
<form class="addTask">
    <input type="text" name="title" placeholder="Add title..." />
    <input type="text" name="text" placeholder="New task..." />
    <input type="text" name="dueDate" class="dueDate" placeholder="Due date: mm/dd/yy" />
    <div class="assignedTo">
        <input type="text" name="assignedTo" placeholder="Assign to..." />
    </div>
    <input type="submit" />
</form>
"""))}
    }
    
    def render(project:Project,task:Task): play.api.templates.Html = apply(project,task)
    
    def f:((Project,Task) => play.api.templates.Html) = (project,task) => apply(project,task)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 20 19:28:41 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/tasks/createForm.scala.html
                    HASH: 3bce85cff6414717099edd3e123d395639c3e005
                    MATRIX: 740->1|847->31|923->72|938->79|966->86|1021->106|1036->113|1062->118
                    LINES: 26->1|29->1|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            