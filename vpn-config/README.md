# Kommunkation im Datenraum

## Wichtig

Bevor Sie mit den folgenden Schritten beginnen, müssen Sie sicherstellen, dass Sie alle anderen notwendigen Konfigurationen vorgenommen haben und der Datenraum ordnungsgemäß läuft. Weitere Informationen dazu finden Sie in den Readme-Dateien unter /VPN_In_EDC_Datenraum, /consumer_company und /provider_company.

Führen Sie nun die unten stehenden Befehle aus und stellen Sie sicher, dass Sie die richtigen Befehle auf der entsprechenden Seite (Provider/Consumer) ausführen.

1: Der Provider erstellt ein VPN-Config-Asset für die Konfigurationsdatei und legt dafür eine Policy sowie eine Vertragsdefinition fest.

### Asset erstellen
- Provider-Seite

```curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @asset-vpn-config.json "http://provider_ip:9191/api/v1/management/assets"```
`
2: Der Provider nutzt das Management-API, um die Policy und die Vertragsdefinition für das VPN-Config-Asset bereitzustellen.

### Policy erstellen

```curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @../policydefinition.json "http://provider_ip:9191/api/v1/management/policydefinitions"```

### Contractdefinition erstellen

```curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @contractdefinition.json "http://provider_ip:9191/api/v1/management/contractdefinitions"
```


3: Der Consumer führt eine Katalogabfrage des Providers durch und alle verfügbaren Assets des Providers.

- Consumer-Seite
### Katalogabfrage von dem Consumer

```curl -X GET -H "Content-Type: application/json" -H "X-Api-Key: password" "http://provider_ip:9191/api/v1/management/assets/"```

4: Der Consumer fragt nach Details über das VPN-Config-Asset, woraufhin ihm die Policy und die Vertragsdefinition von dem Provider gesendet werden.

### Abfrage von einem bestimmten Asset

```curl -X GET -H "Content-Type: application/json" -H "X-Api-Key: password" "http://provider_ip:9191/api/v1/management/assets/id"```

5: Der Consumer überprüft die Policy und die Vertragsdefinition und akzeptiert sie. Dann schickt er ein Vertragsangebot an den Provider. Darüber hinaus erstellt der Consumer ein Asset, in dem er seinen Public Key veröffentlicht.

### Contractnegotiation/ Contractoffer
- Provider-Seite

```curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @contractoffer.json "http://Consumer_ip:9191/api/v1/management/contractnegotiations"```

### Publickey erstellen
- Consumer-Seite

curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @asset-vpn-config.json "http://Consumer_ip:9191/api/v1/management/assets"

6: Der Provider akzeptiert das Vertragsangebot, woraufhin eine Vertragsvereinbarung zustande kommt. Der Provider fügt das Public Key des Consumers in der Konfigurationsdatei hinzu.
### VPN-Konfiguration erstellen
- Provider-Seite
#### Katalogabfrage von dem Provider

```curl -X GET -H "Content-Type: application/json" -H "X-Api-Key: password" "http://Consumer_ip:9191/api/v1/management/assets/"```
#### Script ausführen
`
```bash WireguardService/neue-client.sh vpn-config```

7: Der Consumer kann nun über seine Control-plane das VPN-Config-Asset anfordern.
#### Datei übertragen
- Provider-Seite

```curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @filetransfer.json "http://Consumer_ip:9191/api/v1/management/transferprocess"```
 
8: Der Consumer empfängt die VPN-Konfigurationsdatei, fügt sein privat-key hinzu und führt sein Skript aus aus. Dadurch wird eine VPN-Verbindung aufgebaut.
### VPN-Verbindungsaufbau
- Consumer-Seite

```bash consumer_company/vpnconfig.sh```

Diese Schritte zeigen, wie ein Datenaustausch im Datenraum abläuft und wie eine VPN-Verbindung zwischen Teilnehmern des Datenraums aufgebaut werden kann.
