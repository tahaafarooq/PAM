"""
author : @tahaafarooq
file : main.py
desc : This is the main application's code
"""

from kivy.app import App
from kivy.uix.image import Image
from kivy.uix.label import Label
from kivy.animation import Animation
from kivy.clock import Clock


class PAM():
    def test(self):
        return Label(text='Password Account Manager')


class PAMSplash(App):
    def build(self):
        # Splash Screen
        image = Image(source='assets/pam.jpeg', pos=(800, 800))
        animation = Animation(x=0, y=0, d=2, t='out_bounce')
        animation.start(image)

        Clock.schedule_once(PAM.test, 0.5)

        return image


if __name__ == '__main__':
    PAMSplash().run()