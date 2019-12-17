import kivy
kivy.require("1.9.0")

from kivy.app import App
from kivy.uix.gridlayout import GridLayout


class GridApp(App):
    
    def build(self):
        return GridLayout()


glApp = GridApp()
glApp.run()
