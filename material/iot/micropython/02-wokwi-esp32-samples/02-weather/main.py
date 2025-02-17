import time
from machine import Pin
import dht

sensor = dht.DHT22(Pin(15))

prev_temperature = None
prev_humidity = None
while True:
    print("measuring ...")
    sensor.measure()
    if prev_humidity != sensor.humidity() or prev_temperature != sensor.temperature():
        prev_temperature, prev_humidity = sensor.temperature(), sensor.humidity()
        print("temp", prev_temperature, "hum", prev_humidity)
    time.sleep(1)
