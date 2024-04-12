MISSION_START
// *****************************************************************************************
// ********************************* Haitian Mission 2 ************************************* 
// ************************************* Drop Off ******************************************
// *****************************************************************************************
// *** The Haitians *** Bombs Away
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_haitian2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_haitian2_failed
ENDIF

GOSUB mission_cleanup_haitian2

MISSION_END
 
// Variables for mission


//FLAGS TIMERS COUNTERS
VAR_INT circle_button_pressed circle_button_timer boat_route_counter
VAR_INT player_attacking_flag new_boat_using_gosub	no_of_rc_planes_left
VAR_INT bomb_is_primed_flag	detonation_timer next_bomb_timer dead_cubans
VAR_INT cuban_dude13_flag cuban_dude13_timer
VAR_INT cuban_jetmax_flag cuban_speeder_flag cuban_coastg_flag cubangang_car_flag
VAR_INT help_counter_h2 help_timer_h2
VAR_INT player_run_out_of_planes_timer player_run_out_of_planes

//PEDS VEHICLES OBJECTS
VAR_INT rc_plane plane_carrier
VAR_INT primed_bomb_1 falling_bomb_1 
VAR_INT cuban_speeder cuban_jetmax cuban_coastg cubangang_car 
VAR_INT cuban_dude01 cuban_dude02 cuban_dude03 cuban_dude04 cuban_dude05 cuban_dude06
VAR_INT cuban_dude07 cuban_dude08 cuban_dude13
VAR_INT cs_drugpak

//BLIPS
VAR_INT plane_carrier_blip cuban_jetmax_blip cuban_speeder_blip 
VAR_INT cuban_coastg_blip 
VAR_INT cuban_dude01_blip cuban_dude02_blip	cuban_dude03_blip cuban_dude04_blip	cuban_dude05_blip
VAR_INT cuban_dude06_blip cuban_dude07_blip	cuban_dude08_blip 	
VAR_INT cuban_dude13_blip

//COORD MATHS
VAR_FLOAT distance_to_ground
VAR_FLOAT grenade_x grenade_y grenade_z
VAR_FLOAT primed_bomb_z
VAR_FLOAT cuban_jetmax_heading cuban_speeder_heading cuban_coastg_heading heading_diff

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE stuff
//VAR_INT game_timer timer gosub_boat

// ****************************************Mission Start************************************

mission_start_haitian2:

flag_player_on_mission = 1
flag_player_on_rc_mission = 1

REGISTER_MISSION_GIVEN
SCRIPT_NAME HAIT2

WAIT 0
{
LVAR_INT cuban_dude01_flag cuban_dude01_timer
LVAR_INT cuban_dude02_flag cuban_dude02_timer
LVAR_INT cuban_dude03_flag cuban_dude03_timer
LVAR_INT cuban_dude04_flag cuban_dude04_timer
LVAR_INT cuban_dude05_flag cuban_dude05_timer
LVAR_INT cuban_dude06_flag cuban_dude06_timer
LVAR_INT cuban_dude07_flag cuban_dude07_timer
LVAR_INT cuban_dude08_flag cuban_dude08_timer

LOAD_MISSION_TEXT HAIT2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -957.904 122.843 8.278 356.948

rc_plane = -1
no_of_rc_planes_left  = 3

circle_button_pressed = 0
circle_button_timer	  = 0
detonation_timer      = 0
bomb_is_primed_flag   = 0
next_bomb_timer       = 0
player_attacking_flag = 0
boat_route_counter    = 0
new_boat_using_gosub  = 0
dead_cubans			  = 0
button_pressed		  = 0
help_counter_h2 	  = 0
help_timer_h2		  = 0
player_run_out_of_planes_timer = 0
player_run_out_of_planes = 0

cuban_dude01_flag  = 0
cuban_dude01_timer = 0
cuban_dude02_flag  = 0
cuban_dude02_timer = 0
cuban_dude03_flag  = 0
cuban_dude03_timer = 0
cuban_dude04_flag  = 0
cuban_dude04_timer = 0
cuban_dude05_flag  = 0
cuban_dude05_timer = 0
cuban_dude06_flag  = 0
cuban_dude06_timer = 0
cuban_dude07_flag  = 0
cuban_dude07_timer = 0
cuban_dude08_flag  = 0
cuban_dude08_timer = 0
cuban_dude13_flag  = 0
cuban_dude13_timer = 0

cuban_jetmax_flag  = 0
cuban_speeder_flag = 0
cuban_coastg_flag  = 0
cubangang_car_flag = 0

//////////////////////////
//////////////////////////

SET_AREA_VISIBLE VIS_POLICE_STATION
SET_EXTRA_COLOURS 13 FALSE

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 apoulet

LOAD_SPECIAL_MODEL CUTOBJ01 htable
LOAD_SPECIAL_MODEL CUTOBJ02 drugpak
LOAD_SPECIAL_MODEL CUTOBJ03 kettle

LOAD_SCENE -962.799 148.391 8.355

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
OR NOT HAS_MODEL_LOADED CUTOBJ03
	WAIT 0

ENDWHILE

SET_NEAR_CLIP 0.1
SET_EXTRA_COLOURS 13 FALSE

LOAD_CUTSCENE HAT_2
SET_CUTSCENE_OFFSET -962.799 148.391 8.355

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken apoulet

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_htable
SET_CUTSCENE_ANIM cs_htable htable

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_drugpak
SET_CUTSCENE_ANIM cs_drugpak drugpak

CREATE_CUTSCENE_OBJECT CUTOBJ03 cs_kettle
SET_CUTSCENE_ANIM cs_kettle kettle

CLEAR_AREA -962.53 141.69 8.25 1.0 TRUE
SET_PLAYER_COORDINATES player1 -962.53 141.69 8.25
SET_PLAYER_HEADING player1 183.42

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4054
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_1 10000 1 //Oh. Sorry I must have the wrong address... 
 
WHILE cs_time < 7163
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_2 10000 1 //Well you might as well come in and rest your soles and have some tea. 
 
WHILE cs_time < 11419
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_3 10000 1 //Do you have something for me there, Tommy?
 
WHILE cs_time < 13873
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_4 10000 1 //Yeah...
 
WHILE cs_time < 16370
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_5 10000 1 //This place feels familiar to me. A smell from childhood - a deja vu...
 
WHILE cs_time < 22166
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_6 10000 1 //Now Tommy, I'm going to whisper me a lickle errand for you. Hear me well, aye?
 
WHILE cs_time < 28339
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_7 10000 1 //You look like someone I...
 
WHILE cs_time < 30139
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_8 10000 1 //The Cubans have fast boats they use to cross the seas with drugs.
 
WHILE cs_time < 34861
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_9 10000 1 //It is their livelihood. 
 
WHILE cs_time < 37790
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_10 10000 1 //Me nephew bin making ickle flying bombs to take dem out. 
 
WHILE cs_time < 42538
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_11 10000 1 //Blow de boats to coffin wood.
 
WHILE cs_time < 51176
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW HAT2_12 10000 1 //Well thanks for the tea.
 
WHILE cs_time < 56400//53248
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT


CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

CLEAR_EXTRA_COLOURS FALSE

SET_AREA_VISIBLE VIS_MAIN_MAP

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ03

//////////////////////////
//////////////////////////

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

REQUEST_MODEL TOPFUN
REQUEST_MODEL RCBARON
REQUEST_MODEL SPEEDER
REQUEST_MODEL JETMAX	
REQUEST_MODEL COASTG	
REQUEST_MODEL CUBAN
REQUEST_MODEL CBA	
REQUEST_MODEL CBB	
REQUEST_MODEL RUGER

LOAD_SCENE -962.53 141.69 8.25
LOAD_ALL_MODELS_NOW

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

WHILE NOT HAS_MODEL_LOADED TOPFUN
OR NOT HAS_MODEL_LOADED RCBARON
OR NOT HAS_MODEL_LOADED SPEEDER
OR NOT HAS_MODEL_LOADED JETMAX
OR NOT HAS_MODEL_LOADED COASTG
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUBAN	
OR NOT HAS_MODEL_LOADED CBA	
OR NOT HAS_MODEL_LOADED CBB	
OR NOT HAS_MODEL_LOADED RUGER	
	WAIT 0
ENDWHILE

PRINT_NOW HAT2_B1 15000 1//"Get to the van that contains the flying bombs."

CREATE_CAR TOPFUN -808.9448 -162.9215 10.0458 plane_carrier
SET_CAR_HEADING plane_carrier 0.0
ADD_BLIP_FOR_CAR plane_carrier plane_carrier_blip
FREEZE_CAR_POSITION	plane_carrier TRUE

WHILE NOT IS_PLAYER_SITTING_IN_CAR player1 plane_carrier
	WAIT 0
	
	IF IS_CAR_DEAD plane_carrier
		GOTO mission_haitian2_failed
	ENDIF

ENDWHILE

//LOCK_CAR_DOORS plane_carrier CARLOCK_LOCKED_PLAYER_INSIDE

REMOVE_BLIP plane_carrier_blip

CREATE_CAR JETMAX -524.3332 -227.5792 5.3 cuban_jetmax
SET_CAR_HEADING cuban_jetmax 25.0 
ANCHOR_BOAT cuban_jetmax TRUE
SET_BOAT_CRUISE_SPEED cuban_jetmax 12.0
ADD_BLIP_FOR_CAR cuban_jetmax cuban_jetmax_blip
//ADD_BLIP_FOR_CAR cuban_jetmax cuban_jetmax_blip

CREATE_CAR SPEEDER -533.5898 -230.4594 5.3 cuban_speeder
SET_CAR_HEADING cuban_speeder 88.4134
ANCHOR_BOAT cuban_speeder TRUE
SET_BOAT_CRUISE_SPEED cuban_speeder 12.0
//ADD_BLIP_FOR_CAR cuban_speeder cuban_speeder_blip

CREATE_CAR COASTG -514.9578 -230.6103 5.3 cuban_coastg
SET_CAR_HEADING cuban_coastg 265.6394
ANCHOR_BOAT cuban_coastg TRUE
SET_BOAT_CRUISE_SPEED cuban_coastg 12.0
//ADD_BLIP_FOR_CAR cuban_coastg cuban_coastg_blip

//CREATE_CAR DINGHY -513.9479 -234.7423 7.3 dinghy1
//SET_CAR_HEADING dinghy1 0.0
//SET_BOAT_CRUISE_SPEED dinghy1 12.0
//ADD_BLIP_FOR_CAR dinghy1 dinghy1_blip

//CREATE_CAR DINGHY -509.4384 -234.9151 7.3 dinghy2
//SET_CAR_HEADING dinghy2 0.0
//SET_BOAT_CRUISE_SPEED dinghy2 12.0
//ADD_BLIP_FOR_CAR dinghy2 dinghy2_blip

CREATE_CAR CUBAN -524.3280 -255.0365 9.5340 cubangang_car
SET_CAR_HEADING cubangang_car 183.1269
//POP_CAR_BOOT cubangang_car

////WATCHING MINI CRANE - SPEEDER DRIVER 1ST
CREATE_CHAR PEDTYPE_CIVMALE CBA -535.1575 -233.1016 7.2104 cuban_dude01
SET_CHAR_HEADING cuban_dude01 27.1130
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude01 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude01
//ADD_BLIP_FOR_CHAR cuban_dude01 cuban_dude01_blip

////WORKING MINI CRANE - SPEEDER SHOOTER 2ND
CREATE_CHAR PEDTYPE_CIVMALE CBA -538.0 -235.1073 7.2104 cuban_dude02
SET_CHAR_HEADING cuban_dude02 273.9880
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude02 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude02
SET_CHAR_WAIT_STATE cuban_dude02 WAITSTATE_USE_ATM 100
//ADD_BLIP_FOR_CHAR cuban_dude02 cuban_dude02_blip

////STANDING NEXT TO CUBAN SITTING ON STEPS - SPEEDER SHOOTER 3RD 
CREATE_CHAR PEDTYPE_CIVMALE CBB -528.9341 -237.8728 7.2056 cuban_dude03
SET_CHAR_HEADING cuban_dude03 6.0796
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude03 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude03
//ADD_BLIP_FOR_CHAR cuban_dude03 cuban_dude03_blip

////SITTING ON SIDE OF STEPS - JETMAX DRIVER 4TH
CREATE_CHAR PEDTYPE_CIVMALE CBB -527.7787 -236.5049 7.2104 cuban_dude04
SET_CHAR_HEADING cuban_dude04 93.2798
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude04 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude04
SET_CHAR_WAIT_STATE cuban_dude04 WAITSTATE_SIT_IDLE 100
//ADD_BLIP_FOR_CHAR cuban_dude04 cuban_dude04_blip

////CHATTING ON PIER - JETMAX SHOOTER 5TH
CREATE_CHAR PEDTYPE_CIVMALE CBA -519.8645 -242.7792 9.5542 cuban_dude05
SET_CHAR_HEADING cuban_dude05 244.8008
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude05 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude05
SET_CHAR_WAIT_STATE cuban_dude05 WAITSTATE_CROSS_ROAD_LOOK 100
//ADD_BLIP_FOR_CHAR cuban_dude05 cuban_dude05_blip

//CHATTING ON PIER - COASTG DRIVER 6TH
CREATE_CHAR PEDTYPE_CIVMALE CBA -517.9925 -243.0342 9.5542 cuban_dude06
SET_CHAR_HEADING cuban_dude06 118.9880
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude06 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude06
//ADD_BLIP_FOR_CHAR cuban_dude06 cuban_dude06_blip

//WORKING ON THE ENGINE OF DINGHY2 - COASTG FRONT SHOOTER 7TH
CREATE_CHAR PEDTYPE_CIVMALE CBB -509.3864 -237.7915 7.2103 cuban_dude07
SET_CHAR_HEADING cuban_dude07 6.0796
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude07 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude07
SET_CHAR_WAIT_STATE cuban_dude07 WAITSTATE_USE_ATM 100
//ADD_BLIP_FOR_CHAR cuban_dude07 cuban_dude07_blip

//CHATTING ON PIER - COASTG BACK SHOOTER 8TH
CREATE_CHAR PEDTYPE_CIVMALE CBB -519.7886 -244.7169 9.5542 cuban_dude08
SET_CHAR_HEADING cuban_dude08 357.2437
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude08 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude08
SET_CHARS_CHATTING cuban_dude06 cuban_dude08 600000000
//ADD_BLIP_FOR_CHAR cuban_dude08 cuban_dude08_blip

//CREATE_CHAR PEDTYPE_CIVMALE CBA -506.4470 -257.3781 11.000 cuban_dude09
//SET_CHAR_HEADING cuban_dude09 335.5638
//SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude09 TRUE
//CLEAR_CHAR_THREAT_SEARCH cuban_dude09
//SET_CHAR_CROUCH cuban_dude09 TRUE 100
//ADD_BLIP_FOR_CHAR cuban_dude09 cuban_dude09_blip

//CHATTING BY - DINGHY1 SHOOTER 10TH
//CREATE_CHAR PEDTYPE_CIVMALE CBA -509.9002 -256.8647 9.5327 cuban_dude10
//SET_CHAR_HEADING cuban_dude10 315.2729
//SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude10 TRUE
//CLEAR_CHAR_THREAT_SEARCH cuban_dude10
//ADD_BLIP_FOR_CHAR cuban_dude10 cuban_dude10_blip

//LOADING - DINGHY2 DRIVER 11TH
//CREATE_CHAR PEDTYPE_CIVMALE CBB -505.1767 -255.8461 9.5680 cuban_dude11
//SET_CHAR_HEADING cuban_dude11 116.1346
//SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude11 TRUE
//CLEAR_CHAR_THREAT_SEARCH cuban_dude11
//SET_CHAR_WAIT_STATE cuban_dude11 WAITSTATE_PLAYANIM_CHAT 100
//ADD_BLIP_FOR_CHAR cuban_dude11 cuban_dude11_blip

//CHATTING BY - DINGHY2 SHOOTER 12TH
//CREATE_CHAR PEDTYPE_CIVMALE CBA -508.1243 -255.8814 9.5476 cuban_dude12
//SET_CHAR_HEADING cuban_dude12 118.9880
//SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude12 TRUE
//CLEAR_CHAR_THREAT_SEARCH cuban_dude12
//SET_CHARS_CHATTING cuban_dude10 cuban_dude12 600000000
//ADD_BLIP_FOR_CHAR cuban_dude12 cuban_dude12_blip

//BEHIND CUBAN CAR WORKING IN TRUNK	- ENTER CUBAN CAR 13TH
CREATE_CHAR PEDTYPE_CIVMALE CBB -524.5753 -251.0094 9.5370 cuban_dude13
SET_CHAR_HEADING cuban_dude13 185.2318
SET_CHAR_STAY_IN_SAME_PLACE	cuban_dude13 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_dude13
SET_CHAR_WAIT_STATE cuban_dude13 WAITSTATE_USE_ATM 100
//ADD_BLIP_FOR_CHAR cuban_dude13 cuban_dude13_blip

GOTO hait2_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	CREATE_OBJECT rcbomb 0.0 0.0 0.0 primed_bomb_1
	GET_REMOTE_CONTROLLED_CAR player1 rc_plane
	ADD_BLIP_FOR_CAR cuban_jetmax cuban_jetmax_blip
	ADD_BLIP_FOR_CAR cuban_speeder cuban_speeder_blip
	ADD_BLIP_FOR_CAR cuban_coastg cuban_coastg_blip
hait2_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE

SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_IN

SWITCH_WIDESCREEN ON
SET_FIXED_CAMERA_POSITION -552.6316 -220.1019 22.1608 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -551.9008 -220.5808 21.6745 JUMP_CUT
LOAD_SCENE -524.1709 -234.6104 8.1665
PRINT_NOW HAT2_B2 4500 1//"Kill the Cubans..."

GET_GAME_TIMER game_timer
timer = game_timer + 4500

button_pressed = 0 // SCFIX: fix skips not working
WHILE game_timer < timer
	WAIT 0
	GET_GAME_TIMER game_timer
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO cutscene_skip
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE

SET_FIXED_CAMERA_POSITION -541.3336 -237.3457 9.8484 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -540.4141 -237.0497 9.5899 JUMP_CUT
PRINT_NOW HAT2_B4 4000 1//"...and destroy their boats!"

GET_GAME_TIMER game_timer
timer = game_timer + 4000

button_pressed = 0 // SCFIX: fix skips not working
WHILE game_timer < timer
	WAIT 0
	GET_GAME_TIMER game_timer
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO cutscene_skip
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE

cutscene_skip:

button_pressed = 0

IF IS_CAR_DEAD plane_carrier
	GOTO mission_haitian2_failed
ENDIF


SET_CAR_COORDINATES plane_carrier -808.9448 -162.9215 10.0458
SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT


SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 FALSE
SWITCH_WIDESCREEN OFF
SET_ALL_CARS_CAN_BE_DAMAGED TRUE

WHILE NOT IS_PLAYER_DEAD player1
	
	WAIT 0

	GET_GAME_TIMER game_timer

	IF IS_CAR_DEAD plane_carrier
		GOTO mission_haitian2_failed
	ENDIF
	
	//plane_carrier & rc_plane//////
	////////////////////////////////
	IF player_run_out_of_planes = 0
		IF IS_PLAYER_SITTING_IN_CAR	player1 plane_carrier
			
			IF NOT IS_PLAYER_IN_REMOTE_MODE	player1
				IF NOT no_of_rc_planes_left = 0
					IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -812.0 -168.0 10.0457 0.6 0.6 1.0
						GIVE_REMOTE_CONTROLLED_MODEL_TO_PLAYER player1 -812.0 -168.0 10.0457 180.0 rcbaron
						
						-- no_of_rc_planes_left
						IF no_of_rc_planes_left = 2
							DISPLAY_ONSCREEN_COUNTER_WITH_STRING no_of_rc_planes_left COUNTER_DISPLAY_NUMBER HAT2_B9
						ENDIF
					ELSE
						GOTO cutscene_skip
					ENDIF
				ELSE
					PRINT_NOW HAT2_B8 5000 1//"~r~You have no RC planes left!"
					player_run_out_of_planes = 1
					player_run_out_of_planes_timer = game_timer + 2000
					//GOTO mission_haitian2_failed
				ENDIF 
				GET_REMOTE_CONTROLLED_CAR player1 rc_plane
		
				SET_ENABLE_RC_DETONATE FALSE
				SET_POLICE_IGNORE_PLAYER player1 ON
				CLEAR_WANTED_LEVEL player1
				SET_PLAYER_CONTROL player1 ON
			ENDIF
			
			IF IS_PLAYER_IN_REMOTE_MODE	player1

				IF help_counter_h2 = 0
					CLEAR_HELP
					
					GET_CONTROLLER_MODE controlmode
					IF controlmode = 3
						PRINT_HELP PLANE_4 //plane help text
					ELSE
						PRINT_HELP PLANE_H //plane help text
					ENDIF

					help_counter_h2 ++
					help_timer_h2 = game_timer + 6000
				ENDIF

				IF help_counter_h2 = 1
					IF help_timer_h2 < game_timer
						CLEAR_HELP

						GET_CONTROLLER_MODE controlmode
						IF controlmode = 3
							PRINT_HELP BOLLOX //"Press CIRCLE to drop a bomb."
						ELSE
							PRINT_HELP HAT2_B3 //"Press CIRCLE to drop a bomb."
						ENDIF

						help_counter_h2 ++
					ENDIF
				ENDIF

				IF NOT IS_CAR_DEAD rc_plane
					IF LOCATE_PLAYER_IN_CAR_CAR_2D player1 rc_plane	500.0 750.0 0
						IF NOT LOCATE_PLAYER_IN_CAR_CAR_2D player1 rc_plane	450.0 700.0 0
							PRINT_NOW HAT2_B6 100 1//"The RC plane is getting too far out of range!"
						ENDIF
						bomb_is_primed_flag = 0
						GET_CAR_COORDINATES rc_plane grenade_x grenade_y grenade_z
						IF NOT DOES_OBJECT_EXIST primed_bomb_1
							IF game_timer > next_bomb_timer
								CREATE_OBJECT rcbomb grenade_x grenade_y grenade_z primed_bomb_1
								SET_OBJECT_COLLISION primed_bomb_1 FALSE
								SET_OBJECT_DYNAMIC primed_bomb_1 FALSE
								primed_bomb_z = 0.0
							ENDIF
						ELSE
							GET_GROUND_Z_FOR_3D_COORD grenade_x grenade_y grenade_z ground_z
							distance_to_ground = grenade_z - ground_z
							IF distance_to_ground > 0.5
								SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE grenade_x grenade_y grenade_z 10.0 rcbomb TRUE
								primed_bomb_z -=@ 0.05
								IF primed_bomb_z < -0.5
									primed_bomb_z = -0.5
									bomb_is_primed_flag = 1
								ENDIF
							ELSE
								primed_bomb_z = distance_to_ground - 1.0
								primed_bomb_z = primed_bomb_z * -1.0
								IF primed_bomb_z > 0.0
									primed_bomb_z = 0.0
									SET_VISIBILITY_OF_CLOSEST_OBJECT_OF_TYPE grenade_x grenade_y grenade_z 10.0 rcbomb FALSE
								ENDIF
							ENDIF
							PLACE_OBJECT_RELATIVE_TO_CAR primed_bomb_1 rc_plane 0.0 0.0 primed_bomb_z
						ENDIF

						IF IS_IN_CAR_FIRE_BUTTON_PRESSED

							IF circle_button_pressed = 0

								IF bomb_is_primed_flag = 1

							        
									primed_bomb_z = primed_bomb_z - 0.5
									PLACE_OBJECT_RELATIVE_TO_CAR primed_bomb_1 rc_plane 0.0 0.0 primed_bomb_z
									SET_OBJECT_DYNAMIC primed_bomb_1 TRUE
									SET_OBJECT_COLLISION primed_bomb_1 TRUE
									ADD_TO_OBJECT_VELOCITY primed_bomb_1 0.0 0.0 0.0
									next_bomb_timer = game_timer + 500
									falling_bomb_1 = primed_bomb_1
									primed_bomb_1 = -1
									SET_OBJECT_RECORDS_COLLISIONS falling_bomb_1 TRUE
									circle_button_timer = game_timer + 250
									detonation_timer = game_timer + 3000
									circle_button_pressed = 1
								ENDIF

							ENDIF
						
						ELSE
							IF circle_button_pressed = 2
								IF game_timer > circle_button_timer
									circle_button_pressed = 0
								ENDIF
							ENDIF
						ENDIF
					
					ELSE
						IF NOT rc_plane = -1
							REMOVE_RC_BUGGY
							SET_PLAYER_CONTROL player1 OFF
							MARK_OBJECT_AS_NO_LONGER_NEEDED	primed_bomb_1
							MARK_OBJECT_AS_NO_LONGER_NEEDED	falling_bomb_1
							primed_bomb_1 = -1
							falling_bomb_1 = -1
							rc_plane = -1
							circle_button_pressed = 0
						ENDIF
					ENDIF
				ELSE
					IF NOT rc_plane = -1
						REMOVE_RC_BUGGY
						//SET_PLAYER_CONTROL player1 OFF
						MARK_OBJECT_AS_NO_LONGER_NEEDED	primed_bomb_1
						MARK_OBJECT_AS_NO_LONGER_NEEDED	falling_bomb_1
						primed_bomb_1 = -1
						falling_bomb_1 = -1
						rc_plane = -1
						circle_button_pressed = 0
					ENDIF
				ENDIF
				
				IF IS_BUTTON_PRESSED PAD1 TRIANGLE
					IF button_pressed = 1
						IF NOT rc_plane = -1
							//SET_PLAYER_CONTROL player1 OFF
							PRINT_NOW RCCANX 2000 1 //RC plane cancelled.
							REMOVE_RC_BUGGY
							MARK_OBJECT_AS_NO_LONGER_NEEDED	primed_bomb_1
							MARK_OBJECT_AS_NO_LONGER_NEEDED	falling_bomb_1
							primed_bomb_1 = -1
							falling_bomb_1 = -1
							rc_plane = -1
							circle_button_pressed = 0
						ENDIF
						button_pressed = 0
					ENDIF
				
				ELSE
					IF button_pressed = 0
						button_pressed = 1
					ENDIF
				ENDIF
			ENDIF
		
		ELSE
			IF NOT rc_plane = -1
				//SET_PLAYER_CONTROL player1 OFF
				REMOVE_RC_BUGGY
				MARK_OBJECT_AS_NO_LONGER_NEEDED	primed_bomb_1
				MARK_OBJECT_AS_NO_LONGER_NEEDED	falling_bomb_1
				primed_bomb_1 = -1
				falling_bomb_1 = -1
				rc_plane = -1
				circle_button_pressed = 0
			ENDIF
		ENDIF

		IF circle_button_pressed = 1
			IF DOES_OBJECT_EXIST falling_bomb_1
				GET_OBJECT_COORDINATES falling_bomb_1 grenade_x grenade_y grenade_z
				GET_GROUND_Z_FOR_3D_COORD grenade_x grenade_y grenade_z ground_z
				ground_z += 0.5
				IF ground_z < 6.0
					ground_z = 6.0
				ENDIF
				IF HAS_OBJECT_COLLIDED_WITH_ANYTHING falling_bomb_1
				OR game_timer > detonation_timer
				OR IS_OBJECT_IN_WATER falling_bomb_1
					SET_OBJECT_RECORDS_COLLISIONS falling_bomb_1 FALSE
					ADD_EXPLOSION grenade_x grenade_y grenade_z EXPLOSION_GRENADE
					MARK_OBJECT_AS_NO_LONGER_NEEDED	falling_bomb_1
					falling_bomb_1 = -1
					circle_button_pressed = 2
				ENDIF
			ENDIF
		ENDIF
		
		IF player_attacking_flag = 0
			IF DOES_OBJECT_EXIST falling_bomb_1
				IF IS_OBJECT_IN_AREA_3D	falling_bomb_1 -554.2964 -277.5887 0.0 -492.5130 -212.6366 20.0 0
				OR IS_PLAYER_IN_AREA_3D	player1 -554.2964 -277.5887 0.0 -492.5130 -212.6366 20.0 0
					IF NOT IS_CHAR_DEAD	cuban_dude01
						ADD_BLIP_FOR_CHAR cuban_dude01 cuban_dude01_blip
						CHANGE_BLIP_DISPLAY cuban_dude01_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude01_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude02
						ADD_BLIP_FOR_CHAR cuban_dude02 cuban_dude02_blip
						CHANGE_BLIP_DISPLAY cuban_dude02_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude02_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude03
						ADD_BLIP_FOR_CHAR cuban_dude03 cuban_dude03_blip
						CHANGE_BLIP_DISPLAY cuban_dude03_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude03_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude04
						ADD_BLIP_FOR_CHAR cuban_dude04 cuban_dude04_blip
						CHANGE_BLIP_DISPLAY cuban_dude04_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude04_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude05
						ADD_BLIP_FOR_CHAR cuban_dude05 cuban_dude05_blip
						CHANGE_BLIP_DISPLAY cuban_dude05_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude05_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude06
						ADD_BLIP_FOR_CHAR cuban_dude06 cuban_dude06_blip
						CHANGE_BLIP_DISPLAY cuban_dude06_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude06_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude07
						ADD_BLIP_FOR_CHAR cuban_dude07 cuban_dude07_blip
						CHANGE_BLIP_DISPLAY cuban_dude07_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude07_blip 2
					ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude08
						ADD_BLIP_FOR_CHAR cuban_dude08 cuban_dude08_blip
						CHANGE_BLIP_DISPLAY cuban_dude08_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude08_blip 2
					ENDIF
					IF NOT IS_CAR_DEAD	cuban_jetmax
						REMOVE_BLIP	cuban_jetmax_blip
						ADD_BLIP_FOR_CAR cuban_jetmax cuban_jetmax_blip
					ENDIF
					IF NOT IS_CAR_DEAD	cuban_speeder
						REMOVE_BLIP	cuban_speeder_blip
						ADD_BLIP_FOR_CAR cuban_speeder cuban_speeder_blip
					ENDIF
					IF NOT IS_CAR_DEAD	cuban_coastg
						REMOVE_BLIP	cuban_coastg_blip
						ADD_BLIP_FOR_CAR cuban_coastg cuban_coastg_blip
					ENDIF
	//				IF NOT IS_CHAR_DEAD	cuban_dude09
	//					ADD_BLIP_FOR_CHAR cuban_dude09 cuban_dude09_blip
	//					CHANGE_BLIP_DISPLAY cuban_dude09_blip BLIP_ONLY
	//					CHANGE_BLIP_SCALE cuban_dude09_blip 2
	//				ENDIF
	//				IF NOT IS_CHAR_DEAD	cuban_dude10
	//					ADD_BLIP_FOR_CHAR cuban_dude10 cuban_dude10_blip
	//					CHANGE_BLIP_DISPLAY cuban_dude10_blip BLIP_ONLY
	//					CHANGE_BLIP_SCALE cuban_dude10_blip 2
	//				ENDIF
	//				IF NOT IS_CHAR_DEAD	cuban_dude11
	//					ADD_BLIP_FOR_CHAR cuban_dude11 cuban_dude11_blip
	//					CHANGE_BLIP_DISPLAY cuban_dude11_blip BLIP_ONLY
	//					CHANGE_BLIP_SCALE cuban_dude11_blip 2
	//				ENDIF
	//				IF NOT IS_CHAR_DEAD	cuban_dude12
	//					ADD_BLIP_FOR_CHAR cuban_dude12 cuban_dude12_blip
	//					CHANGE_BLIP_DISPLAY cuban_dude12_blip BLIP_ONLY
	//					CHANGE_BLIP_SCALE cuban_dude12_blip 2
	//				ENDIF
					IF NOT IS_CHAR_DEAD	cuban_dude13
						ADD_BLIP_FOR_CHAR cuban_dude13 cuban_dude13_blip
						CHANGE_BLIP_DISPLAY cuban_dude13_blip BLIP_ONLY
						CHANGE_BLIP_SCALE cuban_dude13_blip 2
					ENDIF
					player_attacking_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF player_run_out_of_planes_timer < game_timer
			GOTO mission_haitian2_failed
		ENDIF
	ENDIF

	dead_cubans = 0
	
	//cuban_dude01//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude01
		IF player_attacking_flag = 1
			IF cuban_dude01_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					GIVE_WEAPON_TO_CHAR cuban_dude01 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude01 rc_plane
					cuban_dude01_timer = game_timer	+ 3500
					cuban_dude01_flag = 1
				ELSE
					cuban_dude01_timer = game_timer	- 100
					cuban_dude01_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude01_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude01 rc_plane
				ENDIF
				IF game_timer > cuban_dude01_timer
					IF NOT IS_CAR_DEAD cuban_speeder
						SET_CHAR_OBJ_NO_OBJ cuban_dude01
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude01 -535.0269 -230.2825
						cuban_dude01_timer = game_timer	+ 700
						cuban_dude01_flag = 2
					ELSE
						cuban_dude01_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude01_flag = 2
				IF NOT IS_CAR_DEAD cuban_speeder
					IF IS_CAR_HEALTH_GREATER cuban_speeder 250
						IF game_timer >	cuban_dude01_timer
							SET_CHAR_OBJ_NO_OBJ	cuban_dude01
							REMOVE_BLIP	cuban_dude01_blip
							DELETE_CHAR	cuban_dude01
							CREATE_CHAR_INSIDE_CAR cuban_speeder PEDTYPE_CIVMALE CBA cuban_dude01
							cuban_dude01_flag = 3//IN CUBAN_SPEEDER AS DRIVER
						ENDIF
					ELSE
						cuban_dude01_flag = 100
					ENDIF
				ELSE
					cuban_dude01_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude01_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude01 rc_plane
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT cuban_dude01_flag = -10
			REMOVE_BLIP cuban_dude01_blip
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude01_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF
	
	//cuban_dude02//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude02
		IF player_attacking_flag = 1
			IF cuban_dude02_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_WAIT_STATE cuban_dude02 WAITSTATE_FALSE 17
					GIVE_WEAPON_TO_CHAR cuban_dude02 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude02 rc_plane
					cuban_dude02_timer = game_timer	+ 3700
					cuban_dude02_flag = 1
				ELSE
					cuban_dude02_timer = game_timer	- 100
					cuban_dude02_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude02_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude02 rc_plane
				ENDIF
				IF game_timer > cuban_dude02_timer
					IF NOT IS_CAR_DEAD cuban_speeder
						SET_CHAR_OBJ_NO_OBJ cuban_dude02
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude02 -537.8747 -233.0850
						cuban_dude02_flag = 2
					ELSE
						cuban_dude02_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude02_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude02 -537.8747 -233.0850 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_speeder
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude02 -535.1575 -233.1016
						cuban_dude02_flag = 3
					ELSE
						cuban_dude02_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude02_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude02 -535.1575 -233.1016 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_speeder
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude02 -535.0269 -230.2825
						cuban_dude02_timer = game_timer	+ 700
						cuban_dude02_flag = 4
					ELSE
						cuban_dude02_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude02_flag = 4
				IF NOT IS_CAR_DEAD cuban_speeder
					IF IS_CAR_HEALTH_GREATER cuban_speeder 250
						IF game_timer >	cuban_dude02_timer
							IF NOT IS_CHAR_DEAD	cuban_dude01
								//ATTACH_CHAR_TO_CAR cuban_dude02 cuban_speeder -0.6107 1.4015 1.3205 FACING_BACK 360.0 WEAPONTYPE_RUGER
								ATTACH_CHAR_TO_CAR cuban_dude02 cuban_speeder 0.6462 1.4897 1.3333 FACING_BACK 360.0 WEAPONTYPE_RUGER
								REMOVE_BLIP	cuban_dude02_blip
								cuban_dude02_flag = 100//IN CUBAN_SPEEDER AS SHOOTER
							ELSE
								REMOVE_BLIP	cuban_dude02_blip
								DELETE_CHAR	cuban_dude02
								CREATE_CHAR_INSIDE_CAR cuban_speeder PEDTYPE_CIVMALE CBA cuban_dude02
								cuban_dude02_flag = 5//IN CUBAN_SPEEDER AS DRIVER
							ENDIF
						ENDIF
					ELSE
						cuban_dude02_flag = 100
					ENDIF
				ELSE
					cuban_dude02_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude02_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude02 rc_plane
				ENDIF
			ENDIF
		ELSE
			SET_CHAR_WAIT_STATE cuban_dude02 WAITSTATE_USE_ATM 100
		ENDIF
	ELSE
		IF NOT cuban_dude02_flag = -10
			REMOVE_BLIP cuban_dude02_blip
			DETACH_CHAR_FROM_CAR cuban_dude02
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude02_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_dude03//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude03
		IF player_attacking_flag = 1
			IF cuban_dude03_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					GIVE_WEAPON_TO_CHAR cuban_dude03 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude03 rc_plane
					cuban_dude03_timer = game_timer	+ 3900
					cuban_dude03_flag = 1
				ELSE
					cuban_dude03_timer = game_timer	- 100
					cuban_dude03_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude03_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude03 rc_plane
				ENDIF
				IF game_timer > cuban_dude03_timer
					IF NOT IS_CAR_DEAD cuban_speeder
						SET_CHAR_OBJ_NO_OBJ cuban_dude03
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude03 -535.1575 -233.1016
						cuban_dude03_flag = 2
					ELSE
						cuban_dude03_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude03_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude03 -535.1575 -233.1016 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_speeder
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude03 -535.0269 -230.2825
						cuban_dude03_timer = game_timer	+ 700
						cuban_dude03_flag = 3
					ELSE
						cuban_dude03_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude03_flag = 3
				IF NOT IS_CAR_DEAD cuban_speeder
					IF IS_CAR_HEALTH_GREATER cuban_speeder 250
						IF game_timer >	cuban_dude03_timer
						//OR LOCATE_CHAR_ON_FOOT_2D cuban_dude03 -535.0269 -230.2825 1.0 1.0 0
							IF NOT IS_CHAR_DEAD	cuban_dude01
							OR NOT IS_CHAR_DEAD	cuban_dude02
								ATTACH_CHAR_TO_CAR cuban_dude03 cuban_speeder -0.6107 1.4015 1.3205 FACING_BACK 360.0 WEAPONTYPE_RUGER
								REMOVE_BLIP	cuban_dude03_blip
								//ATTACH_CHAR_TO_CAR cuban_dude03 cuban_speeder 0.6462 1.4897 1.3333 FACING_BACK 360.0 WEAPONTYPE_RUGER
								cuban_dude03_flag = 100//IN CUBAN_SPEEDER AS SHOOTER
							ELSE
								REMOVE_BLIP	cuban_dude03_blip
								DELETE_CHAR	cuban_dude03
								CREATE_CHAR_INSIDE_CAR cuban_speeder PEDTYPE_CIVMALE CBB cuban_dude03
								cuban_dude03_flag = 4//IN CUBAN_SPEEDER AS DRIVER
							ENDIF
						ENDIF
					ELSE
						cuban_dude03_flag = 100
					ENDIF
				ELSE
					cuban_dude03_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude03_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude03 rc_plane
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT cuban_dude03_flag = -10
			REMOVE_BLIP cuban_dude03_blip
			DETACH_CHAR_FROM_CAR cuban_dude03
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude03_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_dude04//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude04
		IF player_attacking_flag = 1
			IF cuban_dude04_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_WAIT_STATE cuban_dude04 WAITSTATE_FALSE 17
					GIVE_WEAPON_TO_CHAR cuban_dude04 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude04 rc_plane
					cuban_dude04_timer = game_timer	+ 1200
					cuban_dude04_flag = 1
				ELSE
					cuban_dude04_timer = game_timer	- 100
					cuban_dude04_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude04_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude04 rc_plane
				ENDIF
				IF game_timer > cuban_dude04_timer
					IF NOT IS_CAR_DEAD cuban_jetmax
						SET_CHAR_OBJ_NO_OBJ cuban_dude04
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude04 -524.5031 -232.6815
						cuban_dude04_flag = 2
					ELSE
						cuban_dude04_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude04_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude04 -524.5031 -232.6815 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_jetmax
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude04 -524.4131 -229.7234
						cuban_dude04_timer = game_timer	+ 700
						cuban_dude04_flag = 3
					ELSE
						cuban_dude04_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude04_flag = 3
				IF NOT IS_CAR_DEAD cuban_jetmax
					IF IS_CAR_HEALTH_GREATER cuban_jetmax 250
						IF game_timer >	cuban_dude04_timer
							REMOVE_BLIP	cuban_dude04_blip
							DELETE_CHAR	cuban_dude04
							CREATE_CHAR_INSIDE_CAR cuban_jetmax PEDTYPE_CIVMALE CBB cuban_dude04
							cuban_dude04_flag = 4//IN cuban_jetmax AS DRIVER
						ENDIF
					ELSE
						cuban_dude04_flag = 100
					ENDIF
				ELSE
					cuban_dude04_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude04_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude04 rc_plane
				ENDIF
			ENDIF
		ELSE
			SET_CHAR_WAIT_STATE cuban_dude04 WAITSTATE_SIT_IDLE 100
		ENDIF
	ELSE
		IF NOT cuban_dude04_flag = -10
			REMOVE_BLIP cuban_dude04_blip
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude04_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_dude05//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude05
		IF player_attacking_flag = 1
			IF cuban_dude05_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_WAIT_STATE cuban_dude05 WAITSTATE_FALSE 17
					GIVE_WEAPON_TO_CHAR cuban_dude05 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude05 rc_plane
					cuban_dude05_timer = game_timer	+ 1500
					cuban_dude05_flag = 1
				ELSE
					cuban_dude05_timer = game_timer	- 100
					cuban_dude05_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude05_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude05 rc_plane
				ENDIF
				IF game_timer > cuban_dude05_timer
					IF NOT IS_CAR_DEAD cuban_jetmax
						SET_CHAR_OBJ_NO_OBJ cuban_dude05
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude05 -524.5031 -232.6815
						cuban_dude05_flag = 2
					ELSE
						cuban_dude05_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude05_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude05 -524.5031 -232.6815 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_jetmax
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude05 -524.4131 -229.7234
						cuban_dude05_timer = game_timer	+ 700
						cuban_dude05_flag = 3
					ELSE
						cuban_dude05_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude05_flag = 3
				IF NOT IS_CAR_DEAD cuban_jetmax
					IF IS_CAR_HEALTH_GREATER cuban_jetmax 250
						IF game_timer >	cuban_dude05_timer
							IF NOT IS_CHAR_DEAD	cuban_dude04
								ATTACH_CHAR_TO_CAR cuban_dude05 cuban_jetmax 0.2534 -0.2957 1.4395 FACING_BACK 360.0 WEAPONTYPE_RUGER
								REMOVE_BLIP	cuban_dude05_blip
								cuban_dude05_flag = 100
							ELSE
								REMOVE_BLIP	cuban_dude05_blip
								DELETE_CHAR	cuban_dude05
								CREATE_CHAR_INSIDE_CAR cuban_jetmax PEDTYPE_CIVMALE CBA cuban_dude05
								cuban_dude05_flag = 4//IN CUBAN_JETMAX AS DRIVER
							ENDIF
						ENDIF
					ELSE
						cuban_dude05_flag = 100
					ENDIF
				ELSE
					cuban_dude05_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude05_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude05 rc_plane
				ENDIF
			ENDIF
		ELSE
			SET_CHAR_WAIT_STATE cuban_dude05 WAITSTATE_CROSS_ROAD_LOOK 100
		ENDIF
	ELSE
		IF NOT cuban_dude05_flag = -10
			REMOVE_BLIP cuban_dude05_blip
			DETACH_CHAR_FROM_CAR cuban_dude05
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude05_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF
	
	//cuban_dude06//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude06
		IF player_attacking_flag = 1
			IF cuban_dude06_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					GIVE_WEAPON_TO_CHAR cuban_dude06 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude06 rc_plane
					cuban_dude06_timer = game_timer	+ 1800
					cuban_dude06_flag = 1
				ELSE
					cuban_dude06_timer = game_timer	- 100
					cuban_dude06_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude06_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude06 rc_plane
				ENDIF
				IF game_timer > cuban_dude06_timer
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_NO_OBJ cuban_dude06
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude06 -521.9704 -240.8421
						cuban_dude06_flag = 2
					ELSE
						cuban_dude06_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude06_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude06 -521.9704 -240.8421 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude06 -522.0861 -235.0635
						cuban_dude06_flag = 3
					ELSE
						cuban_dude06_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude06_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude06 -522.0861 -235.0635 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude06 -517.2231 -232.8405
						cuban_dude06_flag = 4
					ELSE
						cuban_dude06_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude06_flag = 4
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude06 -517.2231 -232.8405 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude06 -515.7076 -230.4083
						cuban_dude06_timer = game_timer	+ 700
						cuban_dude06_flag = 5
					ELSE
						cuban_dude06_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude06_flag = 5
				IF NOT IS_CAR_DEAD cuban_coastg
					IF IS_CAR_HEALTH_GREATER cuban_coastg 250
						IF game_timer >	cuban_dude06_timer
							REMOVE_BLIP	cuban_dude06_blip
							DELETE_CHAR	cuban_dude06
							CREATE_CHAR_INSIDE_CAR cuban_coastg PEDTYPE_CIVMALE CBA cuban_dude06
							cuban_dude06_flag = 6//IN CUBAN_COASTG AS DRIVER
						ENDIF
					ELSE
						cuban_dude06_flag = 100
					ENDIF
				ELSE
					cuban_dude06_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude06_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude06 rc_plane
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT cuban_dude06_flag = -10
			REMOVE_BLIP cuban_dude06_blip
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude06_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_dude07//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude07
		IF player_attacking_flag = 1
			IF cuban_dude07_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_WAIT_STATE cuban_dude07 WAITSTATE_FALSE 17
					GIVE_WEAPON_TO_CHAR cuban_dude07 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude07 rc_plane
					cuban_dude07_timer = game_timer	+ 4100
					cuban_dude07_flag = 1
				ELSE
					cuban_dude07_timer = game_timer	- 100
					cuban_dude07_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude07_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude07 rc_plane
				ENDIF
				IF game_timer > cuban_dude07_timer
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_NO_OBJ cuban_dude07
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude07 -512.1264 -237.3874
						cuban_dude07_flag = 2
					ELSE
						cuban_dude07_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude07_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude07 -512.1264 -237.3874 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude07 -512.0654 -232.8520
						cuban_dude07_flag = 3
					ELSE
						cuban_dude07_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude07_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude07 -512.0654 -232.8520 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude07 -513.3506 -230.3167
						cuban_dude07_timer = game_timer	+ 700
						cuban_dude07_flag = 4
					ELSE
						cuban_dude07_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude07_flag = 4
				IF NOT IS_CAR_DEAD cuban_coastg
					IF IS_CAR_HEALTH_GREATER cuban_coastg 250
						IF game_timer >	cuban_dude07_timer
							IF NOT IS_CHAR_DEAD	cuban_dude06
								ATTACH_CHAR_TO_CAR cuban_dude07 cuban_coastg -0.1968 2.0053 0.8746 FACING_BACK 360.0 WEAPONTYPE_RUGER
								REMOVE_BLIP	cuban_dude07_blip
								cuban_dude07_flag = 100
							ELSE
								REMOVE_BLIP	cuban_dude07_blip
								DELETE_CHAR	cuban_dude07
								CREATE_CHAR_INSIDE_CAR cuban_coastg PEDTYPE_CIVMALE CBB cuban_dude07
								cuban_dude07_flag = 5//IN CUBAN_COASTG AS DRIVER
							ENDIF
						ENDIF
					ELSE
						cuban_dude07_flag = 100
					ENDIF
				ELSE
					cuban_dude07_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude07_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude07 rc_plane
				ENDIF
			ENDIF
		ELSE
			SET_CHAR_WAIT_STATE cuban_dude07 WAITSTATE_USE_ATM 100
		ENDIF
	ELSE
		IF NOT cuban_dude07_flag = -10
			REMOVE_BLIP cuban_dude07_blip
			DETACH_CHAR_FROM_CAR cuban_dude07
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude07_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_dude08//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude08
		IF player_attacking_flag = 1
			IF cuban_dude08_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_WAIT_STATE cuban_dude08 WAITSTATE_FALSE 17
					GIVE_WEAPON_TO_CHAR cuban_dude08 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude08 rc_plane
					cuban_dude08_timer = game_timer	+ 3400
					cuban_dude08_flag = 1
				ELSE
					cuban_dude08_timer = game_timer	- 100
					cuban_dude08_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude08_flag = 1
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude08 rc_plane
				ENDIF
				IF game_timer > cuban_dude08_timer
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_NO_OBJ cuban_dude08
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude08 -521.9704 -240.8421
						cuban_dude08_flag = 2
					ELSE
						cuban_dude08_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude08_flag = 2
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude08 -521.9704 -240.8421 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude08 -522.0861 -235.0635
						cuban_dude08_flag = 3
					ELSE
						cuban_dude08_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude08_flag = 3
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude08 -522.0861 -235.0635 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude08 -517.2231 -232.8405
						cuban_dude08_flag = 4
					ELSE
						cuban_dude08_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude08_flag = 4
				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude08 -517.2231 -232.8405 1.0 1.0 0
					IF NOT IS_CAR_DEAD cuban_coastg
						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude08 -515.7076 -230.4083
						cuban_dude08_timer = game_timer	+ 700
						cuban_dude08_flag = 5
					ELSE
						cuban_dude08_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude08_flag = 5
				IF NOT IS_CAR_DEAD cuban_coastg
					IF IS_CAR_HEALTH_GREATER cuban_coastg 250
						IF game_timer >	cuban_dude08_timer
							IF NOT IS_CHAR_DEAD	cuban_dude06
							OR NOT IS_CHAR_DEAD	cuban_dude07
								ATTACH_CHAR_TO_CAR cuban_dude08 cuban_coastg 0.0444 -1.8993 1.0885 FACING_BACK 360.0 WEAPONTYPE_RUGER
								REMOVE_BLIP	cuban_dude08_blip
								cuban_dude08_flag = 100
							ELSE
								REMOVE_BLIP	cuban_dude08_blip
								DELETE_CHAR	cuban_dude08
								CREATE_CHAR_INSIDE_CAR cuban_coastg PEDTYPE_CIVMALE CBB cuban_dude08
								cuban_dude08_flag = 6//IN CUBAN_COASTG AS DRIVER
							ENDIF
						ENDIF
					ELSE
						cuban_dude08_flag = 100
					ENDIF
				ELSE
					cuban_dude08_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude08_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude08 rc_plane
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT cuban_dude08_flag = -10
			REMOVE_BLIP cuban_dude08_blip
			DETACH_CHAR_FROM_CAR cuban_dude08
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude08_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_dude09//////////////////
	////////////////////////////////
//	IF NOT IS_CHAR_DEAD	cuban_dude09
//		IF player_attacking_flag = 1
//			IF cuban_dude09_flag = 0
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_CROUCH cuban_dude09 FALSE 17
//					SET_CHAR_WAIT_STATE cuban_dude09 WAITSTATE_FALSE 17
//					//GIVE_WEAPON_TO_CHAR cuban_dude09 WEAPONTYPE_RUGER 9999
//					//SET_CHAR_OBJ_DESTROY_CAR cuban_dude09 rc_plane
//					cuban_dude09_timer = game_timer	+ 3800
//					cuban_dude09_flag = 1
//				ELSE
//					cuban_dude09_timer = game_timer	- 100
//					cuban_dude09_flag = 1
//				ENDIF
//			ENDIF
//			IF cuban_dude09_flag = 1
//				IF NOT IS_CAR_DEAD rc_plane
//					//SET_CHAR_OBJ_DESTROY_CAR cuban_dude09 rc_plane
//				ENDIF
//				IF game_timer > cuban_dude09_timer
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_NO_OBJ cuban_dude09
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude09 -504.4402 -245.8328
//						cuban_dude09_flag = 2
//					ELSE
//						cuban_dude09_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude09_flag = 2
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude09 -504.4402 -245.8328 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude09 -522.0377 -241.1093
//						cuban_dude09_flag = 3
//					ELSE
//						cuban_dude09_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude09_flag = 3
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude09 -522.0377 -241.1093 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude09 -522.0453 -235.2250
//						cuban_dude09_flag = 4
//					ELSE
//						cuban_dude09_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude09_flag = 4
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude09 -522.0453 -235.2250 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude09 -516.0430 -234.6717
//						cuban_dude09_flag = 5
//					ELSE
//						cuban_dude09_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude09_flag = 5
//				IF NOT IS_CAR_DEAD dinghy1
//					IF IS_CAR_HEALTH_GREATER dinghy1 250
//						IF LOCATE_CHAR_ON_FOOT_2D cuban_dude09 -516.0430 -234.6717 1.0 1.0 0
//							REMOVE_BLIP	cuban_dude09_blip
//							DELETE_CHAR	cuban_dude09
//							CREATE_CHAR_INSIDE_CAR dinghy1 PEDTYPE_CIVMALE CBA cuban_dude09
//							cuban_dude09_flag = 6//IN DINGHY1 AS DRIVER
//						ENDIF
//					ELSE
//						cuban_dude09_flag = 100
//					ENDIF
//				ELSE
//					cuban_dude09_flag = 100
//				ENDIF
//			ENDIF
//			IF cuban_dude09_flag = 100
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude09 rc_plane
//				ENDIF
//			ENDIF
//		ELSE
//			SET_CHAR_CROUCH cuban_dude09 TRUE 100
//		ENDIF
//	ELSE
//		IF NOT cuban_dude09_flag = -10
//			REMOVE_BLIP cuban_dude09_blip
//			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
//			cuban_dude09_flag = -10
//		ENDIF
//		++ dead_cubans
//	ENDIF

	//cuban_dude10//////////////////
	////////////////////////////////
//	IF NOT IS_CHAR_DEAD	cuban_dude10
//		IF player_attacking_flag = 1
//			IF cuban_dude10_flag = 0
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_WAIT_STATE cuban_dude10 WAITSTATE_FALSE 17
//					GIVE_WEAPON_TO_CHAR cuban_dude10 WEAPONTYPE_RUGER 9999
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude10 rc_plane
//					cuban_dude10_timer = game_timer	+ 4100
//					cuban_dude10_flag = 1
//				ELSE
//					cuban_dude10_timer = game_timer	- 100
//					cuban_dude10_flag = 1
//				ENDIF
//			ENDIF
//			IF cuban_dude10_flag = 1
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude10 rc_plane
//				ENDIF
//				IF game_timer > cuban_dude10_timer
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_NO_OBJ cuban_dude10
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude10 -503.2128 -245.7957
//						cuban_dude10_flag = 2
//					ELSE
//						cuban_dude10_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude10_flag = 2
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude10 -503.2128 -245.7957 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude10 -522.0377 -241.1093
//						cuban_dude10_flag = 3
//					ELSE
//						cuban_dude10_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude10_flag = 3
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude10 -522.0377 -241.1093 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude10 -522.0453 -235.2250
//						cuban_dude10_flag = 4
//					ELSE
//						cuban_dude10_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude10_flag = 4
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude10 -522.0453 -235.2250 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy1
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude10 -516.0430 -234.6717
//						cuban_dude10_flag = 5
//					ELSE
//						cuban_dude10_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude10_flag = 5
//				IF NOT IS_CAR_DEAD dinghy1
//					IF IS_CAR_HEALTH_GREATER dinghy1 250
//						IF LOCATE_CHAR_ON_FOOT_2D cuban_dude10 -516.0430 -234.6717 1.0 1.0 0
//							IF NOT IS_CHAR_DEAD	cuban_dude09
//								ATTACH_CHAR_TO_CAR cuban_dude10 dinghy1 0.0742 -0.8961 1.0623 FACING_BACK 360.0 WEAPONTYPE_RUGER
//								REMOVE_BLIP	cuban_dude10_blip
//								cuban_dude10_flag = 100
//							ELSE
//								REMOVE_BLIP	cuban_dude10_blip
//								DELETE_CHAR	cuban_dude10
//								CREATE_CHAR_INSIDE_CAR dinghy1 PEDTYPE_CIVMALE CBA cuban_dude10
//								cuban_dude10_flag = 6//IN DINGHY1 AS DRIVER
//							ENDIF
//						ENDIF
//					ELSE
//						cuban_dude10_flag = 100
//					ENDIF
//				ELSE
//					cuban_dude10_flag = 100
//				ENDIF
//			ENDIF
//			IF cuban_dude10_flag = 100
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude10 rc_plane
//				ENDIF
//			ENDIF
//		ENDIF
//	ELSE
//		IF NOT cuban_dude10_flag = -10
//			REMOVE_BLIP cuban_dude10_blip
//			DETACH_CHAR_FROM_CAR cuban_dude10
//			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
//			cuban_dude10_flag = -10
//		ENDIF
//		++ dead_cubans
//	ENDIF

	//cuban_dude11//////////////////
	////////////////////////////////
//	IF NOT IS_CHAR_DEAD	cuban_dude11
//		IF player_attacking_flag = 1
//			IF cuban_dude11_flag = 0
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_WAIT_STATE cuban_dude11 WAITSTATE_FALSE 17
//					//GIVE_WEAPON_TO_CHAR cuban_dude11 WEAPONTYPE_RUGER 9999
//					//SET_CHAR_OBJ_DESTROY_CAR cuban_dude11 rc_plane
//					cuban_dude11_timer = game_timer	+ 4500
//					cuban_dude11_flag = 1
//				ELSE
//					cuban_dude11_timer = game_timer	- 100
//					cuban_dude11_flag = 1
//				ENDIF
//			ENDIF
//			IF cuban_dude11_flag = 1
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude11 rc_plane
//				ENDIF
//				IF game_timer > cuban_dude11_timer
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_NO_OBJ cuban_dude11
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude11 -504.4402 -245.8328
//						cuban_dude11_flag = 2
//					ELSE
//						cuban_dude11_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude11_flag = 2
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude11 -504.4402 -245.8328 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude11 -522.0377 -241.1093
//						cuban_dude11_flag = 3
//					ELSE
//						cuban_dude11_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude11_flag = 3
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude11 -522.0377 -241.1093 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude11 -522.0453 -235.2250
//						cuban_dude11_flag = 4
//					ELSE
//						cuban_dude11_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude11_flag = 4
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude11 -522.0453 -235.2250 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude11 -511.2752 -234.5884
//						cuban_dude11_flag = 5
//					ELSE
//						cuban_dude11_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude11_flag = 5
//				IF NOT IS_CAR_DEAD dinghy2
//					IF IS_CAR_HEALTH_GREATER dinghy2 250
//						IF LOCATE_CHAR_ON_FOOT_2D cuban_dude11 -511.2752 -234.5884 1.0 1.0 0
//							REMOVE_BLIP	cuban_dude11_blip
//							DELETE_CHAR	cuban_dude11
//							CREATE_CHAR_INSIDE_CAR dinghy2 PEDTYPE_CIVMALE CBB cuban_dude11
//							cuban_dude11_flag = 6//IN DINGHY2 AS DRIVER
//						ENDIF
//					ELSE
//						cuban_dude11_flag = 100
//					ENDIF
//				ELSE
//					cuban_dude11_flag = 100
//				ENDIF
//			ENDIF
//			IF cuban_dude11_flag = 100
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude11 rc_plane
//				ENDIF
//			ENDIF
//		ELSE
//			SET_CHAR_WAIT_STATE cuban_dude11 WAITSTATE_PLAYANIM_CHAT 100
//		ENDIF
//	ELSE
//		IF NOT cuban_dude11_flag = -10
//			REMOVE_BLIP cuban_dude11_blip
//			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
//			cuban_dude11_flag = -10
//		ENDIF
//		++ dead_cubans
//	ENDIF

	//cuban_dude12//////////////////
	////////////////////////////////
//	IF NOT IS_CHAR_DEAD	cuban_dude12
//		IF player_attacking_flag = 1
//			IF cuban_dude12_flag = 0
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_WAIT_STATE cuban_dude12 WAITSTATE_FALSE 17
//					GIVE_WEAPON_TO_CHAR cuban_dude12 WEAPONTYPE_RUGER 9999
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude12 rc_plane
//					cuban_dude12_timer = game_timer	+ 4800
//					cuban_dude12_flag = 1
//				ELSE
//					cuban_dude12_timer = game_timer	- 100
//					cuban_dude12_flag = 1
//				ENDIF
//			ENDIF
//			IF cuban_dude12_flag = 1
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude12 rc_plane
//				ENDIF
//				IF game_timer > cuban_dude12_timer
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_NO_OBJ cuban_dude12
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude12 -503.2128 -245.7957
//						cuban_dude12_flag = 2
//					ELSE
//						cuban_dude12_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude12_flag = 2
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude12 -503.2128 -245.7957 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude12 -522.0377 -241.1093
//						cuban_dude12_flag = 3
//					ELSE
//						cuban_dude12_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude12_flag = 3
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude12 -522.0377 -241.1093 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude12 -522.0453 -235.2250
//						cuban_dude12_flag = 4
//					ELSE
//						cuban_dude12_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude12_flag = 4
//				IF LOCATE_CHAR_ON_FOOT_2D cuban_dude12 -522.0453 -235.2250 1.0 1.0 0
//					IF NOT IS_CAR_DEAD dinghy2
//						SET_CHAR_OBJ_RUN_TO_COORD cuban_dude12 -511.2752 -234.5884
//						cuban_dude12_flag = 5
//					ELSE
//						cuban_dude12_flag = 100
//					ENDIF
//				ENDIF
//			ENDIF
//			IF cuban_dude12_flag = 5
//				IF NOT IS_CAR_DEAD dinghy2
//					IF IS_CAR_HEALTH_GREATER dinghy2 250
//						IF LOCATE_CHAR_ON_FOOT_2D cuban_dude12 -511.2752 -234.5884 1.0 1.0 0
//							IF NOT IS_CHAR_DEAD	cuban_dude11
//								ATTACH_CHAR_TO_CAR cuban_dude12 dinghy2 0.0742 -0.8961 1.0623 FACING_BACK 360.0 WEAPONTYPE_RUGER
//								REMOVE_BLIP	cuban_dude12_blip
//								cuban_dude12_flag = 100
//							ELSE
//								REMOVE_BLIP	cuban_dude12_blip
//								DELETE_CHAR	cuban_dude12
//								CREATE_CHAR_INSIDE_CAR dinghy2 PEDTYPE_CIVMALE CBA cuban_dude12
//								cuban_dude12_flag = 6//IN DINGHY2 AS DRIVER
//							ENDIF
//						ENDIF
//					ELSE
//						cuban_dude12_flag = 100
//					ENDIF
//				ELSE
//					cuban_dude12_flag = 100
//				ENDIF
//			ENDIF
//			IF cuban_dude12_flag = 100
//				IF NOT IS_CAR_DEAD rc_plane
//					SET_CHAR_OBJ_DESTROY_CAR cuban_dude12 rc_plane
//				ENDIF
//			ENDIF
//		ENDIF
//	ELSE
//		IF NOT cuban_dude12_flag = -10
//			REMOVE_BLIP cuban_dude12_blip
//			DETACH_CHAR_FROM_CAR cuban_dude12
//			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
//			cuban_dude12_flag = -10
//		ENDIF
//		++ dead_cubans
//	ENDIF

	//cuban_dude13//////////////////
	////////////////////////////////
	IF NOT IS_CHAR_DEAD	cuban_dude13
		IF player_attacking_flag = 1
			IF cuban_dude13_flag = 0
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_WAIT_STATE cuban_dude13 WAITSTATE_FALSE 17
					GIVE_WEAPON_TO_CHAR cuban_dude13 WEAPONTYPE_RUGER 9999
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude13 rc_plane
					cuban_dude13_timer = game_timer	+ 7000
					cuban_dude13_flag = 1
				ELSE
					cuban_dude13_timer = game_timer	- 100
					cuban_dude13_flag = 1
				ENDIF
			ENDIF
			IF cuban_dude13_flag = 2
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude13 rc_plane
				ENDIF
				IF game_timer > cuban_dude13_timer
					IF NOT IS_CAR_DEAD cubangang_car
						IF IS_CAR_HEALTH_GREATER cubangang_car 250
							SET_CHAR_OBJ_NO_OBJ cuban_dude13
							CHANGE_BLIP_DISPLAY cuban_dude13_blip BOTH
							CHANGE_BLIP_SCALE cuban_dude01_blip 3
							PRINT_NOW HAT2_B7 6000 1 //"One of the Cubans in escaping in a car!"
							SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER cuban_dude13 cubangang_car
							cuban_dude13_flag = 3
						ELSE
							cuban_dude13_flag = 100
						ENDIF
					ELSE
						cuban_dude13_flag = 100
					ENDIF
				ENDIF
			ENDIF
			IF cuban_dude13_flag = 3
				IF NOT IS_CAR_DEAD cubangang_car
					IF IS_CAR_HEALTH_GREATER cubangang_car 250
						IF IS_CHAR_IN_CAR cuban_dude13 cubangang_car
							cuban_dude13_flag = 4//IN CUBANGANG_CAR AS DRIVER
						ENDIF
					ELSE
						cuban_dude13_flag = 100
					ENDIF
				ELSE
					cuban_dude13_flag = 100
				ENDIF
			ENDIF
			IF cuban_dude13_flag = 100
				IF NOT IS_CAR_DEAD rc_plane
					SET_CHAR_OBJ_DESTROY_CAR cuban_dude13 rc_plane
				ENDIF
			ENDIF
		ENDIF
	ELSE
		IF NOT cuban_dude13_flag = -10
			REMOVE_BLIP cuban_dude13_blip
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			cuban_dude13_flag = -10
		ENDIF
		++ dead_cubans
	ENDIF

	//cuban_jetmax//////////////////
	////////////////////////////////
	IF NOT IS_CAR_DEAD cuban_jetmax
		IF cuban_jetmax_flag = 0
			IF cuban_dude04_flag = 4//IN CUBAN_JETMAX AS DRIVER
			OR IS_CHAR_DEAD	cuban_dude04
				IF cuban_dude05_flag = 4//IN CUBAN_JETMAX AS DRIVER
				OR cuban_dude05_flag = 100
				OR IS_CHAR_DEAD	cuban_dude05
					IF cuban_dude04_flag = 4//IN CUBAN_JETMAX AS DRIVER
					OR cuban_dude05_flag = 4//IN CUBAN_JETMAX AS DRIVER
						cuban_jetmax_flag = 1
						PRINT_NOW HAT2_B5 5000 1//"~g~The Cubans are making a run for it. Don't let them get away!"
						REMOVE_BLIP cuban_jetmax_blip
						ADD_BLIP_FOR_CAR cuban_jetmax cuban_jetmax_blip
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF cuban_jetmax_flag = 1
			gosub_boat = cuban_jetmax
			GOSUB boat_routes_gosub
		ENDIF
	ELSE
		REMOVE_BLIP cuban_jetmax_blip
		++ dead_cubans
	ENDIF
	
	//cuban_speeder//////////////////
	////////////////////////////////
	IF NOT IS_CAR_DEAD cuban_speeder
		IF cuban_speeder_flag = 0
			IF cuban_dude01_flag = 3//IN CUBAN_SPEEDER AS DRIVER
			OR IS_CHAR_DEAD	cuban_dude01
				IF cuban_dude02_flag = 5//IN CUBAN_SPEEDER AS DRIVER
				OR cuban_dude02_flag = 100
				OR IS_CHAR_DEAD	cuban_dude02
					IF cuban_dude03_flag = 4//IN CUBAN_SPEEDER AS DRIVER
					OR cuban_dude03_flag = 100
					OR IS_CHAR_DEAD	cuban_dude03
						IF cuban_dude01_flag = 3//IN CUBAN_SPEEDER AS DRIVER
						OR cuban_dude02_flag = 5//IN CUBAN_SPEEDER AS DRIVER
						OR cuban_dude03_flag = 4//IN CUBAN_SPEEDER AS DRIVER
							cuban_speeder_flag = 1
							PRINT_NOW HAT2_B5 5000 1//"~g~The Cubans are making a run for it. Don't let them get away!"
							REMOVE_BLIP cuban_speeder_blip
							ADD_BLIP_FOR_CAR cuban_speeder cuban_speeder_blip
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF cuban_speeder_flag = 1
			IF cuban_jetmax_flag > 0
			OR IS_CAR_DEAD cuban_jetmax
				IF NOT IS_CAR_DEAD cuban_jetmax
					GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_jetmax -10.879 -15.176 0.0 x y z
					IF LOCATE_CAR_3D cuban_speeder x y 6.0 5.0 5.0 5.0 0
						SET_BOAT_CRUISE_SPEED cuban_speeder 2.0
						GET_CAR_HEADING cuban_jetmax cuban_jetmax_heading
						GET_CAR_HEADING cuban_speeder cuban_speeder_heading
						heading_diff = cuban_jetmax_heading - cuban_speeder_heading
						IF heading_diff < -180.0
							heading_diff += 360.0
						ENDIF
						IF heading_diff > 180.0
							heading_diff -= 360.0
						ENDIF
						IF heading_diff < 0.0
							cuban_speeder_heading +=@ 1.0
						ELSE
							cuban_speeder_heading -=@ 1.0
						ENDIF
						IF heading_diff > 5.0
						AND heading_diff < -5.0
							SET_CAR_HEADING cuban_speeder cuban_speeder_heading
						ENDIF
					ELSE
						IF LOCATE_CAR_2D cuban_speeder x y 10.0 10.0 0
							SET_BOAT_CRUISE_SPEED cuban_speeder 12.0
							GET_CAR_HEADING cuban_jetmax cuban_jetmax_heading
							GET_CAR_HEADING cuban_speeder cuban_speeder_heading
							heading_diff = cuban_jetmax_heading - cuban_speeder_heading
							IF heading_diff < -180.0
								heading_diff += 360.0
							ENDIF
							IF heading_diff > 180.0
								heading_diff -= 360.0
							ENDIF
							IF heading_diff < 0.0
								cuban_speeder_heading +=@ 1.0
							ELSE
								cuban_speeder_heading -=@ 1.0
							ENDIF
							IF heading_diff > 5.0
							AND heading_diff < -5.0
								SET_CAR_HEADING cuban_speeder cuban_speeder_heading
							ENDIF
						ELSE
							SET_BOAT_CRUISE_SPEED cuban_speeder 20.0
						ENDIF
					ENDIF
					BOAT_GOTO_COORDS cuban_speeder x y 6.0
				ELSE
					IF NOT boat_route_counter = 0
						-- boat_route_counter
						new_boat_using_gosub = 1
					ENDIF
					SET_BOAT_CRUISE_SPEED cuban_speeder 12.0
					cuban_speeder_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF cuban_speeder_flag = 2
			gosub_boat = cuban_speeder
			GOSUB boat_routes_gosub
		ENDIF
	ELSE
		REMOVE_BLIP cuban_speeder_blip
		++ dead_cubans
	ENDIF
	
	//cuban_coastg//////////////////
	////////////////////////////////
	IF NOT IS_CAR_DEAD cuban_coastg
		IF cuban_coastg_flag = 0
			IF cuban_dude06_flag = 6//IN CUBAN_COASTG AS DRIVER
			OR IS_CHAR_DEAD	cuban_dude06
				IF cuban_dude07_flag = 7//IN CUBAN_COASTG AS DRIVER
				OR cuban_dude07_flag = 100
				OR IS_CHAR_DEAD	cuban_dude07
					IF cuban_dude08_flag = 6//IN CUBAN_COASTG AS DRIVER
					OR cuban_dude08_flag = 100
					OR IS_CHAR_DEAD	cuban_dude08
						IF cuban_dude06_flag = 6//IN CUBAN_COASTG AS DRIVER
						OR cuban_dude07_flag = 7//IN CUBAN_COASTG AS DRIVER
						OR cuban_dude08_flag = 6//IN CUBAN_COASTG AS DRIVER
							cuban_coastg_flag = 1
							PRINT_NOW HAT2_B5 5000 1//"~g~The Cubans are making a run for it. Don't let them get away!"
							REMOVE_BLIP cuban_coastg_blip
							ADD_BLIP_FOR_CAR cuban_coastg cuban_coastg_blip
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF cuban_coastg_flag = 1
			IF NOT IS_CAR_DEAD cuban_jetmax
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_jetmax 11.702 -13.377 0.0 x y z
				IF LOCATE_CAR_3D cuban_coastg x y 6.0 5.0 5.0 5.0 0
					SET_BOAT_CRUISE_SPEED cuban_coastg 2.0
					GET_CAR_HEADING cuban_jetmax cuban_jetmax_heading
					GET_CAR_HEADING cuban_coastg cuban_coastg_heading
					heading_diff = cuban_jetmax_heading - cuban_coastg_heading
					IF heading_diff < -180.0
						heading_diff += 360.0
					ENDIF
					IF heading_diff > 180.0
						heading_diff -= 360.0
					ENDIF
					IF heading_diff < 0.0
						cuban_coastg_heading +=@ 1.0
					ELSE
						cuban_coastg_heading -=@ 1.0
					ENDIF
					IF heading_diff > 5.0
					AND heading_diff < -5.0
						SET_CAR_HEADING cuban_coastg cuban_coastg_heading
					ENDIF
				ELSE
					IF LOCATE_CAR_2D cuban_coastg x y 10.0 10.0 0
						GET_CAR_HEADING cuban_jetmax cuban_jetmax_heading
						GET_CAR_HEADING cuban_coastg cuban_coastg_heading
						heading_diff = cuban_jetmax_heading - cuban_coastg_heading
						IF heading_diff < -180.0
							heading_diff += 360.0
						ENDIF
						IF heading_diff > 180.0
							heading_diff -= 360.0
						ENDIF
						IF heading_diff < 0.0
							cuban_coastg_heading +=@ 1.0
						ELSE
							cuban_coastg_heading -=@ 1.0
						ENDIF
						IF heading_diff > 5.0
						AND heading_diff < -5.0
							SET_CAR_HEADING cuban_coastg cuban_coastg_heading
						ENDIF
						SET_BOAT_CRUISE_SPEED cuban_coastg 12.0
					ELSE
						SET_BOAT_CRUISE_SPEED cuban_coastg 20.0
					ENDIF
				ENDIF
				BOAT_GOTO_COORDS cuban_coastg x y 6.0
			ELSE
				IF NOT IS_CAR_DEAD cuban_speeder
					GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_speeder 11.702 -13.377 0.0 x y z
					IF LOCATE_CAR_2D cuban_coastg x y 4.0 4.0 0
						GET_CAR_HEADING cuban_speeder cuban_speeder_heading
						GET_CAR_HEADING cuban_coastg cuban_coastg_heading
						heading_diff = cuban_speeder_heading - cuban_coastg_heading
						IF heading_diff < -180.0
							heading_diff += 360.0
						ENDIF
						IF heading_diff > 180.0
							heading_diff -= 360.0
						ENDIF
						IF heading_diff < 0.0
							cuban_coastg_heading +=@ 1.0
						ELSE
							cuban_coastg_heading -=@ 1.0
						ENDIF
						IF heading_diff > 5.0
						AND heading_diff < -5.0
							SET_CAR_HEADING cuban_coastg cuban_coastg_heading
						ENDIF
						SET_BOAT_CRUISE_SPEED cuban_coastg 2.0
					ELSE
						IF LOCATE_CAR_2D cuban_coastg x y 10.0 10.0 0
							GET_CAR_HEADING cuban_speeder cuban_speeder_heading
							GET_CAR_HEADING cuban_coastg cuban_coastg_heading
							heading_diff = cuban_speeder_heading - cuban_coastg_heading
							IF heading_diff < -180.0
								heading_diff += 360.0
							ENDIF
							IF heading_diff > 180.0
								heading_diff -= 360.0
							ENDIF
							IF heading_diff < 0.0
								cuban_coastg_heading +=@ 1.0
							ELSE
								cuban_coastg_heading -=@ 1.0
							ENDIF
							IF heading_diff > 5.0
							AND heading_diff < -5.0
								SET_CAR_HEADING cuban_coastg cuban_coastg_heading
							ENDIF
							SET_BOAT_CRUISE_SPEED cuban_coastg 12.0
						ELSE
							SET_BOAT_CRUISE_SPEED cuban_coastg 20.0
						ENDIF
					ENDIF
					BOAT_GOTO_COORDS cuban_coastg x y 6.0
				ELSE
					IF NOT boat_route_counter = 0
						-- boat_route_counter
						new_boat_using_gosub = 1
					ENDIF
					SET_BOAT_CRUISE_SPEED cuban_coastg 12.0
					cuban_coastg_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF cuban_coastg_flag = 2
			gosub_boat = cuban_coastg
			GOSUB boat_routes_gosub
		ENDIF
	ELSE
		REMOVE_BLIP cuban_coastg_blip
		++ dead_cubans
	ENDIF

	//dinghy1///////////////////////
	////////////////////////////////
//	IF NOT IS_CAR_DEAD dinghy1
//		IF dinghy1_flag = 0
//			IF cuban_dude09_flag = 6//IN DINGHY1 AS DRIVER
//			OR IS_CHAR_DEAD	cuban_dude09
//				IF cuban_dude10_flag = 6//IN DINGHY1 AS DRIVER
//				OR cuban_dude10_flag = 100
//				OR IS_CHAR_DEAD	cuban_dude10
//					IF cuban_dude09_flag = 6//IN DINGHY1 AS DRIVER
//					OR cuban_dude10_flag = 6//IN DINGHY1 AS DRIVER
//						dinghy1_flag = 1
//						GET_CAR_COORDINATES	dinghy1 x y z
//						z += 0.5
//						SET_CAR_COORDINATES	dinghy1	x y z
//						ADD_BLIP_FOR_CAR dinghy1 dinghy1_blip
//						SET_CAR_HEADING dinghy1 0.0
//						SET_CAR_FORWARD_SPEED dinghy1 12.0
//					ENDIF
//				ENDIF
//			ENDIF
//		ENDIF
//		IF dinghy1_flag = 1
//			IF NOT IS_CAR_DEAD cuban_jetmax
//				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_jetmax 0.0 -27.077 0.0 x y z
//				IF LOCATE_CAR_3D dinghy1 x y 6.0 4.0 4.0 4.0 0
//					SET_BOAT_CRUISE_SPEED dinghy1 2.0
//				ELSE
//					IF LOCATE_CAR_2D dinghy1 x y 10.0 10.0 0
//						SET_BOAT_CRUISE_SPEED dinghy1 12.0
//					ELSE
//						SET_BOAT_CRUISE_SPEED dinghy1 20.0
//					ENDIF
//				ENDIF
//				BOAT_GOTO_COORDS dinghy1 x y 6.0
//			ELSE
//				IF NOT IS_CAR_DEAD cuban_speeder
//					GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_speeder 0.0 -27.077 0.0 x y z
//					IF LOCATE_CAR_2D dinghy1 x y 4.0 4.0 0
//						SET_BOAT_CRUISE_SPEED dinghy1 2.0
//					ELSE
//						IF LOCATE_CAR_2D dinghy1 x y 10.0 10.0 0
//							SET_BOAT_CRUISE_SPEED dinghy1 12.0
//						ELSE
//							SET_BOAT_CRUISE_SPEED dinghy1 20.0
//						ENDIF
//					ENDIF
//					BOAT_GOTO_COORDS dinghy1 x y 6.0
//				ELSE
//					IF NOT IS_CAR_DEAD cuban_coastg
//						GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_coastg 0.0 -27.077 0.0 x y z
//						IF LOCATE_CAR_2D dinghy1 x y 4.0 4.0 0
//							SET_BOAT_CRUISE_SPEED dinghy1 2.0
//						ELSE
//							IF LOCATE_CAR_2D dinghy1 x y 10.0 10.0 0
//								SET_BOAT_CRUISE_SPEED dinghy1 12.0
//							ELSE
//								SET_BOAT_CRUISE_SPEED dinghy1 20.0
//							ENDIF
//						ENDIF
//						BOAT_GOTO_COORDS dinghy1 x y 6.0
//					ELSE
//						IF NOT boat_route_counter = 0
//							-- boat_route_counter
//							new_boat_using_gosub = 1
//						ENDIF
//						SET_BOAT_CRUISE_SPEED dinghy1 12.0
//						dinghy1_flag = 2
//					ENDIF
//				ENDIF
//			ENDIF
//		ENDIF
//		IF dinghy1_flag = 2
//			gosub_boat = dinghy1
//			GOSUB boat_routes_gosub
//		ENDIF
//	ELSE
//		REMOVE_BLIP dinghy1_blip
//		++ dead_cubans
//	ENDIF

	//dinghy2///////////////////////
	////////////////////////////////
//	IF NOT IS_CAR_DEAD dinghy2
//		IF dinghy2_flag = 0
//			IF cuban_dude11_flag = 6//IN DINGHY2 AS DRIVER
//			OR IS_CHAR_DEAD	cuban_dude11
//				IF cuban_dude12_flag = 6//IN DINGHY2 AS DRIVER
//				OR cuban_dude12_flag = 100
//				OR IS_CHAR_DEAD	cuban_dude12
//					IF cuban_dude11_flag = 6//IN DINGHY2 AS DRIVER
//					OR cuban_dude12_flag = 6//IN DINGHY2 AS DRIVER
//						dinghy2_flag = 1
//						GET_CAR_COORDINATES	dinghy2 x y z
//						z += 0.5
//						SET_CAR_COORDINATES	dinghy2	x y z
//						ADD_BLIP_FOR_CAR dinghy2 dinghy2_blip
//						SET_CAR_HEADING dinghy2 0.0
//						SET_CAR_FORWARD_SPEED dinghy2 12.0
//					ENDIF
//				ENDIF
//			ENDIF
//		ENDIF
//		IF dinghy2_flag = 1
//			IF NOT IS_CAR_DEAD cuban_jetmax
//				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_jetmax 8.794 -27.06 0.0 x y z
//				IF LOCATE_CAR_3D dinghy2 x y 6.0 4.0 4.0 4.0 0
//					SET_BOAT_CRUISE_SPEED dinghy2 2.0
//				ELSE
//					IF LOCATE_CAR_2D dinghy2 x y 10.0 10.0 0
//						SET_BOAT_CRUISE_SPEED dinghy2 12.0
//					ELSE
//						SET_BOAT_CRUISE_SPEED dinghy2 20.0
//					ENDIF
//				ENDIF
//				BOAT_GOTO_COORDS dinghy2 x y 6.0
//			ELSE
//				IF NOT IS_CAR_DEAD cuban_speeder
//					GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_speeder 8.794 -27.06 0.0 x y z
//					IF LOCATE_CAR_2D dinghy2 x y 4.0 4.0 0
//						SET_BOAT_CRUISE_SPEED dinghy2 2.0
//					ELSE
//						IF LOCATE_CAR_2D dinghy2 x y 10.0 10.0 0
//							SET_BOAT_CRUISE_SPEED dinghy2 12.0
//						ELSE
//							SET_BOAT_CRUISE_SPEED dinghy2 20.0
//						ENDIF
//					ENDIF
//					BOAT_GOTO_COORDS dinghy2 x y 6.0
//				ELSE
//					IF NOT IS_CAR_DEAD cuban_coastg
//						GET_OFFSET_FROM_CAR_IN_WORLD_COORDS cuban_coastg 8.794 -27.06 0.0 x y z
//						IF LOCATE_CAR_2D dinghy2 x y 4.0 4.0 0
//							SET_BOAT_CRUISE_SPEED dinghy2 2.0
//						ELSE
//							IF LOCATE_CAR_2D dinghy2 x y 10.0 10.0 0
//								SET_BOAT_CRUISE_SPEED dinghy2 12.0
//							ELSE
//								SET_BOAT_CRUISE_SPEED dinghy2 20.0
//							ENDIF
//						ENDIF
//						BOAT_GOTO_COORDS dinghy2 x y 6.0
//					ELSE
//						IF NOT IS_CAR_DEAD dinghy1
//							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS dinghy1 8.794 -27.06 0.0 x y z
//							IF LOCATE_CAR_2D dinghy2 x y 4.0 4.0 0
//								SET_BOAT_CRUISE_SPEED dinghy2 2.0
//							ELSE
//								IF LOCATE_CAR_2D dinghy2 x y 10.0 10.0 0
//									SET_BOAT_CRUISE_SPEED dinghy2 12.0
//								ELSE
//									SET_BOAT_CRUISE_SPEED dinghy2 20.0
//								ENDIF
//							ENDIF
//							BOAT_GOTO_COORDS dinghy2 x y 6.0
//						ELSE
//							IF NOT boat_route_counter = 0
//								-- boat_route_counter
//								new_boat_using_gosub = 1
//							ENDIF
//							SET_BOAT_CRUISE_SPEED dinghy2 12.0
//							dinghy2_flag = 2
//						ENDIF
//					ENDIF
//				ENDIF
//			ENDIF
//		ENDIF
//		IF dinghy2_flag = 2
//			gosub_boat = dinghy2
//			GOSUB boat_routes_gosub
//		ENDIF
//	ELSE
//		REMOVE_BLIP dinghy2_blip
//		++ dead_cubans
//	ENDIF

	//cubangang_car/////////////////
	////////////////////////////////
	IF NOT IS_CAR_DEAD cubangang_car
		IF cubangang_car_flag = 0
			IF cuban_dude13_flag = 4//IN CUBANGANG_CAR AS DRIVER
				IF NOT IS_CHAR_DEAD	cuban_dude13
					SET_CAR_STRAIGHT_LINE_DISTANCE cubangang_car 200
					CAR_GOTO_COORDINATES_ACCURATE cubangang_car -508.7597 -311.8881 10.4693
					SET_CAR_CRUISE_SPEED cubangang_car 15.0
					SET_CAR_DRIVING_STYLE cubangang_car 2
					cubangang_car_flag = 1
				ENDIF
			ENDIF
		ENDIF
		IF cubangang_car_flag = 1
			IF LOCATE_CAR_2D cubangang_car -508.7597 -311.8881 6.0 6.0 0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car -523.6951 -342.9825 10.9509
				cubangang_car_flag = 2
			ENDIF
		ENDIF
		IF cubangang_car_flag = 2
			IF LOCATE_CAR_2D cubangang_car -523.6951 -342.9825 4.0 4.0 0
				SET_CAR_STRAIGHT_LINE_DISTANCE cubangang_car 20
				SET_CAR_CRUISE_SPEED cubangang_car 20.0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car -761.7885 -492.0030 14.0889
				cubangang_car_flag = 3
			ENDIF
		ENDIF
		IF cubangang_car_flag = 3
			IF LOCATE_CAR_2D cubangang_car -761.7885 -492.0030 6.0 6.0 0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car -942.2122 -278.2615 10.3119
				cubangang_car_flag = 4
			ENDIF
		ENDIF
		//START OF LOOP
		IF cubangang_car_flag = 4
			IF LOCATE_CAR_2D cubangang_car -942.2122 -278.2615 6.0 6.0 0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car -1067.2872 -1.6537 11.2119
				cubangang_car_flag = 5
			ENDIF
		ENDIF
		IF cubangang_car_flag = 5
			IF LOCATE_CAR_2D cubangang_car -1067.2872 -1.6537 6.0 6.0 0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car -964.8415 321.9443 11.0549
				cubangang_car_flag = 6
			ENDIF
		ENDIF
		IF cubangang_car_flag = 6
			IF LOCATE_CAR_2D cubangang_car -964.8415 321.9443 6.0 6.0 0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car -863.3309 -261.5879 10.7002
				cubangang_car_flag = 7
			ENDIF
		ENDIF
		IF cubangang_car_flag = 7
			IF LOCATE_CAR_2D cubangang_car -863.3309 -261.5879 6.0 6.0 0
				CAR_GOTO_COORDINATES_ACCURATE cubangang_car	-942.2122 -278.2615 10.3119
				cubangang_car_flag = 4
			ENDIF
		ENDIF
	ENDIF

	IF IS_CAR_DEAD cuban_jetmax
	AND	IS_CAR_DEAD cuban_speeder
	AND	IS_CAR_DEAD cuban_coastg
		IF cuban_dude13_flag = 1
			cuban_dude13_flag =	2
		ENDIF
	ENDIF

	IF dead_cubans = 12
		GOTO mission_haitian2_passed
	ENDIF

ENDWHILE


boat_routes_gosub:

IF boat_route_counter = 0
	BOAT_GOTO_COORDS gosub_boat	-555.308 -141.189 6.0
	boat_route_counter = 1
	new_boat_using_gosub = 0
ENDIF

IF boat_route_counter = 1
	IF LOCATE_CAR_3D gosub_boat	-555.308 -141.189 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-626.792 -78.237 6.0
		boat_route_counter = 2
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 2
	IF LOCATE_CAR_3D gosub_boat	-626.792 -78.237 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-649.263 -5.788 6.0//BEGINNING OF LOOP
		boat_route_counter = 3
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 3
	IF LOCATE_CAR_3D gosub_boat	-649.263 -5.788 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-602.947 296.718 6.0
		boat_route_counter = 4
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 4
	IF LOCATE_CAR_3D gosub_boat	-602.947 296.718 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-587.552 427.51 6.0
		boat_route_counter = 5
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 5
	IF LOCATE_CAR_3D gosub_boat	-587.552 427.51 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-528.738 507.634 6.0
		boat_route_counter = 6
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 6
	IF LOCATE_CAR_3D gosub_boat	-528.738 507.634 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-443.897 470.554 6.0
		boat_route_counter = 7
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 7
	IF LOCATE_CAR_3D gosub_boat	-443.897 470.554 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-490.341 377.161 6.0
		boat_route_counter = 8
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 8
	IF LOCATE_CAR_3D gosub_boat	-490.341 377.161 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-602.947 296.718 6.0
		boat_route_counter = 9
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 9
	IF LOCATE_CAR_3D gosub_boat	-602.947 296.718 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-649.263 -5.788 6.0
		boat_route_counter = 10
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 10
	IF LOCATE_CAR_3D gosub_boat	-649.263 -5.788 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-749.833 -327.552 6.0
		boat_route_counter = 11
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 11
	IF LOCATE_CAR_3D gosub_boat	-749.833 -327.552 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-750.703 -447.009 6.0
		boat_route_counter = 12
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 12
	IF LOCATE_CAR_3D gosub_boat	-750.703 -447.009 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-739.379 -573.229 6.0
		boat_route_counter = 13
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 13
	IF LOCATE_CAR_3D gosub_boat	-739.379 -573.229 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-743.073 -674.655 6.0
		boat_route_counter = 14
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 14
	IF LOCATE_CAR_3D gosub_boat	-743.073 -674.655 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-710.041 -787.354 6.0
		boat_route_counter = 15
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 15
	IF LOCATE_CAR_3D gosub_boat	-710.041 -787.354 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-600.638 -835.484 6.0
		boat_route_counter = 16
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 16
	IF LOCATE_CAR_3D gosub_boat	-600.638 -835.484 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-509.722 -756.564 6.0
		boat_route_counter = 17
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 17
	IF LOCATE_CAR_3D gosub_boat	-509.722 -756.564 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-571.734 -697.569 6.0
		boat_route_counter = 18
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 18
	IF LOCATE_CAR_3D gosub_boat	-571.734 -697.569 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-661.336 -662.576 6.0
		boat_route_counter = 19
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 19
	IF LOCATE_CAR_3D gosub_boat	-661.336 -662.576 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-739.379 -573.229 6.0
		boat_route_counter = 20
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 20
	IF LOCATE_CAR_3D gosub_boat	-739.379 -573.229 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-750.703 -447.009 6.0
		boat_route_counter = 21
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 21
	IF LOCATE_CAR_3D gosub_boat	-750.703 -447.009 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-749.833 -327.552 6.0
		boat_route_counter = 22
		new_boat_using_gosub = 0
	ENDIF
ENDIF

IF boat_route_counter = 22
	IF LOCATE_CAR_3D gosub_boat	-749.833 -327.552 6.0 6.0 6.0 6.0 0
	OR new_boat_using_gosub = 1
		BOAT_GOTO_COORDS gosub_boat	-649.263 -5.788 6.0//BEGINNING OF LOOP
		boat_route_counter = 3
		new_boat_using_gosub = 0
	ENDIF
ENDIF

RETURN


// Mission haitian2 failed

mission_haitian2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission haitian2 passed

mission_haitian2_passed:

flag_haitian_mission2_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 2000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000
REGISTER_MISSION_PASSED HAT_2
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
//IF NOT IS_GERMAN_GAME // SCFIX: remove german censorshit
	START_NEW_SCRIPT haitian_mission3_loop
//ELSE // SCFIX: remove german censorshit
//	REMOVE_BLIP haitian_contact_blip // SCFIX: remove german censorshit
//ENDIF // SCFIX: remove german censorshit

RETURN
		


// mission cleanup

mission_cleanup_haitian2:

flag_player_on_mission = 0

IF NOT rc_plane = -1
	REMOVE_RC_BUGGY
	MARK_OBJECT_AS_NO_LONGER_NEEDED	primed_bomb_1
	MARK_OBJECT_AS_NO_LONGER_NEEDED	falling_bomb_1
	rc_plane = -1
ENDIF

IF NOT IS_CAR_DEAD plane_carrier
	FREEZE_CAR_POSITION plane_carrier FALSE
	LOCK_CAR_DOORS plane_carrier CARLOCK_UNLOCKED
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED TOPFUN
MARK_MODEL_AS_NO_LONGER_NEEDED RCBARON
MARK_MODEL_AS_NO_LONGER_NEEDED SPEEDER
MARK_MODEL_AS_NO_LONGER_NEEDED JETMAX	
MARK_MODEL_AS_NO_LONGER_NEEDED COASTG	
MARK_MODEL_AS_NO_LONGER_NEEDED CUBAN
MARK_MODEL_AS_NO_LONGER_NEEDED CBA	
MARK_MODEL_AS_NO_LONGER_NEEDED CBB	
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER

REMOVE_BLIP	plane_carrier_blip 
REMOVE_BLIP cuban_jetmax_blip 
REMOVE_BLIP cuban_speeder_blip 
REMOVE_BLIP cuban_coastg_blip 
//REMOVE_BLIP dinghy1_blip 
//REMOVE_BLIP dinghy2_blip
REMOVE_BLIP cuban_dude01_blip
REMOVE_BLIP cuban_dude02_blip
REMOVE_BLIP cuban_dude03_blip
REMOVE_BLIP cuban_dude04_blip
REMOVE_BLIP cuban_dude05_blip
REMOVE_BLIP cuban_dude06_blip
REMOVE_BLIP cuban_dude07_blip
REMOVE_BLIP cuban_dude08_blip
//REMOVE_BLIP cuban_dude09_blip
//REMOVE_BLIP cuban_dude10_blip
//REMOVE_BLIP cuban_dude11_blip
//REMOVE_BLIP cuban_dude12_blip
REMOVE_BLIP cuban_dude13_blip

GET_GAME_TIMER timer_mobile_start

//CLEAR_AREA -817.3 -245.0 11.1 150.0 TRUE

CLEAR_ONSCREEN_COUNTER no_of_rc_planes_left
flag_player_on_rc_mission = 0

MISSION_HAS_FINISHED
RETURN


}