/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.intralot.loto.layer.view.game.teapuesto;

import java.text.DecimalFormat;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author developer5
 */
public class limit extends SimpleTagSupport {

    private String maxima;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
        	DecimalFormat formateador = new DecimalFormat("#,###,###,##0.00");
            String cad = maxima;
            String coma = ",";
            String simbolo = "S/. ";
            String num1 = maxima.replace(simbolo, "");
            String max1 = num1.replace(coma, "");

            if(max1 != null){
            double numerico = Double.parseDouble(max1);
            double limite=50000.00;
            String ganancia_max = "";

            if (numerico > limite) {
                ganancia_max = "S/. 50,000.00";
            } else {
                ganancia_max = "S/. " + formateador.format(numerico);
            }
              out.println(ganancia_max);
            }
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
        } catch (java.io.IOException ex) {
            throw new JspException("Error in limit tag", ex);
        }
    }

    public void setMaxima(String maxima) {
        this.maxima = maxima;
    }
}
