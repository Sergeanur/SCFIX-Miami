MISSION_START
// *****************************************************************************************
// ************************************ General Mission 2 ********************************** 
// ************************************** Mall Shootout ************************************
// *****************************************************************************************
// *** The Colonel wants you to pick up some guidance chips that he has paid a good deal ***
// *** of money for. The exchange will take place in the relative safety of a busy 		 ***
// *** shopping mall. The French security forces are watching and spring a trap. The 	 ***
// *** player1 must escape with the merchandise and get it to <location>.				 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_general2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_general2_failed
ENDIF

GOSUB mission_cleanup_general2

MISSION_END
 
// Variables for mission

//CARS PEDS OBJECTS
VAR_INT cs_dude1 cs_dude2
//BLIPS
VAR_INT the_seller_blip

//FLAG COUNTER TIMERS
VAR_INT chips_pickup_flag timer	destination_counter destination_timer done_wanted_level
VAR_INT mall_shootout_counter mall_shootout_timer the_seller_counter done_blip_help	player_close_to_seller
VAR_INT ammunation_help_timer ammunation_help_flag

//COORD MATHS
VAR_FLOAT the_seller_heading the_seller_x the_seller_y the_seller_z

//LOAD_AND_LAUNCH_EXCLUSIVE stuff
//VAR_INT game_timer is_audio_in_use
//VAR_INT audio_1_flag audio_2_flag audio_3_flag audio_4_flag audio_5_flag audio_6_flag audio_7_flag audio_8_flag
//VAR_INT audio_1_timeout audio_2_timeout audio_3_timeout audio_4_timeout audio_5_timeout audio_6_timeout audio_7_timeout audio_8_timeout
//VAR_FLOAT x_temp y_temp	sum_x_y_temp criminal1_car_speed
// ****************************************Mission Start************************************

mission_start_general2:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN
SCRIPT_NAME COL2

WAIT 0
{
LVAR_INT the_seller french_security1 french_security2 french_security3 french_security4 the_sellers_car
LVAR_INT french_security5 french_security6 french_security7 french_security8 the_chips
LVAR_INT french_security9 the_players_car

LOAD_MISSION_TEXT GENERA2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -163.0 -1439.4 9.0 201.5

mall_shootout_counter = 0
mall_shootout_timer = 0
the_seller_counter = -1
chips_pickup_flag = 0
done_blip_help = 0
timer = 0
ground_z = 0.0
destination_counter =0
destination_timer = 0
done_wanted_level = 0

is_audio_in_use = 1

audio_1_flag = 0
audio_2_flag = 0
audio_3_flag = 0
audio_4_flag = 0
audio_5_flag = 0
audio_6_flag = 0
audio_7_flag = 0
audio_8_flag = 0

player_close_to_seller = 2
ammunation_help_flag = 0

//////////////////////////
//////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cscolo
LOAD_SPECIAL_CHARACTER 3 cgonb
LOAD_SPECIAL_CHARACTER 4 cservrb

REQUEST_MODEL yt_main_body
REQUEST_MODEL yt_main_body2
REQUEST_MODEL yt_doors14
REQUEST_MODEL yt_tmp_boat
REQUEST_MODEL lodmain_body
REQUEST_MODEL big_poly_tings
REQUEST_MODEL yt_gangplnk_tmp

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
CREATE_OBJECT_NO_OFFSET big_poly_tings the_yacht_x the_yacht_y the_yacht_z the_yacht3
//GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
//the_yacht_x = the_yacht_x + 0.003
//the_yacht_y = the_yacht_y - 1.381
//the_yacht_z = the_yacht_z + 3.149
//LOAD_SCENE the_yacht_x the_yacht_y the_yacht_z

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
LOAD_CUTSCENE COL_2

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
SET_CUTSCENE_ANIM cs_dude1 cgonb

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_dude2
SET_CUTSCENE_ANIM cs_dude2 cservrb

REQUEST_COLLISION -244.2799 -1360.6704
LOAD_SCENE -244.2799 -1360.6704 7.0786
CLEAR_AREA -244.2799 -1360.6704 7.0786 1.0 TRUE
SET_PLAYER_COORDINATES player1 -244.2799 -1360.6704 7.0786
SET_PLAYER_HEADING player1 279.1362
SET_CAMERA_BEHIND_PLAYER

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
SET_NEAR_CLIP 0.3
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 5347
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_A 10000 1 //Tommy! Come and join me.2920

WHILE cs_time < 9864
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_B 10000 1 //This looks delicous huh? Tapia snout?8317

WHILE cs_time < 13052
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_C 10000 1 //Eerr...No. No thanks.10659

WHILE cs_time < 14891
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_D 10000 1 //Tommy; you are like a pampas breeze that has freed me from the stench of corruption,		12516

WHILE cs_time < 20085
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_E 10000 1 //although, I must appear to mourn his passing and carry on with business as usual.17707

WHILE cs_time < 24630
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_F 10000 1 //This isn't getting me any closer to my money...22199

WHILE cs_time < 26918
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_G 10000 1 //Tommy, my friend; you are not in Liberty now. Here we do things differently.24500

WHILE cs_time < 33020
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_H 10000 1 //I will continue with my enquiries but in the meantime I have a valuable deal to close.30654

WHILE cs_time < 38898
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_I 10000 1 //A favour for a friend, Cortez.36500

WHILE cs_time < 40828
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_J 10000 1 //You're a good friend Tommy. I knew you would not let me down.38392

WHILE cs_time < 44168
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW COL2_K 10000 1 //I need you to meet a courier who has obtained some valuable technology for me...41736

WHILE cs_time < 48182
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

SWITCH_RUBBISH ON
CLEAR_CUTSCENE

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4

DELETE_OBJECT the_yacht3
MARK_MODEL_AS_NO_LONGER_NEEDED yt_main_body
MARK_MODEL_AS_NO_LONGER_NEEDED yt_main_body2
MARK_MODEL_AS_NO_LONGER_NEEDED yt_doors14
MARK_MODEL_AS_NO_LONGER_NEEDED yt_tmp_boat
MARK_MODEL_AS_NO_LONGER_NEEDED lodmain_body
MARK_MODEL_AS_NO_LONGER_NEEDED big_poly_tings
MARK_MODEL_AS_NO_LONGER_NEEDED yt_gangplnk_tmp

//////////////////////////
//////////////////////////

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

REQUEST_MODEL PCJ600
REQUEST_MODEL COLT45
REQUEST_MODEL UZI
LOAD_SPECIAL_CHARACTER 1 fsfa
LOAD_SPECIAL_CHARACTER 2 courier

LOAD_MISSION_AUDIO 1 COL2_1
LOAD_MISSION_AUDIO 2 COL2_2

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED PCJ600
OR NOT HAS_MODEL_LOADED COLT45
OR NOT HAS_MODEL_LOADED UZI
OR NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

PRINT_NOW COL2_B1 15000 1//"Meet the courier at the mall."
GET_GAME_TIMER ammunation_help_timer
ammunation_help_timer += 20000

//SET_UP_TAXI_SHORTCUT (-160.3530 -1454.4674 10.0) 25.6793 (48.8072 -899.7817 10.0) 90.0  // 9.4186 9.4157

CREATE_CHAR	PEDTYPE_CIVMALE SPECIAL02 6.1112 -937.0656 15.0760 the_seller
SET_CHAR_ONLY_DAMAGED_BY_PLAYER	the_seller TRUE
SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
SET_CHAR_HEADING the_seller	262.8159
CLEAR_CHAR_THREAT_SEARCH the_seller
SET_CHAR_ONLY_DAMAGED_BY_PLAYER the_seller TRUE
SET_CHAR_STAY_IN_SAME_PLACE	the_seller TRUE
SET_CHAR_PERSONALITY the_seller PEDSTAT_TOUGH_GUY
SHUT_CHAR_UP the_seller TRUE


SET_ENTER_CAR_RANGE_MULTIPLIER 6.0

ADD_BLIP_FOR_CHAR the_seller the_seller_blip

GOTO gen2_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 18.9999 -928.7729 15.0727	french_security1
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 18.9999 -928.7729 15.0727	french_security2
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 18.9999 -928.7729 15.0727	french_security3
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 18.9999 -928.7729 15.0727	french_security4
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 18.9999 -928.7729 15.0727 french_security5
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -15.6727 -929.0634 15.066 french_security6
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -10.2667 -937.9695 9.4077 french_security7
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -9.9934 -939.7717 9.4492  french_security8
	CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -15.2250 -949.0593 15.072 french_security9
gen2_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check

button_pressed = 0

mall_shootout_loop:

	WAIT 0

	GET_GAME_TIMER game_timer

	IF chips_pickup_flag > 0
		IF done_wanted_level = 0
			ALTER_WANTED_LEVEL_NO_DROP player1 2
			done_wanted_level = 1
		ENDIF
	ENDIF

	IF mall_shootout_counter < 12
		IF IS_CHAR_DEAD	the_seller
			PRINT_NOW COL2_F1 5000 1//"You killed the contact!"
			GOTO mission_general2_failed
		ENDIF
		IF mall_shootout_counter < 1
			IF NOT IS_CHAR_HEALTH_GREATER the_seller 95
				GIVE_WEAPON_TO_CHAR the_seller WEAPONTYPE_UZI 9999
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT the_seller player1
			ENDIF
		ELSE
			REMOVE_ALL_CHAR_WEAPONS the_seller
		ENDIF
	ENDIF

	IF ammunation_help_flag = 0
		IF ammunation_help_timer < game_timer
			CLEAR_HELP
			PRINT_HELP AMMUHLP//If you need any weapons vist Ammunation. It is marked on the radar by a blue gun blip.
			REMOVE_BLIP	weapon_shop1_blip
			ADD_SPRITE_BLIP_FOR_COORD ammu1X ammu1Y ammu1Z RADAR_SPRITE_GUN weapon_shop1_blip
			FLASH_HUD_OBJECT HUD_FLASH_RADAR
			ammunation_help_timer = game_timer + 3000
			ammunation_help_flag = 1
		ENDIF
	ENDIF

	IF ammunation_help_flag = 1
		IF game_timer > ammunation_help_timer
			FLASH_HUD_OBJECT -1
			ammunation_help_flag = 2
		ENDIF
	ENDIF

	IF done_blip_help = 0
		IF LOCATE_PLAYER_ANY_MEANS_2D player1 3.3530 -938.9778 100.0 100.0 0
			CLEAR_HELP
			PRINT_HELP BLIPHLP //"The blip on the radar is a triangle pointing up, this shows that the target is higher than the player."
			FLASH_HUD_OBJECT HUD_FLASH_RADAR
			timer =	game_timer + 3000
			done_blip_help = 1
		ENDIF
	ENDIF

	IF done_blip_help = 1
		IF game_timer > timer
			FLASH_HUD_OBJECT -1
			done_blip_help = 2
		ENDIF
	ENDIF

	IF mall_shootout_counter > 1
	AND mall_shootout_counter < 12
		IF IS_BUTTON_PRESSED PAD1 CROSS
			IF button_pressed = 1
				CLEAR_MISSION_AUDIO 1
				CLEAR_MISSION_AUDIO 2
				CLEAR_SMALL_PRINTS
				IF mall_shootout_counter < 5
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 4.2931 -947.4683 20.7330 french_security1
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 2.4581 -947.4636 20.7330 french_security2
				ENDIF
				IF mall_shootout_counter < 9
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 2.7139 -936.8358 9.3967 french_security3
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 4.6123 -937.3372 9.3965 french_security4
				ENDIF
				IF mall_shootout_counter < 11
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					SET_CHAR_ONLY_DAMAGED_BY_PLAYER the_seller FALSE
					SET_CHAR_COORDINATES the_seller -8.3703 -934.7144 9.4119
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 1.7873 -928.6034
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					the_seller_counter = 4
				ENDIF
				mall_shootout_counter = 12
				mall_shootout_timer = game_timer - 500
				button_pressed = 2
			ENDIF
		ELSE
			IF button_pressed = 0
				button_pressed = 1
			ENDIF
		ENDIF
	ENDIF
	
	/////////
	/////////
	IF mall_shootout_counter = 13
		IF NOT IS_PLAYER_IN_AREA_3D player1 -39.0665 -968.8087 9.4111 47.3099 -909.2296 33.5801 0 //THE MALL
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security1
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security2
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security3
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security4
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security5
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security6
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security7
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security8
			MARK_CHAR_AS_NO_LONGER_NEEDED french_security9
			mall_shootout_counter = 14
		ELSE
			IF NOT IS_CHAR_DEAD	the_seller
				IF the_seller_counter = 7
					IF IS_CHAR_ON_SCREEN the_seller
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security1
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security2
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security3
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security4
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security5
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security6
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security7
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security8
						MARK_CHAR_AS_NO_LONGER_NEEDED french_security9
						mall_shootout_counter = 14
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	IF mall_shootout_counter = 12
		IF HAS_MISSION_AUDIO_FINISHED 1
		OR button_pressed = 2
			IF HAS_MISSION_AUDIO_LOADED	2
			OR button_pressed = 2
				IF game_timer > mall_shootout_timer

					SET_PLAYER_CONTROL player1 ON
					TURN_CHAR_TO_FACE_COORD	scplayer -2.3434 -939.0732 15.4658
					SET_EVERYONE_IGNORE_PLAYER player1 FALSE
					SWITCH_WIDESCREEN OFF
					SET_ALL_CARS_CAN_BE_DAMAGED TRUE
					SET_CAMERA_BEHIND_PLAYER
					RESTORE_CAMERA_JUMPCUT

					IF NOT button_pressed = 2
						PLAY_MISSION_AUDIO 2
					ENDIF
					is_audio_in_use = 0
					
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 18.9999 -928.7729 15.0727 french_security5
					SET_CHAR_HEED_THREATS french_security5 TRUE
					SET_CHAR_PERSONALITY french_security5 PEDSTAT_TOUGH_GUY
					SET_CHAR_THREAT_SEARCH french_security5 THREAT_PLAYER1
					GIVE_WEAPON_TO_CHAR french_security5 WEAPONTYPE_PISTOL  999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security5 player1
					
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -15.6727 -929.0634 15.066 french_security6
					SET_CHAR_HEED_THREATS french_security6 TRUE
					SET_CHAR_PERSONALITY french_security6 PEDSTAT_TOUGH_GUY
					SET_CHAR_THREAT_SEARCH french_security6 THREAT_PLAYER1
					GIVE_WEAPON_TO_CHAR french_security6 WEAPONTYPE_PISTOL  999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security6 player1
					
					
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -10.2667 -937.9695 9.4077 french_security7
					SET_CHAR_HEED_THREATS french_security7 TRUE
					SET_CHAR_PERSONALITY french_security7 PEDSTAT_TOUGH_GUY
					SET_CHAR_THREAT_SEARCH french_security7 THREAT_PLAYER1
					GIVE_WEAPON_TO_CHAR french_security7 WEAPONTYPE_PISTOL  999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security7 player1
					
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -9.9934 -939.7717 9.4492  french_security8 
					SET_CHAR_HEED_THREATS french_security8 TRUE
					SET_CHAR_PERSONALITY french_security8 PEDSTAT_TOUGH_GUY
					SET_CHAR_THREAT_SEARCH french_security8 THREAT_PLAYER1
					GIVE_WEAPON_TO_CHAR french_security8 WEAPONTYPE_PISTOL  999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security8 player1
					
					
					
					CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 -15.2250 -949.0593 15.072 french_security9
					SET_CHAR_HEED_THREATS french_security9 TRUE
					SET_CHAR_PERSONALITY french_security9 PEDSTAT_TOUGH_GUY
					SET_CHAR_THREAT_SEARCH french_security9 THREAT_PLAYER1
					GIVE_WEAPON_TO_CHAR french_security9 WEAPONTYPE_PISTOL  999
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security9 player1
					
					
					IF NOT IS_CHAR_DEAD	french_security1
						SET_CHAR_HEED_THREATS french_security1 TRUE
						SET_CHAR_PERSONALITY french_security1 PEDSTAT_TOUGH_GUY
						SET_CHAR_THREAT_SEARCH french_security1 THREAT_PLAYER1
						GIVE_WEAPON_TO_CHAR french_security1 WEAPONTYPE_PISTOL  999
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security1 player1
					ENDIF

					IF NOT IS_CHAR_DEAD	french_security2
						SET_CHAR_HEED_THREATS french_security2 TRUE
						SET_CHAR_PERSONALITY french_security2 PEDSTAT_TOUGH_GUY
						SET_CHAR_THREAT_SEARCH french_security2 THREAT_PLAYER1
						GIVE_WEAPON_TO_CHAR french_security2 WEAPONTYPE_PISTOL  999
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security2 player1
					ENDIF

					IF NOT IS_CHAR_DEAD	french_security3
						SET_CHAR_HEED_THREATS french_security3 TRUE
						SET_CHAR_PERSONALITY french_security3 PEDSTAT_TOUGH_GUY
						SET_CHAR_THREAT_SEARCH french_security3 THREAT_PLAYER1
						GIVE_WEAPON_TO_CHAR french_security3 WEAPONTYPE_PISTOL  999
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security3 player1
					ENDIF

					IF NOT IS_CHAR_DEAD	french_security4
						SET_CHAR_HEED_THREATS french_security4 TRUE
						SET_CHAR_PERSONALITY french_security4 PEDSTAT_TOUGH_GUY
						SET_CHAR_THREAT_SEARCH french_security4 THREAT_PLAYER1
						GIVE_WEAPON_TO_CHAR french_security4 WEAPONTYPE_PISTOL  999
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT french_security4 player1
					ENDIF

					IF NOT IS_CHAR_DEAD	the_seller
						ADD_BLIP_FOR_CHAR the_seller the_seller_blip
						PRINT_NOW COL2_B2 10000 1 //"The courier is fleeing with the guidance chips, don't let him get away!"
						CREATE_CAR PCJ600 41.7295 -897.1017 9.3919 the_sellers_car
						SET_CAR_HEADING	the_sellers_car	359.1412
						CREATE_CAR PCJ600 36.1736 -895.8868 9.3919 the_players_car
						SET_CAR_HEADING	the_players_car 266.8658
					ENDIF

					mall_shootout_counter = 13
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF mall_shootout_counter > 12
		IF NOT LOCATE_PLAYER_ANY_MEANS_2D player1 36.1736 -895.8868 120.0 120.0 0
			MARK_CAR_AS_NO_LONGER_NEEDED the_players_car
		ENDIF
	ENDIF
	
	IF mall_shootout_counter = 11
		IF HAS_MISSION_AUDIO_LOADED	2
			IF game_timer > mall_shootout_timer
				SET_FIXED_CAMERA_POSITION -16.7670 -942.2947 10.0640 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT -15.8789 -941.8711 10.2422 JUMP_CUT
				CLEAR_AREA -5.4288 -939.4909 13.0343 10.0 FALSE
				SWITCH_PED_ROADS_ON 0.7780 -944.7307 14.4913 7.0235 -931.7332 23.0981
				mall_shootout_timer	= game_timer + 2000
				mall_shootout_counter = 12
			ENDIF
		ENDIF
	ENDIF
	
	IF mall_shootout_counter = 10
		IF HAS_MISSION_AUDIO_FINISHED 2
			IF HAS_MISSION_AUDIO_LOADED	1
				IF game_timer > mall_shootout_timer
					LOAD_MISSION_AUDIO 2 COL2_8	//"Fill 'im full of ze lead!"
					PLAY_MISSION_AUDIO 1
					PRINT_NOW COL2_9 5000 1//You American idiot! They followed you here!
					the_seller_counter = 0
					mall_shootout_timer	= game_timer + 2000
					mall_shootout_counter = 11
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF mall_shootout_counter = 9
		IF HAS_MISSION_AUDIO_FINISHED 1
			IF HAS_MISSION_AUDIO_LOADED	2
				SET_FIXED_CAMERA_POSITION 2.7282 -949.3295 23.6051 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 2.7581 -948.4955 23.0540 JUMP_CUT
				
				IF NOT IS_CHAR_DEAD	french_security1
					SET_CHAR_COORDINATES french_security1 4.2931 -947.4683 -100.0
					SET_CHAR_OBJ_NO_OBJ	french_security1
					TURN_CHAR_TO_FACE_PLAYER french_security1 player1
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR french_security1 scplayer
				ENDIF
					
				IF NOT IS_CHAR_DEAD	french_security2
					SET_CHAR_COORDINATES french_security2 2.4581 -947.4636 -100.0
					SET_CHAR_OBJ_NO_OBJ	french_security2
					TURN_CHAR_TO_FACE_PLAYER french_security2 player1
					SET_CHAR_OBJ_AIM_GUN_AT_CHAR french_security2 scplayer
				ENDIF

				//French Special Forces (SHOUTING, outrageous French accent):
				PRINT_NOW COL2_6A 5000 1//"Freeze imperialist American pig! Zat iz zee propertay of ze French government. 'And eet over!"
				PLAY_MISSION_AUDIO 2
				LOAD_MISSION_AUDIO 1 COL2_9 //You American idiot! They followed you here!
				
				mall_shootout_timer	= game_timer + 1000
				mall_shootout_counter = 10
			ENDIF
		ENDIF
	ENDIF

	IF mall_shootout_counter = 8
		CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 2.5231 -924.9479 9.3967 french_security3
		CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 5.3188 -924.7693 9.3965 french_security4

		SET_CHAR_USE_PEDNODE_SEEK french_security3 FALSE
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	french_security3 2.7139 -936.8358
		SET_CHAR_USE_PEDNODE_SEEK french_security3 FALSE
		SET_CHAR_USE_PEDNODE_SEEK french_security4 FALSE
		SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	french_security4 4.6123 -937.3372
		SET_CHAR_USE_PEDNODE_SEEK french_security4 FALSE

		mall_shootout_counter = 9
	ENDIF

	IF mall_shootout_counter = 7
		IF HAS_MISSION_AUDIO_FINISHED 2
			IF HAS_MISSION_AUDIO_LOADED	1
				//Courier:
				PRINT_NOW COL2_5 2000 1//"Oh...ok."
				PLAY_MISSION_AUDIO 1
				LOAD_MISSION_AUDIO 2 COL2_6A//"Freeze imperialist American pig! Zat iz zee propertay of ze French government. 'And eet over!"
				
				SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT the_seller player1
				mall_shootout_timer	= game_timer + 700
				mall_shootout_counter = 8
			ENDIF
		ENDIF
	ENDIF

	IF mall_shootout_counter = 6
		IF HAS_MISSION_AUDIO_FINISHED 1
			IF HAS_MISSION_AUDIO_LOADED 2
				//player1:
				PRINT_NOW COL2_4 3000 1//"Look, Cortez sent me. Just give me the damned chips."
				PLAY_MISSION_AUDIO 2
				LOAD_MISSION_AUDIO 1 COL2_5//"Oh...ok."

				mall_shootout_timer	= game_timer + 4000
				mall_shootout_counter = 7
			ENDIF
		ENDIF
	ENDIF
	
	IF mall_shootout_counter = 5
		IF HAS_MISSION_AUDIO_FINISHED 2
			IF HAS_MISSION_AUDIO_LOADED 1
				//Courier:
				PRINT_NOW COL2_3 2000 1//"Que?"
				PLAY_MISSION_AUDIO 1
				LOAD_MISSION_AUDIO 2 COL2_4	//"Look, Cortez sent me. Just give me the damned chips."
				mall_shootout_counter = 6
			ENDIF
		ENDIF
	ENDIF

	IF mall_shootout_counter = 4
		IF HAS_MISSION_AUDIO_LOADED	2
			IF HAS_MISSION_AUDIO_FINISHED 1
				SET_FIXED_CAMERA_POSITION 3.8965 -930.5530 16.1132 0.0 0.0 0.0//PULL BACK SHOT FROM THE SIDE
				POINT_CAMERA_AT_POINT 3.8828 -931.5497 16.1934 JUMP_CUT
				TURN_CHAR_TO_FACE_PLAYER the_seller player1
				
				//player1:
				PRINT_NOW COL2_2 5000 1//"What?"
				PLAY_MISSION_AUDIO 2
				LOAD_MISSION_AUDIO 1 COL2_3//"ah...common?"
				
				CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 4.6792 -951.7053 20.7330 french_security1
				CREATE_CHAR PEDTYPE_CIVMALE	SPECIAL01 2.1545 -954.6406 20.7330 french_security2
				SET_CHAR_USE_PEDNODE_SEEK french_security1 FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	french_security1 4.2931 -947.4683
				SET_CHAR_USE_PEDNODE_SEEK french_security1 FALSE
				SET_CHAR_USE_PEDNODE_SEEK french_security2 FALSE
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	french_security2 2.4581 -947.4636
				SET_CHAR_USE_PEDNODE_SEEK french_security2 FALSE

				mall_shootout_timer	= game_timer + 1000
				mall_shootout_counter = 5
			ENDIF
		ENDIF
	ENDIF

	IF mall_shootout_counter = 3
		IF game_timer > mall_shootout_timer
			GET_CHAR_HEADING the_seller the_seller_heading
			the_seller_heading -= 12.0
			IF the_seller_heading < 115.6022
				the_seller_heading = 115.6022
				IF HAS_MISSION_AUDIO_LOADED 1
					mall_shootout_timer	= game_timer + 1500
					mall_shootout_counter = 4
					
					//Courier (silly French accent):
					PRINT_NOW COL2_1 5000 1//"Ze rain, she is tres wet zis time of year."
					PLAY_MISSION_AUDIO 1
				ENDIF
			ENDIF
			SET_CHAR_HEADING the_seller the_seller_heading
			STOP_CHAR_LOOKING the_seller
			CHAR_LOOK_AT_PLAYER_ALWAYS the_seller player1
		ENDIF
	ENDIF

	IF mall_shootout_counter = 2
		IF game_timer > mall_shootout_timer
			SET_CHAR_WAIT_STATE the_seller WAITSTATE_CROSS_ROAD_LOOK 900
			mall_shootout_timer	= game_timer + 1000
			mall_shootout_counter = 3
		ENDIF
	ENDIF

	IF mall_shootout_counter = 1
		mall_shootout_timer	= game_timer + 500
		mall_shootout_counter = 2
	ENDIF

	IF mall_shootout_counter = 0
		IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player1 the_seller 3.0 3.0 2.0 0
			REMOVE_BLIP	the_seller_blip
			SET_PLAYER_CONTROL player1 OFF
			SET_EVERYONE_IGNORE_PLAYER player1 TRUE
			SWITCH_WIDESCREEN ON
			SET_ALL_CARS_CAN_BE_DAMAGED FALSE
			SET_CHAR_OBJ_NO_OBJ	the_seller
			CLEAR_AREA 4.1929 -938.9565 15.0760 5.0 1
			SET_PLAYER_COORDINATES player1 3.0914 -938.5570 15.0760//TOP OF ESCALATOR
			TURN_PLAYER_TO_FACE_CHAR player1 the_seller
			SET_FIXED_CAMERA_POSITION 8.1222 -935.5150 17.0304 0.0 0.0 0.0//OVER SELLERS SHOULDER
			POINT_CAMERA_AT_POINT 7.3126 -936.0714 16.8437 JUMP_CUT
			SET_CHAR_COORDINATES the_seller 6.1112 -937.0656 15.0760
			SET_CHAR_HEADING the_seller	262.8159
			SWITCH_PED_ROADS_OFF 0.7780 -944.7307 14.4913 7.0235 -931.7332 23.0981
			CLEAR_AREA 3.6782 -939.0247 16.0038 6.0 FALSE
			//CLEAR_TAXI_SHORTCUT
			REMOVE_BLIP	weapon_shop1_blip
			ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD ammu1X ammu1Y ammu1Z RADAR_SPRITE_GUN weapon_shop1_blip
			mall_shootout_counter = 1
		ENDIF
	ENDIF
	/////////
	/////////

	IF mall_shootout_counter > 10
		IF NOT IS_CHAR_DEAD	the_seller
			GET_CHAR_COORDINATES the_seller the_seller_x the_seller_y the_seller_z
			IF the_seller_counter = 0
				SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
				SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 1.8336 -938.0876
				SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
				SET_CHAR_ONLY_DAMAGED_BY_PLAYER the_seller FALSE
				the_seller_counter = 1
			ENDIF
			IF the_seller_counter = 1
				IF LOCATE_CHAR_ON_FOOT_2D the_seller 1.8336 -938.0876 1.0 1.0 0
					SET_CHAR_OBJ_SPRINT_TO_COORD the_seller -11.6307 -938.0319
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					the_seller_counter = 2
				ENDIF
			ENDIF
			IF the_seller_counter = 2
				IF LOCATE_CHAR_ON_FOOT_2D the_seller -11.6307 -938.0319 1.0 1.0 0
					SET_CHAR_OBJ_SPRINT_TO_COORD the_seller -11.4825 -935.4515
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					the_seller_counter = 3
				ENDIF
			ENDIF
			IF the_seller_counter = 3
				IF LOCATE_CHAR_ON_FOOT_2D the_seller -11.4825 -935.4515 1.0 1.0 0
					SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 1.7873 -928.6034//
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					the_seller_counter = 4
				ENDIF
			ENDIF
			IF the_seller_counter = 4
				IF LOCATE_CHAR_ON_FOOT_2D the_seller 1.7873 -928.6034 1.0 1.0 0
					SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 5.9929 -904.0090
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					the_seller_counter = 5
				ENDIF
			ENDIF
			IF the_seller_counter = 5
				IF LOCATE_CHAR_ON_FOOT_2D the_seller 5.9929 -904.0090 1.0 1.0 0
					SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 40.2117 -897.6254
					SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
					the_seller_counter = 6
				ENDIF
			ENDIF
			IF the_seller_counter = 6
				IF LOCATE_CHAR_ON_FOOT_2D the_seller 40.2117 -897.6254 1.0 1.0 0
					IF NOT IS_CAR_DEAD the_sellers_car
						SET_CHAR_RUNNING the_seller TRUE
						SET_CHAR_USE_PEDNODE_SEEK the_seller TRUE
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER the_seller	the_sellers_car
						the_seller_counter = 7
					ENDIF
				ENDIF
			ENDIF
			IF mall_shootout_counter > 13
				IF the_seller_counter = 7
					IF NOT IS_CAR_DEAD the_sellers_car
						IF IS_CHAR_IN_CAR the_seller the_sellers_car
							CAR_GOTO_COORDINATES the_sellers_car 267.4104 1287.8461 16.1968
							SET_CAR_CRUISE_SPEED the_sellers_car 25.0
							SET_CAR_DRIVING_STYLE the_sellers_car 2
							IF audio_2_flag = 0
								audio_2_flag = 1
								audio_2_timeout = game_timer + 6000
							ENDIF
							the_seller_counter = 8
						ENDIF
					ELSE
						IF NOT IS_CURRENT_CHAR_WEAPON the_seller WEAPONTYPE_UZI
							GIVE_WEAPON_TO_CHAR the_seller WEAPONTYPE_UZI 9999
							SET_CHAR_OBJ_NO_OBJ	the_seller
						ENDIF
						IF audio_4_flag = 0
							audio_4_flag = 1
							audio_4_timeout = game_timer + 6000
						ENDIF
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT the_seller player1
					ENDIF
				ENDIF
			ENDIF

			IF the_seller_counter > 7
				IF NOT IS_CAR_DEAD the_sellers_car
					IF IS_CHAR_IN_CAR the_seller the_sellers_car
						GET_PLAYER_COORDINATES player1 player_x	player_y z
						GET_CHAR_COORDINATES the_seller x y z
						x_temp = player_x - x // dist = (1_x - 2_x)~2  +  (1_y - 2_y)~2
						y_temp = player_y - y
						x_temp = x_temp * x_temp
						y_temp = y_temp * y_temp
						sum_x_y_temp = x_temp + y_temp
						SQRT sum_x_y_temp sum_x_y_temp
						
						criminal1_car_speed = 800.0 / sum_x_y_temp

						IF criminal1_car_speed > 38.0
							criminal1_car_speed = 38.0
						ENDIF
						IF criminal1_car_speed < 10.0
							criminal1_car_speed = 10.0
						ENDIF
						SET_CAR_CRUISE_SPEED the_sellers_car criminal1_car_speed
					ENDIF
				ENDIF
			ENDIF
			
			IF the_seller_counter = 8
				IF NOT IS_CHAR_IN_ANY_CAR the_seller
					IF NOT IS_CAR_DEAD the_sellers_car
						IF audio_3_flag = 0
							audio_3_flag = 1
							audio_3_timeout = game_timer + 6000
						ENDIF
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER the_seller	the_sellers_car
						the_seller_counter = 9
					ELSE
						SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS the_seller player1
						IF audio_5_flag = 0
							audio_5_flag = 1
							audio_5_timeout = game_timer + 6000
						ENDIF
					ENDIF
				ELSE
					IF NOT IS_CAR_DEAD the_sellers_car
						IF destination_counter = 0
							IF LOCATE_CAR_2D the_sellers_car 267.4104 1287.8461 15.0 15.0 0
								SET_CAR_TEMP_ACTION	the_sellers_car TEMPACT_TURNLEFT 200
								destination_timer = game_timer + 199
								destination_counter = 1
							ENDIF
						ENDIF
						IF destination_counter = 1
							IF game_timer >	destination_timer
								SET_CAR_TEMP_ACTION	the_sellers_car TEMPACT_HANDBRAKETURNLEFT 5000
								destination_counter = 2
							ENDIF
						ENDIF
						IF destination_counter = 2
							IF IS_CAR_STOPPED the_sellers_car
								SET_CAR_TEMP_ACTION	the_sellers_car TEMPACT_WAIT 5000
								SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 266.1230 1297.0134
								SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
								the_seller_counter = 10
								destination_counter = 3
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			IF the_seller_counter = 9
				IF NOT IS_CAR_DEAD the_sellers_car
					IF IS_CHAR_IN_CAR the_seller the_sellers_car
						SET_CAR_CRUISE_SPEED the_sellers_car 25.0
						SET_CAR_DRIVING_STYLE the_sellers_car 2
						CAR_GOTO_COORDINATES the_sellers_car 267.4104 1287.8461 16.1968
						the_seller_counter = 8
					ENDIF
				ELSE
					IF NOT IS_CURRENT_CHAR_WEAPON the_seller WEAPONTYPE_UZI
						GIVE_WEAPON_TO_CHAR the_seller WEAPONTYPE_UZI 9999
						SET_CHAR_OBJ_NO_OBJ	the_seller
					ENDIF
					IF audio_4_flag = 0
						audio_4_flag = 1
						audio_4_timeout = game_timer + 6000
					ENDIF
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT the_seller player1
				ENDIF
			ENDIF
			IF the_seller_counter = 10
				IF destination_counter < 4
					IF LOCATE_CHAR_ON_FOOT_2D the_seller 266.1230 1297.0134 1.0 1.0 0
						SET_CHAR_OBJ_SPRINT_TO_COORD the_seller 264.7184 1307.3624
						SET_CHAR_USE_PEDNODE_SEEK the_seller FALSE
						destination_counter = 4
					ENDIF
				ENDIF
				IF destination_counter = 4
					IF LOCATE_CHAR_ON_FOOT_2D the_seller 264.7184 1307.3624 1.0 1.0 0
						DELETE_CHAR	the_seller
						PRINT_NOW COL2_F4 5000 1//~r~The courier has escaped! You failed to get the chips.
						GOTO mission_general2_failed
					ENDIF
				ENDIF
			ENDIF
	
			IF audio_1_flag = 2
				IF HAS_MISSION_AUDIO_FINISHED 1
					//CLEAR_THIS_PRINT COL2_7
					audio_1_flag = 3
					is_audio_in_use = 0
					GOTO mall_shootout_loop
				ENDIF
			ENDIF
			IF audio_1_flag = 1
				IF HAS_MISSION_AUDIO_LOADED 1
					PLAY_MISSION_AUDIO 1
					//IF print_timer < game_timer
						//PRINT_NOW COL2_7 10000 1//Shoot 'im!
					//ENDIF
					audio_1_flag = 2
				ENDIF
			ENDIF
			IF audio_1_flag = 0
				IF is_audio_in_use = 0
					LOAD_MISSION_AUDIO 1 COL2_7
					audio_1_flag = 1
					is_audio_in_use = 1
				ENDIF
			ENDIF

			//First gets on bike:
			//[COL2_10]
			//Au revoir, you cretin!
			IF audio_2_flag > 0
				IF audio_2_flag = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_10
						audio_2_flag = 0
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_2_flag = 2
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z
						SET_MISSION_AUDIO_POSITION 1 x y z
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_10 10000 1//Au revoir, you cretin!
						//ENDIF
						audio_2_flag = 3
					ENDIF
				ENDIF
				IF audio_2_flag = 1
					IF is_audio_in_use = 0
						LOAD_MISSION_AUDIO 1 COL2_10
						audio_2_flag = 2
						is_audio_in_use = 1
//					ELSE
//						IF game_timer >	audio_2_timeout
//							audio_2_flag = 0 
//						ENDIF
					ENDIF
				ENDIF
			ENDIF

			//GETS KNOCKED/FALLS OFF BIKE:
			//[COL2_11]
			//Merd! My bike, kaput!
			IF audio_3_flag > 0
				IF audio_3_flag = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_11
						audio_3_flag = 0
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_3_flag = 2
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z
						SET_MISSION_AUDIO_POSITION 1 x y z
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_11 10000 1 //Merd! My bike, kaput!
						//ENDIF
						audio_3_flag = 3
					ENDIF
				ENDIF
				IF audio_3_flag = 1
					IF is_audio_in_use = 0
						LOAD_MISSION_AUDIO 1 COL2_11
						audio_3_flag = 2
						is_audio_in_use = 1
//					ELSE
//						IF game_timer >	audio_3_timeout
//							audio_3_flag = 0 
//						ENDIF
					ENDIF
				ENDIF
			ENDIF

			//ATTACKS PLAYER:
			//[COL2_12]
			//You cannot have the guidance chips, monkey bottom boy!
			IF audio_4_flag > 0
				IF audio_4_flag = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_12
						audio_4_flag = 4
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_4_flag = 2
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z
						SET_MISSION_AUDIO_POSITION 1 x y z
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_12 10000 1 //You cannot have the guidance chips, monkey bottom boy!
						//ENDIF
						audio_4_flag = 3
					ENDIF
				ENDIF
				IF audio_4_flag = 1
					IF is_audio_in_use = 0
						LOAD_MISSION_AUDIO 1 COL2_12
						audio_4_flag = 2
						is_audio_in_use = 1
//					ELSE
//						IF game_timer >	audio_4_timeout
//							audio_4_flag = 0 
//						ENDIF
					ENDIF
				ENDIF
			ENDIF

			//RUNS AWAY ON FOOT:
			//[COL2_13]
			//I make like the antelope!
			IF audio_5_flag > 0
				IF audio_5_flag = 3
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_13
						audio_5_flag = 4
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_5_flag = 2
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z
						SET_MISSION_AUDIO_POSITION 1 x y z
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_13 10000 1 //I make like the antelope!
						//ENDIF
						audio_5_flag = 3
					ENDIF
				ENDIF
				IF audio_5_flag = 1
					IF is_audio_in_use = 0
						LOAD_MISSION_AUDIO 1 COL2_13
						audio_5_flag = 2
						is_audio_in_use = 1
//					ELSE
//						IF game_timer >	audio_5_timeout
//							audio_5_flag = 0 
//						ENDIF
					ENDIF
				ENDIF
			ENDIF

			//PLAYER GETS CLOSE WHILE HE'S SPEEDING AWAY ON HIS BIKE:
			//[COL2_14]
			//You got to do better, Mr. Snail!
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 the_seller 15.0 15.0 0
				IF player_close_to_seller = 0
					player_close_to_seller = 1
				ENDIF
			ELSE
				player_close_to_seller = 0
			ENDIF

			IF mall_shootout_counter > 12
				IF audio_6_flag = 2
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_14
						audio_6_flag = 3
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_6_flag = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI: uncommented
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI: uncommented
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_14 10000 1 //You got to do better, Mr. Snail!
						//ENDIF
						audio_6_flag = 2
					ENDIF
				ENDIF
				IF player_close_to_seller = 1
					IF audio_6_flag = 0
						IF is_audio_in_use = 0
							LOAD_MISSION_AUDIO 1 COL2_14
							audio_6_flag = 1
							is_audio_in_use = 1
							player_close_to_seller = 2
							GOTO mall_shootout_loop
						ENDIF
					ENDIF
				ENDIF
				
				//[COL2_15]
				//Ha! You eat my dirt!
				IF audio_7_flag = 2
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_15
						audio_7_flag = 3
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_7_flag = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI: uncommented
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI: uncommented
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_15 10000 1 //Ha! You eat my dirt!
						//ENDIF
						audio_7_flag = 2
					ENDIF
				ENDIF
				IF player_close_to_seller = 1
					IF audio_7_flag = 0
						IF is_audio_in_use = 0
							LOAD_MISSION_AUDIO 1 COL2_15
							audio_7_flag = 1
							is_audio_in_use = 1
							player_close_to_seller = 2
							GOTO mall_shootout_loop
						ENDIF
					ENDIF
				ENDIF
				
				//[COL2_16]
				//Slow, fat, American poop-head!
				IF audio_8_flag = 2
					IF HAS_MISSION_AUDIO_FINISHED 1
						//CLEAR_THIS_PRINT COL2_16
						audio_8_flag = 3
						is_audio_in_use = 0
						GOTO mall_shootout_loop
					ELSE // FIXMIAMI
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI
					ENDIF
				ENDIF
				IF audio_8_flag = 1
					IF HAS_MISSION_AUDIO_LOADED 1
						GET_CHAR_COORDINATES the_seller x y z // FIXMIAMI: uncommented
						SET_MISSION_AUDIO_POSITION 1 x y z // FIXMIAMI: uncommented
						PLAY_MISSION_AUDIO 1
						//IF print_timer < game_timer
							//PRINT_NOW COL2_16 10000 1 //You got to do better, Mr. Snail!
						//ENDIF
						audio_8_flag = 2
					ENDIF
				ENDIF
				IF player_close_to_seller = 1
					IF audio_8_flag = 0
						IF is_audio_in_use = 0
							LOAD_MISSION_AUDIO 1 COL2_16
							audio_8_flag = 1
							is_audio_in_use = 1
							player_close_to_seller = 2
							GOTO mall_shootout_loop
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			IF chips_pickup_flag = 0
				CLEAR_MISSION_AUDIO 1
				CLEAR_MISSION_AUDIO 2
				IF NOT IS_CHAR_IN_WATER	the_seller
					PRINT_NOW COL2_F2 5000 1//"The courier is dead. Grab the guidance chips."
					REMOVE_BLIP	the_seller_blip
					IF DOES_CHAR_EXIST the_seller
						GET_DEAD_CHAR_PICKUP_COORDS the_seller x y z
						CREATE_PICKUP briefcase PICKUP_ONCE x y z the_chips
					ELSE
						CREATE_PICKUP briefcase PICKUP_ONCE the_seller_x the_seller_y the_seller_z the_chips
					ENDIF
					REMOVE_BLIP	the_seller_blip
					ADD_BLIP_FOR_PICKUP the_chips the_seller_blip
					chips_pickup_flag = 1
				ELSE
					PRINT_NOW COL2_F3 5000 1//~r~The guidance chips are at the bottom of the sea.
					GOTO mission_general2_failed
				ENDIF
			ENDIF
			IF chips_pickup_flag = 1
				IF HAS_PICKUP_BEEN_COLLECTED the_chips
					chips_pickup_flag = 2
					REMOVE_BLIP	the_seller_blip
					ADD_BLIP_FOR_COORD -245.0020 -1360.8174 7.0786 the_seller_blip
					PRINT_NOW COL2_B3 5000 1//"~g~Take the guidance chips back to the Colonel"
					ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				ENDIF
			ENDIF
			IF chips_pickup_flag = 2
				IF LOCATE_PLAYER_ON_FOOT_3D	player1 -245.0020 -1360.8174 7.0786 2.0 2.0 3.0	1
					SET_PLAYER_CONTROL player1 OFF
					SET_EVERYONE_IGNORE_PLAYER player1 TRUE
					SET_ALL_CARS_CAN_BE_DAMAGED FALSE
					WAIT 0
					WAIT 0
					SET_FIXED_CAMERA_POSITION -245.1924 -1364.1660 8.6417 0.0 0.0 0.0
					POINT_CAMERA_AT_POINT -246.0084 -1363.5885 8.6193 JUMP_CUT
					SET_PLAYER_COORDINATES player1 -245.0020 -1360.8174 7.0786
					
					SWITCH_WIDESCREEN ON
					SET_CHAR_OBJ_RUN_TO_COORD scplayer -258.4183 -1360.6534
					WAIT 1000
					SET_FADING_COLOUR 0 0 1
					DO_FADE 1000 FADE_OUT
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					SET_CHAR_OBJ_NO_OBJ	scplayer
					CLEAR_AREA -244.2799 -1360.6704 7.0786 1.0 TRUE
					SET_PLAYER_COORDINATES player1 -244.2799 -1360.6704 7.0786
					SET_PLAYER_HEADING player1 279.1362
					SET_CAMERA_BEHIND_PLAYER
					RESTORE_CAMERA_JUMPCUT
					SWITCH_WIDESCREEN OFF
					SET_FADING_COLOUR 0 0 1
					DO_FADE 1000 FADE_IN
					WHILE GET_FADING_STATUS
						WAIT 0
					ENDWHILE
					GOTO mission_general2_passed
				ENDIF
			ENDIF
		ENDIF
	ENDIF

GOTO mall_shootout_loop


	   		
	
// Mission general2 failed

mission_general2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// mission general2 passed

mission_general2_passed:

flag_general_mission2_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 500 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 500
REGISTER_MISSION_PASSED COL_2
PLAY_MISSION_PASSED_TUNE 1
PLAYER_MADE_PROGRESS 1
shotgun_in_stock = 1
START_NEW_SCRIPT general_mission3_loop
RETURN
		


// mission cleanup

mission_cleanup_general2:

flag_player_on_mission = 0

IF chips_pickup_flag = 1
	REMOVE_PICKUP the_chips
ENDIF

REMOVE_CHAR_ELEGANTLY the_seller
REMOVE_CHAR_ELEGANTLY french_security1
REMOVE_CHAR_ELEGANTLY french_security2
REMOVE_CHAR_ELEGANTLY french_security3
REMOVE_CHAR_ELEGANTLY french_security4
REMOVE_CHAR_ELEGANTLY french_security5
REMOVE_CHAR_ELEGANTLY french_security6
REMOVE_CHAR_ELEGANTLY french_security7
REMOVE_CHAR_ELEGANTLY french_security8
REMOVE_CHAR_ELEGANTLY french_security9

REMOVE_BLIP	weapon_shop1_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD ammu1X ammu1Y ammu1Z RADAR_SPRITE_GUN weapon_shop1_blip
REMOVE_BLIP the_seller_blip

SWITCH_PED_ROADS_ON 0.7780 -944.7307 14.4913 7.0235 -931.7332 23.0981

MARK_MODEL_AS_NO_LONGER_NEEDED PCJ600
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED UZI
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

//CLEAR_TAXI_SHORTCUT

GET_GAME_TIMER timer_mobile_start

MISSION_HAS_FINISHED
RETURN
}