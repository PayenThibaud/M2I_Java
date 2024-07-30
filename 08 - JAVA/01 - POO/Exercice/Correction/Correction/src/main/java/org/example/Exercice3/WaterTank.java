package org.example.Exercice3;

public class WaterTank {

    private float poidVide;
    private int capaciteTotal;
    /**
     * remplissage est le nombre de litre present dans ma citerne
     */
    private int remplissage = 0;

    private static int quantiteTotalReservoires;

    public WaterTank (float poidVide,int capaciteTotal){
        this.poidVide = poidVide;
        this.capaciteTotal = capaciteTotal;
    }
    /**
     * @param remplissage est le nombre de litre present dans ma citerne
     */
    public WaterTank (float poidVide,int capaciteTotal,int remplissage){
        this(poidVide,capaciteTotal);
        this.remplissage = remplissage;
    }

    public float poidTotal (){
        return poidVide + remplissage;
    }

    private void setRemplissage (int quantite){
        quantiteTotalReservoires -= this.remplissage;
        this.remplissage  = quantite;
        quantiteTotalReservoires += remplissage;
    }

    public int remplir(int quantite){
        if(quantite<0){
            quantite = 0;
        }

        if(remplissage+quantite <= capaciteTotal){
            setRemplissage(remplissage+ quantite);
            return 0;
        }
        else{
            int excedent = remplissage + quantite - capaciteTotal;
            setRemplissage(capaciteTotal);
            return excedent;
        }
    }

    public int vider (int quantite){
        if(quantite < 0){
            quantite = 0;
        }

        if(remplissage - quantite < 0){
            int eauRecup = remplissage;
            setRemplissage(0);
            return eauRecup;
        }else{
            setRemplissage(remplissage - quantite);
            return quantite;
        }
    }

    public static int getAllQuatityFronWaterTank(){
        return quantiteTotalReservoires;
    }

    public void affichageCiterne()
    {
        String[][] citerneAscii = {
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│            │",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
                {"┌──────O─────┐",
                        "│~~~~~~~~~~~~│",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "│            │",
                        "└────────────┘"},
        };
        int niveauCiterne = this.remplissage == 1 ? 1 : Math.round((float) (this.remplissage * 8) / this.capaciteTotal);
        System.out.println(niveauCiterne);
        for (int i = 0; i < 10; i++)
        {
            System.out.println(citerneAscii[niveauCiterne][i]);
        }
    }



}
