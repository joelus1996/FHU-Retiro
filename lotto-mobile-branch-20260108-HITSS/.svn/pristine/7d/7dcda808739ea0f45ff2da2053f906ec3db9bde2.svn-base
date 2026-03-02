/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.intralot.loto.layer.view.game.ganagol;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author developer5
 */
public class Busqueda extends SimpleTagSupport {
    private String cadena;

    /**
     * Called by the container to invoke this tag. 
     * The implementation of this method is provided by the tag library developer,
     * and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            String  sTexto = cadena;
             int car=0;String cadena_fin="";
             for (int x=0; x < sTexto.length(); x++) {
                  if (sTexto.charAt(x) == '*'){
                    car++;cadena_fin=cadena_fin.concat("*");
                    }
                }
             out.println(cadena_fin);

            JspFragment f = getJspBody();
            if (f != null){
               f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Busqueda tag", ex);
        }
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

}
