MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************ Bankjob Mission Three ******************************
// *********************************** Race The Getaway Driver *****************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME bankjo3

// Mission start stuff

GOSUB mission_start_bankjob3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bankjob3_failed
ENDIF

GOSUB mission_cleanup_bankjob3

MISSION_END


// Variables for mission

// ******************************** Variables for mission **********************************

// Racer 1

VAR_FLOAT racer1_headings_bankjob3
VAR_FLOAT difference_x_float_d_bankjob3 difference_y_float_d_bankjob3	sum_difference_d_xy_bankjob3	
VAR_FLOAT racer1_locate_size_bankjob3 
VAR_FLOAT racer1_distance_from_cp_bankjob3
VAR_INT racer1_bankjob3

VAR_INT racer1_cpcounter_bankjob3
VAR_INT blip_racer1_bankjob3
VAR_FLOAT racer1_stuck_x_bankjob3
VAR_FLOAT racer1_stuck_y_bankjob3
VAR_FLOAT racer1_stuck_z_bankjob3
VAR_FLOAT racer1_cp_x_bankjob3
VAR_FLOAT racer1_cp_y_bankjob3
VAR_FLOAT racer1_cp_z_bankjob3

// Driver1 drives racer1

VAR_INT driver_bankjob3

// Player stuff

VAR_FLOAT player11_distance_from_cp_bankjob3
VAR_FLOAT player1_start_x_bankjob3
VAR_FLOAT player1_start_y_bankjob3
VAR_FLOAT player1_start_z_bankjob3
VAR_FLOAT player1_cp_x_bankjob3
VAR_FLOAT player1_cp_y_bankjob3
VAR_FLOAT player1_cp_z_bankjob3
VAR_INT player1_cpcounter_bankjob3

VAR_FLOAT blip_2nd_x_bankjob3
VAR_FLOAT blip_2nd_y_bankjob3
VAR_FLOAT blip_2nd_z_bankjob3

VAR_FLOAT car_x_bankjob3
VAR_FLOAT car_y_bankjob3
VAR_FLOAT car_z_bankjob3

// Check Point stuff

VAR_INT total_checkpoints_bankjob3
VAR_FLOAT cp1_x_bankjob3 cp1_y_bankjob3 cp1_z_bankjob3
VAR_FLOAT cp2_x_bankjob3 cp2_y_bankjob3 cp2_z_bankjob3
VAR_FLOAT cp3_x_bankjob3 cp3_y_bankjob3 cp3_z_bankjob3
VAR_FLOAT cp4_x_bankjob3 cp4_y_bankjob3 cp4_z_bankjob3
VAR_FLOAT cp5_x_bankjob3 cp5_y_bankjob3 cp5_z_bankjob3
VAR_FLOAT cp6_x_bankjob3 cp6_y_bankjob3 cp6_z_bankjob3
VAR_FLOAT cp7_x_bankjob3 cp7_y_bankjob3 cp7_z_bankjob3
VAR_FLOAT cp8_x_bankjob3 cp8_y_bankjob3 cp8_z_bankjob3
VAR_FLOAT cp9_x_bankjob3 cp9_y_bankjob3 cp9_z_bankjob3
VAR_FLOAT cp10_x_bankjob3 cp10_y_bankjob3 cp10_z_bankjob3
VAR_FLOAT cp11_x_bankjob3 cp11_y_bankjob3 cp11_z_bankjob3
VAR_FLOAT cp12_x_bankjob3 cp12_y_bankjob3 cp12_z_bankjob3
VAR_FLOAT cp13_x_bankjob3 cp13_y_bankjob3 cp13_z_bankjob3
VAR_FLOAT cp14_x_bankjob3 cp14_y_bankjob3 cp14_z_bankjob3
VAR_FLOAT cp15_x_bankjob3 cp15_y_bankjob3 cp15_z_bankjob3
VAR_FLOAT cp16_x_bankjob3 cp16_y_bankjob3 cp16_z_bankjob3
VAR_FLOAT cp17_x_bankjob3 cp17_y_bankjob3 cp17_z_bankjob3
VAR_FLOAT cp18_x_bankjob3 cp18_y_bankjob3 cp18_z_bankjob3
VAR_FLOAT gosub_cp_x_bankjob3 gosub_cp_y_bankjob3	gosub_cp_z_bankjob3 gosub_cp_2nd_x_bankjob3 gosub_cp_2nd_y_bankjob3 gosub_cp_2nd_z_bankjob3

VAR_INT blip_chase_bankjob3
VAR_INT second_blip_chase_bankjob3

 
VAR_INT car_health_bankjob3
VAR_INT gosub_race_car_bankjob3


VAR_INT gosub_cpcounter_bankjob3
VAR_INT position_bankjob3

// timer stuff

VAR_INT race_timer_bankjob3

VAR_INT flag_had_cops_message_bankjob3

VAR_INT flag_load_audio_bankjob3 // used to load the mission audio stuff

VAR_INT flag_car_rev_cleared_bankjob3 // Clears the car rev when the race starts

VAR_INT player_car_bank3 // Stores the car teh player is in

VAR_INT flag_had_car_message_bank3

VAR_INT player_race_car_bank3

// Timer Stuff

VAR_INT race_timer_mins_bankjob3

VAR_INT race_timer_seconds2_bankjob3
 
VAR_INT race_timer_seconds_bankjob3

VAR_INT flag_car_line_dist_bankjob3 // Used to set the car back to default distance

VAR_INT temp_int_bank3 // Used to jump the car forward in checkpoints if he is too far away form the player

// ****************************************Mission Start************************************

mission_start_bankjob3:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

flag_player_in_malibu = 0

gosub_cpcounter_bankjob3 = 0
player1_cpcounter_bankjob3 = 0
racer1_cpcounter_bankjob3 = 0
racer1_locate_size_bankjob3 = 7.0

flag_had_cops_message_bankjob3 = 0

flag_load_audio_bankjob3 = 0

flag_car_rev_cleared_bankjob3 = 0

flag_had_car_message_bank3 = 0

race_timer_bankjob3 = 0

// Timer Stuff

race_timer_mins_bankjob3 = 0

race_timer_seconds2_bankjob3 = 0
 
race_timer_seconds_bankjob3 = 0

// Used to set car back to default distance

flag_car_line_dist_bankjob3 = 0

temp_int_bank3 = 0 // Used to jump the car forward in checkpoints if he is too far away form the player

WAIT 0

LOAD_MISSION_TEXT BANKJ3
LOAD_MISSION_AUDIO 1 ( MONO13 )

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 512.591 -74.900 9.573 189.24

{

// SCFIX: START
LVAR_INT flag_hilary_won
flag_hilary_won = 0
// SCFIX: END

// ****************************************START OF CUTSCENE********************************
// Player is talking about needing a getaway driver, Phil says that he knows someone
  
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_CHARACTER 3 CSphil
LOAD_SPECIAL_MODEL CUTOBJ01 gcfan
LOAD_SPECIAL_MODEL CUTOBJ02 clchr
LOAD_SPECIAL_MODEL CUTOBJ03 colphon

SET_AREA_VISIBLE VIS_MALIBU_CLUB

LOAD_SCENE 481.03 -64.21 8.98

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03

	WAIT 0

ENDWHILE

LOAD_CUTSCENE bank_3a

SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_phil
SET_CUTSCENE_ANIM cs_phil CSphil

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_clubfan
SET_CUTSCENE_ANIM_TO_LOOP gcfan
SET_CUTSCENE_ANIM cs_clubfan gcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_clubchair
SET_CUTSCENE_ANIM cs_clubchair clchr

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_phone
SET_CUTSCENE_ANIM cs_phone colphon 

CLEAR_AREA 493.1 -82.4 9.8 1.0 TRUE
SET_PLAYER_COORDINATES player1 493.1 -82.4 9.8
SET_PLAYER_HEADING player1 220.0

DO_FADE 3000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2827
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_A ) 10000 1 // "Things are coming together perfectly." 

WHILE cs_time < 4964 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_B ) 10000 1 // "What's the plan, Tommy? Que pasa, amigo?"

WHILE cs_time < 7438 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_C ) 10000 1 //"the plan is you keep that like a moron. Anyhow we need a driver."

WHILE cs_time < 12291 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_D ) 10000 1 //"Tommy I'll do it. I can drive"

WHILE cs_time < 14893 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_E ) 10000 1 //"You want Hilary, mister. Not some smart talking law school chump."

WHILE cs_time < 19162 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_F ) 10000 1 //"Hilary is the real deal. He must drink petrol. You ain't never seen anyone so fast. I'll give him a call."

WHILE cs_time < 26056 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_G ) 10000 1 //"Hey Hil, it's Phil, how's it going. No don't talk. We'll reminisce later. You want to do me a favour?"

WHILE cs_time < 34674 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_H ) 10000 1 //"I got me a guy from up north, no I don't think he was in the service, but he wants a driver."

WHILE cs_time < 40799 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM3_I ) 10000 1 //"For a bit of action. Okay I understand."

WHILE cs_time < 46343
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_J ) 10000 1 //"What'd he say?" 

WHILE cs_time <47448 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_K ) 10000 1 //"Well he'll do it, no problem. Well, there might be a little problem, see he has abandonment issues." 

WHILE cs_time < 52709  
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_L ) 10000 1 //"Seems he won't work for anyone who can't beat him. Something to do with his momma." 

WHILE cs_time < 56624 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_M ) 10000 1 //"Anyway, he wants to race you first, said he'd meet you outside."                                                                                                                              

WHILE cs_time < 59809
 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED

	IF HAS_MISSION_AUDIO_LOADED 1
		PLAY_MISSION_AUDIO 1
	ENDIF

ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03

SET_AREA_VISIBLE VIS_MAIN_MAP

CLEAR_EXTRA_COLOURS FALSE

LOAD_SCENE 449.89 -116.18 9.74

flag_player_in_malibu = 0

// ****************************************END OF CUTSCENE**********************************

SWITCH_ROADS_OFF 439.691 -319.016 8.0 533.378 139.155 14.0
CLEAR_AREA_OF_CARS 439.691 -319.016 8.0 533.378 139.155 14.0
CLEAR_AREA_OF_CHARS 439.691 -319.016 8.0 533.378 139.155 14.0 

// ********************************** CUT SCENE TWO ****************************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CShlary
LOAD_SPECIAL_MODEL CUTOBJ01 hlrycar

LOAD_SCENE 479.090 -149.436 9.00

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01

  	WAIT 0

ENDWHILE

LOAD_CUTSCENE bank_3b

SET_CUTSCENE_OFFSET 479.090 -149.436 9.00 // Same as car position
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_hilary
SET_CUTSCENE_ANIM cs_hilary CShlary

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_hilcar
SET_CUTSCENE_ANIM cs_hilcar hlrycar

CLEAR_AREA 449.89 -116.18 9.74 1.0 TRUE
SET_PLAYER_COORDINATES player1 449.89 -116.18 9.74
SET_PLAYER_HEADING player1 310.41

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4501 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_2A ) 10000 1 //"You Tommy? Of course you're Tommy, I mean,"

WHILE cs_time < 7978
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_2B ) 10000 1 //"Why else would someone want to speak to me.

WHILE cs_time < 9549 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_2C ) 10000 1 //"OK. consider it this way.

WHILE cs_time < 11840 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW (BJM3_2D ) 10000 1 //"I'll drive for you, if and only if you can drive properly.

WHILE cs_time < 17081 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM3_2E ) 10000 1 //"Leave me alone, and I'll never forgive you.

WHILE cs_time < 20480
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 24056
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

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

// ******************************** END OF CUTSCENE TWO ************************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

// **************************************** Race Coordinates *******************************

// starting position of racer1

racer1_stuck_x_bankjob3 = 479.090 
racer1_stuck_y_bankjob3 = -149.436     
racer1_stuck_z_bankjob3 = 9.00 

// sets all the cars to face the correct way

racer1_headings_bankjob3 = 185.022

// Check points in the race

total_checkpoints_bankjob3 = 18

// Player start point

player1_start_x_bankjob3  = 483.190 
player1_start_y_bankjob3  = -149.436
player1_start_z_bankjob3  = 9.00

// Check point 1

cp1_x_bankjob3  = 479.06 
cp1_y_bankjob3  = -174.68 
cp1_z_bankjob3  = 9.00 

// Checkpoint 2

cp2_x_bankjob3  = 477.68
cp2_y_bankjob3  = -213.29 
cp2_z_bankjob3  = 10.77 

// Checkpoint 3

cp3_x_bankjob3  = 458.74
cp3_y_bankjob3  = -315.75 
cp3_z_bankjob3  = 9.08

// Check point 4

cp4_x_bankjob3  = 418.92 
cp4_y_bankjob3  = -397.27 
cp4_z_bankjob3  = 8.95 

// Check point 5

cp5_x_bankjob3  = 230.78
cp5_y_bankjob3  = -697.36 
cp5_z_bankjob3  = 9.28 

// Check point 6

cp6_x_bankjob3  = 71.23 
cp6_y_bankjob3  = -1006.72  
cp6_z_bankjob3  = 9.31 

// Check point 7

cp7_x_bankjob3  = 171.80 
cp7_y_bankjob3  = -1132.57 
cp7_z_bankjob3  = 9.28 

// Check point 8

cp8_x_bankjob3  = 160.03  
cp8_y_bankjob3  = -1331.92 
cp8_z_bankjob3  = 9.28 

// Check point 9

cp9_x_bankjob3  = 38.84  
cp9_y_bankjob3  = -1473.71 
cp9_z_bankjob3  = 9.30 

// Check point 10

cp10_x_bankjob3  = -54.79  
cp10_y_bankjob3  = -1560.57
cp10_z_bankjob3  = 9.28 

// Check point 11

cp11_x_bankjob3  = -190.29  
cp11_y_bankjob3  = -1215.46  
cp11_z_bankjob3  = 9.31  

// Check point 12

cp12_x_bankjob3 = -88.78   
cp12_y_bankjob3 = -936.21  
cp12_z_bankjob3 = 9.31  

// Check point 13

cp13_x_bankjob3 = 124.88 
cp13_y_bankjob3 = -800.59  
cp13_z_bankjob3 = 9.31  

// Check point 14

cp14_x_bankjob3 = 183.11  
cp14_y_bankjob3 = -496.49 
cp14_z_bankjob3 = 9.90 

// Check point 15

cp15_x_bankjob3 = 277.36  
cp15_y_bankjob3 = -176.64 
cp15_z_bankjob3 = 10.30 

// Check point 16

cp16_x_bankjob3 = 446.80  
cp16_y_bankjob3 = 68.27 
cp16_z_bankjob3 = 10.16 

// Check point 17

cp17_x_bankjob3 = 489.63  
cp17_y_bankjob3 = 67.13 
cp17_z_bankjob3 = 10.00 

// Check point 18

cp18_x_bankjob3 = 517.55 
cp18_y_bankjob3 = -74.78
cp18_z_bankjob3 = 9.59

SET_CAR_DENSITY_MULTIPLIER 0.3  // Normal is 1.0 

// Waiting for models to load

REQUEST_MODEL SABRETUR

REQUEST_MODEL SENTINEL

LOAD_SPECIAL_CHARACTER 3 ighlary

LOAD_MISSION_AUDIO 1 ( CARREV )  // car rev

LOAD_MISSION_AUDIO 2 ( BNK3_3A )  // Police radio

WHILE NOT HAS_MODEL_LOADED SABRETUR
OR NOT HAS_MODEL_LOADED SENTINEL
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3

	WAIT 0

ENDWHILE

CLEAR_AREA 526.20 -76.85 10.78 5.0 TRUE //will delete all projectiles in the world

// Creates car 1

CREATE_CAR SABRETUR racer1_stuck_x_bankjob3 racer1_stuck_y_bankjob3 racer1_stuck_z_bankjob3 racer1_bankjob3
LOCK_CAR_DOORS racer1_bankjob3 CARLOCK_LOCKED
SET_CAR_PROOFS racer1_bankjob3 TRUE TRUE TRUE FALSE TRUE
SET_CAR_WATERTIGHT racer1_bankjob3 TRUE
SET_CAR_STRONG racer1_bankjob3 TRUE
SET_CAR_TRACTION racer1_bankjob3 1.5 
SET_UPSIDEDOWN_CAR_NOT_DAMAGED racer1_bankjob3 TRUE
SET_CAR_STRAIGHT_LINE_DISTANCE racer1_bankjob3 200

CREATE_CHAR_INSIDE_CAR racer1_bankjob3 PEDTYPE_CIVMALE SPECIAL03 driver_bankjob3 
CLEAR_CHAR_THREAT_SEARCH driver_bankjob3 	
SET_CHAR_CANT_BE_DRAGGED_OUT driver_bankjob3 TRUE

SET_CAR_HEADING racer1_bankjob3 racer1_headings_bankjob3
CAR_SET_IDLE racer1_bankjob3
SET_CAR_DRIVING_STYLE racer1_bankjob3 2
SET_CAR_CRUISE_SPEED racer1_bankjob3 45.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER racer1_bankjob3 TRUE

CREATE_CAR SENTINEL player1_start_x_bankjob3 player1_start_y_bankjob3 player1_start_z_bankjob3 player_race_car_bank3
SET_CAR_HEADING player_race_car_bank3 racer1_headings_bankjob3
WARP_CHAR_INTO_CAR scplayer player_race_car_bank3

CLEAR_AREA 473.713 -149.895 10.546 1.0 FALSE 
SET_FIXED_CAMERA_POSITION 473.713 -149.895 10.546 0.0 0.0 0.0 // WILL HVE TO COME OUT AGAIN IF SCRIPT CHANGES
POINT_CAMERA_AT_POINT 474.708 -149.824 10.479 JUMP_CUT
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON

IF NOT IS_CHAR_DEAD driver_bankjob3
	CHAR_LOOK_AT_CHAR_ALWAYS driver_bankjob3 scplayer
	CHAR_LOOK_AT_CHAR_ALWAYS scplayer driver_bankjob3
ELSE
	PRINT_NOW ( BJM3_2 ) 5000 1 //"Shit Hilary has been wasted!"
	GOTO mission_bankjob3_failed
ENDIF 

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CAR_DEAD racer1_bankjob3
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CHAR_DEAD driver_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Shit Hilary has been wasted!"
		GOTO mission_bankjob3_failed

		IF NOT IS_CAR_DEAD racer1_bankjob3
			CAR_SET_IDLE racer1_bankjob3
		ENDIF  

	ENDIF
		
	GET_CAR_HEALTH racer1_bankjob3 car_health_bankjob3

	IF car_health_bankjob3 < 1000
	OR IS_CAR_TYRE_BURST racer1_bankjob3 ANY_WHEEL // no 4 
		car_health_bankjob3 = 9
		GOTO race_start_bankjob3
	ENDIF

	IF IS_CAR_DEAD player_race_car_bank3
		GOTO mission_bankjob3_failed
	ENDIF  

ENDWHILE

// waiting for the player1 to get to the starting grid					

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 player1_start_x_bankjob3 player1_start_y_bankjob3 player1_start_z_bankjob3 2.0 2.0 2.0 FALSE // SCFIX: last arg was TRUE
OR IS_PLAYER_IN_ANY_BOAT player1
OR IS_PLAYER_IN_FLYING_VEHICLE player1
							   
	WAIT 0

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 player1_start_x_bankjob3 player1_start_y_bankjob3 player1_start_z_bankjob3 2.0 2.0 2.0 FALSE

		IF IS_PLAYER_IN_ANY_BOAT player1
		OR IS_PLAYER_IN_FLYING_VEHICLE player1
		
			IF flag_had_car_message_bank3 = 0
				PRINT_NOW ( BJM3_4 ) 5000 1  //"You need a car to take part."
				flag_had_car_message_bank3 = 1
			ENDIF

		ELSE

			IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 player1_start_x_bankjob3 player1_start_y_bankjob3 player1_start_z_bankjob3 2.0 2.0 2.0 FALSE
	
				IF flag_had_car_message_bank3 = 0
					PRINT_NOW ( BJM3_4 ) 5000 1  //"You need a car to take part."
					flag_had_car_message_bank3 = 1
				ENDIF

			ENDIF

		ENDIF

	ELSE
		flag_had_car_message_bank3 = 0
	ENDIF
		  
	IF IS_CAR_DEAD racer1_bankjob3
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CHAR_DEAD driver_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Shit Hilary has been wasted!"
		GOTO mission_bankjob3_failed
	ENDIF
		
	GET_CAR_HEALTH racer1_bankjob3 car_health_bankjob3

	IF car_health_bankjob3 < 1000
	OR IS_CAR_TYRE_BURST racer1_bankjob3 ANY_WHEEL // no 4 
		car_health_bankjob3 = 9
		GOTO race_start_bankjob3
	ENDIF
		
ENDWHILE

race_start_bankjob3:

PLAY_MISSION_AUDIO 1 // CARREV

IF car_health_bankjob3 = 9
	PRINT_BIG ( RACE1 ) 1200 4 // "3..2..1.. GO GO GO!"
	RESTORE_CAMERA_JUMPCUT
ELSE
	SET_PLAYER_CONTROL player1 OFF
  	SET_EVERYONE_IGNORE_PLAYER player1 ON
	SET_POLICE_IGNORE_PLAYER player1 ON
  	PRINT_BIG ( RACE2 ) 1500 4 //"3"
  	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
  	WAIT 1500
	CLEAR_AREA 481.704 -155.509 10.900 1.0 FALSE 
	SET_FIXED_CAMERA_POSITION 481.704 -155.509 10.900 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 481.675 -154.522 10.741 JUMP_CUT
  	PRINT_BIG ( RACE3 ) 1500 4 //"2"
  	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2
  	WAIT 1500
	CLEAR_AREA 487.907 -148.861 11.167 1.0 FALSE 
	SET_FIXED_CAMERA_POSITION 487.907 -148.861 11.167 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 486.924 -148.899 10.98 JUMP_CUT
   	PRINT_BIG ( RACE4 ) 1500 4 //"1"
   	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1
  	WAIT 1500
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT

	STOP_CHAR_LOOKING scplayer
	IF NOT IS_CHAR_DEAD driver_bankjob3
		STOP_CHAR_LOOKING driver_bankjob3
	ELSE
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Shit Hilary has been wasted!"
		GOTO mission_bankjob3_failed
	ENDIF 
		
  	PRINT_BIG ( RACE5 ) 800 4 //"GO"
  	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
  	SET_PLAYER_CONTROL player1 ON
  	SET_EVERYONE_IGNORE_PLAYER player1 OFF
	SET_POLICE_IGNORE_PLAYER player1 OFF
ENDIF

IF IS_CAR_DEAD racer1_bankjob3
	PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
	GOTO mission_bankjob3_failed
ENDIF

ADD_BLIP_FOR_CAR_OLD racer1_bankjob3 RED MARKER_ONLY blip_racer1_bankjob3

ADD_STUCK_CAR_CHECK racer1_bankjob3 0.1 1000 

GOSUB get_next_checkpoint_bankjob3

player1_cp_x_bankjob3 = gosub_cp_x_bankjob3
player1_cp_y_bankjob3 = gosub_cp_y_bankjob3
player1_cp_z_bankjob3 = gosub_cp_z_bankjob3
blip_2nd_x_bankjob3 = gosub_cp_2nd_x_bankjob3
blip_2nd_y_bankjob3 = gosub_cp_2nd_y_bankjob3
blip_2nd_z_bankjob3 = gosub_cp_2nd_z_bankjob3

racer1_cp_x_bankjob3 = gosub_cp_x_bankjob3
racer1_cp_y_bankjob3 = gosub_cp_y_bankjob3
racer1_cp_z_bankjob3 = gosub_cp_z_bankjob3


ADD_BLIP_FOR_COORD player1_cp_x_bankjob3 player1_cp_y_bankjob3 player1_cp_z_bankjob3 blip_chase_bankjob3

ADD_BLIP_FOR_COORD_OLD blip_2nd_x_bankjob3 blip_2nd_y_bankjob3 blip_2nd_z_bankjob3 PURPLE BLIP_ONLY second_blip_chase_bankjob3
CHANGE_BLIP_SCALE second_blip_chase_bankjob3 2
DIM_BLIP second_blip_chase_bankjob3 TRUE

CAR_GOTO_COORDINATES racer1_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3

DISPLAY_ONSCREEN_TIMER_WITH_STRING race_timer_bankjob3 TIMER_UP ( R_TIME ) 

// waiting for the race to be finished

WHILE player1_cpcounter_bankjob3 < total_checkpoints_bankjob3

	WAIT 0

	IF gosub_cpcounter_bankjob3 >= 4 

		IF flag_had_cops_message_bankjob3 = 0
		
			IF HAS_MISSION_AUDIO_LOADED 2
				flag_had_cops_message_bankjob3 = 1
			ENDIF
		
		ENDIF
		
		IF flag_had_cops_message_bankjob3 = 1
			PLAY_MISSION_AUDIO 2
			PRINT_NOW ( BNK3_3A ) 5000 1 //"Illegal street race in progress at Vice Point."
			ALTER_WANTED_LEVEL_NO_DROP player1 2
			flag_had_cops_message_bankjob3 = 2
		ENDIF
		
		IF flag_had_cops_message_bankjob3 = 2
			
			IF HAS_MISSION_AUDIO_FINISHED 2
				CLEAR_THIS_PRINT ( BNK3_3A )
				flag_had_cops_message_bankjob3 = 3
			ENDIF
		
		ENDIF
		
		IF flag_had_cops_message_bankjob3 = 3
			LOAD_MISSION_AUDIO 1 ( BNK3_3B )
			LOAD_MISSION_AUDIO 2 ( BNK3_3C )
			flag_had_cops_message_bankjob3 = 4
		ENDIF

		IF flag_had_cops_message_bankjob3 = 4
		
			IF HAS_MISSION_AUDIO_LOADED 1
				flag_had_cops_message_bankjob3 = 5
			ENDIF
			
		ENDIF
		
		IF flag_had_cops_message_bankjob3 = 5
			PLAY_MISSION_AUDIO 1
			PRINT_NOW ( BNK3_3B ) 5000 1 //""Calling all officers."
			flag_had_cops_message_bankjob3 = 6
		ENDIF

		IF flag_had_cops_message_bankjob3 = 6
		
			IF HAS_MISSION_AUDIO_FINISHED 1
				CLEAR_THIS_PRINT ( BNK3_3B )
				flag_had_cops_message_bankjob3 = 7
			ENDIF
			
		ENDIF
		
		IF flag_had_cops_message_bankjob3 = 7
		
			IF HAS_MISSION_AUDIO_LOADED 2
				flag_had_cops_message_bankjob3 = 8
			ENDIF
			
		ENDIF
		
		IF flag_had_cops_message_bankjob3 = 8
			PLAY_MISSION_AUDIO 2
			PRINT_NOW ( BNK3_3C ) 5000 1 //"Street racers, this is illegal and forbidden."
 			flag_had_cops_message_bankjob3 = 9
		ENDIF

		IF flag_had_cops_message_bankjob3 = 9

			IF HAS_MISSION_AUDIO_FINISHED 2
				CLEAR_THIS_PRINT ( BNK3_3C )
				SWITCH_ROADS_ON 439.691 -319.016 8.0 533.378 139.155 14.0 // switches on road outside of Malibu
				flag_had_cops_message_bankjob3 = 10
			ENDIF

		ENDIF
				
	ENDIF 
   		
	IF flag_car_rev_cleared_bankjob3 = 0
		CLEAR_MISSION_AUDIO 1
		flag_car_rev_cleared_bankjob3 = 1
	ENDIF

	IF flag_had_cops_message_bankjob3 = 1

		IF HAS_MISSION_AUDIO_FINISHED 2
			CLEAR_THIS_PRINT ( BNK3_3A )
			CLEAR_THIS_PRINT ( BNK3_3B )
			CLEAR_MISSION_AUDIO 2
			flag_had_cops_message_bankjob3 = 2
		ENDIF

	ENDIF
			 	
	position_bankjob3 = 0

	IF LOCATE_PLAYER_IN_CAR_3D player1 player1_cp_x_bankjob3 player1_cp_y_bankjob3 player1_cp_z_bankjob3 6.0 6.0 6.0 0
	AND NOT IS_PLAYER_IN_ANY_BOAT player1
	AND NOT IS_PLAYER_IN_FLYING_VEHICLE player1
		
		++ player1_cpcounter_bankjob3

		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE // This might not work
		
		REMOVE_BLIP blip_chase_bankjob3
		REMOVE_BLIP second_blip_chase_bankjob3
		
		gosub_cpcounter_bankjob3 = player1_cpcounter_bankjob3
		GOSUB get_next_checkpoint_bankjob3
		player1_cp_x_bankjob3 = gosub_cp_x_bankjob3
		player1_cp_y_bankjob3 = gosub_cp_y_bankjob3
		player1_cp_z_bankjob3 = gosub_cp_z_bankjob3
		blip_2nd_x_bankjob3 = gosub_cp_2nd_x_bankjob3
		blip_2nd_y_bankjob3 = gosub_cp_2nd_y_bankjob3
		blip_2nd_z_bankjob3 = gosub_cp_2nd_z_bankjob3
		
		IF player1_cpcounter_bankjob3 = total_checkpoints_bankjob3
			GOTO mini_cutscene_bankjob3		
		ENDIF

		ADD_BLIP_FOR_COORD player1_cp_x_bankjob3 player1_cp_y_bankjob3 player1_cp_z_bankjob3 blip_chase_bankjob3

		IF player1_cpcounter_bankjob3 < 17
			ADD_BLIP_FOR_COORD_OLD blip_2nd_x_bankjob3 blip_2nd_y_bankjob3 blip_2nd_z_bankjob3 PURPLE BLIP_ONLY second_blip_chase_bankjob3
			DIM_BLIP second_blip_chase_bankjob3 ON
			CHANGE_BLIP_SCALE second_blip_chase_bankjob3 2
		ENDIF
	ENDIF

// Chase car 1

	IF IS_CHAR_DEAD driver_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Shit Hilary has been wasted!"
		GOTO mission_bankjob3_failed
	ENDIF
			
	IF NOT IS_CAR_DEAD racer1_bankjob3
						
		IF IS_CHAR_DEAD driver_bankjob3
			PRINT_NOW ( BJM3_2 ) 5000 1 //"Shit Hilary has been wasted!"
			GOTO mission_bankjob3_failed
		ENDIF
		
		gosub_race_car_bankjob3 = racer1_bankjob3
		gosub_cpcounter_bankjob3 = racer1_cpcounter_bankjob3
		gosub_cp_x_bankjob3 = racer1_cp_x_bankjob3 
		gosub_cp_y_bankjob3 = racer1_cp_y_bankjob3 
		gosub_cp_z_bankjob3 = racer1_cp_z_bankjob3 
		GOSUB car_stuck_checks_bankjob3
				
	 	IF LOCATE_CAR_3D racer1_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3 racer1_locate_size_bankjob3 racer1_locate_size_bankjob3 racer1_locate_size_bankjob3 0
			
			++ racer1_cpcounter_bankjob3

			IF flag_car_line_dist_bankjob3 = 0
				SET_CAR_STRAIGHT_LINE_DISTANCE racer1_bankjob3 20
				flag_car_line_dist_bankjob3 = 1
			ENDIF

			gosub_cpcounter_bankjob3 = racer1_cpcounter_bankjob3
			GOSUB get_next_checkpoint_bankjob3
			racer1_cp_x_bankjob3 = gosub_cp_x_bankjob3
			racer1_cp_y_bankjob3 = gosub_cp_y_bankjob3
			racer1_cp_z_bankjob3 = gosub_cp_z_bankjob3
			
			IF racer1_cpcounter_bankjob3 = total_checkpoints_bankjob3
				racer1_locate_size_bankjob3 = 6.0
			ENDIF

			IF racer1_cpcounter_bankjob3 = total_checkpoints_bankjob3
				//PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!" // SCFIX: moved
				//GOTO mission_bankjob3_failed		// SCFIX: moved
				// SCFIX: START - restore unused line
				flag_hilary_won = 1
				GOTO mini_cutscene_bankjob3
				// SCFIX: END
			ENDIF
			
			IF racer1_locate_size_bankjob3 = 7.0
				CAR_GOTO_COORDINATES racer1_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3
			ELSE
				CAR_GOTO_COORDINATES_ACCURATE racer1_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3
			ENDIF

		ENDIF
		
		IF IS_CAR_IN_WATER racer1_bankjob3

			IF NOT IS_CAR_ON_SCREEN racer1_bankjob3

				GET_CAR_COORDINATES racer1_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
				GET_CLOSEST_CAR_NODE car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3

				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0 4.0 4.0

					IF NOT IS_POINT_ON_SCREEN car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 3.0
						SET_CAR_COORDINATES racer1_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
						TURN_CAR_TO_FACE_COORD racer1_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3
					ENDIF

				ENDIF

			ENDIF

		ENDIF

	ELSE

		IF NOT IS_CAR_IN_WATER racer1_bankjob3
			racer1_cpcounter_bankjob3	= 0
		ENDIF
		
   	ENDIF
		 
	IF position_bankjob3 = 0
		PRINT ( FIRST ) 100 1 //"1st"
	ENDIF

	IF position_bankjob3 = 1
		PRINT ( SECOND ) 100 1 //"2nd"
	ENDIF
		
	IF player1_cpcounter_bankjob3 = 17
		DRAW_CORONA player1_cp_x_bankjob3 player1_cp_y_bankjob3 player1_cp_z_bankjob3 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 0 0
	ELSE
		DRAW_CORONA player1_cp_x_bankjob3 player1_cp_y_bankjob3 player1_cp_z_bankjob3 5.5 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

ENDWHILE

CLEAR_ONSCREEN_TIMER race_timer_bankjob3


// mini cut-scene with driver saying he will do the job for the player1

mini_cutscene_bankjob3:

CLEAR_WANTED_LEVEL player1
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

IF IS_PLAYER_IN_ANY_CAR player1
	APPLY_BRAKES_TO_PLAYERS_CAR player1 ON
	STORE_CAR_PLAYER_IS_IN player1 player_car_bank3
ENDIF

SET_FADING_COLOUR 1 1 1

DO_FADE 1500 FADE_OUT 

WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CAR_DEAD racer1_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CAR_DEAD player_car_bank3
		GOTO mission_bankjob3_failed
	ENDIF	

ENDWHILE

SET_FIXED_CAMERA_POSITION 515.93 -82.24 12.87 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 515.92 -81.38 12.55 JUMP_CUT

CLEAR_AREA 513.70 -74.30 9.58 4.0 TRUE
CLEAR_AREA_OF_CARS 528.63 64.64 8.0 376.19 -320.62 16.0 

SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

SET_CAR_COORDINATES player_car_bank3 513.70 -74.30 9.58
SET_CAR_HEADING player_car_bank3 180.0

SET_CAR_COORDINATES racer1_bankjob3 517.19 -74.30 9.58 
SET_CAR_HEADING racer1_bankjob3 180.0
REMOVE_BLIP blip_racer1_bankjob3 
SET_CAR_CRUISE_SPEED racer1_bankjob3 0.0
CAR_SET_IDLE racer1_bankjob3 

IF flag_load_audio_bankjob3 = 0
	IF flag_hilary_won = 1 // SCFIX: restore cut line
		LOAD_MISSION_AUDIO 1 ( BNK3_2 )  // SCFIX: restore cut line
	ELSE // SCFIX: restore cut line
		LOAD_MISSION_AUDIO 1 ( BNK3_1 )  // Hilary message 
	ENDIF // SCFIX: restore cut line
	flag_load_audio_bankjob3 = 1
ENDIF

WHILE NOT HAS_MISSION_AUDIO_LOADED 1 

	WAIT 0

	IF IS_CAR_DEAD racer1_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CAR_DEAD player_car_bank3
		GOTO mission_bankjob3_failed
	ENDIF
		  	
ENDWHILE

SET_FADING_COLOUR 1 1 1

DO_FADE 1500 FADE_IN 

WHILE GET_FADING_STATUS 

	WAIT 0

	IF IS_CAR_DEAD racer1_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CAR_DEAD player_car_bank3
		GOTO mission_bankjob3_failed
	ENDIF

ENDWHILE

// Make player1 and Hilary look at each other

IF NOT IS_CHAR_DEAD driver_bankjob3 
	PLAYER_LOOK_AT_CHAR_ALWAYS player1 driver_bankjob3
	CHAR_LOOK_AT_PLAYER_ALWAYS driver_bankjob3 player1
ELSE
	PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
	GOTO mission_bankjob3_failed
ENDIF

//IF player1_cpcounter_bankjob3 = total_checkpoints_bankjob3 // SCFIX: removed
	PLAY_MISSION_AUDIO 1 // Hilary talk stuff
	IF flag_hilary_won = 1 // SCFIX: restore cut line
		PRINT_NOW ( BNK3_2 ) 6000 1 //"I'm not driving for you, no way, I'm sharing this at group." // SCFIX: restore cut line
	ELSE // SCFIX: restore cut line
		PRINT_NOW ( BNK3_1 ) 6000 1 //"Ok. I'll drive for you, but please, treat me bad."
	ENDIF // SCFIX: restore cut line
//ENDIF // SCFIX: removed

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0
	
	IF IS_CHAR_DEAD driver_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CAR_DEAD racer1_bankjob3
	
		IF IS_CHAR_DEAD driver_bankjob3
			PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
			GOTO mission_bankjob3_failed
		ENDIF
		
	ENDIF
	
	IF IS_CAR_DEAD player_car_bank3
		GOTO mission_bankjob3_failed
	ENDIF  
	
ENDWHILE

CLEAR_MISSION_AUDIO 1
IF flag_hilary_won = 1 // SCFIX: restore cut line
	CLEAR_THIS_PRINT ( BNK3_2 )
ELSE // SCFIX: restore cut line
	CLEAR_THIS_PRINT ( BNK3_1 )
ENDIF // SCFIX: restore cut line

IF NOT IS_CHAR_DEAD driver_bankjob3 
	STOP_PLAYER_LOOKING player1
	STOP_CHAR_LOOKING driver_bankjob3
ELSE
	PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
	GOTO mission_bankjob3_failed
ENDIF

IF NOT IS_CAR_DEAD racer1_bankjob3 
	REMOVE_STUCK_CAR_CHECK racer1_bankjob3
	SET_CAR_CRUISE_SPEED racer1_bankjob3 30.0
	CAR_GOTO_COORDINATES racer1_bankjob3 478.26 -129.32 9.01 
ENDIF

timerb = 0
timera = 0

WHILE IS_CHAR_ON_SCREEN driver_bankjob3 
AND timera < 3000

	WAIT 0

	IF IS_CHAR_DEAD driver_bankjob3
		PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
		GOTO mission_bankjob3_failed
	ENDIF

	IF IS_CAR_DEAD racer1_bankjob3
	
		IF IS_CHAR_DEAD driver_bankjob3
			PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
			GOTO mission_bankjob3_failed
		ENDIF
		
	ENDIF
	
	IF timera >= 5000
	   	   
		IF NOT IS_CHAR_DEAD driver_bankjob3 
		
			IF IS_CHAR_ON_SCREEN driver_bankjob3
				GOTO mini_cut2_bankjob3
			ENDIF

		ELSE
			PRINT_NOW ( BJM3_2 ) 5000 1 //"Hilary is dead!"
			GOTO mission_bankjob3_failed
		ENDIF
		
	ENDIF
	
	IF IS_CAR_DEAD player_car_bank3
		GOTO mission_bankjob3_failed
	ENDIF 
		
ENDWHILE 

mini_cut2_bankjob3:

CAR_SET_IDLE racer1_bankjob3
DELETE_CHAR driver_bankjob3 
DELETE_CAR racer1_bankjob3 

IF NOT IS_CAR_DEAD player_car_bank3
	APPLY_BRAKES_TO_PLAYERS_CAR player1 OFF
ELSE
	GOTO mission_bankjob3_failed
ENDIF

SWITCH_WIDESCREEN OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT 

IF flag_hilary_won = 1 // SCFIX
	PRINT_NOW ( RACEFA ) 5000 1 //"~r~You failed to win the race!" // SCFIX: moved here
	GOTO mission_bankjob3_failed		// SCFIX: moved here
ELSE // SCFIX
	GOTO mission_bankjob3_passed
ENDIF // SCFIX

// ****************************************** Mission Failed *******************************

mission_bankjob3_failed:

CLEAR_THIS_PRINT ( FIRST )
CLEAR_THIS_PRINT ( SECOND )

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

IF NOT IS_CAR_DEAD racer1_bankjob3
	SET_CAR_CRUISE_SPEED racer1_bankjob3 0.0
	CAR_SET_IDLE racer1_bankjob3
ENDIF

RETURN

// *************************************** Mission Passed **********************************

mission_bankjob3_passed:

flag_bankjob_mission3_passed = 1
REGISTER_MISSION_PASSED ( BANK_3 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1

// Works out race time in mins and seconds
race_timer_seconds_bankjob3 = race_timer_bankjob3 / 1000 //seconds
REGISTER_FASTEST_TIME 1 race_timer_seconds_bankjob3
race_timer_mins_bankjob3 = race_timer_seconds_bankjob3 / 60 // mins
race_timer_seconds2_bankjob3 = race_timer_mins_bankjob3 * 60 
race_timer_seconds_bankjob3 = race_timer_seconds_bankjob3 - race_timer_seconds2_bankjob3 

ADD_SCORE player1 3000
PRINT_WITH_NUMBER_BIG ( M_PASS ) 3000 5000 1 // "Mission Passed!"

IF race_timer_seconds_bankjob3 >= 10
	PRINT_WITH_2_NUMBERS_NOW ( RACETM ) race_timer_mins_bankjob3 race_timer_seconds_bankjob3 5000 1
ELSE
	PRINT_WITH_2_NUMBERS_NOW ( RACETM2 ) race_timer_mins_bankjob3 race_timer_seconds_bankjob3 5000 1
ENDIF

START_NEW_SCRIPT bankjob_mission4_loop
RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_bankjob3:

REMOVE_CHAR_ELEGANTLY driver_bankjob3

IF NOT IS_CAR_DEAD racer1_bankjob3
	SET_CAR_PROOFS racer1_bankjob3 FALSE FALSE FALSE FALSE FALSE
	SET_CAR_WATERTIGHT racer1_bankjob3 FALSE
	SET_CAR_STRONG racer1_bankjob3 FALSE 
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED racer1_bankjob3 FALSE
ENDIF 

SWITCH_ROADS_ON 439.691 -319.016 8.0 533.378 139.155 14.0 // switches on road outside of Malibu
SET_CAR_DENSITY_MULTIPLIER 1.0

flag_player_on_mission = 0
SET_CAR_DENSITY_MULTIPLIER 1.0 // Sets this back to normal
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED SABRETUR
MARK_MODEL_AS_NO_LONGER_NEEDED SENTINEL
SWITCH_ROADS_ON 444.90 -203.82 8.0 572.14 133.77 20.0
REMOVE_BLIP blip_racer1_bankjob3
REMOVE_BLIP blip_chase_bankjob3
REMOVE_BLIP second_blip_chase_bankjob3
CLEAR_ONSCREEN_TIMER race_timer_bankjob3
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

// Creates the next checkpoint

get_next_checkpoint_bankjob3:

	IF gosub_cpcounter_bankjob3 = 0
		gosub_cp_x_bankjob3 = cp1_x_bankjob3
		gosub_cp_y_bankjob3 = cp1_y_bankjob3
		gosub_cp_z_bankjob3 = cp1_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp2_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp2_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp2_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 1
		gosub_cp_x_bankjob3 = cp2_x_bankjob3
		gosub_cp_y_bankjob3 = cp2_y_bankjob3
		gosub_cp_z_bankjob3 = cp2_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp3_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp3_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp3_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 2
		gosub_cp_x_bankjob3 = cp3_x_bankjob3
		gosub_cp_y_bankjob3 = cp3_y_bankjob3
		gosub_cp_z_bankjob3 = cp3_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp4_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp4_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp4_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 3
		gosub_cp_x_bankjob3 = cp4_x_bankjob3
		gosub_cp_y_bankjob3 = cp4_y_bankjob3
		gosub_cp_z_bankjob3 = cp4_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp5_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp5_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp5_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 4
		gosub_cp_x_bankjob3 = cp5_x_bankjob3
		gosub_cp_y_bankjob3 = cp5_y_bankjob3
		gosub_cp_z_bankjob3 = cp5_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp6_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp6_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp6_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 5
		gosub_cp_x_bankjob3 = cp6_x_bankjob3
		gosub_cp_y_bankjob3 = cp6_y_bankjob3
		gosub_cp_z_bankjob3 = cp6_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp7_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp7_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp7_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 6
		gosub_cp_x_bankjob3 = cp7_x_bankjob3
		gosub_cp_y_bankjob3 = cp7_y_bankjob3
		gosub_cp_z_bankjob3 = cp7_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp8_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp8_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp8_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 7
		gosub_cp_x_bankjob3 = cp8_x_bankjob3
		gosub_cp_y_bankjob3 = cp8_y_bankjob3
		gosub_cp_z_bankjob3 = cp8_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp9_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp9_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp9_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 8
		gosub_cp_x_bankjob3 = cp9_x_bankjob3
		gosub_cp_y_bankjob3 = cp9_y_bankjob3
		gosub_cp_z_bankjob3 = cp9_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp10_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp10_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp10_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 9
		gosub_cp_x_bankjob3 = cp10_x_bankjob3
		gosub_cp_y_bankjob3 = cp10_y_bankjob3
		gosub_cp_z_bankjob3 = cp10_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp11_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp11_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp11_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 10
		gosub_cp_x_bankjob3 = cp11_x_bankjob3
		gosub_cp_y_bankjob3 = cp11_y_bankjob3
		gosub_cp_z_bankjob3 = cp11_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp12_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp12_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp12_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 11
		gosub_cp_x_bankjob3 = cp12_x_bankjob3
		gosub_cp_y_bankjob3 = cp12_y_bankjob3
		gosub_cp_z_bankjob3 = cp12_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp13_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp13_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp13_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 12
		gosub_cp_x_bankjob3 = cp13_x_bankjob3
		gosub_cp_y_bankjob3 = cp13_y_bankjob3
		gosub_cp_z_bankjob3 = cp13_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp14_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp14_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp14_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 13
		gosub_cp_x_bankjob3 = cp14_x_bankjob3
		gosub_cp_y_bankjob3 = cp14_y_bankjob3
		gosub_cp_z_bankjob3 = cp14_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp15_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp15_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp15_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 14
		gosub_cp_x_bankjob3 = cp15_x_bankjob3
		gosub_cp_y_bankjob3 = cp15_y_bankjob3
		gosub_cp_z_bankjob3 = cp15_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp16_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp16_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp16_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 15
		gosub_cp_x_bankjob3 = cp16_x_bankjob3
		gosub_cp_y_bankjob3 = cp16_y_bankjob3
		gosub_cp_z_bankjob3 = cp16_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp17_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp17_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp17_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 16
		gosub_cp_x_bankjob3 = cp17_x_bankjob3
		gosub_cp_y_bankjob3 = cp17_y_bankjob3
		gosub_cp_z_bankjob3 = cp17_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp18_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp18_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp18_z_bankjob3
	ENDIF

	IF gosub_cpcounter_bankjob3 = 17
		gosub_cp_x_bankjob3 = cp18_x_bankjob3
		gosub_cp_y_bankjob3 = cp18_y_bankjob3
		gosub_cp_z_bankjob3 = cp18_z_bankjob3
		gosub_cp_2nd_x_bankjob3 = cp18_x_bankjob3
		gosub_cp_2nd_y_bankjob3 = cp18_y_bankjob3
		gosub_cp_2nd_z_bankjob3 = cp18_z_bankjob3
	ENDIF

RETURN

// car stuck checks

car_stuck_checks_bankjob3:

GET_CAR_HEALTH gosub_race_car_bankjob3 car_health_bankjob3

IF car_health_bankjob3 < 500
	SET_CAR_HEALTH gosub_race_car_bankjob3 1000
ENDIF

IF player1_cpcounter_bankjob3	= gosub_cpcounter_bankjob3	
	GET_CAR_COORDINATES	gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
	difference_x_float_d_bankjob3 = car_x_bankjob3 - player1_cp_x_bankjob3
	difference_y_float_d_bankjob3 = car_y_bankjob3 - player1_cp_y_bankjob3
	difference_x_float_d_bankjob3 = difference_x_float_d_bankjob3 * difference_x_float_d_bankjob3
	difference_y_float_d_bankjob3 = difference_y_float_d_bankjob3 * difference_y_float_d_bankjob3
	sum_difference_d_xy_bankjob3 = difference_x_float_d_bankjob3 + difference_y_float_d_bankjob3
	SQRT sum_difference_d_xy_bankjob3 racer1_distance_from_cp_bankjob3

	GET_PLAYER_COORDINATES player1 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
	difference_x_float_d_bankjob3 = car_x_bankjob3 - player1_cp_x_bankjob3
	difference_y_float_d_bankjob3 = car_y_bankjob3 - player1_cp_y_bankjob3
	difference_x_float_d_bankjob3 = difference_x_float_d_bankjob3 * difference_x_float_d_bankjob3
	difference_y_float_d_bankjob3 = difference_y_float_d_bankjob3 * difference_y_float_d_bankjob3
	sum_difference_d_xy_bankjob3 = difference_x_float_d_bankjob3 + difference_y_float_d_bankjob3
	SQRT sum_difference_d_xy_bankjob3 player11_distance_from_cp_bankjob3

	IF player11_distance_from_cp_bankjob3 > racer1_distance_from_cp_bankjob3
		++ position_bankjob3
	ENDIF
ELSE
	IF player1_cpcounter_bankjob3 < gosub_cpcounter_bankjob3
		++ position_bankjob3
	ENDIF
ENDIF

IF IS_CAR_STUCK gosub_race_car_bankjob3

	IF NOT IS_CAR_ON_SCREEN gosub_race_car_bankjob3

		IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 gosub_race_car_bankjob3 30.0 30.0 30.0 FALSE

			GET_CAR_COORDINATES gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
			GET_CLOSEST_CAR_NODE car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3

			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0 4.0 3.0

				IF NOT IS_POINT_ON_SCREEN car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0
					SET_CAR_COORDINATES gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
					TURN_CAR_TO_FACE_COORD gosub_race_car_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3
				   	
					IF racer1_locate_size_bankjob3 = 7.0
						SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
						SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
						CAR_GOTO_COORDINATES gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
					ELSE
						SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
						SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
						CAR_GOTO_COORDINATES_ACCURATE gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
					ENDIF

				ENDIF

			ELSE

				GET_NTH_CLOSEST_CAR_NODE car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 2 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3

				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0 4.0 3.0

					IF NOT IS_POINT_ON_SCREEN car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0
						SET_CAR_COORDINATES gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
						TURN_CAR_TO_FACE_COORD gosub_race_car_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3
					   	
						IF racer1_locate_size_bankjob3 = 7.0
							SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
							SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
							CAR_GOTO_COORDINATES gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
						ELSE
							SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
							SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
							CAR_GOTO_COORDINATES_ACCURATE gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF

	ENDIF
	
ENDIF

// Checks to see if the car has turned upside down

IF IS_CAR_UPSIDEDOWN gosub_race_car_bankjob3

	IF NOT IS_CAR_ON_SCREEN gosub_race_car_bankjob3

		IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 gosub_race_car_bankjob3 30.0 30.0 30.0 FALSE

			GET_CAR_COORDINATES gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
			GET_CLOSEST_CAR_NODE car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
			CLEAR_AREA car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0 FALSE 

			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0 4.0 3.0

				IF NOT IS_POINT_ON_SCREEN car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0
					SET_CAR_COORDINATES gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
					TURN_CAR_TO_FACE_COORD gosub_race_car_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3
				   
					IF racer1_locate_size_bankjob3 = 7.0
						SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
						SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
						CAR_GOTO_COORDINATES gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
					ELSE
						SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
						SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
						CAR_GOTO_COORDINATES_ACCURATE gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
					ENDIF

				ENDIF

			ELSE

				GET_NTH_CLOSEST_CAR_NODE car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 2 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3

				IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0 4.0 3.0

					IF NOT IS_POINT_ON_SCREEN car_x_bankjob3 car_y_bankjob3 car_z_bankjob3 4.0
						SET_CAR_COORDINATES gosub_race_car_bankjob3 car_x_bankjob3 car_y_bankjob3 car_z_bankjob3
						TURN_CAR_TO_FACE_COORD gosub_race_car_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3
					   
						IF racer1_locate_size_bankjob3 = 7.0
							SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
							SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
							CAR_GOTO_COORDINATES gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
						ELSE
							SET_CAR_DRIVING_STYLE gosub_race_car_bankjob3 2
							SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
							CAR_GOTO_COORDINATES_ACCURATE gosub_race_car_bankjob3 gosub_cp_x_bankjob3 gosub_cp_y_bankjob3 gosub_cp_z_bankjob3
						ENDIF

					ENDIF

				ENDIF

		 	ENDIF

		ENDIF

	ENDIF

ENDIF

temp_int_bank3 = player1_cpcounter_bankjob3 - 3

IF gosub_cpcounter_bankjob3 < temp_int_bank3
	
	IF NOT IS_CAR_ON_SCREEN gosub_race_car_bankjob3

		IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3 4.0 4.0 3.0

			IF NOT IS_POINT_ON_SCREEN racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3 4.0
				SET_CAR_COORDINATES gosub_race_car_bankjob3 racer1_cp_x_bankjob3 racer1_cp_y_bankjob3 racer1_cp_z_bankjob3
				TURN_CAR_TO_FACE_COORD gosub_race_car_bankjob3 player1_cp_x_bankjob3 player1_cp_y_bankjob3
				SET_CAR_FORWARD_SPEED gosub_race_car_bankjob3 30.0
			ENDIF

		ENDIF

	ENDIF

ENDIF

temp_int_bank3 = player1_cpcounter_bankjob3 + 2
IF gosub_cpcounter_bankjob3 > temp_int_bank3
	SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 35.0
ELSE
	SET_CAR_CRUISE_SPEED gosub_race_car_bankjob3 45.0
ENDIF

RETURN

}