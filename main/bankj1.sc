MISSION_START
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// ************************************* Bank Mission 1***************************************
// ******************************** Break Out the Safe Cracker *******************************
// ********************************	      No Escape ?		   *******************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************
// *******************************************************************************************

SCRIPT_NAME bankjo1

// Mission start stuff

GOSUB mission_start_bankjob1

	IF HAS_DEATHARREST_BEEN_EXECUTED
		GOSUB mission_bankjob1_failed
	ENDIF
      
GOSUB mission_cleanup_bankjob1

MISSION_END


// Variables for mission

// Safe cracker

VAR_INT safecracker_bankjob1

VAR_INT flag_safecracker_dead_bankjob1

VAR_INT radar_blip_ped1_bankjob1

VAR_INT flag_safecracker_in_group_bankjob1 // Tells me the safecracker has been added to the players group

VAR_INT flag_cams_blip_on_bankjob1

VAR_INT flag_had_cops_message_bankjob1

// Location to take safecracher too

VAR_INT radar_blip_coord1_bankjob1

// cop1

VAR_INT cop1_bankjob1

VAR_INT flag_cop1_dead_bankjob1

VAR_INT flag_duck_cop1
																	  
VAR_INT counter_time_cop1_duck_again

VAR_INT counter_shoot_cop1

VAR_INT flag_start_shoot_timer_cop1

VAR_INT flag_cop1_got_gun_bankjob1

VAR_INT timer_start_cop1_bankjob1

VAR_INT times_done_gun_cop1_bankjob1

VAR_INT timer_gun_cop1_bankjob1

VAR_INT cop1_health_bank1

// cop2

VAR_INT cop2_bankjob1

VAR_INT flag_cop2_dead_bankjob1

VAR_INT flag_duck_cop2

VAR_INT counter_time_cop2_duck_again

VAR_INT counter_shoot_cop2

VAR_INT flag_start_shoot_timer_cop2

VAR_INT flag_cop2_got_gun_bankjob1

VAR_INT timer_start_cop2_bankjob1

VAR_INT times_done_gun_cop2_bankjob1

VAR_INT timer_gun_cop2_bankjob1

VAR_INT cop2_health_bank1

// cop3

VAR_INT cop3_bankjob1

VAR_INT flag_cop3_dead_bankjob1

VAR_INT flag_duck_cop3

VAR_INT counter_time_cop3_duck_again

VAR_INT counter_shoot_cop3

VAR_INT flag_start_shoot_timer_cop3

VAR_INT flag_cop3_got_gun_bankjob1

VAR_INT timer_start_cop3_bankjob1

VAR_INT times_done_gun_cop3_bankjob1

VAR_INT timer_gun_cop3_bankjob1

VAR_INT cop3_health_bank1

// cop4

VAR_INT cop4_bankjob1

VAR_INT flag_cop4_dead_bankjob1

VAR_INT flag_duck_cop4

VAR_INT counter_time_cop4_duck_again

VAR_INT counter_shoot_cop4

VAR_INT flag_start_shoot_timer_cop4

VAR_INT flag_cop4_got_gun_bankjob1

VAR_INT timer_start_cop4_bankjob1

VAR_INT times_done_gun_cop4_bankjob1

VAR_INT timer_gun_cop4_bankjob1

VAR_INT cop4_health_bank1

// cop5

VAR_INT cop5_bankjob1

VAR_INT flag_cop5_dead_bankjob1

VAR_INT flag_cop5_got_gun_bankjob1

VAR_INT cop5_health_bank1

// cop6

VAR_INT cop6_bankjob1

VAR_INT flag_cop6_dead_bankjob1

VAR_INT flag_duck_cop6

VAR_INT counter_time_cop6_duck_again

VAR_INT counter_shoot_cop6

VAR_INT flag_start_shoot_timer_cop6

VAR_INT flag_cop6_got_gun_bankjob1

VAR_INT timer_start_cop6_bankjob1

VAR_INT times_done_gun_cop6_bankjob1

VAR_INT timer_gun_cop6_bankjob1

VAR_INT cop6_health_bank1

// cop7

VAR_INT cop7_bankjob1

VAR_INT flag_cop7_dead_bankjob1

VAR_INT flag_cop7_got_gun_bankjob1

VAR_INT cop7_health_bank1

VAR_INT cop7_sitting_bankjob1

// cop8

VAR_INT cop8_bankjob1

VAR_INT flag_cop8_dead_bankjob1

VAR_INT flag_cop8_got_gun_bankjob1

VAR_INT cop8_health_bank1

// cop9

VAR_INT cop9_bankjob1

VAR_INT flag_cop9_dead_bankjob1

VAR_INT flag_cop9_got_gun_bankjob1

VAR_INT cop9_health_bank1

// cop10

VAR_INT cop10_bankjob1

VAR_INT flag_cop10_dead_bankjob1

VAR_INT flag_cop10_got_gun_bankjob1

VAR_INT cop10_health_bank1

// cop11

VAR_INT cop11_bankjob1

VAR_INT flag_cop11_dead_bankjob1

VAR_INT flag_cop11_got_gun_bankjob1

VAR_INT cop11_health_bank1

VAR_INT cop11_sitting_bankjob1

// general stuff

VAR_INT kill_player_flag_bankjob1

VAR_INT flag_bloke_in_group_bankjob1 // Checks once the guy has been added to the players group

VAR_FLOAT player_x_bankjob1

VAR_FLOAT player_y_bankjob1

VAR_FLOAT player_z_bankjob1

VAR_INT alarm_bankjob1

// key stuff

VAR_INT key_bankjob1  // Key to cells

VAR_INT key_blip_bank1

VAR_INT flag_key_collected_bankjob1

VAR_INT flag_doors_moved_bankjob1

VAR_INT flag_cell_door_open_bankjob1  // Tells me that the door is in its open position

// Clothes stuff

VAR_INT uniform_pickedup_bankjob1

// Checks to see if the player1 is armed in area

VAR_INT flag_player_armed_bankjob1

VAR_INT flag_player_gun_message_bankjob1

// Player in area of station he should not be

VAR_INT flag_player_in_station_bankjob1

VAR_INT flag_had_area_message_bankjob1

// Alarm stuff

// created guard1

VAR_INT created_guard1_bankjob1

VAR_INT flag_guard1_state_bankjob1

// created guard2

VAR_INT created_guard2_bankjob1

VAR_INT flag_guard2_state_bankjob1

// created guard3

VAR_INT created_guard3_bankjob1

VAR_INT flag_guard3_state_bankjob1

// created guard4

VAR_INT created_guard4_bankjob1

VAR_INT flag_guard4_state_bankjob1

// created guard5

VAR_INT created_guard5_bankjob1

VAR_INT flag_guard5_state_bankjob1

// created guard6

VAR_INT created_guard6_bankjob1

VAR_INT flag_guard6_state_bankjob1

// created guard7

VAR_INT created_guard7_bankjob1

VAR_INT flag_guard7_state_bankjob1

// created guard8

VAR_INT created_guard8_bankjob1

VAR_INT flag_guard8_state_bankjob1
	
// Starts the timers for the guard creation stuff

VAR_INT flag_timer_started_bankjob1

VAR_INT total_guards_created_bankjob1

VAR_INT counter_blokes_alive_bankjob1

VAR_INT flag_created_bloke_in_area_bankjob1

VAR_INT guard_number_bankjob1

VAR_INT cam_died_in_subscript_bankjob1  // Lets me know if cam has died in a subscript

VAR_INT sphere_bankjob1 // Used to show player area to stand for the cutsecne

VAR_INT sphere2_bankjob1 // Used to mark to where to stand for the second part with the keycard

VAR_INT player_had_gun_warning_bank1
		
// Audio for cell door

VAR_INT door_sfx1_bankjob1

VAR_INT had_cop_audio_1sttime_bankjob1

VAR_INT had_cop_audio_bankjob1

VAR_INT alarm_triggered_bankjob1

VAR_INT alarm_sound_added_bankjob1

// New sitting triggers

VAR_INT cop2_sitting_bankjob1

VAR_INT cop3_sitting_bankjob1

VAR_INT cop4_sitting_bankjob1

VAR_INT cop5_chatting_bankjob1

VAR_INT cop6_sitting_bankjob1

VAR_INT cop8_sitting_bankjob1

VAR_INT cop9_sitting_bankjob1

VAR_INT cop10_sitting_bankjob1

// Area2 message stuff

VAR_INT had_area2_message_bankjob1 // used for if the player is behind the counter in the station

// cutscene at end

VAR_INT cam_car_bankjob1

// Timer stuff

VAR_INT game_time_bank1

VAR_INT timer_started_bank1

VAR_INT time_to_act_bank1

VAR_INT timer_guards_react_bank1

VAR_INT timer_alarm_guards_react_bank1

VAR_INT time_to_act_alarm_bank1

VAR_INT timer_started_alarm_bank1

VAR_INT player_has_key_message_bank1 // Used for help prints

VAR_INT player_no_key_message_bank1 // Used tell player he needs to get the key card first

VAR_INT player_had_locker_message_bank1 // Tells player about locker room

VAR_INT stored_current_weapon_bank1  // Stores players gun while he is talking

// Sound effects

VAR_INT door_sliding_bankjob1

VAR_INT flag_played_card_beep_bank1 // Used to play this sample only once

VAR_INT snore_bank1

VAR_INT start_timer_for_message_bank1

// New blip for spray shop

VAR_INT spray_shop_blip_bank1

VAR_INT health_bankjob1 // health upstairs in the station

// Used to delete extra guards if player is not longer in teh area

VAR_INT player_gone_out_bank1

// Car stuff for creating one outsdie of copshop

VAR_INT escape_car_bank1

VAR_INT escape_car_created_bank1

// ***************************************Mission Start*************************************


mission_start_bankjob1:

flag_player_on_mission = 1

flag_player_in_malibu = 0

flag_player_on_bank1_mission = 1

REGISTER_MISSION_GIVEN

// safecracker

flag_safecracker_dead_bankjob1 = 0

flag_safecracker_in_group_bankjob1 = 0

flag_cams_blip_on_bankjob1 = 0

flag_had_cops_message_bankjob1 = 0

// cop1

flag_cop1_dead_bankjob1 = 0

flag_duck_cop1 = 0

counter_time_cop1_duck_again = 0

counter_shoot_cop1 = 0

flag_start_shoot_timer_cop1 = 0

flag_cop1_got_gun_bankjob1 = 0

timer_start_cop1_bankjob1 = 0

times_done_gun_cop1_bankjob1 = 0

timer_gun_cop1_bankjob1 = 0

cop1_health_bank1 = 100

// cop2

flag_cop2_dead_bankjob1 = 0

flag_duck_cop2 = 0

counter_time_cop2_duck_again = 0

counter_shoot_cop2 = 0

flag_start_shoot_timer_cop2 = 0

flag_cop2_got_gun_bankjob1 = 0

timer_start_cop2_bankjob1 = 0

times_done_gun_cop2_bankjob1 = 0

timer_gun_cop2_bankjob1 = 0

cop2_health_bank1 = 100

// cop3

flag_cop3_dead_bankjob1 = 0

flag_duck_cop3 = 0

counter_time_cop3_duck_again = 0

counter_shoot_cop3 = 0

flag_start_shoot_timer_cop3 = 0

flag_cop3_got_gun_bankjob1 = 0

timer_start_cop3_bankjob1 = 0

times_done_gun_cop3_bankjob1 = 0

timer_gun_cop3_bankjob1 = 0

cop3_health_bank1 = 100

// cop4

flag_cop4_dead_bankjob1 = 0

flag_duck_cop4 = 0

counter_time_cop4_duck_again = 0

counter_shoot_cop4 = 0

flag_start_shoot_timer_cop4 = 0

flag_cop4_got_gun_bankjob1 = 0

timer_start_cop4_bankjob1 = 0

times_done_gun_cop4_bankjob1 = 0

timer_gun_cop4_bankjob1 = 0

cop4_health_bank1 = 100

//cop5

flag_cop5_dead_bankjob1 = 0

flag_cop5_got_gun_bankjob1 = 0

cop5_health_bank1 = 100

// cop6

flag_cop6_dead_bankjob1 = 0

flag_duck_cop6 = 0

counter_time_cop6_duck_again = 0

counter_shoot_cop6 = 0

flag_start_shoot_timer_cop6 = 0

flag_cop6_got_gun_bankjob1 = 0

timer_start_cop6_bankjob1 = 0

times_done_gun_cop6_bankjob1 = 0

timer_gun_cop6_bankjob1 = 0

cop6_health_bank1 = 100

// cop7

flag_cop7_dead_bankjob1 = 0

flag_cop7_got_gun_bankjob1 = 0

cop7_health_bank1 = 100

cop7_sitting_bankjob1 = 0

// cop8

flag_cop8_dead_bankjob1 = 0

flag_cop8_got_gun_bankjob1 = 0

cop8_health_bank1 = 100

// Cop9

flag_cop9_dead_bankjob1 = 0

flag_cop9_got_gun_bankjob1 = 0

cop9_health_bank1 = 100

//Cop10

flag_cop10_dead_bankjob1 = 0

flag_cop10_got_gun_bankjob1 = 0

cop10_health_bank1 = 100

// cop11

flag_cop11_dead_bankjob1 = 0

flag_cop11_got_gun_bankjob1 = 0

cop11_health_bank1 = 100

cop11_sitting_bankjob1 = 0

// General stuff

kill_player_flag_bankjob1 = 0

flag_bloke_in_group_bankjob1 = 0

player_x_bankjob1 = 0.0

player_y_bankjob1 = 0.0

player_z_bankjob1 = 0.0

// key stuff

flag_key_collected_bankjob1 = 0

flag_doors_moved_bankjob1 = 0 // Tells me the cell doors have been moved

flag_cell_door_open_bankjob1 = 0

// unifrom stuff

uniform_pickedup_bankjob1 = 0

// Player armed stuff

flag_player_armed_bankjob1 = 0

flag_player_gun_message_bankjob1 = 0

// Player in area of station he should not be

flag_player_in_station_bankjob1 = 0

flag_had_area_message_bankjob1 = 0

// Alarm stuff

total_guards_created_bankjob1 = 0

counter_blokes_alive_bankjob1 = 0

flag_created_bloke_in_area_bankjob1 = 0

flag_guard1_state_bankjob1 = 0

flag_guard2_state_bankjob1 = 0

flag_guard3_state_bankjob1 = 0

flag_guard4_state_bankjob1 = 0

flag_guard5_state_bankjob1 = 0

flag_guard6_state_bankjob1 = 0

flag_guard7_state_bankjob1 = 0

flag_guard8_state_bankjob1 = 0

flag_timer_started_bankjob1 = 0

guard_number_bankjob1 = 0

cam_died_in_subscript_bankjob1 = 0

alarm_sound_added_bankjob1 = 0

// Weapon stuff

player_had_gun_warning_bank1 = 0
		
// Celldoor audio

door_sfx1_bankjob1 = 0

had_cop_audio_1sttime_bankjob1 = 0

had_cop_audio_bankjob1 = 0 

alarm_triggered_bankjob1 = 0

// sitting stuff

cop2_sitting_bankjob1 = 1

cop3_sitting_bankjob1 = 1

cop4_sitting_bankjob1 = 1

cop5_chatting_bankjob1 = 1

cop6_sitting_bankjob1 = 1

cop8_sitting_bankjob1 = 1

cop9_sitting_bankjob1 = 1

cop10_sitting_bankjob1 = 1

// Area2 used for if the player is behind the counter in station

had_area2_message_bankjob1 = 0

game_time_bank1 = 0

timer_started_bank1 = 0

time_to_act_bank1 = 0

timer_guards_react_bank1 = 0

timer_alarm_guards_react_bank1 = 0

time_to_act_alarm_bank1 = 0

timer_started_alarm_bank1 = 0

player_has_key_message_bank1 = 0 // Used for help prints

player_no_key_message_bank1 = 0 // Used tell player he needs to get the key card first

player_had_locker_message_bank1 = 0 // Tells player about locker room

// Audio stuff

flag_played_card_beep_bank1 = 0

start_timer_for_message_bank1 = 0

// Used to delete extra guards if player is not longer in teh area

player_gone_out_bank1 = 0

// Escape car stuff

escape_car_created_bank1 = 0

WAIT 0

LOAD_MISSION_TEXT BANKJ1

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 512.591 -74.900 9.573 189.24

// FIXMIAMI: remove wanted level
CLEAR_WANTED_LEVEL player1

{

// ****************************************START OF CUTSCENE********************************

// removes all of the clothes pickups

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

REMOVE_PICKUP gun_beach11 //Inside Police Station

SWITCH_PED_ROADS_OFF 371.0 -503.0 -10.0 403.0 -490.0 30.0 //Cop shop (South beach)
SWITCH_PED_ROADS_OFF 357.0 -506.0 -10.0 384.0 -475.0 30.0 //Cop shop (South beach)
SWITCH_PED_ROADS_OFF 363.0 -476.0 -10.0 378.0 -468.0 30.0 //Cop shop (South beach)
SWITCH_PED_ROADS_OFF 383.0 -488.0 -10.0 398.3 -470.5 30.0 //Cop shop (South beach)
SWITCH_PED_ROADS_OFF 376.66 -453.85 -10.00 328.91 -504.02 30.0 //Cop Shop (Used in bank1)   

ADD_CONTINUOUS_SOUND 385.49 -509.0 9.6 SOUND_BANK_ALARM_LOOP door_sliding_bankjob1
REMOVE_SOUND door_sliding_bankjob1

/* FIXMIAMI: remove this
IF NOT IS_CHAR_DEAD scplayer
		   
	UNDRESS_CHAR scplayer player
		   
    LOAD_ALL_MODELS_NOW

	IF NOT IS_CHAR_DEAD scplayer
		DRESS_CHAR scplayer
	ENDIF

ENDIF
*/
 
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_MODEL CUTOBJ01 gcfan
LOAD_SPECIAL_MODEL CUTOBJ02 clchr

SET_AREA_VISIBLE VIS_MALIBU_CLUB

LOAD_SCENE 481.03 -64.21 8.98

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02

	WAIT 0

ENDWHILE

LOAD_CUTSCENE bank_1

SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_clubfan
SET_CUTSCENE_ANIM_TO_LOOP gcfan
SET_CUTSCENE_ANIM cs_clubfan gcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_clubchair
SET_CUTSCENE_ANIM cs_clubchair clchr

CLEAR_AREA 493.1 -82.4 9.8 1.0 TRUE
SET_PLAYER_COORDINATES player1 493.1 -82.4 9.8
SET_PLAYER_HEADING player1 220.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 9500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM1_A ) 10000 1 // "Tommy! Hey, Tommy, look at this, this is great! I've got us this minibar installed!"                                                               

WHILE cs_time < 13934
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_B ) 10000 1 //"We got a whole bar downstairs, Ken!"

WHILE cs_time < 17483
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_C ) 10000 1 //"Yeah, yeah whatever. Well I got the chalk board you asked for."

WHILE cs_time < 20276
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_D ) 10000 1 //"Ah that's the benefit of a law school education; the ability to follow instructions."

WHILE cs_time < 25517 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_E ) 10000 1 //"Now, I need a safe man."

WHILE cs_time < 27000
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_F ) 10000 1 //"Oh, alright, well let me think..safesafesafesafe- I got it! This guy will blow you away!"

WHILE cs_time < 33662
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_G ) 10000 1 //"Oh, no, that schmuck, he's on the inside."

WHILE cs_time < 36542
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_H ) 10000 1 //"Where inside?"

WHILE cs_time < 38100
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE 

PRINT_NOW ( BJM1_I ) 10000 1 //"In a police HQ cell awaiting transfer."

WHILE cs_time < 40677
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM1_J ) 10000 1 //"I think he's about to get paroled...."

WHILE cs_time < 43072
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS                                                                                                                              

WHILE cs_time < 47316
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

DO_FADE 2000 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"

CLEAR_EXTRA_COLOURS FALSE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAR_DENSITY_MULTIPLIER 1.0
UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02 

SET_CAMERA_BEHIND_PLAYER

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SCENE 493.1 -82.4 9.8

// ****************************************END OF CUTSCENE**********************************

flag_player_in_malibu = 0

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

IF NOT HAS_OBJECT_BEEN_DAMAGED cams_celldoor
	SET_OBJECT_COORDINATES cams_celldoor 384.098 -505.893 9.68 	
ENDIF

ADD_BLIP_FOR_COORD -848.02 -901.72 10.10 radar_blip_coord1_bankjob1
REMOVE_BLIP radar_blip_coord1_bankjob1 

ADD_SPHERE 385.13 -509.0 8.0 1.0 sphere2_bankjob1
REMOVE_SPHERE sphere2_bankjob1 

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 2000 FADE_IN

// Requests and loads the models
	
REQUEST_MODEL COP
LOAD_SPECIAL_CHARACTER 3 IGMIKE //CAM Jones
REQUEST_MODEL UZI
REQUEST_MODEL SENTINEL


WHILE NOT HAS_MODEL_LOADED COP
OR NOT HAS_MODEL_LOADED UZI
OR NOT HAS_SPECIAL_CHARACTER_LOADED	3
OR NOT HAS_MODEL_LOADED SENTINEL

	WAIT 0

ENDWHILE

CREATE_PICKUP health PICKUP_ONCE 366.9 -491.80 13.5 health_bankjob1

// creates the safecracker

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL03 381.528 -504.34 8.40 safecracker_bankjob1

CLEAR_CHAR_THREAT_SEARCH safecracker_bankjob1

SET_CHAR_HEADING safecracker_bankjob1 132.535


SET_CHAR_AS_PLAYER_FRIEND safecracker_bankjob1 player1 TRUE

SET_CHAR_SUFFERS_CRITICAL_HITS safecracker_bankjob1 FALSE

SET_CHAR_NEVER_TARGETTED safecracker_bankjob1 TRUE

SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_SIT_DOWN 1000000

PRINT_NOW ( BJM1_1 ) 4000 1 //"Break the safecracker out of police custody!"


ADD_BLIP_FOR_CHAR safecracker_bankjob1 radar_blip_ped1_bankjob1

// creates cop1 at the info desk ground floor 

CREATE_CHAR PEDTYPE_COP COP 388.30 -473.90 11.34 cop1_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop1_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop1_bankjob1

SET_CHAR_HEADING cop1_bankjob1 217.58

SET_CHAR_STAY_IN_SAME_PLACE cop1_bankjob1 TRUE

SET_CHAR_OBJ_GUARD_SPOT cop1_bankjob1 388.30 -473.90 11.34

// creates cop2 in info desk sitting at computer

CREATE_CHAR PEDTYPE_COP COP 387.58 -471.051 11.35 cop2_bankjob1 // 387.988 -471.397 11.35 cop2_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop2_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop2_bankjob1

SET_CHAR_STAY_IN_SAME_PLACE cop2_bankjob1 TRUE

SET_CHAR_HEADING cop2_bankjob1 352.371

SET_CHAR_WAIT_STATE cop2_bankjob1 WAITSTATE_SIT_DOWN 1000000

// Creates cop3 at info desk sitting a computer on left hand side cowardly cop ducks most of the time

CREATE_CHAR PEDTYPE_COP COP 384.196 -472.554 11.35 cop3_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop3_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop3_bankjob1

SET_CHAR_STAY_IN_SAME_PLACE cop3_bankjob1 TRUE

SET_CHAR_HEADING cop3_bankjob1 105.497

SET_CHAR_WAIT_STATE cop3_bankjob1 WAITSTATE_SIT_DOWN 1000000

// Creates cop4 guy with key for cells in upstrairs office left hand side - large office

CREATE_CHAR PEDTYPE_COP COP 363.709 -475.485 12.83 cop4_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop4_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop4_bankjob1

SET_CHAR_STAY_IN_SAME_PLACE cop4_bankjob1 TRUE

SET_CHAR_HEADING cop4_bankjob1 11.32

SET_CHAR_WAIT_STATE cop4_bankjob1 WAITSTATE_SIT_DOWN 1000000

// Creates cop5 in sitting at desk

CREATE_CHAR PEDTYPE_COP COP 362.483 -485.782 12.83 cop5_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop5_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop5_bankjob1

SET_CHAR_STAY_IN_SAME_PLACE cop5_bankjob1 TRUE

SET_CHAR_HEADING cop5_bankjob1 137.470

SET_CHAR_WAIT_STATE cop5_bankjob1 WAITSTATE_PLAYANIM_CHAT 1000000

// creates cop6 in holding room down stairs left hand side

CREATE_CHAR PEDTYPE_COP COP 400.053 -493.559 9.87 cop6_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop6_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop6_bankjob1

SET_CHAR_STAY_IN_SAME_PLACE cop6_bankjob1 TRUE

SET_CHAR_HEADING cop6_bankjob1 326.965

SET_CHAR_WAIT_STATE cop6_bankjob1 WAITSTATE_SIT_DOWN 1000000 

// Creates cop8 in middle of floor chats

CREATE_CHAR PEDTYPE_COP COP 360.686 -487.4 12.8 cop8_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop8_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop8_bankjob1

SET_CHAR_STAY_IN_SAME_PLACE cop8_bankjob1 TRUE

SET_CHAR_HEADING cop8_bankjob1 289.756

SET_CHAR_WAIT_STATE cop8_bankjob1 WAITSTATE_SIT_DOWN 1000000

// Creates cop9 in top floor in office in chair next to cop 10

CREATE_CHAR PEDTYPE_COP COP 369.358 -477.192 12.83 cop9_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop9_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop9_bankjob1

SET_CHAR_HEADING cop9_bankjob1 168.022

SET_CHAR_WAIT_STATE cop9_bankjob1 WAITSTATE_SIT_DOWN 1000000

// Creates cop10 seat facing into office right hand side

CREATE_CHAR PEDTYPE_COP COP 373.331 -477.744 12.8 cop10_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop10_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop10_bankjob1

SET_CHAR_HEADING cop10_bankjob1 177.095

SET_CHAR_WAIT_STATE cop10_bankjob1 WAITSTATE_SIT_DOWN 1000000

// Creates cop 7 filing cabinet in the middle of the floor

CREATE_CHAR PEDTYPE_COP COP 371.0 -482.2 12.8 cop7_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop7_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop7_bankjob1

SET_CHAR_HEADING cop7_bankjob1 47.54

SET_CHAR_WAIT_STATE cop7_bankjob1 WAITSTATE_USE_ATM 1000

cop7_sitting_bankjob1 = 1

// Creates cop11 on the right hand side by file cabinet.

CREATE_CHAR PEDTYPE_COP COP 372.118 -490.603 12.831 cop11_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE

++ counter_blokes_alive_bankjob1

SET_CHAR_PERSONALITY cop11_bankjob1 PEDSTAT_TOUGH_GUY

CLEAR_CHAR_THREAT_SEARCH cop11_bankjob1

SET_CHAR_HEADING cop11_bankjob1 232.192

SET_CHAR_WAIT_STATE cop11_bankjob1 WAITSTATE_USE_ATM 1000

cop11_sitting_bankjob1 = 1

// Creates the keys for the cells

CREATE_PICKUP keycard PICKUP_ONCE 364.99 -472.46 14.1 key_bankjob1

ADD_SPHERE 407.90 -486.35 11.35 1.0 sphere_bankjob1

ADD_CONTINUOUS_SOUND 405.565 -488.547 12.69 SOUND_SNORING_LOOP snore_bank1 

blob_flag = 1

// FIXMIAMI: START - check if player is already in cop uniform
IF IS_PLAYER_WEARING player1 player6
	REMOVE_SPHERE sphere_bankjob1
	uniform_pickedup_bankjob1 = 1
ENDIF
// FIXMIAMI: END


timera = 0

WHILE NOT LOCATE_STOPPED_CHAR_ANY_MEANS_3D safecracker_bankjob1 -829.62 -898.80 10.11 3.0 3.0 6.0 blob_flag
OR IS_WANTED_LEVEL_GREATER player1 0

	WAIT 0

	IF escape_car_created_bank1 = 0

		IF flag_safecracker_in_group_bankjob1 = 1
			CLEAR_AREA 381.942 -449.662 9.078 4.0 FALSE 
			CREATE_CAR SENTINEL 381.942 -449.662 9.078 escape_car_bank1
			SET_CAR_HEADING escape_car_bank1 123.277
			escape_car_created_bank1 = 1
		ENDIF
		
	ENDIF 

	IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance

		IF start_timer_for_message_bank1 = 0
			timerb= 0
			start_timer_for_message_bank1 = 1
		ENDIF

	ENDIF	
      
   	IF kill_player_flag_bankjob1 = 0 
		
	   	IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
		  		   
			IF timerb >= 3000 

				IF uniform_pickedup_bankjob1 = 0

					IF player_had_locker_message_bank1 = 0
						PRINT_NOW ( BJM1_3 ) 6000 1 //"You will find something useful in the locker room."
						player_had_locker_message_bank1 = 1
					ENDIF

				ELSE

					IF flag_key_collected_bankjob1 = 0 
				
						IF player_has_key_message_bank1 = 0

							IF timera >= 6000
								PRINT_NOW ( BJM1_21 ) 5000 1 //"The key card to the cells can be found upstairs in the station."
								ADD_BLIP_FOR_PICKUP key_bankjob1 key_blip_bank1
								player_has_key_message_bank1 = 1
							ENDIF

						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF

		IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard
		
			IF timerb > 4000 

				IF uniform_pickedup_bankjob1 = 0

					IF player_had_locker_message_bank1 = 0
						PRINT_NOW ( BJM1_3 ) 6000 1 //"You will find something useful in the locker room."
						player_had_locker_message_bank1 = 1
					ENDIF

				ELSE

					IF flag_key_collected_bankjob1 = 0 
				
						IF player_has_key_message_bank1 = 0

							IF timera > 6000
								PRINT_NOW ( BJM1_21 ) 5000 1 //"The key card to the cells can be found upstairs in the station."
								ADD_BLIP_FOR_PICKUP key_bankjob1 key_blip_bank1
								player_has_key_message_bank1 = 1
							ENDIF

						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF
		   
   	ENDIF

	GET_GAME_TIMER game_time_bank1

	IF kill_player_flag_bankjob1 = 1
		GOSUB player_force_wanted_level_bj1 // FIXMIAMI

		IF timer_guards_react_bank1 = 0
			timer_started_bank1 = game_time_bank1
			timer_guards_react_bank1 = 1
		ENDIF

		IF timer_guards_react_bank1 = 1
			time_to_act_bank1 = game_time_bank1 - timer_started_bank1 
					
			IF time_to_act_bank1 >= 2000
				timer_guards_react_bank1 = 2
			ENDIF

		ENDIF

		IF timer_alarm_guards_react_bank1 = 0
			timer_started_alarm_bank1 = game_time_bank1
			timer_alarm_guards_react_bank1 = 1
		ENDIF

		IF timer_alarm_guards_react_bank1 = 1

			time_to_act_alarm_bank1 = game_time_bank1 - timer_started_alarm_bank1 
					
			IF time_to_act_alarm_bank1 >= 2000
				timer_alarm_guards_react_bank1 = 2
			ENDIF

		ENDIF
		
	ENDIF	 

	IF alarm_triggered_bankjob1 = 0
		timerb = 0
		alarm_triggered_bankjob1 = 1
	ENDIF

	IF alarm_triggered_bankjob1 = 1
	
		IF timerb >= 1000 
		
			IF kill_player_flag_bankjob1 = 1
		   			
				IF alarm_sound_added_bankjob1 = 0 
					ADD_CONTINUOUS_SOUND 385.49 -509.0 9.6 SOUND_BANK_ALARM_LOOP alarm_bankjob1
					ALTER_WANTED_LEVEL_NO_DROP player1 4
					alarm_sound_added_bankjob1 = 1
				ENDIF

			ENDIF

		ENDIF

	ENDIF

	GET_PLAYER_COORDINATES player1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1

// player clothes change fine

	IF kill_player_flag_bankjob1 = 0

		IF LOCATE_STOPPED_PLAYER_ON_FOOT_2D player1 407.90 -486.35 1.0 1.0 FALSE
		
			IF uniform_pickedup_bankjob1 = 0
				GOSUB change_clothes_bankjob1
			ENDIF

		ENDIF

	ENDIF
					
	IF flag_cell_door_open_bankjob1 = 0
		GOSUB key_check_bankjob1
	ENDIF
	
	IF kill_player_flag_bankjob1 = 0
		GOSUB player_entered_wanted_bankjob1 // FIXMIAMI
		GOSUB player_shooting_bankjob1
		GOSUB player_armed_bankjob1
		GOSUB player_in_station_bankjob1
		GOSUB player_behind_counter_bankjob1
		GOSUB player_driving_in_station_bankjob1 
	ELSE
		REMOVE_SPHERE sphere_bankjob1
	ENDIF

	GOSUB cop_death_check

	GOSUB cop_area_check

	IF flag_safecracker_dead_bankjob1 = 0

		IF IS_CHAR_DEAD safecracker_bankjob1
		OR cam_died_in_subscript_bankjob1 = 1
			CLEAR_MISSION_AUDIO 1
			CLEAR_MISSION_AUDIO 2
			PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
			REMOVE_BLIP radar_blip_ped1_bankjob1

			IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 376.66 -453.85 9.00 328.91 -504.02 20.0 50.0 FALSE
				ALTER_WANTED_LEVEL_NO_DROP player1 4
			ENDIF

			GOTO mission_bankjob1_failed
			flag_safecracker_dead_bankjob1 = 1
		ENDIF
				
		IF flag_safecracker_in_group_bankjob1 = 0

			IF flag_cell_door_open_bankjob1 = 1

				IF LOCATE_PLAYER_ON_FOOT_CHAR_3D player1 safecracker_bankjob1 4.0 4.0 4.0 FALSE
					SET_PLAYER_AS_LEADER safecracker_bankjob1 player1
					
					GIVE_WEAPON_TO_CHAR safecracker_bankjob1 WEAPONTYPE_UZI 30000 // set to infinate ammo 
					SET_CHAR_RUNNING safecracker_bankjob1 TRUE
					SET_CHAR_PERSONALITY safecracker_bankjob1 PEDSTAT_TOUGH_GUY // FIXMIAMI
					SET_CHAR_THREAT_SEARCH safecracker_bankjob1 THREAT_COP // FIXMIAMI
					SET_CHAR_HEED_THREATS safecracker_bankjob1 TRUE // FIXMIAMI
					
					REMOVE_BLIP radar_blip_ped1_bankjob1
					kill_player_flag_bankjob1 = 1
					  
					IF had_cop_audio_1sttime_bankjob1 = 0

						IF had_cop_audio_bankjob1 = 0 
							LOAD_MISSION_AUDIO 1 ( BNK1_12 )
							had_cop_audio_bankjob1 = 1
						ENDIF

						IF had_cop_audio_bankjob1 = 1
							
							IF HAS_MISSION_AUDIO_LOADED 1
								had_cop_audio_bankjob1 = 2
							ENDIF

						ENDIF

						IF had_cop_audio_bankjob1 = 2
							PLAY_MISSION_AUDIO 1
							PRINT_NOW ( BNK1_12 ) 100000 1 //"Loose the cops!"
							had_cop_audio_bankjob1 = 3
						ENDIF

						IF had_cop_audio_bankjob1 = 3

							IF HAS_MISSION_AUDIO_FINISHED 1
								CLEAR_THIS_PRINT ( BNK1_12 )
								flag_safecracker_in_group_bankjob1 = 1
								had_cop_audio_bankjob1 = 4
							ENDIF

						ENDIF

						IF had_cop_audio_bankjob1 = 4
							ADD_BLIP_FOR_COORD -3.8 -1265.8 12.0 spray_shop_blip_bank1 
							flag_had_cops_message_bankjob1 = 1
							had_cop_audio_1sttime_bankjob1 = 1
							flag_bloke_in_group_bankjob1 = 1
							had_cop_audio_bankjob1 = 5
						ENDIF

					ENDIF

				ENDIF

			ELSE
				SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_SIT_IDLE 1000000		
			ENDIF

		ENDIF

// Safecracker in group

		IF flag_safecracker_in_group_bankjob1 = 1
			// FIXMIAMI: START
			IF IS_WANTED_LEVEL_GREATER player1 0
				SET_CHAR_RUNNING safecracker_bankjob1 TRUE // FIXMIAMI: make sure he's always running
				SET_CHAR_THREAT_SEARCH safecracker_bankjob1 THREAT_COP
				SET_CHAR_HEED_THREATS safecracker_bankjob1 TRUE
			ELSE
				CLEAR_CHAR_THREAT_SEARCH safecracker_bankjob1
				SET_CHAR_HEED_THREATS safecracker_bankjob1 FALSE
			ENDIF
			// FIXMIAMI: END
			IF flag_bloke_in_group_bankjob1 = 1
			
				IF IS_WANTED_LEVEL_GREATER player1 0

					IF had_cop_audio_1sttime_bankjob1 = 1

						IF flag_had_cops_message_bankjob1 = 0
							PRINT_NOW ( WANTED1 ) 5000 1 //"You have a wanted level loose the cops "
							ADD_BLIP_FOR_COORD -3.8 -1265.8 12.0 spray_shop_blip_bank1  
							blob_flag = 0
							flag_had_cops_message_bankjob1 = 1
						ENDIF

					ENDIF

					IF flag_cams_blip_on_bankjob1 = 1
						blob_flag = 0
						REMOVE_BLIP radar_blip_coord1_bankjob1
						flag_cams_blip_on_bankjob1 = 0
					ENDIF

				ELSE

					IF flag_had_cops_message_bankjob1 = 1
						REMOVE_BLIP spray_shop_blip_bank1
						flag_had_cops_message_bankjob1 = 0
					ENDIF 


					IF had_cop_audio_1sttime_bankjob1 = 1

						IF flag_cams_blip_on_bankjob1 = 0
							blob_flag = 1
							ADD_BLIP_FOR_COORD -848.02 -901.72 10.10 radar_blip_coord1_bankjob1
							PRINT_NOW ( BJM1_22 ) 5000 1 //"Get Cam back to his house!"
							flag_cams_blip_on_bankjob1 = 1
						ENDIF

					ENDIF

				ENDIF
				
				IF NOT IS_CHAR_IN_PLAYERS_GROUP safecracker_bankjob1 player1
					ADD_BLIP_FOR_CHAR safecracker_bankjob1 radar_blip_ped1_bankjob1
					PRINT_NOW ( HEY ) 5000 1 //"Go and get the safecracker!"
					blob_flag = 0

					IF flag_cams_blip_on_bankjob1 = 1
						blob_flag = 0
						REMOVE_BLIP radar_blip_coord1_bankjob1
						flag_cams_blip_on_bankjob1 = 0
					ENDIF

					IF flag_had_cops_message_bankjob1 = 1
						REMOVE_BLIP spray_shop_blip_bank1
						flag_had_cops_message_bankjob1 = 0
					ENDIF
										
					flag_bloke_in_group_bankjob1 = 0
				ENDIF
							
			ENDIF

			IF flag_bloke_in_group_bankjob1 = 0

				IF LOCATE_PLAYER_ANY_MEANS_CHAR_3D player1 safecracker_bankjob1 8.0 8.0 8.0 FALSE
					SET_PLAYER_AS_LEADER safecracker_bankjob1 player1
					REMOVE_BLIP radar_blip_ped1_bankjob1
					flag_bloke_in_group_bankjob1 = 1
				ENDIF

			ENDIF

		ENDIF

	ENDIF
				  	  
   	IF kill_player_flag_bankjob1 = 0
		
   		IF flag_player_armed_bankjob1 = 1
   		OR flag_player_in_station_bankjob1 = 1
   			kill_player_flag_bankjob1 = 1
		ENDIF
		
   	ELSE

// Extra guard creation stuff
						
   		IF flag_timer_started_bankjob1 = 0
   			timerb = 0
   			flag_timer_started_bankjob1 = 1
   		ENDIF
		
		IF player_gone_out_bank1 = 0
		 	GOSUB alarm_guard_creation_bankjob1
  			GOSUB guard_AI_bankjob1
			GOSUB alarm_guard_death_check_bankjob1
		ENDIF

   	ENDIF

// Gets rid off all of the guards if the player has gone out of the bank

	IF flag_safecracker_in_group_bankjob1 = 1

		IF player_gone_out_bank1 = 0

			IF NOT IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 376.66 -453.85 9.00 328.91 -504.02 20.0 50.0 FALSE
				 
				player_gone_out_bank1 = 1
					 		
		 		IF player_gone_out_bank1 = 1
					GOSUB mini_cleanup_bank1
		 		ENDIF

			ENDIF

		ENDIF
 		
 	ENDIF 	
	

ENDWHILE

REMOVE_BLIP radar_blip_coord1_bankjob1

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

SET_FIXED_CAMERA_POSITION -833.312 -904.83 12.62 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -832.709 -904.049 12.49 JUMP_CUT

LOAD_MISSION_AUDIO 1 ( BNK1_13 ) //"I'm doing a job!"
LOAD_MISSION_AUDIO 2 ( BNK1_14 ) //"Okay beats!"

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0

	IF IS_CHAR_DEAD safecracker_bankjob1
		PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
		REMOVE_BLIP radar_blip_ped1_bankjob1
		GOTO mission_bankjob1_failed
	ENDIF
	
ENDWHILE

GET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_bank1
SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED

IF NOT IS_CHAR_DEAD safecracker_bankjob1
	SET_CURRENT_CHAR_WEAPON safecracker_bankjob1 WEAPONTYPE_UNARMED
ELSE
	PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
	REMOVE_BLIP radar_blip_ped1_bankjob1
	GOTO mission_bankjob1_failed
ENDIF 

IF NOT IS_CHAR_IN_ANY_CAR scplayer 
	TURN_CHAR_TO_FACE_CHAR scplayer safecracker_bankjob1
	PLAY_MISSION_AUDIO 1
	PRINT_NOW ( BNK1_13 ) 5000 1 //"I'm doing a job and you're my safe cracker.
	SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000
ELSE
	PLAY_MISSION_AUDIO 1
	PRINT_NOW ( BNK1_13 ) 5000 1 //"I'm doing a job and you're my safe cracker.
ENDIF	

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0

	IF IS_CHAR_DEAD safecracker_bankjob1
		PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
		REMOVE_BLIP radar_blip_ped1_bankjob1
		GOTO mission_bankjob1_failed
	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( BNK1_13 )
SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1

IF NOT IS_CHAR_DEAD safecracker_bankjob1

	IF NOT IS_CHAR_IN_ANY_CAR safecracker_bankjob1
		PLAY_MISSION_AUDIO 2
		PRINT_NOW ( BNK1_14 ) 5000 1 //"Beats losing my ass in a cell!"
		SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_PLAYANIM_CHAT 1000000
	ELSE
		PLAY_MISSION_AUDIO 2
		PRINT_NOW ( BNK1_14 ) 5000 1 //"Beats losing my ass in a cell!"
	ENDIF

ELSE
	PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
	GOTO mission_bankjob1_failed
ENDIF
      
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0

	IF IS_CHAR_DEAD safecracker_bankjob1
		CLEAR_MISSION_AUDIO 2
		CLEAR_PRINTS
		PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
		REMOVE_BLIP radar_blip_ped1_bankjob1
		GOTO mission_bankjob1_failed
	ENDIF

ENDWHILE

IF NOT IS_CHAR_DEAD safecracker_bankjob1
	CLEAR_THIS_PRINT ( BNK1_14 )
	SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_FALSE 1
	LEAVE_GROUP safecracker_bankjob1 
ELSE
	PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
	GOTO mission_bankjob1_failed
ENDIF

IF NOT IS_CHAR_DEAD safecracker_bankjob1

	IF IS_CHAR_IN_ANY_CAR safecracker_bankjob1
	  	STORE_CAR_CHAR_IS_IN safecracker_bankjob1 cam_car_bankjob1
		SET_CHAR_OBJ_LEAVE_CAR safecracker_bankjob1 cam_car_bankjob1
		
		WHILE IS_CHAR_IN_ANY_CAR safecracker_bankjob1 
		
			WAIT 0

			IF IS_CHAR_DEAD safecracker_bankjob1
				PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
				GOTO mission_bankjob1_failed
			ENDIF

			IF IS_CAR_DEAD cam_car_bankjob1
			
				IF IS_CHAR_DEAD safecracker_bankjob1
					PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
					GOTO mission_bankjob1_failed
				ELSE
					GOTO mission_bankjob1_failed
				ENDIF
				
			ENDIF	 

		ENDWHILE

	ENDIF
		
ELSE
	PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
	GOTO mission_bankjob1_failed
ENDIF

IF NOT IS_CHAR_DEAD safecracker_bankjob1
	SET_CHAR_COORDINATES safecracker_bankjob1 -832.446 -902.456 10.11
	SET_CHAR_HEADING safecracker_bankjob1 165.972 
ELSE
	PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
	GOTO mission_bankjob1_failed
ENDIF 

SET_FIXED_CAMERA_POSITION -833.797 -908.45 12.06 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -833.34 -907.569 11.94 JUMP_CUT

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT safecracker_bankjob1 -833.613 -908.439 

timera = 0

WHILE timera < 3000

	WAIT 0

	IF IS_CHAR_DEAD safecracker_bankjob1
		PRINT_NOW ( BJM1_2 ) 5000 1 //"You were supposed to bust him out not get him killed!"
		GOTO mission_bankjob1_failed
	ENDIF
	
ENDWHILE

DELETE_CHAR safecracker_bankjob1
 
SET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_bank1  

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF
RESTORE_CAMERA_JUMPCUT
 
GOTO mission_bankjob1_passed

// *************************************** Mission Failed **********************************

mission_bankjob1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

// **************************************** Mission Passed *********************************

mission_bankjob1_passed:

flag_bankjob_mission1_passed = 1
REGISTER_MISSION_PASSED ( BANK_1 )
PRINT_WITH_NUMBER_BIG ( M_PASS ) 1000 5000 1 //Mission Passed!"
ADD_SCORE player1 1000
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
START_NEW_SCRIPT bankjob_mission2_loop
RETURN
		


// ****************************************** Mission Cleanup ******************************

mission_cleanup_bankjob1:

flag_player_on_mission = 0
flag_player_on_bank1_mission = 0

REMOVE_CHAR_ELEGANTLY safecracker_bankjob1 

CREATE_PICKUP nitestick PICKUP_ON_STREET_SLOW 402.4 -488.3 12.4 gun_beach11 //Inside Police Station   
REMOVE_PICKUP health_bankjob1

SET_CAR_DENSITY_MULTIPLIER 1.0
REMOVE_SOUND door_sliding_bankjob1
REMOVE_SOUND snore_bank1
REMOVE_PICKUP key_bankjob1
REMOVE_SOUND alarm_bankjob1
MARK_MODEL_AS_NO_LONGER_NEEDED COP
MARK_MODEL_AS_NO_LONGER_NEEDED UZI

MARK_MODEL_AS_NO_LONGER_NEEDED SENTINEL
UNLOAD_SPECIAL_CHARACTER 3
REMOVE_SPHERE sphere_bankjob1
REMOVE_SPHERE sphere2_bankjob1
REMOVE_BLIP radar_blip_ped1_bankjob1
REMOVE_BLIP radar_blip_coord1_bankjob1
REMOVE_BLIP key_blip_bank1
REMOVE_BLIP spray_shop_blip_bank1
GET_GAME_TIMER timer_mobile_start

// Recreates all the clothes pickups

IF mansion_clothes_created = 1
	CREATE_CLOTHES_PICKUP -384.5 -591.9 25.3 1 mansion_clothes   
ENDIF
 
IF safehouse_created2 = 1											
	CREATE_CLOTHES_PICKUP -820.2 1364.1 66.4 1 safehouse_clothes2   
ENDIF

IF hotel_clothes_created = 1                                                                                                                                                                   
	CREATE_CLOTHES_PICKUP 226.4 -1265.6 20.1 1 clothes_pickup1
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

IF clothes6_created = 1
	CREATE_CLOTHES_PICKUP 405.7 -485.6 12.3 6 clothes_pickup6
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

MISSION_HAS_FINISHED
RETURN
  
// checks to see what cops are dead

cop_death_check:

// cop1

IF flag_cop1_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop1_bankjob1
		-- counter_blokes_alive_bankjob1
	   	 kill_player_flag_bankjob1 = 1
		flag_cop1_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop1_bankjob1 cop1_health_bank1 

		IF kill_player_flag_bankjob1 = 0
			IF IS_PLAYER_TARGETTING_CHAR player1 cop1_bankjob1
			OR cop1_health_bank1 <= 95 
				kill_player_flag_bankjob1 = 1
			ENDIF

		ENDIF

	ENDIF

ENDIF

// cop2

IF flag_cop2_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop2_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop2_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop2_bankjob1 cop2_health_bank1
		
		IF kill_player_flag_bankjob1 = 0

			IF cop2_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop2_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop2_bankjob1
			OR cop2_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

		ELSE

			IF cop2_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop2_bankjob1 WAITSTATE_FALSE 1
				cop2_sitting_bankjob1 = 0
			ENDIF

		ENDIF

	ENDIF
		
ENDIF

// cop3

IF flag_cop3_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop3_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop3_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop3_bankjob1 cop3_health_bank1
		
		IF kill_player_flag_bankjob1 = 0

			IF cop3_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop3_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop3_bankjob1
			OR cop3_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

		ELSE

			IF cop3_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop3_bankjob1 WAITSTATE_FALSE 1
				cop3_sitting_bankjob1 = 0
			ENDIF
			
		ENDIF
		 
	ENDIF

ENDIF

// cop4

IF flag_cop4_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop4_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop4_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop4_bankjob1 cop4_health_bank1

		IF kill_player_flag_bankjob1 = 0

			IF cop4_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop4_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop4_bankjob1
			OR cop4_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

		ELSE
			
			IF cop4_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop4_bankjob1 WAITSTATE_FALSE 1
				cop4_sitting_bankjob1 = 0
			ENDIF

		ENDIF

	ENDIF

ENDIF

// cop5

IF flag_cop5_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop5_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop5_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop5_bankjob1 cop5_health_bank1

		IF kill_player_flag_bankjob1 = 0
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop5_bankjob1
			OR cop5_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF
			
		ELSE

			IF cop5_chatting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop5_bankjob1 WAITSTATE_FALSE 1
		 		cop5_chatting_bankjob1 = 0
			ENDIF

		ENDIF

	ENDIF

ENDIF

// cop6

IF flag_cop6_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop6_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop6_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop6_bankjob1 cop6_health_bank1
		
		IF kill_player_flag_bankjob1 = 0

			IF cop6_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop6_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop6_bankjob1
			OR cop6_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

		ELSE

			IF cop6_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop6_bankjob1 WAITSTATE_FALSE 1
				cop6_sitting_bankjob1 = 0
			ENDIF
			
		ENDIF

	ENDIF

ENDIF

// cop7

IF flag_cop7_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop7_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop7_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop7_bankjob1 cop7_health_bank1
		
		IF kill_player_flag_bankjob1 = 0

			IF cop7_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop7_bankjob1 WAITSTATE_USE_ATM 1000
			ENDIF
								
			IF IS_PLAYER_TARGETTING_CHAR player1 cop7_bankjob1
			OR cop7_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

		ELSE

			IF cop7_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop7_bankjob1 WAITSTATE_FALSE 1
				CLEAR_CHAR_WAIT_STATE cop7_bankjob1 
				cop7_sitting_bankjob1 = 0
			ENDIF
			
		ENDIF

	ENDIF

ENDIF

// cop8

IF flag_cop8_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop8_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop8_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop8_bankjob1 cop8_health_bank1

		IF kill_player_flag_bankjob1 = 0
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop8_bankjob1
			OR cop8_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

			IF cop8_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop8_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF

		ELSE

			IF cop8_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop8_bankjob1 WAITSTATE_FALSE 1
				cop8_sitting_bankjob1 = 0
			ENDIF
			
		ENDIF

	ENDIF

ENDIF

// cop9

IF flag_cop9_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop9_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop9_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop9_bankjob1 cop9_health_bank1

		IF kill_player_flag_bankjob1 = 0
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop9_bankjob1
			OR cop9_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

			IF cop9_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop9_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF

		ELSE

			IF cop9_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop9_bankjob1 WAITSTATE_FALSE 1
				cop9_sitting_bankjob1 = 0
			ENDIF
			
		ENDIF

	ENDIF

ENDIF

// cop10

IF flag_cop10_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop10_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop10_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop10_bankjob1 cop10_health_bank1

		IF kill_player_flag_bankjob1 = 0
		
			IF IS_PLAYER_TARGETTING_CHAR player1 cop10_bankjob1
			OR cop10_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

			IF cop10_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop10_bankjob1 WAITSTATE_SIT_IDLE 1000
			ENDIF

		ELSE

			IF cop10_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop10_bankjob1 WAITSTATE_FALSE 1
				cop10_sitting_bankjob1 = 0
			ENDIF
			
		ENDIF
	   	   
	ENDIF

ENDIF

// cop11

IF flag_cop11_dead_bankjob1 = 0 

	IF IS_CHAR_DEAD cop11_bankjob1
		-- counter_blokes_alive_bankjob1
		kill_player_flag_bankjob1 = 1
		flag_cop11_dead_bankjob1 = 1
	ELSE

		GET_CHAR_HEALTH cop11_bankjob1 cop11_health_bank1
			
		IF kill_player_flag_bankjob1 = 0

			IF cop11_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop11_bankjob1 WAITSTATE_USE_ATM 1000
			ENDIF
									
			IF IS_PLAYER_TARGETTING_CHAR player1 cop11_bankjob1
			OR cop11_health_bank1 <= 95
				kill_player_flag_bankjob1 = 1
			ENDIF

		ELSE

			IF cop11_sitting_bankjob1 = 1
				SET_CHAR_WAIT_STATE cop11_bankjob1 WAITSTATE_FALSE 1
				CLEAR_CHAR_WAIT_STATE cop11_bankjob1
				cop11_sitting_bankjob1 = 0
			ENDIF
				
		ENDIF

	ENDIF

ENDIF

RETURN

// sets up cops AI if the player1 is in the area, they will duck when shot at then return fire

cop_area_check:

// cop1

IF kill_player_flag_bankjob1 = 1

	IF flag_cop1_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop1_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop1_dead_bankjob1 = 1
		ELSE

		   	IF flag_duck_cop1 = 1
		   		++ counter_time_cop1_duck_again
		   	ENDIF
			
		   	IF counter_time_cop1_duck_again >=100
		   		flag_duck_cop1 = 0
		   	ENDIF
			
			IF flag_start_shoot_timer_cop1 = 1
		   		++ counter_shoot_cop1
		   	ENDIF 
						
			IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
										
				IF IS_PLAYER_SHOOTING player1
									
					IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player1 cop1_bankjob1 2.0 2.0 FALSE
						
						IF times_done_gun_cop1_bankjob1 = 0

							TURN_CHAR_TO_FACE_COORD cop1_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop1_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop1_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop1_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_bankjob1 player1
							times_done_gun_cop1_bankjob1 = 1

						ENDIF
						IF flag_duck_cop1 = 0
							flag_start_shoot_timer_cop1 = 0
						ENDIF

						IF timer_start_cop1_bankjob1 = 0
							timer_gun_cop1_bankjob1 = 0
							timer_start_cop1_bankjob1 = 1
						ENDIF

						IF timer_start_cop1_bankjob1 = 1
							++ timer_gun_cop1_bankjob1
						ENDIF

						IF timer_gun_cop1_bankjob1 >= 20

							IF flag_cop1_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop1_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop1_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								SET_CHAR_THREAT_SEARCH cop1_bankjob1 THREAT_PLAYER1
								SET_CHAR_STAY_IN_SAME_PLACE cop1_bankjob1 TRUE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_bankjob1 player1
								flag_cop1_got_gun_bankjob1 = 1
							ENDIF

						ENDIF

					ELSE

						timer_start_cop1_bankjob1 = 0

						IF flag_cop1_got_gun_bankjob1 = 1
							SET_CHAR_OBJ_NO_OBJ cop1_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop1_bankjob1 
							GIVE_WEAPON_TO_CHAR cop1_bankjob1 WEAPONTYPE_UZI 0
							flag_cop1_got_gun_bankjob1 = 0
						ENDIF

						IF flag_duck_cop1 = 0
							SET_CHAR_OBJ_NO_OBJ cop1_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop1_bankjob1 
							SET_CHAR_WAIT_STATE cop1_bankjob1 WAITSTATE_PLAYANIM_DUCK 3000
							counter_time_cop1_duck_again = 0 
							counter_shoot_cop1 = 0
							flag_start_shoot_timer_cop1 = 1 
							flag_duck_cop1 = 1
						ENDIF

						IF flag_duck_cop1 = 1
						AND counter_shoot_cop1 >= 30
							SET_CHAR_WAIT_STATE cop1_bankjob1 WAITSTATE_FALSE 0

							IF flag_cop1_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop1_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
								GIVE_WEAPON_TO_CHAR cop1_bankjob1 WEAPONTYPE_UZI 30000

								flag_cop1_got_gun_bankjob1 = 1
							ENDIF

							SET_CHAR_THREAT_SEARCH cop1_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop1_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_bankjob1 player1
						ENDIF

			 		ENDIF

				ELSE

					IF times_done_gun_cop1_bankjob1 = 0
						TURN_CHAR_TO_FACE_COORD cop1_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
						GIVE_WEAPON_TO_CHAR cop1_bankjob1 WEAPONTYPE_UZI 30000
						SET_CHAR_THREAT_SEARCH cop1_bankjob1 THREAT_PLAYER1
						SET_CHAR_STAY_IN_SAME_PLACE cop1_bankjob1 TRUE

						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_bankjob1 player1
						times_done_gun_cop1_bankjob1 = 1
					ENDIF

					IF flag_duck_cop1 = 0
						flag_start_shoot_timer_cop1 = 0
					ENDIF

					IF timer_start_cop1_bankjob1 = 0
						timer_gun_cop1_bankjob1 = 0
						timer_start_cop1_bankjob1 = 1
					ENDIF

					IF timer_start_cop1_bankjob1 = 1
						++ timer_gun_cop1_bankjob1
					ENDIF

					IF timer_gun_cop1_bankjob1 >= 20

						IF flag_cop1_got_gun_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop1_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
							GIVE_WEAPON_TO_CHAR cop1_bankjob1 WEAPONTYPE_UZI 30000
							SET_CHAR_THREAT_SEARCH cop1_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop1_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop1_bankjob1 player1
							flag_cop1_got_gun_bankjob1 = 1
						ENDIF

					ENDIF

				ENDIF

			ENDIF	

		ENDIF

	ENDIF

// cop2

	IF flag_cop2_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop2_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop2_dead_bankjob1 = 1
		ELSE

			IF flag_duck_cop2 = 1
				++ counter_time_cop2_duck_again
			ENDIF
			
			IF counter_time_cop2_duck_again >= 100
				flag_duck_cop2 = 0
			ENDIF

			IF flag_start_shoot_timer_cop2 = 1
				++ counter_shoot_cop2
			ENDIF

			IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station

				IF IS_PLAYER_SHOOTING player1

					IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player1 cop2_bankjob1 2.0 2.0 FALSE

						IF times_done_gun_cop2_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop2_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop2_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop2_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop2_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_bankjob1 player1
							times_done_gun_cop2_bankjob1 = 1
						ENDIF

						IF flag_duck_cop2 = 0
							flag_start_shoot_timer_cop2 = 0
						ENDIF

						IF timer_start_cop2_bankjob1 = 0
							timer_gun_cop2_bankjob1 = 0
							timer_start_cop2_bankjob1 = 1
						ENDIF

						IF timer_start_cop2_bankjob1 = 1
							++ timer_gun_cop2_bankjob1
						ENDIF

						IF timer_gun_cop2_bankjob1 >= 20

							IF flag_cop2_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop2_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop2_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								SET_CHAR_THREAT_SEARCH cop2_bankjob1 THREAT_PLAYER1
								SET_CHAR_STAY_IN_SAME_PLACE cop2_bankjob1 TRUE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_bankjob1 player1
								flag_cop2_got_gun_bankjob1 = 1
							ENDIF

						ENDIF

					ELSE

						timer_start_cop2_bankjob1 = 0

						IF flag_cop2_got_gun_bankjob1 = 1
							SET_CHAR_OBJ_NO_OBJ cop2_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop2_bankjob1 
							GIVE_WEAPON_TO_CHAR cop2_bankjob1 WEAPONTYPE_UZI 0
							flag_cop2_got_gun_bankjob1 = 0
						ENDIF

						IF flag_duck_cop2 = 0
							SET_CHAR_OBJ_NO_OBJ cop2_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop2_bankjob1 
							SET_CHAR_WAIT_STATE cop2_bankjob1 WAITSTATE_PLAYANIM_DUCK 3000
							counter_time_cop2_duck_again = 0 
							counter_shoot_cop2 = 0
							flag_start_shoot_timer_cop2 = 1 
							flag_duck_cop2 = 1
						ENDIF

						IF flag_duck_cop2 = 1
						AND counter_shoot_cop2 >= 30
							SET_CHAR_WAIT_STATE cop2_bankjob1 WAITSTATE_FALSE 0

							IF flag_cop2_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop2_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
								GIVE_WEAPON_TO_CHAR cop2_bankjob1 WEAPONTYPE_UZI 30000
								flag_cop2_got_gun_bankjob1 = 1
							ENDIF

							SET_CHAR_THREAT_SEARCH cop2_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop2_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_bankjob1 player1
						ENDIF

					ENDIF
	   	   
				ELSE 				 			
					IF times_done_gun_cop2_bankjob1 = 0
						TURN_CHAR_TO_FACE_COORD cop2_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
						GIVE_WEAPON_TO_CHAR cop2_bankjob1 WEAPONTYPE_UZI 30000
						SET_CHAR_THREAT_SEARCH cop2_bankjob1 THREAT_PLAYER1
						SET_CHAR_STAY_IN_SAME_PLACE cop2_bankjob1 TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_bankjob1 player1
						times_done_gun_cop2_bankjob1 = 1
					ENDIF

					IF flag_duck_cop2 = 0
						flag_start_shoot_timer_cop2 = 0
					ENDIF

					IF timer_start_cop2_bankjob1 = 0
						timer_gun_cop2_bankjob1 = 0
						timer_start_cop2_bankjob1 = 1
					ENDIF

					IF timer_start_cop2_bankjob1 = 1
						++ timer_gun_cop2_bankjob1
					ENDIF

					IF timer_gun_cop2_bankjob1 >= 20

						IF flag_cop2_got_gun_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop2_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
							GIVE_WEAPON_TO_CHAR cop2_bankjob1 WEAPONTYPE_UZI 30000
							SET_CHAR_THREAT_SEARCH cop2_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop2_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop2_bankjob1 player1
							flag_cop2_got_gun_bankjob1 = 1
						ENDIF

					ENDIF

				ENDIF

			ELSE

				IF kill_player_flag_bankjob1 = 0
					SET_CHAR_WAIT_STATE cop2_bankjob1 WAITSTATE_SIT_IDLE 10
				ENDIF

			ENDIF

		ENDIF

	ENDIF

// cop3

	IF flag_cop3_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop3_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop3_dead_bankjob1 = 1
		ELSE

			IF flag_duck_cop3 = 1
				++ counter_time_cop3_duck_again
			ENDIF
			
			IF counter_time_cop3_duck_again >= 50 // 3000 = 3 seconds
				flag_duck_cop3 = 0
			ENDIF

			IF flag_start_shoot_timer_cop3 = 1
				++ counter_shoot_cop3
			ENDIF
			  			  		   
			IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station

				IF IS_PLAYER_SHOOTING player1

					IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player1 cop3_bankjob1 2.0 2.0 FALSE

						IF times_done_gun_cop3_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop3_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop3_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop3_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop3_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_bankjob1 player1
							times_done_gun_cop3_bankjob1 = 1
						ENDIF

						IF flag_duck_cop3 = 0
							flag_start_shoot_timer_cop3 = 0
						ENDIF

						IF timer_start_cop3_bankjob1 = 0
							timer_gun_cop3_bankjob1 = 0
							timer_start_cop3_bankjob1 = 1
						ENDIF

						IF timer_start_cop3_bankjob1 = 1
							++ timer_gun_cop3_bankjob1
						ENDIF

						IF timer_gun_cop3_bankjob1 >= 20

							IF flag_cop3_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop3_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop3_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								SET_CHAR_THREAT_SEARCH cop3_bankjob1 THREAT_PLAYER1
								SET_CHAR_STAY_IN_SAME_PLACE cop3_bankjob1 TRUE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_bankjob1 player1
								flag_cop3_got_gun_bankjob1 = 1
							ENDIF

						ENDIF

					ELSE

						timer_start_cop3_bankjob1 = 0

						IF flag_cop3_got_gun_bankjob1 = 1
							SET_CHAR_OBJ_NO_OBJ cop3_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop3_bankjob1 
							GIVE_WEAPON_TO_CHAR cop3_bankjob1 WEAPONTYPE_UZI 0
							flag_cop3_got_gun_bankjob1 = 0
						ENDIF

						IF flag_duck_cop3 = 0
							SET_CHAR_OBJ_NO_OBJ cop3_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop3_bankjob1 
							SET_CHAR_WAIT_STATE cop3_bankjob1 WAITSTATE_PLAYANIM_DUCK 3000
							counter_time_cop3_duck_again = 0 
							counter_shoot_cop3 = 0
							flag_start_shoot_timer_cop3 = 1 
							flag_duck_cop3 = 1
						ENDIF

						IF flag_duck_cop3 = 1
						AND counter_shoot_cop3 >= 30
							SET_CHAR_WAIT_STATE cop3_bankjob1 WAITSTATE_FALSE 0

							IF flag_cop3_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop3_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
								GIVE_WEAPON_TO_CHAR cop3_bankjob1 WEAPONTYPE_UZI 30000
								flag_cop3_got_gun_bankjob1 = 1
							ENDIF
							
							SET_CHAR_THREAT_SEARCH cop3_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop3_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_bankjob1 player1
						ENDIF

			   		ENDIF

				ELSE

					IF times_done_gun_cop3_bankjob1 = 0
						TURN_CHAR_TO_FACE_COORD cop3_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
						GIVE_WEAPON_TO_CHAR cop3_bankjob1 WEAPONTYPE_UZI 30000
						SET_CHAR_THREAT_SEARCH cop3_bankjob1 THREAT_PLAYER1
						SET_CHAR_STAY_IN_SAME_PLACE cop3_bankjob1 TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_bankjob1 player1
						times_done_gun_cop3_bankjob1 = 1
					ENDIF

					IF flag_duck_cop3 = 0
						flag_start_shoot_timer_cop3 = 0
					ENDIF

					IF timer_start_cop3_bankjob1 = 0
						timer_gun_cop3_bankjob1 = 0
						timer_start_cop3_bankjob1 = 1
					ENDIF

					IF timer_start_cop3_bankjob1 = 1
						++ timer_gun_cop3_bankjob1
					ENDIF

					IF timer_gun_cop3_bankjob1 >= 20

						IF flag_cop3_got_gun_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop3_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 
							GIVE_WEAPON_TO_CHAR cop3_bankjob1 WEAPONTYPE_UZI 30000
							SET_CHAR_THREAT_SEARCH cop3_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop3_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop3_bankjob1 player1
							flag_cop3_got_gun_bankjob1 = 1
						ENDIF

					ENDIF	

				ENDIF

			ELSE

				IF kill_player_flag_bankjob1 = 0
					SET_CHAR_WAIT_STATE cop3_bankjob1 WAITSTATE_SIT_IDLE 10
				ENDIF
				
			ENDIF

		ENDIF
		
	ENDIF

// cop4

	IF flag_cop4_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop4_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop4_dead_bankjob1 = 1
		ELSE

			IF flag_duck_cop4 = 1
				++ counter_time_cop4_duck_again
			ENDIF
			
			IF counter_time_cop4_duck_again >=80 // 3000 = 3 seconds
				flag_duck_cop4 = 0
			ENDIF

			IF flag_start_shoot_timer_cop4 = 1
				++ counter_shoot_cop4
			ENDIF
			 
			IF IS_PLAYER_IN_ANGLED_AREA_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE //upstairs room with key
			OR IS_PLAYER_IN_ANGLED_AREA_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link from main corridor to key area

				IF IS_PLAYER_SHOOTING player1

					IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player1 cop4_bankjob1 2.0 2.0 FALSE

						IF times_done_gun_cop4_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop4_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop4_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop4_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop4_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4_bankjob1 player1
							times_done_gun_cop4_bankjob1 = 1
						ENDIF
			 			 
			   			IF flag_duck_cop4 = 0
			   				flag_start_shoot_timer_cop4 = 0
						ENDIF

						IF timer_start_cop4_bankjob1 = 0
							timer_gun_cop4_bankjob1 = 0
							timer_start_cop4_bankjob1 = 1
						ENDIF

						IF timer_start_cop4_bankjob1 = 1
							++ timer_gun_cop4_bankjob1
						ENDIF	
					
						IF timer_gun_cop4_bankjob1 >= 20

							IF flag_cop4_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop4_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop4_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								SET_CHAR_THREAT_SEARCH cop4_bankjob1 THREAT_PLAYER1
			   					SET_CHAR_STAY_IN_SAME_PLACE cop4_bankjob1 TRUE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4_bankjob1 player1
								flag_cop4_got_gun_bankjob1 = 1
							ENDIF

						ENDIF

					ELSE

						timer_start_cop4_bankjob1 = 0
													
						IF flag_cop4_got_gun_bankjob1 = 1
							SET_CHAR_OBJ_NO_OBJ cop4_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop4_bankjob1
							GIVE_WEAPON_TO_CHAR cop4_bankjob1 WEAPONTYPE_UZI 0 // sets gun to no ammo
							flag_cop4_got_gun_bankjob1 = 0 	
						ENDIF   

						IF flag_duck_cop4 = 0
							SET_CHAR_OBJ_NO_OBJ cop4_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop4_bankjob1
							SET_CHAR_WAIT_STATE cop4_bankjob1 WAITSTATE_PLAYANIM_DUCK 3000
				   			counter_time_cop4_duck_again = 0
				   			counter_shoot_cop4 = 0
				  			flag_start_shoot_timer_cop4 = 1
							flag_duck_cop4 = 1
						ENDIF

			   			IF flag_duck_cop4 = 1
			   			AND counter_shoot_cop4 >= 30
							SET_CHAR_WAIT_STATE cop4_bankjob1 WAITSTATE_FALSE 0
					
							IF flag_cop4_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop4_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop4_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								flag_cop4_got_gun_bankjob1 = 1
							ENDIF
						 
			   				SET_CHAR_THREAT_SEARCH cop4_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop4_bankjob1 TRUE
			   			ENDIF

					ENDIF
																
				ELSE
				
					IF times_done_gun_cop4_bankjob1 = 0
						TURN_CHAR_TO_FACE_COORD cop4_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
						GIVE_WEAPON_TO_CHAR cop4_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
						SET_CHAR_THREAT_SEARCH cop4_bankjob1 THREAT_PLAYER1
			   			SET_CHAR_STAY_IN_SAME_PLACE cop4_bankjob1 TRUE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4_bankjob1 player1
						times_done_gun_cop4_bankjob1 = 1
					ENDIF
			 			 
			   		IF flag_duck_cop4 = 0
			   			flag_start_shoot_timer_cop4 = 0
					ENDIF

					IF timer_start_cop4_bankjob1 = 0
						timer_gun_cop4_bankjob1 = 0
						timer_start_cop4_bankjob1 = 1
					ENDIF

					IF timer_start_cop4_bankjob1 = 1
						++ timer_gun_cop4_bankjob1
					ENDIF	
					
					IF timer_gun_cop4_bankjob1 >= 20

						IF flag_cop4_got_gun_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop4_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop4_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop4_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop4_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop4_bankjob1 player1
							flag_cop4_got_gun_bankjob1 = 1
						ENDIF

					ENDIF
										
				ENDIF

			ELSE

				IF kill_player_flag_bankjob1 = 0 
					SET_CHAR_WAIT_STATE cop4_bankjob1 WAITSTATE_SIT_IDLE 10
				ENDIF

			ENDIF

		ENDIF
		
	ENDIF

// cop5

	IF flag_cop5_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop5_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop5_dead_bankjob1 = 1
		ELSE
			
			IF flag_cop5_got_gun_bankjob1 = 0
				GIVE_WEAPON_TO_CHAR cop5_bankjob1 WEAPONTYPE_UZI 30000 // Unlimited ammo
				CHAR_FOLLOW_PATH cop5_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop5_bankjob1 player1 
				flag_cop5_got_gun_bankjob1 = 1	
			ENDIF

			IF timer_guards_react_bank1 = 2
				CHAR_FOLLOW_PATH cop5_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop5_bankjob1 player1
			ENDIF

		ENDIF

	ENDIF
				 	 
// cop6

	IF flag_cop6_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop6_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop6_dead_bankjob1 = 1
		ELSE

			IF flag_duck_cop6 = 1
				++ counter_time_cop6_duck_again
			ENDIF
			
			IF counter_time_cop6_duck_again >=80
				flag_duck_cop6 = 0
			ENDIF

			IF flag_start_shoot_timer_cop6 = 1
				++ counter_shoot_cop6
			ENDIF
			  
			IF IS_PLAYER_IN_ANGLED_AREA_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE // Link corridor from main corridor to charging area
			OR IS_PLAYER_IN_ANGLED_AREA_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // chargeing room
			OR IS_PLAYER_IN_ANGLED_AREA_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Cells area
			OR IS_PLAYER_IN_ANGLED_AREA_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link corridor form charge area to cells
			OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station

				IF IS_PLAYER_SHOOTING player1

					IF LOCATE_PLAYER_ON_FOOT_CHAR_2D player1 cop6_bankjob1 2.0 2.0 FALSE

						IF times_done_gun_cop6_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop6_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop6_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop6_bankjob1 THREAT_PLAYER1
							SET_CHAR_STAY_IN_SAME_PLACE cop6_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop6_bankjob1 player1
							times_done_gun_cop6_bankjob1 = 1
						ENDIF
			 			 
			   			IF flag_duck_cop6 = 0
			   				flag_start_shoot_timer_cop6 = 0
						ENDIF

						IF timer_start_cop6_bankjob1 = 0
							timer_gun_cop6_bankjob1 = 0
							timer_start_cop6_bankjob1 = 1
						ENDIF

						IF timer_start_cop6_bankjob1 = 1
							++ timer_gun_cop6_bankjob1
						ENDIF	
					
						IF timer_gun_cop6_bankjob1 >= 20

							IF flag_cop6_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop6_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop6_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								SET_CHAR_THREAT_SEARCH cop6_bankjob1 THREAT_PLAYER1
			   					SET_CHAR_STAY_IN_SAME_PLACE cop6_bankjob1 TRUE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop6_bankjob1 player1
								flag_cop6_got_gun_bankjob1 = 1
							ENDIF

						ENDIF

					ELSE

						timer_start_cop6_bankjob1 = 0
													
						IF flag_cop6_got_gun_bankjob1 = 1
							SET_CHAR_OBJ_NO_OBJ cop6_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop6_bankjob1
							GIVE_WEAPON_TO_CHAR cop6_bankjob1 WEAPONTYPE_UZI 0 // sets gun to no ammo
							flag_cop6_got_gun_bankjob1 = 0 	
						ENDIF   

						IF flag_duck_cop6 = 0
							SET_CHAR_OBJ_NO_OBJ cop6_bankjob1
							CLEAR_CHAR_THREAT_SEARCH cop6_bankjob1
							SET_CHAR_WAIT_STATE cop6_bankjob1 WAITSTATE_PLAYANIM_DUCK 3000
				   			counter_time_cop6_duck_again = 0
				   			counter_shoot_cop6 = 0
				  			flag_start_shoot_timer_cop6 = 1
							flag_duck_cop6 = 1
						ENDIF

			   			IF flag_duck_cop6 = 1
			   			AND counter_shoot_cop6 >= 30
							SET_CHAR_WAIT_STATE cop6_bankjob1 WAITSTATE_FALSE 0
					
							IF flag_cop6_got_gun_bankjob1 = 0
								TURN_CHAR_TO_FACE_COORD cop6_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
								GIVE_WEAPON_TO_CHAR cop6_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
								flag_cop6_got_gun_bankjob1 = 1
							ENDIF
						 
			   				SET_CHAR_THREAT_SEARCH cop6_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop6_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop6_bankjob1 player1
			   			ENDIF

					ENDIF
																
				ELSE
				
					IF times_done_gun_cop6_bankjob1 = 0
						TURN_CHAR_TO_FACE_COORD cop6_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
						GIVE_WEAPON_TO_CHAR cop6_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
						SET_CHAR_THREAT_SEARCH cop6_bankjob1 THREAT_PLAYER1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop6_bankjob1 player1 
						SET_CHAR_STAY_IN_SAME_PLACE cop6_bankjob1 TRUE
						times_done_gun_cop6_bankjob1 = 1
					ENDIF
			 			 
			   		IF flag_duck_cop6 = 0
			   			flag_start_shoot_timer_cop6 = 0
					ENDIF

					IF timer_start_cop6_bankjob1 = 0
						timer_gun_cop6_bankjob1 = 0
						timer_start_cop6_bankjob1 = 1
					ENDIF

					IF timer_start_cop6_bankjob1 = 1
						++ timer_gun_cop6_bankjob1
					ENDIF	
					
					IF timer_gun_cop6_bankjob1 >= 20

						IF flag_cop6_got_gun_bankjob1 = 0
							TURN_CHAR_TO_FACE_COORD cop6_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1
							GIVE_WEAPON_TO_CHAR cop6_bankjob1 WEAPONTYPE_UZI 30000 // sets gun to infinate ammo
							SET_CHAR_THREAT_SEARCH cop6_bankjob1 THREAT_PLAYER1
			   				SET_CHAR_STAY_IN_SAME_PLACE cop6_bankjob1 TRUE
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop6_bankjob1 player1
							flag_cop6_got_gun_bankjob1 = 1
						ENDIF

					ENDIF
										
				ENDIF

			ELSE

				IF kill_player_flag_bankjob1 = 0 
					SET_CHAR_WAIT_STATE cop6_bankjob1 WAITSTATE_SIT_IDLE 10
				ENDIF

			ENDIF

		ENDIF
		
	ENDIF
	
// cop7

	IF flag_cop7_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop7_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop7_dead_bankjob1 = 1
		ELSE
			
			IF flag_cop7_got_gun_bankjob1 = 0
				GIVE_WEAPON_TO_CHAR cop7_bankjob1 WEAPONTYPE_UZI 30000 // Unlimited ammo
				CHAR_FOLLOW_PATH cop7_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop7_bankjob1 player1 
				flag_cop7_got_gun_bankjob1 = 1	
			ENDIF

			IF timer_guards_react_bank1 = 2
				CHAR_FOLLOW_PATH cop7_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop7_bankjob1 player1
			ENDIF

		ENDIF

	ENDIF
		  			      	   		 
// cop8
		
	IF flag_cop8_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop8_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop8_dead_bankjob1 = 1
		ELSE
			
			IF flag_cop8_got_gun_bankjob1 = 0
				GIVE_WEAPON_TO_CHAR cop8_bankjob1 WEAPONTYPE_UZI 30000 // Unlimited ammo
				CHAR_FOLLOW_PATH cop8_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop8_bankjob1 player1 
				flag_cop8_got_gun_bankjob1 = 1	
			ENDIF

			IF timer_guards_react_bank1 = 2
				CHAR_FOLLOW_PATH cop8_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop8_bankjob1 player1
			ENDIF

		ENDIF

	ENDIF
					 
// cop9
	
	IF flag_cop9_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop9_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop9_dead_bankjob1 = 1
		ELSE

			IF flag_cop9_got_gun_bankjob1 = 0
				GIVE_WEAPON_TO_CHAR cop9_bankjob1 WEAPONTYPE_UZI 30000 // Unlimited ammo
				CHAR_FOLLOW_PATH cop9_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop9_bankjob1 player1 
				flag_cop9_got_gun_bankjob1 = 1	
			ENDIF

			IF timer_guards_react_bank1 = 2
			  	CHAR_FOLLOW_PATH cop9_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop9_bankjob1 player1
			ENDIF

		ENDIF

	ENDIF
						   
// cop10
	
	IF flag_cop10_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop10_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop10_dead_bankjob1 = 1
		ELSE

			IF flag_cop10_got_gun_bankjob1 = 0
				GIVE_WEAPON_TO_CHAR cop10_bankjob1 WEAPONTYPE_UZI 30000 // Unlimited ammo
				CHAR_FOLLOW_PATH cop10_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop10_bankjob1 player1 
				flag_cop10_got_gun_bankjob1 = 1	
			ENDIF

			IF timer_guards_react_bank1 = 2
				CHAR_FOLLOW_PATH cop10_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop10_bankjob1 player1
			ENDIF

		ENDIF

	ENDIF
					  
// cop 11

	IF flag_cop11_dead_bankjob1 = 0 

		IF IS_CHAR_DEAD cop11_bankjob1
			-- counter_blokes_alive_bankjob1
			flag_cop11_dead_bankjob1 = 1
		ELSE
				
			IF flag_cop11_got_gun_bankjob1 = 0
				GIVE_WEAPON_TO_CHAR cop11_bankjob1 WEAPONTYPE_UZI 30000 // Unlimited ammo
				CHAR_FOLLOW_PATH cop11_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop11_bankjob1 player1 
				flag_cop11_got_gun_bankjob1 = 1	
			ENDIF

			IF timer_guards_react_bank1 = 2
				CHAR_FOLLOW_PATH cop11_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT cop11_bankjob1 player1
			ENDIF

		ENDIF

	ENDIF

ENDIF

IF timer_guards_react_bank1 = 2
	timer_guards_react_bank1 = 0
ENDIF

RETURN

// Checks to see if the key has been picked up or not

key_check_bankjob1:

IF flag_key_collected_bankjob1 = 0

	IF LOCATE_PLAYER_ON_FOOT_3D player1 385.13 -509.0 8.0 0.5 0.5 3.0 FALSE
		
		IF player_no_key_message_bank1 = 0
			PRINT_NOW ( BJM1_23 ) 5000 1 //"You need to get the key card first
			player_no_key_message_bank1 = 1
		ENDIF

	ELSE
		player_no_key_message_bank1 = 0
	ENDIF


	IF HAS_PICKUP_BEEN_COLLECTED key_bankjob1
		REMOVE_BLIP key_blip_bank1
		ADD_SPHERE 385.13 -509.0 8.0 1.0 sphere2_bankjob1
		flag_key_collected_bankjob1 = 1
	ENDIF

ELSE

	IF flag_cell_door_open_bankjob1 = 0 

   		IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 385.13 -509.0 8.0 0.5 0.5 3.0 FALSE

			SWITCH_WIDESCREEN ON
			SET_PLAYER_CONTROL player1 OFF
			SET_POLICE_IGNORE_PLAYER player1 ON
			SET_EVERYONE_IGNORE_PLAYER player1 ON

			GET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_bank1
			SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED

			REMOVE_SPHERE sphere2_bankjob1 

			CLEAR_AREA 387.22 -506.517 9.194 1.0 FALSE 
			SET_FIXED_CAMERA_POSITION 387.22 -506.517 9.194 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 386.633 -507.287 9.430 JUMP_CUT

			TURN_CHAR_TO_FACE_COORD scplayer 384.932 -510.077 9.848
			SET_CHAR_WAIT_STATE scplayer WAITSTATE_USE_ATM 100000
						
			timera = 0

			WHILE timera < 3000
							
				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF

				IF timera >= 2000

					IF flag_played_card_beep_bank1 = 0
						ADD_ONE_OFF_SOUND 384.932 -510.077 9.848 SOUND_WILLIE_CARD_SWIPE
						flag_played_card_beep_bank1 = 1
					ENDIF

				ENDIF

			ENDWHILE
			
			CLEAR_CHAR_WAIT_STATE scplayer

			POINT_CAMERA_AT_POINT 386.250 -506.384 9.373 JUMP_CUT
			
			LOAD_MISSION_AUDIO 1 ( BNK1_7 ) //Cam jones?"
			LOAD_MISSION_AUDIO 2 ( BNK1_10 ) //"Yeah thats me."

			IF flag_doors_moved_bankjob1 = 0
		   					 
				WHILE NOT SLIDE_OBJECT cams_celldoor 383.252 -506.903 9.68 0.01 0.01 0.0 FALSE
				OR NOT HAS_MISSION_AUDIO_LOADED 1
				OR NOT HAS_MISSION_AUDIO_LOADED 2
											  			
					WAIT 0

					IF door_sfx1_bankjob1 = 0
						ADD_ONE_OFF_SOUND 383.252 -506.903 9.68 SOUND_POLICE_CELL_DOOR_CLUNK 
						door_sfx1_bankjob1 = 1
					ENDIF

					IF door_sfx1_bankjob1 = 1 
						ADD_CONTINUOUS_SOUND 383.252 -506.903 9.68 SOUND_POLICE_CELL_DOOR_SLIDING_LOOP door_sliding_bankjob1    
						door_sfx1_bankjob1 = 2
					ENDIF
					
					IF IS_CHAR_DEAD safecracker_bankjob1 
						cam_died_in_subscript_bankjob1 = 1
					ENDIF

				ENDWHILE
				
				REMOVE_SOUND door_sliding_bankjob1

				IF door_sfx1_bankjob1 = 2
					ADD_ONE_OFF_SOUND 383.252 -506.903 9.68 SOUND_POLICE_CELL_DOOR_CLUNK
					door_sfx1_bankjob1 = 3
				ENDIF
					
				flag_doors_moved_bankjob1 = 1			
				
			ENDIF
						
			
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 384.12 -507.38			

			timera = 0

			IF NOT IS_CHAR_DEAD safecracker_bankjob1
				SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_FALSE 1  
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT safecracker_bankjob1 383.523 -505.34
			ELSE
				cam_died_in_subscript_bankjob1 = 1
			ENDIF

			
			WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer 384.12 -507.38 0.5 0.5 FALSE
			
				WAIT 0
				
				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF
					
				IF timera > 8000

					IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer 384.12 -507.38 0.5 0.5 FALSE
						SET_CHAR_COORDINATES scplayer 384.12 -507.38 8.40
					ENDIF
						
				ENDIF
								
			ENDWHILE
									
			timerb = 0
			
			WHILE NOT LOCATE_CHAR_ON_FOOT_2D safecracker_bankjob1 383.523 -505.34 0.5 0.5 FALSE
			
				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ELSE
					
					IF timerb > 8000

						IF NOT LOCATE_CHAR_ON_FOOT_2D safecracker_bankjob1 383.523 -505.34 0.5 0.5 FALSE
							SET_CHAR_COORDINATES safecracker_bankjob1 383.523 -505.34 8.40
						ENDIF
						
					ENDIF
					
				ENDIF
				
			ENDWHILE

			TURN_CHAR_TO_FACE_CHAR scplayer safecracker_bankjob1 
			
			PLAY_MISSION_AUDIO 1
			PRINT_NOW ( BNK1_7 ) 5000 1 //"Cam Jones?"
			SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000

			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
				
				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF

			ENDWHILE

			CLEAR_THIS_PRINT ( BNK1_7 ) //"Cam Jones?"
			SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
			LOAD_MISSION_AUDIO 1 ( BNK1_8 ) //"I'm busting you out!"
			
			PLAY_MISSION_AUDIO 2
			PRINT_NOW ( BNK1_10 ) 10000 1//"Yeah that's me.."

			IF NOT IS_CHAR_DEAD safecracker_bankjob1
				SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_PLAYANIM_CHAT 1000000
			ELSE
				cam_died_in_subscript_bankjob1 = 1
			ENDIF 
			
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
			OR NOT HAS_MISSION_AUDIO_LOADED 1
			
				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF
				
			ENDWHILE
			
			CLEAR_THIS_PRINT ( BNK1_10 )

			IF NOT IS_CHAR_DEAD safecracker_bankjob1
				SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_FALSE 1
			ELSE
				cam_died_in_subscript_bankjob1 = 1
			ENDIF

			LOAD_MISSION_AUDIO 2 ( BNK1_11 ) //"What ever you say."

			PLAY_MISSION_AUDIO 1 // I'm busting you out! 
			PRINT_NOW ( BNK1_8 ) 10000 1 //"I'm busting you out!"
			SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000 

			WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			OR NOT HAS_MISSION_AUDIO_LOADED 2
			
				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF
				
			ENDWHILE
			
			CLEAR_THIS_PRINT ( BNK1_8 )
			SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
			
			PLAY_MISSION_AUDIO 2
			PRINT_NOW ( BNK1_11 ) 10000 1 //"What ever you say."
			
			IF NOT IS_CHAR_DEAD safecracker_bankjob1
				SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_PLAYANIM_CHAT 1000000
			ELSE
				cam_died_in_subscript_bankjob1 = 1
			ENDIF   
			
			WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF

			ENDWHILE

			CLEAR_THIS_PRINT ( BNK1_11 )
			
			IF NOT IS_CHAR_DEAD safecracker_bankjob1
				SET_CHAR_WAIT_STATE safecracker_bankjob1 WAITSTATE_FALSE 1
			ELSE
				cam_died_in_subscript_bankjob1 = 1
			ENDIF

			CLEAR_AREA 389.950 -503.077 9.114 1.0 FALSE
			SET_FIXED_CAMERA_POSITION 389.950 -503.077 9.114 0.0 0.0 0.0
			POINT_CAMERA_AT_POINT 389.151 -503.666 9.229 JUMP_CUT 
			
			SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 387.64 -505.70

			timerb = 0

			WHILE timerb < 750

				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF
				
			ENDWHILE

			IF NOT IS_CHAR_DEAD safecracker_bankjob1 
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT safecracker_bankjob1 385.48 -506.76 	 
			ENDIF

			timera = 0

			WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer 387.64 -505.70 0.5 0.5 FALSE
			
				WAIT 0
				
				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ENDIF

				IF timera > 5000

					IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer 387.64 -505.70 0.5 0.5 FALSE 
						SET_CHAR_COORDINATES scplayer 387.64 -505.70 8.41
					ENDIF

				ENDIF

			ENDWHILE

			timerb = 0
			
			WHILE NOT LOCATE_CHAR_ON_FOOT_2D safecracker_bankjob1 385.48 -506.76 0.5 0.5 FALSE
			
				WAIT 0

				IF IS_CHAR_DEAD safecracker_bankjob1 
					cam_died_in_subscript_bankjob1 = 1
				ELSE

					IF timerb > 5000

						IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer 385.48 -506.76 0.5 0.5 FALSE 
							SET_CHAR_COORDINATES scplayer 385.48 -506.76 8.41
						ENDIF

					ENDIF

				ENDIF
				
			ENDWHILE
			
			SET_CHAR_HEADING scplayer 333.85
			
			IF NOT IS_CHAR_DEAD safecracker_bankjob1
				SET_CHAR_HEADING safecracker_bankjob1 333.85
			ELSE
				cam_died_in_subscript_bankjob1 = 1
			ENDIF	   
		
			SET_CURRENT_CHAR_WEAPON scplayer stored_current_weapon_bank1
			SWITCH_WIDESCREEN OFF
			SET_PLAYER_CONTROL player1 ON
			SET_POLICE_IGNORE_PLAYER player1 OFF
			SET_EVERYONE_IGNORE_PLAYER player1 OFF
			SET_CAMERA_IN_FRONT_OF_PLAYER 
			RESTORE_CAMERA_JUMPCUT 
						
			flag_cell_door_open_bankjob1 = 1
		ENDIF

	ENDIF

ENDIF

RETURN

// Player armed checks

player_armed_bankjob1:

IF uniform_pickedup_bankjob1 = 0
		
	IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
	   	   		
		IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED
		AND NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_BRASSKNUCKLE

			IF player_had_gun_warning_bank1 = 0
				LOAD_MISSION_AUDIO 1 ( BJM1_20 )
				player_had_gun_warning_bank1 = 1
			ENDIF
			
			IF player_had_gun_warning_bank1 = 1
				
				IF HAS_MISSION_AUDIO_LOADED 1
					player_had_gun_warning_bank1 = 2
				ENDIF
				
			ENDIF
			
			IF player_had_gun_warning_bank1 = 2
				PLAY_MISSION_AUDIO 1
				PRINT_NOW ( BJM1_20 ) 5000 1 //"Put the weapon away or face the consequences!"
				player_had_gun_warning_bank1 = 3  
			ENDIF

			IF player_had_gun_warning_bank1 = 3

				IF HAS_MISSION_AUDIO_FINISHED 1
					CLEAR_THIS_PRINT ( BJM1_20 )
					player_had_gun_warning_bank1 = 4
				ENDIF

			ENDIF

			IF player_had_gun_warning_bank1 = 4
				timerb = 0
				player_had_gun_warning_bank1 = 5
			ENDIF	
						
			IF player_had_gun_warning_bank1 = 5 

				IF timerb >= 4000 // Should be 4 secs

					IF flag_player_gun_message_bankjob1 = 0
						LOAD_MISSION_AUDIO 2 ( BJM1_4 )
						flag_player_gun_message_bankjob1 = 1
					ENDIF

				ENDIF

			ENDIF

			IF flag_player_gun_message_bankjob1 = 1

				IF HAS_MISSION_AUDIO_LOADED 2
					flag_player_gun_message_bankjob1 = 2
				ENDIF

			ENDIF

			IF flag_player_gun_message_bankjob1 = 2
				PLAY_MISSION_AUDIO 2
				PRINT_NOW ( BJM1_4 ) 5000 1 //"He's armed, kill him!"
				flag_player_gun_message_bankjob1 = 3
			ENDIF

			IF flag_player_gun_message_bankjob1 = 3

				IF HAS_MISSION_AUDIO_FINISHED 2
					CLEAR_THIS_PRINT ( BJM1_4 )
					flag_player_gun_message_bankjob1 = 4
				ENDIF

			ENDIF

			IF flag_player_gun_message_bankjob1 = 4
				flag_player_armed_bankjob1 = 1
				flag_player_gun_message_bankjob1 = 5
			ENDIF	
													
		ELSE
			flag_player_gun_message_bankjob1 = 0
			player_had_gun_warning_bank1 = 0 
			flag_player_armed_bankjob1 = 0
		ENDIF
	   
	ENDIF
	
	IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard

		IF NOT IS_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED

			IF player_had_gun_warning_bank1 = 0
				LOAD_MISSION_AUDIO 1 ( BJM1_20 )
				player_had_gun_warning_bank1 = 1
			ENDIF
			
			IF player_had_gun_warning_bank1 = 1
				
				IF HAS_MISSION_AUDIO_LOADED 1
					player_had_gun_warning_bank1 = 2
				ENDIF
				
			ENDIF
			
			IF player_had_gun_warning_bank1 = 2
				PLAY_MISSION_AUDIO 1
				PRINT_NOW ( BJM1_20 ) 5000 1 //"Put the weapon away or face the consequences!"
				player_had_gun_warning_bank1 = 3  
			ENDIF

			IF player_had_gun_warning_bank1 = 3

				IF HAS_MISSION_AUDIO_FINISHED 1
					CLEAR_THIS_PRINT ( BJM1_20 )
					player_had_gun_warning_bank1 = 4
				ENDIF

			ENDIF

			IF player_had_gun_warning_bank1 = 4
				timerb = 0
				player_had_gun_warning_bank1 = 5
			ENDIF	
						
			IF player_had_gun_warning_bank1 = 5 

				IF timerb >= 4000 // Should be 4 secs

					IF flag_player_gun_message_bankjob1 = 0
						LOAD_MISSION_AUDIO 2 ( BJM1_4 )
						flag_player_gun_message_bankjob1 = 1
					ENDIF

				ENDIF

			ENDIF

			IF flag_player_gun_message_bankjob1 = 1

				IF HAS_MISSION_AUDIO_LOADED 2
					flag_player_gun_message_bankjob1 = 2
				ENDIF

			ENDIF

			IF flag_player_gun_message_bankjob1 = 2
				PLAY_MISSION_AUDIO 2
				PRINT_NOW ( BJM1_4 ) 5000 1 //"He's armed, kill him!"
				flag_player_gun_message_bankjob1 = 3
			ENDIF

			IF flag_player_gun_message_bankjob1 = 3

				IF HAS_MISSION_AUDIO_FINISHED 2
					CLEAR_THIS_PRINT ( BJM1_4 )
					flag_player_gun_message_bankjob1 = 4
				ENDIF

			ENDIF

			IF flag_player_gun_message_bankjob1 = 4
				flag_player_armed_bankjob1 = 1
				flag_player_gun_message_bankjob1 = 5
			ENDIF	
													
		ELSE
			flag_player_gun_message_bankjob1 = 0
			player_had_gun_warning_bank1 = 0 
			flag_player_armed_bankjob1 = 0
		ENDIF
	   
	ENDIF

ENDIF

RETURN

// Player in secondary area in station

player_in_station_bankjob1:

IF uniform_pickedup_bankjob1 = 0
	
	IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // Main link corridor in the station

		IF flag_had_area_message_bankjob1 = 0 
			flag_had_area_message_bankjob1 = 1
		ENDIF
			
	ENDIF
	
	IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
	OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard		
	
		IF flag_had_area_message_bankjob1 = 0 
			flag_had_area_message_bankjob1 = 1
		ENDIF

	ENDIF
		 		
	IF flag_had_area_message_bankjob1 = 1
		LOAD_MISSION_AUDIO 2 ( BJM1_5 )
		flag_had_area_message_bankjob1 = 2
	ENDIF

	IF flag_had_area_message_bankjob1 = 2

		IF HAS_MISSION_AUDIO_LOADED 2
			flag_had_area_message_bankjob1 = 3
		ENDIF

	ENDIF

	IF flag_had_area_message_bankjob1 = 3
		PLAY_MISSION_AUDIO 2
		PRINT_NOW ( BJM1_5 ) 5000 1 //"Hey get him, only authorised personnel beyond this point!"
		flag_had_area_message_bankjob1 = 4
	ENDIF

	IF flag_had_area_message_bankjob1 = 4

		IF HAS_MISSION_AUDIO_FINISHED 2
			CLEAR_THIS_PRINT ( BJM1_5 )
			flag_had_area_message_bankjob1 = 5
		ENDIF

	ENDIF

	IF flag_had_area_message_bankjob1 = 5
		flag_player_in_station_bankjob1 = 1
		flag_had_area_message_bankjob1 = 6
	ENDIF	
		
ENDIF

RETURN

// Checks to see if the player1 is firing in the police station

player_shooting_bankjob1:

IF kill_player_flag_bankjob1 = 0

	IF IS_PLAYER_SHOOTING player1


		IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
			kill_player_flag_bankjob1 = 1
		ENDIF
		
		IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
		OR IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard
			kill_player_flag_bankjob1 = 1
		ENDIF
						
	ENDIF
	
ENDIF	 

RETURN

// Checks to see if the player has taken a vehicle into the police station

player_driving_in_station_bankjob1:

IF kill_player_flag_bankjob1 = 0

	IF IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
		kill_player_flag_bankjob1 = 1
	ENDIF
	
	IF IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
	OR IS_PLAYER_IN_ANGLED_AREA_IN_CAR_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard
		kill_player_flag_bankjob1 = 1
	ENDIF		
			
ENDIF	 

RETURN

// FIXMIAMI: START
player_force_wanted_level_bj1:
IF kill_player_flag_bankjob1 = 1
	IF NOT IS_WANTED_LEVEL_GREATER player1 3
		IF IS_PLAYER_IN_ANGLED_AREA_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
			ALTER_WANTED_LEVEL_NO_DROP player1 4
		ENDIF
		
		IF IS_PLAYER_IN_ANGLED_AREA_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard
			ALTER_WANTED_LEVEL_NO_DROP player1 4
		ENDIF
	ENDIF
ENDIF

RETURN

player_entered_wanted_bankjob1:

IF kill_player_flag_bankjob1 = 0

	IF IS_WANTED_LEVEL_GREATER player1 0
		IF IS_PLAYER_IN_ANGLED_AREA_3D player1 393.174 -470.686 10.0 386.992 -478.052 15.0 8.20 FALSE // Entrance
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // over counter
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 397.983 -479.156 10.0 394.546 -483.252 15.0 3.30 FALSE // Corridor to changing room
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 401.651 -480.614 10.0 397.416 -485.66 15.0 9.40 FALSE // Changing room	
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 407.682 -480.576 10.0 405.289 -483.392 15.0 4.80 FALSE //shower room
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 389.12 -478.56 10.34 379.50 -489.40 14.0 4.0 FALSE // link corridor to back of station
			kill_player_flag_bankjob1 = 1
		ENDIF
		
		IF IS_PLAYER_IN_ANGLED_AREA_3D player1 387.811 -486.137 10.0 386.424 -487.79 15.0 4.20 FALSE //Link corridor to charging desk
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 393.073 -495.966 8.0 390.441 -499.103 15.0 2.20 FALSE // Link coridor to cells
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 378.554 -485.414 11.0 377.167 -487.068 15.0 4.20 FALSE // Link corridor to keycard rooms
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 395.032 -484.093 8.0 388.44 -491.948 15.0 11.60 FALSE // Charging desk area
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 396.233 -504.359 7.0 386.533 -496.22 15.0 12.70 FALSE // Police cells
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 368.888 -465.922 11.0 353.713 -484.155 20.0 19.80 FALSE // Upper room with keycard
			kill_player_flag_bankjob1 = 1
		ENDIF
						
	ENDIF
	
ENDIF	 

RETURN

// FIXMIAMI: END

// If the alarm has been raised this will create guys from the stations interior

alarm_guard_creation_bankjob1:

IF player_gone_out_bank1 = 0

	IF total_guards_created_bankjob1 <= 20
	
		IF counter_blokes_alive_bankjob1 < 6
			
			IF flag_created_bloke_in_area_bankjob1 = 2
				timerb = 0
				flag_created_bloke_in_area_bankjob1 = 0
			ENDIF
					 		
			IF NOT IS_AREA_OCCUPIED 380.0 -491.64 8.0 375.62 -493.57 16.0 FALSE TRUE TRUE FALSE FALSE

				IF timerb >= 5000

					IF flag_created_bloke_in_area_bankjob1 = 0

						guard_number_bankjob1 = -1
						
						IF flag_guard1_state_bankjob1 = 0
						OR flag_guard1_state_bankjob1 = 2
							CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE 
							CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard1_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
							guard_number_bankjob1 = created_guard1_bankjob1
							flag_guard1_state_bankjob1 = 1
						ELSE
			
							IF flag_guard2_state_bankjob1 = 0
							OR flag_guard2_state_bankjob1 = 2
								CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE
								CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard2_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
								guard_number_bankjob1 = created_guard2_bankjob1
								flag_guard2_state_bankjob1 = 1
							ELSE

								IF flag_guard3_state_bankjob1 = 0
								OR flag_guard3_state_bankjob1 = 2
									CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE 
									CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard3_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
									guard_number_bankjob1 = created_guard3_bankjob1
									flag_guard3_state_bankjob1 = 1
								ELSE	
				
									IF flag_guard4_state_bankjob1 = 0
									OR flag_guard4_state_bankjob1 = 2
										CLEAR_AREA -379.88 -493.05 11.34 4.0 FALSE 
										CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard4_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
										guard_number_bankjob1 = created_guard4_bankjob1
										flag_guard4_state_bankjob1 = 1
									ELSE

										IF flag_guard5_state_bankjob1 = 0
										OR flag_guard5_state_bankjob1 = 2
											CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE 
											CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard5_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
											guard_number_bankjob1 = created_guard5_bankjob1
											flag_guard5_state_bankjob1 = 1
										ELSE

											IF flag_guard6_state_bankjob1 = 0
											OR flag_guard6_state_bankjob1 = 2
												CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE 
												CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard6_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
												guard_number_bankjob1 = created_guard6_bankjob1
												flag_guard6_state_bankjob1 = 1
											ELSE
												
												IF flag_guard7_state_bankjob1 = 0
												OR flag_guard7_state_bankjob1 = 2
													CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE 
													CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard7_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
													guard_number_bankjob1 = created_guard7_bankjob1
													flag_guard7_state_bankjob1 = 1
												ELSE
													
													IF flag_guard8_state_bankjob1 = 0
													OR flag_guard8_state_bankjob1 = 2
														CLEAR_AREA 379.88 -493.05 11.34 4.0 FALSE 
														CREATE_CHAR PEDTYPE_COP COP 379.88 -493.05 11.34 created_guard8_bankjob1 // FIXMIAMI: was PEDTYPE_CIVMALE
														guard_number_bankjob1 = created_guard8_bankjob1
														flag_guard8_state_bankjob1 = 1
													ENDIF

												ENDIF

											ENDIF

										ENDIF

									ENDIF

								ENDIF

							ENDIF	

						ENDIF
							
						IF NOT IS_CHAR_DEAD guard_number_bankjob1
								
							IF NOT guard_number_bankjob1 = -1	
								SET_CHAR_PERSONALITY guard_number_bankjob1 PEDSTAT_TOUGH_GUY 
								SET_CHAR_HEADING guard_number_bankjob1 180.0
								SET_CHAR_OBJ_RUN_TO_COORD guard_number_bankjob1 381.53 -490.91
								++ counter_blokes_alive_bankjob1
								++ total_guards_created_bankjob1
								flag_created_bloke_in_area_bankjob1 = 1
							ENDIF

						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF
	
RETURN

// Checks to see if the created guards are in the correct area and gives them AI

guard_AI_bankjob1:

IF flag_created_bloke_in_area_bankjob1 = 1

	IF NOT IS_CHAR_DEAD guard_number_bankjob1 

		IF LOCATE_CHAR_ON_FOOT_3D guard_number_bankjob1 381.53 -490.91 11.35 1.0 1.0 2.0 FALSE
			GIVE_WEAPON_TO_CHAR guard_number_bankjob1 WEAPONTYPE_UZI 30000 // Set to infinate ammo
			CHAR_FOLLOW_PATH guard_number_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard_number_bankjob1 player1
			flag_created_bloke_in_area_bankjob1 = 2
		ENDIF

	ELSE
		flag_created_bloke_in_area_bankjob1 = 2	
	ENDIF
	
ENDIF

RETURN

// Guard death checks

alarm_guard_death_check_bankjob1:
	   						
IF flag_guard1_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard1_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard1_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard1_state_bankjob1 = 2
	ELSE

		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard1_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard1_bankjob1 player1
		ENDIF

	ENDIF  
		
ENDIF

IF flag_guard2_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard2_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard2_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard2_state_bankjob1 = 2
	ELSE
		
		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard2_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard2_bankjob1 player1
		ENDIF

	ENDIF
		
ENDIF

IF flag_guard3_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard3_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard3_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard3_state_bankjob1 = 2
	ELSE

		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard3_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard3_bankjob1 player1
		ENDIF

	ENDIF

ENDIF

IF flag_guard4_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard4_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard4_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard4_state_bankjob1 = 2
	ELSE

		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard4_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard4_bankjob1 player1
		ENDIF

	ENDIF
		
ENDIF

IF flag_guard5_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard5_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard5_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard5_state_bankjob1 = 2
	ELSE

		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard5_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard5_bankjob1 player1
		ENDIF

	ENDIF
		
ENDIF

IF flag_guard6_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard6_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard6_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard6_state_bankjob1 = 2
	ELSE

		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard6_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard6_bankjob1 player1
		ENDIF

	ENDIF
		
ENDIF

IF flag_guard7_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard7_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard7_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard7_state_bankjob1 = 2
	ELSE

		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard7_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard7_bankjob1 player1
		ENDIF

	ENDIF
		
ENDIF

IF flag_guard8_state_bankjob1 = 1

	IF IS_CHAR_DEAD created_guard8_bankjob1
		REMOVE_CHAR_ELEGANTLY created_guard8_bankjob1
		-- counter_blokes_alive_bankjob1
		flag_guard8_state_bankjob1 = 2
	ELSE
		
		IF timer_alarm_guards_react_bank1 = 2
			CHAR_FOLLOW_PATH created_guard8_bankjob1 player_x_bankjob1 player_y_bankjob1 player_z_bankjob1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard8_bankjob1 player1
		ENDIF

	ENDIF
		
ENDIF

IF timer_alarm_guards_react_bank1 = 2 
	timer_alarm_guards_react_bank1 = 0
ENDIF
 
RETURN

// player clothes change stuff

change_clothes_bankjob1:

IF uniform_pickedup_bankjob1 = 0 

	REMOVE_SPHERE sphere_bankjob1
	SWITCH_WIDESCREEN ON
	SET_PLAYER_CONTROL player1 OFF
	SET_POLICE_IGNORE_PLAYER player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 ON
	GET_PLAYER_CHAR player1 scplayer
	SET_FIXED_CAMERA_POSITION 399.925 -485.48 14.542 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 400.831 -485.674 14.162 JUMP_CUT
			
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 409.56 -484.36

	timera = 0
			
	WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer 409.56 -484.36 1.0 1.0 FALSE
				
		WAIT 0

		IF cam_died_in_subscript_bankjob1 = 0

			IF IS_CHAR_DEAD safecracker_bankjob1 
				cam_died_in_subscript_bankjob1 = 1
			ENDIF

		ENDIF

		IF timera > 8000

			IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer 409.56 -484.36 1.0 1.0 FALSE
			
				IF NOT IS_CHAR_DEAD scplayer
					SET_CHAR_COORDINATES scplayer 409.56 -484.36 11.35
				ENDIF
				
	 		ENDIF
			
		ENDIF   

	ENDWHILE
		
// Change clothes code
  	
	IF NOT IS_CHAR_DEAD scplayer
		   
    	UNDRESS_CHAR scplayer player6 // player is police uniform
		LOAD_ALL_MODELS_NOW
		
        IF NOT IS_CHAR_DEAD scplayer
			DRESS_CHAR scplayer
		ENDIF
		
	ENDIF
			
	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 407.77 -487.13
	
	timera = 0 
			
	WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer 407.77 -487.13 0.5 0.5 FALSE
				
		WAIT 0

		IF timera > 8000

			IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer 407.77 -487.13 0.5 0.5 FALSE
			
				IF NOT IS_CHAR_DEAD scplayer
					SET_CHAR_COORDINATES scplayer 407.77 -487.13 11.35
				ENDIF
				
			ENDIF
			
		ENDIF    

		IF cam_died_in_subscript_bankjob1 = 0

			IF IS_CHAR_DEAD safecracker_bankjob1 
				cam_died_in_subscript_bankjob1 = 1
			ENDIF

		ENDIF

	ENDWHILE

	SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer 406.16 -487.14
	
	WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer 406.16 -487.14 0.5 0.5 FALSE
	
		WAIT 0

		IF cam_died_in_subscript_bankjob1 = 0

			IF IS_CHAR_DEAD safecracker_bankjob1 
				cam_died_in_subscript_bankjob1 = 1
			ENDIF

		ENDIF

		IF timera > 8000

			IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer 406.16 -487.14 0.5 0.5 FALSE
			
				IF NOT IS_CHAR_DEAD scplayer
					SET_CHAR_COORDINATES scplayer 406.16 -487.14 11.35
				ENDIF
				
			ENDIF
			
		ENDIF
		
	ENDWHILE  
	
	SWITCH_WIDESCREEN OFF
	SET_PLAYER_CONTROL player1 ON
	SET_POLICE_IGNORE_PLAYER player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
	SET_CAMERA_IN_FRONT_OF_PLAYER
	RESTORE_CAMERA_JUMPCUT
	uniform_pickedup_bankjob1 = 1			
		
ENDIF

RETURN

// Checks to see if the player is behind the counter in the station

player_behind_counter_bankjob1:

IF kill_player_flag_bankjob1 = 0

	IF uniform_pickedup_bankjob1 = 0
	   
		IF IS_PLAYER_IN_ANGLED_AREA_ON_FOOT_3D player1 393.174 -470.686 8.0 386.992 -478.052 15.0 8.20 FALSE
			
			IF IS_WANTED_LEVEL_GREATER player1 0
				kill_player_flag_bankjob1 = 1
			ENDIF

		ENDIF

		IF IS_PLAYER_IN_ANGLED_AREA_3D player1 390.82 -471.0 10.0 385.0 -468.27 15.0 10.0 FALSE
			
			IF had_area2_message_bankjob1 = 0
				had_area2_message_bankjob1 = 1
			ENDIF

		ENDIF
			   					 	
		IF had_area2_message_bankjob1 = 1
			LOAD_MISSION_AUDIO 2 ( BJM1_5 )
			had_area2_message_bankjob1 = 2
		ENDIF

		IF had_area2_message_bankjob1 = 2

			IF HAS_MISSION_AUDIO_LOADED 2
				had_area2_message_bankjob1 = 3
			ENDIF

		ENDIF

		IF had_area2_message_bankjob1 = 3
			PLAY_MISSION_AUDIO 2
			PRINT_NOW ( BJM1_5 ) 5000 1 //"Hey get him, only authorised personnel beyond this point!"
			had_area2_message_bankjob1 = 4
		ENDIF

		IF had_area2_message_bankjob1 = 4

			IF HAS_MISSION_AUDIO_FINISHED 2
				CLEAR_THIS_PRINT ( BJM1_5 )
				kill_player_flag_bankjob1 = 1
				had_area2_message_bankjob1 = 5
			ENDIF

		ENDIF
		
	ENDIF

ENDIF

RETURN

// Cleansup any guards that are left

mini_cleanup_bank1:

MARK_CHAR_AS_NO_LONGER_NEEDED cop1_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop2_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop3_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop4_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop5_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop6_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop7_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop8_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop9_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop10_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED cop11_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard1_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard2_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard3_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard4_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard5_bankjob1 
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard6_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard7_bankjob1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard8_bankjob1
player_gone_out_bank1 = 2

RETURN

}


 