/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.intralot.loto.layer.view.game.ganadiario;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author developer5
 */
public class CallTransformByCost extends SimpleTagSupport {

    private int p_sum_total_bet;
    private int p_number_consecutive;
    private double p_data_value_bet;
    private int p_bets;
    private double p_cost;

    /**
     * Called by the container to invoke this tag. 
     * The implementation of this method is provided by the tag library developer,
     * and handles all tag processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            double var_total_cost = 0;
            double var_sum_total_bet_consecutive = 0;
            var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
            var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets * p_data_value_bet - p_cost)));
            out.println(var_total_cost);
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            // TODO: insert code to write html after writing the body content.
            // e.g.:
            //
            // out.println("    </blockquote>");

        } catch (java.io.IOException ex) {
            throw new JspException("Error in callTransformByCost tag", ex);
        }
    }

    public void setP_sum_total_bet(int p_sum_total_bet) {
        this.p_sum_total_bet = p_sum_total_bet;
    }

    public void setP_number_consecutive(int p_number_consecutive) {
        this.p_number_consecutive = p_number_consecutive;
    }

    public void setP_data_value_bet(double p_data_value_bet) {
        this.p_data_value_bet = p_data_value_bet;
    }

    public void setP_bets(int p_bets) {
        this.p_bets = p_bets;
    }

    public void setP_cost(double p_cost) {
        this.p_cost = p_cost;
    }
}
