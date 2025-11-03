# telephoneKata
Kata réalisé le 2025/10/31 par Scott MESSNER

## Enoncé de l’exercice technique à réaliser :
Tu es un nouveau Développeur dans une société de vente de produit en ligne. La société vend trois types deproduits : des téléphones haut de gamme, des téléphones milieu de gamme et des ordinateurs portables.Ton Product Manager te demande de développer un programme permettant de calculer le panier d’unconsommateur.

Il existe deux types de clients :
1) Des clients particuliers identifiés par un id client, un nom et un prénom
2) Des clients professionnels identifiés par un id client, une raison sociale, un numéro de TVA intracommunautaire(qui est optionnel), un SIREN et un chiffre d’affaires annuel
    - Pour les particuliers, le modèle de téléphone haut de gamme coute 1500 euros, le milieu de gamme coûte 800euros et le laptop 1200 euros.
    - Pour les clients professionnels ayant un chiffre d’affaires supérieur à 10 millions d’euros, le modèle de téléphonehaut de gamme coûte 1000 euros, le moyen de gamme coûte 550 euros, et le laptop coûte 900 euros.
    - Pour les clients professionnels ayant un chiffre d’affaires inférieur à 10 millions d’euros, le modèle de téléphonehaut de gamme coûte 1150 euros, le milieu de gamme coûte 600 euros et le laptop coûte 1000 euros.

### Objective:
Calculez pour un client donné le coût de son panier, sachant que celui-ci pourra contenir les 3 produits enplusieurs exemplaires

## Notes de Réalisation
1) J'ai exploité Quarkus pour la mise en place du socle -- ce n'est pas nécessaire, mais c'est simple pour démarrer un projet parce que je connais bien et 99% du temps on va développer un API REST pour exposer nos fonctionalités et on va faire un Front avec un belle interface pour connecter notre client et choisir les produits pour notre panier.
2) J'utilise Gherkin/Cucumber pour défénir les tests - vu que l'énoncé est fonctionnellement non-ambigue et facilement convertible en test unitaire. Les plugins Cucumber d'IntelliJ rendre cela très intuitive et simple.
3) J'ai ajouté les suites JUnit 5 pour qu'on puisse lancer ces tests unitaires via maven - qui serait bien utile pour l'automatisation des test dans le CI/CD.
4) Les premiers tests de couverture vont démontrer que nous avons pas strictement respecté le TDD et que nous avons du code qui anticipe les futures evolutions (c'est non non dans le monde de craft). Néanmoins, c'est une raccourcie pragmatique intentionelle pour avancer vers les prochaines étapes sans étant trop scolaire.
5) Même remarque pour l'absence des features/scénarios pour les identifiants des client (id, raison sociale, numéro de TVA, SIREN) -- je n'ai pas encore écrit les tests pour cela.
6) Il y a une problematique avec l'expression du besoin -- Si on respecte tel que l'écrit un client avec un chiffre d'affaire d'exactement 10000000 n'est pas géré. Je prétends d'avoir discuté avec l'équipe fonctionelle pour corriger l'expression de besoin. Autrement on aurait pu corriger le code et le spec de sortir une exception pour le cas non-géré.
7) Determination de type de Client
   - L'enoncé de l'exercice indique les critères pour déterminer si un client est un Particulier ou un Professionel. J'estime qu'il y a suffisament d'ambiguïté sur l'interface et sur comment le Client est reçu à l'entrée du calcul.
   - Il est possible de recevoir une formulaire avec les informations pour pro/part tout confondu (nom, prénom, raison sociale, numéro TVA, SIREN, etc...) avec les éléments non-renseigné en null. Par contre si on fait comme ça, il reste la possibilité de recevoir les formulaires avec toute information toute renseigné et ensuite il faut décider est-ce un client pro ou un client part ? Cette ambiguïté risque de poser des problèmes sécurité/non-conformité fonctionnelle
   - Il est possible de recevoir explicitement un Client de type PART ou type PRO et construire soit un ClientPart soit un ClientPro. Si on fait comme ça il est important de savoir qu'un ClientPart ne peut pas devenir un ClientPro -- ils sont forcement deux identités séparés.
   - Il est possible de recevoir explicitement le Type de client, ayant la même object Client dans la base. Cela permet un Client PART de devenir un Client PRO plus tard si besoin. La solution actuelle est positionée mieux pour cette possibilité.
   - En bref: il est nécessaire de causer pour rendre le contrat d'interface (spécification) plus concrete sur le model du Client.
8) Gestion des prix des produits : A priori ces prix seront configurables ou stockés dans une base/index d'ailleurs.