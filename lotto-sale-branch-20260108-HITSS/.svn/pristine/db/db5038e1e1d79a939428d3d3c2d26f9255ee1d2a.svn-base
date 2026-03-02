package pe.com.intralot.loto.util;
import java.util.ArrayList;
import java.util.logging.Logger;

import pe.com.intralot.loto.json.lib.JLib;
import pe.com.intralot.loto.sale.card.lib.LoggerAPI;
import pe.com.intralot.loto.util.AciertoscotejadorUtil;
import pe.com.intralot.loto.util.CotejadorUtil;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author developer5
 */
public class GanagolcotejadorUtil {

    int dies_aciertos=0, once_aciertos = 0, doce_aciertos = 0, trece_aciertos = 0, catorce_aciertos = 0, quince_aciertos = 0;

    public ArrayList<String> aciertos_depo(String list, String lista_ganador) {

    	String bet[] = list.trim().split(" ");
    	String gan[] = lista_ganador.trim().split(" ");
    	 
        ArrayList<String> lista_jugada_final = new ArrayList<String>();
    	
    	for (int i0=0; i0<bet[0].length(); i0++) {
        	for (int i1=0; i1<bet[1].length(); i1++) {
            	for (int i2=0; i2<bet[2].length(); i2++) {
                	for (int i3=0; i3<bet[3].length(); i3++) {
                    	for (int i4=0; i4<bet[4].length(); i4++) {
                        	for (int i5=0; i5<bet[5].length(); i5++) {
                            	for (int i6=0; i6<bet[6].length(); i6++) {
                                	for (int i7=0; i7<bet[7].length(); i7++) {
                                    	for (int i8=0; i8<bet[8].length(); i8++) {
                                        	for (int i9=0; i9<bet[9].length(); i9++) {
                                            	for (int i10=0; i10<bet[10].length(); i10++) {
                                                	for (int i11=0; i11<bet[11].length(); i11++) {
                                                    	for (int i12=0; i12<bet[12].length(); i12++) {
                                                        	for (int i13=0; i13<bet[13].length(); i13++) {

                                                        		String jugadas_fin = bet[0].charAt(i0)+" "+bet[1].charAt(i1)+" "+bet[2].charAt(i2)+" "+bet[3].charAt(i3)+" "+bet[4].charAt(i4)+" "+bet[5].charAt(i5)+" "+bet[6].charAt(i6)+" "+bet[7].charAt(i7)+" "+bet[8].charAt(i8)+" "+bet[9].charAt(i9)+" "+bet[10].charAt(i10)+" "+bet[11].charAt(i11)+" "+bet[12].charAt(i12)+" "+bet[13].charAt(i13);
                                                        		String []apu = jugadas_fin.split(" ");
                                                        		String acierto_fin = "";
                                                        		int aciertos=0;
                                                            	for (int j=0; j<14; j++) {
                                                            		if (apu[j].equals(gan[j])) {
                                                            			acierto_fin += " <b>"+apu[j]+"</b>";
                                                                        aciertos++;
                                                            		} else {
                                                            			acierto_fin += " "+apu[j];
                                                            		} 
                                                            	}
                                                                if (aciertos < 10) {
                                                                    lista_jugada_final.add(jugadas_fin);
                                                                } else {
                                                                    lista_jugada_final.add(acierto_fin + " => " + aciertos+" aciertos");
                                                                }
                                                        	}	                                                    		
                                                    	}	                                                		
                                                	}	
                                            	}	
                                        	}	
                                    	}	
                                	}                            		
                            	}                        		
                        	}                    		
                    	}                		
                	}            		
            	}        		
        	}
        } 
    	
		Logger.getLogger(LoggerAPI.SALECARD).info("list="+list+" lista_ganador="+lista_ganador+" lista_jugada_final="+JLib.arrayToString(lista_jugada_final));
		 
        return lista_jugada_final;
    }
    
    public ArrayList aciertos_depo_old(String list, String lista_ganador) {
        String jugada_final = "",listra_entrante="";
        int aciertos = 0,indicador=0;
        CotejadorUtil or = new CotejadorUtil();
        ArrayList lista = new ArrayList();
        ArrayList lista_final = new ArrayList();
        ArrayList lista_ganadora = new ArrayList();
        ArrayList lista_jugada_final = new ArrayList();
//        lista = or.genera_array(list);
        lista = itera_lista_doblejugadas(list, lista_ganador);
        lista_final = itera_lista_doblejugadas(list, lista_ganador);
//        for(int u =0; u<lista.size();u++){
//            System.out.println("lista 1 :"+lista.get(u));
//        }
//        System.out.println("TAMAï¿½O DE LISTA : "+lista.size());
//        lista_final = or.genera_array(list);
        String acierto = "", jugadas = "", jugadas_fin = "", acierto_fin = "";
//        System.out.println("d");
//        System.out.println("j");
        lista_ganadora = or.genera_array(lista_ganador);
//        System.out.println("lista.size()="+lista.size());
        for (int i = 0; i < lista.size(); i++) {
//            System.out.println("nv");
            String lista_jugada_cadena = "", lista_cadena_jugada = "";
            lista_jugada_cadena = lista.get(i).toString().trim();
//            System.out.println(i+" lista_jugada_cadena="+lista_jugada_cadena);
//            System.out.println("cand=  "+lista_jugada_cadena);
            for (int d = 0; d < lista_jugada_cadena.length(); d++) {
//              System.out.println("d  "+d );
                if (!lista_jugada_cadena.substring(d, d + 1).equals(" ")) {
//                  System.out.println("agregando :  "+lista_jugada_cadena.substring(d, d + 1));
                    lista_cadena_jugada = lista_cadena_jugada + lista_jugada_cadena.substring(d, d + 1);
//                  System.out.println("saliendo : -------------------------------------------------->"+lista_cadena_jugada);
                }
            }
//            System.out.println("fn");
//          System.out.println("LISTA :  ----------------------------->" + lista_cadena_jugada);
//          System.out.println("TAMANO : "+lista_cadena_jugada);
            
            for (int j = 0; j < lista_cadena_jugada.length(); j++) {
//              System.out.println("ndc");
                String jugada = "", resultado = "";
                jugada = lista_cadena_jugada.substring(j, j + 1);
//              System.out.println("jugada: "+jugada);
//              System.out.println("vnf");
//              System.out.println("tam : "+lista_cadena_jugada.length());
//              System.out.println("lis_tam: "+lista_ganadora.size());
                resultado = lista_ganadora.get(j).toString();
//              System.out.println("jdfbv");

//              System.out.println("j="+j+" "+jugada + " - " + resultado);
                
                if (jugada.equals(resultado)) {
                    aciertos++;
//                  System.out.println("ENTRO - " + jugada + " - " + resultado);
                    acierto = acierto + " " + "<b>" + jugada + "</b>";
                    jugadas = jugadas + " " + jugada;
//                        lista_final.set(i, "<b>" + lista.get(i).toString() + "</b>");
                } else {
//                        System.out.println("DIFERENTES - "+jugada+" - "+resultado);
                    acierto = acierto + " " + jugada;
                    jugadas = jugadas + " " + jugada;
                }
//              System.out.println(acierto);
                
//              System.out.println("jugada : " + jugada);
//              System.out.println("resultado : " + resultado);
            }
            acierto_fin = acierto_fin + acierto;
            jugadas_fin = jugadas_fin + jugadas;            
//          System.out.println("ACIERTOS :  " + aciertos);
//          System.out.println("A ----------------------------------------------->" + acierto_fin);

            AciertoscotejadorUtil num_a = new AciertoscotejadorUtil();
            if (aciertos == 10) {
            	  dies_aciertos++;
                  num_a.diez_aciertos = dies_aciertos;
                  lista_jugada_final.add(acierto_fin + " => " + aciertos+" aciertos");
             }
            if (aciertos == 11) {
                once_aciertos++;
                num_a.once_aciertos = once_aciertos;
                lista_jugada_final.add(acierto_fin + " => " + aciertos+" aciertos");
            }
            if (aciertos == 12) {
                doce_aciertos++;
                num_a.doce_aciertos = doce_aciertos;
                lista_jugada_final.add(acierto_fin + " => " + aciertos+" aciertos");
            }
            if (aciertos == 13) {
                trece_aciertos++;
                num_a.trece_aciertos = trece_aciertos;
                lista_jugada_final.add(acierto_fin + " => " + aciertos+" aciertos");
            }
            if (aciertos == 14) {
                catorce_aciertos++;
                num_a.catorce_aciertos = catorce_aciertos;
                lista_jugada_final.add(acierto_fin + " => " + aciertos+" aciertos");
            }
            /* if (aciertos == 15) {
                quince_aciertos++;
                num_a.quince_aciertos = quince_aciertos;
                lista_jugada_final.add(acierto_fin);
            } */
            if (aciertos < 10) {
                lista_jugada_final.add(jugadas_fin);
            }
            aciertos = 0;
            jugadas = "";
            jugadas_fin = "";
            acierto = "";
            acierto_fin = "";
        }
     /*   jugada_final = lista_final.toString();
        jugada_final = jugada_final.replace(",", "");
        jugada_final = jugada_final.replace("[", "");
        jugada_final = jugada_final.replace("]", "");*/

		Logger.getLogger(LoggerAPI.SALECARD).info("list="+list+" lista_jugada_final="+lista_jugada_final.toString());
		 
        return lista_jugada_final;
    }

    public ArrayList genera_array_entrada(String resultado) {
        ArrayList resultado_entrada = new ArrayList();
        for (int p = 1; p < resultado.trim().length() + 1; p++) {
            resultado_entrada.add(resultado.substring(p, p + 1));
        }
        return resultado_entrada;
    }

    public ArrayList itera_lista_doblejugadas(String list, String lista_ganador) {
        ArrayList lista = new ArrayList();
        int recorre = 0;
        ArrayList lista_ganadora = new ArrayList();
        ArrayList lista_final = new ArrayList();
        ArrayList lista_pivo = new ArrayList();
        CotejadorUtil or = new CotejadorUtil();
        lista_ganadora = or.genera_array(lista_ganador);
        lista = or.genera_array(list);
        for (int i = 0; i < lista.size(); i++) {
            String jugada = "", resultado = "", jugada_final;
            jugada = lista.get(i).toString();
            resultado = lista.get(i).toString();
            for (int r = 0; r < lista_final.size(); r++) {
                if (r < lista_pivo.size()) {
                    lista_pivo.set(r, lista_final.get(r));
                } else {
                    lista_pivo.add(lista_final.get(r));
                }
            }
            if (jugada.length() > 1) {
                for (int k = 0; k < jugada.length(); k++) {
                    if (k == 0) {
                        if (lista_final.toString().replace("[", "").replace("]", "").equals("")) {
                            lista_final.add(jugada.substring(k, k + 1));
                            lista_pivo.add(jugada.substring(k, k + 1));
                        } else {

                            for (int z = 0; z < lista_final.size(); z++) {
                                lista_final.set(z, lista_final.get(z) + " " + jugada.substring(k, k + 1));
                            }
                        }
                    } else {
                        if (lista_pivo.size() <= 1) {
                            if (jugada.substring(k, jugada.length()).length() == 2) {
                                if (i > 1) {
                                    lista_final.add(lista_pivo.get(0) + " " + jugada.substring(k, k + 1));
                                } else {
                                    if (lista_final.get(0).toString().length() <= 1) {
                                        lista_final.add(jugada.substring(i, i + 1));
                                    } else {
                                        lista_final.add(lista_pivo.get(0) + " " + jugada.substring(i, i + 1));
                                    }
                                }
                            }
                            if (jugada.substring(k, jugada.length()).length() == 1) {
                                if (i > 1) {
                                    lista_final.add(lista_pivo.get(0) + " " + jugada.substring(k, k + 1));

                                } else {
                                    if (lista_final.get(0).toString().length() <= 1) {
                                        lista_final.add(jugada.substring(i, i + 1));
                                    } else {
                                        lista_final.add(lista_pivo.get(0) + " " + jugada.substring(i, i + 1));
                                    }
                                }

                            }
                            if (jugada.substring(k, jugada.length()).length() == 3) {
                                for (int s = 0; s < lista_pivo.size(); s++) {
                                    lista_final.add(lista_pivo.get(s) + " " + jugada.substring(k, k + 1));
                                }
                            }
                        } else if (lista_pivo.size() > 1) {
                            if (jugada.length() == 2) {
                                for (int g = 0; g < lista_pivo.size(); g++) {
                                    lista_final.add(lista_pivo.get(g) + " " + jugada.substring(k, k + 1));
                                }
                            } else if (jugada.length() == 3) {
                                if (i > 1) {
                                    for (int g = 0; g < lista_pivo.size(); g++) {
                                        lista_final.add(lista_pivo.get(g) + " " + jugada.substring(k, k + 1));
                                    }
                                } else {
                                    for (int g = 0; g < lista_pivo.size(); g++) {
                                        lista_final.add(lista_pivo.get(g) + " " + jugada.substring(k, k + 1));
                                        lista_pivo.add(lista_pivo.get(g) + " " + jugada.substring(k, k + 1));
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

            }
            if (jugada.length() == 1) {
                if (lista_final.toString().replace("[", "").replace("]", "").equals("")) {
                    lista_final.add(jugada);
                    lista_pivo.add(jugada);
                } else {
                    for (int j = 0; j < lista_final.size(); j++) {
                        lista_final.set(j, lista_final.get(j) + " " + jugada);
                    }
                }

            }
        }
        return lista_final;
    }
    
    public ArrayList<String> acierto_golazo_200(ArrayList<String> lista_jugada_final, String rango, String resultado_g200) {
    	for (int i = 0; i < lista_jugada_final.size(); i++) {
    		String aciertos=lista_jugada_final.get(i);
    		String[] parts = aciertos.split(" => ");
    		if(parts.length==2 && !rango.equals("null")) {
    			int naciertos=Integer.parseInt(parts[1].split(" ")[0]);
    			int desde=0, hasta=0;
    			int res_g200=Integer.parseInt(resultado_g200.trim());
    			String[] rango_g200 = rango.split("-");
    			if(rango_g200.length>=2) {
    				desde=Integer.parseInt(rango_g200[0]);
    				hasta=Integer.parseInt(rango_g200[1]);
    				if(naciertos>=12 && res_g200>=desde && res_g200<=hasta){
    					lista_jugada_final.set(i, aciertos+" de Golazo 200");
    				}
    			}else {
    				rango_g200 = rango.split(" a más");
    				desde=Integer.parseInt(rango_g200[0]);
    				if(naciertos>=12 && res_g200>=desde){
    					lista_jugada_final.set(i, aciertos+" de Golazo 200");
    				}
    			}
    		}
		}
    	return lista_jugada_final;
    }
}