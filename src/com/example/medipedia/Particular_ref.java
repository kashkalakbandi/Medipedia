package com.example.medipedia;

public class Particular_ref {

	private String opt1 , opt2 , opt3;
	private int icon_num1,icon_num2,icon_num3,icon_num4,icon_num5,icon_num6;
	
	public Particular_ref(int icon_num1,String opt1,int icon_num2, String opt2,String opt3,int icon_num4,int icon_num5,int icon_num6 ){
		   super();
		   this.icon_num1 = icon_num1;
		   this.opt1 = opt1;
		   this.icon_num2 = icon_num2;
		   this.opt2=opt2;
		  
		   this.opt3=opt3;
		   
		   
		   this.icon_num4 = icon_num4;
		   this.icon_num5 = icon_num5;
		   this.icon_num6 = icon_num6;
		 
	   }
	   
	public String getOpt1() {
		return opt1;
	}
	public void setOpt1(String opt1) {
		this.opt1 = opt1;
	}
	public String getOpt2() {
		return opt2;
	}
	public void setOpt2(String opt2) {
		this.opt2 = opt2;
	}
	public String getOpt3() {
		return opt3;
	}
	public void setOpt3(String opt3) {
		this.opt3 = opt3;
	}
	public int getIcon_num1() {
		return icon_num1;
	}
	public void setIcon_num1(int icon_num1) {
		this.icon_num1 = icon_num1;
	}
	public int getIcon_num2() {
		return icon_num2;
	}
	public void setIcon_num2(int icon_num2) {
		this.icon_num2 = icon_num2;
	}
	
	public int getIcon_num4() {
		return icon_num4;
	}

	public void setIcon_num4(int icon_num4) {
		this.icon_num4 = icon_num4;
	}

	public int getIcon_num5() {
		return icon_num5;
	}

	public void setIcon_num5(int icon_num5) {
		this.icon_num5 = icon_num5;
	}

	public int getIcon_num6() {
		return icon_num6;
	}

	public void setIcon_num6(int icon_num6) {
		this.icon_num6 = icon_num6;
	}

}
