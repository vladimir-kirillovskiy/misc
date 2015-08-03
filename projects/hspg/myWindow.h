#ifndef MYWINDOW_H
#define MYWINDOW_H

	#include <gtkmm/window.h>
	#include <gtkmm/entry.h>

	class myWindow : public Gtk::Window
	{
		public:
			myWindow();
			virtual ~myWindow();
		protected:
			void on_gen_click(Gtk::Entry *esnumber, Gtk::Entry *edate, Gtk::Entry *epcode, Gtk::Entry *epass);
			void dialog(Glib::ustring msg);
		private:
	};



#endif