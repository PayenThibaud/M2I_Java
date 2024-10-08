console.log("Exercice 17")


const ask = (question, yes, no) => {
    if (confirm(question)) 
        yes();
    else 
        no();
}
ask("Do you agree?", () => alert("You agreed."), () => alert("You canceled the execution."));

// solution obrayan

const ask2 = (question,yes,no) => confirm(question) ? yes() : no();

ask2("Do you agree?", () => alert("You agreed."), () => alert("You canceled the execution."));