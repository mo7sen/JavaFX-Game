/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;


public class Number 
{
    public static boolean surrounds(double num1, double num2, double min, double max)
    {
        return ((num1 <= max && num1 >= min) ||
               (num2 <= max && num2 >= min) ||
               (num1 <= min && num2 >= max)); 
    }
}
