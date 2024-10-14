// Les décorateurs TS permettent d'ajouter des comportements supplémentaires à des classes, propriétés ...
// Ils sont souvent utilisés dans des frameworks comme Angular, pour gérer des aspects tels que l'injection de dépendances
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
// Les décorateurs sont en format experimentale dans TypeScript, donc il faut activer les décorateurs dans 
// votre configuration (tsconfig.json)
// {
//     "compilerOptions": {
//       "experimentalDecorators": true,
//       "emitDecoratorMetadata": true
//     }
// }
function LogClass(constructor) {
    console.log(`Class : ${constructor.name} est instanciée !`);
}
let Person = class Person {
    constructor(name) { }
};
Person = __decorate([
    LogClass,
    __metadata("design:paramtypes", [String])
], Person);
let person = new Person("Alice");
let person2 = new Person("Toto");
