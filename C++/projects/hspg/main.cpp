#include <gtkmm/application.h>
#include "myWindow.h"

int main(int argc, char *argv[])
{
	Glib::RefPtr<Gtk::Application> app = 
		Gtk::Application::create(argc, argv,
			 "hspg");

	myWindow window;	

	return app->run(window);	
}
