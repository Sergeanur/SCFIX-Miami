MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ******************************* Counterfeiting Mission 1 ********************************
// ********************************* Get The Information ***********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
 
SCRIPT_NAME count1

// Mission start stuff

GOSUB mission_start_counter1

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_counter1_failed
ENDIF

GOSUB mission_cleanup_counter1

MISSION_END


// Variables for mission

// target area

VAR_INT radar_blip_target_count1 // target to beat for information

VAR_INT flag_player_got_info_count1

// guard1

VAR_INT flag_guard1_shouted_count1

VAR_INT guard1_count1

VAR_INT flag_guard1_dead_count1

VAR_INT guard1_alarm_run_count1 // If antoher guards spots the player guard1 goes for the alarm

VAR_INT guard1_in_alert_position_count1  // Tells me the guard is waiting for the player1

VAR_INT flag_guard1_go_for_alert_count1  // Tells the guard to start moving to his alert position

VAR_INT flag_guard1_kill_player_count1 // used to tell the guard to kill the player if the alarm is triggered

// Guard2

VAR_INT guard2_count1

VAR_INT guard2_in_alert_state_count1

VAR_INT flag_guard2_dead_count1

VAR_INT flag_guard2_shouted_count1

// Guard3

VAR_INT guard3_count1

VAR_INT guard3_in_alert_state_count1

VAR_INT flag_guard3_dead_count1

VAR_INT flag_guard3_shouted_count1

// Guard4

VAR_INT guard4_count1

VAR_INT guard4_in_alert_state_count1

VAR_INT flag_guard4_dead_count1

VAR_INT flag_guard4_shouted_count1

// Guard5

VAR_INT guard5_count1

VAR_INT guard5_in_alert_state_count1

VAR_INT flag_guard5_dead_count1

VAR_INT flag_guard5_shouted_count1

// Guard6

VAR_INT guard6_count1

VAR_INT guard6_in_alert_state_count1

VAR_INT flag_guard6_dead_count1

VAR_INT flag_guard6_shouted_count1

// Guard7

VAR_INT guard7_count1

VAR_INT guard7_in_alert_state_count1

VAR_INT flag_guard7_dead_count1

VAR_INT flag_guard7_shouted_count1

// Guard8

VAR_INT guard8_count1

VAR_INT guard8_in_alert_state_count1

VAR_INT flag_guard8_dead_count1

VAR_INT flag_guard8_shouted_count1

// guard9

VAR_INT guard9_count1

VAR_INT guard9_in_alert_state_count1

VAR_INT flag_guard9_dead_count1

VAR_INT flag_guard9_shouted_count1

// guard10

VAR_INT guard10_count1

VAR_INT guard10_in_alert_state_count1

VAR_INT flag_guard10_dead_count1

VAR_INT flag_guard10_shouted_count1

// Guard 11

VAR_INT guard11_count1

VAR_INT flag_guard11_dead_count1

VAR_INT flag_guard11_shouted_count1

// General stuff

VAR_INT alarm_raised_count1

VAR_INT alarm_count1  // Boat alarm if this is set off then more guards are created and all exsisting guards go for the player1

VAR_INT flag_player_been_on_boat_count1 // tells the guards to start looking for the player1

VAR_FLOAT player_x_count1  // Player location

VAR_FLOAT player_y_count1  // Player location

VAR_FLOAT player_z_count1 // Player location

VAR_INT flag_all_guards_react_count1  // If anything has happened on the boat sets the guards to react

VAR_INT timer_shooting_started_count1 // Used to tell me how a guard died, if it was a loud weapon starts a counter if it reaches 30 seconds alarms are triggered. 

// Club Stuff
VAR_INT radar_blip_malibu_count1

// Guard alarm creation ( If alarm raised this will create some extra guards to get the player )

VAR_INT total_guards_created_count1

VAR_INT counter_blokes_alive_count1

VAR_INT flag_created_bloke_in_area_count1

VAR_INT guard_number_count1

// created guard1

VAR_INT created_guard1_count1

VAR_INT flag_guard1_state_count1

// created guard2

VAR_INT created_guard2_count1

VAR_INT flag_guard2_state_count1

// created guard3

VAR_INT created_guard3_count1

VAR_INT flag_guard3_state_count1

// created guard4

VAR_INT created_guard4_count1

VAR_INT flag_guard4_state_count1

// created guard5

VAR_INT created_guard5_count1

VAR_INT flag_guard5_state_count1

// created guard6

VAR_INT created_guard6_count1

VAR_INT flag_guard6_state_count1

// created guard7

VAR_INT created_guard7_count1

VAR_INT flag_guard7_state_count1

// created guard8

VAR_INT created_guard8_count1

VAR_INT flag_guard8_state_count1
						 
// Starts the timers for the guard creation stuff

VAR_INT flag_timer_started_count1

// General Stuff

VAR_INT flag_had_mini_cut_count1  // Tells me if they have had the cutscene with the player walking into the cabin or not

VAR_INT flag_had_escape_message_count1

VAR_INT sphere_count1  // Used to mark loaction of mini cutscene entrance

VAR_INT radar_blip_escape_count1 //	area player has to get to

// Timer stuff

VAR_INT game_time_count1

VAR_INT timer_started_count1

VAR_INT time_to_act_count1

VAR_INT timer_guards_react_count1

VAR_INT timer_alarm_guards_react_count1

VAR_INT time_to_act_alarm_count1

VAR_INT timer_started_alarm_count1

// Frame counter stuff

VAR_INT frame_counter_count1

// Car stuff for mini-cut at end

VAR_INT car_count1

VAR_INT car2_count1

// Extra quick guard creation if player has got info

VAR_INT number_to_act_at_count1

VAR_INT done_mini_cleanup_count1

// ****************************************Mission Start************************************

mission_start_counter1:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

flag_player_on_counter_1 = 1

// target bloke

flag_player_got_info_count1 = 0

// Guard1

flag_guard1_dead_count1 = 0

flag_guard1_shouted_count1 = 0

guard1_in_alert_position_count1 = 0

flag_guard1_go_for_alert_count1 = 0

flag_guard1_kill_player_count1 = 0

guard1_alarm_run_count1 = 0

// Guard2

flag_guard2_dead_count1 = 0

guard2_in_alert_state_count1 = 0

flag_guard2_shouted_count1 = 0
		  
// Guard3

flag_guard3_dead_count1 = 0

guard3_in_alert_state_count1 = 0

flag_guard3_shouted_count1 = 0

// Guard4

flag_guard4_dead_count1 = 0

guard4_in_alert_state_count1 = 0

flag_guard4_shouted_count1 = 0

// Guard5

flag_guard5_dead_count1 = 0

guard5_in_alert_state_count1 = 0

flag_guard5_shouted_count1 = 0

// Guard6

flag_guard6_dead_count1 = 0

guard6_in_alert_state_count1 = 0

flag_guard6_shouted_count1 = 0
	  
// Guard7

flag_guard7_dead_count1 = 0

guard7_in_alert_state_count1 = 0

flag_guard7_shouted_count1 = 0 
	  
// Guard8

flag_guard8_dead_count1 = 0

guard8_in_alert_state_count1 = 0

flag_guard8_shouted_count1 = 0

// Guard9

flag_guard9_dead_count1 = 0

guard9_in_alert_state_count1 = 0

flag_guard9_shouted_count1 = 0

// Guard10

flag_guard10_dead_count1 = 0

guard10_in_alert_state_count1 = 0

flag_guard10_shouted_count1 = 0

// Guard11

flag_guard11_dead_count1 = 0

flag_guard11_shouted_count1 = 0


// General Stuff

alarm_raised_count1 = 0

flag_all_guards_react_count1 = 0

flag_player_been_on_boat_count1 = 0

player_x_count1 = 0.0

player_y_count1 = 0.0

player_z_count1 = 0.0

// Guard alarm creation ( If alarm raised this will create some extra guards to get the player )

total_guards_created_count1 = 0

counter_blokes_alive_count1 = 0

flag_created_bloke_in_area_count1 = 0

flag_guard1_state_count1 = 0

flag_guard2_state_count1 = 0

flag_guard3_state_count1 = 0

flag_guard4_state_count1 = 0

flag_guard5_state_count1 = 0

flag_guard6_state_count1 = 0

flag_guard7_state_count1 = 0

flag_guard8_state_count1 = 0

flag_timer_started_count1 = 0

// General Stuff

flag_had_mini_cut_count1 = 0

flag_had_escape_message_count1 = 0

// Timer stuff

game_time_count1 = 0

timer_started_count1 = 0

time_to_act_count1 = 0

timer_guards_react_count1 = 0

timer_alarm_guards_react_count1 = 0

time_to_act_alarm_count1 = 0

timer_started_alarm_count1 = 0

// frame counter stuff

frame_counter_count1 = 0

// Extra quick guard creation if player has got info

number_to_act_at_count1 = 0

done_mini_cleanup_count1 = 0

timer_shooting_started_count1 = 0

WAIT 0

LOAD_MISSION_TEXT COUNT1

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1045.726 -292.454 9.758 97.607  // On road outside of Print Works

{

// **************************************** Cut Scene **************************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSkelly

SET_AREA_VISIBLE VIS_PRINT_WORKS

LOAD_SCENE -1070.05 -280.06 11.09

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2

	WAIT 0

ENDWHILE

LOAD_CUTSCENE cnt_1a

SET_CUTSCENE_OFFSET -1064.103 -276.39 11.066

SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kelly
SET_CUTSCENE_ANIM cs_kelly CSkelly

CLEAR_AREA -1059.8411 -278.7214 10.4044 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1059.8411 -278.7214 10.4044
SET_PLAYER_HEADING player1 272.2088 

// SET_AREA_VISIBLE VIS_MAIN_MAP

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 11104
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_A ) 10000 1 //"Mr. Vercetti? Hey. You bought the old print works?"

WHILE cs_time < 15668 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_B ) 10000 1 //"Yeah, my old man used to work on these."

WHILE cs_time < 18152
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_N ) 10000 1 //"I used to spend the evenings with him, cleaning the rollers... "

WHILE cs_time < 21286 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_C ) 10000 1 //"I was going to follow him in his trade, but..I lived a different life"

WHILE cs_time < 25141 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_D ) 10000 1 //"You planning on selling the old machinery, breaking it down?"

WHILE cs_time < 28808 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_E ) 10000 1 //"I'm thinking we might print something, A newspaper, magazine..."

WHILE cs_time < 31680 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_F ) 10000 1 //"Oh, crap, sonny, low grade crap. I've always fancied printing money. It ain't too hard. "

WHILE cs_time < 37694 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_G ) 10000 1 //"You know I've been doing it on a small scale for years. "

WHILE cs_time < 40520 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_H ) 10000 1 //"Really?"

WHILE cs_time < 41862 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_I ) 10000 1 //"Sure. But we'd need some good quality plates."

WHILE cs_time <  46771
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_J ) 10000 1 //"Of course! there's a counterfeiting syndicate already operating in Florida. "

WHILE cs_time < 51081 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_K ) 10000 1 //"A syndicate?"

WHILE cs_time < 51973 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_L ) 10000 1 //"Yeah. Just rumours is all I've heard."

WHILE cs_time < 54422 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_M ) 10000 1 //"I know a man who's good with rumours..."

WHILE cs_time < 56704
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 57968
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_AREA_VISIBLE VIS_MAIN_MAP

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

LOAD_SCENE -1059.8411 -278.7214 10.4044

// *************************************** END OF CUT SCENE ********************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

SET_UP_TAXI_SHORTCUT -1047.664 -298.188 11.0 266.280 512.591 -74.900 9.573 189.24 // used to warp player from print works to Malibu

IF flag_had_taxi_jump_help = 0
	//SWITCH_WIDESCREEN ON
	SET_PLAYER_CONTROL player1 OFF
	SET_POLICE_IGNORE_PLAYER player1 ON
	SET_EVERYONE_IGNORE_PLAYER player1 ON
ENDIF

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

// Waiting for the ped models to load

REQUEST_MODEL GDa

REQUEST_MODEL GDb

REQUEST_MODEL mp5lng

REQUEST_MODEL M4

LOAD_MISSION_AUDIO 2 ( CNT1_1 ) //Who are you? Oooof! Aaiieee! Not the face! Not the face!"

WHILE NOT HAS_MODEL_LOADED GDa
OR NOT HAS_MODEL_LOADED GDb
OR NOT HAS_MODEL_LOADED mp5lng
OR NOT HAS_MODEL_LOADED M4
OR NOT HAS_MISSION_AUDIO_LOADED 2

	WAIT 0
      
ENDWHILE

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

IF flag_had_taxi_jump_help = 0

	WAIT 100

	CLEAR_AREA -1042.921 -304.553 12.463 1.0 FALSE 
	SET_FIXED_CAMERA_POSITION -1042.921 -304.553 12.463 0.0 0.0 0.0 
	POINT_CAMERA_AT_POINT -1043.434 -303.718 12.266 JUMP_CUT

	PRINT_NOW ( TAXSHRT ) 10000 1 //"You can use this taxi..."

	timera = 0

	WHILE timera < 6000

		WAIT 0

	ENDWHILE

	CLEAR_THIS_PRINT ( TAXSHRT )

	SWITCH_WIDESCREEN OFF
	SET_PLAYER_CONTROL player1 ON
	SET_POLICE_IGNORE_PLAYER player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
	SET_CAMERA_BEHIND_PLAYER
	RESTORE_CAMERA_JUMPCUT
	flag_had_taxi_jump_help = 1
ENDIF 

PRINT_NOW ( CM1_5 ) 5000 1 //"Go and meet Kent Paul at the Malibu Club!"

ADD_BLIP_FOR_COORD 491.0 -77.7 10.4 radar_blip_malibu_count1

DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_open 490.34 -77.017 11.598 malibu_doors
SET_OBJECT_AREA_VISIBLE malibu_doors VIS_MAIN_MAP // SCFIX
flag_malibu_doors_open = 1
flag_malibu_doors_closed = 0

WHILE NOT LOCATE_PLAYER_ANY_MEANS_3D player1 491.0 -77.7 10.4 3.0 3.0 3.0 TRUE

	WAIT 0
			
ENDWHILE

SET_PLAYER_CONTROL player1 OFF

REMOVE_BLIP radar_blip_malibu_count1

SET_FADING_COLOUR 0 0 0

DO_FADE 1500 FADE_OUT

WHILE GET_FADING_STATUS

	WAIT 0

ENDWHILE

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION player1
AND breakout_diff < 5000  // if player is not in control after 5 secs do the cutscene anyway

	WAIT 0
	
    GET_GAME_TIMER breakout_timer                                                                                

    breakout_diff = breakout_timer - breakout_timer_start

ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player1

SWITCH_RUBBISH OFF

SWITCH_STREAMING OFF

// **************************************** CUT SCENE TWO **********************************

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSkent
LOAD_SPECIAL_CHARACTER 3 floozya

SET_AREA_VISIBLE VIS_MALIBU_CLUB

LOAD_SCENE 470.495 -57.014 10.04

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3

	WAIT 0

ENDWHILE

SET_EXTRA_COLOURS 1 FALSE

LOAD_CUTSCENE cnt_1b

SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kent
SET_CUTSCENE_ANIM cs_kent CSkent

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_floozya
SET_CUTSCENE_ANIM cs_floozya floozya

CLEAR_AREA 493.1 -82.4 9.8 1.0 TRUE

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_CHAR_IS_IN scplayer car2_count1

	IF NOT IS_CAR_DEAD car2_count1 
		SET_CAR_COORDINATES car2_count1 496.3 -82.8 9.0 
		SET_CAR_HEADING car2_count1 116.6
	ENDIF

    WARP_CHAR_FROM_CAR_TO_COORD scplayer 493.1 -82.4 9.8
	SET_PLAYER_HEADING player1 220.0
ELSE
	SET_PLAYER_COORDINATES player1 493.1 -82.4 9.8
	SET_PLAYER_HEADING player1 220.0
ENDIF

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 7872 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2A ) 10000 1 //"Look at the arse on that.

WHILE cs_time < 12284 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2B ) 10000 1 //"Awright girl, it's your loss mate init!"

WHILE cs_time < 14399 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2C ) 10000 1 //"Awright me ol'china, how's it hangin?"

WHILE cs_time < 17102 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2D ) 10000 1 //"What do you know about counterfeiting?"

WHILE cs_time < 18528 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2E ) 10000 1 //"Oh I'm fine Paul, how 'bout you?"

WHILE cs_time < 20285 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2F ) 10000 1 //"Come 'ere!"

WHILE cs_time < 21336 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2G ) 10000 1 //"Awright! Awright! Awright!! You're obviously a busy man."

WHILE cs_time < 24945 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2H ) 10000 1 //"All I know about dodgy readys is the Triads supply the plates."

WHILE cs_time < 31191 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2I ) 10000 1 //"They've got a shipping company down the docks,"

WHILE cs_time < 33488
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2J ) 10000 1 //"the boss man would know when the plates are coming in next!"

WHILE cs_time < 37791 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2K ) 10000 1 //"Thanks PAul."

WHILE cs_time < 40783 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2L ) 10000 1 //"What's the matter wiht you, you maniac!

WHILE cs_time < 43496 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( CM1_2M ) 10000 1 //"Give me another drink, lively!"

WHILE cs_time < 45120 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 47160 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

// SCFIX: START - move post fade
DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_close 490.34 -77.017 11.598 malibu_doors
SET_OBJECT_AREA_VISIBLE malibu_doors VIS_MAIN_MAP // SCFIX
DONT_REMOVE_OBJECT malibu_doors
flag_malibu_doors_closed = 1
flag_malibu_doors_open = 0
flag_player_on_counter_1 = 0
flag_player_in_malibu = 0
// SCFIX: END

PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"

SET_AREA_VISIBLE VIS_MAIN_MAP

CLEAR_EXTRA_COLOURS FALSE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3

LOAD_SCENE 493.1 -82.4 9.8

// ************************************* END OF CUTSCENE TWO *******************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000 

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

PRINT_NOW ( CM1_1 ) 5000 1 //"Get to the Charted Libertine Lines boat at the docks!"

PRINT ( CM1_2 ) 5000 1 //"The Shipping officer will have the required information!"

// Waiting for the ship collision to be loaded

ADD_BLIP_FOR_COORD -686.85 -1245.43 30.14 radar_blip_target_count1

ADD_SPHERE -686.85 -1245.43 30.14 1.5 sphere_count1

ground_z = 0.0000 

WHILE ground_z < 10.0

	WAIT 0

 	GET_GROUND_Z_FOR_3D_COORD -686.85 -1245.43 30.14 ground_z

ENDWHILE

// creates guard1 patrols on left hand side of boat along by the gang planks 

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -662.12 -1326.81 15.26 guard1_count1

++ counter_blokes_alive_count1

CLEAR_CHAR_THREAT_SEARCH guard1_count1

GIVE_WEAPON_TO_CHAR guard1_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard1_count1 THREAT_PLAYER1

ADD_ROUTE_POINT 0 -666.06 -1318.48 15.26

ADD_ROUTE_POINT 0 -673.80 -1302.02 15.26

ADD_ROUTE_POINT 0 -683.28 -1282.11 15.26

ADD_ROUTE_POINT 0 -693.41 -1258.63 15.24

ADD_ROUTE_POINT 0 -699.76 -1245.01 15.26

ADD_ROUTE_POINT 0 -693.41 -1258.63 15.24 

ADD_ROUTE_POINT 0 -683.28 -1282.11 15.26

ADD_ROUTE_POINT 0 -673.80 -1302.02 15.26

ADD_ROUTE_POINT 0 -666.06 -1318.48 15.26

ADD_ROUTE_POINT 0 -662.12 -1326.81 15.26

SET_CHAR_OBJ_FOLLOW_ROUTE guard1_count1 0 FOLLOW_ROUTE_LOOP

// creates guard2 in left hand side of boat beside gang plank player uses. Follows route 1

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb -659.26 -1330.93 15.26 guard2_count1

++ counter_blokes_alive_count1

CLEAR_CHAR_THREAT_SEARCH guard2_count1

GIVE_WEAPON_TO_CHAR guard2_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard2_count1 THREAT_PLAYER1

ADD_ROUTE_POINT 1 -653.93 -1342.18 15.26

ADD_ROUTE_POINT 1 -647.19 -1355.40 15.27

ADD_ROUTE_POINT 1 -632.47 -1382.57 15.29

ADD_ROUTE_POINT 1 -647.19 -1355.40 15.27

ADD_ROUTE_POINT 1 -653.93 -1342.18 15.26

ADD_ROUTE_POINT 1 -659.26 -1330.93 15.26

SET_CHAR_OBJ_FOLLOW_ROUTE guard2_count1 1 FOLLOW_ROUTE_LOOP

// creates guard3 in rigt hand side of boat follows path 2

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -609.85 -1381.29 15.25 guard3_count1

++ counter_blokes_alive_count1

CLEAR_CHAR_THREAT_SEARCH guard3_count1

GIVE_WEAPON_TO_CHAR guard3_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard3_count1 THREAT_PLAYER1

ADD_ROUTE_POINT 2 -615.43 -1367.41 15.28

ADD_ROUTE_POINT 2 -620.06 -1355.03 15.28

ADD_ROUTE_POINT 2 -635.64 -1363.45 15.28

ADD_ROUTE_POINT 2 -620.06 -1355.03 15.28

ADD_ROUTE_POINT 2 -615.43 -1367.41 15.28

ADD_ROUTE_POINT 2 -609.85 -1381.29 15.25

SET_CHAR_OBJ_FOLLOW_ROUTE guard3_count1 2 FOLLOW_ROUTE_LOOP 

// Guard4 patrols right hand side of the boat near the middle section follows path 3

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb -627.04 -1339.79 15.27 guard4_count1

++ counter_blokes_alive_count1

CLEAR_CHAR_THREAT_SEARCH guard4_count1

GIVE_WEAPON_TO_CHAR guard4_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard4_count1 THREAT_PLAYER1

ADD_ROUTE_POINT 3 -630.43 -1333.91 15.27

ADD_ROUTE_POINT 3 -634.26 -1322.39 15.27 

ADD_ROUTE_POINT 3 -639.33 -1307.99 15.26 

ADD_ROUTE_POINT 3 -642.71 -1303.60 15.26 

ADD_ROUTE_POINT 3 -639.33 -1307.99 15.26

ADD_ROUTE_POINT 3 -634.26 -1322.39 15.27

ADD_ROUTE_POINT 3 -630.43 -1333.91 15.27

ADD_ROUTE_POINT 3 -627.04 -1339.79 15.27

SET_CHAR_OBJ_FOLLOW_ROUTE guard4_count1 3 FOLLOW_ROUTE_LOOP

// Guard5 on rigt hand side of boat closest to the main cabin bit follows route 4

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -653.46 -1279.55 15.26 guard5_count1

++ counter_blokes_alive_count1

CLEAR_CHAR_THREAT_SEARCH guard5_count1

GIVE_WEAPON_TO_CHAR guard5_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard5_count1 THREAT_PLAYER1

ADD_ROUTE_POINT 4 -656.61 -1271.76 15.26 

ADD_ROUTE_POINT 4 -660.34 -1262.76 15.26  

ADD_ROUTE_POINT 4 -664.83 -1254.11 15.26 

ADD_ROUTE_POINT 4 -660.34 -1262.76 15.26 

ADD_ROUTE_POINT 4 -656.61 -1271.76 15.26 

ADD_ROUTE_POINT 4 -653.46 -1279.55 15.26

SET_CHAR_OBJ_FOLLOW_ROUTE guard5_count1 4 FOLLOW_ROUTE_LOOP

// Guard6 side pod left hand side

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb -691.13 -1260.50 31.93 guard6_count1

++ counter_blokes_alive_count1

SET_CHAR_HEADING guard6_count1 180.0

CLEAR_CHAR_THREAT_SEARCH guard6_count1

GIVE_WEAPON_TO_CHAR guard6_count1 WEAPONTYPE_M4 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard6_count1 THREAT_PLAYER1

SET_CHAR_STAY_IN_SAME_PLACE guard6_count1 TRUE

// Guard7 side pod right hand side

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -667.68 -1249.14 31.93 guard7_count1

++ counter_blokes_alive_count1

SET_CHAR_HEADING guard7_count1 180.0

CLEAR_CHAR_THREAT_SEARCH guard7_count1

GIVE_WEAPON_TO_CHAR guard7_count1 WEAPONTYPE_M4 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard7_count1 THREAT_PLAYER1

SET_CHAR_STAY_IN_SAME_PLACE guard7_count1 TRUE

// Guard8 patrols back of boat on ground follows path 5

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb -690.94 -1218.18 15.28 guard8_count1

++ counter_blokes_alive_count1

CLEAR_CHAR_THREAT_SEARCH guard8_count1

GIVE_WEAPON_TO_CHAR guard8_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard8_count1 THREAT_PLAYER1

ADD_ROUTE_POINT 5 -698.00 -1221.23 15.28 

ADD_ROUTE_POINT 5 -690.94 -1218.18 15.28 

SET_CHAR_OBJ_FOLLOW_ROUTE guard8_count1 5 FOLLOW_ROUTE_LOOP


// Guard9 3rd deck up stands guard does not run

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb -690.69 -1229.06 22.46 guard9_count1

++ counter_blokes_alive_count1

SET_CHAR_HEADING guard9_count1 33.0

CLEAR_CHAR_THREAT_SEARCH guard9_count1

GIVE_WEAPON_TO_CHAR guard9_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard9_count1 THREAT_PLAYER1

SET_CHAR_STAY_IN_SAME_PLACE guard9_count1 TRUE

// Guard10 2nd floor of the boat left hand side by the steps

CREATE_CHAR PEDTYPE_GANG_SECURITY GDb -689.14 -1242.03 30.14 guard10_count1

++ counter_blokes_alive_count1

SET_CHAR_HEADING guard10_count1 100.0

CLEAR_CHAR_THREAT_SEARCH guard10_count1

GIVE_WEAPON_TO_CHAR guard10_count1 WEAPONTYPE_MP5 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard10_count1 THREAT_PLAYER1

SET_CHAR_STAY_IN_SAME_PLACE guard10_count1 TRUE

// Guard11

CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -670.709 -1296.564 18.940 guard11_count1

++ counter_blokes_alive_count1

SET_CHAR_HEADING guard11_count1 146.102

CLEAR_CHAR_THREAT_SEARCH guard11_count1

GIVE_WEAPON_TO_CHAR guard11_count1 WEAPONTYPE_M4 30000 // sets it to infinate ammo

SET_CHAR_THREAT_SEARCH guard11_count1 THREAT_PLAYER1

SET_CHAR_STAY_IN_SAME_PLACE guard11_count1 TRUE
 
// waiting for the player1 to get the information

WHILE flag_had_escape_message_count1 < 2

	WAIT 0

	++ frame_counter_count1
	IF frame_counter_count1 > 17
		frame_counter_count1 = 0
	ENDIF

	IF flag_had_escape_message_count1 >= 1

		IF NOT IS_PLAYER_IN_ANGLED_AREA_3D player1 -716.95 -1218.89 2.0 -697.73 -1266.50 50.0 60.0 FALSE
		AND NOT IS_PLAYER_IN_ANGLED_AREA_3D player1 -697.73 -1266.50 2.0 -616.29 -1430.59 50.0 60.0 FALSE
		
			IF done_mini_cleanup_count1 = 0
				GOSUB mini_cleanup_count1
			ENDIF
		
		ENDIF
		
	ENDIF 

	GET_GAME_TIMER game_time_count1
	
	IF flag_had_escape_message_count1 = 1

		IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -716.95 -1218.89 2.0 -697.73 -1266.50 50.0 60.0 FALSE
		OR IS_PLAYER_IN_ANGLED_AREA_3D player1 -697.73 -1266.50 2.0 -616.29 -1430.59 50.0 60.0 FALSE
			flag_had_escape_message_count1 = 1
		ELSE
			flag_had_escape_message_count1 = 2
		ENDIF
		
	ENDIF	
	

	GET_PLAYER_COORDINATES player1 player_x_count1 player_y_count1 player_z_count1
		
	IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -716.95 -1218.89 2.0 -697.73 -1266.50 50.0 60.0 FALSE
	OR IS_PLAYER_IN_ANGLED_AREA_3D player1 -697.73 -1266.50 2.0 -616.29 -1430.59 50.0 60.0 FALSE
   		flag_player_been_on_boat_count1 = 1
   	ENDIF
	
	IF flag_player_got_info_count1 = 0

	   //	IF LOCATE_STOPPED_PLAYER_ON_FOOT_2D player1 -686.85 -1245.43 0.5 0.5 FALSE
		IF LOCATE_PLAYER_ON_FOOT_2D player1 -686.85 -1245.43 0.5 0.5 FALSE
			REMOVE_SPHERE sphere_count1
			REMOVE_BLIP radar_blip_target_count1
			flag_player_got_info_count1 = 1
		ENDIF
		
	ENDIF
   	
   	IF flag_player_got_info_count1 = 1

		IF flag_had_mini_cut_count1 = 0
			GOSUB mini_cut_count1	
		ELSE
			IF flag_had_escape_message_count1 = 0
				PRINT_NOW ( CM1_6 ) 5000 1 //"Escape from the boat to safety!"
				ALTER_WANTED_LEVEL_NO_DROP player1 2
				ADD_BLIP_FOR_COORD -1052.579 -282.013 10.279 radar_blip_escape_count1
				
				IF alarm_raised_count1 = 0 
					ADD_CONTINUOUS_SOUND -692.33 -1258.94 15.25 SOUND_BANK_ALARM_LOOP alarm_count1
					flag_all_guards_react_count1 = 1
					alarm_raised_count1 = 1	
				ENDIF

				flag_had_escape_message_count1 = 1
									
			ENDIF

		ENDIF
			
	ENDIF
	
	GOSUB guard_checks_count1
		
	IF timer_shooting_started_count1 = 1
		timera = 0
		timer_shooting_started_count1 = 2
	ENDIF

	IF timer_shooting_started_count1 = 2

		IF timera >= 30000

			IF alarm_raised_count1 = 0 
				ADD_CONTINUOUS_SOUND -692.33 -1258.94 15.25 SOUND_BANK_ALARM_LOOP alarm_count1
				flag_all_guards_react_count1 = 1
				alarm_raised_count1 = 1	
			ENDIF

		ENDIF

	ENDIF
	
// Extra guard creation stuff
		
   	IF alarm_raised_count1 = 1
				
   		IF flag_timer_started_count1 = 0
   			timerb = 0
   			flag_timer_started_count1 = 1
   		ENDIF
		 
   		GOSUB alarm_guard_creation_count1
  		GOSUB guard_AI_count1
		GOSUB alarm_guard_death_check_count1

   	ENDIF

ENDWHILE

blob_flag = 1

WHILE NOT LOCATE_STOPPED_PLAYER_ANY_MEANS_3D player1 -1052.579 -282.013 10.279 3.0 3.0 3.0 blob_flag

	WAIT 0
		
ENDWHILE

REMOVE_BLIP radar_blip_escape_count1

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

CLEAR_AREA -1063.095 -286.610 14.163 1.0 FALSE
SET_FIXED_CAMERA_POSITION -1063.095 -286.610 14.163 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1062.265 -286.498 13.616 JUMP_CUT

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN player1 car_count1
	SET_CHAR_OBJ_LEAVE_CAR scplayer car_count1
	
	WHILE IS_PLAYER_IN_CAR player1 car_count1
	
		WAIT 0

		IF IS_CAR_DEAD car_count1
			GOTO mission_counter1_failed
		ENDIF
		
	ENDWHILE
	
ENDIF 
 
SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -1061.465 -287.322

timera = 0
timerb = 0

WHILE timera < 4000

	WAIT 0

ENDWHILE

RESTORE_CAMERA_JUMPCUT
CHAR_SET_IDLE scplayer
SET_PLAYER_COORDINATES player1 -1059.214 -285.815 10.22
SET_PLAYER_HEADING player1 289.0
SET_CAMERA_IN_FRONT_OF_PLAYER
SWITCH_WIDESCREEN OFF

WAIT 300

SET_PLAYER_CONTROL player1 ON
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF

GOTO mission_counter1_passed


// ****************************************** Mission Failed *******************************

mission_counter1_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


   

// *************************************** Mission Passed **********************************

mission_counter1_passed:

flag_counter_mission1_passed = 1
REGISTER_MISSION_PASSED ( CNT_1 )
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
ADD_SCORE player1 2000
START_NEW_SCRIPT counter_mission2_loop
RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_counter1:

flag_player_on_mission = 0

REMOVE_ROUTE 0
REMOVE_ROUTE 1
REMOVE_ROUTE 2
REMOVE_ROUTE 3
REMOVE_ROUTE 4
REMOVE_ROUTE 5

DELETE_OBJECT malibu_doors 
CREATE_OBJECT_NO_OFFSET od_clbdr_close 490.34 -77.017 11.598 malibu_doors
SET_OBJECT_AREA_VISIBLE malibu_doors VIS_MAIN_MAP // SCFIX
DONT_REMOVE_OBJECT malibu_doors 
flag_malibu_doors_closed = 1
flag_malibu_doors_open = 0
flag_player_on_counter_1 = 0
flag_player_in_malibu = 0

CLEAR_TAXI_SHORTCUT 
MARK_MODEL_AS_NO_LONGER_NEEDED GDa
MARK_MODEL_AS_NO_LONGER_NEEDED GDb
MARK_MODEL_AS_NO_LONGER_NEEDED mp5lng
MARK_MODEL_AS_NO_LONGER_NEEDED M4
REMOVE_BLIP radar_blip_escape_count1
REMOVE_SPHERE sphere_count1
REMOVE_SOUND alarm_count1 
REMOVE_BLIP radar_blip_target_count1
REMOVE_BLIP radar_blip_malibu_count1
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
		

guard_checks_count1:

// guard1

IF frame_counter_count1 = 0

	IF flag_guard1_dead_count1 = 0

		IF IS_CHAR_DEAD guard1_count1
			-- counter_blokes_alive_count1
	 		
			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
							
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
				
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF
				
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard1_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF	 
											
			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard1_count1
			flag_guard1_dead_count1 = 1
				
	 	ELSE

		   //	GET_CHAR_HEALTH guard1_count1 guard1_health_count1
						
			IF flag_player_been_on_boat_count1 = 1

				IF HAS_CHAR_SPOTTED_PLAYER guard1_count1 player1
				OR CAN_CHAR_SEE_DEAD_CHAR guard1_count1 PEDTYPE_GANG_SECURITY
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
							
					IF alarm_raised_count1 = 0
						
						IF flag_guard1_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							flag_all_guards_react_count1 = 1
							flag_guard1_shouted_count1 = 1
						ENDIF

						IF guard1_in_alert_position_count1 = 0
						OR guard1_alarm_run_count1 = 1

							IF flag_guard1_go_for_alert_count1 = 0
								CHAR_FOLLOW_PATH guard1_count1 -697.39 -1250.62 15.24 0.5 RUN
								flag_guard1_go_for_alert_count1 = 1
							ENDIF
								
							IF flag_guard1_go_for_alert_count1 = 1 
						
								IF LOCATE_CHAR_ON_FOOT_2D guard1_count1 -697.39 -1250.62 1.0 1.0 FALSE

									IF alarm_raised_count1 = 0
										ADD_CONTINUOUS_SOUND -692.33 -1258.94 15.25 SOUND_BANK_ALARM_LOOP alarm_count1
										alarm_raised_count1 = 1
									ENDIF

									CHAR_FOLLOW_PATH guard1_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
									SET_CHAR_THREAT_SEARCH guard1_count1 THREAT_PLAYER1
									SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard1_count1 player1
									flag_all_guards_react_count1 = 1
									guard1_in_alert_position_count1 = 1
									flag_guard1_go_for_alert_count1 = 2  
								ENDIF

							ENDIF
																	
						ENDIF

					ELSE

					   	IF flag_guard1_kill_player_count1 = 0
							CHAR_FOLLOW_PATH guard1_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard1_count1 player1
							flag_guard1_kill_player_count1 = 1
						ENDIF

					   //	IF timer_guards_react_count1 = 2
							CHAR_FOLLOW_PATH guard1_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard1_count1 player1
					   //	ENDIF

					ENDIF

				ENDIF

			ENDIF
			
		ENDIF

	ENDIF
	
ENDIF		  
		
// guard2

IF frame_counter_count1 = 1

	IF flag_guard2_dead_count1 = 0

		IF IS_CHAR_DEAD guard2_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0 

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
							
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
				
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard2_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard2_count1
			flag_guard2_dead_count1 = 1
		ELSE

			//GET_CHAR_HEALTH guard2_count1 guard2_health_count1
			
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard2_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard2_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
			   
					IF alarm_raised_count1 = 0
								
						IF flag_guard2_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard2_shouted_count1 = 1
						ENDIF

					ENDIF

				   	IF guard2_in_alert_state_count1 = 0
						CHAR_FOLLOW_PATH guard2_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard2_count1 player1
					   	guard2_in_alert_state_count1 = 1
					ENDIF

				  //IF timer_guards_react_count1 = 2
						CHAR_FOLLOW_PATH guard2_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard2_count1 player1
				  //	ENDIF
								
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// Guard 3

IF frame_counter_count1 = 2

	IF flag_guard3_dead_count1 = 0

		IF IS_CHAR_DEAD guard3_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard3_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard3_count1
			flag_guard3_dead_count1 = 1
			
		ELSE

			//GET_CHAR_HEALTH guard3_count1 guard3_health_count1
			
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard3_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard3_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
				
					IF alarm_raised_count1 = 0
								
						IF flag_guard3_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard3_shouted_count1 = 1
						ENDIF

					ENDIF

				   	IF guard3_in_alert_state_count1 = 0
						CHAR_FOLLOW_PATH guard3_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard3_count1 player1
					 	guard3_in_alert_state_count1 = 1
				   	ENDIF

				   //	IF timer_guards_react_count1 = 2
						CHAR_FOLLOW_PATH guard3_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard3_count1 player1
				   //	ENDIF
								
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// Guard4

IF frame_counter_count1  = 3

	IF flag_guard4_dead_count1 = 0

		IF IS_CHAR_DEAD guard4_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
							
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
				
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard4_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard4_count1
			flag_guard4_dead_count1 = 1
		ELSE

		   //	GET_CHAR_HEALTH guard4_count1 guard4_health_count1
		   
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard4_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard4_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
				
					IF alarm_raised_count1 = 0
								
						IF flag_guard4_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard4_shouted_count1 = 1
						ENDIF

					ENDIF

				   	IF guard4_in_alert_state_count1 = 0
						CHAR_FOLLOW_PATH guard4_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard4_count1 player1	
						guard4_in_alert_state_count1 = 1
				   	ENDIF

				   //	IF timer_guards_react_count1 = 2
						CHAR_FOLLOW_PATH guard4_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard4_count1 player1
					//ENDIF
								
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF
	 
// Guard5

IF frame_counter_count1 = 4

	IF flag_guard5_dead_count1 = 0

		IF IS_CHAR_DEAD guard5_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard5_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard5_count1
			flag_guard5_dead_count1 = 1
		ELSE

			//GET_CHAR_HEALTH guard5_count1 guard5_health_count1
			
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard5_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard5_count1 player1
			   	OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
			
					IF alarm_raised_count1 = 0
								
						IF flag_guard5_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard5_shouted_count1 = 1
						ENDIF

					ENDIF

					IF guard5_in_alert_state_count1 = 0
						CHAR_FOLLOW_PATH guard5_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard5_count1 player1
						guard5_in_alert_state_count1 = 1
				   	ENDIF

				   //	IF timer_guards_react_count1 = 2
						CHAR_FOLLOW_PATH guard5_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard5_count1 player1
				   //	ENDIF
								
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// guard6

IF frame_counter_count1 = 5

	IF flag_guard6_dead_count1 = 0

		IF IS_CHAR_DEAD guard6_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard6_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard6_count1
			flag_guard6_dead_count1 = 1
		ELSE

		   //	GET_CHAR_HEALTH guard6_count1 guard6_health_count1
			
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard6_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard6_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
			   
					IF alarm_raised_count1 = 0
								
						IF flag_guard6_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard6_shouted_count1 = 1
						ENDIF

					ENDIF

					IF guard6_in_alert_state_count1 = 0
					   	SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard6_count1 player1
						guard6_in_alert_state_count1 = 1
					ENDIF
																
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF
	
// guard7

IF frame_counter_count1 = 6

	IF flag_guard7_dead_count1 = 0

		IF IS_CHAR_DEAD guard7_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard7_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard7_count1
			flag_guard7_dead_count1 = 1
		ELSE

			//GET_CHAR_HEALTH guard7_count1 guard7_health_count1
					
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard7_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard7_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
				
					IF alarm_raised_count1 = 0
								
						IF flag_guard7_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard7_shouted_count1 = 1
						ENDIF

					ENDIF

					IF guard7_in_alert_state_count1 = 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard7_count1 player1
						guard7_in_alert_state_count1 = 1
					ENDIF
								  											
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// Guard8

IF frame_counter_count1 = 7

	IF flag_guard8_dead_count1 = 0

		IF IS_CHAR_DEAD guard8_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard8_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard8_count1
			flag_guard8_dead_count1 = 1
		ELSE

		   //	GET_CHAR_HEALTH guard8_count1 guard8_health_count1
					
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard8_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard8_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
				
					IF alarm_raised_count1 = 0
								
						IF flag_guard8_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard8_shouted_count1 = 1
						ENDIF

					ENDIF

					IF guard8_in_alert_state_count1 = 0
						CHAR_FOLLOW_PATH guard8_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard8_count1 player1
						guard8_in_alert_state_count1 = 1
					ENDIF

				   //	IF timer_guards_react_count1 = 2
						CHAR_FOLLOW_PATH guard8_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard8_count1 player1
				   //	ENDIF
								
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// Guard9

IF frame_counter_count1 = 8

	IF flag_guard9_dead_count1 = 0

		IF IS_CHAR_DEAD guard9_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard9_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard9_count1
			flag_guard9_dead_count1 = 1
		ELSE

			//GET_CHAR_HEALTH guard9_count1 guard9_health_count1

			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard9_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard9_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
				
					IF alarm_raised_count1 = 0
								
						IF flag_guard9_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard9_shouted_count1 = 1
						ENDIF

					ENDIF

					IF guard9_in_alert_state_count1 = 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard9_count1 player1
						guard9_in_alert_state_count1 = 1
					ENDIF
																
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// guard10

IF frame_counter_count1 = 9

	IF flag_guard10_dead_count1 = 0

		IF IS_CHAR_DEAD guard10_count1
			-- counter_blokes_alive_count1

			IF timer_shooting_started_count1 = 0

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_DETONATOR_GRENADE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_MOLOTOV
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_ROCKET
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_PISTOL
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_PYTHON
					timer_shooting_started_count1 = 1
				ENDIF
								
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_SPAS12_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_STUBBY_SHOTGUN
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_RUGER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_TEC9
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_M4
					timer_shooting_started_count1 = 1
				ENDIF
					
				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_MP5
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_UZI
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_UZI_DRIVEBY
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_FLAMETHROWER
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_M60
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_MINIGUN
					timer_shooting_started_count1 = 1
				ENDIF

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard10_count1 WEAPONTYPE_CHAINSAW
					timer_shooting_started_count1 = 1
				ENDIF

			ENDIF

			MARK_CHAR_AS_NO_LONGER_NEEDED guard10_count1
			flag_guard10_dead_count1 = 1
		ELSE

		   //	GET_CHAR_HEALTH guard10_count1 guard10_health_count1
					
			IF flag_player_been_on_boat_count1 = 1

				IF CAN_CHAR_SEE_DEAD_CHAR guard10_count1 PEDTYPE_GANG_SECURITY
				OR HAS_CHAR_SPOTTED_PLAYER guard10_count1 player1
				OR alarm_raised_count1 = 1
				OR flag_all_guards_react_count1 = 1
				
					IF alarm_raised_count1 = 0
								
						IF flag_guard10_shouted_count1 = 0
							PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
							guard1_alarm_run_count1 = 1
							flag_all_guards_react_count1 = 1
							flag_guard10_shouted_count1 = 1
						ENDIF

					ENDIF

					IF guard10_in_alert_state_count1 = 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard10_count1 player1
						guard10_in_alert_state_count1 = 1
					ENDIF
												
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

// Guard11
	   
IF flag_guard11_dead_count1 = 0

	IF IS_CHAR_DEAD guard11_count1
		-- counter_blokes_alive_count1

		IF timer_shooting_started_count1 = 0

			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_GRENADE
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_DETONATOR_GRENADE
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_MOLOTOV
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_ROCKET
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_PISTOL
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_PYTHON
				timer_shooting_started_count1 = 1
			ENDIF
								
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_SHOTGUN
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_SPAS12_SHOTGUN
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_STUBBY_SHOTGUN
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_RUGER
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_TEC9
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_M4
				timer_shooting_started_count1 = 1
			ENDIF
					
			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_MP5
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_UZI
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_UZI_DRIVEBY
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_FLAMETHROWER
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_M60
			OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_MINIGUN
				timer_shooting_started_count1 = 1
			ENDIF

			IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON guard11_count1 WEAPONTYPE_CHAINSAW
				timer_shooting_started_count1 = 1
			ENDIF

		ENDIF

		MARK_CHAR_AS_NO_LONGER_NEEDED guard11_count1
		flag_guard11_dead_count1 = 1

	ELSE

	   //	GET_CHAR_HEALTH guard11_count1 guard11_health_count1
					
		IF flag_player_been_on_boat_count1 = 1

			IF CAN_CHAR_SEE_DEAD_CHAR guard11_count1 PEDTYPE_GANG_SECURITY
			OR HAS_CHAR_SPOTTED_PLAYER guard11_count1 player1
			OR alarm_raised_count1 = 1
			OR flag_all_guards_react_count1 = 1
				
				IF alarm_raised_count1 = 0
								
					IF flag_guard11_shouted_count1 = 0
						PRINT_NOW ( CM1_3 ) 5000 1 //"Intruder alert raise the alarm!"
						guard1_alarm_run_count1 = 1
						flag_all_guards_react_count1 = 1
						flag_guard11_shouted_count1 = 1
					ENDIF

				ENDIF
																						
			ENDIF

		ENDIF

	ENDIF

ENDIF
	
//IF timer_guards_react_count1 = 2
   //	timer_guards_react_count1 = 0
//ENDIF
	
RETURN

// If the alarm has been raised this will create guys from the ships interior

alarm_guard_creation_count1:

IF total_guards_created_count1 <= 40
	
	IF counter_blokes_alive_count1 < 6
	
		IF flag_created_bloke_in_area_count1 = 2
			timerb = 0
			flag_created_bloke_in_area_count1 = 0
		ENDIF
				 		
		IF NOT IS_AREA_OCCUPIED -693.25 -1257.23 14.0 -685.06 -1261.67 17.0 FALSE TRUE TRUE FALSE FALSE

			//IF flag_had_escape_message_count1 = 0
			//	number_to_act_at_count1 = 7000
			//ELSE
				number_to_act_at_count1 = 3000
			//ENDIF	

			IF timerb >= number_to_act_at_count1
				

				IF flag_created_bloke_in_area_count1 = 0

					guard_number_count1 = -1
				
					IF flag_guard1_state_count1 = 0
					OR flag_guard1_state_count1 = 2
						CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
						CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard1_count1
						guard_number_count1 = created_guard1_count1
						flag_guard1_state_count1 = 1
					ELSE
	
						IF flag_guard2_state_count1 = 0
						OR flag_guard2_state_count1 = 2
							CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE
							CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard2_count1
							guard_number_count1 = created_guard2_count1
							flag_guard2_state_count1 = 1
						ELSE

							IF flag_guard3_state_count1 = 0
							OR flag_guard3_state_count1 = 2
								CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
								CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard3_count1
								guard_number_count1 = created_guard3_count1
								flag_guard3_state_count1 = 1
							ELSE	
			
								IF flag_guard4_state_count1 = 0
								OR flag_guard4_state_count1 = 2
									CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
									CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard4_count1
									guard_number_count1 = created_guard4_count1
									flag_guard4_state_count1 = 1
								ELSE

									IF flag_guard5_state_count1 = 0
									OR flag_guard5_state_count1 = 2
										CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
										CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard5_count1
										guard_number_count1 = created_guard5_count1
										flag_guard5_state_count1 = 1
									ELSE

										IF flag_guard6_state_count1 = 0
										OR flag_guard6_state_count1 = 2
											CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
											CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard6_count1
											guard_number_count1 = created_guard6_count1
											flag_guard6_state_count1 = 1
										ELSE
										
											IF flag_guard7_state_count1 = 0
											OR flag_guard7_state_count1 = 2
												CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
												CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard7_count1
												guard_number_count1 = created_guard7_count1
												flag_guard7_state_count1 = 1
											ELSE
											
												IF flag_guard8_state_count1 = 0
												OR flag_guard8_state_count1 = 2
													CLEAR_AREA -689.73 -1259.37 15.24 1.0 FALSE 
													CREATE_CHAR PEDTYPE_GANG_SECURITY GDa -689.73 -1259.37 15.24 created_guard8_count1
													guard_number_count1 = created_guard8_count1
													flag_guard8_state_count1 = 1
												ENDIF

											ENDIF

										ENDIF

									ENDIF

								ENDIF

							ENDIF

						ENDIF	

					ENDIF
					
					IF NOT IS_CHAR_DEAD guard_number_count1
						
						IF NOT guard_number_count1 = -1	
							SET_CHAR_PERSONALITY guard_number_count1 PEDSTAT_TOUGH_GUY 
							SET_CHAR_HEADING guard_number_count1 204.71
							SET_CHAR_OBJ_RUN_TO_COORD guard_number_count1 -688.40 -1262.07
							++ counter_blokes_alive_count1
							++ total_guards_created_count1
							flag_created_bloke_in_area_count1 = 1
						ENDIF

					ENDIF

				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF

RETURN

// Checks to see if the created guards are in the correct area and gives them AI

guard_AI_count1:

IF flag_created_bloke_in_area_count1 = 1

	IF NOT IS_CHAR_DEAD guard_number_count1 

		IF LOCATE_CHAR_ON_FOOT_2D guard_number_count1 -688.40 -1262.07 1.0 1.0 FALSE
			GIVE_WEAPON_TO_CHAR guard_number_count1 WEAPONTYPE_MP5 30000 // Set to infinate ammo
			CHAR_FOLLOW_PATH guard_number_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT guard_number_count1 player1
			flag_created_bloke_in_area_count1 = 2
		ENDIF

	ELSE
		flag_created_bloke_in_area_count1 = 2	
	ENDIF
	
ENDIF

RETURN

// Guard death checks

alarm_guard_death_check_count1:

IF frame_counter_count1 = 10
	   						
	IF flag_guard1_state_count1 = 1

		IF IS_CHAR_DEAD created_guard1_count1
			REMOVE_CHAR_ELEGANTLY created_guard1_count1
			-- counter_blokes_alive_count1
			flag_guard1_state_count1 = 2
		ELSE

		   //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard1_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard1_count1 player1
		   //	ENDIF

		ENDIF  
			
	ENDIF

ENDIF

IF frame_counter_count1 = 11

	IF flag_guard2_state_count1 = 1

		IF IS_CHAR_DEAD created_guard2_count1
			REMOVE_CHAR_ELEGANTLY created_guard2_count1
			-- counter_blokes_alive_count1
			flag_guard2_state_count1 = 2
		ELSE

		   //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard2_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard2_count1 player1
			//ENDIF

		ENDIF
			
	ENDIF

ENDIF

IF frame_counter_count1 = 12

	IF flag_guard3_state_count1 = 1

		IF IS_CHAR_DEAD created_guard3_count1
			REMOVE_CHAR_ELEGANTLY created_guard3_count1
			-- counter_blokes_alive_count1
			flag_guard3_state_count1 = 2
		ELSE

		  //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard3_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard3_count1 player1
		  //	ENDIF

		ENDIF

	ENDIF

ENDIF

IF frame_counter_count1 = 13

	IF flag_guard4_state_count1 = 1

		IF IS_CHAR_DEAD created_guard4_count1
			REMOVE_CHAR_ELEGANTLY created_guard4_count1
			-- counter_blokes_alive_count1
			flag_guard4_state_count1 = 2
		ELSE

		   //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard4_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard4_count1 player1
		   //	ENDIF

		ENDIF
			
	ENDIF

ENDIF

IF frame_counter_count1 = 14

	IF flag_guard5_state_count1 = 1

		IF IS_CHAR_DEAD created_guard5_count1
			REMOVE_CHAR_ELEGANTLY created_guard5_count1
			-- counter_blokes_alive_count1
			flag_guard5_state_count1 = 2
		ELSE

		  //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard5_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard5_count1 player1
		  //	ENDIF

		ENDIF
			
	ENDIF

ENDIF

IF frame_counter_count1 = 15

	IF flag_guard6_state_count1 = 1

		IF IS_CHAR_DEAD created_guard6_count1
			REMOVE_CHAR_ELEGANTLY created_guard6_count1
			-- counter_blokes_alive_count1
			flag_guard6_state_count1 = 2
		ELSE

		  //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard6_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard6_count1 player1
		   //	ENDIF

		ENDIF
			
	ENDIF

ENDIF

IF frame_counter_count1 = 16

	IF flag_guard7_state_count1 = 1

		IF IS_CHAR_DEAD created_guard7_count1
			REMOVE_CHAR_ELEGANTLY created_guard7_count1
			-- counter_blokes_alive_count1
			flag_guard7_state_count1 = 2
		ELSE

		   //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard7_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard7_count1 player1
		   //	ENDIF

		ENDIF
			
	ENDIF

ENDIF

IF frame_counter_count1 = 17

	IF flag_guard8_state_count1 = 1

		IF IS_CHAR_DEAD created_guard8_count1
			REMOVE_CHAR_ELEGANTLY created_guard8_count1
			-- counter_blokes_alive_count1
			flag_guard8_state_count1 = 2
		ELSE

		   //	IF timer_alarm_guards_react_count1 = 2
				CHAR_FOLLOW_PATH created_guard8_count1 player_x_count1 player_y_count1 player_z_count1 0.5 RUN
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT created_guard8_count1 player1
		   //	ENDIF

		ENDIF
			
	ENDIF

ENDIF

//IF timer_alarm_guards_react_count1 = 2
//	timer_alarm_guards_react_count1 = 0
//ENDIF
 
RETURN

// Mini Cutscene with player entering the cabin

mini_cut_count1:

SWITCH_WIDESCREEN ON
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
SET_POLICE_IGNORE_PLAYER player1 ON
GET_PLAYER_CHAR player1 scplayer

CLEAR_AREA -684.90 -1248.98 30.14 2.0 FALSE
CLEAR_AREA -686.85 -1245.43 30.14 2.0 FALSE 

SET_FIXED_CAMERA_POSITION -691.09 -1242.906 31.45 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -690.182 -1243.30 31.46 JUMP_CUT

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -684.90 -1248.98

timera = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer -684.90 -1248.98 0.5 0.5 FALSE

	WAIT 0

	GET_GAME_TIMER game_time_count1

	IF flag_all_guards_react_count1 = 1

		IF timer_guards_react_count1 = 0
			timer_started_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF				   

		IF timer_guards_react_count1 = 1
			time_to_act_count1 = game_time_count1 - timer_started_count1 
					
			IF time_to_act_count1 >= 1000
				timer_guards_react_count1 = 2
			ENDIF

		ENDIF

		IF timer_alarm_guards_react_count1 = 0
			timer_started_alarm_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_alarm_guards_react_count1 = 1

			time_to_act_alarm_count1 = game_time_count1 - timer_started_alarm_count1 
					
			IF time_to_act_alarm_count1 >= 1000
				timer_alarm_guards_react_count1 = 2
			ENDIF

		ENDIF
		
	ENDIF
	
	IF timera >= 6000

		IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer -684.90 -1248.98 0.5 0.5 FALSE 
			SET_CHAR_COORDINATES scplayer -684.90 -1248.98 30.14	
		ENDIF

	ENDIF

	GOSUB guard_checks_count1
	
   	IF alarm_raised_count1 = 1
				
   		IF flag_timer_started_count1 = 0
   			timerb = 0
   			flag_timer_started_count1 = 1
   		ENDIF
		 
   		GOSUB alarm_guard_creation_count1
  		GOSUB guard_AI_count1
		GOSUB alarm_guard_death_check_count1

   	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO 2 // ( CNT1_1 ) NOT THE FACE

PRINT_NOW ( CNT1_1 ) 5000 1 //"Not the Face Arg!!"

LOAD_MISSION_AUDIO 1 ( CNT1_2 ) //"Ok, I talk! I talk!"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
//OR NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0

	GET_GAME_TIMER game_time_count1

	IF flag_all_guards_react_count1 = 1

		IF timer_guards_react_count1 = 0
			timer_started_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_guards_react_count1 = 1
			time_to_act_count1 = game_time_count1 - timer_started_count1 
					
			IF time_to_act_count1 >= 1000
				timer_guards_react_count1 = 2
			ENDIF

		ENDIF

		IF timer_alarm_guards_react_count1 = 0
			timer_started_alarm_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_alarm_guards_react_count1 = 1

			time_to_act_alarm_count1 = game_time_count1 - timer_started_alarm_count1 
					
			IF time_to_act_alarm_count1 >= 1000
				timer_alarm_guards_react_count1 = 2
			ENDIF

		ENDIF
		
	ENDIF

	GOSUB guard_checks_count1
	
   	IF alarm_raised_count1 = 1
				
   		IF flag_timer_started_count1 = 0
   			timerb = 0
   			flag_timer_started_count1 = 1
   		ENDIF
		 
   		GOSUB alarm_guard_creation_count1
  		GOSUB guard_AI_count1
		GOSUB alarm_guard_death_check_count1

   	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( CNT1_1 )

WHILE NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0

	GET_GAME_TIMER game_time_count1

	IF flag_all_guards_react_count1 = 1

		IF timer_guards_react_count1 = 0
			timer_started_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_guards_react_count1 = 1
			time_to_act_count1 = game_time_count1 - timer_started_count1 
					
			IF time_to_act_count1 >= 1000
				timer_guards_react_count1 = 2
			ENDIF

		ENDIF

		IF timer_alarm_guards_react_count1 = 0
			timer_started_alarm_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_alarm_guards_react_count1 = 1

			time_to_act_alarm_count1 = game_time_count1 - timer_started_alarm_count1 
					
			IF time_to_act_alarm_count1 >= 1000
				timer_alarm_guards_react_count1 = 2
			ENDIF

		ENDIF
		
	ENDIF

	GOSUB guard_checks_count1
	
   	IF alarm_raised_count1 = 1
				
   		IF flag_timer_started_count1 = 0
   			timerb = 0
   			flag_timer_started_count1 = 1
   		ENDIF
		 
   		GOSUB alarm_guard_creation_count1
  		GOSUB guard_AI_count1
		GOSUB alarm_guard_death_check_count1

   	ENDIF

ENDWHILE

PLAY_MISSION_AUDIO 1 // ( CNT1_2 )

PRINT_NOW ( CNT1_2 ) 5000 1 //"Okay okay I will give you the info!"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0

	GET_GAME_TIMER game_time_count1

	IF flag_all_guards_react_count1 = 1

		IF timer_guards_react_count1 = 0
			timer_started_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_guards_react_count1 = 1
			time_to_act_count1 = game_time_count1 - timer_started_count1 
					
			IF time_to_act_count1 >= 1000
				timer_guards_react_count1 = 2
			ENDIF

		ENDIF

		IF timer_alarm_guards_react_count1 = 0
			timer_started_alarm_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_alarm_guards_react_count1 = 1

			time_to_act_alarm_count1 = game_time_count1 - timer_started_alarm_count1 
					
			IF time_to_act_alarm_count1 >= 1000
				timer_alarm_guards_react_count1 = 2
			ENDIF

		ENDIF
		
	ENDIF

	GOSUB guard_checks_count1
	
   	IF alarm_raised_count1 = 1
				
   		IF flag_timer_started_count1 = 0
   			timerb = 0
   			flag_timer_started_count1 = 1
   		ENDIF
		 
   		GOSUB alarm_guard_creation_count1
  		GOSUB guard_AI_count1
		GOSUB alarm_guard_death_check_count1

   	ENDIF

ENDWHILE

CLEAR_THIS_PRINT ( CNT1_2 )

SET_CHAR_COORDINATES scplayer -685.59 -1247.87 30.14

SET_CHAR_HEADING scplayer 32.24 

CLEAR_AREA -686.85 -1245.43 30.14 2.0 FALSE
CLEAR_AREA -684.90 -1248.98 30.14 2.0 FALSE 

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT scplayer -686.85 -1245.43

timerb = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_2D scplayer -686.85 -1245.43 0.5 0.5 FALSE  

	WAIT 0

	GET_GAME_TIMER game_time_count1

	IF flag_all_guards_react_count1 = 1

		IF timer_guards_react_count1 = 0
			timer_started_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_guards_react_count1 = 1
			time_to_act_count1 = game_time_count1 - timer_started_count1 
					
			IF time_to_act_count1 >= 1000
				timer_guards_react_count1 = 2
			ENDIF

		ENDIF

		IF timer_alarm_guards_react_count1 = 0
			timer_started_alarm_count1 = game_time_count1
			timer_guards_react_count1 = 1
		ENDIF

		IF timer_alarm_guards_react_count1 = 1

			time_to_act_alarm_count1 = game_time_count1 - timer_started_alarm_count1 
					
			IF time_to_act_alarm_count1 >= 1000
				timer_alarm_guards_react_count1 = 2
			ENDIF

		ENDIF
		
	ENDIF

	IF timerb >= 4000

		IF NOT LOCATE_CHAR_ON_FOOT_2D scplayer -686.85 -1245.43 0.5 0.5 FALSE
			SET_CHAR_COORDINATES scplayer -686.85 -1245.43 30.14
		ENDIF
		
	ENDIF 

	GOSUB guard_checks_count1
	
   	IF alarm_raised_count1 = 1
				
   		IF flag_timer_started_count1 = 0
   			timerb = 0
   			flag_timer_started_count1 = 1
   		ENDIF
		 
   		GOSUB alarm_guard_creation_count1
  		GOSUB guard_AI_count1
		GOSUB alarm_guard_death_check_count1

   	ENDIF

ENDWHILE

SWITCH_WIDESCREEN OFF
SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_CAMERA_IN_FRONT_OF_PLAYER
RESTORE_CAMERA_JUMPCUT
flag_had_mini_cut_count1 = 1

RETURN

// Gets rid off all the guys on the boat

mini_cleanup_count1:

REMOVE_SOUND alarm_count1

MARK_CHAR_AS_NO_LONGER_NEEDED guard1_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard2_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard3_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard4_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard5_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard6_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard7_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard8_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard9_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard10_count1
MARK_CHAR_AS_NO_LONGER_NEEDED guard11_count1
 
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard1_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard2_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard3_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard4_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard5_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard6_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard7_count1
MARK_CHAR_AS_NO_LONGER_NEEDED created_guard8_count1

done_mini_cleanup_count1 = 1
				
RETURN
			

}