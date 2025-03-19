from machine import Pin, I2C
from utime import sleep
import utils
import ssd1306

# ESP32 Pin assignment
i2c = I2C(0, scl=Pin(21), sda=Pin(19))

oled_width = 128
oled_height = 64
oled = ssd1306.SSD1306_I2C(oled_width, oled_height, i2c)

oled.text("Hello, Wokwi!", 10, 10)
oled.invert(1)
oled.show()


print("Hello, ESP32!")

utils.say_hello()

led = Pin(15, Pin.OUT)
while True:
    led.on()
    sleep(0.5)
    led.off()
    sleep(0.5)
