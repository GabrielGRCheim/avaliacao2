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
 * @brief Class Album
 */
public class Album extends Product{
    private String artist;
    
    public Album(String name, String artist, double price, int numbersOfCopies){
        super(name, price, numbersOfCopies);
        this.artist = artist;
    }
    
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    public String getArtist(){
        return artist;
    }
    
    @Override
    public String toString(){
        return "Album [ Name: " + getName() + " Artist: " + getArtist() + " Price: " + getPrice() + " Numbers of Copies: " + getNumbersOfCopies() + "]";
    }
}

