package proyect.imc;

/**
 * Created by Stree on 29/03/2017.
 */

public class calculoIMC {

    double peso;
    double estatura;
    public  double resul;
    public calculoIMC(double peso, double estatura) {

        this.peso=peso;
        this.estatura= estatura;
    }

    public void calcular()
    {

        resul =   (peso / ((estatura) *(estatura)));
    }

}
