# CSS

## Cascade

Le style qui va être appliqué à un élément HTML va dépendre de plusieurs critères:

1. Position et ordre d'apparence
   Le fait que la règle soit placée après dans mon CSS fait que le style sera appliqué en priorité

   ```css
   p {
     color: red;
   }

   /* c'est le dernier style qui est appliqué */
   p {
     color: blue;
   }
   ```

   1. attribut `style`
   2. balise style `<style>`
   3. import de fichier css avec `link`

2. Spécificité
   Le style de sélecteur spécifique sera appliqué

```css
/* c'est ce style qui sera appliqué à l'élément */
#id {
  color: red;
}

.id {
  color: blue;
}
```

3. Origin du CSS: le fait que le style vienne de l'origine du site ou d'une origine extérieure (via un CDN)
4. Importance de la règle avec l'utilisation du mot clé `!important` sur les propriétés (à proscrire)

## Unité de valeur en CSS

1. Numéros
   Nombre que l'on peut utiliser sans unité de valeur

   ```css
   line-height: 1.5;
   ```

2. Pourcentage: `width: 50%` valeur calculée par rapport à l'élément parent

3. Longueur absolues

   - cm
   - mm
   - Q: quart de millimètre
   - in: pouces
   - pc: pics
   - pt: points
   - px: pixels

4. Longueur relative
   Valeur calculée par rapport à une valeur de base, comme pourrait le faire le pourcentage.

   - ch: taille d'un caractère d'une police par rapport au caractère `0` de cette police
   - rem: taille de la police de l'élément racine (HTML) qui vaut par défaut 16px
   - em: rapport à la taille de l'élément parent

5. Unités relatives à la fenêtre d'affichage

- vw: view weight, 1vw correspond à 1% de la largeur de la fenêtre
- vh: view height, 1vw correspond à 1% de la hauteur de la fenêtre

![longueur avancées](dvh-lvh-svh.jfif)

6. Unité d'angles
   -deg: Valeur en degré, exemple `transform: rotate(30deg)`
