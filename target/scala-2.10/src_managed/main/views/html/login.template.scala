
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Application.Login],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[Application.Login]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""

<html>
    <head>
        <title>Make A Note</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/login.css"))),format.raw/*7.111*/("""">
    </head>
    <body>
        
        <header>
            <a href=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Projects.index)),format.raw/*12.44*/("""" id="logo"><span>Make</span> A Note</a>
			<dl id="user">
                <dt></dt>
                <dd>
                    <a href=""""),_display_(Seq[Any](/*16.31*/routes/*16.37*/.Application.login())),format.raw/*16.57*/("""">Sign in</a>
                </dd>
				 <dd>
                    <a href=""""),_display_(Seq[Any](/*19.31*/routes/*19.37*/.SignUp.blank())),format.raw/*19.52*/("""">Sign up</a>
                </dd>
            </dl>
        </header>
        
        """),_display_(Seq[Any](/*24.10*/helper/*24.16*/.form(routes.Application.authenticate)/*24.54*/ {_display_(Seq[Any](format.raw/*24.56*/("""
            
            <h1>Sign in</h1>
            
            """),_display_(Seq[Any](/*28.14*/if(form.hasGlobalErrors)/*28.38*/ {_display_(Seq[Any](format.raw/*28.40*/(""" 
                <p class="error">
                    """),_display_(Seq[Any](/*30.22*/form/*30.26*/.globalError.message)),format.raw/*30.46*/("""
                </p>
            """)))})),format.raw/*32.14*/("""
            
            """),_display_(Seq[Any](/*34.14*/if(flash.contains("success"))/*34.43*/ {_display_(Seq[Any](format.raw/*34.45*/("""
                <p class="success">
                    """),_display_(Seq[Any](/*36.22*/flash/*36.27*/.get("success"))),format.raw/*36.42*/("""
                </p>
            """)))})),format.raw/*38.14*/("""
            
            <p>
                <input type="email" name="email" placeholder="Email" value=""""),_display_(Seq[Any](/*41.78*/form("email")/*41.91*/.value)),format.raw/*41.97*/("""">
            </p>
            <p>
                <input type="password" name="password" placeholder="Password">
            </p>
            <p>
                <button type="submit">Login</button>
            </p>
			<p>
				<a href=""""),_display_(Seq[Any](/*50.15*/routes/*50.21*/.SignUp.blank())),format.raw/*50.36*/("""">Sign up</a>
            </p>
            
        """)))})),format.raw/*53.10*/("""
        
        <p class="note">
            Try <em>guillaume@sample.com</em> with <em>secret</em> as password.
        </p>
            
    </body>
</html>
    


"""))}
    }
    
    def render(form:Form[Application.Login]): play.api.templates.Html = apply(form)
    
    def f:((Form[Application.Login]) => play.api.templates.Html) = (form) => apply(form)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 20 19:28:41 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/login.scala.html
                    HASH: 6f201bc94de945e5dc051d60aa69ca6df574fbae
                    MATRIX: 740->1|848->32|996->145|1010->151|1063->183|1170->255|1184->261|1241->296|1351->370|1366->376|1403->391|1575->527|1590->533|1632->553|1744->629|1759->635|1796->650|1922->740|1937->746|1984->784|2024->786|2129->855|2162->879|2202->881|2295->938|2308->942|2350->962|2417->997|2480->1024|2518->1053|2558->1055|2652->1113|2666->1118|2703->1133|2770->1168|2913->1275|2935->1288|2963->1294|3238->1533|3253->1539|3290->1554|3375->1607
                    LINES: 26->1|29->1|34->6|34->6|34->6|35->7|35->7|35->7|40->12|40->12|40->12|44->16|44->16|44->16|47->19|47->19|47->19|52->24|52->24|52->24|52->24|56->28|56->28|56->28|58->30|58->30|58->30|60->32|62->34|62->34|62->34|64->36|64->36|64->36|66->38|69->41|69->41|69->41|78->50|78->50|78->50|81->53
                    -- GENERATED --
                */
            