MISSION_START
// *****************************************************************************************
// ******************** Counterfeiting Mission 2 - Plates Courier **************************
// *****************************************************************************************
// *** The courier will go from a-to-b in a three car convoy. The player1 must kill him  ***
// *** and retrieve the plates (destroying any car that he is in will fail the mission   ***
// *** - plates destroyed.)																 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_counter2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_counter2_failed
ENDIF

GOSUB mission_cleanup_counter2

MISSION_END


// Variables for mission

//CARS PEDS OBJECTS PICKUPS
VAR_INT	courier_car1 courier_car2 courier_car3 players_car courier_heli plates
VAR_INT courier_car1_guard1 courier_car1_guard2 courier_car1_guard3 courier_car1_guard4
VAR_INT courier_car2_guard1 courier_car2_guard2 courier_car2_guard3 courier	shooting_char
VAR_INT courier_car3_guard1 courier_car3_guard2 courier_car3_guard3 courier_car3_guard4
VAR_INT sniper1 sniper2 sniper3 sniper4	docks_guard
//FLAGS COUNTERS TIMERS
VAR_INT game_timer courier_flag	passenger_seat security_warning shoot_from_car_counter
VAR_INT car1_ped_in_car_flag car3_ped_in_car_flag courier_has_died courier_flag2
VAR_INT car1_stuck_flag car2_stuck_flag car3_stuck_flag	courier_in_car next_car_timer
VAR_INT courier_car1_health courier_car2_health courier_car3_health	flee_car_timer
VAR_INT car1_stuck_timer_start car2_stuck_timer_start car3_stuck_timer_start
VAR_INT guard1_into_car_flag guard2_into_car_flag created_object_flag shoot_from_car
VAR_INT car1_location_counter car2_location_counter car3_location_counter
VAR_INT car1_arrived_flag car2_arrived_flag	car3_arrived_flag fly_heli_away_flag
VAR_INT shoot_heli_down_flag shoot_from_car_timer courier_car2_health_shoot
VAR_INT sniper1_flag sniper2_flag sniper3_flag sniper4_flag	sniper_dudes_counter docks_guard_counter
//BLIPS
VAR_INT docks_blip//mission_blip2 mission_blip3
//COORDS MATHS
VAR_FLOAT car1_stuck_x car1_stuck_y car1_stuck_z
VAR_FLOAT car2_stuck_x car2_stuck_y car2_stuck_z
VAR_FLOAT car3_stuck_x car3_stuck_y car3_stuck_z
VAR_FLOAT x_temp y_temp	sum_x_y_temp
VAR_FLOAT car1_distance_from_vehicle_behind car2_distance_from_vehicle_behind

//LOAD_AND_LAUNCH_EXCLUSIVE stuff
//VAR_INT mission_blip frame_counter is_audio_in_use
//VAR_INT audio_1_flag audio_2_flag audio_2_timeout audio_3_flag audio_3_timeout audio_4_flag audio_4_timeout
//VAR_FLOAT temp_float_x temp_float_y	gosub_car_to_slow_speed	forward_x forward_y	temp_y
//VAR_FLOAT gosub_target_car_x gosub_target_car_y	gosub_car_to_slow_x gosub_car_to_slow_y

// ******************************* Mission Start *******************************************

mission_start_counter2:

flag_player_on_mission = 1

SCRIPT_NAME count2
REGISTER_MISSION_GIVEN

WAIT 0
{
LVAR_FLOAT courier_car1_x courier_car1_y courier_car1_speed
LVAR_FLOAT courier_car2_x courier_car2_y courier_car2_speed
LVAR_FLOAT courier_car3_x courier_car3_y courier_car3_speed
LVAR_FLOAT courier_car1_distance courier_car2_distance courier_car3_distance
LVAR_FLOAT cnt2_left_door_heading cnt2_right_door_heading

LOAD_MISSION_TEXT COUNT2
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1045.726 -292.454 9.758 97.607  // On road outside of Print Works

game_timer = 0
courier_flag = 0
courier_flag2 = 0
courier_in_car = 0
next_car_timer = 0
passenger_seat = 0
flee_car_timer = 0
shoot_from_car = 0
shoot_from_car_counter = 0
car1_ped_in_car_flag = 0
car3_ped_in_car_flag = 0
created_object_flag = 0
security_warning = 0
courier_has_died = 0
car1_stuck_flag = 0
car2_stuck_flag = 0
car3_stuck_flag = 0
fly_heli_away_flag = 0
courier_car1_health = 0
courier_car2_health = 0
courier_car3_health = 0
car1_stuck_timer_start = 0
car2_stuck_timer_start = 0
car3_stuck_timer_start = 0
guard1_into_car_flag = 0
guard2_into_car_flag = 0
car1_location_counter = 0
car2_location_counter = 0
car3_location_counter = 0
car1_arrived_flag = 0
car2_arrived_flag = 0
car3_arrived_flag = 0
shoot_heli_down_flag = 0
shoot_from_car_timer = 0

courier_car2_health_shoot = 0

sniper1_flag = 0
sniper2_flag = 0
sniper3_flag = 0
sniper4_flag = 0
sniper_dudes_counter = 0

car1_stuck_x = 0.0
car1_stuck_y = 0.0
car1_stuck_z = 0.0
car2_stuck_x = 0.0
car2_stuck_y = 0.0
car2_stuck_z = 0.0
car3_stuck_x = 0.0
car3_stuck_y = 0.0
car3_stuck_z = 0.0
heading = 0.0
courier_car1_distance = 0.0
courier_car2_distance = 0.0
courier_car3_distance = 0.0
coord_1_x = 0.0
coord_1_y = 0.0
coord_1_z = 0.0
cnt2_left_door_heading = 0.0
cnt2_right_door_heading = 0.0

docks_guard_counter = 0

is_audio_in_use = 0
audio_1_flag = 0
audio_2_flag = 0
audio_3_flag = 0
audio_4_flag = 0

frame_counter = 0

gosub_car_to_slow_speed = 0.0

//////////////////////////
//////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cskelly
LOAD_SPECIAL_CHARACTER 3 csbuddy

//LOAD_SPECIAL_MODEL cut_obj1 PLAYERH
//LOAD_SPECIAL_MODEL cut_obj2 LAWYERH

SET_AREA_VISIBLE VIS_PRINT_WORKS
LOAD_SCENE -1071.5597 -278.9497 12.3606

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
//OR NOT HAS_MODEL_LOADED cut_obj1
//OR NOT HAS_MODEL_LOADED cut_obj2
	WAIT 0

ENDWHILE

LOAD_CUTSCENE cnt_2
SET_CUTSCENE_OFFSET -1064.103 -276.39 11.066
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken cskelly

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_buddy
SET_CUTSCENE_ANIM cs_buddy csbuddy

//CREATE_CUTSCENE_HEAD cs_ken CUT_OBJ2 cs_kenhead
//SET_CUTSCENE_HEAD_ANIM cs_kenhead lawyer

//CREATE_CUTSCENE_HEAD cs_player CUT_OBJ1 cs_playerhead
//SET_CUTSCENE_HEAD_ANIM cs_playerhead player1
CLEAR_AREA -1071.5792 -281.4316 12.3068	3.0 TRUE
CLEAR_AREA -1059.8411 -278.7214 10.4044 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1059.8411 -278.7214 10.4044
SET_PLAYER_HEADING player1 272.2088
SET_NEAR_CLIP 0.1

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1444
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B1 10000 1
//Alright, the courier's moving the plate from the docks today.

WHILE cs_time < 3750
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B2 10000 1
//I'm gonna go intercept them, grab the plates, lose any heat, and make my way back here.

WHILE cs_time < 7974
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B3 10000 1
//Now. Depending how well this goes,

WHILE cs_time < 9975
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B4 10000 1
//we may have five minutes to print the money before the counterfeit syndicate finds us, or we may have all year.

WHILE cs_time < 14465
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B5 10000 1
//Either way, I want green rolling off the presses five minutes after I get back. Got it?

WHILE cs_time < 18722
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B6 10000 1
//Don't you worry Tommy. We'll be ready Tommy.

WHILE cs_time < 22232
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B7 10000 1
//Me an'der boys will be around the neighbourhood case you need any heat taking care of.

WHILE cs_time < 28537
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CNT2_B8 10000 1
//Alright everybody cool?  Ok. Catch you later...                                                                                                   

WHILE cs_time < 30268//31872
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
CLEAR_PRINTS
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -1059.8411 -278.7214 10.4044
//////////////////////////
//////////////////////////

SET_PLAYER_MOOD player1 PLAYER_MOOD_WISECRACKING 60000

REQUEST_MODEL SENTINEL
REQUEST_MODEL COLT45
REQUEST_MODEL briefcase
REQUEST_MODEL MAVERICK
REQUEST_MODEL SNIPER
REQUEST_MODEL TEC9
REQUEST_MODEL HFORI
REQUEST_MODEL HFYBU
REQUEST_MODEL WFYRI
REQUEST_MODEL WFORI
REQUEST_MODEL BFYST
REQUEST_MODEL WFYBU
REQUEST_MODEL UZI
REQUEST_MODEL CHROMEGUN

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED SENTINEL
OR NOT HAS_MODEL_LOADED	COLT45
OR NOT HAS_MODEL_LOADED HFORI
OR NOT HAS_MODEL_LOADED HFYBU
OR NOT HAS_MODEL_LOADED WFYRI
OR NOT HAS_MODEL_LOADED WFORI
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED briefcase
OR NOT HAS_MODEL_LOADED	MAVERICK
OR NOT HAS_MODEL_LOADED	SNIPER
OR NOT HAS_MODEL_LOADED	TEC9
OR NOT HAS_MODEL_LOADED BFYST
OR NOT HAS_MODEL_LOADED WFYBU
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED CHROMEGUN
OR NOT HAS_MODEL_LOADED	UZI
	WAIT 0
ENDWHILE

//SET_PLAYER_CONTROL player1 OFF
//SET_ALL_CARS_CAN_BE_DAMAGED FALSE
//WAIT 0
//WAIT 0
//SWITCH_WIDESCREEN ON

CREATE_CAR MAVERICK 408.1980 -1726.1954 50.0 courier_heli
SET_LOAD_COLLISION_FOR_CAR_FLAG courier_heli FALSE
//CHANGE_CAR_COLOUR courier_heli 0 0
SET_CAR_FORWARD_SPEED courier_heli 10.0

CREATE_CHAR_INSIDE_CAR courier_heli	PEDTYPE_GANG_STREET	WFORI courier_car2_guard3
GIVE_WEAPON_TO_CHAR	courier_car2_guard3 WEAPONTYPE_TEC9 9999
CLEAR_CHAR_THREAT_SEARCH courier_car2_guard3
SET_CHAR_THREAT_SEARCH courier_car2_guard3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car2_guard3 THREAT_FAST_CAR
SET_CHAR_PERSONALITY courier_car2_guard3 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car2_guard3 TRUE
SET_ANIM_GROUP_FOR_CHAR courier_car2_guard3 ANIM_SEXY_WOMANPED
SET_LOAD_COLLISION_FOR_CHAR_FLAG courier_car2_guard3 FALSE

CREATE_CHAR_AS_PASSENGER courier_heli PEDTYPE_GANG_STREET HFYBU 0 courier


GIVE_WEAPON_TO_CHAR	courier WEAPONTYPE_SHOTGUN 6
CLEAR_CHAR_THREAT_SEARCH courier
SET_CHAR_THREAT_SEARCH courier THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier THREAT_FAST_CAR
SET_CHAR_PERSONALITY courier PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier TRUE
SET_ANIM_GROUP_FOR_CHAR courier ANIM_SEXY_WOMANPED
SET_LOAD_COLLISION_FOR_CHAR_FLAG courier FALSE
ADD_BLIP_FOR_CHAR courier mission_blip
CHANGE_BLIP_SCALE mission_blip 3
HELI_GOTO_COORDS courier_heli -649.6716 -1590.7273 40.0 15
SET_CAR_FORWARD_SPEED courier_heli 15.0
courier_flag = 1

//SET_FIXED_CAMERA_POSITION 388.0 -1710.0 35.0 0.0 0.0 0.0
//POINT_CAMERA_AT_CAR	courier_heli FIXED JUMP_CUT
//LOAD_SCENE 408.1980 -1726.1954 50.0

//DO_FADE 1500 FADE_IN

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

//PRINT_NOW CNT2_01 30000 1//"Go and get the plates from the courier who is leaving the docks any second now."

//WAIT 5000

//DO_FADE 1500 FADE_OUT

//WHILE GET_FADING_STATUS
//	WAIT 0
//ENDWHILE

//SET_CAMERA_BEHIND_PLAYER
//RESTORE_CAMERA_JUMPCUT
//SET_PLAYER_CONTROL player1 ON
//SET_ALL_CARS_CAN_BE_DAMAGED TRUE
//SWITCH_WIDESCREEN OFF
//LOAD_SCENE -1059.8411 -278.7214 10.4044

DO_FADE 1500 FADE_IN

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW CNT2_01 30000 1//"Go and get the plates from the courier who is leaving the docks any second now."
ADD_BLIP_FOR_COORD -683.1377 -1566.9713 11.4 docks_blip

SET_ENTER_CAR_RANGE_MULTIPLIER 10.0
SET_THREAT_REACTION_RANGE_MULTIPLIER 3.0

CREATE_CAR SENTINEL -707.2035 -1549.6058 11.4769 courier_car1 //On road near ship
CHANGE_CAR_COLOUR courier_car1 10 0
SET_CAR_HEADING courier_car1 66.0
SET_CAR_CRUISE_SPEED courier_car1 15.0
courier_car1_speed = 0.0
SET_CAR_DRIVING_STYLE courier_car1 2
SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car1 TRUE
SET_CAR_CHANGE_LANE courier_car1 FALSE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED courier_car1 TRUE
CAR_SET_IDLE courier_car1
MARK_CAR_AS_CONVOY_CAR courier_car1 TRUE
SET_CAR_MISSION courier_car1 MISSION_STOP_FOREVER

CREATE_CAR SENTINEL -708.8500 -1553.7223 11.4936 courier_car2 //On road near ship
CHANGE_CAR_COLOUR courier_car2 0 0
SET_CAR_HEADING courier_car2 66.0
SET_CAR_CRUISE_SPEED courier_car2 15.0
courier_car2_speed = 0.0
SET_CAR_DRIVING_STYLE courier_car2 2
SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car2 TRUE
SET_CAR_CHANGE_LANE courier_car2 FALSE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED courier_car2 TRUE
LOCK_CAR_DOORS courier_car2 CARLOCK_LOCKOUT_PLAYER_ONLY
CAR_SET_IDLE courier_car2
MARK_CAR_AS_CONVOY_CAR courier_car2 TRUE
SET_CAR_MISSION courier_car2 MISSION_STOP_FOREVER

CREATE_CAR SENTINEL -710.5004 -1557.8105 11.5109 courier_car3 //On road near ship
CHANGE_CAR_COLOUR courier_car3 10 0
SET_CAR_HEADING courier_car3 66.0
SET_CAR_CRUISE_SPEED courier_car3 15.0
courier_car3_speed = 0.0
SET_CAR_DRIVING_STYLE courier_car3 2
SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car3 TRUE
SET_CAR_CHANGE_LANE courier_car3 FALSE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED courier_car3 TRUE
CAR_SET_IDLE courier_car3
MARK_CAR_AS_CONVOY_CAR courier_car3 TRUE
SET_CAR_MISSION courier_car3 MISSION_STOP_FOREVER

///ENTRANCE GUARDS & CAR1 DUDES//////////////////////////////////////
/////////////////////////////////////////////////////////////////////
CREATE_CHAR PEDTYPE_GANG_STREET HFORI -718.9443 -1530.9095 11.2232 courier_car1_guard1
SET_CHAR_HEADING courier_car1_guard1 299.6208 
GIVE_WEAPON_TO_CHAR	courier_car1_guard1 WEAPONTYPE_SHOTGUN 2
CLEAR_CHAR_THREAT_SEARCH courier_car1_guard1
SET_CHAR_THREAT_SEARCH courier_car1_guard1 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car1_guard1 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car1_guard1 THREAT_GUN
SET_CHAR_PERSONALITY courier_car1_guard1 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car1_guard1 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car1_guard1 -718.9443 -1530.9095 11.2232
SET_ANIM_GROUP_FOR_CHAR courier_car1_guard1 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car1_guard1 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET HFORI -716.1127 -1533.7849 11.2238 courier_car1_guard2//SITTING
SET_CHAR_HEADING courier_car1_guard2 258.1555 
GIVE_WEAPON_TO_CHAR	courier_car1_guard2 WEAPONTYPE_UZI 9999
CLEAR_CHAR_THREAT_SEARCH courier_car1_guard2
SET_CHAR_THREAT_SEARCH courier_car1_guard2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car1_guard2 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car1_guard2 THREAT_GUN
SET_CHAR_PERSONALITY courier_car1_guard2 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car1_guard2 TRUE
SET_CHAR_WAIT_STATE courier_car1_guard2 WAITSTATE_SIT_IDLE 60000000
SET_CHAR_OBJ_GUARD_SPOT courier_car1_guard2 -716.1127 -1533.7849 11.2238
SET_ANIM_GROUP_FOR_CHAR courier_car1_guard2 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car1_guard2 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET WFORI -715.5613 -1535.6270 11.2565 courier_car1_guard3
SET_CHAR_HEADING courier_car1_guard3 16.6536 
GIVE_WEAPON_TO_CHAR	courier_car1_guard3 WEAPONTYPE_PISTOL 9999
CLEAR_CHAR_THREAT_SEARCH courier_car1_guard3
SET_CHAR_THREAT_SEARCH courier_car1_guard3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car1_guard3 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car1_guard3 THREAT_GUN
SET_CHAR_PERSONALITY courier_car1_guard3 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car1_guard3 TRUE
SET_CHAR_WAIT_STATE courier_car1_guard3 WAITSTATE_PLAYANIM_CHAT	60000000
SET_CHAR_OBJ_GUARD_SPOT courier_car1_guard3 -715.5613 -1535.6270 11.2565
SET_ANIM_GROUP_FOR_CHAR courier_car1_guard3 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car1_guard3 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET WFYRI -710.0019 -1543.7793 11.4329 courier_car1_guard4
SET_CHAR_HEADING courier_car1_guard4 22.8506
GIVE_WEAPON_TO_CHAR	courier_car1_guard4 WEAPONTYPE_TEC9 9999
CLEAR_CHAR_THREAT_SEARCH courier_car1_guard4
SET_CHAR_THREAT_SEARCH courier_car1_guard4 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car1_guard4 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car1_guard4 THREAT_GUN
SET_CHAR_PERSONALITY courier_car1_guard4 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car1_guard4 TRUE
SET_CHAR_WAIT_STATE courier_car1_guard4 WAITSTATE_LOOK_ABOUT 60000000
SET_CHAR_OBJ_GUARD_SPOT courier_car1_guard4 -710.0019 -1543.7793 11.4329
SET_ANIM_GROUP_FOR_CHAR courier_car1_guard4 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car1_guard4 TRUE

///CRANE GUARDS & CAR2 DUDES/////////////////////////////////////////
CREATE_CHAR PEDTYPE_GANG_STREET WFORI -681.0981 -1557.2467 11.4438 courier_car2_guard1
SET_CHAR_HEADING courier_car2_guard1 334.7375 
GIVE_WEAPON_TO_CHAR	courier_car2_guard1 WEAPONTYPE_UZI 9999
CLEAR_CHAR_THREAT_SEARCH courier_car2_guard1
SET_CHAR_THREAT_SEARCH courier_car2_guard1 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car2_guard1 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car2_guard1 THREAT_GUN
SET_CHAR_PERSONALITY courier_car2_guard1 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car2_guard1 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car2_guard1 -681.0981 -1557.2467 11.4438
SET_ANIM_GROUP_FOR_CHAR courier_car2_guard1 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car2_guard1 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET WFYBU -679.4094 -1559.0453 11.4483 courier_car2_guard2
SET_CHAR_HEADING courier_car2_guard2 223.2479 
GIVE_WEAPON_TO_CHAR	courier_car2_guard2 WEAPONTYPE_TEC9 9999
CLEAR_CHAR_THREAT_SEARCH courier_car2_guard2
SET_CHAR_THREAT_SEARCH courier_car2_guard2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car2_guard2 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car2_guard2 THREAT_GUN
SET_CHAR_PERSONALITY courier_car2_guard2 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car2_guard2 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car2_guard2 -679.4094 -1559.0453 11.4483
SET_ANIM_GROUP_FOR_CHAR courier_car2_guard2 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car2_guard2 TRUE

///COURTYARD GUARDS & CAR3 DUDES/////////////////////////////////////
//STANDING ON WALKWAY////////////////////////////////////////////////
CREATE_CHAR PEDTYPE_GANG_STREET HFORI -718.4953 -1560.2139 13.8580 courier_car3_guard1
SET_CHAR_HEADING courier_car3_guard1 14.0515 
GIVE_WEAPON_TO_CHAR	courier_car3_guard1 WEAPONTYPE_SHOTGUN 2
CLEAR_CHAR_THREAT_SEARCH courier_car3_guard1
SET_CHAR_THREAT_SEARCH courier_car3_guard1 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car3_guard1 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car3_guard1 THREAT_GUN
SET_CHAR_PERSONALITY courier_car3_guard1 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car3_guard1 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car3_guard1 -718.4953 -1560.2139 13.8580
SET_ANIM_GROUP_FOR_CHAR courier_car3_guard1 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car3_guard1 TRUE

//SITTING ON WALL
CREATE_CHAR PEDTYPE_GANG_STREET WFYBU -722.6389 -1557.0291 13.8587 courier_car3_guard2
SET_CHAR_HEADING courier_car3_guard2 344.0981 
GIVE_WEAPON_TO_CHAR	courier_car3_guard2 WEAPONTYPE_TEC9 9999
CLEAR_CHAR_THREAT_SEARCH courier_car3_guard2
SET_CHAR_THREAT_SEARCH courier_car3_guard2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car3_guard2 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car3_guard2 THREAT_GUN
SET_CHAR_PERSONALITY courier_car3_guard2 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car3_guard2 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car3_guard2 -722.6389 -1557.0291 13.8587
SET_ANIM_GROUP_FOR_CHAR courier_car3_guard2 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car3_guard2 TRUE

//END OF WALKWAY AT ENTRANCE
CREATE_CHAR PEDTYPE_GANG_STREET WFYRI -721.5871 -1542.4771 13.8572 courier_car3_guard3
SET_CHAR_HEADING courier_car3_guard3 344.0981 
GIVE_WEAPON_TO_CHAR	courier_car3_guard3 WEAPONTYPE_UZI 9999
CLEAR_CHAR_THREAT_SEARCH courier_car3_guard3
SET_CHAR_THREAT_SEARCH courier_car3_guard3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car3_guard3 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car3_guard3 THREAT_GUN
SET_CHAR_PERSONALITY courier_car3_guard3 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car3_guard3 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car3_guard3 -721.5871 -1542.4771 13.8572
SET_ANIM_GROUP_FOR_CHAR courier_car3_guard3 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car3_guard3 TRUE

//BASE OF WALKWAY INFRONT CARS
CREATE_CHAR PEDTYPE_GANG_STREET WFYRI -721.0208 -1548.8218 11.4844 courier_car3_guard4
SET_CHAR_HEADING courier_car3_guard4 263.0088
GIVE_WEAPON_TO_CHAR	courier_car3_guard4 WEAPONTYPE_TEC9 9999
CLEAR_CHAR_THREAT_SEARCH courier_car3_guard4
SET_CHAR_THREAT_SEARCH courier_car3_guard4 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH courier_car3_guard4 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH courier_car3_guard4 THREAT_GUN
SET_CHAR_PERSONALITY courier_car3_guard4 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING courier_car3_guard4 TRUE
SET_CHAR_OBJ_GUARD_SPOT courier_car3_guard4 -721.0208 -1548.8218 11.4844
SET_ANIM_GROUP_FOR_CHAR courier_car3_guard4 ANIM_SEXY_WOMANPED
//SET_CHAR_STAY_IN_SAME_PLACE courier_car3_guard4 TRUE


//WAIT 10000000

//ADD_BLIP_FOR_CHAR courier_car3_guard1 mission_blip2
//ADD_BLIP_FOR_CHAR courier_car1_guard1 mission_blip3

//SNIPER POSITION LIL ROOF IN COURTYARD
CREATE_CHAR PEDTYPE_GANG_STREET BFYST -703.3905 -1573.1348 15.6165 sniper1
SET_CHAR_HEADING sniper1 312.8055 
GIVE_WEAPON_TO_CHAR	sniper1 WEAPONTYPE_SNIPERRIFLE 9999
CLEAR_CHAR_THREAT_SEARCH sniper1
SET_CHAR_THREAT_SEARCH sniper1 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH sniper1 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH sniper1 THREAT_GUN
SET_CHAR_PERSONALITY sniper1 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING sniper1 TRUE
SET_CHAR_OBJ_AIM_GUN_AT_CHAR sniper1 scplayer
SET_CHAR_STAY_IN_SAME_PLACE sniper1 TRUE
SET_CHAR_HEED_THREATS sniper1 TRUE

//SNIPER POSITION ON CRANE
CREATE_CHAR PEDTYPE_GANG_STREET BFYST -671.9470 -1553.9062 22.7296 sniper2
SET_CHAR_HEADING sniper2 3.9435 
GIVE_WEAPON_TO_CHAR	sniper2 WEAPONTYPE_SNIPERRIFLE 9999
CLEAR_CHAR_THREAT_SEARCH sniper2
SET_CHAR_THREAT_SEARCH sniper2 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH sniper2 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH sniper2 THREAT_GUN
SET_CHAR_PERSONALITY sniper2 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING sniper2 TRUE
SET_CHAR_OBJ_AIM_GUN_AT_CHAR sniper2 scplayer
SET_CHAR_STAY_IN_SAME_PLACE sniper2 TRUE
SET_CHAR_HEED_THREATS sniper2 TRUE

//SNIPER POSITION ON LIL ROOF ENTRANCE
CREATE_CHAR PEDTYPE_GANG_STREET BFYST -722.8923 -1528.6473 15.9040 sniper3
SET_CHAR_HEADING sniper3 331.8096 
GIVE_WEAPON_TO_CHAR	sniper3 WEAPONTYPE_SNIPERRIFLE 9999
CLEAR_CHAR_THREAT_SEARCH sniper3
SET_CHAR_THREAT_SEARCH sniper3 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH sniper3 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH sniper3 THREAT_GUN
SET_CHAR_PERSONALITY sniper3 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING sniper3 TRUE
SET_CHAR_OBJ_AIM_GUN_AT_CHAR sniper3 scplayer
SET_CHAR_STAY_IN_SAME_PLACE sniper3 TRUE
SET_CHAR_HEED_THREATS sniper3 TRUE

//SNIPER ON CORNER BUILDING
CREATE_CHAR PEDTYPE_GANG_STREET BFYST -728.5547 -1554.0133 21.8729 sniper4
SET_CHAR_HEADING sniper4 275.5398 
GIVE_WEAPON_TO_CHAR	sniper4 WEAPONTYPE_SNIPERRIFLE 9999
CLEAR_CHAR_THREAT_SEARCH sniper4
SET_CHAR_THREAT_SEARCH sniper4 THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH sniper4 THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH sniper4 THREAT_GUN
SET_CHAR_PERSONALITY sniper4 PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING sniper4 TRUE
SET_CHAR_OBJ_AIM_GUN_AT_CHAR sniper4 scplayer
SET_CHAR_STAY_IN_SAME_PLACE sniper4 TRUE
SET_CHAR_HEED_THREATS sniper4 TRUE

CREATE_CHAR PEDTYPE_GANG_STREET WFYRI -721.8732 -1500.1005 10.3946 docks_guard 
SET_CHAR_HEADING docks_guard 44.3659 
GIVE_WEAPON_TO_CHAR docks_guard WEAPONTYPE_SHOTGUN 9999
SET_CHAR_RUNNING docks_guard TRUE
SET_CHAR_PERSONALITY docks_guard PEDSTAT_TOUGH_GUY

//SET_CHAR_OBJ_FOLLOW_CHAR_IN_FORMATION CharID SecondCharID FormationPosition
//FORMATION_NONE//0
//FORMATION_BEHIND//1
//FORMATION_BACKLEFT//2
//FORMATION_BACKRIGHT//3
//FORMATION_FRONTLEFT//4
//FORMATION_FRONTRIGHT//5
//FORMATION_LEFT//6
//FORMATION_RIGHT//7
//FORMATION_FRONT//8


TIMERA = 3000
TIMERB = 3000

GOTO count2_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	CREATE_CAR MAVERICK 408.1980 -1726.1954 84.1376 courier_heli
count2_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check
	
mission_counter2_loop:

WAIT 0

GET_PLAYER_COORDINATES player1 player_x player_y player_z
GET_GAME_TIMER game_timer

++ frame_counter
IF frame_counter > 3
	frame_counter = 0
ENDIF

IF frame_counter = 0
	IF shoot_heli_down_flag = 0
		IF NOT IS_CAR_DEAD courier_heli
			IF IS_PLAYER_IN_CAR	player1 courier_heli
				IF NOT IS_CHAR_DEAD	sniper1
					GIVE_WEAPON_TO_CHAR	sniper1	WEAPONTYPE_SHOTGUN 999
					SET_CHAR_OBJ_DESTROY_CAR sniper1 courier_heli
				ENDIF
				IF NOT IS_CHAR_DEAD	sniper2
					GIVE_WEAPON_TO_CHAR	sniper2	WEAPONTYPE_SHOTGUN 999
					SET_CHAR_OBJ_DESTROY_CAR sniper2 courier_heli
				ENDIF
				shoot_heli_down_flag = 1
			ENDIF
		ENDIF
	ENDIF

	///courier_car1_guard1///////////////////////////////////////
	/////////////////////////////////////////////////////////////
	IF NOT IS_CHAR_DEAD courier_car1_guard1
		IF IS_CHAR_IN_ANY_CAR courier_car1_guard1
			
			MARK_CAR_AS_NO_LONGER_NEEDED courier_car1
			STORE_CAR_CHAR_IS_IN_NO_SAVE courier_car1_guard1 courier_car1
			GET_CAR_COORDINATES	courier_car1 courier_car1_x	courier_car1_y z
			
			IF car1_ped_in_car_flag = -1
				TIMERA = 0
				car1_ped_in_car_flag = 0
			ENDIF
			
			IF car1_ped_in_car_flag = 0
				IF courier_flag > 4
					IF TIMERA > 2500
						IF security_warning = 1
							SET_CAR_CRUISE_SPEED courier_car1 100.0
							courier_car1_speed = 100.0
							SET_CAR_DRIVING_STYLE courier_car1 2
							SET_CAR_MISSION courier_car1 MISSION_RAMPLAYER_FARAWAY
							car1_stuck_timer_start = game_timer
							car1_ped_in_car_flag = 1
							car1_stuck_flag = 0
							IF courier_flag = 7
								next_car_timer = game_timer + 250
								courier_flag = 8
							ENDIF
						ELSE
							IF courier_flag > 6
								SET_CAR_CRUISE_SPEED courier_car1 15.0
								courier_car1_speed = 15.0
								SET_CAR_DRIVING_STYLE courier_car1 2
								IF car1_location_counter = 0
									CAR_GOTO_COORDINATES courier_car1 -1133.0615 -342.2911 9.8989//INITIAL GOTO
								ELSE
									CAR_GOTO_COORDINATES_ACCURATE courier_car1 -963.9817 322.1035 10.1818 //CAR1 GOTO TRIAD BASE
								ENDIF
								car1_ped_in_car_flag = 2
								car1_stuck_flag = 0
								car1_stuck_timer_start = game_timer
								IF courier_flag = 7
									courier_flag = 8
									next_car_timer = game_timer + 750
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 courier_car1 15.0 15.0 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car1 FALSE
			ELSE
				SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car1 TRUE
			ENDIF
			
			IF IS_PLAYER_IN_CAR player1 courier_car1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard1 player1
			ENDIF

			IF car1_arrived_flag = 0
				IF LOCATE_CAR_2D courier_car1 -963.9817 322.1035 3.0 3.0 0 //TRIAD BASE
					car1_arrived_flag = 1
				ENDIF
			ENDIF
			
			IF car1_arrived_flag = 0
				IF NOT courier_car1_speed = 0.0
					
					gosub_stuck_car = courier_car1
					car_stuck_flag = car1_stuck_flag
					stuck_timer_start = car1_stuck_timer_start
					stuck_x = car1_stuck_x
					stuck_y = car1_stuck_y
					stuck_z = car1_stuck_z
					GOSUB car_stuck_checks
					car1_stuck_flag = car_stuck_flag
					car1_stuck_timer_start = stuck_timer_start
					car1_stuck_x = stuck_x
					car1_stuck_y = stuck_y
					car1_stuck_z = stuck_z
				
					IF car1_stuck_flag = -9
						SET_CHAR_OBJ_FLEE_CAR courier_car1_guard1 courier_car1
						car1_stuck_flag = 0
					ENDIF
		
				ENDIF
			ENDIF
				
			IF car1_ped_in_car_flag > 0

				GET_CAR_HEALTH courier_car1 courier_car1_health

				IF security_warning > 0
					IF car1_ped_in_car_flag = 2
						car1_ped_in_car_flag = 0
					ENDIF
				ENDIF

				IF courier_car1_health < 900
					IF security_warning = 0
						IF car1_ped_in_car_flag = 2
							car1_ped_in_car_flag = 0
							security_warning = 1
						ENDIF
					ENDIF
				ENDIF

				IF courier_car1_health < 300
					SET_CHAR_OBJ_FLEE_CAR courier_car1_guard1 courier_car1
				ENDIF

				GET_CAR_COORDINATES	courier_car1 courier_car1_x courier_car1_y z
				temp_float_x = courier_car1_x - -963.9817  //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
				temp_float_y = courier_car1_y - 322.1035
				temp_float_x = temp_float_x * temp_float_x
				temp_float_y = temp_float_y * temp_float_y
				temp_float_x = temp_float_x + temp_float_y
				SQRT temp_float_x courier_car1_distance
				
				IF security_warning = 0
					IF car1_location_counter = 0
						IF LOCATE_CAR_2D courier_car1 -1133.0615 -342.2911 10.0 10.0 0
							CAR_GOTO_COORDINATES_ACCURATE courier_car1 -963.9817 322.1035 10.1818 //CAR1 GOTO TRIAD BASE
							car1_location_counter = 1
						ENDIF
					ENDIF
					car1_distance_from_vehicle_behind = courier_car2_distance - courier_car1_distance
					IF car1_distance_from_vehicle_behind > 20.0
						SET_CAR_CRUISE_SPEED courier_car1 0.0
						SET_CAR_TEMP_ACTION courier_car1 TEMPACT_WAIT 100
						courier_car1_speed = 0.0
					ELSE
						SET_CAR_CRUISE_SPEED courier_car1 15.0
						courier_car1_speed = 15.0
					ENDIF
				ENDIF
				
				IF car1_ped_in_car_flag = 1
					IF NOT IS_PLAYER_IN_ANY_CAR	player1
						gosub_car_to_slow = courier_car1
						gosub_target_entity = -1
						GOSUB slow_car_if_close_to_entity
						courier_car1_speed = gosub_car_to_slow_speed
						IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 courier_car1 15.0 15.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard1 player1
						ENDIF
					ENDIF
				ENDIF
				GOSUB car1_group_breaking
			ENDIF
		ELSE
			car1_ped_in_car_flag = -1
			IF courier_flag > 4
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 courier_car1_guard1 40.0 40.0 0
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard1 player1
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 courier_car1_guard1 25.0 25.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard1 player1
						ELSE
							gosub_ped = courier_car1_guard1
							IF NOT IS_CAR_DEAD courier_car1
								IF LOCATE_CHAR_ANY_MEANS_CAR_2D	courier_car1_guard1	courier_car1 20.0 20.0 0
									SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier_car1_guard1 courier_car1
								ELSE
									GOSUB steal_a_car
								ENDIF
							ELSE
								GOSUB steal_a_car
							ENDIF
						ENDIF
					ENDIF
				ELSE
					gosub_ped = courier_car1_guard1
					IF NOT IS_CAR_DEAD courier_car1
						IF LOCATE_CHAR_ANY_MEANS_CAR_2D	courier_car1_guard1	courier_car1 20.0 20.0 0
							SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier_car1_guard1 courier_car1
						ELSE
							GOSUB steal_a_car
						ENDIF
					ELSE
						GOSUB steal_a_car
					ENDIF
				ENDIF
				GOSUB car1_group_breaking
			ENDIF
		ENDIF
	ELSE
		//REMOVE_BLIP mission_blip3
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard1
		IF NOT IS_CHAR_DEAD	courier_car1_guard2
			courier_car1_guard1 = courier_car1_guard2
			courier_car1_guard2 = -1
			//ADD_BLIP_FOR_CHAR courier_car1_guard1 mission_blip3
			IF NOT IS_CHAR_DEAD	courier_car1_guard3
				SET_CHAR_AS_LEADER courier_car1_guard3 courier_car1_guard1
				IF NOT IS_CHAR_IN_CHARS_GROUP courier_car1_guard3 courier_car1_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car1_guard3 player1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	courier_car1_guard4
				SET_CHAR_AS_LEADER courier_car1_guard4 courier_car1_guard1
				IF NOT IS_CHAR_IN_CHARS_GROUP courier_car1_guard4 courier_car1_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car1_guard4 player1
				ENDIF
			ENDIF

		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard2
			IF NOT IS_CHAR_DEAD	courier_car1_guard3
				courier_car1_guard1 = courier_car1_guard3
				courier_car1_guard3 = -1
				//ADD_BLIP_FOR_CHAR courier_car1_guard1 mission_blip3
				IF NOT IS_CHAR_DEAD	courier_car1_guard4
					SET_CHAR_AS_LEADER courier_car1_guard4 courier_car1_guard1
					IF NOT IS_CHAR_IN_CHARS_GROUP courier_car1_guard4 courier_car1_guard1
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car1_guard4 player1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard3
				IF NOT IS_CHAR_DEAD	courier_car1_guard4
					courier_car1_guard1 = courier_car1_guard4
					courier_car1_guard4 = -1
					//ADD_BLIP_FOR_CHAR courier_car1_guard1 mission_blip3
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard4
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

///DOCKS GUARDS STUFF////////////////////////////////////////
/////////////////////////////////////////////////////////////
IF frame_counter = 1
	IF courier_flag > 4
		IF NOT IS_CHAR_DEAD	courier_car1_guard1
			IF guard1_into_car_flag = 0
				IF NOT IS_CAR_DEAD courier_car1
					IF NOT IS_CHAR_DEAD	courier_car1_guard2
						SET_CHAR_AS_LEADER courier_car1_guard2 courier_car1_guard1
					ENDIF
					IF NOT IS_CHAR_DEAD	courier_car1_guard3
						SET_CHAR_AS_LEADER courier_car1_guard3 courier_car1_guard1
					ENDIF
					IF NOT IS_CHAR_DEAD	courier_car1_guard4
						SET_CHAR_AS_LEADER courier_car1_guard4 courier_car1_guard1
					ENDIF
					IF NOT IS_CHAR_IN_ANY_CAR courier_car1_guard1
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier_car1_guard1 courier_car1
						guard1_into_car_flag = 1
					ENDIF
				ELSE
					IF security_warning = 0
						security_warning = 1
					ENDIF
				ENDIF
			ELSE
				IF security_warning = 1
					IF IS_CHAR_IN_ANY_CAR courier_car1_guard1
						guard1_into_car_flag = 2
					ENDIF
					IF guard1_into_car_flag = 1
						SET_CHAR_OBJ_NO_OBJ	courier_car1_guard1
						CHAR_SET_IDLE courier_car1_guard1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard1 player1
						guard1_into_car_flag = 2
					ENDIF
				ENDIF
			ENDIF
		ELSE
			IF security_warning = 0
				security_warning = 1
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	courier_car3_guard1
			IF guard2_into_car_flag = 0
				IF NOT IS_CAR_DEAD courier_car3
					IF NOT IS_CHAR_DEAD	courier_car3_guard2
						SET_CHAR_AS_LEADER courier_car3_guard2 courier_car3_guard1
					ENDIF
					IF NOT IS_CHAR_DEAD	courier_car3_guard3
						SET_CHAR_AS_LEADER courier_car3_guard3 courier_car3_guard1
					ENDIF
					IF NOT IS_CHAR_DEAD	courier_car3_guard4
						SET_CHAR_AS_LEADER courier_car3_guard4 courier_car3_guard1
					ENDIF
					IF NOT IS_CHAR_IN_ANY_CAR courier_car3_guard1
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier_car3_guard1 courier_car3
						guard2_into_car_flag = 1
					ENDIF
				ELSE
					IF security_warning = 0
						security_warning = 1
					ENDIF
				ENDIF
			ELSE
				IF security_warning = 1
					IF IS_CHAR_IN_ANY_CAR courier_car3_guard1
						guard2_into_car_flag = 2
					ENDIF
					IF guard2_into_car_flag = 1
						SET_CHAR_OBJ_NO_OBJ	courier_car3_guard1
						CHAR_SET_IDLE courier_car3_guard1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard1 player1
						guard2_into_car_flag = 2
					ENDIF
				ENDIF
			ENDIF
		ELSE
			IF security_warning = 0
				security_warning = 1
			ENDIF
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD	docks_guard
		IF LOCATE_PLAYER_ON_FOOT_2D player1 -725.096 -1499.147 3.7 3.0 0
			IF docks_guard_counter = 0
				IF audio_4_flag = 0
					audio_4_flag = 1
					audio_4_timeout = game_timer + 6000
				ENDIF
				SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT docks_guard player1
				docks_guard_counter = 1
			ENDIF
		ELSE
			IF LOCATE_PLAYER_ON_FOOT_2D player1 -706.433 -1512.958 15.0 15.0 0
			OR LOCATE_PLAYER_ON_FOOT_2D player1 -723.606 -1515.598 15.0 15.0 0
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT docks_guard player1
			ELSE
				IF docks_guard_counter = 1
					SET_CHAR_OBJ_NO_OBJ	docks_guard
					docks_guard_counter = 0
				ENDIF
			ENDIF
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_2D player1 -725.096 -1499.147 3.7 3.0 0
			IF NOT docks_guard_counter = 2
				CLEAR_CHAR_THREAT_SEARCH docks_guard
				SET_CHAR_THREAT_SEARCH docks_guard THREAT_PLAYER1
				SET_CHAR_THREAT_SEARCH docks_guard THREAT_FAST_CAR
				SET_CHAR_THREAT_SEARCH docks_guard THREAT_GUN
				STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
				SET_CHAR_OBJ_DESTROY_CAR docks_guard players_car
				docks_guard_counter = 2
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED docks_guard
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	courier_car1_guard1
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard1
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard1 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car1_guard2
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard2
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard2 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car1_guard3
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard3
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard3 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car1_guard4
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard4
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car1_guard4 player1
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD	courier_car2_guard1
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car2_guard1
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car2_guard1 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car2_guard2
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car2_guard2
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car2_guard2 player1
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD	courier_car3_guard1
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard1
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard1 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car3_guard2
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard2
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard2 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car3_guard3
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard3
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard3 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	courier_car3_guard4
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard4
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard4 player1
		ENDIF
	ENDIF
	
	IF IS_CHAR_DEAD	sniper1
		MARK_CHAR_AS_NO_LONGER_NEEDED sniper1
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sniper1 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	sniper2
		MARK_CHAR_AS_NO_LONGER_NEEDED sniper2
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sniper2 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	sniper3
		MARK_CHAR_AS_NO_LONGER_NEEDED sniper3
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sniper3 player1
		ENDIF
	ENDIF
	IF IS_CHAR_DEAD	sniper4
		MARK_CHAR_AS_NO_LONGER_NEEDED sniper4
		IF security_warning = 0
			security_warning = 1
		ENDIF
	ELSE
		IF security_warning = 1
		AND courier_flag < 7
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT sniper4 player1
		ENDIF
	ENDIF

	///courier_stuff/////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	IF NOT IS_CHAR_DEAD	courier
		
		IF IS_CHAR_IN_ANY_CAR courier
			IF IS_CHAR_LEAVING_VEHICLE_TO_DIE courier
				courier_in_car = 0
			ELSE
				courier_in_car = 1
			ENDIF
		ELSE
			courier_in_car = 0
			IF flee_car_timer > game_timer
				GOSUB car2_occupants_kill_player
			ENDIF
		ENDIF
		
		IF courier_flag = 1
			IF LOCATE_CHAR_IN_CAR_3D courier -649.6716 -1590.7273 40.0 5.0 5.0 5.0 0
				IF NOT IS_CAR_DEAD courier_heli
					HELI_GOTO_COORDS courier_heli -664.9825 -1579.2522 25.0 15
				ENDIF
				courier_flag = 2
			ENDIF
		ENDIF

		IF courier_flag = 2
			IF LOCATE_CHAR_IN_CAR_3D courier -664.9825 -1579.2522 25.0 5.0 5.0 5.0 0
				IF NOT IS_CAR_DEAD courier_heli
					HELI_GOTO_COORDS courier_heli -679.1260 -1569.7916 17.7605 10
				ENDIF
				courier_flag = 3
			ENDIF
		ENDIF

		IF courier_flag = 3
			IF LOCATE_CHAR_IN_CAR_3D courier -679.1260 -1569.7916 17.7605 5.0 5.0 5.0 0
				IF NOT IS_CAR_DEAD courier_heli
					HELI_GOTO_COORDS courier_heli -683.1377 -1566.9713 11.4 5
				ENDIF
				courier_flag = 4
			ENDIF
		ENDIF

		IF courier_flag = 4
			IF NOT IS_CAR_DEAD courier_heli
				IF LOCATE_CHAR_ANY_MEANS_3D courier -683.1377 -1566.9713 11.4 3.0 3.0 3.0 0
					IF NOT IS_CAR_IN_AIR_PROPER	courier_heli
						IF NOT IS_CAR_DEAD courier_car2
							SET_CHAR_OBJ_LEAVE_ANY_CAR courier
							IF NOT IS_CHAR_DEAD	courier_car2_guard1
								SET_CHAR_AS_LEADER courier_car2_guard1 courier
							ENDIF
							IF NOT IS_CHAR_DEAD	courier_car2_guard2
								SET_CHAR_AS_LEADER courier_car2_guard2 courier
							ENDIF
							IF NOT IS_CHAR_DEAD	courier_car2_guard3
								SET_CHAR_AS_LEADER courier_car2_guard3 courier
							ENDIF
							courier_flag = 5
							PRINT_NOW CNT2_08 5000 1 //The courier with the plates has arrived at the docks.
							REMOVE_BLIP docks_blip
						ELSE
							IF NOT IS_CAR_DEAD courier_heli
								HELI_GOTO_COORDS courier_heli -679.1260 -1569.7916 17.7605 60
							ENDIF
							courier_flag = -1
							IF NOT security_warning = 1
								security_warning = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF courier_flag = 5
			IF NOT IS_CHAR_IN_ANY_CAR courier
				IF NOT IS_CAR_DEAD courier_car2
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier courier_car2
					courier_flag = 6
				ELSE
					IF audio_3_flag = 0
						audio_3_flag = 1
						audio_3_timeout = game_timer + 6000
					ENDIF
					IF NOT IS_CAR_DEAD courier_heli
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier courier_heli
						courier_flag = -1
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF courier_flag = 6
			IF IS_CHAR_IN_ANY_CAR courier
				courier_flag = 7
			ENDIF
		ENDIF

		IF courier_flag = -1
			IF NOT IS_CAR_DEAD courier_heli
				IF IS_CHAR_IN_CAR courier courier_heli
					HELI_GOTO_COORDS courier_heli -664.9825 -1579.2522 31.0306 60
					courier_flag = -2
				ENDIF
			ENDIF
		ENDIF

		IF courier_flag = -2
			IF LOCATE_CHAR_IN_CAR_3D courier -664.9825 -1579.2522 31.0306 5.0 5.0 5.0 0
				IF NOT IS_CAR_DEAD courier_heli
					HELI_GOTO_COORDS courier_heli -649.6716 -1590.7273 40.0 60
					PRINT_NOW CNT2_02 5000 1 //"The plates courier has fled."
					GOTO mission_counter2_failed
				ENDIF
			ENDIF
		ENDIF
		
		IF courier_flag2 = 1
			LEAVE_GROUP courier
			IF NOT IS_CHAR_DEAD	courier_car2_guard1
				LEAVE_GROUP courier_car2_guard1
			ENDIF
			IF NOT IS_CHAR_DEAD	courier_car2_guard2
				LEAVE_GROUP courier_car2_guard2
			ENDIF
			IF NOT IS_CHAR_DEAD	courier_car2_guard3
				LEAVE_GROUP courier_car2_guard3
			ENDIF
			SET_CHAR_OBJ_RUN_TO_COORD courier -973.9560 317.3278 //ON PATH END OF ALLEY
			SET_CHAR_USE_PEDNODE_SEEK courier FALSE
			courier_flag2 = 2
		ENDIF

		IF courier_flag2 = 2
			IF LOCATE_CHAR_ON_FOOT_2D courier -973.9560 317.3278 1.5 1.5 0 //ON PATH END OF ALLEY
				SET_CHAR_OBJ_RUN_TO_COORD courier -974.5215 266.5887 //ABOVE STEPS
				SET_CHAR_USE_PEDNODE_SEEK courier FALSE
				courier_flag2 = 3
			ENDIF
		ENDIF

		IF courier_flag2 = 3
			IF LOCATE_CHAR_ON_FOOT_2D courier -974.5215 266.5887 1.5 1.5 0 //ABOVE STEPS
				SET_CHAR_OBJ_RUN_TO_COORD courier -987.1808 266.6001 //BOTTOM STEPS
				SET_CHAR_USE_PEDNODE_SEEK courier FALSE
				courier_flag2 = 4
			ENDIF
		ENDIF

		IF courier_flag2 = 4
			IF LOCATE_STOPPED_CHAR_ON_FOOT_2D courier -987.1808 266.6001 1.5 1.5 0 //BOTTOM STEPS
				SET_CHAR_OBJ_GUARD_SPOT	courier	-987.1808 266.6001 7.7758
				GIVE_WEAPON_TO_CHAR	courier WEAPONTYPE_SHOTGUN 9999
				SET_CHAR_HEADING courier 270.0
				courier_flag2 = 5
			ENDIF
		ENDIF
	ELSE
		IF courier_in_car = 1
			PRINT_NOW CNT2_04 5000 1//"You destroyed the plates in the explosion!"
			GOTO mission_counter2_failed
		ELSE
			IF NOT IS_CHAR_IN_WATER	courier
				IF NOT security_warning = 1
					security_warning = 1
				ENDIF
				IF created_object_flag = 0
					REMOVE_BLIP mission_blip
					IF DOES_CHAR_EXIST courier
						GET_DEAD_CHAR_PICKUP_COORDS courier x y z
					ELSE
						PRINT_NOW CNT2_04 5000 1//"You destroyed the plates in the explosion!"
						GOTO mission_counter2_failed
					ENDIF
					CREATE_PICKUP briefcase PICKUP_ONCE x y z plates
					ADD_BLIP_FOR_PICKUP plates mission_blip
					PRINT_NOW CNT2_06 5000 1//The courier has died and dropped the plates, get to them before anyone else.
					courier_in_car = 2
					created_object_flag = 1
				ENDIF
			ELSE
				PRINT_NOW CNT2_11 5000 1//"~r~The plates are at the bottom of the sea!"
				GOTO mission_counter2_failed
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF courier_in_car = 2
	
	IF NOT HAS_PICKUP_BEEN_COLLECTED plates
		IF audio_2_flag = 0
			audio_2_flag = 1
			audio_2_timeout = game_timer + 6000
		ENDIF
		IF NOT IS_CHAR_DEAD	courier_car2_guard1
			LEAVE_GROUP	courier_car2_guard1
			SET_CHAR_OBJ_NO_OBJ	courier_car2_guard1
			SET_CHAR_OBJ_RUN_TO_COORD courier_car2_guard1 x y
			SET_CHAR_USE_PEDNODE_SEEK courier_car2_guard1 FALSE
			IF LOCATE_CHAR_ON_FOOT_2D courier_car2_guard1 x y 1.0 1.0 0
				REMOVE_BLIP	mission_blip
				REMOVE_PICKUP plates
				PRINT_NOW CNT2_07 5000 1//One of the guards has picked up the plates, don't let 'em get away.
				created_object_flag = 0
				courier = courier_car2_guard1
				courier_car2_guard1 = -1
				courier_in_car = 0
				courier_has_died = 1
				courier_flag2 = 0
				ADD_BLIP_FOR_CHAR courier mission_blip
				IF NOT IS_CAR_DEAD courier_car2
					IF IS_CAR_HEALTH_GREATER courier_car2 400
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier courier_car2
					ELSE
						gosub_ped = courier
						GOSUB steal_a_car
					ENDIF
				ELSE
					gosub_ped = courier
					GOSUB steal_a_car
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD	courier_car2_guard2
				LEAVE_GROUP	courier_car2_guard2
				SET_CHAR_OBJ_NO_OBJ	courier_car2_guard2
				SET_CHAR_OBJ_RUN_TO_COORD courier_car2_guard2 x y
				SET_CHAR_USE_PEDNODE_SEEK courier_car2_guard2 FALSE
				IF LOCATE_CHAR_ON_FOOT_2D courier_car2_guard2 x y 1.0 1.0 0
					REMOVE_BLIP	mission_blip
					REMOVE_PICKUP plates
					PRINT_NOW CNT2_07 5000 1//One of the guards has picked up the plates, don't let 'em get away.
					created_object_flag = 0
					courier = courier_car2_guard2
					courier_car2_guard2 = -1
					courier_in_car = 0
					courier_has_died = 1
					courier_flag2 = 0
					ADD_BLIP_FOR_CHAR courier mission_blip
					IF NOT IS_CAR_DEAD courier_car2
						IF IS_CAR_HEALTH_GREATER courier_car2 400
							SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier courier_car2
						ELSE
							gosub_ped = courier
							GOSUB steal_a_car
						ENDIF
					ELSE
						gosub_ped = courier
						GOSUB steal_a_car
					ENDIF
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD	courier_car2_guard3
					LEAVE_GROUP	courier_car2_guard3
					SET_CHAR_OBJ_NO_OBJ	courier_car2_guard3
					SET_CHAR_OBJ_RUN_TO_COORD courier_car2_guard3 x y
					SET_CHAR_USE_PEDNODE_SEEK courier_car2_guard3 FALSE
					IF LOCATE_CHAR_ON_FOOT_2D courier_car2_guard3 x y 1.0 1.0 0
						REMOVE_BLIP	mission_blip
						REMOVE_PICKUP plates
						PRINT_NOW CNT2_07 5000 1//One of the guards has picked up the plates, don't let 'em get away.
						created_object_flag = 0
						courier = courier_car2_guard3
						courier_car2_guard3 = -1
						courier_in_car = 0
						courier_has_died = 1
						courier_flag2 = 0
						ADD_BLIP_FOR_CHAR courier mission_blip
						IF NOT IS_CAR_DEAD courier_car2
							IF IS_CAR_HEALTH_GREATER courier_car2 400
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier courier_car2
							ELSE
								gosub_ped = courier
								GOSUB steal_a_car
							ENDIF
						ELSE
							gosub_ped = courier
							GOSUB steal_a_car
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		courier_in_car = 3
	ENDIF
ENDIF

IF courier_has_died = 1
AND	courier_in_car = 1
	IF NOT IS_CHAR_DEAD	courier
		MARK_CAR_AS_NO_LONGER_NEEDED courier_car2
		courier_car2 = -1
		STORE_CAR_CHAR_IS_IN courier courier_car2
		SET_CAR_CRUISE_SPEED courier_car2 15.0
		courier_car2_speed = 15.0
		SET_CAR_DRIVING_STYLE courier_car2 2
		IF car2_location_counter = 0
			CAR_GOTO_COORDINATES courier_car2 -1133.0615 -342.2911 9.8989//INITIAL GOTO
		ELSE
			CAR_GOTO_COORDINATES_ACCURATE courier_car2 -971.6564 322.1157 10.1667 //CAR2 GOTO TRIAD BASE
		ENDIF
		car2_stuck_flag = 0
		car2_stuck_timer_start = game_timer
		courier_has_died = 0
	ENDIF
ENDIF

IF courier_in_car = 3
	REMOVE_BLIP mission_blip
	ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
	PRINT_NOW CNT2_05 5000 1 //"You have the countfeit plates."
	ADD_BLIP_FOR_COORD counterX counterY counterZ mission_blip
	courier_in_car = 4
ENDIF

IF courier_in_car = 4
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 counterX counterY counterZ 1.5 2.0 2.0 1//Drop off at Printworks
		GOTO mission_counter2_passed
	ENDIF
ENDIF

IF courier_flag > 6
	IF NOT IS_CHAR_DEAD	sniper1
		IF NOT IS_CAR_DEAD courier_heli
			IF fly_heli_away_flag = 0
				IF NOT IS_PLAYER_IN_CAR	player1 courier_heli
					IF LOCATE_CAR_3D courier_heli -683.1377 -1566.9713 11.4 4.0 4.0 4.0 0
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER sniper1 courier_heli
						fly_heli_away_flag = 1
					ENDIF
				ENDIF
			ENDIF
			IF fly_heli_away_flag = 1
				IF IS_CHAR_IN_CAR sniper1 courier_heli
					HELI_GOTO_COORDS courier_heli 408.1980 -1726.1954 84.1376 50
					MARK_CAR_AS_NO_LONGER_NEEDED courier_heli
					MARK_CHAR_AS_NO_LONGER_NEEDED sniper1
					MARK_CHAR_AS_NO_LONGER_NEEDED sniper2
					MARK_CHAR_AS_NO_LONGER_NEEDED sniper3
					MARK_CHAR_AS_NO_LONGER_NEEDED sniper4
					MARK_CHAR_AS_NO_LONGER_NEEDED docks_guard
					fly_heli_away_flag = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF


///courier_car2//////////////////////////////////////////////
/////////////////////////////////////////////////////////////
IF frame_counter = 2
	IF NOT IS_CAR_DEAD courier_car2
		GET_CAR_COORDINATES	courier_car2 courier_car2_x courier_car2_y z
		
		///SHOOTING FROM courier_car2////////////////////////////////
		IF shoot_from_car = 1
			IF shoot_from_car_counter = 1
				shoot_from_car_counter = 2
			ENDIF
			IF shoot_from_car_counter = 0
				IF game_timer > shoot_from_car_timer
					IF NOT IS_CHAR_DEAD	courier_car2_guard3
						IF IS_CHAR_IN_CAR courier_car2_guard3 courier_car2
							shooting_char = courier_car2_guard3
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD	courier_car2_guard2
						IF IS_CHAR_IN_CAR courier_car2_guard2 courier_car2
							shooting_char = courier_car2_guard2
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD	courier_car2_guard1
						IF IS_CHAR_IN_CAR courier_car2_guard1 courier_car2
							shooting_char = courier_car2_guard1
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD	shooting_char
						IF IS_CHAR_IN_CAR shooting_char courier_car2
							GET_CAR_COORDINATES	courier_car2 x y z
							WARP_CHAR_FROM_CAR_TO_COORD	shooting_char x y -10.0
							shoot_from_car_counter = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			IF shoot_from_car_counter = 3
				IF NOT IS_CHAR_DEAD	shooting_char
					IF IS_PLAYER_IN_ANY_CAR	player1
						STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
						SET_CHAR_OBJ_DESTROY_CAR shooting_char players_car
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shooting_char player1
					ENDIF
				ELSE
					shoot_from_car = 0
				ENDIF
			ENDIF
			IF shoot_from_car_counter = 2
				IF NOT IS_CHAR_DEAD	shooting_char
					ATTACH_CHAR_TO_CAR shooting_char courier_car2 0.0 -0.3 0.8 FACING_BACK 360.0 WEAPONTYPE_TEC9
					shoot_from_car_counter = 3
				ENDIF
			ENDIF
		ELSE
			IF shoot_from_car_counter > 0
				IF NOT IS_CHAR_DEAD	shooting_char
					DETACH_CHAR_FROM_CAR shooting_char
					passenger_seat = 0
					WHILE NOT IS_CAR_PASSENGER_SEAT_FREE courier_car2 passenger_seat
						++ passenger_seat
					ENDWHILE
					IF shooting_char = courier_car2_guard1
						DELETE_CHAR	courier_car2_guard1
						CREATE_CHAR_AS_PASSENGER courier_car2 PEDTYPE_GANG_STREET WFORI passenger_seat courier_car2_guard1
						shooting_char = courier_car2_guard1
					ENDIF
					IF shooting_char = courier_car2_guard2
						DELETE_CHAR	courier_car2_guard2
						CREATE_CHAR_AS_PASSENGER courier_car2 PEDTYPE_GANG_STREET WFYBU passenger_seat courier_car2_guard2
						shooting_char = courier_car2_guard2
					ENDIF
					IF shooting_char = courier_car2_guard3
						DELETE_CHAR	courier_car2_guard3
						CREATE_CHAR_AS_PASSENGER courier_car2 PEDTYPE_GANG_STREET WFORI passenger_seat courier_car2_guard3
						shooting_char = courier_car2_guard3
					ENDIF
					GIVE_WEAPON_TO_CHAR	shooting_char WEAPONTYPE_TEC9 9999
					CLEAR_CHAR_THREAT_SEARCH shooting_char
					SET_CHAR_THREAT_SEARCH shooting_char THREAT_PLAYER1
					SET_CHAR_THREAT_SEARCH shooting_char THREAT_FAST_CAR
					SET_CHAR_THREAT_SEARCH shooting_char THREAT_GUN
					SET_CHAR_PERSONALITY shooting_char PEDSTAT_TOUGH_GUY
					SET_CHAR_RUNNING shooting_char TRUE
					shoot_from_car_timer = game_timer + 500
					shoot_from_car_counter = 0
				ELSE
					DETACH_CHAR_FROM_CAR shooting_char
					shoot_from_car_counter = 0
				ENDIF
			ENDIF
		ENDIF

		IF NOT IS_CHAR_DEAD	courier
			IF IS_CHAR_IN_CAR courier courier_car2
				IF security_warning = 1
					courier_flag = 8
				ENDIF
			ENDIF
		ENDIF
		
		IF courier_flag = 8
			IF game_timer > next_car_timer
			OR security_warning = 1
				SET_CAR_CRUISE_SPEED courier_car2 15.0
				courier_car2_speed = 15.0
				SET_CAR_DRIVING_STYLE courier_car2 2
				IF car2_location_counter = 0
					CAR_GOTO_COORDINATES courier_car2 -1133.0615 -342.2911 9.8989//INITIAL GOTO
					MARK_CHAR_AS_NO_LONGER_NEEDED docks_guard
				ELSE
					CAR_GOTO_COORDINATES_ACCURATE courier_car2 -971.6564 322.1157 10.1667 //CAR2 GOTO TRIAD BASE
				ENDIF
				car2_stuck_flag = 0
				car2_stuck_timer_start = game_timer
				next_car_timer = game_timer + 750
				courier_flag = 9
			ENDIF
		ENDIF
			
		IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 courier_car2 15.0 15.0 0
			SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car2 FALSE
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car2 TRUE
		ENDIF
			
		IF car2_location_counter = 0
			IF LOCATE_CAR_2D courier_car2 -1133.0615 -342.2911 10.0 10.0 0
				CAR_GOTO_COORDINATES_ACCURATE courier_car2 -971.6564 322.1157 10.1667 //CAR2 GOTO TRIAD BASE
				car2_location_counter = 1
			ENDIF
		ENDIF
		
		IF courier_flag > 8
			
			IF car2_arrived_flag = 0
				IF LOCATE_CAR_2D courier_car2 -971.6564 322.1157 3.0 3.0 0 //TRIAD BASE
					car2_arrived_flag = 1
				ENDIF
			ENDIF

			IF car2_arrived_flag = 0
				IF NOT courier_car2_speed = 0.0
					gosub_stuck_car = courier_car2
					car_stuck_flag = car2_stuck_flag
					stuck_timer_start = car2_stuck_timer_start
					stuck_x = car2_stuck_x
					stuck_y = car2_stuck_y
					stuck_z = car2_stuck_z
					GOSUB car_stuck_checks
					car2_stuck_flag = car_stuck_flag
					car2_stuck_timer_start = stuck_timer_start
					car2_stuck_x = stuck_x
					car2_stuck_y = stuck_y
					car2_stuck_z = stuck_z

					IF security_warning > 0
						IF car2_stuck_flag = -9
							IF NOT IS_CHAR_DEAD	courier
								SET_CHAR_OBJ_FLEE_CAR courier courier_car2
							ENDIF
							car2_stuck_flag = 0
						ENDIF
					ENDIF
				ENDIF
			ELSE
				IF courier_flag2 = 0
					courier_flag2 = 1
				ENDIF
			ENDIF
		ENDIF
		
		GET_CAR_HEALTH courier_car2 courier_car2_health

		IF courier_car2_health < 990
			IF security_warning = 0
				security_warning = 1
			ENDIF
		ENDIF
		
		IF courier_flag > 8
			IF courier_car2_health < 300
				SET_CAR_CRUISE_SPEED courier_car2 0.0
				SET_CAR_TEMP_ACTION courier_car2 TEMPACT_WAIT 100
				courier_car2_speed = 0.0
				IF NOT IS_CHAR_DEAD	courier
					SET_CHAR_OBJ_FLEE_CAR courier courier_car2
				ENDIF
				flee_car_timer = game_timer	+ 5000
				security_warning = 1
			ENDIF
		
			IF security_warning = 0
				IF NOT IS_CAR_DEAD courier_car1
					gosub_car_to_slow = courier_car2
					gosub_target_entity = courier_car1
					GOSUB slow_car_if_close_to_entity
					courier_car2_speed = gosub_car_to_slow_speed
					
					//THIS BIT OF CODE CHECKS TO SEE HOW FAR THE CAR IS FROM THE DESTINATION
					GET_CAR_COORDINATES	courier_car2 courier_car2_x courier_car2_y z
					temp_float_x = courier_car2_x - -963.9817 //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
					temp_float_y = courier_car2_y - 322.1035
					temp_float_x = temp_float_x * temp_float_x
					temp_float_y = temp_float_y * temp_float_y
					temp_float_x = temp_float_x + temp_float_y
					SQRT temp_float_x courier_car2_distance
					
					//THIS BIT OF CODE CHECKS TO SEE IF CAR1 IS INFRONT OF CAR2
					GET_CAR_FORWARD_X courier_car2 forward_x
					GET_CAR_FORWARD_Y courier_car2 forward_y
					IF NOT IS_CAR_DEAD courier_car1
						GET_CAR_COORDINATES courier_car1 courier_car1_x	courier_car1_y z
					ENDIF
					GET_CAR_COORDINATES	courier_car2 courier_car2_x courier_car2_y z
					// IF (((forward_x * (car2_x - car1_x)) + (forward_y * (car2_y - car1_y)>) IS GREATER THAN 0.0 CAR IS IN FRONT
					temp_float_x = courier_car2_x - courier_car1_x
					forward_x = forward_x * temp_float_x
					temp_float_y = courier_car2_y - courier_car1_y
					forward_y = forward_y * temp_float_y
					sum_x_y_temp = forward_x + forward_y
					temp_y = courier_car1_y	- 20.0
					IF sum_x_y_temp > 0.0// +=INFRONT  -=BEHIND
						IF courier_car2_y > temp_y
							SET_CAR_CRUISE_SPEED courier_car2 0.0
							SET_CAR_TEMP_ACTION courier_car2 TEMPACT_WAIT 100
							courier_car2_speed = 0.0
						ENDIF
					ENDIF
				ELSE
					SET_CAR_CRUISE_SPEED courier_car2 15.0
					courier_car2_speed = 15.0
				ENDIF

				car2_distance_from_vehicle_behind = courier_car3_distance - courier_car2_distance
				IF car2_distance_from_vehicle_behind > 20.0
					SET_CAR_CRUISE_SPEED courier_car2 0.0
					SET_CAR_TEMP_ACTION courier_car2 TEMPACT_WAIT 100
					courier_car2_speed = 0.0
				ELSE
					SET_CAR_CRUISE_SPEED courier_car2 15.0
					courier_car2_speed = 15.0
				ENDIF
			ENDIF
			
			IF security_warning = 1
				x_temp = player_x - courier_car2_x //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
				y_temp = player_y - courier_car2_y
				x_temp = x_temp * x_temp
				y_temp = y_temp * y_temp
				sum_x_y_temp = x_temp + y_temp
				SQRT sum_x_y_temp sum_x_y_temp
				
				courier_car2_speed = 1000.0 / sum_x_y_temp

				IF courier_car2_speed > 50.0
					courier_car2_speed = 50.0
				ENDIF
				IF courier_car2_speed < 20.0
					courier_car2_speed = 20.0
				ENDIF
				SET_CAR_CRUISE_SPEED courier_car2 courier_car2_speed
				IF LOCATE_PLAYER_IN_CAR_CAR_2D player1 courier_car2 20.0 20.0 0
					IF IS_CAR_UPRIGHT courier_car2
						IF NOT IS_CAR_STOPPED courier_car2
							IF courier_car2_speed > 15.0
								IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON courier_car2 WEAPONTYPE_RAMMEDBYCAR
								AND NOT IS_CAR_HEALTH_GREATER courier_car2 courier_car2_health_shoot
									shoot_from_car = 0
								ELSE
									shoot_from_car = 1
								ENDIF
								CLEAR_CAR_LAST_WEAPON_DAMAGE courier_car2
								GET_CAR_HEALTH courier_car2 courier_car2_health_shoot
								courier_car2_health_shoot -= 25
							ELSE
								shoot_from_car = 0
							ENDIF
						ELSE
							shoot_from_car = 0
						ENDIF
					ELSE
						shoot_from_car = 0
					ENDIF
				ELSE
					shoot_from_car = 0
				ENDIF
			ELSE
				shoot_from_car = 0
			ENDIF
		ELSE
			shoot_from_car = 0
		ENDIF
	ELSE
		DETACH_CHAR_FROM_CAR courier_car2_guard1
		DETACH_CHAR_FROM_CAR courier_car2_guard2
		DETACH_CHAR_FROM_CAR courier_car2_guard3
		shoot_from_car = 0
	ENDIF
ENDIF

///courier_car3_guard1///////////////////////////////////////
/////////////////////////////////////////////////////////////
IF frame_counter = 3
	IF NOT IS_CHAR_DEAD courier_car3_guard1
		IF IS_CHAR_IN_ANY_CAR courier_car3_guard1
			
			MARK_CAR_AS_NO_LONGER_NEEDED courier_car3
			STORE_CAR_CHAR_IS_IN_NO_SAVE courier_car3_guard1 courier_car3

			GET_CAR_COORDINATES	courier_car3 courier_car3_x	courier_car3_y z
			
			IF car3_ped_in_car_flag = -1
				TIMERB = 0
				car3_ped_in_car_flag = 0
			ENDIF

			IF courier_flag = 9
				IF game_timer > next_car_timer
					SET_CAR_CRUISE_SPEED courier_car3 15.0
					courier_car3_speed = 15.0
					SET_CAR_DRIVING_STYLE courier_car3 2
					IF car3_location_counter = 0
						CAR_GOTO_COORDINATES courier_car3 -1133.0615 -342.2911 9.8989//INITIAL GOTO
					ELSE
						CAR_GOTO_COORDINATES_ACCURATE courier_car3 -984.1348 322.0096 10.1792 //CAR3 GOTO
					ENDIF
					car3_stuck_flag = 0
					car3_stuck_timer_start = game_timer
					courier_flag = 10
				ENDIF
			ENDIF
			
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 courier_car3 15.0 15.0 0
				SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car3 FALSE
			ELSE
				SET_CAR_ONLY_DAMAGED_BY_PLAYER courier_car3 TRUE
			ENDIF
			
			IF car3_ped_in_car_flag = 0
				IF courier_flag > 4
				OR security_warning = 1
					IF TIMERB > 2500
						IF security_warning = 1
							SET_CAR_CRUISE_SPEED courier_car3 100.0
							courier_car3_speed = 100.0
							SET_CAR_DRIVING_STYLE courier_car3 2
							SET_CAR_MISSION courier_car3 MISSION_RAMPLAYER_FARAWAY
							car3_stuck_timer_start = game_timer
							car3_ped_in_car_flag = 1
						ELSE
							IF courier_flag > 9
								SET_CAR_CRUISE_SPEED courier_car3 15.0
								courier_car3_speed = 15.0
								SET_CAR_DRIVING_STYLE courier_car3 2
								IF car3_location_counter = 0
									CAR_GOTO_COORDINATES courier_car3 -1133.0615 -342.2911 9.8989//INITIAL GOTO
								ELSE
									CAR_GOTO_COORDINATES_ACCURATE courier_car3 -984.1348 322.0096 10.1792 //CAR3 GOTO
								ENDIF
								car3_ped_in_car_flag = 2
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			
			IF car3_ped_in_car_flag > 0

				IF IS_PLAYER_IN_CAR player1 courier_car3
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard1 player1
				ENDIF

				IF courier_flag > 9
					IF car3_arrived_flag = 0
						IF LOCATE_CAR_2D courier_car3 -984.1348 322.0096 3.0 3.0 0 //Triad Base
							car3_arrived_flag = 1
						ENDIF
					ENDIF
					IF car3_arrived_flag = 0
						IF NOT courier_car3_speed = 0.0
							gosub_stuck_car = courier_car3
							car_stuck_flag = car3_stuck_flag
							stuck_timer_start = car3_stuck_timer_start
							stuck_x = car3_stuck_x
							stuck_y = car3_stuck_y
							stuck_z = car3_stuck_z
							GOSUB car_stuck_checks
							car3_stuck_flag = car_stuck_flag
							car3_stuck_timer_start = stuck_timer_start
							car3_stuck_x = stuck_x
							car3_stuck_y = stuck_y
							car3_stuck_z = stuck_z
							
							IF car3_stuck_flag = -9
								SET_CHAR_OBJ_FLEE_CAR courier_car3_guard1 courier_car3
								car3_stuck_flag = 0
							ENDIF
						ENDIF
					ENDIF
			
					IF security_warning = 0
						IF car3_location_counter = 0
							IF LOCATE_CAR_2D courier_car3 -1133.0615 -342.2911 10.0 10.0 0
								CAR_GOTO_COORDINATES_ACCURATE courier_car3 -984.1348 322.0096 10.1792 //car3 GOTO TRIAD BASE
								car3_location_counter = 1
							ENDIF
						ENDIF
						gosub_car_to_slow = courier_car3
						gosub_target_entity = courier_car2
						GOSUB slow_car_if_close_to_entity
						courier_car3_speed = gosub_car_to_slow_speed
					ENDIF
				ENDIF
				
				GET_CAR_HEALTH courier_car3 courier_car3_health

				IF security_warning = 1
					IF car3_ped_in_car_flag = 2
						car3_ped_in_car_flag = 0
					ENDIF
				ELSE
					//THIS BIT OF CODE CHECKS TO SEE IF CAR3 IS INFRONT OF CAR2
					GET_CAR_FORWARD_X courier_car3 forward_x
					GET_CAR_FORWARD_Y courier_car3 forward_y
					IF NOT IS_CAR_DEAD courier_car2
						GET_CAR_COORDINATES courier_car2 courier_car2_x	courier_car2_y z
					ENDIF
					GET_CAR_COORDINATES	courier_car3 courier_car3_x courier_car3_y z
					// IF (((forward_x * (car3_x - car2_x)) + (forward_y * (car3_y - car2_y)>) IS GREATER THAN 0.0 CAR3 IS IN FRONT
					temp_float_x = courier_car3_x - courier_car2_x
					forward_x = forward_x * temp_float_x
					temp_float_y = courier_car3_y - courier_car2_y
					forward_y = forward_y * temp_float_y
					sum_x_y_temp = forward_x + forward_y
					temp_y = courier_car2_y	- 20.0
					IF sum_x_y_temp > 0.0// +=INFRONT  -=BEHIND
						IF courier_car3_y > temp_y
							SET_CAR_CRUISE_SPEED courier_car3 0.0
							SET_CAR_TEMP_ACTION courier_car3 TEMPACT_WAIT 100
							courier_car3_speed = 0.0
						ENDIF
					ENDIF
				ENDIF

				IF courier_car3_health < 900
					IF security_warning = 0
						IF car3_ped_in_car_flag = 2
							car3_ped_in_car_flag = 0
							security_warning = 1
						ENDIF
					ENDIF
				ENDIF

				IF courier_car3_health < 300
					SET_CHAR_OBJ_FLEE_CAR courier_car3_guard1 courier_car3
				ENDIF
				
				IF car3_ped_in_car_flag = 1
					IF NOT IS_PLAYER_IN_ANY_CAR	player1
						gosub_car_to_slow = courier_car3
						gosub_target_entity = -1
						GOSUB slow_car_if_close_to_entity
						courier_car3_speed = gosub_car_to_slow_speed
						IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 courier_car3 15.0 15.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard1 player1
						ENDIF
					ENDIF
				ENDIF
				GOSUB car3_group_breaking
			ENDIF
		ELSE
			car3_ped_in_car_flag = -1
			IF courier_flag > 4
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 courier_car3_guard1 40.0 40.0 0
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard1 player1
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 courier_car3_guard1 25.0 25.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car3_guard1 player1
						ELSE
							gosub_ped = courier_car3_guard1
							IF NOT IS_CAR_DEAD courier_car3
								IF LOCATE_CHAR_ANY_MEANS_CAR_2D	courier_car3_guard1	courier_car3 20.0 20.0 0
									SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier_car3_guard1 courier_car3
								ELSE
									GOSUB steal_a_car
								ENDIF
							ELSE
								GOSUB steal_a_car
							ENDIF
						ENDIF
					ENDIF
				ELSE
					gosub_ped = courier_car3_guard1
					IF NOT IS_CAR_DEAD courier_car3
						IF LOCATE_CHAR_ANY_MEANS_CAR_2D	courier_car3_guard1	courier_car3 20.0 20.0 0
							SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER courier_car3_guard1 courier_car3
						ELSE
							GOSUB steal_a_car
						ENDIF
					ELSE
						GOSUB steal_a_car
					ENDIF
				ENDIF
				GOSUB car3_group_breaking
			ENDIF
		ENDIF
	ELSE
		//REMOVE_BLIP	mission_blip2
		MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard1
		IF NOT IS_CHAR_DEAD	courier_car3_guard2
			courier_car3_guard1 = courier_car3_guard2
			courier_car3_guard2 = -1
			//ADD_BLIP_FOR_CHAR courier_car3_guard1 mission_blip2
			IF NOT IS_CHAR_DEAD	courier_car3_guard3
				SET_CHAR_AS_LEADER courier_car3_guard3 courier_car3_guard1
				IF NOT IS_CHAR_IN_CHARS_GROUP courier_car3_guard3 courier_car3_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car3_guard3 player1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	courier_car3_guard4
				SET_CHAR_AS_LEADER courier_car3_guard4 courier_car3_guard1
				IF NOT IS_CHAR_IN_CHARS_GROUP courier_car3_guard4 courier_car3_guard1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car3_guard4 player1
				ENDIF
			ENDIF

		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard2
			IF NOT IS_CHAR_DEAD	courier_car3_guard3
				courier_car3_guard1 = courier_car3_guard3
				courier_car3_guard3 = -1 
				//ADD_BLIP_FOR_CHAR courier_car3_guard1 mission_blip2
				IF NOT IS_CHAR_DEAD	courier_car3_guard4
					SET_CHAR_AS_LEADER courier_car3_guard4 courier_car3_guard1
					IF NOT IS_CHAR_IN_CHARS_GROUP courier_car3_guard4 courier_car3_guard1
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car3_guard4 player1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard3
				IF NOT IS_CHAR_DEAD	courier_car3_guard4
					courier_car3_guard1 = courier_car3_guard4
					courier_car3_guard4 = -1
					//ADD_BLIP_FOR_CHAR courier_car3_guard1 mission_blip2
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard4
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF car2_location_counter = 1
		IF sniper_dudes_counter = 0
			MARK_CHAR_AS_NO_LONGER_NEEDED sniper1
			CREATE_CHAR PEDTYPE_GANG_STREET BFYST -987.1808 266.6001 7.7758 sniper1
			GIVE_WEAPON_TO_CHAR	sniper1 WEAPONTYPE_SHOTGUN 9999
			CLEAR_CHAR_THREAT_SEARCH sniper1
			SET_CHAR_THREAT_SEARCH sniper1 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH sniper1 THREAT_FAST_CAR
			SET_CHAR_THREAT_SEARCH sniper1 THREAT_GUN
			SET_CHAR_PERSONALITY sniper1 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING sniper1 TRUE
			SET_ANIM_GROUP_FOR_CHAR sniper1 ANIM_SEXY_WOMANPED

			MARK_CHAR_AS_NO_LONGER_NEEDED sniper2
			CREATE_CHAR PEDTYPE_GANG_STREET BFYST -985.7646 266.4785 7.7755 sniper2
			GIVE_WEAPON_TO_CHAR	sniper2 WEAPONTYPE_SHOTGUN 9999
			CLEAR_CHAR_THREAT_SEARCH sniper2
			SET_CHAR_THREAT_SEARCH sniper2 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH sniper2 THREAT_FAST_CAR
			SET_CHAR_THREAT_SEARCH sniper2 THREAT_GUN
			SET_CHAR_PERSONALITY sniper2 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING sniper2 TRUE
			SET_ANIM_GROUP_FOR_CHAR sniper2 ANIM_SEXY_WOMANPED

			MARK_CHAR_AS_NO_LONGER_NEEDED sniper3
			CREATE_CHAR PEDTYPE_GANG_STREET BFYST -984.2117 266.6248 7.7751 sniper3
			GIVE_WEAPON_TO_CHAR	sniper3 WEAPONTYPE_SHOTGUN 9999
			CLEAR_CHAR_THREAT_SEARCH sniper3
			SET_CHAR_THREAT_SEARCH sniper3 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH sniper3 THREAT_FAST_CAR
			SET_CHAR_THREAT_SEARCH sniper3 THREAT_GUN
			SET_CHAR_PERSONALITY sniper3 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING sniper3 TRUE
			SET_ANIM_GROUP_FOR_CHAR sniper3 ANIM_SEXY_WOMANPED

			MARK_CHAR_AS_NO_LONGER_NEEDED sniper4
			CREATE_CHAR PEDTYPE_GANG_STREET BFYST -982.5906 266.5252 7.7803 sniper4
			GIVE_WEAPON_TO_CHAR	sniper4 WEAPONTYPE_SHOTGUN 9999
			CLEAR_CHAR_THREAT_SEARCH sniper4
			SET_CHAR_THREAT_SEARCH sniper4 THREAT_PLAYER1
			SET_CHAR_THREAT_SEARCH sniper4 THREAT_FAST_CAR
			SET_CHAR_THREAT_SEARCH sniper4 THREAT_GUN
			SET_CHAR_PERSONALITY sniper4 PEDSTAT_TOUGH_GUY
			SET_CHAR_RUNNING sniper4 TRUE
			SET_ANIM_GROUP_FOR_CHAR sniper4 ANIM_SEXY_WOMANPED
			sniper_dudes_counter = 1
		ENDIF
	ENDIF

	IF sniper_dudes_counter = 1
		cnt2_left_door_heading += 3.0
		IF cnt2_left_door_heading > 90.0
			cnt2_left_door_heading = 90.0
		ENDIF
		SET_OBJECT_HEADING cnt2_left_door cnt2_left_door_heading

		cnt2_right_door_heading -= 3.0
		IF cnt2_right_door_heading < 0.0
			cnt2_right_door_heading += 360.0
		ENDIF
		IF cnt2_right_door_heading < 270.0
			cnt2_right_door_heading = 270.0
		ENDIF
		SET_OBJECT_HEADING cnt2_right_door cnt2_right_door_heading
		IF cnt2_left_door_heading = 90.0
		AND	cnt2_right_door_heading = 270.0	
			sniper_dudes_counter = 2
		ENDIF
		//IS_PLAYER_IN_AREA_3D player1 -991.591 261.036 7.775 -981.068 271.96 11.506 0 //DONT CLOSE DOOR
		//IS_CHAR_IN_AREA_3D courier -991.591 261.036 7.775 -983.0 271.96 11.506 0 //CLOSE DOOR
	ENDIF

	IF sniper_dudes_counter = 2
		IF NOT IS_CHAR_DEAD	courier
			IF IS_CHAR_IN_AREA_3D courier -991.591 261.036 7.775 -983.0 271.96 11.506 0
				IF NOT IS_PLAYER_IN_AREA_3D player1 -991.591 261.036 7.775 -981.068 271.96 11.506 0
					cnt2_left_door_heading -= 3.0
					IF cnt2_left_door_heading < 0.0
						cnt2_left_door_heading = 0.0
					ENDIF
					SET_OBJECT_HEADING cnt2_left_door cnt2_left_door_heading
					cnt2_right_door_heading += 3.0
					IF cnt2_right_door_heading > 360.0
						cnt2_right_door_heading = 0.0
					ENDIF
					SET_OBJECT_HEADING cnt2_right_door cnt2_right_door_heading

					IF cnt2_left_door_heading = 0.0
					AND	cnt2_right_door_heading = 0.0	
						PRINT_NOW CNT2_03 5000 1//"The courier has arrived at his destination safely, you're too late!"
						DELETE_CHAR courier
						GOTO mission_counter2_failed
					ENDIF
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	sniper1
			IF sniper1_flag = 0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	sniper1	-973.5972 266.4069
				IF LOCATE_CHAR_ON_FOOT_2D sniper1 -973.5972 266.4069 1.0 1.0 0
					sniper1_flag = 1
				ENDIF
			ENDIF
			IF sniper1_flag = 1
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT sniper1 -974.2487 262.6737
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D sniper1 -974.2487 262.6737 1.0 1.0 0
					SET_CHAR_OBJ_GUARD_SPOT	sniper1	-974.2487 262.6737 10.2265
					SET_CHAR_HEADING sniper1 321.3187
					sniper1_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	sniper2
			IF sniper2_flag = 0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	sniper2	-973.5972 266.4069
				IF LOCATE_CHAR_ON_FOOT_2D sniper2 -973.5972 266.4069 1.0 1.0 0
					sniper2_flag = 1
				ENDIF
			ENDIF
			IF sniper2_flag = 1
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT sniper2 -969.0840 282.6923
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D sniper2 -969.0840 282.6923 1.0 1.0 0
					SET_CHAR_OBJ_GUARD_SPOT	sniper2	-969.0840 282.6923 10.2265
					SET_CHAR_HEADING sniper2 159.3190
					sniper2_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	sniper3
			IF sniper3_flag = 0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	sniper3	-973.5972 266.4069
				IF LOCATE_CHAR_ON_FOOT_2D sniper3 -973.5972 266.4069 1.0 1.0 0
					sniper3_flag = 1
				ENDIF
			ENDIF
			IF sniper3_flag = 1
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT sniper3 -969.8824 263.6498
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D sniper3 -969.8824 263.6498 1.0 1.0 0
					SET_CHAR_OBJ_GUARD_SPOT	sniper3	-969.8824 263.6498 10.2265
					SET_CHAR_HEADING sniper3 12.6357
					sniper3_flag = 2
				ENDIF
			ENDIF
		ENDIF
		IF NOT IS_CHAR_DEAD	sniper4
			IF sniper4_flag = 0
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT	sniper4	-973.5972 266.4069
				IF LOCATE_CHAR_ON_FOOT_2D sniper4 -973.5972 266.4069 1.0 1.0 0
					sniper4_flag = 1
				ENDIF
			ENDIF
			IF sniper4_flag = 1
				SET_CHAR_OBJ_GOTO_COORD_ON_FOOT sniper4 -977.6256 277.8756
				IF LOCATE_STOPPED_CHAR_ON_FOOT_2D sniper4 -977.6256 277.8756 1.0 1.0 0
					SET_CHAR_OBJ_GUARD_SPOT	sniper4	-977.6256 277.8756 10.2265
					SET_CHAR_HEADING sniper4 3.8761
					sniper4_flag = 2
				ENDIF
			ENDIF
		ENDIF
	ENDIF
ENDIF

IF security_warning = 1
	IF audio_1_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			audio_1_flag = 4
			is_audio_in_use = 0
			GOTO mission_counter2_loop
		ENDIF
	ENDIF
	IF audio_1_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			audio_1_flag = 3
		ENDIF
	ENDIF
	IF audio_1_flag = 0
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 CNT2_1//{Female Goons} Kill him.
			audio_1_flag = 2
			is_audio_in_use = 1
		ENDIF
	ENDIF
ENDIF

IF audio_2_flag > 0
	IF audio_2_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			audio_2_flag = 4
			is_audio_in_use = 0
			GOTO mission_counter2_loop
		ENDIF
	ENDIF
	IF audio_2_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			audio_2_flag = 3
		ENDIF
	ENDIF
	IF audio_2_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 CNT2_2//{Female Goons} Get the Plates!
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
			audio_3_flag = 0
			is_audio_in_use = 0
			GOTO mission_counter2_loop
		ENDIF
	ENDIF
	IF audio_3_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			audio_3_flag = 3
		ENDIF
	ENDIF
	IF audio_3_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 CNT2_3//{Female Goons} Protect the courier!
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
			CLEAR_THIS_PRINT CNT2_4
			audio_4_flag = 0
			is_audio_in_use = 0
			GOTO mission_counter2_loop
		ENDIF
	ENDIF
	IF audio_4_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PRINT_NOW CNT2_4 5000 1//{Female Goons} Private business. You're not welcome!
			PLAY_MISSION_AUDIO 1
			audio_4_flag = 3
		ENDIF
	ENDIF
	IF audio_4_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 CNT2_4
			audio_4_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_4_timeout
				audio_4_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ENDIF

GOTO mission_counter2_loop



// ******************************* Mission Failed ******************************************

mission_counter2_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
RETURN


   

// ******************************* Mission Passed ******************************************

mission_counter2_passed:

SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 TRUE
SET_ALL_CARS_CAN_BE_DAMAGED FALSE

CLEAR_AREA printbuyX printbuyY printbuyZ 4.0 TRUE

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CREATE_PROTECTION_PICKUP printbuyX printbuyY printbuyZ printworks_revenue printworks_revenue printworks_cash_pickup
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -1027.3385 -281.6154 16.3511 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1028.1625 -281.0542 16.2730 JUMP_CUT
SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_IN
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
PRINT_BIG CNT2_09 5000 6//PRINT WORKS ASSET ACQUIRED

WAIT 5000
SET_FIXED_CAMERA_POSITION -1056.3685 -273.4923 12.0057 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1057.2881 -273.8280 11.8015 JUMP_CUT
PRINT_WITH_NUMBER_NOW CNT2_10 printworks_revenue 6000 1//The printworks will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.

WAIT 6000
SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_OUT

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

CLEAR_AREA -1059.8411 -278.7214 10.4044 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1059.8411 -278.7214 10.4044
SET_PLAYER_HEADING player1 272.2088
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT

SET_PLAYER_CONTROL player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 FALSE
SET_ALL_CARS_CAN_BE_DAMAGED TRUE
SWITCH_WIDESCREEN OFF

REMOVE_BLIP counter_contact_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD counterX counterY counterZ the_counter_blip counter_contact_blip
flag_counter_mission2_passed = 1
flag_first_asset_complete = 1 // SCFIX: fix Ken's phonecall
++ counter_60_percent
REGISTER_MISSION_PASSED	CNT_2
PLAYER_MADE_PROGRESS 1
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
PRINT_WITH_NUMBER_BIG M_PASS 5000 2500 1//MISSION PASSED
ADD_SCORE player1 5000
SET_FADING_COLOUR 0 0 1
DO_FADE 500 FADE_IN
WAIT 0

RETURN
	


// ******************************* Mission Cleanup *****************************************

mission_cleanup_counter2:

flag_player_on_mission = 0

REMOVE_BLIP	mission_blip
REMOVE_BLIP	docks_blip

MARK_MODEL_AS_NO_LONGER_NEEDED UZI
MARK_MODEL_AS_NO_LONGER_NEEDED SENTINEL
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED briefcase
MARK_MODEL_AS_NO_LONGER_NEEDED MAVERICK
MARK_MODEL_AS_NO_LONGER_NEEDED SNIPER
MARK_MODEL_AS_NO_LONGER_NEEDED TEC9
MARK_MODEL_AS_NO_LONGER_NEEDED HFORI
MARK_MODEL_AS_NO_LONGER_NEEDED HFYBU
MARK_MODEL_AS_NO_LONGER_NEEDED WFYRI
MARK_MODEL_AS_NO_LONGER_NEEDED WFORI
MARK_MODEL_AS_NO_LONGER_NEEDED BFYST
MARK_MODEL_AS_NO_LONGER_NEEDED WFYBU
MARK_MODEL_AS_NO_LONGER_NEEDED CHROMEGUN

GET_GAME_TIMER timer_mobile_start

SET_OBJECT_HEADING cnt2_left_door 0.0
SET_OBJECT_HEADING cnt2_right_door 0.0

MISSION_HAS_FINISHED
RETURN
		












// *****************************************************************************************
// ******************************* GOSUB FUNCTIONS *****************************************
// *****************************************************************************************



////////////////////////////////////////////////////////////////////////////
slow_car_if_close_to_entity: ///////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
VAR_INT gosub_car_to_slow gosub_target_entity 

	IF gosub_target_entity = -1
		GET_PLAYER_COORDINATES player1 gosub_target_car_x gosub_target_car_y temp_float_x
	ELSE
		IF NOT IS_CAR_DEAD gosub_target_entity
			GET_CAR_COORDINATES gosub_target_entity gosub_target_car_x	gosub_target_car_y temp_float_x
		ENDIF
	ENDIF

	GET_CAR_COORDINATES gosub_car_to_slow gosub_car_to_slow_x gosub_car_to_slow_y temp_float_x

	temp_float_x = gosub_car_to_slow_x - gosub_target_car_x //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
	temp_float_y = gosub_car_to_slow_y - gosub_target_car_y
	temp_float_x = temp_float_x * temp_float_x
	temp_float_y = temp_float_y * temp_float_y
	temp_float_x = temp_float_x + temp_float_y
	SQRT temp_float_x temp_float_x

	gosub_car_to_slow_speed = temp_float_x + 3.0
	IF gosub_car_to_slow_speed > 100.0
		gosub_car_to_slow_speed = 100.0
	ENDIF
	IF gosub_car_to_slow_speed < 0.0
		gosub_car_to_slow_speed = 0.0
	ENDIF
	SET_CAR_CRUISE_SPEED gosub_car_to_slow gosub_car_to_slow_speed
	IF gosub_car_to_slow_speed = 0.0
		SET_CAR_TEMP_ACTION gosub_car_to_slow TEMPACT_WAIT 100
	ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////
steal_a_car: ///////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
VAR_INT gosub_ped
VAR_INT car_model car_health
VAR_FLOAT coord_1_x coord_1_y coord_1_z coord_2_x coord_2_y

	IF heading = 919.9
		CREATE_CAR SENTINEL	coord_1_x coord_1_y coord_1_z car
	ENDIF

	GET_CHAR_COORDINATES gosub_ped coord_1_x coord_1_y coord_1_z

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 gosub_ped 40.0 40.0 0
		coord_2_x = coord_1_x + 20.0
		coord_2_y = coord_1_y + 20.0
		coord_1_x = coord_1_x - 20.0
		coord_1_y = coord_1_y - 20.0
		MARK_CAR_AS_NO_LONGER_NEEDED car
		GET_RANDOM_CAR_OF_TYPE_IN_AREA coord_1_x coord_1_y coord_2_x coord_2_y -1 car
		IF car = -1
			IF NOT IS_CHAR_DEAD	gosub_ped
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_ped player1
			ENDIF
		ELSE
			GET_CAR_MODEL car car_model
			GET_CAR_HEALTH car car_health
			IF car_health > 300
				IF car_model = 116 //COPCAR
				OR car_model = 106 //AMBULANCE
				OR car_model = 122 //TANK
				OR car_model = 117 //SWATVAN
				OR car_model = 97 //FIRETRUCK
				OR car_model = 107 //FBI CAR
				//OR car_model = 123 //ARMY TRUCK
					IF NOT IS_CHAR_DEAD	gosub_ped
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_ped player1
					ENDIF
				ELSE 
					SET_CAR_CRUISE_SPEED car 0.0
					SET_CAR_TEMP_ACTION car TEMPACT_WAIT 100
					IF NOT IS_CHAR_DEAD	gosub_ped
						SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_ped car
					ENDIF
				ENDIF
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_ped player1
			ENDIF
		ENDIF
	ELSE
		GET_CLOSEST_CAR_NODE_WITH_HEADING coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z heading
		IF NOT IS_POINT_ON_SCREEN coord_1_x coord_1_y coord_1_z 3.0
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0
				MARK_CAR_AS_NO_LONGER_NEEDED car
				CREATE_CAR SENTINEL coord_1_x coord_1_y coord_1_z car
				SET_CAR_HEADING	car heading
				IF NOT IS_CHAR_DEAD	gosub_ped
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_ped car//WARP_CHAR_INTO_CAR gosub_ped car
				ENDIF
			ELSE
				IF NOT IS_CHAR_DEAD	gosub_ped
					IF LOCATE_CHAR_ON_FOOT_3D gosub_ped coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0 0
						GET_CLOSEST_CHAR_NODE coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z
						SET_CHAR_OBJ_RUN_TO_COORD gosub_ped	coord_1_x coord_1_y
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////
car_stuck_checks:///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

VAR_FLOAT stuck_x stuck_y stuck_z
VAR_INT gosub_stuck_car	car_stuck_flag
VAR_INT stuck_timer_start

VAR_FLOAT coord_c1_x coord_c1_y coord_c1_z heading
VAR_INT game_time

	GET_GAME_TIMER game_time

	IF NOT IS_CAR_DEAD gosub_stuck_car
		IF IS_CAR_UPSIDEDOWN gosub_stuck_car
		AND IS_CAR_STOPPED gosub_stuck_car
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 gosub_stuck_car 90.0 90.0 0
				SET_UPSIDEDOWN_CAR_NOT_DAMAGED gosub_stuck_car FALSE
				car_stuck_flag = -9
			ELSE
				IF NOT IS_CAR_ON_SCREEN gosub_stuck_car
					GET_CAR_COORDINATES gosub_stuck_car coord_c1_x coord_c1_y coord_c1_z
					GET_CLOSEST_CAR_NODE_WITH_HEADING coord_c1_x coord_c1_y coord_c1_z coord_c1_x coord_c1_y coord_c1_z heading
					IF NOT IS_POINT_ON_SCREEN coord_c1_x coord_c1_y coord_c1_z 4.0
						SET_CAR_COORDINATES gosub_stuck_car coord_c1_x coord_c1_y coord_c1_z
						SET_CAR_HEADING	gosub_stuck_car heading
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF LOCATE_CAR_3D gosub_stuck_car stuck_x stuck_y stuck_z 4.0 4.0 4.0 0
			IF car_stuck_flag = 0
				stuck_timer_start = game_time
				car_stuck_flag = 1
			ENDIF

			game_time = game_time - stuck_timer_start
			IF car_stuck_flag = 1
				IF game_time > 8000
					IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 gosub_stuck_car 90.0 90.0 0
						SET_UPSIDEDOWN_CAR_NOT_DAMAGED gosub_stuck_car FALSE
						stuck_timer_start = game_time
						car_stuck_flag = -9
					ELSE
						IF NOT IS_CAR_ON_SCREEN gosub_stuck_car
							GET_CAR_COORDINATES gosub_stuck_car coord_c1_x coord_c1_y coord_c1_z
							GET_CLOSEST_CAR_NODE_WITH_HEADING coord_c1_x coord_c1_y coord_c1_z coord_c1_x coord_c1_y coord_c1_z heading
							IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY coord_c1_x coord_c1_y coord_c1_z 4.0 4.0 4.0
								IF NOT IS_POINT_ON_SCREEN coord_c1_x coord_c1_y coord_c1_z 4.0
									SET_CAR_COORDINATES gosub_stuck_car coord_c1_x coord_c1_y coord_c1_z
									SET_CAR_HEADING gosub_stuck_car heading
									SET_JAMES_CAR_ON_PATH_TO_PLAYER gosub_stuck_car
									stuck_timer_start = game_time
									car_stuck_flag = 0
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		IF NOT LOCATE_CAR_3D gosub_stuck_car stuck_x stuck_y stuck_z 4.0 4.0 4.0 0
			GET_CAR_COORDINATES gosub_stuck_car stuck_x stuck_y stuck_z
			car_stuck_flag = 0
		ENDIF
	ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////
car2_occupants_kill_player://///////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

	IF NOT IS_CHAR_DEAD	courier_car2_guard1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car2_guard1 player1
	ENDIF

	IF NOT IS_CHAR_DEAD	courier_car2_guard2
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car2_guard2 player1
	ENDIF

	IF NOT IS_CHAR_DEAD	courier_car2_guard3
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier_car2_guard3 player1
	ENDIF

	IF NOT IS_CHAR_DEAD	courier
		//GIVE_WEAPON_TO_CHAR	courier WEAPONTYPE_PISTOL 9999//M16 9999
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT courier player1
	ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////
car1_group_breaking:////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

	IF NOT IS_CHAR_DEAD	courier_car1_guard1
		IF NOT IS_CHAR_DEAD	courier_car1_guard2
			IF NOT IS_CHAR_IN_CHARS_GROUP courier_car1_guard2 courier_car1_guard1
				IF LOCATE_CHAR_ANY_MEANS_CHAR_2D courier_car1_guard2 courier_car1_guard1 30.0 30.0 0
					SET_CHAR_AS_LEADER courier_car1_guard2 courier_car1_guard1
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car1_guard2 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard2
		ENDIF
		
		IF NOT IS_CHAR_DEAD	courier_car1_guard3
			IF NOT IS_CHAR_IN_CHARS_GROUP courier_car1_guard3 courier_car1_guard1
				IF LOCATE_CHAR_ANY_MEANS_CHAR_2D courier_car1_guard3 courier_car1_guard1 30.0 30.0 0
					SET_CHAR_AS_LEADER courier_car1_guard3 courier_car1_guard1
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car1_guard3 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard3
		ENDIF
		
		IF NOT IS_CHAR_DEAD	courier_car1_guard4
			IF NOT IS_CHAR_IN_CHARS_GROUP courier_car1_guard4 courier_car1_guard1
				IF LOCATE_CHAR_ANY_MEANS_CHAR_2D courier_car1_guard4 courier_car1_guard1 30.0 30.0 0
					SET_CHAR_AS_LEADER courier_car1_guard4 courier_car1_guard1
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car1_guard4 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car1_guard4
		ENDIF
	ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////




////////////////////////////////////////////////////////////////////////////
car3_group_breaking:////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

	IF NOT IS_CHAR_DEAD	courier_car3_guard1
		IF NOT IS_CHAR_DEAD	courier_car3_guard2
			IF NOT IS_CHAR_IN_CHARS_GROUP courier_car3_guard2 courier_car3_guard1
				IF LOCATE_CHAR_ANY_MEANS_CHAR_2D courier_car3_guard2 courier_car3_guard1 30.0 30.0 0
					SET_CHAR_AS_LEADER courier_car3_guard2 courier_car3_guard1
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car3_guard2 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard2
		ENDIF
		
		IF NOT IS_CHAR_DEAD	courier_car3_guard3
			IF NOT IS_CHAR_IN_CHARS_GROUP courier_car3_guard3 courier_car3_guard1
				IF LOCATE_CHAR_ANY_MEANS_CHAR_2D courier_car3_guard3 courier_car3_guard1 30.0 30.0 0
					SET_CHAR_AS_LEADER courier_car3_guard3 courier_car3_guard1
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car3_guard3 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard3
		ENDIF
		
		IF NOT IS_CHAR_DEAD	courier_car3_guard4
			IF NOT IS_CHAR_IN_CHARS_GROUP courier_car3_guard4 courier_car3_guard1
				IF LOCATE_CHAR_ANY_MEANS_CHAR_2D courier_car3_guard4 courier_car3_guard1 30.0 30.0 0
					SET_CHAR_AS_LEADER courier_car3_guard4 courier_car3_guard1
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS courier_car3_guard4 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED courier_car3_guard4
		ENDIF
	ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
}