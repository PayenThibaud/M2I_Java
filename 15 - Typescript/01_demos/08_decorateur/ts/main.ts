// Les décorateurs TS permettent d'ajouter des comportements supplémentaires à des classes, propriétés ...
// Ils sont souvent utilisés dans des frameworks comme Angular, pour gérer des aspects tels que l'injection de dépendances

// Les décorateurs sont en format experimentale dans TypeScript, donc il faut activer les décorateurs dans 
// votre configuration (tsconfig.json)

// {
//     "compilerOptions": {
//       "experimentalDecorators": true,
//       "emitDecoratorMetadata": true
//     }
// }

/*
Types de décorateurs

1. Décorateurs de classes
2. Décorateurs de propriétés
3. Décorateurs de méthodes
4. Décorateurs de paramètres
*/

function LogClass(constructor: Function) {
    console.log(`Class : ${constructor.name} est instanciée !`);
}

@LogClass
class Person {
    constructor(name: string) {}
}

let person = new Person("Alice") // Affiche "Class : Person est instanciée !"
let person2 = new Person("Toto")