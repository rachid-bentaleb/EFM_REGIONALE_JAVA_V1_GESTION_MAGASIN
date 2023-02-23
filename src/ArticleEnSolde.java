import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArticleEnSolde extends Article{

    int remise;

    // constractor
    ArticleEnSolde(int code, double prix,int remise) {
        super(code, prix);
        this.remise = remise;
    }


    // getter and setter
    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) throws Exception {
        Pattern pa = Pattern.compile("[0-9]",Pattern.LITERAL);
        Matcher ma = pa.matcher(String.valueOf(remise));

        if(!ma.find()){
            throw new Exception("la remise est invalide");
        }else{
            this.remise = remise;
        }
    }

    // redefinition de la methode prixArticle
    @Override
    public double prixArticle() {
        return (getPrix()*remise)/100;
    }

    // methode toString
    @Override
    public String toString() {
        return super.toString() + "; remise = " + remise ;
    }
}
