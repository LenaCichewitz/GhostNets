# GhostNets

Um das Projekt zu kompilieren, muss die Datenbank ghost_net_db angelegt und die beiliegende Datei ghost_net_db.sql importiert werden.

Zusätzlich muss der tomtom.apikey in der application.properties gesetzt werden. 
Hier kann entweder ein neuer Schlüssel auf der TomTom API-Seite generiert oder der Schlüssel aus der Dokumentation verwendet werden.

Sobald diese Schritte abgeschlossen sind, kann die Anwendung über Maven auf
einem Apache Tomcat-Server gestartet werden. Nach dem Import der .sql-Datei kann man sich als 'bergender' 
Benutzer mit den folgenden Anmeldedaten einloggen: root, root oder berger, berger.