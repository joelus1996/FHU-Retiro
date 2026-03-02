/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.com.intralot.loto.layer.view.game.ganadiario;

import java.text.DecimalFormat;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author developer5
 */
public class Multiplicacion extends SimpleTagSupport {
    private int total;
    private double precio;

    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
        	
             DecimalFormat df = new DecimalFormat("#.##");
             String monto=df.format(total*precio);
             monto=monto.replace(",", ".");
             out.println("S/."+monto);
            JspFragment f = getJspBody();
            if (f != null){
                f.invoke(out);
            }

        } catch (java.io.IOException ex) {
            throw new JspException("Error in Multiplicacion tag", ex);
        }
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
