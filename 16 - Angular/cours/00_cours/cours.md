## Les commandes de bases

- Installer Angular : 

```bash
npm install -g @angular/cli
```

- Création d'un nouveau projet :

```bash
ng new <nom_projet>
```

- Récupération d'un projet existant :
    - Installer les dépendances avec `npm install` ou `npm i`

- On lance le serveur avec `npm start` ou `ng serve`

- Création d'un nouveau composant
 pour eviter de créer de fichier de test (spec.ts), il faut ajouter l'option `--skip-tests`
```bash
ng g c dossier/nom-composant
```

## L'interpolation

C'est le fait d'interpréer du js dans le template. Pour ça, on utilise les balises `{{}}`. 
On peut afficher n'importe quelle expressions js tant qu'elle retourne quelque chose.

## Data Binding :

Permet d'interpréter du js dans les attributs HTML. On peut interpréter du js dans n'importe quel attribut HTML à condition de mettre l'atribut entre crochets

```angular2html
<img [src]="nom_variable">
```

## Le router

Pour créer des "routes", on les définit dans le fichier `app.routes.ts` sous la forme d'un objet qui contient
un path (le chemin dans l'url) et le composant à afficher.

```ts
export const routes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'blocks', component: BlocksComponent}
];
```

On peut ensuite créer des liens vers ces routes avec l'attribut `routerLink`

```angulat2html
<a routerLink="/">Home</a>
```

## Les pipes

Les pipes sont des fonctions qui prennent en valeur une entrée, et qui retourne la valeur transformée.
Il y a des pipes pour le texte `uppercase`, `lowercase`, `titlecase`

## Les formulaires

2 types en Angular : 
    - Template Driven Form
    - Reactive Forms

Les états de formControl :
    - valid -> respecte tous les validators
    - invalid -> ne respecte au moins un des validators
    - touched -> le champs a déjà perdu le focus
    - untouched -> le champs n'a jamais perdu le focus
    - dirty -> le champs a déjà reçu une intéraction
    - pristine -> le champs n'a jamais reçu d'intéraction.

Dans le formulaire réactif, on peut retrouver 3 classes principales :

- formControl : pour les données simples (boolean, string, number)
- formGroup : pour manipuler les objets.
- formArray : pour manipuler des tableaux