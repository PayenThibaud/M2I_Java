const maDate = new Date();

console.log(maDate);


//repeter une fonction tous les x millisecondes
// setInterval(()=> {
//     console.log("3 secondes plus tard")
//     console.log(new Date())
// },3000)


setTimeout(()=> {
    console.log("3 secondes plus tard")
    console.log(new Date())
},3000)


 // Realiser un timer
 const timer = document.querySelector("#timer");
 const btnIn = document.querySelector("#entrer");
 const btnOut = document.querySelector("#sortir");

 
 let inTime, outTime;
 let temps = 0;

 btnIn.addEventListener('click',()=> {
    inTime = new Date();
 })

 btnOut.addEventListener('click',()=> {
    outTime = new Date();
    alert((outTime-inTime)/1000)
 })