
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
object group extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,List[Project],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(group: String, projects: List[Project]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.42*/("""

<li data-group=""""),_display_(Seq[Any](/*3.18*/group)),format.raw/*3.23*/("""">
    <span class="toggle"></span>
    <h4 class="groupName">"""),_display_(Seq[Any](/*5.28*/group)),format.raw/*5.33*/("""</h4>
    <span class="loader">Loading</span>
    <dl class="options">
        <dt>Options</dt>
        <dd>
            <button class="newProject">New group</button>
            <button class="deleteGroup">Remove group</button>
        </dd>
    </dl>
    <ul>
        """),_display_(Seq[Any](/*15.10*/projects/*15.18*/.map/*15.22*/ { project =>_display_(Seq[Any](format.raw/*15.35*/("""
            """),_display_(Seq[Any](/*16.14*/views/*16.19*/.html.projects.item(project))),format.raw/*16.47*/("""
        """)))})),format.raw/*17.10*/("""
    </ul>
</li>
"""))}
    }
    
    def render(group:String,projects:List[Project]): play.api.templates.Html = apply(group,projects)
    
    def f:((String,List[Project]) => play.api.templates.Html) = (group,projects) => apply(group,projects)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 20 19:28:41 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/projects/group.scala.html
                    HASH: fc3c5d627d448da1fbba36a4c39fceb4f4a8f668
                    MATRIX: 746->1|863->41|917->60|943->65|1041->128|1067->133|1374->404|1391->412|1404->416|1455->429|1505->443|1519->448|1569->476|1611->486
                    LINES: 26->1|29->1|31->3|31->3|33->5|33->5|43->15|43->15|43->15|43->15|44->16|44->16|44->16|45->17
                    -- GENERATED --
                */
            