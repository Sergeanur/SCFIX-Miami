MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// ****************************** boat yard odd job*****************************************
// *****************************************************************************************
// *****************************************************************************************



// Mission start stuff

GOSUB mission_start_cokerun

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_cokerun_failed
ENDIF

GOSUB mission_cleanup_cokerun
MISSION_END

{
LVAR_INT counter_cokerun cokerun_bigboat blipcoke_1 coke_ramp1 coke_ramp2 coke_ramp3  
LVAR_INT create_coke_pickup	cokerun_boat coke_pickup

VAR_INT countdown_boat countdown_boat_seconds flag_cokerun_passed start_countdown_boat

mission_start_cokerun:

flag_player_on_mission = 1
SCRIPT_NAME COKERUN					  

WAIT 0

// ****************************************Mission Start************************************

//Mission Script 
counter_cokerun = 0 
create_coke_pickup = 0
REQUEST_MODEL marquis

IF boatyard_asset_acquired = 0
	REGISTER_MISSION_GIVEN
ENDIF

WHILE NOT HAS_MODEL_LOADED marquis
	WAIT 0
ENDWHILE

ADD_BLIP_FOR_COORD -540.1 -1526.9 8.0 blipcoke_1
DRAW_CORONA -540.1 -1526.9 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200

IF create_coke_pickup = 0
	CREATE_PICKUP craigpackage PICKUP_ONCE -540.1 -1526.9 8.0 coke_pickup 
	create_coke_pickup = 1
ENDIF

LOAD_SCENE -569.272 -1503.455 9.428
SET_FIXED_CAMERA_POSITION -570.041 -1502.827 9.547 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -569.272 -1503.455 9.428 JUMP_CUT

DO_FADE 1500 FADE_IN

countdown_boat = 151000

STORE_CAR_CHAR_IS_IN scplayer cokerun_boat
IF NOT IS_CAR_DEAD cokerun_boat
	SET_CAR_HEADING	cokerun_boat 250.0
ENDIF
 
IF flag_cokerun_passed = 0 
	FORCE_WEATHER_NOW WEATHER_SUNNY
ENDIF
IF flag_cokerun_passed = 1 
	countdown_boat = countdown_boat - 5000
	FORCE_WEATHER_NOW WEATHER_EXTRA_SUNNY 	
ENDIF
IF flag_cokerun_passed = 2 
	countdown_boat = countdown_boat - 10000
	FORCE_WEATHER_NOW WEATHER_CLOUDY 
ENDIF
IF flag_cokerun_passed = 3
	countdown_boat = countdown_boat - 15000
	FORCE_WEATHER_NOW WEATHER_FOGGY 
ENDIF
IF flag_cokerun_passed = 4 
	countdown_boat = countdown_boat - 20000
	FORCE_WEATHER_NOW WEATHER_RAINY
ENDIF
IF flag_cokerun_passed > 4 
	countdown_boat = countdown_boat - 30000
ENDIF

start_countdown_boat = countdown_boat

CREATE_OBJECT waterjumpx2 -273.3 -1463.1 5.5 coke_ramp1  
//SET_OBJECT_HEADING coke_ramp1 343.60 
SET_OBJECT_COLLISION coke_ramp1 TRUE

CREATE_OBJECT waterjumpx2 -275.4 -1372.8 5.5 coke_ramp2  
//SET_OBJECT_HEADING coke_ramp2 343.60 
SET_OBJECT_COLLISION coke_ramp2 TRUE

CREATE_OBJECT waterjumpx2 -305.6 -1225.3 5.5 coke_ramp3  
//SET_OBJECT_HEADING coke_ramp3 343.60 
SET_OBJECT_COLLISION coke_ramp3 TRUE

TIMERA = 0


PRINT_NOW ( BOAT_P ) 6000 1

WHILE NOT TIMERA > 500
	WAIT 0

	DRAW_CORONA -540.1 -1526.9 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
 
ENDWHILE

WHILE NOT TIMERA > 5500
	WAIT 0

	DRAW_CORONA -540.1 -1526.9 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200

	IF IS_BUTTON_PRESSED PAD1 cross
		GOTO skip_cokerun_cut
	ENDIF
 
ENDWHILE


skip_cokerun_cut:

SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT

DISPLAY_ONSCREEN_TIMER countdown_boat TIMER_DOWN

WHILE NOT counter_cokerun > 25

	WAIT 0

	IF countdown_boat = 0
		PRINT_NOW ( taxi2 ) 5000 1
		GOTO mission_cokerun_failed
	ENDIF

	IF counter_cokerun = 0
		DRAW_CORONA -540.1 -1526.9 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 -540.1 -1526.9 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -540.1 -1526.9 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -458.2 -1575.2 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF 
	
	IF counter_cokerun = 1
		DRAW_CORONA -458.2 -1575.2 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -458.2 -1575.2 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -458.2 -1575.2 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -458.2 -1575.2 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -361.2 -1599.6 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF 
	
 	IF counter_cokerun = 2
		DRAW_CORONA -361.2 -1599.6 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -361.2 -1599.6 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -361.2 -1599.6 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -361.2 -1599.6 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -333.0 -1678.1 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 3
		DRAW_CORONA -333.0 -1678.1 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -333.0 -1678.1 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -333.0 -1678.1 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -333.0 -1678.1 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -401.3 -1730.7 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 4
		DRAW_CORONA -401.3 -1730.7 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -401.3 -1730.7 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -401.3 -1730.7 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -401.3 -1730.7 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -312.3 -1715.6 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 5
		DRAW_CORONA -312.3 -1715.6 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -312.3 -1715.6 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -312.3 -1715.6 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -312.3 -1715.6 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -273.3 -1556.2 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 6
		DRAW_CORONA -273.3 -1556.2 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -273.3 -1556.2 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -273.3 -1556.2 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -273.3 -1556.2 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -272.4 -1449.7 13.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 7
		DRAW_CORONA -272.4 -1449.7 13.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -272.4 -1449.7 13.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -272.4 -1449.7 13.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -272.4 -1449.7 13.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -272.7 -1360.2 13.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 8
		DRAW_CORONA -275.4 -1360.2 13.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -275.4 -1360.2 13.0 coke_pickup 
			create_coke_pickup = 1				   
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -275.4 -1360.2 13.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -275.4 -1360.2 13.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -305.6 -1214.4 13.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 9
		DRAW_CORONA -305.6 -1214.4 13.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -305.6 -1214.4 13.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -305.6 -1214.4 13.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -305.6 -1214.4 13.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -298.6 -1074.4 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 10
		DRAW_CORONA -298.6 -1074.4 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -298.6 -1074.4 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -298.6 -1074.4 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -298.6 -1074.4 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -252.0 -939.9 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 11
		DRAW_CORONA -252.0 -939.9 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -252.0 -939.9 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -252.0 -939.9 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -252.0 -939.9 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -85.0 -766.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 12
		DRAW_CORONA -85.0 -766.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -85.0 -766.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -85.0 -766.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -85.0 -766.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 158.0 -634.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 13
		DRAW_CORONA 158.0 -634.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 158.0 -634.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 158.0 -634.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 158.0 -634.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 279.0 -475.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 14
		DRAW_CORONA 279.0 -475.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 279.0 -475.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 279.0 -475.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 279.0 -475.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 410.0 -269.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 15
		DRAW_CORONA 410.0 -269.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 410.0 -269.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 410.0 -269.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 410.0 -269.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 392.0 20.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF

	IF counter_cokerun = 16
		DRAW_CORONA 392.0 20.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 392.0 20.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 392.0 20.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 392.0 20.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 249.0 100.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 17
		DRAW_CORONA 249.0 100.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 249.0 100.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 249.0 100.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 249.0 100.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 194.0 -170.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 18
		DRAW_CORONA 194.0 -170.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 194.0 -170.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 194.0 -170.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 194.0 -170.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 49.0 -150.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 19
		DRAW_CORONA 49.0 -150.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 49.0 -150.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 49.0 -150.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 49.0 -150.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -64.0 -156.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 20
		DRAW_CORONA -64.0 -156.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -64.0 -156.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -64.0 -156.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -64.0 -156.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -93.0 67.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 21
		DRAW_CORONA -93.0 67.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -93.0 67.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -93.0 67.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -93.0 67.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD -70.0 294.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 22
		DRAW_CORONA -70.0 294.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE -70.0 294.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 -70.0 294.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND -70.0 294.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 25.0 394.0 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 23
		DRAW_CORONA 25.0 394.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 25.0 394.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 25.0 394.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 25.0 394.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 196.0 403.0 8.0 blipcoke_1
			++ counter_cokerun
			CREATE_CAR marquis 324.0 604.0 6.0 cokerun_bigboat
			SET_CAR_HEADING cokerun_bigboat 60.0
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 24
		DRAW_CORONA 196.0 403.0 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 196.0 403.0 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 196.0 403.0 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 196.0 403.0 8.0 SOUND_PART_MISSION_COMPLETE
			ADD_BLIP_FOR_COORD 304.4 540.6 8.0 blipcoke_1
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
	
	IF counter_cokerun = 25
		DRAW_CORONA 304.4 540.6 8.0 4.0 CORONATYPE_HEX FLARETYPE_NONE 255 0 0
		IF create_coke_pickup = 0
			CREATE_PICKUP craigpackage PICKUP_ONCE 304.4 540.6 8.0 coke_pickup 
			create_coke_pickup = 1
		ENDIF
		IF LOCATE_PLAYER_IN_CAR_3D player1 304.4 540.6 8.0 5.0 5.0 3.0 FALSE
			REMOVE_BLIP blipcoke_1
			REMOVE_PICKUP coke_pickup
			ADD_ONE_OFF_SOUND 304.4 540.6 8.0 SOUND_PART_MISSION_COMPLETE
			IF NOT IS_CAR_DEAD cokerun_bigboat 
				ADD_BLIP_FOR_CAR cokerun_bigboat blipcoke_1
			ENDIF
			++ counter_cokerun
			create_coke_pickup = 0
		ENDIF
	ENDIF
			
ENDWHILE

CLEAR_ONSCREEN_TIMER countdown_boat

IF flag_cokerun_passed = 0 

	SET_PLAYER_CONTROL player1 OFF
	SWITCH_WIDESCREEN ON

	CREATE_PROTECTION_PICKUP boatcashX boatcashY boatcashZ boatyard_revenue boatyard_revenue boatyard_cash_pickup
	SET_FADING_COLOUR 0 0 0
	DO_FADE 1000 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	SWITCH_STREAMING OFF

	REQUEST_MODEL b_hse_pier
	REQUEST_MODEL b_hse_ext
	REQUEST_MODEL docks28
	REQUEST_MODEL docksprops12
	REQUEST_MODEL docks85
	REQUEST_MODEL dk_dockroads04
	REQUEST_MODEL b_hse_pierfence
	REQUEST_MODEL b_hse_interior
	REQUEST_MODEL dk_reef
	REQUEST_MODEL boat_kb2 

	LOAD_ALL_MODELS_NOW

	WHILE NOT HAS_MODEL_LOADED b_hse_pier
	OR NOT HAS_MODEL_LOADED	b_hse_ext
	OR NOT HAS_MODEL_LOADED	docks28
	OR NOT HAS_MODEL_LOADED	docksprops12
	OR NOT HAS_MODEL_LOADED	docks85
	OR NOT HAS_MODEL_LOADED	dk_dockroads04
		WAIT 0
	ENDWHILE

	WHILE NOT HAS_MODEL_LOADED b_hse_pierfence
	OR NOT HAS_MODEL_LOADED	b_hse_interior
	OR NOT HAS_MODEL_LOADED	dk_reef
	OR NOT HAS_MODEL_LOADED	boat_kb2

		WAIT 0
	ENDWHILE

	SWITCH_STREAMING ON

	//LOAD_SCENE -640.2 -1485.5 17.0
	SET_FIXED_CAMERA_POSITION -631.643 -1495.598 26.104 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -632.270 -1495.064 25.537 JUMP_CUT
	
	WAIT 500

	SET_FADING_COLOUR 0 0 0
	DO_FADE 1000 FADE_IN

	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	PLAY_MISSION_PASSED_TUNE 1
	PRINT_BIG BOAT_A2 5000 6 //BOAT ASSET ACQUIRED

	WAIT 5000

	SET_FIXED_CAMERA_POSITION -636.797 -1497.307 17.588 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT -637.279 -1496.606 17.062 JUMP_CUT
	PRINT_WITH_NUMBER_NOW BOAT_AS boatyard_revenue 6000 1//BOAT will now generate revenue upto a maximum of $~1~. Make sure you collect it regulary.

	WAIT 6000

	SET_FADING_COLOUR 0 0 0
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_pier
	MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_ext
	MARK_MODEL_AS_NO_LONGER_NEEDED docks28
	MARK_MODEL_AS_NO_LONGER_NEEDED docksprops12
	MARK_MODEL_AS_NO_LONGER_NEEDED docks85
	MARK_MODEL_AS_NO_LONGER_NEEDED dk_dockroads04
	MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_pierfence
	MARK_MODEL_AS_NO_LONGER_NEEDED boat_kb2
	MARK_MODEL_AS_NO_LONGER_NEEDED dk_reef
	MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_interior

	LOAD_SCENE 324.0 604.0 7.0

	WAIT 500

	SET_FADING_COLOUR 0 0 0
	DO_FADE 500 FADE_IN	
	

	SET_PLAYER_CONTROL player1 ON
	SWITCH_WIDESCREEN OFF
	RESTORE_CAMERA_JUMPCUT

ENDIF


GOTO mission_cokerun_passed

// --------------------------Mission failed-----------------------------------------------

mission_cokerun_failed:

PRINT_BIG ( M_FAIL ) 2000 1

RETURN
   

// -------------------------Mission passed-------------------------------------------------

mission_cokerun_passed:

CLEAR_WANTED_LEVEL player1

IF flag_cokerun_passed = 0
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 5000 5000 1 //"Mission Passed!"
	ADD_SCORE player1 5000
	++ counter_60_percent 
	PLAYER_MADE_PROGRESS 1
	REGISTER_ODDJOB_MISSION_PASSED
	boatyard_asset_acquired	= 1
	flag_first_asset_complete = 1 // FIXMIAMI: fix Ken's phonecall
ENDIF

IF flag_cokerun_passed = 1 
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 6000 5000 1 //"Mission Passed!"
	ADD_SCORE player1 6000
ENDIF
IF flag_cokerun_passed = 2 
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 7000 5000 1 //"Mission Passed!"
	ADD_SCORE player1 7000
ENDIF
IF flag_cokerun_passed = 3
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 8000 5000 1 //"Mission Passed!" 
	ADD_SCORE player1 8000
ENDIF
IF flag_cokerun_passed = 4 
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 9000 5000 1 //"Mission Passed!"
	ADD_SCORE player1 9000
ENDIF
IF flag_cokerun_passed > 4 
	PRINT_WITH_NUMBER_BIG ( M_PASS ) 15000 5000 1 //"Mission Passed!"
	ADD_SCORE player1 15000
ENDIF

start_countdown_boat = start_countdown_boat - countdown_boat

countdown_boat_seconds = start_countdown_boat / 1000 //seconds
REGISTER_FASTEST_TIME 22 countdown_boat_seconds

flag_cokerun_passed ++

RETURN
		

// mission cleanup

mission_cleanup_cokerun:

RELEASE_WEATHER
REMOVE_BLIP blipcoke_1
DELETE_OBJECT coke_ramp1
DELETE_OBJECT coke_ramp2
DELETE_OBJECT coke_ramp3
REMOVE_PICKUP coke_pickup

MARK_MODEL_AS_NO_LONGER_NEEDED marquis
MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_pier
MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_ext
MARK_MODEL_AS_NO_LONGER_NEEDED docks28
MARK_MODEL_AS_NO_LONGER_NEEDED docksprops12
MARK_MODEL_AS_NO_LONGER_NEEDED docks85
MARK_MODEL_AS_NO_LONGER_NEEDED dk_dockroads04
MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_pierfence
MARK_MODEL_AS_NO_LONGER_NEEDED boat_kb2
MARK_MODEL_AS_NO_LONGER_NEEDED dk_reef
MARK_MODEL_AS_NO_LONGER_NEEDED b_hse_interior

MARK_CAR_AS_NO_LONGER_NEEDED cokerun_bigboat

CLEAR_ONSCREEN_TIMER countdown_boat
flag_player_on_mission = 0

MISSION_HAS_FINISHED
RETURN


}