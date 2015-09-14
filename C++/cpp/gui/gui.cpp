#include <gtkmm.h>		// ncludes the entire gtkmm kit. This is usually not a good idea, because it includes a megabyte or so of headers

// made a makefile

// g++ `pkg-config gtkmm-3.0 --libs --cflags` -o gui gui.cpp  !backquotes!

int main(int argc, char* argv[])
{
	Glib::RefPtr<Gtk::Application> app =
   		Gtk::Application::create(argc, argv,
      		"org.gtkmm.examples.base");

 	Gtk::Window window;
	window.set_default_size(200, 200);

	return app->run(window);
}
