#include <gtkmm/application.h>
#include <gtkmm/builder.h>
#include <glibmm/markup.h>
#include <glibmm/fileutils.h>
#include <iostream>

#include "gui.h"

int main (int argc, char **argv)
{
  Glib::RefPtr<Gtk::Application> app = Gtk::Application::create(argc, argv, "org.gtkmm.example");

  //Load the Glade file and instiate its widgets:
  Glib::RefPtr<Gtk::Builder> refBuilder = Gtk::Builder::create();
  try
  {
    refBuilder->add_from_file("hspggui.glade");
  }
  catch(const Glib::FileError& ex)
  {
    std::cerr << "FileError: " << ex.what() << std::endl;
    return 1;
  }
  catch(const Glib::MarkupError& ex)
  {
    std::cerr << "MarkupError: " << ex.what() << std::endl;
    return 1;
  }
  catch(const Gtk::BuilderError& ex)
  {
    std::cerr << "BuilderError: " << ex.what() << std::endl;
    return 1;
  }

  //Get the GtkBuilder-instantiated dialog::
  Gui* pWindow = 0;
  refBuilder->get_widget_derived("window1", pWindow);
  if(pWindow)
  {
  	pWindow->set_title("HS Password Generator");
    //Start:
    app->run(*pWindow);
  }

  delete pWindow;

  return 0;
}