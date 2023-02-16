#!/bin/sh

# Überprüfen wir, ob eine private Key-Datei vorhanden ist
if [ ! -f /etc/wireguard/client.key ]; then
  echo "Private key file not found. Exiting."
  exit 1
fi

# Überprüfen wir, ob eine Wireguard-Konfigurationsdatei vorhanden ist
if [ ! -f /etc/wireguard/wg0.conf ]; then
  echo "Wireguard config file not found. Exiting."
  exit 1
fi

# Private Key aus der Datei lesen
private_key=$(cat /etc/wireguard/client.key)

# Private Key in die Wireguard-Konfigurationsdatei schreiben
sed -i "/PrivateKey/c\PrivateKey = $private_key" /etc/wireguard/wg0.conf

echo "Private key successfully added to Wireguard config file."

wg syncconf wg0 <(wg-quick strip wg0)

wg show
