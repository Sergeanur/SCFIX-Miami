MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ***************************************GRIPPED, SORTED*********************************** 
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

// Mission start stuff

GOSUB mission_start_carpark1
GOSUB mission_cleanup_carpark1
MISSION_END

// Variables for mission
/*
VAR_INT player_4x4 wanted_4x4
VAR_INT counter_4x4_pickups 
VAR_INT flag_timer timer_4x4 timer_bonus timer_4x4_secs
VAR_INT intro_time_lapsed timer_intro_now timer_intro_start flag_intro flag_intro_jump

VAR_INT flag_truck_1 flag_truck_2 truck_1 truck_2 truck_driver1 truck_driver2
VAR_INT flag_launch_4x4_1_ok
VAR_INT blip_1 blip_2 blip_3
VAR_INT blip_4 blip_5 blip_6
VAR_INT blip_7 blip_8 blip_9
VAR_INT blip_10 blip_11 blip_12
VAR_INT blip_13 blip_14 blip_15
VAR_INT blip_16 blip_17 blip_18
VAR_INT blip_19 blip_20 blip_21 
VAR_INT blip_22 blip_23	blip_24

VAR_INT flag_blip_1 flag_blip_2 flag_blip_3 flag_blip_4 
VAR_INT flag_blip_5 flag_blip_6 flag_blip_7 flag_blip_8 
VAR_INT flag_blip_9 flag_blip_10 flag_blip_11 flag_blip_12
VAR_INT flag_blip_13 flag_blip_14 flag_blip_15 flag_blip_16
VAR_INT flag_blip_17 flag_blip_18 flag_blip_19 flag_blip_20
VAR_INT flag_blip_21 flag_blip_22 flag_blip_23 flag_blip_24

VAR_FLOAT cam_4x4_X 
VAR_FLOAT cam_4x4_y 
VAR_FLOAT cam_4x4_z
*/

VAR_INT flag_cone_smashed
VAR_INT cp_seconds

VAR_INT cone_1 cone_2 cone_3 cone_4
VAR_INT cone_5 cone_6 cone_7 cone_8
VAR_INT cone_9 cone_10 cone_11 cone_12
VAR_INT cone_13 cone_14 cone_15 cone_16
VAR_INT cone_17 cone_18 cone_19 cone_20
VAR_INT cone_21 cone_22 cone_23 cone_24
VAR_INT cone_25 cone_26 cone_27 cone_28
VAR_INT cone_29 cone_30 cone_31 cone_32

VAR_INT print_bonus	car_park_reward	cp_minutes

VAR_FLOAT x_cone_1 y_cone_1 z_cone 
VAR_FLOAT x_cone_2 y_cone_2  
VAR_FLOAT x_cone_3 y_cone_3  
VAR_FLOAT x_cone_4 y_cone_4  
VAR_FLOAT x_cone_5 y_cone_5  
VAR_FLOAT x_cone_6 y_cone_6  
VAR_FLOAT x_cone_7 y_cone_7  
VAR_FLOAT x_cone_8 y_cone_8  
VAR_FLOAT x_cone_9 y_cone_9  
VAR_FLOAT x_cone_10 y_cone_10  
VAR_FLOAT x_cone_11 y_cone_11  
VAR_FLOAT x_cone_12 y_cone_12  
VAR_FLOAT x_cone_13 y_cone_13  
VAR_FLOAT x_cone_14 y_cone_14  
VAR_FLOAT x_cone_15 y_cone_15  
/*
VAR_FLOAT x_cone_16 y_cone_16  
VAR_FLOAT x_cone_17 y_cone_17  
VAR_FLOAT x_cone_18 y_cone_18  
VAR_FLOAT x_cone_19 y_cone_19  
VAR_FLOAT x_cone_20 y_cone_20  
VAR_FLOAT x_cone_21 y_cone_21  
VAR_FLOAT x_cone_22 y_cone_22  
VAR_FLOAT x_cone_23 y_cone_23  
VAR_FLOAT x_cone_24 y_cone_24
*/
VAR_FLOAT circle_radius cone_x cone_y theta  
VAR_FLOAT circle_x circle_y
// ****************************************Mission Start************************************

mission_start_carpark1:

IF flag_carpark1_passed = 0
	REGISTER_MISSION_GIVEN
ENDIF
SCRIPT_NAME CARPRK1 
flag_player_on_mission = 1
LOAD_MISSION_TEXT CARPAR1

//flag_player_on_4x4_mission = 1

PRINT_BIG (MM_1) 5000 2

WAIT 0

// ****************SET INT VARIABLES AND FLAGS*********************************************

counter_4x4_pickups = 0
timer_4x4 = 0
flag_intro = 0
flag_timer = 0
flag_intro_jump = 0
intro_time_lapsed = 0

flag_cone_smashed = 0

IF flag_carpark1_passed = 0
	timer_bonus = 12000 //ammount added to timer for each pickup
	print_bonus = 12
	car_park_reward = 400 // SCFIX: was 200, now this is only used when new time record is set, thus 200*2
ENDIF

flag_truck_1 = 0
flag_truck_2 = 0

flag_blip_1 = 0
flag_blip_2 = 0
flag_blip_3 = 0
flag_blip_4 = 0
flag_blip_5 = 0
flag_blip_6 = 0
flag_blip_7 = 0
flag_blip_8 = 0
flag_blip_9 = 0
flag_blip_10 = 0
flag_blip_11 = 0
flag_blip_12 = 0
flag_blip_13 = 0
flag_blip_14 = 0
flag_blip_15 = 0
flag_blip_16 = 0
flag_blip_17 = 0
flag_blip_18 = 0
flag_blip_19 = 0
flag_blip_20 = 0
flag_blip_21 = 0
flag_blip_22 = 0
flag_blip_23 = 0
flag_blip_24 = 0

record_temp = 0
// ******************* SET FLOAT VARIABLES +++++++++++++++++++++++++++++++++++++++++++++++++++++

cam_4x4_X = 106.0
cam_4x4_y = -1242.0
cam_4x4_z = 35.5

theta = 0.0
circle_x = 128.0
circle_y = -1180.75

circle_radius = 8.0

z_cone = -100.0

x_cone_1 = 108.8
y_cone_1 = -1232.9 

x_cone_2 = 120.25
y_cone_2 = -1230.6 

x_cone_3 = 111.2
y_cone_3 = -1219.7 

x_cone_4 = 138.6
y_cone_4 = -1211.8 

x_cone_5 = 138.6
y_cone_5 = -1207.2 

x_cone_6 = 141.6
y_cone_6 = -1207.2 

x_cone_7 = 141.6
y_cone_7 = -1211.8 

x_cone_8 = 144.6
y_cone_8 = -1207.2 

x_cone_9 = 147.6
y_cone_9 = -1207.2 

x_cone_10 = 113.25
y_cone_10 = -1146.5 

x_cone_11 = 113.25
y_cone_11 = -1149.5 

x_cone_12 = 113.25
y_cone_12 = -1155.5 

x_cone_13 = 109.25
y_cone_13 = -1155.5 

x_cone_14 = 121.25
y_cone_14 = -1155.5 

x_cone_15 = 117.25
y_cone_15 = -1155.5 
/*
x_cone_16
y_cone_16  

x_cone_17
y_cone_17  

x_cone_18
y_cone_18  

x_cone_19
y_cone_19  

x_cone_20
y_cone_20  

x_cone_21
y_cone_21  

x_cone_22
y_cone_22  

x_cone_23
y_cone_23  

x_cone_24
y_cone_24  
*/
x_1 = 108.8    
y_1 = -1228.8
z_1 = 33.7

x_2 = 112.6    
y_2 = -1232.9
z_2 = 33.7

x_3 = 140.3   
y_3 = -1209.5 
z_3 = 31.5

x_4 = 108.8   
y_4 = -1147.5 
z_4 = 31.5

x_5 = 131.5   
y_5 = -1182.9 
z_5 = 31.5

/*
x_6 = 192.2 
y_6 = -1301.0 
z_6 = 10.6

x_7 = 246.0   
y_7 = -1428.6 
z_7 = 11.0

x_8 = 211.8   
y_8 = -1492.8 
z_8 = 11.5 

x_9 = -210.0   
y_9 = -1280.5 
z_9 = 11.0

x_10 = 119.3   
y_10 = -1617.2 
z_10 = 10.5

x_11 = 45.0   
y_11 = -1623.2
z_11 = 7.4

x_12 = -90.4 
y_12 = -1594.9 
z_12 = 11.3

x_13 = -159.3    
y_13 = -1499.3
z_13 = 10.7

x_14 = -181.7      
y_14 = -1217.4
z_14 = 10.4

x_15 = -59.8  
y_15 = -1164.8
z_15 = 10.4


x_16 = -49.1    
y_16 = -1084.3
z_16 = 10.4


x_17 = 4.7    
y_17 = -1086.4
z_17 = 10.6


x_19 = -161.2    
y_19 = -1389.3
z_19 = 10.4

x_20 = 6.8  
y_20 = -1162.0
z_20 = 10.6

x_21 = 206.0  
y_21 = -1210.4
z_21 = 11.3

x_22 = 227.7  
y_22 = -1320.0
z_22 = 10.7

IF flag_launch_4x4_1_ok = 2
	x_18 = 7.5   
	y_18 = -1244.8 
	z_18 = 17.0
	
	x_23 = 255.75  
	y_23 = -957.0
	z_23 = 17.0
	
	x_24 = 228.5  
	y_24 = -1148.8
	z_24 = 11.0
ELSE
	x_18 = 16.6   
	y_18 = -1204.2 
	z_18 = 10.4
	
	x_23 = 262.3  
	y_23 = -945.2
	z_23 = 10.8
	
	x_24 = 220.8  
	y_24 = -1144.3
	z_24 = 16.0
ENDIF
*/
//Mission Script 
{
SET_PLAYER_CONTROL player1 off
SWITCH_WIDESCREEN on 

STORE_WANTED_LEVEL player1 wanted_4x4
CLEAR_WANTED_LEVEL player1
STORE_CAR_PLAYER_IS_IN player1 player_4x4
IF NOT IS_CAR_DEAD player_4x4
	LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
ENDIF

CLEAR_THIS_PRINT M_PASS
CLEAR_THIS_PRINT M_FAIL 

REQUEST_MODEL trafficcone
WHILE NOT HAS_MODEL_LOADED trafficcone
	WAIT 0
ENDWHILE

ADD_BLIP_FOR_COORD x_1 y_1 z_1 blip_1
ADD_BLIP_FOR_COORD x_2 y_2 z_2 blip_2
ADD_BLIP_FOR_COORD x_3 y_3 z_3 blip_3
ADD_BLIP_FOR_COORD x_4 y_4 z_4 blip_4
ADD_BLIP_FOR_COORD x_5 y_5 z_5 blip_5

WHILE counter_4x4_pickups < 5

	WAIT 0

	IF flag_timer = 1
		IF timer_4x4 < 1
			PRINT_NOW (taxi2) 3000 1
			GOTO mission_carpark1_failed
		ENDIF
	ENDIF
	
	IF counter_4x4_pickups = 1
	AND flag_timer = 0
		DISPLAY_ONSCREEN_TIMER timer_4x4 TIMER_DOWN
		timera = 0
		flag_timer = 1
	ENDIF


	IF flag_blip_1 = 0
		DRAW_CORONA x_1 y_1 z_1 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_1 y_1 z_1 2.5 2.5 3.5 false
			REMOVE_BLIP blip_1
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_1 y_1 z_1 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_1 = 1
			//PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_2 = 0
		DRAW_CORONA x_2 y_2 z_2 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_2 y_2 z_2 2.5 2.5 3.5 false
			REMOVE_BLIP blip_2
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_2 y_2 z_2 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_2 = 1
			//PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_3 = 0
		DRAW_CORONA x_3 y_3 z_3 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_3 y_3 z_3 2.5 2.5 3.5 false
			REMOVE_BLIP blip_3
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_3 y_3 z_3 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_3 = 1
			//PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_4 = 0
		DRAW_CORONA x_4 y_4 z_4 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_4 y_4 z_4 2.5 2.5 3.5 false
			REMOVE_BLIP blip_4
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_4 y_4 z_4 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_4 = 1
			//PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_5 = 0
		DRAW_CORONA x_5 y_5 z_5 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_5 y_5 z_5 2.5 2.5 3.5 false
			REMOVE_BLIP blip_5
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_5 y_5 z_5 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_5 = 1
			//PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	/*
	
	IF flag_blip_6 = 0
		DRAW_CORONA x_6 y_6 z_6 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_6 y_6 z_6 2.5 2.5 3.5 false
			REMOVE_BLIP blip_6
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_6 y_6 z_6 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_6 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_7 = 0
		DRAW_CORONA x_7 y_7 z_7 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_7 y_7 z_7 2.5 2.5 3.5 false
			REMOVE_BLIP blip_7
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_7 y_7 z_7 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_7 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_8 = 0
		DRAW_CORONA x_8 y_8 z_8 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_8 y_8 z_8 2.5 2.5 3.5 false
			REMOVE_BLIP blip_8
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_8 y_8 z_8 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_8 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_9 = 0
		DRAW_CORONA x_9 y_9 z_9 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_9 y_9 z_9 2.5 2.5 3.5 false
			REMOVE_BLIP blip_9
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_9 y_9 z_9 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_9 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_10 = 0
		DRAW_CORONA x_10 y_10 z_10 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_10 y_10 z_10 2.5 2.5 3.5 false
			REMOVE_BLIP blip_10
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_10 y_10 z_10 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_10 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_11 = 0
		DRAW_CORONA x_11 y_11 z_11 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_11 y_11 z_11 2.5 2.5 3.5 false
			REMOVE_BLIP blip_11
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_11 y_11 z_11 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_11 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_12 = 0
		DRAW_CORONA x_12 y_12 z_12 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_12 y_12 z_12 2.5 2.5 3.5 false
			REMOVE_BLIP blip_12
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_12 y_12 z_12 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_12 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_13 = 0
		DRAW_CORONA x_13 y_13 z_13 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_13 y_13 z_13 2.5 2.5 3.5 false
			REMOVE_BLIP blip_13
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_13 y_13 z_13 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_13 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_14 = 0
		DRAW_CORONA x_14 y_14 z_14 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_14 y_14 z_14 2.5 2.5 3.5 false
			REMOVE_BLIP blip_14
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_14 y_14 z_14 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_14 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 

	IF flag_blip_15 = 0
		DRAW_CORONA x_15 y_15 z_15 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_15 y_15 z_15 2.5 2.5 3.5 false
			REMOVE_BLIP blip_15
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_15 y_15 z_15 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_15 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 

	IF flag_blip_16 = 0
		DRAW_CORONA x_16 y_16 z_16 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_16 y_16 z_16 2.5 2.5 3.5 false
			REMOVE_BLIP blip_16
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_16 y_16 z_16 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_16 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_17 = 0
		DRAW_CORONA x_17 y_17 z_17 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_17 y_17 z_17 2.5 2.5 3.5 false
			REMOVE_BLIP blip_17
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_17 y_17 z_17 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_17 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF
	*/ 
	/*
	IF flag_blip_18 = 0
		DRAW_CORONA x_18 y_18 z_18 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_18 y_18 z_18 2.5 2.5 3.5 false
			REMOVE_BLIP blip_18
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_18 y_18 z_18 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_18 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_19 = 0
		DRAW_CORONA x_19 y_19 z_19 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_19 y_19 z_19 2.5 2.5 3.5 false
			REMOVE_BLIP blip_19
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_19 y_19 z_19 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_19 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_20 = 0
		DRAW_CORONA x_20 y_20 z_20 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_20 y_20 z_20 2.5 2.5 3.5 false
			REMOVE_BLIP blip_20
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_20 y_20 z_20 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_20 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_21 = 0
		DRAW_CORONA x_21 y_21 z_21 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_21 y_21 z_21 2.5 2.5 3.5 false
			REMOVE_BLIP blip_21
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_21 y_21 z_21 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_21 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF
	*/ 
	/*
	IF flag_blip_22 = 0
		DRAW_CORONA x_22 y_22 z_22 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_22 y_22 z_22 2.5 2.5 3.5 false
			REMOVE_BLIP blip_22
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_22 y_22 z_22 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_22 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_23 = 0
		DRAW_CORONA x_23 y_23 z_23 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_23 y_23 z_23 2.5 2.5 3.5 false
			REMOVE_BLIP blip_23
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_23 y_23 z_23 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_23 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	
	IF flag_blip_24 = 0
		DRAW_CORONA x_24 y_24 z_24 1.0 CORONATYPE_HEX FLARETYPE_NONE 0 200 200
		IF LOCATE_PLAYER_IN_CAR_3D player1 x_24 y_24 z_24 2.5 2.5 3.5 false
			REMOVE_BLIP blip_24
			++ counter_4x4_pickups
			ADD_ONE_OFF_SOUND x_24 y_24 z_24 SOUND_PART_MISSION_COMPLETE
			timer_4x4 = timer_4x4 + timer_bonus
			flag_blip_24 = 1
			PRINT_WITH_NUMBER_NOW (T4X4_3C) counter_4x4_pickups 3000 1
		ENDIF
	ENDIF 
	*/
	IF flag_intro_carpark1_before = 1
		IF flag_intro_jump = 0
		AND flag_intro > 0
		AND flag_intro < 4
			IF IS_BUTTON_PRESSED PAD1 CROSS
				intro_time_lapsed = 9501
				flag_intro = 3
				flag_intro_jump = 1
			ENDIF
		ENDIF
	ENDIF

	IF flag_intro = 0
		GET_GAME_TIMER timer_intro_start
		SET_FIXED_CAMERA_POSITION cam_4x4_X cam_4x4_y cam_4x4_z 0.0 0.0 0.0
		SET_MUSIC_DOES_FADE FALSE
		DO_FADE 1000 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE

		CREATE_OBJECT trafficcone x_cone_1 y_cone_1 z_cone cone_1
		SET_OBJECT_COLLISION cone_1 true
		SET_OBJECT_DYNAMIC cone_1 true

		CREATE_OBJECT trafficcone x_cone_2 y_cone_2 z_cone cone_2
		SET_OBJECT_COLLISION cone_2 true
		SET_OBJECT_DYNAMIC cone_2 true

		CREATE_OBJECT trafficcone x_cone_3 y_cone_3 z_cone cone_3
		SET_OBJECT_COLLISION cone_3 true
		SET_OBJECT_DYNAMIC cone_3 true

		CREATE_OBJECT trafficcone x_cone_4 y_cone_4 z_cone cone_4
		SET_OBJECT_COLLISION cone_4 true
		SET_OBJECT_DYNAMIC cone_4 true

		CREATE_OBJECT trafficcone x_cone_5 y_cone_5 z_cone cone_5
		SET_OBJECT_COLLISION cone_5 true
		SET_OBJECT_DYNAMIC cone_5 true

		CREATE_OBJECT trafficcone x_cone_6 y_cone_6 z_cone cone_6
		SET_OBJECT_COLLISION cone_6 true
		SET_OBJECT_DYNAMIC cone_6 true

		CREATE_OBJECT trafficcone x_cone_7 y_cone_7 z_cone cone_7
		SET_OBJECT_COLLISION cone_7 true
		SET_OBJECT_DYNAMIC cone_7 true

		CREATE_OBJECT trafficcone x_cone_8 y_cone_8 z_cone cone_8
		SET_OBJECT_COLLISION cone_8 true
		SET_OBJECT_DYNAMIC cone_8 true

		CREATE_OBJECT trafficcone x_cone_9 y_cone_9 z_cone cone_9
		SET_OBJECT_COLLISION cone_9 true
		SET_OBJECT_DYNAMIC cone_9 true

		CREATE_OBJECT trafficcone x_cone_10 y_cone_10 z_cone cone_10
		SET_OBJECT_COLLISION cone_10 true
		SET_OBJECT_DYNAMIC cone_10 true

		CREATE_OBJECT trafficcone x_cone_11 y_cone_11 z_cone cone_11
		SET_OBJECT_COLLISION cone_11 true
		SET_OBJECT_DYNAMIC cone_11 true

		CREATE_OBJECT trafficcone x_cone_12 y_cone_12 z_cone cone_12
		SET_OBJECT_COLLISION cone_12 true
		SET_OBJECT_DYNAMIC cone_12 true

		CREATE_OBJECT trafficcone x_cone_13 y_cone_13 z_cone cone_13
		SET_OBJECT_COLLISION cone_13 true
		SET_OBJECT_DYNAMIC cone_13 true

		CREATE_OBJECT trafficcone x_cone_14 y_cone_14 z_cone cone_14
		SET_OBJECT_COLLISION cone_14 true
		SET_OBJECT_DYNAMIC cone_14 true

		CREATE_OBJECT trafficcone x_cone_15 y_cone_15 z_cone cone_15
		SET_OBJECT_COLLISION cone_15 true
		SET_OBJECT_DYNAMIC cone_15 true

		GOSUB cone_circle
		
		CREATE_OBJECT trafficcone circle_x circle_y z_cone cone_32
		SET_OBJECT_COLLISION cone_32 true
		SET_OBJECT_DYNAMIC cone_32 true
				
		/*
		ADD_BLIP_FOR_COORD x_6 y_6 z_6 blip_6
		ADD_BLIP_FOR_COORD x_7 y_7 z_7 blip_7
		ADD_BLIP_FOR_COORD x_8 y_8 z_8 blip_8
		ADD_BLIP_FOR_COORD x_9 y_9 z_9 blip_9
		ADD_BLIP_FOR_COORD x_10 y_10 z_10 blip_10
		ADD_BLIP_FOR_COORD x_11 y_11 z_11 blip_11
		ADD_BLIP_FOR_COORD x_12 y_12 z_12 blip_12
		ADD_BLIP_FOR_COORD x_13 y_13 z_13 blip_13
		ADD_BLIP_FOR_COORD x_14 y_14 z_14 blip_14
		ADD_BLIP_FOR_COORD x_15 y_15 z_15 blip_15
		ADD_BLIP_FOR_COORD x_16 y_16 z_16 blip_16
		ADD_BLIP_FOR_COORD x_17 y_17 z_17 blip_17
		ADD_BLIP_FOR_COORD x_18 y_18 z_18 blip_18
		ADD_BLIP_FOR_COORD x_19 y_19 z_19 blip_19
		ADD_BLIP_FOR_COORD x_20 y_20 z_20 blip_20
		ADD_BLIP_FOR_COORD x_21 y_21 z_21 blip_21
		ADD_BLIP_FOR_COORD x_22 y_22 z_22 blip_22
		ADD_BLIP_FOR_COORD x_23 y_23 z_23 blip_23
		ADD_BLIP_FOR_COORD x_24 y_24 z_24 blip_24
		*/

		LOAD_SCENE cam_4x4_X cam_4x4_y cam_4x4_z
		POINT_CAMERA_AT_POINT x_2 y_2 z_2 JUMP_CUT
		DO_FADE 1000 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		PRINT_NOW (MM_1_A) 5000 1 
		flag_intro = 1
	ENDIF

	IF flag_intro_jump = 0
		GET_GAME_TIMER timer_intro_now
		intro_time_lapsed = timer_intro_now - timer_intro_start
	ENDIF
	
	IF intro_time_lapsed > 4000
	AND flag_intro = 1
		SET_FIXED_CAMERA_POSITION 156.3 -1220.1 34.0 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT x_3 y_3 z_3 JUMP_CUT
		flag_intro = 2
	ENDIF
	
	IF intro_time_lapsed > 7000
	AND flag_intro = 2
		SET_FIXED_CAMERA_POSITION 106.5 -1139.0 38.13 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT x_4 y_4 z_4 JUMP_CUT
		PRINT_WITH_NUMBER_NOW (MM_1_C) print_bonus 5000 1
		flag_intro = 3
	ENDIF
	

	IF intro_time_lapsed > 9500
	AND flag_intro = 3
		DO_FADE 1000 FADE_OUT
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		CLEAR_PRINTS
		//GET_PLAYER_COORDINATES player1 player_x player_y player_z
		//LOAD_SCENE player_x player_y player_z
		RESTORE_CAMERA_JUMPCUT
		SWITCH_WIDESCREEN off
		SET_PLAYER_CONTROL player1 on
		IF NOT IS_CAR_DEAD player_4x4
			LOCK_CAR_DOORS player_4x4 CARLOCK_UNLOCKED
		ENDIF
		ALTER_WANTED_LEVEL player1 wanted_4x4
		DO_FADE 1000 FADE_IN
		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE
		SET_MUSIC_DOES_FADE TRUE
		flag_intro = 4
		flag_intro_carpark1_before = 1
	ENDIF
	
	
	IF NOT IS_PLAYER_IN_MODEL player1 STALLION
		PRINT_NOW (T4x4_F) 3000 1
		GOTO mission_carpark1_failed
	ENDIF

	GOSUB cone_check
	
	IF flag_cone_smashed = 1
		PRINT_NOW (CONE_1) 5000 1
		GOTO mission_carpark1_failed
	ENDIF

ENDWHILE

IF counter_4x4_pickups = 5
	GOTO mission_carpark1_passed
ENDIF 

// --------------------------Mission failed-----------------------------------------------

mission_carpark1_failed:


PRINT_BIG ( M_FAIL ) 2000 1


RETURN
   




// -------------------------Mission passed-------------------------------------------------

mission_carpark1_passed:

IF flag_carpark1_passed = 0
	record_carpark1 = timera
	record_carpark1 = record_carpark1 / 1000
	REGISTER_FASTEST_TIME 19 record_carpark1
	GOSUB car_park_record
ENDIF

IF flag_carpark1_passed = 1
	record_temp = timera
	record_temp = record_temp / 1000
	
	IF record_temp < record_carpark1
		record_carpark1 = record_temp
		REGISTER_FASTEST_TIME 19 record_carpark1
		//car_park_reward = car_park_reward * 2 // SCFIX: remove big money abuse
		GOSUB car_park_record
	ELSE 
		PRINT_WITH_NUMBER_BIG ( M_PASS ) 200 5000 1 //"Mission Passed!"
		ADD_SCORE player1 200
	ENDIF
ENDIF


CLEAR_WANTED_LEVEL player1
//REGISTER_4X4_THREE_TIME record_4x4_three

IF flag_carpark1_passed = 0
	REGISTER_ODDJOB_MISSION_PASSED                                                                      
	flag_carpark1_passed = 1
	PLAYER_MADE_PROGRESS 1 
ENDIF

//START_NEW_SCRIPT t4x4_mission2_loop
//START_NEW_SCRIPT multistorey_mission_loop

RETURN
		


// mission cleanup

mission_cleanup_carpark1:

RESTORE_CAMERA_JUMPCUT
SWITCH_WIDESCREEN off
SET_PLAYER_CONTROL player1 on

REMOVE_BLIP blip_1
REMOVE_BLIP blip_2
REMOVE_BLIP blip_3
REMOVE_BLIP blip_4
REMOVE_BLIP blip_5
/*
REMOVE_BLIP blip_6
REMOVE_BLIP blip_7
REMOVE_BLIP blip_8
REMOVE_BLIP blip_9
REMOVE_BLIP blip_10
REMOVE_BLIP blip_11
REMOVE_BLIP blip_12
REMOVE_BLIP blip_13
REMOVE_BLIP blip_14
REMOVE_BLIP blip_15
REMOVE_BLIP blip_16
REMOVE_BLIP blip_17
REMOVE_BLIP blip_18
REMOVE_BLIP blip_19
REMOVE_BLIP blip_20
REMOVE_BLIP blip_21
REMOVE_BLIP blip_22
REMOVE_BLIP blip_23
REMOVE_BLIP blip_24
*/
GOSUB delete_cones

MARK_MODEL_AS_NO_LONGER_NEEDED trafficcone

CLEAR_ONSCREEN_TIMER timer_4x4
flag_player_on_mission = 0

//flag_player_on_4x4_mission = 0

MISSION_HAS_FINISHED
RETURN

cone_circle:

	inner_circle:

	SIN theta cone_x
	cone_x = cone_x * circle_radius
	cone_x = cone_x + circle_x
	COS theta cone_y
	cone_y = cone_y * circle_radius
	cone_y = cone_y + circle_y

	IF theta = 0.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_16
		SET_OBJECT_COLLISION cone_16 true
		SET_OBJECT_DYNAMIC cone_16 true
	ENDIF

	IF theta = 18.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_17
		SET_OBJECT_COLLISION cone_17 true
		SET_OBJECT_DYNAMIC cone_17 true
	ENDIF

	IF theta = 36.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_18
		SET_OBJECT_COLLISION cone_18 true
		SET_OBJECT_DYNAMIC cone_18 true
	ENDIF

	IF theta = 54.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_19
		SET_OBJECT_COLLISION cone_19 true
		SET_OBJECT_DYNAMIC cone_19 true
	ENDIF

	IF theta = 72.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_20
		SET_OBJECT_COLLISION cone_20 true
		SET_OBJECT_DYNAMIC cone_20 true
	ENDIF

	IF theta = 90.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_21
		SET_OBJECT_COLLISION cone_21 true
		SET_OBJECT_DYNAMIC cone_21 true
	ENDIF

	IF theta = 108.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_22
		SET_OBJECT_COLLISION cone_22 true
		SET_OBJECT_DYNAMIC cone_22 true
	ENDIF

	IF theta = 126.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_23
		SET_OBJECT_COLLISION cone_23 true
		SET_OBJECT_DYNAMIC cone_23 true
	ENDIF

	IF theta = 144.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_24
		SET_OBJECT_COLLISION cone_24 true
		SET_OBJECT_DYNAMIC cone_24 true
	ENDIF

	IF theta = 162.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_25
		SET_OBJECT_COLLISION cone_25 true
		SET_OBJECT_DYNAMIC cone_25 true
	ENDIF

	IF theta = 180.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_26
		SET_OBJECT_COLLISION cone_26 true
		SET_OBJECT_DYNAMIC cone_26 true
	ENDIF

	IF theta = 198.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_27
		SET_OBJECT_COLLISION cone_27 true
		SET_OBJECT_DYNAMIC cone_27 true
	ENDIF

	IF theta = 216.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_28
		SET_OBJECT_COLLISION cone_28 true
		SET_OBJECT_DYNAMIC cone_28 true
	ENDIF

	IF theta = 234.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_29
		SET_OBJECT_COLLISION cone_29 true
		SET_OBJECT_DYNAMIC cone_29 true
	ENDIF

	IF theta = 252.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_30
		SET_OBJECT_COLLISION cone_30 true
		SET_OBJECT_DYNAMIC cone_30 true
	ENDIF

	IF theta = 270.0
		CREATE_OBJECT trafficcone cone_x cone_y z_cone cone_31
		SET_OBJECT_COLLISION cone_31 true
		SET_OBJECT_DYNAMIC cone_31 true
	ENDIF
	
	theta = theta + 18.0
	IF theta < 288.0
		GOTO inner_circle
	ENDIF

RETURN

cone_check:

	IF HAS_OBJECT_BEEN_DAMAGED cone_1
	OR HAS_OBJECT_BEEN_DAMAGED cone_2
	OR HAS_OBJECT_BEEN_DAMAGED cone_3
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_4
	OR HAS_OBJECT_BEEN_DAMAGED cone_5
	OR HAS_OBJECT_BEEN_DAMAGED cone_6
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_7
	OR HAS_OBJECT_BEEN_DAMAGED cone_8
	OR HAS_OBJECT_BEEN_DAMAGED cone_9
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_10
	OR HAS_OBJECT_BEEN_DAMAGED cone_11
	OR HAS_OBJECT_BEEN_DAMAGED cone_12
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_13
	OR HAS_OBJECT_BEEN_DAMAGED cone_14
	OR HAS_OBJECT_BEEN_DAMAGED cone_15
		flag_cone_smashed = 1
	ENDIF
	
	IF HAS_OBJECT_BEEN_DAMAGED cone_16
	OR HAS_OBJECT_BEEN_DAMAGED cone_17
	OR HAS_OBJECT_BEEN_DAMAGED cone_18
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_19
	OR HAS_OBJECT_BEEN_DAMAGED cone_20
	OR HAS_OBJECT_BEEN_DAMAGED cone_21
		flag_cone_smashed = 1
	ENDIF
	
	IF HAS_OBJECT_BEEN_DAMAGED cone_22
	OR HAS_OBJECT_BEEN_DAMAGED cone_23
	OR HAS_OBJECT_BEEN_DAMAGED cone_24
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_25
	OR HAS_OBJECT_BEEN_DAMAGED cone_26
	OR HAS_OBJECT_BEEN_DAMAGED cone_27
		flag_cone_smashed = 1
	ENDIF
	
	IF HAS_OBJECT_BEEN_DAMAGED cone_28
	OR HAS_OBJECT_BEEN_DAMAGED cone_29
	OR HAS_OBJECT_BEEN_DAMAGED cone_30
		flag_cone_smashed = 1
	ENDIF
	IF HAS_OBJECT_BEEN_DAMAGED cone_31
	OR HAS_OBJECT_BEEN_DAMAGED cone_32
	//OR HAS_OBJECT_BEEN_DAMAGED cone_27
		flag_cone_smashed = 1
	ENDIF

RETURN


delete_cones:

	DELETE_OBJECT cone_1
	DELETE_OBJECT cone_2
	DELETE_OBJECT cone_3
	DELETE_OBJECT cone_4
	DELETE_OBJECT cone_5
	DELETE_OBJECT cone_6
	DELETE_OBJECT cone_7
	DELETE_OBJECT cone_8
	DELETE_OBJECT cone_9
	DELETE_OBJECT cone_10
	DELETE_OBJECT cone_11
	DELETE_OBJECT cone_12
	DELETE_OBJECT cone_13
	DELETE_OBJECT cone_14
	DELETE_OBJECT cone_15
	DELETE_OBJECT cone_16
	DELETE_OBJECT cone_17
	DELETE_OBJECT cone_18
	DELETE_OBJECT cone_19
	DELETE_OBJECT cone_20
	DELETE_OBJECT cone_21
	DELETE_OBJECT cone_22
	DELETE_OBJECT cone_23
	DELETE_OBJECT cone_24
	DELETE_OBJECT cone_25
	DELETE_OBJECT cone_26
	DELETE_OBJECT cone_27
	DELETE_OBJECT cone_28
	DELETE_OBJECT cone_29
	DELETE_OBJECT cone_30
	DELETE_OBJECT cone_31
	DELETE_OBJECT cone_32

RETURN

car_park_record:
	cp_minutes = 0
	cp_seconds = record_carpark1
	womble:
	IF cp_seconds > 59
		cp_seconds = cp_seconds - 60
		++ cp_minutes
		GOTO womble
	ENDIF
	PRINT_WITH_2_NUMBERS_NOW NEW_REC cp_minutes cp_seconds 5000 1
	timer_bonus = timer_bonus - 1000
	IF timer_bonus < 6000
		timer_bonus = 6000
	ENDIF 
	-- print_bonus
	IF print_bonus < 6
		print_bonus = 6
	ENDIF 
	PRINT_WITH_NUMBER_BIG ( M_PASS ) car_park_reward 5000 1 //"Mission Passed!"
	ADD_SCORE player1 car_park_reward

RETURN

}

// ************************************* MAIN.SC STUFF ***************************************
/*



// 4x4/carpark Missions

VAR_INT	flag_4x4_mission1_passed flag_4x4_mission2_passed flag_4x4_mission3_passed flag_mayhem_mission1_passed
VAR_INT flag_4x4one_trigger flag_4x4two_trigger flag_4x4three_trigger flag_mayhem_trigger
VAR_INT record_4x4_one record_4x4_two record_4x4_three record_mayhem record_temp
VAR_INT flag_intro1_before flag_intro2_before flag_intro3_before flag_intro_carpark1_before
VAR_INT flag_carpark1_passed record_carpark1 flag_carpark1_trigger

flag_intro1_before = 0
flag_intro2_before = 0
flag_intro3_before = 0
flag_intro_carpark1_before = 0
flag_4x4_mission1_passed = 0
flag_4x4_mission2_passed = 0
flag_4x4_mission3_passed = 0
flag_carpark1_passed = 0
flag_4x4one_trigger = 0
flag_4x4two_trigger = 0
flag_4x4three_trigger = 0
flag_carpark1_trigger	= 0
flag_launch_4x4_1_ok = 0


START_NEW_SCRIPT carpark1_loop



carpark1_loop:
{
SCRIPT_NAME multi 

carpark1_loop_inner:
	
	
	WAIT mission_trigger_wait_time

	IF flag_carpark1_passed = 0
		record_carpark1 = 120
	ENDIF
	 
	IF IS_PLAYER_PLAYING player1

		IF flag_player_on_mission = 0
		//AND IS_PLAYER_IN_ZONE player1 COM_EAS

			IF IS_PLAYER_IN_MODEL player1 STALLION
			AND NOT IS_PLAYER_IN_AREA_3D player1 125.0 -1155.0 27.0 130.0 -1160.0 33.0 false
				flag_carpark1_trigger = 1
			ENDIF

			IF IS_PLAYER_IN_MODEL player1 STALLION
			AND flag_carpark1_trigger = 0
				PRINT_BIG ( MM_1 ) 15000 2
				WAIT 0
				LOAD_AND_LAUNCH_MISSION carpark_1.sc	//	ask James about the fades in this one?
			ENDIF

			IF IS_PLAYER_PLAYING player1
				IF NOT IS_PLAYER_IN_ANY_CAR player1
					flag_carpark1_trigger = 0
				ENDIF
			ENDIF

		ENDIF

	ENDIF
	 
	GOTO carpark1_loop_inner

}


*/