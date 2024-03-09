MISSION_START
// *****************************************************************************************
// *********************************** General Mission 4 *********************************** 
// ********************************* Attack Military Convoy ********************************
// *****************************************************************************************
// *** The General has a buyer for a Sherman Tank and knows the perfect place to get one.***
// *** There is a military convoy transporting the tank across the map, the player1 must ***
// *** steal the tank by any means possible.  Then get it back to the General.			 ***
// *****************************************************************************************


// Mission start stuff

GOSUB mission_start_general4

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_general4_failed
ENDIF

GOSUB mission_cleanup_general4

MISSION_END
 
// Variables for mission

//PEDS CARS OBJECTS PICKUPS
VAR_INT escort1 escort2 escort3 tank  car_obstacle dude
VAR_INT escort1_dude1 escort1_dude2 formation_ped3 formation_ped4
VAR_INT escort2_dude1 escort2_dude2 formation_ped5 formation_ped6
VAR_INT escort3_dude1 escort3_dude2 formation_ped1 formation_ped2
VAR_INT escort2_attached_01 escort2_attached_02 escort2_attached_03 escort2_attached_04
VAR_INT escort3_attached_01 escort3_attached_02 escort3_attached_03 escort3_attached_04
VAR_INT tank_attached_dude army_soldier_vehicle
VAR_INT escort1_dude2_car_obstacle escort2_dude2_car_obstacle tank_dude2_car_obstacle escort3_dude2_car_obstacle
VAR_INT escort1_dude2_car escort2_dude2_car tank_dude2_car escort3_dude2_car
VAR_INT tank_dude1 tank_dude2 players_tank army_vehicle	army_soldier
VAR_INT garage_guard1 garage_guard2	tank_dude1_bodyarmour tank_dude2_bodyarmour gosub_armydude
VAR_INT shooting_ped shooting_peds_car shooting_peds_car_driver
//BLIPS
VAR_INT tank_blip
//FLAGS TIMERS COUNTERS
VAR_INT player_in_tank_flag another_fucking_flag tank_mission_flag tank_detonation_timer
VAR_INT flag_escort1_unusable flag_escort2_unusable escort2_attack_player escort3_attack_player
VAR_INT attack_player player_close_to_tank convoy_stop_flag next_to_centres	got_locked_tank_message
VAR_INT obstruction_of_vehicle_flag	move_car_timeout player_in_warehouse_flag
VAR_INT escort1_dude2_obstruction_flag escort2_dude2_obstruction_flag tank_not_home
VAR_INT tank_dude2_obstruction_flag escort3_dude2_obstruction_flag tank_attached_dude_counter
VAR_INT	escort1_dude2_timeout escort2_dude2_timeout	tank_dude2_timeout escort3_dude2_timeout
VAR_INT unlock_tank_timer unlock_tank_flag garage_guard1_flag garage_guard2_flag print_timer
VAR_INT escort2_attached_01_flag escort2_attached_02_flag escort2_attached_03_flag escort2_attached_04_flag
VAR_INT escort3_attached_01_flag escort3_attached_02_flag escort3_attached_03_flag escort3_attached_04_flag
VAR_INT escort2_ram_player_counter escort3_ram_player_counter tank_attached_dude_flag tank_attached_dude_timer
VAR_INT audio_1_flag audio_2_flag audio_3_flag audio_4_flag	audio_5_flag frame_counter shooting_ped_flag
VAR_INT audio_6_flag audio_7_flag audio_8_flag audio_9_flag	audio_10_flag done_tank_on_fire_bit
VAR_INT audio_11_flag audio_12_flag audio_13_flag audio_14_flag	audio_15_flag done_this_audio_bit
VAR_INT audio_16_flag audio_17_flag audio_18_flag audio_19_flag	audio_20_flag audio_21_flag
VAR_INT audio_1_timeout audio_2_timeout audio_3_timeout audio_4_timeout	audio_5_timeout
VAR_INT audio_6_timeout audio_7_timeout audio_8_timeout audio_9_timeout	audio_10_timeout player_nearish_to_tank_flag
VAR_INT audio_11_timeout audio_12_timeout audio_13_timeout audio_14_timeout	audio_15_timeout
VAR_INT audio_16_timeout audio_17_timeout audio_18_timeout audio_19_timeout	audio_20_timeout audio_21_timeout
VAR_INT	is_audio_in_use	opened_garage_stuff	player_hiding_in_warehouse player_near_tank_flag dudes_go_into_doorway
VAR_INT escort1_attack_player  escort1_ram_player_counter got_garage_help got_steal_tank_message
VAR_INT donut_stop_flag donut_stop_timer last_convoy_stop_flag initiate_seft_destruct_timer initiate_seft_destruct_flag
VAR_INT formation_ped1_counter formation_ped2_counter formation_ped3_counter formation_ped4_counter	formation_ped5_counter
VAR_INT formation_ped6_counter tank_dude1_counter tank_dude2_counter escort1_dude1_counter escort1_dude2_counter
VAR_INT vehicle_stopped_timer escort1_stopped_timer	escort2_stopped_timer tank_stopped_timer escort3_stopped_timer
VAR_INT escort1_has_been_rammed_by_player escort2_has_been_rammed_by_player escort3_has_been_rammed_by_player
VAR_INT escort1_health escort2_health escort3_health rammed_attack_timer close_to_tank_timer gosub_armydude_counter
//COORD MATHS
VAR_FLOAT escort3_dude2_obstacle_x escort3_dude2_obstacle_y	tank_detonation_timer_float
VAR_FLOAT escort2_dude2_obstacle_x escort2_dude2_obstacle_y	tank_dude2_obstacle_x tank_dude2_obstacle_y
VAR_FLOAT escort1_dude2_obstacle_x escort1_dude2_obstacle_y formation_ped1_distance formation_ped4_distance
VAR_FLOAT tank_speed x2 y2
VAR_FLOAT vector_x vector_y
VAR_FLOAT obstacle_x obstacle_y	escort1_dist_from_dest tank_dist_from_dest escort2_dist_from_dest escort3_dist_from_dest
VAR_FLOAT escort1_distance_from_vehicle_behind escort2_distance_from_vehicle_behind	tank_distance_from_vehicle_behind

//LOAD_AND_LAUNCH_MISSION_EXCLUSIVE stuff
//VAR_INT game_timer game_timer_start	players_car	temp_int cs_time_limit
//VAR_FLOAT x_temp y_temp	sum_x_y_temp heading

// ****************************************Mission Start************************************


mission_start_general4:

flag_player_on_mission = 1
flag_player_on_army_ped_mission = 1

SCRIPT_NAME COL_4

REGISTER_MISSION_GIVEN

WAIT 0
{
LVAR_FLOAT escort1_x escort1_y escort1_z tank_x tank_y tank_z
LVAR_FLOAT escort2_x escort2_y escort2_z escort2_speed army_vehicle_z
LVAR_FLOAT escort3_x escort3_y escort3_z escort3_speed

LOAD_MISSION_TEXT GENERA4
SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -163.0 -1439.4 9.0 201.5

escort2_speed = 7.5
escort3_speed = 7.5
tank_speed = 7.5

car_obstacle = -1
army_vehicle = -1
army_soldier = -1

escort1_dude2_car_obstacle = -1
escort2_dude2_car_obstacle = -1
tank_dude2_car_obstacle = -1
escort3_dude2_car_obstacle = -1

army_soldier_vehicle = -1
escort1_dude2_car = -1
escort2_dude2_car = -1
tank_dude2_car  = -1
escort3_dude2_car = -1
players_tank = -1

flag_escort1_unusable = 0
flag_escort2_unusable = 0
attack_player = 0
player_close_to_tank = 0
convoy_stop_flag = 0
obstruction_of_vehicle_flag = 0

player_in_tank_flag = 0
another_fucking_flag = 0
move_car_timeout = 0
unlock_tank_timer = 0
unlock_tank_flag = 0
tank_mission_flag = 0
tank_detonation_timer = 0
tank_detonation_timer_float = 0.0

escort1_dude2_obstruction_flag = 0
escort2_dude2_obstruction_flag = 0
tank_dude2_obstruction_flag = 0
escort3_dude2_obstruction_flag = 0

escort2_attached_01_flag = 0
escort2_attached_02_flag = 0
escort2_attached_03_flag = 0
escort2_attached_04_flag = 0

escort3_attached_01_flag = 0
escort3_attached_02_flag = 0
escort3_attached_03_flag = 0
escort3_attached_04_flag = 0

escort1_dude2_timeout = 0
escort2_dude2_timeout = 0
tank_dude2_timeout = 0
escort3_dude2_timeout = 0

tank_attached_dude_flag = 0
tank_attached_dude_timer = 0

escort1_attack_player = 0
escort2_attack_player = 0
escort3_attack_player = 0
escort1_ram_player_counter = 0
escort2_ram_player_counter = 0
escort3_ram_player_counter = 0

escort1_dude2_obstacle_x = 0.0
escort1_dude2_obstacle_y = 0.0
escort2_dude2_obstacle_x = 0.0
escort2_dude2_obstacle_y = 0.0
tank_dude2_obstacle_x = 0.0
tank_dude2_obstacle_y = 0.0
escort3_dude2_obstacle_x = 0.0
escort3_dude2_obstacle_y = 0.0

army_vehicle_z = -100.0

vector_x = 0.0
vector_y = 0.0

escort1_dist_from_dest = 0.0
escort2_dist_from_dest = 0.0
tank_dist_from_dest = 0.0
escort3_dist_from_dest = 0.0

donut_stop_flag = 0
donut_stop_timer = 0

last_convoy_stop_flag = 0
initiate_seft_destruct_timer = 0
initiate_seft_destruct_flag = 0

is_audio_in_use = 0
audio_1_flag = 0
audio_2_flag = 0 
audio_3_flag = 0
audio_4_flag = 0
audio_5_flag = 0
audio_6_flag = 0
audio_7_flag = 0
audio_8_flag = 0
audio_9_flag = 0
audio_10_flag = 0
audio_11_flag = 0
audio_12_flag = 0
audio_13_flag = 0
audio_14_flag = 0
audio_15_flag = 0
audio_16_flag = 0
audio_17_flag = 0
audio_18_flag = 0
audio_19_flag = 0
audio_20_flag = 0
audio_21_flag = 0

audio_5_timeout = 0
audio_18_timeout = 0
audio_20_timeout = 0

opened_garage_stuff = 0
player_hiding_in_warehouse = 0
got_garage_help = 0
player_near_tank_flag = 0
got_steal_tank_message = 0
garage_guard1_flag = 0
garage_guard2_flag = 0
player_in_warehouse_flag = 0
next_to_centres = 0
frame_counter = 0
tank_not_home = 0

formation_ped1_counter = 0
formation_ped2_counter = 0
formation_ped3_counter = 0
formation_ped4_counter = 0
formation_ped5_counter = 0
formation_ped6_counter = 0
tank_dude1_counter = 0
tank_dude2_counter = 0
tank_attached_dude_counter = 0
escort1_dude1_counter = 0
escort1_dude2_counter = 0

dudes_go_into_doorway = 0

print_timer = 0
got_locked_tank_message = 0

vehicle_stopped_timer = 0
escort1_stopped_timer = 0
escort2_stopped_timer = 0
tank_stopped_timer = 0
escort3_stopped_timer = 0

done_tank_on_fire_bit = 0
done_this_audio_bit = 0

escort1_has_been_rammed_by_player = 0
escort2_has_been_rammed_by_player = 0
escort3_has_been_rammed_by_player = 0
rammed_attack_timer = 0
close_to_tank_timer = 0
gosub_armydude_counter = 0
player_nearish_to_tank_flag = 0

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

LOAD_SPECIAL_CHARACTER 1 csplay
LOAD_SPECIAL_CHARACTER 2 cscolo

REQUEST_MODEL yt_main_body
REQUEST_MODEL yt_main_body2
REQUEST_MODEL yt_doors14
REQUEST_MODEL yt_tmp_boat
REQUEST_MODEL lodmain_body
REQUEST_MODEL big_poly_tings
REQUEST_MODEL yt_gangplnk_tmp

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED yt_main_body
OR NOT HAS_MODEL_LOADED yt_main_body2
OR NOT HAS_MODEL_LOADED yt_doors14
OR NOT HAS_MODEL_LOADED yt_tmp_boat
OR NOT HAS_MODEL_LOADED lodmain_body
OR NOT HAS_MODEL_LOADED big_poly_tings
	WAIT 0
ENDWHILE

WHILE NOT HAS_MODEL_LOADED yt_gangplnk_tmp
	WAIT 0
ENDWHILE

SET_NEAR_CLIP 0.1
LOAD_CUTSCENE COL_4A

GET_OBJECT_COORDINATES the_yacht the_yacht_x the_yacht_y the_yacht_z
the_yacht_x = the_yacht_x + 0.003
the_yacht_y = the_yacht_y - 1.381
the_yacht_z = the_yacht_z + 3.149
SET_CUTSCENE_OFFSET the_yacht_x the_yacht_y the_yacht_z
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player csplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken cscolo

REQUEST_COLLISION -244.2799 -1360.6704
CLEAR_AREA -244.2799 -1360.6704 7.0786 1.0 TRUE
SET_PLAYER_COORDINATES player1 -244.2799 -1360.6704 7.0786
SET_PLAYER_HEADING player1 279.1362
SET_CAMERA_BEHIND_PLAYER

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

GET_CUTSCENE_TIME cs_time

cs_time_limit = 210
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_01 10000 1 //Diaz was pleased with you and would like to meet you again.

cs_time_limit = 2773
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_02 10000 1 //Is that a good thing?

cs_time_limit = 3669
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_03 10000 1 //Of course! Although I'm starting to think that Diaz was responsible for our unfortunate loss...

cs_time_limit = 8935
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_04 10000 1 //What makes you say that?

cs_time_limit = 10386
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_05 10000 1 //One does not wave accusations at a man like Diaz, I'm merely thinking out loud

cs_time_limit = 14243
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_06 10000 1 //no matter, I have a proposal that you could profit from...

cs_time_limit = 16762
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_07 10000 1 //I don't have time to run more errands, Cortez.

cs_time_limit = 19154
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_08 10000 1 //I would have thought a man with such dangerous debts would be hungry for opportunities. At least hear me out.

cs_time_limit = 25653
GOSUB wait_for_cs_time_col4
PRINT_NOW COL4_09 10000 1 //Go on...

cs_time_limit = 26526
GOSUB wait_for_cs_time_col4
PRINT_NOW COL410 10000 1 //I have a buyer for a piece of military hardware that is being taken through town. Pick it up for me...

cs_time_limit = 32640
GOSUB wait_for_cs_time_col4
PRINT_NOW COL411 10000 1 //and once you get it, I want you to call me immediately, then...

cs_time_limit = 34964//36672
GOSUB wait_for_cs_time_col4
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
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2

MARK_MODEL_AS_NO_LONGER_NEEDED yt_main_body
MARK_MODEL_AS_NO_LONGER_NEEDED yt_main_body2
MARK_MODEL_AS_NO_LONGER_NEEDED yt_doors14
MARK_MODEL_AS_NO_LONGER_NEEDED yt_tmp_boat
MARK_MODEL_AS_NO_LONGER_NEEDED lodmain_body
MARK_MODEL_AS_NO_LONGER_NEEDED big_poly_tings
MARK_MODEL_AS_NO_LONGER_NEEDED yt_gangplnk_tmp

/////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////

SET_PLAYER_MOOD player1 PLAYER_MOOD_PISSED_OFF 60000

REQUEST_MODEL RHINO
REQUEST_MODEL BARRACKS
REQUEST_MODEL ARMY
REQUEST_MODEL PATRIOT
REQUEST_MODEL RUGER

LOAD_ALL_MODELS_NOW

WHILE NOT HAS_MODEL_LOADED RHINO
OR NOT HAS_MODEL_LOADED	BARRACKS
OR NOT HAS_MODEL_LOADED	ARMY
OR NOT HAS_MODEL_LOADED	PATRIOT
OR NOT HAS_MODEL_LOADED	RUGER
	WAIT 0
ENDWHILE

SET_FADING_COLOUR 0 0 1
DO_FADE 1500 FADE_IN

ADD_ARMOUR_TO_PLAYER player1 200

GET_PLAYER_HEALTH player1 temp_int
IF temp_int < 100
	SET_PLAYER_HEALTH player1 100
ENDIF

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_NOW COL4_B1 20000 1//"Go steal the tank"

//SWITCH_ROADS_OFF -877.0355 -1502.6396 -2.4916 -477.6842 685.0324 52.1452
SWITCH_ROADS_OFF -721.211 243.998 5.0 -651.211 693.998 25.0
SWITCH_ROADS_OFF -760.362 101.883 5.0 -700.362 251.883 25.0
SWITCH_ROADS_OFF -783.906 -46.826 5.0 -723.906 103.174 25.0
SWITCH_ROADS_OFF -853.397 -149.692 5.0 -773.397 0.308 25.0
SWITCH_ROADS_OFF -870.656 -594.54 5.0 -810.656 -144.54 25.0
SWITCH_ROADS_OFF -837.282 -1041.814 5.0 -770.282 -591.814 25.0
SWITCH_ROADS_OFF -827.532 -1539.617 5.0 -747.532 -1039.617 25.0

SET_ENTER_CAR_RANGE_MULTIPLIER 6.0

/////////////////////////////////////////////////
//ESCORT1////////////////////////////////////////
CREATE_CAR PATRIOT -751.1733 113.8836 9.8756 escort1//-676.0 698.9212 9.9 escort1
SET_CAR_HEADING escort1 167.7853//180.0
SET_CAR_CRUISE_SPEED escort1 escort2_speed
SET_CAR_DRIVING_STYLE escort1 4
SET_CAR_CHANGE_LANE escort1 FALSE
CHANGE_CAR_COLOUR escort1 CARCOLOUR_GREEN4 CARCOLOUR_GREY3
SET_CAR_ONLY_DAMAGED_BY_PLAYER escort1 TRUE

//ESCORT1 PASSENGERS
CREATE_CHAR_INSIDE_CAR escort1 PEDTYPE_CIVMALE ARMY escort1_dude1
dude = escort1_dude1
GOSUB setup_initial_ped_stuff

CREATE_CHAR_AS_PASSENGER escort1 PEDTYPE_CIVMALE ARMY 0 escort1_dude2
dude = escort1_dude2
GOSUB setup_initial_ped_stuff

CAR_GOTO_COORDINATES_ACCURATE escort1 -843.4301 -1503.7 11.9556

/////////////////////////////////////////////////
//ESCORT2////////////////////////////////////////
SET_CAR_MODEL_COMPONENTS BARRACKS -1 1
CREATE_CAR BARRACKS -749.1604 123.1814 9.8749 escort2//-676.0 709.3193 9.9 escort2
SET_CAR_HEADING escort2 167.7853//180.0
SET_CAR_CRUISE_SPEED escort2 1.0
SET_CAR_DRIVING_STYLE escort2 4
SET_CAR_CHANGE_LANE escort2 FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER escort2 TRUE

//ESCORT2 PASSENGERS
CREATE_CHAR_INSIDE_CAR escort2 PEDTYPE_CIVMALE ARMY escort2_dude1
dude = escort2_dude1
GOSUB setup_initial_ped_stuff

CREATE_CHAR_AS_PASSENGER escort2 PEDTYPE_CIVMALE ARMY 0 escort2_dude2
dude = escort2_dude2
GOSUB setup_initial_ped_stuff

//ESCORT2 ATTACHED CHARS
CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 665.0 10.1 escort2_attached_01
dude = escort2_attached_01
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort2_attached_01 escort2  0.4242 -0.0679 1.1322 FACING_RIGHT 270.0 WEAPONTYPE_RUGER//FRONT RIGHT

CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 664.0 10.1 escort2_attached_02
dude = escort2_attached_02
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort2_attached_02 escort2 -0.7608 -1.4 1.1138 FACING_LEFT 270.0 WEAPONTYPE_RUGER//FRONT LEFT

CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 663.0 10.1 escort2_attached_03
dude = escort2_attached_03
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort2_attached_03 escort2 -0.7595 -3.5704 1.1108 FACING_BACK 270.0 WEAPONTYPE_RUGER//BACK LEFT

CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 662.0 10.1 escort2_attached_04
dude = escort2_attached_04
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort2_attached_04 escort2  0.7158 -3.6996 1.1162 FACING_BACK 270.0 WEAPONTYPE_RUGER//BACK RIGHT

CAR_GOTO_COORDINATES_ACCURATE escort2 -848.7084 -1482.7328 10.9920

/////////////////////////////////////////////////
//TANK///////////////////////////////////////////
CREATE_CAR RHINO -747.1234 132.5895 9.8742 tank//-676.0 720.3492 9.9 tank
SET_CAR_HEADING tank 167.7853//180.0
SET_CAR_CRUISE_SPEED tank 1.0
SET_CAR_DRIVING_STYLE tank 4
SET_CAR_CHANGE_LANE tank FALSE
ADD_BLIP_FOR_CAR tank tank_blip
SET_TANK_DETONATE_CARS tank FALSE

//TANK PASSENGERS
CREATE_CHAR_INSIDE_CAR tank PEDTYPE_CIVMALE ARMY tank_dude1
dude = tank_dude1
GOSUB setup_initial_ped_stuff

CREATE_CHAR_AS_PASSENGER tank PEDTYPE_CIVMALE ARMY 0 tank_dude2
dude = tank_dude2
GOSUB setup_initial_ped_stuff

//TANK ATTACHED CHARS
CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 662.0 10.1 tank_attached_dude
dude = tank_attached_dude
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR tank_attached_dude tank 0.0455 -1.0043 1.9962 FACING_FORWARD 360.0 WEAPONTYPE_RUGER//BACK RIGHT

CAR_GOTO_COORDINATES_ACCURATE tank -838.3314 -1492.5 11.0623

/////////////////////////////////////////////////
//ESCORT3////////////////////////////////////////
SET_CAR_MODEL_COMPONENTS BARRACKS -1 1
CREATE_CAR BARRACKS -744.8403 143.1341 9.8734 escort3//-676.0 732.0956 9.9 escort3
SET_CAR_HEADING escort3 167.7853//180.0
SET_CAR_DRIVING_STYLE escort3 4
SET_CAR_CRUISE_SPEED escort3 1.0
SET_CAR_CHANGE_LANE escort3 FALSE
SET_CAR_ONLY_DAMAGED_BY_PLAYER escort3 TRUE

//ESCORT3 PASSENGERS
CREATE_CHAR_INSIDE_CAR escort3 PEDTYPE_CIVMALE ARMY escort3_dude1
dude = escort3_dude1
GOSUB setup_initial_ped_stuff

CREATE_CHAR_AS_PASSENGER escort3 PEDTYPE_CIVMALE ARMY 0 escort3_dude2
dude = escort3_dude2
GOSUB setup_initial_ped_stuff

//ESCORT3 ATTACHED CHARS
CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 665.0 10.1 escort3_attached_01
dude = escort3_attached_01
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort3_attached_01 escort3  0.4242 -0.0679 1.1322 FACING_RIGHT 270.0 WEAPONTYPE_RUGER//FRONT RIGHT

CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 664.0 10.1 escort3_attached_02
dude = escort3_attached_02
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort3_attached_02 escort3 -0.7608 -1.4 1.1138 FACING_LEFT 270.0 WEAPONTYPE_RUGER//FRONT LEFT

CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 663.0 10.1 escort3_attached_03
dude = escort3_attached_03
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort3_attached_03 escort3 -0.7595 -3.5704 1.1108 FACING_BACK 270.0 WEAPONTYPE_RUGER//BACK LEFT

CREATE_CHAR PEDTYPE_CIVMALE ARMY -686.0 662.0 10.1 escort3_attached_04
dude = escort3_attached_04
GOSUB setup_initial_ped_stuff
ATTACH_CHAR_TO_CAR escort3_attached_04 escort3  0.7158 -3.6996 1.1162 FACING_BACK 270.0 WEAPONTYPE_RUGER//BACK RIGHT

CAR_GOTO_COORDINATES_ACCURATE escort3 -856.1463 -1480.3773 10.9387

/////////////////////////////////////////////////
//TANK FROMATION DUDES///////////////////////////
GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank 5.0 2.0 0.0 x y z
CREATE_CHAR PEDTYPE_CIVMALE ARMY x y 10.0 formation_ped1
dude = formation_ped1
GOSUB setup_initial_ped_stuff
SET_CHAR_ONLY_DAMAGED_BY_PLAYER formation_ped1 TRUE

GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank 5.0 -1.0 0.0 x y z
CREATE_CHAR PEDTYPE_CIVMALE ARMY x y 10.0 formation_ped2
dude = formation_ped2
GOSUB setup_initial_ped_stuff
SET_CHAR_ONLY_DAMAGED_BY_PLAYER formation_ped2 TRUE

GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank 5.0 -4.0 0.0 x y z
CREATE_CHAR PEDTYPE_CIVMALE ARMY x y 10.0 formation_ped3
dude = formation_ped3
GOSUB setup_initial_ped_stuff
SET_CHAR_ONLY_DAMAGED_BY_PLAYER formation_ped3 TRUE

GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 2.0 0.0 x y z
CREATE_CHAR PEDTYPE_CIVMALE ARMY x y 10.0 formation_ped4
dude = formation_ped4
GOSUB setup_initial_ped_stuff
SET_CHAR_ONLY_DAMAGED_BY_PLAYER formation_ped4 TRUE

GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 -1.0 0.0 x y z
CREATE_CHAR PEDTYPE_CIVMALE ARMY x y 10.0 formation_ped5
dude = formation_ped5
GOSUB setup_initial_ped_stuff
SET_CHAR_ONLY_DAMAGED_BY_PLAYER formation_ped5 TRUE

GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 -4.0 0.0 x y z
CREATE_CHAR PEDTYPE_CIVMALE ARMY x y 10.0 formation_ped6
dude = formation_ped6
GOSUB setup_initial_ped_stuff
SET_CHAR_ONLY_DAMAGED_BY_PLAYER formation_ped6 TRUE

/////////////////////////////////////////////////
//ROADBLOCKS SOUTH 2 NORTH///////////////////////
//CREATE_SCRIPT_ROADBLOCK -885.9499 -1442.2649 11.0349 -891.6244 -1456.6609 10.9687//by final warehouse
//CREATE_SCRIPT_ROADBLOCK -807.0514 -1388.8850 10.6476 -801.7827 -1374.5934 10.5058//next off road in docks
//CREATE_SCRIPT_ROADBLOCK -786.6721 -1343.5258 10.5875 -780.6464 -1329.5001 10.4440//2nd off road in docks
//CREATE_SCRIPT_ROADBLOCK -834.2352 -1057.6764 10.5529 -837.0213 -1045.5490 10.7284//turning from main drag into airport
//CREATE_SCRIPT_ROADBLOCK -789.1951 -930.0892 9.6729 -788.2363 -915.2332 9.6729//southernmost bridge
//CREATE_SCRIPT_ROADBLOCK -849.7534 -658.3314 10.6090	-851.6252 -643.2387 10.4786//icecream turning
//CREATE_SCRIPT_ROADBLOCK -812.9766 -526.0633 10.1554	-817.8110 -501.2489 9.9922//starisland bridge
//CREATE_SCRIPT_ROADBLOCK -876.0130 -291.4716 9.9119 -875.7681 -277.5194 10.1305//turning to printworks
//CREATE_SCRIPT_ROADBLOCK -811.8735 -8.3261 10.5396 -804.6509 5.3036 10.5061//next end of printworks 'U'
//CREATE_SCRIPT_ROADBLOCK -749.2551 193.4344 10.6401 -747.0237 207.8837 10.4886//south of rooftop diner
//CREATE_SCRIPT_ROADBLOCK -732.3436 287.1511 10.4862 -731.0121 302.1729 10.5000//north of rooftop diner

mission_general4_loop:

WAIT 0

++ frame_counter
IF frame_counter > 3
	frame_counter = 0
ENDIF

GET_GAME_TIMER game_timer
//SET_PLAYER_HEALTH player1 100

//////////////////////////////////////////////////////////////////////////
//ESCORT1 STUFF///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
IF frame_counter = 0
	IF NOT IS_CAR_DEAD escort1
		IF NOT IS_PLAYER_IN_CAR player1 escort1
			IF NOT IS_CHAR_DEAD	escort1_dude1
				IF IS_CHAR_IN_CAR escort1_dude1	escort1
			
					GET_CAR_COORDINATES	escort1 escort1_x escort1_y escort1_z
					x_temp = escort1_x - -837.0244
					y_temp = escort1_y - -1509.2794
					x_temp = x_temp * x_temp
					y_temp = y_temp * y_temp
					sum_x_y_temp = x_temp + y_temp
					SQRT sum_x_y_temp escort1_dist_from_dest

					IF attack_player = 0

						IF NOT IS_CHAR_DEAD escort1_dude2
							IF escort1_dude2_counter = 0
								IF escort1_dude2_obstruction_flag = 5
									IF IS_CHAR_IN_CAR escort1_dude2 escort1
										escort1_dude2_obstruction_flag = 0
										IF donut_stop_flag = 0
										OR donut_stop_flag = 7
											convoy_stop_flag = 0
										ENDIF
									ELSE
										IF IS_CHAR_IN_ANY_CAR escort1_dude2
											STORE_CAR_CHAR_IS_IN_NO_SAVE escort1_dude2 escort1_dude2_car
											SET_CHAR_OBJ_LEAVE_CAR escort1_dude2 escort1_dude2_car
										ELSE
											SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	escort1_dude2 escort1
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ELSE
							IF NOT escort1_dude2_counter = 3
								IF attack_player = 0
									attack_player = 1
								ENDIF
							ENDIF
						ENDIF
						
						IF IS_CHAR_DEAD escort1_dude1
							IF NOT escort1_dude1_counter = 3
								IF attack_player = 0
									attack_player = 1
								ENDIF
							ENDIF
						ENDIF

						IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON escort1 WEAPONTYPE_RAMMEDBYCAR
							IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 escort1 20.0 20.0 0
								escort1_has_been_rammed_by_player = 1
							ENDIF
						ENDIF
						
						IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON escort1 WEAPONTYPE_ANYWEAPON
							GET_CAR_HEALTH escort1 escort1_health
							IF escort1_health < 800
								attack_player = 1
							ENDIF
						ENDIF

						CLEAR_CAR_LAST_WEAPON_DAMAGE escort1
						
						IF NOT LOCATE_CAR_2D escort1 -838.3314 -1490.4927 50.0 50.0 0
							escort1_distance_from_vehicle_behind = escort2_dist_from_dest - escort1_dist_from_dest
							IF escort1_distance_from_vehicle_behind > 20.0
								SET_CAR_CRUISE_SPEED escort1 0.0
								SET_CAR_TEMP_ACTION escort1 TEMPACT_WAIT 200
							ELSE
								SET_CAR_CRUISE_SPEED escort1 7.5
							ENDIF
						ENDIF

						IF NOT escort1_dude2_counter = 3
							army_vehicle = escort1
							army_soldier = escort1_dude2
							army_vehicle_z = escort1_z
							GOSUB if_in_front_of_army_vehicle
						ENDIF
					
						IF convoy_stop_flag = 1
							SET_CAR_CRUISE_SPEED escort1 0.0
							SET_CAR_TEMP_ACTION escort1 TEMPACT_WAIT 500
						ENDIF
					ELSE
						IF player_nearish_to_tank_flag = 1 
							IF escort1_attack_player = 2
							OR escort1_attack_player = 3
								escort1_attack_player = 0
							ENDIF
							IF escort1_attack_player = 0
								SET_CAR_CRUISE_SPEED escort1 100.0
								SET_CAR_DRIVING_STYLE escort1 2
								SET_CAR_MISSION escort1 MISSION_RAMPLAYER_FARAWAY
								escort1_attack_player = 1
							ENDIF
							IF escort1_attack_player = 1
								IF escort1_ram_player_counter = 10
									IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 escort1 20.0 20.0 0
										IF NOT IS_CHAR_DEAD	escort1_dude2
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort1_dude2 player1
										ENDIF
									ENDIF
									escort1_ram_player_counter = 0
								ELSE
									++ escort1_ram_player_counter
								ENDIF
							ENDIF
						ELSE
							IF escort1_attack_player = 0
							OR escort1_attack_player = 1
								escort1_attack_player = 2
							ENDIF
							IF escort1_attack_player = 2
								SET_CAR_CRUISE_SPEED escort1 100.0
								SET_CAR_DRIVING_STYLE escort1 2
								CAR_GOTO_COORDINATES escort1 tank_x tank_y tank_z
								escort1_attack_player = 3
							ENDIF
							IF escort1_attack_player = 3
								IF LOCATE_CAR_2D escort1 tank_x tank_y 20.0 20.0 0
									SET_CAR_MISSION	escort1 MISSION_STOP_FOREVER
									SET_CAR_TEMP_ACTION escort1 TEMPACT_WAIT 500
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ELSE
					IF NOT escort1_dude1_counter = 3
						flag_escort1_unusable = 1
						IF attack_player = 0
							attack_player = 1
						ENDIF
					ENDIF
				ENDIF//IS_CHAR_IN_CAR
			ELSE
				IF NOT escort1_dude1_counter = 3
					flag_escort1_unusable = 1
					IF attack_player = 0
						attack_player = 1
					ENDIF
				ENDIF
			ENDIF//IS_CHAR_DEAD
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER escort1 FALSE
			IF NOT IS_CHAR_DEAD	escort1_dude1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort1_dude1 player1
			ENDIF
			
			IF NOT IS_CHAR_DEAD	escort1_dude2
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort1_dude2 player1
			ENDIF
			IF attack_player = 0
				attack_player = 1
			ENDIF
			flag_escort1_unusable = 1
		ENDIF//IS_PLAYER_IN_CAR
	ELSE
		IF attack_player = 0
			attack_player = 1
		ENDIF
		flag_escort1_unusable = 1
	ENDIF//IS_CAR_DEAD
ENDIF

//////////////////////////////////////////////////////////////////////////
//ESCORT2 STUFF///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
IF frame_counter = 1
	IF NOT IS_CAR_DEAD escort2
		IF NOT IS_PLAYER_IN_CAR player1 escort2
			IF NOT IS_CHAR_DEAD	escort2_dude1
				IF IS_CHAR_IN_CAR escort2_dude1	escort2
			
					GET_CAR_COORDINATES	escort2 escort2_x escort2_y escort2_z

					x_temp = escort2_x - -837.0244
					y_temp = escort2_y - -1509.2794
					x_temp = x_temp * x_temp
					y_temp = y_temp * y_temp
					sum_x_y_temp = x_temp + y_temp
					SQRT sum_x_y_temp escort2_dist_from_dest
				
					IF attack_player = 0
						IF NOT IS_CHAR_DEAD escort2_dude2
							IF escort2_dude2_obstruction_flag = 5
								IF IS_CHAR_IN_CAR escort2_dude2 escort2
									escort2_dude2_obstruction_flag = 0
									IF donut_stop_flag = 0
									OR donut_stop_flag = 7
										convoy_stop_flag = 0
									ENDIF
								ELSE
									IF IS_CHAR_IN_ANY_CAR escort2_dude2
										STORE_CAR_CHAR_IS_IN_NO_SAVE escort2_dude2 escort2_dude2_car
										SET_CHAR_OBJ_LEAVE_CAR escort2_dude2 escort2_dude2_car
									ELSE
										SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	escort2_dude2 escort2
									ENDIF
								ENDIF
							ENDIF
						ELSE
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
						
						IF IS_CHAR_DEAD escort2_dude1
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
						
						IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON escort2 WEAPONTYPE_RAMMEDBYCAR
							IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 escort2 20.0 20.0 0
								escort2_has_been_rammed_by_player = 1
							ENDIF
						ENDIF
						
						IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON escort2 WEAPONTYPE_ANYWEAPON
							GET_CAR_HEALTH escort2 escort2_health
							IF escort2_health < 800
								attack_player = 1
							ENDIF
						ENDIF

						CLEAR_CAR_LAST_WEAPON_DAMAGE escort2
						
						IF NOT flag_escort1_unusable = 1
							x_temp = escort2_x - escort1_x
							y_temp = escort2_y - escort1_y
							x_temp = x_temp * x_temp
							y_temp = y_temp * y_temp
							sum_x_y_temp = x_temp + y_temp
							SQRT sum_x_y_temp sum_x_y_temp
							
							escort2_speed = sum_x_y_temp - 3.0
							IF escort2_speed > 100.0
								escort2_speed = 100.0
							ENDIF
							IF escort2_speed < 0.0
								escort2_speed = 0.0
							ENDIF
							IF NOT LOCATE_CAR_2D escort2 -838.3314 -1490.4927 50.0 50.0 0
								IF escort1_dist_from_dest > escort2_dist_from_dest
									escort2_speed = 0.0
								ENDIF
							   
								escort2_distance_from_vehicle_behind = tank_dist_from_dest - escort2_dist_from_dest
								IF escort2_distance_from_vehicle_behind > 20.0
									escort2_speed = 0.0
								ENDIF
							ELSE
								SET_CAR_STRAIGHT_LINE_DISTANCE escort2 40
							ENDIF
						ELSE
							escort2_speed = 12.0
						ENDIF
						
						army_vehicle = escort2
						army_soldier = escort2_dude2
						army_vehicle_z = escort2_z
						GOSUB if_in_front_of_army_vehicle

						IF convoy_stop_flag = 0
							IF escort2_speed = 0.0
								SET_CAR_TEMP_ACTION escort2 TEMPACT_WAIT 200
							ELSE
								SET_CAR_CRUISE_SPEED escort2 escort2_speed
							ENDIF
						ELSE
							escort2_speed = 0.0
							SET_CAR_TEMP_ACTION escort2 TEMPACT_WAIT 500
						ENDIF
					ELSE
						IF player_nearish_to_tank_flag = 1 
							IF escort2_attack_player = 2
							OR escort2_attack_player = 3
								escort2_attack_player = 0
							ENDIF
							IF escort2_attack_player = 0
								SET_CAR_CRUISE_SPEED escort2 100.0
								SET_CAR_DRIVING_STYLE escort2 2
								SET_CAR_MISSION escort2 MISSION_RAMPLAYER_FARAWAY
								escort2_attack_player = 1
							ENDIF
							IF escort2_attack_player = 1
								IF escort2_ram_player_counter = 10
									IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 escort2 20.0 20.0 0
										IF NOT IS_CHAR_DEAD	escort2_dude2
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort2_dude2 player1
										ENDIF
									ENDIF
									escort2_ram_player_counter = 0
								ELSE
									++ escort2_ram_player_counter
								ENDIF
							ENDIF
						ELSE
							IF escort2_attack_player = 0
							OR escort2_attack_player = 1
								escort2_attack_player = 2
							ENDIF
							IF escort2_attack_player = 2
								SET_CAR_CRUISE_SPEED escort2 100.0
								SET_CAR_DRIVING_STYLE escort2 2
								CAR_GOTO_COORDINATES escort2 tank_x tank_y tank_z
								escort2_attack_player = 3
							ENDIF
							IF escort2_attack_player = 3
								IF LOCATE_CAR_2D escort2 tank_x tank_y 20.0 20.0 0
									SET_CAR_MISSION	escort2 MISSION_STOP_FOREVER
									SET_CAR_TEMP_ACTION escort2 TEMPACT_WAIT 500
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ELSE//IS CHAR IN CAR
					IF attack_player = 0
						attack_player = 1
					ENDIF
					flag_escort2_unusable = 1
				ENDIF
			ELSE//IS CHAR DEAD
				IF attack_player = 0
					attack_player = 1
				ENDIF
				flag_escort2_unusable = 1
			ENDIF
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER escort2 FALSE
			IF NOT IS_CHAR_DEAD	escort2_dude1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort2_dude1 player1
			ENDIF
			IF NOT IS_CHAR_DEAD	escort2_dude2
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort2_dude2 player1
			ENDIF
			IF attack_player = 0
				attack_player = 1
			ENDIF
			flag_escort2_unusable = 1
		ENDIF
	ELSE
		IF attack_player = 0
			attack_player = 1
		ENDIF
		flag_escort2_unusable = 1
	ENDIF
	
	//////////////////////////////////////////////////////////////////////////
	//SHOOTING FROM ESCORT2 STUFF/////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	shooting_ped = escort2_attached_01
	shooting_peds_car = escort2
	shooting_peds_car_driver = escort2_dude1
	shooting_ped_flag = escort2_attached_01_flag
	GOSUB shooting_from_vehicle_stuff
	escort2_attached_01_flag = shooting_ped_flag
	
	shooting_ped = escort2_attached_02
	shooting_peds_car = escort2
	shooting_peds_car_driver = escort2_dude1
	shooting_ped_flag = escort2_attached_02_flag
	GOSUB shooting_from_vehicle_stuff
	escort2_attached_02_flag = shooting_ped_flag
	
	shooting_ped = escort2_attached_03
	shooting_peds_car = escort2
	shooting_peds_car_driver = escort2_dude1
	shooting_ped_flag = escort2_attached_03_flag
	GOSUB shooting_from_vehicle_stuff
	escort2_attached_03_flag = shooting_ped_flag
	
	shooting_ped = escort2_attached_04
	shooting_peds_car = escort2
	shooting_peds_car_driver = escort2_dude1
	shooting_ped_flag = escort2_attached_04_flag
	GOSUB shooting_from_vehicle_stuff
	escort2_attached_04_flag = shooting_ped_flag
	
ENDIF//frame counter

//////////////////////////////////////////////////////////////////////////
//TANK STUFF//////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
IF frame_counter = 2
	IF NOT IS_CAR_DEAD tank
		IF NOT IS_PLAYER_IN_CAR player1 tank
			IF IS_GARAGE_CLOSED garage_col4_destination
			AND	opened_garage_stuff > 0
				PRINT_NOW COL4_B2 5000 1//"~r~The tank arrived at its destination safely"
				GOTO mission_general4_failed
			ENDIF

			IF opened_garage_stuff = 1
				//IF IS_CAR_STOPPED_IN_ANGLED_AREA_3D tank -823.448 -1488.083 10.852 -841.991 -1480.591 16.165 30.0 0
				IF LOCATE_CAR_2D tank -836.007 -1500.523 13.5 13.5 0
					IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -823.448 -1488.083 10.852 -841.991 -1480.591 16.165 30.0 0
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 -833.708 -1509.877 12.489 4.0 6.0 1.5 0
							IF dudes_go_into_doorway = 0
								dudes_go_into_doorway = 1
							ENDIF
						ELSE
							IF formation_ped1_counter < 3
							OR escort1_dude1_counter < 3
							OR formation_ped3_counter < 3
							OR formation_ped4_counter < 3
							OR escort1_dude2_counter < 3
							OR formation_ped6_counter < 3
								IF attack_player = 0
									attack_player = 1
								ENDIF
							ENDIF
							opened_garage_stuff = 2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			
			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 tank 60.0 60.0 0
				player_near_tank_flag = 1
				IF got_steal_tank_message = 0
					PRINT_NOW COL4_B6 5000 1//Find a way to steal the tank!
					print_timer = game_timer + 5000
					got_steal_tank_message = 1
				ENDIF
				ALTER_WANTED_LEVEL player1 0
			ELSE
				player_near_tank_flag = 0
			ENDIF														

			IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 tank 250.0 250.0 0
				player_nearish_to_tank_flag = 1
			ELSE
				player_nearish_to_tank_flag = 0
			ENDIF														
			GET_CAR_COORDINATES	tank tank_x tank_y tank_z

			x_temp = tank_x - -837.0244
			y_temp = tank_y - -1509.2794
			x_temp = x_temp * x_temp
			y_temp = y_temp * y_temp
			sum_x_y_temp = x_temp + y_temp
			SQRT sum_x_y_temp tank_dist_from_dest
			
			IF IS_CHAR_DEAD tank_dude1
				IF NOT tank_dude1_counter = 3
					IF attack_player = 0
						IF DOES_CHAR_EXIST tank_dude1
							GET_DEAD_CHAR_PICKUP_COORDS	tank_dude1 x y z
							CREATE_PICKUP bodyarmour PICKUP_ONCE x y z tank_dude1_bodyarmour
						ENDIF
						attack_player = 1
					ENDIF
				ENDIF
			ENDIF
			
			IF IS_CHAR_DEAD tank_dude2
				IF NOT tank_dude2_counter = 3
					IF attack_player = 0
						IF DOES_CHAR_EXIST tank_dude2
							GET_DEAD_CHAR_PICKUP_COORDS	tank_dude2 x y z
							CREATE_PICKUP bodyarmour PICKUP_ONCE x y z tank_dude2_bodyarmour
						ENDIF
						attack_player = 1
					ENDIF
				ENDIF
			ENDIF
			
			IF got_locked_tank_message = 0
				IF NOT unlock_tank_flag = 2
					IF NOT IS_PLAYER_ON_FOOT player1
						GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -2.5017 0.3918 -0.1973 x y z
						IF LOCATE_PLAYER_ON_FOOT_2D player1	x y 1.0 1.0 0
							PRINT_NOW COL4_B4 5000 1//"~g~The Tank is locked, find a way to open it."
							print_timer = game_timer + 5000
							got_locked_tank_message = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF

			//TANK ON FIRE BIT
			IF done_tank_on_fire_bit = 0
				IF IS_CAR_ON_FIRE tank
					IF NOT IS_CHAR_DEAD tank_dude1
						IF IS_CHAR_IN_CAR tank_dude1 tank
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE tank_dude1 player1
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD tank_dude2
						IF IS_CHAR_IN_CAR tank_dude2 tank
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE tank_dude2 player1
						ENDIF
					ENDIF
					IF NOT IS_CHAR_DEAD tank_dude1 // FIXMIAMI
					OR NOT IS_CHAR_DEAD tank_dude2 // FIXMIAMI
						IF audio_7_flag = 0
							audio_7_flag = 1
							audio_7_timeout = game_timer + 6000
						ENDIF
					ENDIF // FIXMIAMI
					LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
					unlock_tank_flag = 2
					IF attack_player = 0
						attack_player = 1
					ENDIF
					done_tank_on_fire_bit = 1
				ENDIF
			ENDIF
						
			IF NOT tank_attached_dude_counter = 3
				IF NOT IS_CHAR_DEAD tank_attached_dude
					IF attack_player = 0
						IF tank_attached_dude_counter = 0
							GET_CAR_HEADING tank heading
							SET_CHAR_HEADING tank_attached_dude	heading
						ENDIF
					ELSE
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT tank_attached_dude player1
					ENDIF
				ELSE
					IF attack_player = 0
						IF tank_attached_dude_flag = 0
							convoy_stop_flag = 1
							tank_attached_dude_flag = 1
							tank_attached_dude_timer = game_timer + 2000
						ENDIF

						IF tank_attached_dude_flag = 1
							IF game_timer > tank_attached_dude_timer
								IF audio_12_flag = 0
									audio_12_flag = 1
									audio_12_timeout = game_timer + 6000
								ENDIF
								IF audio_21_flag = 0
									audio_21_flag = 1
									audio_21_timeout = game_timer + 8000
								ENDIF
								tank_attached_dude_flag = 2
							ENDIF
						ENDIF

						IF tank_attached_dude_flag = 2
							IF NOT IS_CHAR_DEAD	tank_dude1
								GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 0.0 0.0 x y z
								SET_CHAR_OBJ_RUN_TO_COORD tank_dude1 x y
								LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
								unlock_tank_flag = 2
								IF LOCATE_CHAR_ON_FOOT_2D tank_dude1 x y 1.0 1.0 0
									SET_CHAR_OBJ_NO_OBJ	tank_dude1
									GET_CAR_COORDINATES	tank x y z
									IF audio_8_flag = 0
										audio_8_flag = 1
										audio_8_timeout = game_timer + 6000
									ENDIF
									TURN_CHAR_TO_FACE_COORD	tank_dude1 x y z
									tank_attached_dude_flag = 3
									tank_attached_dude_timer = game_timer + 2000
								ENDIF
							ENDIF
						ENDIF

						IF tank_attached_dude_flag = 3
							IF game_timer > tank_attached_dude_timer
								IF attack_player = 0
									attack_player = 1
								ENDIF
							ENDIF
						ENDIF
					ELSE
						DETACH_CHAR_FROM_CAR tank_attached_dude
					ENDIF
				ENDIF			
			ENDIF			

			IF attack_player = 0


				IF formation_ped1_counter = 0
					IF NOT IS_CHAR_DEAD formation_ped1
						GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank 5.0 2.0 0.0 x y z
						IF convoy_stop_flag = 0
							SET_CHAR_USE_PEDNODE_SEEK formation_ped1 FALSE
							SET_CHAR_OBJ_RUN_TO_COORD formation_ped1 x y
							SET_CHAR_USE_PEDNODE_SEEK formation_ped1 FALSE
						ENDIF
					ELSE
						IF NOT formation_ped1_counter = 3
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				
				IF formation_ped2_counter = 0
					IF NOT IS_CHAR_DEAD formation_ped2
						GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank 5.0 -1.0 0.0 x y z
						SET_CHAR_USE_PEDNODE_SEEK formation_ped2 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD formation_ped2 x y
						SET_CHAR_USE_PEDNODE_SEEK formation_ped2 FALSE
					ELSE
						IF NOT formation_ped2_counter = 3
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				
				IF formation_ped3_counter = 0
					IF NOT IS_CHAR_DEAD formation_ped3
						IF escort1_has_been_rammed_by_player = 1
						OR escort2_has_been_rammed_by_player = 1
						OR escort3_has_been_rammed_by_player = 1
							IF done_this_audio_bit = 0
								IF audio_19_flag = 0
									audio_19_flag = 1
									audio_19_timeout = game_timer + 6000
								ENDIF
								done_this_audio_bit = 1
							ENDIF
							SET_CHAR_STAY_IN_SAME_PLACE formation_ped3 TRUE
							IF IS_PLAYER_IN_ANY_CAR player1
								STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
								SET_CHAR_OBJ_DESTROY_CAR formation_ped3	players_car
							ELSE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped3	player1
							ENDIF
							IF rammed_attack_timer < game_timer
								escort1_has_been_rammed_by_player = 0
								escort2_has_been_rammed_by_player = 0
								escort3_has_been_rammed_by_player = 0
								done_this_audio_bit = 0
							ENDIF
						ELSE
							SET_CHAR_STAY_IN_SAME_PLACE formation_ped3 FALSE
							rammed_attack_timer	= game_timer + 6000
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank 5.0 -4.0 0.0 x y z
							SET_CHAR_USE_PEDNODE_SEEK formation_ped3 FALSE
							SET_CHAR_OBJ_RUN_TO_COORD formation_ped3 x y
							SET_CHAR_USE_PEDNODE_SEEK formation_ped3 FALSE
						ENDIF
					ELSE
						IF NOT formation_ped3_counter = 3
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			
				IF LOCATE_CAR_2D tank -860.463 -204.449 8.0 75.0 0
					next_to_centres = 1
				ELSE
					next_to_centres = 0
				ENDIF
				
				IF formation_ped4_counter = 0
					IF NOT IS_CHAR_DEAD formation_ped4
						IF next_to_centres = 1
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -3.5 -4.0 0.0 x y z
						ELSE
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 2.0 0.0 x y z
						ENDIF
						IF convoy_stop_flag = 0
							SET_CHAR_USE_PEDNODE_SEEK formation_ped4 FALSE
							SET_CHAR_OBJ_RUN_TO_COORD formation_ped4 x y
							SET_CHAR_USE_PEDNODE_SEEK formation_ped4 FALSE
						ENDIF
					ELSE
						IF NOT formation_ped4_counter = 3
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				
				IF formation_ped5_counter = 0
					IF NOT IS_CHAR_DEAD formation_ped5
						IF escort1_has_been_rammed_by_player = 1
						OR escort2_has_been_rammed_by_player = 1
						OR escort3_has_been_rammed_by_player = 1
							IF IS_CHAR_DEAD	formation_ped3
								IF done_this_audio_bit = 0
									IF audio_19_flag = 0
										audio_19_flag = 1
										audio_19_timeout = game_timer + 6000
									ENDIF
									done_this_audio_bit = 1
								ENDIF
							ENDIF
							SET_CHAR_STAY_IN_SAME_PLACE formation_ped5 TRUE
							IF IS_PLAYER_IN_ANY_CAR player1
								STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
								SET_CHAR_OBJ_DESTROY_CAR formation_ped5	players_car
							ELSE
								SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped5	player1
							ENDIF
							IF IS_CHAR_DEAD	formation_ped3
								IF rammed_attack_timer < game_timer
									escort1_has_been_rammed_by_player = 0
									escort2_has_been_rammed_by_player = 0
									escort3_has_been_rammed_by_player = 0
									done_this_audio_bit = 0
								ENDIF
							ENDIF
						ELSE
							IF IS_CHAR_DEAD	formation_ped3
								rammed_attack_timer	= game_timer + 6000
							ELSE
								SET_CHAR_STAY_IN_SAME_PLACE formation_ped3 FALSE
							ENDIF
							IF next_to_centres = 1
								GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -3.5 -1.0 0.0 x y z
							ELSE
								GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 -1.0 0.0 x y z
							ENDIF
							SET_CHAR_USE_PEDNODE_SEEK formation_ped5 FALSE
							SET_CHAR_OBJ_RUN_TO_COORD formation_ped5 x y
							SET_CHAR_USE_PEDNODE_SEEK formation_ped5 FALSE
						ENDIF
					ELSE
						IF NOT formation_ped5_counter = 3
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				
				IF formation_ped6_counter = 0
					IF NOT IS_CHAR_DEAD formation_ped6
						IF next_to_centres = 1
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -3.5 2.0 0.0 x y z
						ELSE
							GET_OFFSET_FROM_CAR_IN_WORLD_COORDS tank -5.0 -4.0 0.0 x y z
						ENDIF
						SET_CHAR_USE_PEDNODE_SEEK formation_ped6 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD formation_ped6 x y
						SET_CHAR_USE_PEDNODE_SEEK formation_ped6 FALSE
					ELSE
						IF NOT formation_ped6_counter = 3
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				
				IF NOT IS_CHAR_DEAD tank_dude2
					IF tank_dude2_counter = 0
						IF tank_dude2_obstruction_flag = 5
							IF IS_CHAR_IN_CAR tank_dude2 tank
								tank_dude2_obstruction_flag = 0
								IF donut_stop_flag = 0
								OR donut_stop_flag = 7
									convoy_stop_flag = 0
								ENDIF
							ELSE
								IF IS_CHAR_IN_ANY_CAR tank_dude2
									STORE_CAR_CHAR_IS_IN_NO_SAVE tank_dude2 tank_dude2_car
									SET_CHAR_OBJ_LEAVE_CAR tank_dude2 tank_dude2_car
								ELSE
									SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	tank_dude2 tank
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ELSE
					IF NOT tank_dude2_counter = 3
						IF attack_player = 0
							attack_player = 1
						ENDIF
					ENDIF
				ENDIF
			ELSE
				IF unlock_tank_flag = 0
					unlock_tank_timer = game_timer + 100000
					unlock_tank_flag = 1
				ENDIF
				IF unlock_tank_flag = 1
					IF IS_CAR_DEAD escort1
						IF IS_CAR_DEAD escort2
							IF IS_CAR_DEAD escort3
								IF IS_CHAR_DEAD formation_ped1
									IF IS_CHAR_DEAD formation_ped2
										IF IS_CHAR_DEAD formation_ped3
											IF IS_CHAR_DEAD formation_ped4
												IF IS_CHAR_DEAD formation_ped5
													IF IS_CHAR_DEAD formation_ped6
														unlock_tank_timer = game_timer - 500
													ENDIF
												ENDIF
											ENDIF
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ENDIF
					ENDIF
					IF game_timer > unlock_tank_timer
						IF NOT IS_CHAR_DEAD tank_dude1
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE tank_dude1 player1
						ENDIF
						IF NOT IS_CHAR_DEAD tank_dude2
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE tank_dude2 player1
						ENDIF
						IF audio_7_flag = 0
							audio_7_flag = 1
							audio_7_timeout = game_timer + 6000
						ENDIF
						LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
						unlock_tank_flag = 2
					ENDIF
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped1 player1
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped2
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped2 player1
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped3
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped3 player1
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped4
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped4 player1
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped5
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped5 player1
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped6
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped6 player1
				ENDIF
			ENDIF
			
			IF attack_player = 0
				
				//SNIPED IN CARS CHECK
				IF NOT IS_CHAR_DEAD	tank_dude1
					IF IS_CHAR_LEAVING_VEHICLE_TO_DIE tank_dude1
						IF NOT IS_CHAR_DEAD	tank_dude2
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE tank_dude2 player1
							LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
							unlock_tank_flag = 2
							IF audio_6_flag = 0
								audio_6_flag = 1
								audio_6_timeout = game_timer + 6000
							ENDIF
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF

				//SNIPED IN CARS CHECK
				IF NOT IS_CHAR_DEAD	tank_dude2
					IF IS_CHAR_LEAVING_VEHICLE_TO_DIE tank_dude2
						IF NOT IS_CHAR_DEAD	tank_dude1
							SET_CHAR_OBJ_FLEE_PLAYER_ON_FOOT_TILL_SAFE tank_dude1 player1
							LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
							unlock_tank_flag = 2
							IF audio_6_flag = 0
								audio_6_flag = 1
								audio_6_timeout = game_timer + 6000
							ENDIF
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					ENDIF
				
					//STOP FOR DOUGHNUTS STUFF
					IF donut_stop_flag = 0
						IF LOCATE_CAR_2D tank -834.422 -634.884 5.0 5.0 0
							convoy_stop_flag = 1
							IF tank_dude2_obstruction_flag = 0
								LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
								unlock_tank_flag = 2
								IF audio_9_flag = 0
									audio_9_flag = 1
									audio_9_timeout = game_timer + 6000
								ENDIF
								SET_CHAR_OBJ_RUN_TO_COORD tank_dude2 -844.5248 -639.3130
								donut_stop_flag = 1
							ENDIF
						ENDIF
					ENDIF
					IF donut_stop_flag = 1
						IF LOCATE_CHAR_ON_FOOT_2D tank_dude2 -844.5248 -639.3130 1.0 1.0 0
							SET_CHAR_OBJ_RUN_TO_COORD tank_dude2 -850.9821 -633.8697
							donut_stop_flag = 2
						ENDIF
					ENDIF
					IF donut_stop_flag = 2
						IF LOCATE_CHAR_ON_FOOT_2D tank_dude2 -850.9821 -633.8697 1.0 1.0 0
							//DO CHAR CHATTING STUFF
							//CREATE_CHAR PEDTYPE_CIVMALE MALE01 -851.5631 -631.1492 10.3356 donut_dude
							//SET_CHAR_HEADING donut_dude 190.8128 //DONUT SHOP DUDE
							//SET_CHARS_CHATTING tank_dude2 donut_dude 2000
							donut_stop_timer = game_timer + 2000
							donut_stop_flag = 3
						ENDIF
					ENDIF
					IF donut_stop_flag = 3
						IF game_timer > donut_stop_timer
							SET_CHAR_OBJ_RUN_TO_COORD tank_dude2 -850.9821 -633.8697
							donut_stop_flag = 4
						ENDIF
					ENDIF

					IF donut_stop_flag = 4
						IF LOCATE_CHAR_ON_FOOT_2D tank_dude2 -850.9821 -633.8697 1.0 1.0 0
							SET_CHAR_OBJ_RUN_TO_COORD tank_dude2 -844.5248 -639.3130
							donut_stop_flag = 5
						ENDIF
					ENDIF
					IF donut_stop_flag = 5
						IF LOCATE_CHAR_ON_FOOT_2D tank_dude2 -844.5248 -639.3130 1.0 1.0 0
							SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	tank_dude2 tank
							donut_stop_flag = 6
						ENDIF
					ENDIF
					IF donut_stop_flag = 6
						IF IS_CHAR_IN_CAR tank_dude2 tank
							IF opened_garage_stuff = 0
								IF audio_10_flag = 0
									audio_10_flag = 1
									audio_10_timeout = game_timer + 6000
								ENDIF
								SET_TARGET_CAR_FOR_MISSION_GARAGE garage_col4_destination tank
								OPEN_GARAGE garage_col4_destination
								CREATE_CHAR PEDTYPE_CIVMALE ARMY -830.7947 -1500.0537 11.0670 garage_guard1
								SET_CHAR_HEADING garage_guard1 2.1778
								GIVE_WEAPON_TO_CHAR	garage_guard1 WEAPONTYPE_RUGER 9999
								CLEAR_CHAR_THREAT_SEARCH garage_guard1
								SET_CHAR_PERSONALITY garage_guard1 PEDSTAT_TOUGH_GUY
								SET_CHAR_ONLY_DAMAGED_BY_PLAYER garage_guard1 TRUE
								SET_CHAR_STAY_IN_SAME_PLACE	garage_guard1 TRUE
								SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
								CREATE_CHAR PEDTYPE_CIVMALE ARMY -824.3466 -1488.2743 10.9186 garage_guard2
								SET_CHAR_HEADING garage_guard2 117.4210
								GIVE_WEAPON_TO_CHAR	garage_guard2 WEAPONTYPE_RUGER 9999
								CLEAR_CHAR_THREAT_SEARCH garage_guard2
								SET_CHAR_PERSONALITY garage_guard2 PEDSTAT_TOUGH_GUY
								SET_CHAR_ONLY_DAMAGED_BY_PLAYER garage_guard2 TRUE
								SET_CHAR_STAY_IN_SAME_PLACE	garage_guard2 TRUE
								SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
								opened_garage_stuff = 1
							ENDIF
							IF player_close_to_tank = 0
								convoy_stop_flag = 0
								donut_stop_flag = 7
							ENDIF
							CAR_GOTO_COORDINATES_ACCURATE tank -838.3314 -1492.5 11.0623
						ENDIF
					ENDIF
				ELSE
					IF NOT tank_dude2_counter = 3
						IF attack_player = 0
							attack_player = 1
						ENDIF
					ENDIF
				ENDIF//IF NOT IS_CHAR_DEAD tank_dude2

				IF LOCATE_CAR_2D tank -838.3314 -1492.5 3.0 3.0 0
					IF player_hiding_in_warehouse = 0			
						IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -823.448 -1488.083 10.852 -841.991 -1480.591 16.165 30.0 0
							player_in_warehouse_flag = 1
						ELSE
							player_in_warehouse_flag = 0
						ENDIF
					ELSE
						player_in_warehouse_flag = 0
					ENDIF
				ELSE
					player_in_warehouse_flag = 0
				ENDIF

				//PLAYER CLOSE TO TANK STUFF
				IF formation_ped1_counter = 0
					IF formation_ped4_counter = 0
						IF player_close_to_tank = 0
							IF LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 tank 8.0 10.0 3.0 0
							OR player_in_warehouse_flag = 1
								IF close_to_tank_timer < game_timer
									GET_CHAR_COORDINATES formation_ped1	x y z
									GET_PLAYER_COORDINATES player1 player_x player_y z
									x_temp = x - player_x
									y_temp = y - player_y
									x_temp = x_temp * x_temp
									y_temp = y_temp * y_temp
									sum_x_y_temp = x_temp + y_temp
									SQRT sum_x_y_temp formation_ped1_distance
									GET_CHAR_COORDINATES formation_ped4	x y z
									x_temp = x - player_x
									y_temp = y - player_y
									x_temp = x_temp * x_temp
									y_temp = y_temp * y_temp
									sum_x_y_temp = x_temp + y_temp
									SQRT sum_x_y_temp formation_ped4_distance
									IF formation_ped4_distance > formation_ped1_distance
										CHAR_LOOK_AT_PLAYER_ALWAYS formation_ped1 player1
										formation_ped1_distance = -100.0
									ELSE
										CHAR_LOOK_AT_PLAYER_ALWAYS formation_ped4 player1
										formation_ped4_distance = -100.0
									ENDIF
									IF audio_13_flag = 0
										audio_13_flag = 1
										audio_13_timeout = game_timer + 6000
									ENDIF
									GET_GAME_TIMER game_timer_start
									game_timer_start += 5000
									player_close_to_tank = 1
								ENDIF
							ELSE
								close_to_tank_timer = game_timer + 2000
							ENDIF
						ENDIF

						IF player_close_to_tank = 1
							IF LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 tank 8.0 10.0 3.0 0
							OR player_in_warehouse_flag = 1
								IF game_timer > game_timer_start
									IF convoy_stop_flag = 0
										convoy_stop_flag = 1
									ENDIF
									player_close_to_tank = 2
									IF formation_ped1_distance = -100.0
										SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT formation_ped1 player1
									ELSE
										SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT formation_ped4 player1
									ENDIF
								ENDIF
							ELSE
								IF escort1_dude2_obstruction_flag = 0
								AND escort2_dude2_obstruction_flag = 0
								AND tank_dude2_obstruction_flag = 0
								AND escort3_dude2_obstruction_flag = 0
									IF donut_stop_flag = 0
									OR donut_stop_flag = 7
										convoy_stop_flag = 0
									ENDIF
								ENDIF
								player_close_to_tank = 0
							ENDIF
						ENDIF

						IF player_close_to_tank = 2
							IF LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 tank 8.0 10.0 3.0 0
							OR player_in_warehouse_flag = 1
								IF formation_ped1_distance = -100.0
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped1 4.0 4.0 0
										IF audio_17_flag = 0
											audio_17_flag = 1
											audio_17_timeout = game_timer + 6000
										ENDIF
										GET_GAME_TIMER game_timer_start
										game_timer_start +=	6000
										player_close_to_tank = 3
									ENDIF
								ELSE
									IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped4 4.0 4.0 0
										IF audio_17_flag = 0
											audio_17_flag = 1
											audio_17_timeout = game_timer + 6000
										ENDIF
										GET_GAME_TIMER game_timer_start
										game_timer_start +=	6000
										player_close_to_tank = 3
									ENDIF
								ENDIF
							ELSE
								IF escort1_dude2_obstruction_flag = 0
								AND escort2_dude2_obstruction_flag = 0
								AND tank_dude2_obstruction_flag = 0
								AND escort3_dude2_obstruction_flag = 0
									IF donut_stop_flag = 0
									OR donut_stop_flag = 7
										convoy_stop_flag = 0
									ENDIF
								ENDIF
								player_close_to_tank = 0
							ENDIF
						ENDIF

						IF player_close_to_tank = 3
							IF LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 tank 8.0 10.0 3.0 0
							OR player_in_warehouse_flag = 1
								IF game_timer > game_timer_start
									IF audio_16_flag = 0
										audio_16_flag = 1
										audio_16_timeout = game_timer + 6000
									ENDIF
									IF formation_ped1_distance = -100.0
										IF IS_PLAYER_IN_ANY_CAR	player1
											STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
											SET_CHAR_OBJ_DESTROY_CAR formation_ped1 players_car
										ELSE
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped1 player1
										ENDIF
									ELSE
										IF IS_PLAYER_IN_ANY_CAR	player1
											STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 players_car
											SET_CHAR_OBJ_DESTROY_CAR formation_ped4 players_car
										ELSE
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped4 player1
										ENDIF
									ENDIF
									IF LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 tank 2.0 2.0 1.0 0
										IF audio_11_flag = 0
											audio_11_flag = 1
											audio_11_timeout = game_timer + 6000
										ENDIF
										IF NOT IS_CHAR_DEAD	tank_dude2
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT tank_dude2 player1
										ENDIF
										LOCK_CAR_DOORS tank CARLOCK_UNLOCKED
										unlock_tank_flag = 2
									ENDIF
									player_close_to_tank = 4
								ENDIF
							ELSE
								IF escort1_dude2_obstruction_flag = 0
								AND escort2_dude2_obstruction_flag = 0
								AND tank_dude2_obstruction_flag = 0
								AND escort3_dude2_obstruction_flag = 0
									IF donut_stop_flag = 0
									OR donut_stop_flag = 7
										convoy_stop_flag = 0
									ENDIF
								ENDIF
								player_close_to_tank = 0
							ENDIF
						ENDIF
						IF player_close_to_tank = 4
							IF NOT LOCATE_PLAYER_ANY_MEANS_CAR_3D player1 tank 8.0 10.0 3.0 0
							AND player_in_warehouse_flag = 0
								IF NOT IS_CHAR_DEAD	tank_dude2
									IF NOT IS_CHAR_IN_CAR tank_dude2 tank
										SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	tank_dude2 tank
									ENDIF
								ENDIF
								IF escort1_dude2_obstruction_flag = 0
								AND escort2_dude2_obstruction_flag = 0
								AND tank_dude2_obstruction_flag = 0
								AND escort3_dude2_obstruction_flag = 0
									IF donut_stop_flag = 0
									OR donut_stop_flag = 7
										convoy_stop_flag = 0
									ENDIF
								ENDIF
								player_close_to_tank = 0
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ELSE
				IF NOT player_close_to_tank = -1
					SET_CAR_DRIVING_STYLE tank 3
					player_close_to_tank = -1
				ENDIF
			ENDIF

			IF NOT LOCATE_CAR_2D tank -838.3314 -1490.4927 50.0 50.0 0
				tank_not_home = 1
			ELSE
				tank_not_home = 0
			ENDIF
		
			IF NOT flag_escort2_unusable = 1
				x_temp = tank_x - escort2_x
				y_temp = tank_y - escort2_y
				x_temp = x_temp * x_temp
				y_temp = y_temp * y_temp
				sum_x_y_temp = x_temp + y_temp
				SQRT sum_x_y_temp sum_x_y_temp
				IF escort2_dist_from_dest > tank_dist_from_dest
					IF tank_not_home = 1
						sum_x_y_temp = 5.0
					ELSE
						sum_x_y_temp = 10.0
					ENDIF
				ENDIF
			ELSE
				IF NOT flag_escort1_unusable = 1
					x_temp = tank_x - escort1_x
					y_temp = tank_y - escort1_y
					x_temp = x_temp * x_temp
					y_temp = y_temp * y_temp
					sum_x_y_temp = x_temp + y_temp
					SQRT sum_x_y_temp sum_x_y_temp
					IF escort1_dist_from_dest > tank_dist_from_dest
						IF tank_not_home = 1
							sum_x_y_temp = 5.0
						ELSE
							sum_x_y_temp = 10.0
						ENDIF
					ENDIF
				ELSE
					sum_x_y_temp = 12.0
				ENDIF
			ENDIF
			
			tank_speed = sum_x_y_temp - 5.0
			IF tank_speed > 100.0
				tank_speed = 100.0
			ENDIF
			IF tank_speed < 0.0
				tank_speed = 0.0
			ENDIF
			
			IF tank_not_home = 1
				tank_distance_from_vehicle_behind = escort3_dist_from_dest - tank_dist_from_dest
				IF tank_distance_from_vehicle_behind > 20.0
					tank_speed = 0.0
				ENDIF
			ENDIF

			IF convoy_stop_flag = 0
				IF tank_speed = 0.0
					SET_CAR_TEMP_ACTION tank TEMPACT_WAIT 500
				ELSE
					SET_CAR_CRUISE_SPEED tank tank_speed
				ENDIF
			ELSE
				tank_speed = 0.0
				SET_CAR_TEMP_ACTION tank TEMPACT_WAIT 500
			ENDIF
			IF donut_stop_flag = 0
			OR donut_stop_flag = 7
				IF NOT tank_dude2_counter = 3
					army_vehicle = tank
					army_soldier = tank_dude2
					army_vehicle_z = tank_z
					GOSUB if_in_front_of_army_vehicle
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD	tank_attached_dude
				GET_CHAR_COORDINATES tank_attached_dude x y z
				DETACH_CHAR_FROM_CAR tank_attached_dude
				z += 0.5
				SET_CHAR_COORDINATES tank_attached_dude x y z
			ENDIF
			IF tank_mission_flag = 0
				IF audio_4_flag = 0
					//audio_4_flag = 1 // FIXMIAMI: removed
					GOSUB check_any_alive_soldier_near_tank // FIXMIAMI
					audio_4_timeout = game_timer + 6000
				ENDIF
				initiate_seft_destruct_timer = game_timer + 6000
				PRINT_NOW COL4_B3 5000 1//"Drop the tank off for the Colonel"
				print_timer = game_timer + 5000
				REMOVE_BLIP tank_blip
				ADD_BLIP_FOR_COORD -1053.5721 -478.0450 11.2887 tank_blip
				//SWITCH_ROADS_ON -877.0355 -1502.6396 -2.4916 -477.6842 685.0324 52.1452
				SWITCH_ROADS_ON -721.211 243.998 5.0 -651.211 693.998 25.0
				SWITCH_ROADS_ON -760.362 101.883 5.0 -700.362 251.883 25.0
				SWITCH_ROADS_ON -783.906 -46.826 5.0 -723.906 103.174 25.0
				SWITCH_ROADS_ON -853.397 -149.692 5.0 -773.397 0.308 25.0
				SWITCH_ROADS_ON -870.656 -594.54 5.0 -810.656 -144.54 25.0
				SWITCH_ROADS_ON -837.282 -1041.814 5.0 -777.282 -591.814 25.0
				SWITCH_ROADS_ON -827.532 -1539.617 5.0 -747.532 -1039.617 25.0
				players_tank = tank
				SET_TARGET_CAR_FOR_MISSION_GARAGE garage_col4_dropoff players_tank
				SET_TANK_DETONATE_CARS tank TRUE
				tank = -1
				player_in_tank_flag = 1
				attack_player = 1
				tank_mission_flag = 1
				IF NOT IS_CHAR_DEAD	formation_ped1
					SET_CHAR_THREAT_SEARCH formation_ped1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped1	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED formation_ped1
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped2
					SET_CHAR_THREAT_SEARCH formation_ped2 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped2	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED formation_ped2
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped3
					SET_CHAR_THREAT_SEARCH formation_ped3 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped3	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED formation_ped3
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped4
					SET_CHAR_THREAT_SEARCH formation_ped4 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped4	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED formation_ped4
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped5
					SET_CHAR_THREAT_SEARCH formation_ped5 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped5	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED formation_ped5
				ENDIF
				IF NOT IS_CHAR_DEAD	formation_ped6
					SET_CHAR_THREAT_SEARCH formation_ped6 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT formation_ped6	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED formation_ped6
				ENDIF
				IF NOT IS_CHAR_DEAD	tank_dude1
					SET_CHAR_THREAT_SEARCH tank_dude1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT tank_dude1	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED tank_dude1
				ENDIF
				IF NOT IS_CHAR_DEAD	tank_dude2
					SET_CHAR_THREAT_SEARCH tank_dude2 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT tank_dude2	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED tank_dude2
				ENDIF
				IF NOT IS_CHAR_DEAD	escort1_dude1
					SET_CHAR_THREAT_SEARCH escort1_dude1 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort1_dude1	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED escort1_dude1
				ENDIF
				IF NOT IS_CHAR_DEAD	escort1_dude2
					SET_CHAR_THREAT_SEARCH escort1_dude2 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort1_dude2	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED escort1_dude2
				ENDIF
				IF NOT IS_CHAR_DEAD	escort2_dude2
					SET_CHAR_THREAT_SEARCH escort2_dude2 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort2_dude2	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED escort2_dude2
				ENDIF
				IF NOT IS_CHAR_DEAD	escort3_dude2
					SET_CHAR_THREAT_SEARCH escort3_dude2 THREAT_PLAYER1
					SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort3_dude2	player1
					MARK_CHAR_AS_NO_LONGER_NEEDED escort3_dude2
				ENDIF
				MARK_CAR_AS_NO_LONGER_NEEDED escort1
				MARK_CAR_AS_NO_LONGER_NEEDED escort2
				MARK_CAR_AS_NO_LONGER_NEEDED escort3
			ENDIF
		ENDIF
	ELSE
		IF tank_mission_flag = 0
			PRINT_NOW COL4_B5 5000 1//"~r~The tank has been destroyed!"
			GOTO mission_general4_failed
		ENDIF
	ENDIF
ENDIF


//////////////////////////////////////////////////////////////////////////
//PLAYER IN TANK BIT//////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

IF tank_mission_flag = 1
	IF IS_CAR_IN_MISSION_GARAGE garage_col4_dropoff
	 	GOTO mission_general4_passed
	ENDIF
	
	IF IS_CAR_DEAD players_tank
		PRINT_NOW COL4_B5 5000 1//"~r~The tank has been destroyed!"
		GOTO mission_general4_failed
	ENDIF
	
	IF NOT LOCATE_CAR_2D players_tank -1058.095 -478.054 30.0 30.0 0
		ALTER_WANTED_LEVEL_NO_DROP player1 3
	ELSE
		ALTER_WANTED_LEVEL player1 0
	ENDIF
	
	IF IS_PLAYER_IN_CAR player1 players_tank
		IF got_garage_help = 0
			IF LOCATE_PLAYER_IN_CAR_3D player1 -1058.095 -478.054 10.0896 4.0 4.0 3.0 1
				PRINT_NOW COL4_B7 5000 1//Drive the tank into the garage.
				print_timer = game_timer + 5000
				got_garage_help = 1
			ENDIF
		ENDIF
		IF got_garage_help = 1
			IF LOCATE_PLAYER_IN_CAR_3D player1 -1043.661 -476.886 12.038 7.0 8.0 2.0 0
				PRINT_NOW COL4_B8 5000 1//Get out of the tank and walk out of the garage.
				print_timer = game_timer + 5000
				got_garage_help = 2
			ENDIF
		ENDIF
		IF player_in_tank_flag = 0
			REMOVE_BLIP	tank_blip
			ADD_BLIP_FOR_COORD -1053.5721 -478.0450 11.2887 tank_blip
			player_in_tank_flag = 1
		ENDIF
	ELSE
		IF player_in_tank_flag = 1
			IF NOT got_garage_help = 2
				REMOVE_BLIP	tank_blip
				ADD_BLIP_FOR_CAR players_tank tank_blip
				player_in_tank_flag = 0
			ENDIF
		ENDIF
	ENDIF
	
	IF game_timer > initiate_seft_destruct_timer
		IF initiate_seft_destruct_flag = 0
			IF audio_1_flag = 0
				audio_1_flag = 1
				audio_1_timeout = game_timer + 6000
			ENDIF
			DISPLAY_ONSCREEN_COUNTER_WITH_STRING tank_detonation_timer COUNTER_DISPLAY_BAR DETON
			initiate_seft_destruct_flag = 1
		ENDIF
	ENDIF
	
	IF initiate_seft_destruct_flag > 0
		IF tank_detonation_timer_float > 100.0
			tank_detonation_timer = 100
			EXPLODE_CAR	players_tank
		ELSE
			tank_detonation_timer_float +=@ 0.017//REDUCE THIS TO INCREASE THE TIMER
			tank_detonation_timer =# tank_detonation_timer_float
		ENDIF

		IF tank_detonation_timer > 95
			IF initiate_seft_destruct_flag = 1
				IF audio_2_flag = 0
					audio_2_flag = 1
					audio_2_timeout = game_timer + 6000
				ENDIF
				initiate_seft_destruct_flag = 2
			ENDIF
		ENDIF
	ENDIF
ENDIF


//////////////////////////////////////////////////////////////////////////
//WAREHOUSE STUFF/////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
IF opened_garage_stuff > 0
	IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -823.448 -1488.083 10.852 -841.991 -1480.591 16.165 30.0 0
		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -833.708 -1509.877 12.489 4.0 6.0 1.5 0
			IF NOT IS_CHAR_DEAD	garage_guard1
				IF garage_guard1_flag = 0
					SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD garage_guard1 -838.6741 -1498.0697
					SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
					garage_guard1_flag = 1
				ENDIF
				IF garage_guard1_flag = 1
					IF LOCATE_CHAR_ON_FOOT_2D garage_guard1	-838.6741 -1498.0697 1.0 1.0 0
						SET_CHAR_OBJ_RUN_TO_COORD garage_guard1 -845.7342 -1501.9176
						SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
						garage_guard1_flag = 2
					ENDIF
				ENDIF
				IF garage_guard1_flag = 2
					IF LOCATE_CHAR_ON_FOOT_2D garage_guard1	-845.7342 -1501.9176 1.0 1.0 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT garage_guard1 player1
						garage_guard1_flag = 3
					ENDIF
				ENDIF
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED garage_guard1
				IF NOT IS_CHAR_DEAD	garage_guard2
					IF garage_guard2_flag = 0
						SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
						SET_CHAR_OBJ_RUN_TO_COORD garage_guard2 -838.6741 -1498.0697
						SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
						garage_guard2_flag = 1
					ENDIF
					IF garage_guard2_flag = 1
						IF LOCATE_CHAR_ON_FOOT_2D garage_guard2	-838.6741 -1498.0697 1.0 1.0 0
							SET_CHAR_OBJ_RUN_TO_COORD garage_guard2 -845.7342 -1501.9176
							SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
							garage_guard2_flag = 2
						ENDIF
					ENDIF
					IF garage_guard2_flag = 2
						IF LOCATE_CHAR_ON_FOOT_2D garage_guard2	-845.7342 -1501.9176 1.0 1.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT garage_guard2 player1
							garage_guard2_flag = 3
						ENDIF
					ENDIF
				ELSE
					MARK_CHAR_AS_NO_LONGER_NEEDED garage_guard2
					player_hiding_in_warehouse = 1
				ENDIF
			ENDIF
		ELSE
			IF NOT IS_CHAR_DEAD	garage_guard1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT garage_guard1 player1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED garage_guard1
			ENDIF
			IF NOT IS_CHAR_DEAD	garage_guard2
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT garage_guard2 player1
			ELSE
				MARK_CHAR_AS_NO_LONGER_NEEDED garage_guard2
			ENDIF
			player_hiding_in_warehouse = 0
		ENDIF
	ELSE
		IF NOT IS_CHAR_DEAD	garage_guard1
			IF garage_guard1_flag = 0
				IF LOCATE_CHAR_ON_FOOT_2D garage_guard1	-830.7947 -1500.0537 1.0 1.0 0
					SET_CHAR_OBJ_NO_OBJ	garage_guard1
					SET_CHAR_HEADING garage_guard1 2.1778
				ENDIF
			ENDIF
			IF garage_guard1_flag = 1
				SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD garage_guard1 -830.7947 -1500.0537
				SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
				garage_guard1_flag = 0
			ENDIF
			IF garage_guard1_flag = 3
				SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD garage_guard1 -839.5587 -1496.7245
				SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
				garage_guard1_flag = 2
			ENDIF
			IF garage_guard1_flag = 2
				SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD garage_guard1 -839.5587 -1496.7245
				SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
				IF LOCATE_CHAR_ON_FOOT_2D garage_guard1	-839.5587 -1496.7245 1.0 1.0 0
					SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD garage_guard1 -830.7947 -1500.0537
					SET_CHAR_USE_PEDNODE_SEEK garage_guard1 FALSE
					garage_guard1_flag = 0
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED garage_guard1
		ENDIF
		IF NOT IS_CHAR_DEAD	garage_guard2
			IF garage_guard2_flag = 0
				IF LOCATE_CHAR_ON_FOOT_2D garage_guard2	-824.3466 -1488.2743 1.0 1.0 0
					SET_CHAR_OBJ_NO_OBJ	garage_guard2
					SET_CHAR_HEADING garage_guard2 117.4210
				ENDIF
			ENDIF
			IF garage_guard2_flag = 1
				SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD garage_guard2 -824.3466 -1488.2743
				SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
				garage_guard2_flag = 0
			ENDIF
			IF garage_guard2_flag = 3
				SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD garage_guard2 -839.5587 -1496.7245
				SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
				garage_guard2_flag = 2
			ENDIF
			IF garage_guard2_flag = 2
				SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
				SET_CHAR_OBJ_RUN_TO_COORD garage_guard2 -839.5587 -1496.7245
				SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
				IF LOCATE_CHAR_ON_FOOT_2D garage_guard2	-839.5587 -1496.7245 1.0 1.0 0
					SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
					SET_CHAR_OBJ_RUN_TO_COORD garage_guard2 -824.3466 -1488.2743
					SET_CHAR_USE_PEDNODE_SEEK garage_guard2 FALSE
					garage_guard2_flag = 0
				ENDIF
			ENDIF
		ELSE
			MARK_CHAR_AS_NO_LONGER_NEEDED garage_guard2
		ENDIF
	ENDIF
ENDIF

//-826.4618 -1493.2281//1ST GOTO
//-823.1886 -1494.2570//2ND GOTO
IF dudes_go_into_doorway = 1
	IF audio_3_flag = 0
		audio_3_flag = 1
		audio_3_timeout = game_timer + 6000
	ENDIF
	IF NOT IS_CHAR_DEAD	formation_ped1
		gosub_armydude = formation_ped1
		gosub_armydude_counter = formation_ped1_counter
		GOSUB armydudes_go_into_doorway
		formation_ped1_counter = gosub_armydude_counter
	ELSE
		IF NOT formation_ped1_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	formation_ped2
		gosub_armydude = formation_ped2
		gosub_armydude_counter = formation_ped2_counter
		GOSUB armydudes_go_into_doorway
		formation_ped2_counter = gosub_armydude_counter
	ELSE
		IF NOT formation_ped2_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	formation_ped3
		gosub_armydude = formation_ped3
		gosub_armydude_counter = formation_ped3_counter
		GOSUB armydudes_go_into_doorway
		formation_ped3_counter = gosub_armydude_counter
	ELSE
		IF NOT formation_ped3_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	formation_ped4
		gosub_armydude = formation_ped4
		gosub_armydude_counter = formation_ped4_counter
		GOSUB armydudes_go_into_doorway
		formation_ped4_counter = gosub_armydude_counter
	ELSE
		IF NOT formation_ped4_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	formation_ped5
		gosub_armydude = formation_ped5
		gosub_armydude_counter = formation_ped5_counter
		GOSUB armydudes_go_into_doorway
		formation_ped5_counter = gosub_armydude_counter
	ELSE
		IF NOT formation_ped5_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	formation_ped6
		gosub_armydude = formation_ped6
		gosub_armydude_counter = formation_ped6_counter
		GOSUB armydudes_go_into_doorway
		formation_ped6_counter = gosub_armydude_counter
	ELSE
		IF NOT formation_ped6_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	escort1_dude1
		gosub_armydude = escort1_dude1
		gosub_armydude_counter = escort1_dude1_counter
		GOSUB armydudes_go_into_doorway
		escort1_dude1_counter = gosub_armydude_counter
	ELSE
		IF NOT escort1_dude1_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	escort1_dude2
		gosub_armydude = escort1_dude2
		gosub_armydude_counter = escort1_dude2_counter
		GOSUB armydudes_go_into_doorway
		escort1_dude2_counter = gosub_armydude_counter
	ELSE
		IF NOT escort1_dude2_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	tank_dude1
		gosub_armydude = tank_dude1
		gosub_armydude_counter = tank_dude1_counter
		GOSUB armydudes_go_into_doorway
		tank_dude1_counter = gosub_armydude_counter
	ELSE
		IF NOT tank_dude1_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	tank_dude2
		gosub_armydude = tank_dude2
		gosub_armydude_counter = tank_dude2_counter
		GOSUB armydudes_go_into_doorway
		tank_dude2_counter = gosub_armydude_counter
	ELSE
		IF NOT tank_dude2_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
	IF NOT IS_CHAR_DEAD	tank_attached_dude


		IF tank_attached_dude_counter = 0
			DETACH_CHAR_FROM_CAR tank_attached_dude
			GET_CHAR_COORDINATES tank_attached_dude	x y z
			z += 1.0
			SET_CHAR_COORDINATES tank_attached_dude	x y z
			SET_CHAR_HEED_THREATS tank_attached_dude TRUE
			SET_CHAR_THREAT_SEARCH tank_attached_dude THREAT_PLAYER1
			SET_CHAR_OBJ_RUN_TO_COORD tank_attached_dude -829.7494 -1491.9958
			SET_CHAR_USE_PEDNODE_SEEK tank_attached_dude FALSE
			tank_attached_dude_counter = 1
		ENDIF
		IF tank_attached_dude_counter = 1
			IF IS_CHAR_OBJ_NO_OBJ tank_attached_dude
				SET_CHAR_OBJ_RUN_TO_COORD tank_attached_dude -829.7494 -1491.9958
				SET_CHAR_USE_PEDNODE_SEEK tank_attached_dude FALSE
			ENDIF
			IF LOCATE_CHAR_ON_FOOT_2D tank_attached_dude -829.7494 -1491.9958 1.0 1.0 0
				SET_CHAR_OBJ_RUN_TO_COORD tank_attached_dude -826.0425 -1493.5173
				SET_CHAR_USE_PEDNODE_SEEK tank_attached_dude FALSE
				tank_attached_dude_counter = 2
			ENDIF
		ENDIF
		IF tank_attached_dude_counter = 2
			IF IS_CHAR_OBJ_NO_OBJ tank_attached_dude
				SET_CHAR_OBJ_RUN_TO_COORD tank_attached_dude -826.0425 -1493.5173
				SET_CHAR_USE_PEDNODE_SEEK tank_attached_dude FALSE
			ENDIF
			IF LOCATE_CHAR_ON_FOOT_2D tank_attached_dude -826.0425 -1493.5173 1.0 1.0 0
				DELETE_CHAR	tank_attached_dude
				tank_attached_dude_counter = 3
			ENDIF
		ENDIF
	ELSE
		IF NOT tank_attached_dude_counter = 3
			attack_player = 1
		ENDIF
	ENDIF
ENDIF
//////////////////////////////////////////////////////////////////////////
//ESCORT3 STUFF///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
IF frame_counter = 3
	IF NOT IS_CAR_DEAD escort3
		IF NOT IS_PLAYER_IN_CAR	player1 escort3
			IF NOT IS_CHAR_DEAD	escort3_dude1
				IF IS_CHAR_IN_CAR escort3_dude1	escort3
					GET_CAR_COORDINATES	escort3 escort3_x escort3_y escort3_z

					x_temp = escort3_x - -837.0244
					y_temp = escort3_y - -1509.2794
					x_temp = x_temp * x_temp
					y_temp = y_temp * y_temp
					sum_x_y_temp = x_temp + y_temp
					SQRT sum_x_y_temp escort3_dist_from_dest
					
					IF attack_player = 0
						
						IF NOT IS_CHAR_DEAD escort3_dude2
							IF escort3_dude2_obstruction_flag = 5
								IF IS_CHAR_IN_CAR escort3_dude2 escort3
									escort3_dude2_obstruction_flag = 0
									IF donut_stop_flag = 0
									OR donut_stop_flag = 7
										convoy_stop_flag = 0
									ENDIF
								ELSE
									IF IS_CHAR_IN_ANY_CAR escort3_dude2
										STORE_CAR_CHAR_IS_IN_NO_SAVE escort3_dude2 escort3_dude2_car
										SET_CHAR_OBJ_LEAVE_CAR escort3_dude2 escort3_dude2_car
									ELSE
										SET_CHAR_OBJ_ENTER_CAR_AS_PASSENGER	escort3_dude2 escort3
									ENDIF
								ENDIF
							ENDIF
						ELSE
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
						
						IF IS_CHAR_DEAD escort3_dude1
							IF attack_player = 0
								attack_player = 1
							ENDIF
						ENDIF
					
						IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON escort3 WEAPONTYPE_RAMMEDBYCAR
							IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 escort3 20.0 20.0 0
								escort3_has_been_rammed_by_player = 1
							ENDIF
						ENDIF
						
						IF HAS_CAR_BEEN_DAMAGED_BY_WEAPON escort3 WEAPONTYPE_ANYWEAPON
							GET_CAR_HEALTH escort3 escort3_health
							IF escort3_health < 800
								attack_player = 1
							ENDIF
						ENDIF

						CLEAR_CAR_LAST_WEAPON_DAMAGE escort3
						
						x_temp = escort3_x - tank_x
						y_temp = escort3_y - tank_y
						x_temp = x_temp * x_temp
						y_temp = y_temp * y_temp
						sum_x_y_temp = x_temp + y_temp
						SQRT sum_x_y_temp sum_x_y_temp
						
						escort3_speed = sum_x_y_temp - 4.0
						IF escort3_speed > 100.0
							escort3_speed = 100.0
						ENDIF
						IF escort3_speed < 0.0
							escort3_speed = 0.0
						ENDIF
						IF NOT LOCATE_CAR_2D escort3 -838.3314 -1490.4927 50.0 50.0	0
							IF tank_dist_from_dest > escort3_dist_from_dest
								escort3_speed = 0.0
							ENDIF
						ELSE
							SET_CAR_STRAIGHT_LINE_DISTANCE escort3 40
						ENDIF
						//IF donut_stop_flag = 0
						//OR donut_stop_flag = 7
							army_vehicle = escort3
							army_soldier = escort3_dude2
							army_vehicle_z = escort3_z
							GOSUB if_in_front_of_army_vehicle
						//ENDIF
						
						IF convoy_stop_flag = 0
							IF escort3_speed = 0.0
								SET_CAR_TEMP_ACTION escort3 TEMPACT_WAIT 500
							ELSE
								SET_CAR_CRUISE_SPEED escort3 escort3_speed
							ENDIF
						ELSE
							escort3_speed = 0.0
							SET_CAR_TEMP_ACTION escort3 TEMPACT_WAIT 500
						ENDIF
					ELSE
						IF player_nearish_to_tank_flag = 1 
							IF escort3_attack_player = 2
							OR escort3_attack_player = 3
								escort3_attack_player = 0
							ENDIF
							IF escort3_attack_player = 0
								SET_CAR_CRUISE_SPEED escort3 100.0
								SET_CAR_DRIVING_STYLE escort3 2
								SET_CAR_MISSION escort3 MISSION_RAMPLAYER_FARAWAY
								escort3_attack_player = 1
							ENDIF
							IF escort3_attack_player = 1
								IF escort3_ram_player_counter = 10
									IF LOCATE_PLAYER_ANY_MEANS_CAR_2D player1 escort3 20.0 20.0 0
										IF NOT IS_CHAR_DEAD	escort3_dude2
											SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort3_dude2 player1
										ENDIF
									ENDIF
									escort3_ram_player_counter = 0
								ELSE
									++ escort3_ram_player_counter
								ENDIF
							ENDIF
						ELSE
							IF escort3_attack_player = 0
							OR escort3_attack_player = 1
								escort3_attack_player = 2
							ENDIF
							IF escort3_attack_player = 2
								SET_CAR_CRUISE_SPEED escort3 100.0
								SET_CAR_DRIVING_STYLE escort3 2
								CAR_GOTO_COORDINATES escort3 tank_x tank_y tank_z
								escort3_attack_player = 3
							ENDIF
							IF escort3_attack_player = 3
								IF LOCATE_CAR_2D escort3 tank_x tank_y 20.0 20.0 0
									SET_CAR_MISSION	escort3 MISSION_STOP_FOREVER
									SET_CAR_TEMP_ACTION escort3 TEMPACT_WAIT 500
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ELSE//IS_CHAR_IN_CAR
					IF attack_player = 0
						attack_player = 1
					ENDIF
				ENDIF
			ELSE//IS_CHAR_DEAD
				IF attack_player = 0
					attack_player = 1
				ENDIF
			ENDIF
		ELSE
			SET_CAR_ONLY_DAMAGED_BY_PLAYER escort3 FALSE
			IF NOT IS_CHAR_DEAD	escort3_dude1
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort3_dude1 player1
			ENDIF
			IF NOT IS_CHAR_DEAD	escort3_dude2
				SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT escort3_dude2 player1
			ENDIF
			IF attack_player = 0
				attack_player = 1
			ENDIF
		ENDIF
	ELSE
		IF attack_player = 0
			attack_player = 1
		ENDIF
	ENDIF

	//////////////////////////////////////////////////////////////////////////
	//SHOOTING FROM ESCORT3 STUFF/////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////
	shooting_ped = escort3_attached_01
	shooting_peds_car = escort3
	shooting_peds_car_driver = escort3_dude1
	shooting_ped_flag = escort3_attached_01_flag
	GOSUB shooting_from_vehicle_stuff
	escort3_attached_01_flag = shooting_ped_flag
	
	shooting_ped = escort3_attached_02
	shooting_peds_car = escort3
	shooting_peds_car_driver = escort3_dude1
	shooting_ped_flag = escort3_attached_02_flag
	GOSUB shooting_from_vehicle_stuff
	escort3_attached_02_flag = shooting_ped_flag
	
	shooting_ped = escort3_attached_03
	shooting_peds_car = escort3
	shooting_peds_car_driver = escort3_dude1
	shooting_ped_flag = escort3_attached_03_flag
	GOSUB shooting_from_vehicle_stuff
	escort3_attached_03_flag = shooting_ped_flag
	
	shooting_ped = escort3_attached_04
	shooting_peds_car = escort3
	shooting_peds_car_driver = escort3_dude1
	shooting_ped_flag = escort3_attached_04_flag
	GOSUB shooting_from_vehicle_stuff
	escort3_attached_04_flag = shooting_ped_flag

ENDIF//frame_counter

//////////////////////////////////////////////////////////////////////////
//AUDIO STUFF/////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////

IF NOT convoy_stop_flag = last_convoy_stop_flag
	last_convoy_stop_flag = convoy_stop_flag
	IF convoy_stop_flag = 1
		IF audio_14_flag = 0
			audio_14_flag = 1
			audio_14_timeout = game_timer + 6000
		ENDIF
	ELSE
		IF audio_15_flag = 0
			audio_15_flag = 1
			audio_15_timeout = game_timer + 6000
		ENDIF
	ENDIF
ENDIF

IF audio_1_flag > 0
	IF audio_1_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_24
			audio_1_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_1_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_24 10000 1//Security protocol Delta India Echo triggered! Vehicle self destruct initiated!
			ENDIF
			audio_1_flag = 3
		ENDIF
	ENDIF
	IF audio_1_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_24
			audio_1_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_1_timeout
				audio_1_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_1_flag > 0
		IF audio_1_flag > 1
			audio_1_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_1_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_2_flag > 0
	IF audio_2_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_26
			audio_2_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_2_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_26 10000 1//Prepare to die Communist scum!
			ENDIF
			audio_2_flag = 3
		ENDIF
	ENDIF
	IF audio_2_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_26
			audio_2_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_2_timeout
				audio_2_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_2_flag > 0
		IF audio_2_flag > 1
			audio_2_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_2_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_3_flag > 0
AND	player_near_tank_flag = 1
	IF audio_3_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_23
			audio_3_flag = 4
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_3_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_23 10000 1//Sergeant: Objective completed! Platoon dismissed! - Marine: Lets go eat some of those doughnuts.
			ENDIF
			audio_3_flag = 3
		ENDIF
	ENDIF
	IF audio_3_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_23
			audio_3_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_3_timeout
				audio_3_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_3_flag > 0
		IF audio_3_flag > 1
			audio_3_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_3_flag = 0
		ENDIF
	ENDIF
ENDIF


IF audio_4_flag > 0
AND	player_near_tank_flag = 1
	IF audio_4_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_12
			audio_4_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_4_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_12 10000 1//Marine: Someone's in the TANK!  STOP HIM!
			ENDIF
			audio_4_flag = 3
		ENDIF
	ENDIF
	IF audio_4_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_12
			audio_4_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_4_timeout
				audio_4_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_4_flag > 0
		IF audio_4_flag > 1
			audio_4_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_4_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_6_flag > 0
AND	player_near_tank_flag = 1
	IF audio_6_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_21
			audio_6_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_6_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_21 10000 1//Marine: SNIPER! AAARRRRGGGGHHHhhhhhhh! (as the other passenger runs away)
			ENDIF
			audio_6_flag = 3
		ENDIF
	ENDIF
	IF audio_6_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_21
			audio_6_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_6_timeout
				audio_6_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_6_flag > 0
		IF audio_6_flag > 1
			audio_6_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_6_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_7_flag > 0
AND	player_near_tank_flag = 1
	IF audio_7_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_22
			audio_7_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_7_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_22 10000 1//Sergeant: I'm getting out of here, AAARRRRGGGGHHHhhhhhhh!
			ENDIF
			audio_7_flag = 3
		ENDIF
	ENDIF
	IF audio_7_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_22
			audio_7_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_7_timeout
				audio_7_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_7_flag > 0
		IF audio_7_flag > 1
			audio_7_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_7_flag = 0
		ENDIF
	ENDIF
ENDIF

IF attack_player > 0
AND	player_near_tank_flag = 1
	IF audio_5_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_9
			audio_5_flag = 4
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_5_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_9 10000 1//Sergeant: We are under attack.  DEFENSIVE POSITIONS!
			ENDIF
			audio_5_flag = 3
		ENDIF
	ENDIF
	IF audio_5_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_9
			audio_5_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_5_timeout
				audio_5_flag = 0 
			ENDIF
		ENDIF
	ENDIF
	IF audio_5_flag = 0
		audio_5_timeout = game_timer + 6000
		audio_5_flag = 1
	ENDIF
ELSE
	IF audio_5_flag > 0
		IF audio_5_flag > 1
			IF NOT audio_5_flag = 4
				audio_5_flag = 0
			ENDIF
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_5_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_8_flag > 0
AND	player_near_tank_flag = 1
	IF audio_8_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_6
			audio_8_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_8_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_6 10000 1//Marine: The gunner is dead, WE ARE UNDER ATTACK!
			ENDIF
			audio_8_flag = 3
		ENDIF
	ENDIF
	IF audio_8_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_6
			audio_8_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_8_timeout
				audio_8_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_8_flag > 0
		IF audio_8_flag > 1
			audio_8_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_8_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_9_flag > 0
AND	player_near_tank_flag = 1
	IF audio_9_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_19
			audio_9_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_9_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_19 10000 1//Sergeant: Go get some doughnuts, soldier! - Marine: Sir, Yes Sir!
			ENDIF
			audio_9_flag = 3
		ENDIF
	ENDIF
	IF audio_9_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_19
			audio_9_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_9_timeout
				audio_9_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_9_flag > 0
		IF audio_9_flag > 1
			audio_9_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_9_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_10_flag > 0
AND	player_near_tank_flag = 1
	IF audio_10_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_20
			audio_10_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_10_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_20 10000 1//Marine: Target acquired, Sir
			ENDIF
			audio_10_flag = 3
		ENDIF
	ENDIF
	IF audio_10_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_20
			audio_10_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_10_timeout
				audio_10_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_10_flag > 0
		IF audio_10_flag > 1
			audio_10_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_10_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_11_flag > 0
AND	player_near_tank_flag = 1
	IF audio_11_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_18
			audio_11_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_11_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_18 10000 1//Marine: Sir! Someone's on the tank, Sir!
			ENDIF
			audio_11_flag = 3
		ENDIF
	ENDIF
	IF audio_11_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_18
			audio_11_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_11_timeout
				audio_11_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_11_flag > 0
		IF audio_11_flag > 1
			audio_11_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_11_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_12_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_12_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_1
			audio_12_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_12_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_1 10000 1//Sergeant: What's up with the Gunner? - Marine: Don't know Sir!
			ENDIF
			audio_12_flag = 3
		ENDIF
	ENDIF
	IF audio_12_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_1
			audio_12_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_12_timeout
				audio_12_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_12_flag > 0
		IF audio_12_flag > 1
			audio_12_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_12_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_21_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_21_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_4
			audio_21_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_21_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_4 10000 1//Sergeant: Get topside soldier. - Soldier: Sir, yes Sir!
			ENDIF
			audio_21_flag = 3
		ENDIF
	ENDIF
	IF audio_21_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_4
			audio_21_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_21_timeout
				audio_21_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_21_flag > 0
		IF audio_21_flag > 1
			audio_21_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_21_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_14_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_14_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_3
			audio_14_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_14_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_3 10000 1//Sergeant: HALT CONVOY!
			ENDIF
			audio_14_flag = 3
		ENDIF
	ENDIF
	IF audio_14_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_3
			audio_14_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_14_timeout
				audio_14_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_14_flag > 0
		IF audio_14_flag > 1
			audio_14_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_14_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_15_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_15_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_17
			audio_15_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_15_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_17 10000 1//Sergeant: Ok, PLATOON MOVE IT OUT!
			ENDIF
			audio_15_flag = 3
		ENDIF
	ENDIF
	IF audio_15_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_17
			audio_15_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_15_timeout
				audio_15_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_15_flag > 0
		IF audio_15_flag > 1
			audio_15_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_15_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_13_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_13_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_7
			audio_13_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_13_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_7 10000 1//Sergeant: Civilian, move away from the tank immediately!
			ENDIF
			audio_13_flag = 3
		ENDIF
	ENDIF
	IF audio_13_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_7
			audio_13_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_13_timeout
				audio_13_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_13_flag > 0
		IF audio_13_flag > 1
			audio_13_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_13_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_16_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_16_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_14
			audio_16_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_16_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_14 10000 1//Sergeant: Drop him soldier. (Shoots player)
			ENDIF
			audio_16_flag = 3
		ENDIF
	ENDIF
	IF audio_16_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_14
			audio_16_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_16_timeout
				audio_16_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_16_flag > 0
		IF audio_16_flag > 1
			audio_16_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_16_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_17_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_17_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_8
			audio_17_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_17_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_8 10000 1//Sergeant (walks up to player): I SAID, move away, IMMEDIATELY!
			ENDIF
			audio_17_flag = 3
		ENDIF
	ENDIF
	IF audio_17_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_8
			audio_17_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_17_timeout
				audio_17_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_17_flag > 0
		IF audio_17_flag > 1
			audio_17_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_17_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_18_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_18_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_11
			audio_18_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_18_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_11 10000 1//Sergeant: Move that civilian out our way soldier - Marine: Sir, Yes Sir!
			ENDIF
			audio_18_flag = 3
		ENDIF
	ENDIF
	IF audio_18_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_11
			audio_18_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_18_timeout
				audio_18_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_18_flag > 0
		IF audio_18_flag > 1
			audio_18_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_18_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_19_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_19_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_13
			audio_19_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_19_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_13 10000 1//Marine: This is a military convoy, do not obstruct our route. 
			ENDIF
			audio_19_flag = 3
		ENDIF
	ENDIF
	IF audio_19_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_13
			audio_19_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_19_timeout
				audio_19_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_19_flag > 0
		IF audio_19_flag > 1
			audio_19_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_19_flag = 0
		ENDIF
	ENDIF
ENDIF

IF audio_20_flag > 0
AND	player_near_tank_flag = 1
AND attack_player = 0
	IF audio_20_flag = 3
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT COL4_15
			audio_20_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ENDIF
	ENDIF
	IF audio_20_flag = 2
		IF HAS_MISSION_AUDIO_LOADED 1
			PLAY_MISSION_AUDIO 1
			IF print_timer < game_timer
				PRINT_NOW COL4_15 10000 1//Sergeant: Get that civilian vehicle out our way! - Marine: Sir! Moving vehicle Sir!
			ENDIF
			audio_20_flag = 3
		ENDIF
	ENDIF
	IF audio_20_flag = 1
		IF is_audio_in_use = 0
			LOAD_MISSION_AUDIO 1 COL4_15
			audio_20_flag = 2
			is_audio_in_use = 1
		ELSE
			IF game_timer >	audio_20_timeout
				audio_20_flag = 0 
			ENDIF
		ENDIF
	ENDIF
ELSE
	IF audio_20_flag > 0
		IF audio_20_flag > 1
			audio_20_flag = 0
			is_audio_in_use = 0
			GOTO mission_general4_loop
		ELSE
			audio_20_flag = 0
		ENDIF
	ENDIF
ENDIF



////Player in Tank:
//PRINT_NOW COL4_12 5000 1 //Marine: Someone's in the TANK!  STOP HIM!
//PRINT_NOW COL4_24 5000 1 //Security protocol Delta India Echo triggered! Vehicle self destruct initiated!
//PRINT_NOW COL4_26 5000 1 //Prepare to die Communist scum!
////attack_player = 1
//PRINT_NOW COL4_9 5000 1 //Sergeant: We are under attack.  DEFENSIVE POSITIONS!
////Sniping Driver in vehicle:
//PRINT_NOW COL4_21 5000 1 //Marine: SNIPER! AAARRRRGGGGHHHhhhhhhh! (as the other passenger runs away)
////Tank driver running away:
//PRINT_NOW COL4_22 5000 1//Sergeant: I'm getting out of here, AAARRRRGGGGHHHhhhhhhh!
////Halt/resume convoy stuff
//PRINT_NOW COL4_3 5000 1////Sergeant: HALT CONVOY!
//PRINT_NOW COL4_17 5000 1 ////Sergeant: Ok, PLATOON MOVE IT OUT!
////Player in front of tank escort vehicles:
//PRINT_NOW COL4_11 5000 1 //Sergeant: Move that civilian out our way soldier	- Marine: Sir, Yes Sir!
//PRINT_NOW COL4_13 5000 1 //Marine: This is a military convoy, do not obstruct our route. 
//PRINT_NOW COL4_8 5000 1  //Marine: I SAID, move away, IMMEDIATELY!
//PRINT_NOW COL4_14 5000 1 ////Sergeant: Drop him soldier. (Shoots player)
////Vehicle in the way of any of the vehicles:
//PRINT_NOW COL4_15 5000 1 //Sergeant: Get that civilian vehicle out our way!	- Marine: Sir! Moving vehicle Sir!
////Buying doughnuts:
//PRINT_NOW COL4_19 5000 1 //Sergeant: Go get some doughnuts, soldier! - Marine: Sir, Yes Sir!
//PRINT_NOW COL4_20 5000 1 ////Marine: Target acquired, Sir
////Walking close to tank routine:
//PRINT_NOW COL4_7 5000 1  //Sergeant: Civilian, move away from the tank immediately!
//PRINT_NOW COL4_8 5000 1 //Sergeant (walks up to player): I SAID, move away, IMMEDIATELY!
//PRINT_NOW COL4_14 5000 1 ////Sergeant: Drop him soldier. (Shoots player)
////Player on the tank routine:
//PRINT_NOW COL4_18 5000 1 //Marine: Sir! Someone's on the tank, Sir!
////Tank gunner killed:
//PRINT_NOW COL4_1 5000 1  //Sergeant: What's up with the Gunner? - Marine: Don't know Sir! -	Sergeant: Get topside and check it out soldier.
//PRINT_NOW COL4_6 5000 1 ////Marine: The gunner is dead, WE ARE UNDER ATTACK!
////Arrive at warehouse:
//PRINT_NOW COL4_23 5000 1 //Sergeant: Objective completed! Platoon dismissed! - Marine: Lets go eat some of those doughnuts.


GOTO mission_general4_loop


	
//////////////////////////////////////////////////////////////////////////////////////
mission_general4_failed://////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
PRINT_BIG M_FAIL 5000 1 //"Mission Failed"
RETURN


//////////////////////////////////////////////////////////////////////////////////////
mission_general4_passed://////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

flag_general_mission4_passed = 1
PRINT_WITH_NUMBER_BIG M_PASS 2000 5000 1 //"Mission Passed!"
CLEAR_WANTED_LEVEL player1
ADD_SCORE player1 2000
REGISTER_MISSION_PASSED COL_4
PLAYER_MADE_PROGRESS 1
PLAY_MISSION_PASSED_TUNE 1
REMOVE_BLIP	general_contact_blip
RETURN
		

//////////////////////////////////////////////////////////////////////////////////////
mission_cleanup_general4://///////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

flag_player_on_mission = 0

REMOVE_BLIP tank_blip

//SWITCH_ROADS_ON -877.0355 -1502.6396 -2.4916 -477.6842 685.0324 52.1452
SWITCH_ROADS_ON -721.211 243.998 5.0 -651.211 693.998 25.0
SWITCH_ROADS_ON -760.362 101.883 5.0 -700.362 251.883 25.0
SWITCH_ROADS_ON -783.906 -46.826 5.0 -723.906 103.174 25.0
SWITCH_ROADS_ON -853.397 -149.692 5.0 -773.397 0.308 25.0
SWITCH_ROADS_ON -870.656 -594.54 5.0 -810.656 -144.54 25.0
SWITCH_ROADS_ON -837.282 -1041.814 5.0 -777.282 -591.814 25.0
SWITCH_ROADS_ON -827.532 -1539.617 5.0 -747.532 -1039.617 25.0

GET_GAME_TIMER timer_mobile_start

MARK_MODEL_AS_NO_LONGER_NEEDED RHINO
MARK_MODEL_AS_NO_LONGER_NEEDED BARRACKS
MARK_MODEL_AS_NO_LONGER_NEEDED ARMY
MARK_MODEL_AS_NO_LONGER_NEEDED PATRIOT
MARK_MODEL_AS_NO_LONGER_NEEDED RUGER

CLEAR_ONSCREEN_COUNTER tank_detonation_timer
//CLEAR_ALL_SCRIPT_ROADBLOCKS

REMOVE_PICKUP tank_dude1_bodyarmour
REMOVE_PICKUP tank_dude2_bodyarmour

flag_player_on_army_ped_mission = 0

MISSION_HAS_FINISHED
RETURN

//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////




//////////////////////////////////////////////////////////////////////////////////////
if_in_front_of_army_vehicle://////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////

IF army_soldier = escort1_dude2
	obstruction_of_vehicle_flag = escort1_dude2_obstruction_flag
	move_car_timeout = escort1_dude2_timeout
	obstacle_x = escort1_dude2_obstacle_x
	obstacle_y = escort1_dude2_obstacle_y
	car_obstacle = escort1_dude2_car_obstacle
	vehicle_stopped_timer = escort1_stopped_timer
ENDIF

IF army_soldier = escort2_dude2
	obstruction_of_vehicle_flag = escort2_dude2_obstruction_flag
	move_car_timeout = escort2_dude2_timeout
	obstacle_x = escort2_dude2_obstacle_x
	obstacle_y = escort2_dude2_obstacle_y
	car_obstacle = escort2_dude2_car_obstacle
	vehicle_stopped_timer = escort2_stopped_timer
ENDIF

IF army_soldier = tank_dude2
	obstruction_of_vehicle_flag = tank_dude2_obstruction_flag
	move_car_timeout = tank_dude2_timeout
	obstacle_x = tank_dude2_obstacle_x
	obstacle_y = tank_dude2_obstacle_y
	car_obstacle = tank_dude2_car_obstacle
	vehicle_stopped_timer = tank_stopped_timer
ENDIF

IF army_soldier = escort3_dude2
	obstruction_of_vehicle_flag = escort3_dude2_obstruction_flag
	move_car_timeout = escort3_dude2_timeout
	obstacle_x = escort3_dude2_obstacle_x
	obstacle_y = escort3_dude2_obstacle_y
	car_obstacle = escort3_dude2_car_obstacle
	vehicle_stopped_timer = escort3_stopped_timer
ENDIF

IF IS_CAR_STOPPED army_vehicle
//	IF vehicle_stopped_timer < game_timer

		GET_OFFSET_FROM_CAR_IN_WORLD_COORDS army_vehicle 0.0 7.0 0.0 vector_x vector_y z
		
		IF NOT IS_CHAR_DEAD	army_soldier
			IF LOCATE_PLAYER_ON_FOOT_3D player1 vector_x vector_y army_vehicle_z 4.0 4.0 2.0 0
				IF obstruction_of_vehicle_flag = 5
					obstruction_of_vehicle_flag = 0
				ENDIF
				
				IF obstruction_of_vehicle_flag = 0
					IF IS_CHAR_ON_FOOT army_soldier
						SET_CHAR_OBJ_NO_OBJ	army_soldier
						SET_CHAR_OBJ_GOTO_PLAYER_ON_FOOT army_soldier player1
						IF audio_18_flag = 0
							audio_18_flag = 1
							audio_18_timeout = game_timer + 6000
						ENDIF
						obstruction_of_vehicle_flag = 1
					ELSE
						IF NOT army_soldier = tank_dude2
							IF IS_CHAR_IN_ANY_CAR army_soldier
								STORE_CAR_CHAR_IS_IN_NO_SAVE army_soldier army_soldier_vehicle
								LOCK_CAR_DOORS army_soldier_vehicle CARLOCK_UNLOCKED
								IF army_soldier_vehicle = tank
									unlock_tank_flag = 2
								ENDIF
								SET_CHAR_OBJ_LEAVE_CAR army_soldier army_soldier_vehicle
							ENDIF
						ENDIF
					ENDIF
					IF convoy_stop_flag = 0
						convoy_stop_flag = 1
					ENDIF
				ENDIF
				
				IF obstruction_of_vehicle_flag = 1
					IF NOT IS_CHAR_IN_ANY_CAR army_soldier
						IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 army_soldier 2.5 2.5 0
							IF audio_19_flag = 0
								audio_19_flag = 1
								audio_19_timeout = game_timer + 6000
							ENDIF
							move_car_timeout = game_timer + 7000
							obstruction_of_vehicle_flag = 2
						ENDIF
					ENDIF
				ENDIF
				
				IF obstruction_of_vehicle_flag = 2
					IF move_car_timeout < game_timer
						IF audio_16_flag = 0
							audio_16_flag = 1
							audio_16_timeout = game_timer + 6000
						ENDIF
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT army_soldier player1
						obstruction_of_vehicle_flag = 3
					ENDIF
				ENDIF
			ENDIF
			
			IF obstruction_of_vehicle_flag = 0
				IF NOT IS_CHAR_IN_ANY_CAR army_soldier
					obstruction_of_vehicle_flag = 5
				ENDIF
			ENDIF
			
			IF NOT LOCATE_PLAYER_ON_FOOT_3D player1 vector_x vector_y army_vehicle_z 4.0 4.0 2.0 0
				IF obstruction_of_vehicle_flag = 1
				OR obstruction_of_vehicle_flag = 2
				OR obstruction_of_vehicle_flag = 3
					x2 = vector_x + 4.0
					y2 = vector_y + 4.0
					x = x2 - 8.0
					y = y2 - 8.0
					GET_RANDOM_CAR_OF_TYPE_IN_AREA_NO_SAVE x2 y2 x y -1 car_obstacle
					IF car_obstacle = -1
						obstruction_of_vehicle_flag = 5
						another_fucking_flag = 0
					ELSE
						obstruction_of_vehicle_flag = 0
						another_fucking_flag = 1
					ENDIF
				ENDIF

				IF obstruction_of_vehicle_flag = 8
					IF NOT IS_CHAR_IN_ANY_CAR army_soldier
						IF NOT IS_CAR_DEAD car_obstacle
							SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER army_soldier car_obstacle
						ELSE
							SET_CHAR_OBJ_NO_OBJ	army_soldier
							obstruction_of_vehicle_flag = 5
						ENDIF
						MARK_CAR_AS_NO_LONGER_NEEDED car_obstacle
						IF audio_20_flag = 0
							audio_20_flag = 1
							audio_20_timeout = game_timer + 4000
						ENDIF
						obstruction_of_vehicle_flag = 4
					ENDIF
				ENDIF

				IF obstruction_of_vehicle_flag = 0
					IF NOT another_fucking_flag = 1
						x2 = vector_x + 4.0
						y2 = vector_y + 4.0
						x = x2 - 8.0
						y = y2 - 8.0
						GET_RANDOM_CAR_OF_TYPE_IN_AREA_NO_SAVE x2 y2 x y -1 car_obstacle
					ENDIF
					
					IF NOT car_obstacle = -1
						IF IS_CAR_DEAD car_obstacle
							SET_CAR_DRIVING_STYLE army_vehicle 3
							MARK_CAR_AS_NO_LONGER_NEEDED car_obstacle
							obstruction_of_vehicle_flag = 5
							car_obstacle = -1
						ELSE
							IF NOT IS_CHAR_IN_ANY_CAR army_soldier
								SET_CHAR_OBJ_ENTER_CAR_AS_DRIVER army_soldier car_obstacle
								MARK_CAR_AS_NO_LONGER_NEEDED car_obstacle
								obstruction_of_vehicle_flag = 4
							ELSE
								STORE_CAR_CHAR_IS_IN_NO_SAVE army_soldier army_soldier_vehicle
								LOCK_CAR_DOORS army_soldier_vehicle CARLOCK_UNLOCKED
								IF army_soldier_vehicle = tank
									unlock_tank_flag = 2
								ENDIF
								SET_CHAR_OBJ_LEAVE_CAR army_soldier	army_soldier_vehicle
								obstruction_of_vehicle_flag = 8
							ENDIF
							IF convoy_stop_flag = 0
								convoy_stop_flag = 1
							ENDIF
						ENDIF
					ENDIF
				ENDIF
				another_fucking_flag = 0
			ENDIF
			IF obstruction_of_vehicle_flag = 4
				IF IS_CHAR_IN_ANY_CAR army_soldier
					MARK_CAR_AS_NO_LONGER_NEEDED car_obstacle
					car_obstacle = -1
					STORE_CAR_CHAR_IS_IN_NO_SAVE army_soldier car_obstacle
					GET_CAR_COORDINATES	car_obstacle x y z
					x -= 10.0
					y -= 25.0
					GET_CLOSEST_CHAR_NODE x y z obstacle_x obstacle_y z
					SET_CAR_CRUISE_SPEED car_obstacle 20.0
					SET_CAR_DRIVING_STYLE car_obstacle 2
					CAR_GOTO_COORDINATES_ACCURATE car_obstacle obstacle_x obstacle_y z
					move_car_timeout = game_timer + 10000
					obstruction_of_vehicle_flag = 6
				ELSE
					IF IS_CAR_DEAD car_obstacle
						SET_CHAR_OBJ_NO_OBJ	army_soldier
						obstruction_of_vehicle_flag = 5
					ELSE
						IF NOT LOCATE_CAR_2D car_obstacle vector_x vector_y 4.0 4.0 0
							SET_CHAR_OBJ_NO_OBJ	army_soldier
							obstruction_of_vehicle_flag = 5
						ENDIF
					ENDIF
				ENDIF
			ENDIF
			IF obstruction_of_vehicle_flag = 6
				IF LOCATE_CHAR_IN_CAR_2D army_soldier obstacle_x obstacle_y 3.0 3.0 0
					obstruction_of_vehicle_flag = 5
				ELSE
					IF move_car_timeout < game_timer
						obstruction_of_vehicle_flag = 5
					ENDIF
					IF NOT IS_CHAR_IN_ANY_CAR army_soldier
						obstruction_of_vehicle_flag = 5
					ENDIF
				ENDIF
			ENDIF
		ENDIF //IF NOT IS_CHAR_DEAD army_soldier
//	ENDIF//IF vehicle_stopped_timer < game_timer
ELSE
//	vehicle_stopped_timer = game_timer + 2000
	IF NOT obstruction_of_vehicle_flag = 0
	AND NOT obstruction_of_vehicle_flag = 5
		obstruction_of_vehicle_flag = 5
	ENDIF
ENDIF //IF IS_CAR_STOPPED army_vehicle

IF army_soldier = escort1_dude2
	escort1_dude2_obstruction_flag = obstruction_of_vehicle_flag
	escort1_dude2_timeout = move_car_timeout
	escort1_dude2_obstacle_x = obstacle_x
	escort1_dude2_obstacle_y = obstacle_y
	escort1_dude2_car_obstacle = car_obstacle
	escort1_stopped_timer = vehicle_stopped_timer
ENDIF

IF army_soldier = escort2_dude2
	escort2_dude2_obstruction_flag = obstruction_of_vehicle_flag
	escort2_dude2_timeout = move_car_timeout
	escort2_dude2_obstacle_x = obstacle_x
	escort2_dude2_obstacle_y = obstacle_y
	escort2_dude2_car_obstacle = car_obstacle
	escort2_stopped_timer = vehicle_stopped_timer
ENDIF

IF army_soldier = tank_dude2
	tank_dude2_obstruction_flag = obstruction_of_vehicle_flag
	tank_dude2_timeout = move_car_timeout
	tank_dude2_obstacle_x = obstacle_x
	tank_dude2_obstacle_y = obstacle_y
	tank_dude2_car_obstacle = car_obstacle
	tank_stopped_timer = vehicle_stopped_timer
ENDIF

IF army_soldier = escort3_dude2
	escort3_dude2_obstruction_flag = obstruction_of_vehicle_flag
	escort3_dude2_timeout = move_car_timeout
	escort3_dude2_obstacle_x = obstacle_x
	escort3_dude2_obstacle_y = obstacle_y
	escort3_dude2_car_obstacle = car_obstacle
	escort3_stopped_timer = vehicle_stopped_timer
ENDIF

RETURN


setup_initial_ped_stuff:
GIVE_WEAPON_TO_CHAR	dude WEAPONTYPE_RUGER 9999
CLEAR_CHAR_THREAT_SEARCH dude
SET_CHAR_PERSONALITY dude PEDSTAT_TOUGH_GUY
SET_CHAR_RUNNING dude TRUE
//SET_CHAR_ACCURACY dude 40
RETURN


armydudes_go_into_doorway:
		
IF gosub_armydude_counter = 0
	SET_CHAR_HEED_THREATS gosub_armydude TRUE
	SET_CHAR_THREAT_SEARCH gosub_armydude THREAT_PLAYER1
	SET_CHAR_OBJ_RUN_TO_COORD gosub_armydude -829.7494 -1491.9958
	SET_CHAR_USE_PEDNODE_SEEK gosub_armydude FALSE
	gosub_armydude_counter = 1
ENDIF
IF gosub_armydude_counter = 1
	IF IS_CHAR_OBJ_NO_OBJ gosub_armydude
		SET_CHAR_OBJ_RUN_TO_COORD gosub_armydude -829.7494 -1491.9958
		SET_CHAR_USE_PEDNODE_SEEK gosub_armydude FALSE
	ENDIF
	IF LOCATE_CHAR_ON_FOOT_2D gosub_armydude -829.7494 -1491.9958 1.0 1.0 0
		SET_CHAR_OBJ_RUN_TO_COORD gosub_armydude -826.0425 -1493.5173
		SET_CHAR_USE_PEDNODE_SEEK gosub_armydude FALSE
		gosub_armydude_counter = 2
	ENDIF
ENDIF
IF gosub_armydude_counter = 2
	IF IS_CHAR_OBJ_NO_OBJ gosub_armydude
		SET_CHAR_OBJ_RUN_TO_COORD gosub_armydude -826.0425 -1493.5173
		SET_CHAR_USE_PEDNODE_SEEK gosub_armydude FALSE
	ENDIF
	IF LOCATE_CHAR_ON_FOOT_2D gosub_armydude -826.0425 -1493.5173 1.0 1.0 0
		DELETE_CHAR	gosub_armydude
		gosub_armydude_counter = 3
	ENDIF
ENDIF

RETURN


wait_for_cs_time_col4:
WHILE cs_time < cs_time_limit
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE
RETURN



shooting_from_vehicle_stuff:
	
IF NOT IS_CAR_DEAD shooting_peds_car
	IF NOT IS_PLAYER_IN_CAR	player1 shooting_peds_car
		IF NOT IS_CHAR_DEAD	shooting_peds_car_driver
			IF IS_CHAR_IN_CAR shooting_peds_car_driver shooting_peds_car
				IF NOT attack_player = 0
					IF NOT IS_CHAR_DEAD	shooting_ped
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shooting_ped player1
					ELSE
						DETACH_CHAR_FROM_CAR shooting_ped
					ENDIF
				ELSE
					IF IS_CHAR_DEAD	shooting_ped
						IF attack_player = 0
							attack_player = 1
						ENDIF
					ELSE
						TURN_CHAR_TO_FACE_PLAYER shooting_ped player1
						SET_CHAR_OBJ_AIM_GUN_AT_CHAR shooting_ped scplayer
					ENDIF
				ENDIF
			ELSE
				IF shooting_ped_flag = 0
					IF NOT IS_CHAR_DEAD	shooting_ped
						DETACH_CHAR_FROM_CAR shooting_ped
						GET_OFFSET_FROM_CAR_IN_WORLD_COORDS shooting_peds_car 0.0 -11.0 0.0 x y z
						SET_CHAR_OBJ_RUN_TO_COORD shooting_ped x y
						IF LOCATE_CHAR_ON_FOOT_2D shooting_ped x y 2.0 2.0 0
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shooting_ped player1
							shooting_ped_flag = 1
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			IF attack_player = 0
				attack_player = 1
			ENDIF
			IF shooting_ped_flag = 0
				IF NOT IS_CHAR_DEAD	shooting_ped
					DETACH_CHAR_FROM_CAR shooting_ped
					GET_OFFSET_FROM_CAR_IN_WORLD_COORDS shooting_peds_car 0.0 -11.0 0.0 x y z
					SET_CHAR_OBJ_RUN_TO_COORD shooting_ped x y
					IF LOCATE_CHAR_ON_FOOT_2D shooting_ped x y 2.0 2.0 0
						SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shooting_ped player1
						shooting_ped_flag = 1
					ENDIF
				ENDIF
			ENDIF
		ENDIF
	ELSE
		SET_CAR_ONLY_DAMAGED_BY_PLAYER shooting_peds_car FALSE
		DETACH_CHAR_FROM_CAR shooting_ped
		IF NOT IS_CHAR_DEAD	shooting_ped
			SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shooting_ped player1
		ENDIF
	ENDIF
ELSE
	DETACH_CHAR_FROM_CAR shooting_ped
	IF NOT IS_CHAR_DEAD	shooting_ped
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT shooting_ped player1
	ENDIF
ENDIF

RETURN

// FIXMIAMI: BEGIN
check_any_alive_soldier_near_tank:

	IF NOT IS_CHAR_DEAD escort1_dude1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort1_dude1 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort1_dude2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort1_dude2 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort2_dude1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort2_dude1 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort2_dude2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort2_dude2 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort2_attached_01
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort2_attached_01 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort2_attached_02
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort2_attached_02 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort2_attached_03
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort2_attached_03 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort2_attached_04
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort2_attached_04 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD tank_dude1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 tank_dude1 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD tank_dude2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 tank_dude2 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort3_dude1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort3_dude1 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort3_dude2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort3_dude2 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort3_attached_01
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort3_attached_01 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort3_attached_02
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort3_attached_02 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort3_attached_04
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort3_attached_04 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD escort3_attached_04
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 escort3_attached_04 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD formation_ped1
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped1 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD formation_ped2
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped2 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD formation_ped3
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped3 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD formation_ped4
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped4 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD formation_ped5
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped5 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	IF NOT IS_CHAR_DEAD formation_ped6
		IF LOCATE_PLAYER_ANY_MEANS_CHAR_2D player1 formation_ped6 20.0 20.0 FALSE
			audio_4_flag = 1
			RETURN
		ENDIF
	ENDIF

	RETURN
// FIXMIAMI: END
}