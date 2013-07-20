
package views.html.projects

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
object item extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Project,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(project: Project):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.20*/("""

<li data-project=""""),_display_(Seq[Any](/*3.20*/project/*3.27*/.id)),format.raw/*3.30*/("""">
    <a class="name" href="#"""),_display_(Seq[Any](/*4.29*/routes/*4.35*/.Notes.index(project.id))),format.raw/*4.59*/("""">"""),_display_(Seq[Any](/*4.62*/project/*4.69*/.name)),format.raw/*4.74*/("""</a>
    <button class="delete" href=""""),_display_(Seq[Any](/*5.35*/routes/*5.41*/.Projects.delete(project.id))),format.raw/*5.69*/("""">Delete</button>
    <span class="loader">Loading</span>
</li>
"""))}
    }
    
    def render(project:Project): play.api.templates.Html = apply(project)
    
    def f:((Project) => play.api.templates.Html) = (project) => apply(project)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 20 20:20:39 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/projects/item.scala.html
                    HASH: 5f72bf19de604d295675b39fa5585e91bbf8bb7c
                    MATRIX: 732->1|827->19|883->40|898->47|922->50|988->81|1002->87|1047->111|1085->114|1100->121|1126->126|1200->165|1214->171|1263->199
                    LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|32->4|32->4|32->4|33->5|33->5|33->5
                    -- GENERATED --
                */
            