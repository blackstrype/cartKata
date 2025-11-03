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