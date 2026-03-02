/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.intralot.loto.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import pe.com.intralot.loto.lib.ConnectionFactory;
import pe.com.intralot.loto.sale.lib.LoggerApi;

/**
 *
 * @author developer5
 */
public class CotejadorUtil {

    int dos_aciertos = 0, tres_aciertos = 0, cuatro_aciertos = 0, cinco_aciertos = 0, seis_aciertos = 0,cuatro_ac_yapa=0,cinco_ac_yapa=0;
    ArrayList aci_2 = new ArrayList();

    public ArrayList style_negrita_cotejo(ArrayList aciertos, ArrayList jugada) {
        ArrayList al2 = new ArrayList();
        ArrayList a_pivo = new ArrayList();
        ArrayList a_final = new ArrayList();
        int z = 0;
        String ar = "";
        String cad = "", cad_arra = "", cad_pivo = "", variable_pivo = "", aciertos_num = "";
        for (int r = 0; r < aciertos.size(); r++) {
            z = 0;
            cad_pivo = aciertos.get(r).toString() + " ";
            for (int s = 0; s < cad_pivo.length(); s++) {
                variable_pivo = cad_pivo.substring(s, s + 1);
                if (!variable_pivo.equals(" ")) {
                    aciertos_num = aciertos_num + variable_pivo;
                } else {
                    a_pivo.add(aciertos_num);
                    aciertos_num = "";
                    z++;
                }
            }
            HashSet hs = new HashSet();
            hs.addAll(a_pivo);
            a_pivo.clear();
            a_pivo.addAll(hs);

            ar = a_pivo.toString().replace(",", "");
            ar = ar.substring(1, ar.length() - 1);
            ar = " " + ar + " ";
            String list = ar;
            al2 = ordenar_array_menor_mayor(list);
            for (int i = 0; i < jugada.size(); i++) {
                cad = jugada.get(i).toString().substring(3);
                cad = cad.substring(0, cad.length() - 4);
                for (int j = 0; j < al2.size(); j++) {
                    if (cad.equals(al2.get(j))) {

                        al2.set(j, "<b>" + cad + "</b>");
                    }
                }
            }
            cad_arra = al2.toString();
            cad_arra = cad_arra.replace(",", "");
            cad_arra = cad_arra.replace("[", "");
            cad_arra = cad_arra.replace("]", "");
            a_final.add(cad_arra);
            a_pivo.removeAll(a_pivo);
        }
        return a_final;
    }

    public ArrayList ordenar_array_menor_mayor(String list) {
        ArrayList lista = new ArrayList();
        ArrayList jugada_ordenada = new ArrayList();

        String cade = "", ordenada = "";
        String numero = "";
        for (int x = 1; x < list.length(); x++) {

            numero = list.substring(x, x + 1);
            if (!numero.equals(" ")) {
                cade += numero;
                ordenada = cade;
            } else {
                if (!ordenada.equals("")) {
                    lista.add(ordenada);

                }
                if (numero.equals(" ")) {
                    cade = "";
                }
            }

        }

        int num_jugada = 0, ind_eliminado = 0;
        int recorre = 0;
        String menor = "99999";
        for (int i = 0; i < lista.size(); i++) {

            if (ind_eliminado == 1) {

                recorre = 0;
            } else {
                recorre = i;

            }

            num_jugada = Integer.parseInt(lista.get(recorre).toString());
            menor = "999999";

            for (int j = 0; j < lista.size(); j++) {


                if (num_jugada <= Integer.parseInt(lista.get(j).toString()) && lista.size() != 1) {
                    if (Integer.parseInt(menor) != 0) {
                        menor = num_jugada + "";
                        ind_eliminado = 0;

                    }

                } else {
                    menor = 0 + "";
                    ind_eliminado = 0;

                }
            }
            if (Integer.parseInt(menor) != 0) {
                lista.remove(recorre);
                jugada_ordenada.add(menor);
                i = -1;
                ind_eliminado = 1;
            }

            if (lista.size() == 1) {
                menor = Integer.parseInt(lista.get(0).toString()) + "";
                String r = "";
                r = r + menor;
                jugada_ordenada.add(menor);

                lista.remove(0);

            }
        }
        return jugada_ordenada;
    }

    public ArrayList genera_array(String list) {
        ArrayList lista = new ArrayList();
        String cade = "", ordenada = "";
        String numero = "";
        for (int x = 1; x < list.length(); x++) {
            numero = list.substring(x, x + 1);
            if (!numero.equals(" ")) {
                cade += numero;
                ordenada = cade;
            } else {
                if (!ordenada.equals("")) {
                    lista.add(ordenada);
                }
                if (numero.equals(" ")) {
                    cade = "";
                }
            }
        }
        return lista;
    }

    public ArrayList genera_array_entrada(String resultado) {
        ArrayList resultado_entrada = new ArrayList();
        for (int p = 1; p < resultado.trim().length() + 1; p++) {
            resultado_entrada.add(resultado.substring(p, p + 1));
        }
        return resultado_entrada;
    }
    
    public ArrayList cotejo_aciertos_jugada(CombinacionesUtil it,String lista_resultado_sorteo,String yapa){

    		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
            ArrayList iteracion_jugada = new ArrayList();
	    	ArrayList cadena_final = new ArrayList();
	        ArrayList cadena_jugada = new ArrayList();
	        ArrayList cadena_aciertos = new ArrayList();
                ArrayList cadena = new ArrayList();
	    	Iterator s = it.iterator();
	        
	        int num = 0, num_actual = 0, inicial_jugada = 0, siguiente_jugada = 1, cantidad_aciertos = 0, variable_yapa=0;
	        String lista_ganadora = lista_resultado_sorteo.toString(), ju = "", ju_num = "", acer_num = "", cad_aleatoria = "",acertando = "",it_jugada="",
                       lista_jugada = "",prue_acier = "", variable = "", variable_pivo = "", variable_jugada_ganadora = "", variable_pivo_jug_gan = "", aciertos_num = "", aciertos = "";
	        lista_ganadora = lista_ganadora.replace(",", "");
	        lista_ganadora = lista_ganadora.replace("[", " ");
	        lista_ganadora = lista_ganadora.replace("]", " ");

	        while (s.hasNext()) {

                List<String> listares = (List<String>) s.next();
                cadena.add(listares);
            }

            for (int i = 0; i < cadena.size(); i++) {
                num = i + 1;
            }

            for (int i = 0; i < cadena.size(); i++) {
                inicial_jugada = 0;
                siguiente_jugada = 1;
                num_actual++;
                lista_jugada = (cadena.get(num - 1).toString());
                lista_jugada = lista_jugada.replace(",", "");
                lista_jugada = lista_jugada.replace("[", " ");
                lista_jugada = lista_jugada.replace("]", " ");
                for (int j = 0; j < lista_jugada.length(); j++) {
                    variable_pivo = lista_jugada.substring(inicial_jugada, siguiente_jugada);
                    if (!variable_pivo.equals(" ")) {
                        variable = variable + variable_pivo;
                    } else {
                        for (int r = 0; r < lista_ganadora.length(); r++) {
                            variable_pivo_jug_gan = lista_ganadora.substring(r, r + 1);
                            if (!variable_pivo_jug_gan.equals(" ")) {
                                variable_jugada_ganadora = variable_jugada_ganadora + variable_pivo_jug_gan;

                            } else {
                                if (variable_jugada_ganadora.equals(variable) && !variable_jugada_ganadora.equals("")) {
                                    aciertos = aciertos + variable_jugada_ganadora + " ";
                                    cantidad_aciertos++;

                                }
                                variable_jugada_ganadora = "";
                            }
                        }
                        variable = "";
                    }
                    inicial_jugada++;
                    siguiente_jugada++;
                }

                if (cantidad_aciertos > 1) {
                     /* System.out.println("[" + num_actual + "]: " + (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " => " + cantidad_aciertos + " aciertos");*/
                    String jugada = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " ";
                    for (int j = 0; j < jugada.length(); j++) {
                        ju = jugada.substring(j, j + 1);
                        if (!ju.equals(" ")) {
                            aciertos_num = aciertos_num + ju;
                        } else {
                            for (int k = 0; k < aciertos.length(); k++) {
                                acertando = aciertos.substring(k, k + 1);
                                if (!acertando.equals(" ")) {
                                    acer_num = acer_num + acertando;
                                } else {
                                    if (aciertos_num.equals(acer_num)) {
                                        ju_num = "<b>" + aciertos_num + "</b>";
                                        cadena_jugada.add(ju_num);
                                    } else {
                                        cad_aleatoria = cad_aleatoria + aciertos_num + " ";
                                    }
                                    acer_num = "";
                                }
                            }
                            aciertos_num = "";
                        }
                    }
                    cadena_aciertos.add(cad_aleatoria);
                    String f = style_negrita_cotejo(cadena_aciertos, cadena_jugada).toString();
                    f = f.replace("[", "");
                    f = f.replace("]", "");
                    f = f + " => " + cantidad_aciertos + " aciertos";
                    if (cantidad_aciertos > 3) {
                        String jugada_yapa = "";

                        String[] corte_cadena, jugadas;
                        corte_cadena = f.toString().split("=>");

                        jugadas = corte_cadena[0].toString().split(" ");
                        jugadas.toString().replace("[", "");
                        ArrayList jugadas_cortadas = new ArrayList();
                        for (int m = 0; m < jugadas.length; m++) {
                            jugadas_cortadas.add(jugadas[m]);
                        }

                        for (int k = 0; k < jugadas_cortadas.size(); k++) {
                            String jugada_rec = jugadas_cortadas.get(k).toString();
                            if (!jugada_rec.substring(0, 1).equals("[") && !jugada_rec.substring(0, 1).equals("<")) {
                            	/*System.out.println("AQUI :    ----------------->"+jugadas_cortadas.get(k)+"------------------>"+yapa);*/
                                if (jugadas_cortadas.get(k).equals(yapa)) {
                                    jugadas_cortadas.set(k, "<b>" + jugadas_cortadas.get(k) + "</b>");
                                    jugada_yapa = jugadas_cortadas.toString();
                                    jugada_yapa = jugada_yapa.replace(",", "");
                                    jugada_yapa = jugada_yapa.replace("[", "");
                                    jugada_yapa = jugada_yapa.replace("]", "");
                                    if (cantidad_aciertos == 4) {
                                    	variable_yapa=1;
                                        cadena_final.add(jugada_yapa + " => " + cantidad_aciertos + " aciertos " + "+ 1 yapita");
                                     } else if (cantidad_aciertos == 5) {
                                    	variable_yapa=1;
                                        cadena_final.add(jugada_yapa + " => " + cantidad_aciertos + " aciertos " + "+ 1 yapa");
                                    }

                                } else {
                                	  if(k+1==jugadas_cortadas.size()){
                                    	  cadena_final.add(f);
                                    	 }
                                }
                            }

                        }
                    } else {
                        cadena_final.add(f);
                    }

                    ju_num = "";
                    cad_aleatoria = "";
                    cadena_jugada.removeAll(cadena_jugada);
                    cadena_aciertos.removeAll(cadena_aciertos);
                    it_jugada = ((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1) + " => " + cantidad_aciertos + " aciertos";


                    prue_acier = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "");
                    iteracion_jugada.add(it_jugada);
                }
                if (cantidad_aciertos <= 1) {
                    String jugada = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " ";
                    for (int j = 0; j < jugada.length(); j++) {
                        ju = jugada.substring(j, j + 1);
                        if (!ju.equals(" ")) {
                            aciertos_num = aciertos_num + ju;
                        } else {
                            for (int k = 0; k < aciertos.length(); k++) {
                                acertando = aciertos.substring(k, k + 1);
                                if (!acertando.equals(" ")) {
                                    acer_num = acer_num + acertando;
                                } else {
                                    if (aciertos_num.equals(acer_num)) {
                                        ju_num ="<b>" + aciertos_num + "</b>";
                                        cadena_jugada.add(ju_num);
                                    } else {
                                        cad_aleatoria = jugada + " ";

                                    }
                                    acer_num = "";
                                }
                            }

                            aciertos_num = "";

                        }

                    }
                    cadena_aciertos.add(jugada);
                    String f =style_negrita_cotejo(cadena_aciertos, cadena_jugada).toString();
                    f = f.replace("[", "");
                    f = f.replace("]", "");
                    cadena_final.add(f);
                   /* System.out.println("ARRAY             : " + sn.ordenar_array(cadena_aciertos, cadena_jugada));*/
                    ju_num = "";
                    cad_aleatoria = "";
                    cadena_jugada.removeAll(cadena_jugada);
                    cadena_aciertos.removeAll(cadena_aciertos);
                    it_jugada = ((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1);
                    iteracion_jugada.add(it_jugada);
                }
                if (cantidad_aciertos == 2) {
                    dos_aciertos++;
                    num_a.dos_aciertos++;
                    num_a.setDos_aciertos(num_a.dos_aciertos);
                } else if (cantidad_aciertos == 3) {
                	
                    tres_aciertos++;
                    num_a.tres_aciertos++;
                    num_a.setTres_aciertos(num_a.tres_aciertos);
                } else if (cantidad_aciertos == 4) {
                    cuatro_aciertos++;
                    num_a.cuatro_aciertos++;
                    num_a.setCuatro_aciertos(num_a.cuatro_aciertos);
                } else if (cantidad_aciertos == 4 && variable_yapa==1) {
                    cuatro_ac_yapa++;
                    num_a.cuatro_ac_yapa++;
                    num_a.setCuatro_ac_yapa(num_a.cuatro_ac_yapa);
                    variable_yapa=0;
                }else if (cantidad_aciertos == 5 && variable_yapa==1) {
                    cinco_ac_yapa++;
                    num_a.cinco_ac_yapa++;
                    num_a.setCinco_ac_yapa(num_a.cinco_ac_yapa);
                    variable_yapa=0;
                }
                else if (cantidad_aciertos == 5) {
                    cinco_aciertos++;
                    num_a.cinco_aciertos++;
                    num_a.setCinco_aciertos(num_a.cinco_ac_yapa);
                }
                else if (cantidad_aciertos == 6) {
                	seis_aciertos++;
                    num_a.seis_aciertos++;
                    num_a.setSeis_aciertos(num_a.cinco_ac_yapa);
                }
                aciertos = "";
                cantidad_aciertos = 0;
                num--;
	        }
    	return cadena_final;

    }
    public ArrayList cotejo_aciertos_jugada(CombinacionesUtil it,String lista_resultado_sorteo){

		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
        ArrayList iteracion_jugada = new ArrayList();
    	ArrayList cadena_final = new ArrayList();
        ArrayList cadena_jugada = new ArrayList();
        ArrayList cadena_aciertos = new ArrayList();
            ArrayList cadena = new ArrayList();
    	Iterator s = it.iterator();
        
        int num = 0, num_actual = 0, inicial_jugada = 0, siguiente_jugada = 1, cantidad_aciertos = 0, variable_yapa=0;
        String lista_ganadora = lista_resultado_sorteo.toString(), ju = "", ju_num = "", acer_num = "", cad_aleatoria = "",acertando = "",it_jugada="",
                   lista_jugada = "",prue_acier = "", variable = "", variable_pivo = "", variable_jugada_ganadora = "", variable_pivo_jug_gan = "", aciertos_num = "", aciertos = "";
        lista_ganadora = lista_ganadora.replace(",", "");
        lista_ganadora = lista_ganadora.replace("[", " ");
        lista_ganadora = lista_ganadora.replace("]", " ");

        while (s.hasNext()) {

            List<String> listares = (List<String>) s.next();
            cadena.add(listares);
        }

        for (int i = 0; i < cadena.size(); i++) {
            num = i + 1;
        }

        for (int i = 0; i < cadena.size(); i++) {
            inicial_jugada = 0;
            siguiente_jugada = 1;
            num_actual++;
            lista_jugada = (cadena.get(num - 1).toString());
            lista_jugada = lista_jugada.replace(",", "");
            lista_jugada = lista_jugada.replace("[", " ");
            lista_jugada = lista_jugada.replace("]", " ");
            for (int j = 0; j < lista_jugada.length(); j++) {
                variable_pivo = lista_jugada.substring(inicial_jugada, siguiente_jugada);
                if (!variable_pivo.equals(" ")) {
                    variable = variable + variable_pivo;
                } else {
                    for (int r = 0; r < lista_ganadora.length(); r++) {
                        variable_pivo_jug_gan = lista_ganadora.substring(r, r + 1);
                        if (!variable_pivo_jug_gan.equals(" ")) {
                            variable_jugada_ganadora = variable_jugada_ganadora + variable_pivo_jug_gan;

                        } else {
                            if (variable_jugada_ganadora.equals(variable) && !variable_jugada_ganadora.equals("")) {
                                aciertos = aciertos + variable_jugada_ganadora + " ";
                                cantidad_aciertos++;

                            }
                            variable_jugada_ganadora = "";
                        }
                    }
                    variable = "";
                }
                inicial_jugada++;
                siguiente_jugada++;
            }

            if (cantidad_aciertos > 1) {
                 /* System.out.println("[" + num_actual + "]: " + (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " => " + cantidad_aciertos + " aciertos");*/
                String jugada = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " ";
                for (int j = 0; j < jugada.length(); j++) {
                    ju = jugada.substring(j, j + 1);
                    if (!ju.equals(" ")) {
                        aciertos_num = aciertos_num + ju;
                    } else {
                        for (int k = 0; k < aciertos.length(); k++) {
                            acertando = aciertos.substring(k, k + 1);
                            if (!acertando.equals(" ")) {
                                acer_num = acer_num + acertando;
                            } else {
                                if (aciertos_num.equals(acer_num)) {
                                    ju_num = "<b>" + aciertos_num + "</b>";
                                    cadena_jugada.add(ju_num);
                                } else {
                                    cad_aleatoria = cad_aleatoria + aciertos_num + " ";
                                }
                                acer_num = "";
                            }
                        }
                        aciertos_num = "";
                    }
                }
                cadena_aciertos.add(cad_aleatoria);
                String f = style_negrita_cotejo(cadena_aciertos, cadena_jugada).toString();
                f = f.replace("[", "");
                f = f.replace("]", "");
                f = f + " => " + cantidad_aciertos + " aciertos";

                cadena_final.add(f);
                ju_num = "";
                cad_aleatoria = "";
                cadena_jugada.removeAll(cadena_jugada);
                cadena_aciertos.removeAll(cadena_aciertos);
                it_jugada = ((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1) + " => " + cantidad_aciertos + " aciertos";


                prue_acier = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "");
                iteracion_jugada.add(it_jugada);
            }
            if (cantidad_aciertos <= 1) {
                String jugada = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " ";
                for (int j = 0; j < jugada.length(); j++) {
                    ju = jugada.substring(j, j + 1);
                    if (!ju.equals(" ")) {
                        aciertos_num = aciertos_num + ju;
                    } else {
                        for (int k = 0; k < aciertos.length(); k++) {
                            acertando = aciertos.substring(k, k + 1);
                            if (!acertando.equals(" ")) {
                                acer_num = acer_num + acertando;
                            } else {
                                if (aciertos_num.equals(acer_num)) {
                                    ju_num ="<b>" + aciertos_num + "</b>";
                                    cadena_jugada.add(ju_num);
                                } else {
                                    cad_aleatoria = jugada + " ";

                                }
                                acer_num = "";
                            }
                        }

                        aciertos_num = "";

                    }

                }
                cadena_aciertos.add(jugada);
                String f =style_negrita_cotejo(cadena_aciertos, cadena_jugada).toString();
                f = f.replace("[", "");
                f = f.replace("]", "");
                cadena_final.add(f);
               /* System.out.println("ARRAY             : " + sn.ordenar_array(cadena_aciertos, cadena_jugada));*/
                ju_num = "";
                cad_aleatoria = "";
                cadena_jugada.removeAll(cadena_jugada);
                cadena_aciertos.removeAll(cadena_aciertos);
                it_jugada = ((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1);
                iteracion_jugada.add(it_jugada);
            }
            if (cantidad_aciertos == 2) {
                dos_aciertos++;
                num_a.dos_aciertos++;
                num_a.setDos_aciertos(num_a.dos_aciertos);
            } else if (cantidad_aciertos == 3) {
            	
                tres_aciertos++;
                num_a.tres_aciertos++;
                num_a.setTres_aciertos(num_a.tres_aciertos);
            } else if (cantidad_aciertos == 4) {
                cuatro_aciertos++;
                num_a.cuatro_aciertos++;
                num_a.setCuatro_aciertos(num_a.cuatro_aciertos);
            } else if (cantidad_aciertos == 4 && variable_yapa==1) {
                cuatro_ac_yapa++;
                num_a.cuatro_ac_yapa++;
                num_a.setCuatro_ac_yapa(num_a.cuatro_ac_yapa);
                variable_yapa=0;
            }else if (cantidad_aciertos == 5 && variable_yapa==1) {
                cinco_ac_yapa++;
                num_a.cinco_ac_yapa++;
                num_a.setCinco_ac_yapa(num_a.cinco_ac_yapa);
                variable_yapa=0;
            }
            else if (cantidad_aciertos == 5) {
                cinco_aciertos++;
                num_a.cinco_aciertos++;
                num_a.setCinco_aciertos(num_a.cinco_ac_yapa);
            }
            else if (cantidad_aciertos == 6) {
            	seis_aciertos++;
                num_a.seis_aciertos++;
                num_a.setSeis_aciertos(num_a.cinco_ac_yapa);
            }
            aciertos = "";
            cantidad_aciertos = 0;
            num--;
        }
	return cadena_final;

}
    
    
    public ArrayList cotejo_aciertos_jugada(CombinacionesUtil it,String lista_resultado_sorteo,String resultado_chauChamba,String plus,Integer chauchamba){

		AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
        ArrayList iteracion_jugada = new ArrayList();
    	ArrayList cadena_final = new ArrayList();
        ArrayList cadena_jugada = new ArrayList();
        ArrayList cadena_aciertos = new ArrayList();
        ArrayList cadena = new ArrayList();
    	Iterator s = it.iterator();
        
        int num = 0, num_actual = 0, inicial_jugada = 0, siguiente_jugada = 1, cantidad_aciertos = 0, variable_yapa=0;
        
        String lista_ganadora = "";
        lista_ganadora = lista_resultado_sorteo.toString();	
        
        
        
        int cond_chauChamba=1;
        for(int t=0;t<cond_chauChamba;t++){
        
        String ju = "", ju_num = "", acer_num = "", cad_aleatoria = "",acertando = "",it_jugada="",
                   lista_jugada = "",prue_acier = "", variable = "", variable_pivo = "", variable_jugada_ganadora = "", variable_pivo_jug_gan = "", aciertos_num = "", aciertos = "";
        lista_ganadora = lista_ganadora.replace(",", "");
        lista_ganadora = lista_ganadora.replace("[", " ");
        lista_ganadora = lista_ganadora.replace("]", " ");

        while (s.hasNext()) {

            List<String> listares = (List<String>) s.next();
            cadena.add(listares);
        }

        for (int i = 0; i < cadena.size(); i++) {
            num = i + 1;
        }

        for (int w = 0; w < cadena.size(); w++) {
            inicial_jugada = 0;
            siguiente_jugada = 1;
            num_actual++;
            lista_jugada = (cadena.get(num - 1).toString());
            lista_jugada = lista_jugada.replace(",", "");
            lista_jugada = lista_jugada.replace("[", " ");
            lista_jugada = lista_jugada.replace("]", " ");
            for (int j = 0; j < lista_jugada.length(); j++) {
                variable_pivo = lista_jugada.substring(inicial_jugada, siguiente_jugada);
                if (!variable_pivo.equals(" ")) {
                    variable = variable + variable_pivo;
                } else {
                    for (int r = 0; r < lista_ganadora.length(); r++) {
                        variable_pivo_jug_gan = lista_ganadora.substring(r, r + 1);
                        if (!variable_pivo_jug_gan.equals(" ")) {
                            variable_jugada_ganadora = variable_jugada_ganadora + variable_pivo_jug_gan;

                        } else {
                            if (variable_jugada_ganadora.equals(variable) && !variable_jugada_ganadora.equals("")) {
                                aciertos = aciertos + variable_jugada_ganadora + " ";
                                cantidad_aciertos++;

                            }
                            variable_jugada_ganadora = "";
                        }
                    }
                    variable = "";
                }
                inicial_jugada++;
                siguiente_jugada++;
            }

            if (cantidad_aciertos > 1) {
                 /* System.out.println("[" + num_actual + "]: " + (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " => " + cantidad_aciertos + " aciertos");*/
                String jugada = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " ";
                for (int j = 0; j < jugada.length(); j++) {
                    ju = jugada.substring(j, j + 1);
                    if (!ju.equals(" ")) {
                        aciertos_num = aciertos_num + ju;
                    } else {
                        for (int k = 0; k < aciertos.length(); k++) {
                            acertando = aciertos.substring(k, k + 1);
                            if (!acertando.equals(" ")) {
                                acer_num = acer_num + acertando;
                            } else {
                                if (aciertos_num.equals(acer_num)) {
                                    ju_num = "<b>" + aciertos_num + "</b>";
                                    cadena_jugada.add(ju_num);
                                } else {
                                    cad_aleatoria = cad_aleatoria + aciertos_num + " ";
                                }
                                acer_num = "";
                            }
                        }
                        aciertos_num = "";
                    }
                }
                cadena_aciertos.add(cad_aleatoria);
                String f = style_negrita_cotejo(cadena_aciertos, cadena_jugada).toString();
                f = f.replace("[", "");
                f = f.replace("]", "");
               
                if(cantidad_aciertos==6){
                		if(plus.trim().equals("AD1") && chauchamba==0){
                			f = f + " => " + cantidad_aciertos + " aciertos + Plus";
                    	}else if(cond_chauChamba!=2 && plus.trim().equals("AD1") && chauchamba==1){
                			f = f + " => " + cantidad_aciertos + " aciertos + Plus";
                    	}else if(cond_chauChamba==2){
                			for(int r=0;r<cadena_final.size();r++){
                				String variable_F=f.replace("<b>", "").replace("</b>", "");
                    			if((variable_F.trim()).equals(cadena_final.get(r).toString().trim().replace("<b>", "").replace("</b>", ""))){
                    				f = f + " => "+ "Chau Chamba";
                    				cadena_final.set(r, f);
                    				}
                    			
                    		}
                    	}
                		else{
                			f = f + " => " + cantidad_aciertos + " aciertos";
                    	}	
                	                	
                }else{
                	f = f + " => " + cantidad_aciertos + " aciertos";	
                }  
                
                if(cond_chauChamba!=2){
                cadena_final.add(f);
                }
                
                ju_num = "";
                cad_aleatoria = "";
                cadena_jugada.removeAll(cadena_jugada);
                cadena_aciertos.removeAll(cadena_aciertos);
                it_jugada = ((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1) + " => " + cantidad_aciertos + " aciertos";


                prue_acier = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "");
                iteracion_jugada.add(it_jugada);
            }
            if (cantidad_aciertos <= 1) {
                String jugada = (((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1)).replace(",", "") + " ";
                for (int j = 0; j < jugada.length(); j++) {
                    ju = jugada.substring(j, j + 1);
                    if (!ju.equals(" ")) {
                        aciertos_num = aciertos_num + ju;
                    } else {
                        for (int k = 0; k < aciertos.length(); k++) {
                            acertando = aciertos.substring(k, k + 1);
                            if (!acertando.equals(" ")) {
                                acer_num = acer_num + acertando;
                            } else {
                                if (aciertos_num.equals(acer_num)) {
                                    ju_num ="<b>" + aciertos_num + "</b>";
                                    cadena_jugada.add(ju_num);
                                } else {
                                    cad_aleatoria = jugada + " ";

                                }
                                acer_num = "";
                            }
                        }

                        aciertos_num = "";

                    }

                }
                cadena_aciertos.add(jugada);
                String f =style_negrita_cotejo(cadena_aciertos, cadena_jugada).toString();
                f = f.replace("[", "");
                f = f.replace("]", "");
                if(cond_chauChamba!=2){
                cadena_final.add(f);
                }
               /* System.out.println("ARRAY             : " + sn.ordenar_array(cadena_aciertos, cadena_jugada));*/
                ju_num = "";
                cad_aleatoria = "";
                cadena_jugada.removeAll(cadena_jugada);
                cadena_aciertos.removeAll(cadena_aciertos);
                it_jugada = ((cadena.get(num - 1)).toString()).substring(1, cadena.get(num - 1).toString().length() - 1);
                iteracion_jugada.add(it_jugada);
            }
            if (cantidad_aciertos == 2) {
                dos_aciertos++;
                num_a.dos_aciertos++;
                num_a.setDos_aciertos(num_a.dos_aciertos);
            } else if (cantidad_aciertos == 3) {
            	
                tres_aciertos++;
                num_a.tres_aciertos++;
                num_a.setTres_aciertos(num_a.tres_aciertos);
            } else if (cantidad_aciertos == 4) {
                cuatro_aciertos++;
                num_a.cuatro_aciertos++;
                num_a.setCuatro_aciertos(num_a.cuatro_aciertos);
            } else if (cantidad_aciertos == 4 && variable_yapa==1) {
                cuatro_ac_yapa++;
                num_a.cuatro_ac_yapa++;
                num_a.setCuatro_ac_yapa(num_a.cuatro_ac_yapa);
                variable_yapa=0;
            }else if (cantidad_aciertos == 5 && variable_yapa==1) {
                cinco_ac_yapa++;
                num_a.cinco_ac_yapa++;
                num_a.setCinco_ac_yapa(num_a.cinco_ac_yapa);
                variable_yapa=0;
            }
            else if (cantidad_aciertos == 5) {
                cinco_aciertos++;
                num_a.cinco_aciertos++;
                num_a.setCinco_aciertos(num_a.cinco_ac_yapa);
            }
            else if (cantidad_aciertos == 6) {
            	seis_aciertos++;
                num_a.seis_aciertos++;
                num_a.setSeis_aciertos(num_a.cinco_ac_yapa);
            }
            aciertos = "";
            cantidad_aciertos = 0;
            num--;
        }

        
        if(chauchamba==1){
        	if(!(resultado_chauChamba.trim()).equals("null")){
        		cond_chauChamba=2;	
        	}
            }
            
            if(cond_chauChamba==2){
            	lista_ganadora = resultado_chauChamba.toString();		        	
            }
            
        }
	return cadena_final;

}
    public static void main(String [] args) {
    	int draw = 5439;
		LoggerApi.startLogger(LoggerApi.LOTTOSALE);
    	CotejadorUtil cot = new CotejadorUtil();
        cot.cotejoAciertosKabala(" 01 02 03 04 05 07 36 ", "1 2 3 4 5 6 ", " 1 2 3 4 5 7 ", "AD1", "1", draw); 
    }
    
    public ArrayList<String> cotejoAciertosKabala(String bet, String listaResultadoSorteo, String resultadoChauChamba, String plus, String chauChamba, int from) {

    	LoggerApi.Log.info("cotejo_ajax bet= "+bet+" listaResultadoSorteo="+listaResultadoSorteo+" resultadoChauChamba="+resultadoChauChamba+" plus="+plus+" chauChamba="+chauChamba+" from="+from);
    	int chChDrawEnabled = Integer.valueOf(ConnectionFactory.operationProperty("kabalaChChDrawEnabled", Constants.contextCardWeb).trim()).intValue();
        String [] bets = bet.trim().split(" ");
        String [] res = listaResultadoSorteo.trim().split(" ");
        String [] cc = resultadoChauChamba.trim().split(" ");
        int n = bets.length;
        ArrayList<String> cadenaFinal = new ArrayList<String>();

        int i=0;
        for (int i0 =    0; i0 < n - 5; i0++)
        for (int i1 = i0+1; i1 < n - 4; i1++)
        for (int i2 = i1+1; i2 < n - 3; i2++)
        for (int i3 = i2+1; i3 < n - 2; i3++)
        for (int i4 = i3+1; i4 < n - 1; i4++)
        for (int i5 = i4+1; i5 < n - 0; i5++) {
        	i++; 
        	String cadena="", cadenachch="";
        	int aciertos=0;
        	int chauAciertos=0;
        	String [] beti = (bets[i0]+" "+bets[i1]+" "+bets[i2]+" "+bets[i3]+" "+bets[i4]+" "+bets[i5]).split(" ");
        	
        	for (int b = 0; b < 6; b++) {
        		boolean found = false;
                for (int r = 0; r < 6; r++) {
                	if (Integer.parseInt(beti[b]) == Integer.parseInt(res[r])) {
                		cadena += " <label style='font-weight:bold;color:#000;'>"+ Integer.parseInt(beti[b]) +"</label>";
                		aciertos++;
                		found = true;
                		break;
                	}
                }
                if (cc.length==6) {
                	boolean foundchch = false;
                	for (int r = 0; r < 6; r++) {
	                	if (Integer.parseInt(beti[b]) == Integer.parseInt(cc[r])) {
	                		cadenachch += " <label style='font-weight:bold;color:#000;'>"+ Integer.parseInt(beti[b]) +"</label >";
	                		chauAciertos++;
	                		foundchch = true;
	                		break;
	                	}
	                }
                	if (!foundchch) {
                		cadenachch += " "+ Integer.parseInt(beti[b]);
                    }
                }
                if (!found) {
                	cadena += " "+ Integer.parseInt(beti[b]);
                }
        	}
        	//System.out.println("from="+from+" chChDrawEnabled="+chChDrawEnabled);
        	if(from>=chChDrawEnabled){
        		//cadena += " => " + aciertos + " aciertos de ";
        		if(aciertos>=2)
        			cadena += " => <b>" + aciertos + "</b> aciertos de sorteo regular";
            	if(chauChamba.equals("1") && chauAciertos>=3) 
            		cadenachch += " => <b>" + chauAciertos + "</b> aciertos de Chau Chamba";
        	} else {
        		if (aciertos>=2)
	            	cadena += " => <b>" + aciertos + "</b> aciertos</b>";
            	if (plus.equals("AD1") && aciertos==6 )
            		cadena += " / Plus";
            	if (plus.equals("AD1") && chauChamba.equals("1") && chauAciertos==6 ) 
            		cadenachch += " => <b>" + chauAciertos + "</b> aciertos / Chau Chamba";	
            }
        	LoggerApi.Log.info("cotejo_ajax "+i+"=["+cadena.trim()+"] aciertos="+aciertos+" chauAciertos="+chauAciertos);
        	
        	//if(aciertos>=2) 
        	if(cadena.trim().length()>0 && aciertos>=2)
        		cadenaFinal.add("<b>["+ i +"]</b> <span>"+cadena.trim()+"</span>");
        	//if(chauChamba.equals("1"))// && chauAciertos>=3)
        	if(from>=chChDrawEnabled) {
	        	if(cadenachch.trim().length()>0 && chauChamba.equals("1") && chauAciertos>=3)
	        		cadenaFinal.add("<b>["+ i +"]</b> <span>"+cadenachch.trim()+"</span>");
        	} else {
        		if(cadenachch.trim().length()>0 && chauChamba.equals("1") && chauAciertos==6)
            		cadenaFinal.add("<b>["+ i +"]</b> <span>"+cadenachch.trim()+"</span>");
        	}
        }
        
        return cadenaFinal; 
  }
    

    public ArrayList<String> cotejoAciertosTinka(String bet, String listaResultadoSorteo, String yapa, boolean is3mas1And2mas1) {

    	LoggerApi.Log.info("cotejo_ajax bet= "+bet+" listaResultadoSorteo="+listaResultadoSorteo+" yapa="+yapa+" is3mas1And2mas1="+is3mas1And2mas1);
    	
        String [] bets = bet.trim().split(" ");
        String [] res = listaResultadoSorteo.trim().split(" ");
        int n = bets.length;
        ArrayList<String> cadenaFinal = new ArrayList<String>();

        int i=0;
        for (int i0 =    0; i0 < n - 5; i0++)
        for (int i1 = i0+1; i1 < n - 4; i1++)
        for (int i2 = i1+1; i2 < n - 3; i2++)
        for (int i3 = i2+1; i3 < n - 2; i3++)
        for (int i4 = i3+1; i4 < n - 1; i4++)
        for (int i5 = i4+1; i5 < n - 0; i5++) {
        	i++; 
        	String cadena="";
        	int aciertos=0;
        	int yapaAcierto=0;
        	String [] beti = (bets[i0]+" "+bets[i1]+" "+bets[i2]+" "+bets[i3]+" "+bets[i4]+" "+bets[i5]).split(" ");
        	
        	for (int b = 0; b < 6; b++) {
        		boolean found = false;
                for (int r = 0; r < 6; r++) {
                	if (Integer.parseInt(beti[b]) == Integer.parseInt(res[r])) {
                		cadena += " <b>"+ Integer.parseInt(beti[b]) +"</b>";
                		aciertos++;
                		found = true;
                		break;
                	}
                } 
            	if (Integer.parseInt(beti[b]) == Integer.parseInt(yapa)) yapaAcierto=1;
                 
                if (!found) {
                	cadena += " "+ Integer.parseInt(beti[b]);
                }
        	}
            
            if (aciertos>=2) {
            	cadena += " => " + aciertos + " aciertos";
            	if (yapaAcierto == 1 ) {
                    if (aciertos>=4) {
                		cadena += " + Boliyapa";	
                    } else {
                        if (is3mas1And2mas1) {
                    		cadena += " + Boliyapa";	
                        }                    	
                    }
            	} 
            }

        	LoggerApi.Log.info("cotejo_ajax "+i+"=["+cadena.trim()+"] aciertos="+aciertos+" yapaAcierto="+yapaAcierto);
        	
        	cadenaFinal.add(cadena.trim());
        	
        }
        
        return cadenaFinal; 
  }
}
