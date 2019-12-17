# import kivy
# kivy.require('1.9.0')

# from kivy.app import App
# from kivy.uix.button import Label

# class HelloKivy(App):
#     def build(self):
#         return Label(text="Hello Kivy")



# helloKivy = HelloKivy()
# helloKivy.run()


# we can separate presentation layer from logic layer
import kivy
kivy.require('1.9.0')

from kivy.app import App
from kivy.uix.button import Label

class HelloKivyApp(App):
    def build(self):
        return Label()


helloKivy = HelloKivyApp()
helloKivy.run()