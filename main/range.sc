MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *********************************** Shooting Range Oddjob *******************************
// ********************************** The Shooting Competition *****************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME range

// Mission start stuff

GOSUB mission_start_range

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_range_failed
ENDIF

GOSUB mission_cleanup_range

MISSION_END

{
 
// ******************************************** Mission Start ******************************

mission_start_range:

flag_player_on_mission = 1

IF player_had_reload_award = 0
	REGISTER_MISSION_GIVEN
ENDIF

// General stuff

total_ammo_used_bankjob2 = 0

ammo_used_round1_bankjob2 = 0

final_ammo_used_bankjob2 = 0

percentage_hits_bankjob2 = 0

score_to_beat_bankjob2 = 30

player_score_bankjob2 = 0

ammo_given_round1_bankjob2 = 0

bits_hit_bank2 = 0

// Round1

timer_round1_bankjob2 = 121000 // 2 mins

counter_hits_scored_round1_bankjob2 = 0

//score_round_one_bankjob2 = 0

flag_round1_finished_bankjob2 = 0

ammo_round1_bankjob = 0

// Slot1

target_1_bankjob2_dead = 0

target1_part1_dead_bankjob2 = 0

target1_part2_dead_bankjob2 = 0

target1_part3_dead_bankjob2 = 0

target1_part4_dead_bankjob2 = 0

target1_part5_dead_bankjob2 = 0

slot1_x_bankjob2 = 0.0
 
slot1_y_bankjob2 = 0.0

slot1_z_bankjob2 = 0.0

slot1_filled_round1_bankjob2 = 0

// Location One Round one 

slot1_x_bankjob2 = -673.29 
slot1_y_bankjob2 = 1238.52 
slot1_z_bankjob2 = 11.50

// Slot2

target_2_bankjob2_dead = 0

target2_part1_dead_bankjob2 = 0

target2_part2_dead_bankjob2 = 0

target2_part3_dead_bankjob2 = 0

target2_part4_dead_bankjob2 = 0

target2_part5_dead_bankjob2 = 0

slot2_x_bankjob2 = 0.0
 
slot2_y_bankjob2 = 0.0

slot2_z_bankjob2 = 0.0

slot2_filled_round1_bankjob2 = 0

targ2_x_bankjob2 = 0.0 

targ2_y_bankjob2 = 0.0

targ2_z_bankjob2 = 0.0

target2_travel_bank2 = 0

// Location Two Round one

slot2_x_bankjob2 = -676.11  
slot2_y_bankjob2 = 1227.00 // 1238.52  
slot2_z_bankjob2 = 11.50

// Slot3

target_3_bankjob2_dead = 0

target3_part1_dead_bankjob2 = 0

target3_part2_dead_bankjob2 = 0

target3_part3_dead_bankjob2 = 0

target3_part4_dead_bankjob2 = 0

target3_part5_dead_bankjob2 = 0

slot3_x_bankjob2 = 0.0
 
slot3_y_bankjob2 = 0.0

slot3_z_bankjob2 = 0.0

slot3_filled_round1_bankjob2 = 0

targ3_x_bankjob2 = 0.0 

targ3_y_bankjob2 = 0.0

targ3_z_bankjob2 = 0.0

target3_travel_bank2 = 0

// Location Three Round one

slot3_x_bankjob2 = -679.04 
slot3_y_bankjob2 = 1238.52
slot3_z_bankjob2 = 11.50

// Slot 4 pistol weapons

slot4_weapon_type_bank2 = 0 

slot4_ammo_bank2 = 0

slot4_model_bank2 = 0

// New time out stuff

flag_time_out_round1_bank2 = 0

WAIT 0

LOAD_MISSION_TEXT BANKJ2

// ***************************************** REQUESTS THE MODELS ***************************

// requests models

SHUT_PLAYER_UP player1 TRUE

SET_PLAYER_CONTROL player1 OFF // SCFIX

REQUEST_MODEL COLT45

REQUEST_MODEL tar_frame

REQUEST_MODEL tar_downleft

REQUEST_MODEL tar_downright

REQUEST_MODEL tar_top

REQUEST_MODEL tar_upleft

REQUEST_MODEL tar_upright

REQUEST_MODEL faketarget

LOAD_MISSION_AUDIO 1 ( BNK2_1 ) // Live Ammo

LOAD_MISSION_AUDIO 2 ( BNK2_2 ) // Aim 3-2-1 fire 

WHILE NOT 
OR NOT HAS_MODEL_LOADED COLT45
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
OR NOT HAS_MODEL_LOADED faketarget

	WAIT 0
      
ENDWHILE

WHILE NOT HAS_MODEL_LOADED tar_frame
OR NOT HAS_MODEL_LOADED tar_downleft
OR NOT HAS_MODEL_LOADED tar_downright
OR NOT HAS_MODEL_LOADED tar_top
OR NOT HAS_MODEL_LOADED tar_upleft
OR NOT HAS_MODEL_LOADED tar_upright 

	WAIT 0
	
ENDWHILE

// Creates the invisible target to stick palyer on

CREATE_OBJECT_NO_OFFSET faketarget -668.42 1231.65 10.08 object1_bankjob2
DONT_REMOVE_OBJECT object1_bankjob2
SET_OBJECT_HEADING object1_bankjob2 90.0   

// sets up player1 in 1st person camera mode and locks him in position.

GET_CHAR_WEAPON_IN_SLOT scplayer 4 slot4_weapon_type_bank2 slot4_ammo_bank2 slot4_model_bank2

// SCFIX: START - make sure the model is not unloaded (COLT45 is already requested for the mission)
IF NOT slot4_model_bank2 = COLT45
AND slot4_ammo_bank2 > 0
	REQUEST_MODEL slot4_model_bank2
ENDIF
// SCFIX: END

// SCFIX: START - nil player's ammo before attach
SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_PISTOL
SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 0
// SCFIX: END

SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED // SCFIX: moved before attach
ATTACH_CHAR_TO_OBJECT scplayer object1_bankjob2 0.0 -2.0 1.0 FACING_FORWARD 60.0 WEAPONTYPE_PISTOL
SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_PISTOL
SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 100
ammo_given_round1_bankjob2 = 100

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

// SCFIX: START - tidy up this big ass chunk
LVAR_INT range_tutor_state
range_tutor_state = 0

WHILE range_tutor_state < 6
	WAIT 0

	IF range_tutor_state > 0
		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_range
		ENDIF
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF

	IF range_tutor_state = 0
		IF NOT GET_FADING_STATUS
			range_tutor_state = 1
		ENDIF
	ENDIF

	IF range_tutor_state = 1
		PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!
		timera = 0
		range_tutor_state = 2
	ENDIF

	IF range_tutor_state = 2
	AND timera >= 5000
		PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!
		timera = 0
		range_tutor_state = 3
	ENDIF

	IF range_tutor_state = 3
	AND timera >= 5000
		PRINT_NOW ( BJM2_2 ) 8000 1 //"To exit the round press the ^ button."
		timera = 0
		range_tutor_state = 4
	ENDIF

	IF range_tutor_state = 4
	AND timera >= 5000
		PRINT_NOW ( BJM2_23 ) 8000 1 //"If you leave the shooting range during the competition, you will fail the mission."
		timera = 0
		range_tutor_state = 5
	ENDIF

	IF range_tutor_state = 5
	AND timera >= 5000
		range_tutor_state = 6
	ENDIF

ENDWHILE
// SCFIX: END

/* SCFIX: all this was rewritten above
WHILE GET_FADING_STATUS

	WAIT 0
      
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF

ENDWHILE

SET_PLAYER_CONTROL player1 ON

IF IS_BUTTON_PRESSED PAD1 CROSS
OR IS_BUTTON_PRESSED PAD1 START
	GOTO mission_skip_range
ENDIF 

PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_range
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_range
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_2 ) 8000 1 //"To exit the round press the ^ button."

timera = 0

WHILE timera < 5000

	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_range
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_23 ) 8000 1 //"If you leave the shooting range during the competition, you will fail the mission."

timera = 0

WHILE timera < 5000

	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_range
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF

ENDWHILE
*/

mission_skip_range:

SET_PLAYER_CONTROL player1 ON
PRINT_NOW ( BNK2_1 ) 5000 1 //"LIVE AMMO"
PLAY_MISSION_AUDIO 1 // Live ammo

SET_POLICE_IGNORE_PLAYER player1 ON

SET_EVERYONE_IGNORE_PLAYER player1 ON

blob_flag = 1

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1 // Live ammo

	WAIT 0
		
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF
		
ENDWHILE

CLEAR_THIS_PRINT ( BNK2_1 ) // LIVE AMMO

PLAY_MISSION_AUDIO 2 // Aim 3-2-1 fire

PRINT_NOW ( BNK2_2 ) 5000 1 //"Aim 3-2-1 fire"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2 // aim

	WAIT 0
      
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF
	
ENDWHILE

CLEAR_THIS_PRINT ( BNK2_2 ) // FIRE

DISPLAY_ONSCREEN_TIMER timer_round1_bankjob2 TIMER_DOWN

DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING score_to_beat_bankjob2 COUNTER_DISPLAY_NUMBER 2 ( BJM2_18 )

DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING player_score_bankjob2 COUNTER_DISPLAY_NUMBER 1 ( BJM2_15 )

timera = 0

ADD_CONTINUOUS_SOUND -679.403 1232.564 11.105 SOUND_SHOOTING_RANGE_TARGET_MOVING_LOOP target_moving_sound_bank2

WHILE flag_round1_finished_bankjob2 = 0

	WAIT 0

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_range_failed
	ENDIF
		
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		flag_round1_finished_bankjob2 = 1
	ENDIF	
		
	IF round_clear_audio_loaded_bankjob2 = 0
		LOAD_MISSION_AUDIO 1 ( BNK2_3 ) // Area clear
		round_clear_audio_loaded_bankjob2 = 1
	ENDIF

	IF round_clear_audio_loaded_bankjob2 = 1
	
		IF HAS_MISSION_AUDIO_LOADED 1 // Area clear
			round_clear_audio_loaded_bankjob2 = 2
		ENDIF

	ENDIF	    	
						
	CLEAR_WANTED_LEVEL player1

	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL ammo_round1_bankjob
		
	IF timer_round1_bankjob2 = 0
	OR ammo_round1_bankjob = 0

		IF flag_time_out_round1_bank2 = 0
			timera = 0
			flag_time_out_round1_bank2 = 1
		ELSE
	
			IF timera > 200
				PLAY_MISSION_AUDIO 1 // area clear
				PRINT_NOW ( BNK2_3 ) 5000 1 //"area clear!"
				flag_round1_done_right_bankjob2 = 1 
				flag_round1_finished_bankjob2 = 1	
   			ENDIF

		ENDIF

	ENDIF
   	
	GET_GAME_TIMER game_time_round1_bankjob2
	   	
// slot 1
	
	IF create_timer_targ1_round1_bankjob2 = 0
		GET_GAME_TIMER game_time_round1_bankjob2
		timer_create_targ1_round1_bankjob2 = game_time_round1_bankjob2
		create_timer_targ1_round1_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ1_round1_bankjob2 = 1 
		targ1_round1_movetime_bankjob2 = game_time_round1_bankjob2 - timer_create_targ1_round1_bankjob2
	ENDIF

	IF targ1_round1_movetime_bankjob2 >= 2000
						
		IF slot1_filled_round1_bankjob2 = 0

			CREATE_OBJECT tar_frame slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_frame_bankjob2
			SET_OBJECT_HEADING target1_frame_bankjob2 90.0 

			CREATE_OBJECT tar_downleft slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part1_bankjob2
			SET_OBJECT_HEADING target1_part1_bankjob2 90.0

			CREATE_OBJECT tar_downright slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part2_bankjob2
			SET_OBJECT_HEADING target1_part2_bankjob2 90.0

			CREATE_OBJECT tar_top slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part3_bankjob2
			SET_OBJECT_HEADING target1_part3_bankjob2 90.0

			CREATE_OBJECT tar_upleft slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part4_bankjob2
			SET_OBJECT_HEADING target1_part4_bankjob2 90.0

			CREATE_OBJECT tar_upright slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part5_bankjob2
			SET_OBJECT_HEADING target1_part5_bankjob2 90.0
		
			target_1_bankjob2_dead = 0
			target1_part1_dead_bankjob2 = 0
			target1_part2_dead_bankjob2 = 0
			target1_part3_dead_bankjob2 = 0
			target1_part4_dead_bankjob2 = 0
			target1_part5_dead_bankjob2 = 0
			target1_travel_bank2 = 0 // tells target to go left
			slot1_filled_round1_bankjob2 = 1
		ENDIF

	ENDIF
	
// Moves target one to left and right then to right if its destroyed			

	IF slot1_filled_round1_bankjob2 = 1

		IF target_1_bankjob2_dead = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target1_frame_bankjob2  
   				GET_OBJECT_COORDINATES target1_frame_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
   			ENDIF

			IF target1_travel_bank2 = 0 

  				IF targ1_y_bankjob2 <= 1228.70  // 1228.50 
  					target1_travel_bank2 = 1 // right
  				ELSE 
  					targ1_y_bankjob2 = targ1_y_bankjob2 -@ 0.06
  				ENDIF
	   
  			ELSE
		
   				IF targ1_y_bankjob2 >= 1236.50 
   					target1_travel_bank2 = 0 // left	  
   				ELSE
					targ1_y_bankjob2 = targ1_y_bankjob2 +@ 0.06
   				ENDIF

  			ENDIF

		ELSE
		
			IF NOT HAS_OBJECT_BEEN_DAMAGED target1_frame_bankjob2  
   				GET_OBJECT_COORDINATES target1_frame_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
   			
				IF targ1_y_bankjob2 >= 1239.0
					IF NOT HAS_OBJECT_BEEN_DAMAGED target1_frame_bankjob2
						DELETE_OBJECT target1_frame_bankjob2  
					ENDIF
   					slot1_filled_round1_bankjob2 = 0
   					create_timer_targ1_round1_bankjob2 = 0	  
   				ELSE
					targ1_y_bankjob2 = targ1_y_bankjob2 +@ 0.06 
   				ENDIF
			
			ENDIF

		ENDIF
   		  		
  	ENDIF 
	   
// Target One

	IF slot1_filled_round1_bankjob2 = 1
	
		SET_OBJECT_COORDINATES target1_frame_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
 		
		IF target_1_bankjob2_dead = 0
				   				
			IF target1_part1_dead_bankjob2 = 1
			AND target1_part2_dead_bankjob2 = 1
		   	AND target1_part3_dead_bankjob2 = 1
		   	AND target1_part4_dead_bankjob2 = 1
		   	AND target1_part5_dead_bankjob2 = 1
				++ targets_really_hit_round1_bank1
				++ counter_hits_scored_round1_bankjob2
				++ player_score_bankjob2
				create_timer_targ1_round1_bankjob2 = 0
				target_1_bankjob2_dead = 1
			ENDIF

// part one of the target
			
			IF target1_part1_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part1_bankjob2
					DELETE_OBJECT target1_part1_bankjob2
					++ bits_hit_bank2
					target1_part1_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part1_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF

			ENDIF 
			

// part two of the target
			
			IF target1_part2_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part2_bankjob2
					DELETE_OBJECT target1_part2_bankjob2
					++ bits_hit_bank2
					target1_part2_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part2_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
		   		ENDIF
				
			ENDIF

// part three of the target
			
			IF target1_part3_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part3_bankjob2
					DELETE_OBJECT target1_part3_bankjob2
					++ bits_hit_bank2
					target1_part3_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part3_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF
						   
			ENDIF

// part four of the target
			
			IF target1_part4_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part4_bankjob2
					DELETE_OBJECT target1_part4_bankjob2
					++ bits_hit_bank2
					target1_part4_dead_bankjob2 = 1
				ELSE
			 		SET_OBJECT_COORDINATES target1_part4_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF

			ENDIF
			
// part five of the target
			
			IF target1_part5_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part5_bankjob2
					DELETE_OBJECT target1_part5_bankjob2
					++ bits_hit_bank2
					target1_part5_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part5_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF

// ******************************************* Slot2 ***************************************

	IF create_timer_targ2_round1_bankjob2 = 0
		GET_GAME_TIMER game_time_round1_bankjob2
		timer_create_targ2_round1_bankjob2 = game_time_round1_bankjob2
		create_timer_targ2_round1_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ2_round1_bankjob2 = 1 
		targ2_round1_movetime_bankjob2 = game_time_round1_bankjob2 - timer_create_targ2_round1_bankjob2
	ENDIF
	
	IF targ2_round1_movetime_bankjob2 >= 2000 
							
		IF slot2_filled_round1_bankjob2 = 0

			CREATE_OBJECT tar_frame slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_frame_bankjob2
			SET_OBJECT_HEADING target2_frame_bankjob2 90.0 

			CREATE_OBJECT tar_downleft slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part1_bankjob2
			SET_OBJECT_HEADING target2_part1_bankjob2 90.0

			CREATE_OBJECT tar_downright slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part2_bankjob2
			SET_OBJECT_HEADING target2_part2_bankjob2 90.0

			CREATE_OBJECT tar_top slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part3_bankjob2
			SET_OBJECT_HEADING target2_part3_bankjob2 90.0

			CREATE_OBJECT tar_upleft slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part4_bankjob2
			SET_OBJECT_HEADING target2_part4_bankjob2 90.0

			CREATE_OBJECT tar_upright slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part5_bankjob2
			SET_OBJECT_HEADING target2_part5_bankjob2 90.0
		
			target_2_bankjob2_dead = 0
			target2_part1_dead_bankjob2 = 0
			target2_part2_dead_bankjob2 = 0
			target2_part3_dead_bankjob2 = 0
			target2_part4_dead_bankjob2 = 0
			target2_part5_dead_bankjob2 = 0
			target2_travel_bank2 = 1 // tells target to go right
			slot2_filled_round1_bankjob2 = 1
		ENDIF

	ENDIF
	
// Moves target one to left and right then to right if its destroyed			

	IF slot2_filled_round1_bankjob2 = 1

		IF target_2_bankjob2_dead = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target2_frame_bankjob2  
   				GET_OBJECT_COORDINATES target2_frame_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
   			ENDIF

			IF target2_travel_bank2 = 0 

  				IF targ2_y_bankjob2 <= 1228.70
  					target2_travel_bank2 = 1 // right
  				ELSE 
  					targ2_y_bankjob2 = targ2_y_bankjob2 -@ 0.04
  				ENDIF
	   
  			ELSE
		
   				IF targ2_y_bankjob2 >= 1236.50 
   					target2_travel_bank2 = 0 // left	  
   				ELSE
					targ2_y_bankjob2 = targ2_y_bankjob2 +@ 0.04
   				ENDIF

  			ENDIF
						
		ELSE
		
			IF NOT HAS_OBJECT_BEEN_DAMAGED target2_frame_bankjob2  
   				GET_OBJECT_COORDINATES target2_frame_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
   			
				IF targ2_y_bankjob2 <= 1227.00
					IF NOT HAS_OBJECT_BEEN_DAMAGED target2_frame_bankjob2
						DELETE_OBJECT target2_frame_bankjob2  
					ENDIF
   					slot2_filled_round1_bankjob2 = 0
   					create_timer_targ2_round1_bankjob2 = 0	  
   				ELSE
					targ2_y_bankjob2 = targ2_y_bankjob2 -@ 0.06
   				ENDIF
			
			ENDIF

		ENDIF
   		  		
  	ENDIF 
	   
// Target Two

	IF slot2_filled_round1_bankjob2 = 1
	
		SET_OBJECT_COORDINATES target2_frame_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
 		
		IF target_2_bankjob2_dead = 0
				   				
			IF target2_part1_dead_bankjob2 = 1
			AND target2_part2_dead_bankjob2 = 1
		   	AND target2_part3_dead_bankjob2 = 1
		   	AND target2_part4_dead_bankjob2 = 1
		   	AND target2_part5_dead_bankjob2 = 1
				++ targets_really_hit_round1_bank1
				++ counter_hits_scored_round1_bankjob2
				++ counter_hits_scored_round1_bankjob2
				++ player_score_bankjob2
				++ player_score_bankjob2
				create_timer_targ2_round1_bankjob2 = 0
				target_2_bankjob2_dead = 1
			ENDIF

// part one of the target
			
			IF target2_part1_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part1_bankjob2
					DELETE_OBJECT target2_part1_bankjob2
					++ bits_hit_bank2
					target2_part1_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part1_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF

			ENDIF 
			
// part two of the target
			
			IF target2_part2_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part2_bankjob2
					DELETE_OBJECT target2_part2_bankjob2
					++ bits_hit_bank2
					target2_part2_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part2_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
		   		ENDIF
				
			ENDIF

// part three of the target
			
			IF target2_part3_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part3_bankjob2
					DELETE_OBJECT target2_part3_bankjob2
					++ bits_hit_bank2
					target2_part3_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part3_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF
						   
			ENDIF

// part four of the target
			
			IF target2_part4_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part4_bankjob2
					DELETE_OBJECT target2_part4_bankjob2
					++ bits_hit_bank2
					target2_part4_dead_bankjob2 = 1
				ELSE
			 		SET_OBJECT_COORDINATES target2_part4_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF

			ENDIF
			
// part five of the target
			
			IF target2_part5_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part5_bankjob2
					DELETE_OBJECT target2_part5_bankjob2
					++ bits_hit_bank2
					target2_part5_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part5_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF

// ***************************************** SLOT3 *****************************************

// Slot Three

	IF create_timer_targ3_round1_bankjob2 = 0
		GET_GAME_TIMER game_time_round1_bankjob2
		timer_create_targ3_round1_bankjob2 = game_time_round1_bankjob2
		create_timer_targ3_round1_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ3_round1_bankjob2 = 1 
		targ3_round1_movetime_bankjob2 = game_time_round1_bankjob2 - timer_create_targ3_round1_bankjob2
	ENDIF

	IF targ3_round1_movetime_bankjob2 >= 2000
						
		IF slot3_filled_round1_bankjob2 = 0

			CREATE_OBJECT tar_frame slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_frame_bankjob2
			SET_OBJECT_HEADING target3_frame_bankjob2 90.0 

			CREATE_OBJECT tar_downleft slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part1_bankjob2
			SET_OBJECT_HEADING target3_part1_bankjob2 90.0

			CREATE_OBJECT tar_downright slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part2_bankjob2
			SET_OBJECT_HEADING target3_part2_bankjob2 90.0

			CREATE_OBJECT tar_top slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part3_bankjob2
			SET_OBJECT_HEADING target3_part3_bankjob2 90.0

			CREATE_OBJECT tar_upleft slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part4_bankjob2
			SET_OBJECT_HEADING target3_part4_bankjob2 90.0

			CREATE_OBJECT tar_upright slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part5_bankjob2
			SET_OBJECT_HEADING target3_part5_bankjob2 90.0
		
			target_3_bankjob2_dead = 0
			target3_part1_dead_bankjob2 = 0
			target3_part2_dead_bankjob2 = 0
			target3_part3_dead_bankjob2 = 0
			target3_part4_dead_bankjob2 = 0
			target3_part5_dead_bankjob2 = 0
			target3_travel_bank2 = 0 // tells target to go left
			slot3_filled_round1_bankjob2 = 1
		ENDIF

	ENDIF
	
// Moves target one to left and right then to right if its destroyed			

	IF slot3_filled_round1_bankjob2 = 1

		IF target_3_bankjob2_dead = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target3_frame_bankjob2  
   				GET_OBJECT_COORDINATES target3_frame_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
   			ENDIF

			IF target3_travel_bank2 = 0 

  				IF targ3_y_bankjob2 <= 1228.70
  					target3_travel_bank2 = 1 // right
  				ELSE 
  					targ3_y_bankjob2 = targ3_y_bankjob2 -@ 0.02
  				ENDIF
	   
  			ELSE
		
   				IF targ3_y_bankjob2 >= 1236.50 
   					target3_travel_bank2 = 0 // left	  
   				ELSE
					targ3_y_bankjob2 = targ3_y_bankjob2 +@ 0.02
   				ENDIF

  			ENDIF

		ELSE
		
			IF NOT HAS_OBJECT_BEEN_DAMAGED target3_frame_bankjob2  
   				GET_OBJECT_COORDINATES target3_frame_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
   			
				IF targ3_y_bankjob2 >= 1239.0
					IF NOT HAS_OBJECT_BEEN_DAMAGED target3_frame_bankjob2
						DELETE_OBJECT target3_frame_bankjob2  
					ENDIF
   					slot3_filled_round1_bankjob2 = 0
   					targ3_round1_movetime_bankjob2 = 0	  
   				ELSE
					targ3_y_bankjob2 = targ3_y_bankjob2 +@ 0.06 
   				ENDIF
			
			ENDIF

		ENDIF
   		  		
  	ENDIF 
	   
// Target Three

	IF slot3_filled_round1_bankjob2 = 1
	
		SET_OBJECT_COORDINATES target3_frame_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
 		
		IF target_3_bankjob2_dead = 0
				   				
			IF target3_part1_dead_bankjob2 = 1
			AND target3_part2_dead_bankjob2 = 1
		   	AND target3_part3_dead_bankjob2 = 1
		   	AND target3_part4_dead_bankjob2 = 1
		   	AND target3_part5_dead_bankjob2 = 1
				++ targets_really_hit_round1_bank1
				++ counter_hits_scored_round1_bankjob2
				++ counter_hits_scored_round1_bankjob2
				++ counter_hits_scored_round1_bankjob2
				++ player_score_bankjob2
				++ player_score_bankjob2
				++ player_score_bankjob2
				targ3_round1_movetime_bankjob2 = 0
				target_3_bankjob2_dead = 1
			ENDIF

// part one of the target
			
			IF target3_part1_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part1_bankjob2
					DELETE_OBJECT target3_part1_bankjob2
					++ bits_hit_bank2
					target3_part1_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part1_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF

			ENDIF 
			

// part two of the target
			
			IF target3_part2_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part2_bankjob2
					DELETE_OBJECT target3_part2_bankjob2
					++ bits_hit_bank2
					target3_part2_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part2_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
		   		ENDIF
				
			ENDIF

// part three of the target
			
			IF target3_part3_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part3_bankjob2
					DELETE_OBJECT target3_part3_bankjob2
					++ bits_hit_bank2
					target3_part3_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part3_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF
						   
			ENDIF

// part four of the target
			
			IF target3_part4_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part4_bankjob2
					DELETE_OBJECT target3_part4_bankjob2
					++ bits_hit_bank2
					target3_part4_dead_bankjob2 = 1
				ELSE
			 		SET_OBJECT_COORDINATES target3_part4_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF

			ENDIF
			
// part five of the target
			
			IF target3_part5_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part5_bankjob2
					DELETE_OBJECT target3_part5_bankjob2
					++ bits_hit_bank2
					target3_part5_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part5_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF
		
ENDWHILE

REMOVE_SOUND target_moving_sound_bank2

IF flag_round1_done_right_bankjob2 = 1

	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1 // Area clear

		WAIT 0
				
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
			PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
			GOTO mission_range_failed
		ENDIF
   	
	ENDWHILE

ENDIF

CLEAR_THIS_PRINT ( BJM2_19 )

CLEAR_THIS_PRINT ( BJM2_20 )

CLEAR_THIS_PRINT ( BJM2_2 )

CLEAR_THIS_PRINT ( BNK2_3 ) // Area clear

ammo_used_round1_bankjob2 = ammo_given_round1_bankjob2 - ammo_round1_bankjob 

SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED

CLEAR_ONSCREEN_TIMER timer_round1_bankjob2 

PRINT_WITH_NUMBER_BIG ( RANGE_1 ) counter_hits_scored_round1_bankjob2 4000 1 // Score round 1

WAIT 4000

// totals up players percentage of hits

percentage_hits_bankjob2 = bits_hit_bank2 * 100

IF ammo_used_round1_bankjob2 > 0  
	percentage_hits_bankjob2 =  percentage_hits_bankjob2 / ammo_used_round1_bankjob2
ELSE
	percentage_hits_bankjob2 = 0
ENDIF	

PRINT_WITH_NUMBER_BIG ( BJM2_3 ) percentage_hits_bankjob2 4000 1 // percent hit rate

WAIT 4000

CLEAR_THIS_BIG_PRINT ( BJM2_3 )

DETACH_CHAR_FROM_CAR scplayer

DELETE_OBJECT object1_bankjob2

SET_PLAYER_CONTROL player1 ON

IF player_score_bankjob2 >= 45

	IF player_had_reload_award = 0
		PLAYER_MADE_PROGRESS 1
		SET_PLAYER_FAST_RELOAD player1 TRUE
		PRINT_NOW ( RELOAD ) 5000 1 //"You have won the fast reload ability!"
		player_had_reload_award = 1
	ENDIF
	
ENDIF

IF player_score_bankjob2 > score_to_beat_bankjob2
	GOTO mission_range_passed	
ELSE
	GOTO mission_range_failed
ENDIF 


// ****************************************** Mission Failed *******************************

mission_range_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

// *************************************** Mission Passed **********************************

mission_range_passed:

SET_CAR_DENSITY_MULTIPLIER 1.0
PRINT_WITH_NUMBER_BIG ( M_PASS ) 500 5000 1 //"Mission Passed!"
ADD_SCORE player1 500

IF flag_passed_range = 0
	REGISTER_ODDJOB_MISSION_PASSED
	flag_passed_range = 1
ENDIF

PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
REGISTER_HIGHEST_SCORE 0 player_score_bankjob2
REGISTER_HIGHEST_SCORE 1 percentage_hits_bankjob2
RETURN

// *************************************** Mission Cleanup *********************************

mission_cleanup_range:

REMOVE_SOUND target_moving_sound_bank2

DELETE_OBJECT target1_frame_bankjob2
DELETE_OBJECT target1_part1_bankjob2
DELETE_OBJECT target1_part2_bankjob2
DELETE_OBJECT target1_part3_bankjob2
DELETE_OBJECT target1_part4_bankjob2
DELETE_OBJECT target1_part5_bankjob2
DELETE_OBJECT target2_frame_bankjob2
DELETE_OBJECT target2_part1_bankjob2
DELETE_OBJECT target2_part2_bankjob2
DELETE_OBJECT target2_part3_bankjob2
DELETE_OBJECT target2_part4_bankjob2
DELETE_OBJECT target2_part5_bankjob2
DELETE_OBJECT target3_frame_bankjob2
DELETE_OBJECT target3_part1_bankjob2
DELETE_OBJECT target3_part2_bankjob2
DELETE_OBJECT target3_part3_bankjob2
DELETE_OBJECT target3_part4_bankjob2
DELETE_OBJECT target3_part5_bankjob2

DETACH_CHAR_FROM_CAR scplayer

IF slot4_ammo_bank2 > 0
	//REQUEST_MODEL slot4_model_bank2 // SCFIX: removed now, we leave the model loaded

	//LOAD_ALL_MODELS_NOW // SCFIX: removed now, we leave the model loaded

	GIVE_WEAPON_TO_PLAYER player1 slot4_weapon_type_bank2 slot4_ammo_bank2 // SCFIX: moved into if block

	IF NOT slot4_model_bank2 = COLT45 // SCFIX: COLT45 will be unloaded below
		MARK_MODEL_AS_NO_LONGER_NEEDED slot4_model_bank2 // SCFIX: moved into if block
	ENDIF // SCFIX
ENDIF

flag_player_on_mission = 0
flag_player_on_bank_2 = 0 // Used for interior loading stu
SHUT_PLAYER_UP player1 FALSE
DELETE_OBJECT object1_bankjob2
CLEAR_ONSCREEN_COUNTER player_score_bankjob2
CLEAR_ONSCREEN_COUNTER score_to_beat_bankjob2
CLEAR_ONSCREEN_TIMER timer_round1_bankjob2
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED tar_frame
MARK_MODEL_AS_NO_LONGER_NEEDED tar_downleft
MARK_MODEL_AS_NO_LONGER_NEEDED tar_downright
MARK_MODEL_AS_NO_LONGER_NEEDED tar_top
MARK_MODEL_AS_NO_LONGER_NEEDED tar_upleft
MARK_MODEL_AS_NO_LONGER_NEEDED tar_upright
MARK_MODEL_AS_NO_LONGER_NEEDED faketarget
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

}
