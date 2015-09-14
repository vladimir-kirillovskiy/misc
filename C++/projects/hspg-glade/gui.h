#ifndef GUI_H
#define GUI_H

#include <gtkmm/entry.h>
#include <gtkmm/window.h>
#include <gtkmm/builder.h>
#include <gtkmm/button.h>


class Gui : public Gtk::Window
{
public:
  Gui(BaseObjectType* cobject, const Glib::RefPtr<Gtk::Builder>& refGlade);
  virtual ~Gui();

protected:
  //Signal handlers:
  void on_button_click(Gtk::Entry *esnumber, Gtk::Entry *edate, Gtk::Entry *epcode, Gtk::Entry *epass);

  Glib::RefPtr<Gtk::Builder> m_refGlade;
  Gtk::Button* m_pButton;
  Gtk::Entry* m_pSNumber; 
  Gtk::Entry* m_pDate;
  Gtk::Entry* m_pPCode;
  Gtk::Entry* m_pPass;
};

#endif // GUI_H