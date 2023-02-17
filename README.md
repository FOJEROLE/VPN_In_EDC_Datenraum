# VPN_In_EDC_Datenraum

Dieses Dokument beschreibt die Implementierung eines Datenraums mithilfe der Eclipse Dataspace-Komponenten und die Erstellung einer VPN-Verbindung zwischen zwei Teilnehmern, um die Sicherheit bei der Datenübertragung zu erhöhen. Die erforderlichen Komponenten für den Datenraum sind der Eclipse Dataspace Connector, der Identitätsprovider (DAPS) sowie zwei Connectoren für jeweils eine Firma. Zur Durchführung der Tests wurde eine Testumgebung bestehend aus drei virtuellen Ubuntu-Maschinen verwendet.

## Wichtig

Sie müssen den Nginx-Endpunkt beide Seite konfigurieren,
Die minimale Konfiguration finden Sie in dem jeweiligen Verzeichnis  

## Bemerkung

Diese Dokumentation basiert auf der Eclipse-Dokumentation, die unter folgendem Link verfügbar ist: [https://github.com/eclipse-edc/Connector].

# Szenarien

Es wird vor allem ein Datenraum aufgebaut, auf dem ein sicherer und souveräner Datenaustausch stattfinden soll. Danach wird dieser Datenraum genutzt, um eine VPN-Verbindung zwischen einem Datenprovider und einem potentiellen Daten-Consumer herzustellen. Das VPN-Protokoll, das hier genutzt wird, ist Wireguard, da es Open Source ist und eine hohe Performance und Sicherheit gewährleistet.

Das erste Szenario wird wie folgt ablaufen: Der Provider erstellt zwei Assets: "Vertrauliche Daten" und "VPN-Config". "Vertrauliche Daten" enthält eine Bedingung, dass die Daten vertraulich sind und ein VPN-Tunnel aufgebaut werden muss. Der Provider veröffentlicht ein weiteres Asset für die Erstellung des Tunnels. Dieses Asset beinhaltet eine VPN-Konfigurationsdatei und ist mit einer Policy und Contractdefinition verbunden, die über die Management-API veröffentlicht werden.

Ein Consumer, Teilnehmer des Datenraums, zeigt Interesse an der VPN-Konfiguration und startet eine Vertragsverhandlung mit dem Provider. Nach einer erfolgreichen Verhandlung und Akzeptanz der Policy und Contractdefinition wird eine Vertragsvereinbarung im Control-Plane getroffen. Der Control-Plane überträgt nun das Asset an den Data-Plane, der die Übertragung durch ein Provider-Push-Modell über HTTP-Erweiterung durchführt. Der Consumer erhält die VPN-Konfigurationsdatei an seinem angegebenen Nginx-Endpunkt.

Im zweiten Szenario wird folgendes ablaufen: Mit einer erfolgreichen Konfiguration des VPN-Tunnels kann das Asset "Vertrauliche Daten" gebucht werden. Der Consumer startet eine Vertragsverhandlung mit dem Provider. Nach einer erfolgreichen Verhandlung und Akzeptanz der Policy und Contractdefinition wird eine Vertragsvereinbarung im Control-Plane getroffen. Die Übertragung der vertraulichen Daten zwischen Provider und Consumer kann nun stattfinden. Über einen Wireguard VPN-Tunnel kann eine sichere Übertragung gewährleistet werden. Die vertraulichen Daten befinden sich weiterhin auf dem Nginx Webserver des Providers und sind nur über das VPN zugreifbar und übertragbar. So wird sichergestellt, dass die Daten wirklich vertraulich bleiben und nur für die beiden Teilnehmer zugänglich sind.

Das Ziel ist am Ende: Mit der Verwendung von VPN, DAPS und Eclipse Dataspace Connector wird ein sicherer Datenraum aufgebaut, in dem vertrauliche Daten zwischen Provider und Consumer sicher übertragen werden können.

# Konfiguration der Identität Provider(DAPS)

Dieser Launcher enthält alle Erweiterungen, die für eine IDS Connector-Bereitstellung erforderlich sind. Dazu gehört die Kommunikation über ein IDS-Protokoll, derzeit IDS Multipart Messages, sowie die Nutzung eines IDS DAPS als Identity Provider.

## Voraussetzungen

Da der in diesem Launcher definierte Connecto eine Verbindung zu einem IDS-DAPS herstellt, ist ein aktives und erreichbares DAPS erforderlich, damit der Konnektor über das IDS-Protokoll kommunizieren kann. Außerdem benötigen wir ein gültiges Zertifikat (befindet sich in einem Schlüsselspeicher, z. B. .p12Format), das von diesem DAPS bereitgestellt wird und mit dem der Connektor eindeutig identifiziert werden kann.

## Konfiguration von DAPS

Die Originaldokumentation für den DAPS-Server befindet sich auf GitHub in [https://github.com/International-Data-Spaces-Association/omejdn-daps] und [https://github.com/eclipse-edc/Connector/tree/main/launchers/ids-connector].

Für dieses Projekt muss nichts mehr konfiguriert werden, aber folgende Schritte wurden bereits durchgeführt:

1. Überprüfen Sie das Omejdn DAPS-Repository. Dieses Repository erklärt die Prinzipien eines DAPS-Servers und wie er funktioniert.

2. Generieren Sie einen Schlüssel und ein Zertifikat für die DAPS-Instanz:
 openssl req -newkey rsa:2048 -new -nodes -x509 -days 3650 -keyout keys/omejdn/omejdn.key -out daps.cert
Wie bereits erklärt, wird keine Zertifizierungsstelle verwendet, deshalb wird das DAPS-Zertifikat selbst erstellt.

3. Ändern Sie im Projektstamm die .env-Datei. Legen Sie den Wert von DAPS_DOMAIN auf die URL fest, unter der Ihre DAPS-Instanz ausgeführt wird. Die .env-Datei enthält die Konfigurationen des DAPS-Servers.

4. Registrieren Sie einen Connector (das Sicherheitsprofil ist optional und wird standardmäßig auf idsc:BASE_SECURITY_PROFILE gesetzt, wenn es nicht angegeben wird):

 ```shell
 scripts/register_connector.sh <client-name-for-connector> <security-profile>
 ```
Nach der Registrierung des Connectors werden zwei Dateien (ein Schlüssel .key und ein Zertifikat .cert) erstellt und im Verzeichnis keys gespeichert.

5. Erstellen Sie einen Keystore, der beide Dateien speichert:
```shell
openssl pkcs12 -export -in keys/<client-name>.cert -inkey keys/<client-name>.key -out <client-name>.p12
```  
Das resultierenden Schlüsselspeicher (Keystore) hat das Zertifikat den Alias 1.

6. Senden Sie den Keystore an den Connector:

```shell
scp omejdn-daps/keystor.p12 user@xxx.xxx.xxx.xxx:/home/remote_dir
```

7. Optional können weitere Connectors registriert werden, indem Schritt 5 mehrmals mit unterschiedlichen Clientnamen durchgeführt wird.

8.  Führen Sie den DAPS aus:
 ```shell
 bash docker compose -f compose.yml up
 ```

9. Wenn Sie in den Logs omejdn-server_1 | == Sinatra (v2.1.0) has taken the stage on 4567 for development with backup from Thin sehen, ist der DAPS bereit, Anfragen anzunehmen. Die URL, unter der der Konnektor das DAPS erreichen kann, ergibt sich aus <http://localhost:80> (kann aber in der .env-Datei geändert werden), die von NGINX in der docker-compose-Datei verwendet wird.

# Konfiguration von Connectoren

Die Connectoren befinden sich jeweils im Verzeichnis Consumer_company für den Consumer und Provider_company für den Provider. Die Connectoren sind schon konfiguriert und können geklont und ausgeführt werden, aber jeweils auf verschiedenen virtuellen Maschinen.

Hier ein paar grundlegende Konfigurationen:

Der Connector, der hier benutzt wird, ist ids-launchers aus dieser Repository: [https://github.com/eclipse-edc/Connector/tree/main/launchers/ids-connector].
Wir haben für das Projekt unsere build.gradle.kts-Datei folgendermaßen konfiguriert:

```shell
// in build.gradle.kts:
    implementation(project(":core:control-plane:control-plane-core"))
    implementation(project(":core:data-plane-selector:data-plane-selector-core"))
    implementation(project(":core:data-plane:data-plane-core"))
    
    implementation(project(":data-protocols:ids"))

    implementation(project(":extensions:common:configuration:configuration-filesystem"))
    implementation(project(":extensions:common:vault:vault-filesystem"))

    implementation(project(":extensions:common:iam:oauth2:oauth2-service"))
    implementation(project(":extensions:common:iam:oauth2:oauth2-daps"))

    implementation(project(":extensions:control-plane:api:management-api"))

    implementation(project(":extensions:common:auth:auth-tokenbased"))
    
    implementation(project(":extensions:control-plane:transfer:transfer-data-plane"))
    
    implementation(project(":extensions:common:api:api-observability"))
    
    implementation(project(":extensions:data-plane:data-plane-http"))
    implementation(project(":extensions:data-plane-selector:data-plane-selector-client"))
```

- Dazu sind ein paar Konfigurationen für manche Module erforderlich. Diese Konfigurationen sind in config.properties der jeweiligen Connector zu finden. Um mehr Details über die Konfiguration zu haben, schauen Sie sich die Repository an, und zwar den Abschnitt "Configuration": [https://github.com/eclipse-edc/Connector/tree/main/launchers/ids-connector].
Die oben genannte Konfiguration ist schon in diesem Projekt gemacht, aber für mehr Infos schauen Sie sich gerne die originale Repository an.

# Connectoren ausführen

Nachdem die Konfiguration angepasst wurde, können Sie den Launcher ausführen, um den Connector lokal auszuführen. Dabei müssen einige zusätzliche Eigenschaften als Systemeigenschaften bereitgestellt werden:

- edc.fs.config: Pfad zur config.properties-Datei.
- edc.vault: Pfad zur vault.properties-Datei (erforderlich für die vault-fs-Erweiterung, kann so eingestellt werden, dass er auf die config.properties-Datei zeigt).
- edc.keystore: Pfad zum Keystore.
- edc.keystore.password: Passwort für den Keystore.
Führen Sie die folgenden Befehle aus:

Auf der Provider-VM:

```shell
./gradlew clean :launchers:ids-connector:build
java -Dedc.fs.config=/VPN_In_EDC_Datenraum/provider_company/provider_connector/launchers/ids-connector/config.properties \
    -Dedc.vault=/VPN_In_EDC_Datenraum/provider_company/provider_connector/launchers/ids-connector/config.properties \
    -Dedc.keystore=/VPN_In_EDC_Datenraum/provider_company/provider_connector/launchers/ids-connector/connector02.p12 \
    -Dedc.keystore.password=123456 \
    -jar launchers/ids-connector/build/libs/dataspace-connector.jar
```

- Auf der Consumer-vm


```shell
./gradlew clean :launchers:ids-connector:build
java -Dedc.fs.config=/VPN_In_EDC_Datenraum/consumer_company/consumer_connector/launchers/ids-connector/config.properties \
    -Dedc.vault=/VPN_In_EDC_Datenraum/consumer_company/consumer_connector/launchers/ids-connector/config.properties \
    -Dedc.keystore=/VPN_In_EDC_Datenraum/consumer_company/consumer_connector/launchers/ids-connector/connector01.p12 \
    -Dedc.keystore.password=123456 \
    -jar launchers/ids-connector/build/libs/dataspace-connector.jar
```

## Wichtig

Passen Sie die Pfade an, wenn nötig.
## Weitere Schritte

Jetzt haben wir unser Datenraum aufgebaut. Um das VPN-Tunnel zwischen dem Provider und Consumer aufzubauen. folgen Sie die Schritte in [README.md](/vpn-config/README.md).

Schließlich folgen Sie die Schritte in [README.md](/vertrauliche_daten/README.md), um die vertraulichen Daten zu senden.
