MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ********************************* Copcar oddjob ***************************************** 
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_copcar

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB copcar_failed
ENDIF

GOSUB mission_cleanup_copcar

MISSION_END
 
// Variables for mission

//CARS PEDS OBJECTS PICKUPS
VAR_INT players_cop_car
VAR_INT criminal1_car criminal1 criminal1_thug1 criminal1_thug2 criminal1_thug3
VAR_INT criminal2_car criminal2	criminal2_thug1 criminal2_thug2 criminal2_thug3
VAR_INT criminal3_car criminal3	criminal3_thug1 criminal3_thug2 criminal3_thug3
VAR_INT ped
//FLAGS COUNTERS TIMERS	ETC
VAR_INT copcar_level random_seed break_convoy_flag total_criminals_killed
VAR_INT game_timer_start vigilante_score num_of_followers
VAR_INT copcar_timer cop_time_limit game_time_flag copcar_cancelled_flag game_time_present 
VAR_INT game_time_difference timer_in_secs mission_end_button cop_time_limit_int
VAR_INT players_cop_car_health timer_on_screen_flag	criminal1_in_car_flag
VAR_INT criminal1_car_stuck_timer_start criminal1_car_stuck_flag
VAR_INT criminal1_dead_flag criminal1_thug1_dead_flag criminal1_thug2_dead_flag criminal1_thug3_dead_flag
VAR_INT criminal1_timera criminal1_team_dead_flag criminal2_in_car_flag
VAR_INT criminal2_car_stuck_timer_start criminal2_car_stuck_flag
VAR_INT criminal2_dead_flag criminal2_thug1_dead_flag criminal2_thug2_dead_flag criminal2_thug3_dead_flag
VAR_INT criminal2_timera criminal2_team_dead_flag criminal3_in_car_flag
VAR_INT criminal3_dead_flag criminal3_thug1_dead_flag criminal3_thug2_dead_flag criminal3_thug3_dead_flag
VAR_INT criminal3_timera criminal3_team_dead_flag
VAR_INT random_car_model
VAR_INT random_ped_model in_copcar_nice_timer copcar_print_level
//BLIPS
VAR_INT criminal1_blip criminal2_blip criminal3_blip
//COORDS MATHS
VAR_FLOAT car1_x car1_y	car1_z car2_x car2_y car2_z	car3_x car3_y car3_z random_heading
VAR_FLOAT player_dist_from_crim
VAR_FLOAT distance_from_player
VAR_FLOAT criminal1_x criminal1_y 
VAR_FLOAT gosub_car_to_slow_x gosub_car_to_slow_y temp_float_x temp_float_y 
VAR_FLOAT gosub_target_car_x gosub_target_car_y gosub_car_to_slow_speed
VAR_FLOAT dx dy	temp_xy	car1_infront_car2 car2_infront_car1	car2_infront_car3 car3_infront_car2
VAR_FLOAT criminal1_car_x criminal1_car_y criminal2_car_x criminal2_car_y criminal3_car_x criminal3_car_y
VAR_FLOAT forward_x forward_y temp_x temp_y	time_bonus_divider wanted_level_multiplier
VAR_FLOAT criminal1_car_stuck_x criminal1_car_stuck_y criminal1_car_stuck_z criminal1_car_speed

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE stuff
//VAR_FLOAT sum_x_y_temp x_temp y_temp stuck_x stuck_y stuck_z heading 
//VAR_FLOAT coord_1_x coord_1_y coord_1_z coord_2_x coord_2_y	coord_c1_x coord_c1_y coord_c1_z
//VAR_INT game_timer frame_counter gosub_stuck_car car_stuck_flag stuck_timer_start gosub_ped
//VAR_INT gosub_car_to_slow gosub_target_entity random_int max_passengers	game_time

// ****************************************Mission Start************************************

mission_start_copcar:

flag_player_on_mission = 1

SCRIPT_NAME copcar

WAIT 0

IF done_copcar_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF
{
LVAR_FLOAT criminal2_x criminal2_y  
LVAR_FLOAT criminal2_car_stuck_x criminal2_car_stuck_y criminal2_car_stuck_z criminal2_car_speed
LVAR_FLOAT criminal3_x criminal3_y 
LVAR_FLOAT criminal3_car_stuck_x criminal3_car_stuck_y criminal3_car_stuck_z criminal3_car_speed
LVAR_INT criminal3_car_stuck_timer_start criminal3_car_stuck_flag

LOAD_MISSION_TEXT COPCAR

// SCFIX: START
IF IS_PLAYER_IN_MODEL player1 HUNTER
	PRINT_BIG COP_M3 6000 5
ELSE
	IF IS_PLAYER_IN_MODEL player1 CHEETAH
		PRINT_BIG COP_M2 6000 5
	ELSE
		PRINT_BIG COP_M 6000 5
	ENDIF
ENDIF
// SCFIX: END

//flag_baron_mission2_passed = 1//DEBUG!!!!

copcar_level = 0
cop_time_limit = -100
copcar_cancelled_flag = 0
total_criminals_killed = 0
timer_on_screen_flag = 0
mission_end_button = 0
break_convoy_flag = 0
game_timer_start = 0
players_cop_car_health = 0
vigilante_score = 0
num_of_followers = 0
copcar_timer = 0
game_time_flag = 0
game_time_present = 0
game_time_difference = 0
timer_in_secs = 0
cop_time_limit_int = 0
random_car_model = 0
random_ped_model = 0
time_bonus_divider = 4.0
wanted_level_multiplier = 1.0
in_copcar_nice_timer = 0

heading = 0.0
gosub_car_to_slow_speed = 0.0

criminal1_car_stuck_x = 0.0
criminal1_car_stuck_y = 0.0
criminal1_car_stuck_z = 0.0
criminal1_car_speed = 0.0

criminal2_car_stuck_x = 0.0
criminal2_car_stuck_y = 0.0
criminal2_car_stuck_z = 0.0
criminal2_car_speed = 0.0

criminal3_car_stuck_x = 0.0
criminal3_car_stuck_y = 0.0
criminal3_car_stuck_z = 0.0
criminal3_car_speed = 0.0

REQUEST_MODEL COLT45
REQUEST_MODEL TEC9
REQUEST_MODEL RUGER
REQUEST_MODEL CHROMEGUN
REQUEST_MODEL MACHETE
REQUEST_MODEL BAT

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED COLT45
OR NOT HAS_MODEL_LOADED	TEC9
OR NOT HAS_MODEL_LOADED	RUGER
OR NOT HAS_MODEL_LOADED	CHROMEGUN
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED MACHETE
OR NOT HAS_MODEL_LOADED	BAT
	WAIT 0
ENDWHILE

SET_ENTER_CAR_RANGE_MULTIPLIER 6.0
SET_THREAT_REACTION_RANGE_MULTIPLIER 3.0

IF IS_PLAYER_IN_ANY_CAR	player1
	STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_cop_car
	SET_CAN_BURST_CAR_TYRES players_cop_car FALSE
ENDIF

next_criminal_to_kill:

criminal1_team_dead_flag = 0
criminal2_team_dead_flag = 0
criminal3_team_dead_flag = 0
break_convoy_flag = 0

criminal1_in_car_flag = 0
criminal1_car_stuck_timer_start = 0
criminal1_car_stuck_flag = 0
criminal1_dead_flag = 0
criminal1_thug1_dead_flag = 0
criminal1_thug2_dead_flag = 0
criminal1_thug3_dead_flag = 0

criminal2_in_car_flag = 0
criminal2_car_stuck_timer_start = 0
criminal2_car_stuck_flag = 0
criminal2_dead_flag = 0
criminal2_thug1_dead_flag = 0
criminal2_thug2_dead_flag = 0
criminal2_thug3_dead_flag = 0

criminal3_in_car_flag = 0
criminal3_car_stuck_timer_start = 0
criminal3_car_stuck_flag = 0
criminal3_dead_flag = 0
criminal3_thug1_dead_flag = 0
criminal3_thug2_dead_flag = 0
criminal3_thug3_dead_flag = 0

car1_infront_car2 = 0.0
car2_infront_car1 = 0.0

car2_infront_car3 = 0.0
car3_infront_car2 = 0.0

frame_counter = 0

GOSUB request_random_car_model

GENERATE_RANDOM_INT_IN_RANGE 9 95 random_ped_model
REQUEST_MODEL random_ped_model

get_random_car_coords:
	
GOSUB copcar_cancelled_checks
IF copcar_cancelled_flag = 1
	GOTO copcar_failed
ENDIF

GET_PLAYER_COORDINATES player1 player_x player_y z
IF flag_baron_mission2_passed = 0
	GENERATE_RANDOM_FLOAT_IN_RANGE -247.43 683.41 car1_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -1813.62 1308.102 car1_y
ELSE
	IF IS_PLAYER_IN_AREA_2D player1	-1802.615 -1518.473 -270.134 1591.896 0//MAINLAND AREA
		GENERATE_RANDOM_FLOAT_IN_RANGE -1802.615 -270.134 car1_x//MAINLAND AREA
		GENERATE_RANDOM_FLOAT_IN_RANGE -1518.473 1591.896 car1_y
	ELSE
		GENERATE_RANDOM_FLOAT_IN_RANGE -247.43 683.41 car1_x//BEACH AREA
		GENERATE_RANDOM_FLOAT_IN_RANGE -1813.62 1308.102 car1_y
	ENDIF
ENDIF

car1_z = 10.0
IF copcar_level	< 4
	GET_CLOSEST_CAR_NODE_WITH_HEADING car1_x car1_y car1_z car1_x car1_y car1_z	random_heading
	car1_z += 0.5
ENDIF

IF copcar_level > 3
AND	copcar_level < 8
	GET_CLOSEST_STRAIGHT_ROAD car1_x car1_y car1_z 8.0 500.0 car1_x car1_y car1_z car2_x car2_y car2_z random_heading
	IF car1_x = 0.0
	AND	car1_y = 0.0
	AND	car2_x = 0.0
	AND	car2_y = 0.0
		WAIT 0
		GOTO get_random_car_coords
	ENDIF
	//MAKES THE DISTANCE BETWEEN CAR1_XYZ AND CAR2_XYZ EQUAL TO MINLENGTH OF STRAIGHT ROAD (8.0)
	dx = car2_x - car1_x
	dy = car2_y - car1_y
	temp_x = dx * dx
	temp_y = dy * dy
	temp_xy = temp_x + temp_y
	SQRT temp_xy temp_xy
	sum_x_y_temp = 8.0 / temp_xy
	temp_x = dx * sum_x_y_temp
	car2_x = car1_x + temp_x
	temp_y = dy * sum_x_y_temp
	car2_y = car1_y + temp_y
	
	//BRINGS THE CAR1_XYZ BACK TOWARDS CAR2_XYZ BY 2.0 METERS
	sum_x_y_temp = 2.0 / temp_xy
	temp_x = dx * sum_x_y_temp
	car1_x = car1_x + temp_x
	temp_y = dy * sum_x_y_temp
	car1_y = car1_y + temp_y
	
	car1_z += 0.5
	car2_z += 0.5
ENDIF

IF copcar_level > 7
AND	copcar_level < 12
	GET_CLOSEST_STRAIGHT_ROAD car1_x car1_y car1_z 13.0 500.0 car1_x car1_y car1_z car3_x car3_y car3_z random_heading
	IF car1_x = 0.0
	AND	car1_y = 0.0
	AND	car3_x = 0.0
	AND	car3_y = 0.0
		WAIT 0
		GOTO get_random_car_coords
	ENDIF
	
	//MAKES THE DISTANCE BETWEEN CAR1_XYZ AND CAR3_XYZ EQUAL TO MINLENGTH OF STRAIGHT ROAD (13.0)
	dx = car3_x - car1_x
	dy = car3_y - car1_y
	temp_x = dx * dx
	temp_y = dy * dy
	temp_xy = temp_x + temp_y
	SQRT temp_xy temp_xy
	sum_x_y_temp = 13.0 / temp_xy
	temp_x = dx * sum_x_y_temp
	car3_x = car1_x + temp_x
	temp_y = dy * sum_x_y_temp
	car3_y = car1_y + temp_y

	//BRINGS THE CAR1_XYZ BACK TOWARDS CAR3_XYZ BY 2.0 METERS
	sum_x_y_temp = 2.0 / temp_xy
	temp_x = dx * sum_x_y_temp
	car1_x = car1_x + temp_x
	temp_y = dy * sum_x_y_temp
	car1_y = car1_y + temp_y

	//WORKS OUT THE MIDDLE POINT OF CAR1_XYZ AND CAR3_XYZ
	car2_x = car1_x	- car3_x
	car2_x = car2_x / 2.0
	car2_x = car2_x	+ car3_x
	
	car2_y = car1_y	- car3_y
	car2_y = car2_y / 2.0
	car2_y = car2_y	+ car3_y
	
	car2_z = car1_z	- car3_z
	car2_z = car2_z / 2.0
	car2_z = car2_z	+ car3_z
	
	car1_z += 0.5
	car2_z += 0.5
	car3_z += 0.5
ENDIF

IF car1_z < 7.0
	WAIT 0
	GOTO get_random_car_coords
ENDIF

GET_PLAYER_COORDINATES player1 player_x player_y player_z
GET_DISTANCE_BETWEEN_COORDS_2D player_x player_y car1_x car1_y distance_from_player

IF distance_from_player < 150.0
OR distance_from_player > 600.0
	WAIT 0
	GOTO get_random_car_coords
ENDIF
			 //STADIUM
IF car1_x >  -1905.785
AND car1_x < -1105.785
AND car1_y > 745.678	
AND car1_y < 1773.513
	WAIT 0
	GOTO get_random_car_coords
ENDIF
			 //GOLF COURSE & PORN
IF car1_x >  -265.018 
AND car1_x < 170.188 
AND car1_y > -275.942 
AND car1_y < 1689.059
	WAIT 0
	GOTO get_random_car_coords
ENDIF
			 //MORE GOLFCOURSE
IF car1_x >  164.191 
AND car1_x < 259.713 
AND car1_y > -187.926
AND car1_y < 631.97
	WAIT 0
	GOTO get_random_car_coords
ENDIF
			 //GOLFCOURSE BRIDGE
IF car1_x >  -731.729
AND car1_x < -263.334 
AND car1_y > -4.399
AND car1_y < 62.853
	WAIT 0
	GOTO get_random_car_coords
ENDIF
			 //STARISLAND BRIDGE
IF car1_x >  -180.88 
AND car1_x < 64.112 
AND car1_y >  -499.183
AND car1_y < -417.519
	WAIT 0
	GOTO get_random_car_coords
ENDIF
			 //STARISLAND
IF car1_x >  -762.855  
AND car1_x < -172.566 
AND car1_y > -667.099
AND car1_y < -224.382
	WAIT 0
	GOTO get_random_car_coords
ENDIF

IF flag_baron_mission2_passed = 0
	IF car1_x > -2327.212 
	AND car1_x < -261.402
	AND car1_y	> -2027.821
	AND car1_y	< 1894.426
		WAIT 0
		GOTO get_random_car_coords
	ENDIF

	IF car1_x >  -265.018
	AND car1_x < 170.188
	AND car1_y	> -275.942
	AND car1_y	< 1689.059
		WAIT 0
		GOTO get_random_car_coords
	ENDIF

	IF car1_x >  -265.657
	AND car1_x < 36.828
	AND car1_y	> -729.217
	AND car1_y	< -275.488
		WAIT 0
		GOTO get_random_car_coords
	ENDIF

	IF car1_x >  164.191
	AND car1_x < 259.713
	AND car1_y	> -187.926
	AND car1_y	< 631.97
		WAIT 0
		GOTO get_random_car_coords
	ENDIF
ENDIF

GENERATE_RANDOM_INT random_seed
WHILE random_seed = 0
	GENERATE_RANDOM_INT random_seed
ENDWHILE

WHILE NOT HAS_MODEL_LOADED random_car_model
OR NOT HAS_MODEL_LOADED random_ped_model
	
	WAIT 0
	
	GOSUB copcar_cancelled_checks
	IF copcar_cancelled_flag = 1
		GOTO copcar_failed
	ENDIF

ENDWHILE

CREATE_CAR random_car_model car1_x car1_y car1_z criminal1_car
SET_CAR_HEALTH criminal1_car 800
SET_CAR_DRIVING_STYLE criminal1_car 2
SET_CAR_RANDOM_ROUTE_SEED criminal1_car random_seed
MARK_CAR_AS_CONVOY_CAR criminal1_car TRUE
SET_CAR_HEADING criminal1_car random_heading
SET_CAR_AVOID_LEVEL_TRANSITIONS criminal1_car TRUE

WHILE IS_CAR_WAITING_FOR_WORLD_COLLISION criminal1_car
	WAIT 0
	
	IF IS_CAR_DEAD criminal1_car
		GOTO copcar_failed
	ENDIF

	GOSUB copcar_cancelled_checks
	IF copcar_cancelled_flag = 1
		GOTO copcar_failed
	ENDIF

ENDWHILE

CREATE_CHAR_INSIDE_CAR criminal1_car PEDTYPE_GANG9 random_ped_model criminal1

//POINT_CAMERA_AT_CHAR criminal1 FOLLOWPED JUMP_CUT //BEHINDCAR
//SET_CAMERA_BEHIND_PLAYER

IF NOT flag_player_on_mission = 1
	ADD_BLIP_FOR_COORD x y z criminal1_blip
	ADD_BLIP_FOR_COORD x y z criminal2_blip
	ADD_BLIP_FOR_COORD x y z criminal3_blip
ENDIF

REMOVE_BLIP	criminal1_blip
ADD_BLIP_FOR_CHAR criminal1 criminal1_blip

ped = criminal1
GOSUB setup_ped_threats_etc

IF copcar_level > 0
	CREATE_CHAR_AS_PASSENGER criminal1_car PEDTYPE_GANG9 random_ped_model 0 criminal1_thug1
	ped = criminal1_thug1
	GOSUB setup_ped_threats_etc
ELSE
	criminal1_thug1_dead_flag = 1
ENDIF

IF copcar_level > 1
	CREATE_CHAR_AS_PASSENGER criminal1_car PEDTYPE_GANG9 random_ped_model 1 criminal1_thug2
	ped = criminal1_thug2
	GOSUB setup_ped_threats_etc
ELSE
	criminal1_thug2_dead_flag = 1
ENDIF

IF copcar_level > 2
	CREATE_CHAR_AS_PASSENGER criminal1_car PEDTYPE_GANG9 random_ped_model 2 criminal1_thug3
	ped = criminal1_thug3
	GOSUB setup_ped_threats_etc
ELSE
	criminal1_thug3_dead_flag = 1
ENDIF

IF copcar_level > 3
	CREATE_CAR random_car_model car2_x car2_y car2_z criminal2_car
	MARK_CAR_AS_CONVOY_CAR criminal2_car TRUE
	SET_CAR_HEADING criminal2_car random_heading
	SET_CAR_AVOID_LEVEL_TRANSITIONS criminal2_car TRUE
	SET_CAR_DRIVING_STYLE criminal2_car 2
	SET_CAR_HEALTH criminal2_car 800
	SET_CAR_RANDOM_ROUTE_SEED criminal2_car random_seed
	
	WHILE IS_CAR_WAITING_FOR_WORLD_COLLISION criminal2_car
		WAIT 0
		
		IF IS_CAR_DEAD criminal2_car
			GOTO copcar_failed
		ENDIF

		GOSUB copcar_cancelled_checks
		IF copcar_cancelled_flag = 1
			GOTO copcar_failed
		ENDIF

	ENDWHILE

	CREATE_CHAR_INSIDE_CAR criminal2_car PEDTYPE_GANG9 random_ped_model criminal2

	//POINT_CAMERA_AT_CHAR criminal2 FOLLOWPED JUMP_CUT //BEHINDCAR
	//SET_CAMERA_BEHIND_PLAYER
	ped = criminal2
	GOSUB setup_ped_threats_etc
	REMOVE_BLIP	criminal2_blip
	ADD_BLIP_FOR_CHAR criminal2 criminal2_blip
ELSE
	criminal2_team_dead_flag = 1
	criminal2_dead_flag = 1
ENDIF

IF copcar_level > 4
	CREATE_CHAR_AS_PASSENGER criminal2_car PEDTYPE_GANG9 random_ped_model 0 criminal2_thug1
	ped = criminal2_thug1
	GOSUB setup_ped_threats_etc
ELSE
	criminal2_thug1_dead_flag = 1
ENDIF

IF copcar_level > 5
	CREATE_CHAR_AS_PASSENGER criminal2_car PEDTYPE_GANG9 random_ped_model 1 criminal2_thug2
	ped = criminal2_thug2
	GOSUB setup_ped_threats_etc
ELSE
	criminal2_thug2_dead_flag = 1
ENDIF

IF copcar_level > 6
	CREATE_CHAR_AS_PASSENGER criminal2_car PEDTYPE_GANG9 random_ped_model 2 criminal2_thug3
	ped = criminal2_thug3
	GOSUB setup_ped_threats_etc
ELSE
	criminal2_thug3_dead_flag = 1
ENDIF

IF copcar_level > 7
	CREATE_CAR random_car_model car3_x car3_y car3_z criminal3_car
	MARK_CAR_AS_CONVOY_CAR criminal3_car TRUE
	SET_CAR_HEADING criminal3_car random_heading
	SET_CAR_AVOID_LEVEL_TRANSITIONS criminal3_car TRUE
	SET_CAR_DRIVING_STYLE criminal3_car 2
	SET_CAR_HEALTH criminal3_car 800
	SET_CAR_RANDOM_ROUTE_SEED criminal3_car random_seed
	
	WHILE IS_CAR_WAITING_FOR_WORLD_COLLISION criminal3_car
		WAIT 0
		
		IF IS_CAR_DEAD criminal3_car
			GOTO copcar_failed
		ENDIF

		GOSUB copcar_cancelled_checks
		IF copcar_cancelled_flag = 1
			GOTO copcar_failed
		ENDIF

	ENDWHILE

	CREATE_CHAR_INSIDE_CAR criminal3_car PEDTYPE_GANG9 random_ped_model criminal3

	//POINT_CAMERA_AT_CHAR criminal3 FOLLOWPED JUMP_CUT //BEHINDCAR
	//SET_CAMERA_BEHIND_PLAYER
	ped = criminal3
	GOSUB setup_ped_threats_etc
	REMOVE_BLIP	criminal3_blip
	ADD_BLIP_FOR_CHAR criminal3 criminal3_blip
ELSE
	criminal3_team_dead_flag = 1
	criminal3_dead_flag = 1
ENDIF

IF copcar_level > 8
	CREATE_CHAR_AS_PASSENGER criminal3_car PEDTYPE_GANG9 random_ped_model 0 criminal3_thug1
	ped = criminal3_thug1
	GOSUB setup_ped_threats_etc
ELSE
	criminal3_thug1_dead_flag = 1
ENDIF

IF copcar_level > 9
	CREATE_CHAR_AS_PASSENGER criminal3_car PEDTYPE_GANG9 random_ped_model 1 criminal3_thug2
	ped = criminal3_thug2
	GOSUB setup_ped_threats_etc
ELSE
	criminal3_thug2_dead_flag = 1
ENDIF

IF copcar_level > 10
	CREATE_CHAR_AS_PASSENGER criminal3_car PEDTYPE_GANG9 random_ped_model 2 criminal3_thug3
	ped = criminal3_thug3
	GOSUB setup_ped_threats_etc
ELSE
	criminal3_thug3_dead_flag = 1
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model
MARK_MODEL_AS_NO_LONGER_NEEDED random_ped_model

GOSUB print_text_for_zone_char_is_in
GET_CHAR_COORDINATES criminal1 criminal1_x criminal1_y z
POLICE_RADIO_MESSAGE criminal1_x criminal1_y z

GET_PLAYER_COORDINATES player1 player_x player_y player_z
x_temp = player_x - criminal1_x
y_temp = player_y - criminal1_y
x_temp = x_temp * x_temp
y_temp = y_temp * y_temp
player_dist_from_crim = y_temp + y_temp
SQRT player_dist_from_crim player_dist_from_crim

player_dist_from_crim /= time_bonus_divider//4.0
player_dist_from_crim *= 1000.0
cop_time_limit_int =# player_dist_from_crim
IF cop_time_limit_int < 40000
	cop_time_limit_int = 40000
ENDIF
cop_time_limit += cop_time_limit_int

cop_time_limit_int /= 1000

IF timer_on_screen_flag = 1
	PRINT_WITH_NUMBER_BIG A_TIME cop_time_limit_int 4000 6	//+~1~ Seconds
ELSE
	IF cop_time_limit < 45000
		cop_time_limit = 45000
	ENDIF
	cop_time_limit += 30000
	DISPLAY_ONSCREEN_TIMER cop_time_limit TIMER_DOWN
	timer_on_screen_flag = 1
ENDIF

GET_GAME_TIMER game_timer
criminal1_timera = game_timer
criminal2_timera = game_timer
criminal3_timera = game_timer

IF copcar_level < 13
	time_bonus_divider -= 0.1
ENDIF

FREEZE_ONSCREEN_TIMER FALSE

copcar_print_level = copcar_level + 1
PRINT_WITH_NUMBER_NOW CLEVEL copcar_print_level 5000 1//Vigilante Mission Level ~1~

copcar_oddjob_loop:

WAIT 0

//PRINT_WITH_NUMBER_NOW NUMBER random_car_model 17 1//debug

GET_GAME_TIMER game_timer
GET_PLAYER_COORDINATES player1 player_x player_y player_z

GOSUB copcar_cancelled_checks
IF copcar_cancelled_flag = 1
	GOTO copcar_failed
ENDIF

IF criminal1_in_car_flag = -1
OR criminal2_in_car_flag = -1
OR criminal3_in_car_flag = -1
	break_convoy_flag = 1
ENDIF

++ frame_counter
//IF copcar_level < 4
//	IF frame_counter > 0
//		frame_counter = 0
//	ENDIF
//ENDIF
//IF copcar_level > 3
//AND	copcar_level < 8
//	IF frame_counter > 1
//		frame_counter = 0
//	ENDIF
//ENDIF
//IF copcar_level > 7
	IF frame_counter > 2
		frame_counter = 0
	ENDIF
//ENDIF

/////
////criminal1
/////
IF frame_counter = 0
	IF NOT IS_CHAR_DEAD criminal1
		IF IS_CHAR_SITTING_IN_ANY_CAR criminal1
			
			MARK_CAR_AS_NO_LONGER_NEEDED criminal1_car
			STORE_CAR_CHAR_IS_IN_NO_SAVE criminal1 criminal1_car
			
			IF criminal1_in_car_flag = -1
				GET_NUMBER_OF_FOLLOWERS criminal1 num_of_followers
				IF num_of_followers > 0
					criminal1_timera = game_timer + 2000
				ELSE
					criminal1_timera = game_timer
				ENDIF
				criminal1_in_car_flag = 0
			ENDIF
			
			IF criminal1_in_car_flag = 0
				IF game_timer > criminal1_timera
					SET_CAR_CRUISE_SPEED criminal1_car 100.0
					SET_CAR_DRIVING_STYLE criminal1_car 2
					CAR_WANDER_RANDOMLY	criminal1_car
					criminal1_car_stuck_timer_start = game_timer
					criminal1_in_car_flag = 1
					criminal1_car_stuck_flag = 0
				ENDIF
			ENDIF
			
			IF criminal1_in_car_flag > 0

				IF IS_PLAYER_IN_CAR player1 criminal1_car
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal1 player1
				ENDIF

				gosub_stuck_car = criminal1_car
				car_stuck_flag = criminal1_car_stuck_flag
				stuck_timer_start = criminal1_car_stuck_timer_start
				stuck_x = criminal1_car_stuck_x
				stuck_y = criminal1_car_stuck_y
				stuck_z = criminal1_car_stuck_z
				IF criminal1_car_speed > 0.0
					GOSUB criminal_car_stuck_checks
				ENDIF
				criminal1_car_stuck_flag = car_stuck_flag
				criminal1_car_stuck_timer_start = stuck_timer_start
				criminal1_car_stuck_x = stuck_x
				criminal1_car_stuck_y = stuck_y
				criminal1_car_stuck_z = stuck_z
				
				IF criminal1_car_stuck_flag = -9
					SET_CHAR_OBJ_FLEE_CAR criminal1 criminal1_car
					criminal1_car_stuck_flag = 0
				ENDIF
		
				IF NOT IS_CAR_HEALTH_GREATER criminal1_car 400
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal1 player1
				ENDIF

				IF NOT IS_CAR_HEALTH_GREATER criminal1_car 251
					SET_CHAR_OBJ_FLEE_CAR criminal1 criminal1_car
					criminal1_timera = game_timer + 2000
				ELSE
					criminal1_timera = game_timer
				ENDIF
				
				GOSUB criminal1_group_breaking
				
				GET_CHAR_COORDINATES criminal1 criminal1_x criminal1_y z
				x_temp = player_x - criminal1_x //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
				y_temp = player_y - criminal1_y
				x_temp = x_temp * x_temp
				y_temp = y_temp * y_temp
				sum_x_y_temp = x_temp + y_temp
				SQRT sum_x_y_temp sum_x_y_temp
				
				criminal1_car_speed = 1000.0 / sum_x_y_temp

				IF criminal1_car_speed > 100.0
					criminal1_car_speed = 100.0
				ENDIF
				IF criminal1_car_speed < 15.0
					criminal1_car_speed = 15.0
				ENDIF

				SET_CAR_CRUISE_SPEED criminal1_car criminal1_car_speed
			ENDIF
		ELSE
			criminal1_in_car_flag = -1
			GOSUB criminal1_group_breaking
			IF game_timer > criminal1_timera
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 criminal1 45.0 45.0 0
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal1 player1
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 criminal1 30.0 30.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal1 player1
						ELSE
							gosub_ped = criminal1
							IF NOT IS_CAR_DEAD criminal1_car
								IF IS_CAR_HEALTH_GREATER criminal1_car 400
									IF LOCATE_CHAR_ANY_MEANS_CAR_2D	criminal1 criminal1_car 40.0 40.0 0
										SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal1 criminal1_car
									ELSE
										GOSUB criminal_steal_a_car
									ENDIF
								ELSE
									GOSUB criminal_steal_a_car
								ENDIF
							ELSE
								GOSUB criminal_steal_a_car
							ENDIF
						ENDIF
					ENDIF
				ELSE
					gosub_ped = criminal1
					IF NOT IS_CAR_DEAD criminal1_car
						IF IS_CAR_HEALTH_GREATER criminal1_car 400
							IF LOCATE_CHAR_ANY_MEANS_CAR_2D	criminal1 criminal1_car 40.0 40.0 0
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal1 criminal1_car
							ELSE
								GOSUB criminal_steal_a_car
							ENDIF
						ELSE
							GOSUB criminal_steal_a_car
						ENDIF
					ELSE
						GOSUB criminal_steal_a_car
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		REMOVE_BLIP criminal1_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal1
		IF criminal1_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal1_dead_flag = 1
		ENDIF
		IF NOT IS_CHAR_DEAD	criminal1_thug1
			criminal1 = criminal1_thug1
			criminal1_thug1 = -1
			criminal1_dead_flag = 0
			criminal1_thug1_dead_flag = 1
			ADD_BLIP_FOR_CHAR criminal1 criminal1_blip
			IF NOT IS_CHAR_DEAD	criminal1_thug2
				SET_CHAR_AS_LEADER criminal1_thug2 criminal1
				IF NOT IS_CHAR_IN_CHARS_GROUP criminal1_thug2 criminal1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal1_thug2 player1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	criminal1_thug3
				SET_CHAR_AS_LEADER criminal1_thug3 criminal1
				IF NOT IS_CHAR_IN_CHARS_GROUP criminal1_thug3 criminal1
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal1_thug3 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug1
			IF NOT IS_CHAR_DEAD	criminal1_thug2
				criminal1 = criminal1_thug2
				criminal1_thug2 = -1
				criminal1_dead_flag = 0
				criminal1_thug2_dead_flag = 1
				ADD_BLIP_FOR_CHAR criminal1 criminal1_blip
				IF NOT IS_CHAR_DEAD	criminal1_thug3
					SET_CHAR_AS_LEADER criminal1_thug3 criminal1
					IF NOT IS_CHAR_IN_CHARS_GROUP criminal1_thug3 criminal1
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal1_thug3 player1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug2
				IF NOT IS_CHAR_DEAD	criminal1_thug3
					criminal1 = criminal1_thug3
					criminal1_thug3 = -1
					criminal1_dead_flag = 0
					criminal1_thug3_dead_flag = 1
					ADD_BLIP_FOR_CHAR criminal1 criminal1_blip
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug3
					criminal1_team_dead_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal1_thug1
		IF criminal1_thug1_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal1_thug1_dead_flag = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal1_thug2
		IF criminal1_thug2_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal1_thug2_dead_flag = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal1_thug3
		IF criminal1_thug3_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal1_thug3_dead_flag = 1
		ENDIF
	ENDIF
ENDIF

/////
////criminal2
/////
IF frame_counter = 1
	IF NOT IS_CHAR_DEAD criminal2
		IF IS_CHAR_SITTING_IN_ANY_CAR criminal2
			
			MARK_CAR_AS_NO_LONGER_NEEDED criminal2_car
			STORE_CAR_CHAR_IS_IN_NO_SAVE criminal2 criminal2_car
			
			IF criminal2_in_car_flag = -1
				GET_NUMBER_OF_FOLLOWERS criminal2 num_of_followers
				IF num_of_followers > 0
					criminal2_timera = game_timer + 2000
				ELSE
					criminal2_timera = game_timer
				ENDIF
				criminal2_in_car_flag = 0
			ENDIF
			
			IF criminal2_in_car_flag = 0
				IF game_timer > criminal2_timera
					SET_CAR_CRUISE_SPEED criminal2_car 100.0
					SET_CAR_DRIVING_STYLE criminal2_car 2
					IF break_convoy_flag = 0
						IF NOT IS_CAR_DEAD criminal1_car
							CAR_WANDER_RANDOMLY	criminal2_car
							//SET_CAR_STRAIGHT_LINE_DISTANCE criminal2_car 5
							//SET_CAR_RAM_CAR criminal2_car criminal1_car
						ELSE
							break_convoy_flag = 1
						ENDIF
					ENDIF
					IF break_convoy_flag = 1
						MARK_CAR_AS_CONVOY_CAR criminal2_car FALSE
						CAR_WANDER_RANDOMLY	criminal2_car
					ENDIF
					criminal2_car_stuck_timer_start = game_timer
					criminal2_in_car_flag = 1
					criminal2_car_stuck_flag = 0
				ENDIF
			ENDIF
			
			IF criminal2_in_car_flag > 0

				IF IS_PLAYER_IN_CAR player1 criminal2_car
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal2 player1
				ENDIF

				gosub_stuck_car = criminal2_car
				car_stuck_flag = criminal2_car_stuck_flag
				stuck_timer_start = criminal2_car_stuck_timer_start
				stuck_x = criminal2_car_stuck_x
				stuck_y = criminal2_car_stuck_y
				stuck_z = criminal2_car_stuck_z
				IF criminal2_car_speed > 0.0
					GOSUB criminal_car_stuck_checks
				ENDIF
				criminal2_car_stuck_flag = car_stuck_flag
				criminal2_car_stuck_timer_start = stuck_timer_start
				criminal2_car_stuck_x = stuck_x
				criminal2_car_stuck_y = stuck_y
				criminal2_car_stuck_z = stuck_z
				
				IF criminal2_car_stuck_flag = -9
					SET_CHAR_OBJ_FLEE_CAR criminal2 criminal2_car
					criminal2_car_stuck_flag = 0
				ENDIF
		
				IF NOT IS_CAR_HEALTH_GREATER criminal2_car 400
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal2 player1
				ENDIF

				IF NOT IS_CAR_HEALTH_GREATER criminal2_car 251
					SET_CHAR_OBJ_FLEE_CAR criminal2 criminal2_car
					criminal2_timera = game_timer + 2000
				ELSE
					criminal2_timera = game_timer
				ENDIF
				
				GOSUB criminal2_group_breaking
				
				GET_CHAR_COORDINATES criminal2 criminal2_x criminal2_y z
				x_temp = player_x - criminal2_x //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
				y_temp = player_y - criminal2_y
				x_temp = x_temp * x_temp
				y_temp = y_temp * y_temp
				sum_x_y_temp = x_temp + y_temp
				SQRT sum_x_y_temp sum_x_y_temp
				
				criminal2_car_speed = 1000.0 / sum_x_y_temp

				IF criminal2_car_speed > 100.0
					criminal2_car_speed = 100.0
				ENDIF
				IF criminal2_car_speed < 15.0
					criminal2_car_speed = 15.0
				ENDIF

				IF break_convoy_flag = 0
					IF NOT IS_CAR_DEAD criminal1_car
						gosub_car_to_slow = criminal2_car
						gosub_target_entity = criminal1_car
						GOSUB slow_criminal_if_close 
						criminal2_car_speed = gosub_car_to_slow_speed
						
						//THIS BIT OF CODE CHECKS TO SEE IF CAR1 IS INFRONT OF CAR2
						GET_CAR_FORWARD_X criminal2_car forward_x
						GET_CAR_FORWARD_Y criminal2_car forward_y
						GET_CAR_COORDINATES criminal1_car criminal1_car_x criminal1_car_y z
						GET_CAR_COORDINATES	criminal2_car criminal2_car_x criminal2_car_y z
						// IF (((forward_x * (car2_x - car1_x)) + (forward_y * (car2_y - car1_y)>) IS GREATER THAN 0.0 CAR IS IN FRONT
						temp_float_x = criminal2_car_x - criminal1_car_x
						forward_x = forward_x * temp_float_x
						temp_float_y = criminal2_car_y - criminal1_car_y
						forward_y = forward_y * temp_float_y
						car1_infront_car2 = forward_x + forward_y

						//THIS BIT OF CODE CHECKS TO SEE IF CAR2 IS INFRONT OF CAR1
						GET_CAR_FORWARD_X criminal1_car forward_x
						GET_CAR_FORWARD_Y criminal1_car forward_y
						GET_CAR_COORDINATES criminal2_car criminal2_car_x criminal2_car_y z
						GET_CAR_COORDINATES	criminal1_car criminal1_car_x criminal1_car_y z
						// IF (((forward_x * (car1_x - car2_x)) + (forward_y * (car1_y - car2_y)>) IS GREATER THAN 0.0 CAR IS IN FRONT
						temp_float_x = criminal1_car_x - criminal2_car_x
						forward_x = forward_x * temp_float_x
						temp_float_y = criminal1_car_y - criminal2_car_y
						forward_y = forward_y * temp_float_y
						car2_infront_car1 = forward_x + forward_y

						IF car1_infront_car2 > 0.0// +=INFRONT  -=BEHIND
							IF car2_infront_car1 < 0.0
								criminal2_car_speed = 0.0
							ENDIF
						ENDIF
					ELSE
						CAR_WANDER_RANDOMLY	criminal2_car
						break_convoy_flag = 1
					ENDIF
				ENDIF

				IF criminal2_car_speed = 0.0
					SET_CAR_TEMP_ACTION criminal2_car TEMPACT_WAIT 17
				ELSE
					SET_CAR_CRUISE_SPEED criminal2_car criminal2_car_speed
				ENDIF

			ENDIF
		ELSE
			criminal2_in_car_flag = -1
			GOSUB criminal2_group_breaking
			IF game_timer > criminal2_timera
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 criminal2 40.0 40.0 0
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal2 player1
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 criminal2 25.0 25.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal2 player1
						ELSE
							gosub_ped = criminal2
							IF NOT IS_CAR_DEAD criminal2_car
								IF IS_CAR_HEALTH_GREATER criminal2_car 400
									IF LOCATE_CHAR_ANY_MEANS_CAR_2D	criminal2 criminal2_car 40.0 40.0 0
										SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal2 criminal2_car
									ELSE
										GOSUB criminal_steal_a_car
									ENDIF
								ELSE
									GOSUB criminal_steal_a_car
								ENDIF
							ELSE
								GOSUB criminal_steal_a_car
							ENDIF
						ENDIF
					ENDIF
				ELSE
					gosub_ped = criminal2
					IF NOT IS_CAR_DEAD criminal2_car
						IF IS_CAR_HEALTH_GREATER criminal2_car 400
							IF LOCATE_CHAR_ANY_MEANS_CAR_2D	criminal2 criminal2_car 40.0 40.0 0
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal2 criminal2_car
							ELSE
								GOSUB criminal_steal_a_car
							ENDIF
						ELSE
							GOSUB criminal_steal_a_car
						ENDIF
					ELSE
						GOSUB criminal_steal_a_car
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		REMOVE_BLIP criminal2_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal2
		IF criminal2_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal2_dead_flag = 1
		ENDIF
		IF NOT IS_CHAR_DEAD	criminal2_thug1
			criminal2 = criminal2_thug1
			criminal2_thug1 = -1
			criminal2_dead_flag = 0
			criminal2_thug1_dead_flag = 1
			ADD_BLIP_FOR_CHAR criminal2 criminal2_blip
			IF NOT IS_CHAR_DEAD	criminal2_thug2
				SET_CHAR_AS_LEADER criminal2_thug2 criminal2
				IF NOT IS_CHAR_IN_CHARS_GROUP criminal2_thug2 criminal2
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal2_thug2 player1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	criminal2_thug3
				SET_CHAR_AS_LEADER criminal2_thug3 criminal2
				IF NOT IS_CHAR_IN_CHARS_GROUP criminal2_thug3 criminal2
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal2_thug3 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug1
			IF NOT IS_CHAR_DEAD	criminal2_thug2
				criminal2 = criminal2_thug2
				criminal2_thug2 = -1
				criminal2_dead_flag = 0
				criminal2_thug2_dead_flag = 1
				ADD_BLIP_FOR_CHAR criminal2 criminal2_blip
				IF NOT IS_CHAR_DEAD	criminal2_thug3
					SET_CHAR_AS_LEADER criminal2_thug3 criminal2
					IF NOT IS_CHAR_IN_CHARS_GROUP criminal2_thug3 criminal2
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal2_thug3 player1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug2
				IF NOT IS_CHAR_DEAD	criminal2_thug3
					criminal2 = criminal2_thug3
					criminal2_thug3 = -1
					criminal2_dead_flag = 0
					criminal2_thug3_dead_flag = 1
					ADD_BLIP_FOR_CHAR criminal2 criminal2_blip
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug3
					criminal2_team_dead_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal2_thug1
		IF criminal2_thug1_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal2_thug1_dead_flag = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal2_thug2
		IF criminal2_thug2_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal2_thug2_dead_flag = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal2_thug3
		IF criminal2_thug3_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal2_thug3_dead_flag = 1
		ENDIF
	ENDIF
ENDIF

/////
////criminal3
/////
IF frame_counter = 2
	IF NOT IS_CHAR_DEAD criminal3
		IF IS_CHAR_SITTING_IN_ANY_CAR criminal3
			
			MARK_CAR_AS_NO_LONGER_NEEDED criminal3_car
			STORE_CAR_CHAR_IS_IN_NO_SAVE criminal3 criminal3_car
			
			IF criminal3_in_car_flag = -1
				GET_NUMBER_OF_FOLLOWERS criminal3 num_of_followers
				IF num_of_followers > 0
					criminal3_timera = game_timer + 2000
				ELSE
					criminal3_timera = game_timer
				ENDIF
				criminal3_in_car_flag = 0
			ENDIF
			
			IF criminal3_in_car_flag = 0
				IF game_timer > criminal3_timera
					SET_CAR_CRUISE_SPEED criminal3_car 100.0
					SET_CAR_DRIVING_STYLE criminal3_car 2
					IF break_convoy_flag = 0
						IF NOT IS_CAR_DEAD criminal2_car
							CAR_WANDER_RANDOMLY	criminal3_car
							//SET_CAR_STRAIGHT_LINE_DISTANCE criminal3_car 5
							//SET_CAR_RAM_CAR criminal3_car criminal2_car
						ELSE
							break_convoy_flag = 1
						ENDIF
					ENDIF
					IF break_convoy_flag = 1
						MARK_CAR_AS_CONVOY_CAR criminal3_car FALSE
						CAR_WANDER_RANDOMLY	criminal3_car
					ENDIF
					criminal3_car_stuck_timer_start = game_timer
					criminal3_in_car_flag = 1
					criminal3_car_stuck_flag = 0
				ENDIF
			ENDIF
			
			IF criminal3_in_car_flag > 0

				IF IS_PLAYER_IN_CAR player1 criminal3_car
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal3 player1
				ENDIF

				gosub_stuck_car = criminal3_car
				car_stuck_flag = criminal3_car_stuck_flag
				stuck_timer_start = criminal3_car_stuck_timer_start
				stuck_x = criminal3_car_stuck_x
				stuck_y = criminal3_car_stuck_y
				stuck_z = criminal3_car_stuck_z
				IF criminal3_car_speed > 0.0
					GOSUB criminal_car_stuck_checks
				ENDIF
				criminal3_car_stuck_flag = car_stuck_flag
				criminal3_car_stuck_timer_start = stuck_timer_start
				criminal3_car_stuck_x = stuck_x
				criminal3_car_stuck_y = stuck_y
				criminal3_car_stuck_z = stuck_z
				
				IF criminal3_car_stuck_flag = -9
					SET_CHAR_OBJ_FLEE_CAR criminal3 criminal3_car
					criminal3_car_stuck_flag = 0
				ENDIF
		
				IF NOT IS_CAR_HEALTH_GREATER criminal3_car 400
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal3 player1
				ENDIF

				IF NOT IS_CAR_HEALTH_GREATER criminal3_car 251
					SET_CHAR_OBJ_FLEE_CAR criminal3 criminal3_car
					criminal3_timera = game_timer + 2000
				ELSE
					criminal3_timera = game_timer
				ENDIF
				
				GOSUB criminal3_group_breaking
				
				GET_CHAR_COORDINATES criminal3 criminal3_x criminal3_y z
				x_temp = player_x - criminal3_x //	dist = (1_x - 2_x)~2  +	(1_y - 2_y)~2
				y_temp = player_y - criminal3_y
				x_temp = x_temp * x_temp
				y_temp = y_temp * y_temp
				sum_x_y_temp = x_temp + y_temp
				SQRT sum_x_y_temp sum_x_y_temp
				
				criminal3_car_speed = 1000.0 / sum_x_y_temp

				IF criminal3_car_speed > 100.0
					criminal3_car_speed = 100.0
				ENDIF
				IF criminal3_car_speed < 15.0
					criminal3_car_speed = 15.0
				ENDIF

				IF break_convoy_flag = 0
					IF NOT IS_CAR_DEAD criminal2_car
						gosub_car_to_slow = criminal3_car
						gosub_target_entity = criminal2_car
						GOSUB slow_criminal_if_close 
						criminal3_car_speed = gosub_car_to_slow_speed

						//THIS BIT OF CODE CHECKS TO SEE IF CAR2 IS INFRONT OF CAR3
						GET_CAR_FORWARD_X criminal3_car forward_x
						GET_CAR_FORWARD_Y criminal3_car forward_y
						GET_CAR_COORDINATES criminal2_car criminal2_car_x criminal2_car_y z
						GET_CAR_COORDINATES	criminal3_car criminal3_car_x criminal3_car_y z
						// IF (((forward_x * (car3_x - car2_x)) + (forward_y * (car3_y - car2_y)>) IS GREATER THAN 0.0 CAR IS IN FRONT
						temp_float_x = criminal3_car_x - criminal2_car_x
						forward_x = forward_x * temp_float_x
						temp_float_y = criminal3_car_y - criminal2_car_y
						forward_y = forward_y * temp_float_y
						car2_infront_car3 = forward_x + forward_y

						//THIS BIT OF CODE CHECKS TO SEE IF CAR3 IS INFRONT OF CAR2
						GET_CAR_FORWARD_X criminal2_car forward_x
						GET_CAR_FORWARD_Y criminal2_car forward_y
						GET_CAR_COORDINATES criminal3_car criminal3_car_x criminal3_car_y z
						GET_CAR_COORDINATES	criminal2_car criminal2_car_x criminal2_car_y z
						// IF (((forward_x * (car2_x - car3_x)) + (forward_y * (car2_y - car3_y)>) IS GREATER THAN 0.0 CAR IS IN FRONT
						temp_float_x = criminal2_car_x - criminal3_car_x
						forward_x = forward_x * temp_float_x
						temp_float_y = criminal2_car_y - criminal3_car_y
						forward_y = forward_y * temp_float_y
						car3_infront_car2 = forward_x + forward_y

						IF car2_infront_car3 > 0.0// +=INFRONT  -=BEHIND
							IF car3_infront_car2 < 0.0
								criminal3_car_speed = 0.0
							ENDIF
						ENDIF
					ELSE
						CAR_WANDER_RANDOMLY	criminal3_car
						break_convoy_flag = 1
					ENDIF
				ENDIF

				IF criminal3_car_speed = 0.0
					SET_CAR_TEMP_ACTION criminal3_car TEMPACT_WAIT 17
				ELSE
					SET_CAR_CRUISE_SPEED criminal3_car criminal3_car_speed
				ENDIF

			ENDIF
		ELSE
			criminal3_in_car_flag = -1
			GOSUB criminal3_group_breaking
			IF game_timer > criminal3_timera
				IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 criminal3 40.0 40.0 0
					IF NOT IS_PLAYER_IN_ANY_CAR player1
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal3 player1
					ELSE
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 criminal3 25.0 25.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT criminal3 player1
						ELSE
							gosub_ped = criminal3
							IF NOT IS_CAR_DEAD criminal3_car
								IF IS_CAR_HEALTH_GREATER criminal3_car 400
									IF LOCATE_CHAR_ANY_MEANS_CAR_2D	criminal3 criminal3_car 40.0 40.0 0
										SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal3 criminal3_car
									ELSE
										GOSUB criminal_steal_a_car
									ENDIF
								ELSE
									GOSUB criminal_steal_a_car
								ENDIF
							ELSE
								GOSUB criminal_steal_a_car
							ENDIF
						ENDIF
					ENDIF
				ELSE
					gosub_ped = criminal3
					IF NOT IS_CAR_DEAD criminal3_car
						IF IS_CAR_HEALTH_GREATER criminal3_car 400
							IF LOCATE_CHAR_ANY_MEANS_CAR_2D	criminal3 criminal3_car 40.0 40.0 0
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER criminal3 criminal3_car
							ELSE
								GOSUB criminal_steal_a_car
							ENDIF
						ELSE
							GOSUB criminal_steal_a_car
						ENDIF
					ELSE
						GOSUB criminal_steal_a_car
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		REMOVE_BLIP criminal3_blip
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal3
		IF criminal3_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal3_dead_flag = 1
		ENDIF
		IF NOT IS_CHAR_DEAD	criminal3_thug1
			criminal3 = criminal3_thug1
			criminal3_thug1 = -1
			criminal3_dead_flag = 0
			criminal3_thug1_dead_flag = 1
			ADD_BLIP_FOR_CHAR criminal3 criminal3_blip
			IF NOT IS_CHAR_DEAD	criminal3_thug2
				SET_CHAR_AS_LEADER criminal3_thug2 criminal3
				IF NOT IS_CHAR_IN_CHARS_GROUP criminal3_thug2 criminal3
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal3_thug2 player1
				ENDIF
			ENDIF
			IF NOT IS_CHAR_DEAD	criminal3_thug3
				SET_CHAR_AS_LEADER criminal3_thug3 criminal3
				IF NOT IS_CHAR_IN_CHARS_GROUP criminal3_thug3 criminal3
					SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal3_thug3 player1
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug1
			IF NOT IS_CHAR_DEAD	criminal3_thug2
				criminal3 = criminal3_thug2
				criminal3_thug2 = -1
				criminal3_dead_flag = 0
				criminal3_thug2_dead_flag = 1
				ADD_BLIP_FOR_CHAR criminal3 criminal3_blip
				IF NOT IS_CHAR_DEAD	criminal3_thug3
					SET_CHAR_AS_LEADER criminal3_thug3 criminal3
					IF NOT IS_CHAR_IN_CHARS_GROUP criminal3_thug3 criminal3
						SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal3_thug3 player1
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug2
				IF NOT IS_CHAR_DEAD	criminal3_thug3
					criminal3 = criminal3_thug3
					criminal3_thug3 = -1
					criminal3_dead_flag = 0
					criminal3_thug3_dead_flag = 1
					ADD_BLIP_FOR_CHAR criminal3 criminal3_blip
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug3
					criminal3_team_dead_flag = 1
				ENDIF
			ENDIF
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal3_thug1
		IF criminal3_thug1_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal3_thug1_dead_flag = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal3_thug2
		IF criminal3_thug2_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal3_thug2_dead_flag = 1
		ENDIF
	ENDIF

	IF IS_CHAR_DEAD	criminal3_thug3
		IF criminal3_thug3_dead_flag = 0
			++ total_criminals_killed
			REGISTER_CRIMINAL_CAUGHT
			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
			IF total_criminals_killed = 1
				DISPLAY_ONSCREEN_COUNTER_WITH_STRING total_criminals_killed COUNTER_DISPLAY_NUMBER KILLS
			ENDIF
			criminal3_thug3_dead_flag = 1
		ENDIF
	ENDIF
ENDIF

IF criminal1_team_dead_flag = 1
AND criminal2_team_dead_flag = 1
AND criminal3_team_dead_flag = 1
	GOTO mission_copcar_passed
ENDIF

GOTO copcar_oddjob_loop
	   		
	

mission_copcar_passed:

REGISTER_VIGILANTE_LEVEL copcar_print_level
++ copcar_level
IF IS_CHAR_IN_ANY_POLICE_VEHICLE scplayer
OR IS_PLAYER_IN_MODEL player1 HUNTER
OR IS_PLAYER_IN_MODEL player1 FBICAR
	STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_cop_car
	SET_CAN_BURST_CAR_TYRES players_cop_car FALSE
	GET_CAR_HEALTH players_cop_car players_cop_car_health
	players_cop_car_health += 100
	SET_CAR_HEALTH players_cop_car players_cop_car_health
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED criminal1_car
MARK_CHAR_AS_NO_LONGER_NEEDED criminal1
MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug1
MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug2
MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug3

MARK_CAR_AS_NO_LONGER_NEEDED criminal2_car
MARK_CHAR_AS_NO_LONGER_NEEDED criminal2
MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug1
MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug2
MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug3

MARK_CAR_AS_NO_LONGER_NEEDED criminal3_car
MARK_CHAR_AS_NO_LONGER_NEEDED criminal3
MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug1
MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug2
MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug3

REMOVE_BLIP criminal1_blip
REMOVE_BLIP criminal2_blip
REMOVE_BLIP criminal3_blip

vigilante_score	= copcar_level * copcar_level
vigilante_score *= 50
PRINT_WITH_NUMBER_BIG C_PASS vigilante_score 5000 5
//PRINT_WITH_NUMBER_BIG REWARD vigilante_score 5000 6
ADD_SCORE player1 vigilante_score

IF done_copcar_progress = 0
	IF copcar_level = 12
		PRINT_HELP C_COMP1//Vigilante mission level 12 complete: Your max Body Armor increased to 150
		PLAYER_MADE_PROGRESS 1
		INCREASE_PLAYER_MAX_ARMOUR player1 50
		ADD_ARMOUR_TO_CHAR scplayer 150
		REGISTER_ODDJOB_MISSION_PASSED
		done_copcar_progress = 1
	ENDIF
ENDIF

WHILE NOT IS_CHAR_IN_ANY_POLICE_VEHICLE scplayer
AND NOT IS_PLAYER_IN_MODEL player1 HUNTER
AND NOT IS_PLAYER_IN_MODEL player1 FBICAR
	IF game_time_flag = 0
		GET_GAME_TIMER game_timer_start
		IF cop_time_limit > 60000 
			copcar_timer = 60000
		ELSE
			copcar_timer = cop_time_limit
		ENDIF 
		game_time_flag = 1
	ENDIF
	GET_GAME_TIMER game_time_present
	game_time_difference = game_time_present - game_timer_start
	copcar_timer -= game_time_difference
	game_timer_start = game_time_present
	timer_in_secs = copcar_timer / 1000
	IF timer_in_secs < 1
		timer_in_secs = 0
		IF in_copcar_nice_timer < game_time_present
			PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
			copcar_cancelled_flag = 1
			GOTO copcar_failed
		ENDIF
	ELSE
		in_copcar_nice_timer = game_time_present + 1000
	ENDIF
	PRINT_WITH_NUMBER_NOW COPCART timer_in_secs 200 1	//You have ~1~ seconds to return to the car before the mission ends.

	WAIT 0

ENDWHILE

FREEZE_ONSCREEN_TIMER TRUE

IF IS_PLAYER_IN_ANY_CAR player1
	STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_cop_car
	SET_CAN_BURST_CAR_TYRES players_cop_car FALSE
	GET_CAR_HEALTH players_cop_car players_cop_car_health
	players_cop_car_health += 100
	SET_CAR_HEALTH players_cop_car players_cop_car_health
ENDIF

IF copcar_level < 13
	wanted_level_multiplier -= 0.05
	SET_WANTED_MULTIPLIER wanted_level_multiplier
ENDIF


GOTO next_criminal_to_kill		



// Mission copcar failed

copcar_failed:
//PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
//PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
RETURN

   

// mission cleanup

mission_cleanup_copcar:

flag_player_on_mission = 0

REMOVE_BLIP criminal1_blip
REMOVE_BLIP criminal2_blip
REMOVE_BLIP criminal3_blip
CLEAR_ONSCREEN_TIMER cop_time_limit
CLEAR_ONSCREEN_COUNTER total_criminals_killed
MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model
MARK_MODEL_AS_NO_LONGER_NEEDED random_ped_model
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED TEC9
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER
MARK_MODEL_AS_NO_LONGER_NEEDED CHROMEGUN
MARK_MODEL_AS_NO_LONGER_NEEDED MACHETE
MARK_MODEL_AS_NO_LONGER_NEEDED BAT

GET_GAME_TIMER timer_mobile_start

MISSION_HAS_FINISHED
RETURN




/////////////////////////////////////////////////////////////////////////////
request_random_car_model:// (MUST mark model not needed as soon as used) ////
/////////////////////////////////////////////////////////////////////////////


IF copcar_level > 1
	GENERATE_RANDOM_INT_IN_RANGE 26 37 random_int
ELSE
	GENERATE_RANDOM_INT_IN_RANGE 0 37 random_int
ENDIF

//bikes
IF random_int = 0
	random_car_model = PCJ600  //sports bike		181
ENDIF
IF random_int = 1
	random_car_model = FAGGIO  //moped				182
ENDIF
IF random_int = 2
	random_car_model = FREEWAY //harley-style		183
ENDIF
IF random_int = 3
	random_car_model = SANCHEZ //scrambler bike		188
ENDIF

//2-door
IF random_int = 4
	random_car_model = COMET   //2-door sports		200
ENDIF
IF random_int = 5
	random_car_model = STINGER //2-door sports		122
ENDIF
IF random_int = 6
	random_car_model = INFERNUS//2-door sports		131
ENDIF
IF random_int = 7
	random_car_model = CHEETAH //2-door sports		135
ENDIF
IF random_int = 8
	random_car_model = BANSHEE //2-door sports		149
ENDIF
IF random_int = 9
	random_car_model = PHEONIX //2-door sports		197
ENDIF
IF random_int = 10
	random_car_model = BFINJECT//souped-up buggy	144
ENDIF
IF random_int = 11
	random_car_model = IDAHO   //2-door 70s			121
ENDIF
IF random_int = 12
	random_car_model = LINERUN //big rig		   	123
ENDIF
IF random_int = 13
	random_car_model = MANANA  //2-door pish		130
ENDIF
IF random_int = 14
	random_car_model = PONY    //light van			133
ENDIF
IF random_int = 15
	random_car_model = MULE    //heavy van			134
ENDIF
IF random_int = 16
	random_car_model = BOBCAT  //80s pick-up		142
ENDIF
IF random_int = 17
	random_car_model = ESPERANT//2-door 70s			139
ENDIF
IF random_int = 18
	random_car_model = MRWHOOP //ice-cream van		143
ENDIF
IF random_int = 19
	random_car_model = STALLION//small muscle		159
ENDIF
IF random_int = 20
	random_car_model = YANKEE  //heavy van			176
ENDIF
IF random_int = 21
	random_car_model = SABRE   //2-door 70s muscle	195
ENDIF
IF random_int = 22
	random_car_model = BURRITO //light van			202
ENDIF
IF random_int = 23
	random_car_model = WALTON  //50s pick-up		198
ENDIF
IF random_int = 24
	random_car_model = HERMES  //2-door 50s saloon	194
ENDIF
IF random_int = 25
	random_car_model = RUMPO   //light van			160
ENDIF

//4-door
IF random_int = 26
	random_car_model = SENTINEL//4-door saloon		125
ENDIF
IF random_int = 27
	random_car_model = MOONBEAM//people carrier		138
ENDIF
IF random_int = 28
	random_car_model = WASHING //4-door saloon		141
ENDIF
IF random_int = 29
	random_car_model = LANDSTAL//4-door offroad		120
ENDIF
IF random_int = 30
	random_car_model = PEREN   //60s station wagon	124
ENDIF
IF random_int = 31
	random_car_model = ADMIRAL  //4-door saloon		165
ENDIF
IF random_int = 32
	random_car_model = GLENDALE//4-door 60s saloon	186
ENDIF
IF random_int = 33
	random_car_model = OCEANIC //4-door 60s saloon	187
ENDIF
IF random_int = 34
	random_car_model = GREENWOO
ENDIF
IF random_int = 35
	random_car_model = REGINA  //4-door 70s saloon	199
ENDIF
IF random_int = 36
	random_car_model = SENTXS
ENDIF

REQUEST_MODEL random_car_model

////////////////////////////////////////////////////////////////////////////
RETURN// random_car_model ////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
//select_a_weapon:// PED ///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

//	IF NOT IS_PLAYER_IN_ANY_CAR player1
//		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ped 25.0 25.0 0
//			GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_SHOTGUN 9999
//			RETURN
//		ENDIF
//		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ped 60.0 60.0 0
//			GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_RUGER 9999//AK47
//			RETURN
//		ENDIF
//		GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_TEC9 9999
//		RETURN
//	ENDIF
//
//	IF IS_PLAYER_IN_ANY_CAR player1
//		IF NOT LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ped 20.0 20.0 0
//			IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ped 40.0 40.0 0
//				STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_cop_car
//				GET_CAR_SPEED players_cop_car players_cop_car_speed
//				IF players_cop_car_speed < 18.0
//					GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_GRENADE 9999
//					RETURN
//				ENDIF
//			ENDIF
//		ENDIF
//		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 ped 30.0 30.0 0
//			GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_SHOTGUN 9999
//			RETURN
//		ELSE
//			GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_RUGER 9999
//			RETURN
//		ENDIF
//	ENDIF					
		
////////////////////////////////////////////////////////////////////////////
//RETURN////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
slow_criminal_if_close: ////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF gosub_target_entity = -1
	GET_PLAYER_COORDINATES player1 gosub_target_car_x gosub_target_car_y temp_float_x
ELSE
	GET_CAR_COORDINATES gosub_target_entity gosub_target_car_x	gosub_target_car_y temp_float_x
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

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
criminal_steal_a_car: //////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	gosub_ped
	
	GET_CHAR_COORDINATES gosub_ped coord_1_x coord_1_y coord_1_z

	IF heading = 919.9
		CREATE_CAR random_car_model	coord_1_x coord_1_y coord_1_z car
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 gosub_ped 40.0 40.0 0
		coord_2_x = coord_1_x + 40.0
		coord_2_y = coord_1_y + 40.0
		coord_1_x = coord_1_x - 40.0
		coord_1_y = coord_1_y - 40.0
		MARK_CAR_AS_NO_LONGER_NEEDED car
		car = -1
		GET_RANDOM_CAR_OF_TYPE_IN_AREA coord_1_x coord_1_y coord_2_x coord_2_y -1 car
		IF car = -1
		OR criminal1_car = car
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_ped player1
		ELSE
			IF IS_CAR_HEALTH_GREATER car 400
				GET_NUMBER_OF_FOLLOWERS gosub_ped num_of_followers
				GET_MAXIMUM_NUMBER_OF_PASSENGERS car max_passengers
				IF NOT num_of_followers > max_passengers
					LOCK_CAR_DOORS car CARLOCK_UNLOCKED
					SET_CAR_CRUISE_SPEED car 0.0
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_ped car
				ELSE
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_ped player1
				ENDIF
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT gosub_ped player1
				MARK_CAR_AS_NO_LONGER_NEEDED car
				car = -1
			ENDIF
		ENDIF
	ELSE
		GET_CLOSEST_CAR_NODE_WITH_HEADING coord_1_x coord_1_y coord_1_z coord_1_x coord_1_y coord_1_z heading
		IF NOT IS_POINT_ON_SCREEN coord_1_x coord_1_y coord_1_z 3.0
			IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY coord_1_x coord_1_y coord_1_z 3.0 3.0 2.0
				IF HAS_MODEL_LOADED	random_car_model
					MARK_CAR_AS_NO_LONGER_NEEDED car
					CREATE_CAR random_car_model	coord_1_x coord_1_y coord_1_z car
					SET_CAR_HEADING	car heading
					SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER gosub_ped car
				ENDIF
			ELSE
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
criminal_car_stuck_checks://////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

GET_GAME_TIMER game_time

IF NOT IS_CAR_DEAD gosub_stuck_car
	IF IS_CAR_UPSIDEDOWN gosub_stuck_car
	AND IS_CAR_STOPPED gosub_stuck_car
		break_convoy_flag = 1
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
//								SET_JAMES_CAR_ON_PATH_TO_PLAYER gosub_stuck_car
								stuck_timer_start = game_time
								car_stuck_flag = 0
								break_convoy_flag = 1
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
criminal1_group_breaking:////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	criminal1
	IF NOT IS_CHAR_DEAD	criminal1_thug1
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal1_thug1 criminal1
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal1_thug1 criminal1 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal1_thug1 criminal1
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal1_thug1 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	criminal1_thug2
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal1_thug2 criminal1
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal1_thug2 criminal1 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal1_thug2 criminal1
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal1_thug2 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug2
	ENDIF
	
	IF NOT IS_CHAR_DEAD	criminal1_thug3
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal1_thug3 criminal1
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal1_thug3 criminal1 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal1_thug3 criminal1
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal1_thug3 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal1_thug3
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
criminal2_group_breaking:////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	criminal2
	IF NOT IS_CHAR_DEAD	criminal2_thug1
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal2_thug1 criminal2
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal2_thug1 criminal2 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal2_thug1 criminal2
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal2_thug1 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	criminal2_thug2
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal2_thug2 criminal2
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal2_thug2 criminal2 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal2_thug2 criminal2
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal2_thug2 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug2
	ENDIF
	
	IF NOT IS_CHAR_DEAD	criminal2_thug3
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal2_thug3 criminal2
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal2_thug3 criminal2 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal2_thug3 criminal2
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal2_thug3 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal2_thug3
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
criminal3_group_breaking:////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	criminal3
	IF NOT IS_CHAR_DEAD	criminal3_thug1
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal3_thug1 criminal3
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal3_thug1 criminal3 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal3_thug1 criminal3
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal3_thug1 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug1
	ENDIF
	
	IF NOT IS_CHAR_DEAD	criminal3_thug2
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal3_thug2 criminal3
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal3_thug2 criminal3 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal3_thug2 criminal3
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal3_thug2 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug2
	ENDIF
	
	IF NOT IS_CHAR_DEAD	criminal3_thug3
		IF NOT IS_CHAR_IN_CHARS_GROUP criminal3_thug3 criminal3
			IF LOCATE_CHAR_ANY_MEANS_CHAR_2D criminal3_thug3 criminal3 30.0 30.0 0
				SET_CHAR_AS_LEADER criminal3_thug3 criminal3
			ELSE
				SET_CHAR_OBJ_KILL_PLAYER_ANY_MEANS criminal3_thug3 player1
			ENDIF
		ENDIF
	ELSE
		MARK_CHAR_AS_NO_LONGER_NEEDED criminal3_thug3
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
print_text_for_zone_char_is_in://///////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD	criminal1
	IF IS_CHAR_IN_ZONE criminal1 VICE_C
		PRINT_STRING_IN_STRING_NOW C_BREIF VICE_C 5000 1 // The criminal is proceeding south in Vice City
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 BEACH1
		PRINT_STRING_IN_STRING_NOW C_BREIF BEACH1 5000 1 // The criminal is proceeding south in Ocean Beach
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 BEACH2
		PRINT_STRING_IN_STRING_NOW C_BREIF BEACH2 5000 1 // The criminal is proceeding south in Washington Beach
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 BEACH3
		PRINT_STRING_IN_STRING_NOW C_BREIF BEACH3 5000 1 // The criminal is proceeding south in Vice Point
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 GOLFC
		PRINT_STRING_IN_STRING_NOW C_BREIF GOLFC 5000 1 // The criminal is proceeding south in Leaf Links
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 STARI
		PRINT_STRING_IN_STRING_NOW C_BREIF STARI 5000 1 // The criminal is proceeding south in Starfish Island
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 DOCKS
		PRINT_STRING_IN_STRING_NOW C_BREIF DOCKS 5000 1 // The criminal is proceeding south in ViceporT
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 HAVANA
		PRINT_STRING_IN_STRING_NOW C_BREIF HAVANA 5000 1 // The criminal is proceeding south in Little Havana
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 HAITI
		PRINT_STRING_IN_STRING_NOW C_BREIF HAITI 5000 1 // The criminal is proceeding south in Little Haiti
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 PORNI
		PRINT_STRING_IN_STRING_NOW C_BREIF PORNI 5000 1 // The criminal is proceeding south in Prawn Island
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 DTOWN
		PRINT_STRING_IN_STRING_NOW C_BREIF DTOWN 5000 1 // The criminal is proceeding south in Downtown
	ENDIF

	IF IS_CHAR_IN_ZONE criminal1 A_PORT
		PRINT_STRING_IN_STRING_NOW C_BREIF A_PORT 5000 1 // The criminal is proceeding south in Escobar International
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////////////////////////////////////////////////////////////////////////////
setup_ped_threats_etc://////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

SET_CHAR_IS_CHRIS_CRIMINAL ped TRUE
SET_CHAR_RUNNING ped TRUE
SET_CHAR_ONLY_DAMAGED_BY_PLAYER ped TRUE
CLEAR_CHAR_THREAT_SEARCH ped
SET_CHAR_PERSONALITY ped PEDSTAT_TOUGH_GUY

SET_CHAR_THREAT_SEARCH ped THREAT_PLAYER1
SET_CHAR_THREAT_SEARCH ped THREAT_PLAYER2
SET_CHAR_THREAT_SEARCH ped THREAT_PLAYER3
SET_CHAR_THREAT_SEARCH ped THREAT_PLAYER4
SET_CHAR_THREAT_SEARCH ped THREAT_CIVMALE
SET_CHAR_THREAT_SEARCH ped THREAT_CIVFEMALE
SET_CHAR_THREAT_SEARCH ped THREAT_COP
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_CUBAN	
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_HAITIAN
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_STREET
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_DIAZ
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_SECURITY
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_BIKER
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_PLAYER
SET_CHAR_THREAT_SEARCH ped THREAT_GANG_GOLFER
SET_CHAR_THREAT_SEARCH ped THREAT_EMERGENCY
SET_CHAR_THREAT_SEARCH ped THREAT_PROSTITUTE
SET_CHAR_THREAT_SEARCH ped THREAT_CRIMINAL
SET_CHAR_THREAT_SEARCH ped THREAT_SPECIAL
SET_CHAR_THREAT_SEARCH ped THREAT_GUN
SET_CHAR_THREAT_SEARCH ped THREAT_COP_CAR
SET_CHAR_THREAT_SEARCH ped THREAT_FAST_CAR
SET_CHAR_THREAT_SEARCH ped THREAT_FIREMAN
SET_CHAR_HEED_THREATS ped TRUE

IF copcar_level = 0
	GENERATE_RANDOM_INT_IN_RANGE 0 2 random_int
ENDIF

IF copcar_level > 1
	GENERATE_RANDOM_INT_IN_RANGE 0 3 random_int
ENDIF

IF copcar_level > 3
	GENERATE_RANDOM_INT_IN_RANGE 0 4 random_int
ENDIF

IF copcar_level > 5
	GENERATE_RANDOM_INT_IN_RANGE 0 5 random_int
ENDIF

IF copcar_level > 7
	GENERATE_RANDOM_INT_IN_RANGE 0 6 random_int
ENDIF

IF random_int = 0
	GENERATE_RANDOM_INT_IN_RANGE 10 13 random_int
	IF random_int = 10
		GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_MACHETE 9999
	ENDIF
	IF random_int = 11
		GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_BASEBALLBAT 9999
	ENDIF
ENDIF

IF random_int = 1
	GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_PISTOL 9999
ENDIF

IF random_int = 2
	GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_TEC9 9999
ENDIF

IF random_int = 3
	GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_RUGER 9999
ENDIF

IF random_int = 4
OR random_int = 5
	GIVE_WEAPON_TO_CHAR ped WEAPONTYPE_SHOTGUN 9999
ENDIF


////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////////////////////
copcar_cancelled_checks:////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////

IF NOT cop_time_limit = -100
	IF cop_time_limit < 1
		copcar_cancelled_flag = 1
		PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
		RETURN
	ENDIF
ENDIF

IF NOT IS_CHAR_IN_ANY_POLICE_VEHICLE scplayer
AND NOT IS_PLAYER_IN_MODEL player1 HUNTER
AND NOT IS_PLAYER_IN_MODEL player1 FBICAR
	FREEZE_ONSCREEN_TIMER FALSE
	IF game_time_flag = 0
		GET_GAME_TIMER game_timer_start
		IF cop_time_limit > 60000 
			copcar_timer = 60000
		ELSE
			copcar_timer = cop_time_limit
		ENDIF 
		game_time_flag = 1
	ENDIF
	GET_GAME_TIMER game_time_present
	game_time_difference = game_time_present - game_timer_start
	copcar_timer -= game_time_difference
	game_timer_start = game_time_present
	timer_in_secs = copcar_timer / 1000
	IF timer_in_secs < 1
		timer_in_secs = 0
		IF in_copcar_nice_timer < game_time_present
			PRINT_NOW C_TIME 3000 1//"Your time as a law enforcer is over!"
			copcar_cancelled_flag = 1
			RETURN
		ENDIF
	ELSE
		in_copcar_nice_timer = game_time_present + 1000
	ENDIF
	PRINT_WITH_NUMBER_NOW COPCART timer_in_secs 200 1	//You have ~1~ seconds to return to a squad car before the mission ends.
ENDIF

GET_CONTROLLER_MODE controlmode

IF IS_CHAR_IN_ANY_POLICE_VEHICLE scplayer
OR IS_PLAYER_IN_MODEL player1 HUNTER
OR IS_PLAYER_IN_MODEL player1 FBICAR
	STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_cop_car
	SET_CAN_BURST_CAR_TYRES players_cop_car FALSE
	IF NOT controlmode = 3
		IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			IF mission_end_button = 1
				mission_end_button = 2
			ENDIF
		ELSE
			IF mission_end_button = 0
				mission_end_button = 1
			ENDIF
		ENDIF
	ELSE
		IF IS_BUTTON_PRESSED PAD1 SQUARE
			IF mission_end_button = 1
				mission_end_button = 2
			ENDIF
		ELSE
			IF mission_end_button = 0
				mission_end_button = 1
			ENDIF
		ENDIF
	ENDIF
	
	game_time_flag = 0
ENDIF

IF mission_end_button = 2
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW C_CANC 3000 1//"Police mission cancelled!"
			copcar_cancelled_flag = 1
			RETURN
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW C_CANC 3000 1//"Police mission cancelled!"
			copcar_cancelled_flag = 1
			RETURN
		ENDIF
	ENDIF
ENDIF

////////////////////////////////////////////////////////////////////////////
RETURN//////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////



////bikes
//PCJ600	//sports bike			181
//FAGGIO	//moped					182
//FREEWAY//harley-style			183
//SANCHEZ//scrambler bike			188
//
////2-door
//COMET	 //2-door sports		200
//DELUXO	 //2-door sports		201
//STINGER //2-door sports			122
//INFERNUS//2-door sports			131
//CHEETAH //2-door sports			135
//BANSHEE //2-door sports			149
//PHEONIX //2-door sports			197
//BFINJECT//souped-up buggy		144
//IDAHO   //2-door 70s			121
//LINERUN //big rig			 	123
//MANANA  //2-door pish			130
//PONY    //light van				133
//MULE 	 //heavy van			134
//BOBCAT  //80s pick-up			142
//ESPERANT//2-door 70s			139
//MRWHOOP //ice-cream van			143
//STALLION//small 2-door muscle	159
//YANKEE	 //heavy van			176
//SABRE	 //2-door 70s muscle	195
//BURRITO //light van				202
//WALTON  //50s pick-up			198
//
////4-door
//LANDSTAL//4-door offroad		120
//PEREN   //60s station wagon		124
//SENTINEL//4-door saloon			125
//STRETCH //limo					129
//MOONBEAM//people carrier		138
//WASHING //4-door saloon			141
//BUS	 //50s non-service bus		151
//COACH	 //greyhound coach		157
//RUMPO	 //light van			160
//AMBASS	 //4-door saloon		165
//GLENDALE//4-door 60s saloon		186
//OCEANIC //4-door 60s saloon		187
//HERMES	 //4-door 50s saloon	194
//REGINA	 //4-door 70s saloon	199
//RANCHER //hefty SUV				209

}