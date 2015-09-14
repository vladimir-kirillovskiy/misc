#include "gui.h"
#include "hash.h"

#include <iostream>
#include <sstream>

#include <gtkmm/button.h>	
#include <gtkmm/label.h>
#include <gtkmm/entry.h>

Gui::Gui(BaseObjectType* cobject, const Glib::RefPtr<Gtk::Builder>& refGlade)
: Gtk::Window(cobject),
  m_refGlade(refGlade),
  m_pButton(0),
  m_pSNumber(0),
  m_pDate(0),
  m_pPCode(0),
  m_pPass(0)
{
	m_refGlade->get_widget("txtSNumber", m_pSNumber);
	m_refGlade->get_widget("txtDate", m_pDate);
	m_refGlade->get_widget("txtPCode", m_pPCode);
	m_refGlade->get_widget("txtPass", m_pPass);

	//Get the Glade-instantiated Button, and connect a signal handler:
	m_refGlade->get_widget("btnGen", m_pButton);
	if(m_pButton)
	{
	m_pButton->signal_clicked().connect( sigc::bind<Gtk::Entry*, Gtk::Entry*>(
            sigc::mem_fun(*this, &Gui::on_button_click),
            	 m_pSNumber, m_pDate, m_pPCode, m_pPass));
	}

}

Gui::~Gui()
{
}

void Gui::on_button_click(Gtk::Entry *esnumber, Gtk::Entry *edate, Gtk::Entry *epcode, Gtk::Entry *epass)
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