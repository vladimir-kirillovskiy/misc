#include <iostream>
#include <sstream>

#include "myWindow.h"
#include "hash.h"

#include <gtkmm/button.h>	
#include <gtkmm/dialog.h>
#include <gtkmm/grid.h>
#include <gtkmm/messagedialog.h>
#include <gtkmm/label.h>
#include <gtkmm/entry.h>



myWindow::myWindow()
{
    set_default_size(450, 100);
    set_title("HS Password Generator");

    Gtk::Box *vbox = Gtk::manage(new Gtk::Box(Gtk::ORIENTATION_VERTICAL, 0));
    add(*vbox);

    Gtk::Grid *grid = Gtk::manage(new Gtk::Grid);
    grid->set_border_width(10);
    grid->set_row_spacing(5);
    vbox->add(*grid);

    // draw labels and textboxes
    Gtk::Label *lserial = Gtk::manage(new Gtk::Label("Serial Number: "));
    grid->attach(*lserial, 0, 0, 1, 1);
    Gtk::Label *ldate = Gtk::manage(new Gtk::Label("Date (YYYY-MM-DD H):"));
    grid->attach(*ldate, 0, 1, 1, 1);
    Gtk::Label *lproduct = Gtk::manage(new Gtk::Label("Product Code: "));
    grid->attach(*lproduct, 0, 2, 1, 1);

    Gtk::Entry *eserial = Gtk::manage(new Gtk::Entry());
    eserial->set_hexpand(true);
    grid->attach(*eserial, 1, 0, 2, 1);

    Gtk::Entry *edate = Gtk::manage(new Gtk::Entry());
    edate->set_hexpand(true);
    grid->attach(*edate, 1, 1, 2, 1);

    Gtk::Entry *eproduct = Gtk::manage(new Gtk::Entry());
    eproduct->set_hexpand(true);
    grid->attach(*eproduct, 1, 2, 2, 1);

    Gtk::Entry *epass = Gtk::manage(new Gtk::Entry());
    epass->set_hexpand(true);
    epass->set_alignment(0.5);
    grid->attach(*epass, 0, 3, 3, 1);

    Gtk::Button *bgen = Gtk::manage(new Gtk::Button("Generate"));
    bgen->signal_clicked().connect(
        sigc::bind<Gtk::Entry*, Gtk::Entry*>(
            sigc::mem_fun(*this, &myWindow::on_gen_click), eserial, edate, eproduct, epass));
    grid->attach(*bgen, 2, 4, 1, 1);

    vbox->show_all();
}

myWindow::~myWindow()
{
    //destructor
}

void myWindow::on_gen_click(Gtk::Entry *esnumber, Gtk::Entry *edate, Gtk::Entry *epcode, Gtk::Entry *epass)
{
    std::string msg, hash, pass;
    std::string snumber(esnumber->get_text());
    std::string sdate(edate->get_text());
    std::string scode(epcode->get_text());

    msg =  scode + sdate + snumber;

    Hash cHash;
    hash = cHash.sha256(msg);


    epass->set_text(hash);
}

void myWindow::dialog(Glib::ustring msg)
{
    Gtk::MessageDialog dlg(msg, false, Gtk::MESSAGE_INFO, Gtk::BUTTONS_OK, true);
    dlg.set_title("Gtkmm Tutorial 4");
    dlg.run();
}