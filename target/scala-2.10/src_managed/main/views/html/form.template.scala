
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
object form extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[User],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(signupForm: Form[User]):play.api.templates.Html = {
        _display_ {import helper._

import helper.twitterBootstrap._


Seq[Any](format.raw/*1.26*/("""

"""),format.raw/*5.1*/("""
<html>
    <head>
        <title>Make A Note</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*9.59*/routes/*9.65*/.Assets.at("images/favicon.png"))),format.raw/*9.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*10.70*/routes/*10.76*/.Assets.at("stylesheets/signup.css"))),format.raw/*10.112*/("""">
		<link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*11.64*/routes/*11.70*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*11.109*/("""">
	</head>
    <body>
        
        <header>
            <a href=""""),_display_(Seq[Any](/*16.23*/routes/*16.29*/.Projects.index)),format.raw/*16.44*/("""" id="logo"><span>Make</span> A Note</a>
			<dl id="user">
                <dd>
                    <a href=""""),_display_(Seq[Any](/*19.31*/routes/*19.37*/.Application.login())),format.raw/*19.57*/("""">Sign in</a>
                </dd>
				 <dd>
                    <a href=""""),_display_(Seq[Any](/*22.31*/routes/*22.37*/.SignUp.blank())),format.raw/*22.52*/("""">Sign up</a>
                </dd>
            </dl>
        </header>

        """),_display_(Seq[Any](/*27.10*/helper/*27.16*/.form(action = routes.SignUp.submit)/*27.52*/ {_display_(Seq[Any](format.raw/*27.54*/("""
            
            <h1>Account informations</h1>
			
			<fieldset>
			
			"""),_display_(Seq[Any](/*33.5*/inputText(
                signupForm("name"), 
                '_label -> "Username", 
                '_help -> "Please choose a valid username.",
                '_error -> signupForm.globalError
            ))),format.raw/*38.14*/("""
            
            """),_display_(Seq[Any](/*40.14*/inputText(
                signupForm("email"), '_label -> "Email",
                '_help -> "Enter a valid email address."
            ))),format.raw/*43.14*/("""
            
            """),_display_(Seq[Any](/*45.14*/inputPassword(
                signupForm("password"), 
                '_label -> "Password",
                '_help -> "A password must be at least 6 characters. "
            ))),format.raw/*49.14*/("""
            
            """),_display_(Seq[Any](/*51.14*/inputPassword(
                signupForm("repeatPassword"), 
                '_label -> "Repeat password",
                '_help -> "Please repeat your password again.",
                '_error -> signupForm.error("password")
            ))),format.raw/*56.14*/("""
			</fieldset>
            
			<fieldset>
            
            """),_display_(Seq[Any](/*61.14*/checkbox(
                signupForm("accept"), 
                '_label -> None, '_text -> "You agree the Terms and conditions",
                '_showConstraints -> false
            ))),format.raw/*65.14*/("""
            </fieldset>   
			<div class="actions">
				<input type="submit" class="btn primary" value="Sign Up">
				<a href=""""),_display_(Seq[Any](/*69.15*/routes/*69.21*/.Application.login)),format.raw/*69.39*/("""" class="btn">Cancel</a>
			</div>			
        """)))})),format.raw/*71.10*/("""

        <p class="note">
            Try <em>guillaume@sample.com</em> with <em>secret</em> as password.
        </p>
            
    </body>
</html>
    


"""))}
    }
    
    def render(signupForm:Form[User]): play.api.templates.Html = apply(signupForm)
    
    def f:((Form[User]) => play.api.templates.Html) = (signupForm) => apply(signupForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Jul 13 01:27:49 EEST 2013
                    SOURCE: D:/Java/play/Course_Project/app/views/form.scala.html
                    HASH: a802156f9382c7315f339cd86b5ef5c8bd83ec97
                    MATRIX: 726->1|877->25|905->78|1052->190|1066->196|1119->228|1227->300|1242->306|1301->342|1403->408|1418->414|1480->453|1587->524|1602->530|1639->545|1785->655|1800->661|1842->681|1954->757|1969->763|2006->778|2124->860|2139->866|2184->902|2224->904|2341->986|2575->1198|2638->1225|2798->1363|2861->1390|3062->1569|3125->1596|3388->1837|3493->1906|3701->2092|3866->2221|3881->2227|3921->2245|4000->2292
                    LINES: 26->1|32->1|34->5|38->9|38->9|38->9|39->10|39->10|39->10|40->11|40->11|40->11|45->16|45->16|45->16|48->19|48->19|48->19|51->22|51->22|51->22|56->27|56->27|56->27|56->27|62->33|67->38|69->40|72->43|74->45|78->49|80->51|85->56|90->61|94->65|98->69|98->69|98->69|100->71
                    -- GENERATED --
                */
            