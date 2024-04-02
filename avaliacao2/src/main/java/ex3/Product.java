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

package ex3;

/**
 * @author Rodrigo Ramos <rodrigoramos.rr221@gmail.com>
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 01/04/2024
 * @brief Class Product
 */
public abstract class Product {
    private String name;
    private double price;
    private int numbersOfCopies;
    
    public Product(){
        
    }
    
    public Product(String name, double price, int numbersOfCopies){
        super();
        this.name = name;
        this.price = price;
        this.numbersOfCopies = numbersOfCopies;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setNumbersOfCopies(int numbersOfCopies){
        this.numbersOfCopies = numbersOfCopies;
    }
    
    public String getName(){
        return name;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getNumbersOfCopies(){
        return numbersOfCopies;
    }
    
    public void sellCopies(){
   
    }
    
    public void orderCopies(int num){
        
    }
}
