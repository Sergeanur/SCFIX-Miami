MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Sergio 2*********************************** 
// *****************************************************************************************

// This mission is actually Avery Carrington 3: Two Bit Hit.

// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff
{
GOSUB mission_start_serg3
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_serg3_failed
ENDIF
GOSUB mission_cleanup_serg3
MISSION_END
 
// Variables for mission

VAR_INT car_1 car_3 car_4 car_5 car_6 //car_7 car_8 car_2
VAR_INT ped_7 ped_8	//fire_bomber
VAR_INT driver_1  driver_3 driver_4	//driver_2
VAR_INT gang_1 gang_2 //gang_3 gang_4

VAR_INT timer_start timer_now timer_dif chat_rnd chat_time
VAR_INT timer_reset_tex2 timer_current_tex2	timer_start_tex2 tex2_time_dif

VAR_INT flag_chat flag_alarm flag_switch flag_jobby	flag_fire_bomber //flag_fake_target 
VAR_INT flag_spotted flag_alarm_check flag_wait_state flag_print
VAR_INT flag_ped6 flag_ped7 //flag_ped8

VAR_INT flag_car4_dead flag_arm_ped7
VAR_INT var_tex2_car

VAR_FLOAT ped_group_x ped_group_y ped_group_heading //ped_zed
VAR_FLOAT car_4_x car_4_y car_4_z
//VAR_FLOAT firebomb_car_speed

VAR_INT haitian_coffin //flag_coffin_created

VAR_INT flag_route cuban_clothes_blip //firebomb_target player_car

VAR_INT timer_coffin_start coffin_time_lapsed	timer_coffin_now

//VAR_FLOAT fb_x fb_y fb_z firebomb_offset
//VAR_FLOAT vect_x vect_y vect_z 
VAR_FLOAT zed_check zed_check_2

//VAR_INT scripted_cut_limo

// LOCAL VARIABLES
LVAR_INT ped_1 ped_2 ped_3 ped_4 ped_5 ped_6
LVAR_INT bodyguard_1 bodyguard_2
LVAR_FLOAT ped4_x ped4_y ped5_x ped5_y //ped6_x ped6_y  
LVAR_FLOAT min_x min_y max_x max_y

// ********** 'EXCLUSIVE' variables ******************************************************

//VAR_INT cut_limo
//VAR_INT  mission_blip1
//VAR_FLOAT ped1_x ped1_y ped2_x ped2_y ped3_x ped3_y	ped_zed

// ****************************************Mission Start************************************

mission_start_serg3:
REGISTER_MISSION_GIVEN
flag_player_on_mission = 1
SCRIPT_NAME serg2
LOAD_MISSION_TEXT SERG2 
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 252.7968 -230.9387 9.8638 333.9001

WAIT 0
FORCE_WEATHER_NOW WEATHER_SUNNY
RELEASE_WEATHER



/*
WAIT 500

IF NOT IS_CHAR_DEAD scplayer
AND IS_PLAYER_WEARING player1 player5 // SCFIX: add specific skin check

	UNDRESS_CHAR scplayer player

	LOAD_ALL_MODELS_NOW

	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF

ENDIF

DO_FADE 1500 FADE_IN
*/
// *****************************************Set Flags/variables************************************

flag_chat = 0

flag_alarm = 0
flag_switch = 0
flag_jobby = 0
flag_spotted = 0
flag_print = 0
flag_alarm_check = 0
flag_wait_state = 0

flag_ped6 = 0
flag_ped7 = 0
//flag_ped8 = 0

chat_rnd = 0
chat_time = 0
//flag_serg3 = 0

flag_fire_bomber = 0
//flag_fake_target = 0
flag_route = 0
//flag_coffin_created = 0

flag_car4_dead = 0
flag_arm_ped7 = 0

// *******************************************Set Coords*****************************************

clothes_shopX =	-1021.94
clothes_shopY =	-428.68
clothes_shopZ =	10.0


ped_zed = 10.5

ped1_x = -1064.0
ped1_y = 57.0

ped2_x = -1056.0
ped2_y = 52.0

ped3_x = -1037.7
ped3_y = 70.0

ped4_x = -1055.0
ped4_y = 26.0

ped5_x = -1064.0
ped5_y = 40.0
/*

ped6_x
ped6_y 
*/

ped_group_x	= -1046.9
ped_group_y	= 71.3
ped_group_heading = 60.0

min_x = -1090.0
max_x = -1030.0
min_y = 0.0
max_y = 90.0

timer_reset_tex2 = 0
timer_current_tex2 = 0
timer_start_tex2 = 0
tex2_time_dif = 0


// ********************************** SCRIPTED CUT - AVERY'S STRETCH ARRIVES ***************

SET_PLAYER_CONTROL player1 OFF // SCFIX

CLEAR_AREA 299.0 -205.0 10.5 5.0 TRUE
CLEAR_AREA 305.0 -219.5 10.5 10.0 TRUE
REQUEST_COLLISION 299.0 -205.0
SET_PLAYER_COORDINATES player1 299.0 -205.0 10.5
SET_PLAYER_HEADING player1 230.0
SET_FIXED_CAMERA_POSITION 297.0 -204.7 13.0 0.0 0.0 0.0
POINT_CAMERA_AT_POINT 318.5 -219.23 22.4 JUMP_CUT
REQUEST_MODEL stretch
LOAD_SCENE 270.0 -218.0 13.4
WHILE NOT HAS_MODEL_LOADED stretch
	WAIT 0
ENDWHILE

CLEAR_AREA 306.9 -241.65 12.3 15.0 TRUE
CREATE_CAR stretch 306.9 -241.65 12.3 scripted_cut_limo
CHANGE_CAR_COLOUR scripted_cut_limo 0 0
SET_CAR_HEADING scripted_cut_limo 0.0

SWITCH_WIDESCREEN ON

DO_FADE 1500 FADE_IN
WHILE GET_FADING_STATUS 
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	SET_CAR_FORWARD_SPEED scripted_cut_limo 15.0
	SET_CAR_TEMP_ACTION scripted_cut_limo TEMPACT_GOFORWARD 8000
ENDIF
timera = 0
WHILE timera < 1000
	WAIT 0
ENDWHILE

IF NOT IS_CAR_DEAD scripted_cut_limo
	POINT_CAMERA_AT_CAR scripted_cut_limo FIXED INTERPOLATION
ENDIF
timera = 0
WHILE timera < 3000
	WAIT 0
ENDWHILE
IF NOT IS_CAR_DEAD scripted_cut_limo
	GET_CAR_COORDINATES scripted_cut_limo vect_x vect_y vect_z
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer vect_x vect_y   
ENDIF
DO_FADE 1500 FADE_OUT
WHILE GET_FADING_STATUS 
	WAIT 0
ENDWHILE
DELETE_CAR scripted_cut_limo
MARK_MODEL_AS_NO_LONGER_NEEDED stretch
RESTORE_CAMERA
SET_CHAR_OBJ_NO_OBJ scplayer
CHAR_SET_IDLE scplayer



// ****************************************START OF CUTSCENE********************************
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSavery
LOAD_SPECIAL_CHARACTER 3 CSdlove

LOAD_SPECIAL_MODEL CUTOBJ01 cs_limo
//LOAD_SPECIAL_MODEL cut_obj2 LAWYERH

LOAD_SCENE 305.2 -211.9 11.3

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0

ENDWHILE

LOAD_CUTSCENE tex_2

SET_CUTSCENE_OFFSET 305.2 -211.9 11.3
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_avery
SET_CUTSCENE_ANIM cs_avery CSavery

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_dlove
SET_CUTSCENE_ANIM cs_dlove CSdlove

CREATE_CUTSCENE_OBJECT CUTOBJ01 cut_limo
SET_CUTSCENE_ANIM cut_limo cs_limo
//CREATE_CUTSCENE_HEAD cs_ken CUT_OBJ2 cs_kenhead
//SET_CUTSCENE_HEAD_ANIM cs_kenhead lawyer

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player1

//hide player
CLEAR_AREA 265.129 -234.531 11.107 1.0 TRUE
SET_PLAYER_COORDINATES player1 265.129 -234.531 11.107
SET_PLAYER_HEADING player1 78.218376

//SET_AREA_VISIBLE VIS_STRIP_CLUB

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text


GET_CUTSCENE_TIME cs_time


WHILE cs_time < 574
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_A ) 10000 1 //Tommy, this is Donald Love. Donald, this here is Tommy Vercetti, 
 
WHILE cs_time < 4124   
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_B ) 10000 1 //the latest gunslinger to come to these parts.

WHILE cs_time <  6167
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_C ) 10000 1 //Yeh...uh...
  
WHILE cs_time < 6740
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_D ) 10000 1 //Donald, you just shut up and listen, and you might learn something. 

WHILE cs_time < 10018
 	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_E ) 10000 1 //Now, nothing brings down real estate prices quicker than a good old-fashioned gang war -

WHILE cs_time < 14794
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_F ) 10000 1 //'cept  maybe a disaster,  like a biblical plague or something,

WHILE cs_time < 17966
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_G ) 10000 1 //but, that may be going too far in this case.

WHILE cs_time < 20378
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_H ) 10000 1 //You getting this down, you four-eyed prick? 

WHILE cs_time < 23680
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_I ) 10000 1 //Now recently a Haitian gang lord died. Apparently a rival gang did it, nobody's certain.

WHILE cs_time < 28473
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_J ) 10000 1 //But let's make them certain! You disguise yourself as a Cuban hombre,
  
WHILE cs_time < 31827
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_K ) 10000 1 //and head on down to crash that funeral. Mix it up, and then high tail it.

WHILE cs_time < 35494
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_L ) 10000 1 //You getting this down, Donald? 

WHILE cs_time < 37278
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_M ) 10000 1 //Well, that ought to put the coyote in the chicken coop, huh? 

WHILE cs_time < 40242
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( TEX2_N ) 10000 1 //And then we'll just sit back, and watch the prices tumble. 
   
WHILE cs_time < 43214
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

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

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01

SET_AREA_VISIBLE VIS_MAIN_MAP
SET_PLAYER_CONTROL player1 ON // SCFIX

DO_FADE 1500 FADE_IN

// ******************************************END OF CUTSCENE********************************




// Mission stuff goes here
// ***************************** TEST STUFF !!!!!! *************************************
/*
SWITCH_PED_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
SWITCH_PED_ROADS_ON -230.0 -464.5 10.0 56.85 -459.8 20.0 // Star Island gates ocean beach
SWITCH_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates     mainland
SWITCH_ROADS_ON -230.0 -464.5 10.0 165.85 -459.8 20.0 // Star Island gates ocean beach
DELETE_OBJECT star_gate_1
DELETE_OBJECT star_gate_2
CREATE_OBJECT_NO_OFFSET comgate1open -715.042 -489.0 12.615 star_gate_1
SET_OBJECT_HEADING star_gate_1 3.0
DONT_REMOVE_OBJECT star_gate_1
CREATE_OBJECT_NO_OFFSET comgate2open -181.402 -472.859 12.615 star_gate_2
SET_OBJECT_HEADING star_gate_2 12.5
DONT_REMOVE_OBJECT star_gate_2
*/


//------------------REQUEST_MODELS ------------------------------

SWITCH_WIDESCREEN OFF

REQUEST_MODEL HNA
REQUEST_MODEL HNB
REQUEST_MODEL tec9

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED HNA
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED HNB
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED tec9
	WAIT 0
ENDWHILE

// ------------------------MISSION-------------------------------

IF NOT IS_PLAYER_WEARING player1 player5
	// ********************GET NEW COSTUME****************************
	PRINT_NOW ( TEX_2c ) 5000 1	//GET A CHANGE OF CLOTHES

	ADD_SPRITE_BLIP_FOR_COORD clothes_shopX clothes_shopY clothes_shopZ RADAR_SPRITE_TSHIRT cuban_clothes_blip

	WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 clothes_shopX clothes_shopY clothes_shopZ 1.2 1.2 3.0 TRUE
		WAIT 0

	ENDWHILE

	REMOVE_BLIP cuban_clothes_blip

	// **************************************(START) CHANGE OF CLOTHES CUT SCENE*********************************************

	SET_PLAYER_CONTROL player1 OFF
	SWITCH_WIDESCREEN ON
	CLEAR_WANTED_LEVEL player1
	//SET_FIXED_CAMERA_POSITION -1019.7 -428.3 11.5 0.0 0.0 0.0
	//POINT_CAMERA_AT_PLAYER player1 FIXED JUMP_CUT

	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -1026.1 -429.5

	SET_FADING_COLOUR 0 0 1

	DO_FADE 1500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	IF NOT IS_CHAR_DEAD scplayer
		UNDRESS_CHAR scplayer player5
		LOAD_ALL_MODELS_NOW
		IF NOT IS_CHAR_DEAD scplayer
			DRESS_CHAR scplayer
		ENDIF
	ENDIF

	SET_CHAR_OBJ_NO_OBJ scplayer
	SET_PLAYER_COORDINATES player1 -1023.5 -429.0 10.0
	SET_PLAYER_HEADING player1 280.0
	RESTORE_CAMERA_JUMPCUT
	SET_CAMERA_IN_FRONT_OF_PLAYER
	CLEAR_AREA clothes_shopX clothes_shopY clothes_shopZ 1.0 FALSE
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -1019.4 -428.3

	DO_FADE 1500 FADE_IN

	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	SET_CHAR_OBJ_NO_OBJ scplayer
	CHAR_SET_IDLE scplayer
	SET_PLAYER_CONTROL player1 ON
	SWITCH_WIDESCREEN OFF

	// **********************CREATE CARS AND PEDS & GET TO FUNERAL***************************
ENDIF


PRINT_NOW (TEX_2d) 10000	1

SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
ADD_BLIP_FOR_COORD ped_group_x ped_group_y 20.0 mission_blip1
SWITCH_ROADS_OFF min_x min_y 14.0 max_x max_y 20.0

ground_z = 0.0000
WHILE ground_z = 0.0000
	WAIT 0
	GET_GROUND_Z_FOR_3D_COORD ped_group_x ped_group_y 50.0 ground_z
ENDWHILE

/*
WHILE NOT IS_PLAYER_IN_ZONE player1 HAITI
	WAIT 0
ENDWHILE
*/
SET_CAR_DENSITY_MULTIPLIER 0.0


REQUEST_MODEL ROMERO
WHILE NOT HAS_MODEL_LOADED ROMERO
	WAIT 0
ENDWHILE
REQUEST_MODEL VOODOO 
WHILE NOT HAS_MODEL_LOADED VOODOO
	WAIT 0
ENDWHILE

REQUEST_MODEL faketarget
WHILE NOT HAS_MODEL_LOADED faketarget
	WAIT 0
ENDWHILE

REQUEST_MODEL M4
WHILE NOT HAS_MODEL_LOADED M4
	WAIT 0
ENDWHILE

REQUEST_MODEL jw_coffin
WHILE NOT HAS_MODEL_LOADED jw_coffin
	WAIT 0
ENDWHILE

CREATE_CAR VOODOO -1063.0 40.0 11.0 car_1
SET_CAR_HEADING car_1 180.0
CHANGE_CAR_COLOUR car_1 0 0
CREATE_CHAR_INSIDE_CAR car_1 PEDTYPE_GANG_HAITIAN HNB driver_1
CLEAR_CHAR_THREAT_SEARCH driver_1
CAR_SET_IDLE car_1
/* 
CREATE_CAR VOODOO -1063.0 25.0 11.0 car_2
SET_CAR_HEADING car_2 180.0
CHANGE_CAR_COLOUR car_2 0 0
CREATE_CHAR_INSIDE_CAR car_2 PEDTYPE_GANG_HAITIAN HNB driver_2
CLEAR_CHAR_THREAT_SEARCH driver_2
CAR_SET_IDLE car_2
*/
CREATE_CAR ROMERO -1063.0 55.0 11.0 car_3
SET_CAR_HEADING car_3 180.0
CHANGE_CAR_COLOUR car_3 0 0
CREATE_CHAR_INSIDE_CAR car_3 PEDTYPE_GANG_HAITIAN HNA driver_3
CLEAR_CHAR_THREAT_SEARCH driver_3
SET_CAR_HEALTH car_3 2000
CAR_SET_IDLE car_3

CREATE_CAR ROMERO -1057.05 69.64 11.05 car_4
SET_CAR_HEADING car_4 90.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER car_4 TRUE
CREATE_CHAR_INSIDE_CAR car_4 PEDTYPE_GANG_HAITIAN HNA driver_4
		   
		   
CLEAR_CHAR_THREAT_SEARCH driver_4
CAR_SET_IDLE car_4
SET_CAR_PROOFS car_4 0 1 0 0 0
SET_CAR_HEALTH car_4 1500
SET_CAR_HEAVY car_4 TRUE
//POP_CAR_BOOT car_4

CREATE_CAR VOODOO -1070.0 18.6 11.0 car_5
SET_CAR_HEADING car_5 270.0
CREATE_CHAR_INSIDE_CAR car_5 PEDTYPE_GANG_HAITIAN HNB gang_1
CLEAR_CHAR_THREAT_SEARCH gang_1
CAR_SET_IDLE car_5

CREATE_CAR VOODOO -1070.0 75.4 11.0 car_6
SET_CAR_HEADING car_6 270.0
CREATE_CHAR_INSIDE_CAR car_6 PEDTYPE_GANG_HAITIAN HNB gang_2
CLEAR_CHAR_THREAT_SEARCH gang_2
CAR_SET_IDLE car_6

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNB ped1_x ped1_y ped_zed ped_1
SET_CHAR_PERSONALITY ped_1 PEDSTAT_TOUGH_GUY
//SET_CHAR_THREAT_SEARCH ped_1 THREAT_PLAYER1
SET_CHAR_HEADING ped_1 75.0 
GIVE_WEAPON_TO_CHAR ped_1 WEAPONTYPE_tec9	9999
SET_CHAR_WAIT_STATE ped_1 WAITSTATE_LOOK_ABOUT 999999
 
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNA ped2_x ped2_y ped_zed ped_2
SET_CHAR_PERSONALITY ped_2 PEDSTAT_TOUGH_GUY
//SET_CHAR_THREAT_SEARCH ped_2 THREAT_PLAYER1
SET_CHAR_HEADING ped_2 12.0
GIVE_WEAPON_TO_CHAR ped_2 WEAPONTYPE_tec9	9999
SET_CHAR_WAIT_STATE ped_2 WAITSTATE_CROSS_ROAD_LOOK 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNB ped3_x ped3_y ped_zed ped_3
SET_CHAR_PERSONALITY ped_3 PEDSTAT_TOUGH_GUY
//SET_CHAR_THREAT_SEARCH ped_3 THREAT_PLAYER1
SET_CHAR_HEADING ped_3 280.0 
GIVE_WEAPON_TO_CHAR ped_3 WEAPONTYPE_m4	9999
CLEAR_CHAR_THREAT_SEARCH ped_3
SET_CHAR_THREAT_SEARCH ped_3 THREAT_PLAYER1
SET_CHAR_HEED_THREATS ped_3 TRUE
SET_CHAR_WAIT_STATE ped_3 WAITSTATE_LOOK_ABOUT 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNA ped4_x ped4_y ped_zed ped_4
SET_CHAR_PERSONALITY ped_4 PEDSTAT_TOUGH_GUY
//SET_CHAR_THREAT_SEARCH ped_4 THREAT_PLAYER1
SET_CHAR_HEADING ped_4 165.0
GIVE_WEAPON_TO_CHAR ped_4 WEAPONTYPE_tec9	9999
SET_CHAR_WAIT_STATE ped_4 WAITSTATE_LOOK_ABOUT 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNB ped5_x ped5_y ped_zed ped_5
SET_CHAR_PERSONALITY ped_5 PEDSTAT_TOUGH_GUY
//SET_CHAR_THREAT_SEARCH ped_5 THREAT_PLAYER1
SET_CHAR_HEADING ped_5 97.0
GIVE_WEAPON_TO_CHAR ped_5 WEAPONTYPE_tec9	9999
SET_CHAR_WAIT_STATE ped_5 WAITSTATE_CROSS_ROAD_LOOK 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNA -1047.8 54.8 13.3 bodyguard_1
SET_CHAR_PERSONALITY bodyguard_1 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH bodyguard_1 THREAT_PLAYER1
SET_CHAR_HEADING bodyguard_1 140.0
SET_CHAR_STAY_IN_SAME_PLACE bodyguard_1 TRUE
GIVE_WEAPON_TO_CHAR bodyguard_1 WEAPONTYPE_M4	9999
SET_CHAR_WAIT_STATE bodyguard_1 WAITSTATE_LOOK_ABOUT 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNA -1042.44 64.96 15.5 bodyguard_2
SET_CHAR_PERSONALITY bodyguard_2 PEDSTAT_TOUGH_GUY
SET_CHAR_THREAT_SEARCH bodyguard_2 THREAT_PLAYER1
SET_CHAR_HEADING bodyguard_2 80.0
SET_CHAR_STAY_IN_SAME_PLACE bodyguard_1 TRUE
GIVE_WEAPON_TO_CHAR bodyguard_2 WEAPONTYPE_M4	9999
SET_CHAR_WAIT_STATE bodyguard_2 WAITSTATE_LOOK_ABOUT 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNA ped_group_x ped_group_y ped_zed ped_7
CLEAR_CHAR_THREAT_SEARCH ped_7
//SET_CHAR_PERSONALITY ped_7 PEDSTAT_TOUGH_GUY
SET_CHAR_HEADING ped_7 ped_group_heading
//GIVE_WEAPON_TO_CHAR ped_7 WEAPONTYPE_tec9	60
SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped_7 TRUE

ped_group_x	= ped_group_x - 1.0
ped_group_y	= ped_group_y +	1.0

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNB ped_group_x ped_group_y ped_zed ped_6
CLEAR_CHAR_THREAT_SEARCH ped_6
//SET_CHAR_PERSONALITY ped_6 PEDSTAT_TOUGH_GUY
TURN_CHAR_TO_FACE_CHAR ped_6 ped_7
//GIVE_WEAPON_TO_CHAR ped_6 WEAPONTYPE_tec9	60

ped_group_x	= ped_group_x + 1.0
//ped_group_y	= ped_group_y - 1.0

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNB ped_group_x ped_group_y ped_zed ped_8
CLEAR_CHAR_THREAT_SEARCH ped_8
//SET_CHAR_PERSONALITY ped_8 PEDSTAT_TOUGH_GUY
TURN_CHAR_TO_FACE_CHAR ped_8 ped_7
//GIVE_WEAPON_TO_CHAR ped_8 WEAPONTYPE_tec9	60

REMOVE_BLIP mission_blip1

ADD_BLIP_FOR_CHAR ped_7 mission_blip1

GET_GAME_TIMER timer_start

WHILE NOT IS_PLAYER_IN_AREA_2D player1 min_x min_y max_x max_y FALSE //waiting for Player to enter area or to kill someone from a far.
AND flag_alarm = 0
	WAIT 0
	GOSUB alarm_check
	GOSUB pedchat
	GOSUB ostrich
	GOSUB traffic_density
ENDWHILE

flag_alarm_check = 1
//GET_GAME_TIMER timer_start

WHILE flag_alarm = 0 // Player in area. check for firing weapon, or getting too close whilst armed with weapon, or getting way too close
	WAIT 0
	GOSUB alarm_check
	IF IS_CHAR_DEAD ped_7
		GOTO did_goons_spot_player
	ENDIF
	GOSUB ostrich
	GOSUB pedchat
	GOSUB traffic_density
ENDWHILE

WHILE NOT IS_PLAYER_DEAD player1
	WAIT 0
	GOSUB alarm_check
	
		
	IF LOCATE_PLAYER_ON_FOOT_2D player1 ped_group_x ped_group_y 30.0 40.0 FALSE
	OR LOCATE_PLAYER_IN_CAR_2D player1 ped_group_x ped_group_y 10.0 15.0 FALSE
		IF IS_PLAYER_WEARING player1 player5
			GOSUB spotted
		ENDIF
	ENDIF
	
	IF NOT IS_PLAYER_IN_AREA_2D player1 min_x min_y max_x max_y FALSE
	AND flag_alarm < 2
		IF NOT IS_CHAR_DEAD ped_2
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT ped_2 ped2_x ped2_y
		ENDIF
		IF NOT IS_CHAR_DEAD ped_4
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT ped_4 ped4_x ped4_y
		ENDIF
	ENDIF
		
	GOSUB pedchat

	GOSUB ostrich

	IF NOT IS_CHAR_DEAD ped_7
		IF NOT IS_CAR_DEAD car_4
			IF IS_CHAR_IN_CAR ped_7 car_4
				var_tex2_car = car_4
				GOSUB tex2_car_routine
				IF NOT IS_CHAR_IN_AREA_2D ped_7 min_x min_y max_x max_y FALSE
					GOSUB flaming_coffins
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CAR_DEAD car_3
			AND NOT IS_CHAR_DEAD ped_7
				IF LOCATE_CHAR_ANY_MEANS_CAR_2D ped_7 car_3 30.0 30.0 FALSE
				AND NOT IS_CHAR_IN_CAR ped_7 car_3
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER ped_7 car_3
				ENDIF
				IF IS_CHAR_IN_CAR ped_7 car_3
					var_tex2_car = car_3
					GOSUB tex2_car_routine
					IF NOT IS_CHAR_IN_AREA_2D ped_7 min_x min_y max_x max_y FALSE
						GOSUB flaming_coffins
					ENDIF

					IF flag_ped7 = 1
						IF NOT IS_CAR_HEALTH_GREATER car_3 350
							SET_CHAR_OBJ_LEAVE_CAR ped_7 car_3
							SET_CAR_CRUISE_SPEED car_3 0.0
							IF NOT IS_CHAR_DEAD driver_3
								GIVE_WEAPON_TO_CHAR driver_3 WEAPONTYPE_tec9 60
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT driver_3 player1
								//SET_CHAR_OBJ_LEAVE_CAR driver_1 car_1
								//SET_CHAR_THREAT_SEARCH driver_1 THREAT_PLAYER1
							ENDIF
							flag_ped7 = 2
						ENDIF
					ENDIF
					IF flag_ped7 = 0
						SET_CAR_CRUISE_SPEED car_3 40.0
						SET_CAR_DRIVING_STYLE car_3 3
						CAR_WANDER_RANDOMLY car_3
						flag_ped7 = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		GOTO did_goons_spot_player
	ENDIF
		
	IF IS_CAR_DEAD car_4
	AND flag_car4_dead = 0
		flag_ped7 = 0
		flag_car4_dead = 1
	ENDIF
	IF flag_ped7 = 2
		IF NOT IS_CHAR_IN_ANY_CAR ped_7
			IF flag_arm_ped7 = 0
				SET_CHAR_THREAT_SEARCH ped_7 THREAT_PLAYER1
				SET_CHAR_HEED_THREATS ped_7 TRUE
				TURN_CHAR_TO_FACE_PLAYER ped_7 player1
				GIVE_WEAPON_TO_CHAR ped_7 WEAPONTYPE_M4 9999
				flag_arm_ped7 = 1
			ENDIF
			flag_ped7 = 3
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD ped_6
		IF NOT IS_CAR_DEAD car_1
			IF IS_CHAR_IN_CAR ped_6 car_1
			AND flag_ped6 = 0
				SET_CAR_CRUISE_SPEED car_1 40.0
				SET_CAR_DRIVING_STYLE car_1 2
				SET_CAR_MISSION car_1 MISSION_RAMPLAYER_FARAWAY
				flag_ped6 = 1
			ENDIF
		ENDIF
	ELSE
		IF NOT IS_CAR_DEAD car_1
		AND flag_ped6 = 0
			SET_CAR_CRUISE_SPEED car_1 40.0
			SET_CAR_DRIVING_STYLE car_1 2
			SET_CAR_MISSION car_1 MISSION_RAMPLAYER_FARAWAY
			flag_ped6 = 1
		ENDIF
	ENDIF
	GOSUB traffic_density
ENDWHILE



did_goons_spot_player:
REMOVE_BLIP	mission_blip1
flag_alarm = 3
timer_dif = 7000
GOSUB ostrich

IF flag_spotted = 0
	PRINT_NOW ( TEX_2b ) 5000 1	//You failed to get spotted!	
	GOTO mission_serg3_failed
ENDIF

WHILE IS_PLAYER_IN_ZONE player1 HAITI
	WAIT 0
	GOSUB traffic_density
	PRINT_NOW TEXEXIT 1000 1 // Now get out of Haiti!
ENDWHILE

GOTO mission_serg3_passed
	   		


// Mission Ray2 failed

mission_serg3_failed:


PRINT_BIG ( M_FAIL ) 5000 1

RETURN

   

// mission Ray2 passed

mission_serg3_passed:

CREATE_CLOTHES_PICKUP -1025.2 -429.2 10.8 5 clothes_pickup5
clothes5_created = 1
START_NEW_SCRIPT cloth4
START_NEW_SCRIPT check_cuban_player // SCFIX

 


flag_sergio_mission3_passed = 1

//REMOVE_BLIP love_contact_blip
//ADD_SPRITE_BLIP_FOR_CONTACT_POINT loveX loveY loveZ RADAR_SPRITE_DON love_contact_blip

PRINT_WITH_NUMBER_BIG ( M_PASS ) 2500 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2500
REGISTER_MISSION_PASSED TEX_2
PLAYER_MADE_PROGRESS 1
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_GANG_CUBAN
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_CUBAN THREAT_GANG_HAITIAN

SET_ZONE_PED_INFO GHETTO1 DAY   (13) 60 100 0 0 0 0 0 0 0 20 //Haitians
SET_ZONE_PED_INFO GHETTO1 NIGHT (10) 80 100 0 0 0 0 0 0 0 10
SET_ZONE_CAR_INFO GHETTO1 DAY   (12) 60 100 0 0 0 0 0 0 0 10 
SET_ZONE_CAR_INFO GHETTO1 NIGHT (10) 80 100 0 0 0 0 0 0 0 10

SET_ZONE_PED_INFO GHETTO2 DAY   (13) 100 60 0 0 0 0 0 0 0 20 //Cubans
SET_ZONE_PED_INFO GHETTO2 NIGHT (10) 100 80 0 0 0 0 0 0 0 10
SET_ZONE_CAR_INFO GHETTO2 DAY   (12) 100 60 0 0 0 0 0 0 0 10 
SET_ZONE_CAR_INFO GHETTO2 NIGHT (10) 100 80 0 0 0 0 0 0 0 10

REMOVE_BLIP sergio_contact_blip 
 
//START_NEW_SCRIPT serg_mission3_loop
RETURN






		


// mission cleanup

mission_cleanup_serg3:


GET_GAME_TIMER timer_mobile_start

SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PLAYER_CONTROL player1 on
SWITCH_WIDESCREEN off
RESTORE_CAMERA_JUMPCUT 
SWITCH_ROADS_ON min_x min_y 14.0 max_x max_y 20.0

CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1

REMOVE_BLIP mission_blip1
REMOVE_BLIP cuban_clothes_blip
 
IF NOT IS_CHAR_DEAD ped_1
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_1 
ENDIF
IF NOT IS_CHAR_DEAD ped_2
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_2 
ENDIF
IF NOT IS_CHAR_DEAD ped_3
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_3 
ENDIF
IF NOT IS_CHAR_DEAD ped_4
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_4 
ENDIF
IF NOT IS_CHAR_DEAD ped_5
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_5 
ENDIF
IF NOT IS_CHAR_DEAD ped_6
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_6 
ENDIF
IF NOT IS_CHAR_DEAD ped_7
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_7 
ENDIF
IF NOT IS_CHAR_DEAD ped_8
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_8 
ENDIF
IF NOT IS_CHAR_DEAD gang_1
	MARK_CHAR_AS_NO_LONGER_NEEDED gang_1 
ENDIF
IF NOT IS_CHAR_DEAD gang_2
	MARK_CHAR_AS_NO_LONGER_NEEDED gang_2 
ENDIF
IF NOT IS_CHAR_DEAD bodyguard_1
	MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard_1 
ENDIF
IF NOT IS_CHAR_DEAD bodyguard_2
	MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard_2 
ENDIF

IF NOT IS_CHAR_DEAD driver_1
	MARK_CHAR_AS_NO_LONGER_NEEDED driver_1 
ENDIF
/*IF NOT IS_CHAR_DEAD driver_2
	MARK_CHAR_AS_NO_LONGER_NEEDED driver_2 
ENDIF*/
IF NOT IS_CHAR_DEAD driver_3
	MARK_CHAR_AS_NO_LONGER_NEEDED driver_3 
ENDIF
IF NOT IS_CHAR_DEAD driver_4
	MARK_CHAR_AS_NO_LONGER_NEEDED driver_4 
ENDIF
IF NOT IS_CAR_DEAD car_1
	MARK_CAR_AS_NO_LONGER_NEEDED car_1 
ENDIF
/*
IF NOT IS_CAR_DEAD car_2
	MARK_CAR_AS_NO_LONGER_NEEDED car_2 
ENDIF
*/
IF NOT IS_CAR_DEAD car_3
	MARK_CAR_AS_NO_LONGER_NEEDED car_3 
ENDIF
IF NOT IS_CAR_DEAD car_4
	MARK_CAR_AS_NO_LONGER_NEEDED car_4 
ENDIF
IF NOT IS_CAR_DEAD car_5
	MARK_CAR_AS_NO_LONGER_NEEDED car_5 
ENDIF
IF NOT IS_CAR_DEAD car_6
	MARK_CAR_AS_NO_LONGER_NEEDED car_6 
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED VOODOO 
MARK_MODEL_AS_NO_LONGER_NEEDED ROMERO 
MARK_MODEL_AS_NO_LONGER_NEEDED M4 
MARK_MODEL_AS_NO_LONGER_NEEDED HNA
MARK_MODEL_AS_NO_LONGER_NEEDED HNB 
MARK_MODEL_AS_NO_LONGER_NEEDED faketarget 
MARK_MODEL_AS_NO_LONGER_NEEDED jw_coffin 
MARK_MODEL_AS_NO_LONGER_NEEDED tec9 

//UNLOAD_SPECIAL_CHARACTER 1

flag_player_on_mission = 0


MISSION_HAS_FINISHED
RETURN
		

//---------------------------GOSUBS----------------GOSUBS---------------------------actuallydon'tchaknow



pedchat: // sets peds chatting until shots are fired or player1 comes too close with weapon. 

IF flag_alarm < 2

	GET_GAME_TIMER timer_now
	timer_dif = timer_now - timer_start
	
	IF timer_dif > 9000
		timer_dif = 0
		timer_start = timer_now
	ENDIF
	
	GENERATE_RANDOM_INT_IN_RANGE 1 13 chat_rnd
	chat_time = chat_rnd * 1000

	IF timer_dif < 3001
		IF flag_chat = 0
			GOSUB chat_choice
		ENDIF
	ENDIF
 	IF timer_dif < 6001
	AND timer_dif >3000
		IF flag_chat = 1
			GOSUB chat_choice
		ENDIF
	ENDIF
	IF timer_dif < 9001
	AND timer_dif > 6000
		IF flag_chat = 2
			GOSUB chat_choice
		ENDIF
	ENDIF
	
ENDIF

RETURN


ostrich: // Peds react

//IF flag_alarm_check = 1
	IF flag_alarm > 0
	AND flag_wait_state = 0
		IF NOT IS_CHAR_DEAD ped_2
			SET_CHAR_WAIT_STATE ped_2 WAITSTATE_FALSE 0
		ENDIF
		IF NOT IS_CHAR_DEAD ped_4
			SET_CHAR_WAIT_STATE ped_4 WAITSTATE_FALSE 0
		ENDIF
		IF NOT IS_CHAR_DEAD ped_1
			SET_CHAR_WAIT_STATE ped_1 WAITSTATE_FALSE 0
		ENDIF
		IF NOT IS_CHAR_DEAD ped_3
			SET_CHAR_WAIT_STATE ped_3 WAITSTATE_FALSE 0
		ENDIF
		IF NOT IS_CHAR_DEAD ped_5
			SET_CHAR_WAIT_STATE ped_5 WAITSTATE_FALSE 0
		ENDIF
		flag_wait_state = 1
	ENDIF

	IF flag_alarm = 1 // player1 approaching with weapon or approaching too close without weapon.
	AND flag_switch = 0
		
		// NOTE, play sound: "<warning>"
		
		IF NOT IS_CHAR_DEAD ped_2
			SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT ped_2 player1
		ENDIF
		IF NOT IS_CHAR_DEAD ped_4
			SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT ped_4 player1
		ENDIF
		IF NOT IS_CHAR_DEAD ped_1
			CHAR_LOOK_AT_PLAYER_ALWAYS ped_1 player1
		ENDIF
		IF NOT IS_CHAR_DEAD ped_3
			CHAR_LOOK_AT_PLAYER_ALWAYS ped_3 player1
		ENDIF
		IF NOT IS_CHAR_DEAD ped_5
			CHAR_LOOK_AT_PLAYER_ALWAYS ped_5 player1
		ENDIF
		flag_switch = 1
	ENDIF
//ENDIF

	IF flag_alarm = 2 // player1 firing shots or approaching too close with weapon. -initial ped reactions
	AND flag_switch < 2
		GET_GAME_TIMER timer_start
		
		// NOTE, play sound: "ASSASSIN!!!!"

		IF NOT IS_CHAR_DEAD ped_1
			SET_CHAR_WAIT_STATE ped_1 WAITSTATE_PLAYANIM_DUCK 3500
		ENDIF
		IF NOT IS_CHAR_DEAD ped_2
			IF flag_alarm_check = 1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_2 player1
			ELSE
				SET_CHAR_WAIT_STATE ped_2 WAITSTATE_PLAYANIM_DUCK 6000
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD ped_3
			SET_CHAR_WAIT_STATE ped_3 WAITSTATE_PLAYANIM_DUCK 6000
		ENDIF
		IF NOT IS_CHAR_DEAD ped_4
			IF flag_alarm_check = 1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_4 player1
			ELSE
				SET_CHAR_WAIT_STATE ped_4 WAITSTATE_PLAYANIM_DUCK 6000
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD ped_5
			SET_CHAR_WAIT_STATE ped_5 WAITSTATE_PLAYANIM_DUCK 3500
		ENDIF
		IF NOT IS_CHAR_DEAD ped_6
			SET_CHAR_WAIT_STATE ped_6 WAITSTATE_FALSE 0
			SET_CHAR_WAIT_STATE ped_6 WAITSTATE_PLAYANIM_DUCK 6000
			//SET_CHAR_WAIT_STATE ped_6 WAITSTATE_PLAYANIM_HANDSCOWER 6000
		ENDIF
		IF NOT IS_CHAR_DEAD ped_7
			SET_CHAR_WAIT_STATE ped_7 WAITSTATE_FALSE 0
			SET_CHAR_WAIT_STATE ped_7 WAITSTATE_PLAYANIM_DUCK 3000
			//GIVE_WEAPON_TO_CHAR ped_7 WEAPONTYPE_tec9 120
		ENDIF
		IF NOT IS_CHAR_DEAD ped_8
			SET_CHAR_WAIT_STATE ped_8 WAITSTATE_FALSE 0
			SET_CHAR_WAIT_STATE ped_8 WAITSTATE_PLAYANIM_DUCK 3500
			//SET_CHAR_WAIT_STATE ped_8 WAITSTATE_PLAYANIM_COWER 3500
		ENDIF

		flag_switch = 2
		flag_alarm = 3
	ENDIF

	IF flag_alarm = 3 // ped attack or run for life.
	AND flag_switch < 3
		GET_GAME_TIMER timer_now
		timer_dif = timer_now - timer_start

		IF timer_dif > 4000
		AND flag_jobby = 0
			IF NOT IS_CHAR_DEAD ped_1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_1 player1
			ENDIF
			
			IF NOT IS_CHAR_DEAD ped_5
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_5 player1
			ENDIF
			
			IF NOT IS_CHAR_DEAD gang_1
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS gang_1 player1
			ENDIF
			IF NOT IS_CHAR_DEAD gang_2
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS gang_2 player1
			ENDIF
			
			IF NOT IS_CHAR_DEAD ped_7
				SET_CHAR_OBJ_NO_OBJ ped_7
				SET_CHAR_WAIT_STATE ped_7 WAITSTATE_FALSE 0
				SET_CHAR_RUNNING ped_7 TRUE
				IF NOT IS_CAR_DEAD car_4
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER ped_7 car_4
				ELSE
					IF NOT IS_CAR_DEAD car_1
						SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER ped_7 car_1
					ENDIF
				ENDIF
			ENDIF
			
			IF NOT IS_CHAR_DEAD ped_8
				SET_CHAR_OBJ_NO_OBJ ped_8
				SET_CHAR_WAIT_STATE ped_8 WAITSTATE_FALSE 0
				/*
				IF NOT IS_CAR_DEAD car_2
					SET_CHAR_RUNNING ped_8 TRUE
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER ped_8 car_2
				ELSE
					GIVE_WEAPON_TO_CHAR ped_8 WEAPONTYPE_tec9 60
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_8 player1
				ENDIF*/
				GIVE_WEAPON_TO_CHAR ped_8 WEAPONTYPE_tec9 60
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_8 player1
			ENDIF
			flag_jobby = 1
		ENDIF
			
		IF timer_dif > 6500
		AND flag_jobby = 1
			IF NOT IS_CHAR_DEAD ped_3
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS ped_3 player1
			ENDIF
			
			IF NOT IS_CHAR_DEAD ped_6
				SET_CHAR_OBJ_NO_OBJ ped_6
				SET_CHAR_WAIT_STATE ped_6 WAITSTATE_FALSE 0
				IF NOT IS_CAR_DEAD car_1
					SET_CHAR_RUNNING ped_6 TRUE
					SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER ped_6 car_1
				ELSE
					SET_CHAR_OBJ_FLEE_ON_FOOT_TILL_SAFE ped_6
				ENDIF
			ENDIF
			flag_jobby = 2
			flag_switch = 3
		ENDIF
		
	ENDIF

RETURN



chat_choice:

IF chat_rnd > 0
AND chat_rnd < 5
	GOSUB chatsub_1
ENDIF
IF chat_rnd > 4
AND chat_rnd < 9
	GOSUB chatsub_2
ENDIF
IF chat_rnd > 8
AND chat_rnd < 13
	GOSUB chatsub_3
ENDIF


RETURN


chatsub_1:

	IF NOT IS_CHAR_DEAD ped_7
	AND NOT IS_CHAR_DEAD ped_6
		//SET_CHARS_CHATTING ped_7 ped_6 2900
		chat_time = chat_rnd * 1000
		STOP_CHAR_LOOKING ped_6
		STOP_CHAR_LOOKING ped_7
		SET_CHAR_WAIT_STATE ped_6 WAITSTATE_PLAYANIM_CHAT chat_time
		CHAR_LOOK_AT_CHAR_ALWAYS ped_6 ped_7
		CHAR_LOOK_AT_CHAR_ALWAYS ped_7 ped_6
		IF NOT IS_CHAR_DEAD ped_8
			STOP_CHAR_LOOKING ped_8
			CHAR_LOOK_AT_CHAR_ALWAYS ped_8 ped_6
		ENDIF
		++ flag_chat
		IF flag_chat > 2
			flag_chat = 0
		ENDIF
	ENDIF

RETURN

chatsub_2:

	IF NOT IS_CHAR_DEAD ped_7
	AND NOT IS_CHAR_DEAD ped_8
		//SET_CHARS_CHATTING ped_7 ped_6 2900
		chat_time = chat_rnd * 1000
		STOP_CHAR_LOOKING ped_8
		STOP_CHAR_LOOKING ped_7
		SET_CHAR_WAIT_STATE ped_7 WAITSTATE_PLAYANIM_CHAT chat_time
		CHAR_LOOK_AT_CHAR_ALWAYS ped_8 ped_7
		CHAR_LOOK_AT_CHAR_ALWAYS ped_7 ped_8
		IF NOT IS_CHAR_DEAD ped_6
			STOP_CHAR_LOOKING ped_6
			CHAR_LOOK_AT_CHAR_ALWAYS ped_6 ped_8
		ENDIF
		++ flag_chat
		IF flag_chat > 2
			flag_chat = 0
		ENDIF
	ENDIF

RETURN

chatsub_3:

	IF NOT IS_CHAR_DEAD ped_8
	AND NOT IS_CHAR_DEAD ped_6
		//SET_CHARS_CHATTING ped_7 ped_6 2900
		chat_time = chat_rnd * 750
		STOP_CHAR_LOOKING ped_6
		STOP_CHAR_LOOKING ped_8
		SET_CHAR_WAIT_STATE ped_8 WAITSTATE_PLAYANIM_CHAT chat_time
		CHAR_LOOK_AT_CHAR_ALWAYS ped_6 ped_8
		CHAR_LOOK_AT_CHAR_ALWAYS ped_8 ped_6
		IF NOT IS_CHAR_DEAD ped_7
			STOP_CHAR_LOOKING ped_7
			CHAR_LOOK_AT_CHAR_ALWAYS ped_7 ped_8
		ENDIF
		++ flag_chat
		IF flag_chat > 2
			flag_chat = 0
		ENDIF
	ENDIF

RETURN


alarm_check:

	IF flag_alarm < 3
		IF IS_CHAR_DEAD driver_1
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_1
		ENDIF
		//IF IS_CHAR_DEAD driver_2
		//	flag_alarm = 2
	   //	ENDIF
		IF IS_CHAR_DEAD driver_3
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_3
		ENDIF
		IF IS_CHAR_DEAD driver_4
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED driver_4
		ENDIF
		IF IS_CHAR_DEAD gang_1
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED gang_1
		ENDIF
		IF IS_CHAR_DEAD gang_2
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED gang_2
		ENDIF
		
		IF IS_CHAR_DEAD ped_1
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_1
		ENDIF
		IF IS_CHAR_DEAD ped_2
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_2
		ENDIF
		IF IS_CHAR_DEAD ped_3
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_3
		ENDIF
		IF IS_CHAR_DEAD ped_4
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_4
		ENDIF
		IF IS_CHAR_DEAD ped_5
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_5
		ENDIF
		IF IS_CHAR_DEAD ped_6
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_6
		ENDIF
		IF IS_CHAR_DEAD ped_7
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_7
		ENDIF
		IF IS_CHAR_DEAD ped_8
			flag_alarm = 2
			MARK_CHAR_AS_NO_LONGER_NEEDED ped_8
		ENDIF
	ENDIF
	IF flag_alarm_check = 1
		IF flag_alarm < 3
			IF IS_PLAYER_IN_MODEL player1 SANCHEZ 
			OR IS_PLAYER_IN_MODEL player1 PIZZABOY 
			OR IS_PLAYER_IN_MODEL player1 FAGGIO 
				IF IS_PLAYER_WEARING player1 player5
					GOSUB spotted
					IF flag_alarm < 2
						flag_alarm = 1
					ENDIF
				ENDIF
				
			ENDIF
			
			IF IS_PLAYER_IN_MODEL player1 FREEWAY 
			OR IS_PLAYER_IN_MODEL player1 PCJ600 
				IF IS_PLAYER_WEARING player1 player5
					GOSUB spotted
					flag_alarm = 1
				ENDIF
			ENDIF
			IF NOT IS_PLAYER_IN_ANY_CAR player1
				IF IS_PLAYER_WEARING player1 player5
					GOSUB spotted
					IF flag_alarm < 2
						flag_alarm = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF IS_PLAYER_IN_ANY_CAR player1
		AND NOT IS_PLAYER_ON_ANY_BIKE player1
			IF CHECK_FOR_PED_MODEL_AROUND_PLAYER player1 10.0 10.0 10.0 HNA HNB
				IF IS_PLAYER_WEARING player1 player5
					GOSUB spotted
				ENDIF
			ENDIF
		ELSE
			IF CHECK_FOR_PED_MODEL_AROUND_PLAYER player1 15.0 15.0 15.0 HNA HNB
				IF IS_PLAYER_WEARING player1 player5
					GOSUB spotted
				ENDIF
			ENDIF
		ENDIF	

		
		IF IS_PLAYER_IN_MODEL player1 CUBAN 
		AND flag_alarm < 3
			IF IS_PLAYER_WEARING player1 player5
				GOSUB spotted
			ENDIF
			flag_alarm = 2
		ENDIF
		
		IF IS_PLAYER_SHOOTING player1
		AND flag_alarm < 3
			flag_alarm = 2
		ENDIF

		IF NOT IS_CHAR_DEAD ped_7
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 ped_7 20.0 20.0 20.0 FALSE
			AND flag_alarm < 3
				IF IS_PLAYER_WEARING player1 player5
					GOSUB spotted
				ENDIF
				flag_alarm = 2
				IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
					flag_alarm = 3
				ENDIF
			ENDIF
		ENDIF
	ENDIF

RETURN


spotted:

	flag_spotted = 1
	IF flag_print = 0
		PRINT_NOW ( TEX_2a ) 5000 1	//EXCELLENT! YOU'VE BEEN SPOTTED!
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		flag_print = 1
	ENDIF

RETURN

traffic_density:
	IF NOT IS_CHAR_DEAD ped_7
		IF NOT IS_PLAYER_IN_AREA_2D player1 min_x min_y max_x max_y FALSE
		OR NOT IS_CHAR_IN_AREA_2D ped_7 min_x min_y max_x max_y FALSE
			SET_CAR_DENSITY_MULTIPLIER 1.0
		ENDIF
	ELSE
		SET_CAR_DENSITY_MULTIPLIER 1.0
	ENDIF

	IF NOT IS_PLAYER_IN_ZONE player1 HAITI
		MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard_1
		MARK_CHAR_AS_NO_LONGER_NEEDED bodyguard_2
	ENDIF

RETURN


flaming_coffins:
	IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 var_tex2_car	20.0 20.0 FALSE
		SET_CAR_CRUISE_SPEED var_tex2_car 30.0
	ELSE
		SET_CAR_CRUISE_SPEED var_tex2_car 20.0
	ENDIF

	// ))))))))))))))))))))))) COFFIN CODE (((((((((((((((((((((((((((((((((((((((((((
	IF flag_fire_bomber = 0
		SET_CAR_DENSITY_MULTIPLIER 1.0
		SET_CAR_HEAVY var_tex2_car FALSE 
		GET_CAR_COORDINATES var_tex2_car car_4_x car_4_y car_4_z
		GET_OFFSET_FROM_CAR_IN_WORLD_COORDS var_tex2_car 0.0 -15.0 0.0 vect_x vect_y zed_check
		vect_z = zed_check
		GET_GROUND_Z_FOR_3D_COORD vect_x vect_y zed_check zed_check
		zed_check_2 = car_4_z + 1.0
		IF zed_check < car_4_z
		AND LOCATE_PLAYER_ANY_MEANS_2D player1 vect_x vect_y 8.0 8.0 FALSE
			vect_x = vect_x - car_4_x
			vect_y = vect_y - car_4_y
			vect_z = vect_z - car_4_z
			vect_z = vect_z + 4.0
			CREATE_OBJECT jw_coffin car_4_x car_4_y car_4_z	haitian_coffin
			SET_OBJECT_COLLISION haitian_coffin TRUE
			SET_OBJECT_DYNAMIC haitian_coffin TRUE
			PLACE_OBJECT_RELATIVE_TO_CAR haitian_coffin var_tex2_car 0.0 -0.6 0.1
			SORT_OUT_OBJECT_COLLISION_WITH_CAR haitian_coffin var_tex2_car
			ADD_TO_OBJECT_VELOCITY haitian_coffin vect_x vect_y vect_z
			flag_fire_bomber = 1
		ENDIF
	ENDIF
	IF flag_fire_bomber = 1
		IF HAS_OBJECT_BEEN_DAMAGED haitian_coffin
			GET_OBJECT_COORDINATES haitian_coffin vect_x vect_y vect_z
			ADD_EXPLOSION vect_x vect_y vect_z EXPLOSION_MOLOTOV
			DELETE_OBJECT haitian_coffin
			flag_fire_bomber = 0
		ELSE
			IF NOT LOCATE_CHAR_ANY_MEANS_OBJECT_2D scplayer haitian_coffin 15.0 15.0 FALSE
				IF NOT IS_OBJECT_ON_SCREEN haitian_coffin
					DELETE_OBJECT haitian_coffin
					flag_fire_bomber = 2
					GET_GAME_TIMER timer_coffin_start 	
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	IF flag_fire_bomber = 2
		GET_GAME_TIMER timer_coffin_now
		coffin_time_lapsed = timer_coffin_now - timer_coffin_start
		IF coffin_time_lapsed > 3000
			 flag_fire_bomber = 0
		ENDIF
	ENDIF
	// )))))))))))))))))))))))))))))))((((((((((((((((((((((((((((((((((((((((((((((((((((

RETURN

tex2_car_routine:
	IF flag_ped7 = 0
		SET_CAR_CRUISE_SPEED var_tex2_car 15.0
		SET_CAR_DRIVING_STYLE var_tex2_car 2
		CAR_GOTO_COORDINATES var_tex2_car -1062.0 -117.0 11.0
		ADD_UPSIDEDOWN_CAR_CHECK var_tex2_car
		ADD_STUCK_CAR_CHECK var_tex2_car 1.5 2000
		POP_CAR_BOOT_USING_PHYSICS var_tex2_car
		//CAR_WANDER_RANDOMLY var_tex2_car
		//SET_CAR_TEMP_ACTION var_tex2_car TEMPACT_GOFORWARD 1500
		IF NOT IS_CAR_DEAD car_1
			SET_CAR_CRUISE_SPEED car_1 30.0
			SET_CAR_DRIVING_STYLE car_1 3
			SET_CAR_MISSION car_1 MISSION_RAMPLAYER_FARAWAY
		ENDIF
		flag_ped7 = 1
	ENDIF
	IF flag_ped7 = 1
		
		IF timer_reset_tex2 = 1
			IF NOT IS_CAR_STUCK var_tex2_car
				timer_reset_tex2 = 0
			ENDIF
		ENDIF
				
		IF IS_CAR_STUCK var_tex2_car
			IF timer_reset_tex2 = 0
				GET_GAME_TIMER timer_start_tex2
				timer_reset_tex2 = 1
			ENDIF

			IF timer_reset_tex2 = 1
				GET_GAME_TIMER timer_current_tex2
				tex2_time_dif = timer_current_tex2 - timer_start_tex2
				IF tex2_time_dif > 3000
					SET_CAR_TEMP_ACTION var_tex2_car TEMPACT_REVERSE 500
					timer_reset_tex2 = 0
				ENDIF
			ENDIF
		ELSE
			IF flag_route = 0
				IF LOCATE_CAR_2D var_tex2_car -1062.0 -117.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car -872.0 -284.0 11.0
					SET_CAR_CRUISE_SPEED var_tex2_car 25.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 1
				ENDIF	
			ENDIF
			IF flag_route = 1
				IF LOCATE_CAR_2D var_tex2_car -872.0 -284.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car -854.0 -498.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 2
				ENDIF	
			ENDIF
			IF flag_route = 2
				IF LOCATE_CAR_2D var_tex2_car -854.0 -498.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car 154.0 -445.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 3
				ENDIF	
			ENDIF
			IF flag_route = 3
				IF LOCATE_CAR_2D var_tex2_car 154.0 -445.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car 321.0 -54.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 4
				ENDIF	
			ENDIF
			IF flag_route = 4
				IF LOCATE_CAR_2D var_tex2_car 321.0 -54.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car 410.0 41.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 5
				ENDIF	
			ENDIF
			IF flag_route = 5
				IF LOCATE_CAR_2D var_tex2_car 410.0 41.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car 295.0 230.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 6
				ENDIF	
			ENDIF
			IF flag_route = 6
				IF LOCATE_CAR_2D var_tex2_car 295.0 230.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car -814.0 36.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 7
				ENDIF	
			ENDIF
			IF flag_route = 7
				IF LOCATE_CAR_2D var_tex2_car -814.0 36.0 10.0 10.0 FALSE
					CAR_GOTO_COORDINATES var_tex2_car -854.0 -498.0 11.0
					//CAR_WANDER_RANDOMLY var_tex2_car
					flag_route = 2
				ENDIF	
			ENDIF
		ENDIF
		

		IF NOT IS_CAR_HEALTH_GREATER var_tex2_car 350
		OR IS_CAR_STUCK_ON_ROOF var_tex2_car
		OR IS_PLAYER_IN_CAR player1 var_tex2_car
		//OR IS_CAR_STUCK var_tex2_car
			SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE ped_7 player1
			SET_CAR_CRUISE_SPEED var_tex2_car 0.0
			IF NOT IS_CHAR_DEAD driver_4
				GIVE_WEAPON_TO_CHAR driver_4 WEAPONTYPE_tec9 60
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT driver_4 player1
				//SET_CHAR_OBJ_LEAVE_CAR driver_4 var_tex2_car
				//SET_CHAR_THREAT_SEARCH driver_4 THREAT_PLAYER1
			ENDIF
			flag_ped7 = 2
		ENDIF
	ENDIF
RETURN

}
