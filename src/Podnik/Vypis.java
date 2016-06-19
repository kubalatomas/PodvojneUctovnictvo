/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Podnik;

import java.io.FileNotFoundException;

/**
 *
 * @author Tomáš
 */
public interface Vypis {
    public void vypisDoSuboru(Podnik p) throws FileNotFoundException;
}
