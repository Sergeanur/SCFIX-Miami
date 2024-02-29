MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// **************************************** Bank Job *************************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff
{

GOSUB mission_start_bankjob4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bankjob4_failed
ENDIF

GOSUB mission_cleanup_bankjob4

MISSION_END
 
// Variables for mission
//VAR_INT flag_bank_job
VAR_INT audio_slot cs_gun 

VAR_INT flag_player_in_car flag_arrived_in_car flag_this_is_a_raid
//VAR_INT hostage_collective
VAR_INT flag_hilary_gone	flag_bank_mission_failed
VAR_INT flag_player_gun
//VAR_INT flag_bibble flag_bobble flag_babble

VAR_INT bank_cop_1 bank_cop_2 bank_cop_3
VAR_INT bank_cop_4 bank_cop_5 bank_cop_6
VAR_INT bank_cop_7 bank_cop_8 
//VAR_INT bank_cop_9 bank_cop_10 bank_cop_11 bank_cop_12

VAR_INT target_ped phils_target bank_alarm
VAR_INT target_ped1 target_ped2 target_ped3 target_ped4
VAR_INT bank_manager

VAR_INT bank_job_counter flag_blip_on_phil flag_blip_on_hilary flag_blip_on_cam random_int
VAR_INT phil hilary cam phil_blip hilary_blip cam_blip locate_dome_flag
VAR_INT	getaway_car	blip_getaway_car flag_blip_on_getaway_car


VAR_INT cashier1 cashier2 cashier3 cashier4 cashier5 cashier6 cashier7 cashier8
//VAR_INT clerk_1 clerk_2 clerk_3 clerk_4
//VAR_INT punter_1 punter_2 punter_3 punter_4 punter_5 punter_6 punter_7 punter_8 
VAR_INT cop_car1 cop_car2 cop_car3 //cop_car4 cop_car5

VAR_INT bank_armour bank_health //bank_chaingun

VAR_INT lift_door_1 lift_door_2

VAR_INT counter_conv1 counter_conv2 counter_conv3 //counter_conv4
VAR_INT counter_temp1 counter_temp2 counter_temp3 counter_temp4
VAR_INT flag_conv3 flag_watch_the_car flag_stopped

VAR_INT flag_cam_downstairs
VAR_INT gas_1 gas_2 gas_3 gas_4 gas_5 gas_6 var_gas
VAR_FLOAT gas_x gas_y gas_z gas_vect_x gas_vect_y gas_vect_z
VAR_FLOAT gas_world_x gas_world_y gas_world_z

VAR_INT swat_1 swat_2 //swat_3 swat_4 swat_5 swat_6
VAR_INT flag_swat_rope flag_grill_collision
VAR_INT flag_player_leader_phil	flag_player_leader_hilary flag_player_leader_cam

LVAR_INT hostage_casualties
LVAR_INT flag_hostage1 flag_hostage2 flag_hostage3 flag_hostage4  
LVAR_INT flag_hostage5 flag_hostage6 flag_hostage7 flag_hostage8  
LVAR_INT flag_hostage9 flag_hostage10 flag_hostage11   
VAR_INT flag_launch_hostage_attack var_hostage hostage_int
//VAR_INT flag_cam_dead
//VAR_INT guard1 guard2 guard3 guard4	guard5 guard6
//VAR_INT guard1_routine_counter guard2_routine_counter guard3_routine_counter guard4_routine_counter guard5_routine_counter guard6_routine_counter
//VAR_INT cam_routine_counter phil_routine_counter

VAR_INT flag_car_warp

VAR_INT mission_blip flag_switcharoo // mission_blob
VAR_INT rand_crouch_time
VAR_INT flag_surveilance flag_surv_cam flag_surveilance_trigger

VAR_INT flag_phil_at_bank 
VAR_INT flag_hilary_at_bank 
VAR_INT flag_cam_at_bank flag_cam_dead
VAR_INT flag_dialogue
VAR_INT retirement
VAR_INT flag_flee 

//VAR_INT flag_launch_cops_1
VAR_INT flag_cop_4 flag_cop_5 flag_cop_6 flag_cop_7
VAR_INT flag_waitstate_1 flag_waitstate_2 flag_waitstate_3 flag_change_waitstate

//VAR_INT route_1	route_2
VAR_INT flag_area_check_1 flag_phil_warp flag_cam_at_target

//VAR_INT flag_player_in_bank
VAR_FLOAT warp_x warp_y warp_z
VAR_FLOAT world_x world_y world_z
//VAR_FLOAT waypoint_1_x waypoint_1_y waypoint_2_x waypoint_2_y waypoint_z
VAR_FLOAT phil_x phil_y  cam_x cam_y   //phil_z
VAR_FLOAT player_heading_bj4

// ******** TEST FLAGS FOR 'LOAD AND LAUNCH EXCLUSIVE' **********************************

//VAR_INT flag_intro  timer_intro_start intro_time_lapsed	timer_intro_now
//VAR_INT test_blip1 test_blip2 test_blip3 test_blip4 
// ****************************************Mission Start************************************

mission_start_bankjob4:

SCRIPT_NAME bankjo4

flag_player_on_mission = 1
LOAD_MISSION_TEXT BANKJ4
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 512.591 -74.900 9.573 189.24

flag_player_in_malibu = 0
REGISTER_MISSION_GIVEN 
WAIT 0

// FIXMIAMI - Start: remove robber clothes from player
IF NOT IS_CHAR_DEAD scplayer
AND IS_PLAYER_WEARING player1 player7

	UNDRESS_CHAR scplayer player

	LOAD_ALL_MODELS_NOW

	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF

ENDIF
// FIXMIAMI - End

//flag_bank_job = 1
audio_slot = 1

flag_player_in_car = 0
flag_arrived_in_car = 0
flag_intro = 0
flag_hilary_gone = 0
flag_player_gun = 0
flag_bank_mission_failed = 0

flag_player_leader_phil = 0
flag_player_leader_hilary = 0
flag_player_leader_cam = 0

//flag_player_on_bank_mission = 1
bank_job_counter = 0

flag_blip_on_phil = 0
flag_blip_on_hilary = 0
flag_blip_on_cam = 0
flag_blip_on_getaway_car = 0

locate_dome_flag = 0
flag_area_check_1 = 0

flag_phil_at_bank = 0
flag_hilary_at_bank = 0 
flag_cam_at_bank = 0
flag_this_is_a_raid = 0

//flag_bibble = 0
//flag_babble = 0
//flag_bobble = 0

flag_change_waitstate = 0

flag_cop_4 = 0
flag_cop_5 = 0
flag_cop_6 = 0
flag_cop_7 = 0
//flag_launch_cops_1 = 0

flag_surveilance = 0
flag_surv_cam = 0
flag_surveilance_trigger = 0

flag_switcharoo = 0

counter_conv1 = 0
counter_conv2 = 0
counter_conv3 = 0
//counter_conv4 = 0

counter_temp1 = 0
counter_temp2 = 0
counter_temp3 = 0
counter_temp4 = 0

flag_dialogue = 0
flag_conv3 = 0
flag_watch_the_car = 0
flag_stopped = 0
flag_phil_warp = 0
flag_swat_rope = 0
flag_grill_collision = 0
flag_cam_at_target = 0
flag_flee = 0
flag_cam_dead = 0
phils_target = 0

flag_cam_dead = 0

hostage_casualties = 0
flag_hostage1 = 0
flag_hostage2 = 0
flag_hostage3 = 0
flag_hostage4 = 0
flag_hostage5 = 0
flag_hostage6 = 0
flag_hostage7 = 0
flag_hostage8 = 0
flag_hostage9 = 0
flag_hostage10 = 0
flag_hostage11 = 0
flag_launch_hostage_attack = 0 

flag_cam_downstairs = 0
//flag_player_in_bank = 0

flag_car_warp = 0

// ****************************************START OF CUTSCENE********************************

SWITCH_STREAMING OFF

//CLEAR_EXTRA_COLOURS FALSE
SET_AREA_VISIBLE VIS_MALIBU_CLUB
SET_CAR_DENSITY_MULTIPLIER 0.0
LOAD_SCENE 481.03 -64.21 8.98

 
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_CHARACTER 3 CSphil
LOAD_SPECIAL_CHARACTER 4 CShlary
LOAD_SPECIAL_CHARACTER 5 CScamj

LOAD_SPECIAL_MODEL CUTOBJ01 gcfan
LOAD_SPECIAL_MODEL CUTOBJ02 clchr


LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0

ENDWHILE

SET_NEAR_CLIP 0.1

LOAD_CUTSCENE bank_4

SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_phil
SET_CUTSCENE_ANIM cs_phil CSphil

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_hilary
SET_CUTSCENE_ANIM cs_hilary CShlary

//CREATE_CUTSCENE_OBJECT SPECIAL05 cs_cam
//SET_CUTSCENE_ANIM cs_cam CScamj

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_cam
SET_CUTSCENE_ANIM cs_cam CScamj

SET_CUTSCENE_ANIM_TO_LOOP gcfan
CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_clubfan
SET_CUTSCENE_ANIM cs_clubfan gcfan
SET_CUTSCENE_ANIM_TO_LOOP gcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_clubchair
SET_CUTSCENE_ANIM cs_clubchair clchr

//CREATE_CUTSCENE_HEAD cs_ken CUT_OBJ2 cs_kenhead
//SET_CUTSCENE_HEAD_ANIM cs_kenhead lawyer

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player1

//SET_CUTSCENE_OFFSET 476.972 -65.499 8.943

SET_NEAR_CLIP 0.1

CLEAR_AREA 495.12 -83.39 9.02 1.0 TRUE

SET_PLAYER_COORDINATES player1 495.12 -83.39 9.02

SET_PLAYER_HEADING player1 223.21

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE



// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 3659
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_A ) 10000 1 // Mission brief

WHILE cs_time < 7265
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_B ) 10000 1 // Mission brief

WHILE cs_time < 11744
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_C ) 10000 1 // Mission brief

WHILE cs_time < 16951
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_D ) 10000 1 // Mission brief

WHILE cs_time < 18806
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_E ) 10000 1 // Mission brief

WHILE cs_time < 24030
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_F ) 10000 1 // Mission brief

WHILE cs_time < 28243
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_G ) 10000 1 // Mission brief

WHILE cs_time < 34410
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_H ) 10000 1 // Mission brief

WHILE cs_time < 39555
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_I ) 10000 1 // Mission brief

WHILE cs_time < 46880
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_J ) 10000 1 // Mission brief

WHILE cs_time < 49700
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_K ) 10000 1 // Mission brief

WHILE cs_time < 52105
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BNK4_L ) 10000 1 // Mission brief

WHILE cs_time < 55224
	WAIT 0
	GET_CUTSCENE_TIME cs_time			   
ENDWHILE
CLEAR_PRINTS 			   

WHILE cs_time < 59584
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
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

//SET_AREA_VISIBLE VIS_MAIN_MAP



// ****************************************END OF CUTSCENE**********************************

SET_AREA_VISIBLE VIS_MAIN_MAP
CLEAR_EXTRA_COLOURS FALSE
flag_player_in_malibu = 0
SWITCH_PED_ROADS_OFF 468.0 -77.0 0.0 490.0 -54.0 30.0
SET_TIME_OF_DAY 08 30
SET_CAR_DENSITY_MULTIPLIER 1.0

REQUEST_MODEL m4
REQUEST_MODEL mp5lng
REQUEST_MODEL TAXI
REQUEST_MODEL python

//LOAD_ALL_MODELS_NOW
LOAD_SCENE 496.5 -84.0 9.8

WHILE NOT HAS_MODEL_LOADED m4
OR NOT HAS_MODEL_LOADED	mp5lng
OR NOT HAS_MODEL_LOADED python
OR NOT HAS_MODEL_LOADED	TAXI
	WAIT 0
ENDWHILE

/*
LOAD_SPECIAL_CHARACTER 1 phil3
LOAD_SPECIAL_CHARACTER 2 hlry2     
LOAD_SPECIAL_CHARACTER 3 mike2

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0
ENDWHILE
*/

CLEAR_AREA 496.5 -84.0 9.8 10.0 TRUE
CREATE_CAR TAXI 496.5 -84.0 9.8 getaway_car
SET_CAR_HEADING getaway_car 137.0
ADD_UPSIDEDOWN_CAR_CHECK getaway_car

LOAD_SPECIAL_CHARACTER 1 igphil
LOAD_SPECIAL_CHARACTER 2 ighlary     
LOAD_SPECIAL_CHARACTER 3 igmike

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player1 OFF
SET_CAMERA_IN_FRONT_OF_PLAYER
//GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_MP5 120

SET_PLAYER_COORDINATES player1 491.6465 -80.4476 10.4539 
SET_PLAYER_HEADING player1 225.0

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 490.6913 -79.4378 10.4539 phil
//CREATE_CHAR PEDTYPE_CIVMALE SPECIAL01 490.6913 -79.4378 10.4539 phil
SET_CHAR_HEADING phil 225.0
CLEAR_CHAR_THREAT_SEARCH phil
SET_CHAR_PERSONALITY phil PEDSTAT_TOUGH_GUY
SET_CHAR_AS_PLAYER_FRIEND phil player1 TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS phil FALSE
//SET_CHAR_USE_RANDOM_COMMENTS phil FALSE
//SET_CHAR_THREAT_SEARCH phil THREAT_COP
//SET_CHAR_RUNNING phil TRUE

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL02 490.0092 -80.1343 10.4539 hilary
//CREATE_CHAR PEDTYPE_CIVMALE SPECIAL02 490.0092 -80.1343 10.4539 hilary
SET_CHAR_HEADING hilary 225.0
CLEAR_CHAR_THREAT_SEARCH hilary
SET_CHAR_AS_PLAYER_FRIEND hilary player1 TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS hilary FALSE
//SET_CHAR_USE_RANDOM_COMMENTS hilary FALSE
//SET_CHAR_RUNNING hilary TRUE

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL03 491.3710 -78.7345 10.4539 cam
//CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 491.3710 -78.7345 10.4539 cam
SET_CHAR_HEADING cam 225.0
CLEAR_CHAR_THREAT_SEARCH cam
SET_CHAR_AS_PLAYER_FRIEND cam player1 TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS cam FALSE
//SET_CHAR_USE_RANDOM_COMMENTS cam FALSE
//SET_CHAR_RUNNING cam TRUE



ADD_BLIP_FOR_COORD -833.0 -348.0 11.0 mission_blip
locate_dome_flag = 1				
flag_area_check_1 = 1

DO_FADE 750 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_PLAYER_CONTROL player1 ON
SET_RADIO_CHANNEL 6 -1
PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"

LOAD_MISSION_AUDIO 2 BNK4_3a

GET_GAME_TIMER timer_intro_start

bank_job_loop1:	// GETTING TO THE BANK

	WAIT 0
	
	//SET_PLAYER_HEALTH player1 100 // test stuff!!!!!
	
	GOSUB car_check
	GOSUB phil_check
	GOSUB cam_check
	GOSUB hilary_check
	
	IF counter_conv1 < 7
		GOSUB bank_job_timer
		GOSUB Conversation_1
	ENDIF
	
	IF counter_conv2 = 1
		GOSUB bank_job_timer
		GOSUB Conversation_2
	ENDIF

	IF NOT IS_CAR_DEAD getaway_car
		IF NOT IS_PLAYER_IN_CAR player1 getaway_car
		AND flag_switcharoo = 1
			IF flag_stopped = 0
				LOAD_MISSION_AUDIO audio_slot BNK4_3v
				GOSUB audio_bank_loading
				PRINT_NOW ( BNK4_3v ) 10000 1//rhubarb rhubarb
				GOSUB has_audio_finished_bank
				PRINT_NOW (GETCAR) 4000 1 // get a car!
				//CLEAR_PRINTS
				flag_stopped = 1
			ENDIF
		ELSE
			flag_stopped = 0
		ENDIF
	ENDIF


	IF NOT IS_CAR_DEAD getaway_car
		IF flag_conv3 = 0
		AND NOT IS_CAR_HEALTH_GREATER getaway_car 800
			audio_slot = 2
			GOSUB audio_bank_loading
			PRINT_NOW ( BNK4_3a ) 10000 1//rhubarb rhubarb
			GOSUB has_audio_finished_bank
			CLEAR_PRINTS
			flag_conv3 = 1
		ENDIF
	ENDIF
	
	IF NOT IS_CAR_DEAD getaway_car
		IF flag_conv3 = 1
		AND NOT IS_CAR_HEALTH_GREATER getaway_car 650
			GOSUB Conversation_3
		ENDIF
	ENDIF
		
	IF flag_blip_on_phil = 1
	OR flag_blip_on_hilary = 1
	OR flag_blip_on_cam = 1
		locate_dome_flag = 0
	ELSE
		IF flag_player_in_car = 1
			IF flag_switcharoo = 0
				IF NOT IS_CAR_DEAD getaway_car
				AND NOT IS_CHAR_DEAD phil
					IF IS_CHAR_IN_CAR phil getaway_car
					AND NOT IS_CHAR_DEAD cam
						IF IS_CHAR_IN_CAR cam getaway_car
						AND NOT IS_CHAR_DEAD hilary
							IF IS_CHAR_IN_CAR hilary getaway_car
								DELETE_CHAR phil
								DELETE_CHAR cam
								DELETE_CHAR hilary
								CREATE_CHAR_AS_PASSENGER getaway_car PEDTYPE_CIVMALE SPECIAL01 1 phil
								CLEAR_CHAR_THREAT_SEARCH phil
								SET_CHAR_PERSONALITY phil PEDSTAT_TOUGH_GUY
								SET_CHAR_AS_PLAYER_FRIEND phil player1 TRUE
								SET_CHAR_SUFFERS_CRITICAL_HITS phil FALSE

								CREATE_CHAR_AS_PASSENGER getaway_car PEDTYPE_CIVMALE SPECIAL02 0 hilary
								CLEAR_CHAR_THREAT_SEARCH hilary
								SET_CHAR_AS_PLAYER_FRIEND hilary player1 TRUE
								SET_CHAR_SUFFERS_CRITICAL_HITS hilary FALSE

								CREATE_CHAR_AS_PASSENGER getaway_car PEDTYPE_CIVMALE SPECIAL03 2 cam
								CLEAR_CHAR_THREAT_SEARCH cam
								SET_CHAR_AS_PLAYER_FRIEND cam player1 TRUE
								SET_CHAR_SUFFERS_CRITICAL_HITS cam FALSE

								flag_switcharoo = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF locate_dome_flag	= 0
				ADD_BLIP_FOR_COORD -833.0 -348.0 10.0 mission_blip
				locate_dome_flag = 1
			ENDIF
			IF NOT IS_CAR_DEAD getaway_car
			AND flag_switcharoo = 1
				IF LOCATE_CAR_3D getaway_car -833.0 -348.0 10.0 4.0 4.0 4.0 TRUE
				AND IS_CAR_STOPPED getaway_car
				AND NOT IS_CAR_UPSIDEDOWN getaway_car
					GOTO biffa
				ENDIF
			ENDIF				
		ELSE
			IF flag_switcharoo = 1
				IF NOT IS_CAR_DEAD getaway_car
				AND NOT IS_CHAR_DEAD phil
					IF NOT IS_CHAR_IN_CAR phil getaway_car
					AND NOT IS_CHAR_DEAD cam
						IF NOT IS_CHAR_IN_CAR cam getaway_car
						AND NOT IS_CHAR_DEAD hilary
							IF NOT IS_CHAR_IN_CAR hilary getaway_car
								flag_switcharoo = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF

GOTO bank_job_loop1

/////////////////////// First Arrival at Bank /////////////////////////////

biffa:
flag_area_check_1 = 0
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_EVERYONE_IGNORE_PLAYER player1 ON 
//DELETE_CHAR hilary
IF NOT IS_CAR_DEAD getaway_car
	SET_CAR_HEALTH getaway_car 1000
	GET_CAR_COORDINATES getaway_car cam_x cam_y world_z
ENDIF
cam_x = cam_x + 7.0
world_z = world_z + 2.5

IF NOT IS_CHAR_DEAD hilary
	LEAVE_GROUP hilary
ENDIF

SET_FIXED_CAMERA_POSITION cam_x cam_y world_z 0.0 0.0 0.0
//STORE_CAR_PLAYER_IS_IN player1 getaway_car

GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car 0.0 -3.5 0.0 warp_x warp_y warp_z
GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car 0.0 -3.5 0.0 world_x world_y world_z
GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car -1.0 -4.5 0.0 phil_x phil_y world_z
GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car 1.0 -4.5 0.0 cam_x cam_y world_z
//GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car -4.0 0.0 0.0 waypoint_1_x waypoint_1_y waypoint_z
//GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car -4.0 -4.0.0 0.0 waypoint_2_x waypoint_2_y waypoint_z
//ADD_ROUTE_POINT route_1 waypoint_1_x waypoint_1_y waypoint_z
//ADD_ROUTE_POINT route_1 waypoint_2_x waypoint_2_y waypoint_z
//ADD_ROUTE_POINT route_1 world_x world_y world_z
GET_CAR_COORDINATES getaway_car player_x player_y player_z
GET_CAR_HEADING getaway_car player_heading_bj4 
flag_intro = 0

biffa_loop:

	WAIT 0
	IF flag_intro = 0
		GET_GAME_TIMER timer_intro_start
		IF NOT IS_CAR_DEAD getaway_car
			POINT_CAMERA_AT_CAR getaway_car FIXED JUMP_CUT
			IF NOT IS_CHAR_DEAD scplayer
				SET_CHAR_OBJ_LEAVE_CAR scplayer getaway_car
			ENDIF
			WAIT 500
			IF NOT IS_CHAR_DEAD phil
			AND NOT IS_CAR_DEAD getaway_car
				SET_CHAR_OBJ_LEAVE_CAR phil getaway_car
			ENDIF
			WAIT 150
			IF NOT IS_CHAR_DEAD cam
			AND NOT IS_CAR_DEAD getaway_car
				SET_CHAR_OBJ_LEAVE_CAR cam getaway_car
			ENDIF
			WAIT 500
			IF NOT IS_CHAR_DEAD hilary
			AND NOT IS_CAR_DEAD getaway_car
				SET_CHAR_OBJ_LEAVE_CAR hilary getaway_car
			ENDIF
		ENDIF
		flag_intro = 1
	ENDIF

	GOSUB bank_job_timer	
	
	IF flag_intro = 1
		IF NOT IS_CHAR_DEAD hilary
			IF NOT IS_CHAR_IN_ANY_CAR hilary
				audio_slot = 1
				LOAD_MISSION_AUDIO audio_slot BNK4_4a
				GOSUB audio_bank_loading
				PRINT_NOW (BNK4_4a) 3000 1 
				GOSUB has_audio_finished_bank
				//LOAD_MISSION_AUDIO audio_slot BNK4_94
				flag_intro = 2
			ENDIF
		ENDIF
	ENDIF

	IF intro_time_lapsed > 2000	   
	AND flag_intro = 2
		LOAD_MISSION_AUDIO audio_slot BNK4_5
		GOSUB audio_bank_loading
		PRINT_NOW (BNK4_5) 3000 1 
		IF NOT IS_CHAR_DEAD hilary
		AND NOT IS_CAR_DEAD getaway_car
			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER hilary getaway_car
		ENDIF
		IF NOT IS_CHAR_DEAD scplayer
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer world_x world_y
			//SET_CHAR_OBJ_FOLLOW_ROUTE scplayer route_1 FOLLOW_ROUTE_ONCE
			//CHAR_FOLLOW_PATH scplayer world_x world_y -100.0 1.0 WALK
		ENDIF
		IF NOT IS_CHAR_DEAD phil
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT phil phil_x phil_y
			//CHAR_FOLLOW_PATH scplayer phil_x phil_y -100.0 1.0 WALK
		ENDIF
		IF NOT IS_CHAR_DEAD cam
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT cam cam_x cam_y
			//CHAR_FOLLOW_PATH scplayer cam_x cam_y -100.0 1.0 WALK
		ENDIF
		GOSUB has_audio_finished_bank
		flag_intro = 3
	ENDIF

	IF intro_time_lapsed > 4000	   
	AND flag_intro = 3
		IF NOT IS_CHAR_DEAD scplayer
		AND LOCATE_CHAR_ON_FOOT_2D scplayer	world_x world_y 3.0 3.0 FALSE
			player_z = player_z + 0.25
			SET_FIXED_CAMERA_POSITION player_x player_y player_z 0.0 0.0 0.0
			player_z = player_z + 2.0
			SET_CHAR_OBJ_NO_OBJ scplayer
			SET_CHAR_COORDINATES scplayer world_x world_y -100.0
			SET_CHAR_HEADING scplayer player_heading_bj4
			POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT
			IF NOT IS_CHAR_DEAD phil
				SET_CHAR_OBJ_NO_OBJ phil
				SET_CHAR_COORDINATES phil phil_x phil_y -100.0
				player_heading_bj4 = player_heading_bj4 + 70.0
				SET_CHAR_HEADING phil player_heading_bj4
			ENDIF
			IF NOT IS_CHAR_DEAD cam
				SET_CHAR_OBJ_NO_OBJ cam
				SET_CHAR_COORDINATES cam cam_x cam_y -100.0
				player_heading_bj4 = player_heading_bj4 - 140.0
				SET_CHAR_HEADING cam player_heading_bj4
			ENDIF
			GET_GAME_TIMER timer_intro_start
			GOSUB bank_job_timer
			flag_intro = 4
		ENDIF
	ENDIF
	
	IF flag_intro = 4
	AND intro_time_lapsed > 2000
		IF NOT IS_CAR_DEAD getaway_car
			POP_CAR_BOOT_USING_PHYSICS getaway_car
			flag_intro = 5
		ENDIF
	ENDIF

	IF flag_intro = 5
	AND intro_time_lapsed > 4000
		flag_intro = 6
	ENDIF
	
	IF flag_intro = 6
	AND intro_time_lapsed > 5000
		IF NOT IS_CAR_DEAD getaway_car
			GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car -6.0 -3.0 1.0 world_x world_y world_z
		ENDIF
		SET_FIXED_CAMERA_POSITION world_x world_y world_z 0.0 0.0 0.0
		IF NOT IS_CHAR_DEAD scplayer
			POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT
		ENDIF
		//LOAD_MISSION_AUDIO audio_slot BNK4_94
		//GOSUB audio_bank_loading
		//PRINT_NOW (BNK4_94) 3000 1
		//GOSUB has_audio_finished_bank 
		flag_intro = 7
	ENDIF

	IF flag_intro = 7
	AND intro_time_lapsed > 7000
		IF NOT IS_CAR_DEAD getaway_car
		AND NOT IS_CHAR_DEAD hilary
			IF NOT IS_CHAR_IN_CAR hilary getaway_car
				WARP_CHAR_INTO_CAR hilary getaway_car
			ENDIF
			SET_CHAR_CANT_BE_DRAGGED_OUT hilary TRUE
			CAR_WANDER_RANDOMLY getaway_car
			SET_CAR_CRUISE_SPEED getaway_car 15.0
			LOCK_CAR_DOORS getaway_car CARLOCK_LOCKED
		ENDIF
		flag_intro = 8
	ENDIF
	
	IF flag_intro = 8
	AND intro_time_lapsed > 8000
		SET_PLAYER_CONTROL player1 ON
		SWITCH_WIDESCREEN OFF
		RESTORE_CAMERA_JUMPCUT
		flag_intro = 9
	ENDIF

IF NOT flag_intro = 9
	GOTO biffa_loop
ENDIF

flag_hilary_gone = 1
//ADD_ROUTE_POINT RouteIndex X Y Z
//SET_CHAR_OBJ_FOLLOW_ROUTE CharID RouteIndex RouteFollowMethod
flag_player_in_car = 0

SET_PLAYER_CONTROL player1 ON

REMOVE_BLIP	mission_blip
ADD_BLIP_FOR_COORD -894.0 -331.2 12.45 mission_blip

IF NOT IS_CHAR_DEAD cam
	SET_PLAYER_AS_LEADER cam player1 
ENDIF
IF NOT IS_CHAR_DEAD phil
	SET_PLAYER_AS_LEADER phil player1 
ENDIF

//timera = 0
WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -894.0 -331.2 12.45 2.0 2.0 3.0 TRUE
	WAIT 0
	//GOSUB car_check
	GOSUB phil_death_check
	GOSUB cam_death_check
	GOSUB hilary_car_check
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
ENDWHILE


// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO CHANGE OF CLOTHES 000000000000000000000000000000000000
// 00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000


CLEAR_PRINTS

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_EVERYONE_IGNORE_PLAYER player1 ON 

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -893.9 -324.6

SET_FADING_COLOUR 0 0 1

DO_FADE 750 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
	IF NOT IS_CAR_DEAD getaway_car
	AND flag_car_warp = 0
	//AND timera > 5000
		IF NOT IS_CAR_ON_SCREEN	getaway_car
			DISARM_CAR_BOMB getaway_car
			SET_CAR_COORDINATES getaway_car -903.6 -376.6 56.7
			SET_CAR_HEADING getaway_car 270.0
			SET_CAR_CRUISE_SPEED getaway_car 0.0
			SET_CAR_HEALTH getaway_car 1000
			FREEZE_CAR_POSITION getaway_car TRUE
			flag_car_warp = 1
		ENDIF
	ENDIF

ENDWHILE

CLEAR_AREA -894.0 -331.2 12.45 10.0 TRUE

SET_CHAR_COORDINATES scplayer -893.9 -327.2 12.45
SET_CHAR_HEADING scplayer 175.0
DELETE_CHAR phil
DELETE_CHAR cam

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 3

LOAD_SPECIAL_CHARACTER 1 igphil3
LOAD_SPECIAL_CHARACTER 3 igmike2
LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 1
	WAIT 0
ENDWHILE

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -894.1 -325.0 12.45 phil
SET_CHAR_HEADING phil 175.0
CLEAR_CHAR_THREAT_SEARCH phil
SET_CHAR_AS_PLAYER_FRIEND phil player1 TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS phil FALSE
SET_CHAR_PERSONALITY phil PEDSTAT_PSYCHO
SET_CHAR_HEALTH phil 200
SET_CHAR_NEVER_TARGETTED phil TRUE

//SET_PLAYER_AS_LEADER phil player1

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL03 -894.1 -324.5 12.45 cam
SET_CHAR_HEADING cam 175.0
CLEAR_CHAR_THREAT_SEARCH cam
SET_CHAR_AS_PLAYER_FRIEND cam player1 TRUE
SET_CHAR_SUFFERS_CRITICAL_HITS cam FALSE
SET_CHAR_PERSONALITY cam PEDSTAT_TOUGH_GUY
SET_CHAR_HEALTH cam 200
SET_CHAR_NEVER_TARGETTED cam TRUE
//SET_PLAYER_AS_LEADER cam player1

IF NOT IS_CHAR_DEAD scplayer
	UNDRESS_CHAR scplayer player7
	LOAD_ALL_MODELS_NOW
	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF
ENDIF
/*
REQUEST_MODEL M4
WHILE NOT HAS_MODEL_LOADED M4
	WAIT 0
ENDWHILE
*/
IF NOT IS_CHAR_DEAD scplayer
	IF NOT IS_CHAR_DEAD phil
		//TURN_CHAR_TO_FACE_CHAR phil scplayer 
		GIVE_WEAPON_TO_CHAR phil WEAPONTYPE_M4 9999
	ENDIF
	IF NOT IS_CHAR_DEAD cam
		//TURN_CHAR_TO_FACE_CHAR cam scplayer 
		GIVE_WEAPON_TO_CHAR cam WEAPONTYPE_MP5 9999
	ENDIF
	GIVE_WEAPON_TO_CHAR scplayer WEAPONTYPE_PYTHON 24
ENDIF


audio_slot = 1
LOAD_MISSION_AUDIO audio_slot BNK4_94
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_94 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
CLEAR_PRINTS

IF NOT IS_CHAR_DEAD scplayer
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -894.2 -330.25
ENDIF

SET_FIXED_CAMERA_POSITION -894.05 -331.06 13.3 0.0 0.0 0.0
GET_PLAYER_COORDINATES player1 world_x world_y world_z
world_z = world_z + 0.8 
POINT_CAMERA_AT_POINT world_x world_y world_z JUMP_CUT

DO_FADE 750 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
	GET_PLAYER_COORDINATES player1 world_x world_y world_z
	world_z = world_z + 0.8 
	POINT_CAMERA_AT_POINT world_x world_y world_z JUMP_CUT
ENDWHILE


IF NOT IS_CHAR_DEAD cam
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT cam -894.7 -328.0
ENDIF
IF NOT IS_CHAR_DEAD phil
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT phil -893.25 -329.5
ENDIF

GET_GAME_TIMER timer_intro_start
GOSUB bank_job_timer

WHILE intro_time_lapsed < 7000
	WAIT 0
	GET_PLAYER_COORDINATES player1 world_x world_y world_z
	world_z = world_z + 0.8 
	POINT_CAMERA_AT_POINT world_x world_y world_z JUMP_CUT
	GOSUB bank_job_timer
ENDWHILE

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF 
 
IF NOT IS_CHAR_DEAD phil
	SET_PLAYER_AS_LEADER phil player1
ENDIF
IF NOT IS_CHAR_DEAD cam
	SET_PLAYER_AS_LEADER cam player1
ENDIF

bank_job_loop3:	// Gang arrived on foot. Player must tell Hilary to get a new car
WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -896.0 -341.0 12.5 2.0 2.0 3.0 TRUE
	WAIT 0
	GOSUB car_check
	GOSUB cam_death_check
	GOSUB phil_death_check
	
	//GOSUB plinkety_plonk
	GOSUB wait_state_loop
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -906.0 -341.0 12.5 30.0 30.0 10.0 FALSE
	//AND flag_wandering_psycho = 0
		ALTER_WANTED_LEVEL_NO_DROP player1 4
		PRINT_NOW ( IDIOT ) 5000 1 //That's right, just wander about dressed like a lunatic, IDIOT!
		GOTO mission_bankjob4_failed
	ENDIF
ENDWHILE

DO_FADE 1000 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

REQUEST_MODEL WFYBU
REQUEST_MODEL HFYBU
REQUEST_MODEL WMORI
//REQUEST_MODEL faketarget

WHILE NOT HAS_MODEL_LOADED WFYBU
OR NOT HAS_MODEL_LOADED HFYBU
OR NOT HAS_MODEL_LOADED WMORI
//OR NOT HAS_MODEL_LOADED faketarget
	WAIT 0
ENDWHILE

REQUEST_MODEL GDa
REQUEST_MODEL GDb
//REQUEST_MODEL faketarget

WHILE NOT HAS_MODEL_LOADED GDa
OR NOT HAS_MODEL_LOADED GDb
//OR NOT HAS_MODEL_LOADED faketarget
	WAIT 0
ENDWHILE

CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -904.7 -328.6 12.49 cashier1
SET_CHAR_HEADING cashier1 190.0
CLEAR_CHAR_THREAT_SEARCH cashier1
SET_CHAR_PERSONALITY cashier1 PEDSTAT_GEEK_GIRL
SET_CHAR_NEVER_TARGETTED cashier1 TRUE

CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -910.1 -328.6 12.49 cashier2
SET_CHAR_HEADING cashier2 190.0
CLEAR_CHAR_THREAT_SEARCH cashier2
SET_CHAR_PERSONALITY cashier2 PEDSTAT_GEEK_GIRL
SET_CHAR_NEVER_TARGETTED cashier2 TRUE

CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -912.5 -328.6 12.49 cashier3
SET_CHAR_HEADING cashier3 190.0
CLEAR_CHAR_THREAT_SEARCH cashier3
SET_CHAR_PERSONALITY cashier3 PEDSTAT_SENSIBLE_GIRL
SET_CHAR_NEVER_TARGETTED cashier3 TRUE

CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -907.5 -353.6 12.49 cashier4
SET_CHAR_HEADING cashier4 10.0
CLEAR_CHAR_THREAT_SEARCH cashier4
SET_CHAR_PERSONALITY cashier4 PEDSTAT_GEEK_GIRL
SET_CHAR_NEVER_TARGETTED cashier4 TRUE

CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -910.2 -353.6 12.49 cashier5
SET_CHAR_HEADING cashier5 10.0
CLEAR_CHAR_THREAT_SEARCH cashier5
SET_CHAR_PERSONALITY cashier5 PEDSTAT_SENSIBLE_GIRL
SET_CHAR_NEVER_TARGETTED cashier5 TRUE

CREATE_CHAR PEDTYPE_CIVFEMALE HFYBU -915.3 -353.6 12.49 cashier6
SET_CHAR_HEADING cashier6 10.0
CLEAR_CHAR_THREAT_SEARCH cashier6
SET_CHAR_PERSONALITY cashier6 PEDSTAT_GEEK_GIRL
SET_CHAR_NEVER_TARGETTED cashier6 TRUE

CREATE_CHAR PEDTYPE_CIVFEMALE WFYBU -920.36 -343.7 14.6 cashier7
SET_CHAR_HEADING cashier7 65.0
CLEAR_CHAR_THREAT_SEARCH cashier7
SET_CHAR_PERSONALITY cashier7 PEDSTAT_SENSIBLE_GIRL
SET_CHAR_NEVER_TARGETTED cashier7 TRUE

CREATE_CHAR PEDTYPE_CIVMALE WMORI -921.76 -345.15 12.49 cashier8
SET_CHAR_HEADING cashier8 310.0
CLEAR_CHAR_THREAT_SEARCH cashier8
SET_CHAR_PERSONALITY cashier8 PEDSTAT_SENSIBLE_GUY
SET_CHAR_NEVER_TARGETTED cashier8 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	GDa -917.3 -340.0 12.49 bank_cop_1
CLEAR_CHAR_THREAT_SEARCH bank_cop_1 
SET_CHAR_HEADING bank_cop_1 270.0
CHAR_SET_IDLE bank_cop_1
SET_CHAR_NEVER_TARGETTED bank_cop_1 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	GDb -908.0 -347.77 12.49 bank_cop_2
CLEAR_CHAR_THREAT_SEARCH bank_cop_2 
SET_CHAR_HEADING bank_cop_2 270.0
CHAR_SET_IDLE bank_cop_2
SET_CHAR_NEVER_TARGETTED bank_cop_2 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	GDa -919.14 -336.0 12.49 bank_cop_3
CLEAR_CHAR_THREAT_SEARCH bank_cop_3 
SET_CHAR_HEADING bank_cop_3 130.0
SET_CHAR_STAY_IN_SAME_PLACE bank_cop_3 TRUE
SET_CHAR_NEVER_TARGETTED bank_cop_3 TRUE
//CHAR_WANDER_DIR bank_cop_3 -1

GOTO selkirk
CREATE_CHAR PEDTYPE_CIVMALE	GDa -918.7 -353.3 16.8 bank_cop_6	// FOOLS COMPILER!!
DELETE_CHAR bank_cop_6
CREATE_CHAR PEDTYPE_CIVMALE WMORI -963.28 -337.12 14.6 bank_manager	// FOOLS COMPILER!!
DELETE_CHAR bank_manager
selkirk:

flag_waitstate_1 = 25 //ATM
flag_waitstate_2 = 19 //chat
flag_waitstate_3 = 21 //sit down

REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -896.5 -341.0 12.5 mission_blip

//ADD_SPHERE -896.5 -341.0 13.4 2.0 mission_blob	
//flag_bank_job = 1
 

SET_AREA_VISIBLE VIS_BANK
SWITCH_RUBBISH OFF
LOAD_SCENE -903.0 -341.0 13.4
flag_player_in_bank = 1
SET_EXTRA_COLOURS 4 FALSE

CLEAR_PRINTS
//REMOVE_SPHERE mission_blob
//flag_bank_job = 0
flag_player_in_bank = 1


SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PYTHON 24
SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_PYTHON 
//GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_PISTOL 600
CLEAR_AREA -890.0 -340.0 11.0 10.0 FALSE
//ADD_PEDS_IN_AREA_TO_COLL -911.8 -341.0 15.0 hostage_collective

SET_NEAR_CLIP 0.1

IF NOT IS_CHAR_DEAD phil
	LEAVE_GROUP phil
ENDIF
IF NOT IS_CHAR_DEAD cam
	LEAVE_GROUP cam
ENDIF
 
GOSUB gob_shite

flag_intro = 0
audio_slot = 1
//flag_player_on_bank_mission = 0

tha_inner:

	WAIT 0

	GOSUB wait_state_loop

	IF flag_intro = 0
		GET_GAME_TIMER timer_intro_start
		//DO_FADE 1000 FADE_OUT
		//WHILE GET_FADING_STATUS
		//	WAIT 0
		//ENDWHILE
		IF NOT IS_CHAR_DEAD scplayer
			SET_CHAR_COORDINATES scplayer -911.8 -341.0 12.5
			SET_CHAR_HEADING scplayer 90.0
		ENDIF
		IF NOT IS_CHAR_DEAD phil
			SET_CHAR_COORDINATES phil -909.8 -339.0 12.5
			SET_CHAR_HEALTH phil 100
			CHAR_SET_IDLE phil
		ENDIF
		IF NOT IS_CHAR_DEAD cam
			SET_CHAR_COORDINATES cam -909.55 -341.6 12.5
			SET_CHAR_HEALTH cam 100
			CHAR_SET_IDLE cam
		ENDIF
		SET_FIXED_CAMERA_POSITION -914.5 -341.1 12.7 0.0 0.0 0.0
		POINT_CAMERA_AT_PLAYER player1 FIXED 2
		flag_intro = 1
		LOAD_MISSION_AUDIO audio_slot BNK4_6
	ENDIF

	GOSUB bank_job_timer	
	
	GOSUB phil_death_check
	GOSUB cam_death_check
	IF flag_bank_mission_failed = 1
		GOTO botty_head
	ENDIF
	
	IF intro_time_lapsed > 1000	   
	AND flag_intro = 1
		IF NOT IS_CHAR_DEAD bank_cop_3
		AND NOT IS_CHAR_DEAD phil
			 TURN_CHAR_TO_FACE_CHAR	bank_cop_3 phil
			 TURN_CHAR_TO_FACE_CHAR	phil bank_cop_3 
			 //CHAR_LOOK_AT_CHAR_ALWAYS bank_cop_3 phil 
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_2
		AND NOT IS_CHAR_DEAD cam
			 TURN_CHAR_TO_FACE_CHAR	bank_cop_2 cam
			 TURN_CHAR_TO_FACE_CHAR	cam bank_cop_2
			 //CHAR_LOOK_AT_CHAR_ALWAYS bank_cop_2 cam 
		ENDIF
		DO_FADE 1000 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		flag_intro = 2
	ENDIF
	
	// ******* THIS IS A RAID!!!!
	IF intro_time_lapsed > 2000	   
	AND flag_intro = 2
		GOSUB audio_bank_loading
		IF NOT IS_CHAR_DEAD bank_cop_1
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR scplayer bank_cop_1
		ENDIF
		PRINT_NOW (BNK4_6) 3000 1 
		GOSUB has_audio_finished_bank
		LOAD_MISSION_AUDIO audio_slot BNK4_7
		flag_intro = 3
	ENDIF
   	
   	// *********** NO BODY MOVE!!!!!!!
	IF intro_time_lapsed > 3000	  
	AND flag_intro = 3
		flag_change_waitstate = 0
		flag_waitstate_1 = 0 // clear
		flag_waitstate_2 = 0
		flag_waitstate_3 = 0
		GOSUB wait_state_loop
		flag_change_waitstate = 0
		flag_waitstate_1 = 35 // Hands up!
		flag_waitstate_2 = 35
		flag_waitstate_3 = 35
		GOSUB wait_state_loop
		GOSUB audio_bank_loading
		IF NOT IS_CHAR_DEAD phil
		AND NOT IS_CHAR_DEAD bank_cop_3
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR phil bank_cop_3
		ENDIF
		IF NOT IS_CHAR_DEAD cam
		AND NOT IS_CHAR_DEAD bank_cop_2
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR cam bank_cop_2
		ENDIF

		PRINT_NOW (BNK4_7) 5000 1
		GOSUB has_audio_finished_bank
		LOAD_MISSION_AUDIO audio_slot BNK4_8
		flag_intro = 4
	ENDIF
	
	IF intro_time_lapsed > 4000	  
	AND flag_intro = 4
		flag_intro = 5
	ENDIF
	
	// *********** EVERYBODY UP AGAINST THE WALLS!!!!!!
	IF intro_time_lapsed > 5000	  
	AND flag_intro = 5
		GOSUB audio_bank_loading
		SET_FIXED_CAMERA_POSITION -908.8 -340.2 14.0 0.0 0.0 0.0
		IF NOT IS_CHAR_DEAD bank_cop_1
			POINT_CAMERA_AT_CHAR bank_cop_1 FIXED JUMP_CUT
		ENDIF
		PRINT_NOW (BNK4_8) 5000 1
		GOSUB has_audio_finished_bank
		LOAD_MISSION_AUDIO audio_slot BNK4_9
		flag_intro = 6
	ENDIF
	
	// *****************PEDS MOVE TO CORNER Pt1****************
	IF intro_time_lapsed > 6500	  
	AND flag_intro = 6
		SET_FIXED_CAMERA_POSITION -919.2 -330.0 18.75 0.0 0.0 0.0
		IF NOT IS_CHAR_DEAD scplayer
			POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT
		ENDIF
		flag_change_waitstate = 0
		flag_waitstate_1 = 0 
		flag_waitstate_2 = 0
		flag_waitstate_3 = 0 //wait state FALSE
		flag_intro = 7
	ENDIF

	// *****************PEDS MOVE TO CORNER Pt2****************	cashier1
	IF intro_time_lapsed > 7000	  
	AND flag_intro = 7
		IF NOT IS_CHAR_DEAD bank_cop_3
			SET_CHAR_OBJ_RUN_TO_COORD bank_cop_3 -923.0 -335.8
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_2
			SET_CHAR_OBJ_RUN_TO_COORD bank_cop_2 -923.0 -335.8
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_1
			SET_CHAR_OBJ_RUN_TO_COORD bank_cop_1 -923.0 -335.8
		ENDIF
		IF NOT IS_CHAR_DEAD cashier1
			SET_CHAR_OBJ_RUN_TO_COORD cashier1 -923.0 -335.8
		ENDIF
		IF NOT IS_CHAR_DEAD cashier2
			SET_CHAR_OBJ_RUN_TO_COORD cashier2 -923.0 -335.8
		ENDIF
		IF NOT IS_CHAR_DEAD cashier3
			SET_CHAR_OBJ_RUN_TO_COORD cashier3 -923.0 -335.8
		ENDIF
		IF NOT IS_CHAR_DEAD cashier4
			SET_CHAR_OBJ_RUN_TO_COORD cashier4 -918.2 -342.0
		ENDIF
		IF NOT IS_CHAR_DEAD cashier5
			SET_CHAR_OBJ_RUN_TO_COORD cashier5 -918.0 -344.0
		ENDIF
		IF NOT IS_CHAR_DEAD cashier6
			SET_CHAR_OBJ_RUN_TO_COORD cashier6 -917.8 -346.0
		ENDIF
		IF NOT IS_CHAR_DEAD cashier7
			SET_CHAR_OBJ_RUN_TO_COORD cashier7 -917.0 -345.0
		ENDIF
		IF NOT IS_CHAR_DEAD cashier8
			SET_CHAR_OBJ_RUN_TO_COORD cashier8 -917.0 -343.0
		ENDIF

		flag_intro = 8
	ENDIF
	
	IF intro_time_lapsed > 9000	  
	AND flag_intro = 8
		IF NOT IS_CHAR_DEAD bank_cop_3
			SET_CHAR_OBJ_NO_OBJ	bank_cop_3
			SET_CHAR_HEADING bank_cop_3 84.0
			CHAR_SET_IDLE bank_cop_3
			SET_CHAR_STAY_IN_SAME_PLACE bank_cop_3 TRUE
			SET_CHAR_COORDINATES bank_cop_3 -924.0 -339.6 12.4
			IF NOT IS_CHAR_DEAD phil
				SET_CHAR_COORDINATES phil -918.87 -336.2 12.4
				SET_CHAR_HEADING phil 146.0
				SET_CHAR_OBJ_AIM_GUN_AT_CHAR phil bank_cop_3
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_2
			SET_CHAR_OBJ_NO_OBJ	bank_cop_2
			SET_CHAR_HEADING bank_cop_2 93.0
			CHAR_SET_IDLE bank_cop_2
			SET_CHAR_STAY_IN_SAME_PLACE bank_cop_2 TRUE
			SET_CHAR_COORDINATES bank_cop_2 -923.5 -338.6 12.4
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_1
			SET_CHAR_OBJ_NO_OBJ	bank_cop_1
			SET_CHAR_HEADING bank_cop_1 90.0
			CHAR_SET_IDLE bank_cop_1
			SET_CHAR_STAY_IN_SAME_PLACE bank_cop_1 TRUE
			SET_CHAR_COORDINATES bank_cop_1 -923.0 -337.7 12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier1
			SET_CHAR_OBJ_NO_OBJ	cashier1
			SET_CHAR_HEADING cashier1 88.0
			CHAR_SET_IDLE cashier1
			SET_CHAR_STAY_IN_SAME_PLACE cashier1 TRUE
			SET_CHAR_COORDINATES cashier1 -923.4 -336.6	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier2
			SET_CHAR_OBJ_NO_OBJ	cashier2
			SET_CHAR_HEADING cashier2 98.0
			CHAR_SET_IDLE cashier2
			SET_CHAR_STAY_IN_SAME_PLACE cashier2 TRUE
			SET_CHAR_COORDINATES cashier2 -923.0 -335.6	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier3
			SET_CHAR_OBJ_NO_OBJ	cashier3
			SET_CHAR_HEADING cashier3 90.0
			CHAR_SET_IDLE cashier3
			SET_CHAR_STAY_IN_SAME_PLACE cashier3 TRUE
			SET_CHAR_COORDINATES cashier3 -923.8 -334.3	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier4
			SET_CHAR_OBJ_NO_OBJ	cashier4
			SET_CHAR_HEADING cashier4 82.0
			CHAR_SET_IDLE cashier4
			SET_CHAR_STAY_IN_SAME_PLACE cashier4 TRUE
			SET_CHAR_COORDINATES cashier4 -918.2 -342.0	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier5
			SET_CHAR_OBJ_NO_OBJ	cashier5
			SET_CHAR_HEADING cashier5 90.0
			CHAR_SET_IDLE cashier5
			SET_CHAR_STAY_IN_SAME_PLACE cashier5 TRUE
			SET_CHAR_COORDINATES cashier5 -918.0 -344.0	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier6
			SET_CHAR_OBJ_NO_OBJ	cashier6
			SET_CHAR_HEADING cashier6 93.0
			CHAR_SET_IDLE cashier6
			SET_CHAR_STAY_IN_SAME_PLACE cashier6 TRUE
			SET_CHAR_COORDINATES cashier6 -917.8 -346.0	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier7
			SET_CHAR_OBJ_NO_OBJ	cashier7
			SET_CHAR_HEADING cashier7 93.0
			CHAR_SET_IDLE cashier7
			SET_CHAR_STAY_IN_SAME_PLACE cashier7 TRUE
			SET_CHAR_COORDINATES cashier7 -917.0 -345.0	12.4
		ENDIF
		IF NOT IS_CHAR_DEAD cashier8
			SET_CHAR_OBJ_NO_OBJ	cashier8
			SET_CHAR_HEADING cashier8 93.0
			CHAR_SET_IDLE cashier8
			SET_CHAR_STAY_IN_SAME_PLACE cashier8 TRUE
			SET_CHAR_COORDINATES cashier8 -917.0 -343.0	12.4
			IF NOT IS_CHAR_DEAD cam
				SET_CHAR_COORDINATES cam -916.0 -340.0 12.4
				SET_CHAR_HEADING cam 120.0
				SET_CHAR_OBJ_AIM_GUN_AT_CHAR cam cashier8
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD scplayer
			SET_CHAR_COORDINATES scplayer -918.55 -337.8 13.5
			SET_CHAR_HEADING scplayer 80.0
		ENDIF
		SET_FIXED_CAMERA_POSITION -911.5 -344.0 15.0 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT -922.0 -344.295 13.94 JUMP_CUT
		flag_change_waitstate = 0
		flag_waitstate_1 = 35 // Hands up!
		flag_waitstate_2 = 35
		flag_waitstate_3 = 35
		GOSUB wait_state_loop
		flag_intro = 9
	ENDIF
	
	IF intro_time_lapsed > 11500	  
	AND flag_intro = 9
		SET_FIXED_CAMERA_POSITION -917.8 -329.8 15.8 0.0 0.0 0.0
		POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT
		GOSUB audio_bank_loading
		PRINT_NOW (BNK4_9) 5000 1
		GOSUB wait_state_loop
		GOSUB has_audio_finished_bank
		LOAD_MISSION_AUDIO audio_slot BNK4_10
		flag_intro = 10
	ENDIF

	IF intro_time_lapsed > 12000	  
	AND flag_intro = 10
		GOSUB audio_bank_loading
		PRINT_NOW (BNK4_10) 5000 1
		GOSUB has_audio_finished_bank
		LOAD_MISSION_AUDIO audio_slot BNK4_11
		flag_intro = 11
	ENDIF

	IF intro_time_lapsed > 14000	  
	AND flag_intro = 11
		/*
		IF NOT IS_CHAR_DEAD phil
			SET_CHAR_OBJ_NO_OBJ phil
			SET_CHAR_STAY_IN_SAME_PLACE phil FALSE
			SET_CHAR_OBJ_RUN_TO_COORD phil -908.0 -346.5
			SET_CHAR_THREAT_SEARCH phil THREAT_COP
		ENDIF
		*/
		GOSUB audio_bank_loading
		PRINT_NOW (BNK4_11) 5000 1
		GOSUB has_audio_finished_bank
		//LOAD_MISSION_AUDIO audio_slot BNK4_11
		flag_intro = 12
	ENDIF

	/*
	IF intro_time_lapsed > 9500
	AND flag_intro = 3
		DO_FADE 1000 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		GET_PLAYER_COORDINATES player1 player_x player_y player_z
		LOAD_SCENE player_x player_y player_z
		RESTORE_CAMERA_JUMPCUT
		SWITCH_WIDESCREEN off
		SET_PLAYER_CONTROL player1 on
		IF NOT IS_CAR_DEAD player_4x4
			LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
		ENDIF
		ALTER_WANTED_LEVEL player1 wanted_4x4
		DO_FADE 1000 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		SET_MUSIC_DOES_FADE TRUE
		flag_intro = 4
		flag_intro1_before = 1
	ENDIF
	*/
IF NOT flag_intro = 12
	 GOTO tha_inner
ENDIF


SET_CHAR_OBJ_NO_OBJ scplayer
STOP_CHAR_LOOKING scplayer
CHAR_SET_IDLE scplayer
CLEAR_CHAR_WAIT_STATE scplayer
SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN OFF
IF NOT IS_CHAR_DEAD phil
	LEAVE_GROUP phil
	SET_CHAR_RUNNING phil FALSE
	SET_CHAR_OBJ_NO_OBJ phil
ENDIF
IF NOT IS_CHAR_DEAD cam
	SET_CHAR_OBJ_NO_OBJ cam
	STOP_CHAR_LOOKING cam
	SET_PLAYER_AS_LEADER cam player1
	//SET_CHAR_THREAT_SEARCH cam THREAT_GANG_SECURITY
ENDIF
botty_head:
IF flag_bank_mission_failed = 1
	GOTO mission_bankjob4_failed
ENDIF

REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -938.56 -351.5 16.8 mission_blip


CREATE_CHAR PEDTYPE_CIVMALE	GDa -961.75 -329.1 14.6 bank_cop_4 // managers office & surveillance room
CLEAR_CHAR_THREAT_SEARCH bank_cop_4
SET_CHAR_THREAT_SEARCH bank_cop_4 THREAT_PLAYER1 
SET_CHAR_HEADING bank_cop_4 240.0
//SET_CHAR_CROUCH bank_cop_4 TRUE 9999
//CHAR_SET_IDLE bank_cop_4
GIVE_WEAPON_TO_CHAR bank_cop_4 WEAPONTYPE_MP5 9999

CREATE_CHAR PEDTYPE_CIVMALE	GDb -956.75 -340.4 14.6 bank_cop_5 // managers office & surveillance room
CLEAR_CHAR_THREAT_SEARCH bank_cop_5
SET_CHAR_THREAT_SEARCH bank_cop_5 THREAT_PLAYER1 
SET_CHAR_HEADING bank_cop_5 10.0
//SET_CHAR_CROUCH bank_cop_5 TRUE 9999
//CHAR_SET_IDLE bank_cop_5
GIVE_WEAPON_TO_CHAR bank_cop_5 WEAPONTYPE_MP5 9999

CREATE_CHAR PEDTYPE_CIVMALE	GDa -935.73 -348.3 16.8 bank_cop_7 // by the lift
CLEAR_CHAR_THREAT_SEARCH bank_cop_7
SET_CHAR_THREAT_SEARCH bank_cop_7 THREAT_PLAYER1 
SET_CHAR_HEADING bank_cop_7 266.0
SET_CHAR_CROUCH bank_cop_7 TRUE 300000
//CHAR_SET_IDLE bank_cop_5
GIVE_WEAPON_TO_CHAR bank_cop_7 WEAPONTYPE_MP5 9999

CREATE_CHAR PEDTYPE_CIVMALE	GDb -943.0 -343.9 6.3 bank_cop_8 // bank vault
CLEAR_CHAR_THREAT_SEARCH bank_cop_8
SET_CHAR_THREAT_SEARCH bank_cop_8 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH bank_cop_8 THREAT_SPECIAL
SET_CHAR_HEED_THREATS bank_cop_8 TRUE 
SET_CHAR_HEADING bank_cop_8 270.0
//SET_CHAR_CROUCH bank_cop_8 TRUE 9999
//CHAR_SET_IDLE bank_cop_8
GIVE_WEAPON_TO_CHAR bank_cop_8 WEAPONTYPE_MP5 9999

ADD_ROUTE_POINT 1 -943.0 -343.9 6.3
ADD_ROUTE_POINT 1 -934.8 -343.9 6.3
//ADD_ROUTE_POINT 1 -934.8 -351.7 6.3

SET_CHAR_OBJ_FOLLOW_ROUTE bank_cop_8 1 FOLLOW_ROUTE_LOOP
//SET_CHAR_USE_PEDNODE_SEEK bank_cop_8 FALSE

//REQUEST_MODEL bnk_lft_door1
//REQUEST_MODEL bnk_lft_door2

//LOAD_ALL_MODELS_NOW

//WHILE NOT HAS_MODEL_LOADED bnk_lft_door1  
//OR NOT HAS_MODEL_LOADED bnk_lft_door2
//	WAIT 0
//ENDWHILE

CREATE_OBJECT bnk_lft_door1 -936.964 -349.488 3.235 lift_door_1
CREATE_OBJECT bnk_lft_door2 -936.964 -353.369 3.235 lift_door_2

//CREATE_PICKUP_WITH_AMMO ModelIndex PickUpType Ammo X Y Z PickupID
CREATE_PICKUP health PICKUP_ONCE -959.3 -335.97 15.59 bank_health
CREATE_PICKUP bodyarmour PICKUP_ONCE -956.7 -337.64 15.6 bank_armour

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -938.56 -351.5 16.8 1.5 1.5 1.5 TRUE

	WAIT 0
	GOSUB stairs_cam
	GOSUB cam_death_check
	GOSUB phil_death_check
	GOSUB surveilance
	GOSUB wanted_malarkey
	GOSUB hostage_checker
	IF flag_cop_6 = 1
		GOSUB banK_manager_death_check
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 -942.5 -331.3 14.6 3.0 3.0 3.0 FALSE
		GOSUB wait_state_loop
		IF NOT IS_CHAR_DEAD bank_cop_5
			IF flag_cop_5 = 0
				SET_CHAR_OBJ_RUN_TO_COORD bank_cop_5 -952.8 -334.6
				flag_cop_5 = 1
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_5
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_4
			IF flag_cop_4 = 0
				SET_CHAR_OBJ_RUN_TO_COORD bank_cop_4 -956.8 -331.3
				flag_cop_4 = 1
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_4
		ENDIF
	ENDIF
	
	IF NOT IS_CHAR_DEAD bank_cop_4
	AND flag_cop_4 = 1
		IF LOCATE_CHAR_ON_FOOT_3D bank_cop_4 -956.8 -331.3 15.6 2.0 2.0 2.0 FALSE
			SET_CHAR_STAY_IN_SAME_PLACE bank_cop_4 TRUE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bank_cop_4 player1
			flag_cop_4 = 2
		ENDIF
	ENDIF
	
	IF flag_cop_6 = 1
		IF LOCATE_PLAYER_ON_FOOT_3D player1 -922.3 -333.0 17.8 3.0 3.0 1.5 FALSE
			GOSUB bank_job_timer
			IF intro_time_lapsed > rand_crouch_time
				IF NOT IS_CHAR_DEAD bank_cop_6
					SET_CHAR_CROUCH bank_cop_6 FALSE 0
					SET_CHAR_STAY_IN_SAME_PLACE bank_cop_6 TRUE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bank_cop_6 player1
				ENDIF
			ENDIF	
			IF intro_time_lapsed > 4000
				IF NOT IS_CHAR_DEAD bank_cop_6
					SET_CHAR_CROUCH bank_cop_6 TRUE 2000
					GET_GAME_TIMER timer_intro_start
					GENERATE_RANDOM_INT_IN_RANGE 0 4000 rand_crouch_time
				ENDIF
			ENDIF
			IF flag_cop_7 = 0
				IF NOT IS_CHAR_DEAD bank_cop_7
					SET_CHAR_OBJ_RUN_TO_COORD bank_cop_7 -923.7 -348.25
					flag_cop_7 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF	
	
	IF NOT IS_CHAR_DEAD bank_cop_7
	AND flag_cop_7 = 1
		IF LOCATE_CHAR_ON_FOOT_3D bank_cop_7 -923.7 -348.25 16.8 2.0 2.0 2.0 FALSE
			SET_CHAR_STAY_IN_SAME_PLACE bank_cop_7 TRUE
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bank_cop_7 player1
			flag_cop_7 = 2
		ENDIF
	ENDIF
	
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF

ENDWHILE

// ************************************** PLAYER GOING DOWN IN LIFT ***********************************

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 

IF NOT IS_CHAR_DEAD cam
	LEAVE_GROUP cam
	CHAR_FOLLOW_PATH cam -938.56 -351.5 16.8 0.5 RUN
	//SET_CHAR_OBJ_RUN_TO_COORD cam -938.56 -351.5
ENDIF

cunty:
IF NOT IS_CHAR_DEAD cam
	timera = 0
	WHILE NOT LOCATE_CHAR_ON_FOOT_3D cam -938.56 -351.5 16.8 1.5 1.5 3.0 FALSE
		WAIT 0
		IF timera > 2500
			IF NOT IS_CHAR_DEAD cam
				SET_CHAR_COORDINATES cam -932.9 -351.3 16.8
				SET_CHAR_HEADING cam 90.0
				CHAR_FOLLOW_PATH cam -938.56 -351.5 16.8 0.5 RUN
				//SET_CHAR_OBJ_RUN_TO_COORD cam -938.56 -351.5
			ENDIF
			timera = 0
		ENDIF
		IF IS_CHAR_DEAD cam
			GOTO cunty
		ENDIF
	ENDWHILE
ELSE
	PRINT_NOW C_DEAD 5000 1 //"cam's dead"
	GOTO mission_bankjob4_failed
ENDIF

IF NOT IS_CHAR_DEAD cam
	SET_CHAR_STAY_IN_SAME_PLACE	cam TRUE
	SET_CHAR_OBJ_NO_OBJ cam
ENDIF

aaarrrgghh:

GOSUB going_down_pt1
 
IF NOT IS_CHAR_DEAD cam
	SET_CHAR_COORDINATES cam -939.1 -351.12 6.23
	SET_CHAR_HEADING cam 260.0
	SET_PLAYER_AS_LEADER cam player1
ENDIF

IF NOT IS_CHAR_DEAD bank_cop_8
	SET_CHAR_COORDINATES bank_cop_8 -943.0 -343.9 6.3 
	SET_CHAR_OBJ_FOLLOW_ROUTE bank_cop_8 1 FOLLOW_ROUTE_LOOP
	SET_CHAR_THREAT_SEARCH bank_cop_8 THREAT_PLAYER1
ENDIF

GOSUB going_down_pt2


IF NOT IS_CHAR_DEAD cam
	SET_CHAR_STAY_IN_SAME_PLACE	cam FALSE
ENDIF

// ***************************************************************************************************

REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -944.5 -341.58 6.3 mission_blip

flag_cam_downstairs = 1

WHILE NOT IS_CHAR_DEAD bank_cop_8
	WAIT 0
	GOSUB cam_death_check
	GOSUB wanted_malarkey
	GOSUB banK_manager_death_check
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -944.5 -341.58 6.3 1.0 1.0 1.5 TRUE
	WAIT 0
	GOSUB cam_death_check
	GOSUB wanted_malarkey
	GOSUB banK_manager_death_check
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE

REMOVE_BLIP mission_blip

// ************************** CAM INSPECTS VAULT ********************************

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 
SWITCH_WIDESCREEN ON

TURN_CHAR_TO_FACE_COORD scplayer -944.5 -344.12	8.0

SET_FIXED_CAMERA_POSITION -940.2 -343.6 8.6 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -944.5 -343.8 7.45 JUMP_CUT

IF NOT IS_CHAR_DEAD cam
	LEAVE_GROUP cam
	SET_CHAR_OBJ_RUN_TO_COORD cam -944.5 -344.12
ENDIF

labia:
IF NOT IS_CHAR_DEAD cam
	timera = 0
	WHILE NOT LOCATE_CHAR_ON_FOOT_3D cam -944.5 -344.12 7.0 1.5 1.5 3.0 FALSE
		WAIT 0
		IF timera > 2000
			IF NOT IS_CHAR_DEAD cam
//				IF NOT IS_CHAR_ON_SCREEN cam
					SET_CHAR_COORDINATES cam -937.0 -343.6 7.0
					SET_CHAR_HEADING cam 90.0
					SET_CHAR_OBJ_RUN_TO_COORD cam -944.5 -344.12
//				ENDIF
			ENDIF
			timera = 0
		ENDIF
		IF IS_CHAR_DEAD cam
			GOTO labia
		ENDIF
	ENDWHILE
ELSE
	PRINT_NOW C_DEAD 5000 1 //"~r~Phil died!"
	GOTO mission_bankjob4_failed
ENDIF
	



IF NOT IS_CHAR_DEAD cam
	SET_CHAR_HEADING cam 90.0
	SET_CHAR_CROUCH	cam TRUE 300000
	TURN_CHAR_TO_FACE_CHAR scplayer cam
ENDIF


audio_slot = 1
LOAD_MISSION_AUDIO audio_slot BK4_12a
GOSUB audio_bank_loading
PRINT_NOW ( BK4_12a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BK4_12b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_12b ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BK4_12c
GOSUB audio_bank_loading
PRINT_NOW ( BK4_12c ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD cam
	SET_CHAR_CROUCH	cam FALSE 0
ENDIF

LOAD_MISSION_AUDIO audio_slot BNK4_13
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_13 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
CLEAR_PRINTS

SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF 
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

//WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -937.84 -351.73 6.23 1.5 1.6 1.5 FALSE
REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -964.0 -335.0 14.6 mission_blip

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -939.84 -351.73 6.23 1.5 1.5 1.5 FALSE
	WAIT 0
	GOSUB cam_death_check
	GOSUB wanted_malarkey
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE

// ********************************* PLAYER GOING UP IN LIFT TO FIND BANK MANAGER **********************

GOSUB going_up
GOSUB wait_state_loop
// ******************************************************************************************************

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -964.0 -337.0 14.6 3.0 3.0 3.0 FALSE
	WAIT 0
	GOSUB stairs_cam
	GOSUB cam_death_check
	GOSUB phil_death_check
	GOSUB surveilance
	GOSUB wanted_malarkey
	GOSUB banK_manager_death_check
	GOSUB hostage_checker

	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 -922.3 -348.2 16.6 3.0 3.0 3.0 FALSE
	AND flag_dialogue = 0
		audio_slot = 1
		LOAD_MISSION_AUDIO audio_slot BK4_14b
		GOSUB audio_bank_loading
		PRINT_NOW ( BK4_14a ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank

		LOAD_MISSION_AUDIO audio_slot BNK4_15
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_15 ) 10000 1 //Sure, everything's real quiet (text has a typo).
		GOSUB has_audio_finished_bank
		CLEAR_PRINTS
		flag_dialogue = 1
	ENDIF

ENDWHILE
flag_dialogue = 0

// ********************** PLAYER GETS MANAGER ********************************

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 
SWITCH_WIDESCREEN ON
IF NOT IS_CHAR_DEAD	bank_manager
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR scplayer bank_manager
	SET_FIXED_CAMERA_POSITION -961.3 -330.8 16.6 0.0 0.0 0.0
	POINT_CAMERA_AT_CHAR bank_manager FIXED INTERPOLATION
ENDIF

audio_slot = 1
LOAD_MISSION_AUDIO audio_slot BNK4_16
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_16 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD	bank_manager
	SET_CHAR_CROUCH bank_manager FALSE 0
	CLEAR_CHAR_THREAT_SEARCH bank_manager
	TURN_CHAR_TO_FACE_CHAR bank_manager scplayer
	SET_CHAR_WAIT_STATE bank_manager 17 300000
ENDIF

LOAD_MISSION_AUDIO audio_slot BNK4_17
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_17 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
CLEAR_PRINTS

IF NOT IS_CHAR_DEAD	bank_manager
	SET_CHAR_WAIT_STATE bank_manager 0 0
	SET_PLAYER_AS_LEADER bank_manager player1
ENDIF

SET_CHAR_OBJ_NO_OBJ scplayer
STOP_CHAR_LOOKING scplayer
CHAR_SET_IDLE scplayer
CLEAR_CHAR_WAIT_STATE scplayer

SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF 
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA


// ************* PLAYER MUST TAKE MANAGER TO VAULT ****************************
REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -944.36 -342.0 6.3 mission_blip

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -938.56 -351.5 16.8 1.5 1.5 1.5 TRUE

	WAIT 0
	GOSUB stairs_cam
	GOSUB surveilance
	GOSUB wanted_malarkey
	GOSUB cam_death_check
	GOSUB phil_death_check
	GOSUB banK_manager_death_check
	GOSUB hostage_checker

	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	
	IF LOCATE_PLAYER_ON_FOOT_3D player1 -922.3 -348.3 17.8 3.0 3.0 3.0 FALSE
	AND flag_dialogue = 0
		audio_slot = 1
		LOAD_MISSION_AUDIO audio_slot BNK4_18
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_18 ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		flag_dialogue = 1
	ENDIF
ENDWHILE

// ************************************** PLAYER GOING DOWN IN LIFT WITH MANAGER ***********************************

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 

IF NOT IS_CHAR_DEAD bank_manager
	LEAVE_GROUP bank_manager
	CHAR_FOLLOW_PATH bank_manager -938.56 -351.5 16.8 0.5 RUN
ENDIF

ooooogggg:
IF NOT IS_CHAR_DEAD bank_manager
	timera = 0
	WHILE NOT LOCATE_CHAR_ON_FOOT_3D bank_manager -938.56 -351.5 16.8 1.5 1.5 3.0 FALSE
		WAIT 0
		IF timera > 2500
			IF NOT IS_CHAR_DEAD bank_manager
//				IF NOT IS_CHAR_ON_SCREEN bank_manager
					SET_CHAR_COORDINATES bank_manager -932.9 -351.3 16.8
					SET_CHAR_HEADING bank_manager 90.0
					CHAR_FOLLOW_PATH bank_manager -938.56 -351.5 16.8 0.5 RUN
					//SET_CHAR_OBJ_RUN_TO_COORD bank_manager -938.56 -351.5
//				ENDIF
			ENDIF
			timera = 0
		ENDIF
		IF IS_CHAR_DEAD bank_manager
			GOTO ooooogggg
		ENDIF
	ENDWHILE
ELSE
	PRINT_NOW BM_DEAD 5000 1 //"bank manager dead"
	GOTO mission_bankjob4_failed
ENDIF

IF NOT IS_CHAR_DEAD bank_manager
	SET_CHAR_STAY_IN_SAME_PLACE	bank_manager TRUE
	SET_CHAR_OBJ_NO_OBJ bank_manager
ENDIF

GOSUB going_down_pt1

IF NOT IS_CHAR_DEAD bank_manager
	SET_CHAR_COORDINATES bank_manager -939.1 -351.12 6.23
	SET_CHAR_HEADING bank_manager 260.0
	SET_PLAYER_AS_LEADER bank_manager player1
ENDIF

GOSUB going_down_pt2

IF NOT IS_CHAR_DEAD bank_manager
	SET_CHAR_STAY_IN_SAME_PLACE	bank_manager FALSE
ENDIF
 

// ***************************************************************************************************

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -944.5 -341.58 6.3 1.0 1.0 1.5 TRUE
	WAIT 0
	GOSUB cam_death_check
	GOSUB banK_manager_death_check
	GOSUB wanted_malarkey
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE


// ************** MANAGER, CAM AND PLAYER AT VAULT *************************************************

REMOVE_BLIP mission_blip

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 
SWITCH_WIDESCREEN ON

//TURN_CHAR_TO_FACE_COORD scplayer -944.5 -344.12	8.0

SET_FIXED_CAMERA_POSITION -940.2 -343.6 8.6 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -944.5 -343.8 7.45 JUMP_CUT

IF NOT IS_CHAR_DEAD cam
AND NOT IS_CHAR_DEAD bank_manager
	TURN_CHAR_TO_FACE_CHAR cam bank_manager
	CHAR_LOOK_AT_CHAR_ALWAYS cam bank_manager
ENDIF

IF NOT IS_CHAR_DEAD bank_manager
	LEAVE_GROUP bank_manager
	CLEAR_CHAR_THREAT_SEARCH bank_manager
	SET_CHAR_OBJ_RUN_TO_COORD bank_manager -943.68 -343.47
ENDIF


aaaagggg:
IF NOT IS_CHAR_DEAD bank_manager
	timera = 0
	WHILE NOT LOCATE_CHAR_ON_FOOT_3D bank_manager -943.5 -343.5 6.2 1.5 1.5 3.0 FALSE
		WAIT 0
		IF timera > 2500
			IF NOT IS_CHAR_DEAD bank_manager
//				IF NOT IS_CHAR_ON_SCREEN bank_manager
					SET_CHAR_COORDINATES bank_manager -937.0 -343.5 6.2
					SET_CHAR_HEADING bank_manager 90.0
					SET_CHAR_OBJ_RUN_TO_COORD bank_manager -943.68 -343.47
//				ENDIF
			ENDIF
			timera = 0
		ENDIF
		IF IS_CHAR_DEAD bank_manager
			GOTO aaaagggg
		ENDIF
	ENDWHILE
ELSE
	PRINT_NOW BM_DEAD 5000 1 //"bank manager dead"
	GOTO mission_bankjob4_failed
ENDIF


IF NOT IS_CHAR_DEAD bank_manager
	SET_CHAR_STAY_IN_SAME_PLACE bank_manager TRUE
	SET_CHAR_HEADING bank_manager 90.0
	TURN_CHAR_TO_FACE_CHAR scplayer bank_manager
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR scplayer bank_manager
	//SET_CHAR_COORDINATES bank_manager world_x world_y world_z
	//world_z = world_z + 1.0 
	//SET_CHAR_WAIT_STATE bank_manager 17 300000
ENDIF


audio_slot = 1
LOAD_MISSION_AUDIO audio_slot BK4_19a
GOSUB audio_bank_loading
PRINT_NOW ( BK4_19a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BK4_19b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_19b ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

//DELETE_CHAR bank_manager

IF NOT IS_CHAR_DEAD cam
AND NOT IS_CHAR_DEAD scplayer
AND NOT IS_CHAR_DEAD bank_manager
	TURN_CHAR_TO_FACE_CHAR cam scplayer
	//CHAR_LOOK_AT_CHAR_ALWAYS cam bank_manager
	
	//GET_CHAR_COORDINATES bank_manager world_x world_y world_z
	//world_z = world_z + 0.5
	//SET_FIXED_CAMERA_POSITION world_x world_y world_z 0.0 0.0 0.0
	
	SET_FIXED_CAMERA_POSITION -943.0 -343.6 7.9 0.0 0.0 0.0
	SET_CHAR_COORDINATES bank_manager -941.0 -345.2 6.23
	GET_CHAR_COORDINATES cam world_x world_y world_z
	world_z = world_z + 0.6 
	POINT_CAMERA_AT_POINT world_x world_y world_z JUMP_CUT
	SET_NEAR_CLIP 0.02
	//SET_CHAR_WAIT_STATE bank_manager 19 300000 // CHAT
ENDIF

LOAD_MISSION_AUDIO audio_slot BK4_20a
GOSUB audio_bank_loading
PRINT_NOW ( BK4_20a ) 10000 1// Hell, I can bypass the time lock,
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD cam
AND NOT IS_CHAR_DEAD bank_manager
	STOP_CHAR_LOOKING cam
	SET_CHAR_COORDINATES bank_manager -941.8 -342.9 6.23
	TURN_CHAR_TO_FACE_CHAR cam bank_manager
	CHAR_LOOK_AT_CHAR_ALWAYS cam bank_manager
ENDIF

LOAD_MISSION_AUDIO audio_slot BK4_20b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_20b ) 10000 1// Then we just need your key code and we're good!
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD cam
AND NOT IS_CHAR_DEAD scplayer
	STOP_CHAR_LOOKING cam
	//TURN_CHAR_TO_FACE_CHAR cam scplayer
	//CHAR_LOOK_AT_CHAR_ALWAYS cam scplayer
	SET_CHAR_WAIT_STATE cam 0 0 // NONE
ENDIF

IF NOT IS_CHAR_DEAD scplayer
	GET_CHAR_COORDINATES scplayer world_x world_y world_z
	world_z = world_z + 0.6 
ENDIF
IF NOT IS_CHAR_DEAD bank_manager
	SET_CHAR_COORDINATES bank_manager -942.37 -345.2 6.23
ENDIF
	
POINT_CAMERA_AT_POINT world_x world_y world_z INTERPOLATION
//SET_CHAR_WAIT_STATE bank_manager 19 300000 // CHAT


LOAD_MISSION_AUDIO audio_slot BNK4_21
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_21 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
/*
LOAD_MISSION_AUDIO audio_slot BNK422A
GOSUB audio_bank_loading
PRINT_NOW ( BNK422A ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD cam
	GET_CHAR_COORDINATES cam world_x world_y world_z
	world_z = world_z + 0.6 
ENDIF	

POINT_CAMERA_AT_POINT world_x world_y world_z INTERPOLATION
//SET_CHAR_WAIT_STATE bank_manager 19 300000 // CHAT


LOAD_MISSION_AUDIO audio_slot BK4_23b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_23a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
IF NOT IS_CHAR_DEAD scplayer
	GET_CHAR_COORDINATES scplayer world_x world_y world_z
	world_z = world_z + 0.6 
ENDIF	

POINT_CAMERA_AT_POINT world_x world_y world_z INTERPOLATION
*/

LOAD_MISSION_AUDIO audio_slot BK4_24a
GOSUB audio_bank_loading
PRINT_NOW ( BK4_24a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
CLEAR_PRINTS

SET_CHAR_OBJ_NO_OBJ scplayer
STOP_CHAR_LOOKING scplayer
CHAR_SET_IDLE scplayer
CLEAR_CHAR_WAIT_STATE scplayer

IF NOT IS_CHAR_DEAD bank_manager
	SET_CHAR_COORDINATES bank_manager -943.0 -343.6 6.23
ENDIF

RESTORE_CAMERA_JUMPCUT
//SET_NEAR_CLIP 0.1
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF 
SWITCH_WIDESCREEN OFF

REMOVE_BLIP mission_blip
//IF NOT IS_CHAR_DEAD phil
//	ADD_BLIP_FOR_CHAR phil mission_blip
//ENDIF

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -939.84 -351.73 6.23 1.5 1.5 1.5 FALSE
	WAIT 0
	GOSUB cam_death_check
	GOSUB wanted_malarkey
	GOSUB banK_manager_death_check
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE

// ********************************* PLAYER GOING UP IN LIFT TO CHECK ON PHIL **********************

GOSUB going_up

GOSUB wait_state_loop
// ******************************************************************************************************

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -922.3 -348.3 17.8 3.0 3.0 3.0 FALSE
	WAIT 0
	//GOSUB cam_death_check
	//GOSUB banK_manager_death_check
	GOSUB phil_death_check
	GOSUB stairs_cam
	GOSUB surveilance
	GOSUB wanted_malarkey
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE

// *********************** ALARM GOES OFF, PHIL SHOOTS GUARD **********************************************

ALTER_WANTED_LEVEL_NO_DROP player1 3 

ADD_CONTINUOUS_SOUND -916.0 -340.0 15.0 SOUND_BANK_ALARM_LOOP bank_alarm
LOAD_MISSION_AUDIO audio_slot BK4_24b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_24b ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank
CLEAR_PRINTS

CREATE_CHAR PEDTYPE_CIVMALE	GDa -920.6 -340.0 13.4 target_ped
SET_CHAR_HEALTH target_ped 50
SET_CHAR_HEADING target_ped 270.0
SET_CHAR_OBJ_RUN_TO_COORD target_ped -902.0 -340.0 

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_OBJ_KILL_CHAR_ON_FOOT phil target_ped
	SET_CHAR_ACCURACY phil 80
ENDIF

WHILE NOT IS_CHAR_DEAD target_ped
	WAIT 0
	//GOSUB cam_death_check
	GOSUB phil_death_check
	GOSUB stairs_cam
	GOSUB surveilance
	//GOSUB wanted_malarkey
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
ENDWHILE

LOAD_MISSION_AUDIO audio_slot BNK4_25
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_25 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BNK4_27
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_27 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -907.8 -345.87 12.4 mission_blip

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -907.8 -345.87 12.4 1.5 1.5 1.5 TRUE
	WAIT 0
	//GOSUB cam_death_check
	//GOSUB banK_manager_death_check
	GOSUB stairs_cam
	GOSUB surveilance
	GOSUB phil_death_check
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	GOSUB hostage_checker
	IF NOT IS_CHAR_DEAD phil
		IF NOT IS_CHAR_ON_SCREEN phil
		AND flag_phil_warp = 0
			IF NOT IS_POINT_ON_SCREEN -917.6 -337.57 13.46 2.0
				SET_CHAR_COORDINATES phil -917.6 -337.57 13.46
				SET_CHAR_HEADING phil 272.0
				SET_CHAR_CROUCH phil TRUE 999999
				SET_CHAR_STAY_IN_SAME_PLACE phil TRUE
				flag_phil_warp = 1
			ENDIF
		ENDIF
	ENDIF
ENDWHILE

// ****************************** PLAYER IN POSITION ******************************************************

IF NOT IS_CHAR_DEAD phil
	LEAVE_GROUP phil
ENDIF


REMOVE_BLIP mission_blip
/*
IF NOT IS_CHAR_DEAD phil
	SET_CHAR_THREAT_SEARCH phil THREAT_COP
ENDIF
*/
CREATE_CHAR PEDTYPE_CIVMALE	GDa -897.0 -341.1 12.4 target_ped
SET_CHAR_STAY_IN_SAME_PLACE target_ped TRUE

IF NOT IS_CHAR_DEAD scplayer
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR scplayer target_ped
ENDIF


SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 
SWITCH_WIDESCREEN ON


SET_FIXED_CAMERA_POSITION -914.5 -347.25 15.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -902.2 -341.9 12.69 JUMP_CUT

LOAD_MISSION_AUDIO audio_slot BNK4_28
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_28 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD phil
	SET_FIXED_CAMERA_POSITION -915.8 -335.0 13.8 0.0 0.0 0.0
	POINT_CAMERA_AT_CHAR phil FIXED JUMP_CUT
ENDIF

LOAD_MISSION_AUDIO audio_slot BNK4_29
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_29 ) 10000 1//surrounded, ha hah ah .
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BNK4_30
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_30 ) 10000 1//crapping etc
IF NOT IS_CHAR_DEAD phil
AND NOT IS_CHAR_DEAD target_ped
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR phil target_ped
ENDIF
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD cam
	SET_CHAR_COORDINATES cam -920.0 -347.0 16.8
	SET_CHAR_HEADING cam 290.0
	SET_FIXED_CAMERA_POSITION -914.3 -345.25 15.8 0.0 0.0 0.0
	POINT_CAMERA_AT_CHAR cam FIXED JUMP_CUT
	flag_cam_downstairs = 0
ENDIF

LOAD_MISSION_AUDIO audio_slot BK4_31b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_31a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

SET_FIXED_CAMERA_POSITION -905.76 -345.84 14.0 0.0 0.0 0.0
POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT

LOAD_MISSION_AUDIO audio_slot BK4_34a
GOSUB audio_bank_loading
PRINT_NOW ( BK4_34a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

SET_FIXED_CAMERA_POSITION -914.5 -347.25 15.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -902.2 -341.9 12.69 JUMP_CUT

LOAD_MISSION_AUDIO audio_slot BK4_34b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_34b ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD phil
	SET_FIXED_CAMERA_POSITION -915.8 -335.0 13.8 0.0 0.0 0.0
	POINT_CAMERA_AT_CHAR phil FIXED JUMP_CUT
ENDIF

LOAD_MISSION_AUDIO audio_slot BK4_35a
GOSUB audio_bank_loading
PRINT_NOW ( BK4_35a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BK4_35b
GOSUB audio_bank_loading
PRINT_NOW ( BK4_35b ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD scplayer
	SET_CHAR_OBJ_NO_OBJ scplayer
	SET_CAMERA_BEHIND_PLAYER
ENDIF

SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF 
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_OBJ_NO_OBJ phil
	SET_CHAR_THREAT_SEARCH phil THREAT_COP
ENDIF

DELETE_CHAR target_ped
DELETE_CHAR bank_manager
// ********************************* SWAT STORM BANK!!! *************************************************
flag_phil_warp = 0
//REMOVE_SOUND bank_alarm

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_OBJ_NO_OBJ phil
	SET_CHAR_STAY_IN_SAME_PLACE phil TRUE
	SET_CHAR_HEALTH phil 200
	SET_CHAR_THREAT_SEARCH phil THREAT_COP
	SET_CHAR_HEED_THREATS phil TRUE
ENDIF

REQUEST_MODEL swat
REQUEST_MODEL gasgrenade

WHILE NOT HAS_MODEL_LOADED swat
OR NOT HAS_MODEL_LOADED gasgrenade
	WAIT 0
ENDWHILE

flag_waitstate_1 = 0
flag_waitstate_2 = 0
flag_waitstate_3 = 0
flag_change_waitstate = 0
GOSUB wait_state_loop
flag_waitstate_1 = 15
flag_waitstate_2 = 15
flag_waitstate_3 = 15
flag_change_waitstate = 0
GOSUB wait_state_loop
//GOSUB flee_bank


/*
-899.214 -333.656 21.233  grill_1
-899.214 -348.466 21.233  grill_2
-907.307 -336.618 23.987  grill_3
-907.307 -345.504 23.987  grill_4
-915.401 -336.6184 23.987 grill_5
-915.401 -345.50 23.987   grill_6
*/
SET_OBJECT_DYNAMIC grill_1 TRUE
//ADD_TO_OBJECT_VELOCITY grill_1 0.0 0.0 -0.1

SET_OBJECT_DYNAMIC grill_2 TRUE
//ADD_TO_OBJECT_VELOCITY grill_2 0.0 0.0 -0.1

SET_OBJECT_DYNAMIC grill_3 TRUE
//ADD_TO_OBJECT_VELOCITY grill_3 0.0 0.0 -0.1

SET_OBJECT_DYNAMIC grill_4 TRUE
//ADD_TO_OBJECT_VELOCITY grill_4 0.0 0.0 -0.1

SET_OBJECT_DYNAMIC grill_5 TRUE
//ADD_TO_OBJECT_VELOCITY grill_5 0.0 0.0 -0.1

SET_OBJECT_DYNAMIC grill_6 TRUE
//ADD_TO_OBJECT_VELOCITY grill_6 0.0 0.0 -0.1
			
SET_OBJECT_COLLISION grill_1 TRUE
SET_OBJECT_COLLISION grill_2 TRUE
SET_OBJECT_COLLISION grill_3 TRUE
SET_OBJECT_COLLISION grill_4 TRUE
SET_OBJECT_COLLISION grill_5 TRUE
SET_OBJECT_COLLISION grill_6 TRUE

audio_slot = 2
LOAD_MISSION_AUDIO audio_slot bloroof
GOSUB audio_bank_loading
GOSUB has_audio_finished_bank
audio_slot = 1


REMOVE_ROUTE 1
REMOVE_ROUTE 2

timera = 0

WHILE IS_PLAYER_PLAYING player1
//AND flag_cam_at_target < 2
	WAIT 0
	
	//SET_PLAYER_HEALTH player1 100

	GOSUB phil_death_check
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
		
	GOSUB surveilance
	GOSUB hostage_checker

	IF NOT IS_CHAR_DEAD phil
	AND flag_swat_rope > 1
		IF phils_target = 0
			GET_RANDOM_COP_IN_AREA -919.5 -329.8 -901.5 -351.45 0 1 0 0 0 target_ped1
			GET_RANDOM_COP_IN_AREA -919.5 -329.8 -901.5 -351.45 0 1 0 0 0 target_ped2
			GET_RANDOM_COP_IN_AREA -919.5 -329.8 -901.5 -351.45 0 1 0 0 0 target_ped3
			GET_RANDOM_COP_IN_AREA -919.5 -329.8 -901.5 -351.45 0 1 0 0 0 target_ped4
			phils_target = 1
		ELSE
			IF NOT IS_CHAR_DEAD target_ped1
				IF phils_target = 1
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT phil target_ped1
					phils_target = 2
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED target_ped1
				IF NOT IS_CHAR_DEAD target_ped2
					IF phils_target = 2
						SET_CHAR_OBJ_KILL_CHAR_ON_FOOT phil target_ped2
						phils_target = 3
					ENDIF
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED target_ped2
					IF NOT IS_CHAR_DEAD target_ped3
						IF phils_target = 3
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT phil target_ped3
							phils_target = 4
						ENDIF
					ELSE
						MARK_CHAR_AS_NO_LONGER_NEEDED target_ped3
						IF NOT IS_CHAR_DEAD target_ped4
							IF phils_target = 4
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT phil target_ped4
								phils_target = 5
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED target_ped4
							phils_target = 6
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	

	IF flag_grill_collision < 2
		GET_OBJECT_COORDINATES grill_3 warp_x warp_y warp_z
		IF flag_grill_collision = 0
		AND timera > 2000	
			DELETE_OBJECT bank_windows
			CREATE_OBJECT_NO_OFFSET rocketed_win1 -899.851 -341.061 14.318 bank_windows
			DONT_REMOVE_OBJECT bank_windows
			
			CREATE_OBJECT_NO_OFFSET gasgrenade -900.7 -333.88 14.73 gas_1
			SET_OBJECT_DYNAMIC gas_1 TRUE
			SET_OBJECT_COLLISION gas_1 TRUE
			ADD_TO_OBJECT_VELOCITY gas_1 -0.5 0.0 0.0
			//ADD_BLIP_FOR_OBJECT gas_3 test_blip1 // TEST TO COME OUT !!!!!
			
			CREATE_OBJECT_NO_OFFSET gasgrenade -900.7 -348.4 14.73 gas_2
			SET_OBJECT_DYNAMIC gas_2 TRUE
			SET_OBJECT_COLLISION gas_2 TRUE
			ADD_TO_OBJECT_VELOCITY gas_2 -0.5 0.0 0.0
			
			//ADD_BLIP_FOR_OBJECT gas_4 test_blip2 // TEST TO COME OUT !!!!!
			
			CREATE_OBJECT_NO_OFFSET gasgrenade -907.307 -336.618 18.0 gas_3
			SET_OBJECT_DYNAMIC gas_3 TRUE
			SET_OBJECT_COLLISION gas_3 TRUE
			
			//ADD_BLIP_FOR_OBJECT gas_3 test_blip1 // TEST TO COME OUT !!!!!
			
			CREATE_OBJECT_NO_OFFSET gasgrenade -907.307 -345.504 18.0 gas_4
			SET_OBJECT_DYNAMIC gas_4 TRUE
			SET_OBJECT_COLLISION gas_4 TRUE
			
			//ADD_BLIP_FOR_OBJECT gas_4 test_blip2 // TEST TO COME OUT !!!!!
			
			CREATE_OBJECT_NO_OFFSET gasgrenade -915.401 -336.6184 18.0 gas_5
			SET_OBJECT_DYNAMIC gas_5 TRUE
			SET_OBJECT_COLLISION gas_5 TRUE
			
			//ADD_BLIP_FOR_OBJECT gas_5 test_blip3 // TEST TO COME OUT !!!!!
			
			CREATE_OBJECT_NO_OFFSET gasgrenade -915.401 -345.50 18.0 gas_6
			SET_OBJECT_DYNAMIC gas_6 TRUE
			SET_OBJECT_COLLISION gas_6 TRUE

			//ADD_BLIP_FOR_OBJECT gas_6 test_blip4 // TEST TO COME OUT !!!!!

			flag_grill_collision = 1
			timerb = 0
		ENDIF
		/*
		IF warp_z < 20.0
		AND flag_grill_collision = 0
			SET_OBJECT_COLLISION grill_1 TRUE
			SET_OBJECT_COLLISION grill_2 TRUE
			SET_OBJECT_COLLISION grill_3 TRUE
			SET_OBJECT_COLLISION grill_4 TRUE
			SET_OBJECT_COLLISION grill_5 TRUE
			SET_OBJECT_COLLISION grill_6 TRUE
			flag_grill_collision = 1
		ENDIF
		*/
	ENDIF
	IF flag_grill_collision = 1
		IF timerb > 50
			timerb = 0
			GOSUB gas_canisters
		ENDIF
	ENDIF
	IF flag_swat_rope = 0
	AND timera > 2000
		CREATE_SWAT_ROPE -907.307 -336.618 26.0  
		CREATE_SWAT_ROPE -907.307 -345.504 26.0  
		CREATE_SWAT_ROPE -915.401 -336.6184 26.0 
		CREATE_SWAT_ROPE -915.401 -345.50 26.0   
		flag_swat_rope = 1
	ENDIF
	IF timera > 4000
	AND flag_swat_rope = 1
		/*
		DELETE_OBJECT bank_windows
		CREATE_OBJECT_NO_OFFSET rocketed_win1 -899.851 -341.061 14.318 bank_windows
		DONT_REMOVE_OBJECT bank_windows
		*/
		flag_swat_rope = 2
	ENDIF
	IF timera > 5000
	AND flag_swat_rope = 2
		//SET_OBJECT_DYNAMIC grill_1 TRUE
		CREATE_CHAR PEDTYPE_COP	swat -899.214 -333.656 23.0 swat_1
		SET_CHAR_HEADING swat_1 0.0
		GIVE_WEAPON_TO_CHAR swat_1 WEAPONTYPE_MP5 9999
		
		//SET_OBJECT_DYNAMIC grill_2 TRUE
		CREATE_CHAR PEDTYPE_COP	swat -899.214 -348.466 23.0 swat_2
		SET_CHAR_HEADING swat_2 180.0
		GIVE_WEAPON_TO_CHAR swat_2 WEAPONTYPE_MP5 9999

		IF NOT IS_CHAR_DEAD	cam
			SET_CHAR_OBJ_KILL_CHAR_ON_FOOT swat_1 cam
			SET_CHAR_OBJ_KILL_CHAR_ON_FOOT swat_2 cam
			ADD_ROUTE_POINT 1 -921.5 -347.1 17.0
			ADD_ROUTE_POINT 1 -923.0 -334.3 17.0
			ADD_ROUTE_POINT 1 -937.2 -333.8 15.0
			ADD_ROUTE_POINT 1 -935.0 -329.6 15.0
			ADD_ROUTE_POINT 1 -927.3 -328.5 13.0
			ADD_ROUTE_POINT 1 -921.1 -326.5 13.0
			ADD_ROUTE_POINT 1 -920.7 -339.0 13.0
			ADD_ROUTE_POINT 1 -910.6 -346.6 13.0
			SET_CHAR_OBJ_FOLLOW_ROUTE cam 1 FOLLOW_ROUTE_ONCE
			SET_CHAR_USE_PEDNODE_SEEK cam FALSE
			SET_CHAR_THREAT_SEARCH cam THREAT_COP
		ENDIF
		flag_swat_rope = 3
	ENDIF
	IF NOT IS_CHAR_DEAD cam
		GET_CHAR_COORDINATES cam world_x world_y world_z // getting coords to create pickup if he dies
		GET_PLAYER_COORDINATES player1 player_x player_y player_z
		IF flag_cam_at_target = 0
			IF LOCATE_CHAR_ON_FOOT_3D cam player_x player_y player_z 5.0 5.0 2.0 FALSE
			OR LOCATE_CHAR_ON_FOOT_3D cam -910.6 -346.6 13.0 10.0 10.0 2.0 FALSE
				SET_CHAR_OBJ_NO_OBJ cam
				//SET_CHAR_STAY_IN_SAME_PLACE cam TRUE
				//SET_CHAR_HEADING cam 340.0
				SET_CHAR_THREAT_SEARCH cam THREAT_COP
				SET_CHAR_HEED_THREATS cam TRUE
				SET_PLAYER_AS_LEADER cam player1
				flag_cam_at_target = 1
			ENDIF
		ENDIF
	ELSE
		IF flag_cam_dead = 0
			MARK_CHAR_AS_NO_LONGER_NEEDED cam
			PRINT_NOW C_DEAD 5000 1 //Cam's dead!
			CREATE_PICKUP briefcase PICKUP_ONCE world_x world_y world_z retirement 
			REMOVE_BLIP mission_blip
			ADD_BLIP_FOR_PICKUP retirement mission_blip
			flag_cam_dead = 1
			flag_cam_at_target = 0
		ENDIF
	ENDIF
	IF flag_cam_dead = 1
		IF HAS_PICKUP_BEEN_COLLECTED retirement
		AND flag_cam_at_target < 2
			flag_cam_at_target = 1
		ENDIF
	ENDIF
	IF flag_cam_at_target = 1
		IF phils_target = 6
			LOAD_MISSION_AUDIO audio_slot BNK4_38
			GOSUB audio_bank_loading
			PRINT_NOW ( BNK4_38 ) 10000 1//rhubarb rhubarb
			GOSUB has_audio_finished_bank
			IF NOT IS_CHAR_DEAD phil
				SET_CHAR_CROUCH phil FALSE 0
				SET_PLAYER_AS_LEADER phil player1
			ENDIF
			REMOVE_BLIP mission_blip
			ADD_BLIP_FOR_COORD -900.0 -341.0 13.4 mission_blip
			flag_cam_at_target = 2
		ENDIF
	ENDIF
	IF flag_cam_at_target = 2
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -900.0 -341.0 13.4 1.4 1.4 3.0 TRUE
			GOTO outside_the_bank
		ENDIF
	ENDIF
		
//	IF flag_grill_collision > 1
//		GET_OBJECT_COORDINATES gas_3 warp_x warp_y warp_z
//		IF LOCATE_PLAYER_ANY_MEANS_3D player1 warp_x warp_y warp_z 10.0 10.0 10.0 TRUE
//		ENDIF
//	ENDIF
ENDWHILE


// *********************************** MAKE BREAK FOR THE DOOR !!! *******************************************
// 88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
// ***********************************************************************************************************

outside_the_bank:

//ADD_SPHERE -900.0 -340.9 13.4 2.0 mission_blob	
//flag_bank_job = 1
//flag_player_on_bank_mission = 1
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 
SWITCH_WIDESCREEN ON

GOSUB exit_bank

// ******************************************************* OUTSIDE *******************************************
// 88888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888888
// ***********************************************************************************************************

SWITCH_PED_ROADS_OFF -956.0 -355.0 5.0 -898.0 -328.0 25.0 //bank interior
SWITCH_PED_ROADS_OFF -877.0 -368.0 5.0 -832.0 -317.0 25.0 //side walks outside bank

REMOVE_BLIP mission_blip
//REMOVE_SPHERE mission_blob


CLEAR_AREA -863.0 -340.9 12.19 30.0 TRUE
GOSUB delete_routine
SET_FIXED_CAMERA_POSITION -889.57 -341.42 15.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -894.3 -346.0 13.4 JUMP_CUT 

SET_CHAR_COORDINATES scplayer -892.1 -349.47 12.0
SET_CHAR_HEADING scplayer 12.0
SET_CHAR_CROUCH scplayer TRUE 999999
flag_player_in_bank = 0

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_OBJ_NO_OBJ phil
	SET_CHAR_COORDINATES phil -892.8 -349.37 12.7
	SET_CHAR_HEADING phil 317.0
	SET_CHAR_CROUCH phil TRUE 999999
ENDIF
IF NOT IS_CHAR_DEAD cam
	SET_CHAR_OBJ_NO_OBJ cam
	SET_CHAR_COORDINATES cam -894.3 -349.5 12.5
	SET_CHAR_HEADING cam 330.0
	SET_CHAR_CROUCH cam TRUE 999999
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED cam
	flag_cam_dead = 1
ENDIF

REQUEST_MODEL enforcer
WHILE NOT HAS_MODEL_LOADED enforcer
	WAIT 0
ENDWHILE
	
IF NOT IS_CHAR_DEAD phil
	POINT_CAMERA_AT_CHAR phil FIXED JUMP_CUT
ENDIF

CREATE_CHAR PEDTYPE_CIVMALE	swat -875.9 -334.0 10.3 bank_cop_1
CLEAR_CHAR_THREAT_SEARCH bank_cop_1 
SET_CHAR_HEADING bank_cop_1 137.0
GIVE_WEAPON_TO_CHAR bank_cop_1 WEAPONTYPE_MP5 9999
SET_CHAR_CROUCH bank_cop_1 TRUE 9999 
SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_1 player1
SET_CHAR_STAY_IN_SAME_PLACE bank_cop_1 TRUE
//SET_CHAR_THREAT_SEARCH bank_cop_1 THREAT_PLAYER1
//SET_CHAR_HEED_THREATS bank_cop_1 TRUE
 

CREATE_CHAR PEDTYPE_CIVMALE	swat -876.39 -347.45 10.3 bank_cop_2
CLEAR_CHAR_THREAT_SEARCH bank_cop_2 
SET_CHAR_HEADING bank_cop_2 130.0
GIVE_WEAPON_TO_CHAR bank_cop_2 WEAPONTYPE_MP5 9999
SET_CHAR_CROUCH bank_cop_2 TRUE 9999 
SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_2 player1
SET_CHAR_STAY_IN_SAME_PLACE bank_cop_2 TRUE
//SET_CHAR_THREAT_SEARCH bank_cop_2 THREAT_PLAYER1
//SET_CHAR_HEED_THREATS bank_cop_2 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	swat -864.6 -341.0 9.9 bank_cop_3
CLEAR_CHAR_THREAT_SEARCH bank_cop_3 
SET_CHAR_HEADING bank_cop_3 95.0
GIVE_WEAPON_TO_CHAR bank_cop_3 WEAPONTYPE_MP5 9999
SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_3 player1
SET_CHAR_STAY_IN_SAME_PLACE bank_cop_3 TRUE
//SET_CHAR_THREAT_SEARCH bank_cop_3 THREAT_PLAYER1
//SET_CHAR_HEED_THREATS bank_cop_3 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	swat -868.4 -339.98 9.9 bank_cop_4
CLEAR_CHAR_THREAT_SEARCH bank_cop_4 
SET_CHAR_HEADING bank_cop_4 90.0
GIVE_WEAPON_TO_CHAR bank_cop_4 WEAPONTYPE_MP5 9999
SET_CHAR_CROUCH bank_cop_4 TRUE 9999 
SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_4 player1
SET_CHAR_STAY_IN_SAME_PLACE bank_cop_4 TRUE
//SET_CHAR_THREAT_SEARCH bank_cop_4 THREAT_PLAYER1
//SET_CHAR_HEED_THREATS bank_cop_4 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	swat -856.3 -294.7 10.1 bank_cop_5
CLEAR_CHAR_THREAT_SEARCH bank_cop_5 
SET_CHAR_HEADING bank_cop_5 167.0
GIVE_WEAPON_TO_CHAR bank_cop_5 WEAPONTYPE_MP5 9999
SET_CHAR_CROUCH bank_cop_5 TRUE 9999 
//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_5 player1
//SET_CHAR_STAY_IN_SAME_PLACE bank_cop_5 TRUE
SET_CHAR_THREAT_SEARCH bank_cop_5 THREAT_PLAYER1
SET_CHAR_HEED_THREATS bank_cop_5 TRUE

CREATE_CHAR PEDTYPE_CIVMALE	swat -852.1 -304.3 10.1 bank_cop_6
CLEAR_CHAR_THREAT_SEARCH bank_cop_6 
SET_CHAR_HEADING bank_cop_6 140.0
GIVE_WEAPON_TO_CHAR bank_cop_6 WEAPONTYPE_MP5 9999
SET_CHAR_CROUCH bank_cop_6 TRUE 9999 
//SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_6 player1
//SET_CHAR_STAY_IN_SAME_PLACE bank_cop_6 TRUE
SET_CHAR_THREAT_SEARCH bank_cop_6 THREAT_PLAYER1
SET_CHAR_HEED_THREATS bank_cop_6 TRUE

CREATE_CAR enforcer -870.0 -344.5 10.2 cop_car1
SET_CAR_HEADING cop_car1 124.0
LOCK_CAR_DOORS cop_car1 CARLOCK_UNLOCKED

CREATE_CAR enforcer -869.43 -336.3 10.2 cop_car2
SET_CAR_HEADING cop_car2 43.0
LOCK_CAR_DOORS cop_car2 CARLOCK_UNLOCKED

CREATE_CAR enforcer -852.73 -298.3 10.2 cop_car3
SET_CAR_HEADING cop_car3 30.0
LOCK_CAR_DOORS cop_car3 CARLOCK_UNLOCKED

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

//flag_bank_job = 0

IF flag_cam_dead = 1
	LOAD_MISSION_AUDIO audio_slot BNK4_36
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_36 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank

	POINT_CAMERA_AT_CHAR scplayer FIXED JUMP_CUT
	
	LOAD_MISSION_AUDIO audio_slot BNK4_37
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_37 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank
ENDIF
	

LOAD_MISSION_AUDIO audio_slot BNK_39
GOSUB audio_bank_loading
PRINT_NOW ( BNK_39 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

SET_FIXED_CAMERA_POSITION -888.25 -341.4 13.9 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -863.0 -340.9 12.19 JUMP_CUT

//IF flag_cam_dead = 1
	LOAD_MISSION_AUDIO audio_slot BK4_40a
	GOSUB audio_bank_loading
	PRINT_NOW ( BK4_40a ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank
/*
ELSE
	LOAD_MISSION_AUDIO audio_slot BK4_40b
	GOSUB audio_bank_loading
	PRINT_NOW ( BK4_40a ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank
ENDIF 
*/

IF NOT IS_CAR_DEAD getaway_car
	SET_CAR_COORDINATES getaway_car -884.1 -311.3 10.8
	SET_CAR_HEADING getaway_car 180.0
	SET_CAR_HEALTH getaway_car 1000
	LOCK_CAR_DOORS getaway_car CARLOCK_UNLOCKED
ENDIF

DELETE_CHAR hilary


UNLOAD_SPECIAL_CHARACTER 2

LOAD_SPECIAL_CHARACTER 2 ighlry2
LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

IF NOT IS_CAR_DEAD getaway_car

	CREATE_CHAR_INSIDE_CAR getaway_car PEDTYPE_CIVMALE SPECIAL02 hilary
	CLEAR_CHAR_THREAT_SEARCH hilary
	SET_CHAR_AS_PLAYER_FRIEND hilary player1 TRUE
	SET_CHAR_SUFFERS_CRITICAL_HITS hilary FALSE
	SET_CHAR_PERSONALITY hilary PEDSTAT_PSYCHO
	GIVE_WEAPON_TO_CHAR hilary WEAPONTYPE_MP5 9999
	FREEZE_CAR_POSITION getaway_car FALSE

	SET_CAR_TEMP_ACTION getaway_car TEMPACT_GOFORWARD 3000
	SET_CAR_FORWARD_SPEED getaway_car 30.0
ENDIF

SET_FIXED_CAMERA_POSITION -873.12 -348.1 13.96 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -879.4 -341.7 10.75 JUMP_CUT

WHILE NOT IS_CAR_DEAD getaway_car
	IF LOCATE_CAR_3D getaway_car -884.8 -334.2 10.0 3.0 3.0 3.0 FALSE
		GOTO skid_stop
	ENDIF
	WAIT 0
ENDWHILE

skid_stop:
SET_CAR_TEMP_ACTION getaway_car TEMPACT_NONE 0
SET_CAR_TEMP_ACTION getaway_car TEMPACT_HANDBRAKETURNLEFT 3000

timera = 0
WHILE timera < 1000
	WAIT 0
ENDWHILE

IF NOT IS_CHAR_DEAD hilary
AND NOT IS_CAR_DEAD getaway_car
	SET_CHAR_OBJ_LEAVE_CAR hilary getaway_car
ENDIF

WHILE NOT IS_CHAR_DEAD hilary
	IF IS_CHAR_ON_FOOT hilary
		SET_CHAR_HEADING hilary 280.0
		SET_CHAR_THREAT_SEARCH hilary THREAT_COP
		SET_CHAR_HEED_THREATS hilary TRUE
		//IF NOT IS_CHAR_DEAD bank_cop_1
			//SET_CHAR_OBJ_AIM_GUN_AT_CHAR hilary bank_cop_1
		//ENDIF
		GOTO covering_fire
	ENDIF
	WAIT 0
ENDWHILE

covering_fire:

IF NOT IS_CAR_DEAD getaway_car
	GET_OFFSET_FROM_CAR_IN_WORLD_COORDS getaway_car -2.0 3.5 -0.2 warp_x warp_y warp_z
ENDIF

SET_FIXED_CAMERA_POSITION warp_x warp_y warp_z 0.0 0.0 0.0

IF NOT IS_CHAR_DEAD hilary
	POINT_CAMERA_AT_CHAR hilary FIXED JUMP_CUT
ENDIF

LOAD_MISSION_AUDIO audio_slot BNK4_42
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_42 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF NOT IS_CHAR_DEAD bank_cop_1
AND NOT IS_CHAR_DEAD hilary
	SET_CHAR_HEALTH hilary 100
	SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS bank_cop_1 hilary
	SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS hilary bank_cop_1 
ENDIF

timera = 0
WHILE timera < 2000
	WAIT 0
ENDWHILE

IF NOT IS_CHAR_DEAD hilary
	EXPLODE_CHAR_HEAD hilary
ENDIF

timera = 0
WHILE timera < 1000
	WAIT 0
ENDWHILE


SET_CHAR_CROUCH scplayer FALSE 0
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF 
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_IN_FRONT_OF_PLAYER

// ************************************ THE GETAWAY !!!! *********************************************
// ***************************************************************************************************
// ***************************************************************************************************

SET_RADIO_CHANNEL 6 -1

IF NOT IS_CHAR_DEAD phil
	SET_CHAR_CROUCH phil FALSE 0
	SET_PLAYER_AS_LEADER phil player1
	SET_CHAR_THREAT_SEARCH phil THREAT_COP
	SET_CHAR_HEED_THREATS phil TRUE
	SET_CHAR_RUNNING phil TRUE
ENDIF

IF NOT IS_CHAR_DEAD hilary
	SET_CHAR_OBJ_NO_OBJ hilary
	SET_CHAR_THREAT_SEARCH hilary THREAT_COP
	SET_CHAR_HEED_THREATS hilary TRUE
	SET_PLAYER_AS_LEADER hilary player1
ENDIF

IF NOT IS_CHAR_DEAD cam
	SET_CHAR_OBJ_NO_OBJ cam
	SET_CHAR_THREAT_SEARCH cam THREAT_COP
	SET_CHAR_HEED_THREATS cam TRUE
	SET_PLAYER_AS_LEADER cam player1
	SET_CHAR_RUNNING cam TRUE
ENDIF

flag_blip_on_phil = 0

IF NOT IS_CHAR_DEAD bank_cop_1
	SET_CHAR_STAY_IN_SAME_PLACE bank_cop_1 FALSE
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS bank_cop_1 player1
ENDIF
IF NOT IS_CHAR_DEAD bank_cop_2
	SET_CHAR_STAY_IN_SAME_PLACE bank_cop_2 FALSE
ENDIF
IF NOT IS_CHAR_DEAD bank_cop_3
	SET_CHAR_STAY_IN_SAME_PLACE bank_cop_3 FALSE
ENDIF
IF NOT IS_CHAR_DEAD bank_cop_4
	SET_CHAR_STAY_IN_SAME_PLACE bank_cop_4 FALSE
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED getaway_car

//DELETE_OBJECT cams_door
//CREATE_OBJECT_NO_OFFSET dk_camjonesdoor -837.134 -901.672 12.03 cams_door
//CREATE_OBJECT_NO_OFFSET dk_camjonesdoor -837.134 -901.672 15.03 cams_door
//DONT_REMOVE_OBJECT cams_door

get_a_car_you_prat:

WHILE flag_blip_on_phil = 1
	WAIT 0
	GOSUB phil_death_check_2
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
//	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -854.5 -337.8 11.5 20.0 20.0 20.0 FALSE
//		ALTER_WANTED_LEVEL_NO_DROP player1 3
//	ENDIF
ENDWHILE

lose_wanted_level:

REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -871.57 -118.5 10.0 mission_blip

WHILE IS_WANTED_LEVEL_GREATER player1 0
	WAIT 0
	GOSUB phil_death_check_2
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -879.57 -114.5 10.0 3.0 3.0 2.0 TRUE
	ENDIF
	IF flag_blip_on_phil = 1
		GOTO get_a_car_you_prat
	ENDIF
//	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -854.5 -337.8 11.5 20.0 20.0 20.0 FALSE
//		ALTER_WANTED_LEVEL_NO_DROP player1 3
//	ENDIF
	IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -844.95 -901.0 10.0 15.0 15.0 15.0 FALSE
		SLIDE_OBJECT cams_door -837.134 -901.672 12.03 0.0 0.0 0.025 FALSE
	ENDIF
ENDWHILE

get_to_cams:

REMOVE_BLIP mission_blip
ADD_BLIP_FOR_COORD -832.2 -901.0 10.0 mission_blip

//SET_OBJECT_COORDINATES cams_door -837.134 -901.672 15.03 

WHILE NOT IS_WANTED_LEVEL_GREATER player1 0
	WAIT 0
	GOSUB phil_death_check_2
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -832.2 -901.0 10.0 3.0 3.0 2.0 TRUE
	AND LOCATE_CHAR_ANY_MEANS_3D phil -832.2 -901.0 10.0 3.0 3.0 2.0 FALSE
		GOTO home_and_dry
	ENDIF
	IF flag_blip_on_phil = 1
		GOTO get_a_car_you_prat
	ENDIF
//	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -854.5 -337.8 11.5 20.0 20.0 20.0 FALSE
//		ALTER_WANTED_LEVEL_NO_DROP player1 3
//	ENDIF
	IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -844.95 -901.0 10.0 15.0 15.0 15.0 FALSE
		SLIDE_OBJECT cams_door -837.134 -901.672 12.03 0.0 0.0 0.025 FALSE
	ENDIF
ENDWHILE

GOTO lose_wanted_level

home_and_dry:

WHILE IS_PLAYER_PLAYING player1
	WAIT 0	
	SLIDE_OBJECT cams_door -837.134 -901.672 15.03 0.0 0.0 0.025 FALSE 
	GOSUB phil_death_check_2
	IF flag_bank_mission_failed = 1
		GOTO mission_bankjob4_failed
	ENDIF
	IF flag_blip_on_phil = 1
		GOTO get_a_car_you_prat
	ENDIF
	IF IS_WANTED_LEVEL_GREATER player1 0
		GOTO lose_wanted_level
	ENDIF
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -844.95 -901.0 10.0 3.5 3.5 3.5 TRUE
		GOTO home_free
	ENDIF
	IF NOT LOCATE_PLAYER_ANY_MEANS_3D player1 -844.95 -901.0 10.0 15.0 15.0 15.0 FALSE
		GOTO get_to_cams
	ENDIF
ENDWHILE

home_free:

REMOVE_BLIP mission_blip


GOTO mission_bankjob4_passed









// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
// +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    
//      +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    +++++++    




mission_bankjob4_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"

SET_FADING_COLOUR 0 0 1
SWITCH_PED_ROADS_OFF -414.0 -597.0 12.0 -332.0 -555.0 30.0

WHILE IS_PLAYER_IN_AREA_3D player1 -852.8 -915.0 10.0 -837.5 -897.2 13.0 FALSE // CHECKS IF PLAYER HAS FAILED BY STANDING IN GARAGE AND SHOOTING PHIL - STOPS PLAYER GETTING STUCK IN GARAGE.
	WAIT 0
ENDWHILE

IF IS_PLAYER_PLAYING player1
AND flag_player_in_bank = 1
	//flag_bank_job = 1
	//flag_player_on_bank_mission = 0
	GOSUB exit_bank
	
	DO_FADE 1500 FADE_IN
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE
ENDIF
RETURN
	   		
	
// mission bankjob4 passed

mission_bankjob4_passed:

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON 
SWITCH_WIDESCREEN ON

IF IS_PLAYER_IN_ANY_CAR player1
AND NOT IS_CAR_DEAD getaway_car
	SET_CHAR_OBJ_LEAVE_CAR scplayer getaway_car
ENDIF

SET_RADIO_CHANNEL 3 -1
SET_MUSIC_DOES_FADE FALSE

SET_FADING_COLOUR 0 0 1

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
	SLIDE_OBJECT cams_door -837.134 -901.672 12.03 0.0 0.0 0.025 FALSE
ENDWHILE

SET_FIXED_CAMERA_POSITION -827.5 -894.2 22.5 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -833.15 -899.4 17.6 JUMP_CUT

DO_FADE 500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

DELETE_CHAR phil
DELETE_CHAR cam

PRINT_WITH_NUMBER_BIG ( M_PASS ) 50000 5000 1 //"Mission Passed"
ADD_SCORE player1 50000
PLAY_MISSION_PASSED_TUNE 1

LOAD_MISSION_AUDIO audio_slot BNK4_44
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_44 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

IF flag_cam_dead = 1
	LOAD_MISSION_AUDIO audio_slot BNK4_45
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_45 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank

	LOAD_MISSION_AUDIO audio_slot BNK4_46
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_46 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank

	LOAD_MISSION_AUDIO audio_slot BNK4_47
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_47 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank
ENDIF

LOAD_MISSION_AUDIO audio_slot BNK4_48
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_48 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BNK4_49
GOSUB audio_bank_loading
PRINT_NOW ( BNK4_49 ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BNK450a
GOSUB audio_bank_loading
PRINT_NOW ( BNK450a ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

LOAD_MISSION_AUDIO audio_slot BNK450b
GOSUB audio_bank_loading
PRINT_NOW ( BNK450b ) 10000 1//rhubarb rhubarb
GOSUB has_audio_finished_bank

SET_FADING_COLOUR 0 0 1

DO_FADE 500 FADE_OUT

REQUEST_MODEL od_clubout_dy
REQUEST_MODEL od_clubout_nt
REQUEST_MODEL od_clubneon
REQUEST_MODEL od_clubdoors
REQUEST_MODEL od_clbdr_close
REQUEST_MODEL od_clbdr_open
REQUEST_MODEL veg_palmkbb11
REQUEST_MODEL odNroad01_nt
REQUEST_MODEL odNroad01_dy
REQUEST_MODEL od_clubback
REQUEST_MODEL miamiodnroadxa
REQUEST_MODEL lodd_build2
REQUEST_MODEL spad_buildnew
REQUEST_MODEL veg_palmbig14

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE


WHILE NOT HAS_MODEL_LOADED od_clubout_dy
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED od_clubout_nt
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED od_clubneon
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED od_clubdoors
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED od_clbdr_close
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED od_clbdr_open
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED veg_palmkbb11
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED odNroad01_nt
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED odNroad01_dy
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED od_clubback
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED miamiodnroadxa
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED lodd_build2
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED spad_buildnew
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED veg_palmbig14
	WAIT 0
ENDWHILE

//SET_PLAYER_COORDINATES player1 528.5 -95.5 9.6
//LOAD_SCENE 504.0 -95.25 11.4
SET_FIXED_CAMERA_POSITION 513.5 -44.5 22.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 502.0 -60.5 14.0 JUMP_CUT

REMOVE_BLIP bankjob_contact_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD bankbuyx bankbuyy bankbuyz the_bankjob_blip bankjob_contact_blip
CREATE_PROTECTION_PICKUP bankbuyX bankbuyY bankbuyZ malibu_revenue malibu_revenue malibu_cash_pickup

SET_TIME_OF_DAY 21 30

DO_FADE 1000 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

timera = 0
WHILE timera < 2000
	WAIT 0
ENDWHILE
PRINT_BIG ASSET_A 10000 6//BANK HEIST ASSET COMPLETED!
PRINT_WITH_NUMBER_NOW ASSET_B malibu_revenue 10000 1

SET_FIXED_CAMERA_POSITION 493.6 -87.0 10.8 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 492.6 -77.4 13.2 JUMP_CUT

timera = 0
WHILE timera < 1500
	WAIT 0
ENDWHILE

POINT_CAMERA_AT_POINT bankbuyX bankbuyY bankbuyZ INTERPOLATION

timera = 0
WHILE timera < 1000
	WAIT 0
ENDWHILE

//PLAY_MISSION_PASSED_TUNE 1

timera = 0
WHILE timera < 5000
	WAIT 0
ENDWHILE

DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

LOAD_SCENE -833.6 -908.5 11.11

CLEAR_AREA -833.6 -908.5 11.11 2.0 TRUE
 
IF IS_PLAYER_IN_ANY_CAR player1
	WARP_PLAYER_FROM_CAR_TO_COORD player1 -833.6 -908.5 11.11
ELSE
	SET_PLAYER_COORDINATES player1 -833.6 -908.5 11.11
ENDIF

IF NOT IS_CHAR_DEAD scplayer
	UNDRESS_CHAR scplayer player2
	LOAD_ALL_MODELS_NOW
	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF
ENDIF

SET_PLAYER_HEADING player1 345.0

SET_OBJECT_COORDINATES cams_door -837.134 -901.672 12.03 

RESTORE_CAMERA_JUMPCUT

CLEAR_PRINTS

DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_MUSIC_DOES_FADE TRUE
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_PLAYER_MOOD player1 PLAYER_MOOD_WISECRACKING 60000 
SWITCH_WIDESCREEN OFF

REGISTER_MISSION_PASSED	BANK_4
malibu_asset_acquired = 1 
flag_first_asset_complete = 1 // FIXMIAMI: fix Ken's phonecall
++ counter_60_percent
flag_bankjob_mission4_passed = 1
CLEAR_WANTED_LEVEL player1
PLAYER_MADE_PROGRESS 1

CREATE_CLOTHES_PICKUP 465.3 -57.4 15.7 7 clothes_pickup13
CREATE_PICKUP knifecur PICKUP_ON_STREET 468.5 -54.2 15.7 jason_knife 
clothes13_created = 1
START_NEW_SCRIPT cloth9
START_NEW_SCRIPT ambient_bank_loop


RETURN
		

// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ************************************************** GOSUBS GOSUBS GOSUBS GOSUBS ****************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************
// ***********************************************************************************************************************************


exit_bank:
	DO_FADE 1500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE
	CLEAR_EXTRA_COLOURS FALSE
	SET_CAR_DENSITY_MULTIPLIER 1.0
	SWITCH_RUBBISH ON
	SET_AREA_VISIBLE VIS_MAIN_MAP
	SWITCH_PED_ROADS_OFF -956.0 -355.0 5.0 -898.0 -328.0 25.0
	CLEAR_AREA -893.0 -341.0 13.5 1.0 FALSE
	LOAD_SCENE -893.0 -341.0 13.5
	SET_PLAYER_COORDINATES player1 -893.0 -341.0 12.0
	flag_player_in_bank = 0
	SET_PLAYER_HEADING player1 270.0
	SET_CAMERA_IN_FRONT_OF_PLAYER
RETURN


hilary_car_check:
	IF IS_CHAR_DEAD hilary
		PRINT_NOW H_DEAD 5000 1 //Hilary's dead!
		flag_bank_mission_failed = 1
		RETURN
	ENDIF
	IF IS_CAR_DEAD getaway_car
		PRINT_NOW TRASHED 5000 1
		flag_bank_mission_failed = 1
	ENDIF
RETURN


car_check:
IF flag_hilary_gone = 0

	IF NOT IS_CAR_DEAD getaway_car
		IF NOT IS_PLAYER_IN_CAR player1 getaway_car
			flag_player_in_car = 0
			GET_PLAYER_COORDINATES player1 player_x player_y player_z
			IF flag_hilary_gone = 0
			AND flag_blip_on_getaway_car = 0
				
				ADD_BLIP_FOR_CAR getaway_car blip_getaway_car
				flag_blip_on_getaway_car = 1
			ENDIF
			IF locate_dome_flag = 1
				REMOVE_BLIP mission_blip
				locate_dome_flag = 0
			ENDIF
		ELSE
			flag_player_in_car = 1
			IF flag_blip_on_getaway_car = 1
				REMOVE_BLIP blip_getaway_car
				flag_blip_on_getaway_car = 0
			ENDIF
		ENDIF
		IF IS_CAR_UPSIDEDOWN getaway_car
		AND IS_CAR_STOPPED getaway_car
			flag_bank_mission_failed = 1
		ENDIF	
	ELSE
		PRINT_NOW TRASHED 5000 1
		flag_bank_mission_failed = 1
	ENDIF
ENDIF
RETURN



phil_check:
	IF NOT IS_CAR_DEAD getaway_car
		IF IS_CHAR_DEAD	phil
			PRINT_NOW P_DEAD 5000 1 //"~r~Phil died!"
			flag_bank_mission_failed = 1
		ELSE
			IF flag_player_in_car = 1
				IF NOT IS_CHAR_IN_CAR phil getaway_car
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER phil getaway_car
					IF LOCATE_CHAR_ANY_MEANS_CAR_3D phil getaway_car 2.5 2.5 2.5 FALSE
					AND NOT IS_WANTED_LEVEL_GREATER player1 0 
						SET_CHAR_RUNNING phil FALSE
					ELSE
						SET_CHAR_RUNNING phil TRUE
					ENDIF
				ENDIF
			ELSE
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 phil 4.0 4.0 FALSE
					IF flag_player_leader_phil = 0
						SET_CHAR_OBJ_NO_OBJ phil
						SET_PLAYER_AS_LEADER phil player1
						flag_player_leader_phil = 1
					ENDIF
				ELSE
					LEAVE_GROUP phil
					SET_CHAR_OBJ_RUN_TO_COORD phil player_x player_y //player_z
					flag_player_leader_phil = 0
				ENDIF
			ENDIF
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 phil 20.0 20.0 FALSE
				IF flag_blip_on_phil = 0
					PRINT_NOW P_HIND 5000 1 //"You have left Phil behind!"
					REMOVE_BLIP mission_blip
					ADD_BLIP_FOR_CHAR phil phil_blip
					flag_blip_on_phil = 1
				ENDIF
			ELSE
				IF flag_blip_on_phil = 1
					//SET_PLAYER_AS_LEADER phil player1
					REMOVE_BLIP phil_blip
					flag_blip_on_phil = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
RETURN

	

cam_check:
	IF NOT IS_CAR_DEAD getaway_car
		IF IS_CHAR_DEAD	cam
			PRINT_NOW C_DEAD 5000 1 //"~r~Phil died!"
			flag_bank_mission_failed = 1
		ELSE
			IF flag_player_in_car = 1
				IF NOT IS_CHAR_IN_CAR cam getaway_car
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER cam getaway_car
					IF LOCATE_CHAR_ANY_MEANS_CAR_3D cam getaway_car 2.5 2.5 2.5 FALSE
					AND NOT IS_WANTED_LEVEL_GREATER player1 0 
						SET_CHAR_RUNNING cam FALSE
					ELSE
						SET_CHAR_RUNNING cam TRUE
					ENDIF
				ENDIF
			ELSE
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 cam 4.0 4.0 FALSE
					IF flag_player_leader_cam = 0
						SET_CHAR_OBJ_NO_OBJ cam
						SET_PLAYER_AS_LEADER cam player1
						flag_player_leader_cam = 1
					ENDIF
				ELSE
					LEAVE_GROUP cam
					SET_CHAR_OBJ_RUN_TO_COORD cam player_x player_y //player_z
					flag_player_leader_cam = 0
				ENDIF
			ENDIF
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 cam 20.0 20.0 FALSE
				IF flag_blip_on_cam = 0
					PRINT_NOW C_HIND 5000 1 //"You have left Phil behind!"
					REMOVE_BLIP mission_blip
					ADD_BLIP_FOR_CHAR cam cam_blip
					flag_blip_on_cam = 1
				ENDIF
			ELSE
				IF flag_blip_on_cam = 1
					//SET_PLAYER_AS_LEADER cam player1
					REMOVE_BLIP cam_blip
					flag_blip_on_cam = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
RETURN

	

hilary_check:

	IF flag_hilary_gone = 0
	AND NOT IS_CAR_DEAD getaway_car
		IF IS_CHAR_DEAD	hilary
			PRINT_NOW H_DEAD 5000 1 //"~r~Phil died!"
		flag_bank_mission_failed = 1
		ELSE
			IF flag_player_in_car = 1
				IF NOT IS_CHAR_IN_CAR hilary getaway_car
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER hilary getaway_car
					IF LOCATE_CHAR_ANY_MEANS_CAR_3D hilary getaway_car 2.5 2.5 2.5 FALSE
					AND NOT IS_WANTED_LEVEL_GREATER player1 0 
						SET_CHAR_RUNNING hilary FALSE
					ELSE
						SET_CHAR_RUNNING hilary TRUE
					ENDIF
				ENDIF
			ELSE
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 hilary 4.0 4.0 FALSE
					IF flag_player_leader_hilary = 0
						SET_CHAR_OBJ_NO_OBJ hilary
						SET_PLAYER_AS_LEADER hilary player1
						flag_player_leader_hilary = 1
					ENDIF
				ELSE
					LEAVE_GROUP hilary
					SET_CHAR_OBJ_RUN_TO_COORD hilary player_x player_y //player_z
					flag_player_leader_hilary = 0
				ENDIF
			ENDIF
			IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 hilary 20.0 20.0 FALSE
				IF flag_blip_on_hilary = 0
					PRINT_NOW H_HIND 5000 1 //"You have left Phil behind!"
					REMOVE_BLIP mission_blip
					ADD_BLIP_FOR_CHAR hilary hilary_blip
					flag_blip_on_hilary = 1
				ENDIF
			ELSE
				IF flag_blip_on_hilary = 1
					//SET_PLAYER_AS_LEADER hilary player1
					REMOVE_BLIP hilary_blip
					flag_blip_on_hilary = 0
				ENDIF
			ENDIF
		ENDIF
	ENDIF
RETURN



plinkety_plonk:
	IF flag_blip_on_phil = 1
	OR flag_blip_on_hilary = 1
	OR flag_blip_on_cam = 1
		locate_dome_flag = 0
	ELSE
		IF flag_player_in_car = 1
			IF locate_dome_flag	= 0
				ADD_BLIP_FOR_COORD -896.5 -341.0 13.4 mission_blip
				locate_dome_flag = 1
			ENDIF
		ENDIF
	ENDIF
	
RETURN

// OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----
// ----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO
// OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----
// ----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO
// OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----
// ----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO
// OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----
// ----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO
// OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----
// ----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO----OOOO

// mission cleanup

mission_cleanup_bankjob4:
GET_GAME_TIMER timer_mobile_start

WAIT 5

REMOVE_BLIP mission_blip
REMOVE_BLIP phil_blip
REMOVE_BLIP cam_blip
REMOVE_BLIP hilary_blip	 
REMOVE_BLIP blip_getaway_car
//REMOVE_SPHERE mission_blob

REMOVE_ROUTE 1
REMOVE_ROUTE 2
REMOVE_SOUND bank_alarm


IF NOT IS_CHAR_DEAD scplayer
	SET_CHAR_OBJ_NO_OBJ scplayer
ENDIF
IF IS_PLAYER_PLAYING player1
	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
ENDIF
RESTORE_CAMERA_JUMPCUT

SET_OBJECT_COORDINATES cams_door -837.134 -901.672 12.03 
SWITCH_PED_ROADS_ON -877.0 -368.0 5.0 -832.0 -317.0 25.0 //side walks outside bank

SET_MUSIC_DOES_FADE TRUE
CLEAR_EXTRA_COLOURS FALSE 
/*
REQUEST_MODEL m4
REQUEST_MODEL mp5lng
REQUEST_MODEL TAXI
REQUEST_MODEL python
*/
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED GDb
MARK_MODEL_AS_NO_LONGER_NEEDED swat
MARK_MODEL_AS_NO_LONGER_NEEDED gasgrenade
MARK_MODEL_AS_NO_LONGER_NEEDED m4
MARK_MODEL_AS_NO_LONGER_NEEDED mp5lng
MARK_MODEL_AS_NO_LONGER_NEEDED TAXI
MARK_MODEL_AS_NO_LONGER_NEEDED python
MARK_MODEL_AS_NO_LONGER_NEEDED enforcer
MARK_MODEL_AS_NO_LONGER_NEEDED WFYBU
MARK_MODEL_AS_NO_LONGER_NEEDED HFYBU
MARK_MODEL_AS_NO_LONGER_NEEDED WMORI

MARK_MODEL_AS_NO_LONGER_NEEDED od_clubout_dy
MARK_MODEL_AS_NO_LONGER_NEEDED od_clubout_nt
MARK_MODEL_AS_NO_LONGER_NEEDED od_clubneon
MARK_MODEL_AS_NO_LONGER_NEEDED od_clubdoors
MARK_MODEL_AS_NO_LONGER_NEEDED od_clbdr_close
MARK_MODEL_AS_NO_LONGER_NEEDED od_clbdr_open
MARK_MODEL_AS_NO_LONGER_NEEDED veg_palmkbb11
MARK_MODEL_AS_NO_LONGER_NEEDED odNroad01_nt
MARK_MODEL_AS_NO_LONGER_NEEDED odNroad01_dy
MARK_MODEL_AS_NO_LONGER_NEEDED od_clubback
MARK_MODEL_AS_NO_LONGER_NEEDED miamiodnroadxa
MARK_MODEL_AS_NO_LONGER_NEEDED lodd_build2
MARK_MODEL_AS_NO_LONGER_NEEDED spad_buildnew
MARK_MODEL_AS_NO_LONGER_NEEDED veg_palmbig14


REMOVE_CHAR_ELEGANTLY phil
REMOVE_CHAR_ELEGANTLY cam
REMOVE_CHAR_ELEGANTLY hilary
REMOVE_CHAR_ELEGANTLY bank_manager

REMOVE_PICKUP retirement

MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_1
MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_2
MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_3
MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_4
MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_5
MARK_CHAR_AS_NO_LONGER_NEEDED bank_cop_6
MARK_CAR_AS_NO_LONGER_NEEDED cop_car1
MARK_CAR_AS_NO_LONGER_NEEDED cop_car2
MARK_CAR_AS_NO_LONGER_NEEDED cop_car3
MARK_CAR_AS_NO_LONGER_NEEDED getaway_car


UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
//SET_NEAR_CLIP 1.0

//Bank windows
GOSUB delete_routine
//DELETE_OBJECT bank_windows
CREATE_OBJECT_NO_OFFSET unrocketed_win1 -899.851 -341.061 14.318 bank_windows
DONT_REMOVE_OBJECT bank_windows
//Bank Grills
CREATE_OBJECT_NO_OFFSET Bnk_grill01 -899.214 -333.656 21.0 grill_1
SET_OBJECT_DYNAMIC grill_1 FALSE
DONT_REMOVE_OBJECT grill_1
SET_OBJECT_AREA_VISIBLE grill_1 VIS_BANK

CREATE_OBJECT_NO_OFFSET Bnk_grill01 -899.214 -348.466 21.03 grill_2
SET_OBJECT_DYNAMIC grill_2 FALSE
DONT_REMOVE_OBJECT grill_2
SET_OBJECT_AREA_VISIBLE grill_2 VIS_BANK

CREATE_OBJECT_NO_OFFSET Bnk_grill01 -907.307 -336.618 23.7 grill_3
SET_OBJECT_DYNAMIC grill_3 FALSE
DONT_REMOVE_OBJECT grill_3
SET_OBJECT_AREA_VISIBLE grill_3 VIS_BANK

CREATE_OBJECT_NO_OFFSET Bnk_grill01 -907.307 -345.504 23.7 grill_4
SET_OBJECT_DYNAMIC grill_4 FALSE
DONT_REMOVE_OBJECT grill_4
SET_OBJECT_AREA_VISIBLE grill_4 VIS_BANK

CREATE_OBJECT_NO_OFFSET Bnk_grill01 -915.401 -336.6184 23.7 grill_5
SET_OBJECT_DYNAMIC grill_5 FALSE
DONT_REMOVE_OBJECT grill_5
SET_OBJECT_AREA_VISIBLE grill_5 VIS_BANK

CREATE_OBJECT_NO_OFFSET Bnk_grill01 -915.401 -345.50 23.7 grill_6
SET_OBJECT_DYNAMIC grill_6 FALSE
DONT_REMOVE_OBJECT grill_6
SET_OBJECT_AREA_VISIBLE grill_6 VIS_BANK

//flag_player_on_bank_mission = 0
//flag_bank_job = 0
flag_player_on_mission = 0


MISSION_HAS_FINISHED
RETURN

delete_routine:
DELETE_OBJECT bank_windows
DELETE_OBJECT grill_1
DELETE_OBJECT grill_2
DELETE_OBJECT grill_3
DELETE_OBJECT grill_4
DELETE_OBJECT grill_5
DELETE_OBJECT grill_6
DELETE_CHAR cashier1
DELETE_CHAR cashier2
DELETE_CHAR cashier3
DELETE_CHAR cashier4
DELETE_CHAR cashier5
DELETE_CHAR cashier6
DELETE_CHAR cashier7
DELETE_CHAR cashier8

//MARK_CAR_AS_NO_LONGER_NEEDED getaway_car

DELETE_CHAR bank_cop_1
DELETE_CHAR bank_cop_2
DELETE_CHAR bank_cop_3
DELETE_CHAR bank_cop_4
DELETE_CHAR bank_cop_5
DELETE_CHAR bank_cop_6
DELETE_CHAR bank_cop_7
DELETE_CHAR bank_cop_8

DELETE_CHAR target_ped1
DELETE_CHAR target_ped2
DELETE_CHAR target_ped3
DELETE_CHAR target_ped4

REMOVE_PICKUP bank_health
REMOVE_PICKUP bank_armour

DELETE_OBJECT lift_door_1
DELETE_OBJECT lift_door_2

RETURN

bank_job_timer:
	GET_GAME_TIMER timer_intro_now
	intro_time_lapsed = timer_intro_now - timer_intro_start
RETURN



audio_bank_loading:
	WHILE NOT HAS_MISSION_AUDIO_LOADED audio_slot
		WAIT 0
		IF flag_area_check_1 = 1
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -833.0 -348.0 10.0 4.0 4.0 4.0 TRUE
			ENDIF
			//GOSUB car_check
			//GOSUB phil_check
			//GOSUB cam_check
			//GOSUB hilary_check
		ENDIF
	ENDWHILE
	PLAY_MISSION_AUDIO audio_slot
RETURN




has_audio_finished_bank:
	WHILE NOT HAS_MISSION_AUDIO_FINISHED audio_slot
		WAIT 0
		IF flag_area_check_1 = 1
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 -833.0 -348.0 10.0 4.0 4.0 4.0 TRUE
			ENDIF
			//GOSUB car_check
			//GOSUB phil_check
			//GOSUB cam_check
			//GOSUB hilary_check
		ENDIF
	ENDWHILE
	CLEAR_PRINTS
RETURN




wait_state_loop:

IF flag_change_waitstate = 0

	IF NOT IS_CHAR_DEAD cashier1
		SET_CHAR_WAIT_STATE cashier1 0 0
		SET_CHAR_WAIT_STATE cashier1 flag_waitstate_1 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier2
		SET_CHAR_WAIT_STATE cashier2 0 0
		SET_CHAR_WAIT_STATE cashier2 flag_waitstate_2 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier3
		SET_CHAR_WAIT_STATE cashier3 0 0
		SET_CHAR_WAIT_STATE cashier3 flag_waitstate_1 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier4
		SET_CHAR_WAIT_STATE cashier4 0 0
		SET_CHAR_WAIT_STATE cashier4 flag_waitstate_2 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier5
		SET_CHAR_WAIT_STATE cashier5 0 0
		SET_CHAR_WAIT_STATE cashier5 flag_waitstate_2 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier6
		SET_CHAR_WAIT_STATE cashier6 0 0
		SET_CHAR_WAIT_STATE cashier6 flag_waitstate_1 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier7
		SET_CHAR_WAIT_STATE cashier7 0 0
		SET_CHAR_WAIT_STATE cashier7 flag_waitstate_2 999999
	ENDIF
	IF NOT IS_CHAR_DEAD cashier8
		SET_CHAR_WAIT_STATE cashier8 0 0
		SET_CHAR_WAIT_STATE cashier8 flag_waitstate_1 999999
	ENDIF

	//IF flag_this_is_a_raid = 1
		IF NOT IS_CHAR_DEAD bank_cop_3
			SET_CHAR_WAIT_STATE bank_cop_3 0 0
			SET_CHAR_WAIT_STATE bank_cop_3 flag_waitstate_3 999999
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_2
			SET_CHAR_WAIT_STATE bank_cop_2 0 0
			SET_CHAR_WAIT_STATE bank_cop_2 flag_waitstate_3 999999
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_1
			SET_CHAR_WAIT_STATE bank_cop_1 0 0
			SET_CHAR_WAIT_STATE bank_cop_1 flag_waitstate_3 999999
		ENDIF
	//ENDIF
	
	IF NOT IS_CHAR_DEAD bank_manager
		IF flag_cop_6 = 1
			//SET_CHAR_WAIT_STATE bank_manager 14 999999 //COWER!
			SET_CHAR_CROUCH bank_manager TRUE 999999
		ELSE
			SET_CHAR_CROUCH bank_manager FALSE 0
		ENDIF
	ENDIF
				

	flag_change_waitstate = 1

ENDIF
RETURN

hostage_checker:
	IF IS_CHAR_DEAD cashier1
	AND flag_hostage1 = 0
		++ hostage_casualties
		flag_hostage1 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier2
	AND flag_hostage2 = 0
		++ hostage_casualties
		flag_hostage2 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier3
	AND flag_hostage3 = 0
		++ hostage_casualties
		flag_hostage3 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier4
	AND flag_hostage4 = 0
		++ hostage_casualties
		flag_hostage4 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier5
	AND flag_hostage5 = 0
		++ hostage_casualties
		flag_hostage5 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier6
	AND flag_hostage6 = 0
		++ hostage_casualties
		flag_hostage6 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier7
	AND flag_hostage7 = 0
		++ hostage_casualties
		flag_hostage7 = 1
	ENDIF
	IF IS_CHAR_DEAD cashier8
	AND flag_hostage8 = 0
		++ hostage_casualties
		flag_hostage8 = 1
	ENDIF

	IF IS_CHAR_DEAD bank_cop_3
	AND flag_hostage9 = 0
		++ hostage_casualties
		flag_hostage9 = 1
	ENDIF
	IF IS_CHAR_DEAD bank_cop_2
	AND flag_hostage10 = 0
		++ hostage_casualties
		flag_hostage10 = 1
	ENDIF
	IF IS_CHAR_DEAD bank_cop_1
	AND flag_hostage11 = 0
		++ hostage_casualties
		flag_hostage11 = 1
	ENDIF
	IF hostage_casualties > 2
	AND flag_launch_hostage_attack = 0
		var_hostage = cashier1
		GOSUB hostage_attack
		var_hostage = cashier2
		GOSUB hostage_attack
		var_hostage = cashier3
		GOSUB hostage_attack
		var_hostage = cashier4
		GOSUB hostage_attack
		var_hostage = cashier5
		GOSUB hostage_attack
		var_hostage = cashier6
		GOSUB hostage_attack
		var_hostage = cashier7
		GOSUB hostage_attack
		var_hostage = cashier8
		GOSUB hostage_attack
		var_hostage = bank_cop_1
		GOSUB hostage_attack
		var_hostage = bank_cop_2
		GOSUB hostage_attack
		var_hostage = bank_cop_3
		GOSUB hostage_attack
		IF NOT IS_CHAR_DEAD phil
			SET_CHAR_THREAT_SEARCH phil THREAT_GANG_SECURITY
			SET_CHAR_THREAT_SEARCH phil THREAT_COP
			SET_CHAR_HEED_THREATS phil TRUE
			SET_PLAYER_AS_LEADER phil player1
		ENDIF
		IF NOT IS_CHAR_DEAD cam
		AND flag_cam_downstairs = 0
			SET_CHAR_THREAT_SEARCH cam THREAT_GANG_SECURITY
			SET_CHAR_THREAT_SEARCH cam THREAT_COP
			SET_CHAR_HEED_THREATS cam TRUE
			SET_PLAYER_AS_LEADER cam player1
		ENDIF
		ALTER_WANTED_LEVEL_NO_DROP player1 3
		SWITCH_PED_ROADS_ON -414.0 -597.0 12.0 -332.0 -555.0 30.0
		//flag_bank_mission_failed = 1 
		flag_launch_hostage_attack = 1
	ENDIF
RETURN

hostage_attack:
	IF NOT IS_CHAR_DEAD var_hostage
	GENERATE_RANDOM_INT_IN_RANGE 0 2 hostage_int 
		IF hostage_int = 0
			IF NOT IS_CHAR_DEAD phil
				SET_CHAR_WAIT_STATE var_hostage 0 0
				SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS var_hostage phil
				SET_CHAR_STAY_IN_SAME_PLACE var_hostage FALSE
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD cam
				SET_CHAR_WAIT_STATE var_hostage 0 0
				SET_CHAR_OBJ_KILL_CHAR_ANY_MEANS var_hostage cam
				SET_CHAR_STAY_IN_SAME_PLACE var_hostage FALSE
			ENDIF
		ENDIF
	ENDIF
RETURN

gob_shite:
REMOVE_BLIP phil_blip
REMOVE_BLIP cam_blip
RETURN



stairs_cam:

	IF IS_PLAYER_IN_AREA_3D player1 -926.3 -330.0 12.4 -929.0 -327.67 15.0 FALSE
		//flag_launch_cops_1 = 1
		/*
		GET_PLAYER_HEADING player1 player_heading_bj4
		IF player_heading_bj4 > 0.0
		AND player_heading_bj4 < 181.0
			//SET_CAMERA_ZOOM CAM_ZOOM_ONE
			SET_FIXED_CAMERA_POSITION -925.6 -329.3 13.9 0.0 0.0 0.0 
			POINT_CAMERA_AT_PLAYER player1 FIXED JUMP_CUT
		ELSE
			//SET_CAMERA_ZOOM CAM_ZOOM_THREE
			RESTORE_CAMERA
		ENDIF
		*/
		IF flag_cop_6 = 0

			CREATE_CHAR PEDTYPE_CIVMALE	GDa -918.7 -353.3 16.8 bank_cop_6
			CLEAR_CHAR_THREAT_SEARCH bank_cop_6
			SET_CHAR_THREAT_SEARCH bank_cop_6 THREAT_PLAYER1 
			SET_CHAR_HEADING bank_cop_6 60.0
			SET_CHAR_CROUCH bank_cop_6 TRUE 300000
			//CHAR_SET_IDLE bank_cop_6
			GIVE_WEAPON_TO_CHAR bank_cop_6 WEAPONTYPE_MP5 9999

			GET_GAME_TIMER timer_intro_start
			IF NOT IS_CHAR_DEAD phil
				ADD_ROUTE_POINT 2 -921.0 -340.0 13.4
				ADD_ROUTE_POINT 2 -921.0 -333.0	13.4
				//ADD_ROUTE_POINT 2 -917.7 -340.0 12.4
				SET_CHAR_COORDINATES phil -921.0 -340.0 12.4
				SET_CHAR_OBJ_FOLLOW_ROUTE phil 2 FOLLOW_ROUTE_LOOP
				SET_CHAR_USE_PEDNODE_SEEK phil FALSE
				//SET_CHAR_HEADING phil 320.0
				//SET_CHAR_STAY_IN_SAME_PLACE phil TRUE
				SET_CHAR_THREAT_SEARCH phil THREAT_COP
			ENDIF
			
			CREATE_CHAR PEDTYPE_CIVMALE WMORI -963.8 -336.43 14.6 bank_manager
			SHUT_CHAR_UP bank_manager TRUE
			SET_CHAR_HEADING bank_manager 205.0
			CLEAR_CHAR_THREAT_SEARCH bank_manager
			SET_CHAR_CROUCH bank_manager TRUE 300000
			//SET_CHAR_PERSONALITY bank_manager PEDSTAT_SUIT_GUY
			SET_CHAR_PERSONALITY bank_manager PEDSTAT_SENSIBLE_GUY

			flag_cop_6 = 1
		ENDIF
		GOSUB wait_state_loop
	ENDIF
	/*
	IF IS_PLAYER_IN_AREA_3D player1 -932.3 -330.5 14.4 -933.5 -327.5 17.0 FALSE
		GET_PLAYER_HEADING player1 player_heading_bj4
		IF player_heading_bj4 < 360.0
		AND player_heading_bj4 > 181.0
			//SET_CAMERA_ZOOM CAM_ZOOM_ONE
			SET_FIXED_CAMERA_POSITION -936.0 -329.4 17.35 0.0 0.0 0.0 
			POINT_CAMERA_AT_PLAYER player1 FIXED JUMP_CUT
		ELSE
			//SET_CAMERA_ZOOM CAM_ZOOM_THREE
			RESTORE_CAMERA
		ENDIF
	ENDIF
	*/
RETURN



cam_death_check:
	IF IS_CHAR_DEAD cam
		flag_bank_mission_failed = 1
		PRINT_NOW C_DEAD 5000 1
	ENDIF
RETURN



phil_death_check:
	IF IS_CHAR_DEAD phil
		PRINT_NOW P_DEAD 5000 1
		flag_bank_mission_failed = 1
	ENDIF
RETURN

phil_death_check_2:
	IF NOT IS_CHAR_DEAD phil
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 phil 10.0 10.0 10.0 FALSE
			IF flag_blip_on_phil = 1
				REMOVE_BLIP phil_blip
				flag_blip_on_phil = 0
			ENDIF
		ELSE
			IF flag_blip_on_phil = 0
				REMOVE_BLIP phil_blip
				ADD_BLIP_FOR_CHAR phil phil_blip
				PRINT_NOW P_HIND 5000 1 //"You have left Phil behind!"
				flag_blip_on_phil = 1
			ENDIF
		ENDIF
	ELSE
		PRINT_NOW P_DEAD 5000 1
		flag_bank_mission_failed = 1
	ENDIF
	IF IS_CHAR_DEAD cam
		flag_cam_dead = 1
	ENDIF
RETURN	 


banK_manager_death_check:
	IF IS_CHAR_DEAD bank_manager
		PRINT_NOW BM_DEAD 5000 1
		flag_bank_mission_failed = 1
	ENDIF
RETURN

surveilance:

	IF LOCATE_PLAYER_ON_FOOT_3D player1 -954.5 -341.87 14.6 1.5 1.5 2.0 FALSE
		IF flag_surveilance_trigger = 0
			SET_PLAYER_CONTROL player1 OFF
			SET_EVERYONE_IGNORE_PLAYER player1 ON
			SWITCH_WIDESCREEN ON
			SET_FADING_COLOUR 0 0 1
			DO_FADE 250 FADE_OUT
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE
			GET_GAME_TIMER timer_intro_start
			SET_FIXED_CAMERA_POSITION -916.4 -330.55 15.86 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT -922.5 -338.75 13.44 JUMP_CUT
			SWITCH_SECURITY_CAMERA ON
			DO_FADE 250 FADE_IN
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE

			PRINT_NOW ( EXIT_1 ) 5000 1
			
			WHILE flag_surveilance = 0
				WAIT 0
				GOSUB banK_job_timer
				IF intro_time_lapsed > 2000
				AND flag_surv_cam = 0
					SET_FIXED_CAMERA_POSITION -910.7 -351.9 16.0 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -901.5 -342.45 13.7 JUMP_CUT
					flag_surv_cam = 1
				ENDIF
				IF intro_time_lapsed > 4000
				AND flag_surv_cam = 1
					SET_FIXED_CAMERA_POSITION -926.3 -339.6 20.5 0.0 0.0 0.0
					//SET_FIXED_CAMERA_POSITION -955.2 -328.0 18.1 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -931.0 -345.9 17.47 JUMP_CUT
					//POINT_CAMERA_AT_POINT -945.8 -331.5 15.2 JUMP_CUT
					flag_surv_cam = 2
				ENDIF
				IF intro_time_lapsed > 6000
				AND flag_surv_cam = 2
					SET_FIXED_CAMERA_POSITION -959.0 -328.4 17.85 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -963.5 -334.6 15.6 JUMP_CUT
					flag_surv_cam = 3
				ENDIF
				IF intro_time_lapsed > 8000
				AND flag_surv_cam = 3
					SET_FIXED_CAMERA_POSITION -933.4 -340.23 9.5 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -936.67 -344.34 7.8 JUMP_CUT
					flag_surv_cam = 4
				ENDIF
				IF intro_time_lapsed > 10000
				AND flag_surv_cam = 4
					SET_FIXED_CAMERA_POSITION -936.8 -343.7 9.1 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -942.15 -343.74 7.4 JUMP_CUT
					flag_surv_cam = 5
				ENDIF
				IF intro_time_lapsed > 12000
				AND flag_surv_cam = 5
					SET_FIXED_CAMERA_POSITION -916.4 -330.55 15.86 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -922.5 -338.75 13.44 JUMP_CUT
					GET_GAME_TIMER timer_intro_start
					flag_surv_cam = 0
				ENDIF
				IF IS_BUTTON_PRESSED PAD1 CROSS
					flag_surveilance = 1
				ENDIF
			ENDWHILE
			WHILE IS_BUTTON_PRESSED PAD1 CROSS
				WAIT 0
			ENDWHILE
			DO_FADE 250 FADE_OUT
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE
			RESTORE_CAMERA_JUMPCUT
			SET_PLAYER_CONTROL player1 ON
			SET_EVERYONE_IGNORE_PLAYER player1 OFF
			SWITCH_WIDESCREEN OFF
			SWITCH_SECURITY_CAMERA OFF
			flag_surveilance = 0
			flag_surveilance_trigger = 1
			DO_FADE 250 FADE_IN
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE
		ENDIF
	ELSE
		flag_surveilance_trigger = 0
	ENDIF

RETURN



wanted_malarkey:
	IF flag_launch_hostage_attack = 0
		CLEAR_WANTED_LEVEL player1
	ENDIF
RETURN


Conversation_1:
audio_slot = 1

IF counter_conv1 = 0
	LOAD_MISSION_AUDIO audio_slot BNK4_1
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_1 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank
	LOAD_MISSION_AUDIO audio_slot BNK4_2
	GOSUB audio_bank_loading
	PRINT_NOW ( BNK4_2 ) 10000 1//rhubarb rhubarb
	GOSUB has_audio_finished_bank
	CLEAR_PRINTS
	counter_conv1 = 1
ENDIF
IF NOT IS_CAR_DEAD getaway_car
AND intro_time_lapsed > 20000
	IF IS_PLAYER_IN_CAR player1 getaway_car
	AND NOT IS_CHAR_DEAD phil
		IF IS_CHAR_IN_CAR phil getaway_car
		AND NOT IS_CHAR_DEAD hilary
			IF IS_CHAR_IN_CAR hilary getaway_car
			AND NOT IS_CHAR_DEAD cam
				IF IS_CHAR_IN_CAR cam getaway_car
					IF counter_conv1 = 6
						IF counter_conv2 < 1
							counter_conv2 = 1
						ENDIF
						counter_conv1 = 7
						GET_GAME_TIMER timer_intro_start
					ENDIF
					IF counter_conv1 = 5
						LOAD_MISSION_AUDIO audio_slot BNK4_3f
						GOSUB audio_bank_loading
						PRINT_NOW ( BNK4_3f ) 10000 1//rhubarb rhubarb
						GOSUB has_audio_finished_bank
						CLEAR_PRINTS
						counter_conv1 = 6
					ENDIF
					IF counter_conv1 = 4
						LOAD_MISSION_AUDIO audio_slot BNK4_3e
						GOSUB audio_bank_loading
						PRINT_NOW ( BNK4_3e ) 10000 1//rhubarb rhubarb
						GOSUB has_audio_finished_bank
						counter_conv1 = 5
					ENDIF
					IF counter_conv1 = 3
						LOAD_MISSION_AUDIO audio_slot BNK4_3d
						GOSUB audio_bank_loading
						PRINT_NOW ( BNK4_3d ) 10000 1//rhubarb rhubarb
						GOSUB has_audio_finished_bank
						counter_conv1 = 4
					ENDIF
					IF counter_conv1 = 2
						LOAD_MISSION_AUDIO audio_slot BNK4_3c
						GOSUB audio_bank_loading
						PRINT_NOW ( BNK4_3c ) 10000 1//rhubarb rhubarb
						GOSUB has_audio_finished_bank
						counter_conv1 = 3
					ENDIF
					IF counter_conv1 = 1
						LOAD_MISSION_AUDIO audio_slot BNK4_3b
						GOSUB audio_bank_loading
						PRINT_NOW ( BNK4_3b ) 10000 1//rhubarb rhubarb
						GOSUB has_audio_finished_bank
						counter_conv1 = 2
					ENDIF
				ELSE
					IF counter_conv1 < 6
					AND counter_conv1 > 1
						counter_conv1 = 7
						IF counter_conv2 < 1
							counter_conv2 = 1
							GET_GAME_TIMER timer_intro_start
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF	

RETURN



Conversation_2:
audio_slot = 1
IF intro_time_lapsed > 40000
AND counter_conv2 > 0
	IF NOT IS_CAR_DEAD getaway_car
		IF IS_PLAYER_IN_CAR player1 getaway_car
		AND NOT IS_CHAR_DEAD phil
			IF IS_CHAR_IN_CAR phil getaway_car
			AND NOT IS_CHAR_DEAD hilary
				IF IS_CHAR_IN_CAR hilary getaway_car
				AND NOT IS_CHAR_DEAD cam
					IF IS_CHAR_IN_CAR cam getaway_car
						IF counter_conv2 = 2
							LOAD_MISSION_AUDIO audio_slot BNK4_3j
							GOSUB audio_bank_loading
							PRINT_NOW ( BNK4_3j ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished_bank
							counter_conv2 = 3
						ENDIF
						IF counter_conv2 = 1
							LOAD_MISSION_AUDIO audio_slot BNK4_3i
							GOSUB audio_bank_loading
							PRINT_NOW ( BNK4_3i ) 10000 1//rhubarb rhubarb
							GOSUB has_audio_finished_bank
							CLEAR_PRINTS
							counter_conv2 = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
RETURN




Conversation_3:
audio_slot = 1

	counter_temp1 = counter_conv1
	counter_conv1 = 10
	counter_temp2 = counter_conv2
	counter_conv2 = 10
	
	IF counter_conv3 = 7
		LOAD_MISSION_AUDIO audio_slot BNK4_3u
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3u ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		flag_conv3 = 1
		counter_conv1 = counter_temp1
		counter_conv2 = counter_temp2
		counter_conv3 = 8
	ENDIF
	IF counter_conv3 = 6
		LOAD_MISSION_AUDIO audio_slot BNK4_3t
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3t ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		counter_conv3 = 7
	ENDIF
	IF counter_conv3 = 5
		LOAD_MISSION_AUDIO audio_slot BNK4_3s
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3s ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		CLEAR_PRINTS
		counter_conv3 = 6
	ENDIF
	IF counter_conv3 = 4
		LOAD_MISSION_AUDIO audio_slot BNK4_3r
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3r ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		counter_conv3 = 5
	ENDIF
	IF counter_conv3 = 3
		LOAD_MISSION_AUDIO audio_slot BNK4_3q
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3q ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		counter_conv3 = 4
	ENDIF
	IF counter_conv3 = 2
		LOAD_MISSION_AUDIO audio_slot BNK4_3p
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3p ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		counter_conv3 = 3
	ENDIF
	IF counter_conv3 = 1
		LOAD_MISSION_AUDIO audio_slot BNK4_3o
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3o ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		counter_conv3 = 2
	ENDIF
	IF counter_conv3 = 0
		LOAD_MISSION_AUDIO audio_slot BNK4_3m
		GOSUB audio_bank_loading
		PRINT_NOW ( BNK4_3m ) 10000 1//rhubarb rhubarb
		GOSUB has_audio_finished_bank
		counter_conv3 = 1
	ENDIF
	
RETURN


gas_canisters:
	var_gas = gas_1
	GOSUB gas_generator
	var_gas = gas_2
	GOSUB gas_generator
	var_gas = gas_3
	GOSUB gas_generator
	var_gas = gas_4
	GOSUB gas_generator
	var_gas = gas_5
	GOSUB gas_generator
	var_gas = gas_6
	GOSUB gas_generator
RETURN

gas_generator:
	GET_OBJECT_COORDINATES var_gas gas_x gas_y gas_z 
	//ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE gas_x gas_y gas_z 0.0 0.0 0.0 0.3 0 0 0 200
	
	GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS var_gas 0.0 0.0 0.2 gas_world_x gas_world_y gas_world_z
	gas_vect_x = gas_world_x - gas_x
	gas_vect_y = gas_world_y - gas_y
	gas_vect_z = gas_world_z - gas_z
	//ADD_MOVING_PARTICLE_EFFECT POBJECT_DRY_ICE gas_world_x gas_world_y gas_world_z 0.0 0.0 0.0 0.3 0 0 0 200
	CREATE_SINGLE_PARTICLE PARTICLE_TEARGAS gas_x gas_y gas_z gas_vect_x gas_vect_y gas_vect_z 0.3
	
RETURN
//ADD_MOVING_PARTICLE_EFFECT MovingParticleType X Y Z XSpeed YSpeed ZSpeed Radius R G B Time

going_up:
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 ON 

	SET_FADING_COLOUR 0 0 1

	DO_FADE 1500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		SLIDE_OBJECT lift_door_1 -936.964 -350.688 3.235 0.0 0.025 0.0 FALSE
		SLIDE_OBJECT lift_door_2  -936.964 -352.169 3.235 0.0 0.025 0.0 FALSE
	ENDWHILE


	SET_PLAYER_COORDINATES player1 -938.56 -351.5 16.8
	SET_PLAYER_HEADING player1 280.0
	SET_CAMERA_IN_FRONT_OF_PLAYER

	DO_FADE 1500 FADE_IN

	WHILE GET_FADING_STATUS
		WAIT 0
		SLIDE_OBJECT lift_door_1 -936.964 -349.488 3.235 0.0 0.025 0.0 FALSE
		SLIDE_OBJECT lift_door_2  -936.964 -353.369 3.235 0.0 0.025 0.0 FALSE
	ENDWHILE

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 OFF 
RETURN

going_down_pt1:
	SET_FADING_COLOUR 0 0 1

	DO_FADE 1500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
		SLIDE_OBJECT lift_door_1 -936.964 -350.688 3.235 0.0 0.025 0.0 FALSE
		SLIDE_OBJECT lift_door_2  -936.964 -352.169 3.235 0.0 0.025 0.0 FALSE
	ENDWHILE


	SET_PLAYER_COORDINATES player1 -937.84 -351.73 6.23
	SET_PLAYER_HEADING player1 280.0
	SET_CAMERA_IN_FRONT_OF_PLAYER
RETURN

going_down_pt2:
	DO_FADE 1500 FADE_IN

	WHILE GET_FADING_STATUS
		WAIT 0
		SLIDE_OBJECT lift_door_1 -936.964 -349.488 3.235 0.0 0.025 0.0 FALSE
		SLIDE_OBJECT lift_door_2  -936.964 -353.369 3.235 0.0 0.025 0.0 FALSE
	ENDWHILE

	SET_PLAYER_CONTROL player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 OFF 
RETURN
/*
flee_bank:
	IF flag_flee = 1
		IF NOT IS_CHAR_DEAD cashier1
			bank_manager = cashier1
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier2
			bank_manager = cashier2
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier3
			bank_manager = cashier3
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier4
			bank_manager = cashier4
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier5
			bank_manager = cashier5
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier6
			bank_manager = cashier6
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier7
			bank_manager = cashier7
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD cashier8
			bank_manager = cashier8
			GOSUB area_check_flee
		ENDIF

		IF NOT IS_CHAR_DEAD bank_cop_3
			bank_manager = bank_cop_3
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_2
			bank_manager = bank_cop_2
			GOSUB area_check_flee
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_1
			bank_manager = bank_cop_1
			GOSUB area_check_flee
		ENDIF
	ENDIF
	IF flag_flee = 0
		ADD_ROUTE_POINT 2 -923.0 -337.24 12.4
		ADD_ROUTE_POINT 2 -920.74 -339.78 12.4
		ADD_ROUTE_POINT 2 -900.0 -340.9 12.4
		IF NOT IS_CHAR_DEAD cashier1
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier1 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier2
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier2 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier3
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier3 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier4
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier4 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier5
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier5 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier6
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier6 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier7
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier7 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD cashier8
			SET_CHAR_OBJ_FOLLOW_ROUTE cashier8 2 FOLLOW_ROUTE_ONCE
		ENDIF

		IF NOT IS_CHAR_DEAD bank_cop_3
			SET_CHAR_OBJ_FOLLOW_ROUTE bank_cop_3 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_2
			SET_CHAR_OBJ_FOLLOW_ROUTE bank_cop_2 2 FOLLOW_ROUTE_ONCE
		ENDIF
		IF NOT IS_CHAR_DEAD bank_cop_1
			SET_CHAR_OBJ_FOLLOW_ROUTE bank_cop_1 2 FOLLOW_ROUTE_ONCE
		ENDIF
		flag_flee = 1
	ENDIF

RETURN

area_check_flee:
IF LOCATE_CHAR_ON_FOOT_3D bank_manager -900.0 -340.9 13.4 2.0 2.0 2.0 FALSE
	REMOVE_CHAR_ELEGANTLY bank_manager
ENDIF
RETURN
*/



}