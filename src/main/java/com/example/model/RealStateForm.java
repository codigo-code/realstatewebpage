package com.example.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class RealStateForm implements Serializable{

	private static final long serialVersionUID = -8665469533411174703L;

	private int id;
	private String reference;
	private String onStreet;
	private String Streetnumber;
	private String onStreetbtwone;
	private String onStreetbtwtwo;
	private String status;
	private String mcc;
	private String mcd;
	private String toilette;
	private String canttoilette;
	private String garage;
	private String garaberoof;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getOnStreet() {
		return onStreet;
	}
	public void setOnStreet(String onStreet) {
		this.onStreet = onStreet;
	}
	public String getStreetnumber() {
		return Streetnumber;
	}
	public void setStreetnumber(String streetnumber) {
		Streetnumber = streetnumber;
	}
	public String getOnStreetbtwone() {
		return onStreetbtwone;
	}
	public void setOnStreetbtwone(String onStreetbtwone) {
		this.onStreetbtwone = onStreetbtwone;
	}
	public String getOnStreetbtwtwo() {
		return onStreetbtwtwo;
	}
	public void setOnStreetbtwtwo(String onStreetbtwtwo) {
		this.onStreetbtwtwo = onStreetbtwtwo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMcc() {
		return mcc;
	}
	public void setMcc(String mcc) {
		this.mcc = mcc;
	}
	public String getMcd() {
		return mcd;
	}
	public void setMcd(String mcd) {
		this.mcd = mcd;
	}
	public String getToilette() {
		return toilette;
	}
	public void setToilette(String toilette) {
		this.toilette = toilette;
	}
	public String getCanttoilette() {
		return canttoilette;
	}
	public void setCanttoilette(String canttoilette) {
		this.canttoilette = canttoilette;
	}
	public String getGarage() {
		return garage;
	}
	public void setGarage(String garage) {
		this.garage = garage;
	}
	public String getGaraberoof() {
		return garaberoof;
	}
	public void setGaraberoof(String garaberoof) {
		this.garaberoof = garaberoof;
	}

}
