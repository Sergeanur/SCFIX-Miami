MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************** KickStart Bike Trials ********************************
// ********************************** Dirtring Dirt Ring DirtRing	    ********************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME kickst

// Mission start stuff

GOSUB mission_start_kickstart

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_kickstart_failed
ENDIF

GOSUB mission_cleanup_kickstart

MISSION_END

// Variables for mission

VAR_INT player_checkpoint_kickstart // number of checkpoints that the player has completed

VAR_INT time_now_ks // time recorded for falling off of bike

VAR_INT time_off_bike_ks // time player has been off of bike 

VAR_INT time_bailed_ks  // time player fell off

VAR_INT time_left_to_find_bike_ks  // timer player has left to find bike

VAR_INT	time_left_to_find_bike_secs_ks // timer player has left to find bike in seconds

// timer stuff

VAR_INT race_timer_kickstart // time taken

// Checkpoint1 small jump over 3 burnt out cars

VAR_FLOAT checkpoint1_x_kickstart

VAR_FLOAT checkpoint1_y_kickstart

VAR_FLOAT checkpoint1_z_kickstart

VAR_INT flag_done_checkpoint1_kickstart

VAR_INT checkpoint1_blip_kickstart

// Checkpoint 2 // fire jump on left hand side

VAR_FLOAT checkpoint2_x_kickstart

VAR_FLOAT checkpoint2_y_kickstart

VAR_FLOAT checkpoint2_z_kickstart

VAR_INT flag_done_checkpoint2_kickstart

VAR_INT checkpoint2_blip_kickstart

// Checkpoint 3 placed in the middle of a small pile of cars left hand side

VAR_FLOAT checkpoint3_x_kickstart

VAR_FLOAT checkpoint3_y_kickstart

VAR_FLOAT checkpoint3_z_kickstart

VAR_INT flag_done_checkpoint3_kickstart

VAR_INT checkpoint3_blip_kickstart

// Checkpoint 4 ontop of first bus

VAR_FLOAT checkpoint4_x_kickstart

VAR_FLOAT checkpoint4_y_kickstart

VAR_FLOAT checkpoint4_z_kickstart

VAR_INT flag_done_checkpoint4_kickstart

VAR_INT checkpoint4_blip_kickstart

// Checkpoint 5 on top of second bus

VAR_FLOAT checkpoint5_x_kickstart

VAR_FLOAT checkpoint5_y_kickstart

VAR_FLOAT checkpoint5_z_kickstart

VAR_INT flag_done_checkpoint5_kickstart

VAR_INT checkpoint5_blip_kickstart

// Checkpoint 6 second fire jump in teh middle of the course

VAR_FLOAT checkpoint6_x_kickstart

VAR_FLOAT checkpoint6_y_kickstart

VAR_FLOAT checkpoint6_z_kickstart

VAR_INT flag_done_checkpoint6_kickstart

VAR_INT checkpoint6_blip_kickstart

// Checkpoint 7 loop the loop right hand side of middle fire jump

VAR_FLOAT checkpoint7_x_kickstart

VAR_FLOAT checkpoint7_y_kickstart

VAR_FLOAT checkpoint7_z_kickstart

VAR_INT flag_done_checkpoint7_kickstart

VAR_INT checkpoint7_blip_kickstart

// Checkpoint 8 ontop of pile of cars by bus jump

VAR_FLOAT checkpoint8_x_kickstart

VAR_FLOAT checkpoint8_y_kickstart

VAR_FLOAT checkpoint8_z_kickstart

VAR_INT flag_done_checkpoint8_kickstart

VAR_INT checkpoint8_blip_kickstart

// Checkpoint 9 on top of second pile of cars by bus jump

VAR_FLOAT checkpoint9_x_kickstart

VAR_FLOAT checkpoint9_y_kickstart

VAR_FLOAT checkpoint9_z_kickstart

VAR_INT flag_done_checkpoint9_kickstart

VAR_INT checkpoint9_blip_kickstart

// Checkpoint 10

VAR_FLOAT checkpoint10_x_kickstart

VAR_FLOAT checkpoint10_y_kickstart

VAR_FLOAT checkpoint10_z_kickstart

VAR_INT flag_done_checkpoint10_kickstart

VAR_INT checkpoint10_blip_kickstart

// Checkpoint 11

VAR_FLOAT checkpoint11_x_kickstart

VAR_FLOAT checkpoint11_y_kickstart

VAR_FLOAT checkpoint11_z_kickstart

VAR_INT flag_done_checkpoint11_kickstart

VAR_INT checkpoint11_blip_kickstart

// Checkpoint 12

VAR_FLOAT checkpoint12_x_kickstart

VAR_FLOAT checkpoint12_y_kickstart

VAR_FLOAT checkpoint12_z_kickstart

VAR_INT flag_done_checkpoint12_kickstart

VAR_INT checkpoint12_blip_kickstart

// Checkpoint 13

VAR_FLOAT checkpoint13_x_kickstart

VAR_FLOAT checkpoint13_y_kickstart

VAR_FLOAT checkpoint13_z_kickstart

VAR_INT flag_done_checkpoint13_kickstart

VAR_INT checkpoint13_blip_kickstart

// Checkpoint 14

VAR_FLOAT checkpoint14_x_kickstart

VAR_FLOAT checkpoint14_y_kickstart

VAR_FLOAT checkpoint14_z_kickstart

VAR_INT flag_done_checkpoint14_kickstart

VAR_INT checkpoint14_blip_kickstart

// Checkpoint 15

VAR_FLOAT checkpoint15_x_kickstart

VAR_FLOAT checkpoint15_y_kickstart

VAR_FLOAT checkpoint15_z_kickstart

VAR_INT flag_done_checkpoint15_kickstart

VAR_INT checkpoint15_blip_kickstart

// Checkpoint 16

VAR_FLOAT checkpoint16_x_kickstart

VAR_FLOAT checkpoint16_y_kickstart

VAR_FLOAT checkpoint16_z_kickstart

VAR_INT flag_done_checkpoint16_kickstart

VAR_INT checkpoint16_blip_kickstart

// Checkpoint 17

VAR_FLOAT checkpoint17_x_kickstart

VAR_FLOAT checkpoint17_y_kickstart

VAR_FLOAT checkpoint17_z_kickstart

VAR_INT flag_done_checkpoint17_kickstart

VAR_INT checkpoint17_blip_kickstart

// Checkpoint 18

VAR_FLOAT checkpoint18_x_kickstart

VAR_FLOAT checkpoint18_y_kickstart

VAR_FLOAT checkpoint18_z_kickstart

VAR_INT flag_done_checkpoint18_kickstart

VAR_INT checkpoint18_blip_kickstart

// Checkpoint 19

VAR_FLOAT checkpoint19_x_kickstart

VAR_FLOAT checkpoint19_y_kickstart

VAR_FLOAT checkpoint19_z_kickstart

VAR_INT flag_done_checkpoint19_kickstart

VAR_INT checkpoint19_blip_kickstart

// Checkpoint 20

VAR_FLOAT checkpoint20_x_kickstart

VAR_FLOAT checkpoint20_y_kickstart

VAR_FLOAT checkpoint20_z_kickstart

VAR_INT flag_done_checkpoint20_kickstart

VAR_INT checkpoint20_blip_kickstart

// Checkpoint 21

VAR_FLOAT checkpoint21_x_kickstart

VAR_FLOAT checkpoint21_y_kickstart

VAR_FLOAT checkpoint21_z_kickstart

VAR_INT flag_done_checkpoint21_kickstart

VAR_INT checkpoint21_blip_kickstart

// Checkpoint 22

VAR_FLOAT checkpoint22_x_kickstart

VAR_FLOAT checkpoint22_y_kickstart

VAR_FLOAT checkpoint22_z_kickstart

VAR_INT flag_done_checkpoint22_kickstart

VAR_INT checkpoint22_blip_kickstart

// Checkpoint 23

VAR_FLOAT checkpoint23_x_kickstart

VAR_FLOAT checkpoint23_y_kickstart

VAR_FLOAT checkpoint23_z_kickstart

VAR_INT flag_done_checkpoint23_kickstart

VAR_INT checkpoint23_blip_kickstart

// Checkpoint 24

VAR_FLOAT checkpoint24_x_kickstart

VAR_FLOAT checkpoint24_y_kickstart

VAR_FLOAT checkpoint24_z_kickstart

VAR_INT flag_done_checkpoint24_kickstart

VAR_INT checkpoint24_blip_kickstart

// Checkpoint 25

VAR_FLOAT checkpoint25_x_kickstart

VAR_FLOAT checkpoint25_y_kickstart

VAR_FLOAT checkpoint25_z_kickstart

VAR_INT flag_done_checkpoint25_kickstart

VAR_INT checkpoint25_blip_kickstart

// Checkpoint 26

VAR_FLOAT checkpoint26_x_kickstart

VAR_FLOAT checkpoint26_y_kickstart

VAR_FLOAT checkpoint26_z_kickstart

VAR_INT flag_done_checkpoint26_kickstart

VAR_INT checkpoint26_blip_kickstart

// Checkpoint 27

VAR_FLOAT checkpoint27_x_kickstart

VAR_FLOAT checkpoint27_y_kickstart

VAR_FLOAT checkpoint27_z_kickstart

VAR_INT flag_done_checkpoint27_kickstart

VAR_INT checkpoint27_blip_kickstart

// Checkpoint 28

VAR_FLOAT checkpoint28_x_kickstart

VAR_FLOAT checkpoint28_y_kickstart

VAR_FLOAT checkpoint28_z_kickstart

VAR_INT flag_done_checkpoint28_kickstart

VAR_INT checkpoint28_blip_kickstart

// Checkpoint 29

VAR_FLOAT checkpoint29_x_kickstart

VAR_FLOAT checkpoint29_y_kickstart

VAR_FLOAT checkpoint29_z_kickstart

VAR_INT flag_done_checkpoint29_kickstart

VAR_INT checkpoint29_blip_kickstart

// Checkpoint 30

VAR_FLOAT checkpoint30_x_kickstart

VAR_FLOAT checkpoint30_y_kickstart

VAR_FLOAT checkpoint30_z_kickstart

VAR_INT flag_done_checkpoint30_kickstart

VAR_INT checkpoint30_blip_kickstart

// Checkpoint 31

VAR_FLOAT checkpoint31_x_kickstart

VAR_FLOAT checkpoint31_y_kickstart

VAR_FLOAT checkpoint31_z_kickstart

VAR_INT flag_done_checkpoint31_kickstart

VAR_INT checkpoint31_blip_kickstart

// Checkpoint 32

VAR_FLOAT checkpoint32_x_kickstart

VAR_FLOAT checkpoint32_y_kickstart

VAR_FLOAT checkpoint32_z_kickstart

VAR_INT flag_done_checkpoint32_kickstart

VAR_INT checkpoint32_blip_kickstart

// Timer stuff

VAR_INT race_timer_seconds_kickstart

VAR_INT race_timer_mins_kickstart

VAR_INT race_timer_seconds2_kickstart

VAR_INT player_taken_too_long_kickstart // player has been in the area too long

// Bike stuff

VAR_INT bike_kickstart

VAR_INT flag_bike_blip_on_kickstart 

VAR_INT bike_blip_kickstart

// Blob Stuff

VAR_INT number_of_checkpoints_kickstart

// Dodgy map stuff coords

VAR_FLOAT player_x_kickstart

VAR_FLOAT player_y_kickstart

VAR_FLOAT player_z_kickstart

VAR_FLOAT bike_x_kickstart

VAR_FLOAT bike_y_kickstart

VAR_FLOAT bike_z_kickstart

// player in end area

VAR_INT player_in_end_area_kickstart

VAR_INT sphere_kickstart

// New scoreing system

VAR_INT player_been_rewarded_kickstart

// New audio stuff

VAR_INT audio_flag_cheer_kick // Used when the player has scored 8 checkpoints

VAR_INT audio_flag_ohh_kick // used when the player has falled off of the bike

VAR_INT flag_bike_dead_kickstart

flag_bike_dead_kickstart = 0
		
// ****************************************Mission Start************************************

mission_start_kickstart:

flag_player_on_mission = 1

IF flag_kickstart_passed_1stime = 0
	REGISTER_MISSION_GIVEN
ENDIF

player_checkpoint_kickstart = 0

race_timer_kickstart = 0

time_left_to_find_bike_ks = 30000

// Checkpoint1 small jump over 3 burnt out cars

checkpoint1_x_kickstart = -1484.643

checkpoint1_y_kickstart = 1488.02

checkpoint1_z_kickstart = 302.654

flag_done_checkpoint1_kickstart = 0

// Checkpoint 2 fire jump left hand side

checkpoint2_x_kickstart = -1333.700

checkpoint2_y_kickstart = 1478.770

checkpoint2_z_kickstart = 302.50 //303.50

flag_done_checkpoint2_kickstart = 0

// Checkpoint 3 placed in the middle of a small pile of cars left hand side

checkpoint3_x_kickstart = -1335.735 

checkpoint3_y_kickstart = 1519.111 

checkpoint3_z_kickstart = 300.748

flag_done_checkpoint3_kickstart = 0

// Checkpoint 4 on top of first bus roof

checkpoint4_x_kickstart = -1304.975 

checkpoint4_y_kickstart = 1494.277

checkpoint4_z_kickstart = 302.124 

flag_done_checkpoint4_kickstart = 0

// Checkpoint 5 ontop of the second bus

checkpoint5_x_kickstart = -1302.957

checkpoint5_y_kickstart = 1514.426

checkpoint5_z_kickstart = 302.18

flag_done_checkpoint5_kickstart = 0

// Checkpoint 6 fire jump in middle of course

checkpoint6_x_kickstart = -1388.630

checkpoint6_y_kickstart = 1486.478

checkpoint6_z_kickstart = 305.919

flag_done_checkpoint6_kickstart = 0

// Checkpoint 7 loop the loop right hand side of middle fire jump

checkpoint7_x_kickstart = -1437.116

checkpoint7_y_kickstart = 1434.815

checkpoint7_z_kickstart = 315.836

flag_done_checkpoint7_kickstart = 0

// Checkpoint 8 loop the loop beside fire jump

checkpoint8_x_kickstart = -1417.707

checkpoint8_y_kickstart = 1544.800

checkpoint8_z_kickstart = 302.693

flag_done_checkpoint8_kickstart = 0

// Checkpoint 9 on top of pile of cars by bus jump

checkpoint9_x_kickstart = -1313.301

checkpoint9_y_kickstart = 1502.544

checkpoint9_z_kickstart = 301.162

flag_done_checkpoint9_kickstart = 0

// Checkpoint 10 on top of second pile of cars by bus jump

checkpoint10_x_kickstart = -1312.470

checkpoint10_y_kickstart = 1512.856 

checkpoint10_z_kickstart = 302.067 

flag_done_checkpoint10_kickstart = 0

// Checkpoint 11 wall beside fire jump and bus

checkpoint11_x_kickstart = -1323.204

checkpoint11_y_kickstart = 1492.103

checkpoint11_z_kickstart = 303.936

flag_done_checkpoint11_kickstart = 0

// Checkpoint 12 wall beside fire jump and bus highest one

checkpoint12_x_kickstart = -1323.245

checkpoint12_y_kickstart = 1477.574

checkpoint12_z_kickstart = 305.774

flag_done_checkpoint12_kickstart = 0

// Checkpoint 13 wall opposite fire jump on left by bus

checkpoint13_x_kickstart = -1344.384

checkpoint13_y_kickstart = 1533.452

checkpoint13_z_kickstart = 303.0

flag_done_checkpoint13_kickstart = 0

// Checkpoint 14 track one

checkpoint14_x_kickstart = -1348.278

checkpoint14_y_kickstart = 1511.859

checkpoint14_z_kickstart = 298.644

flag_done_checkpoint14_kickstart = 0

// Checkpoint 15 track two

checkpoint15_x_kickstart = -1378.509 

checkpoint15_y_kickstart = 1509.739

checkpoint15_z_kickstart = 300.0

flag_done_checkpoint15_kickstart = 0

// Checkpoint 16 track three

checkpoint16_x_kickstart = -1388.155

checkpoint16_y_kickstart = 1527.837

checkpoint16_z_kickstart = 300.929

flag_done_checkpoint16_kickstart = 0

// Checkpoint 17 track four

checkpoint17_x_kickstart = -1409.253

checkpoint17_y_kickstart = 1522.967

checkpoint17_z_kickstart = 298.37

flag_done_checkpoint17_kickstart = 0

// Checkpoint 18 track five over jump one

checkpoint18_x_kickstart = -1426.424

checkpoint18_y_kickstart = 1520.959

checkpoint18_z_kickstart = 303.545

flag_done_checkpoint18_kickstart = 0

// Checkpoint 19 track 6

checkpoint19_x_kickstart = -1460.186

checkpoint19_y_kickstart = 1510.866

checkpoint19_z_kickstart = 298.952

flag_done_checkpoint19_kickstart = 0

// Checkpoint 20 behind jump 2 on track7

checkpoint20_x_kickstart = -1460.878

checkpoint20_y_kickstart = 1471.218

checkpoint20_z_kickstart = 298.564

flag_done_checkpoint20_kickstart = 0

// Checkpoint 21 in small dip track8

checkpoint21_x_kickstart = -1429.784 

checkpoint21_y_kickstart = 1451.610

checkpoint21_z_kickstart = 298.27

flag_done_checkpoint21_kickstart = 0

// Checkpoint 22 track9

checkpoint22_x_kickstart = -1400.634

checkpoint22_y_kickstart = 1461.061

checkpoint22_z_kickstart = 298.286

flag_done_checkpoint22_kickstart = 0

// Checkpoint 23  track 10

checkpoint23_x_kickstart = -1425.175

checkpoint23_y_kickstart = 1478.428

checkpoint23_z_kickstart = 301.445

flag_done_checkpoint23_kickstart = 0

// Checkpoint 24 track 11

checkpoint24_x_kickstart = -1414.860

checkpoint24_y_kickstart = 1497.479

checkpoint24_z_kickstart = 302.988

flag_done_checkpoint24_kickstart = 0

// Checkpoint 25 track 12

checkpoint25_x_kickstart = -1379.127

checkpoint25_y_kickstart = 1492.167

checkpoint25_z_kickstart = 302.758

flag_done_checkpoint25_kickstart = 0

// Checkpoint 26 track 13

checkpoint26_x_kickstart = -1366.536

checkpoint26_y_kickstart = 1450.439

checkpoint26_z_kickstart = 299.945

flag_done_checkpoint26_kickstart = 0

// Checkpoint 27 track 14

checkpoint27_x_kickstart = -1346.842

checkpoint27_y_kickstart = 1484.873

checkpoint27_z_kickstart = 299.035

flag_done_checkpoint27_kickstart = 0

// Checkpoint 28 single bus far side of comp

checkpoint28_x_kickstart = -1513.362

checkpoint28_y_kickstart = 1508.387

checkpoint28_z_kickstart = 302.0

flag_done_checkpoint28_kickstart = 0

// Checkpoint 29 single bus far side by two small walls

checkpoint29_x_kickstart = -1493.339

checkpoint29_y_kickstart = 1462.965

checkpoint29_z_kickstart = 302.345

flag_done_checkpoint29_kickstart = 0

// Checkpoint 30 

checkpoint30_x_kickstart = -1509.219

checkpoint30_y_kickstart = 1479.257

checkpoint30_z_kickstart = 301.356

flag_done_checkpoint30_kickstart = 0

// Checkpoint 31 

checkpoint31_x_kickstart = -1484.417

checkpoint31_y_kickstart = 1454.364

checkpoint31_z_kickstart = 303.049

flag_done_checkpoint31_kickstart = 0

// Checkpoint 32 ontop of pile of 3 cars. 

checkpoint32_x_kickstart = -1496.913

checkpoint32_y_kickstart = 1517.326

checkpoint32_z_kickstart = 301.50

flag_done_checkpoint32_kickstart = 0

// Timer stuff

race_timer_seconds_kickstart = 0

race_timer_seconds2_kickstart = 0

race_timer_mins_kickstart = 0

flag_bike_blip_on_kickstart = 0

player_taken_too_long_kickstart = 0

// Number of checkpoint stuff

number_of_checkpoints_kickstart = 32

// dodgy map stuff

player_x_kickstart = 0.0

player_y_kickstart = 0.0

player_z_kickstart = 0.0

bike_x_kickstart = 0.0

bike_y_kickstart = 0.0

bike_z_kickstart = 0.0

// Player in end area

player_in_end_area_kickstart = 0

// New scoreing system

player_been_rewarded_kickstart = 0

// New audio stuff

audio_flag_cheer_kick = 0

audio_flag_ohh_kick = 0

WAIT 0

LOAD_MISSION_TEXT KICKSTT

{

// *************************************** MISSION START ***********************************

SET_PLAYER_CONTROL player1 OFF
SET_PLAYER_IS_IN_STADIUM TRUE
SET_AREA_VISIBLE VIS_DIRT
SET_EXTRA_COLOURS 9 FALSE
LOAD_SCENE -1331.889 1498.615 298.140

// Waiting for the ped models to load

REQUEST_MODEL SANCHEZ

WHILE NOT HAS_MODEL_LOADED SANCHEZ

	WAIT 0
      
ENDWHILE

SET_FIXED_CAMERA_POSITION -1339.475 1448.583 299.939 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1338.617 1449.095 299.894 JUMP_CUT

IF IS_PLAYER_IN_ANY_CAR player1 // SCFIX
	WARP_PLAYER_FROM_CAR_TO_COORD player1 -1333.326 1451.837 298.161 // SCFIX
ELSE // SCFIX
	SET_PLAYER_COORDINATES player1 -1333.326 1451.837 298.161
ENDIF // SCFIX
SET_PLAYER_HEADING player1 0.0
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT

CREATE_CAR SANCHEZ -1331.994 1454.152 298.150 bike_kickstart
SET_CAR_PROOFS bike_kickstart TRUE TRUE TRUE TRUE TRUE
ADD_BLIP_FOR_CAR bike_kickstart bike_blip_kickstart

SET_CAR_STRONG bike_kickstart TRUE

ADD_SPHERE -1445.728 1531.963 301.721 3.0 sphere_kickstart

// creates the checkpoints

DRAW_CORONA checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart 0 BOTH checkpoint1_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint1_blip_kickstart 1

DRAW_CORONA checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart 0 BOTH checkpoint2_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint2_blip_kickstart 1

DRAW_CORONA checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart 0 BOTH checkpoint3_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint3_blip_kickstart 1

DRAW_CORONA checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart 0 BOTH checkpoint4_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint4_blip_kickstart 1

DRAW_CORONA checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart 0 BOTH checkpoint5_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint5_blip_kickstart 1

DRAW_CORONA checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart 0 BOTH checkpoint6_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint6_blip_kickstart 1

DRAW_CORONA checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart 0 BOTH checkpoint7_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint7_blip_kickstart 1
																	  
DRAW_CORONA checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart 0 BOTH checkpoint8_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint8_blip_kickstart 1

DRAW_CORONA checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart 0 BOTH checkpoint9_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint9_blip_kickstart 1

DRAW_CORONA checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart 0 BOTH checkpoint10_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint10_blip_kickstart 1
										
DRAW_CORONA checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart 0 BOTH checkpoint11_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint11_blip_kickstart 1

DRAW_CORONA checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart 0 BOTH checkpoint12_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint12_blip_kickstart 1

DRAW_CORONA checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart 0 BOTH checkpoint13_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint13_blip_kickstart 1

DRAW_CORONA checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart 0 BOTH checkpoint14_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint14_blip_kickstart 1

DRAW_CORONA checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart 0 BOTH checkpoint15_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint15_blip_kickstart 1

DRAW_CORONA checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart 0 BOTH checkpoint16_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint16_blip_kickstart 1

DRAW_CORONA checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart 0 BOTH checkpoint17_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint17_blip_kickstart 1

DRAW_CORONA checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart 0 BOTH checkpoint18_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint18_blip_kickstart 1

DRAW_CORONA checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart 0 BOTH checkpoint19_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint19_blip_kickstart 1

DRAW_CORONA checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart 0 BOTH checkpoint20_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint20_blip_kickstart 1

DRAW_CORONA checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart 0 BOTH checkpoint21_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint21_blip_kickstart 1

DRAW_CORONA checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart 0 BOTH checkpoint22_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint22_blip_kickstart 1

DRAW_CORONA checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart 0 BOTH checkpoint23_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint23_blip_kickstart 1

DRAW_CORONA checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart 0 BOTH checkpoint24_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint24_blip_kickstart 1

DRAW_CORONA checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart 0 BOTH checkpoint25_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint25_blip_kickstart 1

DRAW_CORONA checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart 0 BOTH checkpoint26_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint26_blip_kickstart 1

DRAW_CORONA checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart 0 BOTH checkpoint27_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint27_blip_kickstart 1

DRAW_CORONA checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart 0 BOTH checkpoint28_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint28_blip_kickstart 1

DRAW_CORONA checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart 0 BOTH checkpoint29_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint29_blip_kickstart 1

DRAW_CORONA checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart 0 BOTH checkpoint30_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint30_blip_kickstart 1

DRAW_CORONA checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart 0 BOTH checkpoint31_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint31_blip_kickstart 1

DRAW_CORONA checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
ADD_BLIP_FOR_COORD_OLD checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart 0 BOTH checkpoint32_blip_kickstart 
CHANGE_BLIP_SCALE checkpoint32_blip_kickstart 1

//SWITCH_WIDESCREEN ON
SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON

// fades the screen in

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

SET_FIXED_CAMERA_POSITION -1332.843 1459.140 299.987 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1332.882 1460.137 300.053 JUMP_CUT

WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CAR_DEAD bike_kickstart
		SET_PLAYER_CONTROL player1 OFF
		PRINT_NOW ( KICK1_7 ) 5000 1 //"You have wrecked the bike!"
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

		SET_FADING_COLOUR 0 0 0
		
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed

	ELSE
		SET_CAR_HEALTH bike_kickstart 1000
	ENDIF 
		
	GOSUB checkpoints_kickstart
   	
ENDWHILE

PRINT_NOW ( KICK_10 ) 10000 1 //"Use the Sanchez to complete the course by passing through all of the checkpoints.!

timera = 0

WHILE timera < 7000

	WAIT 0

	IF IS_CAR_DEAD bike_kickstart
		SET_PLAYER_CONTROL player1 OFF
		PRINT_NOW ( KICK1_7 ) 5000 1 //"You have wrecked the bike!"
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed

	ELSE
		SET_CAR_HEALTH bike_kickstart 1000
	ENDIF

	GOSUB checkpoints_kickstart 

ENDWHILE

CLEAR_THIS_PRINT ( KICK_10 )

SET_PLAYER_COORDINATES player1 -1459.980 1532.382 301.478
SET_FIXED_CAMERA_POSITION -1454.861 1526.978 305.908 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -1453.956 1527.388 305.790 JUMP_CUT
PRINT_NOW ( KICK_11 ) 10000 1 //"To leave the mission stand in the pink hilighted area on foot.!

timera = 0

WHILE timera < 7000

	WAIT 0

	IF IS_CAR_DEAD bike_kickstart
		SET_PLAYER_CONTROL player1 OFF
		PRINT_NOW ( KICK1_7 ) 5000 1 //"You have wrecked the bike!"
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed

	ELSE
		SET_CAR_HEALTH bike_kickstart 1000
	ENDIF

	GOSUB checkpoints_kickstart 
		
ENDWHILE

CLEAR_THIS_PRINT ( KICK_11 )

SET_PLAYER_COORDINATES player1 -1333.326 1451.837 298.161
SET_PLAYER_HEADING player1 0.0
SET_CAMERA_BEHIND_PLAYER
RESTORE_CAMERA_JUMPCUT

SWITCH_WIDESCREEN OFF
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF
SET_CAMERA_BEHIND_PLAYER
SET_PLAYER_CONTROL player1 ON
RESTORE_CAMERA_JUMPCUT

PRINT_NOW ( KICK1_8 ) 5000 1 //"Get ont the bike!"

WHILE NOT IS_PLAYER_IN_CAR player1 bike_kickstart

	WAIT 0

	IF IS_CAR_DEAD bike_kickstart
		SET_PLAYER_CONTROL player1 OFF
		PRINT_NOW ( KICK1_7 ) 5000 1 //"You have wrecked the bike!"
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed

	ELSE
		SET_CAR_HEALTH bike_kickstart 1000
	ENDIF

	IF race_timer_kickstart >= 3600000
	OR player_taken_too_long_kickstart = 1
		SET_PLAYER_CONTROL player1 OFF
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		PRINT_NOW ( KICK_13 ) 5000 1 //"You have taken too long!
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE

		GOTO mission_kickstart_failed
	ENDIF
	
	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1445.728 1531.96.33 301.721 3.0 3.0 3.0 FALSE
	OR player_in_end_area_kickstart = 1
		SET_PLAYER_CONTROL player1 OFF
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		PRINT_NOW ( KICK_12 ) 5000 1 //"You bottled it!"
		REMOVE_SPHERE sphere_kickstart

		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed
	ENDIF
		
	
	GOSUB checkpoints_kickstart	
   
ENDWHILE

REMOVE_BLIP bike_blip_kickstart

SET_PLAYER_CONTROL player1 ON

PRINT_NOW ( KICK1_1 ) 5000 1 //"Complete the course!"

DISPLAY_ONSCREEN_COUNTER_WITH_STRING number_of_checkpoints_kickstart COUNTER_DISPLAY_NUMBER ( KICK1_9 )

DISPLAY_ONSCREEN_TIMER_WITH_STRING race_timer_kickstart TIMER_UP ( KICK1_T ) 

timera = 0

// Player started the competition  

WHILE NOT player_checkpoint_kickstart = 32

	WAIT 0

// player collected the checkpoints audio
		
	IF audio_flag_cheer_kick = 0

		IF player_checkpoint_kickstart < 8
			LOAD_MISSION_AUDIO 1 ( cheer1 )
			audio_flag_cheer_kick = 1
		ENDIF

		IF player_checkpoint_kickstart > 8
		AND player_checkpoint_kickstart < 16
			LOAD_MISSION_AUDIO 1 ( cheer2 )
			audio_flag_cheer_kick = 1
		ENDIF

		IF player_checkpoint_kickstart > 16
		AND player_checkpoint_kickstart < 24
			LOAD_MISSION_AUDIO 1 ( cheer3 )
			audio_flag_cheer_kick = 1
		ENDIF
		
		IF player_checkpoint_kickstart > 24
		AND player_checkpoint_kickstart < 32
			LOAD_MISSION_AUDIO 1 ( cheer4 )
			audio_flag_cheer_kick = 1
		ENDIF  
		
	ENDIF

	IF audio_flag_cheer_kick = 1
	
		IF HAS_MISSION_AUDIO_LOADED 1
			audio_flag_cheer_kick = 2
		ENDIF
		
	ENDIF

	IF audio_flag_cheer_kick = 2
	
		IF player_checkpoint_kickstart = 8
			PLAY_MISSION_AUDIO 1
			audio_flag_cheer_kick = 3
		ENDIF

		IF player_checkpoint_kickstart = 16
			PLAY_MISSION_AUDIO 1
			audio_flag_cheer_kick = 3
		ENDIF

		IF player_checkpoint_kickstart = 24
			PLAY_MISSION_AUDIO 1
			audio_flag_cheer_kick = 3
		ENDIF

		IF player_checkpoint_kickstart = 32
			PLAY_MISSION_AUDIO 1
			audio_flag_cheer_kick = 3
		ENDIF
		
	ENDIF
	
	IF audio_flag_cheer_kick = 3
	
		IF HAS_MISSION_AUDIO_FINISHED 1
			audio_flag_cheer_kick = 4
		ENDIF
		
	ENDIF	  

	IF audio_flag_cheer_kick = 4
	   	audio_flag_cheer_kick = 0
	ENDIF
	
// player fallen off of bike audio	 

	IF audio_flag_ohh_kick = 0
		LOAD_MISSION_AUDIO 2 ( ooh1 )
		audio_flag_ohh_kick = 1
	ENDIF
	
	IF audio_flag_ohh_kick = 1
	
		IF HAS_MISSION_AUDIO_LOADED 2
			audio_flag_ohh_kick = 2
		ENDIF
		
	ENDIF

	IF audio_flag_ohh_kick = 3
		HAS_MISSION_AUDIO_FINISHED 2
		audio_flag_ohh_kick = 4
	ENDIF
	
	IF audio_flag_ohh_kick = 4
	   	audio_flag_ohh_kick = 0
	ENDIF 
	 
	IF race_timer_kickstart >= 3600000
	OR player_taken_too_long_kickstart = 1
		SET_PLAYER_CONTROL player1 OFF
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		PRINT_NOW ( KICK_13 ) 5000 1 //"You have taken too long!
		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE

		GOTO mission_kickstart_failed
	ENDIF
	
	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1445.728 1531.96.33 301.721 3.0 3.0 3.0 FALSE
	OR player_in_end_area_kickstart = 1
		SET_PLAYER_CONTROL player1 OFF
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
		PRINT_NOW ( KICK_12 ) 5000 1 //"You bottled it!"
		REMOVE_SPHERE sphere_kickstart

		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed
	ENDIF

	GET_PLAYER_COORDINATES player1 player_x_kickstart player_y_kickstart player_z_kickstart

	IF player_z_kickstart < 290.0
		SET_PLAYER_COORDINATES player1 -1333.326 1451.837 298.161
		SET_PLAYER_HEADING player1 0.0
	ENDIF
		 

	IF IS_CAR_DEAD bike_kickstart
	OR flag_bike_dead_kickstart = 1
		SET_PLAYER_CONTROL player1 OFF
		PRINT_NOW ( KICK1_7 ) 5000 1 //"You have wrecked the bike!"
		PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

		SET_FADING_COLOUR 0 0 0
		DO_FADE 1000 FADE_OUT

		WHILE GET_FADING_STATUS
			
			WAIT 0

		ENDWHILE
		
		GOTO mission_kickstart_failed
	ELSE
				
		SET_CAR_HEALTH bike_kickstart 1000
	
		GET_CAR_COORDINATES bike_kickstart bike_x_kickstart bike_y_kickstart bike_z_kickstart

		IF bike_z_kickstart < 290.0
			SET_CAR_COORDINATES bike_kickstart -1331.994 1454.152 298.150
			SET_CAR_HEADING bike_kickstart 0.0
		ENDIF

	ENDIF

	GOSUB checkpoints_kickstart
      	
	IF flag_done_checkpoint1_kickstart = 0
		DRAW_CORONA checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF
	
	IF flag_done_checkpoint2_kickstart = 0 
		DRAW_CORONA checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint3_kickstart = 0 
		DRAW_CORONA checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint4_kickstart = 0 
		DRAW_CORONA checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint5_kickstart = 0 
		DRAW_CORONA checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint6_kickstart = 0 
		DRAW_CORONA checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF
	
	IF flag_done_checkpoint7_kickstart = 0 
		DRAW_CORONA checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint8_kickstart = 0 
		DRAW_CORONA checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint9_kickstart = 0 
		DRAW_CORONA checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint10_kickstart = 0 
		DRAW_CORONA checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint11_kickstart = 0 
		DRAW_CORONA checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint12_kickstart = 0 
		DRAW_CORONA checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint13_kickstart = 0 
		DRAW_CORONA checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF
	
	IF flag_done_checkpoint14_kickstart = 0 
		DRAW_CORONA checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint15_kickstart = 0 
		DRAW_CORONA checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint16_kickstart = 0 
		DRAW_CORONA checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint17_kickstart = 0 
		DRAW_CORONA checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint18_kickstart = 0 
		DRAW_CORONA checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint19_kickstart = 0 
		DRAW_CORONA checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint20_kickstart = 0 
		DRAW_CORONA checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint21_kickstart = 0 
		DRAW_CORONA checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF
	
	IF flag_done_checkpoint22_kickstart = 0 
		DRAW_CORONA checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint23_kickstart = 0 
		DRAW_CORONA checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint24_kickstart = 0 
		DRAW_CORONA checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint25_kickstart = 0 
		DRAW_CORONA checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint26_kickstart = 0 
		DRAW_CORONA checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint27_kickstart = 0 
		DRAW_CORONA checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint28_kickstart = 0 
		DRAW_CORONA checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint29_kickstart = 0 
		DRAW_CORONA checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint30_kickstart = 0 
		DRAW_CORONA checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint31_kickstart = 0 
		DRAW_CORONA checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF

	IF flag_done_checkpoint32_kickstart = 0 
		DRAW_CORONA checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	ENDIF
		
bike_check_kickstart:

	IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1445.728 1531.96.33 301.721 3.0 3.0 3.0 FALSE
		player_in_end_area_kickstart = 1
	ENDIF

   	IF NOT IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF NOT IS_PLAYER_IN_MODEL player1 SANCHEZ
		
		IF flag_bike_blip_on_kickstart = 0
			ADD_BLIP_FOR_CAR bike_kickstart bike_blip_kickstart

			IF audio_flag_ohh_kick = 2
				PLAY_MISSION_AUDIO 2
				audio_flag_ohh_kick = 3
			ENDIF

			flag_bike_blip_on_kickstart = 1
		ENDIF
	  
		GET_GAME_TIMER time_bailed_ks

		time_left_to_find_bike_ks = 30000
		
		WHILE time_left_to_find_bike_ks > 0
		
			WAIT 0

			IF audio_flag_cheer_kick = 0

				IF player_checkpoint_kickstart < 8
					LOAD_MISSION_AUDIO 1 ( cheer1 )
					audio_flag_cheer_kick = 1
				ENDIF

				IF player_checkpoint_kickstart > 8
				AND player_checkpoint_kickstart < 16
					LOAD_MISSION_AUDIO 1 ( cheer2 )
					audio_flag_cheer_kick = 1
				ENDIF

				IF player_checkpoint_kickstart > 16
				AND player_checkpoint_kickstart < 24
					LOAD_MISSION_AUDIO 1 ( cheer3 )
					audio_flag_cheer_kick = 1
				ENDIF
				
				IF player_checkpoint_kickstart > 24
				AND player_checkpoint_kickstart < 32
					LOAD_MISSION_AUDIO 1 ( cheer4 )
					audio_flag_cheer_kick = 1
				ENDIF  
				
			ENDIF

			IF audio_flag_cheer_kick = 1
			
				IF HAS_MISSION_AUDIO_LOADED 1
					audio_flag_cheer_kick = 2
				ENDIF
				
			ENDIF

			IF audio_flag_cheer_kick = 2
			
				IF player_checkpoint_kickstart = 8
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF

				IF player_checkpoint_kickstart = 16
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF

				IF player_checkpoint_kickstart = 24
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF

				IF player_checkpoint_kickstart = 32
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF
				
			ENDIF
	
			IF audio_flag_cheer_kick = 3
			
				IF HAS_MISSION_AUDIO_FINISHED 1
					audio_flag_cheer_kick = 4
				ENDIF
				
			ENDIF	  

			IF audio_flag_cheer_kick = 4
			   	audio_flag_cheer_kick = 0
			ENDIF
	
// player fallen off of bike audio	 

			IF audio_flag_ohh_kick = 0
				LOAD_MISSION_AUDIO 2 ( ooh1 )
				audio_flag_ohh_kick = 1
			ENDIF
				
			IF audio_flag_ohh_kick = 1
				
				IF HAS_MISSION_AUDIO_LOADED 2
					audio_flag_ohh_kick = 2
				ENDIF
					
			ENDIF

			IF audio_flag_ohh_kick = 3
				HAS_MISSION_AUDIO_FINISHED 2
				audio_flag_ohh_kick = 4
			ENDIF
				
			IF audio_flag_ohh_kick = 4
				audio_flag_ohh_kick = 0
			ENDIF
		   
			IF race_timer_kickstart >= 3600000
			OR player_taken_too_long_kickstart = 1
				SET_PLAYER_CONTROL player1 OFF
				PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
				PRINT_NOW ( KICK_13 ) 5000 1 //"You have taken too long!
				SET_FADING_COLOUR 0 0 0
				DO_FADE 1000 FADE_OUT

				WHILE GET_FADING_STATUS
					
					WAIT 0
										
				ENDWHILE

				GOTO mission_kickstart_failed
			ENDIF
			
			IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1445.728 1531.96.33 301.721 3.0 3.0 3.0 FALSE
			OR player_in_end_area_kickstart = 1
				SET_PLAYER_CONTROL player1 OFF
				PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
				PRINT_NOW ( KICK_12 ) 5000 1 //"You bottled it!"
				REMOVE_SPHERE sphere_kickstart

				SET_FADING_COLOUR 0 0 0
				DO_FADE 1000 FADE_OUT

				WHILE GET_FADING_STATUS
					
					WAIT 0
										
				ENDWHILE
				
				GOTO mission_kickstart_failed
			ENDIF

			IF flag_done_checkpoint1_kickstart = 0
				DRAW_CORONA checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF
	
			IF flag_done_checkpoint2_kickstart = 0 
				DRAW_CORONA checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint3_kickstart = 0 
				DRAW_CORONA checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint4_kickstart = 0 
				DRAW_CORONA checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint5_kickstart = 0 
				DRAW_CORONA checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint6_kickstart = 0 
				DRAW_CORONA checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF
			
			IF flag_done_checkpoint7_kickstart = 0 
				DRAW_CORONA checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint8_kickstart = 0 
				DRAW_CORONA checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint9_kickstart = 0 
				DRAW_CORONA checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint10_kickstart = 0 
				DRAW_CORONA checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint11_kickstart = 0 
				DRAW_CORONA checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint12_kickstart = 0 
				DRAW_CORONA checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint13_kickstart = 0 
				DRAW_CORONA checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF
			
			IF flag_done_checkpoint14_kickstart = 0 
				DRAW_CORONA checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint15_kickstart = 0 
				DRAW_CORONA checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint16_kickstart = 0 
				DRAW_CORONA checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint17_kickstart = 0 
				DRAW_CORONA checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint18_kickstart = 0 
				DRAW_CORONA checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint19_kickstart = 0 
				DRAW_CORONA checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint20_kickstart = 0 
				DRAW_CORONA checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint21_kickstart = 0 
				DRAW_CORONA checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF
			
			IF flag_done_checkpoint22_kickstart = 0 
				DRAW_CORONA checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint23_kickstart = 0 
				DRAW_CORONA checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint24_kickstart = 0 
				DRAW_CORONA checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint25_kickstart = 0 
				DRAW_CORONA checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint26_kickstart = 0 
				DRAW_CORONA checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint27_kickstart = 0 
				DRAW_CORONA checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint28_kickstart = 0 
				DRAW_CORONA checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint29_kickstart = 0 
				DRAW_CORONA checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint30_kickstart = 0 
				DRAW_CORONA checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint31_kickstart = 0 
				DRAW_CORONA checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF

			IF flag_done_checkpoint32_kickstart = 0 
				DRAW_CORONA checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
			ENDIF
									 
	 		GET_GAME_TIMER time_now_ks
	 		time_off_bike_ks = time_now_ks - time_bailed_ks
			time_bailed_ks = time_now_ks
	 		time_left_to_find_bike_ks = time_left_to_find_bike_ks - time_off_bike_ks
	 		time_left_to_find_bike_secs_ks = time_left_to_find_bike_ks / 1000
	 		PRINT_WITH_NUMBER_NOW ( GETBIKE ) time_left_to_find_bike_secs_ks 1000 1 //"time left to get onto bike!"

	 		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
				CLEAR_THIS_PRINT ( GETBIKE )
	 			time_left_to_find_bike_ks = 1
	 			GOTO bike_check_kickstart
	 		ENDIF

	 	ENDWHILE

		IF time_left_to_find_bike_ks <= 0
			PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"
			PRINT_NOW ( KICK1_2 ) 5000 1 //"You did not get back to the bike quickly enough!"
			SET_PLAYER_CONTROL player1 OFF

			SET_FADING_COLOUR 0 0 0
			DO_FADE 1000 FADE_OUT

			WHILE GET_FADING_STATUS

				WAIT 0
								
			ENDWHILE
			
			GOTO mission_kickstart_failed
		ENDIF

	ELSE
		CLEAR_THIS_PRINT ( GETBIKE )

		IF flag_bike_blip_on_kickstart = 1
			REMOVE_BLIP bike_blip_kickstart
			flag_bike_blip_on_kickstart = 0
		ENDIF
 		 			
	ENDIF
			
ENDWHILE

CLEAR_ONSCREEN_TIMER race_timer_kickstart
CLEAR_ONSCREEN_COUNTER number_of_checkpoints_kickstart 

GOTO mission_kickstart_passed

// ****************************************** Mission Failed *******************************

mission_kickstart_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN

  

// *************************************** Mission Passed **********************************

mission_kickstart_passed:

IF flag_kickstart_passed_1stime = 0
	REGISTER_ODDJOB_MISSION_PASSED
	PLAYER_MADE_PROGRESS 1
	flag_kickstart_passed_1stime = 1
ENDIF

PLAY_MISSION_PASSED_TUNE 1
SET_MUSIC_DOES_FADE FALSE
CLEAR_WANTED_LEVEL player1

IF player_been_rewarded_kickstart = 0

	IF race_timer_kickstart <= 300000 // 5 mins
	   	PRINT_WITH_NUMBER_BIG ( M_PASS ) 50000 5000 1 //"Mission Passed!"
   		ADD_SCORE player1 50000
		player_been_rewarded_kickstart = 1
	ENDIF

ENDIF

IF player_been_rewarded_kickstart = 0

	IF race_timer_kickstart <= 600000 // 10 mins
	   	PRINT_WITH_NUMBER_BIG ( M_PASS ) 10000 5000 1 //"Mission Passed!"
   		ADD_SCORE player1 10000
		player_been_rewarded_kickstart = 1
	ENDIF

ENDIF

IF player_been_rewarded_kickstart = 0

	IF race_timer_kickstart <= 3600000 // 60 mins
	   	PRINT_WITH_NUMBER_BIG ( M_PASS ) 5000 5000 1 //"Mission Passed!"
   		ADD_SCORE player1 5000
		player_been_rewarded_kickstart = 1
	ENDIF

ENDIF

race_timer_seconds_kickstart = race_timer_kickstart / 1000 //seconds
REGISTER_FASTEST_TIME 2 race_timer_seconds_kickstart
race_timer_mins_kickstart = race_timer_seconds_kickstart / 60 // mins
race_timer_seconds2_kickstart = race_timer_mins_kickstart * 60 
race_timer_seconds_kickstart = race_timer_seconds_kickstart - race_timer_seconds2_kickstart

IF race_timer_seconds_kickstart >= 10
	PRINT_WITH_2_NUMBERS_NOW ( KICKTM ) race_timer_mins_kickstart race_timer_seconds_kickstart 5000 1
ELSE
	PRINT_WITH_2_NUMBERS_NOW ( KICKTM2 ) race_timer_mins_kickstart race_timer_seconds_kickstart 5000 1
ENDIF

WAIT 3000

SET_PLAYER_CONTROL player1 OFF

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

WHILE GET_FADING_STATUS
	
	WAIT 0

ENDWHILE

SET_MUSIC_DOES_FADE TRUE

RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_kickstart:

flag_player_on_mission = 0
CLEAR_PRINTS
CLEAR_EXTRA_COLOURS FALSE
SET_MUSIC_DOES_FADE TRUE

REMOVE_SPHERE sphere_kickstart
REMOVE_BLIP checkpoint1_blip_kickstart
REMOVE_BLIP checkpoint2_blip_kickstart
REMOVE_BLIP checkpoint3_blip_kickstart
REMOVE_BLIP checkpoint4_blip_kickstart
REMOVE_BLIP checkpoint5_blip_kickstart
REMOVE_BLIP checkpoint6_blip_kickstart
REMOVE_BLIP checkpoint7_blip_kickstart
REMOVE_BLIP checkpoint8_blip_kickstart
REMOVE_BLIP checkpoint9_blip_kickstart
REMOVE_BLIP checkpoint10_blip_kickstart
REMOVE_BLIP checkpoint11_blip_kickstart
REMOVE_BLIP checkpoint12_blip_kickstart
REMOVE_BLIP checkpoint13_blip_kickstart
REMOVE_BLIP checkpoint14_blip_kickstart
REMOVE_BLIP checkpoint15_blip_kickstart
REMOVE_BLIP checkpoint16_blip_kickstart
REMOVE_BLIP checkpoint17_blip_kickstart
REMOVE_BLIP checkpoint18_blip_kickstart
REMOVE_BLIP checkpoint19_blip_kickstart
REMOVE_BLIP checkpoint20_blip_kickstart
REMOVE_BLIP checkpoint21_blip_kickstart
REMOVE_BLIP checkpoint22_blip_kickstart
REMOVE_BLIP checkpoint23_blip_kickstart
REMOVE_BLIP checkpoint24_blip_kickstart
REMOVE_BLIP checkpoint25_blip_kickstart
REMOVE_BLIP checkpoint26_blip_kickstart
REMOVE_BLIP checkpoint27_blip_kickstart
REMOVE_BLIP checkpoint28_blip_kickstart
REMOVE_BLIP checkpoint29_blip_kickstart
REMOVE_BLIP checkpoint30_blip_kickstart
REMOVE_BLIP checkpoint31_blip_kickstart
REMOVE_BLIP checkpoint32_blip_kickstart
REMOVE_BLIP bike_blip_kickstart
MARK_MODEL_AS_NO_LONGER_NEEDED SANCHEZ
CLEAR_ONSCREEN_TIMER race_timer_kickstart
CLEAR_ONSCREEN_COUNTER number_of_checkpoints_kickstart

LOAD_SCENE -1101.0 1331.0 19.1

IF NOT HAS_DEATHARREST_BEEN_EXECUTED
OR flag_kickstart_mission1_passed = 1
	
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

SET_PLAYER_IS_IN_STADIUM FALSE
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN
		

checkpoints_kickstart:

IF audio_flag_cheer_kick = 0

	IF player_checkpoint_kickstart < 8
		LOAD_MISSION_AUDIO 1 ( cheer1 )
		audio_flag_cheer_kick = 1
	ENDIF

	IF player_checkpoint_kickstart > 8
	AND player_checkpoint_kickstart < 16
		LOAD_MISSION_AUDIO 1 ( cheer2 )
		audio_flag_cheer_kick = 1
	ENDIF

	IF player_checkpoint_kickstart > 16
	AND player_checkpoint_kickstart < 24
		LOAD_MISSION_AUDIO 1 ( cheer3 )
		audio_flag_cheer_kick = 1
	ENDIF
		
	IF player_checkpoint_kickstart > 24
	AND player_checkpoint_kickstart < 32
		LOAD_MISSION_AUDIO 1 ( cheer4 )
		audio_flag_cheer_kick = 1
	ENDIF  
		
ENDIF

IF audio_flag_cheer_kick = 1
	
	IF HAS_MISSION_AUDIO_LOADED 1
		audio_flag_cheer_kick = 2
	ENDIF
		
ENDIF

IF audio_flag_cheer_kick = 2
	
	IF player_checkpoint_kickstart = 8
		PLAY_MISSION_AUDIO 1
		audio_flag_cheer_kick = 3
	ENDIF

	IF player_checkpoint_kickstart = 16
		PLAY_MISSION_AUDIO 1
		audio_flag_cheer_kick = 3
	ENDIF

	IF player_checkpoint_kickstart = 24
		PLAY_MISSION_AUDIO 1
		audio_flag_cheer_kick = 3
	ENDIF

	IF player_checkpoint_kickstart = 32
		PLAY_MISSION_AUDIO 1
		audio_flag_cheer_kick = 3
	ENDIF
		
ENDIF
	
IF audio_flag_cheer_kick = 3
	
	IF HAS_MISSION_AUDIO_FINISHED 1
		audio_flag_cheer_kick = 4
	ENDIF
		
ENDIF	  

IF audio_flag_cheer_kick = 4
	audio_flag_cheer_kick = 0
ENDIF
	
// player fallen off of bike audio	 

IF audio_flag_ohh_kick = 0
	LOAD_MISSION_AUDIO 2 ( ooh1 )
	audio_flag_ohh_kick = 1
ENDIF
	
IF audio_flag_ohh_kick = 1
	
	IF HAS_MISSION_AUDIO_LOADED 2
		audio_flag_ohh_kick = 2
	ENDIF
		
ENDIF

IF audio_flag_ohh_kick = 3
	HAS_MISSION_AUDIO_FINISHED 2
	audio_flag_ohh_kick = 4
ENDIF
	
IF audio_flag_ohh_kick = 4
	audio_flag_ohh_kick = 0
ENDIF

IF race_timer_kickstart >= 3600000
	player_taken_too_long_kickstart = 1
ENDIF

IF LOCATE_STOPPED_PLAYER_ON_FOOT_3D player1 -1445.728 1531.96.33 301.721 3.0 3.0 3.0 FALSE
	player_in_end_area_kickstart = 1
ENDIF

GET_PLAYER_COORDINATES player1 player_x_kickstart player_y_kickstart player_z_kickstart

IF player_z_kickstart < 290.0
	SET_PLAYER_COORDINATES player1 -1333.326 1451.837 298.161
	SET_PLAYER_HEADING player1 0.0
ENDIF
   
IF IS_CAR_DEAD bike_kickstart
	PRINT_NOW ( KICK1_7 ) 5000 1 //"You have wrecked the bike!"
	flag_bike_dead_kickstart = 1
ELSE
	   
	SET_CAR_HEALTH bike_kickstart 1000
		
	GET_CAR_COORDINATES bike_kickstart bike_x_kickstart bike_y_kickstart bike_z_kickstart

	IF bike_z_kickstart < 290.0
		SET_CAR_COORDINATES bike_kickstart -1331.994 1454.152 298.150
		SET_CAR_HEADING bike_kickstart 0.0
	ENDIF

ENDIF

IF flag_done_checkpoint1_kickstart = 0

	DRAW_CORONA checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint1_x_kickstart checkpoint1_y_kickstart checkpoint1_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint1_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint1_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF 
			
IF flag_done_checkpoint2_kickstart = 0

	DRAW_CORONA checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ

			IF audio_flag_cheer_kick = 2

				IF NOT player_checkpoint_kickstart = 7
				AND NOT player_checkpoint_kickstart = 15
				AND NOT player_checkpoint_kickstart = 23
				AND NOT player_checkpoint_kickstart = 31
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF
										
			ENDIF
			
			ADD_ONE_OFF_SOUND checkpoint2_x_kickstart checkpoint2_y_kickstart checkpoint2_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint2_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint2_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint3_kickstart = 0

	DRAW_CORONA checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint3_x_kickstart checkpoint3_y_kickstart checkpoint3_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint3_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint3_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint4_kickstart = 0

	DRAW_CORONA checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint4_x_kickstart checkpoint4_y_kickstart checkpoint4_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint4_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint4_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint5_kickstart = 0

	DRAW_CORONA checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint5_x_kickstart checkpoint5_y_kickstart checkpoint5_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint5_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint5_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint6_kickstart = 0

	DRAW_CORONA checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ

			IF audio_flag_cheer_kick = 2

				IF NOT player_checkpoint_kickstart = 7
				AND NOT player_checkpoint_kickstart = 15
				AND NOT player_checkpoint_kickstart = 23
				AND NOT player_checkpoint_kickstart = 31
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF
										
			ENDIF

			ADD_ONE_OFF_SOUND checkpoint6_x_kickstart checkpoint6_y_kickstart checkpoint6_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint6_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint6_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint7_kickstart = 0

	DRAW_CORONA checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart 2.0 2.0 2.0 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ

			IF audio_flag_cheer_kick = 2

				IF NOT player_checkpoint_kickstart = 7
				AND NOT player_checkpoint_kickstart = 15
				AND NOT player_checkpoint_kickstart = 23
				AND NOT player_checkpoint_kickstart = 31
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF
										
			ENDIF
			
			ADD_ONE_OFF_SOUND checkpoint7_x_kickstart checkpoint7_y_kickstart checkpoint7_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint7_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint7_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint8_kickstart = 0

	DRAW_CORONA checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart 2.0 2.0 2.0 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ

			IF audio_flag_cheer_kick = 2

				IF NOT player_checkpoint_kickstart = 7
				AND NOT player_checkpoint_kickstart = 15
				AND NOT player_checkpoint_kickstart = 23
				AND NOT player_checkpoint_kickstart = 31
					PLAY_MISSION_AUDIO 1
					audio_flag_cheer_kick = 3
				ENDIF
										
			ENDIF
			
			ADD_ONE_OFF_SOUND checkpoint8_x_kickstart checkpoint8_y_kickstart checkpoint8_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint8_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint8_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint9_kickstart = 0

	DRAW_CORONA checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint9_x_kickstart checkpoint9_y_kickstart checkpoint9_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint9_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint9_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint10_kickstart = 0

	DRAW_CORONA checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint10_x_kickstart checkpoint10_y_kickstart checkpoint10_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint10_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint10_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint11_kickstart = 0

	DRAW_CORONA checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint11_x_kickstart checkpoint11_y_kickstart checkpoint11_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint11_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint11_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint12_kickstart = 0

	DRAW_CORONA checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint12_x_kickstart checkpoint12_y_kickstart checkpoint12_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint12_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint12_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint13_kickstart = 0

	DRAW_CORONA checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint13_x_kickstart checkpoint13_y_kickstart checkpoint13_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint13_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint13_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint14_kickstart = 0

	DRAW_CORONA checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint14_x_kickstart checkpoint14_y_kickstart checkpoint14_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint14_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint14_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint15_kickstart = 0

	DRAW_CORONA checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint15_x_kickstart checkpoint15_y_kickstart checkpoint15_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint15_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint15_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint16_kickstart = 0

	DRAW_CORONA checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint16_x_kickstart checkpoint16_y_kickstart checkpoint16_z_kickstart SOUND_PART_MISSION_COMPLETE
		   	PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint16_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint16_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint17_kickstart = 0

	DRAW_CORONA checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint17_x_kickstart checkpoint17_y_kickstart checkpoint17_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint17_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint17_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint18_kickstart = 0

	DRAW_CORONA checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint18_x_kickstart checkpoint18_y_kickstart checkpoint18_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint18_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint18_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint19_kickstart = 0

	DRAW_CORONA checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint19_x_kickstart checkpoint19_y_kickstart checkpoint19_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint19_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint19_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint20_kickstart = 0

	DRAW_CORONA checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint20_x_kickstart checkpoint20_y_kickstart checkpoint20_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint20_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint20_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint21_kickstart = 0

	DRAW_CORONA checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint21_x_kickstart checkpoint21_y_kickstart checkpoint21_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint21_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint21_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint22_kickstart = 0

	DRAW_CORONA checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint22_x_kickstart checkpoint22_y_kickstart checkpoint22_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint22_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint22_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint23_kickstart = 0

	DRAW_CORONA checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint23_x_kickstart checkpoint23_y_kickstart checkpoint23_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint23_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint23_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint24_kickstart = 0

	DRAW_CORONA checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint24_x_kickstart checkpoint24_y_kickstart checkpoint24_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint24_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint24_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint25_kickstart = 0

	DRAW_CORONA checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint25_x_kickstart checkpoint25_y_kickstart checkpoint25_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint25_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint25_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint26_kickstart = 0

	DRAW_CORONA checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint26_x_kickstart checkpoint26_y_kickstart checkpoint26_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint26_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint26_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint27_kickstart = 0

	DRAW_CORONA checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint27_x_kickstart checkpoint27_y_kickstart checkpoint27_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint27_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint27_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint28_kickstart = 0

	DRAW_CORONA checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint28_x_kickstart checkpoint28_y_kickstart checkpoint28_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint28_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint28_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint29_kickstart = 0

	DRAW_CORONA checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint29_x_kickstart checkpoint29_y_kickstart checkpoint29_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint29_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint29_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint30_kickstart = 0

	DRAW_CORONA checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint30_x_kickstart checkpoint30_y_kickstart checkpoint30_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint30_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint30_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint31_kickstart = 0

	DRAW_CORONA checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint31_x_kickstart checkpoint31_y_kickstart checkpoint31_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint31_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint31_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

IF flag_done_checkpoint32_kickstart = 0

	DRAW_CORONA checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart 1.0 CORONATYPE_CIRCLE FLARETYPE_NONE 255 137 205
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart 1.5 1.5 1.5 FALSE

		IF IS_PLAYER_IN_CAR player1 bike_kickstart // SCFIX: was IF IS_PLAYER_IN_MODEL player1 SANCHEZ
			ADD_ONE_OFF_SOUND checkpoint32_x_kickstart checkpoint32_y_kickstart checkpoint32_z_kickstart SOUND_PART_MISSION_COMPLETE
			PRINT_NOW ( KICK1_6 ) 1000 1 //"Well done now on to the next checkpoint!"
			REMOVE_BLIP checkpoint32_blip_kickstart
			++ player_checkpoint_kickstart
			-- number_of_checkpoints_kickstart
			flag_done_checkpoint32_kickstart = 1
		ENDIF
		
	ENDIF
	
ENDIF

RETURN

}









   