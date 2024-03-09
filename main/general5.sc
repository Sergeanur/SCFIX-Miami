MISSION_START
////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////// General Mission 5 //////////////////////////////////// 
///////////////////////////////// Defend the General's Yacht ///////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
///// The General has had enough of the heat and wants out of Miami.  When the player    ///
///// arrives at the contact point the General will start moving his yacht out to sea.   ///
///// The <Shining Path Rebels?> chose this moment to launch an all out attack on the 	 ///
///// yacht.  The player1 must stay up on deck with an M-16 defending the boat from the  ///
///// attackers.  They'll be closing in in boats, helicopters, following on land in cars ///
///// On foot, jumping from bridges as the yacht passes underneath.  The player1 must 	 ///
///// hold them off till the General is far enough out to sea to make a clean getaway.   ///
///// Then the player1 will get back to land using the General's personal launch.		 ///
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
GOSUB mission_start_general5

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_general5_failed
ENDIF

GOSUB mission_cleanup_general5

MISSION_END
////////////////////////////////////////////////////////////////////////////////////////////
//VARS FOR MISSION//////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

//PEDS OBJECTS CARS ETC
VAR_INT car01_goon1 car01_goon2	car01_goon3 car01_goon4	boat01 boat02 boat03 car01 
VAR_INT	car02_goon1 car02_goon2	car02_goon3 car02_goon4	car02
VAR_INT colonels_launch colonel colonel_goon1 colonel_goon2 colonel_goon3 gosub_heli killer_chopper	killer_chopper_pilot
VAR_INT heli1 temp_yacht goon
VAR_INT barricade_boat01 barricade_boat02 barricade_boat03 barricade_boat04 barricade_boat05
VAR_INT barricade_boat06 barricade_boat07 barricade_boat08 barricade_boat09
VAR_INT boarder_1 boarder_2	boarder_3 boarder_4
VAR_INT heli1_pilot heli1_passenger1 heli1_passenger2 heli1_passenger3
VAR_INT barricade_boat01_dr barricade_boat01_sh barricade_boat02_dr barricade_boat02_sh 
VAR_INT barricade_boat03_sh barricade_boat05_dr barricade_boat05_sh barricade_boat06_sh1 
VAR_INT barricade_boat06_sh2 barricade_boat06_sh3 barricade_boat03_dr barricade_boat09_dr
VAR_INT heli2 heli2_pilot heli2_passenger1 heli2_passenger2	heli2_passenger3
VAR_INT health_on_yacht ruger_on_yacht colonel_goon4
VAR_INT gosub_boat gosub_boat_dr gosub_boat_sh boat_shooter_ped	sailor heli_passenger jetty_stuff_dude
//COUNTERS FLAGS TIMERS ETC
VAR_INT heli_dropoff_timer hunter_timer	given_player_smg_flag
VAR_INT initial_yacht_speedup killer_chopper_created weapon_type ammo model
VAR_INT gosub_heli_fly_to_counter gosub_heli_just_come_from random_flight
VAR_INT killer_chopper_fly_to_counter killer_chopper_just_come_from 
VAR_INT car01_counter car01_timer car01_goon1_counter car01_goon2_counter car01_goon3_counter car01_goon4_counter
VAR_INT car02_counter car02_timer car02_goon1_counter car02_goon2_counter car02_goon3_counter car02_goon4_counter
VAR_INT heli1_counter heli2_counter boat01_timer stop_for_barricade barricade_boat09_flag
VAR_INT first_boats_dead boat01_dead boat02_dead boat03_dead first_boats_timer got_ammo_message got_health_message
VAR_INT boarder_1_flag boarder_2_flag gosub_boat_flag jetty_stuff_dude_flag
VAR_INT boarder_3_flag boarder_4_flag cs_time_limit	heli1_timer	heli_audio_counter
VAR_INT barricade_boat01_flag barricade_boat02_flag barricade_boat05_flag created_bridge_scene
VAR_INT played_bridge_dialogue played_this_dialogue played_this_dialogue2 played_this_dialogue3	
VAR_INT clear_route_flag played_audio_7_dialogue played_audio_9_dialogue played_audio_15_dialogue
VAR_INT got_hunter_message cutscene_timer cutscene_counter barricade_boat03_flag next_text text_timer
//VAR_INT heli1_death_counter heli2_death_counter killer_heli_death_counter
//COORD MATHS

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE	stuff
//VAR_INT cs_dude1 cs_dude2 game_timer temp_int 
//VAR_INT is_audio_in_use audio_1_flag audio_2_flag audio_3_flag audio_4_flag 
//VAR_INT audio_7_flag audio_9_flag audio_10_flag audio_11_flag audio_12_flag audio_13_flag
//VAR_INT audio_14_flag audio_15_flag audio_16_flag
//VAR_INT audio_1_timeout audio_2_timeout audio_3_timeout audio_4_timeout
//VAR_INT audio_7_timeout audio_9_timeout audio_10_timeout audio_11_timeout audio_12_timeout audio_13_timeout
//VAR_INT audio_14_timeout audio_15_timeout audio_16_timeout
//VAR_FLOAT heading_diff heading

////////////////////////////////////////////////////////////////////////////////////////////
mission_start_general5://///////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

flag_player_on_mission = 1

SCRIPT_NAME COL_5

REGISTER_MISSION_GIVEN

WAIT 0
{
VAR_FLOAT fly_to_x fly_to_y fly_to_z old_fly_to_z boat01_heading boat02_heading boat03_heading
VAR_FLOAT locate_size the_yacht_speed the_yacht_heading
VAR_FLOAT the_yacht_x_start the_yacht_y_start the_yacht_z_start

LOAD_MISSION_TEXT GENERA5
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -163.0 -1439.4 9.0 201.5

the_yacht_speed = 0.0

killer_chopper_fly_to_counter = 0
killer_chopper_just_come_from = 0

initial_yacht_speedup = 0
killer_chopper_created = 0
gosub_heli_fly_to_counter = 0
gosub_heli_just_come_from = 0
random_flight = 0
car01_counter = 0
car01_goon1_counter = 0
car01_goon2_counter = 0
car01_goon3_counter = 0
car01_goon4_counter = 0
car02_counter = 0
car02_goon1_counter = 0
car02_goon2_counter = 0
car02_goon3_counter = 0
car02_goon4_counter = 0
heli1_counter = -2

is_audio_in_use = 0
audio_1_flag = 0
audio_2_flag = 0
audio_3_flag = 0
audio_4_flag = 0
audio_7_flag = 0
audio_9_flag = 0
audio_10_flag = 0
audio_11_flag = 0
audio_12_flag = 0
audio_13_flag = 0
audio_14_flag = 0
audio_15_flag = 0
audio_16_flag = 0
audio_1_timeout = 0
audio_2_timeout = 0
audio_3_timeout = 0
audio_4_timeout = 0
audio_7_timeout = 0
audio_9_timeout = 0
audio_10_timeout = 0
audio_11_timeout = 0
audio_12_timeout = 0
audio_13_timeout = 0
audio_14_timeout = 0
audio_15_timeout = 0
audio_16_timeout = 0

first_boats_dead = 0
boat01_dead = 0
boat02_dead = 0
boat03_dead = 0
first_boats_timer = 0
stop_for_barricade = 0
barricade_boat01_flag = -1
barricade_boat02_flag = -1
barricade_boat03_flag = -1
barricade_boat05_flag = -1
barricade_boat09_flag = -1

boarder_1_flag = 0
boarder_2_flag = 0
boarder_3_flag = 0
boarder_4_flag = 0

played_bridge_dialogue = 0
played_this_dialogue = 0
played_this_dialogue2 = 0
played_this_dialogue3 = 0
clear_route_flag = 0
played_audio_7_dialogue = 0
played_audio_9_dialogue = 0
played_audio_15_dialogue = 0
got_hunter_message = 0

cutscene_timer = 0
cutscene_counter = 0

created_bridge_scene = 0

next_text = 0
text_timer = 0

got_ammo_message = 0
got_health_message = 0

old_fly_to_z = 10.0
hunter_timer = 0
jetty_stuff_dude_flag = 0
heli_audio_counter = 0
given_player_smg_flag = 0

//heli1_death_counter = 0
//heli2_death_counter = 0
//killer_heli_death_counter = 0

heli2_counter = -1
GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z

the_yacht_x_start = the_yacht_x
the_yacht_y_start = the_yacht_y
the_yacht_z_start = the_yacht_z

SET_THREAT_REACTION_RANGE_MULTIPLIER 6.0
SET_TIME_OF_DAY 06 00
FORCE_WEATHER_NOW WEATHER_SUNNY
SWITCH_CAR_GENERATOR gen_car20 0

////////////////////////////////////////////////////////////////////////////////////////////
//CUTSCENE START////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cscolo
LOAD_SPECIAL_CHARACTER 3 cgona
LOAD_SPECIAL_CHARACTER 4 cgonb

REQUEST_MODEL yt_main_body
REQUEST_MODEL yt_main_body2
REQUEST_MODEL yt_doors14
REQUEST_MODEL yt_tmp_boat
REQUEST_MODEL lodmain_body
REQUEST_MODEL big_poly_tings
REQUEST_MODEL yt_gangplnk_tmp

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED yt_main_body
OR NOT HAS_MODEL_LOADED yt_main_body2
OR NOT HAS_MODEL_LOADED yt_doors14
OR NOT HAS_MODEL_LOADED yt_tmp_boat
OR NOT HAS_MODEL_LOADED lodmain_body
OR NOT HAS_MODEL_LOADED big_poly_tings
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED yt_gangplnk_tmp
	WAIT 0
ENDWHILE

SET_NEAR_CLIP 0.1
LOAD_CUTSCENE COL_5A

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
the_yacht_x = the_yacht_x + 0.003
the_yacht_y = the_yacht_y - 1.381
the_yacht_z = the_yacht_z + 3.149
SET_CUTSCENE_OFFSET the_yacht_x the_yacht_y the_yacht_z
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken cscolo

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_dude1
SET_CUTSCENE_ANIM cs_dude1 cgona

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_dude2
SET_CUTSCENE_ANIM cs_dude2 cgonb

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

cs_time_limit = 791
GOSUB wait_for_cs_time
PRINT_NOW COL5A_1 10000 1 //Circumstances force a hasty departure amigo.
 
cs_time_limit = 3435
GOSUB wait_for_cs_time
PRINT_NOW COL5A_2 10000 1 //Whats the problem?
 
cs_time_limit = 4140
GOSUB wait_for_cs_time
PRINT_NOW COL5A_3 10000 1 //Uuh, The French want their missile technology back and after that last incident,
 
cs_time_limit = 7919
GOSUB wait_for_cs_time
PRINT_NOW COL5A_4 10000 1 //I feel it is time to find safer harbours.
 
cs_time_limit = 9945
GOSUB wait_for_cs_time
PRINT_NOW COL5A_5 10000 1 //Wouldn't it be safer to fly?
 
cs_time_limit = 11371
GOSUB wait_for_cs_time
PRINT_NOW COL5A_6 10000 1 //I'd be dead before I reached check-in. Besides, I need to get my merchandise out of the country.
 
cs_time_limit = 16000
GOSUB wait_for_cs_time
PRINT_NOW COL5A_7 10000 1 //Need another gun?
 
cs_time_limit = 17365
GOSUB wait_for_cs_time
PRINT_NOW COL5A_8 10000 1 //You, my friend, are worth ten guns...hahaha
 
cs_time_limit = 21837//20672
GOSUB wait_for_cs_time
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

MARK_MODEL_AS_NO_LONGER_NEEDED yt_main_body
MARK_MODEL_AS_NO_LONGER_NEEDED yt_main_body2
MARK_MODEL_AS_NO_LONGER_NEEDED yt_doors14
MARK_MODEL_AS_NO_LONGER_NEEDED yt_tmp_boat
MARK_MODEL_AS_NO_LONGER_NEEDED lodmain_body
MARK_MODEL_AS_NO_LONGER_NEEDED big_poly_tings
MARK_MODEL_AS_NO_LONGER_NEEDED yt_gangplnk_tmp

////////////////////////////////////////////////////////////////////////////////////////////
//CUTSCENE END//////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

SET_PLAYER_MOOD player1 PLAYER_MOOD_WISECRACKING 60000

//IF IS_BUTTON_PRESSED PAD2 DPADUP//DEBUG!!!!!!!!!!
//	GOTO col5b_cutscene			//DEBUG!!!!!!!!!!
//ENDIF							//DEBUG!!!!!!!!!!

REQUEST_MODEL HUNTER
REQUEST_MODEL DINGHY
REQUEST_MODEL SPEEDER
REQUEST_MODEL RIO
REQUEST_MODEL WASHING
REQUEST_MODEL MAVERICK
REQUEST_MODEL MARQUIS
REQUEST_MODEL TROPIC
REQUEST_MODEL RUGER
REQUEST_MODEL KATANA
REQUEST_MODEL HMOST
REQUEST_MODEL UZI
REQUEST_MODEL COLT45
LOAD_SPECIAL_CHARACTER 1 igcolon
LOAD_SPECIAL_CHARACTER 2 cgona
//LOAD_SPECIAL_CHARACTER 3 fsfa

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED HUNTER
OR NOT HAS_MODEL_LOADED DINGHY
OR NOT HAS_MODEL_LOADED SPEEDER
OR NOT HAS_MODEL_LOADED RIO
OR NOT HAS_MODEL_LOADED WASHING
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED MAVERICK
OR NOT HAS_MODEL_LOADED	MARQUIS
OR NOT HAS_MODEL_LOADED	TROPIC
OR NOT HAS_MODEL_LOADED	KATANA
OR NOT HAS_MODEL_LOADED RUGER
	WAIT 0
ENDWHILE

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED	HMOST
OR NOT HAS_MODEL_LOADED	UZI
OR NOT HAS_MODEL_LOADED	COLT45
	WAIT 0
ENDWHILE

GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_KATANA 1

ADD_ARMOUR_TO_PLAYER player1 200

GET_PLAYER_HEALTH player1 temp_int
IF temp_int < 100
	SET_PLAYER_HEALTH player1 100
ENDIF

DELETE_OBJECT pier_closed

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

DELETE_OBJECT the_yacht3
DELETE_OBJECT the_yacht7
DELETE_OBJECT the_yacht8

GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS the_yacht -0.277 -16.662 3.152 the_yacht_x the_yacht_y the_yacht_z
SET_PLAYER_COORDINATES player1 the_yacht_x the_yacht_y the_yacht_z
SET_PLAYER_HEADING player1 0.0
SET_CAMERA_BEHIND_PLAYER

//colonel 4.288 -5.171 4.029 //right side front
//goon1 4.288 -11.674 4.029	//right side back
//goon2 -4.2 -9.822 4.029 //left side
//goon3 -1.931 -4.427 4.029	//by middle stairs
//goon4 -3.043 -13.026 4.029 //by back left stairs
//player1 -0.277 -16.662 3.152 //back middle

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 the_yacht_x the_yacht_y the_yacht_z colonel
sailor = colonel
GOSUB setup_sailors
SET_CHAR_SUFFERS_CRITICAL_HITS colonel FALSE
SET_CHAR_PROOFS colonel FALSE FALSE TRUE TRUE FALSE
SET_CHAR_ACCURACY colonel 40
SET_CHAR_HEALTH	colonel 500
ATTACH_CHAR_TO_OBJECT colonel the_yacht -2.5 -1.996 4.179 0 360.0 WEAPONTYPE_RUGER//4.288 -5.171 4.179 0 360.0 WEAPONTYPE_RUGER

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL02 the_yacht_x the_yacht_y the_yacht_z colonel_goon1
sailor = colonel_goon1
GOSUB setup_sailors
ATTACH_CHAR_TO_OBJECT colonel_goon1 the_yacht 4.288 -11.674 4.179 0 360.0 WEAPONTYPE_RUGER

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL02 the_yacht_x the_yacht_y the_yacht_z colonel_goon2
sailor = colonel_goon2
GOSUB setup_sailors
ATTACH_CHAR_TO_OBJECT colonel_goon2 the_yacht -4.215 -8.161 4.179 0 360.0 WEAPONTYPE_RUGER

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL02 the_yacht_x the_yacht_y the_yacht_z colonel_goon3
sailor = colonel_goon3
GOSUB setup_sailors
ATTACH_CHAR_TO_OBJECT colonel_goon3 the_yacht 4.267 -4.745 4.179 0 360.0 WEAPONTYPE_RUGER

CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL02 the_yacht_x the_yacht_y the_yacht_z colonel_goon4
sailor = colonel_goon4
GOSUB setup_sailors
ATTACH_CHAR_TO_OBJECT colonel_goon4 the_yacht -4.225 -12.46 4.179 0 360.0 WEAPONTYPE_RUGER

SET_OBJECT_PATH_SPEED the_path_spline 0.0

GOTO gen5_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	CREATE_CAR HUNTER 36.0195 -447.5407 15.0170	heli1
	CREATE_CAR HUNTER 36.0195 -447.5407 15.0170	killer_chopper
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 killer_chopper_pilot
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car01_goon1
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car01_goon2
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car01_goon3
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car01_goon4
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car02_goon1
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car02_goon2
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car02_goon3
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 car02_goon4
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 boarder_1
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 boarder_2
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 boarder_3
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 boarder_4
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 heli1_passenger1
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 heli1_passenger2
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 heli1_passenger3
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 heli2_passenger1
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 heli2_passenger2
	CREATE_CHAR PEDTYPE_GANG_STREET HMOST 36.0195 -447.5407 15.0170 heli2_passenger3
   	CREATE_CAR WASHING -238.2693 -1361.3296 7.0786 car02
	CREATE_CAR WASHING -238.2693 -1361.3296 7.0786 car01

gen5_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check

//Boats at jetty
CREATE_CAR MARQUIS -327.2818 -1207.3 6.0000 boat01
SET_CAR_HEADING boat01 90.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER boat01 TRUE
CREATE_CAR SPEEDER -332.1327 -1221.6234 6.0000 boat02
SET_CAR_HEADING boat02 90.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER boat02 TRUE

CREATE_CAR RIO -332.6164 -1233.0079 6.0000 boat03//catamaran
SET_CAR_HEADING boat03 90.0
SET_CAR_ONLY_DAMAGED_BY_PLAYER boat03 TRUE

GET_GAME_TIMER game_timer
car01_timer	= game_timer + 12000

WAIT 0

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SWITCH_WIDESCREEN ON
SET_ALL_CARS_CAN_BE_DAMAGED FALSE
SET_FIXED_CAMERA_POSITION -410.4125 -1320.8638 12.1604 0.0 0.0 0.0//SHOT OF YACHT PULLING AWAY
POINT_CAMERA_AT_POINT -409.6047 -1320.2751 12.1915 JUMP_CUT
cutscene_timer = game_timer + 6100

mission_general5_loop:

/*

IF cutscene_counter >= 0
    IF cutscene_counter < 5
        IF IS_BUTTON_PRESSED PAD1 CROSS
            //PRINT_NOW skip 500 1
            SET_FIXED_CAMERA_POSITION -351.4564 -1232.3345 10.4296 0.0 0.0 0.0//3RD SHOT OF GUYS RUNNING UP JETTY
	        POINT_CAMERA_AT_POINT -350.6927 -1231.6893 10.4065 JUMP_CUT
	        cutscene_timer = game_timer
	        cutscene_counter = 5
        ENDIF
    ENDIF
ENDIF

*/


WAIT 0

///////////////////////////////////////////////////////////////////////////////////////////
// MISSION STUFF //////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GET_GAME_TIMER game_timer
GET_PLAYER_COORDINATES player1 player_x	player_y player_z
ALTER_WANTED_LEVEL player1 0

IF IS_PLAYER_IN_ANY_CAR	player1
	IF NOT IS_PLAYER_IN_ANY_BOAT player1
		IF NOT IS_CHAR_DEAD colonel
			EXPLODE_CHAR_HEAD colonel
		ENDIF
		PRINT_NOW COL5_B3 5000 1 //~r~The Colonel is dead!
		SET_FADING_COLOUR 225 225 225
		DO_FADE 1000 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		GOTO mission_general5_failed
	ENDIF
ENDIF

IF created_bridge_scene = 0
	GET_CHAR_WEAPON_IN_SLOT scplayer 7 weapon_type ammo MODEL
	IF ammo < 1
		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_RUGER 180
	ENDIF
ENDIF

IF given_player_smg_flag = 0
	GET_CHAR_WEAPON_IN_SLOT scplayer 6 weapon_type ammo model
	IF ammo < 1
		GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_UZI 80
		given_player_smg_flag = 1
	ENDIF
ENDIF


IF stop_for_barricade = 2
	IF got_ammo_message = 0
		GET_CHAR_WEAPON_IN_SLOT scplayer 7 weapon_type ammo model
		IF ammo < 1
			PRINT_NOW COL5_B6 5000 1//You have run out of ammo, get more from the stairs on the top deck.
			text_timer = game_timer + 4000
			got_ammo_message = 1
		ENDIF
	ENDIF

	IF got_health_message = 0
		IF NOT IS_PLAYER_HEALTH_GREATER	PLAYER1 40
			PRINT_NOW COL5_B7 5000 1//You are running low on health, get more from the stairs on the top deck.
			text_timer = game_timer + 4000
			got_health_message = 1
		ENDIF
	ENDIF
ENDIF

IF cutscene_counter = 0
	IF game_timer > cutscene_timer
		SET_FIXED_CAMERA_POSITION -381.3522 -1363.9183 18.9859 0.0 0.0 0.0//2ND SHOT OF YACHT PULLING AWAY
		POINT_CAMERA_AT_POINT -381.1456 -1362.9531 18.8254 JUMP_CUT
		cutscene_counter = 1
	ENDIF
ENDIF

IF cutscene_counter = 1
	IF car01_counter > 0
		LOAD_SCENE -264.5628 -1231.9009 10.8113
		SET_FIXED_CAMERA_POSITION -264.5628 -1231.9009 10.8113 0.0 0.0 0.0//SHOT OF CARS SPEEDING UP
		IF NOT IS_CAR_DEAD car01
			POINT_CAMERA_AT_CAR	car01 FIXED JUMP_CUT
		ENDIF
		cutscene_timer = game_timer + 5500
		cutscene_counter = 2
	ENDIF
ENDIF

IF cutscene_counter = 2
	IF game_timer > cutscene_timer
		SET_FIXED_CAMERA_POSITION -233.0363 -1221.2832 9.3205 0.0 0.0 0.0//SHOT OF GUYS RUNNING UP JETTY
		POINT_CAMERA_AT_POINT -233.9623 -1220.9071 9.3547 JUMP_CUT
		cutscene_timer = game_timer + 4000
		cutscene_counter = 3
	ENDIF
ENDIF

IF cutscene_counter = 3
	IF game_timer > cutscene_timer
		SET_FIXED_CAMERA_POSITION -267.5756 -1219.9111 10.2994 0.0 0.0 0.0//3RD SHOT OF GUYS RUNNING UP JETTY
		POINT_CAMERA_AT_POINT -268.5739 -1219.9662 10.2809 JUMP_CUT
		cutscene_timer = game_timer + 4000
		cutscene_counter = 4
	ENDIF
ENDIF

IF cutscene_counter = 4
	IF game_timer > cutscene_timer
		SET_FIXED_CAMERA_POSITION -351.4564 -1232.3345 10.4296 0.0 0.0 0.0//3RD SHOT OF GUYS RUNNING UP JETTY
		POINT_CAMERA_AT_POINT -350.6927 -1231.6893 10.4065 JUMP_CUT
		cutscene_timer = game_timer + 4000
		cutscene_counter = 5
	ENDIF
ENDIF

IF cutscene_counter = 5
	
	IF game_timer > cutscene_timer
		GET_OBJECT_HEADING the_yacht the_yacht_heading
		SET_PLAYER_HEADING player1 the_yacht_heading
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 FALSE
		SWITCH_WIDESCREEN OFF
		SET_ALL_CARS_CAN_BE_DAMAGED TRUE
		SET_CAMERA_BEHIND_PLAYER
		RESTORE_CAMERA_JUMPCUT
		IF next_text = 1
			PRINT_NOW COL5_B2 5000 1//~g~Get up front and clear the route for the Colonel's yacht.
			text_timer = game_timer + 4000
			++ next_text
		ENDIF
		IF next_text = 0
			PRINT_NOW COL5_B1 5000 1//~g~Defend the Colonel and his yacht at all costs.
			text_timer = game_timer + 4000
			++ next_text
		ENDIF
		cutscene_counter = 6
	ENDIF
ENDIF
IF cutscene_counter = 10
	IF game_timer > cutscene_timer
		SET_FIXED_CAMERA_POSITION 223.1382 976.4195 11.1547 0.0 0.0 0.0//215.2970 952.7535 9.5638 0.0 0.0 0.0//THRU BARRICADE
		POINT_CAMERA_AT_POINT 222.8153 975.4747 11.2115  JUMP_CUT
		LOAD_SCENE 222.8153 975.4747 11.2115
		cutscene_timer = game_timer + 4000
		cutscene_counter = 5
	ENDIF
ENDIF

IF cutscene_counter = 15
	IF game_timer > cutscene_timer
		SET_FIXED_CAMERA_POSITION 203.4923 871.4227 23.2555 0.0 0.0 0.0//2ND SHOT BEFORE FINAL CS PLAYS
		POINT_CAMERA_AT_POINT 203.3397 872.3857 23.0336 JUMP_CUT
		cutscene_timer = game_timer + 4000
		cutscene_counter = 16
	ENDIF
ENDIF

IF killer_chopper_created = 2
	IF NOT GET_FADING_STATUS
		SET_FIXED_CAMERA_POSITION 75.9000 748.5027 10.4895 0.0 0.0 0.0
		IF NOT IS_CAR_DEAD killer_chopper
			POINT_CAMERA_AT_CAR	killer_chopper FIXED JUMP_CUT
		ENDIF
		SET_FADING_COLOUR 0 0 1
		DO_FADE 500 FADE_IN
		CLEAR_AREA 189.6395 888.1066 12.6813 60.0 TRUE
		cutscene_timer = game_timer + 4000
		cutscene_counter = 5
		killer_chopper_created = 3
	ENDIF
ENDIF

IF cutscene_counter = 16
	IF game_timer > cutscene_timer
		SET_FADING_COLOUR 0 0 1
		DO_FADE 1500 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		FREEZE_CHAR_POSITION scplayer TRUE
		SET_OBJECT_PATH_POSITION the_path_spline 3250.0
		SET_OBJECT_PATH_SPEED the_path_spline 0.0
		RESTORE_CAMERA_JUMPCUT
		WAIT 0
		WAIT 0
		GOTO col5b_cutscene
	ENDIF
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
// YACHT STUFF ////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
GET_OBJECT_HEADING the_yacht the_yacht_heading

IF initial_yacht_speedup = 0
	IF the_yacht_speed < 5.0
		the_yacht_speed +=@ 0.01
	ELSE
		the_yacht_speed = 5.0
		initial_yacht_speedup = 1
	ENDIF
	SET_OBJECT_PATH_SPEED the_path_spline the_yacht_speed
ENDIF

IF first_boats_dead = 0
	IF LOCATE_OBJECT_2D the_yacht -277.999 614.19 25.0 25.0 0
		IF created_bridge_scene = 0
			created_bridge_scene = 1
		ENDIF
		first_boats_dead = 3
	ELSE
		IF boat01_dead = 1
		AND boat02_dead = 1
		AND	boat03_dead = 1
			first_boats_timer = game_timer + 8000
			first_boats_dead = 1
		ENDIF
	ENDIF
ENDIF

IF created_bridge_scene = 1
	MARK_CAR_AS_NO_LONGER_NEEDED car01
	MARK_CAR_AS_NO_LONGER_NEEDED car02
	MARK_CAR_AS_NO_LONGER_NEEDED boat01
	MARK_CAR_AS_NO_LONGER_NEEDED boat02
	MARK_CAR_AS_NO_LONGER_NEEDED boat03
	MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon1
	MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon2
	MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon3
	MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon4
	MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon1
	MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon2
	MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon3
	MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon4

	CREATE_CAR DINGHY 246.161 934.99 6.0 barricade_boat01
	SET_CAR_HEADING barricade_boat01 165.0

	CREATE_CHAR_INSIDE_CAR barricade_boat01 PEDTYPE_GANG_STREET HMOST barricade_boat01_dr

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat01_sh
	boat_shooter_ped = barricade_boat01_sh
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat01_sh barricade_boat01 0.0742 -0.8961 1.0623 FACING_BACK 360.0 WEAPONTYPE_UZI


	CREATE_CAR DINGHY 252.074 929.9 6.0 barricade_boat02
	SET_CAR_HEADING barricade_boat02 165.0

	CREATE_CHAR_INSIDE_CAR barricade_boat02 PEDTYPE_GANG_STREET HMOST barricade_boat02_dr

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat02_sh
	boat_shooter_ped = barricade_boat02_sh
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat02_sh barricade_boat02 0.0742 -0.8961 1.0623 FACING_BACK 360.0 WEAPONTYPE_UZI


	CREATE_CAR RIO 229.653 929.049 6.0 barricade_boat03
	SET_CAR_HEADING barricade_boat03 124.5
	CREATE_CHAR_INSIDE_CAR barricade_boat03 PEDTYPE_GANG_STREET HMOST barricade_boat03_dr

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat03_sh
	boat_shooter_ped = barricade_boat03_sh
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat03_sh barricade_boat03 0.0 4.0 1.5 0 360.0 WEAPONTYPE_UZI


	CREATE_CAR TROPIC 217.382 940.656 6.0 barricade_boat04
	SET_CAR_HEADING barricade_boat04 -136.5


	CREATE_CAR DINGHY 210.127 932.185 6.0 barricade_boat05
	SET_CAR_HEADING barricade_boat05 166.5

	CREATE_CHAR_INSIDE_CAR barricade_boat05 PEDTYPE_GANG_STREET HMOST barricade_boat05_dr

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat05_sh
	boat_shooter_ped = barricade_boat05_sh
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat05_sh barricade_boat05 0.0742 -0.8961 1.0623 FACING_BACK 360.0 WEAPONTYPE_UZI


	CREATE_CAR MARQUIS 201.639 942.166 6.0 barricade_boat06
	SET_CAR_HEADING barricade_boat06 72.0

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat06_sh1
	boat_shooter_ped = barricade_boat06_sh1
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat06_sh1 barricade_boat06 0.0 -2.0 1.2 0 360.0 WEAPONTYPE_UZI

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat06_sh2
	boat_shooter_ped = barricade_boat06_sh2
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat06_sh2 barricade_boat06 0.0 6.0 2.65 0 360.0 WEAPONTYPE_UZI

	CREATE_CHAR	PEDTYPE_GANG_STREET HMOST 274.1312 969.9899 23.4139 barricade_boat06_sh3
	boat_shooter_ped = barricade_boat06_sh3
	GOSUB setup_boat_shooters
	ATTACH_CHAR_TO_CAR barricade_boat06_sh3 barricade_boat06 0.0 10.0 1.9 0 360.0 WEAPONTYPE_UZI

	CREATE_CAR TROPIC 187.631 953.41 6.0 barricade_boat07
	SET_CAR_HEADING barricade_boat07 -126.0


	CREATE_CAR MARQUIS 168.216 955.625 6.0 barricade_boat08
	SET_CAR_HEADING barricade_boat08 -106.5


	CREATE_CAR TROPIC 195.398 767.808 6.0 barricade_boat09
	SET_CAR_HEADING barricade_boat09 -7.5
	CREATE_CHAR_INSIDE_CAR barricade_boat09 PEDTYPE_GANG_STREET HMOST barricade_boat09_dr

	created_bridge_scene = 2
ENDIF

IF first_boats_dead = 1
	IF game_timer > first_boats_timer
		SET_FADING_COLOUR 0 0 1
		DO_FADE 1500 FADE_OUT
		first_boats_dead = 2
	ENDIF
ENDIF

IF first_boats_dead = 3
	IF created_bridge_scene = 0
		created_bridge_scene = 1
	ENDIF
	FREEZE_CHAR_POSITION scplayer FALSE
	GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS the_yacht -0.277 -16.662 3.152 the_yacht_x the_yacht_y the_yacht_z
	IF NOT IS_PLAYER_IN_ANY_CAR player1
		SET_PLAYER_COORDINATES player1 the_yacht_x the_yacht_y the_yacht_z
	ELSE
		WARP_PLAYER_FROM_CAR_TO_COORD player1 the_yacht_x the_yacht_y the_yacht_z
	ENDIF
	SET_PLAYER_HEADING player1 the_yacht_heading
	SET_CAMERA_BEHIND_PLAYER
	LOAD_SCENE the_yacht_x the_yacht_y the_yacht_z
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 TRUE
	SWITCH_WIDESCREEN ON
	SET_ALL_CARS_CAN_BE_DAMAGED FALSE
	SET_FIXED_CAMERA_POSITION 160.3909 797.2673 7.6438 0.0 0.0 0.0//SHOT OF YACHT INFRONT OF MAINLAND
	POINT_CAMERA_AT_POINT 159.4485 797.5592 7.8072 JUMP_CUT
	cutscene_timer = game_timer + 8500
	cutscene_counter = 10
	WAIT 500
	SET_FADING_COLOUR 0 0 1
	DO_FADE 1500 FADE_IN
	//SET_OBJECT_PATH_SPEED the_path_spline 0.0
	first_boats_dead = 4
ENDIF

IF first_boats_dead = 2
	IF NOT GET_FADING_STATUS
		SET_OBJECT_PATH_POSITION the_path_spline 2700.0
		FREEZE_CHAR_POSITION scplayer TRUE
		first_boats_dead = 3
	ENDIF
ENDIF

IF stop_for_barricade = 0
	IF LOCATE_OBJECT_2D the_yacht 194.999 891.496 25.0 25.0 0
		stop_for_barricade = 1
	ENDIF
ENDIF

IF stop_for_barricade = 1
	IF played_bridge_dialogue = 0
		IF audio_3_flag = 0
			audio_3_flag = 1
			audio_3_timeout = game_timer + 5000
		ENDIF
		played_bridge_dialogue = 1
	ENDIF
	IF NOT the_yacht_speed = 0.0
		IF the_yacht_speed < 0.0
			the_yacht_speed = 0.0
		ELSE
			the_yacht_speed -=@ 0.01
		ENDIF
		SET_OBJECT_PATH_SPEED the_path_spline the_yacht_speed
	ELSE
		stop_for_barricade = 2
		//PICKUPS ON YACHT
		//CREATE_PICKUP HEALTH PICKUP_ON_STREET 189.6395 888.1066 12.6813 health_on_yacht
		//CREATE_PICKUP_WITH_AMMO RUGER PICKUP_ON_STREET 120 190.6359 887.7457 12.6813 ruger_on_yacht
		CREATE_PICKUP HEALTH PICKUP_ON_STREET 189.4928 885.3084 13.7132 health_on_yacht
		CREATE_PICKUP_WITH_AMMO RUGER PICKUP_ON_STREET 120 190.5261 885.2347 13.7132 ruger_on_yacht
	ENDIF
ENDIF

IF stop_for_barricade = 2
	IF barricade_boat09_flag = -1
		barricade_boat09_flag = 1
	ENDIF
	
	IF heli1_counter = -2
		heli1_timer = game_timer + 45000
		heli1_counter = -1
	ENDIF

	IF barricade_boat01_flag = -1
		barricade_boat01_flag = 0
	ENDIF
	IF barricade_boat02_flag = -1
		barricade_boat02_flag = 0
	ENDIF
	IF barricade_boat03_flag = -1
		barricade_boat03_flag = 0
	ENDIF
	IF barricade_boat05_flag = -1
		barricade_boat05_flag = 0
	ENDIF
ENDIF

IF clear_route_flag = 0

	IF killer_chopper_created > 0
		IF IS_CAR_DEAD killer_chopper
			IF NOT IS_CAR_DEAD barricade_boat06
				PRINT_NOW COL5_B2 200 1//~g~Get up front and clear the route for the Colonel's yacht.
				//ADD_BLIP_FOR_CAR barricade_boat06 barricade_boat06_BLIP
			ELSE
				cutscene_timer = game_timer + 6000
				clear_route_flag = 1
			ENDIF
		ENDIF
	ENDIF
ENDIF
IF clear_route_flag = 1
	IF game_timer > cutscene_timer
		MARK_CHAR_AS_NO_LONGER_NEEDED boarder_1
		MARK_CHAR_AS_NO_LONGER_NEEDED boarder_2
		MARK_CHAR_AS_NO_LONGER_NEEDED boarder_3
		MARK_CHAR_AS_NO_LONGER_NEEDED boarder_4
		MARK_CHAR_AS_NO_LONGER_NEEDED heli1_passenger1
		MARK_CHAR_AS_NO_LONGER_NEEDED heli1_passenger2
		MARK_CHAR_AS_NO_LONGER_NEEDED heli1_passenger3
		MARK_CHAR_AS_NO_LONGER_NEEDED heli2_passenger1
		MARK_CHAR_AS_NO_LONGER_NEEDED heli2_passenger2
		MARK_CHAR_AS_NO_LONGER_NEEDED heli2_passenger3
		DELETE_CAR barricade_boat06
		SET_PLAYER_CONTROL player1 OFF
		SET_EVERYONE_IGNORE_PLAYER player1 TRUE
		SWITCH_WIDESCREEN ON
		SET_ALL_CARS_CAN_BE_DAMAGED FALSE
		SET_FIXED_CAMERA_POSITION 218.3319 1001.1410 10.0492 0.0 0.0 0.0//1ST SHOT BEFORE FINAL CS STARTS
		POINT_CAMERA_AT_POINT 218.0191 1000.1914 10.0691 JUMP_CUT
		SET_OBJECT_PATH_SPEED the_path_spline 5.0
		CLEAR_AREA the_yacht_x the_yacht_y the_yacht_z 100.0 TRUE
		REMOVE_PICKUP health_on_yacht
		REMOVE_PICKUP ruger_on_yacht
		cutscene_timer = game_timer + 4000
		cutscene_counter = 15
		clear_route_flag = 2
	ENDIF
ENDIF

IF clear_route_flag = 2
	IF game_timer > cutscene_timer
		IF the_yacht_speed < 5.0
			the_yacht_speed +=@ 0.01
		ELSE
			the_yacht_speed = 5.0
			clear_route_flag = 2
		ENDIF
		SET_OBJECT_PATH_SPEED the_path_spline the_yacht_speed
	ENDIF
ENDIF



///////////////////////////////////////////////////////////////////////////////////////////
// COLONEL & GOONS STUFF //////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	colonel
	IF played_audio_15_dialogue	= 0
		IF NOT IS_PLAYER_HEALTH_GREATER	PLAYER1 50
			IF audio_15_flag = 0
				audio_15_flag = 1
				audio_15_timeout = game_timer + 5000
			ENDIF
			played_audio_15_dialogue = 1
		ENDIF
	ENDIF
	IF played_audio_7_dialogue	= 0
		IF NOT IS_CHAR_HEALTH_GREATER colonel 180
			IF audio_7_flag = 0
				audio_7_flag = 1
				audio_7_timeout = game_timer + 5000
			ENDIF
			played_audio_7_dialogue	= 1
		ENDIF
	ENDIF
	IF played_audio_9_dialogue	= 0
		IF NOT IS_CHAR_HEALTH_GREATER colonel 100
			IF audio_9_flag = 0
				audio_9_flag = 1
				audio_9_timeout = game_timer + 5000
			ENDIF
			played_audio_9_dialogue	= 1
		ENDIF
	ENDIF
ELSE
	PRINT_NOW COL5_B3 5000 1 //~r~The Colonel is dead!
	SET_FADING_COLOUR 225 225 225
	DO_FADE 1000 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE
	GOTO mission_general5_failed
ENDIF

IF IS_CHAR_DEAD colonel_goon1
	REMOVE_CHAR_ELEGANTLY colonel_goon1
ENDIF

IF IS_CHAR_DEAD colonel_goon2
	REMOVE_CHAR_ELEGANTLY colonel_goon2
ENDIF

IF IS_CHAR_DEAD colonel_goon3
	REMOVE_CHAR_ELEGANTLY colonel_goon3
ENDIF

IF IS_CHAR_DEAD colonel_goon4
	REMOVE_CHAR_ELEGANTLY colonel_goon4
ENDIF


///////////////////////////////////////////////////////////////////////////////////////////
// DINGHYS CIRCLING YACHT /////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

gosub_boat = barricade_boat01
gosub_boat_dr = barricade_boat01_dr
gosub_boat_sh = barricade_boat01_sh
gosub_boat_flag = barricade_boat01_flag
GOSUB boat_circle_yacht
barricade_boat01 = gosub_boat 		  
barricade_boat01_flag =	gosub_boat_flag	  

gosub_boat = barricade_boat02
gosub_boat_dr = barricade_boat02_dr
gosub_boat_sh = barricade_boat02_sh
gosub_boat_flag = barricade_boat02_flag
GOSUB boat_circle_yacht
barricade_boat02 = gosub_boat 		  
barricade_boat02_flag =	gosub_boat_flag	  

gosub_boat = barricade_boat05
gosub_boat_dr = barricade_boat05_dr
gosub_boat_sh = barricade_boat05_sh
gosub_boat_flag = barricade_boat05_flag
GOSUB boat_circle_yacht
barricade_boat05 = gosub_boat 		  
barricade_boat05_flag =	gosub_boat_flag	  


///////////////////////////////////////////////////////////////////////////////////////////
// BARRICADE_BOAT03 STUFF /////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD barricade_boat03
	IF NOT IS_CHAR_DEAD barricade_boat03_dr
		IF barricade_boat03_flag = 0
			SET_BOAT_CRUISE_SPEED barricade_boat03 10.0
			BOAT_GOTO_COORDS barricade_boat03 171.0578 942.3843 6.0
			barricade_boat03_flag = 1
		ENDIF
		IF barricade_boat03_flag = 1
			IF LOCATE_CAR_2D barricade_boat03 171.0578 942.3843 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 148.7975 947.8748 6.0
				barricade_boat03_flag = 2
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 2
			IF LOCATE_CAR_2D barricade_boat03 148.7975 947.8748 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 129.6003 936.7351 6.0
				barricade_boat03_flag = 3
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 3
			IF LOCATE_CAR_2D barricade_boat03 129.6003 936.7351 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 122.3512 920.2498 6.0
				barricade_boat03_flag = 4
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 4
			IF LOCATE_CAR_2D barricade_boat03 122.3512 920.2498 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 124.6240 909.1359 6.0
				barricade_boat03_flag = 5
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 5
			IF LOCATE_CAR_2D barricade_boat03 124.6240 909.1359 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 138.0438 900.7563 6.0
				barricade_boat03_flag = 6
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 6
			IF LOCATE_CAR_2D barricade_boat03 138.0438 900.7563 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 161.4032 891.2236 6.0
				barricade_boat03_flag = 7
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 7
			IF LOCATE_CAR_2D barricade_boat03 161.4032 891.2236 8.0 8.0 0
				BOAT_GOTO_COORDS barricade_boat03 176.3047 887.8659 6.0
				barricade_boat03_flag = 8
			ENDIF
		ENDIF
		IF barricade_boat03_flag = 8
			IF LOCATE_CAR_2D barricade_boat03 176.3047 887.8659 8.0 8.0 0
				SET_BOAT_CRUISE_SPEED barricade_boat03 0.0
				BOAT_STOP barricade_boat03
				ANCHOR_BOAT	barricade_boat03 TRUE
				SET_CAR_MISSION	barricade_boat03 MISSION_STOP_FOREVER
				barricade_boat03_flag = 9
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED barricade_boat03_dr
		MARK_CAR_AS_NO_LONGER_NEEDED barricade_boat03
		barricade_boat05 = -1
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED barricade_boat03_dr
	MARK_CAR_AS_NO_LONGER_NEEDED barricade_boat03
	barricade_boat05 = -1
	barricade_boat03_flag = -1
ENDIF



///////////////////////////////////////////////////////////////////////////////////////////
// BARRICADE_BOAT09 STUFF /////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD barricade_boat09
	IF NOT IS_CHAR_DEAD barricade_boat09_dr
		IF barricade_boat09_flag = 1
			BOAT_GOTO_COORDS barricade_boat09 200.4224 885.9669 6.0
			SET_BOAT_CRUISE_SPEED barricade_boat09 8.0
			barricade_boat09_flag = 2		
		ENDIF
		IF barricade_boat09_flag = 2
			IF LOCATE_CAR_2D barricade_boat09 200.4224 885.9669 8.0 8.0 0
				SET_BOAT_CRUISE_SPEED barricade_boat09 0.0
				SET_CAR_MISSION	barricade_boat09 MISSION_STOP_FOREVER
				BOAT_STOP barricade_boat09
				ANCHOR_BOAT	barricade_boat09 TRUE
				barricade_boat09_flag = 3
			ENDIF
		ENDIF
	ELSE
		SET_CAR_MISSION	barricade_boat09 MISSION_STOP_FOREVER
		SET_BOAT_CRUISE_SPEED barricade_boat09 0.0
		BOAT_STOP barricade_boat09
		ANCHOR_BOAT	barricade_boat09 TRUE
		SET_CAR_STATUS barricade_boat09 STATUS_ABANDONED
		MARK_CAR_AS_NO_LONGER_NEEDED barricade_boat09
		MARK_CHAR_AS_NO_LONGER_NEEDED barricade_boat09_dr
		barricade_boat09 = -1
	ENDIF
ELSE
	MARK_CAR_AS_NO_LONGER_NEEDED barricade_boat09
	MARK_CHAR_AS_NO_LONGER_NEEDED barricade_boat09_dr
	barricade_boat09 = -1
	barricade_boat09_flag = -1
ENDIF


///////////////////////////////////////////////////////////////////////////////////////////
// BOARDER_1 STUFF ////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF barricade_boat09_flag = 3
	IF boarder_1_flag = 0
		//IF NOT IS_POINT_ON_SCREEN 195.7159 886.0515 8.5 1.0
		GET_PLAYER_COORDINATES player1 x y z
		IF z > 11.2
			//IF NOT IS_AREA_OCCUPIED 195.2 885.5 7.3 196.2 886.5 9.5 FALSE FALSE TRUE FALSE FALSE
				CREATE_CHAR PEDTYPE_GANG_STREET HMOST 195.7159 886.0515 8.0 boarder_1
				goon = boarder_1
				GOSUB set_up_boarders_shite
				boarder_1_flag = 1
			//ENDIF
		ENDIF
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD	boarder_1
	IF boarder_1_flag = 1
		IF IS_CHAR_OBJ_NO_OBJ boarder_1
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	196.3903 888.9396
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_1	196.3903 888.9396 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
			boarder_1_flag = 2
		ENDIF
	ENDIF
	IF boarder_1_flag = 2
		IF IS_CHAR_OBJ_NO_OBJ boarder_1
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_1	194.5447 914.6995 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
			boarder_1_flag = 3
		ENDIF
	ENDIF
	IF boarder_1_flag = 3
		IF IS_CHAR_OBJ_NO_OBJ boarder_1
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_1	192.4100 901.3952 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	196.3216 899.4728
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
			boarder_1_flag = 4
		ENDIF
	ENDIF
	IF boarder_1_flag = 4
		IF IS_CHAR_OBJ_NO_OBJ boarder_1
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	196.3216 899.4728
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_1	196.3216 899.4728 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	192.9792 875.6545
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
			boarder_1_flag = 5
		ENDIF
	ENDIF
	IF boarder_1_flag = 5
		IF IS_CHAR_OBJ_NO_OBJ boarder_1
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	192.9792 875.6545
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_1	192.9792 875.6545 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	191.2296 869.7584
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
			boarder_1_flag = 6
		ENDIF
	ENDIF
	IF boarder_1_flag = 6
		IF IS_CHAR_OBJ_NO_OBJ boarder_1
			SET_CHAR_OBJ_RUN_TO_COORD boarder_1	191.2296 869.7584
			SET_CHAR_USE_PEDNODE_SEEK boarder_1 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_1	191.2296 869.7584 2.0 2.0 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_1 player1
			IF audio_13_flag = 0
				audio_13_flag = 1
				audio_13_timeout = game_timer + 5000
			ENDIF
			boarder_1_flag = 7
		ENDIF
	ENDIF
	IF boarder_1_flag = 7
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_1 player1
	ENDIF
ELSE
	REMOVE_CHAR_ELEGANTLY boarder_1
	boarder_1_flag = 0
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
// BOARDER_2 STUFF ////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF boarder_1_flag > 1
	IF boarder_2_flag = 0
		//IF NOT IS_POINT_ON_SCREEN 195.7159 886.0515 8.5 1.0
		GET_PLAYER_COORDINATES player1 x y z
		IF z > 11.2
			//IF NOT IS_AREA_OCCUPIED 195.2 885.5 7.3 196.2 886.5 9.5 FALSE FALSE TRUE FALSE FALSE
				CREATE_CHAR PEDTYPE_GANG_STREET HMOST 195.7159 886.0515 8.0 boarder_2
				goon = boarder_2
				GOSUB set_up_boarders_shite
				boarder_2_flag = 1
			//ENDIF
		ENDIF
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD	boarder_2
	IF boarder_2_flag = 1
		IF IS_CHAR_OBJ_NO_OBJ boarder_2
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	196.3903 888.9396
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_2	196.3903 888.9396 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
			boarder_2_flag = 2
		ENDIF
	ENDIF
	IF boarder_2_flag = 2
		IF IS_CHAR_OBJ_NO_OBJ boarder_2
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_2	194.5447 914.6995 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
			boarder_2_flag = 3
		ENDIF
	ENDIF
	IF boarder_2_flag = 3
		IF IS_CHAR_OBJ_NO_OBJ boarder_2
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_2	192.4100 901.3952 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	187.9892 900.3357
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
			boarder_2_flag = 4
		ENDIF
	ENDIF
	IF boarder_2_flag = 4
		IF IS_CHAR_OBJ_NO_OBJ boarder_2
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	187.9892 900.3357
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_2	187.9892 900.3357 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	184.6517 876.7971
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
			boarder_2_flag = 5
		ENDIF
	ENDIF
	IF boarder_2_flag = 5
		IF IS_CHAR_OBJ_NO_OBJ boarder_2
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	184.6517 876.7971
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_2	184.6517 876.7971 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	184.4611 870.8157
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
			boarder_2_flag = 6
		ENDIF
	ENDIF
	IF boarder_2_flag = 6
		IF IS_CHAR_OBJ_NO_OBJ boarder_2
			SET_CHAR_OBJ_RUN_TO_COORD boarder_2	184.4611 870.8157
			SET_CHAR_USE_PEDNODE_SEEK boarder_2 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_2	184.4611 870.8157 2.0 2.0 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_2 player1
			boarder_2_flag = 7
		ENDIF
	ENDIF
	IF boarder_2_flag = 7
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_2 player1
	ENDIF
ELSE
	REMOVE_CHAR_ELEGANTLY boarder_2
	boarder_2_flag = 0
ENDIF



///////////////////////////////////////////////////////////////////////////////////////////
// boarder_3 STUFF ////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF barricade_boat03_flag = 9
	IF boarder_3_flag = 0
		//IF NOT IS_POINT_ON_SCREEN 184.5751 887.7821 8.5 1.0
		GET_PLAYER_COORDINATES player1 x y z
		IF z > 11.2
			//IF NOT IS_AREA_OCCUPIED 184.1 887.3 7.3 185.1 888.2 9.5 FALSE FALSE TRUE FALSE FALSE
				CREATE_CHAR PEDTYPE_GANG_STREET HMOST 184.5751 887.7821 8.0 boarder_3
				goon = boarder_3
				GOSUB set_up_boarders_shite
				boarder_3_flag = 1
			//ENDIF
		ENDIF
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD	boarder_3
	IF boarder_3_flag = 1
		IF IS_CHAR_OBJ_NO_OBJ boarder_3
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3 184.8738 891.4559
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_3 184.8738 891.4559 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
			boarder_3_flag = 2
		ENDIF
	ENDIF
	IF boarder_3_flag = 2
		IF IS_CHAR_OBJ_NO_OBJ boarder_3
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_3 194.5447 914.6995 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
			boarder_3_flag = 3
		ENDIF
	ENDIF
	IF boarder_3_flag = 3
		IF IS_CHAR_OBJ_NO_OBJ boarder_3
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_3 192.4100 901.3952 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	196.3216 899.4728
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
			boarder_3_flag = 4
		ENDIF
	ENDIF
	IF boarder_3_flag = 4
		IF IS_CHAR_OBJ_NO_OBJ boarder_3
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	196.3216 899.4728
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_3	196.3216 899.4728 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	192.9792 875.6545
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
			boarder_3_flag = 5
		ENDIF
	ENDIF
	IF boarder_3_flag = 5
		IF IS_CHAR_OBJ_NO_OBJ boarder_3
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	192.9792 875.6545
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_3	192.9792 875.6545 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	191.2296 869.7584
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
			boarder_3_flag = 6
		ENDIF
	ENDIF
	IF boarder_3_flag = 6
		IF IS_CHAR_OBJ_NO_OBJ boarder_3
			SET_CHAR_OBJ_RUN_TO_COORD boarder_3	191.2296 869.7584
			SET_CHAR_USE_PEDNODE_SEEK boarder_3 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_3 191.2296 869.7584 2.0 2.0 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_3 player1
			IF audio_13_flag = 0
				audio_13_flag = 1
				audio_13_timeout = game_timer + 5000
			ENDIF
			boarder_3_flag = 7
		ENDIF
	ENDIF
	IF boarder_3_flag = 7
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_3 player1
	ENDIF
ELSE
	REMOVE_CHAR_ELEGANTLY boarder_3
	boarder_3_flag = 0
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
// boarder_4 STUFF ////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF boarder_3_flag > 0
	IF boarder_4_flag = 0
		//IF NOT IS_POINT_ON_SCREEN 184.5751 887.7821 8.5 1.0
		GET_PLAYER_COORDINATES player1 x y z
		IF z > 11.2
			////IF NOT IS_AREA_OCCUPIED 184.2 887.4 7.4 185.0 888.1 9.0 FALSE FALSE TRUE FALSE FALSE
				CREATE_CHAR PEDTYPE_GANG_STREET HMOST 184.5751 887.7821 8.0 boarder_4
				goon = boarder_4
				GOSUB set_up_boarders_shite
				boarder_4_flag = 1
			//ENDIF
		ENDIF
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD	boarder_4
	IF boarder_4_flag = 1
		IF IS_CHAR_OBJ_NO_OBJ boarder_4
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4 184.8738 891.4559
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_4 184.8738 891.4559 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
			boarder_4_flag = 2
		ENDIF
	ENDIF
	IF boarder_4_flag = 2
		IF IS_CHAR_OBJ_NO_OBJ boarder_4
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	194.5447 914.6995
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_4	194.5447 914.6995 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
			boarder_4_flag = 3
		ENDIF
	ENDIF
	IF boarder_4_flag = 3
		IF IS_CHAR_OBJ_NO_OBJ boarder_4
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	192.4100 901.3952
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_4	192.4100 901.3952 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	187.9892 900.3357
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
			boarder_4_flag = 4
		ENDIF
	ENDIF
	IF boarder_4_flag = 4
		IF IS_CHAR_OBJ_NO_OBJ boarder_4
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	187.9892 900.3357
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_4	187.9892 900.3357 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	184.6517 876.7971
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
			boarder_4_flag = 5
		ENDIF
	ENDIF
	IF boarder_4_flag = 5
		IF IS_CHAR_OBJ_NO_OBJ boarder_4
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	184.6517 876.7971
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_4	184.6517 876.7971 1.0 1.0 0
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	184.4611 870.8157
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
			boarder_4_flag = 6
		ENDIF
	ENDIF
	IF boarder_4_flag = 6
		IF IS_CHAR_OBJ_NO_OBJ boarder_4
			SET_CHAR_OBJ_RUN_TO_COORD boarder_4	184.4611 870.8157
			SET_CHAR_USE_PEDNODE_SEEK boarder_4 FALSE
		ENDIF
		IF LOCATE_CHAR_ON_FOOT_2D boarder_4	184.4611 870.8157 2.0 2.0 0
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_4 player1
			boarder_4_flag = 7
		ENDIF
	ENDIF
	IF boarder_4_flag = 7
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boarder_4 player1
	ENDIF
ELSE
	REMOVE_CHAR_ELEGANTLY boarder_4
	boarder_4_flag = 0
ENDIF

//195.7159 886.0515 8.0 //WARP DUDE FROM BOAT ONTO BOTTOM DECK
//184.5751 887.7821 8.0

//GOTOS TO GET ONTO TOP DECK
//196.3903 888.9396//184.8738 891.4559
//194.5447 914.6995
//192.4100 901.3952
//196.3216 899.4728//187.9892 900.3357
//192.9792 875.6545//184.6517 876.7971
//191.2296 869.7584//184.4611 870.8157


///////////////////////////////////////////////////////////////////////////////////////////
// HELI1 STUFF ////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF heli1_counter = -1
	IF heli1_timer < game_timer
		heli1_counter = 0
	ENDIF
ENDIF

IF heli1_counter = 0
	CREATE_CAR MAVERICK 314.2827 993.9822 13.2063 heli1
	CREATE_CHAR_INSIDE_CAR heli1 PEDTYPE_GANG_STREET HMOST heli1_pilot
	LOCK_CAR_DOORS heli1 CARLOCK_LOCKED
	
	CREATE_CHAR_AS_PASSENGER heli1 PEDTYPE_GANG_STREET HMOST 0 heli1_passenger1
	heli_passenger = heli1_passenger1
	GOSUB setup_heli_passengers
	
	CREATE_CHAR_AS_PASSENGER heli1 PEDTYPE_GANG_STREET HMOST 1 heli1_passenger2
	heli_passenger = heli1_passenger2
		GOSUB setup_heli_passengers
	
	CREATE_CHAR_AS_PASSENGER heli1 PEDTYPE_GANG_STREET HMOST 2 heli1_passenger3
	heli_passenger = heli1_passenger3
	GOSUB setup_heli_passengers
	
	SET_CAR_FORWARD_SPEED heli1 0.1
	HELI_GOTO_COORDS heli1 314.2827 993.9822 40.0 30
	
	heli1_counter = 1
ENDIF
IF heli1_counter > 0

	IF NOT IS_CAR_DEAD heli1
		IF NOT IS_CHAR_DEAD	heli1_pilot
			IF heli1_counter = 1
				IF LOCATE_CAR_3D heli1	314.2827 993.9822 40.0 5.0 5.0 4.0 0
					heli1_counter = 2
				ENDIF
			ENDIF
			IF heli1_counter = 2
				HELI_GOTO_COORDS heli1	188.1993 877.1445 30.0 20
				IF next_text = 2
					PRINT_NOW COL5_B5 5000 1//~g~Shoot down the helicopters, do not endanger the yacht.
					text_timer = game_timer + 4000
					IF audio_4_flag = 0
						audio_4_flag = 1
						audio_4_timeout = game_timer + 5000
					ENDIF
					next_text ++
				ENDIF
				IF LOCATE_CAR_3D heli1	188.1993 877.1445 30.0 10.0 10.0 5.0 0
					heli1_counter = 3
				ENDIF
			ENDIF
			IF heli1_counter = 3
				HELI_GOTO_COORDS heli1	188.1993 877.1445 16.0 10
				IF LOCATE_CAR_2D heli1	188.1993 877.1445 5.0 5.0 0
					heli_dropoff_timer = game_timer + 100
					heli1_counter = 4
				ENDIF
			ENDIF
			IF heli1_counter = 4
				IF game_timer > heli_dropoff_timer
					IF NOT IS_CHAR_DEAD heli1_passenger1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT heli1_passenger1 player1
					ENDIF
					heli_dropoff_timer = game_timer + 100
					heli1_counter = 5
				ENDIF
			ENDIF
			IF heli1_counter = 5
				IF game_timer > heli_dropoff_timer
					IF NOT IS_CHAR_DEAD heli1_passenger2
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT heli1_passenger2 player1
					ENDIF
					heli_dropoff_timer = game_timer + 80
					heli1_counter = 6
				ENDIF
			ENDIF
			IF heli1_counter = 6
				IF game_timer > heli_dropoff_timer
					IF NOT IS_CHAR_DEAD heli1_passenger3
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT heli1_passenger3 player1
					ENDIF
					heli_dropoff_timer = game_timer + 1500
					IF audio_12_flag = 0
						audio_12_flag = 1
						audio_12_timeout = game_timer + 5000
					ELSE
						audio_12_flag = 0
						IF audio_13_flag = 0
							audio_13_flag = 1
							audio_13_timeout = game_timer + 5000
						ENDIF
					ENDIF
					heli1_counter = 7
				ENDIF
			ENDIF
			IF heli1_counter = 7
				IF game_timer > heli_dropoff_timer
					HELI_GOTO_COORDS heli1	189.1993 879.1445 30.0 20
					IF LOCATE_CAR_3D heli1	189.1993 879.1445 30.0 5.0 5.0 4.0 0
						heli1_counter = 8
					ENDIF
				ENDIF
			ENDIF
			IF heli1_counter = 8
				HELI_GOTO_COORDS heli1 314.2827 993.9822 40.0 20
				IF LOCATE_CAR_3D heli1 314.2827 993.9822 40.0 5.0 5.0 4.0 0
					heli1_counter = 9
				ENDIF
			ENDIF
			IF heli1_counter = 9
				HELI_GOTO_COORDS heli1 314.2827 993.9822 15.0 20
				IF LOCATE_CAR_3D heli1 314.2827 993.9822 15.0 5.0 5.0 4.0 0
					MARK_CHAR_AS_NO_LONGER_NEEDED heli1_passenger1
					MARK_CHAR_AS_NO_LONGER_NEEDED heli1_passenger2
					MARK_CHAR_AS_NO_LONGER_NEEDED heli1_passenger3
					
					CREATE_CHAR_AS_PASSENGER heli1 PEDTYPE_GANG_STREET HMOST 0 heli1_passenger1
					heli_passenger = heli1_passenger1
					GOSUB setup_heli_passengers

					CREATE_CHAR_AS_PASSENGER heli1 PEDTYPE_GANG_STREET HMOST 1 heli1_passenger2
					heli_passenger = heli1_passenger2
					GOSUB setup_heli_passengers

					CREATE_CHAR_AS_PASSENGER heli1 PEDTYPE_GANG_STREET HMOST 2 heli1_passenger3
					heli_passenger = heli1_passenger3
					GOSUB setup_heli_passengers
			
					HELI_GOTO_COORDS heli1	314.2827 993.9822 40.0 20
					heli1_counter = 1
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD	heli1_passenger1
				IF IS_CHAR_IN_ANY_CAR heli1_passenger1
					SET_CHAR_OBJ_LEAVE_ANY_CAR heli1_passenger1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	heli1_passenger2
				IF IS_CHAR_IN_ANY_CAR heli1_passenger2
					SET_CHAR_OBJ_LEAVE_ANY_CAR heli1_passenger2
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	heli1_passenger3
				IF IS_CHAR_IN_ANY_CAR heli1_passenger3
					SET_CHAR_OBJ_LEAVE_ANY_CAR heli1_passenger3
				ENDIF
			ENDIF
			//SET_CAR_STATUS heli1 STATUS_ABANDONED
			//SET_CAR_MISSION heli1 MISSION_NONE
			MAKE_HELI_COME_CRASHING_DOWN heli1
			CLOSE_ALL_CAR_DOORS heli1
			MARK_CAR_AS_NO_LONGER_NEEDED heli1
			REMOVE_CHAR_ELEGANTLY heli1_pilot
			heli1 = -1
		ENDIF
	ELSE
		MARK_CAR_AS_NO_LONGER_NEEDED heli1
	ENDIF

	IF IS_CHAR_DEAD	heli1_passenger1
		REMOVE_CHAR_ELEGANTLY heli1_passenger1
	ENDIF

	IF IS_CHAR_DEAD	heli1_passenger2
		REMOVE_CHAR_ELEGANTLY heli1_passenger2
	ENDIF

	IF IS_CHAR_DEAD	heli1_passenger3
		REMOVE_CHAR_ELEGANTLY heli1_passenger3
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
// HELI2 STUFF ////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF IS_CAR_DEAD heli1
AND	heli1_counter > 0
	IF heli2_counter = -1
		heli2_counter = 0
	ENDIF
ENDIF
IF heli1_counter > 4
	IF heli2_counter = -1
		heli2_counter = 0
	ENDIF
ENDIF

IF heli2_counter = 0
	CREATE_CAR MAVERICK 302.9623 909.7476 11.6869 heli2
	CREATE_CHAR_INSIDE_CAR heli2 PEDTYPE_GANG_STREET HMOST heli2_pilot
	LOCK_CAR_DOORS heli2 CARLOCK_LOCKED
	
	CREATE_CHAR_AS_PASSENGER heli2 PEDTYPE_GANG_STREET HMOST 0 heli2_passenger1
	heli_passenger = heli2_passenger1
	GOSUB setup_heli_passengers
	
	CREATE_CHAR_AS_PASSENGER heli2 PEDTYPE_GANG_STREET HMOST 1 heli2_passenger2
	heli_passenger = heli2_passenger2
	GOSUB setup_heli_passengers
	
	CREATE_CHAR_AS_PASSENGER heli2 PEDTYPE_GANG_STREET HMOST 2 heli2_passenger3
	heli_passenger = heli2_passenger3
	GOSUB setup_heli_passengers
	
	SET_CAR_FORWARD_SPEED heli2 0.1
	HELI_GOTO_COORDS heli2 302.9623 909.7476 32.0 30
	
	heli2_counter = 1
ENDIF

IF heli2_counter > 0
	IF NOT IS_CAR_DEAD heli2
		IF NOT IS_CHAR_DEAD	heli2_pilot
			IF heli2_counter = 1
				IF LOCATE_CAR_3D heli2	302.9623 909.7476 32.0 5.0 5.0 4.0 0
					heli2_counter = 2
				ENDIF
			ENDIF
			IF heli2_counter = 2
				HELI_GOTO_COORDS heli2	188.1993 879.1445 25.0 20
				IF LOCATE_CAR_3D heli2	188.1993 879.1445 25.0 10.0 10.0 5.0 0
					IF audio_4_flag = 0
						audio_4_flag = 1
						audio_4_timeout = game_timer + 5000
					ENDIF
					heli2_counter = 3
				ENDIF
			ENDIF
			IF heli2_counter = 3
				HELI_GOTO_COORDS heli2	188.1993 879.1445 16.0 10
				IF LOCATE_CAR_2D heli2	188.1993 879.1445 5.0 5.0 0
					heli_dropoff_timer = game_timer + 100
					heli2_counter = 4
				ENDIF
			ENDIF
			IF heli2_counter = 4
				IF game_timer > heli_dropoff_timer
					IF NOT IS_CHAR_DEAD heli2_passenger1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT heli2_passenger1 player1
					ENDIF
					heli_dropoff_timer = game_timer + 100
					heli2_counter = 5
				ENDIF
			ENDIF
			IF heli2_counter = 5
				IF game_timer > heli_dropoff_timer
					IF NOT IS_CHAR_DEAD heli2_passenger2
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT heli2_passenger2 player1
					ENDIF
					heli_dropoff_timer = game_timer + 80
					heli2_counter = 6
				ENDIF
			ENDIF
			IF heli2_counter = 6
				IF game_timer > heli_dropoff_timer
					IF NOT IS_CHAR_DEAD heli2_passenger3
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT heli2_passenger3 player1
					ENDIF
					heli_dropoff_timer = game_timer + 1500
					IF audio_14_flag = 0
						audio_14_flag = 1
						audio_14_timeout = game_timer + 5000
					ELSE
						audio_14_flag = 0
						IF audio_16_flag = 0
							audio_16_flag = 1
							audio_16_timeout = game_timer + 5000
						ENDIF
					ENDIF
					heli2_counter = 7
				ENDIF
			ENDIF
			IF heli2_counter = 7
				IF game_timer > heli_dropoff_timer
					HELI_GOTO_COORDS heli2 189.1993 879.1445 30.0 20
					IF LOCATE_CAR_3D heli2 189.1993 879.1445 30.0 5.0 5.0 4.0 0
						heli2_counter = 8
					ENDIF
				ENDIF
			ENDIF
			IF heli2_counter = 8
				HELI_GOTO_COORDS heli2 302.9623 909.7476 32.0 20
				IF LOCATE_CAR_3D heli2 302.9623 909.7476 32.0 5.0 5.0 4.0 0
					heli2_counter = 9
				ENDIF
			ENDIF
			IF heli2_counter = 9
				HELI_GOTO_COORDS heli2 302.9623 909.7476 13.0 20
				IF LOCATE_CAR_3D heli2 302.9623 909.7476 13.0 5.0 5.0 4.0 0
					MARK_CHAR_AS_NO_LONGER_NEEDED heli2_passenger1
					MARK_CHAR_AS_NO_LONGER_NEEDED heli2_passenger2
					MARK_CHAR_AS_NO_LONGER_NEEDED heli2_passenger3
					
					CREATE_CHAR_AS_PASSENGER heli2 PEDTYPE_GANG_STREET HMOST 0 heli2_passenger1
					heli_passenger = heli2_passenger1
					GOSUB setup_heli_passengers

					CREATE_CHAR_AS_PASSENGER heli2 PEDTYPE_GANG_STREET HMOST 1 heli2_passenger2
					heli_passenger = heli2_passenger2
					GOSUB setup_heli_passengers

					CREATE_CHAR_AS_PASSENGER heli2 PEDTYPE_GANG_STREET HMOST 2 heli2_passenger3
					heli_passenger = heli2_passenger3
					GOSUB setup_heli_passengers
			
					HELI_GOTO_COORDS heli2 302.9623 909.7476 40.0 20
					heli2_counter = 1
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD	heli2_passenger1
				IF IS_CHAR_IN_ANY_CAR heli2_passenger1
					SET_CHAR_OBJ_LEAVE_ANY_CAR heli2_passenger1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	heli2_passenger2
				IF IS_CHAR_IN_ANY_CAR heli2_passenger2
					SET_CHAR_OBJ_LEAVE_ANY_CAR heli2_passenger2
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	heli2_passenger3
				IF IS_CHAR_IN_ANY_CAR heli2_passenger3
					SET_CHAR_OBJ_LEAVE_ANY_CAR heli2_passenger3
				ENDIF
			ENDIF
			//SET_CAR_STATUS heli2 STATUS_ABANDONED
			//SET_CAR_MISSION heli2 MISSION_NONE
			MAKE_HELI_COME_CRASHING_DOWN heli2
			CLOSE_ALL_CAR_DOORS heli2
			MARK_CAR_AS_NO_LONGER_NEEDED heli2
			REMOVE_CHAR_ELEGANTLY heli2_pilot
			heli2 = -1
		ENDIF
	ELSE
		MARK_CAR_AS_NO_LONGER_NEEDED heli2
	ENDIF

	IF IS_CHAR_DEAD	heli2_passenger1
		REMOVE_CHAR_ELEGANTLY heli2_passenger1
	ENDIF

	IF IS_CHAR_DEAD	heli2_passenger2
		REMOVE_CHAR_ELEGANTLY heli2_passenger2
	ENDIF

	IF IS_CHAR_DEAD	heli2_passenger3
		REMOVE_CHAR_ELEGANTLY heli2_passenger3
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
// APACHE STUFF ///////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD killer_chopper
	IF NOT IS_CHAR_DEAD	killer_chopper_pilot
		
		gosub_heli = killer_chopper
		GOSUB heli_do_flybys_over_yacht
		IF LOCATE_CAR_2D killer_chopper the_yacht_x the_yacht_y	40.0 40.0 0
			IF got_hunter_message = 0
				PRINT_NOW COL5_B4 5000 1//~g~Shoot the attacking helicopter out of the sky.
				text_timer = game_timer + 4000
				got_hunter_message = 1
			ENDIF
			FIRE_HUNTER_GUN	killer_chopper
		ENDIF
	ELSE
		//GET_CAR_COORDINATES killer_chopper x y z
		//z = 0.0
		//HELI_GOTO_COORDS killer_chopper X Y Z 50
		//SET_CAR_STATUS killer_chopper STATUS_ABANDONED
		//SET_CAR_MISSION killer_chopper MISSION_NONE
		MAKE_HELI_COME_CRASHING_DOWN killer_chopper
		CLOSE_ALL_CAR_DOORS killer_chopper
		MARK_CAR_AS_NO_LONGER_NEEDED killer_chopper
		MARK_CHAR_AS_NO_LONGER_NEEDED killer_chopper_pilot
		killer_chopper = -1
	ENDIF
ELSE
	MARK_CAR_AS_NO_LONGER_NEEDED killer_chopper
	MARK_CHAR_AS_NO_LONGER_NEEDED killer_chopper_pilot
	IF killer_chopper_created = 0
		IF IS_CAR_DEAD heli1
		AND	heli1_counter > 0
			IF IS_CAR_DEAD heli2
			AND	heli2_counter > 0
				IF hunter_timer < game_timer
					SET_PLAYER_CONTROL player1 OFF
					SET_EVERYONE_IGNORE_PLAYER player1 TRUE
					SWITCH_WIDESCREEN ON
					SET_ALL_CARS_CAN_BE_DAMAGED FALSE
					SET_FADING_COLOUR 0 0 1
					DO_FADE 500 FADE_OUT
					killer_chopper_created = 1
				ENDIF
			ELSE
				hunter_timer = game_timer + 8000
			ENDIF
		ELSE
			hunter_timer = game_timer + 8000
		ENDIF
		IF killer_chopper_created = 1
			CREATE_CAR HUNTER 21.2864 720.1946 13.0 killer_chopper
			SET_CAR_HEADING	killer_chopper 312.7112
			CREATE_CHAR_INSIDE_CAR killer_chopper PEDTYPE_GANG_STREET HMOST killer_chopper_pilot
			SET_CAR_HEALTH killer_chopper 2500
			LOCK_CAR_DOORS killer_chopper CARLOCK_LOCKED
			SET_CAR_FORWARD_SPEED killer_chopper 30.0
			killer_chopper_created = 2
		ENDIF
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
// CAR01 BOAT02 BOAT03 STUFF //////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT car01_counter = 4
	IF NOT IS_CAR_DEAD car01
		IF car01_counter = 1
			IF LOCATE_CAR_2D car01 -247.1728 -1215.7502 26.0 26.0 0
				SET_CAR_TEMP_ACTION	car01 TEMPACT_TURNLEFT 200
				car01_timer = game_timer + 199
				car01_counter = 2
			ENDIF
		ENDIF
		IF car01_counter = 2
			IF game_timer >	car01_timer
				SET_CAR_TEMP_ACTION	car01 TEMPACT_HANDBRAKETURNLEFT 5000
				car01_counter = 3
			ENDIF
		ENDIF
		IF car01_counter = 3
			IF IS_CAR_STOPPED car01
				SET_CAR_TEMP_ACTION	car01 TEMPACT_WAIT 5000
				car01_counter = 4
			ENDIF
		ENDIF
	ELSE
		IF car01_counter = 0
			IF game_timer > car01_timer
				CLEAR_AREA -238.2693 -1361.3296 7.0786 500.0 TRUE
				CREATE_CAR WASHING -238.2693 -1361.3296 7.0786 car01
				CHANGE_CAR_COLOUR car01 0 0
				SET_CAR_HEADING car01 10.7405
				CREATE_CHAR_INSIDE_CAR car01 PEDTYPE_GANG_STREET HMOST car01_goon1
				goon = car01_goon1
				GOSUB setup_the_goons_shite
				CREATE_CHAR_AS_PASSENGER car01 PEDTYPE_GANG_STREET HMOST 0 car01_goon2
				goon = car01_goon2
				GOSUB setup_the_goons_shite
				CREATE_CHAR_AS_PASSENGER car01 PEDTYPE_GANG_STREET HMOST 1 car01_goon3
				goon = car01_goon3
				GOSUB setup_the_goons_shite
				CREATE_CHAR_AS_PASSENGER car01 PEDTYPE_GANG_STREET HMOST 2 car01_goon4
				goon = car01_goon4
				GOSUB setup_the_goons_shite

				SET_CAR_CRUISE_SPEED car01 100.0
				SET_CAR_FORWARD_SPEED car01 30.0
				SET_CAR_DRIVING_STYLE car01 2
				CAR_GOTO_COORDINATES_ACCURATE car01 -247.1728 -1215.7502 7.0856 
				SET_CAR_STRAIGHT_LINE_DISTANCE car01 255
				//SET_CAR_MISSION car01 MISSION_GOTOCOORDS_ASTHECROWSWIMS
				car01_counter = 1
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF NOT IS_CHAR_DEAD	car01_goon1
		IF car01_goon1_counter = 0
			SET_CHAR_OBJ_RUN_TO_COORD car01_goon1 -257.2504 -1214.4840
			SET_CHAR_USE_PEDNODE_SEEK car01_goon1 FALSE
			car01_goon1_counter = 1
		ENDIF
		IF car01_goon1_counter = 1
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon1 -257.2504 -1214.4840 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon1 -266.0016 -1214.5647
				SET_CHAR_USE_PEDNODE_SEEK car01_goon1 FALSE
				car01_goon1_counter = 2
			ENDIF
		ENDIF
		IF car01_goon1_counter = 2
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon1 -266.0016 -1214.5647 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon1 -321.7568 -1214.5964
				SET_CHAR_USE_PEDNODE_SEEK car01_goon1 FALSE
				car01_goon1_counter = 3
			ENDIF
		ENDIF
		IF car01_goon1_counter = 3
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon1 -321.7568 -1214.5964 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon1 -323.5134 -1232.9800//CATAMARAN
				SET_CHAR_USE_PEDNODE_SEEK car01_goon1 FALSE
				car01_goon1_counter = 4
			ENDIF
		ENDIF
		IF car01_goon1_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon1 -323.5134 -1232.9800 1.5 1.5 0
				IF NOT IS_CAR_DEAD boat03
					ATTACH_CHAR_TO_CAR car01_goon1 boat03 0.0 4.0 1.5 0 360.0 WEAPONTYPE_UZI
					car01_goon1_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car01_goon1 player1
				ENDIF
			ENDIF
		ENDIF
		IF car01_goon1_counter = 5
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car01_goon1 player1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	car01_goon2
		IF car01_goon2_counter = 0
			SET_CHAR_OBJ_RUN_TO_COORD car01_goon2 -257.2504 -1214.4840
			SET_CHAR_USE_PEDNODE_SEEK car01_goon2 FALSE
			car01_goon2_counter = 1
		ENDIF
		IF car01_goon2_counter = 1
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon2 -257.2504 -1214.4840 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon2 -266.0016 -1214.5647
				SET_CHAR_USE_PEDNODE_SEEK car01_goon2 FALSE
				car01_goon2_counter = 2
			ENDIF
		ENDIF
		IF car01_goon2_counter = 2
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon2 -266.0016 -1214.5647 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon2 -321.7568 -1214.5964
				SET_CHAR_USE_PEDNODE_SEEK car01_goon2 FALSE
				car01_goon2_counter = 3
			ENDIF
		ENDIF
		IF car01_goon2_counter = 3
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon2 -321.7568 -1214.5964 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon2 -323.5134 -1232.9800//CATAMARAN
				SET_CHAR_USE_PEDNODE_SEEK car01_goon2 FALSE
				car01_goon2_counter = 4
			ENDIF
		ENDIF
		IF car01_goon2_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon2 -323.5134 -1232.9800 1.5 1.5 0
				IF NOT IS_CAR_DEAD boat03
					DELETE_CHAR	car01_goon2
					CREATE_CHAR_INSIDE_CAR boat03 PEDTYPE_GANG_STREET HMOST car01_goon2
					car01_goon2_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car01_goon2 player1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CAR_DEAD boat03
		IF NOT IS_CHAR_DEAD car01_goon2
			IF car01_goon1_counter = 5
			AND car01_goon2_counter = 5
				GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS the_yacht -20.0 -20.0 0.0 x y z
				IF LOCATE_CAR_3D boat03 x y 6.0 5.0 5.0 5.0 0
					SET_BOAT_CRUISE_SPEED boat03 2.0
					GET_OBJECT_HEADING the_yacht heading
					GET_CAR_HEADING boat03 boat03_heading
					heading_diff = heading - boat03_heading
					IF heading_diff < -180.0
						heading_diff += 360.0
					ENDIF
					IF heading_diff > 180.0
						heading_diff -= 360.0
					ENDIF
					IF heading_diff < 0.0
						boat03_heading +=@ 1.0
					ELSE
						boat03_heading -=@ 1.0
					ENDIF
					IF heading_diff > 5.0
					AND heading_diff < -5.0
						SET_CAR_HEADING boat03 boat03_heading
					ENDIF
				ELSE
					IF LOCATE_CAR_2D boat03 x y 10.0 10.0 0
						SET_BOAT_CRUISE_SPEED boat03 6.0
						GET_OBJECT_HEADING the_yacht heading
						GET_CAR_HEADING boat03 boat03_heading
						heading_diff = heading - boat03_heading
						IF heading_diff < -180.0
							heading_diff += 360.0
						ENDIF
						IF heading_diff > 180.0
							heading_diff -= 360.0
						ENDIF
						IF heading_diff < 0.0
							boat03_heading +=@ 1.0
						ELSE
							boat03_heading -=@ 1.0
						ENDIF
						IF heading_diff > 5.0
						AND heading_diff < -5.0
							SET_CAR_HEADING boat03 boat03_heading
						ENDIF
					ELSE
						SET_BOAT_CRUISE_SPEED boat03 12.0
					ENDIF
				ENDIF
				BOAT_GOTO_COORDS boat03 x y 6.0
				IF NOT LOCATE_CAR_2D boat03 the_yacht_x the_yacht_y 300.0 300.0 0
					car01_goon1 = -1
				ENDIF
				IF IS_CHAR_DEAD	car01_goon1
					MARK_CAR_AS_NO_LONGER_NEEDED car02
					MARK_CAR_AS_NO_LONGER_NEEDED boat03
					boat03 = -1
					MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon2
					MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon1
					boat03_dead = 1
				ENDIF
			ENDIF
		ELSE
			MARK_CAR_AS_NO_LONGER_NEEDED car02
			MARK_CAR_AS_NO_LONGER_NEEDED boat03
			boat03 = -1
			MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon2
			MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon1
			boat03_dead = 1
		ENDIF
	ELSE
		IF played_this_dialogue = 0
			IF NOT IS_CAR_DEAD boat01
				IF IS_CAR_DEAD boat02
					IF audio_2_flag = 0
						audio_2_flag = 1
						audio_2_timeout = game_timer + 5000
					ENDIF
					played_this_dialogue = 1
				ENDIF
			ENDIF
		ENDIF
		MARK_CAR_AS_NO_LONGER_NEEDED car02
		MARK_CAR_AS_NO_LONGER_NEEDED boat03
		boat03 = -1
		MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon2
		MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon1
		boat03_dead = 1
	ENDIF
	IF NOT IS_CHAR_DEAD	car01_goon3
		IF car01_goon3_counter = 0
			SET_CHAR_OBJ_RUN_TO_COORD car01_goon3 -257.2504 -1214.4840
			SET_CHAR_USE_PEDNODE_SEEK car01_goon3 FALSE
			car01_goon3_counter = 1
		ENDIF
		IF car01_goon3_counter = 1
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon3 -257.2504 -1214.4840 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon3 -266.0016 -1214.5647
				SET_CHAR_USE_PEDNODE_SEEK car01_goon3 FALSE
				car01_goon3_counter = 2
			ENDIF
		ENDIF
		IF car01_goon3_counter = 2
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon3 -266.0016 -1214.5647 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon3 -321.7568 -1214.5964
				SET_CHAR_USE_PEDNODE_SEEK car01_goon3 FALSE
				car01_goon3_counter = 3
			ENDIF
		ENDIF
		IF car01_goon3_counter = 3
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon3 -321.7568 -1214.5964 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon3 -332.7804 -1217.1168
				SET_CHAR_USE_PEDNODE_SEEK car01_goon3 FALSE
				car01_goon3_counter = 4
			ENDIF
		ENDIF
		IF car01_goon3_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon3 -332.7804 -1217.1168 2.0 2.0 0
				IF NOT IS_CAR_DEAD boat02
					ATTACH_CHAR_TO_CAR car01_goon3 boat02 0.6462 1.4897 1.3333 0 360.0 WEAPONTYPE_UZI
					car01_goon3_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car01_goon3 player1
				ENDIF
			ENDIF
		ENDIF
		IF car01_goon1_counter = 5
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car01_goon3 player1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	car01_goon4
		IF car01_goon4_counter = 0
			SET_CHAR_OBJ_RUN_TO_COORD car01_goon4 -257.2504 -1214.4840
			SET_CHAR_USE_PEDNODE_SEEK car01_goon4 FALSE
			car01_goon4_counter = 1
		ENDIF
		IF car01_goon4_counter = 1
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon4 -257.2504 -1214.4840 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon4 -266.0016 -1214.5647
				SET_CHAR_USE_PEDNODE_SEEK car01_goon4 FALSE
				car01_goon4_counter = 2
			ENDIF
		ENDIF
		IF car01_goon4_counter = 2
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon4 -266.0016 -1214.5647 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon4 -321.7568 -1214.5964
				SET_CHAR_USE_PEDNODE_SEEK car01_goon4 FALSE
				car01_goon4_counter = 3
			ENDIF
		ENDIF
		IF car01_goon4_counter = 3
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon4 -321.7568 -1214.5964 1.5 1.5 0
				SET_CHAR_OBJ_RUN_TO_COORD car01_goon4 -332.7804 -1217.1168
				SET_CHAR_USE_PEDNODE_SEEK car01_goon4 FALSE
				car01_goon4_counter = 4
			ENDIF
		ENDIF
		IF car01_goon4_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car01_goon4 -332.7804 -1217.1168 2.0 2.0 0
				IF NOT IS_CAR_DEAD boat02
					DELETE_CHAR	car01_goon4
					CREATE_CHAR_INSIDE_CAR boat02 PEDTYPE_GANG_STREET HMOST car01_goon4
					car01_goon4_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car01_goon4 player1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CAR_DEAD boat02
		IF NOT IS_CHAR_DEAD car01_goon4
			IF car01_goon3_counter = 5
			AND car01_goon4_counter = 5
				GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS the_yacht -20.0 0.0 0.0 x y z
				IF LOCATE_CAR_3D boat02 x y 6.0 5.0 5.0 5.0 0
					SET_BOAT_CRUISE_SPEED boat02 2.0
					GET_OBJECT_HEADING the_yacht heading
					GET_CAR_HEADING boat02 boat02_heading
					heading_diff = heading - boat02_heading
					IF heading_diff < -180.0
						heading_diff += 360.0
					ENDIF
					IF heading_diff > 180.0
						heading_diff -= 360.0
					ENDIF
					IF heading_diff < 0.0
						boat02_heading +=@ 1.0
					ELSE
						boat02_heading -=@ 1.0
					ENDIF
					IF heading_diff > 5.0
					AND heading_diff < -5.0
						SET_CAR_HEADING boat02 boat02_heading
					ENDIF
				ELSE
					IF LOCATE_CAR_2D boat02 x y 10.0 10.0 0
						SET_BOAT_CRUISE_SPEED boat02 6.0
						GET_OBJECT_HEADING the_yacht heading
						GET_CAR_HEADING boat02 boat02_heading
						heading_diff = heading - boat02_heading
						IF heading_diff < -180.0
							heading_diff += 360.0
						ENDIF
						IF heading_diff > 180.0
							heading_diff -= 360.0
						ENDIF
						IF heading_diff < 0.0
							boat02_heading +=@ 1.0
						ELSE
							boat02_heading -=@ 1.0
						ENDIF
						IF heading_diff > 5.0
						AND heading_diff < -5.0
							SET_CAR_HEADING boat02 boat02_heading
						ENDIF
					ELSE
						SET_BOAT_CRUISE_SPEED boat02 12.0
					ENDIF
				ENDIF
				BOAT_GOTO_COORDS boat02 x y 6.0
			ENDIF
			IF NOT LOCATE_CAR_2D boat02 the_yacht_x the_yacht_y 300.0 300.0 0
				car01_goon3 = -1
			ENDIF
			IF IS_CHAR_DEAD	car01_goon3
				MARK_CAR_AS_NO_LONGER_NEEDED car02
				MARK_CAR_AS_NO_LONGER_NEEDED boat02
				boat02 = -1
				MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon4
				MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon3
				boat02_dead = 1
			ENDIF
		ELSE
			MARK_CAR_AS_NO_LONGER_NEEDED car02
			MARK_CAR_AS_NO_LONGER_NEEDED boat02
			boat02 = -1
			MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon4
			MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon3
			boat02_dead = 1
		ENDIF
	ELSE
		IF played_this_dialogue = 0
			IF NOT IS_CAR_DEAD boat01
				IF IS_CAR_DEAD boat03
					IF audio_2_flag = 0
						audio_2_flag = 1
						audio_2_timeout = game_timer + 5000
					ENDIF
					played_this_dialogue = 1
				ENDIF
			ENDIF
		ENDIF
		MARK_CAR_AS_NO_LONGER_NEEDED car02
		MARK_CAR_AS_NO_LONGER_NEEDED boat02
		boat02 = -1
		MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon4
		MARK_CHAR_AS_NO_LONGER_NEEDED car01_goon3
		boat02_dead = 1
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
// CAR02 BOAT01 STUFF /////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF NOT car02_counter = 4
	IF NOT IS_CAR_DEAD car02
		IF car02_counter = 1
			IF LOCATE_CAR_2D car02 -247.1728 -1215.7502 33.0 33.0 0
				SET_CAR_TEMP_ACTION	car02 TEMPACT_TURNRIGHT 200
				car02_timer = game_timer + 199
				car02_counter = 2
			ENDIF
		ENDIF
		IF car02_counter = 2
			IF game_timer >	car02_timer
				SET_CAR_TEMP_ACTION	car02 TEMPACT_HANDBRAKETURNRIGHT 5000
				car02_counter = 3
			ENDIF
		ENDIF
		IF car02_counter = 3
			IF IS_CAR_STOPPED car02
				SET_CAR_TEMP_ACTION	car02 TEMPACT_WAIT 5000
				car02_counter = 4
			ENDIF
		ENDIF
	ELSE
		IF car02_counter = 0
		AND car01_counter > 0
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -238.2693 -1361.3296 7.0786 4.0 4.0 4.0
				CREATE_CAR WASHING -238.2693 -1361.3296 7.0786 car02
				CHANGE_CAR_COLOUR car02 0 0
				SET_CAR_HEADING car02 10.7405
				MARK_MODEL_AS_NO_LONGER_NEEDED WASHING

				CREATE_CHAR_INSIDE_CAR car02 PEDTYPE_GANG_STREET HMOST car02_goon1
				goon = car02_goon1
				GOSUB setup_the_goons_shite
				CREATE_CHAR_AS_PASSENGER car02 PEDTYPE_GANG_STREET HMOST 0 car02_goon2
				goon = car02_goon2
				GOSUB setup_the_goons_shite
				CREATE_CHAR_AS_PASSENGER car02 PEDTYPE_GANG_STREET HMOST 1 car02_goon3
				goon = car02_goon3
				GOSUB setup_the_goons_shite
				CREATE_CHAR_AS_PASSENGER car02 PEDTYPE_GANG_STREET HMOST 2 car02_goon4
				goon = car02_goon4
				GOSUB setup_the_goons_shite

				SET_CAR_CRUISE_SPEED car02 100.0
				SET_CAR_FORWARD_SPEED car02 30.0
				SET_CAR_DRIVING_STYLE car02 2
				CAR_GOTO_COORDINATES_ACCURATE car02 -247.1728 -1215.7502 7.0856 
				SET_CAR_STRAIGHT_LINE_DISTANCE car02 255
				//SET_CAR_MISSION car02 MISSION_GOTOCOORDS_ASTHECROWSWIMS
				car02_counter = 1
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF NOT IS_CHAR_DEAD	car02_goon1
		jetty_stuff_dude = car02_goon1
		jetty_stuff_dude_flag = car02_goon1_counter
		GOSUB jetty_stuff
		car02_goon1_counter = jetty_stuff_dude_flag
		IF car02_goon1_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car02_goon1 -328.9344 -1212.0651 1.5 1.5 0
				IF NOT IS_CAR_DEAD boat01
					ATTACH_CHAR_TO_CAR car02_goon1 boat01 0.0 -2.0 1.2 0 360.0 WEAPONTYPE_UZI
					car02_goon1_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon1 player1
				ENDIF
			ENDIF
		ENDIF
		IF car02_goon1_counter = 5
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon1 player1
		ENDIF
	ENDIF
	
	IF NOT IS_CHAR_DEAD	car02_goon2
		jetty_stuff_dude = car02_goon2
		jetty_stuff_dude_flag = car02_goon2_counter
		GOSUB jetty_stuff
		car02_goon2_counter = jetty_stuff_dude_flag
		IF car02_goon2_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car02_goon2 -328.9344 -1212.0651 1.5 1.5 0
				IF NOT IS_CAR_DEAD boat01
					ATTACH_CHAR_TO_CAR car02_goon2 boat01 0.0 6.0 2.65 0 360.0 WEAPONTYPE_UZI
					car02_goon2_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon2 player1
				ENDIF
			ENDIF
		ENDIF
		IF car02_goon2_counter = 5
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon2 player1
		ENDIF
	ENDIF
	
	IF NOT IS_CHAR_DEAD	car02_goon3
		jetty_stuff_dude = car02_goon3
		jetty_stuff_dude_flag = car02_goon3_counter
		GOSUB jetty_stuff
		car02_goon3_counter = jetty_stuff_dude_flag
		IF car02_goon3_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car02_goon3 -328.9344 -1212.0651 1.5 1.5 0
				IF NOT IS_CAR_DEAD boat01
					ATTACH_CHAR_TO_CAR car02_goon3 boat01 0.0 10.0 1.9 0 360.0 WEAPONTYPE_UZI
					car02_goon3_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon3 player1
				ENDIF
			ENDIF
		ENDIF
		IF car02_goon3_counter = 5
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon3 player1
		ENDIF
	ENDIF
	
	IF NOT IS_CHAR_DEAD	car02_goon4
		jetty_stuff_dude = car02_goon4
		jetty_stuff_dude_flag = car02_goon4_counter
		GOSUB jetty_stuff
		car02_goon4_counter = jetty_stuff_dude_flag
		IF car02_goon4_counter = 4
			IF LOCATE_CHAR_ON_FOOT_2D car02_goon4 -328.9344 -1212.0651 1.5 1.5 0
				IF NOT IS_CAR_DEAD boat01
					DELETE_CHAR	car02_goon4
					CREATE_CHAR_INSIDE_CAR boat01 PEDTYPE_GANG_STREET HMOST car02_goon4
					boat01_timer = game_timer + 5000
					car02_goon4_counter = 5
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT car02_goon4 player1
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	IF NOT IS_CAR_DEAD boat01
		IF NOT IS_CHAR_DEAD car02_goon4
			IF car02_goon1_counter = 5
			AND car02_goon2_counter = 5
			AND car02_goon3_counter = 5
			AND car02_goon4_counter = 5
			AND game_timer > boat01_timer
				IF played_this_dialogue2 = 0
					IF audio_1_flag = 0
						audio_1_flag = 1
						audio_1_timeout = game_timer + 5000
					ENDIF
					IF NOT IS_CAR_DEAD boat01
//						IF NOT IS_CHAR_DEAD	colonel
//							SET_CHAR_OBJ_DESTROY_CAR colonel boat01
//						ENDIF
						IF NOT IS_CHAR_DEAD	colonel_goon1
							SET_CHAR_OBJ_DESTROY_CAR colonel_goon1 boat01
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD boat02
						IF NOT IS_CHAR_DEAD	colonel_goon2
							SET_CHAR_OBJ_DESTROY_CAR colonel_goon2 boat02
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD boat03
						IF NOT IS_CHAR_DEAD	colonel_goon3
							SET_CHAR_OBJ_DESTROY_CAR colonel_goon3 boat01
						ENDIF
					ENDIF
					IF NOT IS_CAR_DEAD boat03
						IF NOT IS_CHAR_DEAD	colonel_goon4
							SET_CHAR_OBJ_DESTROY_CAR colonel_goon4 boat03
						ENDIF
					ENDIF
					played_this_dialogue2 = 1
				ENDIF
				GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS the_yacht 20.0 20.0 0.0 x y z
				GET_OBJECT_HEADING the_yacht heading
				GET_CAR_HEADING boat01 boat01_heading
				heading_diff = heading - boat01_heading
				IF heading_diff < -180.0
					heading_diff += 360.0
				ENDIF
				IF heading_diff > 180.0
					heading_diff -= 360.0
				ENDIF
				IF heading_diff < 0.0
					boat01_heading -=@ 2.0
				ELSE
					boat01_heading +=@ 2.0
				ENDIF
				IF heading_diff > 5.0
				AND heading_diff < -5.0
					SET_CAR_HEADING boat01 boat01_heading
				ENDIF
				IF LOCATE_CAR_3D boat01 x y 6.0 10.0 10.0 5.0 0
					SET_BOAT_CRUISE_SPEED boat01 2.0
				ELSE
					IF LOCATE_CAR_2D boat01 x y 30.0 30.0 0
						SET_BOAT_CRUISE_SPEED boat01 6.0
					ELSE
						SET_BOAT_CRUISE_SPEED boat01 12.0
					ENDIF
				ENDIF
				BOAT_GOTO_COORDS boat01 x y 6.0
			ENDIF
			IF NOT LOCATE_CAR_2D boat01 the_yacht_x the_yacht_y 300.0 300.0 0
				car02_goon1 = -1
				car02_goon2 = -1
				car02_goon3 = -1
			ENDIF
			IF IS_CHAR_DEAD	car02_goon1
				IF IS_CHAR_DEAD car02_goon2
					IF IS_CHAR_DEAD car02_goon3
						MARK_CAR_AS_NO_LONGER_NEEDED boat01
						boat01 = -1
						MARK_CAR_AS_NO_LONGER_NEEDED car01
						MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon1
						MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon2
						MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon3
						MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon4
						boat01_dead = 1
					ENDIF
				ENDIF
			ENDIF
		ELSE
			MARK_CAR_AS_NO_LONGER_NEEDED boat01
			boat01 = -1
			MARK_CAR_AS_NO_LONGER_NEEDED car01
			MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon1
			MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon2
			MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon3
			MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon4
			boat01_dead = 1
		ENDIF
	ELSE
		IF played_this_dialogue3 = 0
			IF NOT IS_CAR_DEAD boat02
			OR NOT IS_CAR_DEAD boat03
				IF audio_1_flag = 0
					audio_1_flag = 1
					audio_1_timeout = game_timer + 5000
				ENDIF
				played_this_dialogue3 = 1
			ENDIF
		ENDIF
		MARK_CAR_AS_NO_LONGER_NEEDED boat01
		boat01 = -1
		MARK_CAR_AS_NO_LONGER_NEEDED car01
		MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon1
		MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon2
		MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon3
		MARK_CHAR_AS_NO_LONGER_NEEDED car02_goon4
		boat01_dead = 1
	ENDIF
ENDIF


///////////////////////////////////////////////////////////////////////////////////////////
// AUDIO STUFF ////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
IF audio_1_flag > 0
	IF audio_1_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_1
			audio_1_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_1_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_1 10000 1//Port side! Port side!
			ENDIF
			audio_1_flag = 3
		ENDIF
	ENDIF
	IF audio_1_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_1
			audio_1_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_1_timeout
				audio_1_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_2_flag > 0
	IF audio_2_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_2
			audio_2_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_2_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_2 10000 1//They're attacking from starboard!
			ENDIF
			audio_2_flag = 3
		ENDIF
	ENDIF
	IF audio_2_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_2
			audio_2_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_2_timeout
				audio_2_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_3_flag > 0
	IF audio_3_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_3
			audio_3_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_3_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_3 10000 1//The bridge up ahead!
			ENDIF
			audio_3_flag = 3
		ENDIF
	ENDIF
	IF audio_3_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_3
			audio_3_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_3_timeout
				audio_3_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_4_flag > 0
	IF audio_4_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_17
			CLEAR_THIS_PRINT COL5_18
			CLEAR_THIS_PRINT COL5_19
			CLEAR_THIS_PRINT COL5_20
			CLEAR_THIS_PRINT COL5_21
			CLEAR_THIS_PRINT COL5_22
			audio_4_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_4_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				IF heli_audio_counter = 0
					PRINT_NOW COL5_17 10000 1//Oh my god they've got a helicopter!
				ENDIF
				IF heli_audio_counter = 1
					PRINT_NOW COL5_18 10000 1//Shoot the helicopter!
				ENDIF
				IF heli_audio_counter = 2
					PRINT_NOW COL5_19 10000 1//Tommy, take that chopper out!
				ENDIF
				IF heli_audio_counter = 3
					PRINT_NOW COL5_20 10000 1//He's coming again!  Blow that chopper!
				ENDIF
				IF heli_audio_counter = 4
					PRINT_NOW COL5_21 10000 1//Look at the size of that chopper!
				ENDIF
				IF heli_audio_counter = 5
					PRINT_NOW COL5_22 10000 1//Here he comes again!
				ENDIF
			ENDIF
			++ heli_audio_counter
			IF heli_audio_counter = 6
				heli_audio_counter = 0
			ENDIF    
			audio_4_flag = 3
		ENDIF
	ENDIF
	IF audio_4_flag = 1
		IF is_audio_in_use = 0
			IF heli_audio_counter = 0
				LOAD_MISSION_AUDIO 1 COL5_17
			ENDIF
			IF heli_audio_counter = 1
				LOAD_MISSION_AUDIO 1 COL5_18
			ENDIF
			IF heli_audio_counter = 2
				LOAD_MISSION_AUDIO 1 COL5_19
			ENDIF
			IF heli_audio_counter = 3
				LOAD_MISSION_AUDIO 1 COL5_20
			ENDIF
			IF heli_audio_counter = 4
				LOAD_MISSION_AUDIO 1 COL5_21
			ENDIF
			IF heli_audio_counter = 5
				LOAD_MISSION_AUDIO 1 COL5_22
			ENDIF
			audio_4_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_4_timeout
				audio_4_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

//COLONEL DIALOGUE
IF audio_7_flag > 0
	IF audio_7_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_7
			audio_7_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_7_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_7 10000 1//Stop shooting at me!
			ENDIF
			audio_7_flag = 3
		ENDIF
	ENDIF
	IF audio_7_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_7
			audio_7_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_7_timeout
				audio_7_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_9_flag > 0
	IF audio_9_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_9
			audio_9_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_9_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_9 10000 1//Tommy, stop them shooting at me!
			ENDIF
			audio_9_flag = 3
		ENDIF
	ENDIF
	IF audio_9_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_9
			audio_9_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_9_timeout
				audio_9_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_10_flag > 0
	IF audio_10_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_10
			audio_10_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_10_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_10 10000 1//I have diplomatic immunity!
			ENDIF
			audio_10_flag = 3
		ENDIF
	ENDIF
	IF audio_10_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_10
			audio_10_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_10_timeout
				audio_10_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_11_flag > 0
	IF audio_11_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_11
			audio_11_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_11_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_11 10000 1//Don't shoot, I am a Colonel!
			ENDIF
			audio_11_flag = 3
		ENDIF
	ENDIF
	IF audio_11_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_11
			audio_11_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_11_timeout
				audio_11_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_12_flag > 0
	IF audio_12_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_12
			audio_12_flag = 4
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_12_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_12 10000 1//Thomas, kill them, my country will love you.
			ENDIF
			audio_12_flag = 3
		ENDIF
	ENDIF
	IF audio_12_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_12
			audio_12_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_12_timeout
				audio_12_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_13_flag > 0
	IF audio_13_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_13
			audio_13_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_13_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_13 10000 1//Tommy, we are being over-run by the French!
			ENDIF
			audio_13_flag = 3
		ENDIF
	ENDIF
	IF audio_13_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_13
			audio_13_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_13_timeout
				audio_13_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_14_flag > 0
	IF audio_14_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_14
			audio_14_flag = 4
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_14_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_14 10000 1//Tommy, everywhere I look, there are French men, I hate it!
			ENDIF
			audio_14_flag = 3
		ENDIF
	ENDIF
	IF audio_14_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_14
			audio_14_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_14_timeout
				audio_14_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_15_flag > 0
	IF audio_15_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_15
			audio_15_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_15_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_15 10000 1//Tommy, how are you?
			ENDIF
			audio_15_flag = 3
		ENDIF
	ENDIF
	IF audio_15_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_15
			audio_15_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_15_timeout
				audio_15_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF audio_16_flag > 0
	IF audio_16_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL5_16
			audio_16_flag = 0
			is_audio_in_use = 0
			GOTO mission_general5_loop
		ENDIF
	ENDIF
	IF audio_16_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF text_timer < game_timer
				PRINT_NOW COL5_16 10000 1//This is for Piaf and Gainesbourg and your stupid french bread!
			ENDIF
			audio_16_flag = 3
		ENDIF
	ENDIF
	IF audio_16_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL5_16
			audio_16_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_16_timeout
				audio_16_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOTO mission_general5_loop
	   		

////////////////////////////////////////////////////////////////////////////////////////////
col5b_cutscene://CUTSCENE START/////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

GET_GAME_TIMER game_timer
breakout_timer = game_timer + 5000

WHILE NOT CAN_PLAYER_START_MISSION Player1
AND game_timer < breakout_timer //IF PLAYER IS NOT IN CONTROL AFTER 5 SECS DO THE CUTSCENE ANYWAY
    WAIT 0
    GET_GAME_TIMER game_timer                                                                                
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE Player1
//SET_FADING_COLOUR 0 0 1
//DO_FADE 1500 FADE_OUT
//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE
SWITCH_RUBBISH OFF
SWITCH_STREAMING OFF

DELETE_CAR boat01
DELETE_CAR boat02
DELETE_CAR boat03
DELETE_CAR car01
DELETE_CAR car02
DELETE_CAR gosub_heli
DELETE_CAR killer_chopper
DELETE_CAR heli1
DELETE_CAR barricade_boat01
DELETE_CAR barricade_boat02
DELETE_CAR barricade_boat03
DELETE_CAR barricade_boat04
DELETE_CAR barricade_boat05
DELETE_CAR barricade_boat06
DELETE_CAR barricade_boat07
DELETE_CAR barricade_boat08
DELETE_CAR barricade_boat09
DELETE_CAR heli2
DELETE_CAR gosub_boat
DELETE_CHAR car01_goon1
DELETE_CHAR car01_goon2
DELETE_CHAR car01_goon3
DELETE_CHAR car01_goon4
DELETE_CHAR car02_goon1
DELETE_CHAR car02_goon2
DELETE_CHAR car02_goon3
DELETE_CHAR car02_goon4
DELETE_CHAR colonel
DELETE_CHAR colonel_goon1
DELETE_CHAR colonel_goon2
DELETE_CHAR colonel_goon3
DELETE_CHAR colonel_goon4
DELETE_CHAR killer_chopper_pilot
DELETE_CHAR heli1_pilot
DELETE_CHAR heli1_passenger1
DELETE_CHAR heli1_passenger2
DELETE_CHAR heli1_passenger3
DELETE_CHAR heli2_pilot
DELETE_CHAR heli2_passenger1
DELETE_CHAR heli2_passenger2
DELETE_CHAR heli2_passenger3
DELETE_CHAR boarder_1
DELETE_CHAR boarder_2
DELETE_CHAR boarder_3
DELETE_CHAR boarder_4
DELETE_CHAR barricade_boat01_dr
DELETE_CHAR barricade_boat01_sh
DELETE_CHAR barricade_boat02_dr
DELETE_CHAR barricade_boat02_sh 
DELETE_CHAR barricade_boat03_sh
DELETE_CHAR barricade_boat05_dr
DELETE_CHAR barricade_boat05_sh
DELETE_CHAR barricade_boat06_sh1 
DELETE_CHAR barricade_boat06_sh2
DELETE_CHAR barricade_boat06_sh3
DELETE_CHAR barricade_boat03_dr
DELETE_CHAR barricade_boat09_dr

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cscolo

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
the_yacht_x = the_yacht_x + 0.003
the_yacht_y = the_yacht_y - 1.381
the_yacht_z = the_yacht_z + 3.149
LOAD_SCENE the_yacht_x the_yacht_y the_yacht_z

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

LOAD_CUTSCENE COL_5B
SET_NEAR_CLIP 0.1

SET_CUTSCENE_OFFSET the_yacht_x the_yacht_y the_yacht_z
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken cscolo

//CLEAR_AREA xyz 1.0 TRUE
//SET_PLAYER_COORDINATES player1 -10.2859 -939.8060 9.4023
//SET_PLAYER_HEADING player1 270.0

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

cs_time_limit = 5880
GOSUB wait_for_cs_time
PRINT_NOW COL5B_1 10000 1 //Thomas, you have protected and served me well. 
 
cs_time_limit = 8941
GOSUB wait_for_cs_time
PRINT_NOW COL5B_2 10000 1 //But now you must leave us before we reach the open seas.
 
cs_time_limit = 12276
GOSUB wait_for_cs_time
PRINT_NOW COL5B_3 10000 1 //I will lower my personal launch. Keep it my friend, a token of my gratitude.
 
cs_time_limit = 17735
GOSUB wait_for_cs_time
PRINT_NOW COL5B_4 10000 1 //Thank you, Colonel.
 
cs_time_limit = 18884
GOSUB wait_for_cs_time
PRINT_NOW COL5B_5 10000 1 //One more request; while I'm away, could you keep an eye on Mercedes for me?
 
cs_time_limit = 24046
GOSUB wait_for_cs_time
PRINT_NOW COL5B_6 10000 1 //I think she can look after herself, but sure, I'll keep an eye out.
 
cs_time_limit = 27722
GOSUB wait_for_cs_time
PRINT_NOW COL5B_7 10000 1 //Thank you my friend. Until I return.
 
cs_time_limit = 30400
GOSUB wait_for_cs_time
PRINT_NOW COL5B_8 10000 1 //Adios amigo. 
 
cs_time_limit = 32127//31936
GOSUB wait_for_cs_time
SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

WHILE NOT HAS_CUTSCENE_FINISHED
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

////////////////////////////////////////////////////////////////////////////////////////////
//CUTSCENE END//////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN
DELETE_OBJECT the_yacht5
GET_OFFSET_FROM_OBJECT_IN_WORLD_COORDS the_yacht 0.0 -50.0 0.0 the_yacht_x the_yacht_y the_yacht_z
CREATE_CAR SPEEDER the_yacht_x the_yacht_y 6.0 colonels_launch
//CREATE_CAR DINGHY 132.5211 1277.7527 6.0 colonels_launch
SET_CAR_HEADING colonels_launch 270.0

IF NOT IS_PLAYER_IN_ANY_CAR player1
	WARP_PLAYER_INTO_CAR player1 colonels_launch
ELSE
	GET_PLAYER_COORDINATES player1 x y z
	z += 1.0
	WARP_PLAYER_FROM_CAR_TO_COORD player1 x y z
	WAIT 0

	IF NOT IS_CAR_DEAD colonels_launch
		WARP_PLAYER_INTO_CAR player1 colonels_launch
	ENDIF
ENDIF

FREEZE_CHAR_POSITION scplayer FALSE
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT

DELETE_OBJECT the_yacht
DELETE_OBJECT the_yacht2
DELETE_OBJECT the_yacht3
DELETE_OBJECT the_yacht4
DELETE_OBJECT the_yacht5
DELETE_OBJECT the_yacht6
DELETE_OBJECT the_yacht7
DELETE_OBJECT the_yacht8

CLEAR_OBJECT_PATH the_path_spline

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

GOTO mission_general5_passed

////////////////////////////////////////////////////////////////////////////////////////////
boat_circle_yacht://////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
IF NOT IS_CAR_DEAD gosub_boat
	IF NOT IS_CHAR_DEAD	gosub_boat_dr
		IF gosub_boat_flag = 0
			BOAT_GOTO_COORDS gosub_boat 210.4842 914.7000 6.0
			IF LOCATE_CAR_3D gosub_boat 210.4842 914.7000 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 1
			ENDIF
		ENDIF
		IF gosub_boat_flag = 1
			BOAT_GOTO_COORDS gosub_boat 209.1303 871.3950 6.0
			IF LOCATE_CAR_3D gosub_boat 209.1303 871.3950 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 2
			ENDIF
		ENDIF
		IF gosub_boat_flag = 2
			BOAT_GOTO_COORDS gosub_boat 190.7315 844.9837 6.0
			IF LOCATE_CAR_3D gosub_boat 190.7315 844.9837 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 3
			ENDIF
		ENDIF
		IF gosub_boat_flag = 3
			BOAT_GOTO_COORDS gosub_boat 166.0 862.7161 6.0
			IF LOCATE_CAR_3D gosub_boat 166.0 862.7161 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 4
			ENDIF
		ENDIF
		IF gosub_boat_flag = 4
			BOAT_GOTO_COORDS gosub_boat 173.0 907.8094 6.0
			IF LOCATE_CAR_3D gosub_boat 173.0 907.8094 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 5
			ENDIF
		ENDIF
		IF gosub_boat_flag = 5
			BOAT_GOTO_COORDS gosub_boat 196.3743 924.7827 6.0
			IF LOCATE_CAR_3D gosub_boat 196.3743 924.7827 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 0
			ENDIF
		ENDIF
		IF gosub_boat_flag = 6
			BOAT_GOTO_COORDS gosub_boat 210.4842 914.7000 6.0
			IF LOCATE_CAR_3D gosub_boat 210.4842 914.7000 6.0 8.0 8.0 8.0 0
				gosub_boat_flag = 0
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED gosub_boat_dr
		MARK_CAR_AS_NO_LONGER_NEEDED gosub_boat
		gosub_boat = -1
	ENDIF
	IF NOT IS_CHAR_DEAD	gosub_boat_sh
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_boat_sh player1
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED gosub_boat_dr
		MARK_CHAR_AS_NO_LONGER_NEEDED gosub_boat_sh
		MARK_CAR_AS_NO_LONGER_NEEDED gosub_boat
		gosub_boat = -1
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED gosub_boat_dr
	MARK_CAR_AS_NO_LONGER_NEEDED gosub_boat
	gosub_boat = -1
ENDIF

RETURN



////////////////////////////////////////////////////////////////////////////////////////////
heli_do_flybys_over_yacht://////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

GET_PLAYER_COORDINATES player1 player_x player_y player_z

fly_to_z = old_fly_to_z

IF gosub_heli = killer_chopper
	gosub_heli_fly_to_counter = killer_chopper_fly_to_counter
	gosub_heli_just_come_from = killer_chopper_just_come_from
ENDIF

IF gosub_heli_fly_to_counter = 0
	fly_to_x = player_x
	fly_to_y = player_y
	fly_to_z = player_z + 7.0
ELSE
	IF gosub_heli_fly_to_counter = 1
		fly_to_x = player_x + 70.0
		fly_to_y = player_y + 70.0//higher z
		fly_to_z = player_z + 22.0
		gosub_heli_just_come_from = 1
	ENDIF

	IF gosub_heli_fly_to_counter = 2
		fly_to_x = player_x + 70.0
		fly_to_y = player_y
		fly_to_z = player_z + 14.0
		gosub_heli_just_come_from = 2
	ENDIF

	IF gosub_heli_fly_to_counter = 3
		fly_to_x = player_x	+ 70.0
		fly_to_y = player_y	- 70.0
		fly_to_z = player_z + 14.0
		gosub_heli_just_come_from = 3
	ENDIF

	IF gosub_heli_fly_to_counter = 4
		fly_to_x = player_x
		fly_to_y = player_y - 70.0
		fly_to_z = player_z + 14.0
		gosub_heli_just_come_from = 4
	ENDIF

	IF gosub_heli_fly_to_counter = 5
		fly_to_x = player_x - 70.0
		fly_to_y = player_y - 70.0
		fly_to_z = player_z + 14.0
		gosub_heli_just_come_from = 5
	ENDIF

	IF gosub_heli_fly_to_counter = 6
		fly_to_x = player_x - 70.0
		fly_to_y = player_y
		fly_to_z = player_z + 14.0
		gosub_heli_just_come_from = 6
	ENDIF

	IF gosub_heli_fly_to_counter = 7
		fly_to_x = player_x - 70.0
		fly_to_y = player_y + 70.0//higher z
		fly_to_z = player_z + 22.0
		gosub_heli_just_come_from = 7
	ENDIF

	IF gosub_heli_fly_to_counter = 8
		fly_to_x = player_x
		fly_to_y = player_y + 70.0//higher z
		fly_to_z = player_z + 22.0
		gosub_heli_just_come_from = 8
	ENDIF
ENDIF

GET_CAR_COORDINATES	gosub_heli x y z
GET_GROUND_Z_FOR_3D_COORD x y z ground_z
ground_z += 10.0
IF fly_to_z < ground_z
	old_fly_to_z = fly_to_z
	fly_to_z = ground_z
ENDIF

HELI_GOTO_COORDS gosub_heli fly_to_x fly_to_y fly_to_z 40

IF gosub_heli_fly_to_counter = 0
	locate_size = 10.0 //30.0
ELSE
	locate_size = 15.0 //35.0
ENDIF

IF LOCATE_CAR_3D gosub_heli	fly_to_x fly_to_y fly_to_z locate_size locate_size 10.0 0
	GENERATE_RANDOM_INT_IN_RANGE 0 3 random_flight
	
	IF gosub_heli_fly_to_counter = 0
		IF gosub_heli_just_come_from = 0
			gosub_heli_just_come_from = 1
		ENDIF
		IF gosub_heli_just_come_from = 1
			IF random_flight = 0
				gosub_heli_fly_to_counter = 5
			ENDIF
			IF random_flight = 1
			OR random_flight = 2
				gosub_heli_fly_to_counter = 6
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 2
			IF random_flight = 0
				gosub_heli_fly_to_counter = 6
			ENDIF
			IF random_flight = 1
			OR random_flight = 2
				gosub_heli_fly_to_counter = 7
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 3
			IF random_flight = 0
				gosub_heli_fly_to_counter = 7
			ENDIF
			IF random_flight = 1
			OR random_flight = 2
				gosub_heli_fly_to_counter = 8
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 4
			IF random_flight = 0
				gosub_heli_fly_to_counter = 7
			ENDIF
			IF random_flight = 1
				gosub_heli_fly_to_counter = 8
			ENDIF
			IF random_flight = 2
				gosub_heli_fly_to_counter = 1
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 5
			IF random_flight = 0
			OR random_flight = 1
				gosub_heli_fly_to_counter = 8
			ENDIF
			IF random_flight = 2
				gosub_heli_fly_to_counter = 1
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 6
			IF random_flight = 0
			OR random_flight = 1
				gosub_heli_fly_to_counter = 1
			ENDIF
			IF random_flight = 2
				gosub_heli_fly_to_counter = 2
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 7
			IF random_flight = 0
				gosub_heli_fly_to_counter = 2
			ENDIF
			IF random_flight = 1
				gosub_heli_fly_to_counter = 3
			ENDIF
			IF random_flight = 2
				gosub_heli_fly_to_counter = 4
			ENDIF
		ENDIF
		IF gosub_heli_just_come_from = 8
			IF random_flight = 0
				gosub_heli_fly_to_counter = 3
			ENDIF
			IF random_flight = 1
				gosub_heli_fly_to_counter = 4
			ENDIF
			IF random_flight = 2
				gosub_heli_fly_to_counter = 5
			ENDIF
		ENDIF
	ELSE
		gosub_heli_fly_to_counter = 0
	ENDIF
ENDIF

IF gosub_heli = killer_chopper
	killer_chopper_fly_to_counter = gosub_heli_fly_to_counter
	killer_chopper_just_come_from = gosub_heli_just_come_from
ENDIF

RETURN



wait_for_cs_time:
WHILE cs_time < cs_time_limit
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
RETURN


setup_the_goons_shite:
CLEAR_CHAR_THREAT_SEARCH goon
GIVE_WEAPON_TO_CHAR goon WEAPONTYPE_UZI 9999
SET_CHAR_PERSONALITY goon PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING goon TRUE
SET_CHAR_USE_PEDNODE_SEEK goon FALSE
SET_CHAR_STAY_IN_SAME_PLACE	goon TRUE
RETURN

set_up_boarders_shite:
SET_CHAR_STAY_IN_SAME_PLACE	goon TRUE
GIVE_WEAPON_TO_CHAR	goon WEAPONTYPE_PISTOL 9999
CLEAR_CHAR_THREAT_SEARCH goon
SET_CHAR_THREAT_SEARCH goon THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH goon THREAT_GUN
SET_CHAR_HEED_THREATS goon TRUE
SET_CHAR_OBJ_RUN_TO_COORD goon	196.3903 888.9396
SET_CHAR_USE_PEDNODE_SEEK goon FALSE
SET_CHAR_PERSONALITY goon PEDSTAT_TOUGH_GUY
SET_CHAR_IGNORE_THREATS_BEHIND_OBJECTS goon TRUE
SET_CHAR_CEASE_ATTACK_TIMER	goon 1500
RETURN

setup_boat_shooters:
SET_CHAR_STAY_IN_SAME_PLACE	boat_shooter_ped TRUE
GIVE_WEAPON_TO_CHAR	boat_shooter_ped WEAPONTYPE_PISTOL 9999
CLEAR_CHAR_THREAT_SEARCH boat_shooter_ped
SET_CHAR_THREAT_SEARCH boat_shooter_ped THREAT_PLAYER1
SET_CHAR_HEED_THREATS boat_shooter_ped TRUE
SET_CHAR_USE_PEDNODE_SEEK boat_shooter_ped FALSE
SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT boat_shooter_ped player1
SET_CHAR_PERSONALITY boat_shooter_ped PEDSTAT_TOUGH_GUY
RETURN

setup_heli_passengers:
SET_CHAR_STAY_IN_SAME_PLACE	heli_passenger TRUE
GIVE_WEAPON_TO_CHAR	heli_passenger WEAPONTYPE_PISTOL 9999
CLEAR_CHAR_THREAT_SEARCH heli_passenger
SET_CHAR_THREAT_SEARCH heli_passenger THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH heli_passenger THREAT_GUN
SET_CHAR_HEED_THREATS heli_passenger TRUE
SET_CHAR_PERSONALITY heli_passenger PEDSTAT_TOUGH_GUY
RETURN

setup_sailors:
SET_CHAR_AS_PLAYER_FRIEND sailor player1 TRUE
CLEAR_CHAR_THREAT_SEARCH sailor
SET_CHAR_THREAT_SEARCH sailor THREAT_GANG_STREET
SET_CHAR_HEED_THREATS sailor TRUE
SET_CHAR_PERSONALITY sailor PEDSTAT_TOUGH_GUY
SET_CHAR_STAY_IN_SAME_PLACE	sailor TRUE
SET_CHAR_USE_PEDNODE_SEEK sailor FALSE
SET_CHAR_ACCURACY sailor 15
SET_CHAR_NEVER_TARGETTED sailor TRUE
SET_CHAR_IGNORE_THREATS_BEHIND_OBJECTS sailor TRUE
RETURN


////////////////////////////////////////////////////////////////////////////////////////////
mission_general5_failed:////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
GET_OBJECT_HEADING the_yacht heading

CREATE_OBJECT_NO_OFFSET yt_main_body the_yacht_x the_yacht_y the_yacht_z temp_yacht
SET_OBJECT_HEADING temp_yacht	heading
MARK_OBJECT_AS_NO_LONGER_NEEDED temp_yacht

CREATE_OBJECT_NO_OFFSET yt_main_body2 the_yacht_x the_yacht_y the_yacht_z temp_yacht
SET_OBJECT_HEADING temp_yacht	heading
MARK_OBJECT_AS_NO_LONGER_NEEDED temp_yacht

CREATE_OBJECT_NO_OFFSET yt_doors14 the_yacht_x the_yacht_y the_yacht_z temp_yacht
SET_OBJECT_HEADING temp_yacht	heading
MARK_OBJECT_AS_NO_LONGER_NEEDED temp_yacht

CREATE_OBJECT_NO_OFFSET yt_tmp_boat the_yacht_x the_yacht_y the_yacht_z temp_yacht
SET_OBJECT_HEADING temp_yacht	heading
MARK_OBJECT_AS_NO_LONGER_NEEDED temp_yacht

CREATE_OBJECT_NO_OFFSET lodmain_body the_yacht_x the_yacht_y the_yacht_z temp_yacht
SET_OBJECT_HEADING temp_yacht	heading
MARK_OBJECT_AS_NO_LONGER_NEEDED temp_yacht

temp_yacht = -1

SET_OBJECT_PATH_POSITION the_path_spline 0.0
SET_OBJECT_PATH_SPEED the_path_spline 0.0
GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
CREATE_OBJECT_NO_OFFSET yt_gangplnk_tmp the_yacht_x_start the_yacht_y_start	the_yacht_z_start the_yacht7
DONT_REMOVE_OBJECT the_yacht7
CREATE_OBJECT_NO_OFFSET yacht_chunk_kb the_yacht_x_start the_yacht_y_start	the_yacht_z_start the_yacht8
DONT_REMOVE_OBJECT the_yacht8
IF NOT HAS_DEATHARREST_BEEN_EXECUTED
	REQUEST_COLLISION -244.2799 -1360.6704
	LOAD_SCENE -244.2799 -1360.6704 7.0786
	CLEAR_AREA -244.2799 -1360.6704 7.0786 1.0 TRUE
	IF NOT IS_PLAYER_IN_ANY_CAR	player1
		SET_PLAYER_COORDINATES player1 -244.2799 -1360.6704 7.0786
	ELSE
		WARP_PLAYER_FROM_CAR_TO_COORD player1 -244.2799 -1360.6704 7.0786
	ENDIF
	SET_PLAYER_HEADING player1 279.1362
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
	SET_FADING_COLOUR 225 225 225
	DO_FADE 1000 FADE_IN
ENDIF
RETURN

   

////////////////////////////////////////////////////////////////////////////////////////////
mission_general5_passed:////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

flag_general_mission5_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 5000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 5000
REMOVE_BLIP general_contact_blip
REGISTER_MISSION_PASSED COL_5
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
RETURN
		


////////////////////////////////////////////////////////////////////////////////////////////
mission_cleanup_general5:///////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////

flag_player_on_mission = 0

GET_GAME_TIMER timer_mobile_start

REMOVE_CHAR_ELEGANTLY car01_goon1
REMOVE_CHAR_ELEGANTLY car01_goon2
REMOVE_CHAR_ELEGANTLY car01_goon3
REMOVE_CHAR_ELEGANTLY car01_goon4
REMOVE_CHAR_ELEGANTLY car02_goon1
REMOVE_CHAR_ELEGANTLY car02_goon2
REMOVE_CHAR_ELEGANTLY car02_goon3
REMOVE_CHAR_ELEGANTLY car02_goon4
REMOVE_CHAR_ELEGANTLY colonel
REMOVE_CHAR_ELEGANTLY colonel_goon1
REMOVE_CHAR_ELEGANTLY colonel_goon2
REMOVE_CHAR_ELEGANTLY colonel_goon3
REMOVE_CHAR_ELEGANTLY colonel_goon4
REMOVE_CHAR_ELEGANTLY killer_chopper_pilot
REMOVE_CHAR_ELEGANTLY heli1_pilot
REMOVE_CHAR_ELEGANTLY heli1_passenger1
REMOVE_CHAR_ELEGANTLY heli1_passenger2
REMOVE_CHAR_ELEGANTLY heli1_passenger3
REMOVE_CHAR_ELEGANTLY heli2_pilot
REMOVE_CHAR_ELEGANTLY heli2_passenger1
REMOVE_CHAR_ELEGANTLY heli2_passenger2
REMOVE_CHAR_ELEGANTLY heli2_passenger3
REMOVE_CHAR_ELEGANTLY boarder_1
REMOVE_CHAR_ELEGANTLY boarder_2
REMOVE_CHAR_ELEGANTLY boarder_3
REMOVE_CHAR_ELEGANTLY boarder_4
REMOVE_CHAR_ELEGANTLY barricade_boat01_dr
REMOVE_CHAR_ELEGANTLY barricade_boat01_sh
REMOVE_CHAR_ELEGANTLY barricade_boat02_dr
REMOVE_CHAR_ELEGANTLY barricade_boat02_sh 
REMOVE_CHAR_ELEGANTLY barricade_boat03_sh
REMOVE_CHAR_ELEGANTLY barricade_boat05_dr
REMOVE_CHAR_ELEGANTLY barricade_boat05_sh
REMOVE_CHAR_ELEGANTLY barricade_boat06_sh1 
REMOVE_CHAR_ELEGANTLY barricade_boat06_sh2
REMOVE_CHAR_ELEGANTLY barricade_boat06_sh3
REMOVE_CHAR_ELEGANTLY barricade_boat03_dr
REMOVE_CHAR_ELEGANTLY barricade_boat09_dr

REMOVE_PICKUP health_on_yacht
REMOVE_PICKUP ruger_on_yacht

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

RELEASE_WEATHER

SWITCH_CAR_GENERATOR gen_car20 101

MARK_MODEL_AS_NO_LONGER_NEEDED UZI
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED HUNTER
MARK_MODEL_AS_NO_LONGER_NEEDED DINGHY
MARK_MODEL_AS_NO_LONGER_NEEDED SPEEDER
MARK_MODEL_AS_NO_LONGER_NEEDED RIO
MARK_MODEL_AS_NO_LONGER_NEEDED WASHING
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
MARK_MODEL_AS_NO_LONGER_NEEDED MAVERICK
MARK_MODEL_AS_NO_LONGER_NEEDED MARQUIS
MARK_MODEL_AS_NO_LONGER_NEEDED TROPIC
MARK_MODEL_AS_NO_LONGER_NEEDED KATANA
MARK_MODEL_AS_NO_LONGER_NEEDED HMOST

MISSION_HAS_FINISHED
RETURN
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////




jetty_stuff:
	IF jetty_stuff_dude_flag = 0
		SET_CHAR_OBJ_RUN_TO_COORD jetty_stuff_dude -257.2504 -1214.4840
		SET_CHAR_USE_PEDNODE_SEEK jetty_stuff_dude FALSE
		jetty_stuff_dude_flag = 1
	ENDIF
	IF jetty_stuff_dude_flag = 1
		IF LOCATE_CHAR_ON_FOOT_2D jetty_stuff_dude -257.2504 -1214.4840 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD jetty_stuff_dude -266.0016 -1214.5647
			SET_CHAR_USE_PEDNODE_SEEK jetty_stuff_dude FALSE
			jetty_stuff_dude_flag = 2
		ENDIF
	ENDIF
	IF jetty_stuff_dude_flag = 2
		IF LOCATE_CHAR_ON_FOOT_2D jetty_stuff_dude -266.0016 -1214.5647 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD jetty_stuff_dude -321.7568 -1214.5964
			SET_CHAR_USE_PEDNODE_SEEK jetty_stuff_dude FALSE
			jetty_stuff_dude_flag = 3
		ENDIF
	ENDIF
	IF jetty_stuff_dude_flag = 3
		IF LOCATE_CHAR_ON_FOOT_2D jetty_stuff_dude -321.7568 -1214.5964 1.5 1.5 0
			SET_CHAR_OBJ_RUN_TO_COORD jetty_stuff_dude -328.9344 -1212.0651
			SET_CHAR_USE_PEDNODE_SEEK jetty_stuff_dude FALSE
			jetty_stuff_dude_flag = 4
		ENDIF
	ENDIF
RETURN



}