package Class_Java;

import java.util.ArrayList;


public class Panier
{

	ArrayList<LignePanier>  lignesPanier;

    public Panier()
    {
    	  lignesPanier = new ArrayList<LignePanier>();
    }

    @Override
    public String toString()
    {
        String s = "Panier : \n";
        for (LignePanier l : lignesPanier)
        {
            s += l.toString() + "\n";
        }

        return s;

    } 

    
    
    public void addArticle(Book art)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getBook().getIdBk() == art.getIdBk())
            {
                lignePanier.setQuantite(lignePanier.getQuantite() + 1);
                return;
            }
        } 

        lignesPanier.add(new LignePanier(art, 1));
    }

    
    
    
    public void sousArticle(Book book)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getBook().getIdBk()== book.getIdBk())
            {
                if (lignePanier.getQuantite() > 1)
                {
                    lignePanier.setQuantite(lignePanier.getQuantite() - 1);
                } else
                {
                    lignesPanier.remove(lignePanier);
                    return ;
                }
            }
        }


    }
    
    
    
    

    public int getNumberArticle()
    {
        return lignesPanier.size();
    }

    
    
    
    
    
    public ArrayList<LignePanier> getLignesPanier()
    {
        return lignesPanier;
    }

    
    
    
    public void removeArticle(Book book)
    {
        for (LignePanier lignePanier : lignesPanier)
        {
            if (lignePanier.getBook().getIdBk() == book.getIdBk())
            {
                lignesPanier.remove(lignePanier);
                return ;
            }
        }

    }
    
    
    
    
    public void vider()
    {
        try
        {

            while (lignesPanier.get(0) != null)
            {
                lignesPanier.remove(lignesPanier.get(0));
            }

        } catch (Exception e)
        {
        }
               
    }
}

