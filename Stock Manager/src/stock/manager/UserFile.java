/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.manager;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Julien
 */
public class UserFile extends Fichiers {
    
    List listLogin;
    final int COLUMN_Login=0;//Position de la colone Login dans le fichier CSV
    
    /**
     * Fonction qui lie la CSV Utilisateur
     */
    public UserFile ()
    {
        
        
        CSVReader readerLogin;//Lecture du CSV Utilisateur contenant les Login des utilisateurs
        try {
            readerLogin = new CSVReader(new FileReader("C:\\Users\\Julien\\Documents\\GitHub\\StockManager\\Stock Manager\\src\\stock\\manager\\CSVUtilisateur\\UtilisateurListe.csv"),';');
            this.listLogin = readerLogin.readAll();
        } catch (IOException ex) {
            Logger.getLogger(UserFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    /**
    * Fonction de test du Login pour savoir si celui-ci existe dans le fichier CSV
    * @param login
    * @return 
    */
    public boolean testExistenceLogin (String login)
    {
        boolean tesLoginResult = false;
             
        //Recherche du Login placé en paramètre dans le CSV
        for(Iterator it = listLogin.iterator(); it.hasNext();)
        {
            String[] row =(String[]) it.next();
            
            if(row[COLUMN_Login].equals(login))
            {
                tesLoginResult = true;
            }
        }
        
        return tesLoginResult;
    }
    
}
