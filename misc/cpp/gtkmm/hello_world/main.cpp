#include "hello.h"
#include <gtkmm/application.h>

int main(int argc, char *argv[])
{
	
	Glib::RefPtr<Gtk::Application> app = Gtk::Application::create(argc, argv, "hello world");
	
	HelloWorld helloworld;
	
		
	//Shows the window and returns when it is closed.
  	return app->run(helloworld);
}
