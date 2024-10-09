// Une fonction pouvant traiter le bon type de paramètre peut être assignée en tant que callback d'une 
// fonctionnalité .addEventListener(), qui rappellons le, prend en premier paramètre le nom de l'évènement, 
// et en second la fonctionnalité à effectuer
// lors de la levée de l'évènement. 

function myFunc(event) {
    console.log("Hello world!");
  }

  // Pour effectuer une fonctionalité qui peut prendre un certain temps à s'effectuer, 
// il faut utiliser ce que l'on appelle une promesse

// Une promesse est un objet Javascript qui va avoir en paramètre du constructeur une fonction 
// devant traiter deux paramètres (ces deux paramètres seront de type callback)

// Le premier paramètre sera la résolution de notre promesse, alors que le second sera la callback de gestion de l'erreur. 
// Souvent, on voit ainsi en paramètre de notre constructeur une fonction anonyme traitant 'resolve' et 'reject'

function doLongTask() {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
          let random = Math.random()
          console.log(random)
        if (random > 0.5) {
           // Pour marquer la fin de la promesse, on va provoquer la fonction resolve
          resolve("Tout s'est bien passé")
        } else {
          reject(new Error("Il y a eu une erreur !"))
        }
      }, 5000)
    })
  }

  // Il est aussi possible de faire une promesse qui traitera un paramètre d'entrée, 
// dans le but de potentiellement enchainer les promesses.

function doLongTaskB(param) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve(param + ", with something added!")
      }, 3000)
    })
  }

  function logResult(result) {
    console.log(result);
  }
  
  function logError(result) {
    console.error(result);
  }

  document.querySelector("#myButtonA").addEventListener('click', () => {
    // Pour réaliser des instructions seulement à la résolution de la promesse
    // il nous faut utiliser les méthodes .then() et .catch() sur une promesse
    //
    // Le .then() servira à réaliser la fonctionnalité lors de la résolution positive de la promesse
    // La .catch() servira à réaliser la fonctionnalité lors de la résolution négative de la promesse, 
    // souvent pour gérer l'erreur et ne pas bloquer le programme
    doLongTask()
    .then(logResult)
    .catch(logError)
  
  
    console.log("clique A");
  })

  document.querySelector("#myButtonB").addEventListener('click', () => {

    // Dans le cas où l'on veut chainer les promesses, il nous faut utiliser plusieurs .then()
    //
    // Le .catch() sera de son côté commun à tous les .then()
    doLongTask()
    .then(res => {
      doLongTaskB(res)
      .then(res => {
        console.log(res);
      })
    })
    .catch(err => {
      console.error(err);
    })
  
    // doLongTaskB("Blabla")
    // .then(res => {
    //   console.log(res);
    // })
  
    console.log("Je suis lancé");
    console.log("Du texte");
  })

  // syntaxe async
async function myAsyncFunc() {

}

document.querySelector("#myButtonC").addEventListener('click', async () => {

    // Depuis l'ECMAScript 6 (ES6), il est possible d'utiliser les mots-clés 'async' et 'await' pour réaliser des fonctionnalités
    // asynchrone dans une fonction. Il sera possible d'utiliser le mot-clé 'await' seulement si la fonction porte le mot-clé 'async'. 
    // Dans le cas contraire, on aura une erreur de Runtime
  
    // Pour gérer les erreurs, il faut cependant, vu que l'on n'a plus accès à .then() et .catch(), utiliser un bloc TRY...CATCH
  
    // La partie TRY servira à y placer toutes les instructions qui peuvent poser problème et envoyer des erreurs
    // La partie CATCH servira de son côté à gérer une erreur et pouvoir si l'on veut la logguer, l'envoyer par mail, etc...
  
    try {
      let result = await doLongTask();
      console.log("Etape 1 finie !");
      let resultB = await doLongTaskB(result);
      console.log("Etape 2 finie !");
      console.log(resultB);
    } catch (error) {
      console.error(error);
    }
  })
  
  