#ifndef MYWINDOW_H
#define MYWINDOW_H

	#include <gtkmm/window.h>

	class myWindow : public Gtk::Window
	{
		public:
			myWindow();
			virtual ~myWindow();
		protected:
			void on_big_button1_click();
			void on_button2_click();
			void on_button3_click();
			void on_quit_click();
			void dialog(Glib::ustring msg);
		private:
	};



#endif