package com.example.itauchallenge.auxiliares;
import android.content.Context;
import android.content.SharedPreferences;

import com.firebase.client.Firebase;

/**
 * Created by Matt on 14/01/2019.
 */
//Classe que serve como auxiliar para poder guardar o token gerado no login
public class LibraryClass {
    private static Firebase firebase;

    public static Firebase getFirebase(){
        try{
            if( firebase == null ){
                firebase = new Firebase("https://nosso-chate-fb.firebaseio.com/");
            }
            return( firebase );
        }catch (Exception e){

        }
        return null;
    }

}