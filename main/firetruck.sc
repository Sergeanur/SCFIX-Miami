MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// *************************************** Fire missions *********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_fire

GOSUB failed

MISSION_END
 
// Variables for mission

//PEDS CARS OBJECTS FIRES ETC
VAR_INT onfire_car_fire onfire_car_1_fire onfire_car_2_fire onfire_car_3_fire
VAR_INT onfire_ped_fire onfire_ped_1_fire onfire_ped_2_fire onfire_ped_3_fire onfire_ped_4_fire
VAR_INT onfire_ped_5_fire onfire_ped_6_fire onfire_ped_7_fire onfire_ped_8_fire onfire_ped_9_fire
//VAR_INT fire fire1 fire2 fire3 fire4 fire5 
//BLIPS
VAR_INT	onfire_car_blip onfire_car_1_blip onfire_car_2_blip	onfire_car_3_blip
VAR_INT	onfire_ped_blip onfire_ped_1_blip onfire_ped_2_blip	onfire_ped_3_blip onfire_ped_4_blip
VAR_INT	onfire_ped_5_blip onfire_ped_6_blip onfire_ped_7_blip onfire_ped_8_blip onfire_ped_9_blip
//FLAGS TIMERS COUNTER ETC
VAR_INT	fire_time_limit	fail_firetruck_mission intermediate_int	score_ft 
VAR_INT displayed_timer displayed_counter fires_extinguished firetruck_level mission_end_button_ft
VAR_INT total_score players_car_health firetruck_level_minus_4 fires_extinguished_this_round
VAR_INT onfire_car_health fires_needing_extinguishing car_health_test_timer
VAR_INT onfire_car_flag onfire_car_1_flag onfire_car_2_flag	onfire_car_3_flag
VAR_INT onfire_ped_flag onfire_ped_1_flag onfire_ped_2_flag	onfire_ped_3_flag onfire_ped_4_flag
VAR_INT onfire_ped_5_flag onfire_ped_6_flag onfire_ped_7_flag onfire_ped_8_flag onfire_ped_9_flag
//VAR_INT fire_flag fire1_flag fire2_flag fire3_flag fire4_flag	fire5_flag 
//COORD MATHS
VAR_FLOAT time_divider
VAR_FLOAT players_distance_from_fire fire_time_limit_float random_car_heading
//VAR_FLOAT fire1_x fire1_y fire2_x fire2_y fire3_x fire3_y fire4_x fire4_y fire5_x fire5_y

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE stuff
//VAR_INT	random_int random_car_model	players_car
//VAR_FLOAT car1_x car1_y car1_z car2_x car2_y car2_z car3_x car3_y car3_z
//VAR_FLOAT dx dy temp_x temp_y temp_xy sum_x_y_temp

// ****************************************Mission Start************************************

mission_start_fire:

flag_player_on_mission = 1
flag_player_on_fire_mission = 1

SCRIPT_NAME firetru

WAIT 0

IF done_firetruck_progress = 0
	REGISTER_MISSION_GIVEN
ENDIF

{
LVAR_INT onfire_car onfire_car_1 onfire_car_2 onfire_car_3
LVAR_INT onfire_ped onfire_ped_1 onfire_ped_2 onfire_ped_3 onfire_ped_4
LVAR_INT onfire_ped_5 onfire_ped_6 onfire_ped_7 onfire_ped_8 onfire_ped_9

LOAD_MISSION_TEXT FIRETRK


fire_time_limit			= 0
score_ft				= 0
displayed_timer			= 0
fires_extinguished		= 0
displayed_counter		= 0
total_score				= 0
mission_end_button_ft	= 0
time_divider 			= 5.5//7.0
firetruck_level 		= 1
fail_firetruck_mission  = 0
random_car_model = 0
intermediate_int = 0
players_car_health = 0
onfire_car_1 = -1
onfire_car_1 = -1
onfire_car_1 = -1
car_health_test_timer = 0

onfire_ped_1_fire = 0
onfire_ped_2_fire = 0
onfire_ped_3_fire = 0
onfire_ped_4_fire = 0
onfire_ped_5_fire = 0
onfire_ped_6_fire = 0
onfire_ped_7_fire = 0
onfire_ped_8_fire = 0
onfire_ped_9_fire = 0

SET_WANTED_MULTIPLIER 0.5

GOTO firetruck_fool_compiler // SCFIX: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_COORD x y z onfire_car_blip
	ADD_BLIP_FOR_COORD x y z onfire_car_1_blip
	ADD_BLIP_FOR_COORD x y z onfire_car_2_blip
	ADD_BLIP_FOR_COORD x y z onfire_car_3_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_1_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_2_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_3_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_4_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_5_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_6_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_7_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_8_blip
	ADD_BLIP_FOR_COORD x y z onfire_ped_9_blip
firetruck_fool_compiler: // SCFIX: remove flag_player_on_mission = 0 check

fire_generation_start:

fires_needing_extinguishing = 0
fires_extinguished_this_round = 0

onfire_car_1_flag = 0
onfire_car_2_flag = 0
onfire_car_3_flag = 0
onfire_ped_1_flag = 0
onfire_ped_2_flag = 0
onfire_ped_3_flag = 0
onfire_ped_4_flag = 0
onfire_ped_5_flag = 0
onfire_ped_6_flag = 0
onfire_ped_7_flag = 0
onfire_ped_8_flag = 0
onfire_ped_9_flag = 0
//fire1_flag = 0
//fire2_flag = 0
//fire3_flag = 0
//fire4_flag = 0
//fire5_flag = 0

/////////////////////////////////////////////////////////////////////
//REQUEST CAR MODEL
/////////////////////////////////////////////////////////////////////
GENERATE_RANDOM_INT_IN_RANGE 25 44 random_int

//4-door
IF random_int = 25
	random_car_model = SENTINEL//4-door saloon		125
ENDIF
IF random_int = 26
	random_car_model = MOONBEAM//people carrier		138
ENDIF
IF random_int = 27
	random_car_model = WASHING //4-door saloon		141
ENDIF
IF random_int = 28
	random_car_model = LANDSTAL//4-door offroad		120
ENDIF
IF random_int = 29
	random_car_model = PEREN   //60s station wagon	124
ENDIF
IF random_int = 30
	random_car_model = ADMIRAL  //4-door saloon		165
ENDIF
IF random_int = 31
	random_car_model = GLENDALE//4-door 60s saloon	186
ENDIF
IF random_int = 32
	random_car_model = OCEANIC //4-door 60s saloon	187
ENDIF
IF random_int = 33
	random_car_model = REGINA  //4-door 70s saloon	199
ENDIF
IF random_int = 34
	random_car_model = PONY
ENDIF
IF random_int = 35
	random_car_model = TAXI
ENDIF
IF random_int = 36
	random_car_model = CABBIE
ENDIF
IF random_int = 37
	random_car_model = RUMPO
ENDIF
IF random_int = 38
	random_car_model = GANGBUR
ENDIF
IF random_int = 39
	random_car_model = PATRIOT
ENDIF
IF random_int = 40
	random_car_model = BURRITO
ENDIF
IF random_int = 41
	random_car_model = KAUFMAN
ENDIF
IF random_int = 42
	random_car_model = GREENWOO
ENDIF
IF random_int = 43
	random_car_model = SENTXS
ENDIF

REQUEST_MODEL random_car_model


/////////////////////////////////////////////////////////////////////
//GET RANDOM FIRE COORDS
/////////////////////////////////////////////////////////////////////
next_fire:

GOSUB do_cancelled_checks
IF fail_firetruck_mission = 1
	GOTO failed
ENDIF

//xmin -247.43 ymin -1813.62 xmax 683.41 ymax 1308.102//BEACH AREA
//xmin -1802.615 ymin -1518.473 xmax -270.134 ymax 1591.896//MAINLAND AREA

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

IF firetruck_level < 5	
	GET_CLOSEST_CAR_NODE car1_x car1_y 10.0 car1_x car1_y car1_z
ELSE
	IF firetruck_level < 9
		GET_CLOSEST_STRAIGHT_ROAD car1_x car1_y 10.0 12.0 500.0 car1_x car1_y car1_z car2_x car2_y car2_z z
		IF car1_x = 0.0
		AND	car1_y = 0.0
		AND	car2_x = 0.0
		AND	car2_y = 0.0
			WAIT 0
			GOTO next_fire
		ENDIF
		//MAKES THE DISTANCE BETWEEN CAR1_XYZ AND CAR2_XYZ EQUAL TO MINLENGTH OF STRAIGHT ROAD (8.0)
		dx = car2_x - car1_x
		dy = car2_y - car1_y
		temp_x = dx * dx
		temp_y = dy * dy
		temp_xy = temp_x + temp_y
		SQRT temp_xy temp_xy
		sum_x_y_temp = 12.0 / temp_xy
		temp_x = dx * sum_x_y_temp
		car2_x = car1_x + temp_x
		temp_y = dy * sum_x_y_temp
		car2_y = car1_y + temp_y
		
		car1_z += 0.5
		car2_z += 0.5
	ELSE
		GET_CLOSEST_STRAIGHT_ROAD car1_x car1_y 10.0 18.0 500.0 car2_x car2_y car2_z car3_x car3_y car3_z z
		IF car2_x = 0.0
		AND	car2_y = 0.0
		AND	car3_x = 0.0
		AND	car3_y = 0.0
			WAIT 0
			GOTO next_fire
		ENDIF
		
		//MAKES THE DISTANCE BETWEEN car2_XYZ AND CAR3_XYZ EQUAL TO MINLENGTH OF STRAIGHT ROAD (13.0)
		dx = car3_x - car2_x
		dy = car3_y - car2_y
		temp_x = dx * dx
		temp_y = dy * dy
		temp_xy = temp_x + temp_y
		SQRT temp_xy temp_xy
		sum_x_y_temp = 18.0 / temp_xy
		temp_x = dx * sum_x_y_temp
		car3_x = car2_x + temp_x
		temp_y = dy * sum_x_y_temp
		car3_y = car2_y + temp_y

		//WORKS OUT THE MIDDLE POINT OF car2_XYZ AND CAR3_XYZ
		car1_x = car2_x	- car3_x
		car1_x = car1_x / 2.0
		car1_x = car1_x	+ car3_x
		
		car1_y = car2_y	- car3_y
		car1_y = car1_y / 2.0
		car1_y = car1_y	+ car3_y
		
		car1_z = car2_z	- car3_z
		car1_z = car1_z / 2.0
		car1_z = car1_z	+ car3_z
		
		car2_z += 0.5
		car1_z += 0.5
		car3_z += 0.5
	ENDIF
ENDIF

/////////////////////////////////////////////////////////////////////
//MAKE SURE FIRE COORDS ARE NOT IN A BAD PLACE
/////////////////////////////////////////////////////////////////////

IF car1_z < 7.0
	WAIT 0
	GOTO next_fire
ENDIF

GET_PLAYER_COORDINATES player1 player_x player_y player_z
GET_DISTANCE_BETWEEN_COORDS_2D player_x player_y car1_x car1_y players_distance_from_fire

IF players_distance_from_fire < 150.0
OR players_distance_from_fire > 600.0
	WAIT 0
	GOTO next_fire
ENDIF
			 //STADIUM
IF car1_x >  -1905.785
AND car1_x < -1105.785
AND car1_y > 745.678	
AND car1_y < 1773.513
	WAIT 0
	GOTO next_fire
ENDIF
			 //GOLF COURSE & PORN
IF car1_x >  -265.018 
AND car1_x < 170.188 
AND car1_y > -275.942 
AND car1_y < 1689.059
	WAIT 0
	GOTO next_fire
ENDIF
			 //MORE GOLFCOURSE
IF car1_x >  164.191 
AND car1_x < 259.713 
AND car1_y > -187.926
AND car1_y < 631.97
	WAIT 0
	GOTO next_fire
ENDIF
			 //GOLFCOURSE BRIDGE
IF car1_x >  -731.729
AND car1_x < -263.334 
AND car1_y > -4.399
AND car1_y < 62.853
	WAIT 0
	GOTO next_fire
ENDIF
			 //STARISLAND BRIDGE
IF car1_x >  -180.88 
AND car1_x < 64.112 
AND car1_y >  -499.183
AND car1_y < -417.519
	WAIT 0
	GOTO next_fire
ENDIF
			 //STARISLAND
IF car1_x >  -762.855  
AND car1_x < -172.566 
AND car1_y > -667.099
AND car1_y < -224.382
	WAIT 0
	GOTO next_fire
ENDIF

IF flag_baron_mission2_passed = 0
	IF car1_x > -2327.212 
	AND car1_x < -261.402
	AND car1_y > -2027.821
	AND car1_y < 1894.426
		WAIT 0
		GOTO next_fire
	ENDIF

	IF car1_x >  -265.018
	AND car1_x < 170.188
	AND car1_y > -275.942
	AND car1_y < 1689.059
		WAIT 0
		GOTO next_fire
	ENDIF

	IF car1_x >  -265.657
	AND car1_x < 36.828
	AND car1_y > -729.217
	AND car1_y < -275.488
		WAIT 0
		GOTO next_fire
	ENDIF

	IF car1_x >  164.191
	AND car1_x < 259.713
	AND car1_y > -187.926
	AND car1_y < 631.97
		WAIT 0
		GOTO next_fire
	ENDIF
ENDIF

/////////////////////////////////////////////////////////////////////
//GENERATE TIMELIMIT
/////////////////////////////////////////////////////////////////////
fire_time_limit_float = players_distance_from_fire / time_divider

fire_time_limit_float = fire_time_limit_float * 1000.0
intermediate_int =#	fire_time_limit_float
fire_time_limit += intermediate_int

IF fires_extinguished = 0
	IF fire_time_limit < 50000
		fire_time_limit = 50000
	ENDIF
ENDIF

/////////////////////////////////////////////////////////////////////
//WAIT FOR CAR MODEL TO BE LOADED
/////////////////////////////////////////////////////////////////////
WHILE NOT HAS_MODEL_LOADED random_car_model
	WAIT 0

	GOSUB do_cancelled_checks
	IF fail_firetruck_mission = 1
		GOTO failed
	ENDIF

ENDWHILE

/////////////////////////////////////////////////////////////////////
//CREATE THE FIRE SCENE
/////////////////////////////////////////////////////////////////////

CREATE_CAR random_car_model car1_x car1_y car1_z onfire_car_1
GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 359.9 random_car_heading
SET_CAR_HEADING	onfire_car_1 random_car_heading
START_CAR_FIRE onfire_car_1 onfire_car_1_fire
ADD_BLIP_FOR_CAR onfire_car_1 onfire_car_1_blip
CHANGE_BLIP_DISPLAY onfire_car_1_blip BLIP_ONLY
SET_UPSIDEDOWN_CAR_NOT_DAMAGED onfire_car_1 TRUE
++ fires_needing_extinguishing

CREATE_RANDOM_CHAR_AS_DRIVER onfire_car_1 onfire_ped_1
SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_1 TRUE
++ fires_needing_extinguishing

IF firetruck_level > 2
	CREATE_RANDOM_CHAR_AS_PASSENGER onfire_car_1 0 onfire_ped_2
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_2 TRUE
	++ fires_needing_extinguishing
ENDIF

IF firetruck_level > 3
	CREATE_RANDOM_CHAR_AS_PASSENGER onfire_car_1 1 onfire_ped_3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_3 TRUE
	++ fires_needing_extinguishing
//	temp_x = car1_x - 5.0
//	x = temp_x + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x fire1_x
//	temp_y = car1_y - 5.0
//	y = temp_y + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y fire1_y
//	START_SCRIPT_FIRE fire1_x fire1_y car1_z fire1
ENDIF

IF firetruck_level > 4
	temp_x = car2_x - 5.0
	x = temp_x + 10.0
	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x car2_x
	temp_y = car2_y - 5.0
	y = temp_y + 10.0
	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y car2_y
	CREATE_CAR random_car_model car2_x car2_y car2_z onfire_car_2
	TURN_CAR_TO_FACE_COORD onfire_car_2	car1_x car1_y
	START_CAR_FIRE onfire_car_2 onfire_car_2_fire
	SET_CAR_FORWARD_SPEED onfire_car_2 20.0
	ADD_BLIP_FOR_CAR onfire_car_2 onfire_car_2_blip
	CHANGE_BLIP_DISPLAY onfire_car_2_blip BLIP_ONLY
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED onfire_car_2 TRUE
	++ fires_needing_extinguishing
ENDIF

IF firetruck_level > 5
	CREATE_RANDOM_CHAR_AS_DRIVER onfire_car_2 onfire_ped_4
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_4 TRUE
	++ fires_needing_extinguishing
//	temp_x = car1_x - 5.0
//	x = temp_x + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x fire2_x
//	temp_y = car1_y - 5.0
//	y = temp_y + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y fire2_y
//	START_SCRIPT_FIRE fire2_x fire2_y car1_z fire2
ENDIF

IF firetruck_level > 6
	CREATE_RANDOM_CHAR_AS_PASSENGER onfire_car_2 0 onfire_ped_5
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_5 TRUE
	++ fires_needing_extinguishing
ENDIF

IF firetruck_level > 7
	CREATE_RANDOM_CHAR_AS_PASSENGER onfire_car_2 1 onfire_ped_6
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_6 TRUE
	++ fires_needing_extinguishing
//	temp_x = car1_x - 5.0
//	x = temp_x + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x fire3_x
//	temp_y = car1_y - 5.0
//	y = temp_y + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y fire3_y
//	START_SCRIPT_FIRE fire3_x fire3_y car1_z fire3
ENDIF

IF firetruck_level > 8
	temp_x = car3_x - 5.0
	x = temp_x + 10.0
	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x car3_x
	temp_y = car3_y - 5.0
	y = temp_y + 10.0
	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y car3_y
	CREATE_CAR random_car_model car3_x car3_y car3_z onfire_car_3
	TURN_CAR_TO_FACE_COORD onfire_car_3	car1_x car1_y
	START_CAR_FIRE onfire_car_3 onfire_car_3_fire
	SET_CAR_FORWARD_SPEED onfire_car_3 20.0
	ADD_BLIP_FOR_CAR onfire_car_3 onfire_car_3_blip
	CHANGE_BLIP_DISPLAY onfire_car_3_blip BLIP_ONLY
	SET_UPSIDEDOWN_CAR_NOT_DAMAGED onfire_car_3 TRUE
	++ fires_needing_extinguishing
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model

IF firetruck_level > 9
	CREATE_RANDOM_CHAR_AS_DRIVER onfire_car_3 onfire_ped_7
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_7 TRUE
	++ fires_needing_extinguishing
//	temp_x = car1_x - 5.0
//	x = temp_x + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x fire4_x
//	temp_y = car1_y - 5.0
//	y = temp_y + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y fire4_y
//	START_SCRIPT_FIRE fire4_x fire4_y car1_z fire4
ENDIF

IF firetruck_level > 10
	CREATE_RANDOM_CHAR_AS_PASSENGER onfire_car_3 0 onfire_ped_8
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_8 TRUE
	++ fires_needing_extinguishing
ENDIF

IF firetruck_level > 11
	CREATE_RANDOM_CHAR_AS_PASSENGER onfire_car_3 1 onfire_ped_9
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER	onfire_ped_9 TRUE
	++ fires_needing_extinguishing
//	temp_x = car1_x - 5.0
//	x = temp_x + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_x x fire5_x
//	temp_y = car1_y - 5.0
//	y = temp_y + 10.0
//	GENERATE_RANDOM_FLOAT_IN_RANGE temp_y y fire5_y
//	START_SCRIPT_FIRE fire5_x fire5_y car1_z fire5
ENDIF

IF NOT IS_CAR_DEAD onfire_car_1
	SET_CAR_MISSION onfire_car_1 MISSION_STOP_FOREVER
ENDIF
IF NOT IS_CAR_DEAD onfire_car_2
	SET_CAR_MISSION onfire_car_2 MISSION_STOP_FOREVER
ENDIF
IF NOT IS_CAR_DEAD onfire_car_3
	SET_CAR_MISSION onfire_car_3 MISSION_STOP_FOREVER
ENDIF

/////////////////////////////////////////////////////////////////////
//DO PROMPTS & GAMEY STUFF
/////////////////////////////////////////////////////////////////////

IF NOT IS_CHAR_DEAD onfire_ped_1
	IF firetruck_level < 5
		IF IS_CHAR_IN_ZONE onfire_ped_1 VICE_C
			PRINT_STRING_IN_STRING_NOW F_START VICE_C 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 BEACH1
			PRINT_STRING_IN_STRING_NOW F_START BEACH1 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 BEACH2
			PRINT_STRING_IN_STRING_NOW F_START BEACH2 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 BEACH3
			PRINT_STRING_IN_STRING_NOW F_START BEACH3 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 GOLFC
			PRINT_STRING_IN_STRING_NOW F_START GOLFC 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 STARI
			PRINT_STRING_IN_STRING_NOW F_START STARI 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 DOCKS
			PRINT_STRING_IN_STRING_NOW F_START DOCKS 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 HAVANA
			PRINT_STRING_IN_STRING_NOW F_START HAVANA 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 HAITI
			PRINT_STRING_IN_STRING_NOW F_START HAITI 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 PORNI
			PRINT_STRING_IN_STRING_NOW F_START PORNI 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 DTOWN
			PRINT_STRING_IN_STRING_NOW F_START DTOWN 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 A_PORT
			PRINT_STRING_IN_STRING_NOW F_START A_PORT 5000 1 //~g~Burning vehicle reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
	ELSE
		IF IS_CHAR_IN_ZONE onfire_ped_1 VICE_C
			PRINT_STRING_IN_STRING_NOW F_STAR1 VICE_C 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 BEACH1
			PRINT_STRING_IN_STRING_NOW F_STAR1 BEACH1 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 BEACH2
			PRINT_STRING_IN_STRING_NOW F_STAR1 BEACH2 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 BEACH3
			PRINT_STRING_IN_STRING_NOW F_STAR1 BEACH3 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 GOLFC
			PRINT_STRING_IN_STRING_NOW F_STAR1 GOLFC 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 STARI
			PRINT_STRING_IN_STRING_NOW F_STAR1 STARI 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 DOCKS
			PRINT_STRING_IN_STRING_NOW F_STAR1 DOCKS 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 HAVANA
			PRINT_STRING_IN_STRING_NOW F_STAR1 HAVANA 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 HAITI
			PRINT_STRING_IN_STRING_NOW F_STAR1 HAITI 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 PORNI
			PRINT_STRING_IN_STRING_NOW F_STAR1 PORNI 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 DTOWN
			PRINT_STRING_IN_STRING_NOW F_STAR1 DTOWN 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
		IF IS_CHAR_IN_ZONE onfire_ped_1 A_PORT
			PRINT_STRING_IN_STRING_NOW F_STAR1 A_PORT 5000 1 //~g~Burning vehicles reported in the ~a~ area. Go and extinguish the fire.
		ENDIF
	ENDIF
ENDIF

PRINT_WITH_NUMBER FIRELVL firetruck_level 3000 1//"Fire Truck Mission level ~1~"

IF firetruck_level = 1
	-- fires_needing_extinguishing
	DELETE_CHAR	onfire_ped_1
ENDIF

IF got_siren_help_before = 1
	GET_CONTROLLER_MODE controlmode
	IF controlmode = 1
		PRINT_HELP SIREN_2
	ENDIF
	IF controlmode = 2
		PRINT_HELP SIREN_3
	ENDIF
	IF controlmode = 0
	OR controlmode = 3
		PRINT_HELP SIREN_1
	ENDIF
	got_siren_help_before = 2
ENDIF

IF got_siren_help_before = 0
	GET_CONTROLLER_MODE controlmode
	IF controlmode < 3
		PRINT_HELP SPRAY_1 //Use the ~o~| ~w~button to fire the water cannon.
	ENDIF
	IF controlmode = 3
		PRINT_HELP SPRAY_4 //Use the ~o~| ~w~button to fire the water cannon.
	ENDIF

	got_siren_help_before = 1
ENDIF

IF displayed_timer = 0
	DISPLAY_ONSCREEN_TIMER fire_time_limit TIMER_DOWN
	displayed_timer = 1
ELSE
	FREEZE_ONSCREEN_TIMER FALSE
ENDIF

firetruck_level_minus_4 = firetruck_level - 4

GET_GAME_TIMER game_timer
car_health_test_timer = game_timer + 3000

/////////////////////////////////////////////////////////////////////
firetruck_mission_loop:
/////////////////////////////////////////////////////////////////////
	
	IF fail_firetruck_mission = 1
		GOTO failed
	ENDIF
	
	WAIT 0
	
	GET_GAME_TIMER game_timer
	
	GOSUB do_cancelled_checks
	IF fail_firetruck_mission = 1
		GOTO failed
	ENDIF

	onfire_car      = onfire_car_1
	onfire_car_fire = onfire_car_1_fire
	onfire_car_flag = onfire_car_1_flag
	onfire_car_blip = onfire_car_1_blip
	GOSUB do_fire_on_car_bit
	onfire_car_1_fire = onfire_car_fire
	onfire_car_1_flag = onfire_car_flag
	onfire_car_1_blip = onfire_car_blip

	IF firetruck_level > 1
		onfire_ped	    = onfire_ped_1	  
		onfire_ped_flag = onfire_ped_1_flag 
		onfire_ped_fire = onfire_ped_1_fire 
		onfire_ped_blip = onfire_ped_1_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_1_flag = onfire_ped_flag 
		onfire_ped_1_fire = onfire_ped_fire 
		onfire_ped_1_blip = onfire_ped_blip 
	ENDIF

	IF firetruck_level > 2
		onfire_ped	    = onfire_ped_2	  
		onfire_ped_flag = onfire_ped_2_flag 
		onfire_ped_fire = onfire_ped_2_fire 
		onfire_ped_blip = onfire_ped_2_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_2_flag = onfire_ped_flag 
		onfire_ped_2_fire = onfire_ped_fire 
		onfire_ped_2_blip = onfire_ped_blip 
	ENDIF
	
	IF firetruck_level > 3
		onfire_ped	    = onfire_ped_3	  
		onfire_ped_flag = onfire_ped_3_flag 
		onfire_ped_fire = onfire_ped_3_fire 
		onfire_ped_blip = onfire_ped_3_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_3_flag = onfire_ped_flag 
		onfire_ped_3_fire = onfire_ped_fire 
		onfire_ped_3_blip = onfire_ped_blip 
//		fire = fire1
//		fire_flag = fire1_flag
//		GOSUB do_fire_on_ground_bit
//		fire1_flag = fire_flag
	ENDIF
	
	IF firetruck_level > 4
		onfire_car      = onfire_car_2
		onfire_car_fire = onfire_car_2_fire
		onfire_car_flag = onfire_car_2_flag
		onfire_car_blip = onfire_car_2_blip
		GOSUB do_fire_on_car_bit
		onfire_car_2_fire = onfire_car_fire
		onfire_car_2_flag = onfire_car_flag
		onfire_car_2_blip = onfire_car_blip
	ENDIF

	IF firetruck_level > 5
		onfire_ped	    = onfire_ped_4	  
		onfire_ped_flag = onfire_ped_4_flag 
		onfire_ped_fire = onfire_ped_4_fire 
		onfire_ped_blip = onfire_ped_4_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_4_flag = onfire_ped_flag 
		onfire_ped_4_fire = onfire_ped_fire 
		onfire_ped_4_blip = onfire_ped_blip 
//		fire = fire2
//		fire_flag = fire2_flag
//		GOSUB do_fire_on_ground_bit
//		fire2_flag = fire_flag
	ENDIF
	
	IF firetruck_level > 6
		onfire_ped	    = onfire_ped_5	  
		onfire_ped_flag = onfire_ped_5_flag 
		onfire_ped_fire = onfire_ped_5_fire 
		onfire_ped_blip = onfire_ped_5_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_5_flag = onfire_ped_flag 
		onfire_ped_5_fire = onfire_ped_fire 
		onfire_ped_5_blip = onfire_ped_blip 
	ENDIF

	IF firetruck_level > 7
		onfire_ped	    = onfire_ped_6	  
		onfire_ped_flag = onfire_ped_6_flag 
		onfire_ped_fire = onfire_ped_6_fire 
		onfire_ped_blip = onfire_ped_6_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_6_flag = onfire_ped_flag 
		onfire_ped_6_fire = onfire_ped_fire 
		onfire_ped_6_blip = onfire_ped_blip 
//		fire = fire3
//		fire_flag = fire3_flag
//		GOSUB do_fire_on_ground_bit
//		fire3_flag = fire_flag
	ENDIF
	
	IF firetruck_level > 8
		onfire_car      = onfire_car_3
		onfire_car_fire = onfire_car_3_fire
		onfire_car_flag = onfire_car_3_flag
		onfire_car_blip = onfire_car_3_blip
		GOSUB do_fire_on_car_bit
		onfire_car_3_fire = onfire_car_fire
		onfire_car_3_flag = onfire_car_flag
		onfire_car_3_blip = onfire_car_blip
	ENDIF

	IF firetruck_level > 9
		onfire_ped	    = onfire_ped_7	  
		onfire_ped_flag = onfire_ped_7_flag 
		onfire_ped_fire = onfire_ped_7_fire 
		onfire_ped_blip = onfire_ped_7_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_7_flag = onfire_ped_flag 
		onfire_ped_7_fire = onfire_ped_fire 
		onfire_ped_7_blip = onfire_ped_blip 
//		fire = fire4
//		fire_flag = fire4_flag
//		GOSUB do_fire_on_ground_bit
//		fire4_flag = fire_flag
	ENDIF
	
	IF firetruck_level > 10
		onfire_ped	    = onfire_ped_8	  
		onfire_ped_flag = onfire_ped_8_flag 
		onfire_ped_fire = onfire_ped_8_fire 
		onfire_ped_blip = onfire_ped_8_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_8_flag = onfire_ped_flag 
		onfire_ped_8_fire = onfire_ped_fire 
		onfire_ped_8_blip = onfire_ped_blip 
	ENDIF

	IF firetruck_level > 11
		onfire_ped	    = onfire_ped_9	  
		onfire_ped_flag = onfire_ped_9_flag 
		onfire_ped_fire = onfire_ped_9_fire 
		onfire_ped_blip = onfire_ped_9_blip 
		GOSUB do_fire_on_ped_bit
		onfire_ped_9_flag = onfire_ped_flag 
		onfire_ped_9_fire = onfire_ped_fire 
		onfire_ped_9_blip = onfire_ped_blip 
//		fire = fire5
//		fire_flag = fire5_flag
//		GOSUB do_fire_on_ground_bit
//		fire5_flag = fire_flag
	ENDIF
	
//	IF firetruck_level > 12
//		IF fires_extinguished_this_round = 12
//			GOTO passed
//		ENDIF
//	ELSE
		IF fires_extinguished_this_round = fires_needing_extinguishing//firetruck_level
			GOTO passed
		ENDIF
//	ENDIF
	
GOTO firetruck_mission_loop



/////////////////////////////////////////////////////////////////////
do_cancelled_checks:
/////////////////////////////////////////////////////////////////////
IF displayed_timer = 1
	IF fire_time_limit < 1
		PRINT_NOW F_FAIL2 5000 1
		fail_firetruck_mission = 1
		RETURN
	ENDIF
ENDIF
	
IF NOT IS_PLAYER_IN_MODEL player1 FIRETRUK
	PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
	fail_firetruck_mission = 1
	RETURN
ENDIF

GET_CONTROLLER_MODE controlmode

IF NOT controlmode = 3
	IF IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
		mission_end_button_ft = 1
	ENDIF
ELSE
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		mission_end_button_ft = 1
	ENDIF
ENDIF

IF mission_end_button_ft = 1
	IF NOT controlmode = 3
		IF NOT IS_BUTTON_PRESSED PAD1 RIGHTSHOCK
			PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
			fail_firetruck_mission = 1
			RETURN
		ENDIF
	ELSE
		IF NOT IS_BUTTON_PRESSED PAD1 SQUARE
			PRINT_NOW F_CANC 3000 1//"Fire truck mission cancelled!"
			fail_firetruck_mission = 1
			RETURN
		ENDIF
	ENDIF
ENDIF
RETURN


/////////////////////////////////////////////////////////////////////
do_fire_on_car_bit:
/////////////////////////////////////////////////////////////////////
IF NOT onfire_car_flag = 10
	IF NOT IS_CAR_DEAD onfire_car
		IF NOT IS_SCRIPT_FIRE_EXTINGUISHED onfire_car_fire
			GET_CAR_HEALTH onfire_car onfire_car_health
			
			IF car_health_test_timer < game_timer
				IF onfire_car_health < 700
					EXPLODE_CAR onfire_car
					PRINT_NOW F_FAIL2 5000 1
					fail_firetruck_mission = 1
					RETURN
				ENDIF
			ELSE
				SET_CAR_HEALTH onfire_car 1000
			ENDIF

			IF onfire_car_flag = 0
				IF fires_extinguished_this_round = firetruck_level_minus_4
					CAR_WANDER_RANDOMLY	onfire_car
					SET_CAR_CRUISE_SPEED onfire_car 20.0
					SET_CAR_DRIVING_STYLE onfire_car 2
					SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car TRUE
					onfire_car_flag = 1
				ENDIF
			ENDIF
		ELSE
			IF NOT onfire_car_flag = 10
				REMOVE_BLIP onfire_car_blip
				SET_ALL_OCCUPANTS_OF_CAR_LEAVE_CAR onfire_car
				REGISTER_FIRE_EXTINGUISHED
				IF displayed_counter = 0
					DISPLAY_ONSCREEN_COUNTER_WITH_STRING fires_extinguished	COUNTER_DISPLAY_NUMBER F_EXTIN
					displayed_counter = 1
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				onfire_car_flag = 10
				++ fires_extinguished
				++ fires_extinguished_this_round
			ENDIF
		ENDIF
	ELSE
		IF IS_CAR_IN_WATER onfire_car
			IF NOT onfire_car_flag = 10
				REMOVE_BLIP onfire_car_blip
				SET_ALL_OCCUPANTS_OF_CAR_LEAVE_CAR onfire_car
				REGISTER_FIRE_EXTINGUISHED
				IF displayed_counter = 0
					DISPLAY_ONSCREEN_COUNTER_WITH_STRING fires_extinguished	COUNTER_DISPLAY_NUMBER F_EXTIN
					displayed_counter = 1
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				onfire_car_flag = 10
				++ fires_extinguished
				++ fires_extinguished_this_round
			ENDIF
		ELSE
			PRINT_NOW F_FAIL2 5000 1
			fail_firetruck_mission = 1
			RETURN
		ENDIF
	ENDIF
ENDIF
RETURN


/////////////////////////////////////////////////////////////////////
do_fire_on_ped_bit:		
/////////////////////////////////////////////////////////////////////
IF onfire_ped_flag < 2
	IF NOT IS_CHAR_DEAD	onfire_ped
		IF onfire_ped_flag = 0
			IF NOT IS_CHAR_IN_ANY_CAR onfire_ped
				START_CHAR_FIRE onfire_ped onfire_ped_fire
				SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_ALWAYS	onfire_ped player1
				ADD_BLIP_FOR_CHAR onfire_ped onfire_ped_blip
				CHANGE_BLIP_DISPLAY onfire_ped_blip BLIP_ONLY
				onfire_ped_flag = 1
			ENDIF
		ENDIF
		IF onfire_ped_flag = 1
			IF IS_SCRIPT_FIRE_EXTINGUISHED onfire_ped_fire
				REMOVE_BLIP	onfire_ped_blip
				REGISTER_FIRE_EXTINGUISHED
				IF displayed_counter = 0
					DISPLAY_ONSCREEN_COUNTER_WITH_STRING fires_extinguished	COUNTER_DISPLAY_NUMBER F_EXTIN
					displayed_counter = 1
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				++ fires_extinguished
				++ fires_extinguished_this_round
				onfire_ped_flag = 2
			ENDIF
		ENDIF
	ELSE
		IF IS_CHAR_IN_WATER	onfire_ped
			IF onfire_ped_flag = 1
				REMOVE_SCRIPT_FIRE onfire_ped_fire
				REMOVE_BLIP	onfire_ped_blip
				REGISTER_FIRE_EXTINGUISHED
				IF displayed_counter = 0
					DISPLAY_ONSCREEN_COUNTER_WITH_STRING fires_extinguished	COUNTER_DISPLAY_NUMBER F_EXTIN
					displayed_counter = 1
				ENDIF
				ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
				++ fires_extinguished
				++ fires_extinguished_this_round
				onfire_ped_flag = 2
			ELSE
				PRINT_NOW F_FAIL2 5000 1
				fail_firetruck_mission = 1
				RETURN
			ENDIF
		ELSE
			PRINT_NOW F_FAIL2 5000 1
			fail_firetruck_mission = 1
			RETURN
		ENDIF
	ENDIF
ENDIF
RETURN


/////////////////////////////////////////////////////////////////////////
//do_fire_on_ground_bit:
/////////////////////////////////////////////////////////////////////////
//IF IS_SCRIPT_FIRE_EXTINGUISHED fire
//	IF fire_flag = 0
//		IF IS_SCRIPT_FIRE_EXTINGUISHED fire
//			REGISTER_FIRE_EXTINGUISHED
//			IF displayed_counter = 0
//				DISPLAY_ONSCREEN_COUNTER_WITH_STRING fires_extinguished	COUNTER_DISPLAY_NUMBER F_EXTIN
//				displayed_counter = 1
//			ENDIF
//			ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
//			++ fires_extinguished
//			++ fires_extinguished_this_round
//			fire_flag = 1
//		ENDIF
//	ENDIF
//ENDIF
//RETURN



/////////////////////////////////////////////////////////////////////
passed:
/////////////////////////////////////////////////////////////////////

FREEZE_ONSCREEN_TIMER TRUE

PRINT_BIG F_PASS1 5000 5
score_ft = firetruck_level * firetruck_level
score_ft *= 50
total_score += score_ft
PRINT_WITH_NUMBER_BIG REWARD score_ft 6000 6
ADD_SCORE player1 score_ft

IF firetruck_level > 11
	IF done_firetruck_progress = 0
		MAKE_PLAYER_FIRE_PROOF player1 TRUE
		PRINT_HELP FIREPRO
		PLAYER_MADE_PROGRESS 1
		REGISTER_ODDJOB_MISSION_PASSED
		done_firetruck_progress = 1
	ENDIF
ENDIF

REGISTER_FIRE_LEVEL	firetruck_level

++ firetruck_level

REMOVE_ALL_SCRIPT_FIRES

REMOVE_BLIP	onfire_car_blip
REMOVE_BLIP	onfire_car_1_blip
REMOVE_BLIP	onfire_car_2_blip
REMOVE_BLIP	onfire_car_3_blip
REMOVE_BLIP	onfire_ped_blip
REMOVE_BLIP	onfire_ped_1_blip
REMOVE_BLIP	onfire_ped_2_blip
REMOVE_BLIP	onfire_ped_3_blip
REMOVE_BLIP	onfire_ped_4_blip
REMOVE_BLIP	onfire_ped_5_blip
REMOVE_BLIP	onfire_ped_6_blip
REMOVE_BLIP	onfire_ped_7_blip
REMOVE_BLIP	onfire_ped_8_blip
REMOVE_BLIP	onfire_ped_9_blip

IF IS_PLAYER_IN_ANY_CAR	player1
	STORE_CAR_PLAYER_IS_IN player1 players_car
	GET_CAR_HEALTH players_car players_car_health
	players_car_health += 150
	SET_CAR_HEALTH players_car players_car_health
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED onfire_car_1
IF NOT IS_CAR_DEAD onfire_car_1
	SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car_1 FALSE
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED onfire_car_2
IF NOT IS_CAR_DEAD onfire_car_2
	SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car_2 FALSE
ENDIF

MARK_CAR_AS_NO_LONGER_NEEDED onfire_car_3
IF NOT IS_CAR_DEAD onfire_car_3
	SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car_3 FALSE
ENDIF

//DELETE_CHAR onfire_ped_1//DEBUG!!!!
//DELETE_CHAR onfire_ped_2//DEBUG!!!!
//DELETE_CHAR onfire_ped_3//DEBUG!!!!
//DELETE_CHAR onfire_ped_4//DEBUG!!!!
//DELETE_CHAR onfire_ped_5//DEBUG!!!!
//DELETE_CHAR onfire_ped_6//DEBUG!!!!
//DELETE_CHAR onfire_ped_7//DEBUG!!!!
//DELETE_CHAR onfire_ped_8//DEBUG!!!!
//DELETE_CHAR onfire_ped_9//DEBUG!!!!

MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_1
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_2
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_3
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_4
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_5
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_6
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_7
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_8
MARK_CHAR_AS_NO_LONGER_NEEDED onfire_ped_9

MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model

GOTO fire_generation_start


/////////////////////////////////////////////////////////////////////
failed:
/////////////////////////////////////////////////////////////////////

CLEAR_ONSCREEN_TIMER fire_time_limit
CLEAR_ONSCREEN_COUNTER fires_extinguished
PRINT_BIG F_FAIL1 5000 5
PRINT_WITH_NUMBER_BIG TSCORE total_score 6000 6
REMOVE_ALL_SCRIPT_FIRES
SET_WANTED_MULTIPLIER 1.0

REMOVE_BLIP	onfire_car_blip
REMOVE_BLIP	onfire_car_1_blip
REMOVE_BLIP	onfire_car_2_blip
REMOVE_BLIP	onfire_car_3_blip
REMOVE_BLIP	onfire_ped_blip
REMOVE_BLIP	onfire_ped_1_blip
REMOVE_BLIP	onfire_ped_2_blip
REMOVE_BLIP	onfire_ped_3_blip
REMOVE_BLIP	onfire_ped_4_blip
REMOVE_BLIP	onfire_ped_5_blip
REMOVE_BLIP	onfire_ped_6_blip
REMOVE_BLIP	onfire_ped_7_blip
REMOVE_BLIP	onfire_ped_8_blip
REMOVE_BLIP	onfire_ped_9_blip

IF NOT IS_CHAR_DEAD	onfire_ped_1  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_1 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_1
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_2  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_2 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_2
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_3  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_3 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_3
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_4  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_4 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_4
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_5  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_5 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_5
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_6  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_6 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_6
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_7  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_7 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_7
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_8  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_8 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_8
ENDIF
IF NOT IS_CHAR_DEAD	onfire_ped_9  
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER onfire_ped_9 FALSE
	EXPLODE_CHAR_HEAD onfire_ped_9
ENDIF

IF NOT IS_CAR_DEAD onfire_car_1
	SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car_1 FALSE
	EXPLODE_CAR	onfire_car_1
ENDIF
IF NOT IS_CAR_DEAD onfire_car_2
	SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car_2 FALSE
	EXPLODE_CAR	onfire_car_2
ENDIF
IF NOT IS_CAR_DEAD onfire_car_3
	SET_CAR_ONLY_DAMAGED_BY_PLAYER onfire_car_3 FALSE
	EXPLODE_CAR	onfire_car_3
ENDIF

MARK_MODEL_AS_NO_LONGER_NEEDED random_car_model

GET_GAME_TIMER timer_mobile_start

flag_player_on_mission = 0
flag_player_on_fire_mission	= 0
MISSION_HAS_FINISHED
RETURN






}