package com.example.medipedia;

public class Sch_items {
		

		private String opt , opt2,icon_num2;
		private int icon_num1 ,igb;

	   public Sch_items(String opt, String opt2,int icon_num1,String icon_num2,int igb){
		   super();
		   this.opt = opt;
		   this.opt2=opt2;
		   this.icon_num1 = icon_num1;
		   this.icon_num2 = icon_num2;
		   this.igb=igb;
	   }
	   

		public String getOpt() {
			return opt;
		}

		public String getOpt2(){
			return opt2;
			
			
			
		}
		public int getIcon_num1() {
			return icon_num1;
		}
		public String getIcon_num2() {
			return icon_num2;
		}
		public int getIgb() {
			return igb;
		}




	}


