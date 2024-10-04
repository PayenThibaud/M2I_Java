let tempEau = parseInt(prompt("Temperature de l eau ?"));

alert(tempEau < 0 ? "solide" : tempEau < 100 ? "liquide" : "gazeux");