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

package ex1.entities;

/**
 * 
 * @author Gabriel Gomes Rodrigues Cheim <gabrielgrcheim2@gmail.com>
 * @date 08/04/2024
 * @brief Class Estudantes
 */
public class Estudantes {
    private String Name;
    private String Email;
    private int Room;
    
    public Estudantes(String Name, String Email, int Room){
        this.Name = Name;
        this.Email = Email;
        this.Room = Room;
    }

    public int getRoom() {
        return Room;
    }

    public void setRoom(int Room) {
        this.Room = Room;
    }
    
    public void setName(String Name){
        this.Name= Name;
    }
    
    public String getName(){
        return Name;
    }
    
    public void setEmail(String Email){
        this.Email = Email;
    }
    
    public String getEmail(){
        return Email;
    }
    
    @Override
    public String toString(){
        return Room +": " + Name + ", " + Email;
    }


}
