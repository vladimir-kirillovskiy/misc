#include <gtkmm.h>

int main(int argc, char *argv[])
{
	Glib::RefPtr<Gtk::Application> app = 
		Gtk::Application::create(argc, argv,
			 "tutorial1");

	Gtk::Window window;
	
	window.set_default_size(400,200);
	window.set_title("Tutorial 1");

	return app->run(window);	
}