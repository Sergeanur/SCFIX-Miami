MISSION_START
// *****************************************************************************************
// *****************************************Cuban 3*****************************************
// *****************************************NAVAL ENGAGEMENT********************************
// **********************haitains attacking coke deals on boats*****************************
// **********************go to deal kill haitians on boat then chase other haitians boats***
// *****************************************************************************************
SCRIPT_NAME cuban3
// Mission start stuff
GOSUB mission_start_cuban3
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_cuban3
ENDIF
GOSUB mission_cleanup_cuban3
MISSION_END
{ 
// Variables for mission
//people, cars and objects
VAR_INT playrs_boat 
VAR_INT boat_driver
VAR_INT haitian_big_boat1
VAR_INT haitian_big_boat2
VAR_INT haitian_ob1
VAR_INT haitian_ob2
VAR_INT haitian_ob3
VAR_INT haitian_ob4
VAR_INT haitian_ob5
VAR_INT haitian_ob6
VAR_INT haitian_with_money
VAR_INT drug_dealer
VAR_INT drug_dealer_bodyguard1
VAR_INT drug_dealer_bodyguard2											
VAR_INT drug_dealer_sniper
VAR_INT drug_dealer_backup1
VAR_INT drug_dealer_backup2
VAR_INT drug_dealer_backup3
VAR_INT drug_dealer_backup4
VAR_INT drug_dealer_backup5
VAR_INT haitian_bodyguard1
VAR_INT haitian_bodyguard2
VAR_INT dropped_money
VAR_INT briefcase_dropped_1
VAR_INT briefcase_dropped_2
VAR_INT haitian_dinghy
VAR_INT drug_dealer_with_briefcases
VAR_INT dummy_dude

//blips
VAR_INT radar_blip_playrs_boat
VAR_INT dropped_money_blip
VAR_INT briefcase_dropped_1_blip
VAR_INT briefcase_dropped_2_blip
VAR_INT cuban_base

//flags
VAR_INT boat_location 
VAR_INT drug_dealer_flag
VAR_INT dropped_money_flag
VAR_INT briefcase_dropped_flag 
VAR_INT drug_dealer_bodyguard1_flag 
VAR_INT drug_dealer_bodyguard2_flag 
VAR_INT cub3_speech_played
VAR_INT boat_haitians_dead
VAR_INT haitian_death_ob1
VAR_INT haitian_death_ob2
VAR_INT haitian_death_ob3
VAR_INT haitian_death_ob4
VAR_INT haitian_death_ob5
VAR_INT haitian_death_ob6
VAR_INT haitian_moving_ob3
VAR_INT haitian_moving_ob5
VAR_INT haitian_moving_ob6

//coordinates 
VAR_FLOAT leader_coordsx 
VAR_FLOAT leader_coordsy 
VAR_FLOAT leader_coordsz
VAR_FLOAT hait3_coordx
VAR_FLOAT hait3_coordy
VAR_FLOAT hait5_coordx
VAR_FLOAT hait5_coordy
VAR_FLOAT hait6_coordx
VAR_FLOAT hait6_coordy
// ****************************************Mission Start************************************
mission_start_cuban3:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT CUBAN3
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1173.5 -599.6 10.2 277.1
// *****************************************Set Flags/variables************************************
boat_location = 0
drug_dealer_flag = 0
dropped_money_flag = 0
briefcase_dropped_flag = 0
drug_dealer_bodyguard1_flag = 0
drug_dealer_bodyguard2_flag = 0
button_pressed = 0
cub3_speech_played = 0
boat_haitians_dead = 6
haitian_death_ob1 = 0
haitian_death_ob2 = 0
haitian_death_ob3 = 0
haitian_death_ob4 = 0
haitian_death_ob5 = 0
haitian_death_ob6 = 0
haitian_moving_ob3 = 0
haitian_moving_ob5 = 0
haitian_moving_ob6 = 0


leader_coordsx = 0.0 
leader_coordsy = 0.0 
leader_coordsz = 0.0
player_x = 0.0 
player_y = 0.0 
player_z = 0.0
hait3_coordx = 0.0
hait3_coordy = 0.0
hait5_coordx = 0.0
hait5_coordy = 0.0
hait6_coordx = 0.0
hait6_coordy = 0.0

// ****************************************START OF CUTSCENE********************************
SET_AREA_VISIBLE VIS_COFFEE_SHOP
DISABLE_CUTSCENE_SHADOWS
CLEAR_AREA_OF_CHARS -1174.8 -609.0 10.4 -116.3 -632.5 15.3
SET_CAR_DENSITY_MULTIPLIER 0.0
SET_PED_DENSITY_MULTIPLIER 0.0

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSpablo
LOAD_SPECIAL_CHARACTER 3 CSpapa
LOAD_SPECIAL_CHARACTER 4 CSpepe
LOAD_SPECIAL_CHARACTER 5 CSumbto

LOAD_SCENE -1169.0 -620.0 10.791

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0
ENDWHILE

LOAD_CUTSCENE cub_4
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

CLEAR_AREA -1170.9 -603.7 10.6 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1170.9 -603.7 10.6
SET_PLAYER_HEADING player1 15.3 

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 876  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW CUB3_A 10000 1 // Alberto? Une caffee, senor?

WHILE cs_time < 2635
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_B 10000 1 // Poppa, don't serve this snake in the straw.  

WHILE cs_time < 5749
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_C 10000 1 // You're two-faced Tommy!

WHILE cs_time < 7227
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_D 10000 1 // You either two-faced, or you a wimp, baby boy!

WHILE cs_time < 10024
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_E 10000 1 // The Haitians! Man, they laughing at me.

WHILE cs_time < 12109
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_F 10000 1 // Easy, easy. What's the problem?

WHILE cs_time < 13963
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_G 10000 1 // They laughing at me, Tommy. At me!

WHILE cs_time < 16044
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_H 10000 1 // Umberto Robina! They doing whatever they like!

WHILE cs_time < 18802
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_I 10000 1 //Nobody does whatever they like, Umberto, they do what you let them do.

WHILE cs_time < 21689
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_J 10000 1 //What?

WHILE cs_time < 23629
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_K 10000 1 //You want somebody taken care of?

WHILE cs_time < 24851
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_L 10000 1 //I can handle it, but it's gonna cost you.

WHILE cs_time < 26958
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_M 10000 1 //I know we're brothers and all, but this is a business.

WHILE cs_time < 29060
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_N 10000 1 //Tommy. You are real man. A business man, a gentleman.

WHILE cs_time < 33831
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_O 10000 1 //These Haitians.  They have a load of product coming in off shore, really good stuff.

WHILE cs_time < 39459
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_P 10000 1 // We take it, and we finish them. 

WHILE cs_time < 42056
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_Q 10000 1 // You take it, and I look after you. Like my brother. Like my son.

WHILE cs_time < 47769
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW CUB3_R 10000 1 // I think I prefer the cash to being bounced on your knee amigo

/* 
WHILE cs_time < 48769
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS
*/
WHILE cs_time < 51904
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
SET_AREA_VISIBLE VIS_MAIN_MAP
flag_player_in_cafe = 0
SET_CAR_DENSITY_MULTIPLIER 1.0
SET_PED_DENSITY_MULTIPLIER 1.0
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_CAMERA_BEHIND_PLAYER
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

flag_is_on_cuban_mission = 1 // SCFIX
SET_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1

REQUEST_MODEL tropic
REQUEST_MODEL HNa
REQUEST_MODEL HNb
REQUEST_MODEL jetmax

REQUEST_MODEL uzi
REQUEST_MODEL SGa
REQUEST_MODEL grenade
REQUEST_MODEL dinghy

REQUEST_MODEL SGb
REQUEST_MODEL CBb
REQUEST_MODEL briefcase
REQUEST_MODEL ruger
REQUEST_MODEL buddyshot


WHILE NOT HAS_MODEL_LOADED tropic 
OR NOT HAS_MODEL_LOADED HNa
OR NOT HAS_MODEL_LOADED HNb
OR NOT HAS_MODEL_LOADED jetmax
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED SGa
OR NOT HAS_MODEL_LOADED uzi
OR NOT HAS_MODEL_LOADED grenade
OR NOT HAS_MODEL_LOADED dinghy
	WAIT 0 
ENDWHILE

WHILE NOT HAS_MODEL_LOADED SGb
OR NOT HAS_MODEL_LOADED CBb
OR NOT HAS_MODEL_LOADED briefcase
OR NOT HAS_MODEL_LOADED ruger
OR NOT HAS_MODEL_LOADED buddyshot
	WAIT 0 
ENDWHILE

LOAD_MISSION_AUDIO 1 CUB3_2
LOAD_MISSION_AUDIO 2 CUB3_3

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 


//SET_PLAYER_COORDINATES player1 -731.7 -1170.4 19.4   //test

//creating boat and waiting for player to reach it 
ADD_BLIP_FOR_COORD -725.4 -1166.8 9.7 radar_blip_playrs_boat

CREATE_CHAR PEDTYPE_GANG_CUBAN CBb -724.3 -1166.5 9.7 boat_driver 
SET_CHAR_AS_PLAYER_FRIEND boat_driver player1 TRUE
SET_CHAR_HEADING boat_driver 103.3 

DO_FADE 1500 FADE_IN

PRINT_NOW ( CUB3_07 ) 11000 1 //Go meet Rico.  He'll drive you to the meet location.

//getting into boat and setting boat to drive to deal

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -725.4 -1166.8 9.7 1.0 1.0 2.0 TRUE
	WAIT 0 
	IF IS_CHAR_DEAD boat_driver 
		PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
		GOTO mission_failed_cuban3
	ENDIF
ENDWHILE 

// ******************************************START OF PLAYER GETTING INTO BOAT*******************************************
CLEAR_AREA -725.4 -1166.8 9.7 5.0 1 
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_RADIO_CHANNEL RADIO_ESPANTOSO -1
CREATE_CAR jetmax -722.6 -1163.7 5.0 playrs_boat
SET_CAR_HEADING playrs_boat 32.0
ANCHOR_BOAT playrs_boat TRUE

SET_FIXED_CAMERA_POSITION -723.1 -1169.5 10.2 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -726.4 -1164.6 11.2 JUMP_CUT

IF NOT IS_CHAR_DEAD boat_driver
	SET_CHAR_OBJ_NO_OBJ scplayer
	TURN_CHAR_TO_FACE_CHAR scplayer boat_driver 
	TURN_CHAR_TO_FACE_PLAYER boat_driver player1  	
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

WAIT 1000

SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 10000

PRINT_NOW CUB3_01 4000 1//Hey Rico. Nice boat, you ready?
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
AND NOT IS_CHAR_DEAD boat_driver  
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_cub3_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT CUB3_01 

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
IF NOT IS_CHAR_DEAD boat_driver 
	SET_CHAR_WAIT_STATE boat_driver WAITSTATE_PLAYANIM_CHAT 10000
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

PRINT_NOW CUB3_05 4000 1//Si Tommy. Now you be a good shot today,
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD boat_driver  
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_cub3_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB3_05 

SET_FIXED_CAMERA_POSITION -709.8 -1161.3 11.0 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -724.3 -1166.5 9.7 JUMP_CUT

LOAD_MISSION_AUDIO 2 CUB3_4

WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

PRINT_NOW CUB3_06 4000 1//My boat, she no good full of holes, ok?
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
AND NOT IS_CHAR_DEAD boat_driver  
	WAIT 0
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO end_cut_cub3_1
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
CLEAR_MISSION_AUDIO 2
CLEAR_THIS_PRINT CUB3_06 

IF NOT IS_CHAR_DEAD boat_driver 
	SET_CHAR_WAIT_STATE boat_driver WAITSTATE_FALSE 100
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

end_cut_cub3_1:
CLEAR_MISSION_AUDIO 1
CLEAR_MISSION_AUDIO 2
CLEAR_SMALL_PRINTS
IF NOT IS_CHAR_DEAD boat_driver 
	SET_CHAR_WAIT_STATE boat_driver WAITSTATE_FALSE 100
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF
SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 100
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
// ******************************************END OF PLAYER GETTING INTO BOAT*********************************************

//FADE OUT 
SET_FADING_COLOUR 1 1 1
DO_FADE 1500 FADE_OUT
IF NOT HAS_PLAYER_GOT_WEAPON player1 WEAPONTYPE_M4
AND NOT HAS_PLAYER_GOT_WEAPON player1 WEAPONTYPE_SNIPERRIFLE 
AND NOT HAS_PLAYER_GOT_WEAPON player1 WEAPONTYPE_LASERSCOPE 
	GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_RUGER 30
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

DELETE_CHAR boat_driver 
IF NOT IS_CAR_DEAD playrs_boat
	ATTACH_CHAR_TO_CAR scplayer playrs_boat 0.0 -0.4 1.5 FACING_BACK 360.0 WEAPONTYPE_UNARMED
	CREATE_CHAR_INSIDE_CAR playrs_boat PEDTYPE_GANG_CUBAN CBb boat_driver  
	SET_CHAR_AS_PLAYER_FRIEND boat_driver player1 TRUE
	BOAT_GOTO_COORDS playrs_boat -754.0 -425.7 6.6
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER boat_driver TRUE 
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF
REMOVE_BLIP radar_blip_playrs_boat


//CREATING HAITIANS ON BOATS
//Boat 2
CREATE_CAR tropic -660.0 -269.1 5.0 haitian_big_boat2 //RIGHT BOAT when looking at deal from players boat
SET_CAR_HEADING haitian_big_boat2 134.0
ANCHOR_BOAT haitian_big_boat2 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -647.0 -256.7 5.0 haitian_ob4 
ATTACH_CHAR_TO_CAR haitian_ob4 haitian_big_boat2 0.0 -4.0 1.2 FACING_LEFT 360.0 WEAPONTYPE_UZI  //ON LOWER DECK OF RIGHT BOAT
SET_CHAR_HEADING haitian_ob4 227.4 
CLEAR_CHAR_THREAT_SEARCH haitian_ob4
SET_CHAR_PERSONALITY haitian_ob4 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_ob4 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -647.0 -256.7 5.0 haitian_ob5 
//ATTACH_CHAR_TO_CAR haitian_ob5 haitian_big_boat2 0.5 2.5 3.8 FACING_BACK 360.0 WEAPONTYPE_uzi  //RIGHT HAND DRIVERS SEAT 
ATTACH_CHAR_TO_CAR haitian_ob5 haitian_big_boat2 2.3 0.0 2.0 FACING_BACK 360.0 WEAPONTYPE_UZI  //ON LOWER DECK OF RIGHT BOAT (side)
SET_CHAR_HEADING haitian_ob5 140.4 
CLEAR_CHAR_THREAT_SEARCH haitian_ob5
SET_CHAR_PERSONALITY haitian_ob5 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_ob5 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -647.0 -256.7 5.0 haitian_ob6 
//ATTACH_CHAR_TO_CAR haitian_ob6 haitian_big_boat2 -0.3 2.5 3.8 FACING_BACK 360.0 WEAPONTYPE_uzi  //LEFT HAND DRIVERS SEAT
ATTACH_CHAR_TO_CAR haitian_ob6 haitian_big_boat2 0.0 -1.3 3.8 FACING_BACK 360.0 WEAPONTYPE_RUGER  //ON UPPER DECK OF RIGHT BOAT
SET_CHAR_HEADING haitian_ob6 140.4 
CLEAR_CHAR_THREAT_SEARCH haitian_ob6
SET_CHAR_PERSONALITY haitian_ob6 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_ob6 TRUE




//Boat 1
CREATE_CAR tropic -647.0 -256.7 5.0 haitian_big_boat1 //LEFT BOAT when looking at deal from players boat
SET_CAR_HEADING haitian_big_boat1 317.0
ANCHOR_BOAT haitian_big_boat1 TRUE
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -647.0 -256.7 5.0 haitian_ob1 
ATTACH_CHAR_TO_CAR haitian_ob1 haitian_big_boat1 0.0 -4.0 1.2 FACING_FORWARD 360.0 WEAPONTYPE_UZI  //ON LOWER DECK OF LEFT BOAT
SET_CHAR_HEADING haitian_ob1 102.4 
CLEAR_CHAR_THREAT_SEARCH haitian_ob1
SET_CHAR_PERSONALITY haitian_ob1 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_ob1 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -647.0 -256.7 5.0 haitian_ob2 
ATTACH_CHAR_TO_CAR haitian_ob2 haitian_big_boat1 -2.3 0.0 2.0 FACING_RIGHT 360.0 WEAPONTYPE_RUGER  //ON LOWER DECK OF LEFT BOAT (side)
CLEAR_CHAR_THREAT_SEARCH haitian_ob2
SET_CHAR_PERSONALITY haitian_ob2 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_ob2 TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -647.0 -256.7 5.0 haitian_ob3 
//ATTACH_CHAR_TO_CAR haitian_ob3 haitian_big_boat1 -0.3 2.5 3.8 FACING_RIGHT 360.0 WEAPONTYPE_uzi  //DRIVERS SEAT
ATTACH_CHAR_TO_CAR haitian_ob3 haitian_big_boat1 0.2 -1.3 3.8 FACING_RIGHT 360.0 WEAPONTYPE_UZI  //ON UPPER DECK OF LEFT BOAT
SET_CHAR_HEADING haitian_ob3 322.4 
CLEAR_CHAR_THREAT_SEARCH haitian_ob3
SET_CHAR_PERSONALITY haitian_ob3 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_ob3 TRUE








//HAITIAN WITH MONEY
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNb -649.9 -269.6 8.5 haitian_with_money 
SET_CHAR_HEADING haitian_with_money 229.2  
CLEAR_CHAR_THREAT_SEARCH haitian_with_money
SET_CHAR_PERSONALITY haitian_with_money PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_with_money TRUE
SET_CHAR_STAY_IN_SAME_PLACE haitian_with_money TRUE

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -650.1 -267.7 8.5 haitian_bodyguard1 
SET_CHAR_HEADING haitian_bodyguard1 60.6  
CLEAR_CHAR_THREAT_SEARCH haitian_bodyguard1
SET_CHAR_PERSONALITY haitian_bodyguard1 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_bodyguard1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE haitian_bodyguard1 TRUE
	
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -651.6 -269.0 8.5 haitian_bodyguard2 
SET_CHAR_HEADING haitian_bodyguard2 222.9  
CLEAR_CHAR_THREAT_SEARCH haitian_bodyguard2
SET_CHAR_PERSONALITY haitian_bodyguard2 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS haitian_bodyguard2 TRUE
SET_CHAR_STAY_IN_SAME_PLACE haitian_bodyguard2 TRUE

//CREATING DRUG DEALERS
CREATE_CHAR PEDTYPE_GANG_STREET SGb -648.8 -270.8 8.5 drug_dealer 
SET_CHAR_HEADING drug_dealer 49.2  
CLEAR_CHAR_THREAT_SEARCH drug_dealer
SET_CHAR_PERSONALITY drug_dealer PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS drug_dealer TRUE
SET_CHAR_STAY_IN_SAME_PLACE drug_dealer TRUE

CREATE_CHAR PEDTYPE_GANG_STREET SGa -647.4 -270.8 8.5 drug_dealer_bodyguard1  //left looking at guy 
SET_CHAR_HEADING drug_dealer_bodyguard1 34.2  
CLEAR_CHAR_THREAT_SEARCH drug_dealer_bodyguard1
SET_CHAR_PERSONALITY drug_dealer_bodyguard1 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS drug_dealer_bodyguard1 TRUE
SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_bodyguard1 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET SGa -649.3 -272.5 8.5 drug_dealer_bodyguard2 //right looking at guy 
SET_CHAR_HEADING drug_dealer_bodyguard2 33.0  
CLEAR_CHAR_THREAT_SEARCH drug_dealer_bodyguard2
SET_CHAR_PERSONALITY drug_dealer_bodyguard2 PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS drug_dealer_bodyguard2 TRUE
SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_bodyguard2 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET SGa -621.9 -307.8 25.9 drug_dealer_sniper 
SET_CHAR_HEADING drug_dealer_sniper 35.4  
CLEAR_CHAR_THREAT_SEARCH drug_dealer_sniper
SET_CHAR_PERSONALITY drug_dealer_sniper PEDSTAT_TOUGH_GUY  
SET_CHAR_HEED_THREATS drug_dealer_sniper TRUE
SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_sniper TRUE

SET_CHARS_CHATTING haitian_with_money drug_dealer 5000000 

//Jumping car forwards

SET_CAR_COORDINATES playrs_boat -754.0 -425.7 5.5

//FADE IN
DO_FADE 1500 FADE_IN




// ******************************************START OF PLAYER PULLING UP TO BATTLE****************************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -743.5 -318.2 11.0 0.0 0.0 0.0 

POINT_CAMERA_AT_CAR playrs_boat FIXED JUMP_CUT
timera = 0

////////////////////////////////////////////////////////THE SET UP//////////////////////////////////////////////////////////////////////////////
waiting_for_boat_to_reach_destination:
WAIT 0

CLEAR_AREA_OF_CARS -530.2 -186.3 10.0 -791.8 -447.8 0.0

IF NOT IS_CAR_DEAD playrs_boat
	
	IF boat_location = 0 
		IF LOCATE_CAR_2D playrs_boat -754.0 -425.7 10.0 10.0 FALSE
			SET_BOAT_CRUISE_SPEED playrs_boat 20.0
		ENDIF
		IF LOCATE_CAR_2D playrs_boat -754.0 -425.7 5.0 5.0 FALSE
			BOAT_GOTO_COORDS playrs_boat -705.8 -304.5 6.6
			boat_location = 1
		ENDIF
	ENDIF
	IF boat_location = 1 
		IF LOCATE_CAR_2D playrs_boat -705.8 -304.5 10.0 10.0 FALSE
			SET_BOAT_CRUISE_SPEED playrs_boat 12.0
		ENDIF
		IF LOCATE_CAR_2D playrs_boat -705.8 -304.5 5.0 5.0 FALSE
			IF NOT IS_CAR_DEAD haitian_big_boat2
				SET_FIXED_CAMERA_POSITION -645.2 -269.7 11.0 0.0 0.0 0.0 
				POINT_CAMERA_AT_POINT -650.9 -269.9 9.2 JUMP_CUT
			ENDIF
			BOAT_GOTO_COORDS playrs_boat -670.8 -263.8 6.6
			boat_location = 2
		ENDIF
	ENDIF
	IF boat_location = 2 
		IF LOCATE_CAR_2D playrs_boat -670.8 -263.8 10.0 10.0 FALSE
			BOAT_GOTO_COORDS playrs_boat -666.3 -258.5 6.6
			boat_location = 3
		ENDIF
	ENDIF
	IF boat_location = 3 
		IF LOCATE_CAR_2D playrs_boat -666.3 -258.5 10.0 10.0 FALSE
			BOAT_STOP playrs_boat
			ANCHOR_BOAT playrs_boat TRUE
			boat_location = 4
		ENDIF
	ENDIF
	IF boat_location = 4
		IF LOCATE_CAR_2D playrs_boat -666.3 -258.5 2.0 2.0 FALSE
			BOAT_STOP playrs_boat
			ANCHOR_BOAT playrs_boat TRUE
			DETACH_CHAR_FROM_CAR scplayer

			RESTORE_CAMERA_JUMPCUT
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
			GET_OFFSET_FROM_CAR_IN_WORLD_COORDS playrs_boat 0.0 -0.4 1.1 player_x player_y player_z 
			SET_PLAYER_COORDINATES player1 player_x player_y 6.6
			SET_PLAYER_HEADING player1 213.7
			WAIT 0
			SET_CAMERA_BEHIND_PLAYER
			PRINT_NOW ( CUB3_02 ) 5000 1 //KILL ALL THE HAITIANS ON THE BOATS!!  
			GOTO waiting_for_player_to_shoot
		ENDIF
	ENDIF  
ENDIF  



//mission fails if boat dies when player is on it.  Gonna blow player up too
IF IS_CAR_DEAD playrs_boat
OR IS_CHAR_DEAD boat_driver 
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

GOTO waiting_for_boat_to_reach_destination 
// ******************************************END OF PLAYER PULLING UP TO BATTLE******************************************


//Once player is into position, set everyone to kill everyone else and remaining druggies to leg it.  Remaining Haitians should kill player
waiting_for_player_to_shoot:
WAIT 0

CLEAR_AREA_OF_CARS -530.2 -186.3 10.0 -791.8 -447.8 0.0

IF IS_PLAYER_SHOOTING player1

	SET_THREAT_REACTION_RANGE_MULTIPLIER 5.0
	IF NOT IS_CHAR_DEAD drug_dealer
		SET_CHAR_THREAT_SEARCH drug_dealer THREAT_GANG_HAITIAN
		GIVE_WEAPON_TO_CHAR drug_dealer WEAPONTYPE_RUGER 30000
	ENDIF
	IF NOT IS_CHAR_DEAD drug_dealer_bodyguard1
		SET_CHAR_THREAT_SEARCH drug_dealer_bodyguard1 THREAT_GANG_HAITIAN
		GIVE_WEAPON_TO_CHAR drug_dealer_bodyguard1 WEAPONTYPE_RUGER 30000
	ENDIF
	IF NOT IS_CHAR_DEAD drug_dealer_bodyguard2
		SET_CHAR_THREAT_SEARCH drug_dealer_bodyguard2 THREAT_GANG_HAITIAN
		GIVE_WEAPON_TO_CHAR drug_dealer_bodyguard2 WEAPONTYPE_RUGER 30000
	ENDIF
	IF NOT IS_CHAR_DEAD drug_dealer_sniper
		SET_CHAR_THREAT_SEARCH drug_dealer_sniper THREAT_GANG_HAITIAN
		SET_CHAR_THREAT_SEARCH drug_dealer_sniper THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_sniper WEAPONTYPE_RUGER 30000  
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_with_money
		SET_CHAR_STAY_IN_SAME_PLACE haitian_with_money FALSE  
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_bodyguard1
		SET_CHAR_STAY_IN_SAME_PLACE haitian_bodyguard1 FALSE  
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT haitian_bodyguard1 -645.4 -278.9 
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_bodyguard2
		SET_CHAR_STAY_IN_SAME_PLACE haitian_bodyguard2 FALSE  
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_ob1
		SET_CHAR_THREAT_SEARCH haitian_ob1 THREAT_PLAYER1
		TURN_CHAR_TO_FACE_COORD haitian_ob1 -663.3 -253.8 6.0 
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob1 player1 
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_ob2
		SET_CHAR_THREAT_SEARCH haitian_ob2 THREAT_PLAYER1
		TURN_CHAR_TO_FACE_COORD haitian_ob2 -663.3 -253.8 6.0 
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob2 player1 
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_ob3
		SET_CHAR_THREAT_SEARCH haitian_ob3 THREAT_PLAYER1
		TURN_CHAR_TO_FACE_COORD haitian_ob3 -663.3 -253.8 6.0 
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob3 player1 
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_ob4
		SET_CHAR_THREAT_SEARCH haitian_ob4 THREAT_PLAYER1
		TURN_CHAR_TO_FACE_COORD haitian_ob4 -663.3 -253.8 6.0 
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob4 player1 
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_ob5
		SET_CHAR_THREAT_SEARCH haitian_ob5 THREAT_PLAYER1
		TURN_CHAR_TO_FACE_COORD haitian_ob5 -663.3 -253.8 6.0 
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob5 player1 
	ENDIF
	IF NOT IS_CHAR_DEAD haitian_ob6
		SET_CHAR_THREAT_SEARCH haitian_ob6 THREAT_PLAYER1
		TURN_CHAR_TO_FACE_COORD haitian_ob6 -663.3 -253.8 6.0 
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob6 player1 
	ENDIF
	GOTO fight
ENDIF

//mission fails if boat dies when player is on it.  Gonna blow player up too
IF IS_CAR_DEAD playrs_boat 
OR IS_CHAR_DEAD boat_driver 
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

GOTO waiting_for_player_to_shoot




////////////////////////////////////////////////////////THE FIGHT//////////////////////////////////////////////////////////////////////////////
fight:
WAIT 0

IF cub3_speech_played = 0 
	LOAD_MISSION_AUDIO 1 CUB3_1
	WHILE NOT HAS_MISSION_AUDIO_LOADED 1
		WAIT 0
	ENDWHILE 
	PRINT_NOW CUB3_08 4000 1//Uh oh.. Pack of Cubans.  We under attack!
	PLAY_MISSION_AUDIO 1
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
	CLEAR_MISSION_AUDIO 1
	CLEAR_THIS_PRINT CUB3_08
	cub3_speech_played = 1
ENDIF 


/*
IF boat_haitians_dead > 3
	IF haitian_death_ob1 = 0
		IF IS_CHAR_DEAD haitian_ob1
			boat_haitians_dead --
			haitian_death_ob1 = 1
		ENDIF
	ENDIF
	IF haitian_death_ob2 = 0
		IF IS_CHAR_DEAD haitian_ob2
			boat_haitians_dead --
			haitian_death_ob2 = 1
		ENDIF
	ENDIF
	IF haitian_death_ob3 = 0
		IF IS_CHAR_DEAD haitian_ob3
			boat_haitians_dead --
			haitian_death_ob3 = 1
		ENDIF
	ENDIF
	IF haitian_death_ob4 = 0
		IF IS_CHAR_DEAD haitian_ob4
			boat_haitians_dead --
			haitian_death_ob4 = 1
		ENDIF
	ENDIF
	IF haitian_death_ob5 = 0
		IF IS_CHAR_DEAD haitian_ob5
			boat_haitians_dead --
			haitian_death_ob5 = 1
		ENDIF
	ENDIF
	IF haitian_death_ob6 = 0
		IF IS_CHAR_DEAD haitian_ob6
			boat_haitians_dead --
			haitian_death_ob6 = 1
		ENDIF
	ENDIF
ELSE
	IF NOT IS_CHAR_DEAD haitian_ob3 
		IF NOT IS_CAR_DEAD haitian_big_boat1 
			IF haitian_moving_ob3 = 0
				DETACH_CHAR_FROM_CAR haitian_ob3 
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS haitian_big_boat1 -0.3 2.5 3.8 hait3_coordx hait3_coordy player_z
				SET_CHAR_COORDINATES haitian_ob3 hait3_coordx hait3_coordy player_z 
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS haitian_big_boat1 0.2 -1.3 3.8 hait3_coordx hait3_coordy player_z
				SET_CHAR_OBJ_RUN_TO_COORD haitian_ob3 hait3_coordx hait3_coordy
				haitian_moving_ob3 = 1
			ENDIF
			IF haitian_moving_ob3 = 1
				IF LOCATE_CHAR_ANY_MEANS_2D haitian_ob3 hait3_coordx hait3_coordy 1.0 1.0 FALSE
					ATTACH_CHAR_TO_CAR haitian_ob3 haitian_big_boat1 0.2 -1.3 3.8 FACING_RIGHT 360.0 WEAPONTYPE_uzi	 
					SET_CHAR_THREAT_SEARCH haitian_ob3 THREAT_PLAYER1
					TURN_CHAR_TO_FACE_COORD haitian_ob3 -663.3 -253.8 6.0 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob3 player1 
					haitian_moving_ob3 = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_ob5 
		IF NOT IS_CAR_DEAD haitian_big_boat2 
			IF haitian_moving_ob5 = 0
				DETACH_CHAR_FROM_CAR haitian_ob5 
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS haitian_big_boat2 -0.3 2.5 3.8 hait5_coordx hait5_coordy player_z
				SET_CHAR_COORDINATES haitian_ob5 hait5_coordx hait5_coordy player_z 
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS haitian_big_boat2 0.2 -1.3 3.8 hait5_coordx hait5_coordy player_z
				SET_CHAR_OBJ_RUN_TO_COORD haitian_ob5 hait5_coordx hait5_coordy
				haitian_moving_ob5 = 1
			ENDIF
			IF haitian_moving_ob5 = 1
				IF LOCATE_CHAR_ANY_MEANS_2D haitian_ob5 hait5_coordx hait5_coordy 1.0 1.0 FALSE
					ATTACH_CHAR_TO_CAR haitian_ob5 haitian_big_boat2 0.2 -1.3 3.8 FACING_RIGHT 360.0 WEAPONTYPE_uzi	 
					SET_CHAR_THREAT_SEARCH haitian_ob5 THREAT_PLAYER1
					TURN_CHAR_TO_FACE_COORD haitian_ob5 -663.3 -253.8 6.0 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob5 player1 
					haitian_moving_ob5 = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD haitian_ob6 
		IF NOT IS_CAR_DEAD haitian_big_boat2 
			IF haitian_moving_ob6 = 0
				DETACH_CHAR_FROM_CAR haitian_ob6 
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS haitian_big_boat2 -0.3 2.5 3.8 hait6_coordx hait6_coordy player_z
				SET_CHAR_COORDINATES haitian_ob6 hait6_coordx hait6_coordy player_z 
				GET_OFFSET_FROM_CAR_IN_WORLD_COORDS haitian_big_boat2 0.2 -1.3 3.8 hait6_coordx hait6_coordy player_z
				SET_CHAR_OBJ_RUN_TO_COORD haitian_ob6 hait6_coordx hait6_coordy
				haitian_moving_ob6 = 1
			ENDIF
			IF haitian_moving_ob6 = 1
				IF LOCATE_CHAR_ANY_MEANS_2D haitian_ob6 hait6_coordx hait6_coordy 1.0 1.0 FALSE
					ATTACH_CHAR_TO_CAR haitian_ob6 haitian_big_boat2 0.2 -1.3 3.8 FACING_RIGHT 360.0 WEAPONTYPE_uzi	 
					SET_CHAR_THREAT_SEARCH haitian_ob6 THREAT_PLAYER1
					TURN_CHAR_TO_FACE_COORD haitian_ob6 -663.3 -253.8 6.0 
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob6 player1 
					haitian_moving_ob6 = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF
*/		 

IF IS_CHAR_DEAD haitian_with_money
	IF dropped_money_flag = 0 
		CREATE_PICKUP briefcase PICKUP_ONCE -650.4 -268.5 9.0 dropped_money 
		ADD_BLIP_FOR_COORD -650.4 -268.5 leader_coordsz dropped_money_blip 
		dropped_money_flag = 1
	ENDIF



//waiting for player to kill all the haitians
	IF IS_CHAR_DEAD haitian_bodyguard1
		IF IS_CHAR_DEAD haitian_bodyguard2
			IF IS_CHAR_DEAD haitian_ob1
				IF IS_CHAR_DEAD haitian_ob2
					IF IS_CHAR_DEAD haitian_ob3
						IF IS_CHAR_DEAD haitian_ob4
							IF IS_CHAR_DEAD haitian_ob5
								IF IS_CHAR_DEAD haitian_ob6
									GOTO jetty_cutscene
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF 
			

  
//setting dealers to slaughter the haitians then leg it back up to the mansion
			IF NOT IS_CHAR_DEAD drug_dealer
				CLEAR_CHAR_THREAT_SEARCH drug_dealer
				SET_CHAR_STAY_IN_SAME_PLACE drug_dealer FALSE  
				SET_CHAR_RUNNING drug_dealer TRUE 
				IF drug_dealer_flag = 0 
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -645.4 -278.9
					drug_dealer_flag = 1
				ENDIF
				IF drug_dealer_flag = 1 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer -645.4 -278.9 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -648.7 -285.6
						drug_dealer_flag = 2
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -645.4 -278.9
					ENDIF
				ENDIF
				IF drug_dealer_flag = 2 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer -648.7 -285.6 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -634.7 -303.2
						drug_dealer_flag = 3
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -648.7 -285.6
					ENDIF
				ENDIF
				IF drug_dealer_flag = 3 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer -634.7 -303.2 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -641.0 -309.0
						drug_dealer_flag = 4
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer -634.7 -303.2
					ENDIF
				ENDIF
				IF drug_dealer_flag = 4
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer -641.0 -309.0 2.0 2.0 FALSE 
						SET_CHAR_OBJ_NO_OBJ drug_dealer
						TURN_CHAR_TO_FACE_COORD drug_dealer -650.0 -269.1 9.0 
						drug_dealer_flag = 5
					ENDIF
				ENDIF
			ENDIF 
			 
			IF NOT IS_CHAR_DEAD drug_dealer_bodyguard1
				CLEAR_CHAR_THREAT_SEARCH drug_dealer_bodyguard1
				SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_bodyguard1 FALSE  
				SET_CHAR_RUNNING drug_dealer_bodyguard1 TRUE 
				IF drug_dealer_bodyguard1_flag = 0 
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -645.4 -278.9
					drug_dealer_bodyguard1_flag = 1
				ENDIF
				
				IF drug_dealer_bodyguard1_flag = 1
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard1 -645.4 -278.9 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -648.7 -285.6
						drug_dealer_bodyguard1_flag = 2
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -645.4 -278.9
					ENDIF
				ENDIF

				IF drug_dealer_bodyguard1_flag = 2 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard1 -648.7 -285.6 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -646.9 -289.4
						drug_dealer_bodyguard1_flag = 3
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -648.7 -285.6
					ENDIF
				ENDIF

				IF drug_dealer_bodyguard1_flag = 3 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard1 -646.9 -289.4 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -656.5 -290.5
						drug_dealer_bodyguard1_flag = 4
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard1 -646.9 -289.4
					ENDIF
				ENDIF
				
				IF drug_dealer_bodyguard1_flag = 4 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard1 -656.5 -290.5 2.0 2.0 FALSE 
						SET_CHAR_OBJ_NO_OBJ drug_dealer_bodyguard1
						TURN_CHAR_TO_FACE_COORD drug_dealer_bodyguard1 -650.0 -269.1 9.0 
						drug_dealer_bodyguard1_flag = 5
					ENDIF
				ENDIF
			ENDIF 
			 
			IF NOT IS_CHAR_DEAD drug_dealer_bodyguard2
				CLEAR_CHAR_THREAT_SEARCH drug_dealer_bodyguard2
				SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_bodyguard2 FALSE  
				SET_CHAR_RUNNING drug_dealer_bodyguard2 TRUE 
				IF drug_dealer_bodyguard2_flag = 0 
					SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -645.4 -278.9
					drug_dealer_bodyguard2_flag = 1
				ENDIF

				IF drug_dealer_bodyguard2_flag = 1 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard2 -645.4 -278.9 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -648.7 -285.6
						drug_dealer_bodyguard2_flag = 2
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -645.4 -278.9
					ENDIF
				ENDIF

				IF drug_dealer_bodyguard2_flag = 2 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard2 -648.7 -285.6 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -646.9 -289.4
						drug_dealer_bodyguard2_flag = 3
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -648.7 -285.6
					ENDIF
				ENDIF
					
				IF drug_dealer_bodyguard2_flag = 3 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard2 -646.9 -289.4 2.0 2.0 FALSE 
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -643.5 -283.1
						drug_dealer_bodyguard2_flag = 4
					ELSE
						SET_CHAR_OBJ_GOTO_COORD_ON_FOOT drug_dealer_bodyguard2 -646.9 -289.4
					ENDIF
				ENDIF
					
				IF drug_dealer_bodyguard2_flag = 4 
					IF LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard2 -643.5 -283.1 2.0 2.0 FALSE 
						SET_CHAR_OBJ_NO_OBJ drug_dealer_bodyguard2
						TURN_CHAR_TO_FACE_COORD drug_dealer_bodyguard2 -650.0 -269.1 9.0
						drug_dealer_bodyguard2_flag = 5 
					ENDIF
				ENDIF
			ENDIF  
		ENDIF
	ENDIF
ENDIF

IF IS_CHAR_DEAD boat_driver 
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF
				   	
IF IS_CAR_DEAD playrs_boat
	EXPLODE_PLAYER_HEAD player1 
	GOTO mission_failed_cuban3
ENDIF

//removing bodies from pool
IF IS_CHAR_DEAD haitian_bodyguard1
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_bodyguard1
ENDIF 
IF IS_CHAR_DEAD haitian_bodyguard2
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_bodyguard2
ENDIF 
IF IS_CHAR_DEAD haitian_ob1
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_ob1
ENDIF 
IF IS_CHAR_DEAD haitian_ob2
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_ob2
ENDIF 
IF IS_CHAR_DEAD haitian_ob3
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_ob3
ENDIF 
IF IS_CHAR_DEAD haitian_ob4
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_ob4
ENDIF 
IF IS_CHAR_DEAD haitian_ob5
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_ob5
ENDIF 
IF IS_CHAR_DEAD haitian_ob6
	MARK_CHAR_AS_NO_LONGER_NEEDED haitian_ob6
ENDIF 
IF IS_CHAR_DEAD drug_dealer
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer
ENDIF 
IF IS_CHAR_DEAD drug_dealer_bodyguard1
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard1
ENDIF 
IF IS_CHAR_DEAD drug_dealer_bodyguard2
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard2
ENDIF 

GOTO fight 


// ******************************************START OF PLAYER PULLING UP TO JETTY CUTSCENE********************************
jetty_cutscene:
WAIT 1000


SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -642.3 -241.4 10.0 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -630.5 -261.4 7.0 JUMP_CUT
CLEAR_AREA_OF_CARS -530.2 -186.3 10.0 -791.8 -447.8 0.0
SET_RADIO_CHANNEL RADIO_ESPANTOSO -1

IF NOT IS_CAR_DEAD playrs_boat 
	ATTACH_CHAR_TO_CAR scplayer playrs_boat 0.0 -0.4 1.5 FACING_BACK 360.0 WEAPONTYPE_UNARMED
	SET_CAR_COORDINATES playrs_boat -642.3 -230.4 6.0 
	SET_CAR_HEADING playrs_boat 223.0
	ANCHOR_BOAT playrs_boat FALSE
	SET_BOAT_CRUISE_SPEED playrs_boat 10.0
	BOAT_GOTO_COORDS playrs_boat -632.1 -251.0 6.5
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

IF NOT IS_CHAR_DEAD drug_dealer 
	IF NOT LOCATE_CHAR_ANY_MEANS_2D drug_dealer -641.0 -309.0 2.0 2.0 FALSE 
		SET_CHAR_OBJ_NO_OBJ drug_dealer
		SET_CHAR_COORDINATES drug_dealer -641.0 -309.0 11.5 
		TURN_CHAR_TO_FACE_COORD drug_dealer -650.0 -269.1 9.0 
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer
ENDIF

IF NOT IS_CHAR_DEAD drug_dealer_bodyguard1 
	IF NOT LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard1 -656.5 -290.5 2.0 2.0 FALSE 
		SET_CHAR_OBJ_NO_OBJ drug_dealer_bodyguard1
		SET_CHAR_COORDINATES drug_dealer_bodyguard1 -656.5 -290.5 9.0 
		TURN_CHAR_TO_FACE_COORD drug_dealer_bodyguard1 -650.0 -269.1 9.0 
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard1
ENDIF

IF NOT IS_CHAR_DEAD drug_dealer_bodyguard2 
	IF NOT LOCATE_CHAR_ANY_MEANS_2D drug_dealer_bodyguard2 -643.5 -283.1 2.0 2.0 FALSE 
		SET_CHAR_OBJ_NO_OBJ drug_dealer_bodyguard2
		SET_CHAR_COORDINATES drug_dealer_bodyguard2 -643.5 -283.1 9.0 
		TURN_CHAR_TO_FACE_COORD drug_dealer_bodyguard2 -650.0 -269.1 9.0 
	ENDIF
ELSE
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard2
ENDIF

WAIT 1000

waiting_on_boat_to_dock:
WAIT 0
CLEAR_AREA_OF_CARS -530.2 -186.3 10.0 -791.8 -447.8 0.0
IF NOT IS_CAR_DEAD playrs_boat
	IF LOCATE_CAR_2D playrs_boat -632.1 -251.0 5.0 5.0 FALSE
		BOAT_STOP playrs_boat
		ANCHOR_BOAT playrs_boat TRUE
		DETACH_CHAR_FROM_CAR scplayer  

		//FADE OUT 
		SET_FADING_COLOUR 1 1 1
		DO_FADE 500 FADE_OUT

		WAIT 600

		SET_PLAYER_COORDINATES player1 -633.2 -263.6 8.7
		SET_PLAYER_HEADING player1 143.3
		IF NOT IS_CAR_DEAD playrs_boat
			SET_CAR_COORDINATES playrs_boat -633.3 -256.2 5.5
			SET_CAR_HEADING playrs_boat 213.0 
		ENDIF
		IF NOT IS_CHAR_DEAD drug_dealer 
			SET_CHAR_STAY_IN_SAME_PLACE drug_dealer TRUE  
			SET_CHAR_THREAT_SEARCH drug_dealer THREAT_PLAYER1
			GIVE_WEAPON_TO_CHAR drug_dealer WEAPONTYPE_RUGER 30000
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer player1
		ENDIF 
		IF NOT IS_CHAR_DEAD drug_dealer_bodyguard1 
			SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_bodyguard1 TRUE  
			SET_CHAR_THREAT_SEARCH drug_dealer_bodyguard1 THREAT_PLAYER1
			GIVE_WEAPON_TO_CHAR drug_dealer_bodyguard1 WEAPONTYPE_RUGER 30000
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_bodyguard1 player1
		ENDIF
		IF NOT IS_CHAR_DEAD drug_dealer_bodyguard2 
			SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_bodyguard2 TRUE  
			SET_CHAR_THREAT_SEARCH drug_dealer_bodyguard2 THREAT_PLAYER1
			GIVE_WEAPON_TO_CHAR drug_dealer_bodyguard2 WEAPONTYPE_RUGER 30000
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_bodyguard2 player1
		ENDIF
		
		//guy with briefcase
		CREATE_CHAR PEDTYPE_GANG_STREET SGb -629.9 -300.4 11.0 drug_dealer_with_briefcases 
		SET_CHAR_HEADING drug_dealer_with_briefcases 66.4  
		CLEAR_CHAR_THREAT_SEARCH drug_dealer_with_briefcases
		SET_CHAR_PERSONALITY drug_dealer_with_briefcases PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS drug_dealer_with_briefcases TRUE
		SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_with_briefcases TRUE
		SET_CHAR_THREAT_SEARCH drug_dealer_with_briefcases THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_with_briefcases WEAPONTYPE_ruger 30000
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_with_briefcases player1
 

		//in front of door
		CREATE_CHAR PEDTYPE_GANG_STREET SGa -627.3 -310.8 12.1 drug_dealer_backup1 
		SET_CHAR_HEADING drug_dealer_backup1 69.4  
		CLEAR_CHAR_THREAT_SEARCH drug_dealer_backup1
		SET_CHAR_PERSONALITY drug_dealer_backup1 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS drug_dealer_backup1 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_backup1 TRUE
		SET_CHAR_THREAT_SEARCH drug_dealer_backup1 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_backup1 WEAPONTYPE_RUGER 30000
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_backup1 player1
	
		//on porch
		CREATE_CHAR PEDTYPE_GANG_STREET SGa -631.1 -313.0 12.1 drug_dealer_backup2 
		SET_CHAR_HEADING drug_dealer_backup2 49.2  
		CLEAR_CHAR_THREAT_SEARCH drug_dealer_backup2
		SET_CHAR_PERSONALITY drug_dealer_backup2 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS drug_dealer_backup2 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_backup2 TRUE
		SET_CHAR_THREAT_SEARCH drug_dealer_backup2 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_backup2 WEAPONTYPE_ruger 30000
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_backup2 player1
		
		//left side of house looking at deal
		CREATE_CHAR PEDTYPE_GANG_STREET SGa -648.6 -326.2 11.0 drug_dealer_backup3 
		SET_CHAR_HEADING drug_dealer_backup3 2.7  
		CLEAR_CHAR_THREAT_SEARCH drug_dealer_backup3
		SET_CHAR_PERSONALITY drug_dealer_backup3 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS drug_dealer_backup3 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_backup3 TRUE
		SET_CHAR_THREAT_SEARCH drug_dealer_backup3 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_backup3 WEAPONTYPE_STUBBY_SHOTGUN 30000
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_backup3 player1
		
		//right side of house looking at deal
		CREATE_CHAR PEDTYPE_GANG_STREET SGa -608.5 -294.6 11.0 drug_dealer_backup4 
		SET_CHAR_HEADING drug_dealer_backup4 46.2  
		CLEAR_CHAR_THREAT_SEARCH drug_dealer_backup4
		SET_CHAR_PERSONALITY drug_dealer_backup4 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS drug_dealer_backup4 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_backup4 TRUE
		SET_CHAR_THREAT_SEARCH drug_dealer_backup4 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_backup4 WEAPONTYPE_STUBBY_SHOTGUN 30000
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_backup4 player1

		//waiting for player to run through archway on left looking at deal
		CREATE_CHAR PEDTYPE_GANG_STREET SGa -592.6 -255.9 9.5 drug_dealer_backup5 
		SET_CHAR_HEADING drug_dealer_backup5 10.7  
		CLEAR_CHAR_THREAT_SEARCH drug_dealer_backup5
		SET_CHAR_PERSONALITY drug_dealer_backup5 PEDSTAT_TOUGH_GUY  
		SET_CHAR_HEED_THREATS drug_dealer_backup5 TRUE
		SET_CHAR_STAY_IN_SAME_PLACE drug_dealer_backup5 TRUE
		SET_CHAR_THREAT_SEARCH drug_dealer_backup5 THREAT_PLAYER1
		GIVE_WEAPON_TO_CHAR drug_dealer_backup5 WEAPONTYPE_STUBBY_SHOTGUN 30000
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT drug_dealer_backup5 player1
		
		IF briefcase_dropped_flag = 0
			ADD_BLIP_FOR_COORD -641.0 -309.0 11.5 briefcase_dropped_1_blip
		ENDIF 
		boat_location = 0

		GOTO boat_docked 
	ENDIF
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF
GOTO waiting_on_boat_to_dock 

IF IS_CHAR_DEAD boat_driver 
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

boat_docked:	 

WAIT 600

//FADE IN
DO_FADE 1500 FADE_IN

WAIT 1600

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
// ******************************************END OF PLAYER PULLING UP TO JETTY CUTSCENE**********************************
//////////////////////THE FINAL FIGHT and PLAYER GOING BACK TO CUBAN BASE////////////////////////////////////////////////


PRINT_NOW ( CUB3_03 ) 7000 1 //Collect all the briefcases filled with the drugs and cash.

final_fight:
WAIT 0

IF IS_CHAR_DEAD boat_driver 
OR IS_CAR_DEAD playrs_boat
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

IF IS_CHAR_DEAD drug_dealer_with_briefcases
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_with_briefcases 
	IF briefcase_dropped_flag = 0
		leader_coordsy -= 1.0 
		CREATE_PICKUP briefcase PICKUP_ONCE leader_coordsx leader_coordsy leader_coordsz briefcase_dropped_1 
		REMOVE_BLIP briefcase_dropped_1_blip
		ADD_BLIP_FOR_COORD leader_coordsx leader_coordsy leader_coordsz briefcase_dropped_1_blip 
		briefcase_dropped_flag = 1
	ENDIF
	IF briefcase_dropped_flag = 1
		leader_coordsy += 2.0 
		CREATE_PICKUP briefcase PICKUP_ONCE leader_coordsx leader_coordsy leader_coordsz briefcase_dropped_2 
		ADD_BLIP_FOR_COORD leader_coordsx leader_coordsy leader_coordsz briefcase_dropped_2_blip 
		briefcase_dropped_flag = 2
	ENDIF
ELSE
	GET_CHAR_COORDINATES drug_dealer_with_briefcases leader_coordsx leader_coordsy leader_coordsz
ENDIF

IF HAS_PICKUP_BEEN_COLLECTED dropped_money
	boat_location ++
	REMOVE_BLIP dropped_money_blip
ENDIF 

IF briefcase_dropped_flag = 2
	IF HAS_PICKUP_BEEN_COLLECTED briefcase_dropped_1
		boat_location ++
		REMOVE_BLIP briefcase_dropped_1_blip
	ENDIF 

	IF HAS_PICKUP_BEEN_COLLECTED briefcase_dropped_2
		boat_location ++
		REMOVE_BLIP briefcase_dropped_2_blip
	ENDIF 
ENDIF

//removing peds from pool
IF IS_CHAR_DEAD drug_dealer
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer
ENDIF 
IF IS_CHAR_DEAD drug_dealer_bodyguard1
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard1
ENDIF 
IF IS_CHAR_DEAD drug_dealer_bodyguard2
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard2
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup1
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup1
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup2
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup2
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup3
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup3
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup4
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup4
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup5
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup5
ENDIF 

IF boat_location = 3
// ******************************************START OF CUTSCENE - BLOWING UP PLAYERS BOAT**********************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON

DELETE_CHAR haitian_ob1
DELETE_CHAR haitian_ob2
CREATE_CAR dinghy -635.5 -237.7 5.5 haitian_dinghy 
SET_CAR_HEADING haitian_dinghy 159.0
ANCHOR_BOAT haitian_dinghy TRUE
CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -635.5 -237.7 6.0 haitian_ob1 
ATTACH_CHAR_TO_CAR haitian_ob1 haitian_dinghy 0.0 1.8 1.2 FACING_FORWARD 360.0 WEAPONTYPE_GRENADE //guy throwing grenade 

CREATE_CHAR PEDTYPE_GANG_HAITIAN HNa -635.5 -237.7 6.0 haitian_ob2 
ATTACH_CHAR_TO_CAR haitian_ob2 haitian_dinghy 0.4 -1.8 1.2 FACING_FORWARD 360.0 WEAPONTYPE_GRENADE //guy driving dinghy
SET_CHAR_WAIT_STATE haitian_ob2 WAITSTATE_PLAYANIM_DUCK 100000 

BOAT_GOTO_COORDS haitian_dinghy -637.0 -239.0 5.5
SET_BOAT_CRUISE_SPEED haitian_dinghy 0.0
IF NOT IS_CHAR_DEAD boat_driver  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER boat_driver FALSE
ENDIF 

SET_FIXED_CAMERA_POSITION -627.6 -268.3 12.0 0.0 0.0 0.0 
POINT_CAMERA_AT_CAR haitian_dinghy FIXED JUMP_CUT
CLEAR_AREA_OF_CARS -530.2 -186.3 10.0 -791.8 -447.8 0.0

WHILE NOT LOCATE_CAR_2D haitian_dinghy -637.0 -239.0 2.0 2.0 FALSE
	WAIT 0
		IF NOT IS_CAR_DEAD haitian_dinghy 
		ENDIF
ENDWHILE  

IF NOT IS_CAR_DEAD haitian_dinghy 
	BOAT_STOP haitian_dinghy
	ANCHOR_BOAT haitian_dinghy TRUE
ELSE
	PRINT_NOW ( CUB2_10 ) 5000 1 //You are supposed to be killing Haitians, not Cubans.
	GOTO mission_failed_cuban3
ENDIF

WAIT 2000

IF NOT IS_CAR_DEAD playrs_boat 
	IF NOT IS_CHAR_DEAD haitian_ob1
		SET_CHAR_OBJ_DESTROY_CAR haitian_ob1 playrs_boat
	ENDIF
ENDIF  

WAIT 2000

IF NOT IS_CAR_DEAD playrs_boat		   
	SET_CAR_CAN_BE_DAMAGED playrs_boat TRUE
	GET_CAR_COORDINATES playrs_boat player_x player_y player_z 
	EXPLODE_CAR playrs_boat
	ADD_EXPLOSION player_x player_y player_z EXPLOSION_ROCKET
	ADD_EXPLOSION player_x player_y player_z EXPLOSION_HELI_BOMB  
	ADD_EXPLOSION player_x player_y player_z EXPLOSION_MOLOTOV
	ADD_EXPLOSION player_x player_y player_z EXPLOSION_HELI
	ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE player_x player_y player_z 0.1 0.0 0.2 0.8 0 0 0 11000 
ENDIF  

WAIT 2000

IF NOT IS_CHAR_DEAD haitian_ob1
	DETACH_CHAR_FROM_CAR haitian_ob1
	SET_CHAR_COORDINATES haitian_ob1 -632.2 -264.0 8.7
	SET_CHAR_HEADING haitian_ob1 183.0 
	CLEAR_CHAR_THREAT_SEARCH haitian_ob1
	SET_CHAR_PERSONALITY haitian_ob1 PEDSTAT_TOUGH_GUY  
	SET_CHAR_HEED_THREATS haitian_ob1 TRUE
	SET_CHAR_THREAT_SEARCH haitian_ob1 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR haitian_ob1 WEAPONTYPE_RUGER 30000
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob1 player1
ENDIF

IF NOT IS_CHAR_DEAD haitian_ob2
	SET_CHAR_WAIT_STATE haitian_ob2 WAITSTATE_FALSE 100
	DETACH_CHAR_FROM_CAR haitian_ob2
	SET_CHAR_COORDINATES haitian_ob2 -639.2 -272.0 8.7
	SET_CHAR_HEADING haitian_ob2 183.0 
	CLEAR_CHAR_THREAT_SEARCH haitian_ob2
	SET_CHAR_PERSONALITY haitian_ob2 PEDSTAT_TOUGH_GUY  
	SET_CHAR_HEED_THREATS haitian_ob2 TRUE
	SET_CHAR_THREAT_SEARCH haitian_ob2 THREAT_PLAYER1
	GIVE_WEAPON_TO_CHAR haitian_ob2 WEAPONTYPE_RUGER 30000
	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT haitian_ob2 player1
ENDIF

 
IF NOT IS_CAR_DEAD haitian_dinghy
	SET_CAR_COORDINATES haitian_dinghy -624.0 -257.7 6.0
	SET_CAR_HEADING haitian_dinghy 335.0
ENDIF 

RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SWITCH_WIDESCREEN OFF
// ******************************************END OF CUTSCENE - BLOWING UP PLAYERS BOAT************************************
	ADD_BLIP_FOR_COORD -1170.0 -603.4 11.6 cuban_base
	PRINT_NOW ( CUB3_04 ) 7000 1 //Get the drugs and cash back to Umberto.
	ALTER_WANTED_LEVEL_NO_DROP player1 4
	GOTO taking_drugsandmoney_back
ENDIF

GOTO final_fight  

//Waiting for player to return with cash
taking_drugsandmoney_back:
WAIT 0
IF LOCATE_PLAYER_ON_FOOT_3D player1 -1169.9 -607.8 10.6 2.0 2.0 2.0 TRUE
// ******************************************START OF CUTSCENE - PLAYER GIVING CASH AND DRUGS TO UMBERTO**********************************
	SET_PLAYER_CONTROL player1 OFF
	SWITCH_WIDESCREEN ON
	
	SET_FIXED_CAMERA_POSITION -1171.0 -595.6 14.2 0.0 0.0 0.0 
	POINT_CAMERA_AT_PLAYER player1 FIXED JUMP_CUT

	SET_PLAYER_COORDINATES player1 -1161.4 -620.2 10.6
	CREATE_CHAR PEDTYPE_CIVMALE null -1169.9 -607.8 10.6 dummy_dude
	
	TURN_CHAR_TO_FACE_COORD dummy_dude -1169.7 -630.9 11.0  
	SET_CHAR_OBJ_RUN_TO_COORD dummy_dude -1169.7 -630.9 

	IF NOT IS_CHAR_DEAD dummy_dude
	ENDIF 
	WHILE NOT LOCATE_CHAR_ON_FOOT_2D dummy_dude -1169.7 -630.9 2.0 2.0 FALSE
		WAIT 0 
		IF NOT IS_CHAR_DEAD dummy_dude
		ENDIF 
	ENDWHILE
	IF NOT IS_CHAR_DEAD dummy_dude
		SET_CHAR_OBJ_NO_OBJ dummy_dude
	ENDIF 

	WAIT 1000
	
	DELETE_CHAR dummy_dude 
	RESTORE_CAMERA_JUMPCUT
	SET_PLAYER_CONTROL player1 ON
	SWITCH_WIDESCREEN OFF
	CLEAR_AREA -1170.2 -603.9 10.6 20.0 TRUE
	GOTO mission_passed_cuban3
ENDIF  

//removing peds from pool
IF IS_CHAR_DEAD drug_dealer
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer
ENDIF 
IF IS_CHAR_DEAD drug_dealer_bodyguard1
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard1
ENDIF 
IF IS_CHAR_DEAD drug_dealer_bodyguard2
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_bodyguard2
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup1
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup1
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup2
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup2
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup3
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup3
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup4
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup4
ENDIF 
IF IS_CHAR_DEAD drug_dealer_backup5
	MARK_CHAR_AS_NO_LONGER_NEEDED drug_dealer_backup5
ENDIF 

GOTO taking_drugsandmoney_back 

// ******************************************END OF CUTSCENE - PLAYER GIVING CASH AND DRUGS TO UMBERTO**********************************


// Mission failed
mission_failed_cuban3:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_cuban3:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 4000 5000 1 //"Mission Passed!"
PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 4000
PLAYER_MADE_PROGRESS 1 
REGISTER_MISSION_PASSED CUB_3
START_NEW_SCRIPT cuban_mission4_loop
flag_cuban_mission3_passed = 1
RETURN
		


// mission cleanup
mission_cleanup_cuban3:
flag_player_on_mission = 0

SET_PLAYER_CONTROL player1 on
CLEAR_THREAT_FOR_PED_TYPE PEDTYPE_GANG_HAITIAN THREAT_PLAYER1
flag_is_on_cuban_mission = 0 // SCFIX
MARK_MODEL_AS_NO_LONGER_NEEDED tropic
MARK_MODEL_AS_NO_LONGER_NEEDED HNa
MARK_MODEL_AS_NO_LONGER_NEEDED HNb
MARK_MODEL_AS_NO_LONGER_NEEDED jetmax
MARK_MODEL_AS_NO_LONGER_NEEDED SGa
MARK_MODEL_AS_NO_LONGER_NEEDED grenade
MARK_MODEL_AS_NO_LONGER_NEEDED dinghy
MARK_MODEL_AS_NO_LONGER_NEEDED SGb
MARK_MODEL_AS_NO_LONGER_NEEDED CBb
MARK_MODEL_AS_NO_LONGER_NEEDED briefcase
MARK_MODEL_AS_NO_LONGER_NEEDED ruger
MARK_MODEL_AS_NO_LONGER_NEEDED buddyshot
MARK_MODEL_AS_NO_LONGER_NEEDED uzi
REMOVE_BLIP radar_blip_playrs_boat
REMOVE_BLIP dropped_money_blip 
REMOVE_BLIP briefcase_dropped_1_blip 
REMOVE_BLIP briefcase_dropped_2_blip
REMOVE_BLIP cuban_base  
REMOVE_PICKUP dropped_money 
REMOVE_PICKUP briefcase_dropped_1 
REMOVE_PICKUP briefcase_dropped_2 
DETACH_CHAR_FROM_CAR scplayer 
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
}




	 