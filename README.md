# programmieraufgabe-autohaus

## Aufgabestellung

Die Firma XY besitzt mehrere Autohäuser an verschiedenen Standorten und muss bisher die Autos mühsam in einem Excel File pflegen. Damit sie es in Zukunft einfacher hat, erstellt die Firma Z eine App für sie, wo sie ihre Autos und Autohäuser pflegen können.

## Aufgaben

Sie sind bei der Firma Z für die Backend Entwicklung zuständig und haben folgenden Aufgaben bekommen:

1. Bilden Sie ein Autohaus in einer Java Klasse ab. Sie soll folgende Variablen enthalten:

	- Name
	- Strasse
	- Ort
	- PLZ
	- Weitere Felder, welche Sie für sinnvoll halten

2. Bilden Sie ein Auto in einer Java Klasse ab. Sie soll folgende Variablen enthalten:
	
	- Marke
	- Modell
	- PS
	- Weitere Felder, welche Sie für sinnvoll halten
	
3. Schreiben Sie ein Programm, womit man die Klassen testen kann (entweder durch JUnit tests oder durch Konsolen eingaben).

4. Das Programm sollte es ermöglichen, dass man die Autohäuser und Autos irgendwo abspeichern kann. Entweder in einer Datenbank oder als Text Files ineinem bestimmten Format (JSON, XML, TXT, etc.).

	- Variante Datenbank: Stellen Sie sicher, dass Sie odbc für die Kommunikation zur 	Datenbank verwenden. Die verschiedenen Tabellen müssen Sie noch anlegen.  
	Auf Ihrem Rechner soll bereits eine Datenbank in einem Docker Container laufen. Sie sollte mit URL, User und Passwort erreichbar sein.

	- Variante Text File: Sie können die Daten in einem beliebigen FOrmat abspeichern.  
	Achten Sie darauf, dass es möglich ist neue Daten zu speichern, ohne dass die alten verloren gehen.

5. <ins>Optional</ins>: Falls Sie genug Zeit haben, programmieren Sie eine Funktion, um ein Auto von einem Autohaus ins andere Autohaus zu verschieben.
