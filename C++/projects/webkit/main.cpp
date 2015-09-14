#include <gtkmm.h>
#include <webkit/webkit.h>
#include <iostream>
#include <string>

/*
	need to install webkitgtk and gtkmm
*/

std::string get_working_path()
{
   char temp[PATH_MAX];
   return ( getcwd(temp, PATH_MAX) ? std::string( temp ) : std::string("") );
}

int main( int argc, char *argv[])
{



	Glib::RefPtr<Gtk::Application> app = Gtk::Application::create( argc, argv, "" );

	Gtk::Window window;
	window.set_default_size( 800, 600 );

	WebKitWebView * one =  WEBKIT_WEB_VIEW( webkit_web_view_new() );
	/*
	* the next line does some tricks :
	* GTK_WIDGET( one ) -> convert WebKitWebView to GtkWidget (one->two)
	* Glib::wrap( GTK_WIDGET( one ) ) -> convert GtkWidget to Gtk::Widget (two->three)
	*/
	Gtk::Widget * three = Glib::wrap( GTK_WIDGET( one ) );

	window.add( *three );

	std::string full_path = "file://" +  get_working_path() + "/index.html";
	const char * c_full_path = full_path.c_str();

	webkit_web_view_load_uri(one, c_full_path);

	window.show_all();

	app->run( window );  
	exit( 0 );
}

