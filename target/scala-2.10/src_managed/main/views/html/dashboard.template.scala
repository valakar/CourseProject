
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
object dashboard extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Project],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(projects: List[Project], user: User):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.39*/("""

"""),_display_(Seq[Any](/*3.2*/main(projects, user)/*3.22*/{_display_(Seq[Any](format.raw/*3.23*/("""
    
    <header>
        <hgroup>
            <h1>Dashboard</h1>
            <h2>Tasks over all projects</h2>
        </hgroup>
    </header>
    
    <article  class="tasks">
		test
    </article>
    
""")))})),format.raw/*16.2*/("""

"""))}
    }
    
    def render(projects:List[Project],user:User): play.api.templates.Html = apply(projects,user)
    
    def f:((List[Project],User) => play.api.templates.Html) = (projects,user) => apply(projects,user)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 20 19:28:40 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/dashboard.scala.html
                    HASH: 261aae0e8ae6ac56bddca304361dab251fe712ef
                    MATRIX: 739->1|853->38|890->41|918->61|956->62|1193->268
                    LINES: 26->1|29->1|31->3|31->3|31->3|44->16
                    -- GENERATED --
                */
            