MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Cuban 2*****************************************
// *****************************************Cannon Fodder***********************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME cuban2
// Mission start stuff
GOSUB mission_start_cuban2
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_cuban2
ENDIF
GOSUB mission_cleanup_cuban2
MISSION_END
 
// Variables for mission
//people, cars and objects
VAR_INT target1
VAR_INT haitian_defender1 
VAR_INT haitian_defender2
VAR_INT haitian_defender3
VAR_INT haitian_defender4
VAR_INT haitian_defender5
VAR_INT haitian_defender6
VAR_INT haitian_defender7
VAR_INT haitian_defender8
VAR_INT haitian_defender9
VAR_INT haitian_defender10
VAR_INT	cuban_attacker1
VAR_INT	cuban_attacker2
VAR_INT	cuban_attacker3
VAR_INT cuban_pickup1
VAR_INT cuban_pickup2
VAR_INT cuban_pickup3
VAR_INT cuban_carry_car 
VAR_INT death_car
VAR_INT target2
VAR_INT cuban_pickup4
VAR_INT cuban_pickup5
VAR_INT cuban_pickup6
VAR_INT escape_car_drugs
VAR_INT escape_car
VAR_INT taxi_dude
VAR_INT free_scope
VAR_INT fake_haitian1
VAR_INT fake_haitian2
VAR_INT fake_haitian3
VAR_INT crappy_car

//blips
VAR_INT cuban_pickup_blip
VAR_INT drop_off_point1 
VAR_INT radar_blip_cuban_carry_car
VAR_INT escape_car_blip
VAR_INT home_blip
VAR_INT cuban_blip1
VAR_INT cuban_blip2
VAR_INT cuban_blip3
VAR_INT cuban_blip4
VAR_INT cuban_blip5
VAR_INT sniper_blip

//flags
VAR_INT maxcubans_in_car
VAR_INT cubans_in_cars
VAR_INT car_emptied
VAR_INT flag_player_not_in_cuban_carry_car
VAR_INT flag_cuban_carry_car_upsidedown
VAR_INT cuban1_in
VAR_INT cuban2_in
VAR_INT cuban3_in
VAR_INT cuban4_in
VAR_INT cuban5_in
VAR_INT cuban6_in
VAR_INT haitians_doubled_flag 
VAR_INT creating_flag
VAR_INT number_of_haitians_dead 
VAR_INT completed_goal_flag
VAR_INT cub2_waiving_flag
VAR_INT cubans_out_of_car
VAR_INT cuban_crouch1 
VAR_INT cuban_crouch3 
VAR_INT cuban_attacker_doingstuff1
VAR_INT cuban_attacker_doingstuff2
VAR_INT cuban_attacker_doingstuff3
VAR_INT cuban_carry_car_old	
VAR_INT play_cub2_mission_audio
VAR_INT cuban_flag1 
VAR_INT cub2_cubans_killed1
VAR_INT cub2_cubans_killed2
VAR_INT body_count_cub2
VAR_INT ped_density_flag
VAR_INT hait_heading1
VAR_INT hait_heading2
VAR_INT hait_heading3
VAR_INT hait_heading4
VAR_INT hait_heading5
VAR_INT telling_guys_to_move
VAR_INT sniper_shot
VAR_INT fire_car_flag

//coordinates
VAR_FLOAT haitian1x
VAR_FLOAT haitian1y
VAR_FLOAT haitian2x
VAR_FLOAT haitian2y
VAR_FLOAT haitian3x 
VAR_FLOAT haitian3y 
VAR_FLOAT haitian4x
VAR_FLOAT haitian4y 
VAR_FLOAT haitian5x
VAR_FLOAT haitian5y 
VAR_FLOAT haitian_z 
VAR_FLOAT hd1_heading
VAR_FLOAT hd2_heading
VAR_FLOAT hd3_heading
VAR_FLOAT hd4_heading
VAR_FLOAT hd5_heading


// ****************************************Mission Start************************************
mission_start_cuban2:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT CUBAN2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1173.5 -599.6 10.2 277.1
// *****************************************Set Flags/variables************************************
maxcubans_in_car = 0
cubans_in_cars = 0
car_emptied = 0
flag_player_not_in_cuban_carry_car = 0
flag_cuban_carry_car_upsidedown = 0
cuban1_in = 0
cuban2_in = 0
cuban3_in = 0
cuban4_in = 0
cuban5_in = 0
cuban6_in = 0
haitians_doubled_flag = 0
creating_flag = 0
number_of_haitians_dead = 0
completed_goal_flag = 0
cub2_waiving_flag = 0
cubans_out_of_car = 0
cuban_crouch1 = 0
cuban_crouch3 = 0
blob_flag = 0
ped_density_flag = 0
hait_heading1 = 0
hait_heading2 = 0
hait_heading3 = 0
hait_heading4 = 0
hait_heading5 = 0
fire_car_flag = 0

cuban_attacker_doingstuff1 = 0
cuban_attacker_doingstuff2 = 0
cuban_attacker_doingstuff3 = 0

cuban_flag1 = 1 

haitian1x = -1115.8 
haitian1y = 61.7
haitian2x = -1115.7
haitian2y = 61.7
haitian3x = -1115.8
haitian3y = 77.2
haitian4x = -1139.3
haitian4y = 74.6
haitian5x = -1139.3
haitian5y = 67.0
haitian_z = 10.1
hd1_heading = 270.0
hd2_heading = 272.0
hd3_heading = 272.2
hd4_heading = 298.0
hd5_heading = 263.6

cuban_carry_car_old	= 0
play_cub2_mission_audio = 0

cub2_cubans_killed1 = 0
cub2_cubans_killed2 = 0
body_count_cub2 = 0
telling_guys_to_move = 0
sniper_shot = 0


// ****************************************START OF CUTSCENE********************************
SET_AREA_VISIBLE VIS_COFFEE_SHOP
CLEAR_AREA_OF_CHARS -1174.8 -609.0 10.4 -116.3 -632.5 15.3
SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSpablo
LOAD_SPECIAL_CHARACTER 3 CSpapa
LOAD_SPECIAL_CHARACTER 4 CSpepe
LOAD_SPECIAL_CHARACTER 5 CSumbto

LOAD_SPECIAL_MODEL CUTOBJ01 ccfan

LOAD_SCENE -1169.0 -620.0 10.791
CLEAR_AREA -1170.708 -608.327 10.791 5.0 TRUE 

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CUTOBJ01
	WAIT 0
ENDWHILE

LOAD_CUTSCENE cub_2
SET_CUTSCENE_OFFSET -1170.708 -608.327 10.791 
SET_NEAR_CLIP 0.1				

CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_pablo
SET_CUTSCENE_ANIM cs_pablo CSpablo

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_papa
SET_CUTSCENE_ANIM cs_papa CSpapa

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_pepe
SET_CUTSCENE_ANIM cs_pepe CSpepe

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_umbto
SET_CUTSCENE_ANIM cs_umbto CSumbto

CREATE_CUTSCENE_OBJECT CUTOBJ01 cc_fan1
SET_CUTSCENE_ANIM_TO_LOOP ccfan
SET_CUTSCENE_ANIM cc_fan1 ccfan 

CLEAR_AREA -1170.9 -603.7 10.6 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1170.9 -603.7 10.6
SET_PLAYER_HEADING player1 15.3 

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 33
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW CUB2_A 10000 1 // Une cafecito, por favor, Alberto..

WHILE cs_time < 1457
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_N 10000 1 // No problem Tommy

WHILE cs_time < 2467
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_B 10000 1 // Poppa! Una grande problema!  

WHILE cs_time < 4466
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_O 10000 1 // Umberto my son, what happened?  

WHILE cs_time < 5642
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_C 10000 1 // The Haitians! I hate these Haitians!

WHILE cs_time < 9437
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_D 10000 1 // They mess with me, they mess with me for the last time!

WHILE cs_time < 11602
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_E 10000 1 // We take them out! 

WHILE cs_time < 13786
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_F 10000 1 // Only we need some backup. 

WHILE cs_time < 15750
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_G 10000 1 // I lost a few of ermanos already out there.

WHILE cs_time < 18171
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_H 10000 1 // Amigo, you drive good!

WHILE cs_time < 19840
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_I 10000 1 //For a woman.

WHILE cs_time < 21118
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_J 10000 1 //This is no time for joking!

WHILE cs_time < 22511
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_K 10000 1 //Come on, drive for me again!

WHILE cs_time < 24770
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_L 10000 1 //Take my boys over there, and then we'll take those Haitians down!

WHILE cs_time < 27856
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB2_M 10000 1 //They mess with me, and they mess with the biggest boy in town!
/*
WHILE cs_time < 29856
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS
*/
WHILE cs_time < 32000
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

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

CREATE_PICKUP_WITH_AMMO laser PICKUP_ONCE 6 -1129.9 66.3 11.0 free_scope
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_cafe = 0
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000
SET_WANTED_MULTIPLIER 0.2

flag_is_on_cuban_mission = 1 // SCFIX
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1

REQUEST_MODEL CBa
REQUEST_MODEL HNa
REQUEST_MODEL CBb
REQUEST_MODEL HNb
REQUEST_MODEL WMOCA
REQUEST_MODEL cellphone

REQUEST_MODEL stinger
REQUEST_MODEL uzi
REQUEST_MODEL pony
REQUEST_MODEL sniper
REQUEST_MODEL m4
REQUEST_MODEL taxi

WHILE NOT HAS_MODEL_LOADED CBa
OR NOT HAS_MODEL_LOADED	HNa
OR NOT HAS_MODEL_LOADED	CBb
OR NOT HAS_MODEL_LOADED	HNb
OR NOT HAS_MODEL_LOADED	WMOCA
OR NOT HAS_MODEL_LOADED	cellphone
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED stinger
OR NOT HAS_MODEL_LOADED uzi
OR NOT HAS_MODEL_LOADED	pony
OR NOT HAS_MODEL_LOADED	sniper
OR NOT HAS_MODEL_LOADED	m4
OR NOT HAS_MODEL_LOADED	taxi
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO 1 CUB2_1
LOAD_MISSION_AUDIO 2 CUB2_2

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 


DO_FADE 1500 FADE_IN
//cheating the compilier into thinking i have created something which i havent (so it can be used later)
GOTO cuban2_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian1x haitian1y haitian_z haitian_defender1
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian2x haitian2y haitian_z haitian_defender2
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian3x haitian3y haitian_z haitian_defender3
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian4x haitian4y haitian_z haitian_defender4
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender5
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender6
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender7
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender8
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender9
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender10
	STORE_CAR_PLAYER_IS_IN player1 cuban_carry_car
	ADD_BLIP_FOR_CAR cuban_carry_car radar_blip_cuban_carry_car
cuban2_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

//opening haitian gate
//andy_has_control = 1
WHILE NOT SLIDE_OBJECT haitian_gate -1114.5 73.0 10.1 10.0 10.0 0.0 FALSE
	WAIT 0								 
ENDWHILE


PRINT_NOW ( CUB2_03 ) 5000 1 //Get a car and pick up the cubans from outside Robina's Cafe.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////picking up first set of cubans//////////////////////////////////////////////////////////////////

//Collecting Cubans to drive to Haitian Base
CREATE_CHAR PEDTYPE_GANG_CUBAN CBa -1171.2 -608.7 10.8 cuban_pickup1
SET_CHAR_HEADING cuban_pickup1 181.1 
GIVE_WEAPON_TO_CHAR cuban_pickup1 WEAPONTYPE_uzi 30000
ADD_ARMOUR_TO_CHAR cuban_pickup1 100 
CLEAR_CHAR_THREAT_SEARCH cuban_pickup1
SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup1 TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup1 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup1 TRUE
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup1 player1 TRUE
SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_pickup1 TRUE
SET_CHAR_HEED_THREATS cuban_pickup1 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_pickup1 TRUE

CREATE_CHAR PEDTYPE_GANG_CUBAN CBa -1169.9 -609.0 10.8 cuban_pickup2
SET_CHAR_HEADING cuban_pickup2 181.1 
GIVE_WEAPON_TO_CHAR cuban_pickup2 WEAPONTYPE_uzi 30000
ADD_ARMOUR_TO_CHAR cuban_pickup2 100 
CLEAR_CHAR_THREAT_SEARCH cuban_pickup2
SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup2 TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup2 TRUE 
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup2 TRUE
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup2 player1 TRUE
SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_pickup2 TRUE
SET_CHAR_HEED_THREATS cuban_pickup2 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_pickup2 TRUE

CREATE_CHAR PEDTYPE_GANG_CUBAN CBa -1169.9 -610.0 10.8 cuban_pickup3
GIVE_WEAPON_TO_CHAR cuban_pickup3 WEAPONTYPE_uzi 30000
ADD_ARMOUR_TO_CHAR cuban_pickup3 100 
CLEAR_CHAR_THREAT_SEARCH cuban_pickup3
SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup3 TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup3 TRUE 
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup3 TRUE
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup3 player1 TRUE
SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_pickup3 TRUE
SET_CHAR_HEED_THREATS cuban_pickup3 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_pickup3 TRUE

SET_CHARS_CHATTING cuban_pickup2 cuban_pickup3 86400000 
CREATE_CAR pony -1071.3 -608.4 9.7 crappy_car

//getting a car to pick up boxers

ADD_BLIP_FOR_COORD -1168.5 -599.6 10.6 cuban_pickup_blip  
{
timera = 0
first_cuban_pickup:

WAIT 0

WHILE NOT LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 -1168.5 -599.6 10.6 5.0 5.0 10.0 TRUE
OR NOT IS_PLAYER_SITTING_IN_ANY_CAR player1
	WAIT 0 

	IF IS_CHAR_DEAD cuban_pickup1
	OR IS_CHAR_DEAD cuban_pickup2
	OR IS_CHAR_DEAD cuban_pickup3
		GOSUB nutters
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
		GOTO mission_failed_cuban2
	ENDIF

	IF timera > 6000
		IF LOCATE_PLAYER_ON_FOOT_3D player1 -1168.5 -599.6 10.6 5.0 5.0 10.0 FALSE
			PRINT_NOW ( CUB2_18 ) 5000 1 //Get a car and pick up the cubans.
		ELSE
			CLEAR_THIS_PRINT ( CUB2_18 )
		ENDIF
	ENDIF
ENDWHILE

MARK_CAR_AS_NO_LONGER_NEEDED crappy_car 
STORE_CAR_PLAYER_IS_IN player1 cuban_carry_car

IF cuban_carry_car = cuban_carry_car_old  
	play_cub2_mission_audio = 0
ELSE
	play_cub2_mission_audio = 1
ENDIF

cuban_carry_car_old	= cuban_carry_car

GET_MAXIMUM_NUMBER_OF_PASSENGERS cuban_carry_car maxcubans_in_car

IF NOT maxcubans_in_car > 2	
	PRINT_NOW ( CUB2_01 ) 5000 1 //Not enough room man, need a bigger car.
	IF NOT IS_CHAR_DEAD cuban_pickup2 
		SET_CHAR_HEADING cuban_pickup2 0.0 
	ENDIF
	IF play_cub2_mission_audio = 1
		LOAD_MISSION_AUDIO 1 CUB2_1
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		AND NOT IS_CHAR_DEAD cuban_pickup2 
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT CUB2_01 
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup2 
		SET_CHAR_HEADING cuban_pickup2 181.0
	ENDIF 
	GOTO first_cuban_pickup
ENDIF

REMOVE_BLIP cuban_pickup_blip


//getting cubans into car

IF NOT IS_CAR_DEAD cuban_carry_car
	LOCK_CAR_DOORS cuban_carry_car CARLOCK_LOCKED_PLAYER_INSIDE
ENDIF

WAIT 500

// ****************************************START OF CUTSCENE -getting cubans into car********************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

SET_FIXED_CAMERA_POSITION -1175.9 -608.1 11.4 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1147.9 -583.11 16.1 JUMP_CUT

/*
IF NOT IS_CHAR_DEAD cuban_pickup1 
	IF NOT IS_CHAR_DEAD cuban_pickup2 
		IF NOT IS_CHAR_DEAD cuban_pickup3 
			SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup1 FALSE
			SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup2 FALSE
			SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup3 FALSE
		ENDIF
	ENDIF
ENDIF
*/

TIMERB = 0

IF NOT IS_CAR_DEAD cuban_carry_car
	LOCK_CAR_DOORS cuban_carry_car CARLOCK_UNLOCKED
ENDIF

WHILE NOT cubans_in_cars = 3  
	WAIT 0

	IF NOT IS_CAR_DEAD cuban_carry_car
		IF NOT IS_CHAR_DEAD cuban_pickup1
			IF cuban1_in = 0
				SET_CHAR_COORDINATES cuban_pickup1 -1169.9 -608.0 10.8 
				cuban1_in = 1
			ENDIF
			SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER cuban_pickup1 cuban_carry_car
			SET_CHAR_RUNNING cuban_pickup1 TRUE
			IF cuban1_in = 1
				IF IS_CHAR_IN_CAR cuban_pickup1 cuban_carry_car
					cubans_in_cars ++
					cuban1_in = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	WAIT 800
		
	IF NOT IS_CAR_DEAD cuban_carry_car
		IF NOT IS_CHAR_DEAD cuban_pickup2
			IF cuban2_in = 0
				SET_CHAR_COORDINATES cuban_pickup2 -1169.9 -608.0 10.8 
				cuban2_in = 1
			ENDIF
			SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER cuban_pickup2 cuban_carry_car
			SET_CHAR_RUNNING cuban_pickup2 TRUE
			IF cuban2_in = 1
				IF IS_CHAR_IN_CAR cuban_pickup2 cuban_carry_car
					cubans_in_cars ++
					cuban2_in = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	WAIT 800

	IF NOT IS_CAR_DEAD cuban_carry_car
		IF NOT IS_CHAR_DEAD cuban_pickup3
			IF cuban3_in = 0
				SET_CHAR_COORDINATES cuban_pickup3 -1169.9 -608.0 10.8
				cuban3_in = 1
			ENDIF 
			SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER cuban_pickup3 cuban_carry_car
			SET_CHAR_RUNNING cuban_pickup3 TRUE
			IF cuban3_in = 1
				IF IS_CHAR_IN_CAR cuban_pickup3 cuban_carry_car
					cubans_in_cars ++
					cuban3_in = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
   
	IF TIMERB > 5000 // SCFIX: was 2000
		IF NOT IS_CAR_DEAD cuban_carry_car
			/* SCFIX: yeah all this is pointless and results in ghosts coming out of the car
			IF NOT IS_CHAR_DEAD cuban_pickup1  
				IF IS_CHAR_IN_CAR cuban_pickup1 cuban_carry_car 
					WARP_CHAR_FROM_CAR_TO_COORD cuban_pickup1 -862.0 -607.4 11.1
					MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup1   
				ELSE
					SET_CHAR_COORDINATES cuban_pickup1 -862.0 -607.7 11.1  
					MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup1
				ENDIF
			ENDIF   

			IF NOT IS_CHAR_DEAD cuban_pickup2  
				IF IS_CHAR_IN_CAR cuban_pickup2 cuban_carry_car 
					WARP_CHAR_FROM_CAR_TO_COORD cuban_pickup2 -862.0 -604.4 11.1	  
					MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup2   
				ELSE	
					SET_CHAR_COORDINATES cuban_pickup2 -862.0 -604.4 11.1 
					MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup2   
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD cuban_pickup3  
				IF IS_CHAR_IN_CAR cuban_pickup3 cuban_carry_car 
					WARP_CHAR_FROM_CAR_TO_COORD cuban_pickup3 -862.0 -601.4 11.1
					MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup3   
				ELSE
					SET_CHAR_COORDINATES cuban_pickup3 -862.0 -601.4 11.1 
					MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup3
				ENDIF 
			ENDIF  
			*/

			// SCFIX: START - just delete chars instead
			DELETE_CHAR cuban_pickup1
			DELETE_CHAR cuban_pickup2
			DELETE_CHAR cuban_pickup3
			// SCFIX: END

			CREATE_CHAR_AS_PASSENGER cuban_carry_car PEDTYPE_GANG_CUBAN CBa 0 cuban_pickup1 
			SET_CHAR_AS_PLAYER_FRIEND cuban_pickup1 player1 TRUE
			SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_pickup1 TRUE
			GIVE_WEAPON_TO_CHAR cuban_pickup1 WEAPONTYPE_uzi 30000
			CLEAR_CHAR_THREAT_SEARCH cuban_pickup1
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup1 TRUE
			SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup1 TRUE
			SET_CHAR_HEED_THREATS cuban_pickup1 TRUE 
			SET_CHAR_NEVER_TARGETTED cuban_pickup1 TRUE

			CREATE_CHAR_AS_PASSENGER cuban_carry_car PEDTYPE_GANG_CUBAN CBa 1 cuban_pickup2 
			SET_CHAR_AS_PLAYER_FRIEND cuban_pickup2 player1 TRUE
			SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_pickup2 TRUE
			GIVE_WEAPON_TO_CHAR cuban_pickup2 WEAPONTYPE_uzi 30000
			CLEAR_CHAR_THREAT_SEARCH cuban_pickup2
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup2 TRUE
			SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup2 TRUE
			SET_CHAR_HEED_THREATS cuban_pickup2 TRUE 
			SET_CHAR_NEVER_TARGETTED cuban_pickup2 TRUE

			CREATE_CHAR_AS_PASSENGER cuban_carry_car PEDTYPE_GANG_CUBAN CBa 2 cuban_pickup3 
			SET_CHAR_AS_PLAYER_FRIEND cuban_pickup3 player1 TRUE
			SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_pickup3 TRUE
			GIVE_WEAPON_TO_CHAR cuban_pickup3 WEAPONTYPE_uzi 30000
			CLEAR_CHAR_THREAT_SEARCH cuban_pickup3
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup3 TRUE 
			SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup3 TRUE
			SET_CHAR_HEED_THREATS cuban_pickup3 TRUE 
			SET_CHAR_NEVER_TARGETTED cuban_pickup3 TRUE
			CLOSE_ALL_CAR_DOORS cuban_carry_car 
	 	ENDIF
		cubans_in_cars = 3
	ENDIF
ENDWHILE

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF
// ****************************************END OF CUTSCENE - getting cubans into car********************************




//Waiting for player1 to get back to battle

ADD_BLIP_FOR_COORD -1072.6 70.3 11.2 drop_off_point1
PRINT_NOW ( CUB2_19 ) 5000 1 //We gonna fight like men!
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD cuban_pickup1 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB2_19 
PRINT ( CUB2_04 ) 5000 1 //Go and drop the Cubans off at the fight. 
PRINT ( CUB2_23 ) 5000 1 //Little Haiti will be swarming with Haitians trying to even the score with the Cubans.  Watch your back. 

LOAD_MISSION_AUDIO 1 CUB2_3a
LOAD_MISSION_AUDIO 2 CUB2_3b

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

waiting_for_player_2_get_close:

	WAIT 0

	IF LOCATE_PLAYER_IN_CAR_3D player1 -1072.6 70.3 11.2 180.0 180.0 180.0 FALSE
		IF creating_flag = 0
			//Creating Initial Haitians

			GOSUB creating_new_haitians
			SET_THREAT_REACTION_RANGE_MULTIPLIER 3.0 

			//Creating Initial Cubans

			//right of alleyway
			CREATE_CHAR PEDTYPE_GANG_CUBAN CBa -1079.5 72.6 10.2 cuban_attacker1
			SET_CHAR_AS_PLAYER_FRIEND cuban_attacker1 player1 TRUE
			SET_CHAR_HEADING cuban_attacker1 91.5
			GIVE_WEAPON_TO_CHAR cuban_attacker1 WEAPONTYPE_uzi 30000
			CLEAR_CHAR_THREAT_SEARCH cuban_attacker1
			SET_CHAR_PERSONALITY cuban_attacker1 PEDSTAT_TOUGH_GUY  
			SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_EMERGENCY
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_attacker1 TRUE
			SET_CHAR_AS_PLAYER_FRIEND cuban_attacker1 player1 TRUE
			SET_CHAR_HEED_THREATS cuban_attacker1 TRUE
			SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_attacker1 TRUE  
			SET_CHAR_NEVER_TARGETTED cuban_attacker1 TRUE

			//leader bloke
			CREATE_CHAR PEDTYPE_GANG_CUBAN CBb -1079.6 73.9 10.2 cuban_attacker2
			SET_CHAR_AS_PLAYER_FRIEND cuban_attacker2 player1 TRUE
			SET_CHAR_HEADING cuban_attacker2 270.9
			CLEAR_CHAR_THREAT_SEARCH cuban_attacker2
			SET_CHAR_PERSONALITY cuban_attacker2 PEDSTAT_TOUGH_GUY 
			SET_CHAR_ACCURACY cuban_attacker2 90  
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_attacker2 TRUE
			SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_attacker2 TRUE
			SET_CHAR_AS_PLAYER_FRIEND cuban_attacker2 player1 TRUE
			SET_CHAR_HEED_THREATS cuban_attacker2 TRUE 
			SET_CHAR_NEVER_TARGETTED cuban_attacker2 TRUE
			SET_CHAR_STAY_IN_CAR_WHEN_JACKED cuban_attacker2 TRUE 
			SET_CHAR_CANT_BE_DRAGGED_OUT cuban_attacker2 TRUE 

			//left of alleyway
			CREATE_CHAR PEDTYPE_GANG_CUBAN CBa -1079.3 68.6 10.2 cuban_attacker3
			SET_CHAR_AS_PLAYER_FRIEND cuban_attacker3 player1 TRUE
			SET_CHAR_HEADING cuban_attacker3 82.1
			GIVE_WEAPON_TO_CHAR cuban_attacker3 WEAPONTYPE_uzi 30000
			CLEAR_CHAR_THREAT_SEARCH cuban_attacker3
			SET_CHAR_PERSONALITY cuban_attacker3 PEDSTAT_TOUGH_GUY  
			SET_CHAR_THREAT_SEARCH cuban_attacker3 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_attacker3 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_attacker3 THREAT_EMERGENCY
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_attacker3 TRUE
			SET_CHAR_AS_PLAYER_FRIEND cuban_attacker3 player1 TRUE
			SET_CHAR_HEED_THREATS cuban_attacker3 TRUE 
			SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_attacker3 TRUE  
			SET_CHAR_NEVER_TARGETTED cuban_attacker3 TRUE
		    GOTO awaiting_player_arrival_loop1
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD cuban_pickup1
	OR IS_CHAR_DEAD cuban_pickup2
	OR IS_CHAR_DEAD cuban_pickup3
		GOSUB nutters
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
		GOTO mission_failed_cuban2
	ENDIF
	
	IF NOT IS_CAR_DEAD cuban_carry_car 
		GOSUB checking_car_is_in_one_piece
	ELSE
		GOSUB nutters
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
		GOTO mission_failed_cuban2
	ENDIF

GOTO waiting_for_player_2_get_close 


awaiting_player_arrival_loop1:
    
	WAIT 0
    
    IF NOT IS_CAR_DEAD cuban_carry_car 
		IF NOT LOCATE_PLAYER_IN_CAR_3D player1 -1070.1 70.3 10.2 3.5 4.0 4.0 TRUE
			GOSUB checking_car_is_in_one_piece
		ELSE
			IF NOT IS_CAR_DEAD cuban_carry_car 
				IF IS_PLAYER_IN_CAR player1 cuban_carry_car 
					GOTO player1_arrived1
				ENDIF
			ENDIF
		ENDIF	
	ELSE
		GOSUB nutters
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
		GOTO mission_failed_cuban2
	ENDIF
	
	IF IS_CHAR_DEAD cuban_attacker1
	OR IS_CHAR_DEAD cuban_attacker2
	OR IS_CHAR_DEAD cuban_attacker3
		GOSUB nutters
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
		GOTO mission_failed_cuban2
	ENDIF  

	GOSUB leading_the_cubans_part1
	GOSUB creating_new_haitians
	GOSUB first_wave_haitian_attacking_rules

GOTO awaiting_player_arrival_loop1 

player1_arrived1:
REMOVE_BLIP drop_off_point1
REMOVE_BLIP radar_blip_cuban_carry_car

// ****************************************START OF CUTSCENE -telling player what to do********************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

CLEAR_AREA -1079.6 73.9 10.2 50.0 TRUE
SET_CAR_DENSITY_MULTIPLIER 0.0

//creating FIRST GOAL car that has to be destroyed
CREATE_CAR stinger -1113.2 70.2 10.0 target1
SET_CAR_HEADING target1 358.19 
SET_CAR_ONLY_DAMAGED_BY_PLAYER target1 TRUE

SET_FIXED_CAMERA_POSITION -1064.5 64.8 15.7 0.0 0.0 0.0 
POINT_CAMERA_AT_CAR cuban_carry_car FIXED JUMP_CUT

SET_CAR_TEMP_ACTION cuban_carry_car TEMPACT_HANDBRAKESTRAIGHT 10000

IF NOT IS_CAR_DEAD cuban_carry_car 
	WHILE NOT IS_CAR_STOPPED cuban_carry_car
		WAIT 0
		IF NOT IS_CAR_DEAD cuban_carry_car
		ENDIF 
	ENDWHILE 
ENDIF

SET_CHAR_OBJ_LEAVE_CAR scplayer cuban_carry_car
SET_CHAR_OBJ_RUN_TO_COORD scplayer -1077.2 73.3 

WAIT 200

//getting chars to leave car and enter the battle
IF NOT IS_CAR_DEAD cuban_carry_car 
	IF NOT IS_CHAR_DEAD cuban_pickup1 
		SET_CHAR_PERSONALITY cuban_pickup1 PEDSTAT_TOUGH_GUY  
		SET_CHAR_OBJ_LEAVE_CAR cuban_pickup1 cuban_carry_car
		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup1 -1075.8 71.4
	ENDIF

	IF NOT IS_CHAR_DEAD cuban_pickup2 
		SET_CHAR_PERSONALITY cuban_pickup2 PEDSTAT_TOUGH_GUY  
		SET_CHAR_OBJ_LEAVE_CAR cuban_pickup2 cuban_carry_car
		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup2 -1075.6 70.0 
	ENDIF							
		   
	IF NOT IS_CHAR_DEAD cuban_pickup3 
		SET_CHAR_PERSONALITY cuban_pickup3 PEDSTAT_TOUGH_GUY  
		SET_CHAR_OBJ_LEAVE_CAR cuban_pickup3 cuban_carry_car
		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup3 -1075.8 68.6 
	ENDIF
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED cuban_carry_car 

WAIT 2000

IF cub2_waiving_flag = 0
	IF NOT IS_CHAR_DEAD cuban_attacker2
		SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_PLAYANIM_TAXI 800
		cub2_waiving_flag = 1
	ENDIF
ENDIF

SET_FIXED_CAMERA_POSITION -1073.46 72.77 12.32 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1074.44 72.62 12.21 JUMP_CUT

WAIT 900

IF NOT IS_CHAR_DEAD cuban_pickup1 
	SET_CHAR_HEADING cuban_pickup1 91.5
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup1 TRUE	
	SET_CHAR_THREAT_SEARCH cuban_pickup1 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup1 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_pickup1 THREAT_EMERGENCY
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup2
	SET_CHAR_HEADING cuban_pickup2 89.5	
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup2 TRUE	
	SET_CHAR_THREAT_SEARCH cuban_pickup2 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup2 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_pickup2 THREAT_EMERGENCY
ENDIF 
	
IF NOT IS_CHAR_DEAD cuban_pickup3
	SET_CHAR_HEADING cuban_pickup3 90.5	
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup3 TRUE	
	SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_EMERGENCY
ENDIF

timera = 0

WHILE NOT IS_CHAR_OBJECTIVE_PASSED scplayer
	WAIT 0 
	IF timera > 5000
		GOTO fudgelips
	ENDIF
ENDWHILE 

fudgelips:

IF NOT IS_CHAR_DEAD cuban_attacker2 
	TURN_CHAR_TO_FACE_PLAYER cuban_attacker2 player1
	TURN_CHAR_TO_FACE_CHAR scplayer cuban_attacker2
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_FALSE 100
ENDIF

IF NOT IS_CHAR_DEAD cuban_attacker2 
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_PLAYANIM_CHAT 10000
ENDIF

PRINT_NOW CUB2_12 3000 1//Hey amigo! Good to see you could make it
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB2_12 

IF NOT IS_CHAR_DEAD cuban_attacker2 
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_PLAYANIM_CHAT 10000
ENDIF

PRINT_NOW CUB2_13 4000 1//Stinking nest of Haitians, we gonna kill them all!
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB2_13 

LOAD_MISSION_AUDIO 1 CUB2_3c
LOAD_MISSION_AUDIO 2 CUB2_9

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

IF NOT IS_CHAR_DEAD cuban_attacker2 
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_FALSE 100
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup1 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup1 FALSE 
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup2 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup2 FALSE 
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup3 FALSE 
ENDIF

number_of_haitians_dead = 0

STOP_PLAYER_LOOKING player1
IF NOT IS_CHAR_DEAD cuban_attacker2
	STOP_CHAR_LOOKING cuban_attacker2
	SET_CHAR_THREAT_SEARCH cuban_attacker2 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_attacker2 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_attacker2 THREAT_EMERGENCY
	GIVE_WEAPON_TO_CHAR cuban_attacker2 WEAPONTYPE_M4 99999
ENDIF

SET_CAR_DENSITY_MULTIPLIER 1.0
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF

/*
IF NOT IS_CHAR_DEAD cuban_attacker1 
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_attacker1 FALSE  
ENDIF
IF NOT IS_CHAR_DEAD cuban_attacker3 
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_attacker3 FALSE  
ENDIF
*/

PRINT_NOW ( CUB2_14 ) 5000 1 //CHAAAARRGE!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB2_14 

PRINT ( CUB2_25 ) 5000 1 //GET THEM ALL!!

IF NOT IS_CHAR_DEAD haitian_defender1 	
	ADD_BLIP_FOR_CHAR haitian_defender1 cuban_blip1
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender2 	
	ADD_BLIP_FOR_CHAR haitian_defender2 cuban_blip2
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender3 	
	ADD_BLIP_FOR_CHAR haitian_defender3 cuban_blip3
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender4 	
	ADD_BLIP_FOR_CHAR haitian_defender4 cuban_blip4
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender5 	
	ADD_BLIP_FOR_CHAR haitian_defender5 cuban_blip5
ENDIF

cuban_flag1 = 0
RESET_NUM_OF_MODELS_KILLED_BY_PLAYER

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////FIRST GOAL - destroying car and back cubans/////////////////////////////////////////////////////
first_goal_loop:
WAIT 0

IF IS_CHAR_DEAD cuban_attacker1
OR IS_CHAR_DEAD cuban_attacker2
OR IS_CHAR_DEAD cuban_attacker3
OR body_count_cub2 > 0 // SCFIX: was = 1
	GOSUB nutters
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
	GOTO mission_failed_cuban2
ENDIF  

GOSUB leading_the_cubans_part1
GOSUB picked_up_cubans_fighting_rules
GOSUB first_wave_haitian_attacking_rules
GOSUB player_killing_cubans

IF IS_CAR_DEAD target1
OR number_of_haitians_dead > 9
OR IS_PLAYER_IN_AREA_2D player1 -1114.3 61.6 -1131.2 95.9 FALSE 
	completed_goal_flag = 1
ENDIF  

IF IS_CHAR_DEAD haitian_defender1
	REMOVE_BLIP cuban_blip1
ENDIF 
IF IS_CHAR_DEAD haitian_defender2
	REMOVE_BLIP cuban_blip2
ENDIF 
IF IS_CHAR_DEAD haitian_defender3
	REMOVE_BLIP cuban_blip3
ENDIF 
IF IS_CHAR_DEAD haitian_defender4
	REMOVE_BLIP cuban_blip4
ENDIF 
IF IS_CHAR_DEAD haitian_defender5
	REMOVE_BLIP cuban_blip5
ENDIF 

IF completed_goal_flag = 0   
	GOSUB creating_new_haitians
ELSE
	IF IS_CHAR_DEAD haitian_defender1 
		IF IS_CHAR_DEAD haitian_defender2 
			IF IS_CHAR_DEAD haitian_defender3 
				IF IS_CHAR_DEAD haitian_defender4 
					IF IS_CHAR_DEAD haitian_defender5
						SET_THREAT_REACTION_RANGE_MULTIPLIER 1.0
						REMOVE_BLIP cuban_blip1
						REMOVE_BLIP cuban_blip2
						REMOVE_BLIP cuban_blip3
						REMOVE_BLIP cuban_blip4
						REMOVE_BLIP cuban_blip5
						cuban_flag1 = 1
						GOTO preparing_for_next_pickup
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOTO first_goal_loop 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////FIRST GOAL - completed//////////////////////////////////////////////////////////////////////////

// ****************************************START OF CUTSCENE -telling player what to do next********************************
//Creating SECOND GOAL and next wave of haitians
preparing_for_next_pickup:

WAIT 1000

CLEAR_AREA -1079.6 73.9 10.2 25.0 TRUE
SET_CAR_DENSITY_MULTIPLIER 0.0 
SET_PED_DENSITY_MULTIPLIER 0.0

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

PRINT_NOW ( CUB2_15 ) 5000 1 //Now, my brothers, CHAAARRRGGEE!!
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB2_15 


//cuban car

CREATE_CAR taxi -1037.2 24.6 9.9 cuban_carry_car
CREATE_CHAR_INSIDE_CAR cuban_carry_car PEDTYPE_CIVMALE WMOCA taxi_dude
SET_CAR_CRUISE_SPEED cuban_carry_car 0.0 

//Go pick up the other set of Cubans

CREATE_CHAR_AS_PASSENGER cuban_carry_car PEDTYPE_GANG_CUBAN CBa 0 cuban_pickup4
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup4 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_pickup4 WEAPONTYPE_uzi 30000
ADD_ARMOUR_TO_CHAR cuban_pickup4 100 
CLEAR_CHAR_THREAT_SEARCH cuban_pickup4
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup4 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup4 TRUE
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup4 player1 TRUE
SET_CHAR_HEED_THREATS cuban_pickup4 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_pickup4 TRUE

CREATE_CHAR_AS_PASSENGER cuban_carry_car PEDTYPE_GANG_CUBAN CBa 1 cuban_pickup5
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup5 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_pickup5 WEAPONTYPE_uzi 30000
ADD_ARMOUR_TO_CHAR cuban_pickup5 100 
CLEAR_CHAR_THREAT_SEARCH cuban_pickup5
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup5 TRUE 
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup5 TRUE
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup5 player1 TRUE
SET_CHAR_HEED_THREATS cuban_pickup5 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_pickup5 TRUE

CREATE_CHAR_AS_PASSENGER cuban_carry_car PEDTYPE_GANG_CUBAN CBa 2 cuban_pickup6
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup6 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_pickup6 WEAPONTYPE_uzi 30000
ADD_ARMOUR_TO_CHAR cuban_pickup6 100 
CLEAR_CHAR_THREAT_SEARCH cuban_pickup6
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup6 TRUE 
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_pickup6 TRUE
SET_CHAR_AS_PLAYER_FRIEND cuban_pickup6 player1 TRUE
SET_CHAR_HEED_THREATS cuban_pickup6 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_pickup6 TRUE

CLEAR_AREA_OF_CARS -1108.2 65.2 5.0 -1118.2 75.2 15.0
DELETE_CAR target1

//front right (when looking at sniper down alley)
haitian1x = -1137.8 
haitian1y = 66.7
hd1_heading = 5.2

//front left (when looking at sniper down alley)
haitian2x = -1138.2
haitian2y = 75.5
hd2_heading = 175.4

// back right (when looking at sniper down alley)
haitian3x = -1158.2
haitian3y = 67.2
hd3_heading = 5.2

//back left (when looking at sniper down alley)
haitian4x = -1158.1
haitian4y = 75.6
hd4_heading = 175.4

//back (when looking at sniper down alley)
haitian5x = -1163.5
haitian5y = 75.8
hd5_heading = 226.7

haitian_z = 10.1

GOSUB creating_new_haitians

SET_CHAR_OBJ_RUN_TO_COORD scplayer -1103.1 71.9 

//creating sniper
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNb -1189.8 69.2 23.9 target2


SHUT_CHAR_UP target2 TRUE 
SET_CHAR_HEADING target2 270.0
GIVE_WEAPON_TO_CHAR target2 WEAPONTYPE_SNIPERRIFLE 30000
CLEAR_CHAR_THREAT_SEARCH target2
SET_CHAR_PERSONALITY target2 PEDSTAT_TOUGH_GUY  
/* SCFIX: remove
SET_CHAR_THREAT_SEARCH target2 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH target2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH target2 THREAT_COP
*/
SET_CHAR_ACCURACY target2 100 
SET_CHAR_OBJ_RUN_TO_COORD target2 -1173.4 71.3 
SET_ANIM_GROUP_FOR_CHAR target2 ANIM_PLAYER_2ARMED_PED // SCFIX


SET_FIXED_CAMERA_POSITION -1074.47 70.88 14.36 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1075.44 70.90 14.11 JUMP_CUT

IF NOT IS_CHAR_DEAD cuban_attacker3
	CLEAR_CHAR_THREAT_SEARCH cuban_attacker3 
	//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_attacker3 FALSE
	SET_CHAR_OBJ_RUN_TO_COORD  cuban_attacker3 -1117.2 68.5 
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup1 
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup1 
	//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup1 FALSE
	SET_CHAR_OBJ_RUN_TO_COORD  cuban_pickup1 -1130.2 70.5 
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup2
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup2 
	//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY cuban_pickup2 FALSE
	SET_CHAR_OBJ_RUN_TO_COORD  cuban_pickup2 -1130.2 73.5  // SCFIX: was 70.5
ENDIF
WAIT 2000

//looking at cubans dying
SET_FIXED_CAMERA_POSITION -1105.68 70.95 13.95 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1106.66 70.91 13.74 JUMP_CUT
SET_CHAR_OBJ_NO_OBJ scplayer
SET_PLAYER_COORDINATES player1 -1103.1 71.9 10.27

IF NOT IS_CHAR_DEAD cuban_attacker3
	SET_CHAR_COORDINATES cuban_attacker3 -1106.7 69.9 10.4  
	SET_CHAR_OBJ_RUN_TO_COORD  cuban_attacker3 -1117.2 68.5 
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup1 
	SET_CHAR_COORDINATES cuban_pickup1 -1106.7 70.9 10.4  
	SET_CHAR_OBJ_RUN_TO_COORD  cuban_pickup1 -1130.2 70.5 
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup2
	SET_CHAR_COORDINATES cuban_pickup2 -1106.7 71.9 10.4  
	SET_CHAR_OBJ_RUN_TO_COORD  cuban_pickup2 -1130.2 73.5 // SCFIX: was 70.5
ENDIF

timera = 0
timerb = 0 // SCFIX

LOAD_MISSION_AUDIO 2 snipsh
WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO 1 snipsh
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE


snipey_loop:

WAIT 0
	IF NOT IS_CHAR_DEAD target2 // SCFIX
		IF LOCATE_CHAR_ANY_MEANS_2D target2 -1173.4 71.3 1.0 1.0 FALSE // SCFIX
			SET_CHAR_STAY_IN_SAME_PLACE target2 TRUE
			IF NOT IS_CHAR_DEAD cuban_attacker3
				IF IS_CHAR_IN_AREA_2D cuban_attacker3 -1140.0 59.9 -1114.1 82.1 FALSE // SCFIX: was -1130.4 59.9 -1114.1 82.1
				AND timerb > 1500 // SCFIX
					timerb = 0 // SCFIX
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_attacker3 // SCFIX
					IF sniper_shot > 0 
						LOAD_MISSION_AUDIO 1 sniper
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
						ENDWHILE
					ENDIF
					PLAY_MISSION_AUDIO 1
					sniper_shot = 1
					
					
			
					IF NOT IS_CHAR_DEAD cuban_attacker3 
						EXPLODE_CHAR_HEAD cuban_attacker3
					ENDIF
					
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						WAIT 0
					ENDWHILE
					//CLEAR_MISSION_AUDIO 1
					
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD cuban_pickup1
				IF IS_CHAR_IN_AREA_2D cuban_pickup1 -1140.0 59.9 -1114.1 82.1 FALSE // SCFIX: was -1130.4 59.9 -1119.1 82.1 FALSE
				AND timerb > 1500 // SCFIX
					timerb = 0 // SCFIX
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_pickup1 // SCFIX
					PLAY_MISSION_AUDIO 2
					
					IF NOT IS_CHAR_DEAD cuban_pickup1
						EXPLODE_CHAR_HEAD cuban_pickup1
					ENDIF
					
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
						WAIT 0
					ENDWHILE
					//CLEAR_MISSION_AUDIO 2
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD cuban_pickup2
				IF IS_CHAR_IN_AREA_2D cuban_pickup2 -1140.0 59.9 -1114.1 82.1 FALSE // SCFIX: was -1130.4 59.9 -1125.1 82.1 FALSE
				AND timerb > 1500 // SCFIX
					timerb = 0 // SCFIX
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_pickup2 // SCFIX
					IF sniper_shot > 0 
						LOAD_MISSION_AUDIO 1 sniper
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
						ENDWHILE
					ENDIF
					PLAY_MISSION_AUDIO 1
					sniper_shot = 1
					
					
					
					IF NOT IS_CHAR_DEAD cuban_pickup2
						EXPLODE_CHAR_HEAD cuban_pickup2
					ENDIF
					
					
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						WAIT 0
					ENDWHILE
					//CLEAR_MISSION_AUDIO 1
					
				ENDIF
			ENDIF

			IF timera > 12000
				GOTO cuntlips
			ENDIF 

			IF IS_CHAR_DEAD cuban_attacker3 
				IF IS_CHAR_DEAD cuban_pickup1 
					IF IS_CHAR_DEAD cuban_pickup2
						MARK_CHAR_AS_NO_LONGER_NEEDED cuban_attacker3 
						MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup2
						MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup1
						GOTO cuntlips 
					ENDIF
				ENDIF
			ENDIF
		ENDIF // SCFIX
	// SCFIX: START - sniper somehow died, recreate... just paranoid stuff, this really shouldn't happen
	ELSE 
		DELETE_CHAR target2
		CREATE_CHAR PEDTYPE_GANG_HAITIAN HNb -1173.4 71.3 23.9 target2
		SHUT_CHAR_UP target2 TRUE 
		SET_CHAR_HEADING target2 270.0
		GIVE_WEAPON_TO_CHAR target2 WEAPONTYPE_SNIPERRIFLE 30000
		CLEAR_CHAR_THREAT_SEARCH target2
		SET_CHAR_PERSONALITY target2 PEDSTAT_TOUGH_GUY  
		/* SCFIX: remove
		SET_CHAR_THREAT_SEARCH target2 THREAT_GANG_CUBAN
		SET_CHAR_THREAT_SEARCH target2 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH target2 THREAT_COP
		*/
		SET_CHAR_ACCURACY target2 100 
		SET_ANIM_GROUP_FOR_CHAR target2 ANIM_PLAYER_2ARMED_PED
		SET_CHAR_STAY_IN_SAME_PLACE target2 TRUE
	ENDIF // SCFIX
	// SCFIX: END
GOTO snipey_loop

cuntlips:

IF NOT IS_CHAR_DEAD target2 
	SET_CHAR_COORDINATES target2 -1173.4 71.3 23.0
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 scplayer
ENDIF

LOAD_MISSION_AUDIO 1 CUB2_5
LOAD_MISSION_AUDIO 2 CUB2_6

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

WAIT 1000

//Looking behind sniper
SET_FIXED_CAMERA_POSITION -1175.9 70.3 24.3 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1135.9 66.3 18.6 JUMP_CUT

// SCFIX: START
IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker2 -1112.98 66.92
	SET_CHAR_USE_PEDNODE_SEEK cuban_attacker2 FALSE
ENDIF
IF NOT IS_CHAR_DEAD cuban_attacker1
	SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker1 -1112.2 73.0
	SET_CHAR_USE_PEDNODE_SEEK cuban_attacker1 FALSE
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup3
	SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup3 -1112.5 65.2
	SET_CHAR_USE_PEDNODE_SEEK cuban_pickup3 FALSE
ENDIF
IF NOT IS_CHAR_DEAD scplayer
	SET_CHAR_OBJ_RUN_TO_COORD scplayer -1110.95 67.38
	SET_CHAR_USE_PEDNODE_SEEK scplayer FALSE
ENDIF
// SCFIX: END

PRINT_NOW ( CUB2_09 ) 4000 1 //Sniper on the roof!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB2_09 
PRINT_NOW ( CUB2_07 ) 4000 1 //They fight like girls! Take cover!
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB2_07 

LOAD_MISSION_AUDIO 1 CUB2_7

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 

// SCFIX: START
IF NOT IS_CHAR_DEAD target2
	CHAR_SET_IDLE target2
	SET_CHAR_OBJ_NO_OBJ target2
ENDIF
// SCFIX: END

IF NOT IS_CHAR_DEAD cuban_attacker2
	CLEAR_CHAR_THREAT_SEARCH cuban_attacker2
	SET_CHAR_OBJ_NO_OBJ cuban_attacker2 // SCFIX
	SET_CHAR_COORDINATES cuban_attacker2 -1112.98 66.92 10.4
ENDIF

IF NOT IS_CHAR_DEAD cuban_attacker1
	CLEAR_CHAR_THREAT_SEARCH cuban_attacker1
	SET_CHAR_OBJ_NO_OBJ cuban_attacker1 // SCFIX
	SET_CHAR_COORDINATES cuban_attacker1 -1112.2 73.0 10.4 // SCFIX: change coords, was -1112.2 74.5 10.4
	SET_CHAR_HEADING cuban_attacker1 302.4
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup3
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup3
	SET_CHAR_OBJ_NO_OBJ cuban_pickup3 // SCFIX
	SET_CHAR_COORDINATES cuban_pickup3 -1112.5 65.2 10.4
	SET_CHAR_HEADING cuban_pickup3 357.4
ENDIF
SET_CHAR_COORDINATES scplayer -1110.95 67.38 10.4

IF NOT IS_CHAR_DEAD cuban_attacker2
	TURN_CHAR_TO_FACE_PLAYER cuban_attacker2 player1
	TURN_PLAYER_TO_FACE_CHAR player1 cuban_attacker2
	REMOVE_ALL_CHAR_WEAPONS cuban_attacker2
ENDIF

WAIT 1000


//looking at rico
SET_FIXED_CAMERA_POSITION -1110.3 64.24 11.6 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1114.0 71.1 10.25 JUMP_CUT

IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_ANSWERING_MOBILE cuban_attacker2 TRUE
ENDIF

WAIT 1000

PRINT_NOW ( CUB2_02 ) 4000 1 //RICO: We need reinforcements from the cafe!

PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB2_02 

LOAD_MISSION_AUDIO 1 CUB2_8
LOAD_MISSION_AUDIO 2 CUB2_4a

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_ANSWERING_MOBILE cuban_attacker2 FALSE
ENDIF

WAIT 1000


//getting player1 to go back to find out that he needs to pick up the next set of cubans

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////second set of cubans appearing//////////////////////////////////////////////////////////////////

CLEAR_AREA_OF_CARS -1063.6 11.9 0.6 -1080.9 102.8 20.4

SET_FIXED_CAMERA_POSITION -1079.0 73.4 14.0 0.0 0.0 0.0 
IF NOT IS_CAR_DEAD cuban_carry_car 
	POINT_CAMERA_AT_CAR cuban_carry_car FIXED JUMP_CUT
	SET_CAR_FORWARD_SPEED cuban_carry_car 40.0 
	SET_CAR_CRUISE_SPEED cuban_carry_car 40.0 
	CAR_GOTO_COORDINATES cuban_carry_car -1068.1 77.11 10.5
ENDIF

WHILE NOT LOCATE_CAR_2D cuban_carry_car  -1068.1 77.11 10.0 10.0 FALSE  
	WAIT 0
	IF NOT IS_CAR_DEAD cuban_carry_car
	ENDIF
ENDWHILE

IF NOT IS_CAR_DEAD cuban_carry_car
	SET_CAR_TEMP_ACTION cuban_carry_car TEMPACT_HANDBRAKETURNLEFT 10000
ENDIF

	 
IF NOT IS_CHAR_DEAD cuban_pickup4 
	SET_CHAR_OBJ_LEAVE_CAR cuban_pickup4 cuban_carry_car
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup5 
	SET_CHAR_OBJ_LEAVE_CAR cuban_pickup5 cuban_carry_car
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup6 
	SET_CHAR_OBJ_LEAVE_CAR cuban_pickup6 cuban_carry_car
ENDIF

cuban_attacker_doingstuff1 = 2
cuban_attacker_doingstuff2 = 2
cuban_attacker_doingstuff3 = 2
//getting chars to leave car and enter the battle

getting_the_cunts_out_the_car:

WAIT 0 

   	IF NOT IS_CAR_DEAD cuban_carry_car 
	   	GET_NUMBER_OF_PASSENGERS cuban_carry_car cubans_out_of_car
		IF cubans_out_of_car = 0 
			IF NOT IS_CHAR_DEAD cuban_pickup4
				IF NOT IS_CHAR_IN_ANY_CAR cuban_pickup4 
					SET_CHAR_OBJ_NO_OBJ cuban_pickup4    
					SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup4 -1079.8 70.0 
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD cuban_pickup5 
				IF NOT IS_CHAR_IN_ANY_CAR cuban_pickup5
					SET_CHAR_OBJ_NO_OBJ cuban_pickup5    
			   		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup5 -1078.8 70.0 
				ENDIF
			ENDIF
				
			IF NOT IS_CHAR_DEAD cuban_pickup6 
				IF NOT IS_CHAR_IN_ANY_CAR cuban_pickup6
					SET_CHAR_OBJ_NO_OBJ cuban_pickup6    
					SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup6 -1077.8 70.0
				ENDIF
			ENDIF
			GOTO getting_the_cunts_out_the_car2
		ELSE
			GOTO getting_the_cunts_out_the_car
		ENDIF
	ENDIF

GOTO getting_the_cunts_out_the_car 

getting_the_cunts_out_the_car2:

SET_FIXED_CAMERA_POSITION -1070.4 69.9 15.7 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1086.4 69.7 9.76 JUMP_CUT

WHILE NOT LOCATE_CHAR_ON_FOOT_3D cuban_pickup6 -1112.9 66.7 10.4 2.0 2.0 2.0 FALSE
	
	WAIT 0

	IF NOT IS_CHAR_DEAD cuban_pickup4
		IF cuban_attacker_doingstuff1 = 2 
			IF NOT LOCATE_CHAR_ON_FOOT_3D cuban_pickup4 -1079.8 71.0 10.4 1.0 1.0 1.0 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup4 -1079.8 71.0
			ELSE
				cuban_attacker_doingstuff1 = 0
				SET_CHAR_OBJ_NO_OBJ cuban_pickup4
			ENDIF
		ELSE
			IF LOCATE_CHAR_ON_FOOT_3D cuban_pickup4 -1112.0 74.5 10.4 1.0 1.0 1.0 FALSE // SCFIX: change Y, was 73.0
				SET_CHAR_OBJ_NO_OBJ cuban_pickup4
				SET_CHAR_HEADING cuban_pickup4 78.5
				cuban_attacker_doingstuff1 = 1
			ELSE
				IF cuban_attacker_doingstuff1 = 0
					SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup4 -1112.0 74.5  // SCFIX: change Y, was 73.0
					SET_CHAR_USE_PEDNODE_SEEK cuban_pickup6 FALSE // SCFIX
				ENDIF
			ENDIF
		ENDIF	
	ENDIF	 

	IF NOT IS_CHAR_DEAD cuban_pickup5 
		IF cuban_attacker_doingstuff2 = 2 
			IF NOT LOCATE_CHAR_ON_FOOT_3D cuban_pickup5 -1078.8 70.0 10.4 1.0 1.0 1.0 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup5 -1078.8 70.0
			ELSE
				cuban_attacker_doingstuff2 = 0
				SET_CHAR_OBJ_NO_OBJ cuban_pickup5
			ENDIF
		ELSE
			IF LOCATE_CHAR_ON_FOOT_3D cuban_pickup5 -1112.9 73.3 10.4 1.0 1.0 1.0 FALSE
				SET_CHAR_OBJ_NO_OBJ cuban_pickup5
				SET_CHAR_HEADING cuban_pickup5 274.5
				cuban_attacker_doingstuff2 = 1
			ELSE
				IF cuban_attacker_doingstuff2 = 0
					SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup5 -1112.9 73.3 
					SET_CHAR_USE_PEDNODE_SEEK cuban_pickup6 FALSE // SCFIX
				ENDIF
			ENDIF
		ENDIF	
	ENDIF	 

	IF NOT IS_CHAR_DEAD cuban_pickup6 
		IF cuban_attacker_doingstuff3 = 2 
			IF NOT LOCATE_CHAR_ON_FOOT_3D cuban_pickup6 -1077.8 69.0 10.4 1.0 1.0 1.0 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup6 -1077.8 69.0
			ELSE
				cuban_attacker_doingstuff3 = 0
				SET_CHAR_OBJ_NO_OBJ cuban_pickup6
			ENDIF
		ELSE
	   	    IF LOCATE_CHAR_ON_FOOT_3D cuban_pickup6 -1112.9 66.7 10.4 1.0 1.0 1.0 FALSE
	   			SET_CHAR_OBJ_NO_OBJ cuban_pickup6
				SET_CHAR_HEADING cuban_pickup6 27.6
				cuban_attacker_doingstuff3 = 1
			ELSE
				IF cuban_attacker_doingstuff3 = 0
					SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup6 -1112.9 66.7 
					SET_CHAR_USE_PEDNODE_SEEK cuban_pickup6 FALSE // SCFIX
				ENDIF
			ENDIF
		ENDIF	
	ENDIF	 
ENDWHILE   

//looking at rico
SET_FIXED_CAMERA_POSITION -1110.3 64.24 11.6 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1114.0 71.1 10.25 JUMP_CUT

WAIT 1000

IF NOT IS_CHAR_DEAD cuban_attacker2 
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_PLAYANIM_CHAT 10000
ENDIF

PRINT_NOW ( CUB2_05 ) 5000 1 //RICO: Take out that cowardly sniper!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB2_05 

IF NOT IS_CHAR_DEAD cuban_attacker2 
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_FALSE 100
ENDIF

SET_THREAT_REACTION_RANGE_MULTIPLIER 3.0

IF NOT IS_CHAR_DEAD cuban_pickup4 
	SET_CHAR_PERSONALITY cuban_pickup4 PEDSTAT_TOUGH_GUY  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup4 FALSE 
	SET_CHAR_THREAT_SEARCH cuban_pickup4 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup4 THREAT_COP
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup5 
	SET_CHAR_PERSONALITY cuban_pickup5 PEDSTAT_TOUGH_GUY  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup5 FALSE 
	SET_CHAR_THREAT_SEARCH cuban_pickup5 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup5 THREAT_COP
ENDIF							
	   
IF NOT IS_CHAR_DEAD cuban_pickup6 
	SET_CHAR_PERSONALITY cuban_pickup6 PEDSTAT_TOUGH_GUY  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_pickup6 FALSE 
	SET_CHAR_THREAT_SEARCH cuban_pickup6 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup6 THREAT_COP
ENDIF
IF NOT IS_CHAR_DEAD target2  
	ADD_BLIP_FOR_CHAR target2 sniper_blip
	SET_CHAR_COORDINATES target2 -1173.4 71.3 23.0 // SCFIX
	SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 scplayer // SCFIX
ENDIF

IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_WAIT_STATE cuban_attacker2 WAITSTATE_PLAYANIM_CHAT 10
	STOP_CHAR_LOOKING cuban_attacker2
	SET_CHAR_THREAT_SEARCH cuban_attacker2 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_attacker2 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_attacker2 THREAT_EMERGENCY
	GIVE_WEAPON_TO_CHAR cuban_attacker2 WEAPONTYPE_M4 99999
ENDIF

IF NOT IS_CHAR_DEAD cuban_attacker1
	SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_EMERGENCY
ENDIF

IF NOT IS_CHAR_DEAD cuban_pickup3
	SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_COP
	SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_EMERGENCY
ENDIF

IF NOT IS_CHAR_DEAD cuban_attacker2 
	STOP_CHAR_LOOKING cuban_attacker2 
ENDIF

IF NOT IS_CHAR_DEAD cuban_attacker1
	SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker1 -1120.0 68.0
ENDIF
IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker2 -1119.0 74.0
ENDIF

SET_CAR_DENSITY_MULTIPLIER 1.0 
SET_PED_DENSITY_MULTIPLIER 1.0
timerb = 0

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////SECOND GOAL - killing sniper and his mates/////////////////////////////////////////////////////

second_goal_loop:

WAIT 0

IF telling_guys_to_move = 0
	IF timerb > 7000
		IF NOT IS_CHAR_DEAD cuban_pickup3
			SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup3 -1138.0 71.0
		ENDIF
		IF NOT IS_CHAR_DEAD cuban_pickup4
			SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup4 -1138.0 71.0
		ENDIF
		IF NOT IS_CHAR_DEAD cuban_pickup5
			SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup5 -1138.0 71.0
		ENDIF
		IF NOT IS_CHAR_DEAD cuban_pickup6
			SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup6 -1138.0 71.0
		ENDIF
		telling_guys_to_move = 1
	ENDIF
ENDIF


IF IS_CHAR_DEAD cuban_attacker1
OR IS_CHAR_DEAD cuban_attacker2
OR body_count_cub2 > 0 // SCFIX: was = 1
	GOSUB nutters
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
	GOTO mission_failed_cuban2
ENDIF  

IF fire_car_flag = 0
	IF IS_PLAYER_IN_ANY_CAR player1 
		IF IS_PLAYER_IN_AREA_3D player1 -1095.2 57.9 17.8 -1122.8 90.7 7.0 FALSE
			STORE_CAR_PLAYER_IS_IN player1 death_car
			SET_CAR_HEALTH death_car 250
			fire_car_flag = 1
		ENDIF
	ELSE
		fire_car_flag = 0
	ENDIF
ENDIF  

IF IS_PLAYER_IN_ANY_CAR player1 
	IF IS_PLAYER_IN_AREA_3D player1 -1137.0 84.5 5.8 -1179.9 60.7 15.0 FALSE
		STORE_CAR_PLAYER_IS_IN player1 death_car
		EXPLODE_CAR death_car
	ENDIF
ENDIF  

GOSUB second_wave_haitian_attacking_rules
GOSUB player_killing_cubans

IF NOT IS_CHAR_DEAD target2
	IF NOT IS_PLAYER_IN_ANY_CAR player1 
		IF IS_PLAYER_IN_AREA_2D player1 -1136.4 61.1 -1158.1 78.6 FALSE
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 scplayer // SCFIX
			LOAD_MISSION_AUDIO 2 sniper
			WHILE NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			PLAY_MISSION_AUDIO 2
			EXPLODE_PLAYER_HEAD player1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			//CLEAR_MISSION_AUDIO 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup3 
		IF IS_CHAR_IN_AREA_2D cuban_pickup3 -1131.4 59.9 -1158.1 78.6 FALSE
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_pickup3 // SCFIX
			LOAD_MISSION_AUDIO 1 sniper
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			PLAY_MISSION_AUDIO 1
			
			IF NOT IS_CHAR_DEAD cuban_pickup3 
				EXPLODE_CHAR_HEAD cuban_pickup3
			ENDIF
			
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			//CLEAR_MISSION_AUDIO 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup4 
		IF IS_CHAR_IN_AREA_2D cuban_pickup4 -1133.4 59.9 -1158.1 78.6 FALSE
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_pickup4 // SCFIX

			LOAD_MISSION_AUDIO 1 sniper
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			PLAY_MISSION_AUDIO 1
			
			IF NOT IS_CHAR_DEAD cuban_pickup4 
				EXPLODE_CHAR_HEAD cuban_pickup4
			ENDIF
			
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			//CLEAR_MISSION_AUDIO 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup5 
		IF IS_CHAR_IN_AREA_2D cuban_pickup5 -1135.4 59.9 -1158.1 78.6 FALSE
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_pickup5 // SCFIX
			
			LOAD_MISSION_AUDIO 1 sniper
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			PLAY_MISSION_AUDIO 1
			
			IF NOT IS_CHAR_DEAD cuban_pickup5 
			    EXPLODE_CHAR_HEAD cuban_pickup5
			ENDIF
			
			
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			//CLEAR_MISSION_AUDIO 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup6 
		IF IS_CHAR_IN_AREA_2D cuban_pickup6 -1137.4 59.9 -1158.1 78.6 FALSE
			SET_CHAR_OBJ_AIM_GUN_AT_CHAR target2 cuban_pickup6 // SCFIX

			LOAD_MISSION_AUDIO 1 sniper
			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			PLAY_MISSION_AUDIO 1
			
			
			IF NOT IS_CHAR_DEAD cuban_pickup6 
			     EXPLODE_CHAR_HEAD cuban_pickup6
			ENDIF
			
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
				// SCFIX: START
				GOSUB player_killing_cubans
				IF IS_CHAR_DEAD cuban_attacker1
				OR IS_CHAR_DEAD cuban_attacker2
				OR body_count_cub2 > 0 // SCFIX: was = 1
					GOSUB nutters
					PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.	
					GOTO mission_failed_cuban2
				ENDIF  
				// SCFIX: END
			ENDWHILE
			//CLEAR_MISSION_AUDIO 1
		ENDIF
	ENDIF

	GOSUB creating_new_haitians

ELSE
	IF cuban_flag1 = 1
		PRINT_NOW ( CUB2_22 ) 5000 1 //Finish off the rest of the Haitians so the Cubans can move forward.
		IF NOT IS_CHAR_DEAD haitian_defender1 	
			ADD_BLIP_FOR_CHAR haitian_defender1 cuban_blip1
		ENDIF

		IF NOT IS_CHAR_DEAD haitian_defender2 	
			ADD_BLIP_FOR_CHAR haitian_defender2 cuban_blip2
		ENDIF

		IF NOT IS_CHAR_DEAD haitian_defender3 	
			ADD_BLIP_FOR_CHAR haitian_defender3 cuban_blip3
		ENDIF

		IF NOT IS_CHAR_DEAD haitian_defender4 	
			ADD_BLIP_FOR_CHAR haitian_defender4 cuban_blip4
		ENDIF

		IF NOT IS_CHAR_DEAD haitian_defender5 	
			ADD_BLIP_FOR_CHAR haitian_defender5 cuban_blip5
		ENDIF
		cuban_flag1 = 2
	ENDIF
	REMOVE_BLIP sniper_blip
	IF IS_CHAR_DEAD haitian_defender1 
		IF IS_CHAR_DEAD haitian_defender2 
			IF IS_CHAR_DEAD haitian_defender3 
				IF IS_CHAR_DEAD haitian_defender4 
					IF IS_CHAR_DEAD haitian_defender5
						REMOVE_BLIP cuban_blip1
						REMOVE_BLIP cuban_blip2
						REMOVE_BLIP cuban_blip3
						REMOVE_BLIP cuban_blip4
						REMOVE_BLIP cuban_blip5
						CLEAR_PRINTS
						WAIT 1000
						GOTO preparing_for_final_wave
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF IS_CHAR_DEAD haitian_defender1
	REMOVE_BLIP cuban_blip1
ENDIF 
IF IS_CHAR_DEAD haitian_defender2
	REMOVE_BLIP cuban_blip2
ENDIF 
IF IS_CHAR_DEAD haitian_defender3
	REMOVE_BLIP cuban_blip3
ENDIF 
IF IS_CHAR_DEAD haitian_defender4
	REMOVE_BLIP cuban_blip4
ENDIF 
IF IS_CHAR_DEAD haitian_defender5
	REMOVE_BLIP cuban_blip5
ENDIF 

GOTO second_goal_loop 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////SECOND GOAL - completed/////////////////////////////////////////////////////////////////////////

 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////THIRD GOAL - getting back to cuban base alive///////////////////////////////////////////////////
preparing_for_final_wave:

haitians_doubled_flag = 1

MARK_CHAR_AS_NO_LONGER_NEEDED target2

// ****************************************START OF CUTSCENE********************************

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -1161.2 71.5 12.6 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1152.3 71.9 10.8 JUMP_CUT



//creating car to be blown up and car to escape in

CREATE_CAR pony -1161.5 76.5 10.2 escape_car

SET_CAR_HEALTH escape_car 1500
SET_CAR_HEADING escape_car 90.7 
SET_CAR_ONLY_DAMAGED_BY_PLAYER escape_car TRUE
CREATE_OBJECT gunbox -1161.5 76.5 11.2 escape_car_drugs
SET_OBJECT_COLLISION escape_car_drugs FALSE
PLACE_OBJECT_RELATIVE_TO_CAR escape_car_drugs escape_car 0.0 -1.0 0.0 // SCFIX: fix Z coord

haitian1x = -1183.9 
haitian1y = 101.7
hd1_heading = 230.8

haitian2x = -1182.1
haitian2y = 103.2
hd2_heading = 215.1

haitian3x = -1180.8
haitian3y = 105.9
hd3_heading = 215.1

haitian4x = -1182.3
haitian4y = 106.9
hd4_heading = 215.1

haitian5x = -1184.9
haitian5y = 104.5
hd5_heading = 227.6

haitian_z = 10.1

GOSUB creating_new_haitians

haitians_doubled_flag = 2

GOSUB creating_new_haitians

WAIT 2000

IF NOT IS_PLAYER_IN_ANY_CAR player1 
	SET_PLAYER_COORDINATES player1 -1149.2 71.3 11.2
ELSE
	WARP_PLAYER_FROM_CAR_TO_COORD player1 -1149.2 71.3 11.2
ENDIF 	

SET_FIXED_CAMERA_POSITION -1149.2 71.3 13.7 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1163.7 73.3 10.7 JUMP_CUT

IF NOT IS_CHAR_DEAD cuban_attacker1
	SET_CHAR_COORDINATES cuban_attacker1 -1149.2 72.3 10.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_COORDINATES cuban_attacker2 -1149.2 73.3 10.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup3 
	SET_CHAR_COORDINATES cuban_pickup3 -1151.2 73.3 10.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup4 
	SET_CHAR_COORDINATES cuban_pickup4 -1151.2 72.3 10.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup5 
	SET_CHAR_COORDINATES cuban_pickup5 -1153.2 73.3 10.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup6 
	SET_CHAR_COORDINATES cuban_pickup6 -1153.2 72.3 10.2
ENDIF

PRINT_NOW ( CUB2_21 ) 5000 1 //Fight like men with huge cajones!
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD cuban_attacker2 
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB2_21 

LOAD_MISSION_AUDIO 1 CUB2_10
LOAD_MISSION_AUDIO 2 CUB2_11

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

IF NOT IS_CHAR_DEAD cuban_attacker2
	SET_CHAR_HEED_THREATS cuban_attacker2 FALSE 
	SET_CHAR_OBJ_NO_OBJ cuban_attacker2 
	CLEAR_CHAR_THREAT_SEARCH cuban_attacker2 
	SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker2 -1167.7 73.3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_attacker2 FALSE
ENDIF 

WAIT 300

IF NOT IS_CHAR_DEAD cuban_attacker1
	SET_CHAR_HEED_THREATS cuban_attacker1 FALSE 
	SET_CHAR_OBJ_NO_OBJ cuban_attacker1 
	CLEAR_CHAR_THREAT_SEARCH cuban_attacker1 
	SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker1 -1165.1 68.0 
ENDIF

WAIT 300

IF NOT IS_CHAR_DEAD cuban_pickup3 
	SET_CHAR_HEED_THREATS cuban_pickup3 FALSE 
	SET_CHAR_OBJ_NO_OBJ cuban_pickup3 
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup3 
	SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup3 -1166.7 73.3 
ENDIF 

WAIT 300

IF NOT IS_CHAR_DEAD cuban_pickup4 
	SET_CHAR_HEED_THREATS cuban_pickup4 FALSE 
	SET_CHAR_OBJ_NO_OBJ cuban_pickup4 
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup4 
	SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup4 -1165.7 73.3 
ENDIF 

WAIT 300

IF NOT IS_CHAR_DEAD cuban_pickup5 
	SET_CHAR_HEED_THREATS cuban_pickup5 FALSE 
	SET_CHAR_OBJ_NO_OBJ cuban_pickup5 
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup5 
	SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup5 -1164.7 73.3 
ENDIF 

WAIT 300

IF NOT IS_CHAR_DEAD cuban_pickup6 
	SET_CHAR_HEED_THREATS cuban_pickup6 FALSE 
	SET_CHAR_OBJ_NO_OBJ cuban_pickup6 
	CLEAR_CHAR_THREAT_SEARCH cuban_pickup6 
	SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup6 -1164.7 70.3 
ENDIF 

WAIT 300

IF NOT IS_CHAR_DEAD cuban_attacker1
	TURN_CHAR_TO_FACE_COORD cuban_attacker1 -1173.8 102.5 11.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_attacker2
	TURN_CHAR_TO_FACE_COORD cuban_attacker2 -1173.8 102.5 11.2
ENDIF
IF NOT IS_CHAR_DEAD cuban_pickup3 
	TURN_CHAR_TO_FACE_COORD cuban_pickup3 -1173.8 102.5 11.2
ENDIF 
IF NOT IS_CHAR_DEAD cuban_pickup4 
	TURN_CHAR_TO_FACE_COORD cuban_pickup4 -1173.8 102.5 11.2
ENDIF 
IF NOT IS_CHAR_DEAD cuban_pickup5 
	TURN_CHAR_TO_FACE_COORD cuban_pickup5 -1173.8 102.5 11.2
ENDIF 
IF NOT IS_CHAR_DEAD cuban_pickup6 
	TURN_CHAR_TO_FACE_COORD cuban_pickup6 -1173.8 102.5 11.2
ENDIF 

SET_CHAR_OBJ_RUN_TO_COORD scplayer -1161.7 73.3 

WAIT 2000
timera = 0
little_ickle_bit:

WAIT 0

IF NOT IS_CHAR_DEAD cuban_attacker2 	  
	IF LOCATE_CHAR_ANY_MEANS_2D cuban_attacker2 -1167.7 73.3 4.0 4.0 FALSE
	OR timera > 5000  
		
		SET_FIXED_CAMERA_POSITION -1163.2 64.2 16.5 0.0 0.0 0.0 
		POINT_CAMERA_AT_POINT -1163.7 73.3 12.2 JUMP_CUT
		
		IF NOT IS_CHAR_DEAD cuban_attacker1
			SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_attacker1 THREAT_EMERGENCY
			SET_CHAR_HEED_THREATS cuban_attacker1 TRUE
		ENDIF
		IF NOT IS_CHAR_DEAD cuban_pickup3 
			SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_pickup3 THREAT_EMERGENCY
			SET_CHAR_HEED_THREATS cuban_pickup3 TRUE
		ENDIF 
		IF NOT IS_CHAR_DEAD cuban_pickup4 
			SET_CHAR_THREAT_SEARCH cuban_pickup4 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_pickup4 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_pickup4 THREAT_EMERGENCY
			SET_CHAR_HEED_THREATS cuban_pickup4 TRUE
		ENDIF 
		IF NOT IS_CHAR_DEAD cuban_pickup5 
			SET_CHAR_THREAT_SEARCH cuban_pickup5 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_pickup5 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_pickup5 THREAT_EMERGENCY
			SET_CHAR_HEED_THREATS cuban_pickup5 TRUE
		ENDIF 
		IF NOT IS_CHAR_DEAD cuban_pickup6 
			SET_CHAR_THREAT_SEARCH cuban_pickup6 THREAT_GANG_HAITIAN
			SET_CHAR_THREAT_SEARCH cuban_pickup6 THREAT_COP
			SET_CHAR_THREAT_SEARCH cuban_pickup6 THREAT_EMERGENCY
			SET_CHAR_HEED_THREATS cuban_pickup6 TRUE
		ENDIF 

		WAIT 2000

		IF NOT IS_CHAR_DEAD cuban_attacker2
			IF NOT IS_CAR_DEAD escape_car
				//CLEAR_CHAR_THREAT_SEARCH cuban_attacker2 
				SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER cuban_attacker2 escape_car
				SET_CHAR_CANT_BE_DRAGGED_OUT cuban_attacker2 TRUE 	
			ENDIF
		ENDIF
		  
		GOTO next_little_ickle_bit 
	ELSE
		GOTO little_ickle_bit
	ENDIF
ENDIF	



next_little_ickle_bit:
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1115.6 69.6 10.1 fake_haitian1
SET_CHAR_HEADING fake_haitian1 105.9 
GIVE_WEAPON_TO_CHAR fake_haitian1 WEAPONTYPE_uzi 30000
CLEAR_CHAR_THREAT_SEARCH fake_haitian1
SET_CHAR_PERSONALITY fake_haitian1 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH fake_haitian1 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH fake_haitian1 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH fake_haitian1 THREAT_COP
SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY fake_haitian1 TRUE
SET_CHAR_HEED_THREATS fake_haitian1 TRUE 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1115.6 73.7 10.1 fake_haitian2
SET_CHAR_HEADING fake_haitian2 105.9 
GIVE_WEAPON_TO_CHAR fake_haitian2 WEAPONTYPE_uzi 30000
CLEAR_CHAR_THREAT_SEARCH fake_haitian2
SET_CHAR_PERSONALITY fake_haitian2 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH fake_haitian2 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH fake_haitian2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH fake_haitian2 THREAT_COP
SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY fake_haitian2 TRUE
SET_CHAR_HEED_THREATS fake_haitian2 TRUE 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNb -1115.6 71.0 10.1 fake_haitian3
SET_CHAR_HEADING fake_haitian3 105.9 
GIVE_WEAPON_TO_CHAR fake_haitian3 WEAPONTYPE_uzi 30000
CLEAR_CHAR_THREAT_SEARCH fake_haitian3
SET_CHAR_PERSONALITY fake_haitian3 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH fake_haitian3 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH fake_haitian3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH fake_haitian3 THREAT_COP
SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY fake_haitian3 TRUE
SET_CHAR_HEED_THREATS fake_haitian3 TRUE 

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
timera = 0
PRINT_NOW ( CUB2_16 ) 5000 1 //Tommy, we have proved our manful bravery! // SCFIX: replace PRINT with PRINT_NOW
IF NOT IS_CHAR_DEAD cuban_attacker2 
	PLAY_MISSION_AUDIO 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	AND NOT IS_CHAR_DEAD cuban_attacker2 
		WAIT 0
		IF NOT IS_CAR_DEAD escape_car
			PLACE_OBJECT_RELATIVE_TO_CAR escape_car_drugs escape_car 0.0 -1.0 0.0 // SCFIX: fix Z coord
		ENDIF
	ENDWHILE
	CLEAR_MISSION_AUDIO 1
ELSE
	CLEAR_MISSION_AUDIO 1
ENDIF
CLEAR_THIS_PRINT CUB2_16 
PRINT_NOW ( CUB2_17 ) 10000 1 //Let us steal that van full of drugs and make good our escape! // SCFIX: replace PRINT with PRINT_NOW
IF NOT IS_CHAR_DEAD cuban_attacker2 
	PLAY_MISSION_AUDIO 2
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	AND NOT IS_CHAR_DEAD cuban_attacker2 
		WAIT 0
		IF NOT IS_CAR_DEAD escape_car
			PLACE_OBJECT_RELATIVE_TO_CAR escape_car_drugs escape_car 0.0 -1.0 0.0 // SCFIX: fix Z coord
		ENDIF
	ENDWHILE
	CLEAR_MISSION_AUDIO 2
ELSE
	CLEAR_MISSION_AUDIO 2	
ENDIF
CLEAR_THIS_PRINT CUB2_17 // SCFIX

ALTER_WANTED_LEVEL_NO_DROP player1 2

// ******************************************END OF CUTSCENE********************************

final_wave_part1:
WAIT 0
 
IF NOT IS_CAR_DEAD escape_car
	PLACE_OBJECT_RELATIVE_TO_CAR escape_car_drugs escape_car 0.0 -1.0 0.0 // SCFIX: fix Z coord

	IF blob_flag = 0
		ADD_BLIP_FOR_CAR escape_car escape_car_blip
		blob_flag = 1
	ENDIF

	IF IS_PLAYER_IN_CAR player1 escape_car
		/* SCFIX: removed, what was the point of this?
		IF timera < 15000
			CLEAR_PRINTS 
			PRINT ( CUB2_16 ) 5000 1 //Tommy, we have proved our manful bravery!
		ENDIF
		*/
		REMOVE_BLIP escape_car_blip
		ADD_BLIP_FOR_COORD -1160.0 -605.9 10.7 home_blip
		blob_flag = 0
		PRINT_NOW ( CUB2_24 ) 5000 1 //Return to Robina's Cafe with the Van and park it round the back.  
		IF NOT IS_CAR_DEAD escape_car 
			SET_CAR_ONLY_DAMAGED_BY_PLAYER escape_car FALSE
		ENDIF
		GOTO final_wave_part2
	ENDIF
ELSE 
	PRINT_NOW ( CUB2_11 ) 5000 1 //You fool, we needed that car.
	GOTO mission_failed_cuban2
ENDIF   

//creating final wave of Haitians pouring out of base

haitian1x = -1198.9 
haitian1y = 96.7
hd1_heading = 255.8

haitian2x = -1198.9
haitian2y = 96.7
hd2_heading = 255.8

haitian3x = -1198.9
haitian3y = 96.7
hd3_heading = 255.8

haitian4x = -1198.9
haitian4y = 96.7
hd4_heading = 255.8

haitian5x = -1198.9
haitian5y = 96.7
hd5_heading = 255.8

GOSUB creating_new_haitians

GOTO final_wave_part1 

final_wave_part2:
WAIT 0

IF NOT IS_CAR_DEAD escape_car
	PLACE_OBJECT_RELATIVE_TO_CAR escape_car_drugs escape_car 0.0 -1.0 0.0 // SCFIX: fix Z coord
	
	IF IS_PLAYER_IN_CAR player1 escape_car
		IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 -1160.0 -605.9 10.7 10.0 10.0 10.0 TRUE
			SET_CHAR_OBJ_LEAVE_CAR scplayer escape_car
			LOCK_CAR_DOORS escape_car CARLOCK_LOCKOUT_PLAYER_ONLY
			GOTO mission_passed_cuban2
		ENDIF
		IF blob_flag = 0
			REMOVE_BLIP home_blip 
			REMOVE_BLIP escape_car_blip
			ADD_BLIP_FOR_COORD -1160.0 -605.9 10.7 home_blip 
			blob_flag = 1
		ENDIF 
	ELSE
		IF blob_flag = 1
			PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
			REMOVE_BLIP home_blip 
			REMOVE_BLIP escape_car_blip
			ADD_BLIP_FOR_CAR escape_car escape_car_blip
		    blob_flag = 0
		ENDIF
	ENDIF
ELSE
	PRINT_NOW ( CUB2_11 ) 5000 1 //You fool, we needed that car.
	GOTO mission_failed_cuban2
ENDIF  

GOSUB creating_new_haitians

IF IS_CHAR_DEAD cuban_attacker2
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_attacker2 
ENDIF 

IF IS_CHAR_DEAD cuban_attacker1
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_attacker1 
ENDIF

IF IS_CHAR_DEAD cuban_pickup3 
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup3 
ENDIF 

IF IS_CHAR_DEAD cuban_pickup4 
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup4 
ENDIF 

IF IS_CHAR_DEAD cuban_pickup5 
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup5 
ENDIF 

IF IS_CHAR_DEAD cuban_pickup6 
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup6 
ENDIF 

IF body_count_cub2 > 0 // SCFIX: was = 1
	GOSUB nutters
ENDIF  
GOTO final_wave_part2

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////THIRD GOAL - completed - MISSION PASSED/////////////////////////////////////////////////////////

// Mission failed
mission_failed_cuban2:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_cuban2:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED CUB_2
START_NEW_SCRIPT cuban_mission3_loop
flag_cuban_mission2_passed = 1
// SCFIX: START - moved here from cleanup, also not using SLIDE_OBJECT anymore
//closing gate
SET_OBJECT_COORDINATES haitian_gate -1114.5 67.0 10.1
// SCFIX: END
RETURN
		


// mission cleanup
mission_cleanup_cuban2:
// SCFIX: START
CLEAR_THIS_PRINT CUB2_04
CLEAR_THIS_PRINT CUB2_05
IF NOT IS_CHAR_DEAD target2
	REMOVE_CHAR_ELEGANTLY target2
ENDIF
// SCFIX: END
flag_player_on_mission = 0
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
flag_is_on_cuban_mission = 0 // SCFIX
SET_PLAYER_CONTROL player1 on
//andy_has_control = 0 //reseting gate
//closing gate
/* SCFIX: closing only if mission passed now
WHILE NOT SLIDE_OBJECT haitian_gate -1114.5 67.0 10.1 10.0 10.0 0.0 FALSE
	WAIT 0
ENDWHILE*/
MARK_MODEL_AS_NO_LONGER_NEEDED CBa
MARK_MODEL_AS_NO_LONGER_NEEDED stinger
MARK_MODEL_AS_NO_LONGER_NEEDED pony
MARK_MODEL_AS_NO_LONGER_NEEDED uzi
MARK_MODEL_AS_NO_LONGER_NEEDED sniper
MARK_MODEL_AS_NO_LONGER_NEEDED HNa
MARK_MODEL_AS_NO_LONGER_NEEDED CBb
MARK_MODEL_AS_NO_LONGER_NEEDED HNb
MARK_MODEL_AS_NO_LONGER_NEEDED m4
MARK_MODEL_AS_NO_LONGER_NEEDED taxi
MARK_MODEL_AS_NO_LONGER_NEEDED WMOCA
MARK_MODEL_AS_NO_LONGER_NEEDED cellphone
IF NOT HAS_PICKUP_BEEN_COLLECTED free_scope
	REMOVE_PICKUP free_scope
ENDIF
DELETE_OBJECT escape_car_drugs
REMOVE_BLIP cuban_pickup_blip
REMOVE_BLIP drop_off_point1
REMOVE_BLIP radar_blip_cuban_carry_car
REMOVE_BLIP escape_car_blip
REMOVE_BLIP	home_blip
REMOVE_BLIP cuban_blip1
REMOVE_BLIP cuban_blip2
REMOVE_BLIP cuban_blip3
REMOVE_BLIP cuban_blip4
REMOVE_BLIP cuban_blip5
REMOVE_BLIP sniper_blip
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN


	
///////////////////////////////////////////////////////////////////////////////////////////
creating_new_haitians://///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF IS_CHAR_DEAD haitian_defender1
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_defender1  
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian1x haitian1y haitian_z haitian_defender1
	SET_CHAR_HEADING haitian_defender1 hd1_heading 
	GIVE_WEAPON_TO_CHAR haitian_defender1 WEAPONTYPE_uzi 30000
	CLEAR_CHAR_THREAT_SEARCH haitian_defender1
	SET_CHAR_PERSONALITY haitian_defender1 PEDSTAT_TOUGH_GUY  
	//SET_CHAR_THREAT_SEARCH haitian_defender1 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_defender1 THREAT_PLAYER1
	//SET_CHAR_THREAT_SEARCH haitian_defender1 THREAT_COP
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender1 TRUE
	SET_CHAR_HEED_THREATS haitian_defender1 TRUE 
	IF cuban_flag1 = 0
		REMOVE_BLIP cuban_blip1
		ADD_BLIP_FOR_CHAR haitian_defender1 cuban_blip1
		SET_CHAR_ACCURACY haitian_defender1 80
	ENDIF  
	number_of_haitians_dead ++
ELSE
	IF NOT haitians_doubled_flag = 0
		SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender1 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender1 player1
	ENDIF
ENDIF 

IF IS_CHAR_DEAD haitian_defender2
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_defender2  
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian2x haitian2y haitian_z haitian_defender2
	SET_CHAR_HEADING haitian_defender2 hd2_heading 
	GIVE_WEAPON_TO_CHAR haitian_defender2 WEAPONTYPE_uzi 30000
	CLEAR_CHAR_THREAT_SEARCH haitian_defender2
	SET_CHAR_PERSONALITY haitian_defender2 PEDSTAT_TOUGH_GUY  
	SET_CHAR_THREAT_SEARCH haitian_defender2 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_defender2 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH haitian_defender2 THREAT_COP
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender2 TRUE  
	SET_CHAR_HEED_THREATS haitian_defender2 TRUE 
	IF cuban_flag1 = 0
		REMOVE_BLIP cuban_blip2
		ADD_BLIP_FOR_CHAR haitian_defender2 cuban_blip2
		SET_CHAR_ACCURACY haitian_defender2 80
	ENDIF  
	number_of_haitians_dead ++
ELSE
	IF NOT haitians_doubled_flag = 0
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender2 FALSE  
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender2 player1
	ENDIF
ENDIF

IF IS_CHAR_DEAD haitian_defender3
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_defender3  
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian3x haitian3y haitian_z haitian_defender3
	SET_CHAR_HEADING haitian_defender3 hd3_heading 
	GIVE_WEAPON_TO_CHAR haitian_defender3 WEAPONTYPE_uzi 30000
	CLEAR_CHAR_THREAT_SEARCH haitian_defender3
	SET_CHAR_PERSONALITY haitian_defender3 PEDSTAT_TOUGH_GUY  
	SET_CHAR_THREAT_SEARCH haitian_defender3 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_defender3 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH haitian_defender3 THREAT_COP
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender3 TRUE
	SET_CHAR_HEED_THREATS haitian_defender3 TRUE 
	IF cuban_flag1 = 0
		REMOVE_BLIP cuban_blip3
		ADD_BLIP_FOR_CHAR haitian_defender3 cuban_blip3
	ENDIF  
	number_of_haitians_dead ++
ELSE
	IF NOT haitians_doubled_flag = 0
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender3 FALSE
		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender3 -1173.1 79.6 
		SET_CHAR_ACCURACY haitian_defender3 80 
	ENDIF
ENDIF

IF IS_CHAR_DEAD haitian_defender4
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_defender4  
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian4x haitian4y haitian_z haitian_defender4
	SET_CHAR_HEADING haitian_defender4 hd4_heading 
	GIVE_WEAPON_TO_CHAR haitian_defender4 WEAPONTYPE_uzi 30000
	CLEAR_CHAR_THREAT_SEARCH haitian_defender4
	SET_CHAR_PERSONALITY haitian_defender4 PEDSTAT_TOUGH_GUY  
	SET_CHAR_THREAT_SEARCH haitian_defender4 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_defender4 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH haitian_defender4 THREAT_COP
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender4 TRUE 
	SET_CHAR_HEED_THREATS haitian_defender4 TRUE 
	IF cuban_flag1 = 0
		REMOVE_BLIP cuban_blip4
		ADD_BLIP_FOR_CHAR haitian_defender4 cuban_blip4
		SET_CHAR_ACCURACY haitian_defender4 80 
	ENDIF  
	number_of_haitians_dead ++
ELSE
	IF NOT haitians_doubled_flag = 0
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender4 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender4 player1
	ENDIF
ENDIF 

IF IS_CHAR_DEAD haitian_defender5
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_defender5  
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa haitian5x haitian5y haitian_z haitian_defender5
	SET_CHAR_HEADING haitian_defender5 hd5_heading 
	CLEAR_CHAR_THREAT_SEARCH haitian_defender5
	SET_CHAR_PERSONALITY haitian_defender5 PEDSTAT_TOUGH_GUY  
	//SET_CHAR_THREAT_SEARCH haitian_defender5 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_defender5 THREAT_PLAYER1
	//SET_CHAR_THREAT_SEARCH haitian_defender5 THREAT_COP
	SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender5 TRUE
	SET_CHAR_HEED_THREATS haitian_defender5 TRUE 
	SET_CHAR_ACCURACY haitian_defender5 80 
	IF cuban_flag1 = 0
		REMOVE_BLIP cuban_blip5
		ADD_BLIP_FOR_CHAR haitian_defender5 cuban_blip5
		GIVE_WEAPON_TO_CHAR haitian_defender5 WEAPONTYPE_uzi 30000
	ELSE
		GIVE_WEAPON_TO_CHAR haitian_defender5 WEAPONTYPE_m4 30000
		ADD_ARMOUR_TO_CHAR haitian_defender5 100
	ENDIF  
	number_of_haitians_dead ++
ELSE
	IF NOT haitians_doubled_flag = 0
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender5 FALSE
		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender5 -1172.6 91.6 
	ENDIF
ENDIF

IF NOT haitians_doubled_flag = 0
	IF IS_CHAR_DEAD haitian_defender6
		IF haitians_doubled_flag = 1
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1166.5 104.2 10.2 haitian_defender6
		ELSE
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1186.5 104.0 10.2 haitian_defender6
		ENDIF
		SET_CHAR_HEADING haitian_defender6 187.5 
		GIVE_WEAPON_TO_CHAR haitian_defender6 WEAPONTYPE_uzi 30000
		CLEAR_CHAR_THREAT_SEARCH haitian_defender6
		SET_CHAR_PERSONALITY haitian_defender6 PEDSTAT_TOUGH_GUY  
		SET_CHAR_THREAT_SEARCH haitian_defender6 THREAT_GANG_CUBAN
		SET_CHAR_THREAT_SEARCH haitian_defender6 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH haitian_defender6 THREAT_COP
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender6 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender6 player1
		SET_CHAR_HEED_THREATS haitian_defender6 TRUE 
	ENDIF

	IF IS_CHAR_DEAD haitian_defender7
		IF haitians_doubled_flag = 1
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1169.0 103.5 10.2 haitian_defender7
		ELSE
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1186.5 104.0 10.2 haitian_defender7
		ENDIF
		SET_CHAR_HEADING haitian_defender7 199.5 
		GIVE_WEAPON_TO_CHAR haitian_defender7 WEAPONTYPE_uzi 30000
		CLEAR_CHAR_THREAT_SEARCH haitian_defender7
		SET_CHAR_PERSONALITY haitian_defender7 PEDSTAT_TOUGH_GUY  
		SET_CHAR_THREAT_SEARCH haitian_defender7 THREAT_GANG_CUBAN
		SET_CHAR_THREAT_SEARCH haitian_defender7 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH haitian_defender7 THREAT_COP
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender7 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender7 player1
		SET_CHAR_HEED_THREATS haitian_defender7 TRUE 
	ENDIF

	IF IS_CHAR_DEAD haitian_defender8
		IF haitians_doubled_flag = 1
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1170.5 103.2 10.2 haitian_defender8
		ELSE
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1186.5 104.0 10.2 haitian_defender8
		ENDIF
		SET_CHAR_HEADING haitian_defender8 187.5 
		GIVE_WEAPON_TO_CHAR haitian_defender8 WEAPONTYPE_uzi 30000
		CLEAR_CHAR_THREAT_SEARCH haitian_defender8
		SET_CHAR_PERSONALITY haitian_defender8 PEDSTAT_TOUGH_GUY  
		SET_CHAR_THREAT_SEARCH haitian_defender8 THREAT_GANG_CUBAN
		SET_CHAR_THREAT_SEARCH haitian_defender8 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH haitian_defender8 THREAT_COP
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender8 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender8 player1
		SET_CHAR_HEED_THREATS haitian_defender8 TRUE 
	ENDIF


	IF IS_CHAR_DEAD haitian_defender9
		IF haitians_doubled_flag = 1
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1164.5 106.2 10.2 haitian_defender9
		ELSE
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1186.5 104.0 10.2 haitian_defender9
		ENDIF
		SET_CHAR_HEADING haitian_defender9 187.5 
		GIVE_WEAPON_TO_CHAR haitian_defender9 WEAPONTYPE_uzi 30000
		CLEAR_CHAR_THREAT_SEARCH haitian_defender9
		SET_CHAR_PERSONALITY haitian_defender9 PEDSTAT_TOUGH_GUY  
		SET_CHAR_THREAT_SEARCH haitian_defender9 THREAT_GANG_CUBAN
		SET_CHAR_THREAT_SEARCH haitian_defender9 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH haitian_defender9 THREAT_COP
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender9 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender9 player1
		SET_CHAR_HEED_THREATS haitian_defender9 TRUE 
	ENDIF

	IF IS_CHAR_DEAD haitian_defender10
	
		IF haitians_doubled_flag = 1
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1168.5 106.2 10.2 haitian_defender10
		ELSE
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1186.5 104.0 10.2 haitian_defender10
		ENDIF
		SET_CHAR_HEADING haitian_defender10 187.5 
		GIVE_WEAPON_TO_CHAR haitian_defender10 WEAPONTYPE_uzi 30000
		CLEAR_CHAR_THREAT_SEARCH haitian_defender10
		SET_CHAR_PERSONALITY haitian_defender10 PEDSTAT_TOUGH_GUY  
		SET_CHAR_THREAT_SEARCH haitian_defender10 THREAT_GANG_CUBAN
		SET_CHAR_THREAT_SEARCH haitian_defender10 THREAT_PLAYER1
		SET_CHAR_THREAT_SEARCH haitian_defender10 THREAT_COP
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY haitian_defender10 FALSE
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_defender10 player1
		SET_CHAR_HEED_THREATS haitian_defender10 TRUE 
	ENDIF
ENDIF	   
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
leading_the_cubans_part1://////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
//setting cubans up for when player is in haitian danger area 
IF NOT IS_CHAR_DEAD cuban_attacker1 
	IF NOT IS_CHAR_DEAD cuban_attacker2 
		IF NOT IS_CHAR_DEAD cuban_attacker3 
			IF IS_PLAYER_IN_AREA_3D player1 -1086.0 74.6 17.8 -1112.8 64.7 7.0 FALSE
				IF ped_density_flag = 0
					SET_PED_DENSITY_MULTIPLIER 0.0
					ped_density_flag = 1
				ENDIF
				IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_attacker1 -1096.3 67.8 2.0 2.0 FALSE
					//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker1 FALSE
					SET_CHAR_CROUCH cuban_attacker1 FALSE 1
					cuban_crouch1 = 0
			  		SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker1 -1096.3 67.8
			  	ELSE
					IF IS_CHAR_OBJECTIVE_PASSED cuban_attacker1 
			  	 		SET_CHAR_HEADING cuban_attacker1 91.5
						IF cuban_crouch1 = 0
							SET_CHAR_CROUCH cuban_attacker1 TRUE 86400000
							cuban_crouch1 = 1
						ENDIF 
						SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker1 TRUE
					ENDIF
				ENDIF
				IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_attacker2 -1081.2 69.9 2.0 2.0 FALSE
					//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker2 FALSE
			  		SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker2 -1079.3 69.9
			  	ELSE
					IF IS_CHAR_OBJECTIVE_PASSED cuban_attacker2 
						SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker2 TRUE
			  	 		SET_CHAR_HEADING cuban_attacker2 89.9
					ENDIF
				ENDIF
				IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_attacker3 -1096.8 72.6 2.0 2.0 FALSE
					//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker3 FALSE
					SET_CHAR_CROUCH cuban_attacker3 FALSE 1
			  		cuban_crouch3 = 0
			  		SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker3 -1096.8 72.6
			  	ELSE
					IF IS_CHAR_OBJECTIVE_PASSED cuban_attacker3 
			  	 		SET_CHAR_HEADING cuban_attacker3 91.5
						IF cuban_crouch3 = 0
							SET_CHAR_CROUCH cuban_attacker3 TRUE 86400000 
							cuban_crouch3 = 1
						ENDIF 
						SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker3 TRUE
					ENDIF
				ENDIF
//setting cubans up for when player is outside haitian danger area 
			ELSE
				IF ped_density_flag = 1
					SET_PED_DENSITY_MULTIPLIER 1.0
					ped_density_flag = 0
				ENDIF
				IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_attacker1 -1079.5 72.6 2.0 2.0 FALSE
					SET_CHAR_CROUCH cuban_attacker1 FALSE 1
					//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker1 FALSE
			  		SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker1 -1079.5 72.6
			  	ELSE
					IF IS_CHAR_OBJECTIVE_PASSED cuban_attacker1 
						SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker1 TRUE
			  	 		SET_CHAR_HEADING cuban_attacker1 91.5
					ENDIF
				ENDIF
				IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_attacker2 -1079.6 73.9 2.0 2.0 FALSE
					//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker2 FALSE
			  		SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker2 -1079.6 73.9
			  	ELSE
					IF IS_CHAR_OBJECTIVE_PASSED cuban_attacker2 
						SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker2 TRUE
						SET_CHAR_HEADING cuban_attacker2 270.9
					ENDIF
				ENDIF
				IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_attacker3 -1079.3 68.6 2.0 2.0 FALSE
					SET_CHAR_CROUCH cuban_attacker3 FALSE 1
					//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker3 FALSE
			  		SET_CHAR_OBJ_RUN_TO_COORD cuban_attacker3 -1079.3 68.6
			  	ELSE
					IF IS_CHAR_OBJECTIVE_PASSED cuban_attacker3 
						SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_attacker3 TRUE
						SET_CHAR_HEADING cuban_attacker3 82.1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF	
ENDIF

IF fire_car_flag = 0
	IF IS_PLAYER_IN_ANY_CAR player1 
		IF IS_PLAYER_IN_AREA_3D player1 -1095.2 57.9 17.8 -1122.8 90.7 7.0 FALSE
			STORE_CAR_PLAYER_IS_IN player1 death_car
			SET_CAR_HEALTH death_car 250
			fire_car_flag = 1
		ENDIF
	ELSE
		fire_car_flag = 0
	ENDIF
ENDIF  

IF IS_PLAYER_IN_ANY_CAR player1 
	IF IS_PLAYER_IN_AREA_3D player1 -1113.0 57.9 17.8 -1122.8 90.7 7.0 FALSE
		STORE_CAR_PLAYER_IS_IN player1 death_car
		EXPLODE_CAR death_car
	ENDIF
ENDIF  
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
picked_up_cubans_fighting_rules:///////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
//setting cubans up for when player1 is in haitian danger area 
IF IS_PLAYER_IN_AREA_3D player1 -1086.0 74.6 17.8 -1112.8 64.7 7.0 FALSE
	IF NOT IS_CHAR_DEAD cuban_pickup1 
		IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_pickup1 -1089.9 68.1 2.0 2.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup1 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup1 -1089.9 68.1
	  	ELSE
			IF IS_CHAR_OBJECTIVE_PASSED cuban_pickup1 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup1 TRUE
	  	 		SET_CHAR_HEADING cuban_pickup1 89.9
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup2 
		IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_pickup2 -1090.2 72.6 2.0 2.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup2 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup2 -1090.2 72.6
	  	ELSE
			IF IS_CHAR_OBJECTIVE_PASSED cuban_pickup2 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup2 TRUE
	  	 		SET_CHAR_HEADING cuban_pickup2 89.9
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup3 
		IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_pickup3 -1089.6 69.1 2.0 2.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup3 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup3 -1089.6 69.1
	  	ELSE
			IF IS_CHAR_OBJECTIVE_PASSED cuban_pickup3 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup3 TRUE
	  	 		SET_CHAR_HEADING cuban_pickup3 89.9
			ENDIF
		ENDIF
	ENDIF
//setting cubans up for when player1 is outside haitian danger area 
ELSE
	IF NOT IS_CHAR_DEAD cuban_pickup1 
		IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_pickup1 -1076.5 69.8 2.0 2.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup1 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup1 -1076.5 69.8
	  	ELSE
			IF IS_CHAR_OBJECTIVE_PASSED cuban_pickup1 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup1 TRUE
	  	 		SET_CHAR_HEADING cuban_pickup1 91.5
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup2 
		IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_pickup2 -1075.2 71.0 2.0 2.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup2 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup2 -1075.2 71.0
	  	ELSE
			IF IS_CHAR_OBJECTIVE_PASSED cuban_pickup2 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup2 TRUE
	  	 		SET_CHAR_HEADING cuban_pickup2 91.5
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD cuban_pickup3 
		IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_pickup3 -1075.2 67.5 2.0 2.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup3 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD cuban_pickup3 -1075.2 67.5
	  	ELSE
			IF IS_CHAR_OBJECTIVE_PASSED cuban_pickup3 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	cuban_pickup3 TRUE
	  	 		SET_CHAR_HEADING cuban_pickup3 91.5
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
checking_car_is_in_one_piece://////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD cuban_carry_car 	
	IF IS_CAR_UPSIDEDOWN cuban_carry_car
	AND IS_CAR_STOPPED cuban_carry_car
		flag_cuban_carry_car_upsidedown = 1
	ENDIF

	IF NOT IS_PLAYER_IN_CAR player1 cuban_carry_car
	AND flag_player_not_in_cuban_carry_car = 0
	AND flag_cuban_carry_car_upsidedown = 0
		PRINT_NOW ( IN_VEH ) 5000 1 //"Get back into the vehicle and get on with the mission!"
		REMOVE_BLIP drop_off_point1
		ADD_BLIP_FOR_CAR cuban_carry_car radar_blip_cuban_carry_car
		flag_player_not_in_cuban_carry_car = 1 
	ENDIF

	IF IS_PLAYER_IN_CAR player1 cuban_carry_car
	AND flag_player_not_in_cuban_carry_car = 1
		REMOVE_BLIP radar_blip_cuban_carry_car
		ADD_BLIP_FOR_COORD -1072.6 70.3 11.2 drop_off_point1
		CLEAR_PRINTS
		flag_player_not_in_cuban_carry_car = 0
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
 
///////////////////////////////////////////////////////////////////////////////////////////
first_wave_haitian_attacking_rules:////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD haitian_defender1 
	IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender1 -1115.8 67.7 1.0 1.0 FALSE
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender1 FALSE
  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender1 -1115.8 67.7
		hait_heading1 = 0
  	ELSE
		IF hait_heading1 = 0
			IF IS_CHAR_OBJECTIVE_PASSED haitian_defender1
				SET_CHAR_HEADING haitian_defender1 272.8
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender1 TRUE
				hait_heading1 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD haitian_defender2 
	IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender2 -1115.8 69.7 1.0 1.0 FALSE
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender2 FALSE
  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender2 -1115.8 69.7
		hait_heading2 = 0
  	ELSE
		IF hait_heading2 = 0
			IF IS_CHAR_OBJECTIVE_PASSED haitian_defender2 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender2 TRUE
				SET_CHAR_HEADING haitian_defender2 257.4
				hait_heading2 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender3 
	IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender3 -1115.8 71.7 1.0 1.0 FALSE
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender3 FALSE
  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender3 -1115.8 71.7
		hait_heading3 = 0
  	ELSE
		IF hait_heading3 = 0
			IF IS_CHAR_OBJECTIVE_PASSED haitian_defender3 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender3 TRUE
				SET_CHAR_HEADING haitian_defender3 285.1
				hait_heading3 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender4 
	IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender4 -1128.9 67.6 1.0 1.0 FALSE
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender4 FALSE
  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender4 -1128.9 67.6
		hait_heading4 = 0
  	ELSE
		IF hait_heading4 = 0
			IF IS_CHAR_OBJECTIVE_PASSED haitian_defender4 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender4 TRUE
				SET_CHAR_HEADING haitian_defender4 257.5
				hait_heading4 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF NOT IS_CHAR_DEAD haitian_defender5 
	IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender5 -1128.9 74.1 1.0 1.0 FALSE
		//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender5 FALSE
  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender5 -1128.9 74.1
		hait_heading5 = 0
  	ELSE
		IF hait_heading5 = 0
			IF IS_CHAR_OBJECTIVE_PASSED haitian_defender5 
				SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender5 TRUE
				SET_CHAR_HEADING haitian_defender5 274.5
				hait_heading5 = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
second_wave_haitian_attacking_rules:///////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF IS_PLAYER_IN_AREA_3D player1 -1118.5 92.1 5.8 -1179.9 53.3 15.0 FALSE
	IF NOT IS_CHAR_DEAD haitian_defender1 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender1 -1138.1 68.6 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender1 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender1 -1138.1 68.6
			hait_heading1 = 0
	  	ELSE
			IF hait_heading1 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender1 
					SET_CHAR_HEADING haitian_defender1 272.8
					hait_heading1 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender2 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender2 -1138.1 72.9 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender2 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender2 -1138.1 72.9
			hait_heading2 = 0
	  	ELSE
			IF hait_heading2 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender2 
					SET_CHAR_HEADING haitian_defender2 257.4
					hait_heading2 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender3 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender3 -1158.3 68.9 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender3 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender3 -1158.3 68.9
			hait_heading3 = 0
	  	ELSE
			IF hait_heading3 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender3 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender3 TRUE
					SET_CHAR_HEADING haitian_defender3 285.1
					hait_heading3 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF NOT IS_CHAR_DEAD haitian_defender4 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender4 -1158.4 72.5 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender4 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender4 -1158.4 72.5
			hait_heading4 = 0
	  	ELSE
			IF hait_heading4 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender4 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender4 TRUE
					SET_CHAR_HEADING haitian_defender4 257.5
					hait_heading4 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender5 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender5 -1161.2 71.4 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender5 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender5 -1161.2 71.4
			hait_heading5 = 0
	  	ELSE
			IF hait_heading5 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender5 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender5 TRUE
					SET_CHAR_HEADING haitian_defender5 274.5
					hait_heading5 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

ELSE

	IF NOT IS_CHAR_DEAD haitian_defender1 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender1 -1137.8 66.7 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender1 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender1 -1137.8 66.7
			hait_heading1 = 0
	  	ELSE
			IF hait_heading1 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender1 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender1 TRUE
					SET_CHAR_HEADING haitian_defender1 5.2
					hait_heading1 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender2 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender2 -1138.2 75.5 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender2 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender2 -1138.2 75.5
			hait_heading2 = 0
	  	ELSE
			IF hait_heading2 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender2 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender2 TRUE
					SET_CHAR_HEADING haitian_defender2 175.4
					hait_heading2 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender3 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender3 -1158.2 67.2 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender3 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender3 -1158.2 67.2
			hait_heading3 = 0
	  	ELSE
			IF hait_heading3 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender3 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender3 TRUE
					SET_CHAR_HEADING haitian_defender3 5.2
					hait_heading3 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender4 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender4 -1158.1 75.6 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender4 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender4 -1158.1 75.6
			hait_heading4 = 0
	  	ELSE
			IF hait_heading4 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender4 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender4 TRUE
					SET_CHAR_HEADING haitian_defender4 175.4
					hait_heading4 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_defender5 
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_defender5 -1163.5 75.8 1.0 1.0 FALSE
			//SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender5 FALSE
	  		SET_CHAR_OBJ_RUN_TO_COORD haitian_defender5 -1163.5 75.8
			hait_heading5 = 0
	  	ELSE
			IF hait_heading5 = 0
				IF IS_CHAR_OBJECTIVE_PASSED haitian_defender5 
					SET_CHAR_STOP_SHOOT_DONT_SEEK_ENTITY	haitian_defender5 TRUE
					SET_CHAR_HEADING haitian_defender5 226.7
					hait_heading5 = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
player_killing_cubans://///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GET_NUM_OF_MODELS_KILLED_BY_PLAYER CBa cub2_cubans_killed1
GET_NUM_OF_MODELS_KILLED_BY_PLAYER CBb cub2_cubans_killed2
body_count_cub2 = cub2_cubans_killed1 + cub2_cubans_killed2
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
nutters:///////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CHAR_DEAD cuban_pickup1
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup1 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_pickup1 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_pickup2
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup2 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_pickup2 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_pickup3
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup3 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_pickup3 player1
ENDIF 
IF NOT IS_CHAR_DEAD cuban_pickup4
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup4 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_pickup4 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_pickup5
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup5 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_pickup5 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_pickup6
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_pickup6 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_pickup6 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_attacker1
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_attacker1 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_attacker1 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_attacker2
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_attacker2 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_attacker2 player1
ENDIF   
IF NOT IS_CHAR_DEAD cuban_attacker3
	MARK_CHAR_AS_NO_LONGER_NEEDED cuban_attacker3 
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cuban_attacker3 player1
ENDIF   
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
}



