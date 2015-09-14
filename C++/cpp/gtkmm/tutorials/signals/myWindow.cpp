#include "myWindow.h"

#include <gtkmm/button.h>	
#include <gtkmm/dialog.h>
#include <gtkmm/grid.h>
#include <gtkmm/menu.h>
#include <gtkmm/menuitem.h>
#include <gtkmm/menubar.h>
#include <gtkmm/messagedialog.h>


myWindow::myWindow()
{
	set_default_size(400, 200);
	set_title("Tutorial 3");

	Gtk::Box *vbox = Gtk::manage(new Gtk::Box(Gtk::ORIENTATION_VERTICAL, 0));
	add(*vbox);

	Gtk::MenuBar *menubar = Gtk::manage(new Gtk::MenuBar());
	vbox->pack_start(*menubar, Gtk::PACK_SHRINK, 0);

	Gtk::MenuItem *menuitem_file = Gtk::manage(new Gtk::MenuItem("_File", true));
	menubar->append(*menuitem_file);
	Gtk::Menu *filemenu = Gtk::manage(new Gtk::Menu());
	menuitem_file->set_submenu(*filemenu);
	Gtk::MenuItem *menuitem_quit = Gtk::manage(new Gtk::MenuItem("_Quit", true));
	menuitem_quit->signal_activate().connect(sigc::mem_fun(*this, &myWindow::on_quit_click));
	filemenu->append(*menuitem_quit);

	Gtk::Grid *grid = Gtk::manage(new Gtk::Grid);
	grid->set_border_width(10);
	vbox->add(*grid);

	Gtk::Button *b1 = Gtk::manage(new Gtk::Button("Big Button 1"));
    b1->set_hexpand(true);
    b1->set_vexpand(true);
    b1->signal_clicked().connect(sigc::mem_fun(*this, &myWindow::on_big_button1_click));
    grid->attach(*b1, 0, 0, 1, 2);

    Gtk::Button *b2 = Gtk::manage(new Gtk::Button("Button 2"));
    b2->signal_clicked().connect(sigc::mem_fun(*this, &myWindow::on_button2_click));
    grid->attach(*b2, 1, 0, 1, 1);

    Gtk::Button *b3 = Gtk::manage(new Gtk::Button("Button 3"));
    b3->signal_clicked().connect(sigc::mem_fun(*this, &myWindow::on_button3_click));
    grid->attach(*b3, 1, 1, 1, 1);

    vbox->show_all();
}

myWindow::~myWindow()
{
    //destructor
}

void myWindow::on_big_button1_click()
{
    dialog("Big Button 1 Pressed!");
}

void myWindow::on_button2_click()
{
    dialog("Button 2 Pressed!");
}

void myWindow::on_button3_click()
{
    dialog("Button 3 Pressed!");
}

void myWindow::on_quit_click()
{
    hide();
}

void myWindow::dialog(Glib::ustring msg)
{
    Gtk::MessageDialog dlg(msg, false, Gtk::MESSAGE_INFO, Gtk::BUTTONS_OK, true);
    dlg.set_title("Gtkmm Tutorial 3");
    dlg.run();
}