import { Moto } from "./classe/moto.js";
import { Voiture } from "./classe/voiture.js";


const kangoo = new Voiture("Renault","Kangoo","240000","2003","Climatisée");
const moto = new Moto("BMW","R1150R Rockster","65000","2005");


const result = document.querySelector("#result")

result.innerHTML = kangoo.display();
result.innerHTML += "<br>"
result.innerHTML += moto.display();