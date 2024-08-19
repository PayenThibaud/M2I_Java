### Sujet de TP : Conception d'un simulateur de politique fiscale avec le pattern Strategy

#### Contexte
Vous travaillez pour un think tank économique qui développe des outils de simulation pour analyser l'impact des différentes politiques fiscales sur des économies modélisées. Le simulateur doit être capable de tester différentes stratégies fiscales (comme des impôts progressifs, proportionnels, ou des taxes sur la consommation) pour prévoir leurs effets sur la répartition des revenus et la croissance économique.

#### Objectif du TP
Développer un simulateur flexible qui utilise le pattern Strategy pour permettre la modification dynamique des règles fiscales selon les scénarios de politique économique étudiés.

#### Fonctionnalités à Implémenter

1. **Définition de la Stratégie Fiscale :**
    - Permettre aux utilisateurs (économistes, décideurs) de choisir parmi différentes stratégies fiscales à appliquer dans le modèle économique.

2. **Implémentation des Stratégies Fiscales :**
    - Développer différentes classes concrètes de stratégies pour chaque type de fiscalité (impôt sur le revenu progressif, TVA, impôt forfaitaire, etc.).
    - Chaque stratégie doit implémenter une interface commune `TaxStrategy` qui définit la méthode `calculateTax(Income)`, où `Income` représente les revenus des agents économiques dans le modèle.

3. **Simulation et Résultats :**
    - Créer un environnement de simulation où les stratégies fiscales peuvent être testées et où les résultats peuvent être affiché




```
========================================================
     SIMULATEUR DE POLITIQUE FISCALE - MENU PRINCIPAL
========================================================

Veuillez choisir une option :
1. Sélectionner la stratégie fiscale et lancer la simulation
2. Quitter

Votre choix: _
```

```
========================================================
   SÉLECTION DE LA STRATÉGIE FISCALE ET SIMULATION
========================================================

Choisissez une stratégie fiscale pour la simulation :
1. Impôt progressif sur le revenu
2. TVA (Taxe sur la valeur ajoutée)
3. Impôt forfaitaire

Votre choix: _
```


```
Vous avez choisi la stratégie de la TVA.
Entrez le taux de TVA (%): _
```

```
========================================================
   RÉSULTATS DE LA SIMULATION
========================================================

Recettes fiscales totales de la TVA : _ millions d'euros


Appuyez sur une touche pour revenir au menu principal...
```


