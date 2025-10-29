import network
import time
from machine import Pin
import dht
import ujson
from umqtt.simple import MQTTClient
import ssl as ssl_lib


def connect_to_wifi():
    print("Connecting to WiFi", end="")
    sta_if = network.WLAN(network.STA_IF)
    sta_if.active(True)
    # A adapter
    sta_if.connect("nom du wifi du tel", "mdp de mon wifi")
    while not sta_if.isconnected():
        print(".", end="")
        time.sleep(0.1)
    print(" Connected!")


def connect_to_mqtt():
    print("Connecting to MQTT server... ", end="")
    # A adapter
    MQTT_CLIENT_ID = "truc_muche"
    MQTT_BROKER = "URL de mon broker privé sur hiveMQ"
    MQTT_USER = "login d'un des comptes que j'ai créé sur HiveMQ"
    MQTT_PASSWORD = "mdp"
    # Fin de la partie à adapter
    ssl_params = {"server_hostname": MQTT_BROKER}
    client = MQTTClient(
        MQTT_CLIENT_ID, MQTT_BROKER, user=MQTT_USER, password=MQTT_PASSWORD, ssl=ssl_lib
    )
    client.connect()
    print("Connected!")
    return client


connect_to_wifi()
client = connect_to_mqtt()

sensor = dht.DHT22(Pin(15))
prev_weather = ""
while True:
    # A remplacer par les valeurs de vos capteurs
    message = ujson.dumps(
        {
            "text": "Hello",
            "Year": 2025,
        }
    )
    # A adapter selon la fréquence de données à envoyer
    time.sleep(5)
