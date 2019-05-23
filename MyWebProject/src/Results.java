

public class Results {
	
	public static void createHtml(String url, String title) {
		Verify.w.println("<!DOCTYPE html>\r\n" + 
				"<html lang=\"en\">\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\r\n" + 
				"    <title>Results</title>\r\n" + 
				"    <link rel=\"icon\" href=\"img/fav.png\" type=\"image/x-icon\">\r\n" + 
				"\r\n" + 
				"    <!-- Bootstrap -->\r\n" + 
				"    <link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"    <link href=\"ionicons/css/ionicons.min.css\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"    <!-- main css -->\r\n" + 
				"    <link href=\"css/style.css\" rel=\"stylesheet\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!-- modernizr -->\r\n" + 
				"    <script src=\"js/modernizr.js\"></script>\r\n" + 
				"\r\n" + 
				"    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\r\n" + 
				"    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n" + 
				"    <!--[if lt IE 9]>\r\n" + 
				"      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\r\n" + 
				"      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\r\n" + 
				"    <![endif]-->\r\n" + 
				"</head>\r\n" + 
				"\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"    <!-- Preloader -->\r\n" + 
				"    <div id=\"preloader\">\r\n" + 
				"        <div class=\"pre-container\">\r\n" + 
				"            <div class=\"spinner\">\r\n" + 
				"                <div class=\"double-bounce1\"></div>\r\n" + 
				"                <div class=\"double-bounce2\"></div>\r\n" + 
				"            </div>\r\n" + 
				"        </div>\r\n" + 
				"    </div>\r\n" + 
				"    <!-- end Preloader -->\r\n" + 
				"\r\n" + 
				"    <div class=\"container-fluid\"> \r\n" + 
				"       <!-- box-header -->\r\n" + 
				"        <header class=\"box-header\">\r\n" + 
				"            <div class=\"box-logo\">\r\n" + 
				"            \r\n" + 
				"            </div>\r\n" + 
				"            <!-- box-nav -->\r\n" + 
				"            <a class=\"box-primary-nav-trigger\" href=\"#0\">\r\n" + 
				"                <span class=\"box-menu-text\">Menu</span><span class=\"box-menu-icon\"></span>\r\n" + 
				"            </a>\r\n" + 
				"        </header>\r\n" + 
				"        <!-- end box-header -->\r\n" + 
				"        \r\n" + 
				"     \r\n" + 
				"    </div>\r\n" + 
				"    \r\n" + 
				"    <!-- Top bar -->\r\n" + 
				"    <div class=\"top-bar\">\r\n" + 
				"        <h1>Here is Your Post</h1>\r\n" + 
				"        <p><a href=\"single-project.html\">Return</a></p>\r\n" + 
				"    </div>\r\n" + 
				"    <!-- end Top bar -->\r\n" + 
				"    \r\n" + 
				"    <!-- Main container -->\r\n" + 
				"    <div class=\"container main-container clearfix\"> \r\n" + 
				"        <div class=\"col-md-6\">\r\n" + 
				"            <img src=\"http://placehold.it/1200x800\" class=\"img-responsive\" alt=\"\" />\r\n" + 
				"        </div>\r\n" + 
				"        <div class=\"col-md-6\">\r\n" + 
				"           <h3 class=\"uppercase\">" + title +"</h3>\r\n" + 
				"           <h5><a href = \""+ url + "\"> Click Here For Original Post </a> </h5>\r\n" + 
				"           <div class=\"h-30\"></div>\r\n" + 
				"           \r\n" + 
				"            <div class=\"h-10\"></div>\r\n" + 
				"            <ul class=\"social-ul\">\r\n" + 
				"                <li class=\"box-social\"><a href=\"#0\"><i class=\"ion-social-facebook\"></i></a></li>\r\n" + 
				"                <li class=\"box-social\"><a href=\"#0\"><i class=\"ion-social-instagram-outline\"></i></a></li>\r\n" + 
				"                <li class=\"box-social\"><a href=\"#0\"><i class=\"ion-social-twitter\"></i></a></li>\r\n" + 
				"                <li class=\"box-social\"><a href=\"#0\"><i class=\"ion-social-dribbble\"></i></a></li>\r\n" + 
				"            </ul>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"        </div>\r\n" + 
				"    </div>\r\n" + 
				"    <!-- end Main container -->\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!-- footer -->\r\n" + 
				"    <footer>\r\n" + 
				"        <div class=\"container-fluid\">\r\n" + 
				"            <p class=\"copyright\">© Box Portfolio 2016</p>\r\n" + 
				"        </div>\r\n" + 
				"    </footer>\r\n" + 
				"    <!-- end footer -->\r\n" + 
				"    \r\n" + 
				"    <!-- back to top -->\r\n" + 
				"    <a href=\"#0\" class=\"cd-top\"><i class=\"ion-android-arrow-up\"></i></a>\r\n" + 
				"    <!-- end back to top -->\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!-- jQuery -->\r\n" + 
				"    <script src=\"js/jquery-2.1.1.js\"></script>\r\n" + 
				"    <!--  plugins -->\r\n" + 
				"    <script src=\"js/bootstrap.min.js\"></script>\r\n" + 
				"    <script src=\"js/menu.js\"></script>\r\n" + 
				"    <script src=\"js/animated-headline.js\"></script>\r\n" + 
				"    <script src=\"js/isotope.pkgd.min.js\"></script>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"    <!--  custom script -->\r\n" + 
				"    <script src=\"js/custom.js\"></script>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"\r\n" + 
				"</html>\"");
		
	}
	
	
}
