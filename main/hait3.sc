MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ********************************** Haitian Mission 3 ************************************
// ********************************** Snipe The Cubans *************************************
// ************************************ Dirty Lick'ns **************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME hait3

// Mission start stuff

GOSUB mission_start_haitian3

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_haitian3_failed
ENDIF

GOSUB mission_cleanup_haitian3

MISSION_END
 
// Variables for mission

// General fight stuff

VAR_INT flag_player_spotted_hait3

//VAR_FLOAT players_x_hait3

//VAR_FLOAT players_y_hait3

//VAR_FLOAT players_z_hait3

// Fight 1

VAR_INT flag_fight1_over_hait3

VAR_INT flag_fight_over_hait3

VAR_INT counter_dead_cuban

VAR_INT counter_dead_haitian

// Cuban1

VAR_INT flag_cuban1_dead_hait3

VAR_INT cuban1_hait3

VAR_INT flag_cuban1_got_ai_hait3

VAR_INT cuban1_blip_hait3 

// Cuban2

VAR_INT flag_cuban2_dead_hait3

VAR_INT cuban2_hait3

VAR_INT flag_cuban2_got_ai_hait3

VAR_INT cuban2_blip_hait3

// Cuban3

VAR_INT flag_cuban3_dead_hait3

VAR_INT cuban3_hait3

VAR_INT flag_cuban3_got_ai_hait3

VAR_INT cuban3_blip_hait3

// Cuban4

VAR_INT flag_cuban4_dead_hait3

VAR_INT cuban4_hait3

VAR_INT flag_cuban4_got_ai_hait3

VAR_INT cuban4_blip_hait3

// Cuban5

VAR_INT flag_cuban5_dead_hait3

VAR_INT cuban5_hait3

VAR_INT flag_cuban5_got_ai_hait3

VAR_INT cuban5_blip_hait3

// Cuban6

VAR_INT flag_cuban6_dead_hait3

VAR_INT cuban6_hait3

VAR_INT flag_cuban6_got_ai_hait3

VAR_INT cuban6_blip_hait3

// Cuban7

VAR_INT flag_cuban7_dead_hait3

VAR_INT cuban7_hait3

VAR_INT flag_cuban7_got_ai_hait3

VAR_INT cuban7_blip_hait3

// Cuban8

VAR_INT flag_cuban8_dead_hait3

VAR_INT cuban8_hait3

VAR_INT flag_cuban8_got_ai_hait3

VAR_INT cuban8_blip_hait3

// Cuban9

VAR_INT flag_cuban9_dead_hait3

VAR_INT cuban9_hait3

VAR_INT flag_cuban9_got_ai_hait3

VAR_INT cuban9_blip_hait3


// Cuban10

VAR_INT flag_cuban10_dead_hait3

VAR_INT cuban10_hait3

VAR_INT flag_cuban10_got_ai_hait3

VAR_INT cuban10_blip_hait3

// Haitians

// Haitian1

VAR_INT flag_haitian1_dead_hait3

VAR_INT haitian1_hait3

VAR_INT flag_haitian1_got_ai_hait3

// Haitian2

VAR_INT flag_haitian2_dead_hait3

VAR_INT haitian2_hait3

VAR_INT flag_haitian2_got_ai_hait3

// Haitian3

VAR_INT flag_haitian3_dead_hait3

VAR_INT haitian3_hait3

VAR_INT flag_haitian3_got_ai_hait3

// Haitian4

VAR_INT flag_haitian4_dead_hait3

VAR_INT haitian4_hait3

VAR_INT flag_haitian4_got_ai_hait3

// Haititan5

VAR_INT flag_haitian5_dead_hait3

VAR_INT haitian5_hait3

VAR_INT flag_haitian5_got_ai_hait3

// Haitian6

VAR_INT flag_haitian6_dead_hait3

VAR_INT haitian6_hait3

VAR_INT flag_haitian6_got_ai_hait3

// Haitian7

VAR_INT flag_haitian7_dead_hait3

VAR_INT haitian7_hait3

VAR_INT flag_haitian7_got_ai_hait3

// Haitian8

VAR_INT flag_haitian8_dead_hait3

VAR_INT haitian8_hait3

VAR_INT flag_haitian8_got_ai_hait3


// Haitian9

VAR_INT flag_haitian9_dead_hait3

VAR_INT haitian9_hait3

VAR_INT flag_haitian9_got_ai_hait3


// Haitian10

VAR_INT flag_haitian10_dead_hait3

VAR_INT haitian10_hait3

VAR_INT flag_haitian10_got_ai_hait3

// Weapon location stuff

VAR_INT radar_blip_coord1_hait3

// General truck stuff

// Truck1

VAR_INT truck1_hait3

VAR_INT truck1_dead_hait3

VAR_FLOAT truck1_x_hait3

VAR_FLOAT truck1_y_hait3

VAR_FLOAT truck1_z_hait3

VAR_FLOAT truck1_dest_x_hait3

VAR_FLOAT truck1_dest_y_hait3

VAR_FLOAT truck1_dest_z_hait3

VAR_INT flag_truck1_in_position_hait3

// guards

VAR_INT flag_ambush1_created_hait3

VAR_INT flag_ambush2_created_hait3

// driver1

VAR_INT ambush_driver1_hait3

VAR_INT ambush_driver1_dead_hait3

VAR_INT ambush_driver1_blip_hait3

VAR_INT ambush_driver1_target_hait3

// cuban1

VAR_INT ambush_cuban1_hait3

VAR_INT ambush_cuban1_dead_hait3

VAR_INT ambush_cuban1_blip_hait3

VAR_INT ambush_cuban1_target_hait3

// cuban2

VAR_INT ambush_cuban2_hait3

VAR_INT ambush_cuban2_dead_hait3

VAR_INT ambush_cuban2_blip_hait3

VAR_INT ambush_cuban2_target_hait3

// cuban3

VAR_INT ambush_cuban3_hait3

VAR_INT ambush_cuban3_dead_hait3

VAR_INT ambush_cuban3_blip_hait3

VAR_FLOAT fight1_x_hait3

VAR_FLOAT fight1_y_hait3

VAR_FLOAT fight1_z_hait3

VAR_INT driver1_goto_position_hait3

VAR_INT cuban1_goto_position_hait3

VAR_INT cuban2_goto_position_hait3

VAR_INT cuban3_goto_position_hait3

VAR_INT ambush_cuban3_target_hait3

//cuban4

VAR_INT ambush_cuban4_hait3

VAR_INT ambush_cuban4_blip_hait3

VAR_INT ambush_cuban4_dead_hait3

VAR_INT cuban4_goto_position_hait3

VAR_INT ambush_cuban4_target_hait3

//cuban5

VAR_INT ambush_cuban5_hait3

VAR_INT ambush_cuban5_dead_hait3

VAR_INT ambush_cuban5_blip_hait3

VAR_INT cuban5_goto_position_hait3

VAR_INT ambush_cuban5_target_hait3

//cuban6

VAR_INT ambush_cuban6_hait3

VAR_INT ambush_cuban6_dead_hait3

VAR_INT cuban6_goto_position_hait3

VAR_INT ambush_cuban6_blip_hait3

VAR_INT ambush_cuban6_target_hait3

//cuban7

VAR_INT ambush_cuban7_hait3

VAR_INT ambush_cuban7_dead_hait3

VAR_INT cuban7_goto_position_hait3

VAR_INT ambush_cuban7_blip_hait3

VAR_INT ambush_cuban7_target_hait3

//cuban8

VAR_INT ambush_cuban8_hait3

VAR_INT ambush_cuban8_dead_hait3

VAR_INT cuban8_goto_position_hait3

VAR_INT ambush_cuban8_blip_hait3

VAR_INT ambush_cuban8_target_hait3

//cuban9

VAR_INT ambush_cuban9_hait3

VAR_INT ambush_cuban9_dead_hait3

VAR_INT cuban9_goto_position_hait3

VAR_INT ambush_cuban9_blip_hait3

VAR_INT ambush_cuban9_target_hait3

// sets the guys to take damage

VAR_INT flag_guys_can_die_hait3 

VAR_INT sphere1_hait3

VAR_INT all_peds_can_die_hait3

VAR_INT counter_peds_got_ai_hait3

// AI timer stuff

//VAR_INT game_time_hait3

//VAR_INT timer_cubans1_act_hait3

//VAR_INT time_to_act_cubans1_hait3

//VAR_INT timer_started_cubans1_hait3

//VAR_INT timer_cubans2_act_hait3

//VAR_INT time_to_act_cubans2_hait3

//VAR_INT timer_started_cubans2_hait3

//VAR_INT timer_haitians1_act_hait3

//VAR_INT time_to_act_haitians1_hait3

//VAR_INT timer_started_haitians1_hait3

//VAR_INT timer_haitians2_act_hait3

//VAR_INT time_to_act_haitians2_hait3

//VAR_INT timer_started_haitians2_hait3

VAR_INT gosub_cuban1_hait3

//VAR_INT gosub_cuban2_hait3

VAR_INT gosub_haitian1_hait3

//VAR_INT gosub_haitian2_hait3

VAR_INT gosub_spotter_hait3

// chooseing cloest ped stuff

VAR_FLOAT gosub_cuban1_x_hait3

VAR_FLOAT gosub_cuban1_y_hait3

VAR_FLOAT gosub_cuban1_z_hait3

VAR_FLOAT gosub_haitian1_x_hait3

VAR_FLOAT gosub_haitian1_y_hait3

VAR_FLOAT gosub_haitian1_z_hait3

VAR_FLOAT closest_dist_hait3

VAR_INT closest_haitian_hait3

VAR_INT distance_check_targ_hait3

VAR_FLOAT targ_hat_x_hait3

VAR_FLOAT targ_hat_y_hait3

VAR_FLOAT targ_hat_z_hait3

VAR_FLOAT targ_cub_x_hait3

VAR_FLOAT targ_cub_y_hait3

VAR_FLOAT targ_cub_z_hait3

VAR_FLOAT current_dist_hait3

VAR_INT closest_cuban_hait3

VAR_INT haitian1_target_hait3

VAR_INT haitian2_target_hait3

VAR_INT haitian3_target_hait3

VAR_INT haitian4_target_hait3

VAR_INT haitian5_target_hait3

VAR_INT haitian6_target_hait3

VAR_INT haitian7_target_hait3

VAR_INT haitian8_target_hait3

VAR_INT haitian9_target_hait3

VAR_INT haitian10_target_hait3

VAR_INT cuban1_target_hait3

VAR_INT cuban2_target_hait3

VAR_INT cuban3_target_hait3

VAR_INT cuban4_target_hait3

VAR_INT cuban5_target_hait3

VAR_INT cuban6_target_hait3

VAR_INT cuban7_target_hait3

VAR_INT cuban8_target_hait3

VAR_INT cuban9_target_hait3

VAR_INT cuban10_target_hait3

// Player warning stuff

VAR_INT player_had_warning_message_hait3 // used to tell the player that Haitians are dieing

VAR_INT frame_counter_hait3

VAR_INT player_spotted_melee_hait3

VAR_INT flag_death_timer_hait3

// New melee weapon spotted stuff

VAR_INT gosub_death_check_bloke_hait3

// **************************************** Mission Start **********************************

mission_start_haitian3:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1


flag_player_spotted_hait3 = 0

//players_x_hait3 = 0.0

//players_y_hait3 = 0.0

//players_z_hait3 = 0.0

// fight 1

flag_fight1_over_hait3 = 0

// Cuban1

flag_cuban1_dead_hait3 = 0

flag_cuban1_got_ai_hait3 = 0

// Cuban2
 
flag_cuban2_dead_hait3 = 0

flag_cuban2_got_ai_hait3 = 0

// Cuban3

flag_cuban3_dead_hait3 = 0

flag_cuban3_got_ai_hait3 = 0

// Cuban4

flag_cuban4_dead_hait3 = 0

flag_cuban4_got_ai_hait3 = 0

// Cuban5

flag_cuban5_dead_hait3 = 0

flag_cuban5_got_ai_hait3 = 0

// Cuban6

flag_cuban6_dead_hait3 = 0

flag_cuban6_got_ai_hait3 = 0

// Cuban7

flag_cuban7_dead_hait3 = 0

flag_cuban7_got_ai_hait3 = 0

// Cuban8

flag_cuban8_dead_hait3 = 0

flag_cuban8_got_ai_hait3 = 0

// Cuban9

flag_cuban9_dead_hait3 = 0

flag_cuban9_got_ai_hait3 = 0

// Cuban10

flag_cuban10_dead_hait3 = 0

flag_cuban10_got_ai_hait3 = 0

// Haitian1

flag_haitian1_dead_hait3 = 0

flag_haitian1_got_ai_hait3 = 0

// Haitian2

flag_haitian2_dead_hait3 = 0

flag_haitian1_got_ai_hait3 = 0

// Haitian 3

flag_haitian3_dead_hait3 = 0

flag_haitian3_got_ai_hait3 = 0

// Haitian4

flag_haitian4_dead_hait3 = 0

flag_haitian4_got_ai_hait3 = 0

// Haitian5

flag_haitian5_dead_hait3 = 0

flag_haitian5_got_ai_hait3 = 0

// Haitian6

flag_haitian6_dead_hait3 = 0

flag_haitian6_got_ai_hait3 = 0

// Haitian7

flag_haitian7_dead_hait3 = 0

flag_haitian7_got_ai_hait3 = 0

// Haitian8

flag_haitian8_dead_hait3 = 0

flag_haitian8_got_ai_hait3 = 0

// Haitian9

flag_haitian9_dead_hait3 = 0

flag_haitian9_got_ai_hait3 = 0

// Haitian10

flag_haitian10_dead_hait3 = 0

flag_haitian10_got_ai_hait3 = 0

// Ambush stuff

flag_ambush1_created_hait3 = 0

flag_ambush2_created_hait3 = 0

truck1_dead_hait3 = 0

truck1_x_hait3 = -924.912

truck1_y_hait3 = 35.082

truck1_z_hait3 = 9.54

truck1_dest_x_hait3 = -896.317

truck1_dest_y_hait3 = 34.08

truck1_dest_z_hait3 = 9.54

ambush_driver1_dead_hait3 = 0

ambush_driver1_target_hait3 = 0

ambush_cuban1_dead_hait3 = 0

ambush_cuban1_target_hait3 = 0

ambush_cuban2_dead_hait3 = 0

ambush_cuban2_target_hait3 = 0

ambush_cuban3_dead_hait3 = 0

ambush_cuban3_target_hait3 = 0

ambush_cuban4_dead_hait3 = 0

ambush_cuban4_target_hait3 = 0

ambush_cuban5_dead_hait3 = 0

ambush_cuban5_target_hait3 = 0

ambush_cuban6_dead_hait3 = 0

ambush_cuban6_target_hait3 = 0

ambush_cuban7_dead_hait3 = 0

ambush_cuban7_target_hait3 = 0

ambush_cuban8_dead_hait3 = 0

ambush_cuban8_target_hait3 = 0

ambush_cuban9_dead_hait3 = 0

ambush_cuban9_target_hait3 = 0

fight1_x_hait3 = -899.655

fight1_y_hait3 = 44.99

fight1_z_hait3 = 9.076

flag_truck1_in_position_hait3 = 0

driver1_goto_position_hait3 = 0

cuban1_goto_position_hait3 = 0

cuban2_goto_position_hait3 = 0

cuban3_goto_position_hait3 = 0

cuban4_goto_position_hait3 = 0

cuban5_goto_position_hait3 = 0

cuban6_goto_position_hait3 = 0

cuban7_goto_position_hait3 = 0

cuban8_goto_position_hait3 = 0

cuban9_goto_position_hait3 = 0

// Guys dieing stuff

flag_guys_can_die_hait3 = 0

all_peds_can_die_hait3 = 0

counter_peds_got_ai_hait3 = 0

// AI timer stuff

//game_time_hait3 = 0

//timer_cubans1_act_hait3 = 0

//time_to_act_cubans1_hait3 = 0

//timer_started_cubans1_hait3 = 0

//timer_cubans2_act_hait3 = 0

//time_to_act_cubans2_hait3 = 0

//timer_started_cubans2_hait3 = 0

//timer_haitians1_act_hait3 = 0

//time_to_act_haitians1_hait3 = 0

//timer_started_haitians1_hait3 = 0

//timer_haitians2_act_hait3 = 0

//time_to_act_haitians2_hait3 = 0

//timer_started_haitians2_hait3 = 0

// Choosing next target stuff

gosub_cuban1_x_hait3 = 0.0

gosub_cuban1_y_hait3 = 0.0

gosub_cuban1_z_hait3 = 0.0

gosub_haitian1_x_hait3 = 0.0

gosub_haitian1_y_hait3 = 0.0

gosub_haitian1_z_hait3 = 0.0

closest_dist_hait3 = 0.0

closest_haitian_hait3 = 0

closest_cuban_hait3 = 0

distance_check_targ_hait3 = 0

targ_hat_x_hait3 = 0.0

targ_hat_y_hait3 = 0.0

targ_hat_z_hait3 = 0.0

current_dist_hait3 = 0.0

closest_dist_hait3 = 0.0

haitian1_target_hait3 = 0

haitian2_target_hait3 = 0

haitian3_target_hait3 = 0

haitian4_target_hait3 = 0

haitian5_target_hait3 = 0

haitian6_target_hait3 = 0

haitian7_target_hait3 = 0

haitian8_target_hait3 = 0

haitian9_target_hait3 = 0

haitian10_target_hait3 = 0

cuban1_target_hait3 = 0

cuban2_target_hait3 = 0

cuban3_target_hait3	= 0

cuban4_target_hait3	= 0

cuban5_target_hait3	= 0

cuban6_target_hait3 = 0

cuban7_target_hait3 = 0

cuban8_target_hait3	= 0

cuban9_target_hait3	= 0

cuban10_target_hait3 = 0

targ_cub_x_hait3 = 0.0

targ_cub_y_hait3 = 0.0

targ_cub_z_hait3 = 0.0

// Player warning stuff

player_had_warning_message_hait3 = 0

player_spotted_melee_hait3 = 0 // Player been spotted wiht melee weapon

frame_counter_hait3 = 0

flag_death_timer_hait3 = 0

WAIT 0

LOAD_MISSION_TEXT HAIT3

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION -957.904 122.843 8.278 356.948

{

// ****************************************START OF CUTSCENE********************************

ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_driver1_blip_hait3 
REMOVE_BLIP ambush_driver1_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban1_blip_hait3
REMOVE_BLIP ambush_cuban1_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban2_blip_hait3
REMOVE_BLIP ambush_cuban2_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban3_blip_hait3
REMOVE_BLIP ambush_cuban3_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban4_blip_hait3
REMOVE_BLIP ambush_cuban4_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban5_blip_hait3
REMOVE_BLIP ambush_cuban5_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban6_blip_hait3
REMOVE_BLIP ambush_cuban6_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban7_blip_hait3
REMOVE_BLIP ambush_cuban7_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban8_blip_hait3
REMOVE_BLIP ambush_cuban8_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 ambush_cuban9_blip_hait3
REMOVE_BLIP ambush_cuban9_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban1_blip_hait3
REMOVE_BLIP cuban1_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban2_blip_hait3
REMOVE_BLIP cuban2_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban3_blip_hait3
REMOVE_BLIP cuban3_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban4_blip_hait3
REMOVE_BLIP cuban4_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban5_blip_hait3
REMOVE_BLIP cuban5_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban6_blip_hait3
REMOVE_BLIP cuban6_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban7_blip_hait3
REMOVE_BLIP cuban7_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban8_blip_hait3
REMOVE_BLIP cuban8_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban9_blip_hait3 
REMOVE_BLIP cuban9_blip_hait3
ADD_BLIP_FOR_COORD fight1_x_hait3 fight1_y_hait3 fight1_z_hait3 cuban10_blip_hait3
REMOVE_BLIP cuban10_blip_hait3

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 apoulet

LOAD_SPECIAL_MODEL CUTOBJ01 htable
LOAD_SPECIAL_MODEL CUTOBJ02 hatrifl

SET_AREA_VISIBLE VIS_POLICE_STATION // SCFIX: moved up before LOAD_SCENE

LOAD_SCENE -962.697 149.793 10.21

SET_EXTRA_COLOURS 13 FALSE

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02 
 
	WAIT 0

ENDWHILE

LOAD_CUTSCENE hat_3

SET_CUTSCENE_OFFSET -962.799 148.391 8.355

SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_apoulet
SET_CUTSCENE_ANIM cs_apoulet apoulet

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_htable 
SET_CUTSCENE_ANIM cs_htable htable

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_rifle 
SET_CUTSCENE_ANIM cs_rifle hatrifl

CLEAR_AREA -962.53 141.69 8.25 2.0 TRUE
SET_PLAYER_COORDINATES player1 -962.53 141.69 8.25
SET_PLAYER_HEADING player1 183.42

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 1734 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_A ) 10000 1 //"Hello, hello, I uh..I'm looking for somebody around here..."

WHILE cs_time < 6820 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_B ) 10000 1 //"You looking hungry Tommy."

WHILE cs_time < 9485 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_C ) 10000 1 //"Do I know you?"

WHILE cs_time < 11125 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_D ) 10000 1 //"Hush now.2

WHILE cs_time < 12511 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_E ) 10000 1 //"One more ting an den I can let you go Tommy."

WHILE cs_time < 15894 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_F ) 10000 1 //"My boys gone war wit dem Cuban boys."

WHILE cs_time < 19040 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_G ) 10000 1 //"But no guns"

WHILE cs_time < 20758 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_H ) 10000 1 //"Hmm, but de Cubans have a surprise a comin'."

WHILE cs_time < 23591 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_I ) 10000 1 //"While they fight in de streets, you take this rifle."

WHILE cs_time < 28128 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_J ) 10000 1 //"No one sees you, no one hear you."

WHILE cs_time < 32020 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_K ) 10000 1 //"Now Tommy? You do this for me, and you no longer tied to me apron strings."

WHILE cs_time < 37941 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( HAM3_L ) 10000 1 //"'kay auntie."

WHILE cs_time < 39680
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 42464
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SCENE -962.53 141.69 8.25

CLEAR_EXTRA_COLOURS FALSE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02


// ****************************************END OF CUTSCENE**********************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

//Request the models for the mission

REQUEST_MODEL HNa  // Haitian model a

REQUEST_MODEL HNb // Haitian model b

REQUEST_MODEL CBa // Cuban model a

REQUEST_MODEL CBb // Cuban model b

REQUEST_MODEL SNIPER  // special choice

REQUEST_MODEL BURRITO

REQUEST_MODEL KATANA

// Waiting for the models to load

WHILE NOT HAS_MODEL_LOADED HNa
OR NOT HAS_MODEL_LOADED CBa
OR NOT HAS_MODEL_LOADED SNIPER
OR NOT HAS_MODEL_LOADED HNb
OR NOT HAS_MODEL_LOADED CBb
OR NOT HAS_MODEL_LOADED BURRITO

	WAIT 0

ENDWHILE

WHILE NOT HAS_MODEL_LOADED KATANA

	WAIT 0

ENDWHILE
 
CREATE_CHAR PEDTYPE_GANG_CUBAN CBa -886.519 41.28 10.55 distance_check_targ_hait3

DELETE_CHAR distance_check_targ_hait3

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 1500 FADE_IN

SHUT_PLAYER_UP player1 TRUE

SET_WANTED_MULTIPLIER 0.5  // Changes the number of points 

PRINT_NOW ( HAM3_1 ) 5000 1 //"We must win this battle, If all the Haitians die we lose."

PRINT ( HAM3_5 ) 5000 1 //"You must kill the Cubans from a distance, you must not be seen."

//PRINT ( HAM3_6 ) 5000 1 //"Use the sniper rifle I have left to acomplish your task."

// creates the peds

CREATE_CHAR PEDTYPE_CIVMALE CBa -886.519 41.28 10.55 cuban1_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBb -885.463 42.655 9.23 cuban2_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBa -905.0 51.60 8.89 cuban3_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBb -906.26 49.95 9.02 cuban4_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBa -911.60 52.28 9.57 cuban5_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBb -908.00 52.40 9.24 cuban6_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBa -906.214 43.41 9.54 cuban7_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBb -906.01 45.03 9.41 cuban8_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBa -895.35 42.26 9.61 cuban9_hait3

CREATE_CHAR PEDTYPE_CIVMALE CBb -894.96 44.63 9.43 cuban10_hait3

////////////////////////////////////////////////////////////////////////

CREATE_CHAR PEDTYPE_CIVMALE HNa -888.798 41.597 9.52 haitian1_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNb -887.580 43.48 9.15 haitian2_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNa -906.13 47.765 9.19 haitian3_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNb -903.61 46.140 9.32 haitian4_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNa -911.57 50.46 9.57 haitian5_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNb -908.85 49.48 9.41 haitian6_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNa -901.190 42.70 9.61 haitian7_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNb -899.254 44.676 9.43 haitian8_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNa -886.33 43.70 9.05 haitian9_hait3

CREATE_CHAR PEDTYPE_CIVMALE HNb -886.68 41.40 9.51 haitian10_hait3

IF flag_fight1_over_hait3 = 0
	ADD_BLIP_FOR_COORD -892.59 75.3 15.4 radar_blip_coord1_hait3
	ADD_SPHERE -892.59 75.3 15.4 2.0 sphere1_hait3 
ENDIF

GIVE_WEAPON_TO_PLAYER player1 WEAPONTYPE_SNIPERRIFLE 30

// waiting for the player1 to kill all the cubans at fight location one

timera = 0

timerb = 0

counter_dead_cuban = 0

counter_dead_haitian = 0
						 
flag_fight_over_hait3 = 0

WHILE flag_fight_over_hait3 = 0 
	
	WAIT 0

	++ frame_counter_hait3
	IF frame_counter_hait3 > 30
		frame_counter_hait3 = 0
	ENDIF

	//GET_GAME_TIMER game_time_hait3

	IF counter_peds_got_ai_hait3 < 20
		GOSUB ped_ai_hait3 
	ENDIF	

	CLEAR_WANTED_LEVEL player1
						
	GOSUB dead_cuban_check

	GOSUB dead_haitian_check

	IF counter_dead_cuban >= 20
		flag_fight_over_hait3 = 1
	ENDIF

	IF counter_dead_haitian >= 3

		IF player_had_warning_message_hait3 = 0
			PRINT_NOW ( HAM3_8 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
			player_had_warning_message_hait3 = 1
		ENDIF
		
	ENDIF

	IF counter_dead_haitian >= 10
		PRINT_NOW ( HAM3_2 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
		GOTO mission_haitian3_failed
	ENDIF
	
	IF flag_player_spotted_hait3 = 1
	OR player_spotted_melee_hait3 = 1
		PRINT_NOW ( HAM3_4 ) 5000 1 //"You have been spotted the mission is a failure!"
	   	GOTO mission_haitian3_failed
	ENDIF

// removes blips if rifles have been picked up

	IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -936.42 109.11 13.0 -873.118 45.222 18.0 30.0 FALSE

		IF flag_death_timer_hait3 = 0
   			timerb = 0
   			flag_death_timer_hait3 = 1
   		ENDIF

		IF all_peds_can_die_hait3 = 0

			IF timera > 25000
				GOSUB guys_can_die_hait3
				PRINT_NOW ( HAM3_3 ) 5000 1 //"I expect the Cubans to cheat!
			ENDIF

		ENDIF

		IF LOCATE_PLAYER_ON_FOOT_3D player1 -892.59 75.3 15.4 2.0 2.0 2.0 FALSE

			IF all_peds_can_die_hait3 = 0
				GOSUB guys_can_die_hait3
				PRINT_NOW ( HAM3_3 ) 5000 1 //"I expect the Cubans to cheat!
			ENDIF
						
			IF flag_guys_can_die_hait3 = 0
				REMOVE_BLIP radar_blip_coord1_hait3
				REMOVE_SPHERE sphere1_hait3
				flag_guys_can_die_hait3 = 1
			ENDIF

		ENDIF

	ENDIF
	    
   	IF flag_ambush1_created_hait3 = 0

		IF counter_dead_cuban >= 5
			GOSUB ambush1_hait3
		ENDIF

	ENDIF

	IF flag_ambush2_created_hait3 = 0

		IF counter_dead_cuban >= 12
			GOSUB ambush2_hait3
		ENDIF

	ENDIF

	IF flag_ambush1_created_hait3 = 1
		GOSUB ambush1_death_checks
	ENDIF

	IF flag_ambush2_created_hait3 = 1
		GOSUB ambush2_death_checks
	ENDIF

ENDWHILE
	
REMOVE_BLIP radar_blip_coord1_hait3

GOTO mission_haitian3_passed
	
// **************************************** Mission haitian3 failed ************************

mission_haitian3_failed:
PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed"
RETURN

   

// **************************************** mission haitian3 passed ************************

mission_haitian3_passed:

flag_haitian_mission3_passed = 1
PLAY_MISSION_PASSED_TUNE 1
REGISTER_MISSION_PASSED ( HAT_3 )  // Haitian Mission 3
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 5000 5000 1 //"Mission Passed!"
ADD_SCORE player1 5000
CLEAR_WANTED_LEVEL player1
REMOVE_BLIP haitian_contact_blip
RETURN
		


// ********************************** mission cleanup **************************************

mission_cleanup_haitian3:

flag_player_on_mission = 0
REMOVE_BLIP cuban1_blip_hait3
REMOVE_BLIP cuban2_blip_hait3
REMOVE_BLIP cuban3_blip_hait3
REMOVE_BLIP cuban4_blip_hait3
REMOVE_BLIP cuban5_blip_hait3
REMOVE_BLIP cuban6_blip_hait3
REMOVE_BLIP cuban7_blip_hait3
REMOVE_BLIP cuban8_blip_hait3 
REMOVE_BLIP cuban9_blip_hait3
REMOVE_BLIP cuban10_blip_hait3
REMOVE_BLIP ambush_driver1_blip_hait3
REMOVE_BLIP ambush_cuban1_blip_hait3
REMOVE_BLIP ambush_cuban2_blip_hait3
REMOVE_BLIP ambush_cuban3_blip_hait3
REMOVE_BLIP ambush_cuban4_blip_hait3
REMOVE_BLIP ambush_cuban5_blip_hait3
REMOVE_BLIP ambush_cuban6_blip_hait3
REMOVE_BLIP ambush_cuban7_blip_hait3
REMOVE_BLIP ambush_cuban8_blip_hait3
REMOVE_BLIP ambush_cuban9_blip_hait3
SHUT_PLAYER_UP player1 FALSE
SET_WANTED_MULTIPLIER 1.0
REMOVE_SPHERE sphere1_hait3
REMOVE_BLIP radar_blip_coord1_hait3
MARK_MODEL_AS_NO_LONGER_NEEDED HNa
MARK_MODEL_AS_NO_LONGER_NEEDED CBa
MARK_MODEL_AS_NO_LONGER_NEEDED SNIPER
MARK_MODEL_AS_NO_LONGER_NEEDED HNb
MARK_MODEL_AS_NO_LONGER_NEEDED CBb
MARK_MODEL_AS_NO_LONGER_NEEDED BURRITO
MARK_MODEL_AS_NO_LONGER_NEEDED KATANA
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

// ped ai stuff

ped_ai_hait3:

// ********************************* Creates The Haitians **********************************

IF flag_haitian1_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian1_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian1_hait3	
	
			CLEAR_CHAR_THREAT_SEARCH haitian1_hait3

			IF NOT IS_CHAR_DEAD cuban1_hait3
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian1_hait3 cuban1_hait3
				haitian1_target_hait3 = cuban1_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian1_hait3 PEDSTAT_TOUGH_GUY
						
			++ counter_peds_got_ai_hait3

			flag_haitian1_got_ai_hait3 = 1

		ENDIF

	ENDIF
 	 			
ENDIF

IF flag_haitian2_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian2_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian2_hait3 
			
			CLEAR_CHAR_THREAT_SEARCH haitian2_hait3

			IF NOT IS_CHAR_DEAD cuban2_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian2_hait3 cuban2_hait3
				haitian2_target_hait3 = cuban2_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian2_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian2_hait3 TRUE
						
			++ counter_peds_got_ai_hait3
	 	
	 		flag_haitian2_got_ai_hait3 = 1

		ENDIF

	ENDIF
		
ENDIF

IF flag_haitian3_got_ai_hait3 = 0 

	IF NOT IS_CHAR_DEAD haitian3_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian3_hait3
			
			CLEAR_CHAR_THREAT_SEARCH haitian3_hait3

			IF NOT IS_CHAR_DEAD cuban3_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian3_hait3 cuban3_hait3
				haitian3_target_hait3 = cuban3_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian3_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian3_hait3 TRUE
						
			++ counter_peds_got_ai_hait3 

	 		flag_haitian3_got_ai_hait3 = 1

		ENDIF

	ENDIF
 			
ENDIF

IF flag_haitian4_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian4_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian4_hait3
			
			CLEAR_CHAR_THREAT_SEARCH haitian4_hait3

			IF NOT IS_CHAR_DEAD cuban4_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian4_hait3 cuban4_hait3
				haitian4_target_hait3 = cuban4_hait3
			ENDIF
			
			SET_CHAR_PERSONALITY haitian4_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian4_hait3 TRUE
					
			++ counter_peds_got_ai_hait3
			
			flag_haitian4_got_ai_hait3 = 1 

		ENDIF

 	ENDIF
		
ENDIF

IF flag_haitian5_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian5_hait3
	
		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian5_hait3	

			CLEAR_CHAR_THREAT_SEARCH haitian5_hait3

			IF NOT IS_CHAR_DEAD cuban5_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian5_hait3 cuban5_hait3
				haitian5_target_hait3 = cuban5_hait3
			ENDIF
			
			SET_CHAR_PERSONALITY haitian5_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian5_hait3 TRUE
			
			++ counter_peds_got_ai_hait3
			
			flag_haitian5_got_ai_hait3 = 1
			
		ENDIF
		
	ENDIF 
			
ENDIF

IF flag_haitian6_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian6_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian6_hait3	
		
			CLEAR_CHAR_THREAT_SEARCH haitian6_hait3

			IF NOT IS_CHAR_DEAD cuban6_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian6_hait3 cuban6_hait3
				haitian6_target_hait3 = cuban6_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian6_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian6_hait3 TRUE
						
			++ counter_peds_got_ai_hait3 

		 	flag_haitian6_got_ai_hait3 = 1

		ENDIF

	ENDIF
 			
ENDIF

IF flag_haitian7_got_ai_hait3 = 0 

	IF NOT IS_CHAR_DEAD haitian7_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian7_hait3
		
			CLEAR_CHAR_THREAT_SEARCH haitian7_hait3

			IF NOT IS_CHAR_DEAD cuban7_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian7_hait3 cuban7_hait3
				haitian7_target_hait3 = cuban7_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian7_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian7_hait3 TRUE
		   		   
			++ counter_peds_got_ai_hait3
			
			flag_haitian7_got_ai_hait3 = 1
			
		ENDIF
		
	ENDIF 
			
ENDIF

IF flag_haitian8_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian8_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian8_hait3 
	
			CLEAR_CHAR_THREAT_SEARCH haitian8_hait3

			IF NOT IS_CHAR_DEAD cuban8_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian8_hait3 cuban8_hait3
				haitian8_target_hait3 = cuban8_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian8_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian8_hait3 TRUE

			++ counter_peds_got_ai_hait3
			
			flag_haitian8_got_ai_hait3 = 1
			
		ENDIF
		
	ENDIF 
			
ENDIF

IF flag_haitian9_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian9_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian9_hait3
		
			CLEAR_CHAR_THREAT_SEARCH haitian9_hait3

			IF NOT IS_CHAR_DEAD cuban9_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian9_hait3 cuban9_hait3
				haitian9_target_hait3 = cuban9_hait3
			ENDIF
			
		  	SET_CHAR_PERSONALITY haitian9_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian9_hait3 TRUE
						
			++ counter_peds_got_ai_hait3
			
			flag_haitian9_got_ai_hait3 = 1
			
		ENDIF
		
	ENDIF 
	 			
ENDIF

IF flag_haitian10_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD haitian10_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION haitian10_hait3
		
			CLEAR_CHAR_THREAT_SEARCH haitian10_hait3

			IF NOT IS_CHAR_DEAD cuban10_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT haitian10_hait3 cuban10_hait3
				haitian10_target_hait3 = cuban10_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY haitian10_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian10_hait3 TRUE
								   
		   	++ counter_peds_got_ai_hait3 

			flag_haitian10_got_ai_hait3 = 1

		ENDIF

	ENDIF
	 			
ENDIF

// **************************** CREATES THE CUBANS *****************************************

IF flag_cuban1_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban1_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban1_hait3

			CLEAR_CHAR_THREAT_SEARCH cuban1_hait3

			IF NOT IS_CHAR_DEAD haitian1_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban1_hait3 haitian1_hait3
				cuban1_target_hait3 = haitian1_hait3 
			ENDIF 
			
			SET_CHAR_PERSONALITY cuban1_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban1_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban1_hait3 cuban1_blip_hait3 
			
			++ counter_peds_got_ai_hait3
			
			flag_cuban1_got_ai_hait3 = 1

		ENDIF

	ENDIF
	
ENDIF 

IF flag_cuban2_got_ai_hait3 = 0	 				
  
	IF NOT IS_CHAR_DEAD cuban2_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban2_hait3
		
			CLEAR_CHAR_THREAT_SEARCH cuban2_hait3

			IF NOT IS_CHAR_DEAD haitian2_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban2_hait3 haitian2_hait3
				cuban2_target_hait3 = haitian2_hait3
			ENDIF
			
			SET_CHAR_PERSONALITY cuban2_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban2_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban2_hait3 cuban2_blip_hait3
						
			++ counter_peds_got_ai_hait3 
				
			flag_cuban2_got_ai_hait3 = 1
				
		ENDIF

	ENDIF

ENDIF

IF flag_cuban3_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban3_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban3_hait3

			CLEAR_CHAR_THREAT_SEARCH cuban3_hait3

			IF NOT IS_CHAR_DEAD haitian3_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban3_hait3 haitian3_hait3
				cuban3_target_hait3 = haitian3_hait3
			ENDIF
						
			SET_CHAR_PERSONALITY cuban3_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban3_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban3_hait3 cuban3_blip_hait3
			
			++ counter_peds_got_ai_hait3
			
			flag_cuban3_got_ai_hait3 = 1
			
		ENDIF 
				
	ENDIF
	
ENDIF

IF flag_cuban4_got_ai_hait3 = 0  

	IF NOT IS_CHAR_DEAD cuban4_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban4_hait3

			CLEAR_CHAR_THREAT_SEARCH cuban4_hait3

			IF NOT IS_CHAR_DEAD haitian4_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban4_hait3 haitian4_hait3
				cuban4_target_hait3 = haitian4_hait3
			ENDIF
			
			SET_CHAR_PERSONALITY cuban4_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban4_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban4_hait3 cuban4_blip_hait3
			
			++ counter_peds_got_ai_hait3

			flag_cuban4_got_ai_hait3 = 1

		ENDIF
	 	 			
	ENDIF

ENDIF

IF flag_cuban5_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban5_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban5_hait3 

			CLEAR_CHAR_THREAT_SEARCH cuban5_hait3

			IF NOT IS_CHAR_DEAD haitian5_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban5_hait3 haitian5_hait3
				cuban5_target_hait3 = haitian5_hait3
			ENDIF
						
			SET_CHAR_PERSONALITY cuban5_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban5_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban5_hait3 cuban5_blip_hait3
						
			++ counter_peds_got_ai_hait3
		 	
			flag_cuban5_got_ai_hait3 = 1
		   		
		ENDIF

	ENDIF

ENDIF

IF flag_cuban6_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban6_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban6_hait3	

			CLEAR_CHAR_THREAT_SEARCH cuban6_hait3

			IF NOT IS_CHAR_DEAD haitian6_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban6_hait3 haitian6_hait3
				cuban6_target_hait3 = haitian6_hait3
			ENDIF
			
			SET_CHAR_PERSONALITY cuban6_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban6_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban6_hait3 cuban6_blip_hait3
						
			++ counter_peds_got_ai_hait3
 	
 		   flag_cuban6_got_ai_hait3 = 1

		ENDIF

	ENDIF
		
ENDIF

IF flag_cuban7_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban7_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban7_hait3

			CLEAR_CHAR_THREAT_SEARCH cuban7_hait3

			IF NOT IS_CHAR_DEAD haitian7_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban7_hait3 haitian7_hait3
				cuban7_target_hait3 = haitian7_hait3
			ENDIF
						
			SET_CHAR_PERSONALITY cuban7_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban7_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban7_hait3 cuban7_blip_hait3
						
			++ counter_peds_got_ai_hait3 

 			flag_cuban7_got_ai_hait3 = 1

		ENDIF

	ENDIF
	
ENDIF

IF flag_cuban8_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban8_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban8_hait3

			CLEAR_CHAR_THREAT_SEARCH cuban8_hait3

			IF NOT IS_CHAR_DEAD haitian8_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban8_hait3 haitian8_hait3
				cuban8_target_hait3 = haitian8_hait3
			ENDIF
			
			SET_CHAR_PERSONALITY cuban8_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban8_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban8_hait3 cuban8_blip_hait3
						
			++ counter_peds_got_ai_hait3
			
			flag_cuban8_got_ai_hait3 = 1
						
		ENDIF
		
	ENDIF 
			
ENDIF

IF flag_cuban9_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban9_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban9_hait3 

			CLEAR_CHAR_THREAT_SEARCH cuban9_hait3

			IF NOT IS_CHAR_DEAD haitian9_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban9_hait3 haitian9_hait3
				cuban9_target_hait3 = haitian9_hait3
			ENDIF
						
		   	SET_CHAR_PERSONALITY cuban9_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban9_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban9_hait3 cuban9_blip_hait3
						
			++ counter_peds_got_ai_hait3 

		 	flag_cuban9_got_ai_hait3 = 1

		ENDIF

	ENDIF
 			
ENDIF

IF flag_cuban10_got_ai_hait3 = 0

	IF NOT IS_CHAR_DEAD cuban10_hait3

		IF NOT IS_CHAR_WAITING_FOR_WORLD_COLLISION cuban10_hait3

			CLEAR_CHAR_THREAT_SEARCH cuban10_hait3

			IF NOT IS_CHAR_DEAD haitian10_hait3 
				SET_CHAR_OBJ_KILL_CHAR_ON_FOOT cuban10_hait3 haitian10_hait3
				cuban10_target_hait3 = haitian10_hait3
			ENDIF
			
		   	SET_CHAR_PERSONALITY cuban10_hait3 PEDSTAT_TOUGH_GUY

			SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban10_hait3 TRUE

			ADD_BLIP_FOR_CHAR cuban10_hait3 cuban10_blip_hait3
						
			++ counter_peds_got_ai_hait3
			
			flag_cuban10_got_ai_hait3 = 1 

		ENDIF
 			
	ENDIF

ENDIF

RETURN

// If the player is on the roof then the guys can now die

guys_can_die_hait3:

//IF NOT IS_CHAR_DEAD cuban1_hait3 
//	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban1_hait3 FALSE
//ENDIF

IF NOT IS_CHAR_DEAD cuban2_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban2_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban3_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban3_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban4_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban4_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban5_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban5_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban6_hait3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban6_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban7_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban7_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban8_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban8_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban9_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban9_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban10_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban10_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian1_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian1_hait3 FALSE
ENDIF
 
IF NOT IS_CHAR_DEAD haitian2_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian2_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian3_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian3_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian4_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian4_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian5_hait3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian5_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian6_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian6_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian7_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian7_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian8_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian8_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian9_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian9_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian10_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian10_hait3 FALSE
ENDIF

all_peds_can_die_hait3 = 1

RETURN

// *****************************************************************************************
// *************************************** Cuban Dead Checks *******************************
// *****************************************************************************************

dead_cuban_check:

// cuban1

IF frame_counter_hait3 = 0

	IF flag_cuban1_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban1_hait3
			REMOVE_BLIP cuban1_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban1_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban1_dead_hait3 = 1
		ELSE
			
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban1_hait3
				GOSUB player_spotted_hait3
			ENDIF
			
			IF IS_CHAR_DEAD cuban1_target_hait3   
				gosub_cuban1_hait3 = cuban1_hait3
				GOSUB cuban1_attack_hait3
			ENDIF  	   
							   				 						
		ENDIF
			
	ENDIF

ENDIF

// cuban2

IF frame_counter_hait3 = 1

	IF flag_cuban2_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban2_hait3
			REMOVE_BLIP cuban2_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban2_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban2_dead_hait3 = 1
		ELSE
			
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban2_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban2_target_hait3
				gosub_cuban1_hait3 = cuban2_hait3
				GOSUB cuban1_attack_hait3
			ENDIF
				   	   		
		ENDIF
			
	ENDIF

ENDIF

// cuban3

IF frame_counter_hait3 = 2

	IF flag_cuban3_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban3_hait3
			REMOVE_BLIP cuban3_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban3_hait3
			GOSUB all_guys_death_check_hait3		
			flag_cuban3_dead_hait3 = 1
		ELSE
			
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban3_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban3_target_hait3
				gosub_cuban1_hait3 = cuban3_hait3
				GOSUB cuban1_attack_hait3
			ENDIF
							 		
		ENDIF
			
	ENDIF

ENDIF

// cuban4

IF frame_counter_hait3 = 3

	IF flag_cuban4_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban4_hait3
			REMOVE_BLIP cuban4_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban4_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban4_dead_hait3 = 1
		ELSE
				   
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban4_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban4_target_hait3
				gosub_cuban1_hait3 = cuban4_hait3
				GOSUB cuban1_attack_hait3
			ENDIF
					 
		ENDIF
			
	ENDIF

ENDIF

// cuban5

IF frame_counter_hait3 = 4

	IF flag_cuban5_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban5_hait3
			REMOVE_BLIP cuban5_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban5_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban5_dead_hait3 = 1
		ELSE
		   
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban5_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban5_target_hait3
				gosub_cuban1_hait3 = cuban5_hait3
				GOSUB cuban1_attack_hait3
			ENDIF
		  						 
		ENDIF
			
	ENDIF

ENDIF

// cuban6

IF frame_counter_hait3 = 5

	IF flag_cuban6_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban6_hait3
			REMOVE_BLIP cuban6_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban6_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban6_dead_hait3 = 1
		ELSE
		   	   
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban6_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban6_target_hait3
				gosub_cuban1_hait3 = cuban6_hait3
				GOSUB cuban1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// cuban7

IF frame_counter_hait3 = 6

	IF flag_cuban7_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban7_hait3
			REMOVE_BLIP cuban7_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban7_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban7_dead_hait3 = 1
		ELSE

		   	IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban7_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban7_target_hait3
				gosub_cuban1_hait3 = cuban7_hait3
				GOSUB cuban1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// cuban8

IF frame_counter_hait3 = 7

	IF flag_cuban8_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban8_hait3
			REMOVE_BLIP cuban8_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban8_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban8_dead_hait3 = 1
		ELSE
		   
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban8_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban8_target_hait3
				gosub_cuban1_hait3 = cuban8_hait3
				GOSUB cuban1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// cuban9

IF frame_counter_hait3 = 8

	IF flag_cuban9_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban9_hait3
			REMOVE_BLIP cuban9_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban9_hait3
			GOSUB all_guys_death_check_hait3		
			flag_cuban9_dead_hait3 = 1
		ELSE

		  	IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban9_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban9_target_hait3
				gosub_cuban1_hait3 = cuban9_hait3
				GOSUB cuban1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// cuban10

IF frame_counter_hait3 = 9

	IF flag_cuban10_dead_hait3 = 0

		IF IS_CHAR_DEAD cuban10_hait3
			REMOVE_BLIP cuban10_blip_hait3
			++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = cuban10_hait3
			GOSUB all_guys_death_check_hait3
			flag_cuban10_dead_hait3 = 1
		ELSE

		  	IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = cuban10_hait3
				GOSUB player_spotted_hait3
			ENDIF

			IF IS_CHAR_DEAD cuban10_target_hait3
				gosub_cuban1_hait3 = cuban10_hait3
				GOSUB cuban1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

RETURN


// Player spotted stuff

player_spotted_hait3:

IF HAS_CHAR_SPOTTED_PLAYER gosub_spotter_hait3 player1
				
	IF IS_PLAYER_SHOOTING player1

		IF flag_fight1_over_hait3 = 0
						 																
			IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -936.42 109.11 13.0 -873.118 45.222 18.0 30.0 FALSE
				flag_player_spotted_hait3 = 0
			ELSE
				flag_player_spotted_hait3 = 1
			ENDIF
						
		ENDIF
										
	ENDIF

ENDIF

RETURN


// *****************************************************************************************
// ************************************ Haitian Death Checks *******************************
// *****************************************************************************************

dead_haitian_check:

// Haitian1

IF frame_counter_hait3 = 10

	IF flag_haitian1_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian1_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian1_hait3
			GOSUB all_guys_death_check_hait3
			flag_haitian1_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian1_target_hait3
	   			gosub_haitian1_hait3 = haitian1_hait3
				GOSUB haitian1_attack_hait3
		 	ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian2

IF frame_counter_hait3 = 11

	IF flag_haitian2_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian2_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian2_hait3
			GOSUB all_guys_death_check_hait3
			flag_haitian2_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian2_target_hait3
				gosub_haitian1_hait3 = haitian2_hait3
				GOSUB haitian1_attack_hait3
			ENDIF
			
		ENDIF
			
	ENDIF

ENDIF

// haitian3

IF frame_counter_hait3 = 12

	IF flag_haitian3_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian3_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian3_hait3
			GOSUB all_guys_death_check_hait3
			flag_haitian3_dead_hait3 = 1
		ELSE	


			IF IS_CHAR_DEAD haitian3_target_hait3
				gosub_haitian1_hait3 = haitian3_hait3
				GOSUB haitian1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian4

IF frame_counter_hait3 = 13

	IF flag_haitian4_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian4_hait3
	   		++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian4_hait3
			GOSUB all_guys_death_check_hait3
			flag_haitian4_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian4_target_hait3
				gosub_haitian1_hait3 = haitian4_hait3
				GOSUB haitian1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian5

IF frame_counter_hait3 = 14

	IF flag_haitian5_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian5_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian5_hait3
			GOSUB all_guys_death_check_hait3				
			flag_haitian5_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian5_target_hait3
				gosub_haitian1_hait3 = haitian5_hait3
				GOSUB haitian1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian6

IF frame_counter_hait3 = 15

	IF flag_haitian6_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian6_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian6_hait3
			GOSUB all_guys_death_check_hait3
			flag_haitian6_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian6_target_hait3
				gosub_haitian1_hait3 = haitian6_hait3
				GOSUB haitian1_attack_hait3
			ENDIF
			
		ENDIF
			
	ENDIF

ENDIF

// haitian7

IF frame_counter_hait3 = 16

	IF flag_haitian7_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian7_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian7_hait3
			GOSUB all_guys_death_check_hait3		
			flag_haitian7_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian7_target_hait3
				gosub_haitian1_hait3 = haitian7_hait3
				GOSUB haitian1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian8

IF frame_counter_hait3 = 17

	IF flag_haitian8_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian8_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian8_hait3
			GOSUB all_guys_death_check_hait3		
			flag_haitian8_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian8_target_hait3
				gosub_haitian1_hait3 = haitian8_hait3
				GOSUB haitian1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian9

IF frame_counter_hait3 = 18

	IF flag_haitian9_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian9_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian9_hait3
			GOSUB all_guys_death_check_hait3		
			flag_haitian9_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian9_target_hait3
				gosub_haitian1_hait3 = haitian9_hait3
				GOSUB haitian1_attack_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// haitian10

IF frame_counter_hait3 = 19

	IF flag_haitian10_dead_hait3 = 0

		IF IS_CHAR_DEAD haitian10_hait3
			++ counter_dead_haitian
			gosub_death_check_bloke_hait3 = haitian10_hait3
			GOSUB all_guys_death_check_hait3
			flag_haitian10_dead_hait3 = 1
		ELSE

			IF IS_CHAR_DEAD haitian10_target_hait3
				gosub_haitian1_hait3 = haitian10_hait3
				GOSUB haitian1_attack_hait3
			ENDIF
		
		ENDIF
			
	ENDIF

ENDIF

RETURN

// Creates the guys to jump into fight

ambush1_hait3:

IF flag_ambush1_created_hait3 = 0
	
	//DO_FADE 500 FADE_OUT		
	//SWITCH_WIDESCREEN ON
	//SET_PLAYER_CONTROL player1 OFF
	//SET_POLICE_IGNORE_PLAYER player1 ON
	//SET_EVERYONE_IGNORE_PLAYER player1 ON
	
	//GOSUB both_sides_cant_die_hait3
	/*
	WHILE GET_FADING_STATUS

		WAIT 0
		
		++ frame_counter_hait3
		IF frame_counter_hait3 > 30
			frame_counter_hait3 = 0
		ENDIF
						
		CLEAR_WANTED_LEVEL player1
							
		GOSUB dead_cuban_check

		GOSUB dead_haitian_check

		IF counter_dead_cuban >= 20
			flag_fight_over_hait3 = 1
		ENDIF

		IF counter_dead_haitian >= 3

			IF player_had_warning_message_hait3 = 0
				PRINT_NOW ( HAM3_8 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
				player_had_warning_message_hait3 = 1
			ENDIF
			
		ENDIF

		IF counter_dead_haitian >= 10
			PRINT_NOW ( HAM3_2 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
		   	GOTO mission_haitian3_failed
		ENDIF
		
		IF flag_player_spotted_hait3 = 1
		OR player_spotted_melee_hait3 = 1
			PRINT_NOW ( HAM3_4 ) 5000 1 //"You have been spotted the mission is a failure!"
		   	GOTO mission_haitian3_failed
		ENDIF
				
	ENDWHILE
	*/
	
	//LOAD_SCENE -874.053 24.621 11.652 
	//CLEAR_AREA -874.053 24.621 11.652 1.0 FALSE 
	//SET_FIXED_CAMERA_POSITION -874.053 24.621 11.652 0.0 0.0 0.0
	//POINT_CAMERA_AT_POINT -874.714 25.371 11.620 JUMP_CUT
		
	CREATE_CAR BURRITO truck1_x_hait3 truck1_y_hait3 truck1_z_hait3 truck1_hait3 
	SET_CAR_HEADING truck1_hait3 275.73
	CREATE_CHAR_INSIDE_CAR truck1_hait3 PEDTYPE_CIVMALE CBa ambush_driver1_hait3
	CLEAR_CHAR_THREAT_SEARCH ambush_driver1_hait3
	ADD_BLIP_FOR_CHAR ambush_driver1_hait3 ambush_driver1_blip_hait3
	SET_CHAR_PERSONALITY ambush_driver1_hait3 PEDSTAT_TOUGH_GUY
	CAR_SET_IDLE truck1_hait3
	
	CREATE_CHAR_AS_PASSENGER truck1_hait3 PEDTYPE_CIVMALE CBb 0 ambush_cuban1_hait3 
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban1_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban1_hait3 ambush_cuban1_blip_hait3
	SET_CHAR_PERSONALITY ambush_cuban1_hait3 PEDSTAT_TOUGH_GUY
	
	CREATE_CHAR_AS_PASSENGER truck1_hait3 PEDTYPE_CIVMALE CBa 1 ambush_cuban2_hait3 
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban2_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban2_hait3 ambush_cuban2_blip_hait3
	SET_CHAR_PERSONALITY ambush_cuban2_hait3 PEDSTAT_TOUGH_GUY
	
	CREATE_CHAR_AS_PASSENGER truck1_hait3 PEDTYPE_CIVMALE CBb 2 ambush_cuban3_hait3 
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban3_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban3_hait3 ambush_cuban3_blip_hait3
	SET_CHAR_PERSONALITY ambush_cuban3_hait3 PEDSTAT_TOUGH_GUY
	
	CAR_GOTO_COORDINATES truck1_hait3 truck1_dest_x_hait3 truck1_dest_y_hait3 truck1_dest_z_hait3
	SET_CAR_DRIVING_STYLE truck1_hait3 2
	SET_CAR_CRUISE_SPEED truck1_hait3 35.0

	//DO_FADE 500 FADE_IN
	
	PRINT_NOW ( HAM3_7 ) 5000 1 //"What out the Cubans are cheating, those guys have guns."
	
	//timera = 0

/*

	WHILE timera < 5000

		WAIT 0

		IF NOT IS_CAR_DEAD truck1_hait3

			IF LOCATE_CAR_3D truck1_hait3 truck1_dest_x_hait3 truck1_dest_y_hait3 truck1_dest_z_hait3 3.0 3.0 3.0 FALSE
				flag_truck1_in_position_hait3 = 1	
			ENDIF
			
		ENDIF   

		++ frame_counter_hait3
		IF frame_counter_hait3 > 30
			frame_counter_hait3 = 0
		ENDIF
						
		CLEAR_WANTED_LEVEL player1
							
		GOSUB dead_cuban_check

		GOSUB dead_haitian_check

		IF counter_dead_cuban >= 20
			flag_fight_over_hait3 = 1
		ENDIF

		IF counter_dead_haitian >= 3

			IF player_had_warning_message_hait3 = 0
				PRINT_NOW ( HAM3_8 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
				player_had_warning_message_hait3 = 1
			ENDIF
			
		ENDIF

		IF counter_dead_haitian >= 10
			PRINT_NOW ( HAM3_2 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
		   	GOTO mission_haitian3_failed
		ENDIF
		
		IF flag_player_spotted_hait3 = 1
		OR player_spotted_melee_hait3 = 1
			PRINT_NOW ( HAM3_4 ) 5000 1 //"You have been spotted the mission is a failure!"
		   	GOTO mission_haitian3_failed
		ENDIF
			   
		IF flag_ambush2_created_hait3 = 0

			IF counter_dead_cuban >= 12
				GOSUB ambush2_hait3
			ENDIF

		ENDIF
						
	ENDWHILE

*/

   //	GOSUB both_sides_can_die_hait3 

	//SWITCH_WIDESCREEN OFF
	//SET_PLAYER_CONTROL player1 ON
   //	SET_POLICE_IGNORE_PLAYER player1 OFF
   //	SET_EVERYONE_IGNORE_PLAYER player1 OFF
   //	SET_CAMERA_BEHIND_PLAYER
	//RESTORE_CAMERA_JUMPCUT

	frame_counter_hait3 = 19
	
	flag_ambush1_created_hait3 = 1

ENDIF

RETURN

// ambush 2 the guys with the chainsaws running across the road

ambush2_hait3:

IF flag_ambush2_created_hait3 = 0

   //	SWITCH_WIDESCREEN ON
   //	SET_PLAYER_CONTROL player1 OFF 
   //	SET_POLICE_IGNORE_PLAYER player1 ON
   //	SET_EVERYONE_IGNORE_PLAYER player1 ON

   //	DO_FADE 500 FADE_OUT

   //	GOSUB both_sides_cant_die_hait3

/*
	WHILE GET_FADING_STATUS

		WAIT 0
		
		++ frame_counter_hait3
		IF frame_counter_hait3 > 30
			frame_counter_hait3 = 0
		ENDIF
		 	   		
		CLEAR_WANTED_LEVEL player1
							
		GOSUB dead_cuban_check

		GOSUB dead_haitian_check

		IF counter_dead_cuban >= 20
			flag_fight_over_hait3 = 1
		ENDIF

		IF counter_dead_haitian >= 3

			IF player_had_warning_message_hait3 = 0
				PRINT_NOW ( HAM3_8 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
				player_had_warning_message_hait3 = 1
			ENDIF
			
		ENDIF

		IF counter_dead_haitian >= 10
			PRINT_NOW ( HAM3_2 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
			GOTO mission_haitian3_failed
		ENDIF
		
		IF flag_player_spotted_hait3 = 1
		OR player_spotted_melee_hait3 = 1
			PRINT_NOW ( HAM3_4 ) 5000 1 //"You have been spotted the mission is a failure!"
		   	GOTO mission_haitian3_failed
		ENDIF
				
		IF flag_ambush1_created_hait3 = 1
			GOSUB ambush1_death_checks
	   	ENDIF

	ENDWHILE

*/
			
	CREATE_CHAR PEDTYPE_CIVMALE CBa -862.426 59.084 8.38 ambush_cuban4_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban4_hait3 ambush_cuban4_blip_hait3 
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban4_hait3
	SET_CHAR_THREAT_SEARCH ambush_cuban4_hait3 THREAT_GANG_HAITIAN
	SET_CHAR_PERSONALITY ambush_cuban4_hait3 PEDSTAT_TOUGH_GUY
   	SET_CHAR_OBJ_RUN_TO_COORD ambush_cuban4_hait3 fight1_x_hait3 fight1_y_hait3
	cuban4_goto_position_hait3 = 1 
	
	CREATE_CHAR PEDTYPE_CIVMALE CBb -864.075 59.570 8.38 ambush_cuban5_hait3
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban5_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban5_hait3 ambush_cuban5_blip_hait3
	SET_CHAR_THREAT_SEARCH ambush_cuban5_hait3 THREAT_GANG_HAITIAN
	SET_CHAR_PERSONALITY ambush_cuban5_hait3 PEDSTAT_TOUGH_GUY
	SET_CHAR_OBJ_RUN_TO_COORD ambush_cuban5_hait3 fight1_x_hait3 fight1_y_hait3
	cuban5_goto_position_hait3 = 1
	
	CREATE_CHAR PEDTYPE_CIVMALE CBa -865.799 60.488 8.38 ambush_cuban6_hait3
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban6_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban6_hait3 ambush_cuban6_blip_hait3
	SET_CHAR_THREAT_SEARCH ambush_cuban6_hait3 THREAT_GANG_HAITIAN
	GIVE_WEAPON_TO_CHAR ambush_cuban6_hait3 WEAPONTYPE_KATANA 1
	SET_CHAR_PERSONALITY ambush_cuban6_hait3 PEDSTAT_TOUGH_GUY
	SET_CHAR_OBJ_RUN_TO_COORD ambush_cuban6_hait3 fight1_x_hait3 fight1_y_hait3
	cuban6_goto_position_hait3 = 1
	
	CREATE_CHAR PEDTYPE_CIVMALE CBb -868.311 61.519 8.38 ambush_cuban7_hait3
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban7_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban7_hait3 ambush_cuban7_blip_hait3
	SET_CHAR_THREAT_SEARCH ambush_cuban7_hait3 THREAT_GANG_HAITIAN
	SET_CHAR_PERSONALITY ambush_cuban7_hait3 PEDSTAT_TOUGH_GUY
	SET_CHAR_OBJ_RUN_TO_COORD ambush_cuban7_hait3 fight1_x_hait3 fight1_y_hait3
	cuban7_goto_position_hait3 = 1
	
	CREATE_CHAR PEDTYPE_CIVMALE CBa -870.435 62.566 8.38 ambush_cuban8_hait3
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban8_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban8_hait3 ambush_cuban8_blip_hait3
	SET_CHAR_THREAT_SEARCH ambush_cuban8_hait3 THREAT_GANG_HAITIAN
	SET_CHAR_PERSONALITY ambush_cuban8_hait3 PEDSTAT_TOUGH_GUY
	SET_CHAR_OBJ_RUN_TO_COORD ambush_cuban8_hait3 fight1_x_hait3 fight1_y_hait3
	cuban8_goto_position_hait3 = 1
	
	CREATE_CHAR PEDTYPE_CIVMALE CBb -872.876 63.476 8.38 ambush_cuban9_hait3
	CLEAR_CHAR_THREAT_SEARCH ambush_cuban9_hait3
	ADD_BLIP_FOR_CHAR ambush_cuban9_hait3 ambush_cuban9_blip_hait3
	SET_CHAR_THREAT_SEARCH ambush_cuban9_hait3 THREAT_GANG_HAITIAN
	SET_CHAR_PERSONALITY ambush_cuban9_hait3 PEDSTAT_TOUGH_GUY
	SET_CHAR_OBJ_RUN_TO_COORD ambush_cuban9_hait3 fight1_x_hait3 fight1_y_hait3
	cuban9_goto_position_hait3 = 1

	//CLEAR_AREA 912.677 55.208 11.537 1.0 FALSE 
	//SET_FIXED_CAMERA_POSITION -912.677 55.208 11.537 0.0 0.0 0.0
	//POINT_CAMERA_AT_POINT -911.741 54.872 11.433 JUMP_CUT

	//DO_FADE 500 FADE_IN
	
	PRINT_NOW ( HAM3_7 ) 5000 1 //"What out the Cubans are cheating, those guys have guns."

   //	timera = 0

/*
	WHILE timera < 6000

		WAIT 0
		
		++ frame_counter_hait3
		IF frame_counter_hait3 > 30
			frame_counter_hait3 = 0
		ENDIF
		 	   		
		CLEAR_WANTED_LEVEL player1
							
		GOSUB dead_cuban_check

		GOSUB dead_haitian_check

		IF counter_dead_cuban >= 20
			flag_fight_over_hait3 = 1
		ENDIF

		IF counter_dead_haitian >= 3

			IF player_had_warning_message_hait3 = 0
				PRINT_NOW ( HAM3_8 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
				player_had_warning_message_hait3 = 1
			ENDIF
			
		ENDIF

		IF counter_dead_haitian >= 10
			PRINT_NOW ( HAM3_2 ) 5000 1 //"You were supposed to kill the Cubans not Haitians!"
			GOTO mission_haitian3_failed
		ENDIF
		
		IF flag_player_spotted_hait3 = 1
		OR player_spotted_melee_hait3 = 1
			PRINT_NOW ( HAM3_4 ) 5000 1 //"You have been spotted the mission is a failure!"
		   	GOTO mission_haitian3_failed
		ENDIF
		
		
		IF flag_ambush1_created_hait3 = 1
			GOSUB ambush1_death_checks
	   	ENDIF
	   
	ENDWHILE

*/
		
	//GOSUB both_sides_can_die_hait3
		
	//SWITCH_WIDESCREEN OFF
   //	SET_PLAYER_CONTROL player1 ON 
	//SET_POLICE_IGNORE_PLAYER player1 OFF
   //	SET_EVERYONE_IGNORE_PLAYER player1 OFF
   //	SET_CAMERA_BEHIND_PLAYER
   //	RESTORE_CAMERA_JUMPCUT

	frame_counter_hait3 = 23 
	
	flag_ambush2_created_hait3 = 1

ENDIF

RETURN

// Checks to see if any of the guys are dead

ambush1_death_checks:

IF truck1_dead_hait3 = 0

	IF IS_CAR_DEAD truck1_hait3
		truck1_dead_hait3 = 1
	ELSE
		
		IF flag_truck1_in_position_hait3 = 0
			
			IF LOCATE_CAR_3D truck1_hait3 truck1_dest_x_hait3 truck1_dest_y_hait3 truck1_dest_z_hait3 3.0 3.0 3.0 FALSE
				SET_CAR_CRUISE_SPEED truck1_hait3 0.0
				CAR_SET_IDLE truck1_hait3
				flag_truck1_in_position_hait3 = 1
			ENDIF
				
			IF ambush_driver1_dead_hait3 = 0
				   	
			ELSE
				SET_CAR_CRUISE_SPEED truck1_hait3 0.0 
				CAR_SET_IDLE truck1_hait3
			ENDIF

		ENDIF
			
	ENDIF
		
ENDIF
	
// Driver car1

IF frame_counter_hait3 = 21

	IF ambush_driver1_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_driver1_hait3
			REMOVE_BLIP ambush_driver1_blip_hait3 
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_driver1_hait3
			GOSUB all_guys_death_check_hait3
			ambush_driver1_dead_hait3 = 1
		ELSE
					
			IF flag_truck1_in_position_hait3 = 1

				IF driver1_goto_position_hait3 = 0
			
					IF IS_CHAR_IN_ANY_CAR ambush_driver1_hait3
						STORE_CAR_CHAR_IS_IN ambush_driver1_hait3 truck1_hait3
						
						IF NOT IS_CAR_DEAD truck1_hait3   
							SET_CHAR_OBJ_LEAVE_CAR ambush_driver1_hait3 truck1_hait3
						ENDIF
						 
					ELSE
						ambush_driver1_target_hait3 = haitian10_hait3

						IF NOT IS_CHAR_DEAD ambush_driver1_target_hait3 
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_driver1_hait3 ambush_driver1_target_hait3  
						ENDIF
						driver1_goto_position_hait3 = 1
					ENDIF

				ENDIF
				
			ENDIF

			IF driver1_goto_position_hait3 = 1
				
				IF IS_CHAR_DEAD ambush_driver1_target_hait3
				   	gosub_cuban1_hait3 = ambush_driver1_hait3 
					GOSUB cuban1_attack_hait3
				ENDIF
				  								
			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_driver1_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// Cuban 1

IF frame_counter_hait3 = 22

	IF ambush_cuban1_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban1_hait3
			REMOVE_BLIP ambush_cuban1_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban1_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban1_dead_hait3 = 1
		ELSE
					   			   		
			IF ambush_driver1_dead_hait3 = 1

				IF truck1_dead_hait3 = 0

					IF cuban1_goto_position_hait3 = 0

						IF IS_CHAR_IN_ANY_CAR ambush_cuban1_hait3
							STORE_CAR_CHAR_IS_IN ambush_cuban1_hait3 truck1_hait3

							IF NOT IS_CAR_DEAD truck1_hait3 
								SET_CHAR_OBJ_LEAVE_CAR ambush_cuban1_hait3 truck1_hait3
							ENDIF
							 
						ELSE
						  	cuban1_goto_position_hait3 = 1 
						ENDIF

					ENDIF

				ENDIF
					
			ENDIF
					
			IF flag_truck1_in_position_hait3 = 1

				IF cuban1_goto_position_hait3 = 0
			
					IF IS_CHAR_IN_ANY_CAR ambush_cuban1_hait3
						STORE_CAR_CHAR_IS_IN ambush_cuban1_hait3 truck1_hait3

						IF NOT IS_CAR_DEAD truck1_hait3 
							SET_CHAR_OBJ_LEAVE_CAR ambush_cuban1_hait3 truck1_hait3
						ENDIF
						 
					ELSE
					  	ambush_cuban1_target_hait3 = haitian9_hait3

						IF NOT IS_CHAR_DEAD ambush_cuban1_target_hait3 
							SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban1_hait3 ambush_cuban1_target_hait3  
						ENDIF
						
						cuban1_goto_position_hait3 = 1
					ENDIF

				ENDIF
				
			ENDIF

			IF cuban1_goto_position_hait3 = 1

				IF IS_CHAR_DEAD ambush_cuban1_target_hait3 
					gosub_cuban1_hait3 = ambush_cuban1_hait3 
				   	GOSUB cuban1_attack_hait3
				ENDIF
							
			ENDIF
					
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban1_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// Cuban2

IF frame_counter_hait3 = 23

	IF ambush_cuban2_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban2_hait3
			REMOVE_BLIP ambush_cuban2_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban2_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban2_dead_hait3 = 1
		ELSE
		   
			IF ambush_driver1_dead_hait3 = 1

				IF truck1_dead_hait3 = 0

					IF cuban2_goto_position_hait3 = 0

						IF IS_CHAR_IN_ANY_CAR ambush_cuban2_hait3
							STORE_CAR_CHAR_IS_IN ambush_cuban2_hait3 truck1_hait3

							IF NOT IS_CAR_DEAD truck1_hait3
								SET_CHAR_OBJ_LEAVE_CAR ambush_cuban2_hait3 truck1_hait3 
							ENDIF

						ELSE
						   	ambush_cuban2_target_hait3 = haitian8_hait3

							IF NOT IS_CHAR_DEAD ambush_cuban2_target_hait3 
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban2_hait3 ambush_cuban2_target_hait3  
							ENDIF

							cuban2_goto_position_hait3 = 1
						ENDIF

					ENDIF
					
				ENDIF
				
			ENDIF
			
			IF flag_truck1_in_position_hait3 = 1

				IF cuban2_goto_position_hait3 = 0
			
					IF IS_CHAR_IN_ANY_CAR ambush_cuban2_hait3
						STORE_CAR_CHAR_IS_IN ambush_cuban2_hait3 truck1_hait3

						IF NOT IS_CAR_DEAD truck1_hait3
							SET_CHAR_OBJ_LEAVE_CAR ambush_cuban2_hait3 truck1_hait3 
						ENDIF
						 
					ELSE
						cuban2_goto_position_hait3 = 1
					ENDIF

				ENDIF
				
			ENDIF

			IF cuban2_goto_position_hait3 = 1

				IF IS_CHAR_DEAD ambush_cuban2_target_hait3
				  	gosub_cuban1_hait3 = ambush_cuban2_hait3 
				   	GOSUB cuban1_attack_hait3
				ENDIF
							
			ENDIF
			
			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban2_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// Cuban3

IF frame_counter_hait3 = 24

	IF ambush_cuban3_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban3_hait3
			REMOVE_BLIP ambush_cuban3_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban3_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban3_dead_hait3 = 1
		ELSE
			
			IF ambush_driver1_dead_hait3 = 1

				IF truck1_dead_hait3 = 0

					IF cuban3_goto_position_hait3 = 0

						IF IS_CHAR_IN_ANY_CAR ambush_cuban3_hait3
							STORE_CAR_CHAR_IS_IN ambush_cuban3_hait3 truck1_hait3

							IF NOT IS_CAR_DEAD truck1_hait3
								SET_CHAR_OBJ_LEAVE_CAR ambush_cuban3_hait3 truck1_hait3 
							ENDIF

						ELSE
						   	ambush_cuban3_target_hait3 = haitian8_hait3

							IF NOT IS_CHAR_DEAD ambush_cuban3_target_hait3 
								SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban3_hait3 ambush_cuban3_target_hait3  
							ENDIF
							
							cuban3_goto_position_hait3 = 1
						ENDIF
					ENDIF

									
				ENDIF
				
			ENDIF
			
			IF flag_truck1_in_position_hait3 = 1

				IF cuban3_goto_position_hait3 = 0
			
					IF IS_CHAR_IN_ANY_CAR ambush_cuban3_hait3
						STORE_CAR_CHAR_IS_IN ambush_cuban3_hait3 truck1_hait3

						IF NOT IS_CAR_DEAD truck1_hait3
							SET_CHAR_OBJ_LEAVE_CAR ambush_cuban3_hait3 truck1_hait3 
						ENDIF 
					ELSE
					   	cuban3_goto_position_hait3 = 1
					ENDIF
				
				ENDIF

			ENDIF

			IF cuban3_goto_position_hait3 = 1

				IF IS_CHAR_DEAD ambush_cuban3_target_hait3
					gosub_cuban1_hait3 = ambush_cuban3_hait3 
				   	GOSUB cuban1_attack_hait3
			   	ENDIF
				
			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban3_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

RETURN

// Group 2 of ambush guys

ambush2_death_checks:

// cuban 4

IF frame_counter_hait3 = 25

	IF ambush_cuban4_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban4_hait3
			REMOVE_BLIP ambush_cuban4_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban4_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban4_dead_hait3 = 1
		ELSE
			
			IF cuban4_goto_position_hait3 = 1
			
				IF LOCATE_CHAR_ON_FOOT_2D ambush_cuban4_hait3 fight1_x_hait3 fight1_y_hait3 4.0 4.0 FALSE
				   	cuban4_goto_position_hait3 = 2
				ENDIF
				
			ENDIF   
			
			IF cuban4_goto_position_hait3 = 2
			
				ambush_cuban4_target_hait3 = haitian7_hait3

				IF NOT IS_CHAR_DEAD ambush_cuban4_target_hait3 
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban4_hait3 ambush_cuban4_target_hait3  
				ENDIF
					
				cuban4_goto_position_hait3 = 3
			   				
			ENDIF

			IF cuban4_goto_position_hait3 = 3
			
				IF IS_CHAR_DEAD ambush_cuban4_target_hait3
					gosub_cuban1_hait3 = ambush_cuban4_hait3 
				   	GOSUB cuban1_attack_hait3
			  	ENDIF

			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban4_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// Cuban 5

IF frame_counter_hait3 = 26

	IF ambush_cuban5_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban5_hait3
			REMOVE_BLIP ambush_cuban5_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban5_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban5_dead_hait3 = 1
		ELSE
						
			IF cuban5_goto_position_hait3 = 1
			
				IF LOCATE_CHAR_ON_FOOT_2D ambush_cuban5_hait3 fight1_x_hait3 fight1_y_hait3 4.0 4.0 FALSE
					cuban5_goto_position_hait3 = 2
				ENDIF
				
			ENDIF
			
			IF cuban5_goto_position_hait3 = 2
					 			   
				ambush_cuban5_target_hait3 = haitian6_hait3

				IF NOT IS_CHAR_DEAD ambush_cuban5_target_hait3 
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban5_hait3 ambush_cuban5_target_hait3  
				ENDIF
					
				cuban5_goto_position_hait3 = 3
			   				
			ENDIF

			IF cuban5_goto_position_hait3 = 3

				IF IS_CHAR_DEAD ambush_cuban5_target_hait3
					gosub_cuban1_hait3 = ambush_cuban5_hait3 
				  	GOSUB cuban1_attack_hait3
			  	ENDIF

			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban5_hait3 
				GOSUB player_spotted_hait3
			ENDIF
					
		ENDIF
			
	ENDIF

ENDIF

// cuban 6

IF frame_counter_hait3 = 27

	IF ambush_cuban6_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban6_hait3
			REMOVE_BLIP ambush_cuban6_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban6_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban6_dead_hait3 = 1
		ELSE
					   
			IF cuban6_goto_position_hait3 = 1
			
				IF LOCATE_CHAR_ON_FOOT_2D ambush_cuban6_hait3 fight1_x_hait3 fight1_y_hait3 4.0 4.0 FALSE
					cuban6_goto_position_hait3 = 2
				ENDIF
				
			ENDIF
			
			IF cuban6_goto_position_hait3 = 2
			
				ambush_cuban6_target_hait3 = haitian5_hait3

				IF NOT IS_CHAR_DEAD ambush_cuban6_target_hait3 
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban6_hait3 ambush_cuban6_target_hait3  
				ENDIF
					
				cuban6_goto_position_hait3 = 3
			ENDIF

			IF cuban6_goto_position_hait3 = 3
			
				IF IS_CHAR_DEAD ambush_cuban6_target_hait3 
					gosub_cuban1_hait3 = ambush_cuban6_hait3 
					GOSUB cuban1_attack_hait3
			   	ENDIF

			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban6_hait3 
				GOSUB player_spotted_hait3
			ENDIF
				
		ENDIF
			
	ENDIF

ENDIF

// Cuban 7

IF frame_counter_hait3 = 28

	IF ambush_cuban7_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban7_hait3
			REMOVE_BLIP ambush_cuban7_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban7_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban7_dead_hait3 = 1
		ELSE
					   
			IF cuban7_goto_position_hait3 = 1
			
				IF LOCATE_CHAR_ON_FOOT_2D ambush_cuban7_hait3 fight1_x_hait3 fight1_y_hait3 4.0 4.0 FALSE
					cuban7_goto_position_hait3 = 2
				ENDIF
				
			ENDIF
			
			IF cuban7_goto_position_hait3 = 2
			
			  	ambush_cuban7_target_hait3 = haitian4_hait3

				IF NOT IS_CHAR_DEAD ambush_cuban7_target_hait3 
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban7_hait3 ambush_cuban7_target_hait3  
				ENDIF
					
				cuban7_goto_position_hait3 = 3
			   				
			ENDIF

			IF cuban7_goto_position_hait3 = 3
			
				IF IS_CHAR_DEAD ambush_cuban7_target_hait3 
					gosub_cuban1_hait3 = ambush_cuban7_hait3 
				  	GOSUB cuban1_attack_hait3
			   	ENDIF

			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban7_hait3 
				GOSUB player_spotted_hait3
			ENDIF
			
		ENDIF
			
	ENDIF

ENDIF

// Cuban 8

IF frame_counter_hait3 = 29

	IF ambush_cuban8_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban8_hait3
			REMOVE_BLIP ambush_cuban8_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban8_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban8_dead_hait3 = 1
		ELSE
		   			
			IF cuban8_goto_position_hait3 = 1
			
				IF LOCATE_CHAR_ON_FOOT_2D ambush_cuban8_hait3 fight1_x_hait3 fight1_y_hait3 4.0 4.0 FALSE
					cuban8_goto_position_hait3 = 2
				ENDIF
				
			ENDIF
			
			IF cuban8_goto_position_hait3 = 2
			
			  	ambush_cuban8_target_hait3 = haitian3_hait3

				IF NOT IS_CHAR_DEAD ambush_cuban8_target_hait3 
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban8_hait3 ambush_cuban8_target_hait3  
				ENDIF

				cuban8_goto_position_hait3 = 3
			ENDIF
			
			IF cuban8_goto_position_hait3 = 3
			
				IF IS_CHAR_DEAD ambush_cuban8_target_hait3 
					gosub_cuban1_hait3 = ambush_cuban8_hait3 
				 	GOSUB cuban1_attack_hait3
			  	ENDIF

			ENDIF

		   IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban8_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

// Cuban 9

IF frame_counter_hait3 = 30

	IF ambush_cuban9_dead_hait3 = 0

		IF IS_CHAR_DEAD ambush_cuban9_hait3
			REMOVE_BLIP ambush_cuban9_blip_hait3
	  		++ counter_dead_cuban
			gosub_death_check_bloke_hait3 = ambush_cuban9_hait3
			GOSUB all_guys_death_check_hait3
			ambush_cuban9_dead_hait3 = 1
		ELSE
						
			IF cuban9_goto_position_hait3 = 1
			
				IF LOCATE_CHAR_ON_FOOT_2D ambush_cuban9_hait3 fight1_x_hait3 fight1_y_hait3 4.0 4.0 FALSE
					cuban9_goto_position_hait3 = 2
				ENDIF
				
			ENDIF
			
			IF cuban9_goto_position_hait3 = 2
			
				ambush_cuban9_target_hait3 = haitian2_hait3

				IF NOT IS_CHAR_DEAD ambush_cuban9_target_hait3 
					SET_CHAR_OBJ_KILL_CHAR_ON_FOOT ambush_cuban9_hait3 ambush_cuban9_target_hait3  
				ENDIF

				cuban9_goto_position_hait3 = 3
			   				
			ENDIF

			IF cuban9_goto_position_hait3 = 3
			
				IF IS_CHAR_DEAD ambush_cuban9_target_hait3 
					gosub_cuban1_hait3 = ambush_cuban9_hait3 
				 	GOSUB cuban1_attack_hait3
				ENDIF

			ENDIF

			IF flag_player_spotted_hait3 = 0
				gosub_spotter_hait3 = ambush_cuban9_hait3 
				GOSUB player_spotted_hait3
			ENDIF

		ENDIF
			
	ENDIF

ENDIF

RETURN


// checks distance between two peds

distance_check_for_cubans_hait3:
	   
GET_CHAR_COORDINATES distance_check_targ_hait3 targ_hat_x_hait3 targ_hat_y_hait3 targ_hat_z_hait3
				
GET_DISTANCE_BETWEEN_COORDS_2D gosub_cuban1_x_hait3 gosub_cuban1_y_hait3 targ_hat_x_hait3 targ_hat_y_hait3 current_dist_hait3  
		
IF current_dist_hait3 < closest_dist_hait3
	closest_dist_hait3 = current_dist_hait3
	closest_haitian_hait3 = distance_check_targ_hait3
ENDIF   

RETURN

// Cuban attack stuff

cuban1_attack_hait3:

	closest_dist_hait3 = 50.0

	closest_haitian_hait3 = -1
	
	GET_CHAR_COORDINATES gosub_cuban1_hait3 gosub_cuban1_x_hait3 gosub_cuban1_y_hait3 gosub_cuban1_z_hait3 
			   
	IF NOT IS_CHAR_DEAD haitian1_hait3
		distance_check_targ_hait3 = haitian1_hait3
		GOSUB distance_check_for_cubans_hait3
	ENDIF

	IF NOT IS_CHAR_DEAD haitian2_hait3
		distance_check_targ_hait3 = haitian2_hait3
		GOSUB distance_check_for_cubans_hait3
	ENDIF
				
	IF NOT IS_CHAR_DEAD haitian3_hait3 	
		distance_check_targ_hait3 = haitian3_hait3
		GOSUB distance_check_for_cubans_hait3
	ENDIF

	IF NOT IS_CHAR_DEAD haitian4_hait3
		distance_check_targ_hait3 = haitian4_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD haitian5_hait3
		distance_check_targ_hait3 = haitian5_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF 
				
	IF NOT IS_CHAR_DEAD haitian6_hait3
		distance_check_targ_hait3 = haitian6_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF
									
	IF NOT IS_CHAR_DEAD haitian7_hait3
		distance_check_targ_hait3 = haitian7_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD haitian8_hait3
		distance_check_targ_hait3 = haitian8_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD haitian9_hait3
		distance_check_targ_hait3 = haitian9_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD haitian10_hait3
		distance_check_targ_hait3 = haitian10_hait3
		GOSUB distance_check_for_cubans_hait3 
	ENDIF
	
	IF NOT closest_haitian_hait3 = -1
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT gosub_cuban1_hait3 closest_haitian_hait3
	ENDIF
	
	IF gosub_cuban1_hait3 = cuban1_hait3
   		cuban1_target_hait3 = closest_haitian_hait3
   	ENDIF

	IF gosub_cuban1_hait3 = cuban2_hait3
   		cuban2_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban3_hait3
   		cuban3_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban4_hait3
   		cuban4_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban5_hait3
   		cuban5_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban6_hait3
   		cuban6_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban7_hait3
   		cuban7_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban8_hait3
   		cuban8_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban9_hait3
   		cuban9_target_hait3 = closest_haitian_hait3
   	ENDIF

   	IF gosub_cuban1_hait3 = cuban10_hait3
   		cuban10_target_hait3 = closest_haitian_hait3
   	ENDIF
    
RETURN

// checks distance between two peds

distance_check_for_haitians_hait3:
	   
GET_CHAR_COORDINATES distance_check_targ_hait3 targ_cub_x_hait3 targ_cub_y_hait3 targ_cub_z_hait3
				
GET_DISTANCE_BETWEEN_COORDS_2D gosub_haitian1_x_hait3 gosub_haitian1_y_hait3 targ_cub_x_hait3 targ_cub_y_hait3 current_dist_hait3  
		
IF current_dist_hait3 < closest_dist_hait3
	closest_dist_hait3 = current_dist_hait3
	closest_cuban_hait3 = distance_check_targ_hait3
ENDIF   

RETURN

// Haitian attack stuff

haitian1_attack_hait3:

	closest_dist_hait3 = 50.0

	closest_cuban_hait3 = -1

	GET_CHAR_COORDINATES gosub_haitian1_hait3 gosub_haitian1_x_hait3 gosub_haitian1_y_hait3 gosub_haitian1_z_hait3
			   
	IF NOT IS_CHAR_DEAD cuban1_hait3
		distance_check_targ_hait3 = cuban1_hait3
		GOSUB distance_check_for_haitians_hait3
	ENDIF

	IF NOT IS_CHAR_DEAD cuban2_hait3
		distance_check_targ_hait3 = cuban2_hait3
		GOSUB distance_check_for_haitians_hait3
	ENDIF
				
	IF NOT IS_CHAR_DEAD cuban3_hait3 	
		distance_check_targ_hait3 = cuban3_hait3
		GOSUB distance_check_for_haitians_hait3
	ENDIF

	IF NOT IS_CHAR_DEAD cuban4_hait3
		distance_check_targ_hait3 = cuban4_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD cuban5_hait3
		distance_check_targ_hait3 = cuban5_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF 
				
	IF NOT IS_CHAR_DEAD cuban6_hait3
		distance_check_targ_hait3 = cuban6_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF
									
	IF NOT IS_CHAR_DEAD cuban7_hait3
		distance_check_targ_hait3 = cuban7_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD cuban8_hait3
		distance_check_targ_hait3 = cuban8_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD cuban9_hait3
		distance_check_targ_hait3 = cuban9_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF

	IF NOT IS_CHAR_DEAD cuban10_hait3
		distance_check_targ_hait3 = cuban10_hait3
		GOSUB distance_check_for_haitians_hait3 
	ENDIF

	IF flag_ambush1_created_hait3 = 1

		IF NOT IS_CHAR_DEAD ambush_driver1_hait3
			distance_check_targ_hait3 = ambush_driver1_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF
													
		IF NOT IS_CHAR_DEAD ambush_cuban1_hait3
			distance_check_targ_hait3 = ambush_cuban1_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban2_hait3
			distance_check_targ_hait3 = ambush_cuban2_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban3_hait3
			distance_check_targ_hait3 = ambush_cuban3_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

	ENDIF

	IF flag_ambush2_created_hait3 = 1 

		IF NOT IS_CHAR_DEAD ambush_cuban4_hait3
			distance_check_targ_hait3 = ambush_cuban4_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban5_hait3
			distance_check_targ_hait3 = ambush_cuban5_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban6_hait3
			distance_check_targ_hait3 = ambush_cuban6_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban7_hait3
			distance_check_targ_hait3 = ambush_cuban7_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban8_hait3
			distance_check_targ_hait3 = ambush_cuban8_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF

		IF NOT IS_CHAR_DEAD ambush_cuban9_hait3
			distance_check_targ_hait3 = ambush_cuban9_hait3
			GOSUB distance_check_for_haitians_hait3 
		ENDIF
								  
	ENDIF

	IF NOT closest_cuban_hait3 = -1
		SET_CHAR_OBJ_KILL_CHAR_ON_FOOT gosub_haitian1_hait3 closest_cuban_hait3
	ENDIF
	
   	IF gosub_haitian1_hait3 = haitian1_hait3
   		haitian1_target_hait3 = closest_cuban_hait3
   	ENDIF

	IF gosub_haitian1_hait3 = haitian2_hait3
   		haitian2_target_hait3 = closest_cuban_hait3
   	ENDIF
   
   	IF gosub_haitian1_hait3 = haitian3_hait3
   		haitian3_target_hait3 = closest_cuban_hait3
   	ENDIF

	IF gosub_haitian1_hait3 = haitian4_hait3
   		haitian4_target_hait3 = closest_cuban_hait3
   	ENDIF
		
   	IF gosub_haitian1_hait3 = haitian5_hait3
   		haitian5_target_hait3 = closest_cuban_hait3
   	ENDIF

	IF gosub_haitian1_hait3 = haitian6_hait3
   		haitian6_target_hait3 = closest_cuban_hait3
   	ENDIF
		
   	IF gosub_haitian1_hait3 = haitian7_hait3
   		haitian7_target_hait3 = closest_cuban_hait3
   	ENDIF

	IF gosub_haitian1_hait3 = haitian8_hait3
   		haitian8_target_hait3 = closest_cuban_hait3
   	ENDIF
	   
   	IF gosub_haitian1_hait3 = haitian9_hait3
   		haitian9_target_hait3 = closest_cuban_hait3
   	ENDIF

	IF gosub_haitian1_hait3 = haitian10_hait3
   		haitian10_target_hait3 = closest_cuban_hait3
   	ENDIF

	// ambush 1 guys created

	IF flag_ambush1_created_hait3 = 1 

		IF gosub_haitian1_hait3 = ambush_driver1_hait3
   			ambush_driver1_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban1_hait3
   			ambush_cuban1_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban2_hait3
   			ambush_cuban2_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban3_hait3
   			ambush_cuban3_target_hait3 = closest_cuban_hait3
   		ENDIF

	ENDIF

// ambush 2 guys created 

	IF flag_ambush2_created_hait3 = 1
		
		IF gosub_haitian1_hait3 = ambush_cuban4_hait3
   			ambush_cuban4_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban5_hait3
   			ambush_cuban5_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban6_hait3
   			ambush_cuban6_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban7_hait3
   			ambush_cuban7_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban8_hait3
   			ambush_cuban8_target_hait3 = closest_cuban_hait3
   		ENDIF

		IF gosub_haitian1_hait3 = ambush_cuban9_hait3
   			ambush_cuban9_target_hait3 = closest_cuban_hait3
   		ENDIF
		
	ENDIF

RETURN

all_guys_death_check_hait3: // Used to check to see if a ped has died and the player has killed them while not on the roof

IF IS_PLAYER_IN_ANGLED_AREA_3D player1 -936.42 109.11 13.0 -873.118 45.222 18.0 30.0 FALSE
	player_spotted_melee_hait3 = 0
ELSE

	IF player_spotted_melee_hait3 = 0 

		IF IS_CHAR_DEAD gosub_death_check_bloke_hait3 

			IF HAS_CHAR_BEEN_DAMAGED_BY_CHAR gosub_death_check_bloke_hait3 scplayer

				CLEAR_CHAR_LAST_DAMAGE_ENTITY gosub_death_check_bloke_hait3

				IF HAS_CHAR_BEEN_DAMAGED_BY_WEAPON gosub_death_check_bloke_hait3 WEAPONTYPE_ANYMELEE
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON gosub_death_check_bloke_hait3 WEAPONTYPE_RAMMEDBYCAR
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON gosub_death_check_bloke_hait3 WEAPONTYPE_RUNOVERBYCAR
				OR HAS_CHAR_BEEN_DAMAGED_BY_WEAPON gosub_death_check_bloke_hait3 WEAPONTYPE_ANYWEAPON
					CLEAR_CHAR_LAST_WEAPON_DAMAGE gosub_death_check_bloke_hait3
					player_spotted_melee_hait3 = 1
				ENDIF

			ENDIF

		ENDIF

	ENDIF

ENDIF
	   	
RETURN

// Sets all the guys unkillable

both_sides_cant_die_hait3:

IF NOT IS_CHAR_DEAD cuban1_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban1_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban2_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban2_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban3_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban3_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban4_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban4_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban5_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban5_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban6_hait3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban6_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban7_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban7_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban8_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban8_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban9_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban9_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD cuban10_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban10_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian1_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian1_hait3 TRUE
ENDIF
	 
IF NOT IS_CHAR_DEAD haitian2_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian2_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian3_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian3_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian4_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian4_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian5_hait3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian5_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian6_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian6_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian7_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian7_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian8_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian8_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian9_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian9_hait3 TRUE
ENDIF

IF NOT IS_CHAR_DEAD haitian10_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian10_hait3 TRUE
ENDIF

IF flag_ambush1_created_hait3 = 1

	IF NOT IS_CHAR_DEAD ambush_driver1_hait3
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_driver1_hait3 TRUE
	ENDIF 

	IF NOT IS_CHAR_DEAD ambush_cuban1_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban1_hait3 TRUE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban2_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban2_hait3 TRUE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban3_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban3_hait3 TRUE
	ENDIF

ENDIF

IF flag_ambush2_created_hait3 = 1

	IF NOT IS_CHAR_DEAD ambush_cuban4_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban4_hait3 TRUE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban5_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban5_hait3 TRUE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban6_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban6_hait3 TRUE
	ENDIF
		
	IF NOT IS_CHAR_DEAD ambush_cuban7_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban7_hait3 TRUE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban8_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban8_hait3 TRUE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban9_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban9_hait3 TRUE
	ENDIF 

ENDIF

RETURN

// All guys can die

both_sides_can_die_hait3:

IF NOT IS_CHAR_DEAD cuban1_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban1_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban2_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban2_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban3_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban3_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban4_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban4_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban5_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban5_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban6_hait3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban6_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban7_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban7_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban8_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban8_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban9_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban9_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD cuban10_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER cuban10_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian1_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian1_hait3 FALSE
ENDIF
	 
IF NOT IS_CHAR_DEAD haitian2_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian2_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian3_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian3_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian4_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian4_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian5_hait3
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian5_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian6_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian6_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian7_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian7_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian8_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian8_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian9_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian9_hait3 FALSE
ENDIF

IF NOT IS_CHAR_DEAD haitian10_hait3 
	SET_CHAR_ONLY_DAMAGED_BY_PLAYER haitian10_hait3 FALSE
ENDIF

IF flag_ambush1_created_hait3 = 1

	IF NOT IS_CHAR_DEAD ambush_driver1_hait3
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_driver1_hait3 FALSE
	ENDIF 

	//IF NOT IS_CHAR_DEAD ambush_cuban1_hait3 
	//	SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban1_hait3 FALSE
   //	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban2_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban2_hait3 FALSE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban3_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban3_hait3 FALSE
	ENDIF

ENDIF

IF flag_ambush2_created_hait3 = 1

	IF NOT IS_CHAR_DEAD ambush_cuban4_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban4_hait3 FALSE
	ENDIF

	//IF NOT IS_CHAR_DEAD ambush_cuban5_hait3 
	//	SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban5_hait3 FALSE
	//ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban6_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban6_hait3 FALSE
	ENDIF
		
   	IF NOT IS_CHAR_DEAD ambush_cuban7_hait3 
   		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban7_hait3 FALSE
   	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban8_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban8_hait3 FALSE
	ENDIF

	IF NOT IS_CHAR_DEAD ambush_cuban9_hait3 
		SET_CHAR_ONLY_DAMAGED_BY_PLAYER ambush_cuban9_hait3 FALSE
	ENDIF 

ENDIF

RETURN


}