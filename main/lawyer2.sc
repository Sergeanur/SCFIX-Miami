MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *************************************Lawyer mission 2**************************************
// **************************************BACKALLEY BAWL***************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

// Mission start stuff

GOSUB mission_start_lawyer2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_lawyer2_failed
ENDIF

GOSUB mission_cleanup_lawyer2

MISSION_END

{
// Variables for mission
VAR_INT played_buddy_sample1 ran_to_last_coords buddycar_blip_active played_sprint_help	any_bike_lawyer2
VAR_INT ambush_bloke1 ambush_bloke2 ambush_bloke3 ambush_bloke4 ambush_bloke5 ambush_bloke6 ambush_bloke7
VAR_INT ambush_bloke1_dead ambush_bloke2_dead ambush_bloke3_dead ambush_bloke4_dead ambush_bloke5_dead 
VAR_INT ambush_bloke6_dead ambush_bloke7_dead buddycar_blip	chef_cut_scene first_part_of_chef_cut drove_in_from_south
VAR_FLOAT blokeX blokeY blokeZ bud_Heading
LVAR_INT cs_bounca cs_ganga cs_gangb cs_gangc hotel_blip set_buddys_threat short_malibu_cut gun_blip_help
LVAR_INT ambush_blokes_obj_set cs_guncolt players_cellphone players_cellphone_blip on_the_phone_again
LVAR_INT set_players_control_back_on counter_badguys kent_paul1
VAR_INT law2_broken_car_audio1_played law2_broken_car_audio2_played buddycar_health // FIXMIAMI

// ***************************************Mission Start*************************************

mission_start_lawyer2:

REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME LAWYER2
WAIT 0

LOAD_MISSION_TEXT LAWYER2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 110.6 -824.2 9.6 327.9

counter_badguys = 0
ambush_bloke1_dead = 0
ambush_bloke2_dead = 0
ambush_bloke3_dead = 0
ambush_bloke4_dead = 0
ambush_bloke5_dead = 0
ambush_bloke6_dead = 0
ambush_bloke7_dead = 0
played_buddy_sample1 = 0
first_two_samples = 0
second_two_samples = 0
audio_is_loading = 0
audio_has_loaded = 0
set_buddys_threat = 0
ran_to_last_coords = 0
buddy_blip_active = 0
blokeX = 433.7
blokeY = -575.9
blokeZ = 9.7
short_malibu_cut = 0
buddycar_blip_active = 0
chef_cut_scene = 0
first_part_of_chef_cut = 0
ambush_blokes_obj_set = 0
on_the_phone_again = 0
gun_blip_help = 0
set_players_control_back_on = 0
played_sprint_help = 0
drove_in_from_south = 0

law2_broken_car_audio1_played = 0 // FIXMIAMI
law2_broken_car_audio2_played = 0 // FIXMIAMI
buddycar_health = 2000 // FIXMIAMI


CLEAR_HELP


SET_AREA_VISIBLE  VIS_LAWYERS 

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_MODEL CUTOBJ01 lwchara
LOAD_SPECIAL_MODEL CUTOBJ02 lwcharb
LOAD_SPECIAL_MODEL CUTOBJ03 lcfan
LOAD_SPECIAL_MODEL CUTOBJ04 lawdoor

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
OR NOT HAS_MODEL_LOADED CUTOBJ04
	WAIT 0

ENDWHILE

LOAD_SCENE 140.6 -1367.4 13.1

LOAD_CUTSCENE law_2a
SET_CUTSCENE_OFFSET 141.441 -1366.722 12.163
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_lwchara
SET_CUTSCENE_ANIM cs_lwchara lwchara

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_lwcharb
SET_CUTSCENE_ANIM cs_lwcharb lwcharb

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_lcfan
SET_CUTSCENE_ANIM_TO_LOOP lcfan
SET_CUTSCENE_ANIM cs_lcfan lcfan

CREATE_CUTSCENE_OBJECT CUTOBJ04 cs_lawdoor
SET_CUTSCENE_ANIM cs_lawdoor lawdoor

CLEAR_AREA 119.0 -826.8 9.8 0.5 TRUE
SET_PLAYER_COORDINATES player1 119.0 -826.8 9.8
SET_PLAYER_HEADING player1 60.0

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 987
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_A ) 10000 1 // Mission brief

WHILE cs_time < 6800
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_B ) 10000 1 // Mission brief

WHILE cs_time < 11088
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_C ) 10000 1 // Mission brief

WHILE cs_time < 12888
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_D ) 10000 1 // Mission brief

WHILE cs_time < 14496
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_E ) 10000 1 // Mission brief

WHILE cs_time < 17164
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_F ) 10000 1 // Mission brief

WHILE cs_time < 18793
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_G ) 10000 1 // Mission brief

WHILE cs_time < 22223
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_H ) 10000 1 // Mission brief

WHILE cs_time < 25376
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_I ) 10000 1 // Mission brief

WHILE cs_time < 28768
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_J ) 10000 1 // Mission brief

WHILE cs_time < 31266
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2_K ) 10000 1 // Mission brief

WHILE cs_time < 32433 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 33422
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE


DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_IN_FRONT_OF_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ04

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE 117.1 -825.6 9.8

flag_player_on_lawyer_2 = 1

DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_open 490.34 -77.017 11.598 malibu_doors
DONT_REMOVE_OBJECT malibu_doors
flag_malibu_doors_open = 1
flag_malibu_doors_closed = 0


WAIT 500

DO_FADE 1500 FADE_IN

// START OF MISSION

PRINT_NOW ( LAW2_6 ) 10000 2 //MEET KENT PAUL

ADD_BLIP_FOR_COORD kentX kentY kentZ kent_paul1

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 491.0 -77.7 10.4 2.0 2.0 3.0 TRUE
	WAIT 0

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 491.0 -77.7 10.4 2.0 2.0 3.0 TRUE
		IF IS_PLAYER_ON_ANY_BIKE player1
			STORE_CAR_PLAYER_IS_IN player1 any_bike_lawyer2
			GOTO kent_cut
		ENDIF
	ENDIF

ENDWHILE

kent_cut:

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION 502.203 -95.118 10.771 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 501.811 -94.212 10.930 JUMP_CUT

IF IS_PLAYER_ON_ANY_BIKE player1
	IF NOT IS_CAR_DEAD any_bike_lawyer2
		SET_CAR_COORDINATES any_bike_lawyer2 496.3 -82.8 9.0 
		SET_CAR_HEADING any_bike_lawyer2 116.6
	ENDIF
	WARP_PLAYER_FROM_CAR_TO_COORD player1 493.2 -79.7 10.4
ELSE
	SET_PLAYER_COORDINATES player1 493.2 -79.7 10.4
ENDIF

SET_PLAYER_HEADING player1 58.0
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 487.8 -74.3

WAIT 1000

SET_FADING_COLOUR 0 0 0
DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_CHAR_OBJ_NO_OBJ scplayer

flag_player_on_lawyer_2 = 0

DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_close 490.34 -77.017 11.598 malibu_doors
DONT_REMOVE_OBJECT malibu_doors
flag_malibu_doors_closed = 1
flag_malibu_doors_open = 0
flag_player_in_malibu = 0

REQUEST_MODEL infernus
REQUEST_MODEL colt45

// *******************************************START MEET KENT PAUL***********************************************

GET_GAME_TIMER breakout_timer_start
breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player1
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player1
 
SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF


LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSkent
LOAD_SPECIAL_CHARACTER 3 bounca
LOAD_SPECIAL_CHARACTER 4 floozyb


SET_AREA_VISIBLE VIS_MALIBU_CLUB 
SET_EXTRA_COLOURS 1 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0

ENDWHILE

LOAD_SCENE 476.972 -65.499 8.943

CLEAR_AREA 476.972 -65.499 8.943 15.0 TRUE

LOAD_CUTSCENE law_2b
SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
SET_NEAR_CLIP 0.3
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kent
SET_CUTSCENE_ANIM cs_kent CSkent

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_bounca
SET_CUTSCENE_ANIM cs_bounca bounca

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_floozyb
SET_CUTSCENE_ANIM cs_floozyb floozyb


CLEAR_AREA 493.1 -82.4 9.8 1.0 TRUE
SET_PLAYER_COORDINATES player1 493.1 -82.4 9.8 //484.2 -72.5 9.5 
SET_PLAYER_HEADING player1 220.0

DO_FADE 1500 FADE_IN

SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1018
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_A ) 10000 1 // Mission brief

WHILE cs_time < 2526
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_B ) 10000 1 // Mission brief

WHILE cs_time < 5339 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_D ) 10000 1 // Mission brief

WHILE cs_time < 9000  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_C ) 10000 1 // Mission brief

WHILE cs_time < 11311
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_E ) 10000 1 // Mission brief

WHILE cs_time < 12536
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_F ) 10000 1 // Mission brief

WHILE cs_time < 14601
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_G ) 10000 1 // Mission brief

WHILE cs_time < 16228
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_H ) 10000 1 // Mission brief

WHILE cs_time < 18290
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_I ) 10000 1 // Mission brief

WHILE cs_time < 20060
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_J ) 10000 1 // Mission brief

WHILE cs_time < 23582
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_K ) 10000 1 // Mission brief

WHILE cs_time < 31000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_L ) 10000 1 // Mission brief

WHILE cs_time < 34762
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_M ) 10000 1 // Mission brief

WHILE cs_time < 36141
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_N ) 10000 1 // Mission brief

WHILE cs_time < 37719
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_O ) 10000 1 // Mission brief

WHILE cs_time < 40549
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_P ) 10000 1 // Mission brief

WHILE cs_time < 42314
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_Q ) 10000 1 // Mission brief

WHILE cs_time < 44319
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_R ) 10000 1 // Mission brief

WHILE cs_time < 46344
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_S ) 10000 1 // Mission brief

WHILE cs_time < 50737
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_T ) 10000 1 // Mission brief

WHILE cs_time < 54654
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_U ) 10000 1 // Mission brief

WHILE cs_time < 60868
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_V ) 10000 1 // Mission brief

WHILE cs_time < 64355
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2B_W ) 10000 1 // Mission brief

WHILE cs_time < 66768 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
CLEAR_PRINTS

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_BIG ( BEACH3 ) 5000 2 //"Vice Point"

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER


UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3	 
UNLOAD_SPECIAL_CHARACTER 4

CLEAR_EXTRA_COLOURS FALSE
SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE 493.1 -82.4 9.8

// *******************************************END MEET KENT PAUL***********************************************

flag_player_on_lawyer_2	= 0

LOAD_SPECIAL_CHARACTER 3 chef
LOAD_SPECIAL_CHARACTER 4 igbuddy
REQUEST_MODEL cellphone

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED infernus
OR NOT HAS_MODEL_LOADED colt45 
	WAIT 0

ENDWHILE


WAIT 500

DO_FADE 1500 FADE_IN

REMOVE_BLIP kent_paul1

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 blokeX blokeY blokeZ ambush_bloke1 // FIXMIAMI: was PEDTYPE_CIVFEMALE


SET_CHAR_HEADING ambush_bloke1 70.0 
SET_CHAR_HEALTH ambush_bloke1 100

SET_CHAR_ANSWERING_MOBILE ambush_bloke1 TRUE
 
CLEAR_CHAR_THREAT_SEARCH ambush_bloke1

PRINT_NOW ( LAW2_7 ) 10000 2	//DUFF UP BLOKE

ADD_BLIP_FOR_CHAR ambush_bloke1 lawyer_blip1


TIMERB = 0

WHILE NOT IS_CHAR_DEAD ambush_bloke1
	WAIT 0

	IF chef_cut_scene = 0
		
		IF NOT IS_CHAR_DEAD	ambush_bloke1

			IF NOT IS_CHAR_HEALTH_GREATER ambush_bloke1 99
				SET_CHAR_ANSWERING_MOBILE ambush_bloke1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ambush_bloke1 player1
				chef_cut_scene = 1
			ENDIF

			
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 ambush_bloke1 8.0 8.0 3.0 FALSE
			//AND NOT IS_PLAYER_IN_ANY_CAR player1
				IF first_part_of_chef_cut = 0

					SET_PLAYER_CONTROL player1 OFF
					SWITCH_WIDESCREEN ON

					IF IS_PLAYER_IN_ANY_CAR player1
						SET_CHAR_OBJ_LEAVE_ANY_CAR scplayer
					ENDIF

					SET_FIXED_CAMERA_POSITION 434.913 -575.577 11.245 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT 433.925 -575.730 11.256 JUMP_CUT	//Shot of Chef
					WAIT 2000

					IF NOT IS_CHAR_DEAD	ambush_bloke1
						SET_FIXED_CAMERA_POSITION 431.418 -566.374 16.361 0.0 0.0 0.0
						POINT_CAMERA_AT_POINT 431.554 -567.186 15.795 JUMP_CUT	//High shot of Chef

						IF NOT IS_CHAR_DEAD	ambush_bloke1
							CHAR_LOOK_AT_CHAR_ALWAYS ambush_bloke1 scplayer
							CHAR_LOOK_AT_CHAR_ALWAYS scplayer ambush_bloke1
							TURN_CHAR_TO_FACE_CHAR ambush_bloke1 scplayer
							TURN_CHAR_TO_FACE_CHAR scplayer ambush_bloke1
						ENDIF

						TIMERB = 0
						WHILE IS_PLAYER_IN_ANY_CAR player1
							WAIT 0

							IF TIMERB > 2000
								WARP_PLAYER_FROM_CAR_TO_COORD Player1 428.4 -573.7 9.7
							ENDIF

						ENDWHILE

						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer blokeX blokeY //433.0 -575.9

						first_part_of_chef_cut = 1
					ENDIF
				ENDIF
			ENDIF

			IF first_part_of_chef_cut = 1
				IF NOT IS_CHAR_DEAD	ambush_bloke1

					IF first_two_samples = 0
					AND TIMERB > 0
						IF audio_is_loading = 0
							LOAD_MISSION_AUDIO 1 LAW2_1
							LOAD_MISSION_AUDIO 2 LAW2_2
							audio_is_loading = 1
						ELSE
							IF HAS_MISSION_AUDIO_LOADED	1
							AND HAS_MISSION_AUDIO_LOADED 2
								audio_has_loaded = 1
							ENDIF
						ENDIF

						IF audio_has_loaded = 1
							SHUT_PLAYER_UP player1 TRUE
							PLAY_MISSION_AUDIO 1
							IF NOT IS_CHAR_DEAD	ambush_bloke1
								SET_CHAR_ANSWERING_MOBILE ambush_bloke1 FALSE
							ENDIF
							PRINT_NOW ( LAW2_1 ) 2000 2	//Whatchoo lookin at?
							SET_CHAR_WAIT_STATE ambush_bloke1 WAITSTATE_PLAYANIM_CHAT 10000

							GET_CONTROLLER_MODE controlmode

							IF HAS_MISSION_AUDIO_FINISHED 1
								SET_CHAR_WAIT_STATE ambush_bloke1 WAITSTATE_FALSE 100
								
								WAIT 500
								PLAY_MISSION_AUDIO 2
								PRINT_NOW ( LAW2_2 ) 2000 2	//You better start talking..
								first_two_samples = 1
								audio_is_loading = 0
								audio_has_loaded = 0
								TIMERB = 0
							ENDIF
						ENDIF
					ENDIF
					
					IF NOT IS_CHAR_DEAD	ambush_bloke1
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D Player1 ambush_bloke1 0.7 0.7 2.0 FALSE
							SET_CHAR_OBJ_NO_OBJ scplayer
						ENDIF
					ENDIF

					IF first_two_samples = 1
					AND second_two_samples = 0
					AND TIMERB > 2000 
						IF audio_is_loading = 0
							LOAD_MISSION_AUDIO 1 LAW2_3
							audio_is_loading = 1
						ELSE
							IF HAS_MISSION_AUDIO_LOADED	1
								audio_has_loaded = 1
							ENDIF
						ENDIF

						IF audio_has_loaded = 1
							PLAY_MISSION_AUDIO 1
							PRINT_NOW ( LAW2_3 ) 2000 2	//Make me, you prick!
							SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000
							SET_CHAR_WAIT_STATE ambush_bloke1 WAITSTATE_PLAYANIM_CHAT 1500
							IF HAS_MISSION_AUDIO_FINISHED 1
								SHUT_PLAYER_UP player1 FALSE
								first_two_samples = 1
								second_two_samples = 1
								audio_is_loading = 0
								audio_has_loaded = 0
								TIMERB = 0
								chef_cut_scene = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

		ENDIF //IF NOT IS_CHAR_DEAD	ambush_bloke1

	ELSE
		
		IF set_players_control_back_on = 0
			IF NOT IS_CHAR_DEAD	ambush_bloke1
				STOP_CHAR_LOOKING ambush_bloke1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ambush_bloke1 player1
				SET_CHAR_OBJ_NO_OBJ scplayer
				SET_CHAR_WAIT_STATE ambush_bloke1 WAITSTATE_FALSE 0
				GET_CONTROLLER_MODE controlmode

				IF controlmode = 0
				OR controlmode = 1
					PRINT_HELP ( HELP17 ) // "Press the ~o~| ~w~button to attack the chef."
				ENDIF

				IF controlmode = 2
					PRINT_HELP ( HELP18 ) // "Press the~x~ / ~w~button to attack the chef."
				ENDIF
				
				IF controlmode = 3
					PRINT_HELP ( HELP55 ) // "Press the ~h~R1~w~ button to attack the chef."
				ENDIF
			ENDIF
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
			RESTORE_CAMERA_JUMPCUT
			SET_CAMERA_BEHIND_PLAYER
			set_players_control_back_on = 1
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_bloke1
			IF NOT LOCATE_CHAR_ON_FOOT_3D ambush_bloke1 433.7 -575.9 9.7 8.0 8.0 3.0 FALSE
				IF on_the_phone_again = 0
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT ambush_bloke1 433.7 -575.9
					on_the_phone_again = 1		    
				ENDIF
			ELSE
				IF on_the_phone_again = 1
					IF IS_CHAR_OBJECTIVE_PASSED ambush_bloke1
						SET_CHAR_ANSWERING_MOBILE ambush_bloke1 TRUE
						on_the_phone_again = 0
					ENDIF
				ENDIF
			ENDIF
			
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 433.7 -575.9 9.7 8.0 8.0 3.0 FALSE
				SET_CHAR_ANSWERING_MOBILE ambush_bloke1 FALSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ambush_bloke1 player1
				on_the_phone_again = 0
			ENDIF

		ENDIF 

	ENDIF

ENDWHILE

SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER
STOP_CHAR_LOOKING scplayer

REMOVE_BLIP lawyer_blip1

IF DOES_CHAR_EXIST ambush_bloke1
	GET_DEAD_CHAR_PICKUP_COORDS	ambush_bloke1 blokeX blokeY blokeZ
	blokeZ = blokeZ + 0.5
	CREATE_PICKUP cellphone PICKUP_ONCE blokeX blokeY blokeZ players_cellphone
ELSE
	CREATE_PICKUP cellphone PICKUP_ONCE blokeX blokeY blokeZ players_cellphone
ENDIF

ADD_BLIP_FOR_PICKUP players_cellphone players_cellphone_blip

PRINT_NOW ( LAW2_11 ) 5000 2  //Pick up his cell phone

WHILE NOT HAS_PICKUP_BEEN_COLLECTED players_cellphone
	WAIT 0

ENDWHILE

SET_PLAYER_CONTROL player1 OFF
CLEAR_THIS_PRINT ( LAW2_11 )
PRINT_HELP ( LAW2_12 ) //1500 2  //Cell phone acquired

REMOVE_BLIP players_cellphone_blip

WAIT 1500

// ***************************************START MEET THE BUDDY**********************************************

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_HELP

DELETE_CHAR ambush_bloke1


REMOVE_BLIP lawyer_blip1

GET_GAME_TIMER breakout_timer_start
breakout_diff = 0

	WHILE NOT CAN_PLAYER_START_MISSION Player1
	AND breakout_diff < 5000	//	if player is not in control after 5 secs do the cutscene anyway
		WAIT 0

		GET_GAME_TIMER breakout_timer							
		breakout_diff = breakout_timer - breakout_timer_start
	ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player1
 
SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSbuddy
LOAD_SPECIAL_MODEL CUTOBJ01 guncolt

LOAD_SCENE 440.163 -567.622 10.031

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0

ENDWHILE

CLEAR_AREA blokeX blokeY blokeZ 20.0 TRUE

LOAD_CUTSCENE law_2c
SET_CUTSCENE_OFFSET 440.163 -567.622 10.031
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_buddy
SET_CUTSCENE_ANIM cs_buddy CSbuddy

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_ganga
SET_CUTSCENE_ANIM cs_ganga chef01

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_gangb
SET_CUTSCENE_ANIM cs_gangb chef02

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_gangc
SET_CUTSCENE_ANIM cs_gangc chef03

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_guncolt
SET_CUTSCENE_ANIM cs_guncolt guncolt

IF IS_PLAYER_IN_ANY_CAR player1			  
	WARP_PLAYER_FROM_CAR_TO_COORD player1 433.0 -574.5 9.6
ELSE
	SET_PLAYER_COORDINATES player1 433.0 -574.5 9.6
ENDIF

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3050
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_A ) 10000 1 // Mission brief

WHILE cs_time < 9000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_B ) 10000 1 // Mission brief

WHILE cs_time < 10080
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_C ) 10000 1 // Mission brief

WHILE cs_time < 13080
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_D ) 10000 1 // Mission brief

WHILE cs_time < 14250
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_E ) 10000 1 // Mission brief

WHILE cs_time < 21170
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_F ) 10000 1 // Mission brief

WHILE cs_time < 23160
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_G ) 10000 1 // Mission brief

WHILE cs_time < 28030
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_H ) 10000 1 // Mission brief

WHILE cs_time < 34070
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_I ) 10000 1 // Mission brief

WHILE cs_time < 36060
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_J ) 10000 1 // Mission brief

WHILE cs_time < 39100
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( LAW2C_K ) 10000 1 // Mission brief

WHILE cs_time < 40100  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 40744  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SWITCH_RUBBISH ON
CLEAR_CUTSCENE
//SET_CAMERA_IN_FRONT_OF_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01


// ***************************************END MEET THE BUDDY**********************************************

SET_PLAYER_CONTROL player1 OFF

REQUEST_MODEL cleaver
REQUEST_MODEL knifecur

WHILE NOT HAS_MODEL_LOADED cleaver
OR NOT HAS_MODEL_LOADED knifecur
	WAIT 0

ENDWHILE

IF IS_PLAYER_IN_ANY_CAR player1
	WARP_PLAYER_FROM_CAR_TO_COORD player1 433.0 -574.5 9.6
ELSE
	SET_PLAYER_COORDINATES player1 433.0 -574.5 9.6
ENDIF

SET_PLAYER_HEADING player1 327.0

CLEAR_AREA 265.7 -929.3 9.7 4.0 FALSE
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 433.1 -575.8 9.6 buddy // FIXMIAMI: was PEDTYPE_CIVFEMALE
SET_CHAR_HEADING buddy 143.0 
SET_CHAR_PERSONALITY buddy PEDSTAT_TOUGH_GUY
SET_CHAR_AS_PLAYER_FRIEND buddy Player1 TRUE
SET_CHAR_NEVER_TARGETTED buddy TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS buddy FALSE
GIVE_WEAPON_TO_CHAR buddy WEAPONTYPE_PISTOL 9999
ADD_BLIP_FOR_CHAR buddy buddy_blip

CLEAR_AREA 431.3 -655.4 9.7 6.0 FALSE
CREATE_CAR infernus 431.3 -655.4 10.6 buddycar
SET_CAR_HEALTH buddycar 2000
LOCK_CAR_DOORS buddycar CARLOCK_UNLOCKED
SET_CAR_HEADING buddycar 156.0
CHANGE_CAR_COLOUR buddycar CARCOLOUR_WHITE CARCOLOUR_WHITE

// moved to wait until buddy is in the car
ADD_BLIP_FOR_CAR buddycar buddycar_blip

SET_CHAR_CANT_BE_DRAGGED_OUT buddy TRUE
SET_CHAR_STAY_IN_CAR_WHEN_JACKED buddy TRUE

GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 34
SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL

CLEAR_AREA 439.0 -567.7 9.6 1.0 FALSE
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 439.2 -567.9 9.6 ambush_bloke2 // FIXMIAMI: was PEDTYPE_CIVFEMALE
CLEAR_CHAR_THREAT_SEARCH ambush_bloke2
SET_CHAR_PERSONALITY ambush_bloke2 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR ambush_bloke2 WEAPONTYPE_CLEAVER 0
SET_CHAR_HEADING ambush_bloke2 154.0 

CLEAR_AREA 437.4 -567.8 9.6 1.0 FALSE
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 438.2 -567.8 9.6 ambush_bloke3 // FIXMIAMI: was PEDTYPE_CIVFEMALE
CLEAR_CHAR_THREAT_SEARCH ambush_bloke3
SET_CHAR_PERSONALITY ambush_bloke3 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR ambush_bloke3 WEAPONTYPE_KNIFE 0
SET_CHAR_HEADING ambush_bloke3 154.0 

CLEAR_AREA 435.4 -566.2 9.6 1.0 FALSE
CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 437.2 -567.4 9.6 ambush_bloke4 // FIXMIAMI: was PEDTYPE_CIVFEMALE
CLEAR_CHAR_THREAT_SEARCH ambush_bloke4
SET_CHAR_PERSONALITY ambush_bloke4 PEDSTAT_TOUGH_GUY
GIVE_WEAPON_TO_CHAR ambush_bloke4 WEAPONTYPE_CLEAVER 0
SET_CHAR_HEADING ambush_bloke4 154.0 

TIMERB = 0

LOAD_MISSION_AUDIO 1 LAW2_4

SWITCH_WIDESCREEN ON

WAIT 0

IF NOT IS_CHAR_DEAD	ambush_bloke3
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR scplayer ambush_bloke3
ENDIF

WAIT 500

DO_FADE 1500 FADE_IN


SET_FIXED_CAMERA_POSITION 430.001 -576.716 11.667 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 430.808 -576.170 11.442 JUMP_CUT

WAIT 1000

IF NOT IS_CHAR_DEAD buddy 
	SET_CHAR_OBJ_RUN_TO_COORD buddy 421.0 -598.1
ENDIF

WAIT 1000

SET_FIXED_CAMERA_POSITION 430.575 -575.370 11.484 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 430.389 -576.350 11.405 JUMP_CUT

IF HAS_MISSION_AUDIO_LOADED	1
	PLAY_MISSION_AUDIO 1
ENDIF
PRINT_NOW ( LAW2_4 ) 2000 2	//This way

WAIT 500

// FIXMIAMI: START
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
// FIXMIAMI: END

GET_CONTROLLER_MODE controlmode
IF controlmode = 0
OR controlmode = 1
	PRINT_HELP ( GUN_2A )  // Hold the ~h~R1 ~w~button to ~h~auto-target~w~, press the ~o~| ~w~button to ~h~fire!
ENDIF

IF controlmode = 2
	PRINT_HELP ( GUN_2C )  // Hold the ~h~R1 ~w~button to ~h~auto-target~w~, press the ~x~/ ~w~button to ~h~fire!
ENDIF

IF controlmode = 3
	PRINT_HELP ( GUN_2D )  // Hold the ~h~L1 ~w~button to ~h~auto-target,~w~ press the ~h~R1 ~w~button to ~h~fire!
ENDIF

SET_CHAR_OBJ_NO_OBJ scplayer
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

TIMERB = 0

GET_PLAYER_COORDINATES player1 player_x player_y player_z
SET_RADIO_CHANNEL FEVER -1

LOAD_MISSION_AUDIO 1 LANAMU1
LOAD_MISSION_AUDIO 2 LANAMU2

TIMERA = 0

WHILE NOT IS_PLAYER_IN_CAR player1 buddycar 
OR NOT IS_CHAR_IN_CAR buddy	buddycar
	WAIT 0

	IF played_sprint_help = 0
		IF TIMERA > 5000
			IF controlmode = 2
				PRINT_HELP ( HELP2A2 )  // "Press the ~o~|~w~ button when running to ~h~sprint."
			ELSE
				PRINT_HELP ( HELP2_A )  // "Press the ~x~/ ~w~button when running to ~h~sprint."
			ENDIF
			played_sprint_help = 1
		ENDIF
	ENDIF

	IF played_sprint_help = 1
		IF TIMERA > 9000
			PRINT_HELP HELP3  // "You can only sprint for short periods before becoming tired."
			played_sprint_help = 2
	   	ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	buddy

		IF LOCATE_CHAR_ANY_MEANS_3D buddy 427.6 -584.7 10.6 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD buddy 421.0 -598.1
			SET_CHAR_USE_PEDNODE_SEEK buddy FALSE 	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D buddy 421.0 -598.1 10.6 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD buddy 413.3 -614.3 
			SET_CHAR_USE_PEDNODE_SEEK buddy FALSE	 
		ENDIF
			
		IF LOCATE_CHAR_ANY_MEANS_3D buddy 413.3 -614.3 10.6 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD buddy 405.6 -632.4 
			SET_CHAR_USE_PEDNODE_SEEK buddy FALSE	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D buddy 405.6 -632.4 10.6 1.0 1.0 5.0 FALSE
			SET_CHAR_OBJ_RUN_TO_COORD buddy 429.1 -648.7 
			SET_CHAR_USE_PEDNODE_SEEK buddy FALSE	 
		ENDIF

		IF LOCATE_CHAR_ANY_MEANS_3D buddy 429.1 -648.7 10.6 1.0 1.0 5.0 FALSE
			IF ran_to_last_coords = 0
				SET_CHAR_OBJ_RUN_TO_COORD buddy 429.5 -653.7 
				SET_CHAR_USE_PEDNODE_SEEK buddy FALSE
 				ran_to_last_coords = 1
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD buddycar
			IF LOCATE_CHAR_ANY_MEANS_3D buddy 429.5 -653.7 10.6 1.0 1.0 5.0 FALSE
				CLEAR_CHAR_THREAT_SEARCH buddy
				IF NOT IS_CHAR_IN_CAR buddy buddycar
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER buddy buddycar
				ENDIF
			ENDIF
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

	IF TIMERB >	1000

		IF ambush_blokes_obj_set = 0
			IF NOT IS_CHAR_DEAD	ambush_bloke2
				SET_CHAR_THREAT_SEARCH ambush_bloke2 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ambush_bloke2 player1
			ENDIF
			IF NOT IS_CHAR_DEAD	ambush_bloke3
				SET_CHAR_THREAT_SEARCH ambush_bloke3 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ambush_bloke3 player1
			ENDIF
			IF NOT IS_CHAR_DEAD	ambush_bloke4
				SET_CHAR_THREAT_SEARCH ambush_bloke4 THREAT_PLAYER1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ambush_bloke4 player1
			ENDIF
			ambush_blokes_obj_set = 1
		ENDIF

		GET_PLAYER_COORDINATES player1 player_x player_y player_z

		IF NOT IS_CHAR_DEAD	ambush_bloke2
			IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke2 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke2 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	ambush_bloke3
		    IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke3 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke3 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	ambush_bloke4
			IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke4 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke4 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		TIMERB  = 0

	ENDIF

	IF IS_CHAR_DEAD	ambush_bloke2
	AND ambush_bloke2_dead = 0 
		counter_badguys ++
		ambush_bloke2_dead = 1
	ENDIF

	IF IS_CHAR_DEAD	ambush_bloke3
	AND ambush_bloke3_dead = 0 
		counter_badguys ++
		ambush_bloke3_dead = 1
	ENDIF

	IF IS_CHAR_DEAD	ambush_bloke4
	AND ambush_bloke4_dead = 0 
		counter_badguys ++
		ambush_bloke4_dead = 1
	ENDIF

	IF NOT IS_CAR_DEAD buddycar
		IF IS_PLAYER_IN_CAR player1 buddycar
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 buddy 5.0 5.0 10.0 FALSE
				IF buddy_blip_active = 0
					REMOVE_BLIP buddy_blip
		   			ADD_BLIP_FOR_CHAR buddy buddy_blip 
		   			PRINT_NOW ( LAW2_13 ) 5000 2 //You've left lance  
					buddy_blip_active = 1
				ENDIF
		   	ELSE
		   		IF NOT IS_CAR_DEAD buddycar
					IF NOT IS_CHAR_IN_CAR buddy buddycar
						SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER buddy buddycar
					ENDIF
					IF IS_PLAYER_IN_CAR	player1 buddycar
						REMOVE_BLIP buddy_blip
					ENDIF
					buddy_blip_active = 0
				ENDIF
		   	ENDIF
		ENDIF
	ENDIF

ENDWHILE

REMOVE_BLIP buddycar_blip
REMOVE_BLIP buddy_blip
ADD_SPRITE_BLIP_FOR_COORD ammu1X ammu1Y ammu1Z RADAR_SPRITE_GUN hotel_blip

WAIT 1000

IF HAS_MISSION_AUDIO_LOADED	1
	PLAY_MISSION_AUDIO 1
	PRINT_NOW ( LAW2_16 ) 4000 2 // One thing you gotta realise about this town. You gotta pack some heat.
ENDIF

WAIT 500

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0

ENDWHILE

IF HAS_MISSION_AUDIO_LOADED	2
	PLAY_MISSION_AUDIO 2
	PRINT_NOW ( LAW2_17 ) 2000 2 //C'mon, the local gun shop's a couple of blocks away.
ENDIF

//PRINT_NOW ( LAW2_14 ) 2500 2  //We gotta get the hell outta here!
//ADD_BLIP_FOR_COORD -53.7 -1482.9 10.4 hotel_blip
						   
buddycar_blip_active = 1

WAIT 2000

SWITCH_CAR_GENERATOR gen_car3 0

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

PRINT_NOW ( LAW2_15 ) 10000 2  //Drive to AMMUNATION

TIMERA = 0

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -53.7 -1482.9 10.4 3.0 4.0 3.0 TRUE
	WAIT 0

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

	IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 buddy 10.0 10.0 10.0 FALSE
		IF buddy_blip_active = 0
			REMOVE_BLIP buddy_blip
   			ADD_BLIP_FOR_CHAR buddy buddy_blip 
   			PRINT_NOW ( LAW2_13 ) 5000 2 //You've left lance  
			buddy_blip_active = 1
		ENDIF
   	ELSE
   		IF NOT IS_CAR_DEAD buddycar
			IF NOT IS_CHAR_IN_CAR buddy buddycar
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER buddy buddycar
			ELSE // FIXMIAMI
				GOSUB law2_broken_car_audio // FIXMIAMI
			ENDIF
			IF IS_PLAYER_IN_CAR	player1 buddycar
				REMOVE_BLIP buddy_blip
			ENDIF
			buddy_blip_active = 0
		ENDIF
   	ENDIF

	IF NOT IS_PLAYER_IN_CAR	player1 buddycar
		IF NOT IS_CHAR_IN_CAR buddy buddycar 
			IF buddycar_blip_active = 0
				REMOVE_BLIP buddycar_blip
	   			ADD_BLIP_FOR_CAR buddycar buddycar_blip  
				buddycar_blip_active = 1
			ENDIF
		ENDIF
   	ELSE
		IF buddycar_blip_active = 1
			REMOVE_BLIP buddycar_blip
			buddycar_blip_active = 0
		ENDIF
   	ENDIF

	IF TIMERB >	1000

		GET_PLAYER_COORDINATES player1 player_x player_y player_z

		IF NOT IS_CHAR_DEAD	ambush_bloke2
			IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke2 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke2 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	ambush_bloke3
		    IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke3 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke3 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	ambush_bloke4
			IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke4 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke4 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		TIMERB  = 0

	ENDIF

	IF NOT IS_CHAR_DEAD	ambush_bloke2
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player1 ambush_bloke2 120.0 120.0 FALSE
			MARK_CHAR_AS_NO_LONGER_NEEDED ambush_bloke2
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED ambush_bloke2
	ENDIF

	IF NOT IS_CHAR_DEAD	ambush_bloke3
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player1 ambush_bloke3 120.0 120.0 FALSE
			MARK_CHAR_AS_NO_LONGER_NEEDED ambush_bloke3
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED ambush_bloke3
	ENDIF

	IF NOT IS_CHAR_DEAD	ambush_bloke4
		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D Player1 ambush_bloke4 120.0 120.0 FALSE
			MARK_CHAR_AS_NO_LONGER_NEEDED ambush_bloke4
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED ambush_bloke4
	ENDIF


	IF gun_blip_help = 0
		IF TIMERA > 3000
			PRINT_HELP LAW3_15 //Follow the ~h~Gun blip~w~ on the radar to find ~h~Ammu-Nation~w~.
			FLASH_HUD_OBJECT HUD_FLASH_RADAR
			WHILE NOT TIMERA > 5000
				WAIT 0 

					IF IS_CHAR_DEAD	buddy
						PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
						GOTO mission_lawyer2_failed
					ENDIF

					IF IS_CAR_DEAD buddycar
						GOTO mission_lawyer2_failed
					ENDIF
  
			ENDWHILE

			FLASH_HUD_OBJECT -1
			gun_blip_help = 1
		ENDIF
	ENDIF

ENDWHILE

LOAD_MISSION_AUDIO 2 LAW2_5

REMOVE_BLIP hotel_blip

IF NOT IS_CHAR_DEAD ammu_shop_bloke1
	STOP_CHAR_LOOKING ammu_shop_bloke1
ENDIF

SET_PLAYER_CONTROL player1 OFF

SET_FIXED_CAMERA_POSITION -54.730 -1479.250 11.418 0.0 0.0 0.0 //
POINT_CAMERA_AT_POINT -55.647 -1479.631 11.299 JUMP_CUT

PRINT_HELP LAW3_11 //Stand in the ~q~pink marker~w~ to view the weapons on offer.

TIMERA = 0

WHILE NOT TIMERA > 1000
	WAIT 0

ENDWHILE

WHILE NOT TIMERA > 3000
	WAIT 0

    IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_ammu_help
	ENDIF

ENDWHILE


SET_FIXED_CAMERA_POSITION -63.091 -1483.060 12.398 0.0 0.0 0.0 //
POINT_CAMERA_AT_POINT -63.189 -1484.055 12.396 JUMP_CUT

PRINT_HELP LAW3_12 //You can select weapons using ~h~left~w~ or ~h~right~w~ on the ~h~directional button~w~

TIMERA = 0

WAIT 500

WHILE NOT TIMERA > 3500
	WAIT 0

    IF IS_BUTTON_PRESSED PAD1 cross
		WHILE IS_BUTTON_PRESSED	PAD1 cross
			WAIT 0

			IF TIMERA > 3500
				GOTO skip_passed_ammu_help
			ENDIF

		ENDWHILE
		GOTO skip_passed_ammu_help
	ENDIF

ENDWHILE

SET_FIXED_CAMERA_POSITION -61.233 -1482.864 11.818 0.0 0.0 0.0 //
POINT_CAMERA_AT_POINT -61.601 -1483.793 11.811 JUMP_CUT

PRINT_HELP LAW3_13 //If you have enough cash you can buy weapons by pressing the ~x~/ button~w~

TIMERA = 0
WHILE NOT TIMERA > 4000
	WAIT 0

    IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_ammu_help
	ENDIF

ENDWHILE

SET_FIXED_CAMERA_POSITION -68.227 -1479.893 11.670 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -67.359 -1480.372 11.544 JUMP_CUT

PRINT_HELP LAW3_14 //You can exit the shop by pressing the ~t~" button~w~

TIMERA = 0
WHILE NOT TIMERA > 4000
	WAIT 0

    IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_ammu_help
	ENDIF

ENDWHILE

SET_FIXED_CAMERA_POSITION -63.091 -1483.060 12.398 0.0 0.0 0.0 //
POINT_CAMERA_AT_POINT -63.189 -1484.055 12.396 JUMP_CUT

PRINT_HELP HELP46 //There are eight different types of weapon.

TIMERA = 0
WHILE NOT TIMERA > 4000
	WAIT 0

    IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_ammu_help
	ENDIF

ENDWHILE

SET_FIXED_CAMERA_POSITION -61.233 -1482.864 11.818 0.0 0.0 0.0 //
POINT_CAMERA_AT_POINT -61.601 -1483.793 11.811 JUMP_CUT

PRINT_HELP HELP47 //You can carry one of each type of weapon at a time - one type of pistol, one type of shotgun.

TIMERA = 0
WHILE NOT TIMERA > 4000
	WAIT 0

    IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_passed_ammu_help
	ENDIF

ENDWHILE

skip_passed_ammu_help:

SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER

ADD_BLIP_FOR_COORD 242.6 -1281.2 10.0 hotel_blip
PRINT_NOW ( LAW2_10 ) 15000 2  //Drive to the hotel

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

//WHILE NOT LOCATE_CAR_3D buddycar 242.6 -1281.2 10.0 30.0 60.0 5.0 FALSE
WHILE NOT IS_CAR_IN_AREA_3D buddycar 272.8 -1341.5 16.0 212.5 -1280.0 8.0 FALSE
OR NOT IS_CHAR_SITTING_IN_CAR buddy	buddycar
OR NOT IS_CHAR_SITTING_IN_CAR scplayer buddycar
	WAIT 0

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_IN_AREA_3D buddycar 272.9 -1220.6 16.0 212.5 -1280.0 8.0 FALSE
	AND IS_CHAR_SITTING_IN_CAR buddy buddycar
	AND IS_CHAR_SITTING_IN_CAR scplayer buddycar
		 GOTO warp_buddycar
	ENDIF

	IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 buddy 10.0 10.0 10.0 FALSE
		IF buddy_blip_active = 0
			REMOVE_BLIP buddy_blip
   			ADD_BLIP_FOR_CHAR buddy buddy_blip 
   			PRINT_NOW ( LAW2_13 ) 5000 2 //You've left lance  
			buddy_blip_active = 1
		ENDIF
   	ELSE
   		IF NOT IS_CAR_DEAD buddycar
			IF NOT IS_CHAR_IN_CAR buddy buddycar
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER buddy buddycar
			ENDIF
			IF IS_PLAYER_IN_CAR	player1 buddycar
				REMOVE_BLIP buddy_blip
			ENDIF
			buddy_blip_active = 0
		ENDIF
   	ENDIF

	IF NOT IS_PLAYER_IN_CAR	player1 buddycar
		IF NOT IS_CHAR_IN_CAR buddy buddycar 
			IF buddycar_blip_active = 0
				REMOVE_BLIP buddycar_blip
	   			ADD_BLIP_FOR_CAR buddycar buddycar_blip  
				buddycar_blip_active = 1
			ENDIF
		ENDIF
   	ELSE
		IF buddycar_blip_active = 1
			REMOVE_BLIP buddycar_blip
			buddycar_blip_active = 0
		ENDIF
   	ENDIF

	IF TIMERB >	1000

		GET_PLAYER_COORDINATES player1 player_x player_y player_z

		IF NOT IS_CHAR_DEAD	ambush_bloke2
			IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke2 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke2 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	ambush_bloke3
		    IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke3 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke3 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	ambush_bloke4
			IF NOT IS_CHAR_WANDER_PATH_CLEAR ambush_bloke4 player_x player_y player_z 4.0
				CHAR_FOLLOW_PATH ambush_bloke4 player_x player_y player_z 2.0 Run
			ENDIF
		ENDIF

		TIMERB  = 0

	ENDIF

ENDWHILE

warp_buddycar:

DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

	IF NOT IS_CAR_DEAD buddycar
		GET_CAR_HEADING buddycar bud_Heading
	ENDIF

	IF IS_CAR_IN_AREA_3D buddycar 272.8 -1341.5 16.0 212.5 -1280.0 8.0 FALSE

		IF NOT IS_CAR_DEAD buddycar
			SET_CAR_CRUISE_SPEED buddycar 0.0 
			SET_CAR_DRIVING_STYLE buddycar DRIVINGMODE_PLOUGHTHROUGH
			CLEAR_AREA 232.1 -1323.4 10.9 40.0 TRUE
			SET_CAR_COORDINATES buddycar 236.7 -1308.2 -100.0
			SET_CAR_HEADING buddycar 347.3
			SET_CAR_CRUISE_SPEED buddycar 20.0
			CAR_GOTO_COORDINATES buddycar 242.35 -1279.9 10.9
			CLEAR_AREA 242.2 -1279.9 10.9 20.0 TRUE
			CLEAR_AREA 247.264 -1281.508 10.495 40.0 FALSE
			SET_FIXED_CAMERA_POSITION 239.295 -1283.295 10.713 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 239.799 -1282.436 10.622 JUMP_CUT
			drove_in_from_south = 1
		ENDIF

	ELSE

		IF NOT IS_CAR_DEAD buddycar
			SET_CAR_CRUISE_SPEED buddycar 0.0 
			SET_CAR_DRIVING_STYLE buddycar DRIVINGMODE_PLOUGHTHROUGH
			CLEAR_AREA 246.3 -1257.7 10.9 40.0 TRUE
			SET_CAR_COORDINATES buddycar 246.3 -1257.7 -100.0
			SET_CAR_HEADING buddycar 171.8
			SET_CAR_CRUISE_SPEED buddycar 20.0
			CAR_GOTO_COORDINATES buddycar 242.2 -1279.9 10.9
			CLEAR_AREA 242.2 -1279.9 10.9 20.0 TRUE
			CLEAR_AREA 247.264 -1281.508 10.495 40.0 FALSE
			SET_FIXED_CAMERA_POSITION 237.960 -1286.392 10.586 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 238.473 -1285.534 10.609 JUMP_CUT
		ENDIF

	ENDIF

	DO_FADE 1000 FADE_IN

	WAIT 3000

	IF NOT IS_CAR_DEAD buddycar
		SET_CHAR_OBJ_LEAVE_CAR scplayer buddycar
	ENDIF

	WAIT 1300

	IF NOT IS_CHAR_DEAD	buddy
		SET_CHAR_SHUFFLE_INTO_DRIVERS_SEAT buddy
	ENDIF

	IF drove_in_from_south = 0
		SET_FIXED_CAMERA_POSITION 237.787 -1282.583 12.615 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 238.638 -1282.366 12.135 JUMP_CUT
	ELSE
		SET_FIXED_CAMERA_POSITION 239.975 -1273.806 12.873 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 240.511 -1274.468 12.350 JUMP_CUT
	ENDIF

	IF NOT IS_CHAR_DEAD	buddy
		PLAYER_LOOK_AT_CHAR_ALWAYS player1 buddy
		CHAR_LOOK_AT_CHAR_ALWAYS buddy scplayer
	ENDIF

	WAIT 1000

	IF HAS_MISSION_AUDIO_LOADED	2
		PLAY_MISSION_AUDIO 2
	ENDIF

	PRINT_NOW ( LAW2_5 ) 4000 2	//I'll be in touch


	WAIT 4000

	IF NOT IS_CAR_DEAD buddycar
		CLEAR_AREA 200.2 -1460.3 10.9 40.0 FALSE
		CLEAR_AREA 242.2 -1279.9 10.9 40.0 FALSE
		CLEAR_AREA_OF_CARS 213.4 -1376.9 0.0 279.7 -1216.2 30.0
		IF drove_in_from_south = 0
			SET_FIXED_CAMERA_POSITION 245.135 -1276.517 11.710 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 244.775 -1277.430 11.519 JUMP_CUT
		ELSE
			SET_FIXED_CAMERA_POSITION 242.804 -1271.559 10.617 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 242.975 -1272.544 10.603 JUMP_CUT
		ENDIF
		CAR_GOTO_COORDINATES buddycar 200.2 -1460.3 10.9
		SET_CAR_CRUISE_SPEED buddycar 40.0
		SET_CAR_DRIVING_STYLE buddycar DRIVINGMODE_PLOUGHTHROUGH
		IF NOT IS_CHAR_DEAD buddy
			STOP_CHAR_LOOKING buddy
		ENDIF
	ENDIF

	TIMERB = 0

WHILE NOT LOCATE_CAR_3D buddycar 200.2 -1460.3 10.9 4.0 4.0 4.0 FALSE
	WAIT 0

	IF TIMERB > 4000
		GOTO delete_buddycar
	ENDIF

	IF IS_CHAR_DEAD	buddy
		PRINT_NOW ( COK2_26 ) 5000 2 //YOUR BUDDY IS DEAD!
		GOTO mission_lawyer2_failed
	ENDIF

	IF IS_CAR_DEAD buddycar
		GOTO mission_lawyer2_failed
	ENDIF

ENDWHILE


STOP_CHAR_LOOKING scplayer

delete_buddycar:

RESTORE_CAMERA_JUMPCUT

DELETE_CAR buddycar
GOTO mission_lawyer2_passed


 // Mission lawyer2 failed

mission_lawyer2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission lawyer2 passed

mission_lawyer2_passed:

flag_lawyer_mission2_passed = 1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 200 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 200 
REGISTER_MISSION_PASSED	LAW_2
PLAYER_MADE_PROGRESS 1
START_NEW_SCRIPT lawyer_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_lawyer2:

flag_player_on_mission = 0

DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_close 490.34 -77.017 11.598 malibu_doors
DONT_REMOVE_OBJECT malibu_doors
flag_malibu_doors_closed = 1
flag_malibu_doors_open = 0
flag_player_on_lawyer_2	= 0
flag_player_in_malibu = 0
GET_GAME_TIMER timer_mobile_start
MARK_MODEL_AS_NO_LONGER_NEEDED infernus
MARK_MODEL_AS_NO_LONGER_NEEDED cleaver
MARK_MODEL_AS_NO_LONGER_NEEDED colt45
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
MARK_MODEL_AS_NO_LONGER_NEEDED knifecur
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
REMOVE_BLIP kent_paul1
REMOVE_BLIP lawyer_blip1
REMOVE_BLIP buddy_blip
REMOVE_BLIP hotel_blip
SWITCH_CAR_GENERATOR gen_car3 101
REMOVE_BLIP players_cellphone_blip
REMOVE_PICKUP players_cellphone
REMOVE_BLIP buddycar_blip
MISSION_HAS_FINISHED
RETURN

// FIXMIAMI: START
law2_broken_car_audio:
	IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON buddycar WEAPONTYPE_RAMMEDBYCAR
		GET_CAR_HEALTH buddycar buddycar_health
		IF buddycar_health < 1500
		AND law2_broken_car_audio1_played = 0
			law2_broken_car_audio1_played = 1
			LOAD_MISSION_AUDIO 1 LAW2_7
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			RETURN
		ENDIF
		IF buddycar_health < 1000
		AND law2_broken_car_audio2_played = 0
			law2_broken_car_audio2_played = 1
			LOAD_MISSION_AUDIO 1 LAW2_8
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
			ENDWHILE
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			RETURN
		ENDIF
	ENDIF
	RETURN
// FIXMIAMI: END
}
