#!/bin/bash

if [ $# -eq 0 ]
then
        echo "must pass a client name as an arg: add-client.sh new-client"
else
        echo "Creating client config for: $1"
        mkdir -p clients/$1

        ip="10.8.8."$(expr $(cat last-ip.txt | tr "." " " | awk '{print $4}') + 1)

       # Client zur Serverkonfiguration hinzufügen
        echo "[Peer]" >> /etc/wireguard/wg0.conf
        echo "PublicKey = 9LQ5+WJlvuiTSrY2I2MNd1R9ZfBAgRtWmWh/V8La4EM=" >> /etc/wireguard/wg0.conf
        echo "AllowedIPs = $ip/32" >> /etc/wireguard/wg0.conf
        # Configuration aktualisieren ohne neuzustarten
        wg syncconf wg0 <(wg-quick strip wg0)

        wg
        echo $ip > last-ip.txt
        #Client Konfiguration
        echo "[Interface]" > "clients/$1/$1.conf"
        echo "Address = $ip/32" >> "clients/$1/$1.conf"
        echo "PrivateKey =" >> "clients/$1/$1.conf"
        echo "[Peer]" >> "clients/$1/$1.conf"
        echo "AllowedIPs = 10.8.8.1/32" >> "clients/$1/$1.conf"
        #echo "AllowedIPs = 0.0.0.0/32" >> "clients/$1/$1.conf"
        echo "Endpoint = 143.93.245.161/32:23352" >> "clients/$1/$1.conf"
        echo "PublicKey = $(cat /etc/wireguard/server_public_key)" >> "clients/$1/$1.conf"
        chmod 777 clients/$1/$1.conf
        cp clients/$1/$1.conf /var/www/html/ids-connector/
        #Server zu dem Client

        echo "Created config!"
        echo "Adding peer"

        sudo wg show
fi
