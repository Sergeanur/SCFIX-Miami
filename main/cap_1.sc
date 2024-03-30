MISSION_START
// *****************************************************************************************
// ********************************* Finale mission 1 ************************************** 
// ******************************** Cap the Collectors *************************************
// *****************************************************************************************
// *** The player1 gets a pager message to go to the print works. There he finds the 	 ***
// *** lovely old man beaten up. Some mob collector turned up, got heavy, and left with  ***
// *** some cash.  The mob has started taxing the business.	 The player1 flies into a 	 ***
// *** rage and goes to track down the mob collector.									 ***
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_finale1

IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_finale1_failed
ENDIF

GOSUB mission_cleanup_finale1

MISSION_END
 
// Variables for mission

//PEDS CARS ETC
VAR_INT collector_car
VAR_INT collector1
VAR_INT collector2
//BLIPS
VAR_INT	collector_blip
VAR_INT icecream_blip taxifirm_blip boatyard_blip showroom_blip malibu_blip porn_blip
//FLAGS TIMERS COUNTERS
VAR_INT done_bike_cutscene bike_cutscene_timer
VAR_INT icecream_cash_pickup_removed taxifirm_cash_pickup_removed boatyard_cash_pickup_removed
VAR_INT malibu_cash_pickup_removed showroom_cash_pickup_removed porn_cash_pickup_removed
VAR_INT player_audio_timer player_audio_flag collector_audio_timer collector_audio_flag collector_audio_flag2 max_passengers
VAR_INT collector_counter collector_in_car collector_stuck_timer collector_stuck_timer2 collector_car_goto_coords_timer collector_cash	collector_in_car_timer
//COORD MATHS
VAR_FLOAT collector_goto_x collector_goto_y	collector_goto_z
VAR_FLOAT collector_goto_zone_x collector_goto_zone_y collector_goto_zone_size_x collector_goto_zone_size_y
VAR_FLOAT collector_stuck_x collector_stuck_y

VAR_INT play_audio_1 play_audio_2

VAR_FLOAT route_startX route_startY route_startZ
VAR_FLOAT route_endX route_endY route_endZ

VAR_FLOAT current_route_point_x current_route_point_y current_route_point_z
VAR_FLOAT route_point1_x route_point1_y route_point1_z
VAR_FLOAT route_point2_x route_point2_y route_point2_z
VAR_FLOAT route_point3_x route_point3_y route_point3_z
VAR_FLOAT route_point4_x route_point4_y route_point4_z
VAR_FLOAT route_point5_x route_point5_y route_point5_z

VAR_FLOAT route_dist_1to2
VAR_FLOAT route_dist_2to3
VAR_FLOAT route_dist_3to4
VAR_FLOAT route_dist_4to5

VAR_INT current_route_point
VAR_INT closest_point
VAR_INT route_point_count

VAR_INT flag_finished_walking_route
VAR_INT flag_route_go_backwards

VAR_INT final_destination

VAR_INT flag_audio_just_noticed_player

// ****************************************Mission Start************************************

mission_start_finale1:

flag_player_on_mission = 1

REGISTER_MISSION_GIVEN
SCRIPT_NAME CAP_1

WAIT 0
{

LOAD_MISSION_TEXT CAP_1
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -1045.726 -292.454 9.758 97.607  // On road outside of Print Works

malibu_asset_acquired = 1 //debug!!!!!!
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD bankbuyx bankbuyy bankbuyz the_bankjob_blip bankjob_contact_blip
CREATE_PROTECTION_PICKUP bankbuyX bankbuyY bankbuyZ malibu_revenue malibu_revenue malibu_cash_pickup 

porn_asset_acquired	= 1 //debug!!!!!
SET_ZONE_PED_INFO PORNSTU DAY   (4) 0 0 0 0 0 0 1000 0 0 0 
SET_ZONE_PED_INFO PORNSTU NIGHT (5) 0 0 0 0 0 0 1000 0 0 0
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD porncashX porncashY porncashZ	the_porn_blip porn_contact_blip
CREATE_PROTECTION_PICKUP porncashX porncashY porncashZ porn_revenue porn_revenue porn_cash_pickup

icecream_asset_acquired = 1 //debug!!!!!!!
SET_ZONE_PED_INFO ICCREAM DAY   (13) 0 0 0 0 0 0 1000 0 0 0
SET_ZONE_PED_INFO ICCREAM NIGHT (10) 0 0 0 0 0 0 1000 0 0 0 
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -878.5 -575.1 11.2 RADAR_SPRITE_ICE icebuy_blip
CREATE_PROTECTION_PICKUP icebuyX icebuyY icebuyZ icecream_revenue icecream_revenue icecream_cash_pickup 

taxifirm_asset_acquired = 1 //debug!!!!!!!
SET_ZONE_PED_INFO KAUFCAB DAY   (13) 0 0 0 0 0 0 1000 0 0 0
SET_ZONE_PED_INFO KAUFCAB NIGHT (10) 0 0 0 0 0 0 1000 0 0 0 
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
CREATE_PROTECTION_PICKUP taxicashX taxicashY taxicashZ taxifirm_revenue taxifirm_revenue taxifirm_cash_pickup 

boatyard_asset_acquired = 1 //debug!!!!!!
SET_ZONE_PED_INFO BOATYRD DAY   (13) 0 0 0 0 0 0 1000 0 0 0 
SET_ZONE_PED_INFO BOATYRD NIGHT (10) 0 0 0 0 0 0 1000 0 0 0
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -664.1 -1476.3 13.8 RADAR_SPRITE_BOATYARD boatbuy_blip
CREATE_PROTECTION_PICKUP boatcashX boatcashY boatcashZ boatyard_revenue boatyard_revenue boatyard_cash_pickup 

showroom_asset_acquired = 1 //debug!!!!!
SET_ZONE_PED_INFO CARYRD DAY   (13) 0 0 0 0 0 0 1000 0 0 0 
SET_ZONE_PED_INFO CARYRD NIGHT (5 ) 0 0 0 0 0 0 1000 0 0 0
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT carbuyX carbuyY carbuyZ RADAR_SPRITE_SUNYARD carbuy_blip
CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup 


VAR_INT current_place
current_place = 0

VAR_INT arrived_at
arrived_at = 0

collector_car = -1
collector_counter = 0
collector_in_car = 0
collector_stuck_timer = 0
collector_stuck_timer2 = 0
collector_car_goto_coords_timer = 0
collector_cash = 0
collector_in_car_timer = 0
collector_goto_x = 0.0
collector_goto_y = 0.0
collector_goto_z = 0.0
collector_goto_zone_x = 0.0
collector_goto_zone_y = 0.0
collector_goto_zone_size_x = 0.0
collector_goto_zone_size_y = 0.0
collector_stuck_x = 0.0
collector_stuck_y = 0.0

collector1 = -1
collector2 = -1


icecream_cash_pickup_removed = 0
taxifirm_cash_pickup_removed = 0
boatyard_cash_pickup_removed = 0
malibu_cash_pickup_removed = 0
showroom_cash_pickup_removed = 0
porn_cash_pickup_removed = 0

done_bike_cutscene = 0
bike_cutscene_timer = 0

player_audio_timer = 0
player_audio_flag = 0
collector_audio_timer = 0
collector_audio_flag = 0
collector_audio_flag2 = 0

coord_1_x = 0.0
coord_1_y = 0.0
coord_1_z = 0.0

play_audio_1 = 0
play_audio_2 = 0

current_route_point_x = 0.0
current_route_point_y = 0.0
current_route_point_z = 0.0

route_point1_x = 0.0
route_point1_y = 0.0
route_point1_z = 0.0

route_point2_x = 0.0
route_point2_y = 0.0
route_point2_z = 0.0

route_point3_x = 0.0
route_point3_y = 0.0
route_point3_z = 0.0

route_point4_x = 0.0
route_point4_y = 0.0
route_point4_z = 0.0

route_point5_x = 0.0
route_point5_y = 0.0
route_point5_z = 0.0

current_route_point = 0
closest_point = 0
route_point_count = 0

flag_audio_just_noticed_player = 0


//////////////////// TEMP!!!!!!!
SWITCH_PED_ROADS_ON 189.8 230.3 0.0 248.0 258.5 30.0 //  Golf course road block
SWITCH_PED_ROADS_ON -38.0 84.3 0.0 -102.3 95.1 30.0 //  Golf course road block
SWITCH_ROADS_ON 189.8 230.3 0.0 248.0 258.5 30.0 //  Golf course road block
SWITCH_ROADS_ON -38.0 84.3 0.0 -102.3 95.1 30.0 //  Golf course road block
SWITCH_ROADS_ON 175.0 236.1 0.0 161.0 242.4 30.0 //  Golf course road block
SWITCH_ROADS_ON 149.8 231.4 0.0 136.0 235.3 30.0 //  Golf course road block
SWITCH_ROADS_ON 63.4 188.6 0.0 49.4 189.7 30.0 //  Golf course road block
DELETE_OBJECT golf_roadblock
SWITCH_PED_ROADS_ON -214.6 -948.8 0.0 -258.7 -920.6 30.0 //  South road block
SWITCH_ROADS_ON -214.6 -948.8 0.0 -258.7 -920.6 30.0 //  South road block                                          
DELETE_OBJECT south_roadblock
SWITCH_PED_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
SWITCH_ROADS_ON -787.8 -519.4 10.0 -657.5 -475.2 20.0 // Star Island gates mainland
DELETE_OBJECT star_gate_1
CREATE_OBJECT_NO_OFFSET comgate1open -712.524 -489.428 12.549 star_gate_1
DONT_REMOVE_OBJECT star_gate_1
DELETE_OBJECT pier_closed
SWITCH_PED_ROADS_ON -99.8 1041.9 0.0 -129.0 1097.4 30.0 //  porn island road block
SWITCH_ROADS_ON -99.8 1041.9 0.0 -129.0 1097.4 30.0 // porn island road block
DELETE_OBJECT porn_roadblock
DELETE_OBJECT taxi_closed


DELETE_OBJECT porn_north_gate_closed
DELETE_OBJECT porn_south_gate_closed

//north gate
CREATE_OBJECT_NO_OFFSET ci_gatesopen 10.273 963.308 12.258 porn_north_gate_open
DONT_REMOVE_OBJECT porn_north_gate_open

//south gate
CREATE_OBJECT_NO_OFFSET ci_backgateopen -14.381 884.12 13.542 porn_south_gate_open
DONT_REMOVE_OBJECT porn_south_gate_open

DELETE_OBJECT jetty_door_closed
CREATE_OBJECT_NO_OFFSET ci_jetygatesopen -115.825 1028.55 11.334 jetty_door_open
DONT_REMOVE_OBJECT jetty_door_open
//////////////////// TEMP!!!!!!!

GOTO cap_1_fool_compiler
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue taxifirm_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue porn_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue malibu_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue icecream_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue boatyard_cash_pickup
	CREATE_PROTECTION_PICKUP x y z porn_revenue porn_revenue showroom_cash_pickup
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -664.1 -1476.3 13.8 RADAR_SPRITE_BOATYARD boatbuy_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT carbuyX carbuyY carbuyZ RADAR_SPRITE_SUNYARD carbuy_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -878.5 -575.1 11.2 RADAR_SPRITE_ICE icebuy_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD porncashX porncashY porncashZ	the_porn_blip porn_contact_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD bankbuyx bankbuyy bankbuyz the_bankjob_blip bankjob_contact_blip
cap_1_fool_compiler:


/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

LOAD_MISSION_AUDIO 1 MONO12 // FIXMIAMI

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cskelly
LOAD_SPECIAL_CHARACTER 3 printra
LOAD_SPECIAL_CHARACTER 4 printrb
LOAD_SPECIAL_CHARACTER 5 printrc

SET_AREA_VISIBLE VIS_PRINT_WORKS
LOAD_SCENE -1071.5597 -278.9497 12.3606

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
	WAIT 0

ENDWHILE

LOAD_CUTSCENE CAP_1

SET_NEAR_CLIP 0.1

SET_CUTSCENE_OFFSET -1064.103 -276.39 11.066
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_kelly
SET_CUTSCENE_ANIM cs_kelly cskelly

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_buddy
SET_CUTSCENE_ANIM cs_buddy printra

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_sonny
SET_CUTSCENE_ANIM cs_sonny printrb

CREATE_CUTSCENE_OBJECT SPECIAL05 cs_sgoona
SET_CUTSCENE_ANIM cs_sgoona printrc

CLEAR_AREA -1059.8411 -278.7214 10.4044 1.0 TRUE
SET_PLAYER_COORDINATES player1 -1059.8411 -278.7214 10.4044
SET_PLAYER_HEADING player1 272.2088

SET_FADING_COLOUR 0 0 1

DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 2420
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_01 10000 1//Ok, what's the emergency?
 
WHILE cs_time < 5636
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_02 10000 1//WHO?
 
WHILE cs_time < 6065
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_03 10000 1//Tommy...some mob thugs ...said they'd come to take their cut...
 
WHILE cs_time < 10876
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_04 10000 1//...said it was a Mr. Forello's money...I feel like crap.
 
WHILE cs_time < 14640
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_05 10000 1//Forelli? SONNY Forelli?
 
WHILE cs_time < 17053
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_06 10000 1//Yeah, that's the guy...I think...they were very insistent...
 
WHILE cs_time < 20816
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_07 10000 1//Don't you worry, pop, I'm not angry with you.
 
WHILE cs_time < 22129
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_08 10000 1//Get him to the hospital.
 
WHILE cs_time < 24218
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_09 10000 1//Tommy...rip that guy a new asshole for me...
 
WHILE cs_time < 27085
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
PRINT_NOW CAP_10 10000 1//I'm gonna rip him two.

WHILE cs_time < 27367//28993
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF WAS_CUTSCENE_SKIPPED
	CLEAR_PRINTS
ENDIF

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_OUT

WAIT 1000

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
SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 600000

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
UNLOAD_SPECIAL_CHARACTER 4
UNLOAD_SPECIAL_CHARACTER 5

SET_AREA_VISIBLE VIS_MAIN_MAP
LOAD_SCENE -1059.8411 -278.7214 10.4044
/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 TRUE


LOAD_SPECIAL_CHARACTER 1 MBA
LOAD_SPECIAL_CHARACTER 2 MBB
REQUEST_MODEL M4
REQUEST_MODEL CHROMEGUN
REQUEST_MODEL SANCHEZ

LOAD_ALL_MODELS_NOW

// FIXMIAMI: START
IF NOT WAS_CUTSCENE_SKIPPED
	IF HAS_MISSION_AUDIO_LOADED	1
		PLAY_MISSION_AUDIO 1
		WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
			WAIT 0
		ENDWHILE
	ENDIF
ENDIF
// FIXMIAMI: END

WHILE NOT HAS_MODEL_LOADED M4
OR NOT HAS_MODEL_LOADED CHROMEGUN
OR NOT HAS_MODEL_LOADED SANCHEZ
OR NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0
ENDWHILE

SET_ENTER_CAR_RANGE_MULTIPLIER 10.0

VAR_INT collectors_wave
collectors_wave = 0

// 0 - driving to location
// 1 - arrived
// 2 - go to pickup
// 3 - taxed,
// 4 - go back to the car
VAR_INT collectors_state

IF NOT collectors_wave = 0
	CREATE_CAR SANCHEZ x y z collector_car // FUCK OFF COMPILER!!
	collector1 = scplayer
	collector2 = scplayer
	collector1 = -1
	collector2 = -1
ENDIF

final_destination = 7
IF boatyard_asset_acquired = 1
	final_destination = 1
ENDIF
IF showroom_asset_acquired = 1
	final_destination = 2
ENDIF
IF icecream_asset_acquired = 1
	final_destination = 3
ENDIF
IF taxifirm_asset_acquired = 1
	final_destination = 4
ENDIF
IF porn_asset_acquired = 1
	final_destination = 5
ENDIF
IF malibu_asset_acquired = 1
	final_destination = 6
ENDIF

/*ADD_ROUTE_POINT 1 -725.3655 -1501.6598 10.8
ADD_ROUTE_POINT 1 -681.0613 -1490.4276 10.8
ADD_ROUTE_POINT 1 -636.2616 -1500.1516 10.8
ADD_ROUTE_POINT 1 -642.8112 -1496.4293 10.8
ADD_ROUTE_POINT 1 boatcashX boatcashY 10.8

ADD_ROUTE_POINT 2 -1023.7896 -901.9847 13.8
ADD_ROUTE_POINT 2 carbuyX carbuyY 13.8

ADD_ROUTE_POINT 3 icebuyX icebuyY 10.5
ADD_ROUTE_POINT 3 icebuyX icebuyY 10.5

ADD_ROUTE_POINT 4 -1009.2858 196.7185 10.5
ADD_ROUTE_POINT 4 taxicashX taxicashY 10.5

ADD_ROUTE_POINT 5 12.2850 963.0108 10.5
ADD_ROUTE_POINT 5 porncashX porncashY 10.5

ADD_ROUTE_POINT 6 501.5787 -81.7690 9.5
ADD_ROUTE_POINT 6 491.7617 -78.5777 9.5
ADD_ROUTE_POINT 6 bankbuyX bankbuyY 9.5*/

VAR_INT flag_collector_just_capped
flag_collector_just_capped = 0

VAR_INT flag_is_collector1_in_car flag_is_collector1_in_car_just_set
VAR_INT flag_hack_clear_obj_when_exiting_car
flag_is_collector1_in_car = 0
flag_is_collector1_in_car_just_set = 0
flag_hack_clear_obj_when_exiting_car = 0

VAR_INT player_near go_kill_player go_kill_player_just_set
player_near = 0
go_kill_player = 0
go_kill_player_just_set = 0

VAR_INT waiting_for_second_collector
VAR_INT waiting_for_second_collector_timer
VAR_INT no_obj_timer
waiting_for_second_collector = 0
waiting_for_second_collector_timer = 0

// FIXMIAMI: new code starts here
cap1_mission_loop:
	WAIT 0

	GET_GAME_TIMER game_timer

	GOSUB process_audio
	GOSUB process_audio_finish

	IF done_bike_cutscene < 5
		IF done_bike_cutscene = 0
			bike_cutscene_timer = game_timer + 4000
			GOSUB get_next_place
			GOSUB spawn_collectors
			SWITCH_WIDESCREEN ON

			SET_ALL_CARS_CAN_BE_DAMAGED FALSE
			SET_GENERATE_CARS_AROUND_CAMERA TRUE
			SET_FIXED_CAMERA_POSITION -856.1546 -497.3885 10.7677 0.0 0.0 0.0//-862.8522 -475.8948 10.5281
			IF NOT IS_CAR_DEAD collector_car
				POINT_CAMERA_AT_CAR collector_car FIXED JUMP_CUT
			ENDIF
			IF NOT IS_CHAR_DEAD collector1
				GET_CHAR_COORDINATES collector1 x y z
			ENDIF
			LOAD_SCENE x y z
			SET_FADING_COLOUR 0 0 0

			DO_FADE 1500 FADE_IN

			PRINT_NOW CAP1_B1 20000 1 //"The mafia is taxing your businesses, find them and kill them."

			done_bike_cutscene = 1
		ELSE
			IF done_bike_cutscene = 1
			AND bike_cutscene_timer < game_timer
				bike_cutscene_timer = game_timer + 2000
				IF NOT IS_CAR_DEAD collector_car
					POINT_CAMERA_AT_CAR collector_car CAM_ON_A_STRING JUMP_CUT
				ENDIF

				done_bike_cutscene = 2
			ELSE
				IF done_bike_cutscene = 2
				AND bike_cutscene_timer < game_timer
					SET_FADING_COLOUR 0 0 0
					DO_FADE 1500 FADE_OUT
					done_bike_cutscene = 3
				ELSE
					IF done_bike_cutscene = 3
						IF NOT GET_FADING_STATUS
							done_bike_cutscene = 4
						ENDIF
					ELSE
						IF done_bike_cutscene = 4
							SET_PLAYER_CONTROL player1 ON
							SET_EVERYONE_IGNORE_PLAYER player1 FALSE
							SWITCH_WIDESCREEN OFF
							SET_ALL_CARS_CAN_BE_DAMAGED TRUE
							SET_GENERATE_CARS_AROUND_CAMERA FALSE
							SET_CAMERA_BEHIND_PLAYER
							RESTORE_CAMERA_JUMPCUT
							GET_PLAYER_COORDINATES player1 x y z
							LOAD_SCENE x y z
							SET_FADING_COLOUR 0 0 0
							DO_FADE 1500 FADE_IN
							IF NOT IS_CHAR_DEAD	collector1
								ADD_BLIP_FOR_CHAR collector1 collector_blip
								CHANGE_BLIP_COLOUR collector_blip RED
							ENDIF
							done_bike_cutscene = 5
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	flag_collector_just_capped = 0 // flag for audio, play Tommy line if one out of two collectors killed

	// forget about second collector if he's dead
	IF NOT collector2 = -1
		IF IS_CHAR_DEAD collector2
			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR collector2 scplayer
				flag_collector_just_capped = 1
			ENDIF
			MARK_CHAR_AS_NO_LONGER_NEEDED collector2
			collector2 = -1
		ENDIF
	ENDIF

	// if lead collector is dead - make second collector become the lead
	IF IS_CHAR_DEAD collector1
	AND NOT collector2 = -1
	AND NOT IS_CHAR_DEAD collector2
		IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR collector1 scplayer
			flag_collector_just_capped = 1
		ENDIF
		MARK_CHAR_AS_NO_LONGER_NEEDED collector1
		REMOVE_BLIP collector_blip
		LEAVE_GROUP collector2
		collector1 = collector2
		collector2 = -1

		collector_cash = 0

		IF collectors_state = 2
			//GOSUB get_route_pos
			//SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
			//SET_CHAR_OBJ_FOLLOW_ROUTE collector1 arrived_at FOLLOW_ROUTE_BACKFORWARD
			//SET_CHAR_OBJ_RUN_TO_COORD collector1 route_endX route_endY
			GOSUB start_walking_route_forward
		ELSE
			IF collectors_state = 3
				GOSUB start_walking_route_backward // hack shit
			ENDIF
		ENDIF

		ADD_BLIP_FOR_CHAR collector1 collector_blip
		CHANGE_BLIP_COLOUR collector_blip RED

		SET_CHAR_OBJ_NO_OBJ collector1
		/*IF NOT IS_CAR_DEAD collector_car
		AND IS_CHAR_SITTING_IN_CAR collector1 collector_car
			SET_CHAR_OBJ_LEAVE_CAR collector1 collector_car
			collector_in_car = 0
		ENDIF
		IF collector_in_car = 0
		AND collectors_state = 0
			SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector1 collector_car
		ENDIF*/
	ENDIF

	// spawn new collectors if both are dead or beat the mission
	IF IS_CHAR_DEAD collector1
	AND IS_CHAR_DEAD collector2
		REMOVE_BLIP collector_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED collector1
		++ collectors_wave
		IF collectors_wave = 3
			IF play_audio_1 = 2
				WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
					WAIT 0
				ENDWHILE
			ENDIF

			GOTO mission_finale1_passed
		ENDIF
		flag_collector_just_capped = 0
		PRINT_NOW CAP1B10 5000 1 //You've capped the Collectors. More are on their way.

		IF collectors_state = 3
			GOSUB get_next_place
		ENDIF

		GOSUB spawn_collectors
		go_kill_player = 0
		go_kill_player_just_set = 0

		ADD_BLIP_FOR_CHAR collector1 collector_blip
		CHANGE_BLIP_COLOUR collector_blip RED
	ENDIF

	// hack to bypass objectives breaking when collector falls off the bike
	flag_is_collector1_in_car_just_set = 0
	IF NOT IS_CHAR_DEAD collector1
		IF IS_CHAR_IN_ANY_CAR collector1
			IF flag_is_collector1_in_car = 0
				flag_hack_clear_obj_when_exiting_car = 0
				flag_is_collector1_in_car = 1
				flag_is_collector1_in_car_just_set = 1
			ENDIF
		ELSE
			IF NOT IS_CHAR_OBJ_NO_OBJ collector1
				no_obj_timer = game_timer + 5000
			ENDIF
			IF flag_is_collector1_in_car = 1
				flag_hack_clear_obj_when_exiting_car = 1
				flag_is_collector1_in_car = 0
				flag_is_collector1_in_car_just_set = 1
				SET_CHAR_OBJ_NO_OBJ collector1
			ENDIF
		ENDIF
	ENDIF

	// leave car if it's broken or upside down
	IF NOT IS_CAR_DEAD collector_car
		IF IS_PLAYER_IN_CAR player1 collector_car
		OR IS_CAR_STUCK_ON_ROOF collector_car
		OR NOT IS_CAR_HEALTH_GREATER collector_car 350
			IF NOT IS_CHAR_DEAD collector1
				IF IS_CHAR_IN_CAR collector1 collector_car
					SET_CHAR_OBJ_LEAVE_CAR collector1 collector_car
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD collector2
				IF IS_CHAR_IN_CAR collector2 collector_car
					SET_CHAR_OBJ_LEAVE_CAR collector2 collector_car
					//SET_CHAR_AS_LEADER collector2 collector1
				ENDIF
			ENDIF
			GOSUB cleanup_collector_car
		ENDIF
	ENDIF

	IF flag_hack_clear_obj_when_exiting_car = 1
		IF NOT IS_CHAR_DEAD collector1
			IF NOT IS_CHAR_OBJ_NO_OBJ collector1
				GOTO cap1_mission_loop // early exit
			ELSE
				flag_hack_clear_obj_when_exiting_car = 0
			ENDIF
		ENDIF
	ENDIF

	player_near = 0
	IF NOT IS_CHAR_DEAD collector1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 30.0 30.0 0
			player_near = 1 
		ENDIF

		LVAR_INT flag_dont_be_distracted
		flag_dont_be_distracted = 0

		IF collectors_state = 2
		AND LOCATE_CHAR_ON_FOOT_2D collector1 route_endX route_endY 6.0 6.0 0
			flag_dont_be_distracted = 1
		ENDIF

		IF player_near = 1
		AND NOT go_kill_player = 1
		AND flag_dont_be_distracted = 0
			IF NOT IS_CAR_DEAD collector_car
				IF IS_CHAR_IN_CAR collector1 collector_car
					/*IF IS_CAR_STOPPED collector_car
						CLEAR_CHAR_LAST_DAMAGE_ENTITY collector1
						go_kill_player = 1
						go_kill_player_just_set = 1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT collector1 player1
					ENDIF*/
				ELSE
					IF HAS_CHAR_SPOTTED_PLAYER collector1 player1
					OR LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 10.0 10.0 0
					OR HAS_CHAR_BEEN_DAMAGED_BY_CHAR collector1 scplayer
					OR IS_PLAYER_PRESSING_HORN player1
					OR IS_PLAYER_SHOOTING player1
						CLEAR_CHAR_LAST_DAMAGE_ENTITY collector1
						go_kill_player = 1
						go_kill_player_just_set = 1
						flag_audio_just_noticed_player = 1
						SET_CHAR_OBJ_NO_OBJ collector1
						//TIMERA = 0
						//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT collector1 player1
						//PRINT_NOW ( GOAWAY1 ) 5000 1 // TEST
					ENDIF
				ENDIF
			ELSE
				IF HAS_CHAR_SPOTTED_PLAYER collector1 player1
				OR LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 10.0 10.0 0
				OR HAS_CHAR_BEEN_DAMAGED_BY_CHAR collector1 scplayer
				OR IS_PLAYER_PRESSING_HORN player1
				OR IS_PLAYER_SHOOTING player1
					CLEAR_CHAR_LAST_DAMAGE_ENTITY collector1
					go_kill_player = 1
					go_kill_player_just_set = 1
					flag_audio_just_noticed_player = 1
					SET_CHAR_OBJ_NO_OBJ collector1
					//TIMERA = 0
					//SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT collector1 player1
					//PRINT_NOW ( GOAWAY2 ) 5000 1 // TEST
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	// reset states if player is far
	IF player_near = 0
	AND go_kill_player = 1
cancel_player_kill:
		go_kill_player = 0
		go_kill_player_just_set = 1
		flag_audio_just_noticed_player = 0
		IF NOT IS_CHAR_DEAD collector1
			//SET_CHAR_OBJ_NO_OBJ collector1

			IF collectors_state = 0
				collector_in_car = 1
				IF NOT IS_CAR_DEAD collector_car
					IF IS_CHAR_IN_CAR collector1 collector_car
						collector_in_car = 0
					ENDIF
				ENDIF
			ELSE
				IF collectors_state = 2
					//SET_CHAR_OBJ_RUN_TO_COORD collector1 current_route_point_x current_route_point_y
					//SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
					GOSUB start_walking_route_forward
				ELSE
					IF collectors_state = 3
						//SET_CHAR_OBJ_RUN_TO_COORD collector1 current_route_point_x current_route_point_y
						//SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
						GOSUB start_walking_route_backward
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF go_kill_player = 1
	AND NOT IS_CHAR_DEAD collector1
		IF IS_CHAR_OBJ_NO_OBJ collector1
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT collector1 player1
			IF IS_CHAR_OBJ_NO_OBJ collector1 // hack workaround
				//PRINT_HELP FIN_B6 // debug
				GOTO cancel_player_kill
			ENDIF
			//PRINT_HELP_FOREVER FIN_B6 // debug
		//ELSE // debug
		//	CLEAR_HELP  // debug
		ENDIF
	//ELSE // debug
	//	CLEAR_HELP  // debug
	ENDIF

	IF go_kill_player = 1
		GOTO cap1_mission_loop // early exit
	ENDIF

	IF go_kill_player_just_set = 1
		go_kill_player_just_set = 0
		// reset stuff for collectors_state here
	ENDIF

	// checking collector's routine here
	IF collectors_state = 0 // going to point
		IF NOT IS_CHAR_DEAD collector1
			IF NOT IS_CHAR_IN_ANY_CAR collector1
				GOSUB check_is_collector_in_zone
				IF flag_is_collector_in_zone = 1
					collectors_state = 1
					GOSUB print_arrived
					GOTO cap1_mission_loop // early exit
				ENDIF
			ENDIF
			IF LOCATE_CHAR_ON_FOOT_2D collector1 collector_goto_zone_x collector_goto_zone_y collector_goto_zone_size_x collector_goto_zone_size_y FALSE
				//collectors_state = 1
				//GOSUB print_arrived
				SET_CHAR_OBJ_RUN_TO_COORD collector1 collector_goto_x collector_goto_y
				GOTO cap1_mission_loop // early exit
			ENDIF
		ENDIF
		IF collector_in_car = 1
			waiting_for_second_collector = 0
			waiting_for_second_collector_timer = game_time + 10000
			IF NOT IS_CAR_DEAD collector_car
				IF NOT IS_CAR_IN_WATER collector_car
					IF NOT IS_CHAR_DEAD collector1
						IF NOT IS_CHAR_IN_CAR collector1 collector_car
							SET_CAR_MISSION collector_car MISSION_NONE
							SET_CAR_CRUISE_SPEED collector_car 0.0
							collector_in_car = 0
							waiting_for_second_collector = 0
							IF LOCATE_CHAR_ON_FOOT_CAR_2D collector1 collector_car 30.0 30.0 0
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector1 collector_car
								//IF IS_CHAR_OBJ_NO_OBJ collector1 // workaround
								//	PRINT_HELP KICK1_9
								//ENDIF
							ELSE
								GOSUB collector_steal_a_car
							ENDIF
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD collector2
						IF NOT IS_CHAR_IN_CAR collector2 collector_car
						AND IS_CHAR_IN_CHARS_GROUP collector2 collector1
							//IF collectors_state = 0
								//IF LOCATE_CHAR_ON_FOOT_CAR_2D collector1 collector_car 30.0 30.0 0
									//LEAVE_GROUP collector2
								//	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER collector2 collector_car
								//ENDIF
							//ELSE
								//IF NOT IS_CHAR_DEAD collector1
								//	SET_CHAR_AS_LEADER collector2 collector1
								//ENDIF
							//ENDIF
							SET_CAR_MISSION collector_car MISSION_NONE
							SET_CAR_CRUISE_SPEED collector_car 0.0
							collector_in_car = 0
						ENDIF
					ENDIF
				ELSE
					collector_in_car = 0
					waiting_for_second_collector = 0
				ENDIF
			ELSE
				collector_in_car = 0
				waiting_for_second_collector = 0
			ENDIF
		ELSE
			IF NOT IS_CAR_DEAD collector_car
				IF NOT IS_CAR_IN_WATER collector_car
					IF NOT IS_CHAR_DEAD collector1
						IF collector2 = -1
						OR NOT IS_CHAR_DEAD collector2
							IF IS_CHAR_IN_CAR collector1 collector_car
								IF collector2 = -1
									collector_in_car = 1
									SET_CAR_MISSION collector_car MISSION_GOTOCOORDS
									CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
									SET_CAR_CRUISE_SPEED collector_car 40.0
									SET_CAR_DRIVING_STYLE collector_car 2
									GET_CAR_COORDINATES	collector_car collector_stuck_x collector_stuck_y Z
									collector_stuck_timer = game_timer + 4000
								ELSE
									IF IS_CHAR_IN_CAR collector2 collector_car
										collector_in_car = 1
										SET_CAR_MISSION collector_car MISSION_GOTOCOORDS
										CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
										SET_CAR_CRUISE_SPEED collector_car 40.0
										SET_CAR_DRIVING_STYLE collector_car 2
										GET_CAR_COORDINATES	collector_car collector_stuck_x collector_stuck_y Z
										collector_stuck_timer = game_timer + 4000
									ELSE
										IF waiting_for_second_collector = 0
											waiting_for_second_collector_timer = game_time + 10000
											waiting_for_second_collector = 1
										ELSE
											IF waiting_for_second_collector_timer > game_time
												IF NOT IS_CHAR_ON_SCREEN collector2
												AND NOT IS_CAR_ON_SCREEN collector_car
												AND IS_CAR_PASSENGER_SEAT_FREE collector_car 0
													DELETE_CHAR collector2
													CREATE_CHAR_AS_PASSENGER collector_car PEDTYPE_CIVMALE SPECIAL02 0 collector2
													SET_CHAR_ONLY_DAMAGED_BY_PLAYER collector2 TRUE
													GIVE_WEAPON_TO_CHAR collector2 WEAPONTYPE_SHOTGUN 9999
													CLEAR_CHAR_THREAT_SEARCH collector2
													//SET_CHAR_THREAT_SEARCH collector2 THREAT_PLAYER1
													SET_CHAR_PERSONALITY collector2 PEDSTAT_TOUGH_GUY
													SET_CHAR_HEALTH	collector2 250
													//SET_CHAR_CEASE_ATTACK_TIMER collector2 1000
													SET_CHAR_HEED_THREATS collector2 TRUE
													//SET_CHAR_STAY_IN_SAME_PLACE	collector2 TRUE
													SET_CHAR_RUNNING collector2 TRUE
													SET_CHAR_AS_LEADER collector2 collector1
													SET_CHAR_MONEY collector2 0
													waiting_for_second_collector = 0
													waiting_for_second_collector_timer = game_time + 10000
												ENDIF
											ENDIF
										ENDIF
									ENDIF 
								ENDIF
							ENDIF 
						ENDIF
					ENDIF
				ELSE
					GOSUB collector_steal_a_car
				ENDIF
			ELSE
				GOSUB collector_steal_a_car
			ENDIF 
		ENDIF

		IF collector_in_car = 1
			IF LOCATE_CHAR_ANY_MEANS_2D collector1 collector_stuck_x collector_stuck_y 4.0 4.0 0 // TODO: car not char?
				IF collector_stuck_timer < game_timer
					IF player_near = 1
						SET_CHAR_OBJ_LEAVE_CAR collector1 collector_car
						IF NOT IS_CHAR_DEAD collector2
							SET_CHAR_OBJ_LEAVE_CAR collector2 collector_car
						ENDIF
					ELSE
						IF NOT IS_CAR_ON_SCREEN collector_car
							GET_CAR_COORDINATES collector_car car_x car_y car_z
							GET_CLOSEST_CAR_NODE car_x car_y car_z car_x car_y car_z
							IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY car_x car_y car_z 4.0 4.0 3.0
								IF NOT IS_POINT_ON_SCREEN car_x car_y car_z 4.0
									SET_CAR_COORDINATES collector_car car_x car_y car_z
									TURN_CAR_TO_FACE_COORD collector_car collector_goto_x collector_goto_y
									SET_CAR_CRUISE_SPEED collector_car 40.0
									SET_CAR_DRIVING_STYLE collector_car 2
									collector_stuck_timer = game_timer + 4000
									SET_CAR_MISSION collector_car MISSION_GOTOCOORDS
									CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ELSE
				GET_CAR_COORDINATES	collector_car collector_stuck_x collector_stuck_y Z
				collector_stuck_timer = game_timer + 4000
			ENDIF

			IF NOT IS_CHAR_IN_ANY_CAR collector1
			AND LOCATE_CHAR_ON_FOOT_2D collector1 collector_goto_x collector_goto_y 6.0 6.0 0
				GOSUB print_arrived
				collectors_state = 1
			ELSE
				IF LOCATE_CAR_3D collector_car collector_goto_x collector_goto_y collector_goto_z 35.0 35.0 35.0 0
					SET_CAR_CRUISE_SPEED collector_car	8.0
					IF LOCATE_CAR_3D collector_car collector_goto_x collector_goto_y collector_goto_z 6.0 6.0 6.0 0
						SET_CAR_TEMP_ACTION collector_car TEMPACT_WAIT 400
					ENDIF
					IF LOCATE_STOPPED_CAR_3D collector_car collector_goto_x collector_goto_y collector_goto_z 6.0 6.0 6.0 0
						SET_CAR_TEMP_ACTION	collector_car TEMPACT_WAIT 200
						GOSUB print_arrived
						SET_CHAR_OBJ_LEAVE_ANY_CAR collector1
						IF NOT IS_CHAR_DEAD collector2
							SET_CHAR_OBJ_LEAVE_ANY_CAR collector2
							//SET_CHAR_AS_LEADER collector2 collector1
						ENDIF
						collectors_state = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		GOSUB check_is_collector_in_zone
		//IF NOT LOCATE_CHAR_ANY_MEANS_2D collector1 collector_goto_zone_x collector_goto_zone_y collector_goto_zone_size_x collector_goto_zone_size_y FALSE
		IF flag_is_collector_in_zone = 0
			IF collectors_state = 3
				GOSUB print_leaving
				GOSUB get_next_place
			ENDIF
			collectors_state = 0
		ENDIF
		IF collectors_state = 1 // arrived at point
			IF NOT IS_CHAR_IN_ANY_CAR collector1 // gotta wait until we are out of the car
				arrived_at = current_place
				GOSUB get_route_pos
				//SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
				//SET_CHAR_OBJ_FOLLOW_ROUTE collector1 arrived_at FOLLOW_ROUTE_BACKFORWARD

				//SET_CHAR_OBJ_RUN_TO_COORD collector1 route_endX route_endY
				GOSUB start_walking_route_forward
				collectors_state = 2
				collector_stuck_timer2 = game_timer + 15000
			ELSE
				SET_CHAR_OBJ_LEAVE_ANY_CAR collector1
			ENDIF
		ELSE
			IF collectors_state = 2 // following route to the pickup
				GOSUB walk_the_route
				//IF IS_POINT_OBSCURED_BY_A_MISSION_ENTITY route_endX route_endY route_endZ 1.0 1.0 1.0
				//	SET_CHAR_OBJ_RUN_TO_COORD collector1 route_endX route_endY
				//ELSE
					IF no_obj_timer < game_timer
						IF player_near = 1 // go kill player i guess
							go_kill_player = 1
							go_kill_player_just_set = 1
							GOTO cap1_mission_loop // early exit
						ELSE
							IF NOT IS_POINT_ON_SCREEN route_endX route_endY route_endZ 2.0
							AND NOT IS_CHAR_ON_SCREEN collector1
							AND NOT LOCATE_PLAYER_ANY_MEANS_2D player1 route_endX route_endY 30.0 30.0 FALSE
							AND NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 30.0 30.0 FALSE
							//and NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY route_endX route_endY route_endZ 4.0 4.0 3.0
								SET_CHAR_COORDINATES collector1 route_endX route_endY route_endZ
								SET_CHAR_OBJ_NO_OBJ collector1
								no_obj_timer = game_timer + 5000
								flag_finished_walking_route = 1
							ENDIF
						ENDIF
					ELSE
						IF IS_CHAR_STUCK collector1
						AND collector_stuck_timer2 < game_timer
							IF player_near = 1 // go kill player i guess
								//PRINT_NOW GOKILL 3000 1 // debug
								SET_CHAR_OBJ_NO_OBJ collector1
								go_kill_player = 1
								go_kill_player_just_set = 1
								GOTO cap1_mission_loop // early exit
							ELSE
								IF NOT IS_POINT_ON_SCREEN route_endX route_endY route_endZ 2.0
								AND NOT IS_CHAR_ON_SCREEN collector1
								AND NOT LOCATE_PLAYER_ANY_MEANS_2D player1 route_endX route_endY 30.0 30.0 FALSE
								AND NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 30.0 30.0 FALSE
									SET_CHAR_COORDINATES collector1 route_endX route_endY route_endZ
									SET_CHAR_OBJ_NO_OBJ collector1
									flag_finished_walking_route = 1
								ENDIF
							ENDIF
						ELSE
							//SET_CHAR_OBJ_RUN_TO_COORD collector1 route_endX route_endY
						ENDIF
					ENDIF
				//ENDIF
				IF flag_finished_walking_route = 1
					IF arrived_at = final_destination
						PRINT_NOW CAP1_B8 5000 1 //~r~The collector has taxed all of your businesses.
						GOTO mission_finale1_failed
					ENDIF
					GOSUB give_revenue_to_collector
					GOSUB print_taxed
					GOSUB remove_asset_pickup
					GOSUB start_walking_route_backward2 // hack shit
					collectors_state = 3
					collector_stuck_timer2 = game_timer + 15000
				ENDIF
			ELSE
				IF collectors_state = 3 // left pickup, go back to the road
					GOSUB walk_the_route
					//IF IS_POINT_OBSCURED_BY_A_MISSION_ENTITY route_startX route_startY route_startZ 1.0 1.0 1.0
					//	SET_CHAR_OBJ_RUN_TO_COORD collector1 route_endX route_endY
					//ELSE
						IF no_obj_timer < game_timer
							IF player_near = 1 // go kill player i guess
								go_kill_player = 1
								go_kill_player_just_set = 1
								GOTO cap1_mission_loop // early exit
							ELSE
								IF NOT IS_POINT_ON_SCREEN route_startX route_startY route_startZ 2.0
								AND NOT IS_CHAR_ON_SCREEN collector1
								AND NOT LOCATE_PLAYER_ANY_MEANS_2D player1 route_startX route_startY 30.0 30.0 FALSE
								AND NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 30.0 30.0 FALSE
								//and NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY route_startX route_startY route_startZ 4.0 4.0 3.0
									SET_CHAR_COORDINATES collector1 route_startX route_startY route_startZ
									SET_CHAR_OBJ_NO_OBJ collector1
									no_obj_timer = game_timer + 5000
									flag_finished_walking_route = 1
								ENDIF
							ENDIF
						ELSE
							IF IS_CHAR_STUCK collector1
							AND collector_stuck_timer2 < game_timer
								IF player_near = 1 // go kill player i guess
									go_kill_player = 1
									go_kill_player_just_set = 1
									GOTO cap1_mission_loop // early exit
								ELSE
									IF NOT IS_POINT_ON_SCREEN route_startX route_startY route_startZ 2.0
									AND NOT IS_CHAR_ON_SCREEN collector1
									AND NOT LOCATE_PLAYER_ANY_MEANS_2D player1 route_startX route_startY 30.0 30.0 FALSE
									AND NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 30.0 30.0 FALSE
										SET_CHAR_COORDINATES collector1 route_startX route_startY route_startZ
										SET_CHAR_OBJ_NO_OBJ collector1
										flag_finished_walking_route = 1
									ENDIF
								ENDIF
							ELSE
								//SET_CHAR_OBJ_RUN_TO_COORD collector1 route_startX route_startY
							ENDIF
						ENDIF
					//ENDIF
					IF flag_finished_walking_route = 1
						//SET_CHAR_OBJ_NO_OBJ collector1
						//IF NOT IS_CAR_DEAD collector_car
						//	SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector1 collector_car
						//ENDIF
						collectors_state = 0
						GOSUB print_leaving
						GOSUB get_next_place
						IF current_place = 7
							PRINT_NOW CAP1_B8 5000 1 //~r~The collector has taxed all of your businesses.
							GOTO mission_finale1_failed
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF
	
	//GOTO mission_finale1_passed

	GOTO cap1_mission_loop
	
// Mission Finale 1 failed

mission_finale1_failed:
PRINT_BIG M_FAIL 5000 1
IF play_audio_1 = 2
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
		WAIT 0
	ENDWHILE
ENDIF
IF play_audio_2 = 2
	WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
		WAIT 0
	ENDWHILE
ENDIF
RETURN

   

// mission Finale 1 passed

mission_finale1_passed:

flag_finale_mission1_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 30000 5000 1
ADD_SCORE player1 30000
CLEAR_WANTED_LEVEL player1
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED CAP_1
PLAYER_MADE_PROGRESS 1
REMOVE_BLIP counter_contact_blip
ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD counterX counterY counterZ the_counter_blip counter_contact_blip
REMOVE_PICKUP printworks_cash_pickup
CREATE_PROTECTION_PICKUP printbuyX printbuyY printbuyZ printworks_revenue printworks_revenue printworks_cash_pickup
//START_NEW_SCRIPT finale_mission2_loop
RETURN



// mission cleanup

mission_cleanup_finale1:

/*REMOVE_ROUTE 1
REMOVE_ROUTE 2
REMOVE_ROUTE 3
REMOVE_ROUTE 4
REMOVE_ROUTE 5
REMOVE_ROUTE 6*/

IF boatyard_cash_pickup_removed = 1
	REMOVE_PICKUP boatyard_cash_pickup
	CREATE_PROTECTION_PICKUP boatcashX boatcashY boatcashZ boatyard_revenue boatyard_revenue boatyard_cash_pickup 
	REMOVE_BLIP boatbuy_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -664.1 -1476.3 13.8 RADAR_SPRITE_BOATYARD boatbuy_blip
	CHANGE_BLIP_DISPLAY boatbuy_blip BLIP_ONLY
ENDIF

IF showroom_cash_pickup_removed = 1
	REMOVE_PICKUP showroom_cash_pickup
	CREATE_PROTECTION_PICKUP carbuyX carbuyY carbuyZ showroom_revenue showroom_revenue showroom_cash_pickup 
	REMOVE_BLIP carbuy_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT carbuyX carbuyY carbuyZ RADAR_SPRITE_SUNYARD carbuy_blip
	CHANGE_BLIP_DISPLAY carbuy_blip BLIP_ONLY
ENDIF

IF icecream_cash_pickup_removed = 1
	REMOVE_PICKUP icecream_cash_pickup
	CREATE_PROTECTION_PICKUP icebuyX icebuyY icebuyZ icecream_revenue icecream_revenue icecream_cash_pickup 
	REMOVE_BLIP icebuy_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_CONTACT_POINT -878.5 -575.1 11.2 RADAR_SPRITE_ICE icebuy_blip
	CHANGE_BLIP_DISPLAY icebuy_blip BLIP_ONLY
ENDIF

IF taxifirm_cash_pickup_removed = 1
	REMOVE_PICKUP taxifirm_cash_pickup
	CREATE_PROTECTION_PICKUP taxicashX taxicashY taxicashZ taxifirm_revenue taxifirm_revenue taxifirm_cash_pickup 
	REMOVE_BLIP taxiwar_contact_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD taxiwarX taxiwarY taxiwarZ the_taxiwar_blip taxiwar_contact_blip
ENDIF

IF porn_cash_pickup_removed = 1
	REMOVE_PICKUP porn_cash_pickup
	CREATE_PROTECTION_PICKUP porncashX porncashY porncashZ porn_revenue porn_revenue porn_cash_pickup
	REMOVE_BLIP porn_contact_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD porncashX porncashY porncashZ	the_porn_blip porn_contact_blip
ENDIF

IF malibu_cash_pickup_removed = 1
	REMOVE_PICKUP malibu_cash_pickup
	CREATE_PROTECTION_PICKUP bankbuyX bankbuyY bankbuyZ malibu_revenue malibu_revenue malibu_cash_pickup 
	REMOVE_BLIP bankjob_contact_blip
	ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD bankbuyx bankbuyy bankbuyz the_bankjob_blip bankjob_contact_blip
ENDIF

CLEAR_THIS_PRINT CAP1_5
CLEAR_THIS_PRINT CAP1_6

REMOVE_CHAR_ELEGANTLY collector1
REMOVE_CHAR_ELEGANTLY collector2

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED M4
MARK_MODEL_AS_NO_LONGER_NEEDED CHROMEGUN
MARK_MODEL_AS_NO_LONGER_NEEDED SANCHEZ

REMOVE_BLIP collector_blip

/*REMOVE_BLIP icecream_blip
REMOVE_BLIP taxifirm_blip
REMOVE_BLIP boatyard_blip
REMOVE_BLIP showroom_blip
REMOVE_BLIP malibu_blip
REMOVE_BLIP porn_blip*/

SET_GENERATE_CARS_AROUND_CAMERA FALSE
//REMOVE_STUCK_CAR_CHECK collector_car
SET_PLAYER_MOOD player1 PLAYER_MOOD_ANGRY 60000

GET_GAME_TIMER timer_mobile_start

flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN

////////////////////////////////////////////////////////////////////////////
print_arrived://///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
IF current_place = 1
	PRINT_NOW CAP1_C2 5000 1 //~g~The Mafia has arrived at the Boatyard!
	RETURN
ENDIF
IF current_place = 2
	PRINT_NOW CAP1_C4 5000 1 //~g~The Mafia has arrived at the Car Showroom!
	RETURN
ENDIF
IF current_place = 3
	PRINT_NOW CAP1_C3 5000 1 //~g~The Mafia has arrived at the Ice Cream Factory!
	RETURN
ENDIF
IF current_place = 4
	PRINT_NOW CAP1_C5 5000 1 //~g~The Mafia has arrived at the Taxi Firm!
	RETURN
ENDIF
IF current_place = 5
	PRINT_NOW CAP1_C0 5000 1 //~g~The mafia has arrived at the film studio!
	RETURN
ENDIF
IF current_place = 6
	PRINT_NOW CAP1_C9 5000 1 //~g~The mafia has arrived at The Malibu!
	RETURN
ENDIF
RETURN

////////////////////////////////////////////////////////////////////////////
print_taxed://///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
IF arrived_at = 1
	PRINT_NOW CAP1_B2 5000 1 //~g~The mafia has taxed the boat yard!
	RETURN
ENDIF
IF arrived_at = 2
	PRINT_NOW CAP1_B4 5000 1 //~g~The mafia has taxed the car showroom!
	RETURN
ENDIF
IF arrived_at = 3
	PRINT_NOW CAP1_B3 5000 1 //~g~The mafia has taxed the icecream factory!
	RETURN
ENDIF
IF arrived_at = 4
	PRINT_NOW CAP1_B5 5000 1 //~g~The mafia has taxed the taxi firm!
	RETURN
ENDIF
IF arrived_at = 5
	PRINT_NOW CAP1_B0 5000 1 //~g~The mafia has taxed the film studio!
	RETURN
ENDIF
IF arrived_at = 6
	PRINT_NOW CAP1_B9 5000 1 //~g~The mafia has taxed The Malibu!
	RETURN
ENDIF
RETURN

////////////////////////////////////////////////////////////////////////////
print_leaving://///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
IF arrived_at = 1
	PRINT_NOW CAP1_D2 5000 1 //~g~The Mafia is leaving the Boatyard!
	RETURN
ENDIF
IF arrived_at = 2
	PRINT_NOW CAP1_D4 5000 1 //~g~The Mafia is leaving the Car Showroom!
	RETURN
ENDIF
IF arrived_at = 3
	PRINT_NOW CAP1_D3 5000 1 //~g~The Mafia is leaving the Ice Cream Factory!
	RETURN
ENDIF
IF arrived_at = 4
	PRINT_NOW CAP1_D5 5000 1 //~g~The Mafia is leaving the Taxi Firm!
	RETURN
ENDIF
IF arrived_at = 5
	PRINT_NOW CAP1_D0 5000 1 //~g~The mafia is leaving the film studio!
	RETURN
ENDIF
IF arrived_at = 6
	PRINT_NOW CAP1_D9 5000 1 //~g~The mafia is leaving The Malibu!
	RETURN
ENDIF
RETURN

////////////////////////////////////////////////////////////////////////////
give_revenue_to_collector://////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
IF IS_CHAR_DEAD collector1
	RETURN
ENDIF
IF arrived_at = 1
	collector_cash += boatyard_revenue
	SET_CHAR_MONEY collector1 collector_cash
	RETURN
ENDIF
IF arrived_at = 2
	collector_cash += showroom_revenue
	SET_CHAR_MONEY collector1 collector_cash
	RETURN
ENDIF
IF arrived_at = 3
	collector_cash += icecream_revenue
	SET_CHAR_MONEY collector1 collector_cash
	RETURN
ENDIF
IF arrived_at = 4
	collector_cash += taxifirm_revenue
	SET_CHAR_MONEY collector1 collector_cash
	RETURN
ENDIF
IF arrived_at = 5
	collector_cash += porn_revenue
	SET_CHAR_MONEY collector1 collector_cash
	RETURN
ENDIF
IF arrived_at = 6
	collector_cash += malibu_revenue
	SET_CHAR_MONEY collector1 collector_cash
	RETURN
ENDIF
RETURN

remove_asset_pickup:
	IF arrived_at = 1
		REMOVE_PICKUP boatyard_cash_pickup
		REMOVE_BLIP boatbuy_blip
		boatyard_cash_pickup_removed = 1
		RETURN
	ENDIF
	IF arrived_at = 2
		REMOVE_PICKUP showroom_cash_pickup
		REMOVE_BLIP carbuy_blip
		showroom_cash_pickup_removed = 1
		RETURN
	ENDIF
	IF arrived_at = 3
		REMOVE_PICKUP icecream_cash_pickup
		REMOVE_BLIP icebuy_blip
		icecream_cash_pickup_removed = 1
		RETURN
	ENDIF
	IF arrived_at = 4
		REMOVE_PICKUP taxifirm_cash_pickup
		REMOVE_BLIP taxiwar_contact_blip
		taxifirm_cash_pickup_removed = 1
		RETURN
	ENDIF
	IF arrived_at = 5
		REMOVE_PICKUP porn_cash_pickup
		REMOVE_BLIP porn_contact_blip
		porn_cash_pickup_removed = 1
		RETURN
	ENDIF
	IF arrived_at = 6
		REMOVE_PICKUP malibu_cash_pickup
		REMOVE_BLIP bankjob_contact_blip
		malibu_cash_pickup_removed = 1
		RETURN
	ENDIF

	RETURN


////////////////////////////////////////////////////////////////////////////
get_next_place://///////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

	IF boatyard_asset_acquired = 1
	AND current_place < 1
		//collector_goto_x = -726.0752//BOATYARD
		//collector_goto_y = -1494.4872
		//collector_goto_z = 10.3799
		collector_goto_x = -695.0752//BOATYARD
		collector_goto_y = -1485.4872
		collector_goto_z = 10.3799

		collector_goto_zone_x = -661.425
		collector_goto_zone_y = -1515.125
		collector_goto_zone_size_x = 87.915
		collector_goto_zone_size_y = 88.575

		current_place = 1
		RETURN
	ENDIF
	IF showroom_asset_acquired = 1
	AND current_place < 2
		collector_goto_x = -1025.1687//SHOWROOM
		collector_goto_y = -904.9712
		collector_goto_z = 13.2096

		collector_goto_zone_x = -1001.285
		collector_goto_zone_y = -868.865
		collector_goto_zone_size_x = 70.855
		collector_goto_zone_size_y = 66.265

		current_place = 2
		RETURN
	ENDIF
	IF icecream_asset_acquired = 1
	AND current_place < 3
		collector_goto_x = -852.5533//ICECREAM
		collector_goto_y = -568.4194
		collector_goto_z = 10.0567
		
		collector_goto_zone_x = -852.020
		collector_goto_zone_y = -596.325
		collector_goto_zone_size_x = 40.220
		collector_goto_zone_size_y = 70.725

		current_place = 3
		RETURN
	ENDIF
	IF taxifirm_asset_acquired = 1
	AND current_place < 4
		collector_goto_x = -1016.2645//TAXIFIRM
		collector_goto_y = 199.9105
		collector_goto_z = 10.2062

		collector_goto_zone_x = -1004.650
		collector_goto_zone_y = 185.130
		collector_goto_zone_size_x = 42.090
		collector_goto_zone_size_y = 42.090

		current_place = 4
		RETURN
	ENDIF
	IF porn_asset_acquired = 1
	AND current_place < 5
		collector_goto_x = 17.6185//PORN
		collector_goto_y = 962.1060 
		collector_goto_z = 9.727

		collector_goto_zone_x = -4.535
		collector_goto_zone_y = 942.275
		collector_goto_zone_size_x = 121.005
		collector_goto_zone_size_y = 111.445

		current_place = 5
		RETURN
	ENDIF
	IF malibu_asset_acquired = 1
	AND current_place < 6
		collector_goto_x = 506.2871//MALIBU
		collector_goto_y = -82.8296
		collector_goto_z = 9.2532

		collector_goto_zone_x = 484.280
		collector_goto_zone_y = -94.670
		collector_goto_zone_size_x = 58.830
		collector_goto_zone_size_y = 61.700

		current_place = 6
		RETURN
	ENDIF
	current_place = 7

	RETURN

get_route_pos:
	IF arrived_at = 1
		//route_startX = -725.3655
		//route_startY = -1501.6598
		//route_startZ = 10.8
		route_startX = -691.3655
		route_startY = -1486.6598
		route_startZ = 10.8
		route_endX = boatcashX
		route_endY = boatcashY
		route_endZ = boatcashZ

		route_point_count = 5

		route_point1_x = -691.3655
		route_point1_y = -1486.6598
		route_point1_z = 10.8

		route_point2_x = -681.0613
		route_point2_y = -1490.4276
		route_point2_z = 10.8

		route_point3_x = -636.2616
		route_point3_y = -1500.1516
		route_point3_z = 10.8

		route_point4_x = -642.8112
		route_point4_y = -1496.4293
		route_point4_z = 10.8

		route_point5_x = boatcashX
		route_point5_y = boatcashY
		route_point5_z = boatcashZ

		GET_DISTANCE_BETWEEN_COORDS_2D route_point1_x route_point1_y route_point2_x route_point2_y route_dist_1to2
		GET_DISTANCE_BETWEEN_COORDS_2D route_point2_x route_point2_y route_point3_x route_point3_y route_dist_2to3
		GET_DISTANCE_BETWEEN_COORDS_2D route_point3_x route_point3_y route_point4_x route_point4_y route_dist_3to4
		GET_DISTANCE_BETWEEN_COORDS_2D route_point4_x route_point4_y route_point5_x route_point5_y route_dist_4to5

		RETURN
	ENDIF
	IF arrived_at = 2
		route_startX = -1023.7896
		route_startY = -901.9847
		route_startZ = 13.8
		route_endX = carbuyX
		route_endY = carbuyY
		route_endZ = carbuyZ

		route_point_count = 2

		route_point1_x = -1023.7896
		route_point1_y = -901.9847
		route_point1_z = 13.8

		route_point2_x = carbuyX
		route_point2_y = carbuyY
		route_point2_z = carbuyZ

		GET_DISTANCE_BETWEEN_COORDS_2D route_point1_x route_point1_y route_point2_x route_point2_y route_dist_1to2

		RETURN
	ENDIF
	IF arrived_at = 3
		route_startX = icebuyX
		route_startY = icebuyY
		route_startZ = icebuyZ
		route_endX = icebuyX
		route_endY = icebuyY
		route_endZ = icebuyZ

		route_point_count = 1

		route_point1_x = icebuyX
		route_point1_y = icebuyY
		route_point1_z = icebuyZ

		route_dist_1to2 = 0.0

		RETURN
	ENDIF
	IF arrived_at =  4
		route_startX = -1009.2858
		route_startY = 196.7185
		route_startZ = 10.5
		route_endX = taxicashX
		route_endY = taxicashY
		route_endZ = taxicashZ

		route_point_count = 2

		route_point1_x = -1009.2858
		route_point1_y = 196.7185
		route_point1_z = 10.5

		route_point2_x = taxicashX
		route_point2_y = taxicashY
		route_point2_z = taxicashZ

		GET_DISTANCE_BETWEEN_COORDS_2D route_point1_x route_point1_y route_point2_x route_point2_y route_dist_1to2

		RETURN
	ENDIF
	IF arrived_at = 5
		route_startX = 12.2850
		route_startY = 963.0108
		route_startZ = 10.5
		route_endX = porncashX
		route_endY = porncashY
		route_endZ = porncashZ

		route_point_count = 2

		route_point1_x = 12.2850
		route_point1_y = 963.0108
		route_point1_z = 10.5

		route_point2_x = porncashX
		route_point2_y = porncashY
		route_point2_z = porncashZ

		GET_DISTANCE_BETWEEN_COORDS_2D route_point1_x route_point1_y route_point2_x route_point2_y route_dist_1to2
		RETURN
	ENDIF
	IF arrived_at = 6
		route_startX = 501.5787
		route_startY = -81.7690
		route_startZ = 9.5
		route_endX = bankbuyX
		route_endY = bankbuyY
		route_endZ = bankbuyZ

		route_point_count = 2

		route_point1_x = 501.5787
		route_point1_y = -81.7690
		route_point1_z = 9.5

		route_point2_x = 491.7617
		route_point2_y = -78.5777
		route_point2_z = 9.5

		route_point3_x = bankbuyX
		route_point3_y = bankbuyY
		route_point3_z = bankbuyZ

		GET_DISTANCE_BETWEEN_COORDS_2D route_point1_x route_point1_y route_point2_x route_point2_y route_dist_1to2
		GET_DISTANCE_BETWEEN_COORDS_2D route_point2_x route_point2_y route_point3_x route_point3_y route_dist_2to3
		RETURN
	ENDIF
	RETURN

get_path_length_from_point:
	LVAR_INT in_start_point
	LVAR_FLOAT out_cur_distance

	out_cur_distance = 0.0

	IF in_start_point = 1
		GET_DISTANCE_BETWEEN_COORDS_2D x y route_point1_x route_point1_y out_cur_distance
	ENDIF

	IF in_start_point = 2
		GET_DISTANCE_BETWEEN_COORDS_2D x y route_point2_x route_point2_y out_cur_distance
	ENDIF

	IF in_start_point = 3
		GET_DISTANCE_BETWEEN_COORDS_2D x y route_point3_x route_point3_y out_cur_distance
	ENDIF

	IF in_start_point = 4
		GET_DISTANCE_BETWEEN_COORDS_2D x y route_point4_x route_point4_y out_cur_distance
	ENDIF

	IF in_start_point = 5
		GET_DISTANCE_BETWEEN_COORDS_2D x y route_point5_x route_point5_y out_cur_distance
	ENDIF

	IF flag_route_go_backwards = 0
		IF in_start_point <= 1
		AND route_point_count > 1
			out_cur_distance += route_dist_1to2
		ENDIF
		IF in_start_point <= 2
		AND route_point_count > 2
			out_cur_distance += route_dist_2to3
		ENDIF
		IF in_start_point <= 3
		AND route_point_count > 3
			out_cur_distance += route_dist_3to4
		ENDIF
		IF in_start_point <= 4
		AND route_point_count > 4
			out_cur_distance += route_dist_4to5
		ENDIF
	ELSE
		IF in_start_point >= 5
		AND route_point_count > 4
			out_cur_distance += route_dist_4to5
		ENDIF
		IF in_start_point >= 4
		AND route_point_count > 3
			out_cur_distance += route_dist_3to4
		ENDIF
		IF in_start_point >= 3
		AND route_point_count > 2
			out_cur_distance += route_dist_2to3
		ENDIF
		IF in_start_point >= 2
		AND route_point_count > 1
			out_cur_distance += route_dist_1to2
		ENDIF
	ENDIF
	RETURN

get_closest_route_point_for_collector:
	LVAR_FLOAT closest_distance second_closest_distance
	LVAR_INT second_closest_point

	closest_point = 1
	second_closest_point = 2
	IF route_point_count = 1
		RETURN
	ENDIF

	GET_CHAR_COORDINATES collector1 x y z
	GET_DISTANCE_BETWEEN_COORDS_2D x y route_point1_x route_point1_y closest_distance
	GET_DISTANCE_BETWEEN_COORDS_2D x y route_point2_x route_point2_y second_closest_distance
	
	IF second_closest_distance < closest_distance
		closest_point = 2
		second_closest_point = 1
		temp_float = second_closest_distance
		second_closest_distance = closest_distance
		closest_distance = temp_float
	ENDIF

	IF route_point_count > 2

		GET_DISTANCE_BETWEEN_COORDS_2D x y route_point3_x route_point3_y temp_float

		IF temp_float < closest_distance
			closest_point = 3
			closest_distance = temp_float
		ELSE
			IF temp_float < second_closest_distance
				second_closest_point = 3
				second_closest_distance = temp_float
			ENDIF
		ENDIF

		IF route_point_count > 3
			GET_DISTANCE_BETWEEN_COORDS_2D x y route_point4_x route_point4_y temp_float

			IF temp_float < closest_distance
				closest_point = 4
				closest_distance = temp_float
			ELSE
				IF temp_float < second_closest_distance
					second_closest_point = 4
					second_closest_distance = temp_float
				ENDIF
			ENDIF

			IF route_point_count > 4
				GET_DISTANCE_BETWEEN_COORDS_2D x y route_point5_x route_point5_y temp_float

				IF temp_float < closest_distance
					closest_point = 5
					closest_distance = temp_float
				ELSE
					IF temp_float < second_closest_distance
						second_closest_point = 5
						second_closest_distance = temp_float
					ENDIF
				ENDIF
			ENDIF
		ENDIF

		in_start_point = closest_point
		GOSUB get_path_length_from_point
		closest_distance = out_cur_distance

		in_start_point = second_closest_point
		GOSUB get_path_length_from_point

		IF out_cur_distance < closest_distance
			closest_point = second_closest_point
		ENDIF
	ENDIF

	RETURN

start_walking_route_forward:
	flag_route_go_backwards = 0
	flag_finished_walking_route = 0
	GOSUB get_closest_route_point_for_collector
	current_route_point = closest_point
	GOSUB get_route_point
	SET_CHAR_OBJ_RUN_TO_COORD collector1 current_route_point_x current_route_point_y
	SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
	RETURN

start_walking_route_backward:
	flag_route_go_backwards = 1
	flag_finished_walking_route = 0
	GOSUB get_closest_route_point_for_collector
	current_route_point = closest_point
	GOSUB get_route_point
	SET_CHAR_OBJ_RUN_TO_COORD collector1 current_route_point_x current_route_point_y
	SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
	RETURN

start_walking_route_backward2: // hack shit
	flag_route_go_backwards = 1
	flag_finished_walking_route = 0
	GOSUB get_closest_route_point_for_collector
	current_route_point = route_point_count
	GOSUB get_route_point
	SET_CHAR_OBJ_RUN_TO_COORD collector1 current_route_point_x current_route_point_y
	SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
	RETURN

get_route_point:
	IF current_route_point = 1
		current_route_point_x = route_point1_x
		current_route_point_y = route_point1_y
		current_route_point_z = route_point1_z
		RETURN
	ENDIF
	IF current_route_point = 2
		current_route_point_x = route_point2_x
		current_route_point_y = route_point2_y
		current_route_point_z = route_point2_z
		RETURN
	ENDIF
	IF current_route_point = 3
		current_route_point_x = route_point3_x
		current_route_point_y = route_point3_y
		current_route_point_z = route_point3_z
		RETURN
	ENDIF
	IF current_route_point = 4
		current_route_point_x = route_point4_x
		current_route_point_y = route_point4_y
		current_route_point_z = route_point4_z
		RETURN
	ENDIF
	IF current_route_point = 5
		current_route_point_x = route_point5_x
		current_route_point_y = route_point5_y
		current_route_point_z = route_point5_z
		RETURN
	ENDIF
	RETURN

walk_the_route:
	IF LOCATE_CHAR_ON_FOOT_2D collector1 current_route_point_x current_route_point_y 1.0 1.0 0
		IF flag_route_go_backwards = 1
			IF current_route_point = 0
				flag_finished_walking_route = 1
				RETURN
			ENDIF
			-- current_route_point

			// hacking shit at the boatyard
			IF route_point_count = 5
			AND current_route_point <= 3
				route_point_count = 3
			ENDIF
		ELSE
			IF current_route_point = route_point_count
				flag_finished_walking_route = 1
				RETURN
			ENDIF
			++ current_route_point
		ENDIF
		GOSUB get_route_point
		SET_CHAR_OBJ_RUN_TO_COORD collector1 current_route_point_x current_route_point_y
		SET_CHAR_USE_PEDNODE_SEEK collector1 FALSE
	ENDIF
	RETURN

check_is_collector_in_zone:
	VAR_INT flag_is_collector_in_zone
	flag_is_collector_in_zone = 0
	IF current_place = 1
		//IF IS_CHAR_IN_ZONE collector1 BOATYRD
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -613.689 -1474.135 31.950 21.445 0
			flag_is_collector_in_zone = 1
		ENDIF
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -599.898 -1517.020 45.740 21.440 0
			flag_is_collector_in_zone = 1
		ENDIF
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -670.639 -1480.280 25.000 31.990 0
			flag_is_collector_in_zone = 1
		ENDIF
		RETURN
	ENDIF
	IF current_place = 2
		//IF IS_CHAR_IN_ZONE collector1 CARYRD
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -1010.121 -858.923 50.419 51.740 0
			flag_is_collector_in_zone = 1
		ENDIF
		RETURN
	ENDIF
	IF current_place = 3
		//IF IS_CHAR_IN_ZONE collector1 ICCREAM
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -880.901 -583.136 30.013 13.243 0
			flag_is_collector_in_zone = 1
		ENDIF
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -880.902 -556.400 30.012 13.493 0
			flag_is_collector_in_zone = 1
		ENDIF
		RETURN
	ENDIF
	IF current_place = 4
		//IF IS_CHAR_IN_ZONE collector1 KAUFCAB
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -1004.698 200.334 10.663 21.421 0
			flag_is_collector_in_zone = 1
		ENDIF
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -986.618 197.896 6.765 21.421 0
			flag_is_collector_in_zone = 1
		ENDIF
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -1014.698 200.334 4.0 4.0 0
			flag_is_collector_in_zone = 1
		ENDIF
		RETURN
	ENDIF
	IF current_place = 5
		//IF IS_CHAR_IN_ZONE collector1 PORNSTU
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 -60.353 948.896 76.050 96.854 0
			flag_is_collector_in_zone = 1
		ENDIF
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 15.2 962.6 3.0 3.0 0
			flag_is_collector_in_zone = 1
		ENDIF
		RETURN
	ENDIF
	IF current_place = 6
		IF LOCATE_CHAR_ANY_MEANS_2D collector1 484.280 -94.670 58.830 61.700 0
			flag_is_collector_in_zone = 1
		ENDIF
		RETURN
	ENDIF
	RETURN

spawn_collectors:
	collectors_state = 0
	IF collectors_wave = 0
		x = -866.8224
		y = -448.5860
		z = 9.8801
		heading = 198.0000
	ENDIF
	IF collectors_wave = 1
		x = -830.2028
		y = 756.1009
		z = 9.8816
		heading = 264.7463
	ENDIF
	IF collectors_wave = 2
		x = -301.5698
		y = 1245.7740
		z = 9.8718
		heading = 181.6262
	ENDIF

	CREATE_CAR SANCHEZ x y z collector_car
	SET_CAR_HEADING collector_car heading
	SET_CAR_ONLY_DAMAGED_BY_PLAYER collector_car TRUE
	SET_CAR_CHANGE_LANE collector_car FALSE
	SET_CAR_FORWARD_SPEED collector_car 10.0
	
	//ADD_STUCK_CAR_CHECK collector_car 1.0 4000
	ADD_UPSIDEDOWN_CAR_CHECK collector_car

	CREATE_CHAR_INSIDE_CAR collector_car PEDTYPE_CIVMALE SPECIAL01 collector1
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER collector1 TRUE


	GIVE_WEAPON_TO_CHAR collector1 WEAPONTYPE_M4 9999
	CLEAR_CHAR_THREAT_SEARCH collector1
	//SET_CHAR_THREAT_SEARCH collector1 THREAT_PLAYER1
	SET_CHAR_PERSONALITY collector1 PEDSTAT_TOUGH_GUY
	SET_CHAR_HEALTH	collector1 250
	SET_CHAR_CEASE_ATTACK_TIMER collector1 1150
	SET_CHAR_HEED_THREATS collector1 TRUE
	//SET_CHAR_STAY_IN_SAME_PLACE	collector1 TRUE
	SET_CHAR_RUNNING collector1 TRUE
	SET_CHAR_MONEY collector1 0

	CREATE_CHAR_AS_PASSENGER collector_car PEDTYPE_CIVMALE SPECIAL02 0 collector2
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER collector2 TRUE


	GIVE_WEAPON_TO_CHAR collector2 WEAPONTYPE_SHOTGUN 9999
	CLEAR_CHAR_THREAT_SEARCH collector2
	//SET_CHAR_THREAT_SEARCH collector2 THREAT_PLAYER1
	SET_CHAR_PERSONALITY collector2 PEDSTAT_TOUGH_GUY
	SET_CHAR_HEALTH	collector2 250
	//SET_CHAR_CEASE_ATTACK_TIMER collector2 1000
	SET_CHAR_HEED_THREATS collector2 TRUE
	//SET_CHAR_STAY_IN_SAME_PLACE	collector2 TRUE
	SET_CHAR_RUNNING collector2 TRUE
	SET_CHAR_AS_LEADER collector2 collector1
	SET_CHAR_MONEY collector2 0

	collector_in_car = 1

	CAR_GOTO_COORDINATES_ACCURATE collector_car collector_goto_x collector_goto_y collector_goto_z
	SET_CAR_CRUISE_SPEED collector_car 40.0
	SET_CAR_DRIVING_STYLE collector_car 2

	collector_cash = 0
	arrived_at = 0
	go_kill_player = 0
	flag_audio_just_noticed_player = 0
	flag_is_collector1_in_car = 1
	flag_hack_clear_obj_when_exiting_car = 0
	waiting_for_second_collector = 0
	waiting_for_second_collector_timer = 0
	RETURN

process_audio_finish:

	IF play_audio_1 = 1
		IF HAS_MISSION_AUDIO_LOADED 1
			IF IS_PLAYER_DEAD player1
				CLEAR_MISSION_AUDIO 1
				play_audio_1 = 0
				RETURN
			ENDIF
			PLAY_MISSION_AUDIO 1
			IF player_audio_flag = 1
				PRINT_NOW CAP1_5 10000 1//You tell Sonny - stay away
			ELSE
				PRINT_NOW CAP1_6 10000 1//Vice City is MINE now, NOT his.
			ENDIF
			play_audio_1 = 2
		ENDIF
	ENDIF
	IF play_audio_1 = 2
		IF HAS_MISSION_AUDIO_FINISHED 1
			IF player_audio_flag = 1
				CLEAR_THIS_PRINT CAP1_5
			ELSE
				CLEAR_THIS_PRINT CAP1_6
			ENDIF
			play_audio_1 = 0
		ELSE
			IF IS_PLAYER_DEAD player1
				IF player_audio_flag = 1
					CLEAR_THIS_PRINT CAP1_5
				ELSE
					CLEAR_THIS_PRINT CAP1_6
				ENDIF
				CLEAR_MISSION_AUDIO 1
				play_audio_1 = 0
				RETURN
			ENDIF
		ENDIF
	ENDIF

	IF play_audio_2 = 1
		IF HAS_MISSION_AUDIO_LOADED 2
			IF NOT IS_CHAR_DEAD collector1
				GET_CHAR_COORDINATES collector1 x y z
				SET_MISSION_AUDIO_POSITION 2 x y z
				PLAY_MISSION_AUDIO 2
				play_audio_2 = 2
			ELSE
				CLEAR_MISSION_AUDIO 2
				play_audio_2 = 0
				RETURN
			ENDIF
		ENDIF
	ENDIF
	IF play_audio_2 = 2
		IF HAS_MISSION_AUDIO_FINISHED 2
			play_audio_2 = 0
		ELSE
			IF IS_CHAR_DEAD collector1
				CLEAR_MISSION_AUDIO 2
				play_audio_2 = 0
				RETURN
			ELSE
				GET_CHAR_COORDINATES collector1 x y z
				SET_MISSION_AUDIO_POSITION 2 x y z
			ENDIF
		ENDIF
	ENDIF
	RETURN

process_audio:
	IF NOT IS_PLAYER_DEAD player1
		IF NOT IS_CHAR_DEAD collector1
			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 40.0 40.0 0
				GET_GAME_TIMER game_timer
				IF IS_PLAYER_SHOOTING player1
				OR flag_collector_just_capped = 1
					IF play_audio_1 = 0
					AND game_timer > player_audio_timer
						IF player_audio_flag = 0
							LOAD_MISSION_AUDIO 1 CAP1_5
							player_audio_flag ++
							play_audio_1 = 1
							player_audio_timer = game_timer + 3000
							RETURN
						ENDIF

						IF player_audio_flag = 1
							LOAD_MISSION_AUDIO 1 CAP1_6
							player_audio_flag = 0
							play_audio_1 = 1
							player_audio_timer = game_timer + 20000
							RETURN
						ENDIF
					ENDIF
				ENDIF
				IF flag_audio_just_noticed_player = 1
					flag_audio_just_noticed_player = 0
					IF play_audio_2 = 0
					AND game_timer > collector_audio_timer
						IF collector_audio_flag = 0
							LOAD_MISSION_AUDIO 2 CAP1_4
							collector_audio_flag ++
							play_audio_2 = 1
							collector_audio_timer = game_timer + 3000
							RETURN
						ENDIF
						IF collector_audio_flag = 1
							LOAD_MISSION_AUDIO 2 CAP1_2
							collector_audio_flag ++
							play_audio_2 = 1
							collector_audio_timer = game_timer + 3000
							RETURN
						ENDIF
						IF collector_audio_flag = 2
							LOAD_MISSION_AUDIO 2 CAP1_3
							collector_audio_flag = 0
							play_audio_2 = 1
							collector_audio_timer = game_timer + 3000
							RETURN
						ENDIF
					ENDIF
				ELSE
					IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR scplayer collector1
						CLEAR_CHAR_LAST_DAMAGE_ENTITY scplayer
						IF play_audio_2 = 0
						AND game_timer > collector_audio_timer
							IF collector_audio_flag2 = 0
								LOAD_MISSION_AUDIO 2 CAP1_12
								collector_audio_flag2 ++
								play_audio_2 = 1
								collector_audio_timer = game_timer + 3000
								RETURN
							ENDIF
							IF collector_audio_flag2 = 1
								LOAD_MISSION_AUDIO 2 CAP1_8
								collector_audio_flag2 ++
								play_audio_2 = 1
								collector_audio_timer = game_timer + 3000
								RETURN
							ENDIF
							IF collector_audio_flag2 = 2
								LOAD_MISSION_AUDIO 2 CAP1_9
								collector_audio_flag2 ++
								play_audio_2 = 1
								collector_audio_timer = game_timer + 3000
								RETURN
							ENDIF
							IF collector_audio_flag2 = 3
								LOAD_MISSION_AUDIO 2 CAP1_7
								collector_audio_flag2 ++
								play_audio_2 = 1
								collector_audio_timer = game_timer + 3000
								RETURN
							ENDIF
							IF collector_audio_flag2 = 4
								LOAD_MISSION_AUDIO 2 CAP1_10
								collector_audio_flag2 ++
								play_audio_2 = 1
								collector_audio_timer = game_timer + 3000
								RETURN
							ENDIF
							IF collector_audio_flag2 = 5
								LOAD_MISSION_AUDIO 2 CAP1_11
								collector_audio_flag2 = 0
								play_audio_2 = 1
								collector_audio_timer = game_timer + 3000
								RETURN
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ENDIF

RETURN
}

cleanup_collector_car:
	//REMOVE_STUCK_CAR_CHECK collector_car
	REMOVE_UPSIDEDOWN_CAR_CHECK collector_car
	MARK_CAR_AS_NO_LONGER_NEEDED collector_car
	collector_car = -1
	collector_in_car = 0
	RETURN



////////////////////////////////////////////////////////////////////////////
collector_steal_a_car: /////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	collector1
	IF heading = 919.9
		CREATE_CAR SANCHEZ	coord_1_x coord_1_y coord_1_z car
	ENDIF

	GET_CHAR_COORDINATES collector1 coord_1_x coord_1_y coord_1_z

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 collector1 40.0 40.0 0
try_to_find_car:
		coord_2_x = coord_1_x + 40.0
		coord_2_y = coord_1_y + 40.0
		coord_1_x = coord_1_x - 40.0
		coord_1_y = coord_1_y - 40.0
		MARK_CAR_AS_NO_LONGER_NEEDED car
		car = -1
		GET_RANDOM_CAR_OF_TYPE_IN_AREA coord_1_x coord_1_y coord_2_x coord_2_y -1 car
		IF car = -1
		//OR collector1_car = car
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT collector1 player1
		ELSE
			IF IS_CAR_HEALTH_GREATER car 400
				GET_NUMBER_OF_FOLLOWERS collector1 num_of_followers
				GET_MAXIMUM_NUMBER_OF_PASSENGERS car max_passengers
				LOCK_CAR_DOORS car CARLOCK_UNLOCKED
				SET_CAR_CRUISE_SPEED car 0.0
				SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector1 car
				//ADD_STUCK_CAR_CHECK car 1.0 4000
				ADD_UPSIDEDOWN_CAR_CHECK car
				//IF NOT IS_CHAR_DEAD collector2
				//	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER collector2 car
				//ENDIF
				collector_car = car
				car = -1
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT collector1 player1
				MARK_CAR_AS_NO_LONGER_NEEDED car
				car = -1
			ENDIF
		ENDIF
	ELSE
		GET_CLOSEST_CAR_NODE_WITH_HEADING coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z heading
		IF NOT IS_POINT_ON_SCREEN coord_1_x coord_1_y coord_1_z 3.0
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0
				IF HAS_MODEL_LOADED	SANCHEZ
					MARK_CAR_AS_NO_LONGER_NEEDED car
					CREATE_CAR SANCHEZ coord_1_x coord_1_y coord_1_z car
					SET_CAR_HEADING	car heading
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER collector1 car
					//IF NOT IS_CHAR_DEAD collector2
					//	SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER collector2 car
					//ENDIF
					//ADD_STUCK_CAR_CHECK car 1.0 4000
					ADD_UPSIDEDOWN_CAR_CHECK car
					collector_car = car
				ENDIF
			ELSE
				IF LOCATE_CHAR_ON_FOOT_3D collector1 coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0 0
					GET_CLOSEST_CHAR_NODE coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z
					SET_CHAR_OBJ_RUN_TO_COORD collector1 coord_1_x coord_1_y
				ENDIF
			ENDIF
		ELSE
			GET_CHAR_COORDINATES collector1 coord_1_x coord_1_y coord_1_z
			GOTO try_to_find_car
		ENDIF
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////
