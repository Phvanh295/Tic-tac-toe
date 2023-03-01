package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread;  

import View.ViewTicToe;

public class ListenerTicToe implements ActionListener{
	private ViewTicToe vtt;
	public int mode_value = 0;
	public int current_player_value = 0;

	public ListenerTicToe(ViewTicToe vtt) {
		this.vtt = vtt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println(e.getActionCommand());
		if (e.getSource().toString().indexOf("help_button.png")!=-1) {
			vtt.help_monitor();
		} else if (e.getActionCommand()=="Back") {
			vtt.mtt.matrix_tic_toe[0][0]=0;
			vtt.mtt.matrix_tic_toe[0][1]=0;
			vtt.mtt.matrix_tic_toe[0][2]=0;
			vtt.mtt.matrix_tic_toe[1][0]=0;
			vtt.mtt.matrix_tic_toe[1][1]=0;
			vtt.mtt.matrix_tic_toe[1][2]=0;
			vtt.mtt.matrix_tic_toe[2][0]=0;
			vtt.mtt.matrix_tic_toe[2][1]=0;
			vtt.mtt.matrix_tic_toe[2][2]=0;
			vtt.show_matrix();
			vtt.game_play_jlabel_result.setVisible(false);
			vtt.enable_matrix(1);
			vtt.main_monitor();
		} else if (e.getActionCommand()=="Computer") {
			vtt.mtt.go_first_value=0;
		} else if (e.getActionCommand()=="Player") {
			vtt.mtt.go_first_value=1;
		} else if (e.getSource().toString().indexOf("setting_button.png")!=-1) {
			vtt.setting_monitor();
		} else if (e.getActionCommand()=="+") {
			vtt.inc_volume();
		} else if (e.getActionCommand()=="-") {
			vtt.dec_volume();
		} else if (e.getSource().toString().indexOf("easy_level")!=-1) {
			vtt.mtt.setLevel_value(0);
			vtt.change_color_level(1);
		} else if (e.getSource().toString().indexOf("medium_level")!=-1) {
			vtt.mtt.setLevel_value(1);
			vtt.change_color_level(2);
		} else if (e.getSource().toString().indexOf("difficult_level")!=-1) {
			vtt.mtt.setLevel_value(2);
			vtt.change_color_level(3);
		} else if (e.getSource().toString().indexOf("1 player.png")!=-1) {
			current_player_value = 3;
			mode_value = 1;
			if (mode_value==1){
				vtt.change_turn_color(0);
			}
			vtt.game_play_monitor();
			vtt.check_matrix();
			if (vtt.mtt.go_first_value==0) {
				if (vtt.mtt.getLevel_value()==0) {
					int bien_so = random(1,9);
					if (bien_so==1) vtt.go_line(2, "o1");
					if (bien_so==2) vtt.go_line(2, "o2");
					if (bien_so==3) vtt.go_line(2, "o3");
					if (bien_so==4) vtt.go_line(2, "o4");
					if (bien_so==5) vtt.go_line(2, "o5");
					if (bien_so==6) vtt.go_line(2, "o6");
					if (bien_so==7) vtt.go_line(2, "o7");
					if (bien_so==8) vtt.go_line(2, "o8");
					if (bien_so==9) vtt.go_line(2, "o9");
				}
				else vtt.go_line(2, "o5");
				vtt.show_matrix();
			}
			
		} else if ( e.getSource().toString().indexOf("2 player.png")!=-1) {
			current_player_value = 0;
			mode_value = 2;
			if (mode_value==2){
				vtt.change_turn_color(1);
			}
			vtt.game_play_monitor();
			vtt.check_matrix();
			if (vtt.mtt.go_first_value==0) {
				if (vtt.mtt.getLevel_value()==0) {
					int bien_so = random(1,9);
					if (bien_so==1) vtt.go_line(2, "o1");
					if (bien_so==2) vtt.go_line(2, "o2");
					if (bien_so==3) vtt.go_line(2, "o3");
					if (bien_so==4) vtt.go_line(2, "o4");
					if (bien_so==5) vtt.go_line(2, "o5");
					if (bien_so==6) vtt.go_line(2, "o6");
					if (bien_so==7) vtt.go_line(2, "o7");
					if (bien_so==8) vtt.go_line(2, "o8");
					if (bien_so==9) vtt.go_line(2, "o9");
				}
				else vtt.go_line(2, "o5");
				vtt.show_matrix();
			}
			
		}

		 else if (e.getActionCommand()=="o1") {
			if (mode_value==1){
				vtt.go_line(1,"o1");
				vtt.check_matrix();
			
				if (vtt.game_play_jlabel_result.isVisible()){

				}
				else if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o1");
				if (current_player_value==1) vtt.go_line(2,"o1");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}
		} else if (e.getActionCommand()=="o2") {
			if (mode_value==1){
				vtt.go_line(1,"o2");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){

				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o2");
				if (current_player_value==1) vtt.go_line(2,"o2");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}
			
		} else if (e.getActionCommand()=="o3") {
			if (mode_value==1){
				vtt.go_line(1,"o3");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){

				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o3");
				if (current_player_value==1) vtt.go_line(2,"o3");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}
			
		} else if (e.getActionCommand()=="o4") {
			if (mode_value==1){
				vtt.go_line(1,"o4");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){

				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o4");
				if (current_player_value==1) vtt.go_line(2,"o4");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}
			
		} else if (e.getActionCommand()=="o5") {
			if (mode_value==1){
				vtt.go_line(1,"o5");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){
	
				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o5");
				if (current_player_value==1) vtt.go_line(2,"o5");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}
			
		} else if (e.getActionCommand()=="o6") {
			if (mode_value==1){
				vtt.go_line(1,"o6");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){
	
				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o6");
				if (current_player_value==1) vtt.go_line(2,"o6");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}

		} else if (e.getActionCommand()=="o7") {
			if (mode_value==1){
				vtt.go_line(1,"o7");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){
	
				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o7");
				if (current_player_value==1) vtt.go_line(2,"o7");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}

		} else if (e.getActionCommand()=="o8") {
			if (mode_value==1){
				vtt.go_line(1,"o8");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){
	
				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o8");
				if (current_player_value==1) vtt.go_line(2,"o8");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}

		} else if (e.getActionCommand()=="o9") {
			if (mode_value==1){
				vtt.go_line(1,"o9");
				vtt.check_matrix();
				if (vtt.game_play_jlabel_result.isVisible()){
	
				}
				else 
				if (vtt.mtt.getLevel_value()==0) {
					vtt.mtt.random_generate();
				} else if (vtt.mtt.getLevel_value()==1) {
					vtt.mtt.demon_generate();
				} else {
					vtt.mtt.god_generate();
				}
				vtt.show_matrix();
				vtt.check_matrix();
			}
			if (mode_value==2){
				if (current_player_value==0) vtt.go_line(1,"o9");
				if (current_player_value==1) vtt.go_line(2,"o9");
				vtt.check_matrix();
				vtt.show_matrix();
				if (current_player_value==0){
					current_player_value = 1;
					vtt.change_turn_color(2);
				} else{
					current_player_value = 0;
					vtt.change_turn_color(1);
				}
				
			}

		} else if (e.getActionCommand()=="Reset") {
			current_player_value = 0;
			vtt.mtt.matrix_tic_toe[0][0]=0;
			vtt.mtt.matrix_tic_toe[0][1]=0;
			vtt.mtt.matrix_tic_toe[0][2]=0;
			vtt.mtt.matrix_tic_toe[1][0]=0;
			vtt.mtt.matrix_tic_toe[1][1]=0;
			vtt.mtt.matrix_tic_toe[1][2]=0;
			vtt.mtt.matrix_tic_toe[2][0]=0;
			vtt.mtt.matrix_tic_toe[2][1]=0;
			vtt.mtt.matrix_tic_toe[2][2]=0;
			vtt.show_matrix();
			vtt.game_play_jlabel_result.setVisible(false);
			vtt.enable_matrix(1);
			if (vtt.mtt.go_first_value==0) {
				if (vtt.mtt.getLevel_value()==0) {
					int bien_so = random(1,9);
					if (bien_so==1) vtt.go_line(2, "o1");
					if (bien_so==2) vtt.go_line(2, "o2");
					if (bien_so==3) vtt.go_line(2, "o3");
					if (bien_so==4) vtt.go_line(2, "o4");
					if (bien_so==5) vtt.go_line(2, "o5");
					if (bien_so==6) vtt.go_line(2, "o6");
					if (bien_so==7) vtt.go_line(2, "o7");
					if (bien_so==8) vtt.go_line(2, "o8");
					if (bien_so==9) vtt.go_line(2, "o9");
				}
				else vtt.go_line(2, "o5");
				vtt.show_matrix();
			}
			
		}
	}
	public static int random(int a,int b) {  // sinh ra một số ngẫu nhiên từ a, b
		double x = Math.random(); 
		int xx = a;
		xx = xx + (int)(x*(b-a+1));
		return xx;
	}
}
