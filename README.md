#Checklista för Godkänt

## Klientkomponenten:

- Klientkomponenten ska vara ett textbaserat gränssnitt (CLI)
- Användaren ska kunna lista/lägga till/redigera/ta bort blogginlägg via API- förfrågningar till serverkomponenten
- Användaren ska kunna lista alla inlägg (ID och titel visas)
-  Användaren ska kunna efterfråga ett specifikt inlägg och läsa innehållet Ingen information ska sparas i klienten
- Om användaren försöker visa, ta bort, redigera eller ändra ett inlägg som inte finns ska det visas ett tydligt felmeddelande
- Din kod ska sparas i versionshantering med Git

***

- [x] Skapa 4 .java klasser i ett paket
- [x] Klass: BlogApiClientApplication (Main-metod)
  - denna klassen innehåller main-metoden för att kunna starta programmet

- [x] Klass: BlogPost (Objekt)
  - denna klassen styr hur ett blogginlägg är uppbyggt, detta med attribut och inkapsling samt ToString metoder för utskrift

- [x] Klass: BlogProgram (Gränssnitt, CRUD)
  - denna klass ska innehålla användargränssnittet och skapa ett nytt objekt av APIklienten med http adressen den ska skicka förfrågningar till
  - Användaren ska kunna skapa ett blogginlägg (DONE)
  - Användaren ska kunna lista ett specifikt blogginlägg med ID (DONE)
  - Användaren ska kunna lista alla blogginlägg (DONE)
  - Användaren ska kunna uppdatera/redigera ett blogginlägg
  - - Användaren ska kunna rensa hela listan med blogginlägg

- [x] Klass: BlogClient (Klienten)
    - denna klassen styr hur och vart förfrågningarna skickas.
  
***


