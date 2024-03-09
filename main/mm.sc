MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************Miami Massacre******r***************************
// *****************************************Courtesy of Demolition Derby********************
// *****************************************************************************************
// *****************************************************************************************
SCRIPT_NAME mm
// Mission start stuff
GOSUB mission_start_mm
IF HAS_DEATHARREST_BEEN_EXECUTED 
	GOSUB mission_failed_mm
ENDIF
GOSUB mission_cleanup_mm
MISSION_END
{
// Variables for mission
//people, cars and objects
VAR_INT mm_car1 
VAR_INT mm_car2 
VAR_INT mm_car3
VAR_INT mm_car4
VAR_INT mm_car5
VAR_INT mm_car6
VAR_INT mm_car7
VAR_INT mm_car8
VAR_INT mm_car9
VAR_INT mm_car10
VAR_INT mm_car11
VAR_INT mm_car12
VAR_INT mm_car13
VAR_INT mm_car14
VAR_INT mm_car15
VAR_INT mm_car16
VAR_INT mm_driver1
VAR_INT mm_driver2
VAR_INT mm_driver3
VAR_INT mm_driver4
VAR_INT mm_driver5
VAR_INT mm_driver6
VAR_INT mm_driver7
VAR_INT mm_driver8
VAR_INT mm_driver9
VAR_INT mm_driver10
VAR_INT mm_driver11
VAR_INT mm_driver12
VAR_INT mm_driver13
VAR_INT mm_driver14
VAR_INT mm_driver15
VAR_INT mm_driver16
VAR_INT mmplayer_car

//flags
VAR_INT random_garage
VAR_INT cars_created
VAR_INT mm_cars_killed
VAR_INT mm_countdown
VAR_INT mm_attempt
VAR_INT mm_best_time
VAR_INT mm_longest_time
VAR_INT mm_car_health
VAR_INT mm_car_health_divided
VAR_INT where_is_player
VAR_INT zero_where_player
VAR_INT zero1
VAR_INT zero2
VAR_INT zero3
VAR_INT zero4
VAR_INT time_to_beat
VAR_INT letting_cars_do_stuff
VAR_INT mm_audio_flag
VAR_INT mm_sound1
VAR_INT mm_sound_playing
VAR_INT mm_cuntie
VAR_INT mm_adding_health


//coordinates
VAR_FLOAT random_car_node_x
VAR_FLOAT random_car_node_y
VAR_FLOAT random_car_node_z
VAR_FLOAT mm_car_heading

VAR_FLOAT rnd_float1x
VAR_FLOAT rnd_float1y
VAR_FLOAT rnd_float2x
VAR_FLOAT rnd_float2y
VAR_FLOAT rnd_float3x
VAR_FLOAT rnd_float3y
VAR_FLOAT rnd_float4x
VAR_FLOAT rnd_float4y


VAR_FLOAT plyr_rndx
VAR_FLOAT plyr_rndy
VAR_FLOAT plyr_rndz

//blips
VAR_INT plyr_checkpoint_blip



// ****************************************Mission Start************************************
mission_start_mm:
CLEAR_THIS_PRINT M_FAIL
flag_player_on_mission = 1
IF mm_mission_passed_once = 0
	REGISTER_MISSION_GIVEN
ENDIF
SET_TIME_OF_DAY 10 0
//forcing weather to be nice
FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY
SET_PLAYER_IS_IN_STADIUM TRUE
SET_FREE_HEALTH_CARE player1 TRUE
WAIT 0
LOAD_MISSION_TEXT MM
// *****************************************Set Flags/variables************************************
random_garage = 0
cars_created = 16
mm_cars_killed = 0

IF mm_attempt = 0
	mm_best_time = 1
	mm_longest_time = 60
	time_to_beat = 60000 
ENDIF
mm_countdown = 30000
mm_car_health = 0
mm_car_health_divided = 0
where_is_player = 0
zero_where_player = 0
zero1 = 0
zero2 = 0
zero3 = 0
zero4 = 0
letting_cars_do_stuff = 0

mm_audio_flag = 0
mm_sound1 = 0
mm_sound_playing = 0
mm_cuntie = 0
mm_adding_health = 0

random_car_node_x = 0.0
random_car_node_y = 0.0
random_car_node_z = 0.0
mm_car_heading = 0.0
player_x = 0.0
player_y = 0.0
player_z = 0.0

plyr_rndx = 0.0
plyr_rndy = 0.0
plyr_rndz = 0.0

GOTO mm_fool_compiler // FIXMIAMI: remove flag_player_on_mission = 0 check
	ADD_BLIP_FOR_COORD plyr_rndx plyr_rndy plyr_rndz plyr_checkpoint_blip
mm_fool_compiler: // FIXMIAMI: remove flag_player_on_mission = 0 check
//------------------REQUEST_MODELS ------------------------------
REQUEST_MODEL bloodrb
REQUEST_MODEL bloodra
REQUEST_MODEL WMYCR

WHILE NOT HAS_MODEL_LOADED bloodrb
OR NOT HAS_MODEL_LOADED bloodra
OR NOT HAS_MODEL_LOADED WMYCR
	WAIT 0
ENDWHILE

OVERRIDE_NEXT_RESTART -1102.4 1331.2 19.0 271.2

//getting player into destruction derby
SET_PLAYER_CONTROL player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 ON
CLEAR_WANTED_LEVEL player1

SET_AREA_VISIBLE VIS_BLOOD
SWITCH_RUBBISH OFF
SET_CAR_DENSITY_MULTIPLIER 0.0 
SET_PED_DENSITY_MULTIPLIER 0.0
SHUT_PLAYER_UP player1 TRUE

LOAD_SCENE -1379.3 1000.0 251.5

//LOAD_SCENE -1280.960 994.86 261.8
IF IS_PLAYER_IN_ANY_CAR player1 
	WARP_PLAYER_FROM_CAR_TO_COORD player1 -1280.960 994.86 261.8
ELSE
	SET_PLAYER_COORDINATES player1 -1280.960 994.86 261.8
ENDIF

CREATE_CAR bloodra -1280.960 994.86 261.8 mmplayer_car
LOCK_CAR_DOORS mmplayer_car CARLOCK_LOCKED_PLAYER_INSIDE
WARP_PLAYER_INTO_CAR player1 mmplayer_car 
SET_CAR_STRONG mmplayer_car TRUE
SET_CAR_HEADING mmplayer_car 90.0
SET_PLAYER_HEADING player1 80.0
SET_EXTRA_COLOURS 10 FALSE
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mmplayer_car TRUE
SET_CAR_HEALTH mmplayer_car 1249  

random_car_node_x = -1285.77
random_car_node_y = 1014.54
random_car_node_z = 263.0
mm_car_heading = 104.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car1
SET_CAR_HEADING mm_car1 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car1 255
CREATE_CHAR_INSIDE_CAR mm_car1 PEDTYPE_CIVMALE WMYCR mm_driver1
SHUT_CHAR_UP mm_driver1 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car1 TRUE
ADD_STUCK_CAR_CHECK mm_car1 1.5 4000
SET_CAR_DRIVING_STYLE mm_car1 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car1 TRUE 
//SET_CAR_HEALTH mm_car1 750 

random_car_node_x = -1299.50
random_car_node_y = 1030.74
random_car_node_z = 263.0
mm_car_heading = 132.6 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car2
SET_CAR_HEADING mm_car2 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car2 255
CREATE_CHAR_INSIDE_CAR mm_car2 PEDTYPE_CIVMALE WMYCR mm_driver2
SHUT_CHAR_UP mm_driver2 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car2 TRUE
ADD_STUCK_CAR_CHECK mm_car2 1.5 4000
SET_CAR_DRIVING_STYLE mm_car2 DRIVINGMODE_PLOUGHTHROUGH
SET_CAR_MISSION mm_car2 MISSION_RAMPLAYER_FARAWAY
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car2 TRUE 
//SET_CAR_HEALTH mm_car2 750 

random_car_node_x = -1319.30
random_car_node_y = 1042.82
random_car_node_z = 263.0
mm_car_heading = 135.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car3
SET_CAR_HEADING mm_car3 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car3 255
CREATE_CHAR_INSIDE_CAR mm_car3 PEDTYPE_CIVMALE WMYCR mm_driver3
SHUT_CHAR_UP mm_driver3 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car3 TRUE
ADD_STUCK_CAR_CHECK mm_car3 1.5 4000
SET_CAR_DRIVING_STYLE mm_car3 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car3 TRUE 
//SET_CAR_HEALTH mm_car3 750 

random_car_node_x = -1349.33
random_car_node_y = 1054.47
random_car_node_z = 263.0
mm_car_heading = 155.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car4
SET_CAR_HEADING mm_car4 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car4 255
CREATE_CHAR_INSIDE_CAR mm_car4 PEDTYPE_CIVMALE WMYCR mm_driver4
SHUT_CHAR_UP mm_driver4 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car4 TRUE
ADD_STUCK_CAR_CHECK mm_car4 1.5 4000
SET_CAR_DRIVING_STYLE mm_car4 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car4 TRUE 
//SET_CAR_HEALTH mm_car4 750 

random_car_node_x = -1384.33
random_car_node_y = 1058.55
random_car_node_z = 263.0
mm_car_heading = 173.2 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car5
SET_CAR_HEADING mm_car5 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car5 255
CREATE_CHAR_INSIDE_CAR mm_car5 PEDTYPE_CIVMALE WMYCR mm_driver5
SHUT_CHAR_UP mm_driver5 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car5 TRUE
ADD_STUCK_CAR_CHECK mm_car5 1.5 4000
SET_CAR_DRIVING_STYLE mm_car5 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car5 TRUE 
//SET_CAR_HEALTH mm_car5 750 

random_car_node_x = -1293.77   //guy next to player
random_car_node_y = 958.96
random_car_node_z = 263.0
mm_car_heading = 60.5 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car6
SET_CAR_HEADING mm_car6 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car6 255
CREATE_CHAR_INSIDE_CAR mm_car6 PEDTYPE_CIVMALE WMYCR mm_driver6
SHUT_CHAR_UP mm_driver6 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car6 TRUE
ADD_STUCK_CAR_CHECK mm_car6 1.5 4000
SET_CAR_DRIVING_STYLE mm_car6 DRIVINGMODE_PLOUGHTHROUGH
SET_CAR_MISSION mm_car6 MISSION_RAMPLAYER_FARAWAY
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car6 TRUE 
//SET_CAR_HEALTH mm_car6 750 

random_car_node_x = -1418.77
random_car_node_y = 1057.54
random_car_node_z = 263.0
mm_car_heading = 180.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car7
SET_CAR_HEADING mm_car7 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car7 255
CREATE_CHAR_INSIDE_CAR mm_car7 PEDTYPE_CIVMALE WMYCR mm_driver7
SHUT_CHAR_UP mm_driver7 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car7 TRUE
ADD_STUCK_CAR_CHECK mm_car7 1.5 4000
SET_CAR_DRIVING_STYLE mm_car7 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car7 TRUE 
//SET_CAR_HEALTH mm_car7 750 

random_car_node_x = -1460.3
random_car_node_y = 1050.3
random_car_node_z = 263.0
mm_car_heading = 242.9 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car8
SET_CAR_HEADING mm_car8 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car8 255
CREATE_CHAR_INSIDE_CAR mm_car8 PEDTYPE_CIVMALE WMYCR mm_driver8
SHUT_CHAR_UP mm_driver8 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car8 TRUE
ADD_STUCK_CAR_CHECK mm_car8 1.5 4000
SET_CAR_DRIVING_STYLE mm_car8 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car8 TRUE 
//SET_CAR_HEALTH mm_car8 750 

random_car_node_x = -1499.77
random_car_node_y = 1029.54	
random_car_node_z = 263.0
mm_car_heading = 242.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car9
SET_CAR_HEADING mm_car9 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car9 255
CREATE_CHAR_INSIDE_CAR mm_car9 PEDTYPE_CIVMALE WMYCR mm_driver9
SHUT_CHAR_UP mm_driver9 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car9 TRUE
ADD_STUCK_CAR_CHECK mm_car9 1.5 4000
SET_CAR_DRIVING_STYLE mm_car9 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car9 TRUE 
//SET_CAR_HEALTH mm_car9 750 

random_car_node_x = -1513.77
random_car_node_y = 986.54
random_car_node_z = 263.0
mm_car_heading = 271.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car10
SET_CAR_HEADING mm_car10 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car10 255
CREATE_CHAR_INSIDE_CAR mm_car10 PEDTYPE_CIVMALE WMYCR mm_driver10
SHUT_CHAR_UP mm_driver10 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car10 TRUE
ADD_STUCK_CAR_CHECK mm_car10 1.5 4000
SET_CAR_DRIVING_STYLE mm_car10 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car10 TRUE 
//SET_CAR_HEALTH mm_car10 750 

random_car_node_x = -1496.77
random_car_node_y = 959.54
random_car_node_z = 263.0
mm_car_heading = 293.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car11
SET_CAR_HEADING mm_car11 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car11 255
CREATE_CHAR_INSIDE_CAR mm_car11 PEDTYPE_CIVMALE WMYCR mm_driver11
SHUT_CHAR_UP mm_driver11 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car11 TRUE
ADD_STUCK_CAR_CHECK mm_car11 1.5 4000
SET_CAR_DRIVING_STYLE mm_car11 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car11 TRUE 
//SET_CAR_HEALTH mm_car11 750 

random_car_node_x = -1461.84
random_car_node_y = 938.32
random_car_node_z = 261.0
mm_car_heading = 345.6 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car12
SET_CAR_HEADING mm_car12 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car12 255
CREATE_CHAR_INSIDE_CAR mm_car12 PEDTYPE_CIVMALE WMYCR mm_driver12
SHUT_CHAR_UP mm_driver12 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car12 TRUE
ADD_STUCK_CAR_CHECK mm_car12 1.5 4000
SET_CAR_DRIVING_STYLE mm_car12 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car12 TRUE 
//SET_CAR_HEALTH mm_car12 750 

random_car_node_x = -1424.36
random_car_node_y = 931.29
random_car_node_z = 261.0
mm_car_heading = 0.0 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car13
SET_CAR_HEADING mm_car13 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car13 255
CREATE_CHAR_INSIDE_CAR mm_car13 PEDTYPE_CIVMALE WMYCR mm_driver13
SHUT_CHAR_UP mm_driver13 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car13 TRUE
ADD_STUCK_CAR_CHECK mm_car13 1.5 4000
SET_CAR_DRIVING_STYLE mm_car13 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car13 TRUE 
//SET_CAR_HEALTH mm_car13 750 

random_car_node_x = -1363.77
random_car_node_y = 932.44
random_car_node_z = 261.0
mm_car_heading = 17.85 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car14
SET_CAR_HEADING mm_car14 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car14 255
CREATE_CHAR_INSIDE_CAR mm_car14 PEDTYPE_CIVMALE WMYCR mm_driver14
SHUT_CHAR_UP mm_driver14 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car14 TRUE
ADD_STUCK_CAR_CHECK mm_car14 1.5 4000
SET_CAR_DRIVING_STYLE mm_car14 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car14 TRUE 
//SET_CAR_HEALTH mm_car14 750 

random_car_node_x = -1332.77
random_car_node_y = 940.30
random_car_node_z = 263.0
mm_car_heading = 39.98 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car15
SET_CAR_HEADING mm_car15 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car15 255
CREATE_CHAR_INSIDE_CAR mm_car15 PEDTYPE_CIVMALE WMYCR mm_driver15
SHUT_CHAR_UP mm_driver15 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car15 TRUE
ADD_STUCK_CAR_CHECK mm_car15 1.5 4000
SET_CAR_DRIVING_STYLE mm_car15 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car15 TRUE 
//SET_CAR_HEALTH mm_car15 750 

random_car_node_x = -1443.29
random_car_node_y = 933.86
random_car_node_z = 261.0
mm_car_heading = 351.4 
CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car16
SET_CAR_HEADING mm_car16 mm_car_heading 
SET_CAR_STRAIGHT_LINE_DISTANCE mm_car16 255
CREATE_CHAR_INSIDE_CAR mm_car16 PEDTYPE_CIVMALE WMYCR mm_driver16
SHUT_CHAR_UP mm_driver16 TRUE 
//SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car16 TRUE
ADD_STUCK_CAR_CHECK mm_car16 1.5 4000
SET_CAR_DRIVING_STYLE mm_car16 DRIVINGMODE_PLOUGHTHROUGH
SET_UPSIDEDOWN_CAR_NOT_DAMAGED mm_car16 TRUE 
//SET_CAR_HEALTH mm_car16 750 

SET_CAR_CRUISE_SPEED mm_car1 0.0
SET_CAR_CRUISE_SPEED mm_car2 0.0
SET_CAR_CRUISE_SPEED mm_car3 0.0
SET_CAR_CRUISE_SPEED mm_car4 0.0
SET_CAR_CRUISE_SPEED mm_car5 0.0
SET_CAR_CRUISE_SPEED mm_car6 0.0
SET_CAR_CRUISE_SPEED mm_car7 0.0
SET_CAR_CRUISE_SPEED mm_car8 0.0
SET_CAR_CRUISE_SPEED mm_car9 0.0
SET_CAR_CRUISE_SPEED mm_car10 0.0
SET_CAR_CRUISE_SPEED mm_car11 0.0
SET_CAR_CRUISE_SPEED mm_car12 0.0
SET_CAR_CRUISE_SPEED mm_car13 0.0
SET_CAR_CRUISE_SPEED mm_car14 0.0
SET_CAR_CRUISE_SPEED mm_car15 0.0
SET_CAR_CRUISE_SPEED mm_car16 0.0

// ******************************************START OF Demolition Derby*******************************************
SWITCH_WIDESCREEN ON

SET_FIXED_CAMERA_POSITION -1266.5 1042.8 278.3 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1339.9 1009.8 252.0 JUMP_CUT

SET_FADING_COLOUR 0 0 0
WAIT 500
DO_FADE 1500 FADE_IN
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE
IF IS_PLAYER_PLAYING player1
	SET_EVERYONE_IGNORE_PLAYER player1 OFF
ENDIF
timera = 0

PRINT_NOW ( BLOD_01 ) 5000 1 //Drive through the checkpoints to increase your overall time.

WHILE timera < 5000
WAIT 0 	
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO skip_mm_initial_cutscene
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
timera = 0

SET_FIXED_CAMERA_POSITION -1468.7 948.8 262.9 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1459.5 942.2 261.6 JUMP_CUT

PRINT_NOW ( BLOD_02 ) 5000 1 //You will lose if your overall time reaches zero.

WHILE timera < 5000
WAIT 0 	
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO skip_mm_initial_cutscene
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
timera = 0

SET_FIXED_CAMERA_POSITION -1262.7 997.2 266.8 0.0 0.0 0.0 
POINT_CAMERA_AT_POINT -1277.6 996.0 263.6 JUMP_CUT

PRINT_NOW ( BLOD_03 ) 5000 1 //Get your overall time above the Target Time to win!

WHILE timera < 5000
WAIT 0 	
	IF IS_BUTTON_PRESSED PAD1 CROSS
		IF button_pressed = 1
			button_pressed = 0
			GOTO skip_mm_initial_cutscene
		ENDIF
	ELSE
		IF button_pressed = 0
			button_pressed = 1
		ENDIF
	ENDIF
ENDWHILE
timera = 0

skip_mm_initial_cutscene:
CLEAR_PRINTS
RESTORE_CAMERA_JUMPCUT
SET_CAMERA_BEHIND_PLAYER
SWITCH_WIDESCREEN OFF
// ******************************************END OF PLAYER GETTING INTO BOAT*********************************************


PRINT_BIG ( RACE2 ) 1100 4 //"THREE"
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_3
WAIT 1000
PRINT_BIG ( RACE3 ) 1100 4 //"TWO"
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_2

WAIT 1000
PRINT_BIG ( RACE4 ) 1100 4 //"ONE"
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_1

WAIT 1000
PRINT_BIG ( RACE5 ) 800 4  //"GO!"
ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_RACE_START_GO

WAIT 800

CLEAR_PRINTS
SET_PLAYER_CONTROL player1 ON


IF NOT IS_CAR_DEAD mm_car1
	SET_CAR_CRUISE_SPEED mm_car1 100.0
	SET_CAR_TEMP_ACTION mm_car1 TEMPACT_GOFORWARD 5000
	IF NOT IS_CAR_DEAD mm_car2 
		SET_CAR_RAM_CAR mm_car1 mm_car2 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car2 
	SET_CAR_CRUISE_SPEED mm_car2 100.0
	SET_CAR_TEMP_ACTION mm_car2 TEMPACT_GOFORWARD 5000  
	SET_CAR_MISSION mm_car2 MISSION_RAMPLAYER_FARAWAY
ENDIF
IF NOT IS_CAR_DEAD mm_car3 
	SET_CAR_CRUISE_SPEED mm_car3 100.0
	SET_CAR_TEMP_ACTION mm_car3 TEMPACT_GOFORWARD 5000  
ENDIF
IF NOT IS_CAR_DEAD mm_car4 
	SET_CAR_CRUISE_SPEED mm_car4 100.0
	SET_CAR_TEMP_ACTION mm_car4 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car5 
		SET_CAR_RAM_CAR mm_car4 mm_car5 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car5 
	SET_CAR_CRUISE_SPEED mm_car5 100.0
	SET_CAR_TEMP_ACTION mm_car5 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car6 
		SET_CAR_RAM_CAR mm_car5 mm_car6 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car6 
	SET_CAR_CRUISE_SPEED mm_car6 100.0
	SET_CAR_TEMP_ACTION mm_car6 TEMPACT_GOFORWARD 5000  
	SET_CAR_MISSION mm_car6 MISSION_RAMPLAYER_FARAWAY
ENDIF
IF NOT IS_CAR_DEAD mm_car7 
	SET_CAR_CRUISE_SPEED mm_car7 100.0
	SET_CAR_TEMP_ACTION mm_car7 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car8 
		SET_CAR_RAM_CAR mm_car7 mm_car8 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car8 
	SET_CAR_CRUISE_SPEED mm_car8 100.0
	SET_CAR_TEMP_ACTION mm_car8 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car9 
		SET_CAR_RAM_CAR mm_car8 mm_car9 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car9 
	SET_CAR_CRUISE_SPEED mm_car9 100.0
	SET_CAR_TEMP_ACTION mm_car9 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car10 
		SET_CAR_RAM_CAR mm_car9 mm_car10 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car10 
	SET_CAR_CRUISE_SPEED mm_car10 100.0
	SET_CAR_TEMP_ACTION mm_car10 TEMPACT_GOFORWARD 5000  
ENDIF
IF NOT IS_CAR_DEAD mm_car11 
	SET_CAR_CRUISE_SPEED mm_car11 100.0
	SET_CAR_TEMP_ACTION mm_car11 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car12 
		SET_CAR_RAM_CAR mm_car11 mm_car12 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car12 
	SET_CAR_CRUISE_SPEED mm_car12 100.0
	SET_CAR_TEMP_ACTION mm_car12 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car13 
		SET_CAR_RAM_CAR mm_car12 mm_car13 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car13 
	SET_CAR_CRUISE_SPEED mm_car13 100.0
	SET_CAR_TEMP_ACTION mm_car13 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car14 
		SET_CAR_RAM_CAR mm_car13 mm_car14 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car14 
	SET_CAR_CRUISE_SPEED mm_car14 100.0
	SET_CAR_TEMP_ACTION mm_car14 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car15 
		SET_CAR_RAM_CAR mm_car14 mm_car15 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car15 
	SET_CAR_CRUISE_SPEED mm_car15 100.0
	SET_CAR_TEMP_ACTION mm_car15 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car16 
		SET_CAR_RAM_CAR mm_car15 mm_car16 
	ENDIF  
ENDIF
IF NOT IS_CAR_DEAD mm_car16 
	SET_CAR_CRUISE_SPEED mm_car16 100.0
	SET_CAR_TEMP_ACTION mm_car16 TEMPACT_GOFORWARD 5000  
	IF NOT IS_CAR_DEAD mm_car1 
		SET_CAR_RAM_CAR mm_car16 mm_car1 
	ENDIF  
ENDIF

DISPLAY_ONSCREEN_TIMER mm_countdown TIMER_DOWN
//DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING time_to_beat/*mm_cars_killed*/ COUNTER_DISPLAY_NUMBER 2 ( BLOD_08 )
DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING mm_car_health_divided COUNTER_DISPLAY_BAR 1 ( BLOD_04 )

GENERATE_RANDOM_FLOAT_IN_RANGE -1530.0 -1384.0 rnd_float1x
GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 923.0 rnd_float1y

GENERATE_RANDOM_FLOAT_IN_RANGE -1530.0 -1384.0 rnd_float2x
GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 1056.0 rnd_float2y

GENERATE_RANDOM_FLOAT_IN_RANGE -1265.0 -1384.0 rnd_float3x
GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 923.0 rnd_float3y

GENERATE_RANDOM_FLOAT_IN_RANGE -1265.0 -1384.0 rnd_float4x
GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 1056.0 rnd_float4y


GOSUB cunty_hoarz

//starting the fight


TimerA = 0
TIMERB = 0

WHILE mm_countdown > 0

	WAIT 0

	IF mm_attempt = 0					  
		PRINT_WITH_NUMBER ( BLOD_05 ) mm_best_time time_to_beat 1 //Target Time 
	ELSE
		PRINT_WITH_NUMBER ( BLOD_06 ) mm_best_time time_to_beat 1 //Target Time 
	ENDIF 

	//player winning 
	IF mm_countdown > time_to_beat
		GOTO mission_passed_mm
	ENDIF

	
	//playing sound
	IF mm_sound_playing = 1
		GOSUB mm_sound
	ENDIF
			 
	DRAW_CORONA plyr_rndx plyr_rndy plyr_rndz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 plyr_rndx plyr_rndy plyr_rndz 7.0 7.0 7.0 FALSE
		IF NOT IS_CAR_DEAD mmplayer_car
			GET_CAR_HEALTH mmplayer_car mm_adding_health
			IF mm_adding_health < 1234 
				mm_adding_health += 15
				SET_CAR_HEALTH mmplayer_car mm_adding_health
			ELSE
				mm_adding_health = 1249
				SET_CAR_HEALTH mmplayer_car mm_adding_health
			ENDIF
		ENDIF
		mm_countdown += 15000 //15 secs extra
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		GOSUB cunty_hoarz
	ENDIF  
	IF NOT IS_CAR_DEAD mm_car3 
		IF LOCATE_CAR_3D mm_car3 plyr_rndx plyr_rndy plyr_rndz 7.0 7.0 7.0 FALSE
			GOSUB cunty_hoarz
		ENDIF
	ENDIF
	IF NOT IS_CAR_DEAD mm_car10 
		IF LOCATE_CAR_3D mm_car10 plyr_rndx plyr_rndy plyr_rndz 7.0 7.0 7.0 FALSE
			GOSUB cunty_hoarz
		ENDIF
	ENDIF
	
		
	//making sure counter cant be 0
	IF mm_cars_killed < 0 
		mm_cars_killed = 0
	ENDIF

	////checking car health for counter and making car right way up
	IF NOT IS_CAR_DEAD mmplayer_car 
		GET_CAR_HEALTH mmplayer_car mm_car_health
		mm_car_health -= 249 
		IF mm_car_health < 0 
			mm_car_health = 0
		ENDIF
		mm_car_health_divided = mm_car_health / 10
		IF mm_car_health_divided < 0 
			mm_car_health_divided = 0
		ENDIF
		IF IS_CAR_UPSIDEDOWN mmplayer_car
			IF IS_CAR_STOPPED mmplayer_car
				GET_CAR_COORDINATES mmplayer_car player_x player_y player_z
				GET_CAR_HEADING mmplayer_car mm_car_heading
				SET_CAR_COORDINATES mmplayer_car player_x player_y player_z
				SET_CAR_HEADING mmplayer_car mm_car_heading 
			ENDIF
		ENDIF  
	ENDIF


	//waiting for cars to finish initial forward burst
	IF timerb > 5000
		IF letting_cars_do_stuff = 0
			IF NOT IS_CAR_DEAD mm_car3 
				CAR_GOTO_COORDINATES_ACCURATE mm_car3 plyr_rndx plyr_rndy -100.0
			ENDIF
			IF NOT IS_CAR_DEAD mm_car10 
				CAR_GOTO_COORDINATES_ACCURATE mm_car10 plyr_rndx plyr_rndy -100.0
			ENDIF
			letting_cars_do_stuff = 1
		ENDIF
		
		//top left of bloodring
		IF zero_where_player = 1
			IF NOT IS_CAR_DEAD mm_car1
				//IF NOT IS_CAR_DEAD mm_car2
				//	SET_CAR_RAM_CAR mm_car2 mm_car1
				//ENDIF
				IF NOT IS_CAR_DEAD mm_car3
					CAR_GOTO_COORDINATES_ACCURATE mm_car3 plyr_rndx plyr_rndy -100.0
				ENDIF
				IF NOT IS_CAR_DEAD mm_car4
					SET_CAR_RAM_CAR mm_car4 mm_car1
				ENDIF
			ENDIF
			zero_where_player = 5
		ENDIF	
		
		IF where_is_player = 0
			IF zero_where_player = 5
				IF NOT IS_CAR_DEAD mm_car1
					GENERATE_RANDOM_FLOAT_IN_RANGE -1530.0 -1384.0 rnd_float1x
					GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 923.0 rnd_float1y
					CAR_GOTO_COORDINATES_ACCURATE mm_car1 rnd_float1x rnd_float1y -100.0
				ENDIF
			ENDIF
		ENDIF
		 
		IF zero_where_player = 11
			IF NOT IS_CAR_DEAD mm_car1
		 		SET_CAR_MISSION mm_car1 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			//IF NOT IS_CAR_DEAD mm_car2
		 	//	SET_CAR_MISSION mm_car2 MISSION_RAMPLAYER_FARAWAY
			//ENDIF
			//IF NOT IS_CAR_DEAD mm_car3
		 	//	SET_CAR_MISSION mm_car3 MISSION_RAMPLAYER_FARAWAY
			//ENDIF
			IF NOT IS_CAR_DEAD mm_car4
		 		SET_CAR_MISSION mm_car4 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			zero_where_player = 6
		ENDIF



		//top right of bloodring
		IF zero_where_player = 2
			IF NOT IS_CAR_DEAD mm_car5
				//IF NOT IS_CAR_DEAD mm_car6
				//	SET_CAR_RAM_CAR mm_car6 mm_car5
				//ENDIF
				IF NOT IS_CAR_DEAD mm_car7
					SET_CAR_RAM_CAR mm_car7 mm_car5
				ENDIF
				IF NOT IS_CAR_DEAD mm_car8
					SET_CAR_RAM_CAR mm_car8 mm_car5
				ENDIF
			ENDIF
			zero_where_player = 5
		ENDIF	
		
		IF where_is_player = 0
			IF zero_where_player = 5				 
				IF NOT IS_CAR_DEAD mm_car5
					GENERATE_RANDOM_FLOAT_IN_RANGE -1530.0 -1384.0 rnd_float2x
					GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 1056.0 rnd_float2y
					CAR_GOTO_COORDINATES_ACCURATE mm_car5 rnd_float2x rnd_float2y -100.0
				ENDIF
			ENDIF
		ENDIF
		 
		IF zero_where_player = 12
			IF NOT IS_CAR_DEAD mm_car5
		 		SET_CAR_MISSION mm_car5 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			//IF NOT IS_CAR_DEAD mm_car6
		 	//	SET_CAR_MISSION mm_car6 MISSION_RAMPLAYER_FARAWAY
			//ENDIF
			IF NOT IS_CAR_DEAD mm_car7
		 		SET_CAR_MISSION mm_car7 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			IF NOT IS_CAR_DEAD mm_car8
		 		SET_CAR_MISSION mm_car8 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			zero_where_player = 6
		ENDIF



		//Bottom Left of bloodring
		IF zero_where_player = 3
			IF NOT IS_CAR_DEAD mm_car9
				IF NOT IS_CAR_DEAD mm_car10
					CAR_GOTO_COORDINATES_ACCURATE mm_car10 plyr_rndx plyr_rndy -100.0
				ENDIF
				IF NOT IS_CAR_DEAD mm_car11
					SET_CAR_RAM_CAR mm_car11 mm_car9
				ENDIF
				IF NOT IS_CAR_DEAD mm_car12
					SET_CAR_RAM_CAR mm_car12 mm_car9
				ENDIF
			ENDIF
			zero_where_player = 5
		ENDIF	
		
		IF where_is_player = 0							   
			IF zero_where_player = 5
				IF NOT IS_CAR_DEAD mm_car9
					GENERATE_RANDOM_FLOAT_IN_RANGE -1265.0 -1384.0 rnd_float3x
					GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 923.0 rnd_float3y
					CAR_GOTO_COORDINATES_ACCURATE mm_car9 rnd_float3x rnd_float3y -100.0
				ENDIF
			ENDIF
		ENDIF
		 
		IF zero_where_player = 13
			IF NOT IS_CAR_DEAD mm_car9
		 		SET_CAR_MISSION mm_car9 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			//IF NOT IS_CAR_DEAD mm_car10
		 	//	SET_CAR_MISSION mm_car10 MISSION_RAMPLAYER_FARAWAY
			//ENDIF
			IF NOT IS_CAR_DEAD mm_car11
		 		SET_CAR_MISSION mm_car11 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			IF NOT IS_CAR_DEAD mm_car12
		 		SET_CAR_MISSION mm_car12 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			zero_where_player = 6
		ENDIF



		//Bottom Right of bloodring
		IF zero_where_player = 4
			IF NOT IS_CAR_DEAD mm_car13
				IF NOT IS_CAR_DEAD mm_car14
					SET_CAR_RAM_CAR mm_car14 mm_car13
				ENDIF
				IF NOT IS_CAR_DEAD mm_car15
					SET_CAR_RAM_CAR mm_car15 mm_car13
				ENDIF
				IF NOT IS_CAR_DEAD mm_car16
					SET_CAR_RAM_CAR mm_car16 mm_car13
				ENDIF
			ENDIF
			zero_where_player = 5
		ENDIF	
		
		IF where_is_player = 0
			IF zero_where_player = 5					  
				IF NOT IS_CAR_DEAD mm_car13
					GENERATE_RANDOM_FLOAT_IN_RANGE -1265.0 -1384.0 rnd_float4x
					GENERATE_RANDOM_FLOAT_IN_RANGE 995.0 1056.0 rnd_float4y
					CAR_GOTO_COORDINATES_ACCURATE mm_car13 rnd_float4x rnd_float4y -100.0
				ENDIF
			ENDIF
			where_is_player = 1
		ENDIF
		 
		IF zero_where_player = 14
			IF NOT IS_CAR_DEAD mm_car13
		 		SET_CAR_MISSION mm_car13 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			IF NOT IS_CAR_DEAD mm_car14
		 		SET_CAR_MISSION mm_car14 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			IF NOT IS_CAR_DEAD mm_car15
		 		SET_CAR_MISSION mm_car15 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			IF NOT IS_CAR_DEAD mm_car16
		 		SET_CAR_MISSION mm_car16 MISSION_RAMPLAYER_FARAWAY
			ENDIF
			zero_where_player = 6
		ENDIF



	//checking on cars
		IF NOT IS_CAR_DEAD mm_car1
			//IF IS_CAR_STOPPED mm_car1
				IF IS_CAR_UPSIDEDOWN mm_car1 
					//IF NOT IS_CAR_ON_SCREEN mm_car1
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car1 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car1 player_x player_y player_z
							SET_CAR_COORDINATES mm_car1 player_x player_y player_z
						ENDIF
				   	//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car1
				SET_CAR_TEMP_ACTION mm_car1 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF
	
		IF NOT IS_CAR_DEAD mm_car2
			//IF IS_CAR_STOPPED mm_car2
				IF IS_CAR_UPSIDEDOWN mm_car2 
					//IF NOT IS_CAR_ON_SCREEN mm_car2
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car2 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car2 player_x player_y player_z
							SET_CAR_COORDINATES mm_car2 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car2
				SET_CAR_TEMP_ACTION mm_car2 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car3
			//IF IS_CAR_STOPPED mm_car3
				IF IS_CAR_UPSIDEDOWN mm_car3 
					//IF NOT IS_CAR_ON_SCREEN mm_car3
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car3 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car3 player_x player_y player_z
							SET_CAR_COORDINATES mm_car3 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car3
			   	SET_CAR_TEMP_ACTION mm_car3 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF
	
		IF NOT IS_CAR_DEAD mm_car4
			//IF IS_CAR_STOPPED mm_car4
				IF IS_CAR_UPSIDEDOWN mm_car4 
					//IF NOT IS_CAR_ON_SCREEN mm_car4
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car4 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car4 player_x player_y player_z
							SET_CAR_COORDINATES mm_car4 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car4
				SET_CAR_TEMP_ACTION mm_car4 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car5
			//IF IS_CAR_STOPPED mm_car5
				IF IS_CAR_UPSIDEDOWN mm_car5 
					//IF NOT IS_CAR_ON_SCREEN mm_car5
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car5 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car5 player_x player_y player_z
							SET_CAR_COORDINATES mm_car5 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car5
				SET_CAR_TEMP_ACTION mm_car5 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car6
			//IF IS_CAR_STOPPED mm_car6
				IF IS_CAR_UPSIDEDOWN mm_car6 
					//IF NOT IS_CAR_ON_SCREEN mm_car6
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car6 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car6 player_x player_y player_z
							SET_CAR_COORDINATES mm_car6 player_x player_y player_z
						ENDIF
					//ENDIF
			   	ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car6
				SET_CAR_TEMP_ACTION mm_car6 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car7
			//IF IS_CAR_STOPPED mm_car7
				IF IS_CAR_UPSIDEDOWN mm_car7 
					//IF NOT IS_CAR_ON_SCREEN mm_car7
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car7 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car7 player_x player_y player_z
							SET_CAR_COORDINATES mm_car7 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car7
				SET_CAR_TEMP_ACTION mm_car7 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car8
			//IF IS_CAR_STOPPED mm_car8
				IF IS_CAR_UPSIDEDOWN mm_car8 
					//IF NOT IS_CAR_ON_SCREEN mm_car8
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car8 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car8 player_x player_y player_z
							SET_CAR_COORDINATES mm_car8 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car8
				SET_CAR_TEMP_ACTION mm_car8 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car9
			//IF IS_CAR_STOPPED mm_car9
				IF IS_CAR_UPSIDEDOWN mm_car9 
					//IF NOT IS_CAR_ON_SCREEN mm_car9
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car9 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car9 player_x player_y player_z
							SET_CAR_COORDINATES mm_car9 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car9
				SET_CAR_TEMP_ACTION mm_car9 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car10
			//IF IS_CAR_STOPPED mm_car10
				IF IS_CAR_UPSIDEDOWN mm_car10 
					//IF NOT IS_CAR_ON_SCREEN mm_car10
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car10 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car10 player_x player_y player_z
							SET_CAR_COORDINATES mm_car10 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car10
				SET_CAR_TEMP_ACTION mm_car10 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car11
			//IF IS_CAR_STOPPED mm_car11
				IF IS_CAR_UPSIDEDOWN mm_car11 
					//IF NOT IS_CAR_ON_SCREEN mm_car11
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car11 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car11 player_x player_y player_z
							SET_CAR_COORDINATES mm_car11 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car11
				SET_CAR_TEMP_ACTION mm_car11 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car12
			//IF IS_CAR_STOPPED mm_car12
				IF IS_CAR_UPSIDEDOWN mm_car12 
					//IF NOT IS_CAR_ON_SCREEN mm_car12
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car12 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car12 player_x player_y player_z
							SET_CAR_COORDINATES mm_car12 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car12
				SET_CAR_TEMP_ACTION mm_car12 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car13
			//IF IS_CAR_STOPPED mm_car13
				IF IS_CAR_UPSIDEDOWN mm_car13 
					//IF NOT IS_CAR_ON_SCREEN mm_car13
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car13 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car13 player_x player_y player_z
							SET_CAR_COORDINATES mm_car13 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car13
				SET_CAR_TEMP_ACTION mm_car13 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car14
			//IF IS_CAR_STOPPED mm_car14
				IF IS_CAR_UPSIDEDOWN mm_car14 
					//IF NOT IS_CAR_ON_SCREEN mm_car14
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car14 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car14 player_x player_y player_z
							SET_CAR_COORDINATES mm_car14 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car14
				SET_CAR_TEMP_ACTION mm_car14 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car15
			//IF IS_CAR_STOPPED mm_car15
				IF IS_CAR_UPSIDEDOWN mm_car15 
					//IF NOT IS_CAR_ON_SCREEN mm_car15
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car15 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car15 player_x player_y player_z
							SET_CAR_COORDINATES mm_car15 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car15
				SET_CAR_TEMP_ACTION mm_car15 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF

		IF NOT IS_CAR_DEAD mm_car16
			//IF IS_CAR_STOPPED mm_car16
				IF IS_CAR_UPSIDEDOWN mm_car16 
					//IF NOT IS_CAR_ON_SCREEN mm_car16
						IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 mm_car16 7.0 7.0 FALSE
							GET_CAR_COORDINATES mm_car16 player_x player_y player_z
							SET_CAR_COORDINATES mm_car16 player_x player_y player_z
						ENDIF
					//ENDIF
				ENDIF
			//ENDIF   
			IF IS_CAR_STUCK	mm_car16
				SET_CAR_TEMP_ACTION mm_car16 TEMPACT_REVERSE 3000
			ENDIF
		ENDIF
	
//setting timer to change coords lead car is going to
		IF timera > 1500
			where_is_player = 0
			timera = 0
			IF mm_sound_playing = 0
				mm_sound_playing = 1
			ENDIF
		ENDIF

	//where is player
		IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 923.0 FALSE
			IF zero1 = 0
				zero_where_player = 11
				zero1 = 1
			ENDIF
		ELSE
			IF zero1 = 1
				zero_where_player = 1
				zero1 = 0
			ENDIF
		ENDIF
		IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 1076.0 FALSE 
			IF zero2 = 0
				zero_where_player = 12
				zero2 = 1
			ENDIF
		ELSE
			IF zero2 = 1
				zero_where_player = 2
				zero2 = 0
			ENDIF
		ENDIF
		IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 923.0 FALSE 
			IF zero3 = 0
				zero_where_player = 13
				zero3 = 1
			ENDIF
		ELSE
			IF zero3 = 1
				zero_where_player = 3
				zero3 = 0
			ENDIF
		ENDIF
		IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 1076.0 FALSE 
			IF zero4 = 0
				zero_where_player = 14
				zero4 = 1
			ENDIF
		ELSE
			IF zero4 = 1
				zero_where_player = 4
				zero4 = 0
			ENDIF
		ENDIF
	ENDIF


		
//checking cars status
	IF IS_CAR_DEAD mm_car1
		cars_created--
		mm_cars_killed++
	ENDIF

	IF IS_CAR_DEAD mm_car2
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car3
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car4
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car5
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car6
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car7
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car8
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car9
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car10
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car11
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car12
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car13
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car14
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car15
		cars_created--
		mm_cars_killed++
	ENDIF
	
	IF IS_CAR_DEAD mm_car16
		cars_created--
		mm_cars_killed++
	ENDIF
		

 
//building new cars
	IF cars_created < 16
		GOSUB create_cars_mm
	ENDIF

ENDWHILE

SET_PLAYER_CONTROL player1 OFF
SET_FADING_COLOUR 0 0 0
DO_FADE 1000 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW ( taxi2 ) 5000 1 //You're out of time
GOTO mission_failed_mm


// Mission failed
mission_failed_mm:
PRINT_BIG ( M_FAIL ) 5000 1	//"Mission Failed!"
RETURN

   

// mission passed
mission_passed_mm:
LOAD_MISSION_AUDIO 1 airhrnl
WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
ENDWHILE

LOAD_MISSION_AUDIO 2 airhrnr
WHILE NOT HAS_MISSION_AUDIO_LOADED 2
	WAIT 0
ENDWHILE

PLAY_MISSION_AUDIO 1
PLAY_MISSION_AUDIO 2
WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	WAIT 0
ENDWHILE
// ******************************************WINNING Demolition Derby*******************************************
SET_PLAYER_CONTROL player1 OFF
SWITCH_WIDESCREEN ON
PLAY_MISSION_PASSED_TUNE 1

IF NOT IS_CAR_DEAD mm_car1
	FREEZE_CAR_POSITION mm_car1 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car2
	FREEZE_CAR_POSITION mm_car2 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car3
	FREEZE_CAR_POSITION mm_car3 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car4
	FREEZE_CAR_POSITION mm_car4 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car5
	FREEZE_CAR_POSITION mm_car5 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car6
	FREEZE_CAR_POSITION mm_car6 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car7
	FREEZE_CAR_POSITION mm_car7 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car8
	FREEZE_CAR_POSITION mm_car8 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car9
	FREEZE_CAR_POSITION mm_car9 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car10
	FREEZE_CAR_POSITION mm_car10 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car11
	FREEZE_CAR_POSITION mm_car11 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car12
	FREEZE_CAR_POSITION mm_car12 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car13
	FREEZE_CAR_POSITION mm_car13 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car14
	FREEZE_CAR_POSITION mm_car14 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car15
	FREEZE_CAR_POSITION mm_car15 TRUE
ENDIF  
IF NOT IS_CAR_DEAD mm_car16
	FREEZE_CAR_POSITION mm_car16 TRUE
ENDIF  

PRINT_BIG BLOD_10 6000 5//WINNER!!
PRINT_WITH_NUMBER_BIG BLOD_09 1000 6000 6//$~1~

ADD_SCORE player1 1000
mm_longest_time = time_to_beat 
mm_longest_time /= 1000 
mm_attempt ++
mm_best_time ++
SET_LONGEST_TIME_IN_BLOOD_RING mm_longest_time

timera = 0
USE_TEXT_COMMANDS TRUE
bitches:
WAIT 0

IF timera < 5000
	GOSUB texty_wexty
	SET_TEXT_COLOUR 0 0 0 255
	DISPLAY_TEXT_WITH_NUMBER 32.0 302.0 BLOD_07 mm_longest_time //NEW Best Time: ~1~Seconds
	GOSUB texty_wexty
	SET_TEXT_COLOUR 255 128 0 255
	DISPLAY_TEXT_WITH_NUMBER 30.0 300.0 BLOD_07 mm_longest_time //NEW Best Time: ~1~Seconds
	//IF mm_cars_killed > 0
		GOSUB texty_wexty
		SET_TEXT_COLOUR 0 0 0 255
		DISPLAY_TEXT_WITH_NUMBER 32.0 317.0 BLOD_08 mm_cars_killed //Cars Destroyed: ~1~
		GOSUB texty_wexty
		SET_TEXT_COLOUR 255 128 0 255
		DISPLAY_TEXT_WITH_NUMBER 30.0 315.0 BLOD_08 mm_cars_killed //Cars Destroyed: ~1~
	//ENDIF
ELSE
	GOTO bitches_hoars
ENDIF
GOTO bitches
bitches_hoars:

time_to_beat += 60000
// ******************************************END OF PLAYER GETTING INTO BOAT*********************************************
SET_FADING_COLOUR 0 0 0
DO_FADE 1000 FADE_OUT
WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_WIDESCREEN OFF

CANCEL_OVERRIDE_RESTART
SET_FREE_HEALTH_CARE player1 FALSE
CLEAR_PRINTS
CLEAR_WANTED_LEVEL player1

IF mm_mission_passed_once = 0
	SWITCH_CAR_GENERATOR gen_car125 101
	SWITCH_CAR_GENERATOR gen_car126 101
	PLAYER_MADE_PROGRESS 1
	REGISTER_ODDJOB_MISSION_PASSED
	mm_mission_passed_once = 1
ENDIF
RETURN
		


// mission cleanup
mission_cleanup_mm:
flag_player_on_mission = 0
USE_TEXT_COMMANDS FALSE 
CLEAR_EXTRA_COLOURS FALSE
REMOVE_BLIP plyr_checkpoint_blip
LOAD_SCENE -1101.0 1331.0 19.1
SET_PLAYER_CONTROL player1 on
RELEASE_WEATHER
ADD_BLOOD_RING_KILLS mm_cars_killed
CLEAR_ONSCREEN_COUNTER mm_cars_killed 
CLEAR_ONSCREEN_TIMER mm_countdown
CLEAR_ONSCREEN_COUNTER mm_car_health_divided  
CLEAR_THIS_PRINT BLOD_05
CLEAR_THIS_PRINT BLOD_06
MARK_MODEL_AS_NO_LONGER_NEEDED bloodrb
MARK_MODEL_AS_NO_LONGER_NEEDED bloodra
MARK_MODEL_AS_NO_LONGER_NEEDED WMYCR
flag_mm_trigger = 1
GET_GAME_TIMER timer_mobile_start
SHUT_PLAYER_UP player1 FALSE
SET_PLAYER_IS_IN_STADIUM FALSE

IF NOT HAS_DEATHARREST_BEEN_EXECUTED
	SET_AREA_VISIBLE VIS_MAIN_MAP
	LOAD_SCENE -1101.0 1331.0 19.1 
	IF IS_PLAYER_IN_ANY_CAR player1
		WARP_PLAYER_FROM_CAR_TO_COORD player1 -1101.0 1331.0 19.1
	ELSE
		SET_PLAYER_COORDINATES player1 -1101.0 1331.0 19.1
	ENDIF

	SET_PLAYER_HEADING player1 278.650
	RESTORE_CAMERA_JUMPCUT
	SET_CAMERA_IN_FRONT_OF_PLAYER
	SET_FADING_COLOUR 0 0 0 
	DO_FADE 1500 FADE_IN
	SET_PLAYER_CONTROL player1 ON
ENDIF

MISSION_HAS_FINISHED
RETURN



///////////////////////////////////////////////////////////////////////////////////////////
create_cars_mm:////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GOSUB random_garages

IF IS_CAR_DEAD mm_car1
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 923.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car1 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car1
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver1 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car1
	CREATE_CHAR_INSIDE_CAR mm_car1 PEDTYPE_CIVMALE WMYCR mm_driver1
	SHUT_CHAR_UP mm_driver1 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car1 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car1 TRUE
	SET_CAR_CRUISE_SPEED mm_car1 100.0
	ADD_STUCK_CAR_CHECK mm_car1 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car1 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car1 25.0 
	SET_CAR_MISSION mm_car1 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car1 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car2 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 923.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car2 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car2
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver2 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car2
	CREATE_CHAR_INSIDE_CAR mm_car2 PEDTYPE_CIVMALE WMYCR mm_driver2
	SHUT_CHAR_UP mm_driver2 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car2 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car2 TRUE
	SET_CAR_CRUISE_SPEED mm_car2 100.0
	ADD_STUCK_CAR_CHECK mm_car2 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car2 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car2 25.0 
	SET_CAR_MISSION mm_car2 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car2 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car3 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 923.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car3 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car3
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver3 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car3
	CREATE_CHAR_INSIDE_CAR mm_car3 PEDTYPE_CIVMALE WMYCR mm_driver3
	SHUT_CHAR_UP mm_driver3 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car3 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car3 TRUE
	SET_CAR_CRUISE_SPEED mm_car3 100.0
	ADD_STUCK_CAR_CHECK mm_car3 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car3 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car3 25.0 
	SET_CAR_MISSION mm_car3 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car3 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car4 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 923.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car4 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car4
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver4 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car4
	CREATE_CHAR_INSIDE_CAR mm_car4 PEDTYPE_CIVMALE WMYCR mm_driver4
	SHUT_CHAR_UP mm_driver4 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car4 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car4 TRUE
	SET_CAR_CRUISE_SPEED mm_car4 100.0
	ADD_STUCK_CAR_CHECK mm_car4 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car4 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car4 25.0 
	SET_CAR_MISSION mm_car4 MISSION_RAMPLAYER_FARAWAY
    //SET_CAR_HEALTH mm_car4 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car5 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 1076.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car5 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car5
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver5 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car5
	CREATE_CHAR_INSIDE_CAR mm_car5 PEDTYPE_CIVMALE WMYCR mm_driver5
	SHUT_CHAR_UP mm_driver5 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car5 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car5 TRUE
	SET_CAR_CRUISE_SPEED mm_car5 100.0
	ADD_STUCK_CAR_CHECK mm_car5 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car5 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car5 25.0 
	SET_CAR_MISSION mm_car5 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car5 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car6 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 1076.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car6 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car6
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver6 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car6
	CREATE_CHAR_INSIDE_CAR mm_car6 PEDTYPE_CIVMALE WMYCR mm_driver6
	SHUT_CHAR_UP mm_driver6 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car6 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car6 TRUE
	SET_CAR_CRUISE_SPEED mm_car6 100.0
	ADD_STUCK_CAR_CHECK mm_car6 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car6 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car6 25.0 
	SET_CAR_MISSION mm_car6 MISSION_RAMPLAYER_FARAWAY
	SET_CAR_MISSION mm_car6 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car6 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car7 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 1076.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car7 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car7
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver7 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car7
	CREATE_CHAR_INSIDE_CAR mm_car7 PEDTYPE_CIVMALE WMYCR mm_driver7
	SHUT_CHAR_UP mm_driver7 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car7 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car7 TRUE
	SET_CAR_CRUISE_SPEED mm_car7 100.0
	ADD_STUCK_CAR_CHECK mm_car7 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car7 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car7 25.0 
	SET_CAR_MISSION mm_car7 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car7 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car8 
	IF IS_PLAYER_IN_AREA_2D player1 -1530.0 995.0 -1384.0 1076.0 FALSE
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car8 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car8
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver8 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car8
	CREATE_CHAR_INSIDE_CAR mm_car8 PEDTYPE_CIVMALE WMYCR mm_driver8
	SHUT_CHAR_UP mm_driver8 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car8 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car8 TRUE
	SET_CAR_CRUISE_SPEED mm_car8 100.0
	ADD_STUCK_CAR_CHECK mm_car8 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car8 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car8 25.0 
	SET_CAR_MISSION mm_car8 MISSION_RAMPLAYER_FARAWAY
   	//SET_CAR_HEALTH mm_car8 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car9 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 923.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car9 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car9
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver9 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car9
	CREATE_CHAR_INSIDE_CAR mm_car9 PEDTYPE_CIVMALE WMYCR mm_driver9
	SHUT_CHAR_UP mm_driver9 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car9 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car9 TRUE
	SET_CAR_CRUISE_SPEED mm_car9 100.0
	ADD_STUCK_CAR_CHECK mm_car9 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car9 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car9 25.0 
	SET_CAR_MISSION mm_car9 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car9 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car10 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 923.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car10 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car10
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver10 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car10
	CREATE_CHAR_INSIDE_CAR mm_car10 PEDTYPE_CIVMALE WMYCR mm_driver10
	SHUT_CHAR_UP mm_driver10 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car10 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car10 TRUE
	SET_CAR_CRUISE_SPEED mm_car10 100.0
	ADD_STUCK_CAR_CHECK mm_car10 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car10 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car10 25.0 
	SET_CAR_MISSION mm_car10 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car10 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car11 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 923.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car11 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car11
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver11 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car11
	CREATE_CHAR_INSIDE_CAR mm_car11 PEDTYPE_CIVMALE WMYCR mm_driver11
	SHUT_CHAR_UP mm_driver11 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car11 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car11 TRUE
	SET_CAR_CRUISE_SPEED mm_car11 100.0
	ADD_STUCK_CAR_CHECK mm_car11 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car11 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car11 25.0 
	SET_CAR_MISSION mm_car11 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car11 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car12 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 923.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car12 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car12
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver12 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car12
	CREATE_CHAR_INSIDE_CAR mm_car12 PEDTYPE_CIVMALE WMYCR mm_driver12
	SHUT_CHAR_UP mm_driver12 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car12 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car12 TRUE
	SET_CAR_CRUISE_SPEED mm_car12 100.0
	ADD_STUCK_CAR_CHECK mm_car12 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car12 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car12 25.0 
	SET_CAR_MISSION mm_car12 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car12 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car13 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 1076.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car13 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car13
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver13 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car13
	CREATE_CHAR_INSIDE_CAR mm_car13 PEDTYPE_CIVMALE WMYCR mm_driver13
	SHUT_CHAR_UP mm_driver13 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car13 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car13 TRUE
	SET_CAR_CRUISE_SPEED mm_car13 100.0
	ADD_STUCK_CAR_CHECK mm_car13 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car13 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car13 25.0 
	SET_CAR_MISSION mm_car13 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car13 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car14 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 1076.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car14 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car14
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver14 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car14
	CREATE_CHAR_INSIDE_CAR mm_car14 PEDTYPE_CIVMALE WMYCR mm_driver14
	SHUT_CHAR_UP mm_driver14 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car14 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car14 TRUE
	SET_CAR_CRUISE_SPEED mm_car14 100.0
	ADD_STUCK_CAR_CHECK mm_car14 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car14 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car14 25.0 
	SET_CAR_MISSION mm_car14 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car14 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car15 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 1076.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car15 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car15
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver15 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car15
	CREATE_CHAR_INSIDE_CAR mm_car15 PEDTYPE_CIVMALE WMYCR mm_driver15
	SHUT_CHAR_UP mm_driver15 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car15 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car15 TRUE
	SET_CAR_CRUISE_SPEED mm_car15 100.0
	ADD_STUCK_CAR_CHECK mm_car15 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car15 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car15 25.0 
	SET_CAR_MISSION mm_car15 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car15 750 
	cars_created ++
ENDIF

GOSUB random_garages

IF IS_CAR_DEAD mm_car16 
	IF IS_PLAYER_IN_AREA_2D player1 -1265.0 995.0 -1384.0 1076.0 FALSE 
		PRINT_WITH_NUMBER_BIG BONUS 100 1000 1
		ADD_ONE_OFF_SOUND 0.0 0.0 0.0 SOUND_PART_MISSION_COMPLETE
		ADD_SCORE player1 100
	ENDIF
	REMOVE_STUCK_CAR_CHECK mm_car16 
	MARK_CAR_AS_NO_LONGER_NEEDED mm_car16
	MARK_CHAR_AS_NO_LONGER_NEEDED mm_driver16 
	CREATE_CAR bloodrb random_car_node_x random_car_node_y random_car_node_z mm_car16
	CREATE_CHAR_INSIDE_CAR mm_car16 PEDTYPE_CIVMALE WMYCR mm_driver16
	SHUT_CHAR_UP mm_driver16 TRUE 
	SET_CAR_STRAIGHT_LINE_DISTANCE mm_car16 255
	SET_CAR_ONLY_DAMAGED_BY_PLAYER mm_car16 TRUE
	SET_CAR_CRUISE_SPEED mm_car16 100.0
	ADD_STUCK_CAR_CHECK mm_car16 1.5 4000
	SET_CAR_DRIVING_STYLE mm_car16 DRIVINGMODE_PLOUGHTHROUGH
	SET_CAR_FORWARD_SPEED mm_car16 25.0 
	SET_CAR_MISSION mm_car16 MISSION_RAMPLAYER_FARAWAY
	//SET_CAR_HEALTH mm_car16 750 
	cars_created ++
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
random_garages:////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GENERATE_RANDOM_INT_IN_RANGE 1 4 random_garage
WAIT 0
DRAW_CORONA plyr_rndx plyr_rndy plyr_rndz 5.0 CORONATYPE_CIRCLE FLARETYPE_NONE 150 150 0


//playing sound
IF mm_sound_playing = 1
	GOSUB mm_sound
ENDIF


IF random_garage = 1
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1461.84 938.32 261.00 5.0 5.0 5.0  //garage 1
		random_car_node_x = -1461.84
		random_car_node_y = 938.32
		random_car_node_z = 261.00
		mm_car_heading = 345.6 
	ELSE
		GOTO random_garages
	ENDIF
ENDIF
IF random_garage = 2
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1424.36 933.86 261.00 5.0 5.0 5.0  //garage 2
		random_car_node_x = -1424.36
		random_car_node_y = 933.86
		random_car_node_z = 261.00
	ELSE
		GOTO random_garages
	ENDIF
ENDIF
IF random_garage = 3
	IF NOT IS_POINT_OBSCURED_BY_A_MISSION_ENTITY -1443.29 931.29 261.00 5.0 5.0 5.0  //garage 3
		random_car_node_x = -1443.29
		random_car_node_y = 931.29
		random_car_node_z = 261.00
		mm_car_heading = 351.4 
	ELSE
		GOTO random_garages
	ENDIF
ENDIF

///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
cunty_hoarz:///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GENERATE_RANDOM_FLOAT_IN_RANGE -1290.0 -1508.0 plyr_rndx
GENERATE_RANDOM_FLOAT_IN_RANGE 939.0 1052.0 plyr_rndy
GET_GROUND_Z_FOR_3D_COORD plyr_rndx plyr_rndy 275.8 plyr_rndz
IF plyr_rndz > 260.2
	GOTO cunty_hoarz
ENDIF
IF plyr_rndz < 249.0
	GOTO cunty_hoarz
ENDIF
REMOVE_BLIP plyr_checkpoint_blip 
ADD_BLIP_FOR_COORD plyr_rndx plyr_rndy plyr_rndz plyr_checkpoint_blip
CHANGE_BLIP_COLOUR plyr_checkpoint_blip YELLOW 
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
mm_sound://////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
GENERATE_RANDOM_INT_IN_RANGE 1 22 mm_sound1
IF mm_audio_flag = 0
	IF mm_cuntie = mm_sound1
		++ mm_sound1
		IF mm_sound1 > 21
		   	mm_sound1 = 1
		ENDIF
	ENDIF


	IF mm_sound1 = 1 
		LOAD_MISSION_AUDIO 1 ( RACE1 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 2 
		LOAD_MISSION_AUDIO 1 ( RACE2 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 3 
		LOAD_MISSION_AUDIO 1 ( RACE3 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 4 
		LOAD_MISSION_AUDIO 1 ( RACE4 )
		mm_audio_flag = 1
	ENDIF  
	IF mm_sound1 = 5 
		LOAD_MISSION_AUDIO 1 ( RACE5 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 6 
		LOAD_MISSION_AUDIO 1 ( RACE6 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 7 
		LOAD_MISSION_AUDIO 1 ( RACE7 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 8 
		LOAD_MISSION_AUDIO 1 ( RACE8 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 9 
		LOAD_MISSION_AUDIO 1 ( RACE9 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 10 
		LOAD_MISSION_AUDIO 1 ( RACE10 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 11 
		LOAD_MISSION_AUDIO 1 ( RACE11 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 12 
		LOAD_MISSION_AUDIO 1 ( RACE12 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 13 
		LOAD_MISSION_AUDIO 1 ( RACE13 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 14 
		LOAD_MISSION_AUDIO 1 ( RACE14 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 15 
		LOAD_MISSION_AUDIO 1 ( RACE15 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 16 
		LOAD_MISSION_AUDIO 1 ( CHEER1 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 17 
		LOAD_MISSION_AUDIO 1 ( CHEER2 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 18 
		LOAD_MISSION_AUDIO 1 ( CHEER3 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 19 
		LOAD_MISSION_AUDIO 1 ( CHEER4 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 20 
		LOAD_MISSION_AUDIO 1 ( OOH1 )
		mm_audio_flag = 1
	ENDIF
	IF mm_sound1 = 21 
		LOAD_MISSION_AUDIO 1 ( OOH2 )
		mm_audio_flag = 1
	ENDIF


mm_cuntie = mm_sound1



ENDIF

IF mm_audio_flag = 1
	IF HAS_MISSION_AUDIO_LOADED 1
		mm_audio_flag = 2
	ENDIF
ENDIF

IF mm_audio_flag = 2
	PLAY_MISSION_AUDIO 1
	mm_audio_flag = 3
ENDIF
	
IF mm_audio_flag = 3
	IF HAS_MISSION_AUDIO_FINISHED 1
		mm_audio_flag = 4
	ENDIF
ENDIF	  

IF mm_audio_flag = 4
	mm_audio_flag = 0
	mm_sound_playing = 0
ENDIF
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////
texty_wexty:///////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
SET_TEXT_JUSTIFY ON
SET_TEXT_RIGHT_JUSTIFY OFF
SET_TEXT_WRAPX 500.0
SET_TEXT_PROPORTIONAL ON
SET_TEXT_CENTRE OFF
SET_TEXT_BACKGROUND OFF
SET_TEXT_SCALE 0.6 1.6
///////////////////////////////////////////////////////////////////////////////////////////
RETURN/////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////
}