/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.intralot.loto.layer.view.game.tinkamegabol;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author developer5
 */
public class Verifica extends SimpleTagSupport {

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
            String sTexto = cadena;
            int car = 0;
            String cadenita = "", cade = "";
            int inicial = 0, siguiente = 1;
            String indicador = "yes";

            for (int x = 0; x < sTexto.length(); x++) {

               cadenita = sTexto.substring(inicial, siguiente);
            if (!cadenita.equals("-") && !cadenita.equals("")) {
                cade += cadenita;
                car = Integer.parseInt(cade);



            } else {
                 if (car < 6 ) {
                    indicador = "no";
                }
                //System.out.println("cadena: " + car);
                cade = "";

            }

                inicial++;
                siguiente++;
            }
            out.println(indicador);
            
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }


        } catch (java.io.IOException ex) {
            throw new JspException("Error in verifica tag", ex);
        }
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
