# IUTO INVADERS

Ceci est un projet de l'équipe enseignante de l'IUT d'Orleans 
donné aux étudiants de la promotion Année Spéciale 2016-2017.
 
Il s'agit d'une version du jeu eponyme Space Invaders 
en ASCII art

## DEVELOPPEMENT

### CHOIX DE DEVELOPPEMENT

J'ai décidé de changer la structure donnée par l'énoncé car,
 bien qu'adaptée a l'apprentissage de la POO, je la trouvais 
 trop restrictive et je me sentais capable de la depasser.
 
 JavaFX est basé sur un modele MVC et comme je l'avais abordé en cours
 j'ai décidé de m'y interesser
 
 J'ai aussi décidé d'integrer trois fonctionalités issues de
 [codes source externes](doc/SOURCES.md) qui 
 necessitaient ces changements.
 
## STRUCTURE

- README.md : ce fichier.

- /doc
  - ASCII_art.txt : le fichier issu des sources du TD
  - POO.pdf : l'énoncé du projet
  
- /src
  - /game : fichiers source des elements du jeu
  - /gui : fichiers source des elements du GUI 
  - /img : images
  - /sfx : sons
  
  
## CODE SOURCE

### LES CLASSES DE /GAME

#### GestionJeu
#### ChainePositionnée
#### Dessin
###### HUD
###### Diaporama
###### Personnage
###### Vaisseau
###### Alien
###### Projectile
#### Score
#### Niveau


### LES CLASSES DE /GUI
#### Main
#### Game & Game.fxml
#### Splash & Splash.fxml
#### ScreensController
#### ControlledScreen
#### MPKEventHandler

### LES IMAGES
Je ne suis pas à 100% certain de la license de
tout le contenu graphique employé.

### LES SONS
Je ne suis pas à 100% certain de la licence de
tout le contenu sonore employé.

### BUGS CONNUS

- Après un mashing de F2, la vitesse globale du jeu augmente
- Les Aliens se déplacent en dehors du tableau
- Et ce bug arrivé une fois (plus de details dans /doc):

** (java:27254): WARNING **: Couldn't connect to accessibility bus: Failed to connect to socket /tmp/dbus-lWbHsJcxwK: Connexion refusée

