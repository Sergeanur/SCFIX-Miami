MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Protect3****************************************
// *****************************************Disguise****************************************
// *****************************************************************************************
// *****************************************************************************************
// Cop land

SCRIPT_NAME protec3
// Mission start stuff
GOSUB mission_start_protec3
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_protec3
ENDIF
GOSUB mission_cleanup_protec3
MISSION_END
{ 
// Variables for mission
//people, cars and objects
VAR_INT cop1
VAR_INT cop2 
VAR_INT cop3 
VAR_INT cop4 
VAR_INT waitingarmy1
VAR_INT waitingarmy2
VAR_INT fbidoor1
VAR_INT fbidoor2
VAR_INT fbidoor3
VAR_INT fbidoor4
VAR_INT fbidoor5
VAR_INT fbidoor6																 
VAR_INT fbidoor7
VAR_INT mall_fire1
VAR_INT mall_fire2
VAR_INT mall_fire3
VAR_INT mall_fire4
VAR_INT mall_fire5
VAR_INT player_buddy_car
VAR_INT prot_cash_pickup
VAR_INT free_sentinel_car
VAR_INT free_cop_car
VAR_INT cop1_in_garage
VAR_INT cop2_in_garage
VAR_INT cop3_in_garage
VAR_INT cop4_in_garage
VAR_INT dyn1
VAR_INT dyn2
VAR_INT dyn3
VAR_INT dyn4
VAR_INT dyn5
VAR_INT counted_once3
VAR_INT counted_once4

//blips
VAR_INT bombplace
VAR_INT cop_garage
VAR_INT boutique1
VAR_INT radar_blip_buddy

//flags
VAR_INT disguise_goals 
VAR_INT gotpolice
VAR_INT flag_buddy_in_group_prot3
VAR_INT timer_flag
VAR_INT flag_cops_alerted
VAR_INT speech_played
VAR_INT speech_played2
VAR_INT speech_played3
VAR_INT player_in_coffee_shop
VAR_FLOAT player_buddy_car_speed   
VAR_INT prot3_print_flag
VAR_INT cop3_flag
VAR_INT cop4_flag

// ****************************************Mission Start************************************
mission_start_protec3:
CLEAR_THIS_PRINT M_FAIL
CLEAR_WANTED_LEVEL player1 
flag_player_on_mission = 1
flag_player_on_army_ped_mission = 1
REGISTER_MISSION_GIVEN
WAIT 0
LOAD_MISSION_TEXT PROT3 
IF NOT IS_CHAR_DEAD scplayer
    UNDRESS_CHAR scplayer player
    LOAD_ALL_MODELS_NOW
    IF NOT IS_CHAR_DEAD scplayer
        DRESS_CHAR scplayer
    ENDIF
ENDIF
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -288.2 -487.5 9.8 275.0
// *****************************************Set Flags/variables************************************

disguise_goals = 0  //test - should be set to 0 for proper game
gotpolice = 0
flag_buddy_in_group_prot3 = 1
timer_flag = 0
flag_cops_alerted = 0
speech_played = 0
speech_played2 = 0
speech_played3 = 0
player_in_coffee_shop = 0
prot3_print_flag = 0
cop3_flag = 0
cop4_flag = 0
cop1_in_garage = 0
cop2_in_garage = 0
cop3_in_garage = 0
cop4_in_garage = 0
counted_once3 = 0
counted_once4 = 0

player_buddy_car_speed= 0.0

// ****************************************START OF CUTSCENE********************************
//SET_AREA_VISIBLE VIS_MANSION 
//SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSbuddy
LOAD_SPECIAL_CHARACTER 3 dgoona

LOAD_SCENE -378.62 -552.676 18.534

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0
ENDWHILE

LOAD_CUTSCENE bud_3
SET_CUTSCENE_OFFSET -378.62 -552.676 18.534
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_buddy
SET_CUTSCENE_ANIM cs_buddy CSbuddy

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_dgoona
SET_CUTSCENE_ANIM cs_dgoona dgoona

CLEAR_AREA -379.0 -539.6 19.8 60.0 TRUE
SET_PED_DENSITY_MULTIPLIER 0.0
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 640  //FIRST CUTSCENE TIME GOES HERE
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
 
PRINT_NOW PRO3_A 10000 1 //You moron! What were you thinking?!

WHILE cs_time < 3260
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_B 10000 1 //Do you realize what this means?!

WHILE cs_time < 5037
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_C 10000 1 //We could all be sunk! 

WHILE cs_time < 6257
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_D 10000 1 //The timer must have got screwed.

WHILE cs_time < 8063
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_E 10000 1 //That place was wired to go up like a firework factory.

WHILE cs_time < 10576
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_F 10000 1 //Then somebody tipped off the cops... 

WHILE cs_time < 12294
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_G 10000 1 //what's the problem fellas? 

WHILE cs_time < 13350
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_H 10000 1 //Mike was supposed to torch some place in the mall, 

WHILE cs_time < 15890
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_I 10000 1 //but he screwed the fuses and now the cops are crawling all over it. 

WHILE cs_time < 19687
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_J 10000 1 //We gotta get our stuff and get out of here!

WHILE cs_time < 21037
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_K 10000 1 //Relax, both of you, let me think for a second! 

WHILE cs_time < 23717
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_L 10000 1 //Tommy Vercetti doesn't just cut and run. 

WHILE cs_time < 29837
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_M 10000 1 //The cops will be going over that building with a fine toothed comb, 

WHILE cs_time < 33146
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_N 10000 1 //but that takes time. 

WHILE cs_time < 34850
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_O 10000 1 //We gotta go in and torch that place ourselves. 

WHILE cs_time < 36855
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_P 10000 1 //Yeah, but... 

WHILE cs_time < 37233
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_Q 10000 1 //No one but a cop could get within a mile of that place! 

WHILE cs_time < 39659
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_R 10000 1 //So we go as cops. 

WHILE cs_time < 41424
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_S 10000 1 //We get the uniforms - and we're gonna need a squad car.

WHILE cs_time < 44643
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_T 10000 1 //All thanks to you Mike.

WHILE cs_time < 45615
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_U 10000 1 //I'm sorry. 

WHILE cs_time < 46434
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_V 10000 1 //I got it. 

WHILE cs_time < 48010
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_W 10000 1 //What we got to do is lure the cops in with the finger,

WHILE cs_time < 50758
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_X 10000 1 //put them in a lock-up

WHILE cs_time < 52122
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_Y 10000 1 //and jump 'em..

WHILE cs_time < 52864
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_Z 10000 1 //Good plan. Let's go!

WHILE cs_time < 54506
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW PRO3_A1 10000 1 //Alright.

WHILE cs_time < 55506
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 56320
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
SET_PED_DENSITY_MULTIPLIER 1.0
SET_CAR_DENSITY_MULTIPLIER 1.0
flag_player_in_mansion = 0
// ******************************************END OF CUTSCENE********************************
SET_FADING_COLOUR 0 0 0
WAIT 500
SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_COORDINATES player1 -353.1 -526.4 11.7 
LOAD_SCENE -353.1 -510.4 11.7 
SET_PLAYER_HEADING player1 304.3
SET_PLAYER_CONTROL player1 ON
//------------------REQUEST_MODELS ------------------------------
SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

//remove clothes picups
REMOVE_PICKUP mansion_clothes 
REMOVE_PICKUP safehouse_clothes2
REMOVE_PICKUP clothes_pickup1
REMOVE_PICKUP clothes_pickup2
REMOVE_PICKUP clothes_pickup3
REMOVE_PICKUP clothes_pickup4
REMOVE_PICKUP clothes_pickup5
REMOVE_PICKUP clothes_pickup6
REMOVE_PICKUP clothes_pickup7
REMOVE_PICKUP clothes_pickup8
REMOVE_PICKUP clothes_pickup9
REMOVE_PICKUP clothes_pickup13

REQUEST_MODEL dynamite 
REQUEST_MODEL cop
REQUEST_MODEL army
REQUEST_MODEL nitestick

REQUEST_MODEL buddyshot
REQUEST_MODEL m4
REQUEST_MODEL sentinel
REQUEST_MODEL police
REQUEST_MODEL colt45

WHILE NOT HAS_MODEL_LOADED cop
OR NOT HAS_MODEL_LOADED army
OR NOT HAS_MODEL_LOADED dynamite
OR NOT HAS_MODEL_LOADED nitestick
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED buddyshot			   
OR NOT HAS_MODEL_LOADED m4 
OR NOT HAS_MODEL_LOADED sentinel 
OR NOT HAS_MODEL_LOADED police 
OR NOT HAS_MODEL_LOADED colt45 
	WAIT 0
ENDWHILE

LOAD_SPECIAL_CHARACTER 1 igbuddy
LOAD_SPECIAL_CHARACTER 2 IGBudy2
LOAD_SPECIAL_CHARACTER 3 player6
LOAD_ALL_MODELS_NOW

WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2 
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
	WAIT 0
ENDWHILE

LOAD_ALL_MODELS_NOW


LOAD_MISSION_AUDIO 1 BUD3_1a
LOAD_MISSION_AUDIO 2 BUD3_1b

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE 

SET_ZONE_PED_INFO RICH1 DAY   (13) 0 0 0 0 0 0 0 0 0 1000 
SET_ZONE_PED_INFO RICH1 NIGHT (10) 0 0 0 0 0 0 0 0 0 1000
SET_ZONE_CAR_INFO RICH1 DAY   (12) 0 0 0 0 0 0 0 0 0 1000 
SET_ZONE_CAR_INFO RICH1 NIGHT (10) 0 0 0 0 0 0 0 0 0 1000 
SET_ZONE_CIVILIAN_CAR_INFO RICH1 DAY   90 0 400 400 0 0 100 0 10 500 500
SET_ZONE_CIVILIAN_CAR_INFO RICH1 NIGHT 90 0 400 400 0 0 100 0 10 500 500
SET_ZONE_GROUP RICH1 DAY RICH1_PEDGRP
SET_ZONE_GROUP RICH1 NIGHT RICH1_NIGHT_PEDGRP

SET_ZONE_PED_INFO SHOP1 DAY   (30) 0 0 0 0 0 0 0 0 0 1000 
SET_ZONE_PED_INFO SHOP1 NIGHT (20) 0 0 0 0 0 0 0 0 0 1000
SET_ZONE_CAR_INFO SHOP1 DAY   (15) 0 0 0 0 0 0 0 0 0 1000 
SET_ZONE_CAR_INFO SHOP1 NIGHT (13) 0 0 0 0 0 0 0 0 0 1000 
SET_ZONE_CIVILIAN_CAR_INFO SHOP1 DAY   250 250 200 0 100 0 200 0 0 500 500
SET_ZONE_CIVILIAN_CAR_INFO SHOP1 NIGHT 250 250 200 0 100 0 200 0 0 500 500
SET_ZONE_GROUP SHOP1 DAY SHOP1_PEDGRP
SET_ZONE_GROUP SHOP1 NIGHT SHOP1_NIGHT_PEDGRP

IF flag_player_on_mission = 0
	ADD_BLIP_FOR_COORD 471.0 1028.0 19.1 bombplace
	GET_RANDOM_COP_IN_AREA 587.7 -70.7 551.6 -110.6 1 0 0 0 0 cop2
	ADD_BLIP_FOR_COORD 157.4 -1277.0 9.4 boutique1
ENDIF

CREATE_CHAR PEDTYPE_GANG_PLAYER SPECIAL01 -351.3 -525.1 11.7 buddy
SET_CHAR_HEADING buddy 124.3 
SET_CHAR_AS_PLAYER_FRIEND buddy player1 TRUE

CLEAR_CHAR_THREAT_SEARCH buddy
SET_CHAR_PERSONALITY buddy PEDSTAT_TOUGH_GUY
SET_CHAR_ONLY_DAMAGED_BY_PLAYER buddy TRUE 
SET_CHAR_CANT_BE_DRAGGED_OUT buddy TRUE
GIVE_WEAPON_TO_CHAR buddy WEAPONTYPE_STUBBY_SHOTGUN 30000
SET_CHAR_RUNNING buddy TRUE
SET_PLAYER_AS_LEADER buddy player1

// creating BOMB DISPOSAL presence around shop
CREATE_CHAR PEDTYPE_CIVMALE army 464.3 1010.9 17.2 waitingarmy1
SET_CHAR_HEADING waitingarmy1 37.9
SET_CHAR_ONLY_DAMAGED_BY_PLAYER waitingarmy1 TRUE 
GIVE_WEAPON_TO_CHAR waitingarmy1 WEAPONTYPE_M4 30000
SET_CHAR_ACCURACY waitingarmy1 90
SET_CHAR_STAY_IN_SAME_PLACE waitingarmy1 TRUE

CREATE_CHAR PEDTYPE_CIVMALE army 462.5 1009.0 17.2 waitingarmy2
SET_CHAR_HEADING waitingarmy2 54.3
SET_CHAR_ONLY_DAMAGED_BY_PLAYER waitingarmy2 TRUE 
GIVE_WEAPON_TO_CHAR waitingarmy2 WEAPONTYPE_M4 30000
SET_CHAR_STAY_IN_SAME_PLACE waitingarmy2 TRUE
SET_CHAR_ACCURACY waitingarmy1 90

//creating dynamite
CREATE_OBJECT dynamite 467.9 1004.8 18.9 dyn1 
SET_OBJECT_COLLISION dyn1 FALSE
SET_OBJECT_DYNAMIC dyn1 FALSE

CREATE_OBJECT dynamite 468.5 1004.4 18.9 dyn2 
SET_OBJECT_COLLISION dyn2 FALSE
SET_OBJECT_DYNAMIC dyn2 FALSE

CREATE_OBJECT dynamite 468.1 1004.8 18.9 dyn3 
SET_OBJECT_COLLISION dyn3 FALSE
SET_OBJECT_DYNAMIC dyn3 FALSE

CREATE_OBJECT dynamite 468.3 1004.5 18.9 dyn4 
SET_OBJECT_COLLISION dyn4 FALSE
SET_OBJECT_DYNAMIC dyn4 FALSE

CREATE_OBJECT dynamite 468.4 1004.3 18.9 dyn5 
SET_OBJECT_COLLISION dyn5 FALSE
SET_OBJECT_DYNAMIC dyn5 FALSE

SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG buddy GANG_PLAYER FALSE
SET_CHAR_CAN_BE_DAMAGED_BY_MEMBERS_OF_GANG scplayer GANG_PLAYER FALSE

OPEN_GARAGE bud3_garage
NO_SPECIAL_CAMERA_FOR_THIS_GARAGE bud3_garage 
CREATE_CAR sentinel -345.3 -524.6 11.5 free_sentinel_car
CREATE_CAR police 469.6 336.6 11.4 free_cop_car
LOCK_CAR_DOORS free_cop_car CARLOCK_UNLOCKED

DO_FADE 1500 FADE_IN

WAIT 1000

PRINT_NOW ( PRO3_01 ) 5000 1 //Ok Lance, let's get the cops' attention!
PLAY_MISSION_AUDIO 1
WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
ENDWHILE
CLEAR_MISSION_AUDIO 1
CLEAR_THIS_PRINT PRO3_01 


PRINT ( PRO3_21 ) 5000 1 //Get a wanted level so the cops will follow you into the lock-up.


ADD_BLIP_FOR_COORD 459.1 332.5 9.4 cop_garage 
timera = 0



disguise_loop://////////////////////////////////////////////////////////////////////////////

WAIT 0

//player1 must get a wanted level and then get police to follow him into garage

IF disguise_goals = 0 
	IF NOT IS_CHAR_DEAD buddy 
		
		IF IS_WANTED_LEVEL_GREATER player1 0
			IF speech_played = 0
				IF NOT IS_CHAR_DEAD buddy 
					IF IS_CHAR_IN_PLAYERS_GROUP buddy player1
						PRINT_NOW ( PRO3_19 ) 5000 1 //Now that got them really irritated
						PRINT ( PRO3_20 ) 5000 1 //Get two cops to follow you into the garage.
						PLAY_MISSION_AUDIO 2
						WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
						AND NOT IS_CHAR_DEAD buddy  
							WAIT 0
						ENDWHILE
						CLEAR_MISSION_AUDIO 2
						CLEAR_THIS_PRINT PRO3_19 
						speech_played = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		
		
		IF IS_PLAYER_IN_AREA_2D player1 466.1 325.5 448.1 335.2 FALSE
			IF NOT gotpolice = 2
				IF IS_WANTED_LEVEL_GREATER player1 1
					IF cop3_flag = 0
						IF NOT IS_POINT_ON_SCREEN 444.6 348.4 10.7 2.0
							CREATE_CHAR PEDTYPE_CIVMALE cop 444.6 348.4 10.7 cop3
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3 player1  
							SET_CHAR_THREAT_SEARCH cop3 THREAT_PLAYER1 
							GIVE_WEAPON_TO_CHAR cop3 WEAPONTYPE_NIGHTSTICK 1
							cop3_flag = 1
						ENDIF
					ENDIF  
					   
					IF cop4_flag = 0
						IF NOT IS_POINT_ON_SCREEN 472.1 347.8 10.6 2.0
							CREATE_CHAR PEDTYPE_CIVMALE cop 472.1 347.8 10.6 cop4
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4 player1 
							SET_CHAR_THREAT_SEARCH cop4 THREAT_PLAYER1 
							GIVE_WEAPON_TO_CHAR cop4 WEAPONTYPE_NIGHTSTICK 1
							cop4_flag = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF     
			

			IF IS_CHAR_IN_AREA_2D buddy 466.1 325.5 448.1 339.2 FALSE
				IF gotpolice = 0 
					
					IF cop3_flag = 1 
						IF NOT IS_CHAR_DEAD cop3  
							IF IS_CHAR_IN_AREA_2D cop3 466.1 325.5 448.1 337.2 FALSE
								IF cop3_in_garage = 0
									IF cop4_in_garage = 0
										gotpolice ++
										cop3_in_garage = 1
										counted_once3 = 1
									ENDIF
								ENDIF
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED cop3
							cop3_flag = 0
							counted_once3 = 0 
						ENDIF
					ENDIF 

					IF cop4_flag = 1 
						IF NOT IS_CHAR_DEAD cop4  
							IF IS_CHAR_IN_AREA_2D cop4 466.1 325.5 448.1 337.2 FALSE
								IF cop3_in_garage = 0
									IF cop4_in_garage = 0
										gotpolice ++
										cop4_in_garage = 1
										counted_once4 = 1
									ENDIF
								ENDIF
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED cop4
							cop4_flag = 0
							counted_once4 = 0 
						ENDIF
					ENDIF 

					GET_RANDOM_COP_IN_AREA 466.1 325.5 448.1 339.2 1 0 0 0 0 cop1
					IF NOT cop1 = -1
						IF NOT IS_CHAR_DEAD cop1 
							IF IS_CHAR_MODEL cop1 cop
								IF cop1_in_garage = 0
									gotpolice ++
									cop1_in_garage = 1
								ENDIF
								IF IS_CHAR_IN_ANY_CAR cop1 
									SET_CHAR_OBJ_LEAVE_ANY_CAR cop1
								ENDIF
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED cop1
							MARK_CHAR_AS_NO_LONGER_NEEDED cop2
							gotpolice = 0
						ENDIF
					ENDIF

				ENDIF
				
				
				IF gotpolice = 1 

					IF cop3_flag = 1 
						IF NOT IS_CHAR_DEAD cop3  
							IF IS_CHAR_IN_AREA_2D cop3 466.1 325.5 448.1 337.2 FALSE
								IF counted_once3 = 0
									IF cop3_in_garage < 2
										IF cop4_in_garage < 2
											gotpolice ++
											cop3_in_garage = 2
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED cop3
							cop3_flag = 0
							counted_once3 = 0 
						ENDIF
					ENDIF 

					IF cop4_flag = 1 
						IF NOT IS_CHAR_DEAD cop4  
							IF IS_CHAR_IN_AREA_2D cop4 466.1 325.5 448.1 337.2 FALSE
								IF counted_once4 = 0
									IF cop3_in_garage < 2
										IF cop4_in_garage < 2
											gotpolice ++
											cop4_in_garage = 2
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED cop4
							cop4_flag = 0
							counted_once4 = 0 
						ENDIF
					ENDIF 

					GET_RANDOM_COP_IN_AREA 466.1 325.5 448.1 339.2 1 0 0 0 0 cop2	
					IF NOT cop2 = -1
						IF NOT IS_CHAR_DEAD cop2
							IF NOT IS_CHAR_DEAD buddy 
								IF IS_CHAR_MODEL cop2 cop
									IF cop2_in_garage = 0
										gotpolice ++
										cop2_in_garage = 1
									ENDIF
									IF IS_CHAR_IN_ANY_CAR cop2 
										SET_CHAR_OBJ_LEAVE_ANY_CAR cop2
									ENDIF
								ENDIF
							ELSE
								PRINT_NOW ( PRO3_05 ) 5000 1 //You killed Lance!
								GOTO mission_failed_protec3
							ENDIF 
						ELSE
							MARK_CHAR_AS_NO_LONGER_NEEDED cop1
							MARK_CHAR_AS_NO_LONGER_NEEDED cop2
							gotpolice = 0
						ENDIF
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED cop1
				MARK_CHAR_AS_NO_LONGER_NEEDED cop2
				gotpolice = 0
				cop1_in_garage = 0
				cop2_in_garage = 0
				cop3_in_garage = 0
				cop4_in_garage = 0
				counted_once3 = 0 
				counted_once4 = 0 
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop2
			gotpolice = 0
			cop1_in_garage = 0
			cop2_in_garage = 0
			cop3_in_garage = 0
			cop4_in_garage = 0
			counted_once3 = 0 
			counted_once4 = 0 
		ENDIF
	ENDIF


// ****************************************START OF CUTSCENE********************************
	IF gotpolice = 2
		IF NOT IS_AREA_OCCUPIED 465.2 339.8 5.0 451.5 341.0 15.5 FALSE TRUE FALSE FALSE FALSE
			IF NOT IS_CHAR_DEAD cop1 
				CLEAR_CHAR_THREAT_SEARCH cop1
				SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT cop1 player1  
			ENDIF
			IF NOT IS_CHAR_DEAD cop2 
				CLEAR_CHAR_THREAT_SEARCH cop2
				SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT cop2 player1  
			ENDIF
			IF NOT IS_CHAR_DEAD cop3 
				CLEAR_CHAR_THREAT_SEARCH cop3
				SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT cop3 player1  
			ENDIF
			IF NOT IS_CHAR_DEAD cop4 
				CLEAR_CHAR_THREAT_SEARCH cop4
				SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT cop4 player1  
			ENDIF
			CLEAR_PRINTS
			CLEAR_WANTED_LEVEL player1
			SET_POLICE_IGNORE_PLAYER player1 ON
			SET_MAX_WANTED_LEVEL 0
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON

			SET_FIXED_CAMERA_POSITION 460.00 350.5 14.1 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT 458.85 342.56 11.7 JUMP_CUT

			CLOSE_GARAGE bud3_garage
			
			WHILE NOT IS_GARAGE_CLOSED bud3_garage
				WAIT 0
			ENDWHILE 

			IF cop1_in_garage > 0
				IF NOT IS_CHAR_DEAD cop1
					EXPLODE_CHAR_HEAD cop1
				ENDIF
			ENDIF
			IF cop2_in_garage > 0
				IF NOT IS_CHAR_DEAD cop2
					EXPLODE_CHAR_HEAD cop2
				ENDIF
			ENDIF
			IF cop3_in_garage > 0
				IF NOT IS_CHAR_DEAD cop3
					EXPLODE_CHAR_HEAD cop3
				ENDIF
			ENDIF
			IF cop4_in_garage > 0
				IF NOT IS_CHAR_DEAD cop4
					EXPLODE_CHAR_HEAD cop4
				ENDIF
			ENDIF

			UNLOCK_ALL_CAR_DOORS_IN_AREA 466.1 325.5 448.1 339.2 
			 
			CLEAR_AREA_OF_CHARS 466.1 325.5 5.0 448.0 340.1 15.0
		
			LOAD_MISSION_AUDIO 1 BUD3_1
			LOAD_MISSION_AUDIO 2 BUD3_2

			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			OR NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 
		   
		   	REMOVE_BLIP cop_garage

			WAIT 2000
		
			PRINT_NOW ( PRO3_09 ) 5000 1 //Tie 'em up and gag 'em!
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
		    CLEAR_THIS_PRINT PRO3_09 

			PRINT_NOW ( PRO3_10 ) 5000 1 //Ooo. Fits perfectly!!
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			AND NOT IS_CHAR_DEAD buddy 
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2
			CLEAR_THIS_PRINT PRO3_10 
		   
			DELETE_CHAR buddy

			CREATE_CHAR PEDTYPE_CIVMALE SPECIAL02 456.4 338.7 10.8 buddy
			SET_CHAR_AS_PLAYER_FRIEND buddy player1 TRUE
			
			CLEAR_CHAR_THREAT_SEARCH buddy
			SET_CHAR_PERSONALITY buddy PEDSTAT_TOUGH_GUY
			SET_CHAR_ONLY_DAMAGED_BY_PLAYER buddy TRUE 
			SET_CHAR_CANT_BE_DRAGGED_OUT buddy TRUE
			GIVE_WEAPON_TO_CHAR buddy WEAPONTYPE_STUBBY_SHOTGUN 30000
			SET_CHAR_RUNNING buddy TRUE
			SET_PLAYER_AS_LEADER buddy player1
			
			IF IS_PLAYER_IN_ANY_CAR player1 
				WARP_CHAR_FROM_CAR_TO_COORD scplayer 458.5 338.9 10.8
			ELSE
				SET_PLAYER_COORDINATES player1 458.5 338.9 10.8  
			ENDIF

			IF NOT IS_CHAR_DEAD scplayer
				UNDRESS_CHAR scplayer player6
				LOAD_ALL_MODELS_NOW
				IF NOT IS_CHAR_DEAD scplayer
					DRESS_CHAR scplayer
				ENDIF
			ENDIF
			
			LOAD_MISSION_AUDIO 1 BUD3_3
			LOAD_MISSION_AUDIO 2 BUD3_4

			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			OR NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 
			
			PRINT_NOW ( PRO3_11 ) 5000 1 //bit tight around the crotch though
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO3_11 

			PRINT_NOW ( PRO3_12 ) 5000 1 //Oh yeah yeah, mine too. Mine too.
			PLAY_MISSION_AUDIO 2
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			AND NOT IS_CHAR_DEAD buddy 
				WAIT 0
			ENDWHILE
			CLEAR_MISSION_AUDIO 2
			CLEAR_THIS_PRINT PRO3_12 
			
			LOAD_MISSION_AUDIO 1 BUD3_1c
			LOAD_MISSION_AUDIO 2 BUD3_5

			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			OR NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 
			
			DELETE_CHAR cop1
			DELETE_CHAR cop2
			DELETE_CHAR cop3
			DELETE_CHAR cop4
			
			WAIT 2000
				
			OPEN_GARAGE bud3_garage
			
			WHILE NOT IS_GARAGE_OPEN bud3_garage
				WAIT 0
			ENDWHILE 
			
			RESTORE_CAMERA_JUMPCUT
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
			REMOVE_BLIP bombplace
			speech_played = 0 
			disguise_goals = 1
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED cop1
			MARK_CHAR_AS_NO_LONGER_NEEDED cop2
			PRINT_NOW ( PRO3_22 ) 5000 1 //The lock-up door is blocked!  You need to clear the door so it can close.
		ENDIF
	ENDIF
// ******************************************END OF CUTSCENE********************************

	IF flag_player_in_mall = 1
		ALTER_WANTED_LEVEL_NO_DROP player1 5
		
		IF NOT IS_CHAR_DEAD waitingarmy1 
			SET_CHAR_PERSONALITY waitingarmy1 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS waitingarmy1 player1
		ENDIF
		IF NOT IS_CHAR_DEAD waitingarmy2 
			SET_CHAR_PERSONALITY waitingarmy2 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS waitingarmy2 player1
		ENDIF
		
	ENDIF  
ENDIF

//setting up Mall 

IF disguise_goals = 1

//creating FBI presence at entrances to Mall
	CREATE_CHAR PEDTYPE_CIVMALE cop 452.1 994.0 17.2 fbidoor1 //door closest to bomb place, front EAST of mall
	SET_CHAR_HEADING fbidoor1 171.9
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor1 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor1 WEAPONTYPE_M4 30000

	CREATE_CHAR PEDTYPE_CIVMALE cop 377.3 993.8 17.2 fbidoor2 //front WEST of mall
	SET_CHAR_HEADING fbidoor2 172.1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor2 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor2 WEAPONTYPE_M4 30000

	CREATE_CHAR PEDTYPE_CIVMALE cop 348.9 1122.3 17.2 fbidoor3 //middle WEST of mall
	SET_CHAR_HEADING fbidoor3 86.1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor3 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor3 WEAPONTYPE_PISTOL 30000

	CREATE_CHAR PEDTYPE_CIVMALE cop 478.9 1125.5 17.5 fbidoor4 //middle EAST of mall
	SET_CHAR_HEADING fbidoor4 259.1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor4 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor4 WEAPONTYPE_PISTOL 30000

	CREATE_CHAR PEDTYPE_CIVMALE cop 368.9 1208.5 24.5 fbidoor5 //multi storey car park entrance
	SET_CHAR_HEADING fbidoor5 90.1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor5 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor5 WEAPONTYPE_PISTOL 30000

	CREATE_CHAR PEDTYPE_CIVMALE cop 380.5 1257.9 16.4 fbidoor6 //back WEST of mall 
	SET_CHAR_HEADING fbidoor6 353.1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor6 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor6 WEAPONTYPE_PISTOL 30000

	CREATE_CHAR PEDTYPE_CIVMALE cop 447.7 1257.1 17.3 fbidoor7 //back EAST of mall 
	SET_CHAR_HEADING fbidoor7 2.6
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER fbidoor7 TRUE 
	GIVE_WEAPON_TO_CHAR fbidoor7 WEAPONTYPE_PISTOL 30000


//script controlled roadblocks - thanks obbe :)

	CREATE_SCRIPT_ROADBLOCK 556.5 763.3 10.2 538.5 763.3 10.2  
	CREATE_SCRIPT_ROADBLOCK 306.3 881.2 10.2 325.5 881.2 10.2
	

	ADD_BLIP_FOR_COORD 468.0 1005.9 18.1 bombplace
	
//waiting for player1 to set bomb

	PRINT ( PRO3_02 ) 7000 1 //Take the cop car and go and plant the bomb at the Tarbrush Coffee Shop in the Mall.
	
	disguise_goals = 2

ENDIF


//planting the bomb

IF disguise_goals = 2


	IF flag_player_in_mall = 1
		IF prot3_print_flag = 0
			PRINT_NOW ( PRO3_23 ) 5000 1 //Walk into the marker to plant the bomb.
			prot3_print_flag = 1
		ENDIF
	ENDIF

//speech

	IF NOT IS_CHAR_DEAD buddy 
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 556.5 763.3 10.2 20.0 20.0 20.0 FALSE
		OR LOCATE_PLAYER_ANY_MEANS_3D player1 306.3 881.2 10.2 20.0 20.0 20.0 FALSE
			IF speech_played = 0
				IF IS_CHAR_IN_PLAYERS_GROUP buddy player1
					IF IS_PLAYER_IN_ANY_CAR player1
						STORE_CAR_PLAYER_IS_IN player1 player_buddy_car

						GET_CAR_SPEED player_buddy_car player_buddy_car_speed
						IF player_buddy_car_speed > 10.0  
							PRINT_NOW ( PRO3_13 ) 5000 1 //Easy brother! No cop drives this bad!
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD buddy 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT PRO3_13
							speech_played = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF 
	ENDIF
			
	IF IS_PLAYER_IN_AREA_3D player1 436.2 995.1 17.3 468.7 988.7 19.7 FALSE
	OR LOCATE_PLAYER_ANY_MEANS_3D player1 377.3 993.8 18.2 15.0 15.0 15.0 FALSE
	OR LOCATE_PLAYER_ANY_MEANS_3D player1 348.9 1122.3 18.2 15.0 15.0 15.0 FALSE
	OR LOCATE_PLAYER_ANY_MEANS_3D player1 478.9 1125.5 17.5 15.0 15.0 15.0 FALSE
	OR LOCATE_PLAYER_ANY_MEANS_3D player1 368.9 1208.5 25.5 15.0 15.0 15.0 FALSE
		IF NOT IS_WANTED_LEVEL_GREATER player1 0  
			IF NOT IS_CHAR_DEAD buddy 
				IF speech_played2 = 0
					IF IS_CHAR_IN_PLAYERS_GROUP buddy player1
						IF NOT IS_PLAYER_IN_ANY_CAR player1 
							PRINT_NOW ( PRO3_14 ) 5000 1 //Remember - smile at the other cops
							PLAY_MISSION_AUDIO 2
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 2
							CLEAR_THIS_PRINT PRO3_14
							speech_played2 = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		 
			IF speech_played2 = 1
				LOAD_MISSION_AUDIO 1 BUD3_6
				LOAD_MISSION_AUDIO 2 BUD3_7

				WHILE NOT HAS_MISSION_AUDIO_LOADED 1
				OR NOT HAS_MISSION_AUDIO_LOADED 2
					WAIT 0
				ENDWHILE 
				IF NOT IS_CHAR_DEAD buddy 
					IF IS_CHAR_IN_PLAYERS_GROUP buddy player1
						IF NOT IS_PLAYER_IN_ANY_CAR player1 
							PRINT_NOW ( PRO3_15 ) 5000 1 //Hey there officer. Nice badge, nice badge.
							PLAY_MISSION_AUDIO 1
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
							AND NOT IS_CHAR_DEAD buddy 
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 1
							CLEAR_THIS_PRINT PRO3_15
							speech_played2 = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF NOT IS_CHAR_DEAD buddy 
				IF speech_played2 = 2 
					IF IS_CHAR_IN_PLAYERS_GROUP buddy player1
						IF NOT IS_PLAYER_IN_ANY_CAR player1 
							PRINT_NOW ( PRO3_16 ) 5000 1 //Real smooth, Lance.
							PLAY_MISSION_AUDIO 2
							WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
								WAIT 0
							ENDWHILE
							CLEAR_MISSION_AUDIO 2
							CLEAR_THIS_PRINT PRO3_16
							speech_played2 = 3
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
  
//setting up cops, if player attacks any of them
	IF flag_cops_alerted = 0 
		IF NOT IS_PLAYER_WEARING player1 player6
			IF flag_player_in_mall = 1
				flag_cops_alerted = 1
			ENDIF
		ENDIF 
		IF IS_CHAR_DEAD waitingarmy1 
		OR IS_CHAR_DEAD waitingarmy2 
			flag_cops_alerted = 1
		ENDIF
	ELSE
		PRINT ( PRO3_07 ) 5000 1 //You have blown your cover.  Hurry up and plant the bomb!
		IF timer_flag = 0
			SET_MAX_WANTED_LEVEL 6
			ALTER_WANTED_LEVEL player1 4
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor1 
			SET_CHAR_PERSONALITY fbidoor1 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor1 player1
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor2 
			SET_CHAR_PERSONALITY fbidoor2 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor2 player1
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor3 
			SET_CHAR_PERSONALITY fbidoor3 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor3 player1
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor4 
			SET_CHAR_PERSONALITY fbidoor4 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor4 player1
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor5 
			SET_CHAR_PERSONALITY fbidoor5 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor5 player1
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor6 
			SET_CHAR_PERSONALITY fbidoor6 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor6 player1
		ENDIF
		IF NOT IS_CHAR_DEAD fbidoor7 
			SET_CHAR_PERSONALITY fbidoor7 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS fbidoor7 player1
		ENDIF
		IF NOT IS_CHAR_DEAD waitingarmy1 
			SET_CHAR_PERSONALITY waitingarmy1 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS waitingarmy1 player1
		ENDIF
		IF NOT IS_CHAR_DEAD waitingarmy2 
			SET_CHAR_PERSONALITY waitingarmy2 PEDSTAT_TOUGH_GUY  
		   	SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS waitingarmy2 player1
		ENDIF
	ENDIF

	IF timer_flag = 0 
		IF LOCATE_PLAYER_ON_FOOT_3D player1 468.0 1005.9 18.1 1.0 1.0 2.0 TRUE
			REMOVE_BLIP bombplace 
			SET_PLAYER_CONTROL player1 OFF
			
			LOAD_MISSION_AUDIO 1 BUD3_8a
			LOAD_MISSION_AUDIO 2 BUD3_9a

			WHILE NOT HAS_MISSION_AUDIO_LOADED 1
			OR NOT HAS_MISSION_AUDIO_LOADED 2
				WAIT 0
			ENDWHILE 

			SET_EVERYONE_IGNORE_PLAYER player1 TRUE
			GET_PLAYER_CHAR player1 scplayer
			SET_CHAR_HEADING scplayer 232.0 
			SET_CHAR_WAIT_STATE scplayer WAITSTATE_BOMBER 1000
			SET_CAMERA_BEHIND_PLAYER 
			WAIT 1000
			IF NOT IS_CHAR_DEAD scplayer
				SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
			ENDIF
			SET_PLAYER_CONTROL player1 ON
			SET_EVERYONE_IGNORE_PLAYER player1 FALSE
			IF NOT IS_CHAR_DEAD scplayer
				SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
			ENDIF
			timerb = 0
			timer_flag = 1
		ENDIF
	ENDIF	
		
	IF timer_flag = 1
		IF speech_played3 = 0
			
			PRINT_NOW ( PRO3_17 ) 5000 1 //Ok, timers are set, 5 seconds and ticking.
			PLAY_MISSION_AUDIO 1
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				WAIT 0
				IF LOCATE_PLAYER_ANY_MEANS_3D player1 448.65 1003.0 18.4 5.0 5.0 5.0 FALSE
					GOTO shit_cunt
				ENDIF  
			ENDWHILE
			CLEAR_MISSION_AUDIO 1
			CLEAR_THIS_PRINT PRO3_17
			timerb = 0


			IF NOT IS_CHAR_DEAD buddy
				IF IS_CHAR_IN_PLAYERS_GROUP buddy player1 
					PRINT_NOW ( PRO3_18 ) 5000 1 //5 seconds?!! We got to get the hell out of here!
					PRINT ( PRO3_24 ) 5000 1 //Get clear of the Cafe!
					PLAY_MISSION_AUDIO 2
				ENDIF
			ENDIF
			speech_played3 = 1
		ENDIF

		IF timerb > 6000
		OR LOCATE_PLAYER_ANY_MEANS_3D player1 448.65 1003.0 18.4 5.0 5.0 5.0 FALSE 
			shit_cunt:
//blowing out window front 
			IF LOCATE_PLAYER_ANY_MEANS_3D player1 448.65 1003.0 18.4 5.0 5.0 5.0 FALSE
				IF NOT IS_PLAYER_ON_ANY_BIKE player1 
					CLEAR_ALL_CHAR_ANIMS scplayer
				ENDIF
				SET_PLAYER_COORDINATES player1 449.4 1007.1 18.1
				SET_PLAYER_HEADING player1 182.3
			ENDIF
			IF NOT IS_PLAYER_IN_AREA_3D player1 458.7 1002.1 25.0 398.2 1095.3 15.7 FALSE
				IF NOT IS_PLAYER_ON_ANY_BIKE player1 
					CLEAR_ALL_CHAR_ANIMS scplayer
				ENDIF
				SET_PLAYER_COORDINATES player1 435.1 1030.4 18.1
			ENDIF
			GET_PLAYER_COORDINATES player1 player_x player_y player_z
			player_y += 1.0
			IF NOT IS_CHAR_DEAD buddy
				SET_CHAR_COORDINATES buddy player_x player_y player_z
			ENDIF  
			CLEAR_PRINTS
			SET_PLAYER_CONTROL player1 OFF
			SWITCH_WIDESCREEN ON
			SET_PLAYER_VISIBLE player1 FALSE
			IF NOT IS_CHAR_DEAD buddy
				SET_CHAR_PROOFS buddy TRUE TRUE TRUE TRUE TRUE
			ENDIF

			SET_FIXED_CAMERA_POSITION 450.5358 1023.1326 22.5928 0.0 0.0 0.0 
			POINT_CAMERA_AT_POINT 451.2465 1022.4432 22.4529 JUMP_CUT

			//shop counter
			ADD_EXPLOSION 471.5 1009.5 18.1 EXPLOSION_ROCKET
			ADD_EXPLOSION 471.5 1009.5 18.1 EXPLOSION_HELI_BOMB  
			ADD_EXPLOSION 471.5 1009.5 18.1 EXPLOSION_MOLOTOV
			ADD_EXPLOSION 471.5 1009.5 18.1 EXPLOSION_HELI
			SHAKE_CAM 900
			WAIT 1000

			//looking out.  right shop window right 
			ADD_EXPLOSION 468.5 1010.1 18.1 EXPLOSION_ROCKET
			ADD_EXPLOSION 468.5 1010.1 18.1 EXPLOSION_HELI_BOMB  
			ADD_EXPLOSION 468.5 1010.1 18.1 EXPLOSION_MOLOTOV
			ADD_EXPLOSION 468.5 1010.1 18.1 EXPLOSION_HELI
			ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 468.5 1010.1 18.1 0.1 0.0 0.2 0.6 5 156 165 11000 
			//looking out.  right shop window left 
			ADD_EXPLOSION 466.5 1012.5 18.1 EXPLOSION_ROCKET
			ADD_EXPLOSION 466.5 1012.5 18.1 EXPLOSION_HELI_BOMB  
			ADD_EXPLOSION 466.5 1012.5 18.1 EXPLOSION_MOLOTOV
			SHAKE_CAM 900

			WAIT 1000
			//looking out.  left shop window right 
			ADD_EXPLOSION 465.3 1005.6 18.1 EXPLOSION_ROCKET
			ADD_EXPLOSION 465.3 1005.6 18.1 EXPLOSION_HELI_BOMB  
			ADD_EXPLOSION 465.3 1005.6 18.1 EXPLOSION_MOLOTOV

			//looking out.  left shop window left 
			ADD_EXPLOSION 461.7 1002.3 18.1 EXPLOSION_ROCKET
			ADD_EXPLOSION 461.7 1002.3 18.1 EXPLOSION_HELI_BOMB  
			ADD_EXPLOSION 461.7 1002.3 18.1 EXPLOSION_MOLOTOV
			ADD_EXPLOSION 461.7 1002.3 18.1 EXPLOSION_HELI
			ADD_MOVING_PARTICLE_EFFECT POBJECT_FIREBALL_AND_SMOKE 461.7 1002.3 18.1 0.1 0.0 0.2 0.8 0 0 0 11000 
			SHAKE_CAM 1800
			WAIT 2000

			ADD_EXPLOSION 463.9 1008.0 18.1 EXPLOSION_HELI
			ADD_EXPLOSION 464.3 1008.0 18.1 EXPLOSION_HELI
			ADD_EXPLOSION 464.9 1008.0 18.1 EXPLOSION_HELI
			ADD_EXPLOSION 465.3 1008.0 18.1 EXPLOSION_HELI
			ADD_EXPLOSION 465.9 1008.0 18.1 EXPLOSION_HELI
			ADD_MOVING_PARTICLE_EFFECT POBJECT_DARK_SMOKE 463.9 1008.0 18.1 0.2 0.0 0.1 3.0 0 0 0 11000	
			
			ADD_EXPLOSION 452.5358 1023.1326 22.5928 EXPLOSION_HELI
			SHAKE_CAM 1000
			
			SET_FADING_COLOUR 255 255 255
			DO_FADE 400 FADE_OUT
			
			IF NOT IS_PLAYER_DEAD player1
				IF NOT IS_CHAR_DEAD buddy
					SWAP_NEAREST_BUILDING_MODEL 468.882 1006.67 20.681 80.0 ml_tarbrush ml_tarbrushdamage
					IF player_in_coffee_shop = 0
						player_in_coffee_shop = 1
					ENDIF
				ENDIF
			ENDIF
			DO_FADE 400 FADE_IN
			
			START_SCRIPT_FIRE 471.5 1009.5 18.1 mall_fire1
			START_SCRIPT_FIRE 468.5 1010.1 18.1 mall_fire2
			START_SCRIPT_FIRE 465.3 1005.6 18.1 mall_fire3
			START_SCRIPT_FIRE 461.7 1002.3 18.1 mall_fire4
			START_SCRIPT_FIRE 463.9 1008.0 18.1 mall_fire5
			
			WAIT 3000

			RESTORE_CAMERA_JUMPCUT
			SET_PLAYER_CONTROL player1 ON
			SWITCH_WIDESCREEN OFF
			SET_PLAYER_VISIBLE player1 TRUE

			SET_MAX_WANTED_LEVEL 6
			ALTER_WANTED_LEVEL player1 5 
			SET_POLICE_IGNORE_PLAYER player1 OFF
			IF NOT IS_CHAR_DEAD buddy 
				SET_CHAR_PROOFS buddy FALSE FALSE FALSE FALSE FALSE
			ENDIF
			flag_cops_alerted = 1
			PRINT_NOW ( PRO3_08 ) 5000 1 //Get back to Raphaels to change out of the cops uniforms.
			ADD_BLIP_FOR_COORD -378.2 -549.8 17.6 boutique1
			CLEAR_ALL_SCRIPT_ROADBLOCKS
			disguise_goals = 3
			timer_flag = 1
		ENDIF 
	ENDIF
ENDIF


//player1 must get to a boutique to change his outfit and get cops off his back

IF disguise_goals = 3
	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -378.2 -549.8 17.6 3.0 3.0 3.0 TRUE
		IF NOT IS_CHAR_DEAD buddy 
			IF IS_CHAR_IN_PLAYERS_GROUP buddy player1
	// **************************************(START) CHANGE OF CLOTHES CUT SCENE*********************************************
				SET_PLAYER_CONTROL player1 OFF
				SWITCH_WIDESCREEN ON

				SET_PLAYER_COORDINATES player1 -381.4 -532.3 16.1

				CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 -378.2 -549.8 17.6 cop1
				SET_CHAR_HEADING cop1 184.6

				IF NOT IS_CHAR_DEAD cop1
					SET_CHAR_OBJ_RUN_TO_COORD cop1 -378.4 -561.1
				ENDIF

				IF NOT IS_CHAR_DEAD buddy
					SET_CHAR_COORDINATES buddy -377.4 -547.9 16.7
					SET_CHAR_HEADING buddy 184.6
					LEAVE_GROUP buddy
					SET_CHAR_OBJ_RUN_TO_COORD buddy -378.4 -561.1
				ENDIF

				SET_FIXED_CAMERA_POSITION -378.5 -546.1 21.2 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT -378.7 -553.7 19.6 JUMP_CUT

				WAIT 1000

				//GET_PLAYER_CHAR player1 scplayer


				IF NOT IS_CHAR_DEAD cop1 
					SET_CHAR_OBJ_RUN_TO_COORD cop1 -378.4 -561.1
				ENDIF
				timera = 0

				WHILE NOT LOCATE_CHAR_ON_FOOT_2D cop1 -378.4 -561.1 1.0 1.0 FALSE
				AND NOT timera > 7000
					WAIT 0
					IF NOT IS_CHAR_DEAD cop1 
					ENDIF
				ENDWHILE

				IF NOT IS_CHAR_DEAD cop1
					DELETE_CHAR cop1
				ENDIF			

				IF NOT IS_CHAR_DEAD scplayer
					UNDRESS_CHAR scplayer player
					LOAD_ALL_MODELS_NOW
					IF NOT IS_CHAR_DEAD scplayer
						DRESS_CHAR scplayer
					ENDIF
				ENDIF
				IF NOT IS_CHAR_DEAD buddy 
					DELETE_CHAR buddy
				ENDIF

				CREATE_CHAR PEDTYPE_CIVMALE NULL -378.4 -561.1 18.5 cop1


				IF NOT IS_CHAR_DEAD cop1 
					SET_CHAR_OBJ_RUN_TO_COORD cop1 -378.2 -549.8
				ENDIF

				timera = 0

				WHILE NOT LOCATE_CHAR_ON_FOOT_2D cop1 -378.2 -549.8 1.0 1.0 FALSE
				AND NOT timera > 7000
					WAIT 0

					IF NOT IS_CHAR_DEAD cop1 
					ENDIF
				
				ENDWHILE

				WAIT 2000

				DELETE_CHAR cop1
				SET_PLAYER_COORDINATES player1 -378.2 -549.8 17.6
				SET_PLAYER_HEADING player1 9.3
				SET_CAMERA_BEHIND_PLAYER
	// **************************************(END) CHANGE OF CLOTHES CUT SCENE*********************************************
				REMOVE_BLIP boutique1
	// ******************************************START OF ASSET AQUIRED CUTSCENE********************************
				DO_FADE 500 FADE_OUT
				WHILE GET_FADING_STATUS
					WAIT 0
				ENDWHILE

				CREATE_PROTECTION_PICKUP -378.4 -536.9 17.2 taxifirm_revenue taxifirm_revenue prot_cash_pickup

				SET_FIXED_CAMERA_POSITION -369.1 -467.9 22.7 0.0 0.0 0.0 
				POINT_CAMERA_AT_POINT -370.6 -533.8 18.0 JUMP_CUT

				DO_FADE 500 FADE_IN
				WHILE GET_FADING_STATUS
					WAIT 0
				ENDWHILE
			
				PLAY_MISSION_PASSED_TUNE 1
				PRINT_BIG PRO_AS1 5000 6 //PROTECTION ASSET ACQUIRED
				
				WAIT 5000
				SET_FIXED_CAMERA_POSITION -377.1 -526.9 19.4 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT -377.6 -536.6 17.5 JUMP_CUT
				
				PRINT_WITH_NUMBER_NOW PRO_AS2 taxifirm_revenue 6000 1//Chez Tommy will now generate revenue up to a maximum of $~1~. Make sure you collect it regularly.

				WAIT 6000
				DO_FADE 500 FADE_OUT
				WHILE GET_FADING_STATUS
					WAIT 0
				ENDWHILE

				GET_PLAYER_COORDINATES player1 player_x player_y player_z
				LOAD_SCENE player_x player_y player_z

				DO_FADE 500 FADE_IN
				
				RESTORE_CAMERA_JUMPCUT
				SET_PLAYER_CONTROL player1 ON
				SWITCH_WIDESCREEN OFF
	// ******************************************END OF ASSET AQUIRED CUTSCENE********************************

				GOTO mission_passed_protec3
			ENDIF
		ENDIF
	ENDIF
ENDIF  
		


//checking buddy is still in player1s group

IF NOT IS_CHAR_DEAD buddy
	IF flag_buddy_in_group_prot3 = 1
        IF NOT IS_CHAR_IN_PLAYERS_GROUP buddy player1
			IF timera > 3000
	        	PRINT_NOW ( PRO3_03 ) 5000 1 //You've left Lance behind, go and get him.
			ENDIF
	        REMOVE_BLIP cop_garage
	        REMOVE_BLIP bombplace
	        REMOVE_BLIP boutique1
	        ADD_BLIP_FOR_CHAR buddy radar_blip_buddy
	        flag_buddy_in_group_prot3 = 0
		ENDIF
    ENDIF
	IF flag_buddy_in_group_prot3 = 0 
	    IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 buddy 8.0 8.0 8.0 FALSE
	        SET_PLAYER_AS_LEADER buddy player1
			IF timera > 3000
		        PRINT_NOW ( PRO3_04 ) 5000 1 //let's go
			ENDIF
	        REMOVE_BLIP radar_blip_buddy
	        REMOVE_BLIP cop_garage 
			REMOVE_BLIP bombplace
			REMOVE_BLIP boutique1 
	        IF disguise_goals = 0 
	        	ADD_BLIP_FOR_COORD 457.4 335.28 9.4 cop_garage
			ENDIF
	        IF disguise_goals = 2
	        	ADD_BLIP_FOR_COORD 471.5 1009.5 18.1 bombplace
			ENDIF
	        IF disguise_goals = 3
	        	ADD_BLIP_FOR_COORD -378.2 -549.8 17.6 boutique1
			ENDIF
	        flag_buddy_in_group_prot3 = 1
	    ENDIF
	ENDIF
ELSE
	PRINT_NOW ( PRO3_05 ) 5000 1 //You killed Lance!
	GOTO mission_failed_protec3 
ENDIF

GOTO disguise_loop
	   		

// Mission failed
mission_failed_protec3:

PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
IF player_in_coffee_shop = 1
	SWAP_NEAREST_BUILDING_MODEL 468.882 1006.67 20.681 80.0 ml_tarbrushdamage ml_tarbrush
ENDIF

RETURN

   

// mission passed
mission_passed_protec3:

CLEAR_PRINTS
PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
CREATE_CLOTHES_PICKUP 405.7 -485.6 12.3 6 clothes_pickup6
clothes6_created = 1
START_NEW_SCRIPT cloth5
//PLAY_MISSION_PASSED_TUNE 1 
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 10000
PLAYER_MADE_PROGRESS 1
REGISTER_MISSION_PASSED BUD_3
REMOVE_BLIP protect_contact_blip
REMOVE_BLIP baron_contact_blip 
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD -378.4 -536.9 17.2 RADAR_SPRITE_TOMMY baron_contact_blip
++ counter_60_percent
flag_protect_mission3_passed = 1 
flag_first_asset_complete = 1 // FIXMIAMI: fix Ken's phonecall
RETURN
		


// mission cleanup
mission_cleanup_protec3:
flag_player_on_mission = 0
SET_PLAYER_CONTROL player1 on
SET_MAX_WANTED_LEVEL 6
REMOVE_CHAR_ELEGANTLY buddy 
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
MARK_MODEL_AS_NO_LONGER_NEEDED cop
MARK_MODEL_AS_NO_LONGER_NEEDED army
MARK_MODEL_AS_NO_LONGER_NEEDED buddyshot
MARK_MODEL_AS_NO_LONGER_NEEDED m4
MARK_MODEL_AS_NO_LONGER_NEEDED sentinel
MARK_MODEL_AS_NO_LONGER_NEEDED police
MARK_MODEL_AS_NO_LONGER_NEEDED dynamite							
MARK_MODEL_AS_NO_LONGER_NEEDED nitestick
MARK_MODEL_AS_NO_LONGER_NEEDED colt45
DELETE_OBJECT dyn1
DELETE_OBJECT dyn2
DELETE_OBJECT dyn3
DELETE_OBJECT dyn4
DELETE_OBJECT dyn5
REMOVE_BLIP boutique1
REMOVE_BLIP cop_garage
REMOVE_BLIP bombplace
REMOVE_BLIP	radar_blip_buddy
SET_ZONE_PED_INFO RICH1 DAY   (13) 0 0 0 0 0 0 0 0 0 20 
SET_ZONE_PED_INFO RICH1 NIGHT (10) 0 0 0 0 0 0 0 0 0 10
SET_ZONE_CAR_INFO RICH1 DAY   (12) 0 0 0 0 0 0 0 0 0 10 
SET_ZONE_CAR_INFO RICH1 NIGHT (10) 0 0 0 0 0 0 0 0 0 10 
SET_ZONE_CIVILIAN_CAR_INFO RICH1 DAY   90 0 400 400 0 0 100 0 10 500 500
SET_ZONE_CIVILIAN_CAR_INFO RICH1 NIGHT 90 0 400 400 0 0 100 0 10 500 500
SET_ZONE_GROUP RICH1 DAY RICH1_PEDGRP
SET_ZONE_GROUP RICH1 NIGHT RICH1_NIGHT_PEDGRP

SET_ZONE_PED_INFO SHOP1 DAY   (30) 0 0 50 0 50 0 0 0 0 10 
SET_ZONE_PED_INFO SHOP1 NIGHT (20) 0 0 50 0 50 0 0 0 0 10
SET_ZONE_CAR_INFO SHOP1 DAY   (15) 0 0 50 0 0 0 0 0 0 10 
SET_ZONE_CAR_INFO SHOP1 NIGHT (13) 0 0 50 0 0 0 0 0 0 10 
SET_ZONE_CIVILIAN_CAR_INFO SHOP1 DAY   250 250 200 0 100 0 200 0 0 500 500
SET_ZONE_CIVILIAN_CAR_INFO SHOP1 NIGHT 250 250 200 0 100 0 200 0 0 500 500
SET_ZONE_GROUP SHOP1 DAY SHOP1_PEDGRP
SET_ZONE_GROUP SHOP1 NIGHT SHOP1_NIGHT_PEDGRP

IF mansion_clothes_created = 1
	CREATE_CLOTHES_PICKUP -384.5 -591.9 25.3 1 mansion_clothes   
ENDIF 
IF hotel_clothes_created = 1                                                                                                                                                                   
    CREATE_CLOTHES_PICKUP 226.4 -1265.6 20.1 1 clothes_pickup1
ENDIF
IF safehouse_created2 = 1
	CREATE_CLOTHES_PICKUP -820.2 1364.1 66.4 1 safehouse_clothes2   
ENDIF 
IF clothes2_created = 1
   CREATE_CLOTHES_PICKUP 97.5 -1133.6 10.4 2 clothes_pickup2
ENDIF
IF clothes3_created = 1
   CREATE_CLOTHES_PICKUP 364.2 1086.1 19.0 3 clothes_pickup3
ENDIF
IF clothes4_created = 1
   CREATE_CLOTHES_PICKUP 106.5 253.0 21.7 4 clothes_pickup4
ENDIF
IF clothes5_created = 1
   CREATE_CLOTHES_PICKUP -1025.2 -429.2 10.8 5 clothes_pickup5 // FIXMIAMI: fix cuban skin pickup location
ENDIF
IF flag_protect_mission3_passed = 0
	IF clothes6_created = 1
		CREATE_CLOTHES_PICKUP 405.7 -485.6 12.3 6 clothes_pickup6
	ENDIF
ENDIF
IF clothes7_created = 1
    CREATE_CLOTHES_PICKUP 414.3 1042.0 25.4 8 clothes_pickup7
ENDIF
IF clothes8_created = 1
    CREATE_CLOTHES_PICKUP 158.3 -1275.9 10.6 9 clothes_pickup8
ENDIF
IF clothes9_created = 1
    CREATE_CLOTHES_PICKUP -917.4 885.1 11.0 10 clothes_pickup9
ENDIF
IF clothes13_created = 1
    CREATE_CLOTHES_PICKUP 465.3 -57.4 15.7 7 clothes_pickup13
ENDIF

REMOVE_PARTICLE_EFFECTS_IN_AREA 466.0 1023.0 14.1 476.0 1033.0 24.1 
REMOVE_ALL_SCRIPT_FIRES
GET_GAME_TIMER timer_mobile_start
flag_player_on_army_ped_mission = 0
MISSION_HAS_FINISHED
RETURN
}		


	  			  