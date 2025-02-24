import network
import time
from machine import Pin
import dht
import ujson
from umqtt.simple import MQTTClient
import ssl as ssl_lib

# constants.py defines MQTT_CLIENT_ID, MQTT_BROKER, MQTT_USER, MQTT_PASSWORD
from constants import *

sensor = dht.DHT22(Pin(15))

print("Connecting to WiFi", end="")
sta_if = network.WLAN(network.STA_IF)
sta_if.active(True)
sta_if.connect("Wokwi-GUEST", "")
while not sta_if.isconnected():
    print(".", end="")
    time.sleep(0.1)
print(" Connected!")

print("Connecting to MQTT server... ", end="")
ssl_params = {"server_hostname": MQTT_BROKER}
client = MQTTClient(
    MQTT_CLIENT_ID, MQTT_BROKER, user=MQTT_USER, password=MQTT_PASSWORD, ssl=ssl_lib
)
client.connect()

print("Connected!")

prev_weather = ""
while True:
    print("Measuring weather conditions... ", end="")
    sensor.measure()
    message = ujson.dumps(
        {
            "temp": sensor.temperature(),
            "humidity": sensor.humidity(),
        }
    )
    if message != prev_weather:
        print("Updated!")
        print("Reporting to MQTT topic {}: {}".format(MQTT_TOPIC, message))
        client.publish(MQTT_TOPIC, message)
        prev_weather = message
    else:
        print("No change")
    time.sleep(1)
