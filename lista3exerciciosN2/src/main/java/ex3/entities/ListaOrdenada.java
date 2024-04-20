/*
 * Copyright (C) 2024 Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ex3.entities;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 19/04/2024
 * @brief Class ListaOrdenada
 */



public class ListaOrdenada extends Lista{
    
    public ListaOrdenada(){
  
    }
    @Override
    public void inserirNumero(int numero){
        lista.add(numero);
    }
    
    @Override
    public void removerNumero(int numero){
        for(Integer i = 0; i < lista.size(); i++){
            System.out.println(i + " - " + lista.get(i));
        }
        System.out.println("Escolha o valor que deseja remover: ");
        numero = sc.nextInt();
        if(numero >= 0 && numero <= lista.size()){
            lista.remove(numero);
            System.out.println("Numero removido com sucesso");
        }else{
            System.out.println("Valor digitado é invalido tente novamente");
        }
    }
    
    @Override
    public Integer informarQtdNumeros(){
        return lista.size() + 1;
    }
    
    @Override
    public void informarValores(){
        for(Integer i = 0; i < lista.size(); i++){
            System.out.println(i + " - " + lista.get(i));
        }
    }
    
    @Override
    public void exibirValores(){
        for(Integer i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i));
        }
    }
    
    public void ordenarLista(){
        Collections.sort(lista);
        System.out.println("Ordenado com sucesso");
    } 
}
