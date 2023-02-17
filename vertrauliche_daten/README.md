# Kommunkation im Datenraum

## Wichtig

Bevor Sie mit den folgenden Schritten beginnen, müssen Sie sicherstellen, dass Sie alle anderen notwendigen Konfigurationen vorgenommen haben und der Datenraum ordnungsgemäß läuft. Weitere Informationen dazu finden Sie in den Readme-Dateien unter /VPN_In_EDC_Datenraum, /consumer_company und /provider_company.

Führen Sie nun die unten stehenden Befehle aus und stellen Sie sicher, dass Sie die richtigen Befehle auf der entsprechenden Seite (Provider/Consumer) ausführen.
Achten Sie auf den richtigen Pfad zu sein

1: Der Provider erstellt ein VPN-Config-Asset für die Konfigurationsdatei und legt dafür eine Policy sowie eine Vertragsdefinition fest.

### Asset erstellen
- Provider-Seite

```shell
curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @asset-sensible-daten.json "http://provider_ip:9191/api/v1/management/assets"
```
`
2: Der Provider nutzt das Management-API, um die Policy und die Vertragsdefinition für das VPN-Config-Asset bereitzustellen.

### Policy erstellen

```shell
curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @../policydefinition.json "http://provider_ip:9191/api/v1/management/policydefinitions"
```

### Contractdefinition erstellen

```shell
curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @contractdefinitionsensibledaten.json "http://provider_ip:9191/api/v1/management/contractdefinitions"
```


3: Der Consumer führt eine Katalogabfrage des Providers durch und alle verfügbaren Assets des Providers.

- Consumer-Seite
### Katalogabfrage von dem Consumer

```shell
curl -X GET -H "Content-Type: application/json" -H "X-Api-Key: password" "http://provider_ip:9191/api/v1/management/assets/"
```

4: Der Consumer fragt nach Details über das asset-sensible-daten, woraufhin ihm die Policy und die Vertragsdefinition von dem Provider gesendet werden.

### Abfrage von einem bestimmten Asset

```shell
curl -X GET -H "Content-Type: application/json" -H "X-Api-Key: password" "http://provider_ip:9191/api/v1/management/assets/id"
```

5: Der Consumer überprüft die Policy und die Vertragsdefinition und akzeptiert sie. Dann schickt er ein Vertragsangebot an den Provider.

### Contractnegotiation/ Contractoffer
- Provider-Seite

```shell
curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @contractoffer_sensibledaten.json "http://Consumer_ip:9191/api/v1/management/contractnegotiations"
```


7: Der Consumer kann nun über seine Control-plane das VPN-Config-Asset anfordern.
#### Datei übertragen
- Provider-Seite

```shell
curl -X POST -H "Content-Type: application/json" -H "X-Api-Key: password" -d @filetransfer.json "http://Consumer_ip:9191/api/v1/management/transferprocess"
```
 
8: Der Consumer empfängt die sensiblen Daten.
### Die Datei oder der Inhalt befindet sich auf den angegebenen ngnix-Endpunkt


Diese Schritte zeigen, wie ein Datenaustausch im Datenraum abläuft und wie eine VPN-Verbindung zwischen Teilnehmern des Datenraums aufgebaut werden kann.