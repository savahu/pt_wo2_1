/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.Filter.Coffee;

/**
 *
 * @author Dominique
 */
    public enum CoffeeEnum {
	 Making ("M"), Serving ("S"), Ready("R");

	private String coffeeCode;

	private CoffeeEnum(String d) {
		coffeeCode = d;
	}

	public String getStatusCode() {
		return coffeeCode;
	}

}
