MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Cuban 4*****************************************
// ***************************************Trojan Voodoo*************************************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME cuban4
// Mission start stuff
GOSUB mission_start_cuban4
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_cuban4
ENDIF
GOSUB mission_cleanup_cuban4
MISSION_END
 
// Variables for mission
//people, cars and objects
VAR_INT trojan_horse
VAR_INT cuban_trojan1
VAR_INT trojan_horse2 
VAR_INT trojan_horse3
VAR_INT cuban_trojan2
VAR_INT cuban_trojan3
VAR_INT cuban_trojan4
VAR_INT cuban_trojan5
VAR_INT haitian_doorman
VAR_INT haitian_sniper
VAR_INT haitian_engineer3
VAR_INT haitian_engineer4
VAR_INT walking_engineers 
VAR_INT waiving_engineer 
VAR_INT hait_defender1
VAR_INT hait_defender2
VAR_INT hait_defender3
VAR_INT hait_defender4
VAR_INT hait_defender5
VAR_INT haitian_doorman2
VAR_INT haitbase_pickup
VAR_INT dynamite1
VAR_INT dynamite2
VAR_INT dynamite3
VAR_INT random_haitian1
VAR_INT random_haitian2
VAR_INT random_haitian3

//blips
VAR_INT meetingplace1_blip
VAR_INT final_meeting_place_blip
VAR_INT radar_blip_cuban_trojan1
VAR_INT bombplace1
VAR_INT bombplace2
VAR_INT bombplace3
VAR_INT parking_place

//flags
VAR_INT trojan_horse_goal 
VAR_INT flag_cuban_trojan1_in_group_prot3 
VAR_INT door_flag
VAR_INT waiving_flag
VAR_INT fake_car_node1
VAR_INT fake_car_node2
VAR_INT fake_car_node_var 
VAR_INT trojan_horse_var 
VAR_INT timer_reset1 
VAR_INT all_bombs_set
VAR_INT bomb1set
VAR_INT bomb2set
VAR_INT bomb3set  
VAR_INT playonce 
VAR_INT timerupyet
VAR_INT bomb_timer 
VAR_INT out_bomb_area
VAR_INT printy_flaggy
VAR_INT printy_flaggy2
VAR_INT player1_inside_compound
VAR_INT haitian_engineers_created
VAR_INT swap_positions
VAR_INT waitstate 
VAR_INT start_timerb
VAR_INT plyr_in_hait_car
VAR_INT final_meeting_place
VAR_INT setting_up_attackers
VAR_INT cub4_audio_flag1 
VAR_INT cub4_audio_flag2 
VAR_INT cub4_audio_flag3 
VAR_INT cub4_audio_flag4 
VAR_INT cub4_audio_flag5 
VAR_INT cub4_audio_flag6 



//testy var ints
VAR_INT testy_car // TEST CAR

// ****************************************Mission Start************************************
mission_start_cuban4:

CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT CUBAN4
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1173.5 -599.6 10.2 277.1
// *****************************************Set Flags/variables************************************

trojan_horse_goal = 0
flag_cuban_trojan1_in_group_prot3 = 1
door_flag = 0
waiving_flag = 0
fake_car_node1 = 0
fake_car_node2 = 0
fake_car_node_var = 0
trojan_horse_var = 0
timer_reset1 = 0
all_bombs_set = 0
bomb1set = 0
bomb2set = 0
bomb3set = 0
playonce = 0
timerupyet = 0
bomb_timer = 46000 // 45 secs
out_bomb_area = 0
printy_flaggy = 2
printy_flaggy2 = 0
player1_inside_compound = 0
haitian_engineers_created = 0
swap_positions = 0
waitstate = 0
start_timerb = 0
plyr_in_hait_car = 0
final_meeting_place = 0
walking_engineers = 0
waiving_engineer = 0
//andy_has_control = 1
setting_up_attackers = 0
cub4_audio_flag1 = 0 
cub4_audio_flag2 = 0 
cub4_audio_flag3 = 0 
cub4_audio_flag4 = 0 
cub4_audio_flag5 = 0 
cub4_audio_flag6 = 0 

// ****************************************START OF CUTSCENE********************************
SET_AREA_VISIBLE VIS_COFFEE_SHOP
DISABLE_CUTSCENE_SHADOWS
CLEAR_AREA_OF_CHARS -1174.8 -609.0 10.4 -116.3 -632.5 15.3
SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

LOAD_MISSION_AUDIO 1 MONO16

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSumbto
LOAD_SPECIAL_CHARACTER 3 floozyb
LOAD_SPECIAL_CHARACTER 4 floozyc
LOAD_SPECIAL_CHARACTER 5 CSpapa

LOAD_SPECIAL_MODEL CUTOBJ01 ccfan
LOAD_SPECIAL_MODEL CUTOBJ02 espreso

LOAD_SCENE -1169.0 -620.0 10.791

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

LOAD_CUTSCENE cub_3
SET_CUTSCENE_OFFSET -1170.708 -608.327 10.791 
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_umbto
SET_CUTSCENE_ANIM cs_umbto CSumbto

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_floozyb
SET_CUTSCENE_ANIM cs_floozyb floozyb

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_floozyc
SET_CUTSCENE_ANIM cs_floozyc floozyc

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_papa
SET_CUTSCENE_ANIM cs_papa CSpapa

CREATE_CUTSCENE_OBJECT CUTOBJ01 cc_fan1
SET_CUTSCENE_ANIM_TO_LOOP ccfan
SET_CUTSCENE_ANIM cc_fan1 ccfan 

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_espreso
SET_CUTSCENE_ANIM cs_espreso espreso 

CLEAR_AREA -1170.9 -603.7 10.6 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1170.9 -603.7 10.6
SET_PLAYER_HEADING player1 15.3 

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1888  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW CUB4_A 10000 1 // Hey, ladies. You know what I'm gonna do?

WHILE cs_time < 5073
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_B 10000 1 // I'm gonna kill me a Haitian. And then?  

WHILE cs_time < 7958
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_C 10000 1 // Then I'm going to make love like a man.

WHILE cs_time < 9915
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_D 10000 1 // You know that chica? Something like this.

WHILE cs_time < 15514
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_E 10000 1 // Loser! 

WHILE cs_time < 17098
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_F 10000 1 // Prick. 

WHILE cs_time < 17491
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_G 10000 1 // Hey, baby,  I wouldn't touch you with a ten foot pole!

WHILE cs_time < 21119
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_H 10000 1 // Umberto Robina, he likes the ladies! Not some goat in a skirt!

WHILE cs_time < 26363
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_I 10000 1 // Tommy!! Tommy, Tommy,I love you, I love you! Let's go!

WHILE cs_time < 31119
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_J 10000 1 // Go where? Can't I get a cup of coffee first?

WHILE cs_time < 32804
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_K 10000 1 // No time for coffee! Besides, I just had one.

WHILE cs_time < 36208
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_L 10000 1 // We gonna go take out the Haitians.

WHILE cs_time < 38251
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_M 10000 1 // Tommy, How do you take out a snake?

WHILE cs_time < 41602
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_N 10000 1 // You bite him in the ass! Hahaha!

WHILE cs_time < 43148
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_O 10000 1 // Whatever you say, Umberto.

WHILE cs_time < 44248
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_P 10000 1 // Tommy, Go and get us a little car.

WHILE cs_time < 46776
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_Q 10000 1 // When you get it, come back and pick up my boy Pepe, 

WHILE cs_time < 49338
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_R 10000 1 // and take him out to such and such...

WHILE cs_time < 53344
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_S 10000 1 // Hey Tommy! Tommy! Use their solvent as an explosive.

WHILE cs_time < 59927
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_T 10000 1 // Boom! Bye bye!.

WHILE cs_time < 62394
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_U 10000 1 // Umberto, what about you?

WHILE cs_time < 64830
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_V 10000 1 // Oh, I'm going to stay behind, and watch over the cafe with poppa.

WHILE cs_time < 68153
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB4_W 10000 1 // He's not feeling so good.

WHILE cs_time < 69153
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 71424
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 1500 FADE_OUT

CLEAR_PRINTS

WAIT 1000

IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
	ENDIF
ENDIF

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
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_cafe = 0
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0

/*
IF NOT WAS_CUTSCENE_SKIPPED
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
ENDIF
*/
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1

REQUEST_MODEL HNa
REQUEST_MODEL HNb
REQUEST_MODEL CBb
REQUEST_MODEL CBa

REQUEST_MODEL sniper
REQUEST_MODEL tec9
REQUEST_MODEL voodoo
REQUEST_MODEL dynamite

WHILE NOT HAS_MODEL_LOADED CBa
OR NOT HAS_MODEL_LOADED CBb
OR NOT HAS_MODEL_LOADED HNa
OR NOT HAS_MODEL_LOADED HNb
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED sniper
OR NOT HAS_MODEL_LOADED tec9
OR NOT HAS_MODEL_LOADED voodoo
OR NOT HAS_MODEL_LOADED dynamite
	WAIT 0
ENDWHILE

//cheating the compilier into thinking i have created something which i havent (so it can be used later)
IF flag_player_on_mission = 0
	ADD_BLIP_FOR_COORD -1181.2 83.8 11.3 parking_place
	ADD_BLIP_FOR_COORD -1198.4 104.8 11.1 bombplace1 
	ADD_BLIP_FOR_COORD -1198.4 106.6 11.1 bombplace2
	ADD_BLIP_FOR_COORD -1198.9 108.3 11.1 bombplace3
	ADD_BLIP_FOR_COORD -1037.4 172.3 10.0 meetingplace1_blip
	ADD_BLIP_FOR_COORD -1084.1 70.2 10.8 final_meeting_place_blip
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1197.9 82.5 10.1 random_haitian1
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1189.0 83.6 10.1 random_haitian2
	CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1190.5 68.5 10.1 random_haitian3
ENDIF  

//closing gate
WHILE NOT SLIDE_OBJECT haitian_gate -1114.5 67.0 10.1 10.0 10.0 0.0 FALSE
	WAIT 0
ENDWHILE

//creating Trojan Horse for player1 to use.  In game, player1 will just be told to get a Haitian Car

//CREATING TEST CAR
CREATE_CAR voodoo -1071.3 -608.4 9.7 testy_car


//pepe
CREATE_CHAR PEDTYPE_GANG_GOLFER CBb -1170.0 -607.0 10.6 cuban_trojan1
SET_CHAR_AS_PLAYER_FRIEND cuban_trojan1 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_trojan1 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH cuban_trojan1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_trojan1 TRUE
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_trojan1 TRUE
SET_CHAR_PERSONALITY cuban_trojan1 PEDSTAT_TOUGH_GUY
SET_CHAR_HEED_THREATS cuban_trojan1 TRUE
SET_CHAR_RUNNING cuban_trojan1 TRUE
SET_CHAR_NEVER_TARGETTED cuban_trojan1 TRUE


DO_FADE 1500 FADE_IN

//creating haitian doorman
															 
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1116.8 74.3 10.1 haitian_doorman
SET_CHAR_HEADING haitian_doorman 234.8 
GIVE_WEAPON_TO_CHAR haitian_doorman WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH haitian_doorman
SET_CHAR_PERSONALITY haitian_doorman PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_doorman TRUE
SET_CHAR_STAY_IN_SAME_PLACE haitian_doorman TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNb -1179.4 71.2 23.9 haitian_sniper
SET_CHAR_HEADING haitian_sniper 270.0 
GIVE_WEAPON_TO_CHAR haitian_sniper WEAPONTYPE_SNIPERRIFLE 30000
CLEAR_CHAR_THREAT_SEARCH haitian_sniper
SET_CHAR_PERSONALITY haitian_sniper PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_sniper TRUE
SET_CHAR_STAY_IN_SAME_PLACE haitian_sniper TRUE

	   
//creating 2nd van and other drivers

CREATE_CAR voodoo -1044.5 172.7 9.8 trojan_horse2
SET_CAR_HEADING trojan_horse2 180.8
SET_CAR_PROOFS trojan_horse2 FALSE TRUE FALSE FALSE FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER trojan_horse2 TRUE
SET_CAR_CRUISE_SPEED trojan_horse2 0.0 
LOCK_CAR_DOORS trojan_horse2 CARLOCK_LOCKED
SET_CAR_DRIVING_STYLE trojan_horse2 2  

CREATE_CHAR_INSIDE_CAR trojan_horse2 PEDTYPE_GANG_GOLFER CBb cuban_trojan2 //rico
SET_CHAR_AS_PLAYER_FRIEND cuban_trojan2 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_trojan2 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH cuban_trojan2
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_trojan2 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_trojan2 TRUE

CREATE_CHAR_AS_PASSENGER trojan_horse2 PEDTYPE_GANG_GOLFER CBa 0 cuban_trojan3
SET_CHAR_AS_PLAYER_FRIEND cuban_trojan3 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_trojan3 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH cuban_trojan3
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_trojan3 TRUE
SET_CHAR_NEVER_TARGETTED cuban_trojan3 TRUE
CLEAR_CHAR_THREAT_SEARCH cuban_trojan2
CLEAR_CHAR_THREAT_SEARCH cuban_trojan3


//creating third van and other cubans

CREATE_CAR voodoo -1040.4 173.4 9.9 trojan_horse3
SET_CAR_HEADING trojan_horse3 177.1
SET_CAR_PROOFS trojan_horse3 FALSE TRUE FALSE FALSE FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER trojan_horse3 TRUE
SET_CAR_CRUISE_SPEED trojan_horse3 0.0 
LOCK_CAR_DOORS trojan_horse3 CARLOCK_LOCKED
SET_CAR_DRIVING_STYLE trojan_horse3 2  

CREATE_CHAR_INSIDE_CAR trojan_horse3 PEDTYPE_GANG_GOLFER CBa cuban_trojan4
SET_CHAR_AS_PLAYER_FRIEND cuban_trojan4 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_trojan4 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH cuban_trojan4
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_trojan4 TRUE 
SET_CHAR_NEVER_TARGETTED cuban_trojan4 TRUE

CREATE_CHAR_AS_PASSENGER trojan_horse3 PEDTYPE_GANG_GOLFER CBa 0 cuban_trojan5
SET_CHAR_AS_PLAYER_FRIEND cuban_trojan5 player1 TRUE
GIVE_WEAPON_TO_CHAR cuban_trojan5 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH cuban_trojan5
SET_CHAR_CANT_BE_DRAGGED_OUT cuban_trojan5 TRUE
SET_CHAR_NEVER_TARGETTED cuban_trojan5 TRUE

CLEAR_CHAR_THREAT_SEARCH cuban_trojan4
CLEAR_CHAR_THREAT_SEARCH cuban_trojan5

MARK_CAR_AS_CONVOY_CAR trojan_horse2 TRUE 
SET_CAR_STRAIGHT_LINE_DISTANCE trojan_horse2 255 
MARK_CAR_AS_CONVOY_CAR trojan_horse3 TRUE 
SET_CAR_STRAIGHT_LINE_DISTANCE trojan_horse3 255 


SET_PLAYER_AS_LEADER cuban_trojan1 player1
{
timera = 0
timerb = 0

PRINT_NOW ( CUB4_26 ) 5000 1 //Head North into Little Haiti and steal a Voodoo car.
 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////MEETING SECOND SET OF CUBANS////////////////////////////////////////////////////////////////////
//Waiting for player1 to meet with second Haitian car
meeting_second_car_loop:

WAIT 0
	
/*	
//TEST	
IF IS_BUTTON_PRESSED PAD1 CROSS
	GOTO test_explosion
ENDIF
*/

	
//making sure player1 is in a haitian car

IF plyr_in_hait_car = 0 
	IF IS_PLAYER_IN_ANY_CAR player1
		STORE_CAR_PLAYER_IS_IN player1 trojan_horse 
		IF NOT IS_CAR_DEAD trojan_horse 
			IF IS_CAR_MODEL trojan_horse voodoo

				CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1				

				REMOVE_BLIP meetingplace1_blip
				REMOVE_BLIP final_meeting_place_blip
				IF NOT IS_CHAR_DEAD cuban_trojan1 
					IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 cuban_trojan1 8.0 8.0 8.0 FALSE
					
						LOAD_MISSION_AUDIO 1 CUB4_6
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
						ENDWHILE 
						PRINT_NOW ( CUB4_13 ) 5000 1 //Oye, let's go find our muchachos! 
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_13 
					
						IF final_meeting_place = 0
							ADD_BLIP_FOR_COORD -1037.4 172.3 10.0 meetingplace1_blip
						ELSE
						 	ADD_BLIP_FOR_COORD -1084.1 70.2 10.8 final_meeting_place_blip
						ENDIF

						IF printy_flaggy2 = 0
							PRINT_NOW ( CUB4_27 ) 5000 1 //Go and meet up with Rico and the other Cubans.
							printy_flaggy2 = 1
						ENDIF

						plyr_in_hait_car = 1
					ENDIF
				ENDIF
			ELSE
				SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
				MARK_CAR_AS_NO_LONGER_NEEDED trojan_horse   
				plyr_in_hait_car = 0
			ENDIF
		ENDIF
	ENDIF
ENDIF



//getting player to follow blips

IF plyr_in_hait_car = 1
	IF NOT IS_CAR_DEAD trojan_horse 
		IF IS_PLAYER_IN_CAR player1 trojan_horse
			IF final_meeting_place = 0
				IF NOT IS_CHAR_DEAD cuban_trojan1
					IF IS_CHAR_IN_PLAYERS_GROUP cuban_trojan1 player1  	
						IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 -1037.4 172.3 10.0 3.0 3.0 10.0 TRUE
							REMOVE_BLIP meetingplace1_blip
	// ******************************************START OF CUTSCENE******************************
							SET_PLAYER_CONTROL player1 OFF
							SWITCH_WIDESCREEN ON
							
							CLEAR_AREA_OF_CARS -1072.2 70.7 10.2 -1011.2 200.7 15.2
							SET_FIXED_CAMERA_POSITION -1029.6 169.7 13.1 0.0 0.0 0.0 
							POINT_CAMERA_AT_POINT -1030.5 170.0 12.9 JUMP_CUT
							IF NOT IS_CAR_DEAD trojan_horse2 
								IF NOT IS_CAR_DEAD trojan_horse3 
									SET_CAR_DRIVING_STYLE trojan_horse2 DRIVINGMODE_PLOUGHTHROUGH
									SET_CAR_DRIVING_STYLE trojan_horse3 DRIVINGMODE_PLOUGHTHROUGH
								ENDIF
							ENDIF

							LOAD_MISSION_AUDIO 1 CUB4_2
							LOAD_MISSION_AUDIO 2 CUB4_1

							WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							OR NOT HAS_MISSION_AUDIO_LOADED 2
								WAIT 0
							ENDWHILE 
							
							PRINT_NOW ( CUB4_08 ) 4000 1 //Hola, Amigos.
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT CUB4_08 


							PRINT_NOW ( CUB4_07 ) 4000 1 //The solvent is round the back, amigo.
							PLAY_MISSION_AUDIO 2
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 2
							CLEAR_THIS_PRINT CUB4_07 

							LOAD_MISSION_AUDIO 1 CUB4_3
							LOAD_MISSION_AUDIO 2 CUB4_4

							WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							OR NOT HAS_MISSION_AUDIO_LOADED 2
								WAIT 0
							ENDWHILE 

							PRINT_NOW ( CUB4_09 ) 4000 1 //Bueno. Haitian Putas. Muerte.
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT CUB4_09 

						   	IF NOT IS_CAR_DEAD trojan_horse2
								SET_CAR_CRUISE_SPEED trojan_horse2 10.0
								CAR_GOTO_COORDINATES trojan_horse2 -1072.2 70.7 11.2
							ENDIF

							PRINT_NOW ( CUB4_10 ) 4000 1 //Vamos
							PLAY_MISSION_AUDIO 2
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 2
							CLEAR_THIS_PRINT CUB4_10 

							LOAD_MISSION_AUDIO 1 CUB4_5
							LOAD_MISSION_AUDIO 2 CUB4_7

							WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							OR NOT HAS_MISSION_AUDIO_LOADED 2
								WAIT 0
							ENDWHILE 

							PRINT_NOW ( CUB4_11 ) 4000 1 //Vamos indeed.
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT CUB4_11 

						   	IF NOT IS_CAR_DEAD trojan_horse3
								SET_CAR_CRUISE_SPEED trojan_horse3 10.0
								CAR_GOTO_COORDINATES trojan_horse3 -1072.2 70.7 11.2
							ENDIF
							 
							PRINT_NOW ( CUB4_14 ) 4000 1 //Follow my compadres.
							PLAY_MISSION_AUDIO 2
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 2
							CLEAR_THIS_PRINT CUB4_14 

							WAIT 3000

							RESTORE_CAMERA_JUMPCUT
							SET_PLAYER_CONTROL player1 ON
							SWITCH_WIDESCREEN OFF
	// ******************************************END OF CUTSCENE********************************
							IF NOT IS_CAR_DEAD trojan_horse2
								SET_CAR_CRUISE_SPEED trojan_horse2 0.0 
								SET_CAR_COORDINATES trojan_horse2 -1101.2 70.0 10.8	  
								SET_CAR_HEADING trojan_horse2 87.8 
							ENDIF
							IF NOT IS_CAR_DEAD trojan_horse3
								SET_CAR_CRUISE_SPEED trojan_horse3 0.0
								SET_CAR_COORDINATES trojan_horse3 -1093.0 70.6 10.8	  
								SET_CAR_HEADING trojan_horse3 90.6 
							ENDIF
					
							ADD_BLIP_FOR_COORD -1084.1 70.2 10.8 final_meeting_place_blip 
							PRINT_NOW ( CUB4_28 ) 5000 1 //Join the other Cubans at the Haitian Drugs Factory.
							final_meeting_place = 1
						ENDIF
						printy_flaggy = 0
					ENDIF
				ENDIF
			ELSE
				IF LOCATE_STOPPED_PLAYER_IN_CAR_3D player1 -1084.1 70.2 10.8 5.0 5.0 10.0 TRUE
					REMOVE_BLIP final_meeting_place_blip
					GOTO following_cubans_into_base
				ENDIF
			ENDIF 
		ELSE
			IF printy_flaggy = 0
				LOAD_MISSION_AUDIO 1 CUB4_5a
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
				ENDWHILE 
				PRINT_NOW ( CUB4_12 ) 5000 1 //Hey, we need a Haitian gang car!
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD cuban_trojan1 
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT CUB4_12 
				printy_flaggy = 1
			ENDIF
			REMOVE_BLIP meetingplace1_blip
			REMOVE_BLIP final_meeting_place_blip
			plyr_in_hait_car = 0 
		ENDIF
	ENDIF
ENDIF

//checking cuban is still in player1s group
IF timerb > 5000
	IF NOT IS_CHAR_DEAD cuban_trojan1
		IF flag_cuban_trojan1_in_group_prot3 = 1
	        IF NOT IS_CHAR_IN_PLAYERS_GROUP cuban_trojan1 player1
	        	PRINT_NOW ( CUB4_24 ) 5000 1 //You've left Pepe behind, go and get him.
				REMOVE_BLIP meetingplace1_blip 
				REMOVE_BLIP final_meeting_place_blip
	        	ADD_BLIP_FOR_CHAR cuban_trojan1 radar_blip_cuban_trojan1
		        flag_cuban_trojan1_in_group_prot3 = 0
		    ENDIF
		ENDIF
		IF flag_cuban_trojan1_in_group_prot3 = 0 
		    IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 cuban_trojan1 8.0 8.0 8.0 FALSE
		        SET_PLAYER_AS_LEADER cuban_trojan1 player1
		        REMOVE_BLIP radar_blip_cuban_trojan1
				REMOVE_BLIP meetingplace1_blip
				REMOVE_BLIP final_meeting_place_blip
				IF NOT IS_PLAYER_IN_MODEL player1 voodoo 
					IF printy_flaggy = 0
				
						LOAD_MISSION_AUDIO 1 CUB4_5a
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
						ENDWHILE 
						PRINT_NOW ( CUB4_12 ) 5000 1 //Hey, we need a Haitian gang car!
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_12 
						
						printy_flaggy = 1
					ENDIF
				ELSE
					LOAD_MISSION_AUDIO 1 CUB4_6
					WHILE NOT HAS_MISSION_AUDIO_LOADED 1
						WAIT 0
					ENDWHILE 
					PRINT_NOW ( CUB4_13 ) 5000 1 //Oye, let's go find our muchachos!
					PLAY_MISSION_AUDIO 1
					WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					AND NOT IS_CHAR_DEAD cuban_trojan1 
						WAIT 0
					ENDWHILE
					CLEAR_MISSION_AUDIO 1
					CLEAR_THIS_PRINT CUB4_13 
				ENDIF

				IF NOT IS_CHAR_DEAD cuban_trojan1 
					IF IS_CHAR_IN_PLAYERS_GROUP cuban_trojan1 player1
						IF NOT IS_CAR_DEAD trojan_horse 
							IF IS_CAR_MODEL trojan_horse voodoo
								IF IS_PLAYER_IN_CAR player1 trojan_horse 
									IF final_meeting_place = 0
										ADD_BLIP_FOR_COORD -1037.4 172.3 10.0 meetingplace1_blip
									ELSE
									 	ADD_BLIP_FOR_COORD -1084.1 70.2 10.8 final_meeting_place_blip
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
		        
		        flag_cuban_trojan1_in_group_prot3 = 1
		    ENDIF
		ENDIF
	ELSE
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
		GOTO mission_failed_cuban4
	ENDIF
	printy_flaggy = 0
ENDIF


//players speech
IF timera > 5000
	IF NOT IS_CHAR_DEAD cuban_trojan1
		IF IS_CHAR_IN_PLAYERS_GROUP cuban_trojan1 player1
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 cuban_trojan1 8.0 8.0 8.0 FALSE
				IF cub4_audio_flag1 = 0 
					IF IS_PLAYER_IN_AREA_2D player1 -1222.1 -346.7 -996.3 -365.2 FALSE 
						LOAD_MISSION_AUDIO 1 CUB4_11
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
							IF final_meeting_place = 0
								DRAW_SPHERE -1037.4 172.3 10.0 3.0
							ELSE
								DRAW_SPHERE -1084.1 70.2 10.8 5.0
							ENDIF
						ENDWHILE 
						PRINT_NOW ( CUB4_18 ) 5000 1 //Man, this a nice part of town... 
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
							IF final_meeting_place = 0
								DRAW_SPHERE -1037.4 172.3 10.0 3.0
							ELSE
								DRAW_SPHERE -1084.1 70.2 10.8 5.0
							ENDIF
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_18 
						cub4_audio_flag1 = 1
					ENDIF
				ENDIF
				IF cub4_audio_flag2 = 0 
					IF IS_PLAYER_IN_AREA_2D player1 -989.3 -436.5 -1011.2 -500.6 FALSE 
						LOAD_MISSION_AUDIO 1 CUB4_13
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
							IF final_meeting_place = 0
								DRAW_SPHERE -1037.4 172.3 10.0 3.0
							ELSE
								DRAW_SPHERE -1084.1 70.2 10.8 5.0
							ENDIF
						ENDWHILE 
						PRINT_NOW ( CUB4_20 ) 5000 1 //I had a beautiful woman... lived around this neighborhood. 
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
							IF final_meeting_place = 0
								DRAW_SPHERE -1037.4 172.3 10.0 3.0
							ELSE
								DRAW_SPHERE -1084.1 70.2 10.8 5.0
							ENDIF
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_20 
						cub4_audio_flag2 = 1
					ENDIF
				ENDIF
				IF cub4_audio_flag3 = 0 
					IF IS_PLAYER_IN_AREA_2D player1 -1186.1 -95.5 -1054.3 -51.6 FALSE 
						LOAD_MISSION_AUDIO 1 CUB4_12
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
							IF final_meeting_place = 0
								DRAW_SPHERE -1037.4 172.3 10.0 3.0
							ELSE
								DRAW_SPHERE -1084.1 70.2 10.8 5.0
							ENDIF
						ENDWHILE 
						PRINT_NOW ( CUB4_19 ) 5000 1 //This place is a dump, man. 
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
							IF final_meeting_place = 0
								DRAW_SPHERE -1037.4 172.3 10.0 3.0
							ELSE
								DRAW_SPHERE -1084.1 70.2 10.8 5.0
							ENDIF
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_19 
						cub4_audio_flag3 = 1
					ENDIF
				ENDIF
				IF cub4_audio_flag4 = 0 
					IF IS_PLAYER_IN_AREA_2D player1 -1063.6 101.9 -1078.9 67.0 FALSE 
						LOAD_MISSION_AUDIO 1 CUB4_14
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
							IF NOT IS_CAR_DEAD trojan_horse 
								IF IS_CAR_MODEL trojan_horse voodoo
									IF IS_PLAYER_IN_CAR player1 trojan_horse 
										IF final_meeting_place = 0
											DRAW_SPHERE -1037.4 172.3 10.0 3.0
										ELSE
											DRAW_SPHERE -1084.1 70.2 10.8 5.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDWHILE 
						PRINT_NOW ( CUB4_21 ) 5000 1 //You know, they do nice pizzas here. 
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
							IF NOT IS_CAR_DEAD trojan_horse 
								IF IS_CAR_MODEL trojan_horse voodoo
									IF IS_PLAYER_IN_CAR player1 trojan_horse 
										IF final_meeting_place = 0
											DRAW_SPHERE -1037.4 172.3 10.0 3.0
										ELSE
											DRAW_SPHERE -1084.1 70.2 10.8 5.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_21 
						cub4_audio_flag4 = 1
					ENDIF
				ENDIF
				IF cub4_audio_flag5 = 0 
					IF timera > 60000 
						LOAD_MISSION_AUDIO 1 CUB4_16
						WHILE NOT HAS_MISSION_AUDIO_LOADED 1
							WAIT 0
							IF NOT IS_CAR_DEAD trojan_horse 
								IF IS_CAR_MODEL trojan_horse voodoo
									IF IS_PLAYER_IN_CAR player1 trojan_horse 
										IF final_meeting_place = 0
											DRAW_SPHERE -1037.4 172.3 10.0 3.0
										ELSE
											DRAW_SPHERE -1084.1 70.2 10.8 5.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDWHILE 
						PRINT_NOW ( CUB4_23 ) 5000 1 //You lost, man? 
						PLAY_MISSION_AUDIO 1
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
						AND NOT IS_CHAR_DEAD cuban_trojan1 
							WAIT 0
							IF NOT IS_CAR_DEAD trojan_horse 
								IF IS_CAR_MODEL trojan_horse voodoo
									IF IS_PLAYER_IN_CAR player1 trojan_horse 
										IF final_meeting_place = 0
											DRAW_SPHERE -1037.4 172.3 10.0 3.0
										ELSE
											DRAW_SPHERE -1084.1 70.2 10.8 5.0
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDWHILE
						CLEAR_MISSION_AUDIO 1
						CLEAR_THIS_PRINT CUB4_23 
						cub4_audio_flag5 = 1
					ENDIF
				ENDIF
				IF cub4_audio_flag6 = 0 
					IF IS_PLAYER_IN_ANY_CAR player1  
						IF IS_PLAYER_IN_AREA_2D player1 -1045.9 138.2 -1012.2 198.7 FALSE 
							LOAD_MISSION_AUDIO 1 CUB4_15
							WHILE NOT HAS_MISSION_AUDIO_LOADED 1
								WAIT 0
								IF NOT IS_CAR_DEAD trojan_horse 
									IF IS_CAR_MODEL trojan_horse voodoo
										IF IS_PLAYER_IN_CAR player1 trojan_horse 
											IF final_meeting_place = 0
												DRAW_SPHERE -1037.4 172.3 10.0 3.0
											ELSE
												DRAW_SPHERE -1084.1 70.2 10.8 5.0
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDWHILE 
							PRINT_NOW ( CUB4_22 ) 5000 1 //Whoah, man. You drive like a crazy bitch! 
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD cuban_trojan1 
								WAIT 0
								IF NOT IS_CAR_DEAD trojan_horse 
									IF IS_CAR_MODEL trojan_horse voodoo
										IF IS_PLAYER_IN_CAR player1 trojan_horse 
											IF final_meeting_place = 0
												DRAW_SPHERE -1037.4 172.3 10.0 3.0
											ELSE
												DRAW_SPHERE -1084.1 70.2 10.8 5.0
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT CUB4_22 
							cub4_audio_flag6 = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF



//failing mission objectives

IF IS_PLAYER_SHOOTING_IN_AREA player1 -1208.7 42.5 -1077.4 126.0 FALSE
	IF NOT IS_CHAR_DEAD haitian_doorman 
		SET_CHAR_OBJ_RUN_TO_COORD haitian_doorman -1170.9 87.6 
	ENDIF
	PRINT_NOW ( CUB4_04 ) 5000 1 //You've alerted the base, there is no way we will get in now!
	GOTO mission_failed_cuban4
ENDIF  

IF IS_CHAR_DEAD cuban_trojan2
OR IS_CHAR_DEAD cuban_trojan3
OR IS_CHAR_DEAD cuban_trojan4
OR IS_CHAR_DEAD cuban_trojan5
PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4
ENDIF



IF IS_CAR_DEAD trojan_horse2
OR IS_CAR_DEAD trojan_horse3
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4
ENDIF

IF IS_CHAR_DEAD haitian_doorman
	PRINT_NOW ( CUB4_04 ) 5000 1 //You've alerted the base, there is no way we will get in now!
	GOTO mission_failed_cuban4
ENDIF

GOTO meeting_second_car_loop 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////SECOND SET OF CUBANS MET////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////GOING THROUGH GATE//////////////////////////////////////////////////////////////////////////////
//getting player1 to follow other car up to entry gate

following_cubans_into_base:

PRINT_NOW ( CUB4_03 ) 5000 1 //Stay in the car until safely parked inside the compound.

IF NOT IS_CAR_DEAD trojan_horse2
	CAR_GOTO_COORDINATES_ACCURATE trojan_horse2 -1108.8 69.8 10.8
	SET_CAR_CRUISE_SPEED trojan_horse2 2.0
ENDIF

mini_trojan_loop:

WAIT 0

//waiting for lead car to reach gate

IF NOT IS_CAR_DEAD trojan_horse2
	IF LOCATE_CAR_2D trojan_horse2 -1108.8 69.8 3.0 3.0 FALSE
		GOTO haitian_opening_gate
	ENDIF
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4 
ENDIF 

//player1 must stay inside car

IF NOT IS_CAR_DEAD trojan_horse 			
	IF NOT IS_PLAYER_IN_CAR player1 trojan_horse
		PRINT_NOW ( CUB4_10 ) 5000 1 //You were told to stay in the car!  There is no way they will let us in now.
		GOTO mission_failed_cuban4
	ENDIF
ENDIF

//failing mission objectives

IF IS_PLAYER_SHOOTING_IN_AREA player1 -1208.7 42.5 -1077.4 126.0 FALSE
	IF NOT IS_CHAR_DEAD haitian_sniper
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS haitian_sniper player1
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_doorman 
		SET_CHAR_OBJ_RUN_TO_COORD haitian_doorman -1170.9 87.6 
	ENDIF
	PRINT_NOW ( CUB4_09 ) 5000 1 //You've alerted the base, there is no way we will get in now!
	GOTO mission_failed_cuban4
ENDIF  

IF IS_CHAR_DEAD haitian_doorman
	PRINT_NOW ( CUB4_09 ) 5000 1 //You've alerted the base, there is no way we will get in now!
	GOTO mission_failed_cuban4
ENDIF

IF IS_CHAR_DEAD cuban_trojan1  
OR IS_CAR_DEAD trojan_horse3
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4 
ENDIF 

GOTO mini_trojan_loop 



//waiting for haitian doorman to open the gate

haitian_opening_gate:

WAIT 0

//getting doorman to wave at lead van

IF door_flag = 0
	IF NOT IS_CHAR_DEAD haitian_doorman
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_doorman -1115.6 71.6 2.0 2.0 FALSE
			SET_CHAR_STAY_IN_SAME_PLACE	haitian_doorman FALSE
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT haitian_doorman -1115.6 71.6
		ELSE
			IF IS_CHAR_OBJECTIVE_PASSED haitian_doorman 
				SET_CHAR_STAY_IN_SAME_PLACE	haitian_doorman TRUE
		 		SET_CHAR_HEADING haitian_doorman 261.1
				SET_CHAR_WAIT_STATE haitian_doorman WAITSTATE_PLAYANIM_TAXI 1000
				LOAD_MISSION_AUDIO 1 CUB4_8
				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
					WAIT 0
				ENDWHILE 
				PRINT_NOW ( CUB4_15 ) 4000 1 //Ok, in you go...
				PLAY_MISSION_AUDIO 1
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				AND NOT IS_CHAR_DEAD haitian_doorman 
					WAIT 0
				ENDWHILE
				CLEAR_MISSION_AUDIO 1
				CLEAR_THIS_PRINT CUB4_15 
				door_flag = 1
			ENDIF
		ENDIF
	ELSE
		PRINT_NOW ( CUB4_09 ) 5000 1 //You've alerted the base, there is no way we will get in now!
		GOTO mission_failed_cuban4
	ENDIF
ENDIF

//getting doorman to open gate

IF door_flag = 1
	IF NOT IS_CHAR_DEAD haitian_doorman
		IF NOT LOCATE_CHAR_ON_FOOT_2D haitian_doorman -1116.8 74.3 2.0 2.0 FALSE
			SET_CHAR_STAY_IN_SAME_PLACE	haitian_doorman FALSE
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT haitian_doorman -1116.8 74.3
		ELSE
			IF IS_CHAR_OBJECTIVE_PASSED haitian_doorman 
				SET_CHAR_STAY_IN_SAME_PLACE	haitian_doorman TRUE
		 		SET_CHAR_HEADING haitian_doorman 234.8
				ADD_ONE_OFF_SOUND -1114.64 72.85 11.13 SOUND_POLICE_CELL_DOOR_CLUNK
				ADD_CONTINUOUS_SOUND -1114.64 72.85 11.13 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP gate_slide_loop 
				WHILE NOT SLIDE_OBJECT haitian_gate -1114.5 73.0 10.1 0.1 0.1 0.0 FALSE
					WAIT 0								 
				ENDWHILE
				REMOVE_SOUND gate_slide_loop
				door_flag = 2
			ENDIF
		ENDIF
	ELSE
		PRINT_NOW ( CUB4_09 ) 5000 1 //You've alerted the base, there is no way we will get in now!
		GOTO mission_failed_cuban4
	ENDIF
ENDIF

//getting lead van to make its way towards the base

IF NOT IS_CAR_DEAD trojan_horse2
	IF NOT IS_CAR_DEAD trojan_horse3 
		IF door_flag = 2
			CAR_GOTO_COORDINATES_ACCURATE trojan_horse2 -1126.1 70.5 10.8
			CAR_GOTO_COORDINATES_ACCURATE trojan_horse3 -1126.1 70.5 10.8
			GOTO the_hornets_nest 
		ENDIF
	ELSE
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
		GOTO mission_failed_cuban4
	ENDIF
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4
ENDIF
 

//failing mission objectives

IF IS_PLAYER_SHOOTING_IN_AREA player1 -1208.7 42.5 -1077.4 126.0 FALSE
	IF NOT IS_CHAR_DEAD haitian_sniper
		SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS haitian_sniper player1
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_doorman 
		SET_CHAR_OBJ_RUN_TO_COORD haitian_doorman -1170.9 87.6 
	ENDIF
	PRINT_NOW ( CUB4_09 ) 5000 1 //You've alerted the base, there is no way we will get in now!
	GOTO mission_failed_cuban4
ENDIF  

IF NOT IS_CAR_DEAD trojan_horse 			
	IF NOT IS_PLAYER_IN_CAR player1 trojan_horse
		PRINT_NOW ( CUB4_10 ) 5000 1 //You were told to stay in the car!  There is no way they will let us in now.
		GOTO mission_failed_cuban4
	ENDIF
ENDIF

IF IS_CHAR_DEAD cuban_trojan1
OR IS_CAR_DEAD trojan_horse3
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4
ENDIF

IF IS_CHAR_DEAD cuban_trojan2
OR IS_CHAR_DEAD cuban_trojan3
OR IS_CHAR_DEAD cuban_trojan4
OR IS_CHAR_DEAD cuban_trojan5
PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4
ENDIF

IF IS_CHAR_DEAD haitian_doorman
	PRINT_NOW ( CUB4_04 ) 5000 1 //You've alerted the base, there is no way we will get in now!
	GOTO mission_failed_cuban4
ENDIF

GOTO haitian_opening_gate 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////GATE PASSED/////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////DRIVING TO PARKING PLACE////////////////////////////////////////////////////////////////////////
//waiting for player1 to follow into centre of base

the_hornets_nest:

WAIT 0 

//engineers checking out generator outside court 

IF NOT IS_CAR_DEAD trojan_horse2
	IF LOCATE_CAR_2D trojan_horse2 -1126.1 70.5 3.0 3.0 FALSE 
		IF haitian_engineers_created = 0 
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1143.4 84.5 11.1 haitian_engineer3
			SET_CHAR_HEADING haitian_engineer3 190.2 
			GIVE_WEAPON_TO_CHAR haitian_engineer3 WEAPONTYPE_tec9 30000
			CLEAR_CHAR_THREAT_SEARCH haitian_engineer3
			SET_CHAR_PERSONALITY haitian_engineer3 PEDSTAT_TOUGH_GUY  
			SET_CHAR_HEED_THREATS haitian_engineer3 TRUE

			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1143.4 83.3 11.1 haitian_engineer4
			SET_CHAR_HEADING haitian_engineer4 190.2 
			GIVE_WEAPON_TO_CHAR haitian_engineer4 WEAPONTYPE_tec9 30000
			CLEAR_CHAR_THREAT_SEARCH haitian_engineer4
			SET_CHAR_PERSONALITY haitian_engineer4 PEDSTAT_TOUGH_GUY  
			SET_CHAR_HEED_THREATS haitian_engineer4 TRUE
			
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1168.2 106.7 10.1 hait_defender1
			SET_CHAR_HEADING hait_defender1 271.4 
			GIVE_WEAPON_TO_CHAR hait_defender1 WEAPONTYPE_tec9 30000
			CLEAR_CHAR_THREAT_SEARCH hait_defender1
			SET_CHAR_PERSONALITY hait_defender1 PEDSTAT_TOUGH_GUY  
			SET_CHAR_HEED_THREATS hait_defender1 TRUE
 
			CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1166.0 107.1 10.1 hait_defender2
			SET_CHAR_HEADING hait_defender2 92.5 
			GIVE_WEAPON_TO_CHAR hait_defender2 WEAPONTYPE_tec9 30000
			CLEAR_CHAR_THREAT_SEARCH hait_defender2
			SET_CHAR_PERSONALITY hait_defender2 PEDSTAT_TOUGH_GUY  
			SET_CHAR_HEED_THREATS hait_defender2 TRUE 
			
			SET_CHARS_CHATTING hait_defender1 hait_defender2 100000 

			haitian_engineers_created = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_engineer3
		IF NOT IS_CHAR_DEAD haitian_engineer4
			IF IS_CAR_IN_AREA_2D trojan_horse2 -1135.2 73.2 -1130.8 67.9 FALSE
				IF walking_engineers = 0
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT haitian_engineer3 -1141.5 73.5 
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT haitian_engineer4 -1141.5 64.3
					walking_engineers = 1
				ENDIF
			ENDIF
			IF LOCATE_CHAR_ANY_MEANS_2D haitian_engineer3 -1141.5 73.5 2.0 2.0 FALSE
				IF start_timerb = 0
					timerb = 0
					start_timerb = 1
				ENDIF
				IF IS_PLAYER_IN_AREA_2D player1 -1135.2 68.2 -1140.8 73.9 FALSE    
					IF waiving_engineer = 0
						SET_CHAR_WAIT_STATE haitian_engineer3 WAITSTATE_PLAYANIM_TAXI 800	
						timerb = 0
						waiving_engineer = 1
					ENDIF
				ENDIF
				IF timerb > 5000
					waiving_engineer = 1
				ENDIF
				IF waiving_engineer = 1
					IF walking_engineers = 1
						IF timerb > 800
							SET_CHAR_OBJ_GOTO_COORD_ON_FOOT haitian_engineer3 -1141.5 61.9
							walking_engineers = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
	

//getting doorman to wave at player1

IF waiving_flag = 0
	IF NOT IS_CAR_DEAD trojan_horse
		IF NOT IS_CHAR_DEAD haitian_doorman
			IF LOCATE_CAR_2D trojan_horse -1114.6 70.5 5.0 5.0 FALSE
				SET_CHAR_WAIT_STATE haitian_doorman WAITSTATE_PLAYANIM_TAXI 800
				waiving_flag = 1
				//andy_has_control = 0 //giving control back to game to work gate
			ENDIF
		ENDIF
	ELSE
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
		GOTO mission_failed_cuban4
	ENDIF
ENDIF
										   
//FUCKING CUNTING ARSEING HELL OF A PISH JOB TRYING TO GET TWO CARS TO GO TEN CUNTING YARDS (Chris, yes look bad words.  now get back to work :P )
IF NOT IS_CAR_DEAD trojan_horse 
	IF NOT IS_CAR_DEAD trojan_horse2 
		IF NOT IS_CAR_DEAD trojan_horse3 

			//1st car

			IF fake_car_node1 = 0
				IF NOT LOCATE_CAR_2D trojan_horse2 -1126.1 70.5 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse2 -1126.1 70.5 10.8
					SET_CAR_CRUISE_SPEED trojan_horse2 5.0
				ELSE
					fake_car_node1 = 1
				ENDIF
			ENDIF
			IF fake_car_node1 = 1
				IF NOT LOCATE_CAR_2D trojan_horse2 -1140.9 71.2 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse2 -1140.9 71.2 10.8
					SET_CAR_CRUISE_SPEED trojan_horse2 5.0
				ELSE
					fake_car_node1 = 2
				ENDIF
			ENDIF
			IF fake_car_node1 = 2
				IF NOT LOCATE_CAR_2D trojan_horse2 -1160.0 70.7 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse2 -1160.0 70.7 11.3
					SET_CAR_CRUISE_SPEED trojan_horse2 5.0
				ELSE
					fake_car_node1 = 3
				ENDIF
			ENDIF	
			IF fake_car_node1 = 3
				IF NOT LOCATE_CAR_2D trojan_horse2 -1180.2 92.9 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse2 -1180.2 92.9 11.3
					SET_CAR_CRUISE_SPEED trojan_horse2 20.0
				ELSE
					SET_CAR_TEMP_ACTION trojan_horse2 TEMPACT_HANDBRAKESTRAIGHT 10000 
					SET_CAR_CRUISE_SPEED trojan_horse2 0.0
					REMOVE_BLIP parking_place 
					ADD_BLIP_FOR_COORD -1181.2 83.8 11.3 parking_place
					PRINT_NOW ( CUB4_32 ) 5000 1 //Park the car at the blip and get out.
					fake_car_node1 = 4
				ENDIF
			ENDIF

			//2nd car
			
			IF fake_car_node2 = 0
				IF NOT LOCATE_CAR_2D trojan_horse3 -1126.1 70.5 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse3 -1126.1 70.5 10.8
					SET_CAR_CRUISE_SPEED trojan_horse3 5.0
				ELSE
					fake_car_node2 = 1
				ENDIF
			ENDIF
			IF fake_car_node2 = 1
				IF NOT LOCATE_CAR_2D trojan_horse3 -1140.9 71.2 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse3 -1140.9 71.2 10.8
					SET_CAR_CRUISE_SPEED trojan_horse3 5.0
				ELSE
					fake_car_node2 = 2
				ENDIF
			ENDIF
			IF fake_car_node2 = 2
				IF NOT LOCATE_CAR_2D trojan_horse3 -1160.0 70.7 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse3 -1160.0 70.7 10.8
					SET_CAR_CRUISE_SPEED trojan_horse3 5.0
				ELSE
					fake_car_node2 = 3
				ENDIF
			ENDIF	
			IF fake_car_node2 = 3
				IF NOT LOCATE_CAR_2D trojan_horse3 -1166.2 85.1 3.0 3.0 FALSE
					CAR_GOTO_COORDINATES_ACCURATE trojan_horse3 -1166.2 85.1 10.8
					SET_CAR_CRUISE_SPEED trojan_horse3 20.0
				ELSE
					SET_CAR_TEMP_ACTION trojan_horse3 TEMPACT_HANDBRAKETURNRIGHT 10000
					SET_CAR_CRUISE_SPEED trojan_horse3 0.0
					fake_car_node2 = 4
				ENDIF
			ENDIF
			
	//waiting for player1 to reach parking place

			IF fake_car_node1 = 4
				IF NOT LOCATE_CAR_3D trojan_horse -1181.2 83.8 11.3 5.0 5.0 5.0 TRUE
					fake_car_node1 = 4
				ELSE
					GOSUB set_up_for_laying_bombs
					GOTO trojan_horse_loop
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


//failing mission objectives

IF IS_CHAR_DEAD cuban_trojan1  
OR IS_CAR_DEAD trojan_horse2
OR IS_CAR_DEAD trojan_horse3
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4 
ENDIF 

IF IS_CHAR_DEAD cuban_trojan2
OR IS_CHAR_DEAD cuban_trojan3
OR IS_CHAR_DEAD cuban_trojan4
OR IS_CHAR_DEAD cuban_trojan5
PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban4
ENDIF

IF waiving_flag = 0
	IF IS_PLAYER_SHOOTING_IN_AREA player1 -1208.7 42.5 -1077.4 126.0 FALSE
		IF NOT IS_CHAR_DEAD haitian_sniper
			SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS haitian_sniper player1
		ENDIF
		IF NOT IS_CHAR_DEAD haitian_doorman 
			SET_CHAR_OBJ_RUN_TO_COORD haitian_doorman -1170.9 87.6 
		ENDIF
	ENDIF
ENDIF  

 
IF NOT IS_CAR_DEAD trojan_horse
	IF IS_PLAYER_IN_AREA_2D player1 -1158.0 61.1 -1199.6 109.2 FALSE  			
		IF NOT IS_PLAYER_IN_CAR player1 trojan_horse
			GOSUB set_up_for_laying_bombs
			GOTO trojan_horse_loop
		ENDIF
	ENDIF
ENDIF

GOTO the_hornets_nest 
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////PARKED UP AND READY TO ROCK AND ROLL////////////////////////////////////////////////////////////


ADD_BLIP_FOR_COORD -1187.2 103.0 10.1 bombplace1 
ADD_BLIP_FOR_COORD -1181.5 81.2 10.1 bombplace2
ADD_BLIP_FOR_COORD -1173.6 70.2 16.9 bombplace3



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////SETTING BOMBS UP////////////////////////////////////////////////////////////////////////////////
trojan_horse_loop:

WAIT 0

//Setting bombs


IF trojan_horse_goal = 0
	IF printy_flaggy = 0

		PRINT_NOW ( CUB4_29 ) 5000 1 //Walk into each of the markers to plant a bomb at that location.
		PRINT ( CUB4_02 ) 5000 1 //Go plant the bombs with a 45 second timer.
		PRINT ( CUB4_30 ) 5000 1 //After all three bombs are planted, get clear of the factory before it blows.
		printy_flaggy = 1
	ENDIF

	IF all_bombs_set = 3
		LOAD_MISSION_AUDIO 1 CUB4_10
		WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			WAIT 0
		ENDWHILE 
		PRINT_NOW ( CUB4_17 ) 5000 1 //RUN!!
		PRINT ( CUB4_31 ) 5000 1 //Get clear of the factory!!
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
		CLEAR_MISSION_AUDIO 1
		CLEAR_THIS_PRINT CUB4_17 
		IF NOT IS_CHAR_DEAD cuban_trojan2 
			SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan2 FALSE
			SET_PLAYER_AS_LEADER cuban_trojan2 player1
		ENDIF

		IF NOT IS_CHAR_DEAD cuban_trojan3 
			SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan3 FALSE
			SET_PLAYER_AS_LEADER cuban_trojan3 player1
		ENDIF
			
		IF NOT IS_CHAR_DEAD cuban_trojan4 
			SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan4 FALSE
			SET_PLAYER_AS_LEADER cuban_trojan4 player1
		ENDIF
					
		IF NOT IS_CHAR_DEAD cuban_trojan5 
			SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan5 FALSE
			SET_PLAYER_AS_LEADER cuban_trojan5 player1
		ENDIF
		
		trojan_horse_goal = 1
	ELSE	 		
		IF bomb1set = 0
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1187.2 103.0 10.1 1.0 1.0 2.0 TRUE	//strut as you go in 
				IF timer_reset1 = 0
					TIMERA = 0
					timer_reset1 = 1
				ENDIF
				lsd1:
				WAIT 0 
				IF TIMERA < 2100
					IF playonce = 0 
						SET_PLAYER_CONTROL player1 OFF
						SET_EVERYONE_IGNORE_PLAYER player1 TRUE
						SET_CHAR_HEADING scplayer 344.6
						SET_CAMERA_BEHIND_PLAYER
						SET_CHAR_WAIT_STATE scplayer WAITSTATE_BOMBER 2000
						playonce = 1
					ENDIF
					GOTO lsd1
				ELSE
					ADD_ONE_OFF_SOUND -1187.2 104.2 11.2 SOUND_IMRAN_ARM_BOMB
					
					CREATE_OBJECT dynamite -1187.2 104.2 11.2 dynamite1 
					SET_OBJECT_COLLISION dynamite1 FALSE
					SET_OBJECT_DYNAMIC dynamite1 FALSE

					
					SET_PLAYER_CONTROL player1 ON
					SET_EVERYONE_IGNORE_PLAYER player1 FALSE
					playonce = 0
					timer_reset1 = 0
					bomb1set = 1
					REMOVE_BLIP bombplace1
					all_bombs_set ++
				ENDIF
			ENDIF
		ENDIF

		IF bomb2set = 0 
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1180.2 81.2 10.1 1.0 1.0 2.0 TRUE  //strut in far left corner
				IF timer_reset1 = 0
					TIMERA = 0
					timer_reset1 = 1
				ENDIF
				lsd2:
				WAIT 0 
				IF TIMERA < 2100
					IF playonce = 0 
						SET_PLAYER_CONTROL player1 OFF
						SET_EVERYONE_IGNORE_PLAYER player1 TRUE
						SET_CHAR_HEADING scplayer 25.0  
						SET_CAMERA_BEHIND_PLAYER
						SET_CHAR_WAIT_STATE scplayer WAITSTATE_BOMBER 2000
						playonce = 1
					ENDIF
					GOTO lsd2
				ELSE
					ADD_ONE_OFF_SOUND -1181.5 82.1 11.2 SOUND_IMRAN_ARM_BOMB
				
					CREATE_OBJECT dynamite -1181.5 82.1 11.2 dynamite2 
					SET_OBJECT_COLLISION dynamite2 FALSE
					SET_OBJECT_DYNAMIC dynamite2 FALSE
				
					SET_PLAYER_CONTROL player1 ON
					SET_EVERYONE_IGNORE_PLAYER player1 FALSE
					playonce = 0
					timer_reset1 = 0
					bomb2set = 1
					REMOVE_BLIP bombplace2 
					all_bombs_set ++
				ENDIF
			ENDIF
		ENDIF

		IF bomb3set = 0 
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1173.6 70.2 16.9 1.0 1.0 2.0 TRUE //outside office upstairs
				IF timer_reset1 = 0
					TIMERA = 0
					timer_reset1 = 1
				ENDIF
				lsd3:
				WAIT 0 
				IF TIMERA < 2100
					IF playonce = 0 
						SET_PLAYER_CONTROL player1 OFF
						SET_EVERYONE_IGNORE_PLAYER player1 TRUE
						SET_CHAR_HEADING scplayer 7.5 
						SET_CAMERA_BEHIND_PLAYER
						SET_CHAR_WAIT_STATE scplayer WAITSTATE_BOMBER 2000
						playonce = 1
					ENDIF
					GOTO lsd3
				ELSE
					ADD_ONE_OFF_SOUND -1174.0 71.1 18.0 SOUND_IMRAN_ARM_BOMB
					
					CREATE_OBJECT dynamite -1174.0 71.1 18.0 dynamite3 
					SET_OBJECT_COLLISION dynamite3 FALSE
					SET_OBJECT_DYNAMIC dynamite3 FALSE
					
					SET_PLAYER_CONTROL player1 ON
					SET_EVERYONE_IGNORE_PLAYER player1 FALSE
					playonce = 0
					timer_reset1 = 0
					bomb3set = 1
					REMOVE_BLIP bombplace3 
					all_bombs_set ++
				ENDIF
			ENDIF
		ENDIF

		IF all_bombs_set = 1
			IF timerupyet = 0
				DISPLAY_ONSCREEN_TIMER bomb_timer TIMER_DOWN
				timerupyet = 1
			ENDIF
		ENDIF
	ENDIF

	IF setting_up_attackers = 0
		IF NOT IS_CAR_DEAD trojan_horse2 
			LOCK_CAR_DOORS trojan_horse2 CARLOCK_UNLOCKED
			SET_CAR_ONLY_DAMAGED_BY_PLAYER trojan_horse2 FALSE
			IF NOT IS_CHAR_DEAD cuban_trojan2 
				SET_CHAR_PERSONALITY cuban_trojan2 PEDSTAT_TOUGH_GUY  
				SET_CHAR_OBJ_LEAVE_CAR cuban_trojan2 trojan_horse2
				SET_CHAR_THREAT_SEARCH cuban_trojan2 THREAT_GANG_HAITIAN
				SET_CHAR_THREAT_SEARCH cuban_trojan2 THREAT_COP
				SET_CHAR_THREAT_SEARCH cuban_trojan2 THREAT_EMERGENCY
				SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan2 -1184.6 92.3 
			ENDIF
			IF NOT IS_CHAR_DEAD cuban_trojan3 
				SET_CHAR_PERSONALITY cuban_trojan3 PEDSTAT_TOUGH_GUY  
				SET_CHAR_OBJ_LEAVE_CAR cuban_trojan3 trojan_horse2
				SET_CHAR_THREAT_SEARCH cuban_trojan3 THREAT_GANG_HAITIAN
				SET_CHAR_THREAT_SEARCH cuban_trojan3 THREAT_COP
				SET_CHAR_THREAT_SEARCH cuban_trojan3 THREAT_EMERGENCY
				SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan3 -1184.9 100.2
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD trojan_horse3 
			LOCK_CAR_DOORS trojan_horse3 CARLOCK_UNLOCKED
			SET_CAR_ONLY_DAMAGED_BY_PLAYER trojan_horse3 FALSE
			IF NOT IS_CHAR_DEAD cuban_trojan4 
				SET_CHAR_PERSONALITY cuban_trojan4 PEDSTAT_TOUGH_GUY  
				SET_CHAR_OBJ_LEAVE_CAR cuban_trojan4 trojan_horse3
				SET_CHAR_THREAT_SEARCH cuban_trojan4 THREAT_GANG_HAITIAN
				SET_CHAR_THREAT_SEARCH cuban_trojan4 THREAT_COP
				SET_CHAR_THREAT_SEARCH cuban_trojan4 THREAT_EMERGENCY
				SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan4 -1157.7 73.5
			ENDIF
			IF NOT IS_CHAR_DEAD cuban_trojan5 
				SET_CHAR_PERSONALITY cuban_trojan5 PEDSTAT_TOUGH_GUY  
				SET_CHAR_OBJ_LEAVE_CAR cuban_trojan5 trojan_horse3
				SET_CHAR_THREAT_SEARCH cuban_trojan5 THREAT_GANG_HAITIAN
				SET_CHAR_THREAT_SEARCH cuban_trojan5 THREAT_COP
				SET_CHAR_THREAT_SEARCH cuban_trojan5 THREAT_EMERGENCY
				SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan5 -1157.5 69.5
			ENDIF
		ENDIF
		setting_up_attackers = 1
	ELSE
		IF NOT IS_CHAR_DEAD cuban_trojan2 
			IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_trojan2 -1184.6 92.3 1.0 1.0 FALSE
				SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan2 FALSE
		  		SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan2 -1184.6 92.3
		  	ELSE
				IF IS_CHAR_OBJECTIVE_PASSED cuban_trojan2
					SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan2 TRUE
					SET_CHAR_HEADING cuban_trojan2 256.8
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD cuban_trojan3 
			IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_trojan3 -1184.9 100.2 1.0 1.0 FALSE
				SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan3 FALSE
		  		SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan3 -1184.9 100.2
		  	ELSE
				IF IS_CHAR_OBJECTIVE_PASSED cuban_trojan3 
					SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan3 TRUE
					SET_CHAR_HEADING cuban_trojan3 257.4
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD cuban_trojan4 
			IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_trojan4 -1157.7 73.5 1.0 1.0 FALSE
				SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan4 FALSE
		  		SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan4 -1157.7 73.5
		  	ELSE
				IF IS_CHAR_OBJECTIVE_PASSED cuban_trojan4
					SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan4 TRUE
					SET_CHAR_HEADING cuban_trojan4 256.8
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD cuban_trojan5 
			IF NOT LOCATE_CHAR_ON_FOOT_2D cuban_trojan5 -1157.5 69.5 1.0 1.0 FALSE
				SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan5 FALSE
		  		SET_CHAR_OBJ_RUN_TO_COORD cuban_trojan5 -1157.5 69.5
		  	ELSE
				IF IS_CHAR_OBJECTIVE_PASSED cuban_trojan5 
					SET_CHAR_STAY_IN_SAME_PLACE	cuban_trojan5 TRUE
					SET_CHAR_HEADING cuban_trojan5 257.4
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

//what happens if timer runs out

IF timerupyet = 1
	IF bomb_timer = 0
		PRINT_NOW ( CUB4_06 ) 5000 1 //You failed to set all the bombs and we have had to abort the explosion.
		GOTO mission_failed_cuban4
	ENDIF
ENDIF  



//getting out of bomb area

IF trojan_horse_goal = 1
	IF IS_PLAYER_IN_AREA_2D player1 -1077.4 125.9 -1200.0 47.9 FALSE
		trojan_horse_goal = 1
	ELSE
// ******************************************START OF Final end to haitians CUTSCENE******************************


test_explosion:   /////test/////////////

CLEAR_AREA -1191.1 84.8 11.1 50.0 TRUE 

CLEAR_ONSCREEN_TIMER bomb_timer
IF NOT IS_CHAR_DEAD haitian_engineer3
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_engineer3
ENDIF
IF NOT IS_CHAR_DEAD haitian_engineer4
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_engineer4
ENDIF
IF NOT IS_CHAR_DEAD hait_defender1
	MARK_CHAR_AS_NO_LONGER_NEEDED hait_defender1
ENDIF
IF NOT IS_CHAR_DEAD hait_defender2
	MARK_CHAR_AS_NO_LONGER_NEEDED hait_defender2
ENDIF
IF NOT IS_CHAR_DEAD random_haitian1
	MARK_CHAR_AS_NO_LONGER_NEEDED random_haitian1
ENDIF
IF NOT IS_CHAR_DEAD random_haitian2
	MARK_CHAR_AS_NO_LONGER_NEEDED random_haitian2
ENDIF
IF NOT IS_CHAR_DEAD random_haitian3
	MARK_CHAR_AS_NO_LONGER_NEEDED random_haitian3
ENDIF
IF NOT IS_CAR_DEAD trojan_horse2
	MARK_CAR_AS_NO_LONGER_NEEDED trojan_horse2
ENDIF  

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1180.2 81.2 10.1 haitian_engineer3
SET_CHAR_HEADING haitian_engineer3 25.0 
SET_CHAR_WAIT_STATE haitian_engineer3 WAITSTATE_USE_ATM 999999

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1197.1 70.3 10.1 haitian_engineer4
SET_ANIM_GROUP_FOR_CHAR haitian_engineer4 ANIM_PANIC_CHUNKYPED
SET_CHAR_OBJ_RUN_TO_COORD haitian_engineer4 -1169.6 109.2 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1197.4 74.9 10.1 hait_defender1
SET_ANIM_GROUP_FOR_CHAR hait_defender1 ANIM_PANIC_CHUNKYPED
SET_CHAR_OBJ_RUN_TO_COORD hait_defender1 -1169.6 109.2 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1189.8 81.2 10.1 hait_defender2
SET_ANIM_GROUP_FOR_CHAR hait_defender2 ANIM_PANIC_CHUNKYPED
SET_CHAR_OBJ_RUN_TO_COORD hait_defender2 -1169.6 109.2 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1189.0 83.6 10.1 random_haitian1
SET_ANIM_GROUP_FOR_CHAR random_haitian1 ANIM_PANIC_CHUNKYPED
SET_CHAR_OBJ_RUN_TO_COORD random_haitian1 -1169.6 109.2 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1190.5 68.5 10.1 random_haitian2
SET_ANIM_GROUP_FOR_CHAR random_haitian2 ANIM_PANIC_CHUNKYPED
SET_CHAR_OBJ_RUN_TO_COORD random_haitian2 -1169.6 109.2 

CREATE_CAR voodoo -1166.2 85.1 9.8 trojan_horse2
SET_CAR_HEADING trojan_horse2 112.8


WAIT 1000

SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
SET_PLAYER_VISIBLE player1 FALSE

SET_FIXED_CAMERA_POSITION -1198.59 75.79 13.74 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1184.6 74.4 15.3 JUMP_CUT

REQUEST_MODEL buildblown // FIXMIAMI
REQUEST_MODEL hdrugfactorypol // FIXMIAMI
REQUEST_MODEL LODldblown // FIXMIAMI

WAIT 2000

//first two explosions in doorway and first strut
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET      //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1175.8 70.6 16.9 EXPLOSION_ROCKET	  //outside office upstairs
ADD_EXPLOSION -1175.8 70.6 16.9 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1175.8 70.6 16.9 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1175.8 70.6 16.9 EXPLOSION_HELI

SHAKE_CAM 900

WAIT 1000

SET_FIXED_CAMERA_POSITION -1196.61 68.74 18.19 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1187.74 83.15 14.59 JUMP_CUT

WAIT 500

ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in 
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

SHAKE_CAM 900

WAIT 1000
//
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in 
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_ROCKET	   //above strut in far left corner
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI

ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_ROCKET	   //above strut as you go in 
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI

SHAKE_CAM 900

WAIT 1000
//
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in 
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_ROCKET	   //above strut in far left corner
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI

SHAKE_CAM 300

WAIT 300

ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_ROCKET	   //above strut as you go in 
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_ROCKET	   //above far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_ROCKET	   //far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI

SHAKE_CAM 900

WAIT 1000
//
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in 
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_ROCKET	   //above strut in far left corner
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI

SHAKE_CAM 200

WAIT 200

ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_ROCKET	   //above strut as you go in 
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_ROCKET	   //above far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_ROCKET	   //far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI

SHAKE_CAM 100

WAIT 100

ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_ROCKET	   //above last remaining strut 
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_ROCKET	   //last remaining strut 
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI

SHAKE_CAM 1400

WAIT 1500
//
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in 
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

SHAKE_CAM 400

WAIT 400

ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_ROCKET	   //above strut in far left corner
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI

ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_ROCKET	   //above strut as you go in 
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_ROCKET	   //above far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_ROCKET	   //far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI

SHAKE_CAM 300

WAIT 300

ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_ROCKET	   //above last remaining strut 
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_ROCKET	   //last remaining strut 
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI


SHAKE_CAM 1400

WAIT 1500
//
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in 
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

SHAKE_CAM 200

WAIT 200

ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_ROCKET	   //above strut in far left corner
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI

ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_ROCKET	   //above strut as you go in 
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_ROCKET	   //above far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_ROCKET	   //far strut as you go in 
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI

SHAKE_CAM 100

WAIT 100

ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_ROCKET	   //above last remaining strut 
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_ROCKET	   //last remaining strut 
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI


SHAKE_CAM 900

WAIT 1000

//

SET_FIXED_CAMERA_POSITION -1159.03 108.49 15.35 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1180.11 90.65 16.05 JUMP_CUT

ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_ROCKET	   //strut in far left corner
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1182.8 76.7 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_ROCKET	   //strut as you go in
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.4 101.8 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_ROCKET	   //above strut in far left corner
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1181.4 76.8 17.3 EXPLOSION_HELI

ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE -1184.97 96.72 11.13 16.0 0.0 0.1 5.0 0 0 0 11000	
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE -1184.97 96.72 11.13 16.0 0.0 0.1 5.0 0 0 0 11000	
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE -1184.97 96.72 11.13 16.0 0.0 0.1 5.0 0 0 0 11000	
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE -1184.97 96.72 11.13 16.0 0.0 0.1 5.0 0 0 0 11000	
ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE -1184.97 96.72 11.13 16.0 0.0 0.1 5.0 0 0 0 11000	

SHAKE_CAM 600

WAIT 600

ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_ROCKET	   //above strut as you go in
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1187.69 102.0 17.2 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_ROCKET	   //above far strut as you go in
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_ROCKET	   //far strut as you go in
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1198.1 103.2 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_ROCKET	   //above last remaining strut
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_ROCKET	   //last remaining strut
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1189.7 83.6 10.1 EXPLOSION_HELI

SHAKE_CAM 200

WAIT 200

ADD_EXPLOSION -1197.0 89.5 17.1 EXPLOSION_ROCKET	   //last space
ADD_EXPLOSION -1197.0 89.5 17.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1197.0 89.5 17.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1197.0 89.5 17.1 EXPLOSION_HELI

ADD_EXPLOSION -1197.0 89.5 10.1 EXPLOSION_ROCKET	   //last space
ADD_EXPLOSION -1197.0 89.5 10.1 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1197.0 89.5 10.1 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1197.0 89.5 10.1 EXPLOSION_HELI

ADD_EXPLOSION -1196.61 68.74 18.19 EXPLOSION_ROCKET	   //in front of camera
ADD_EXPLOSION -1196.61 68.74 18.19 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1196.61 68.74 18.19 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1196.61 68.74 18.19 EXPLOSION_HELI

SHAKE_CAM 1000

WAIT 1000
//

ADD_EXPLOSION -1171.06 68.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 68.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 68.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 68.74 20.34 EXPLOSION_HELI

ADD_EXPLOSION -1171.06 74.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 74.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 74.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 74.74 20.34 EXPLOSION_HELI

SHAKE_CAM 100

WAIT 100

ADD_EXPLOSION -1171.06 79.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 79.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 79.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 79.74 20.34 EXPLOSION_HELI

ADD_EXPLOSION -1171.06 85.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 85.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 85.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 85.74 20.34 EXPLOSION_HELI

SHAKE_CAM 100

WAIT 100

ADD_EXPLOSION -1171.06 90.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 90.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 90.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 90.74 20.34 EXPLOSION_HELI

ADD_EXPLOSION -1171.06 96.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 96.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 96.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 96.74 20.34 EXPLOSION_HELI

SHAKE_CAM 100

WAIT 100

ADD_EXPLOSION -1171.06 103.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1171.06 103.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1171.06 103.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1171.06 103.74 20.34 EXPLOSION_HELI

ADD_EXPLOSION -1179.06 105.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1179.06 105.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1179.06 105.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1179.06 105.74 20.34 EXPLOSION_HELI

SHAKE_CAM 100

WAIT 100

ADD_EXPLOSION -1188.06 105.74 20.34 EXPLOSION_ROCKET	   //windows blowing out 
ADD_EXPLOSION -1188.06 105.74 20.34 EXPLOSION_HELI_BOMB  
ADD_EXPLOSION -1188.06 105.74 20.34 EXPLOSION_MOLOTOV
ADD_EXPLOSION -1188.06 105.74 20.34 EXPLOSION_HELI

IF NOT IS_CAR_DEAD trojan_horse2 
	IF NOT IS_PLAYER_IN_CAR player1 trojan_horse2
		SET_CAR_CAN_BE_DAMAGED trojan_horse2 TRUE
		EXPLODE_CAR trojan_horse2
	ENDIF
ENDIF

IF NOT IS_CAR_DEAD trojan_horse3
	IF NOT IS_PLAYER_IN_CAR player1 trojan_horse3
		SET_CAR_CAN_BE_DAMAGED trojan_horse3 TRUE
		EXPLODE_CAR trojan_horse3
	ENDIF
ENDIF

SET_FADING_COLOUR 255 255 255

DO_FADE 400 FADE_OUT
ADD_EXPLOSION -1159.03 108.49 10.35 EXPLOSION_HELI

WHILE GET_FADING_STATUS
OR NOT HAS_MODEL_LOADED buildblown // FIXMIAMI
OR NOT HAS_MODEL_LOADED hdrugfactorypol // FIXMIAMI
OR NOT HAS_MODEL_LOADED LODldblown // FIXMIAMI
	WAIT 0
ENDWHILE

IF NOT IS_PLAYER_DEAD player1
	SWAP_NEAREST_BUILDING_MODEL -1165.346 85.534 17.783 80.0 build1 buildblown
ENDIF

IF NOT IS_PLAYER_DEAD player1
	SWAP_NEAREST_BUILDING_MODEL -1165.346 85.534 17.783 80.0 hdrugfactoryint hdrugfactorypol
ENDIF

IF NOT IS_PLAYER_DEAD player1
	SWAP_NEAREST_BUILDING_MODEL -1165.346 85.534 17.783 80.0 LODld1 LODldblown
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED buildblown // FIXMIAMI
MARK_MODEL_AS_NO_LONGER_NEEDED hdrugfactorypol // FIXMIAMI
MARK_MODEL_AS_NO_LONGER_NEEDED LODldblown // FIXMIAMI

DELETE_OBJECT dynamite1
DELETE_OBJECT dynamite2
DELETE_OBJECT dynamite3

bomb_timer = 0

ADD_EXPLOSION -1159.03 108.49 10.35 EXPLOSION_HELI
DO_FADE 1600 FADE_IN



WAIT 5000

		GET_PLAYER_COORDINATES player1 player_x player_y player_z
		LOAD_SCENE player_x player_y player_z
// ******************************************END OF Final end to haitians CUTSCENE********************************
		GOTO mission_passed_cuban4
	ENDIF
ENDIF

//if player1 leaves before setting up the timers 
IF NOT all_bombs_set = 3		
	IF NOT IS_PLAYER_IN_AREA_2D player1 -1111.6 125.9 -1200.0 47.9 FALSE
		PRINT_NOW ( CUB4_06 ) 5000 1 //You failed to set all the bombs and we have had to abort the explosion.
		GOTO mission_failed_cuban4
	ENDIF
ENDIF 


GOTO trojan_horse_loop
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////MISSION PASSED//////////////////////////////////////////////////////////////////////////////////

// Mission failed
mission_failed_cuban4:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_cuban4:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 10000
PLAYER_MADE_PROGRESS 1 
//opening haitian gate
//andy_has_control = 1
WHILE NOT SLIDE_OBJECT haitian_gate -1114.5 73.0 10.1 10.0 10.0 0.0 FALSE
	WAIT 0								 
ENDWHILE
REGISTER_MISSION_PASSED CUB_4
REMOVE_BLIP cuban_contact_blip
SET_ZONE_PED_INFO GHETTO1 DAY   (13) 0 100 0 0 0 0 0 0 0 20 //Haitians
SET_ZONE_PED_INFO GHETTO1 NIGHT (10) 0 100 0 0 0 0 0 0 0 10
SET_ZONE_CAR_INFO GHETTO1 DAY   (12) 0 100 0 0 0 0 0 0 0 10 
SET_ZONE_CAR_INFO GHETTO1 NIGHT (10) 0 100 0 0 0 0 0 0 0 10
SET_ZONE_PED_INFO GHETTO2 DAY   (13) 100 0 0 0 0 0 0 0 0 20 //Cubans
SET_ZONE_PED_INFO GHETTO2 NIGHT (10) 100 0 0 0 0 0 0 0 0 10
SET_ZONE_CAR_INFO GHETTO2 DAY   (12) 100 0 0 0 0 0 0 0 0 10 
SET_ZONE_CAR_INFO GHETTO2 NIGHT (10) 100 0 0 0 0 0 0 0 0 10 
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_GANG_CUBAN
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_CUBAN THREAT_GANG_HAITIAN
IF bomb_timer = 0
	CREATE_PICKUP_WITH_AMMO minigun PICKUP_ON_STREET_SLOW 100 -1184.17 102.62 17.5 haitbase_pickup
	bomb_timer = 1
ENDIF
flag_cuban_mission4_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_cuban4:
flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
//andy_has_control = 0 //reseting gate
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_GANG_GOLFER 
MARK_MODEL_AS_NO_LONGER_NEEDED HNa
MARK_MODEL_AS_NO_LONGER_NEEDED HNb
MARK_MODEL_AS_NO_LONGER_NEEDED CBa
MARK_MODEL_AS_NO_LONGER_NEEDED CBb
MARK_MODEL_AS_NO_LONGER_NEEDED sniper
MARK_MODEL_AS_NO_LONGER_NEEDED tec9
MARK_MODEL_AS_NO_LONGER_NEEDED voodoo
MARK_MODEL_AS_NO_LONGER_NEEDED dynamite
CLEAR_ONSCREEN_TIMER bomb_timer
REMOVE_BLIP meetingplace1_blip
REMOVE_BLIP final_meeting_place_blip
REMOVE_BLIP radar_blip_cuban_trojan1
REMOVE_BLIP bombplace1 
REMOVE_BLIP bombplace2 
REMOVE_BLIP bombplace3 
REMOVE_BLIP parking_place
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN


///////////////////////////////////////////////////////////////////////////////////////////
set_up_for_laying_bombs:///////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
REMOVE_BLIP parking_place
GET_PLAYER_CHAR player1 scplayer
ADD_BLIP_FOR_COORD -1187.2 103.0 10.1 bombplace1 
ADD_BLIP_FOR_COORD -1180.2 81.2 10.1 bombplace2
ADD_BLIP_FOR_COORD -1173.6 70.2 16.9 bombplace3
IF NOT IS_CHAR_DEAD cuban_trojan1 
	SET_CHAR_THREAT_SEARCH cuban_trojan1 THREAT_GANG_HAITIAN
	SET_CHAR_THREAT_SEARCH cuban_trojan1 THREAT_COP
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban_trojan1 FALSE
ENDIF
IF NOT IS_CHAR_DEAD haitian_engineer3 
	SET_CHAR_THREAT_SEARCH haitian_engineer3 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_engineer3 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH haitian_engineer3 THREAT_COP
	SET_CHAR_HEADING haitian_engineer3 4.7 
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS haitian_engineer3 player1 
ENDIF
IF NOT IS_CHAR_DEAD haitian_engineer4 
	SET_CHAR_THREAT_SEARCH haitian_engineer4 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_engineer4 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH haitian_engineer4 THREAT_COP
	SET_CHAR_HEADING haitian_engineer4 4.7 
	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS haitian_engineer4 player1 
ENDIF
IF NOT IS_CHAR_DEAD hait_defender1 
	SET_CHAR_THREAT_SEARCH hait_defender1 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH hait_defender1 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH hait_defender1 THREAT_COP
	IF NOT IS_CHAR_DEAD hait_defender2  
		SET_CHARS_CHATTING hait_defender1 hait_defender2 100000
	ENDIF
ENDIF
IF NOT IS_CHAR_DEAD hait_defender2 
	SET_CHAR_THREAT_SEARCH hait_defender2 THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH hait_defender2 THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH hait_defender2 THREAT_COP
ENDIF
IF NOT IS_CHAR_DEAD haitian_doorman 
	SET_CHAR_THREAT_SEARCH haitian_doorman THREAT_GANG_CUBAN
	SET_CHAR_THREAT_SEARCH haitian_doorman THREAT_PLAYER1
	SET_CHAR_THREAT_SEARCH haitian_doorman THREAT_COP
	SET_CHAR_HEADING haitian_doorman 109.6 
	SET_CHAR_STAY_IN_SAME_PLACE haitian_doorman TRUE
ENDIF

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1115.2 67.0 10.1 haitian_doorman2
SET_CHAR_HEADING haitian_doorman2 85.4 
GIVE_WEAPON_TO_CHAR haitian_doorman2 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH haitian_doorman2
SET_CHAR_PERSONALITY haitian_doorman2 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH haitian_doorman2 THREAT_GANG_CUBAN										
SET_CHAR_THREAT_SEARCH haitian_doorman2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH haitian_doorman2 THREAT_COP
SET_CHAR_HEED_THREATS haitian_doorman2 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE haitian_doorman2 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1182.3 80.5 10.1 hait_defender3
SET_CHAR_HEADING hait_defender3 355.1 
GIVE_WEAPON_TO_CHAR hait_defender3 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH hait_defender3
SET_CHAR_PERSONALITY hait_defender3 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH hait_defender3 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH hait_defender3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH hait_defender3 THREAT_COP
SET_CHAR_HEED_THREATS hait_defender3 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE hait_defender3 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1192.2 102.7 10.1 hait_defender4
SET_CHAR_HEADING hait_defender4 109.6 
GIVE_WEAPON_TO_CHAR hait_defender4 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH hait_defender4
SET_CHAR_PERSONALITY hait_defender4 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH hait_defender4 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH hait_defender4 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH hait_defender4 THREAT_COP
SET_CHAR_HEED_THREATS hait_defender4 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE hait_defender4 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1183.4 67.0 16.9 hait_defender5
SET_CHAR_HEADING hait_defender5 12.0 
GIVE_WEAPON_TO_CHAR hait_defender5 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH hait_defender5
SET_CHAR_PERSONALITY hait_defender5 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH hait_defender5 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH hait_defender5 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH hait_defender5 THREAT_COP
SET_CHAR_HEED_THREATS hait_defender5 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE hait_defender5 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1197.9 82.5 10.1 random_haitian1
SET_CHAR_HEADING random_haitian1 347.0 
GIVE_WEAPON_TO_CHAR random_haitian1 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH random_haitian1
SET_CHAR_PERSONALITY random_haitian1 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH random_haitian1 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH random_haitian1 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH random_haitian1 THREAT_COP
SET_CHAR_HEED_THREATS random_haitian1 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE random_haitian1 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1189.0 83.6 10.1 random_haitian2
SET_CHAR_HEADING random_haitian2 20.0 
GIVE_WEAPON_TO_CHAR random_haitian2 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH random_haitian2
SET_CHAR_PERSONALITY random_haitian2 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH random_haitian2 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH random_haitian2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH random_haitian2 THREAT_COP
SET_CHAR_HEED_THREATS random_haitian2 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE random_haitian2 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -1190.5 68.5 10.1 random_haitian3
SET_CHAR_HEADING random_haitian3 13.8 
GIVE_WEAPON_TO_CHAR random_haitian3 WEAPONTYPE_tec9 30000
CLEAR_CHAR_THREAT_SEARCH random_haitian3
SET_CHAR_PERSONALITY random_haitian3 PEDSTAT_TOUGH_GUY  
SET_CHAR_THREAT_SEARCH random_haitian3 THREAT_GANG_CUBAN
SET_CHAR_THREAT_SEARCH random_haitian3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH random_haitian3 THREAT_COP
SET_CHAR_HEED_THREATS random_haitian3 TRUE 
SET_CHAR_STAY_IN_SAME_PLACE random_haitian3 TRUE

IF NOT IS_CAR_DEAD trojan_horse2 
	SET_CAR_ONLY_DAMAGED_BY_PLAYER trojan_horse2 TRUE
ENDIF
IF NOT IS_CAR_DEAD trojan_horse3 
	SET_CAR_ONLY_DAMAGED_BY_PLAYER trojan_horse3 TRUE
ENDIF
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_GANG_GOLFER

LOAD_MISSION_AUDIO 1 CUB4_9
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE 
PRINT_NOW ( CUB4_16 ) 4000 1 //I'm going to plant the bomb, cover me!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB4_16 
//closing gate
WHILE NOT SLIDE_OBJECT haitian_gate -1114.5 67.0 10.1 10.0 10.0 0.0 FALSE
	WAIT 0
ENDWHILE
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
}
