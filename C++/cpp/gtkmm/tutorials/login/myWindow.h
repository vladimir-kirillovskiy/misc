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
			void on_login_click(Gtk::Entry *euname, Gtk::Entry *epword);
			void on_quit_click();
			void dialog(Glib::ustring msg);
		private:
	};



#endif