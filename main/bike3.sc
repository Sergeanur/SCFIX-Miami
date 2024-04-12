MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ********************************** Get the Boss's bike Back ***************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME bike3

// Mission start stuff

GOSUB mission_start_bike3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bike3_failed
ENDIF

GOSUB mission_cleanup_bike3

MISSION_END


// Variables for mission

VAR_INT bike_bike3

VAR_INT radar_blip_coord1_bike3

VAR_INT radar_blip_bike_bike3

VAR_INT guard1_bike3

VAR_INT guard2_bike3

VAR_INT guard3_bike3

VAR_INT guard4_bike3

VAR_INT guard5_bike3

VAR_INT guard6_bike3

VAR_INT flag_location_on_bike3

VAR_INT flag_guard1_dead_bike3

VAR_INT flag_guard2_dead_bike3

VAR_INT flag_guard3_dead_bike3

VAR_INT flag_guard4_dead_bike3

VAR_INT flag_guard5_dead_bike3 

VAR_INT flag_guard6_dead_bike3

VAR_INT flag_attack_player_bike3

// Guard creation if the alarm goes off

VAR_INT counter_blokes_alive_bike3

VAR_INT flag_created_bloke_in_area_bike3

VAR_INT flag_created_bloke_in_area2_bike3

VAR_INT flag_timer_started_bike3

VAR_INT guard_number_bike3

VAR_INT guard_number2_bike3

VAR_INT flag_alarm_sounded_bike3

VAR_INT alarm_bike3

VAR_INT flag_ped1_go_for_alarm_bike3

VAR_INT flag_ped2_go_for_alarm_bike3

// guard1

VAR_INT created_guard1_bike3

VAR_INT flag_guard1_state_bike3

// guard2

VAR_INT created_guard2_bike3

VAR_INT flag_guard2_state_bike3

// guard3

VAR_INT created_guard3_bike3

VAR_INT flag_guard3_state_bike3

// guard4

VAR_INT created_guard4_bike3

VAR_INT flag_guard4_state_bike3

// guard5

VAR_INT created_guard5_bike3

VAR_INT flag_guard5_state_bike3

// guard6

VAR_INT created_guard6_bike3

VAR_INT flag_guard6_state_bike3

// guard7

VAR_INT created_guard7_bike3

VAR_INT flag_guard7_state_bike3

// guard8

VAR_INT created_guard8_bike3

VAR_INT flag_guard8_state_bike3

// guard9

VAR_INT created_guard9_bike3

VAR_INT flag_guard9_state_bike3

// guard10

VAR_INT created_guard10_bike3

VAR_INT flag_guard10_state_bike3

// guard11

VAR_INT created_guard11_bike3

VAR_INT flag_guard11_state_bike3

// guard12

VAR_INT created_guard12_bike3

VAR_INT flag_guard12_state_bike3

// guard13

VAR_INT created_guard13_bike3

VAR_INT flag_guard13_state_bike3

// guard14

VAR_INT created_guard14_bike3

VAR_INT flag_guard14_state_bike3

// gaurd15

VAR_INT created_guard15_bike3

VAR_INT flag_guard15_state_bike3

// gaurd16

VAR_INT created_guard16_bike3

VAR_INT flag_guard16_state_bike3

VAR_INT total_guards_created_bike3

// player stuff

VAR_FLOAT player_x_bike3

VAR_FLOAT player_y_bike3

VAR_FLOAT player_z_bike3

// General stuff

VAR_INT bike_driver_bike3

// Created chase guards

VAR_INT chase_guard1_bike3

VAR_INT chase_guard2_bike3

VAR_INT chase_guard3_bike3

VAR_INT chase_guard4_bike3

VAR_INT chase_guard5_bike3

VAR_INT chase_guard6_bike3

VAR_INT chase_guard7_bike3

VAR_INT chase_guard8_bike3

VAR_INT chase_guys_created_bike3

VAR_INT flag_player_got_bike_bike3

VAR_INT chase_car1_bike3

VAR_INT chase_car2_bike3

VAR_INT chase_car3_bike3

VAR_INT chase_car4_bike3

// Compound stuff

VAR_INT flag_player_in_compound_bike3

VAR_INT stair_blip_bike3

VAR_INT flag_stair_blip_on_bike3

VAR_INT bike_blip_on_1stime_bike3 // Used to add the blip to the bike first time

// gaurd AI stuff

VAR_INT flag_guard1_got_AI_bike3

VAR_INT flag_guard2_got_AI_bike3

VAR_INT flag_guard3_got_AI_bike3

VAR_INT flag_guard4_got_AI_bike3

VAR_INT flag_guard5_got_AI_bike3

VAR_INT flag_guard6_got_AI_bike3

VAR_INT counter_all_guards_got_AI_bike3

// Timer stuff

VAR_INT timer_guards_react_bike3

// Frame counter stuff

VAR_INT frame_counter_bike3 // used to tell guys to do different things

// ****************************************Mission Start************************************

mission_start_bike3:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

flag_location_on_bike3 = 0

flag_location_on_bike3 = 0

flag_guard1_dead_bike3 = 0

flag_guard2_dead_bike3 = 0

flag_guard3_dead_bike3 = 0

flag_guard4_dead_bike3 = 0

flag_guard5_dead_bike3 = 0 

flag_guard6_dead_bike3 = 0

flag_attack_player_bike3 = 0

// Guard alarm creation

counter_blokes_alive_bike3 = 0

flag_created_bloke_in_area_bike3 = 0

flag_created_bloke_in_area2_bike3 = 0

flag_timer_started_bike3 = 0

flag_guard1_state_bike3 = 0

flag_guard2_state_bike3 = 0

flag_guard3_state_bike3 = 0

flag_guard4_state_bike3 = 0

flag_guard5_state_bike3 = 0

flag_guard6_state_bike3 = 0

flag_guard7_state_bike3 = 0

flag_guard8_state_bike3 = 0

flag_guard9_state_bike3 = 0

flag_guard10_state_bike3 = 0

flag_guard11_state_bike3 = 0

flag_guard12_state_bike3 = 0

flag_guard13_state_bike3 = 0

flag_guard14_state_bike3 = 0

flag_guard15_state_bike3 = 0

flag_guard16_state_bike3 = 0

flag_alarm_sounded_bike3 = 0

flag_ped1_go_for_alarm_bike3 = 0

flag_ped2_go_for_alarm_bike3 = 0

// total counter

total_guards_created_bike3 = 0

// player stuff

player_x_bike3 = 0.0

player_y_bike3 = 0.0

player_z_bike3 = 0.0

// Chase guys

chase_guys_created_bike3 = 0

flag_player_got_bike_bike3 = 0

// Compound stuff

flag_player_in_compound_bike3 = 0

flag_stair_blip_on_bike3 = 0

bike_blip_on_1stime_bike3 = 0

// gaurd AI stuff

flag_guard1_got_AI_bike3 = 0

flag_guard2_got_AI_bike3 = 0

flag_guard3_got_AI_bike3 = 0

flag_guard4_got_AI_bike3 = 0

flag_guard5_got_AI_bike3 = 0

flag_guard6_got_AI_bike3 = 0

counter_all_guards_got_AI_bike3 = 0

// Timer stuff

timer_guards_react_bike3 = 0

// Frame counter stuff

frame_counter_bike3 = 0

VAR_INT flag_fade_done_bike3
flag_fade_done_bike3 = 0

WAIT 0

LOAD_MISSION_TEXT BIKE3

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -609.723 658.861 9.908 279.440

{

// ****************************************START OF CUTSCENE********************************

// This is the correct cutscene the names were just round the wrong ways

LOAD_SPECIAL_CHARACTER 1 CSplay

LOAD_SPECIAL_CHARACTER 2 CSbigm

LOAD_SPECIAL_CHARACTER 3 mserver

SET_AREA_VISIBLE VIS_BIKER_BAR

LOAD_SCENE -597.02 642.46 11.0

SET_EXTRA_COLOURS 15 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3

	WAIT 0

ENDWHILE

LOAD_CUTSCENE bike_2

SET_CUTSCENE_OFFSET -602.052 636.289 10.636
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_bigm
SET_CUTSCENE_ANIM cs_bigm CSbigm

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_server
SET_CUTSCENE_ANIM cs_server mserver

CLEAR_AREA -597.25 655.87 10.06 1.0 TRUE              // PROPER STUFF
SET_PLAYER_COORDINATES player1 -597.25 655.87 10.06
SET_PLAYER_HEADING player1 0.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text
GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4538 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_A ) 10000 1 //"Hey there Mitch.

WHILE cs_time < 6581 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_B ) 10000 1 //"Well if it ain't 'bad ass' Vercetti.

WHILE cs_time < 8775 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_C ) 10000 1 //"Now I wanna see how good you can fight for your patch.

WHILE cs_time < 11662 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_D ) 10000 1 //"A local street gang made the mistake of stealing my hog...

WHILE cs_time < 14895 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_E ) 10000 1 //"probably 'cause of some machismo thing or something.

WHILE cs_time < 17616 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_F ) 10000 1 //"Me and the boys would go over and teach them a lesson in respect an'all.

WHILE cs_time < 22783 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_G ) 10000 1 //"Anyways,

WHILE cs_time < 24681 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_H ) 10000 1 //"Then I got to thinking this would make a good initiation for you.

WHILE cs_time < 28415 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BM3_I ) 10000 1 //"You get my bike back and you can tell Paul he's got his security.

WHILE cs_time < 32256
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 37916
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3

SET_AREA_VISIBLE VIS_MAIN_MAP

CLEAR_EXTRA_COLOURS FALSE

LOAD_SCENE -597.25 655.87 10.06

// ****************************************END OF CUTSCENE**********************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON

REQUEST_MODEL doontoon50
REQUEST_MODEL road_downtown_new2
REQUEST_MODEL road_downtown02
REQUEST_MODEL ammunation_dt
REQUEST_MODEL doontoon19
REQUEST_MODEL dt_compound_roof
REQUEST_MODEL doontoon51
REQUEST_MODEL LODntoon28
REQUEST_MODEL ammu_windows1
//REQUEST_MODEL dtm_cablesb


WHILE NOT HAS_MODEL_LOADED doontoon50
OR NOT HAS_MODEL_LOADED road_downtown_new2
OR NOT HAS_MODEL_LOADED road_downtown02
OR NOT HAS_MODEL_LOADED	ammunation_dt
OR NOT HAS_MODEL_LOADED doontoon19  
OR NOT HAS_MODEL_LOADED	dt_compound_roof

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED doontoon51
OR NOT HAS_MODEL_LOADED LODntoon28
OR NOT HAS_MODEL_LOADED ammu_windows1
//OR NOT HAS_MODEL_LOADED dtm_cablesb 

   	WAIT 0
	
ENDWHILE 

// fades the screen in 

SET_FADING_COLOUR 0 0 0

SWITCH_WIDESCREEN ON

WAIT 1000

DO_FADE 1500 FADE_IN

PRINT_NOW ( BM3_1 ) 4000 1 //"A local gang have stolen the boss's bike get it back!"

timera = 0

WHILE timera < 3500

	WAIT 0
					   
	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_bike3
	ENDIF
	
ENDWHILE

PRINT_NOW ( BM3_6 ) 6000 1 //"They are holed up behind AmmuNation in the Downtown area."

timera = 0

WHILE timera < 5500

	WAIT 0

	IF timera >= 4000

		IF flag_fade_done_bike3 = 0
			DO_FADE 1500 FADE_OUT
			CLEAR_THIS_PRINT ( BM3_6 )
			flag_fade_done_bike3 = 1
		ENDIF

	ENDIF

	IF timera < 4000

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bike3
		ENDIF

	ENDIF

ENDWHILE

WHILE GET_FADING_STATUS

	WAIT 0
		
ENDWHILE

LOAD_SCENE -675.93 1116.28 14.35

SET_FIXED_CAMERA_POSITION -675.93 1116.28 14.35 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -675.81 1117.19 14.40 JUMP_CUT

DO_FADE 2000 FADE_IN

WHILE GET_FADING_STATUS
   
   WAIT 0
      
ENDWHILE

PRINT_NOW ( BM3_7 ) 5000 1 //"You will need a fast vehicle to gain access to the roof."

timerb = 0

WHILE timerb < 4000

	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_bike3
	ENDIF

ENDWHILE

//LOAD_SCENE -678.97 1147.28 25.48 
SET_FIXED_CAMERA_POSITION -678.97 1147.28 25.48 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -678.65 1148.22 25.44 JUMP_CUT
PRINT_NOW ( BM3_8 ) 5000 1 //"Use a fast bike to jump from these stairs to the roof on the far side of the road

timera = 0

WHILE timera < 4000

	WAIT 0

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_bike3
	ENDIF

ENDWHILE

mission_skip_bike3:

CLEAR_PRINTS 

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

LOAD_SCENE -597.25 655.87 10.06

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
RESTORE_CAMERA_JUMPCUT
CLEAR_THIS_PRINT ( BM3_8 )

MARK_MODEL_AS_NO_LONGER_NEEDED doontoon50
MARK_MODEL_AS_NO_LONGER_NEEDED road_downtown_new2
MARK_MODEL_AS_NO_LONGER_NEEDED road_downtown02
MARK_MODEL_AS_NO_LONGER_NEEDED ammunation_dt
MARK_MODEL_AS_NO_LONGER_NEEDED doontoon19
MARK_MODEL_AS_NO_LONGER_NEEDED dt_compound_roof
MARK_MODEL_AS_NO_LONGER_NEEDED doontoon51
MARK_MODEL_AS_NO_LONGER_NEEDED LODntoon28
MARK_MODEL_AS_NO_LONGER_NEEDED ammu_windows1
//MARK_MODEL_AS_NO_LONGER_NEEDED dtm_cablesb


// Waiting for the ped models to load

REQUEST_MODEL SGa  // street gang

REQUEST_MODEL SGb  // street gang

REQUEST_MODEL BKa // biker used at cutscene at end

REQUEST_MODEL ANGEL

REQUEST_MODEL TEC9

REQUEST_MODEL M4

REQUEST_MODEL GANGBUR

WHILE NOT HAS_MODEL_LOADED SGa
OR NOT HAS_MODEL_LOADED SGb
OR NOT HAS_MODEL_LOADED ANGEL
OR NOT HAS_MODEL_LOADED TEC9
OR NOT HAS_MODEL_LOADED M4
OR NOT HAS_MODEL_LOADED BKa
	
	WAIT 0
      
ENDWHILE

WHILE NOT HAS_MODEL_LOADED GANGBUR

	WAIT 0

ENDWHILE

ADD_CONTINUOUS_SOUND -702.16 1215.37 23.17 SOUND_BANK_ALARM_LOOP alarm_bike3
REMOVE_SOUND alarm_bike3

CREATE_CAR GANGBUR -518.54 694.10 10.89 chase_car1_bike3
CREATE_CHAR_INSIDE_CAR chase_car1_bike3 PEDTYPE_GANG_STREET SGb chase_guard1_bike3
CREATE_CHAR_AS_PASSENGER chase_car1_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard5_bike3 
DELETE_CHAR chase_guard1_bike3
DELETE_CHAR chase_guard5_bike3
DELETE_CAR chase_car1_bike3	
   
CREATE_CAR GANGBUR -296.53 1254.60 10.11 chase_car2_bike3
CREATE_CHAR_INSIDE_CAR chase_car2_bike3 PEDTYPE_GANG_STREET SGa chase_guard2_bike3
CREATE_CHAR_AS_PASSENGER chase_car2_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard6_bike3
DELETE_CHAR chase_guard2_bike3
DELETE_CHAR chase_guard6_bike3
DELETE_CAR chase_car2_bike3
			
CREATE_CAR GANGBUR -857.96 1137.78 9.79 chase_car3_bike3
CREATE_CHAR_INSIDE_CAR chase_car3_bike3 PEDTYPE_GANG_STREET SGa chase_guard3_bike3
CREATE_CHAR_AS_PASSENGER chase_car3_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard7_bike3
DELETE_CHAR chase_guard3_bike3
DELETE_CHAR chase_guard7_bike3
DELETE_CAR chase_car3_bike3
			
CREATE_CAR GANGBUR -604.24 664.34 9.91 chase_car4_bike3
CREATE_CHAR_INSIDE_CAR chase_car4_bike3 PEDTYPE_GANG_STREET SGb chase_guard4_bike3
CREATE_CHAR_AS_PASSENGER chase_car4_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard8_bike3
DELETE_CHAR chase_guard4_bike3
DELETE_CHAR chase_guard8_bike3
DELETE_CAR chase_car4_bike3

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 1000

DO_FADE 2000 FADE_IN

ADD_BLIP_FOR_COORD -674.59 1128.49 10.08 stair_blip_bike3

flag_stair_blip_on_bike3 = 1

ground_z = 0.0000

// Creates the bike

CREATE_CAR ANGEL -700.08 1300.14 10.76 bike_bike3

SET_CAN_RESPRAY_CAR bike_bike3 FALSE

SET_CAR_HEADING bike_bike3 180.0

// Creates guard1 on roof left hand side follows route 0

CREATE_CHAR PEDTYPE_GANG_STREET SGa -750.93 1235.44 23.73 guard1_bike3

CLEAR_CHAR_THREAT_SEARCH guard1_bike3

++ counter_blokes_alive_bike3

++ total_guards_created_bike3

// Creates guard2 on roof right hand side follows route 1

CREATE_CHAR PEDTYPE_GANG_STREET SGa -659.81 1257.07 23.17 guard2_bike3

CLEAR_CHAR_THREAT_SEARCH guard2_bike3

++ counter_blokes_alive_bike3

++ total_guards_created_bike3

// Creates guard3 on left hand side by the bike in the garage, patrols by the door that extra guards come out of Route 2

CREATE_CHAR PEDTYPE_GANG_STREET SGa -692.32 1250.27 10.20 guard3_bike3

CLEAR_CHAR_THREAT_SEARCH guard3_bike3

++ counter_blokes_alive_bike3

++ total_guards_created_bike3

// Creates guard4 on left hand side by chain link fence follows route 3

CREATE_CHAR PEDTYPE_GANG_STREET SGb -757.70 1214.37 10.07 guard4_bike3

CLEAR_CHAR_THREAT_SEARCH guard4_bike3

++ counter_blokes_alive_bike3

++ total_guards_created_bike3

// Creates guard5 on right hand side of bike working on it 

CREATE_CHAR PEDTYPE_GANG_STREET SGa -699.21 1300.28 10.76 guard5_bike3

CLEAR_CHAR_THREAT_SEARCH guard5_bike3

++ counter_blokes_alive_bike3

++ total_guards_created_bike3
							 
// Creates guard6 on left hand side of bike working on it

CREATE_CHAR PEDTYPE_GANG_STREET SGb -701.04 1300.24 10.76 guard6_bike3

CLEAR_CHAR_THREAT_SEARCH guard6_bike3

++ counter_blokes_alive_bike3

++ total_guards_created_bike3

blob_flag = 0

// waiting for the bike to be stopped in the correct area
 
WHILE NOT LOCATE_STOPPED_CAR_3D bike_bike3 -596.63 658.20 10.06 4.0 4.0 4.0 blob_flag

	WAIT 0

	++ frame_counter_bike3
	IF frame_counter_bike3 > 20
		frame_counter_bike3 = 0
	ENDIF
	   	
	IF counter_all_guards_got_AI_bike3 < 6
		GOSUB guard_AI2_bike3
	ENDIF

	IF IS_PLAYER_IN_AREA_3D player1 -642.32 1198.51 22.0 -768.194 1306.725 30.0 FALSE // These were 100.0 
	OR IS_PLAYER_IN_AREA_3D player1 -685.75 1239.31 9.0 -768.194 1306.725 30.0 FALSE
	OR IS_PLAYER_IN_AREA_3D player1 -753.43 1213.0 9.0 -768.194 1306.725 30.0 FALSE
	
		CLEAR_WANTED_LEVEL player1 

		IF flag_stair_blip_on_bike3 = 1 
			REMOVE_BLIP stair_blip_bike3
			flag_stair_blip_on_bike3 = 0
		ENDIF

		IF flag_player_got_bike_bike3 = 0
		
			IF bike_blip_on_1stime_bike3 = 0
				
				IF NOT IS_CAR_DEAD bike_bike3
					PRINT_NOW ( BM3_9 ) 5000 1 //Get Mitch's bike and get out of there!" 
					ADD_BLIP_FOR_CAR bike_bike3 radar_blip_bike_bike3
					bike_blip_on_1stime_bike3 = 1
				ELSE
					PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
					GOTO mission_bike3_failed
				ENDIF
								
			ENDIF	
			
		ENDIF	 

		flag_player_in_compound_bike3 = 1
	ELSE

		IF flag_player_got_bike_bike3 = 0
		
			IF bike_blip_on_1stime_bike3 = 1
				REMOVE_BLIP radar_blip_bike_bike3
				bike_blip_on_1stime_bike3 = 0
			ENDIF	
			
		ENDIF

		IF flag_player_got_bike_bike3 = 0

			IF flag_stair_blip_on_bike3 = 0 
				ADD_BLIP_FOR_COORD -674.59 1128.49 10.08 stair_blip_bike3
				flag_stair_blip_on_bike3 = 1
			ENDIF

		ENDIF

		flag_player_in_compound_bike3 = 0
	ENDIF

	IF chase_guys_created_bike3 = 0

		IF flag_player_got_bike_bike3 = 1
			
			IF flag_player_in_compound_bike3 = 0 
				GOSUB chase_creation_bike3
			ENDIF

		ENDIF

	ENDIF

	IF chase_guys_created_bike3 = 1
					 
		IF NOT IS_CHAR_DEAD	chase_guard1_bike3
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard1_bike3 player1 	
		ENDIF
		

		IF NOT IS_CHAR_DEAD	chase_guard2_bike3 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard2_bike3 player1
		ENDIF

		IF NOT IS_CHAR_DEAD	chase_guard3_bike3
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard3_bike3 player1	
		ENDIF

		IF NOT IS_CHAR_DEAD	chase_guard4_bike3 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard4_bike3 player1
		ENDIF

		IF NOT IS_CHAR_DEAD	chase_guard5_bike3 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard5_bike3 player1
		ENDIF

		IF NOT IS_CHAR_DEAD	chase_guard6_bike3 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard6_bike3 player1
		ENDIF

		IF NOT IS_CHAR_DEAD	chase_guard7_bike3 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard7_bike3 player1
		ENDIF

		IF NOT IS_CHAR_DEAD	chase_guard8_bike3 
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard8_bike3 player1
		ENDIF

	ENDIF
			
	GET_PLAYER_COORDINATES player1 player_x_bike3 player_y_bike3 player_z_bike3		
	
	GOSUB guard_check_bike3

	IF IS_CAR_DEAD bike_bike3
		PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
		GOTO mission_bike3_failed
	ELSE
		
		IF IS_PLAYER_IN_CAR player1 bike_bike3
			
			IF flag_location_on_bike3 = 0
				blob_flag = 1
				flag_attack_player_bike3 = 1

				IF flag_player_got_bike_bike3 = 0
		
					IF bike_blip_on_1stime_bike3 = 1
						REMOVE_BLIP radar_blip_bike_bike3
						bike_blip_on_1stime_bike3 = 2
					ENDIF	
			
				ENDIF
				
				REMOVE_BLIP radar_blip_bike_bike3 

				ADD_BLIP_FOR_COORD -596.63 658.20 10.06 radar_blip_coord1_bike3
				PRINT_NOW ( BM3_3 ) 5000 1 //"Get the bike back to the base!"
				flag_player_got_bike_bike3 = 1
				flag_location_on_bike3 = 1
			ENDIF

		ELSE
		
			IF flag_location_on_bike3 = 1
				blob_flag = 0
				REMOVE_BLIP radar_blip_coord1_bike3
				ADD_BLIP_FOR_CAR bike_bike3 radar_blip_bike_bike3
				PRINT_NOW ( BM3_4 ) 5000 1 //"Get on the bike!"
				flag_location_on_bike3 = 0 
			ENDIF
					
		ENDIF

	ENDIF

	IF flag_attack_player_bike3 = 1
		
		IF flag_timer_started_bike3 = 0
			timerb = 0
			timera = 0
			flag_timer_started_bike3 = 1
		ENDIF
		 
		GOSUB alarm_guard_creation_bike3
		GOSUB guard_AI_bike3
		GOSUB alarm_guard_death_bike3

	ENDIF
			
ENDWHILE

blob_flag = 1

REMOVE_BLIP radar_blip_bike_bike3

REMOVE_BLIP radar_blip_coord1_bike3

SWITCH_WIDESCREEN ON
CLEAR_WANTED_LEVEL player1
SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_FIXED_CAMERA_POSITION -607.076 666.146 13.891 0.0 0.0 0.0
CLEAR_AREA -596.63 658.20 10.06 1.0 FALSE 
POINT_CAMERA_AT_POINT -606.531 665.364 13.589 JUMP_CUT

SET_CHAR_OBJ_LEAVE_CAR scplayer bike_bike3  

WHILE IS_CHAR_IN_CAR scplayer bike_bike3

	WAIT 0

	IF IS_CAR_DEAD bike_bike3
		PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
		GOTO mission_bike3_failed
	ENDIF
	 	 			
ENDWHILE

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -594.99 654.58

timera = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer -594.99 654.58 1.0 1.0 FALSE

	WAIT 0

	IF timera > 6000

		IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer -594.99 654.58 1.0 1.0 FALSE
			GOTO cut_skip_bike3
		ENDIF

	ENDIF

	IF IS_CAR_DEAD bike_bike3
		PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
		GOTO mission_bike3_failed
	ENDIF

ENDWHILE

cut_skip_bike3:

SET_CHAR_OBJ_NO_OBJ scplayer 

CREATE_CHAR PEDTYPE_GANG_BIKER BKa -611.72 650.20 10.06 bike_driver_bike3 // SCFIX: x was -608.72
CLEAR_CHAR_THREAT_SEARCH bike_driver_bike3
SET_CHAR_RUNNING bike_driver_bike3 TRUE

TURN_CHAR_TO_FACE_CHAR scplayer bike_driver_bike3

IF NOT IS_CAR_DEAD bike_bike3    
	SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER bike_driver_bike3 bike_bike3
ELSE
	PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
	GOTO mission_bike3_failed
ENDIF

TIMERA = 0

WHILE NOT IS_CHAR_IN_ANY_CAR bike_driver_bike3

	WAIT 0

	IF IS_CAR_DEAD bike_bike3
		PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
		GOTO mission_bike3_failed
	ENDIF

	IF IS_CHAR_DEAD bike_driver_bike3 
		GOTO mission_bike3_failed
	ENDIF

	IF TIMERA > 20000

		IF NOT IS_CHAR_IN_CAR bike_driver_bike3 bike_bike3
			WARP_CHAR_INTO_CAR bike_driver_bike3 bike_bike3
		ENDIF
		
	ENDIF 
	
ENDWHILE

IF NOT IS_CAR_DEAD bike_bike3
	SET_CAR_CRUISE_SPEED bike_bike3 30.0
	SET_CAR_DRIVING_STYLE bike_bike3 2
	CAR_WANDER_RANDOMLY bike_bike3  
ELSE
	PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
	GOTO mission_bike3_failed
ENDIF

WHILE IS_CAR_ON_SCREEN bike_bike3
AND timera < 4000

	WAIT 0

	IF IS_CAR_DEAD bike_bike3
		PRINT_NOW ( BM3_2 ) 5000 1 //"You were supposed to bring the bike back!"
		GOTO mission_bike3_failed
	ENDIF

	IF IS_CHAR_DEAD bike_driver_bike3 
		GOTO mission_bike3_failed
	ENDIF
	
ENDWHILE

WAIT 3000

IF NOT IS_CAR_DEAD bike_bike3 
	CAR_SET_IDLE bike_bike3
ENDIF

DELETE_CHAR bike_driver_bike3
DELETE_CAR bike_bike3      

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF
RESTORE_CAMERA_JUMPCUT   

GOTO mission_bike3_passed

// ****************************************** Mission Failed *******************************

mission_bike3_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


   

// *************************************** Mission Passed **********************************

mission_bike3_passed:

flag_bikers_mission3_passed = 1
REGISTER_MISSION_PASSED ( BIKE_3 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
ADD_SCORE player1 4000
REMOVE_BLIP bikers_contact_blip  // Mission strand has finished so remove blip
RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_bike3:
flag_player_on_mission = 0

MARK_MODEL_AS_NO_LONGER_NEEDED doontoon50
MARK_MODEL_AS_NO_LONGER_NEEDED road_downtown_new2
MARK_MODEL_AS_NO_LONGER_NEEDED road_downtown02
MARK_MODEL_AS_NO_LONGER_NEEDED ammunation_dt
MARK_MODEL_AS_NO_LONGER_NEEDED doontoon19
MARK_MODEL_AS_NO_LONGER_NEEDED dt_compound_roof
MARK_MODEL_AS_NO_LONGER_NEEDED doontoon51
MARK_MODEL_AS_NO_LONGER_NEEDED LODntoon28
MARK_MODEL_AS_NO_LONGER_NEEDED ammu_windows1
//MARK_MODEL_AS_NO_LONGER_NEEDED dtm_cablesb

REMOVE_ROUTE 0
REMOVE_ROUTE 1
REMOVE_ROUTE 2
REMOVE_ROUTE 3
 
REMOVE_SOUND alarm_bike3
MARK_MODEL_AS_NO_LONGER_NEEDED SGa
MARK_MODEL_AS_NO_LONGER_NEEDED SGb
MARK_MODEL_AS_NO_LONGER_NEEDED ANGEL
MARK_MODEL_AS_NO_LONGER_NEEDED BKa
MARK_MODEL_AS_NO_LONGER_NEEDED TEC9
MARK_MODEL_AS_NO_LONGER_NEEDED M4
MARK_MODEL_AS_NO_LONGER_NEEDED GANGBUR
REMOVE_BLIP stair_blip_bike3
REMOVE_BLIP radar_blip_bike_bike3
REMOVE_BLIP radar_blip_coord1_bike3
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

guard_check_bike3:

IF flag_player_in_compound_bike3 = 1

	IF frame_counter_bike3 = 0

		IF flag_guard1_dead_bike3 = 0

			IF IS_CHAR_DEAD guard1_bike3
				-- counter_blokes_alive_bike3
				IF flag_ped1_go_for_alarm_bike3 = 1
					flag_attack_player_bike3 = 1
				ENDIF
				flag_guard1_dead_bike3 = 1
			ELSE

				IF flag_alarm_sounded_bike3 = 0

			  		IF flag_ped1_go_for_alarm_bike3 = 0
					
						IF HAS_CHAR_SPOTTED_PLAYER guard1_bike3 player1
						OR flag_guard2_dead_bike3 = 1
							PRINT ( INTRUDE ) 5000 1 //"Intruder alert! Intruder alert!"
							SET_CHAR_OBJ_RUN_TO_COORD guard1_bike3 -693.58 1213.18  
							flag_ped1_go_for_alarm_bike3 = 1
						ENDIF

					ENDIF

				ENDIF
					   	   
				IF flag_alarm_sounded_bike3 = 0

					IF flag_ped1_go_for_alarm_bike3 = 1

						IF LOCATE_STOPPED_CHAR_ON_FOOT_3D guard1_bike3 -693.58 1213.18 23.16 1.0 1.0 2.0 FALSE
							ADD_CONTINUOUS_SOUND -693.58 1213.18 23.16 SOUND_BANK_ALARM_LOOP alarm_bike3
							flag_attack_player_bike3 = 1
							CHAR_FOLLOW_PATH guard1_bike3 player_x_bike3 player_y_bike3 player_z_bike3 1.0 RUN
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard1_bike3 player1
							flag_alarm_sounded_bike3 = 1
						ENDIF

					ENDIF

				ELSE
				   	CHAR_FOLLOW_PATH guard1_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard1_bike3 player1
				ENDIF

			ENDIF

		ENDIF

	ENDIF

	IF frame_counter_bike3 = 1

		IF flag_guard2_dead_bike3 = 0

			IF IS_CHAR_DEAD guard2_bike3

				IF flag_ped2_go_for_alarm_bike3 = 1
					flag_attack_player_bike3 = 1
				ENDIF

				-- counter_blokes_alive_bike3
				flag_guard2_dead_bike3 = 1
			ELSE

				IF flag_alarm_sounded_bike3 = 0
				   			
					IF flag_ped2_go_for_alarm_bike3 = 0
					
						IF HAS_CHAR_SPOTTED_PLAYER guard2_bike3 player1
						OR flag_guard1_dead_bike3 = 1
							PRINT ( INTRUDE ) 5000 1 //"Intruder alert! Intruder alert!"
							SET_CHAR_OBJ_RUN_TO_COORD guard2_bike3 -693.58 1213.18  
							flag_ped2_go_for_alarm_bike3 = 1
						ENDIF

					ENDIF

				ENDIF
					   	   
				IF flag_alarm_sounded_bike3 = 0

					IF flag_ped2_go_for_alarm_bike3 = 1

						IF LOCATE_STOPPED_CHAR_ON_FOOT_3D guard2_bike3 -693.58 1213.18 23.16 1.0 1.0 2.0 FALSE
							ADD_CONTINUOUS_SOUND -693.58 1213.18 23.16 SOUND_BANK_ALARM_LOOP alarm_bike3
							flag_attack_player_bike3 = 1
							CHAR_FOLLOW_PATH guard2_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard2_bike3 player1
							flag_alarm_sounded_bike3 = 1
						ENDIF

					ENDIF

				ELSE
				 	CHAR_FOLLOW_PATH guard2_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard2_bike3 player1
				ENDIF
						
			ENDIF

		ENDIF

	ENDIF

	IF frame_counter_bike3 = 2

		IF flag_guard3_dead_bike3 = 0

			IF IS_CHAR_DEAD guard3_bike3
				-- counter_blokes_alive_bike3
				flag_guard3_dead_bike3 = 1
			ELSE

				IF flag_attack_player_bike3 = 0
					
					IF HAS_CHAR_SPOTTED_PLAYER guard3_bike3 player1
						PRINT ( INTRUDE ) 5000 1 //"Intruder alert! Intruder alert!"
						flag_attack_player_bike3 = 1
					ENDIF

				ENDIF

				IF flag_attack_player_bike3 = 1

				   //	IF guard3_got_ai_1time_bike3 = 0
				   //		CHAR_FOLLOW_PATH guard3_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				   //		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard3_bike3 player1
				   //		guard3_got_ai_1time_bike3 = 1
				   //	ENDIF
					   				   
					CHAR_FOLLOW_PATH guard3_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				  	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard3_bike3 player1
				   	
				ENDIF

			ENDIF

		ENDIF

	ENDIF

	IF frame_counter_bike3 = 3

		IF flag_guard4_dead_bike3 = 0

			IF IS_CHAR_DEAD guard4_bike3
				-- counter_blokes_alive_bike3
				flag_guard4_dead_bike3 = 1
			ELSE

				IF flag_attack_player_bike3 = 0
					
					IF HAS_CHAR_SPOTTED_PLAYER guard4_bike3 player1
						PRINT ( INTRUDE ) 5000 1 //"Intruder alert! Intruder alert!"
						flag_attack_player_bike3 = 1
					ENDIF

				ENDIF
				
				IF flag_attack_player_bike3 = 1

				   //	IF guard4_got_ai_1time_bike3 = 0
				   //		CHAR_FOLLOW_PATH guard4_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				   //		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard4_bike3 player1
				   //		guard4_got_ai_1time_bike3 = 1
				   //	ENDIF	
					
				   	CHAR_FOLLOW_PATH guard4_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				   	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard4_bike3 player1
					
				ENDIF

			ENDIF
			
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 4

		IF flag_guard5_dead_bike3 = 0

			IF IS_CHAR_DEAD guard5_bike3
				-- counter_blokes_alive_bike3
				flag_guard5_dead_bike3 = 1
			ELSE

				IF flag_attack_player_bike3 = 0
					
					IF HAS_CHAR_SPOTTED_PLAYER guard5_bike3 player1
						PRINT ( INTRUDE ) 5000 1 //"Intruder alert! Intruder alert!"
						flag_attack_player_bike3 = 1
					ENDIF

				ENDIF
						               
				IF flag_attack_player_bike3 = 1
				OR flag_guard6_dead_bike3 = 1

				   //	IF guard5_got_ai_1time_bike3 = 0
				   //		CHAR_FOLLOW_PATH guard5_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				   //		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard5_bike3 player1
				   ////		guard5_got_ai_1time_bike3 = 1
				   //	ENDIF
								   
					CHAR_FOLLOW_PATH guard5_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				  	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard5_bike3 player1
					
				ENDIF

			ENDIF

		ENDIF

	ENDIF

	IF frame_counter_bike3 = 5

		IF flag_guard6_dead_bike3 = 0

			IF IS_CHAR_DEAD guard6_bike3
			-- counter_blokes_alive_bike3
				flag_guard6_dead_bike3 = 1
			ELSE

				IF flag_attack_player_bike3 = 0
					
					IF HAS_CHAR_SPOTTED_PLAYER guard6_bike3 player1
						PRINT ( INTRUDE ) 5000 1 //"Intruder alert! Intruder alert!"
						flag_attack_player_bike3 = 1
					ENDIF

				ENDIF

				IF flag_attack_player_bike3 = 1
				OR flag_guard5_dead_bike3 = 1

				   //	IF guard6_got_ai_1time_bike3 = 0
				   //		CHAR_FOLLOW_PATH guard6_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				   //		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard6_bike3 player1
				   //		guard6_got_ai_1time_bike3 = 1
				   //	ENDIF
				  	
				  	CHAR_FOLLOW_PATH guard6_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				   	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard6_bike3 player1
				   	
				ENDIF
							
			ENDIF

		ENDIF

	ENDIF

ELSE

	IF flag_player_got_bike_bike3 = 1 
		MARK_CHAR_AS_NO_LONGER_NEEDED guard1_bike3
		MARK_CHAR_AS_NO_LONGER_NEEDED guard2_bike3
		MARK_CHAR_AS_NO_LONGER_NEEDED guard3_bike3
		MARK_CHAR_AS_NO_LONGER_NEEDED guard4_bike3
		MARK_CHAR_AS_NO_LONGER_NEEDED guard5_bike3
		MARK_CHAR_AS_NO_LONGER_NEEDED guard6_bike3
	ENDIF

ENDIF

IF timer_guards_react_bike3 = 2 
	timer_guards_react_bike3 = 0
ENDIF

RETURN

// Greates guards if the alarm has been raised

alarm_guard_creation_bike3:

IF flag_player_in_compound_bike3 = 1

	IF total_guards_created_bike3 <= 29
	
		IF counter_blokes_alive_bike3 < 8
	
			IF flag_created_bloke_in_area_bike3 = 2
				timerb = 0
				flag_created_bloke_in_area_bike3 = 0
			ENDIF
	
			IF flag_created_bloke_in_area2_bike3 = 2
				timera = 0
				flag_created_bloke_in_area2_bike3 = 0
			ENDIF
 		
			IF NOT IS_AREA_OCCUPIED -695.11 1301.01 8.0 -688.96 1294.68 14.0 FALSE TRUE TRUE FALSE FALSE

				IF timerb >= 4000

					IF flag_created_bloke_in_area_bike3 = 0

						guard_number_bike3 = -1
				
						IF flag_guard1_state_bike3 = 0
						OR flag_guard1_state_bike3 = 2
							CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
							CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard1_bike3
							guard_number_bike3 = created_guard1_bike3
							flag_guard1_state_bike3 = 1
						ELSE
	
							IF flag_guard2_state_bike3 = 0
							OR flag_guard2_state_bike3 = 2
								CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE
								CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard2_bike3
								guard_number_bike3 = created_guard2_bike3
								flag_guard2_state_bike3 = 1
							ELSE

								IF flag_guard3_state_bike3 = 0
								OR flag_guard3_state_bike3 = 2
									CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
									CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard3_bike3
									guard_number_bike3 = created_guard3_bike3
									flag_guard3_state_bike3 = 1
								ELSE	
			
									IF flag_guard4_state_bike3 = 0
									OR flag_guard4_state_bike3 = 2
										CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
										CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard4_bike3
										guard_number_bike3 = created_guard4_bike3
										flag_guard4_state_bike3 = 1
									ELSE

										IF flag_guard5_state_bike3 = 0
										OR flag_guard5_state_bike3 = 2
											CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
											CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard5_bike3
											guard_number_bike3 = created_guard5_bike3
											flag_guard5_state_bike3 = 1
										ELSE

											IF flag_guard6_state_bike3 = 0
											OR flag_guard6_state_bike3 = 2
												CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
												CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard6_bike3
												guard_number_bike3 = created_guard6_bike3
												flag_guard6_state_bike3 = 1
											ELSE
										
												IF flag_guard7_state_bike3 = 0
												OR flag_guard7_state_bike3 = 2
													CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
													CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard7_bike3
													guard_number_bike3 = created_guard7_bike3
													flag_guard7_state_bike3 = 1
												ELSE
											
													IF flag_guard8_state_bike3 = 0
													OR flag_guard8_state_bike3 = 2
														CLEAR_AREA -690.84 1298.62 10.76 4.0 FALSE 
														CREATE_CHAR PEDTYPE_GANG_STREET SGa -690.84 1298.62 10.76 created_guard8_bike3
														guard_number_bike3 = created_guard8_bike3
														flag_guard8_state_bike3 = 1
													ENDIF

												ENDIF

											ENDIF

										ENDIF

									ENDIF

								ENDIF

							ENDIF	

						ENDIF
					
						IF NOT IS_CHAR_DEAD guard_number_bike3
						
							IF NOT guard_number_bike3 = -1	
								SET_CHAR_PERSONALITY guard_number_bike3 PEDSTAT_TOUGH_GUY 
								SET_CHAR_HEADING guard_number_bike3 174.08
								SET_CHAR_OBJ_RUN_TO_COORD guard_number_bike3 -691.25 1294.99
								++ counter_blokes_alive_bike3
								++ total_guards_created_bike3
								flag_created_bloke_in_area_bike3 = 1
							ENDIF

						ENDIF

					ENDIF

				ENDIF

			ENDIF
	   	    									  
// second area on the left hand side
		
			IF NOT IS_AREA_OCCUPIED -735.7 1261.3 8.0 -728.2 1264.8 14.0 FALSE TRUE TRUE FALSE FALSE

				IF timera >= 7000

					IF flag_created_bloke_in_area2_bike3 = 0

						guard_number2_bike3 = -1
										
						IF flag_guard9_state_bike3 = 0
						OR flag_guard9_state_bike3 = 2
							CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
							CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard9_bike3
							guard_number2_bike3 = created_guard9_bike3
							flag_guard9_state_bike3 = 1
						ELSE
													
							IF flag_guard10_state_bike3 = 0
					   		OR flag_guard10_state_bike3 = 2
					   			CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
					   			CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard10_bike3
					   			guard_number2_bike3 = created_guard10_bike3
					   			flag_guard10_state_bike3 = 1
					   		ELSE


								IF flag_guard11_state_bike3 = 0
								OR flag_guard11_state_bike3 = 2
									CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
									CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard11_bike3
									guard_number2_bike3 = created_guard11_bike3
									flag_guard11_state_bike3 = 1
								ELSE

									IF flag_guard12_state_bike3 = 0
									OR flag_guard12_state_bike3 = 2
										CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
										CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard12_bike3
										guard_number2_bike3 = created_guard12_bike3
										flag_guard12_state_bike3 = 1
									ELSE

										IF flag_guard13_state_bike3 = 0
										OR flag_guard13_state_bike3 = 2
											CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
											CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard13_bike3
											guard_number2_bike3 = created_guard13_bike3
											flag_guard13_state_bike3 = 1
										ELSE

											IF flag_guard14_state_bike3 = 0
											OR flag_guard14_state_bike3 = 2
												CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
												CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard14_bike3
												guard_number2_bike3 = created_guard14_bike3
												flag_guard14_state_bike3 = 1
											ELSE

												IF flag_guard15_state_bike3 = 0
												OR flag_guard15_state_bike3 = 2
													CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
													CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard15_bike3
													guard_number2_bike3 = created_guard15_bike3
													flag_guard15_state_bike3 = 1
												ELSE
																			
													IF flag_guard16_state_bike3 = 0
													OR flag_guard16_state_bike3 = 2
														CLEAR_AREA -733.7 1263.0 10.8 4.0 FALSE 
														CREATE_CHAR PEDTYPE_GANG_STREET SGb -733.7 1263.0 10.8 created_guard16_bike3
														guard_number2_bike3 = created_guard16_bike3
														flag_guard16_state_bike3 = 1
													ENDIF

												ENDIF

											ENDIF

										ENDIF

									ENDIF

								ENDIF

							ENDIF

						ENDIF

						IF NOT IS_CHAR_DEAD guard_number2_bike3 

							IF NOT guard_number2_bike3 = -1	
				   				SET_CHAR_PERSONALITY guard_number2_bike3 PEDSTAT_TOUGH_GUY 
				   				SET_CHAR_HEADING guard_number2_bike3 174.08
				   				SET_CHAR_OBJ_RUN_TO_COORD guard_number2_bike3 -730.6 1262.8
				   				++ counter_blokes_alive_bike3
				   				++ total_guards_created_bike3
				   				flag_created_bloke_in_area2_bike3 = 1
				   			ENDIF

						ENDIF
								
					ENDIF
				
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN
				   					
// If the guards are created checks to give them AI

guard_AI_bike3:

IF flag_created_bloke_in_area_bike3 = 1

		IF NOT IS_CHAR_DEAD guard_number_bike3 

			IF LOCATE_CHAR_ON_FOOT_3D guard_number_bike3 -691.25 1294.99 10.76 1.0 1.0 2.0 FALSE
				
				IF total_guards_created_bike3 > 29
					SET_CHAR_HEALTH guard_number_bike3 200 
					GIVE_WEAPON_TO_CHAR guard_number_bike3 WEAPONTYPE_M4 30000 // Set to infinate ammo	
				ELSE
					GIVE_WEAPON_TO_CHAR guard_number_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
				ENDIF

				CHAR_FOLLOW_PATH guard_number_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard_number_bike3 player1
				flag_created_bloke_in_area_bike3 = 2
			ENDIF

		ELSE
			flag_created_bloke_in_area_bike3 = 2	
		ENDIF
				
	ENDIF


	IF flag_created_bloke_in_area2_bike3 = 1

		IF NOT IS_CHAR_DEAD guard_number2_bike3 

			IF LOCATE_CHAR_ON_FOOT_3D guard_number2_bike3 -730.6 1262.8 10.8 1.0 1.0 2.0 FALSE
							  
				IF total_guards_created_bike3 > 29
					SET_CHAR_HEALTH guard_number2_bike3 200
					GIVE_WEAPON_TO_CHAR guard_number2_bike3 WEAPONTYPE_M4 30000 // Set to infinate ammo	
				ELSE
					GIVE_WEAPON_TO_CHAR guard_number2_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
				ENDIF

				CHAR_FOLLOW_PATH guard_number2_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard_number2_bike3 player1
				flag_created_bloke_in_area2_bike3 = 2
			ENDIF

		ELSE
			flag_created_bloke_in_area2_bike3 = 2
		ENDIF

	ENDIF
	
RETURN

// Guard death checks - if alarm triggered then check to see if the guards are dead

alarm_guard_death_bike3:

IF flag_player_in_compound_bike3 = 1

	IF frame_counter_bike3 = 6  
	   						
		IF flag_guard1_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard1_bike3
				REMOVE_CHAR_ELEGANTLY created_guard1_bike3
				-- counter_blokes_alive_bike3
				flag_guard1_state_bike3 = 2
			ELSE				
				CHAR_FOLLOW_PATH created_guard1_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard1_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 7

		IF flag_guard2_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard2_bike3
				REMOVE_CHAR_ELEGANTLY created_guard2_bike3
				-- counter_blokes_alive_bike3
				flag_guard2_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard2_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard2_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 8

		IF flag_guard3_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard3_bike3
				REMOVE_CHAR_ELEGANTLY created_guard3_bike3
				-- counter_blokes_alive_bike3
				flag_guard3_state_bike3 = 2
			ELSE
			   	CHAR_FOLLOW_PATH created_guard3_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard3_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 9

		IF flag_guard4_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard4_bike3
				REMOVE_CHAR_ELEGANTLY created_guard4_bike3
				-- counter_blokes_alive_bike3
				flag_guard4_state_bike3 = 2
			ELSE
			   	CHAR_FOLLOW_PATH created_guard4_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard4_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 10

		IF flag_guard5_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard5_bike3
				REMOVE_CHAR_ELEGANTLY created_guard5_bike3
				-- counter_blokes_alive_bike3
				flag_guard5_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard5_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard5_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 11
	
		IF flag_guard7_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard7_bike3
				REMOVE_CHAR_ELEGANTLY created_guard7_bike3
				-- counter_blokes_alive_bike3
				flag_guard7_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard7_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard7_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 12

		IF flag_guard8_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard8_bike3
				REMOVE_CHAR_ELEGANTLY created_guard8_bike3
				-- counter_blokes_alive_bike3
				flag_guard8_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard8_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard8_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 13
					
		IF flag_guard9_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard9_bike3
				REMOVE_CHAR_ELEGANTLY created_guard9_bike3
				-- counter_blokes_alive_bike3
				flag_guard9_state_bike3 = 2
			ELSE
			   CHAR_FOLLOW_PATH created_guard9_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
			   SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard9_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 14

		IF flag_guard10_state_bike3 = 1

			 IF IS_CHAR_DEAD created_guard10_bike3
			 	REMOVE_CHAR_ELEGANTLY created_guard10_bike3
			 	-- counter_blokes_alive_bike3
			 	   flag_guard10_state_bike3 = 2
			 ELSE
				CHAR_FOLLOW_PATH created_guard10_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard10_bike3 player1
			 ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 15
			
		IF flag_guard11_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard11_bike3
				REMOVE_CHAR_ELEGANTLY created_guard11_bike3
				   -- counter_blokes_alive_bike3
				flag_guard11_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard11_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard11_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 16

		IF flag_guard12_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard12_bike3
				REMOVE_CHAR_ELEGANTLY created_guard12_bike3
				-- counter_blokes_alive_bike3
				flag_guard12_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard12_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard12_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 17

		IF flag_guard13_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard13_bike3
				REMOVE_CHAR_ELEGANTLY created_guard13_bike3
				-- counter_blokes_alive_bike3
				flag_guard13_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard13_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard13_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 18

		IF flag_guard14_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard14_bike3
				REMOVE_CHAR_ELEGANTLY created_guard14_bike3
				-- counter_blokes_alive_bike3
				flag_guard14_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard14_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard14_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 19

		IF flag_guard15_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard15_bike3
				REMOVE_CHAR_ELEGANTLY created_guard15_bike3
				-- counter_blokes_alive_bike3
				flag_guard15_state_bike3 = 2
			ELSE
			  	CHAR_FOLLOW_PATH created_guard15_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard15_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

	IF frame_counter_bike3 = 20

		IF flag_guard16_state_bike3 = 1

			IF IS_CHAR_DEAD created_guard16_bike3
				REMOVE_CHAR_ELEGANTLY created_guard16_bike3
				-- counter_blokes_alive_bike3
				flag_guard16_state_bike3 = 2
			ELSE
				CHAR_FOLLOW_PATH created_guard16_bike3 player_x_bike3 player_y_bike3 player_z_bike3 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard16_bike3 player1
			ENDIF
				
		ENDIF

	ENDIF

ELSE

	IF NOT IS_CHAR_DEAD created_guard1_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard1_bike3 
	ENDIF

	IF NOT IS_CHAR_DEAD created_guard2_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard2_bike3 
	ENDIF

	IF NOT IS_CHAR_DEAD created_guard3_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard3_bike3 
	ENDIF

	IF NOT IS_CHAR_DEAD created_guard4_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard4_bike3 
	ENDIF

	IF NOT IS_CHAR_DEAD created_guard5_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard5_bike3 
	ENDIF

	IF NOT IS_CHAR_DEAD created_guard6_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard6_bike3 
	ENDIF
	 	
	IF NOT IS_CHAR_DEAD created_guard7_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard7_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard8_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard8_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard9_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard9_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard10_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard10_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard11_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard11_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard12_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard12_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard13_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard13_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard14_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard14_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard15_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard15_bike3 
	ENDIF
	
	IF NOT IS_CHAR_DEAD created_guard16_bike3 
		MARK_CHAR_AS_NO_LONGER_NEEDED created_guard16_bike3 
	ENDIF	
	
ENDIF

RETURN

// Creates cars to chase player

chase_creation_bike3:

IF chase_guys_created_bike3 = 0

// guard1

	CREATE_CAR GANGBUR -783.346 1367.562 10.603 chase_car1_bike3
	SET_CAR_HEADING chase_car1_bike3 192.0 
	CREATE_CHAR_INSIDE_CAR chase_car1_bike3 PEDTYPE_GANG_STREET SGb chase_guard1_bike3
	CREATE_CHAR_AS_PASSENGER chase_car1_bike3 PEDTYPE_GANG_STREET SGa 0 chase_guard5_bike3 
	CLEAR_CHAR_THREAT_SEARCH  chase_guard1_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard5_bike3
	SET_CHAR_THREAT_SEARCH chase_guard1_bike3 THREAT_PLAYER1  
	GIVE_WEAPON_TO_CHAR chase_guard1_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	SET_CHAR_THREAT_SEARCH chase_guard5_bike3 THREAT_PLAYER1  
	GIVE_WEAPON_TO_CHAR chase_guard5_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard1_bike3 player1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard5_bike3 player1
	SET_CAR_FORWARD_SPEED chase_car1_bike3 30.0
	SET_CAR_CRUISE_SPEED chase_car1_bike3 40.0  
	
// Guard2

	CREATE_CAR GANGBUR -791.841 1376.640 10.422 chase_car2_bike3
	SET_CAR_HEADING chase_car2_bike3 258.512 
	CREATE_CHAR_INSIDE_CAR chase_car2_bike3 PEDTYPE_GANG_STREET SGa chase_guard2_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard2_bike3
	SET_CHAR_THREAT_SEARCH chase_guard2_bike3 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR chase_guard2_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	CREATE_CHAR_AS_PASSENGER chase_car2_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard6_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard6_bike3
	SET_CHAR_THREAT_SEARCH chase_guard6_bike3 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR chase_guard6_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard2_bike3 player1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard6_bike3 player1
	SET_CAR_FORWARD_SPEED chase_car2_bike3 30.0
	SET_CAR_CRUISE_SPEED chase_car2_bike3 40.0
		
// guard3
	
	CREATE_CAR GANGBUR -295.967 1255.681 10.142 chase_car3_bike3
	SET_CAR_HEADING chase_car3_bike3 357.556 	
	CREATE_CHAR_INSIDE_CAR chase_car3_bike3 PEDTYPE_GANG_STREET SGa chase_guard3_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard3_bike3
	SET_CHAR_THREAT_SEARCH chase_guard3_bike3 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR chase_guard3_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	CREATE_CHAR_AS_PASSENGER chase_car3_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard7_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard7_bike3
	SET_CHAR_THREAT_SEARCH chase_guard7_bike3 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR chase_guard7_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard3_bike3 player1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard7_bike3 player1
	SET_CAR_FORWARD_SPEED chase_car3_bike3 30.0
	SET_CAR_CRUISE_SPEED chase_car3_bike3 40.0

// guard4 in car1
		
	CREATE_CAR GANGBUR -585.145 666.533 9.917 chase_car4_bike3
	SET_CAR_HEADING chase_car4_bike3 286.737 	
	CREATE_CHAR_INSIDE_CAR chase_car4_bike3 PEDTYPE_GANG_STREET SGb chase_guard4_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard4_bike3
	SET_CHAR_THREAT_SEARCH chase_guard4_bike3 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR chase_guard4_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	CREATE_CHAR_AS_PASSENGER chase_car4_bike3 PEDTYPE_GANG_STREET SGb 0 chase_guard8_bike3
	CLEAR_CHAR_THREAT_SEARCH chase_guard8_bike3
	SET_CHAR_THREAT_SEARCH chase_guard8_bike3 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR chase_guard8_bike3 WEAPONTYPE_TEC9 30000 // Set to infinate ammo
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard4_bike3 player1
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS chase_guard8_bike3 player1
	SET_CAR_FORWARD_SPEED chase_car4_bike3 30.0
	SET_CAR_CRUISE_SPEED chase_car4_bike3 40.0  

	chase_guys_created_bike3 = 1
ENDIF

RETURN

guard_AI2_bike3:

IF counter_all_guards_got_AI_bike3 < 6

// Guard1

	IF flag_guard1_got_AI_bike3 = 0

		IF NOT IS_CHAR_DEAD guard1_bike3 

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard1_bike3

				CLEAR_CHAR_THREAT_SEARCH guard1_bike3

				SET_CHAR_THREAT_SEARCH guard1_bike3 THREAT_PLAYER1

				GIVE_WEAPON_TO_CHAR guard1_bike3 WEAPONTYPE_TEC9 30000 // sets the gun to infinate ammo

				ADD_ROUTE_POINT 0 -751.91 1212.63 23.17

				ADD_ROUTE_POINT 0 -751.87 1204.57 23.17

				ADD_ROUTE_POINT 0 -746.22 1200.42 23.17

				ADD_ROUTE_POINT 0 -728.07 1200.61 23.17

				ADD_ROUTE_POINT 0 -703.98 1201.18 23.17

				ADD_ROUTE_POINT 0 -700.81 1200.92 23.17 // Talking point

				ADD_ROUTE_POINT 0 -703.98 1201.18 23.17

				ADD_ROUTE_POINT 0 -728.07 1200.61 23.17

				ADD_ROUTE_POINT 0 -746.22 1200.42 23.17

				ADD_ROUTE_POINT 0 -751.87 1204.57 23.17

				ADD_ROUTE_POINT 0 -751.91 1212.63 23.17

				ADD_ROUTE_POINT 0 -750.93 1235.44 23.73

				SET_CHAR_OBJ_FOLLOW_ROUTE guard1_bike3 0 FOLLOW_ROUTE_LOOP

				++ counter_all_guards_got_AI_bike3
				
				flag_guard1_got_AI_bike3 = 1
			ENDIF

		ENDIF

	ENDIF

// Guard2

	IF flag_guard2_got_AI_bike3 = 0

		IF NOT IS_CHAR_DEAD guard2_bike3 

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard2_bike3

				CLEAR_CHAR_THREAT_SEARCH guard2_bike3

				SET_CHAR_THREAT_SEARCH guard2_bike3 THREAT_PLAYER1

				GIVE_WEAPON_TO_CHAR guard2_bike3 WEAPONTYPE_TEC9 30000 // sets the gun to infinate ammo

				ADD_ROUTE_POINT 1 -659.65 1239.53 23.17

				ADD_ROUTE_POINT 1 -659.42 1214.94 23.87

				ADD_ROUTE_POINT 1 -659.33 1202.42 23.29

				ADD_ROUTE_POINT 1 -670.12 1202.51 23.30

				ADD_ROUTE_POINT 1 -689.49 1201.52 23.17

				ADD_ROUTE_POINT 1 -689.02 1201.12 23.17 // Talking point

				ADD_ROUTE_POINT 1 -689.49 1201.52 23.17

				ADD_ROUTE_POINT 1 -670.12 1202.51 23.30

				ADD_ROUTE_POINT 1 -659.33 1202.42 23.29

				ADD_ROUTE_POINT 1 -659.42 1214.94 23.87

				ADD_ROUTE_POINT 1 -659.65 1239.53 23.17

				ADD_ROUTE_POINT 1 -659.81 1257.07 23.17

				SET_CHAR_OBJ_FOLLOW_ROUTE guard2_bike3 1 FOLLOW_ROUTE_LOOP
				
				++ counter_all_guards_got_AI_bike3
				
				flag_guard2_got_AI_bike3 = 1
			ENDIF

		ENDIF

	ENDIF

// guard3
	
	IF flag_guard3_got_AI_bike3 = 0

		IF NOT IS_CHAR_DEAD guard3_bike3 

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard3_bike3

				CLEAR_CHAR_THREAT_SEARCH guard3_bike3

				SET_CHAR_THREAT_SEARCH guard3_bike3 THREAT_PLAYER1

				GIVE_WEAPON_TO_CHAR guard3_bike3 WEAPONTYPE_TEC9 30000 // sets the gun to infinate ammo

				ADD_ROUTE_POINT 2 -690.88 1271.50 10.76

				ADD_ROUTE_POINT 2 -691.99 1294.35 10.76

				ADD_ROUTE_POINT 2 -690.88 1271.50 10.76

				ADD_ROUTE_POINT 2 -692.32 1250.27 10.20

				SET_CHAR_OBJ_FOLLOW_ROUTE guard3_bike3 2 FOLLOW_ROUTE_LOOP	
				
				++ counter_all_guards_got_AI_bike3
				
				flag_guard3_got_AI_bike3 = 1
			ENDIF

		ENDIF

	ENDIF

// Guard4

	IF flag_guard4_got_AI_bike3 = 0

		IF NOT IS_CHAR_DEAD guard4_bike3 

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard4_bike3

				CLEAR_CHAR_THREAT_SEARCH guard4_bike3

				SET_CHAR_THREAT_SEARCH guard4_bike3 THREAT_PLAYER1

				GIVE_WEAPON_TO_CHAR guard4_bike3 WEAPONTYPE_TEC9 30000 // sets the gun to infinate ammo

				ADD_ROUTE_POINT 3 -756.20 1227.72 10.07

				ADD_ROUTE_POINT 3 -755.89 1243.83 10.07

				ADD_ROUTE_POINT 3 -755.94 1257.21 10.38

				ADD_ROUTE_POINT 3 -755.68 1275.26 10.66

				ADD_ROUTE_POINT 3 -755.44 1287.88 14.52 // Top of steps

				ADD_ROUTE_POINT 3 -755.68 1275.26 10.66

				ADD_ROUTE_POINT 3 -755.94 1257.21 10.38

				ADD_ROUTE_POINT 3 -755.89 1243.83 10.07

				ADD_ROUTE_POINT 3 -756.20 1227.72 10.07

				ADD_ROUTE_POINT 3 -757.70 1214.37 10.07

				SET_CHAR_OBJ_FOLLOW_ROUTE guard4_bike3 3 FOLLOW_ROUTE_LOOP	
				
				++ counter_all_guards_got_AI_bike3
				
				flag_guard4_got_AI_bike3 = 1
			ENDIF

		ENDIF

	ENDIF

// Guard5

	IF flag_guard5_got_AI_bike3 = 0

		IF NOT IS_CHAR_DEAD guard5_bike3 

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard5_bike3

				CLEAR_CHAR_THREAT_SEARCH guard5_bike3

				SET_CHAR_THREAT_SEARCH guard5_bike3 THREAT_PLAYER1

				SET_CHAR_HEADING guard5_bike3 66.98
				
				++ counter_all_guards_got_AI_bike3
				
				flag_guard5_got_AI_bike3 = 1
			ENDIF

		ENDIF

	ENDIF

// Guard6

	IF flag_guard6_got_AI_bike3 = 0

		IF NOT IS_CHAR_DEAD guard6_bike3 

			IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION guard6_bike3

				CLEAR_CHAR_THREAT_SEARCH guard6_bike3

				SET_CHAR_THREAT_SEARCH guard6_bike3 THREAT_PLAYER1

				SET_CHAR_HEADING guard6_bike3 283.89

				SET_CHARS_CHATTING guard5_bike3 guard6_bike3 1000000 // -1
									
				++ counter_all_guards_got_AI_bike3
				
				flag_guard6_got_AI_bike3 = 1
			ENDIF

		ENDIF

	ENDIF	

ENDIF

RETURN
		
}