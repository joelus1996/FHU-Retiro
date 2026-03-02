package pe.com.intralot.loto.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import pe.com.intralot.loto.util.CotejadorUtil;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Renzo Jauregui
 */
public class KinelocotejadorUtil {

    public String cotejo(String resultado, String jugada) {
        String resultado_final = "";

        String[] jugada_split, jugada_split_numeros;
        double premio = 0.0, factor_base = 0.0;
        jugada_split = jugada.trim().split("x");
        jugada_split_numeros = jugada_split[0].split(" ");

        ArrayList jugada_lista = new ArrayList();
        String jugada_completa = "";
        int multiplicador = Integer.parseInt(jugada_split[1].toString().trim());

        String jugada_cadena = "", jugada_final = "";
        for (int k = 0; k < jugada_split_numeros.length; k++) {
            jugada_lista.add(jugada_split_numeros[k]);
        }

        int tipo_jugada = jugada_lista.size(), ind = 0, aciertos = 0;

        CotejadorUtil ac = new CotejadorUtil();
        ArrayList resultado_lista = new ArrayList();

        resultado_lista = ac.genera_array(" " + resultado.trim() + " ");
        String jugada_recorrido = "", resultado_recorrido = "";

        for (int i = 0; i < jugada_lista.size(); i++) {
            ind = 0;
            jugada_recorrido = jugada_lista.get(i).toString();
            for (int j = 0; j < resultado_lista.size(); j++) {
                resultado_recorrido = resultado_lista.get(j).toString();
                if (jugada_recorrido.equals(resultado_recorrido)) {
                    jugada_cadena = "<b>" + jugada_recorrido + "</b> ";
                    ind = 1;
                    aciertos++;
                } else {
                    if (ind == 0) {
                        jugada_cadena = jugada_recorrido + " ";
                    }
                }

            }
            ind = 0;
            jugada_final = jugada_final + jugada_cadena;
            jugada_cadena = "";
        }

        if (aciertos > 0) {
            jugada_completa = jugada_final + " => <b>aciertos :" + aciertos + "</b>";
        } else {
            jugada_completa = jugada_final;
        }

        if (tipo_jugada == 1) {
            if (aciertos == 1) {
                premio = 2.5 * multiplicador;
                factor_base = 2.5;
            }
        } else if (tipo_jugada == 2) {
            if (aciertos == 1) {
                premio = 1 * multiplicador;
                factor_base = 1;
            } else if (aciertos == 2) {
                premio = 5 * multiplicador;
                factor_base = 5;
            }
        } else if (tipo_jugada == 3) {
            if (aciertos == 2) {
                premio = 2.5 * multiplicador;
                factor_base = 2.5;
            } else if (aciertos == 3) {
                premio = 25 * multiplicador;
                factor_base = 25;
            }
        } else if (tipo_jugada == 4) {
            if (aciertos == 2) {
                premio = 1 * multiplicador;
                factor_base = 1;
            } else if (aciertos == 3) {
                premio = 4 * multiplicador;
                factor_base = 4;
            } else if (aciertos == 4) {
                premio = 100 * multiplicador;
                factor_base = 100;
            }
        } else if (tipo_jugada == 5) {
            if (aciertos == 3) {
                premio = 2 * multiplicador;
                factor_base = 2;
            } else if (aciertos == 4) {
                premio = 20 * multiplicador;
                factor_base = 20;
            } else if (aciertos == 5) {
                premio = 450 * multiplicador;
                factor_base = 450;
            }
        } else if (tipo_jugada == 6) {
            if (aciertos == 3) {
                premio = 1 * multiplicador;
                factor_base = 1;
            } else if (aciertos == 4) {
                premio = 7 * multiplicador;
                factor_base = 7;
            } else if (aciertos == 5) {
                premio = 50 * multiplicador;
                factor_base = 50;
            } else if (aciertos == 6) {
                premio = 1600 * multiplicador;
                factor_base = 1600;
            }
        } else if (tipo_jugada == 7) {
            if (aciertos == 3) {
                premio = 1 * multiplicador;
                factor_base = 1;
            } else if (aciertos == 4) {
                premio = 3 * multiplicador;
                factor_base = 3;
            } else if (aciertos == 5) {
                premio = 20 * multiplicador;
                factor_base = 20;
            } else if (aciertos == 6) {
                premio = 100 * multiplicador;
                factor_base = 100;
            } else if (aciertos == 7) {
                premio = 5000 * multiplicador;
                factor_base = 5000;
            }
        } else if (tipo_jugada == 8) {
            if (aciertos == 3) {
                premio = 2 * multiplicador;
                factor_base = 2;
            } else if (aciertos == 4) {
                premio = 10 * multiplicador;
                factor_base = 10;
            } else if (aciertos == 5) {
                premio = 50 * multiplicador;
                factor_base = 50;
            } else if (aciertos == 6) {
                premio = 1000 * multiplicador;
                factor_base = 1000;
            } else if (aciertos == 7) {
                premio = 5000 * multiplicador;
                factor_base = 5000;
            }
        } else if (tipo_jugada == 9) {
            if (aciertos == 4) {
                premio = 1 * multiplicador;
                factor_base = 1;
            } else if (aciertos == 5) {
                premio = 5 * multiplicador;
                factor_base = 5;
            } else if (aciertos == 6) {
                premio = 25 * multiplicador;
                factor_base = 25;
            } else if (aciertos == 7) {
                premio = 200 * multiplicador;
                factor_base = 200;
            } else if (aciertos == 8) {
                premio = 4000 * multiplicador;
                factor_base = 4000;
            } else if (aciertos == 9) {
                premio = 40000 * multiplicador;
                factor_base = 40000;
            }
        } else if (tipo_jugada == 10) {
            if (aciertos == 0) {
                premio = 2 * multiplicador;
                factor_base = 2;
            } else if (aciertos == 5) {
                premio = 2 * multiplicador;
                factor_base = 2;
            } else if (aciertos == 6) {
                premio = 20 * multiplicador;
                factor_base = 20;
            } else if (aciertos == 7) {
                premio = 80 * multiplicador;
                factor_base = 80;
            } else if (aciertos == 8) {
                premio = 500 * multiplicador;
                factor_base = 500;
            } else if (aciertos == 9) {
                premio = 10000 * multiplicador;
                factor_base = 10000;
            } else if (aciertos == 10) {
                premio = 100000 * multiplicador;
                factor_base = 100000;
            }
        }
        double costo = 1 * multiplicador;
        double efectivo = 0.0;
       System.out.println("premio : "+premio);
        if(premio>1){
        	 efectivo = premio - (premio * 0.1);
        }else{
        	efectivo=premio;
        	
        }
        resultado_final = tipo_jugada + "-" + aciertos + "-" + costo + "-" + multiplicador + "-" + factor_base + "-" + premio + "-" + efectivo + "-" + jugada_completa + "-";

        return resultado_final;
    }
}
