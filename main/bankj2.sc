MISSION_START
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************
// ************************************ Bankjob Mission Two ********************************
// ********************************** The Shooting Competition *****************************
// *****************************************************************************************
// *****************************************************************************************
// *****************************************************************************************

SCRIPT_NAME bankjo2

// Mission start stuff

GOSUB mission_start_bankjob2

IF HAS_DEATHARREST_BEEN_EXECUTED
	GOSUB mission_bankjob2_failed
ENDIF

GOSUB mission_cleanup_bankjob2

MISSION_END


// Variables for mission

// Round 1

// General stuff

VAR_INT counter_hits_scored_round1_bankjob2

VAR_INT radar_blip_coord2_bankjob2

VAR_INT flag_round1_finished_bankjob2 // Tells me when round 1 is over

VAR_INT timer_round1_bankjob2

VAR_INT radar_blip_coord3_bankjob2

VAR_INT radar_blip_coord4_bankjob2

VAR_INT ammo_round1_bankjob // Tells me when the player1 has used all his ammo for the M16 and end the round

VAR_INT bits_hit_bank2 // used for the % stuff for how many targets has been hit

VAR_INT score_round2_bankjob2

VAR_INT score_round3_bankjob2

VAR_INT total_hits_bankjob2

VAR_INT final_hits_bankjob2 

// Slot1

VAR_INT slot1_filled_round1_bankjob2

VAR_INT target_1_bankjob2_dead

VAR_INT target1_part1_dead_bankjob2															 

VAR_INT target1_part2_dead_bankjob2

VAR_INT target1_part3_dead_bankjob2

VAR_INT target1_part4_dead_bankjob2

VAR_INT target1_part5_dead_bankjob2

VAR_INT target1_frame_bankjob2

VAR_INT target1_part1_bankjob2

VAR_INT target1_part2_bankjob2

VAR_INT target1_part3_bankjob2

VAR_INT target1_part4_bankjob2

VAR_INT target1_part5_bankjob2

VAR_FLOAT slot1_x_bankjob2
 
VAR_FLOAT slot1_y_bankjob2

VAR_FLOAT slot1_z_bankjob2

VAR_FLOAT targ1_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ1_y_bankjob2

VAR_FLOAT targ1_z_bankjob2

VAR_INT target1_travel_bank2

// Slot2

VAR_INT slot2_filled_round1_bankjob2

VAR_INT target_2_bankjob2_dead

VAR_INT target2_part1_dead_bankjob2

VAR_INT target2_part2_dead_bankjob2

VAR_INT target2_part3_dead_bankjob2

VAR_INT target2_part4_dead_bankjob2

VAR_INT target2_part5_dead_bankjob2

VAR_INT target2_frame_bankjob2

VAR_INT target2_part1_bankjob2

VAR_INT target2_part2_bankjob2

VAR_INT target2_part3_bankjob2

VAR_INT target2_part4_bankjob2

VAR_INT target2_part5_bankjob2

VAR_FLOAT slot2_x_bankjob2
 
VAR_FLOAT slot2_y_bankjob2

VAR_FLOAT slot2_z_bankjob2

VAR_FLOAT targ2_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ2_y_bankjob2

VAR_FLOAT targ2_z_bankjob2

VAR_INT target2_travel_bank2

// Slot3

VAR_INT slot3_filled_round1_bankjob2

VAR_INT target_3_bankjob2_dead

VAR_INT target3_part1_dead_bankjob2

VAR_INT target3_part2_dead_bankjob2

VAR_INT target3_part3_dead_bankjob2

VAR_INT target3_part4_dead_bankjob2

VAR_INT target3_part5_dead_bankjob2

VAR_INT target3_frame_bankjob2

VAR_INT target3_part1_bankjob2

VAR_INT target3_part2_bankjob2

VAR_INT target3_part3_bankjob2

VAR_INT target3_part4_bankjob2

VAR_INT target3_part5_bankjob2

VAR_FLOAT slot3_x_bankjob2
 
VAR_FLOAT slot3_y_bankjob2

VAR_FLOAT slot3_z_bankjob2

VAR_FLOAT targ3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ3_y_bankjob2

VAR_FLOAT targ3_z_bankjob2

VAR_INT target3_travel_bank2

// *************************************** ROUND TWO ***************************************

// General Stuff

VAR_INT counter_hits_scored_round2_bankjob2

VAR_INT round2_finished_bankjob2 // Tells me when round 2 is over

VAR_INT ammo_round2_bankjob2  // Checks to see how many shots the player1 has fired

VAR_INT game_time_round2_bankjob2


// Slot1 Round2

VAR_FLOAT slot1_x_round2_bankjob2
 
VAR_FLOAT slot1_y_round2_bankjob2

VAR_FLOAT slot1_z_round2_bankjob2

VAR_FLOAT slot1_heading_round2_bankjob2

VAR_INT target1_round2_bankjob2

VAR_INT flag_target1_dead_round2_bankjob2

VAR_INT target1_round2_removed_bankjob2  // If player has not shot target its moved to the side then deleted

VAR_FLOAT targ1_round2_x_bankjob2

VAR_FLOAT targ1_round2_y_bankjob2

VAR_FLOAT targ1_round2_z_bankjob2 

VAR_INT timer_start_targ1_round2_bankjob2

VAR_INT flag_slot1_round2_filled_bankjob2

VAR_INT delete_targ1_round2_time_bankjob2

VAR_INT time_targ1_round2_in_posit_bankjob2

// Slot2 Round2

VAR_FLOAT slot2_x_round2_bankjob2
 
VAR_FLOAT slot2_y_round2_bankjob2

VAR_FLOAT slot2_z_round2_bankjob2

VAR_FLOAT slot2_heading_round2_bankjob2

VAR_INT target2_round2_bankjob2

VAR_INT flag_target2_dead_round2_bankjob2

VAR_INT target2_round2_removed_bankjob2  // If player has not shot target its moved to the side then deleted

VAR_FLOAT targ2_round2_x_bankjob2

VAR_FLOAT targ2_round2_y_bankjob2

VAR_FLOAT targ2_round2_z_bankjob2 

VAR_INT timer_start_targ2_round2_bankjob2

VAR_INT flag_slot2_round2_filled_bankjob2

VAR_INT delete_targ2_round2_time_bankjob2

VAR_INT time_targ2_round2_in_posit_bankjob2

// Slot 3 Round2

VAR_FLOAT slot3_x_round2_bankjob2
 
VAR_FLOAT slot3_y_round2_bankjob2

VAR_FLOAT slot3_z_round2_bankjob2

VAR_FLOAT slot3_heading_round2_bankjob2

VAR_INT target3_round2_bankjob2

VAR_INT flag_target3_dead_round2_bankjob2

VAR_INT target3_round2_removed_bankjob2  // If player has not shot target its moved to the side then deleted

VAR_FLOAT targ3_round2_x_bankjob2

VAR_FLOAT targ3_round2_y_bankjob2

VAR_FLOAT targ3_round2_z_bankjob2 

VAR_INT timer_start_targ3_round2_bankjob2

VAR_INT flag_slot3_round2_filled_bankjob2

VAR_INT delete_targ3_round2_time_bankjob2

VAR_INT time_targ3_round2_in_posit_bankjob2

// Slot4 Round2

VAR_FLOAT slot4_x_round2_bankjob2
 
VAR_FLOAT slot4_y_round2_bankjob2

VAR_FLOAT slot4_z_round2_bankjob2

VAR_FLOAT slot4_heading_round2_bankjob2

VAR_INT target4_round2_bankjob2

VAR_INT flag_target4_dead_round2_bankjob2

VAR_INT target4_round2_removed_bankjob2  // If player has not shot target its moved to the side then deleted

VAR_FLOAT targ4_round2_x_bankjob2

VAR_FLOAT targ4_round2_y_bankjob2

VAR_FLOAT targ4_round2_z_bankjob2 

VAR_INT timer_start_targ4_round2_bankjob2

VAR_INT flag_slot4_round2_filled_bankjob2

VAR_INT delete_targ4_round2_time_bankjob2

VAR_INT time_targ4_round2_in_posit_bankjob2

// Slot5 Round2

VAR_FLOAT slot5_x_round2_bankjob2
 
VAR_FLOAT slot5_y_round2_bankjob2

VAR_FLOAT slot5_z_round2_bankjob2

VAR_FLOAT slot5_heading_round2_bankjob2

VAR_INT target5_round2_bankjob2

VAR_INT flag_target5_dead_round2_bankjob2

VAR_INT target5_round2_removed_bankjob2  // If player has not shot target its moved to the side then deleted

VAR_FLOAT targ5_round2_x_bankjob2

VAR_FLOAT targ5_round2_y_bankjob2

VAR_FLOAT targ5_round2_z_bankjob2 

VAR_INT timer_start_targ5_round2_bankjob2

VAR_INT flag_slot5_round2_filled_bankjob2

VAR_INT delete_targ5_round2_time_bankjob2

VAR_INT time_targ5_round2_in_posit_bankjob2

// Slot6 Round2

VAR_FLOAT slot6_x_round2_bankjob2
 
VAR_FLOAT slot6_y_round2_bankjob2

VAR_FLOAT slot6_z_round2_bankjob2

VAR_FLOAT slot6_heading_round2_bankjob2

VAR_INT target6_round2_bankjob2

VAR_INT flag_target6_dead_round2_bankjob2

VAR_INT target6_round2_removed_bankjob2  // If player has not shot target its moved to the side then deleted

VAR_FLOAT targ6_round2_x_bankjob2

VAR_FLOAT targ6_round2_y_bankjob2

VAR_FLOAT targ6_round2_z_bankjob2 

VAR_INT timer_start_targ6_round2_bankjob2

VAR_INT flag_slot6_round2_filled_bankjob2

VAR_INT delete_targ6_round2_time_bankjob2

VAR_INT time_targ6_round2_in_posit_bankjob2

// *************************************** ROUND 3 *****************************************

// General stuff

VAR_INT counter_hits_scored_round3_bankjob2

VAR_INT round3_finished_bankjob2 // Tells me when round 2 is over

VAR_INT ammo_round3_bankjob2  // Checks to see how many shots the player1 has fired

// SLOT 7 ROUND2

VAR_INT target7_round3_bankjob2

VAR_INT slot7_filled_round3_bankjob2

VAR_INT target7_round3_dead_bankjob2

VAR_FLOAT targ7_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ7_round3_y_bankjob2

VAR_FLOAT targ7_round3_z_bankjob2

VAR_INT target7_round3_travel_bank2

VAR_FLOAT slot7_round3_x_bankjob2  

VAR_FLOAT slot7_round3_y_bankjob2

VAR_FLOAT slot7_round3_z_bankjob2

// SLOT8 ROUND2

VAR_INT target8_round3_bankjob2

VAR_INT slot8_filled_round3_bankjob2

VAR_INT target8_round3_dead_bankjob2

VAR_FLOAT targ8_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ8_round3_y_bankjob2

VAR_FLOAT targ8_round3_z_bankjob2

VAR_INT target8_round3_travel_bank2

VAR_FLOAT slot8_round3_x_bankjob2  

VAR_FLOAT slot8_round3_y_bankjob2

VAR_FLOAT slot8_round3_z_bankjob2

// Slot9 ROUND2

VAR_INT target9_round3_bankjob2

VAR_INT slot9_filled_round3_bankjob2

VAR_INT target9_round3_dead_bankjob2

VAR_FLOAT targ9_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ9_round3_y_bankjob2

VAR_FLOAT targ9_round3_z_bankjob2

VAR_INT target9_round3_travel_bank2

VAR_FLOAT slot9_round3_x_bankjob2  

VAR_FLOAT slot9_round3_y_bankjob2

VAR_FLOAT slot9_round3_z_bankjob2

// SLOT 10 ROUND2

VAR_INT target10_round3_bankjob2

VAR_INT slot10_filled_round3_bankjob2

VAR_INT target10_round3_dead_bankjob2

VAR_FLOAT targ10_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ10_round3_y_bankjob2

VAR_FLOAT targ10_round3_z_bankjob2

VAR_INT target10_round3_travel_bank2

VAR_FLOAT slot10_round3_x_bankjob2  

VAR_FLOAT slot10_round3_y_bankjob2

VAR_FLOAT slot10_round3_z_bankjob2

// SLOT11 ROUND2
	
VAR_INT target11_round3_bankjob2

VAR_INT slot11_filled_round3_bankjob2

VAR_INT target11_round3_dead_bankjob2

VAR_FLOAT targ11_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ11_round3_y_bankjob2

VAR_FLOAT targ11_round3_z_bankjob2

VAR_INT target11_round3_travel_bank2

VAR_FLOAT slot11_round3_x_bankjob2  

VAR_FLOAT slot11_round3_y_bankjob2

VAR_FLOAT slot11_round3_z_bankjob2

// SLOT12 ROUND2

VAR_INT target12_round3_bankjob2

VAR_INT slot12_filled_round3_bankjob2

VAR_INT target12_round3_dead_bankjob2

VAR_FLOAT targ12_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ12_round3_y_bankjob2

VAR_FLOAT targ12_round3_z_bankjob2

VAR_INT target12_round3_travel_bank2

VAR_FLOAT slot12_round3_x_bankjob2  

VAR_FLOAT slot12_round3_y_bankjob2

VAR_FLOAT slot12_round3_z_bankjob2

// SLOT13 ROUND2

VAR_INT target13_round3_bankjob2

VAR_INT slot13_filled_round3_bankjob2

VAR_INT target13_round3_dead_bankjob2

VAR_FLOAT targ13_round3_x_bankjob2 // uesd for target target position for moving 

VAR_FLOAT targ13_round3_y_bankjob2

VAR_FLOAT targ13_round3_z_bankjob2

VAR_INT target13_round3_travel_bank2

VAR_FLOAT slot13_round3_x_bankjob2  

VAR_FLOAT slot13_round3_y_bankjob2

VAR_FLOAT slot13_round3_z_bankjob2

// ROUND2 PART2

VAR_INT radar_blip_area3_bankjob2

// Shooting competition stuff

VAR_INT phil_bankjob2

VAR_INT gunner1_bankjob2

// Percentage stuff

VAR_INT percentage_hits_bankjob2 

VAR_INT ammo_given_round1_bankjob2

VAR_INT ammo_used_round1_bankjob2

VAR_INT ammo_given_round2_bankjob2

VAR_INT ammo_used_round2_bankjob2

VAR_INT ammo_given_round3_bankjob2

VAR_INT ammo_used_round3_bankjob2

VAR_INT total_ammo_used_bankjob2

// timer for round 2 part1

VAR_INT timer_round2_bankjob2

VAR_INT timer_round3_bankjob2

// Target creation stuff

VAR_INT create_timer_targ1_round2_bankjob2 // Used to tell me to grab time so can start check
			
VAR_INT timer_create_targ1_round2_bankjob2 // When teh target was created

VAR_INT targ1_round2_movetime_bankjob2 // Tells target to move now

VAR_INT create_timer_targ2_round2_bankjob2 // Used to tell me to grab time so can start check
			
VAR_INT timer_create_targ2_round2_bankjob2 // When teh target was created

VAR_INT targ2_round2_movetime_bankjob2 // Tells target to move now

VAR_INT create_timer_targ3_round2_bankjob2 // Used to tell me to grab time so can start check
			
VAR_INT timer_create_targ3_round2_bankjob2 // When teh target was created

VAR_INT targ3_round2_movetime_bankjob2 // Tells target to move now

VAR_INT create_timer_targ4_round2_bankjob2 // Used to tell me to grab time so can start check
			
VAR_INT timer_create_targ4_round2_bankjob2 // When teh target was created

VAR_INT targ4_round2_movetime_bankjob2 // Tells target to move now

VAR_INT create_timer_targ5_round2_bankjob2 // Used to tell me to grab time so can start check
			
VAR_INT timer_create_targ5_round2_bankjob2 // When teh target was created

VAR_INT targ5_round2_movetime_bankjob2 // Tells target to move now

VAR_INT create_timer_targ6_round2_bankjob2 // Used to tell me to grab time so can start check
			
VAR_INT timer_create_targ6_round2_bankjob2 // When teh target was created

VAR_INT targ6_round2_movetime_bankjob2 // Tells target to move now

// Removes and stores player pistols

VAR_INT slot4_weapon_type_bank2 slot4_ammo_bank2 slot4_model_bank2

// Audio stuff

VAR_INT doing_well_audio_loaded_bankjob2

VAR_INT doing_bad_audio_loaded_bankjob2

VAR_INT round_clear_audio_loaded_bankjob2

//VAR_INT flag_player_had_exit_message_bankjob2 // Used for player to skip round 

// Objects to attach player to

VAR_INT object1_bankjob2

VAR_INT object2_bankjob2

VAR_INT object3_bankjob2

// Round done correctly flags

VAR_INT flag_round1_done_right_bankjob2

VAR_INT flag_round2_done_right_bankjob2

VAR_INT flag_round3_done_right_bankjob2

// Round 3 random target picking stuff

VAR_INT target1_to_move_this_time_bankjob2

VAR_INT target2_to_move_this_time_bankjob2

VAR_INT target3_to_move_this_time_bankjob2
		
VAR_INT targ_to_move1_bankjob2

VAR_INT targ_to_move2_bankjob2

VAR_INT targ_to_move3_bankjob2 

VAR_INT target_number_bankjob2

VAR_INT flag_choose_slots_bankjob2 // Says wheater to get slots or not

VAR_INT counter_slot_free_bankjob2 // Tells me the slots are free to create stuff in again

VAR_INT target7_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT target8_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT target9_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT target10_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT target11_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT target12_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT target13_round3_delete_bankjob2 // deletes the target if its not dead

VAR_INT sphere_bankjob2

// Sound stuff

VAR_INT target_moving_sound_bank2

// New player score stuff

VAR_INT player_score_bankjob2

VAR_INT final_ammo_used_bankjob2

// New round time out stuff to give the bullets time to hit the target

VAR_INT flag_time_out_round1_bank2

VAR_INT flag_time_out_round2_bank2

VAR_INT flag_time_out_round3_bank2

flag_time_out_round1_bank2 = 0

flag_time_out_round2_bank2 = 0

flag_time_out_round3_bank2 = 0
											 
// ****************************************Mission Start************************************

{

mission_start_bankjob2:

REGISTER_MISSION_GIVEN

flag_player_on_mission = 1

flag_player_in_malibu = 0

// Round1

timer_round1_bankjob2 = 121000 // 2 mins

counter_hits_scored_round1_bankjob2 = 0

flag_round1_finished_bankjob2 = 0

ammo_round1_bankjob = 0

bits_hit_bank2 = 0

score_round2_bankjob2 = 0

score_round3_bankjob2 = 0

total_hits_bankjob2 = 0

final_hits_bankjob2 = 0

// Slot1

target_1_bankjob2_dead = 0

target1_part1_dead_bankjob2 = 0

target1_part2_dead_bankjob2 = 0

target1_part3_dead_bankjob2 = 0

target1_part4_dead_bankjob2 = 0

target1_part5_dead_bankjob2 = 0

slot1_x_bankjob2 = 0.0
 
slot1_y_bankjob2 = 0.0

slot1_z_bankjob2 = 0.0

slot1_filled_round1_bankjob2 = 0

delete_targ1_round2_time_bankjob2 = 0

time_targ1_round2_in_posit_bankjob2 = 0

// Location One Round one 

slot1_x_bankjob2 = -673.29 
slot1_y_bankjob2 = 1238.52 
slot1_z_bankjob2 = 11.50

// Slot2

target_2_bankjob2_dead = 0

target2_part1_dead_bankjob2 = 0

target2_part2_dead_bankjob2 = 0

target2_part3_dead_bankjob2 = 0

target2_part4_dead_bankjob2 = 0

target2_part5_dead_bankjob2 = 0

slot2_x_bankjob2 = 0.0
 
slot2_y_bankjob2 = 0.0

slot2_z_bankjob2 = 0.0

slot2_filled_round1_bankjob2 = 0

targ2_x_bankjob2 = 0.0 

targ2_y_bankjob2 = 0.0

targ2_z_bankjob2 = 0.0

target2_travel_bank2 = 0

// Location Two Round one

slot2_x_bankjob2 = -676.11  
slot2_y_bankjob2 = 1227.00 // 1238.52  
slot2_z_bankjob2 = 11.50

// Slot3

target_3_bankjob2_dead = 0

target3_part1_dead_bankjob2 = 0

target3_part2_dead_bankjob2 = 0

target3_part3_dead_bankjob2 = 0

target3_part4_dead_bankjob2 = 0

target3_part5_dead_bankjob2 = 0

slot3_x_bankjob2 = 0.0
 
slot3_y_bankjob2 = 0.0

slot3_z_bankjob2 = 0.0

slot3_filled_round1_bankjob2 = 0

targ3_x_bankjob2 = 0.0 

targ3_y_bankjob2 = 0.0

targ3_z_bankjob2 = 0.0

target3_travel_bank2 = 0

// Location Three Round one

slot3_x_bankjob2 = -679.04 
slot3_y_bankjob2 = 1238.52
slot3_z_bankjob2 = 11.50

// ************************************* Round2 ********************************************

// General

counter_hits_scored_round2_bankjob2 = 0

round2_finished_bankjob2 = 0

round3_finished_bankjob2 = 0

game_time_round2_bankjob2 = 0

// Slot1

slot1_x_round2_bankjob2 = 0.0
 
slot1_y_round2_bankjob2 = 0.0

slot1_z_round2_bankjob2 = 0.0

slot1_heading_round2_bankjob2 = 0.0

flag_target1_dead_round2_bankjob2 = 0

target1_round2_removed_bankjob2 = 0 // tells me if the target has been removed

targ1_round2_x_bankjob2 = 0.0

targ1_round2_y_bankjob2 = 0.0

targ1_round2_z_bankjob2 = 0.0 

timer_start_targ1_round2_bankjob2 = 0

flag_slot1_round2_filled_bankjob2 = 0

// Slot2

slot2_x_round2_bankjob2 = 0.0
 
slot2_y_round2_bankjob2 = 0.0

slot2_z_round2_bankjob2 = 0.0

slot2_heading_round2_bankjob2 = 0.0

flag_target2_dead_round2_bankjob2 = 0

target2_round2_removed_bankjob2 = 0 // tells me if the target has been removed

targ2_round2_x_bankjob2 = 0.0

targ2_round2_y_bankjob2 = 0.0

targ2_round2_z_bankjob2 = 0.0 

timer_start_targ2_round2_bankjob2 = 0

flag_slot2_round2_filled_bankjob2 = 0

// Slot3

slot3_x_round2_bankjob2 = 0.0
 
slot3_y_round2_bankjob2 = 0.0

slot3_z_round2_bankjob2 = 0.0

slot3_heading_round2_bankjob2 = 0.0

flag_target3_dead_round2_bankjob2 = 0

target3_round2_removed_bankjob2 = 0 // tells me if the target has been removed

targ3_round2_x_bankjob2 = 0.0

targ3_round2_y_bankjob2 = 0.0

targ3_round2_z_bankjob2 = 0.0 

timer_start_targ3_round2_bankjob2 = 0

flag_slot3_round2_filled_bankjob2 = 0

// Slot4 Round2

slot4_x_round2_bankjob2 = 0.0
 
slot4_y_round2_bankjob2 = 0.0

slot4_z_round2_bankjob2 = 0.0

slot4_heading_round2_bankjob2 = 0.0

flag_target4_dead_round2_bankjob2 = 0

target4_round2_removed_bankjob2 = 0 // tells me if the target has been removed

targ4_round2_x_bankjob2 = 0.0

targ4_round2_y_bankjob2 = 0.0

targ4_round2_z_bankjob2 = 0.0 

timer_start_targ4_round2_bankjob2 = 0

flag_slot4_round2_filled_bankjob2 = 0

// Slot 5 Round2

slot5_x_round2_bankjob2 = 0.0
 
slot5_y_round2_bankjob2 = 0.0

slot5_z_round2_bankjob2 = 0.0

slot5_heading_round2_bankjob2 = 0.0

flag_target5_dead_round2_bankjob2 = 0

target5_round2_removed_bankjob2 = 0 // tells me if the target has been removed

targ5_round2_x_bankjob2 = 0.0

targ5_round2_y_bankjob2 = 0.0

targ5_round2_z_bankjob2 = 0.0 

timer_start_targ5_round2_bankjob2 = 0

flag_slot5_round2_filled_bankjob2 = 0

// Slot6 Round2

slot6_x_round2_bankjob2 = 0.0
 
slot6_y_round2_bankjob2 = 0.0

slot6_z_round2_bankjob2 = 0.0

slot6_heading_round2_bankjob2 = 0.0

flag_target6_dead_round2_bankjob2 = 0

target6_round2_removed_bankjob2 = 0 // tells me if the target has been removed

targ6_round2_x_bankjob2 = 0.0

targ6_round2_y_bankjob2 = 0.0

targ6_round2_z_bankjob2 = 0.0 

timer_start_targ6_round2_bankjob2 = 0

flag_slot6_round2_filled_bankjob2 = 0

// ****************************************** ROUND 3 **************************************

// General stuff

counter_hits_scored_round3_bankjob2 = 0

// Slot7 Round2

slot7_filled_round3_bankjob2 = 0

target7_round3_dead_bankjob2 = 0

slot7_round3_x_bankjob2 = -674.16  

slot7_round3_y_bankjob2	= 1288.23

slot7_round3_z_bankjob2	= 9.81

targ7_round3_x_bankjob2	= 0.0

targ7_round3_y_bankjob2	= 0.0

targ7_round3_z_bankjob2	= 0.0

target7_round3_travel_bank2 = 0

// Slot8 Round2

slot8_filled_round3_bankjob2 = 0

target8_round3_dead_bankjob2 = 0

slot8_round3_x_bankjob2 = -673.46   

slot8_round3_y_bankjob2	= 1279.29 

slot8_round3_z_bankjob2	= 9.81

targ8_round3_x_bankjob2	= 0.0

targ8_round3_y_bankjob2	= 0.0

targ8_round3_z_bankjob2	= 0.0

target8_round3_travel_bank2 = 0

// SLOT9 ROUND2

slot9_filled_round3_bankjob2 = 0

target9_round3_dead_bankjob2 = 0

slot9_round3_x_bankjob2 = -683.23   

slot9_round3_y_bankjob2	= 1281.50 

slot9_round3_z_bankjob2	= 9.81

targ9_round3_x_bankjob2	= 0.0

targ9_round3_y_bankjob2	= 0.0

targ9_round3_z_bankjob2	= 0.0

target9_round3_travel_bank2 = 0

// SLOT 10 ROUND2

slot10_filled_round3_bankjob2 = 0

target10_round3_dead_bankjob2 = 0

slot10_round3_x_bankjob2 = -683.73   

slot10_round3_y_bankjob2 = 1289.19 

slot10_round3_z_bankjob2 = 9.81

targ10_round3_x_bankjob2 = 0.0

targ10_round3_y_bankjob2 = 0.0

targ10_round3_z_bankjob2 = 0.0

target10_round3_travel_bank2 = 0

// SLOT 11 ROUND2 tower

slot11_filled_round3_bankjob2 = 0

target11_round3_dead_bankjob2 = 0

slot11_round3_x_bankjob2 = -678.21     

slot11_round3_y_bankjob2 = 1293.04  

slot11_round3_z_bankjob2 = 8.0 

targ11_round3_x_bankjob2 = 0.0

targ11_round3_y_bankjob2 = 0.0

targ11_round3_z_bankjob2 = 0.0

target11_round3_travel_bank2 = 0

// SLOT 12 ROUND2

slot12_filled_round3_bankjob2 = 0

target12_round3_dead_bankjob2 = 0

slot12_round3_x_bankjob2 = -682.67    

slot12_round3_y_bankjob2 = 1279.42  

slot12_round3_z_bankjob2 = 13.0

targ12_round3_x_bankjob2 = 0.0

targ12_round3_y_bankjob2 = 0.0

targ12_round3_z_bankjob2 = 0.0

target12_round3_travel_bank2 = 0

// SLOT 13 ROUND2

slot13_filled_round3_bankjob2 = 0

target13_round3_dead_bankjob2 = 0

slot13_round3_x_bankjob2 = -673.10    

slot13_round3_y_bankjob2 = 1277.80  

slot13_round3_z_bankjob2 = 13.0 

targ13_round3_x_bankjob2 = 0.0

targ13_round3_y_bankjob2 = 0.0

targ13_round3_z_bankjob2 = 0.0

target13_round3_travel_bank2 = 0

// General Stuff For Whole Competition

target1_travel_bank2 = 0 // say to go left or right

slot1_x_round2_bankjob2 = -683.07  
slot1_y_round2_bankjob2 = 1269.74
slot1_z_round2_bankjob2 = 9.81
slot1_heading_round2_bankjob2 = 90.0

slot2_x_round2_bankjob2 = -683.11  
slot2_y_round2_bankjob2 = 1272.55
slot2_z_round2_bankjob2 = 9.81
slot2_heading_round2_bankjob2 = 90.0

slot3_x_round2_bankjob2 = -683.23  
slot3_y_round2_bankjob2 = 1275.01
slot3_z_round2_bankjob2 = 9.81
slot3_heading_round2_bankjob2 = 90.0

slot4_x_round2_bankjob2 = -683.64  
slot4_y_round2_bankjob2 = 1278.10
slot4_z_round2_bankjob2 = 12.56 //12.85
slot4_heading_round2_bankjob2 = 90.0

slot5_x_round2_bankjob2 = -683.54  
slot5_y_round2_bankjob2 = 1275.25
slot5_z_round2_bankjob2 = 12.62
slot5_heading_round2_bankjob2 = 90.0

slot6_x_round2_bankjob2 = -683.54  
slot6_y_round2_bankjob2 = 1272.39
slot6_z_round2_bankjob2 = 12.62
slot6_heading_round2_bankjob2 = 90.0

// Percentage hits

ammo_given_round1_bankjob2 = 0

ammo_used_round1_bankjob2 = 0

ammo_given_round2_bankjob2 = 0

ammo_used_round2_bankjob2 = 0

ammo_given_round3_bankjob2 = 0

ammo_used_round3_bankjob2 = 0

total_ammo_used_bankjob2 = 0

// Round2 timer stuff

timer_round2_bankjob2 = 61000

timer_round3_bankjob2 = 61000

// Timer create targets round2

create_timer_targ1_round2_bankjob2 = 0
			
timer_create_targ1_round2_bankjob2 = 0

targ1_round2_movetime_bankjob2 = 0

create_timer_targ2_round2_bankjob2 = 0
			
timer_create_targ2_round2_bankjob2 = 0

targ2_round2_movetime_bankjob2 = 0

create_timer_targ3_round2_bankjob2 = 0
			
timer_create_targ3_round2_bankjob2 = 0

targ3_round2_movetime_bankjob2 = 0

create_timer_targ4_round2_bankjob2 = 0
			
timer_create_targ4_round2_bankjob2 = 0

targ4_round2_movetime_bankjob2 = 0

create_timer_targ5_round2_bankjob2 = 0
			
timer_create_targ5_round2_bankjob2 = 0

targ5_round2_movetime_bankjob2 = 0

create_timer_targ6_round2_bankjob2 = 0
			
timer_create_targ6_round2_bankjob2 = 0

targ6_round2_movetime_bankjob2 = 0

// Removes all player weapon stuff

slot4_weapon_type_bank2 = 0 

slot4_ammo_bank2 = 0 

slot4_model_bank2 = 0

// Audio Stuff

doing_well_audio_loaded_bankjob2 = 0

doing_bad_audio_loaded_bankjob2 = 0

round_clear_audio_loaded_bankjob2 = 0

// Round done correctly flags

flag_round1_done_right_bankjob2 = 0

flag_round2_done_right_bankjob2 = 0

flag_round3_done_right_bankjob2 = 0

// Round 3 random target picking stuff

target1_to_move_this_time_bankjob2 = 0

target2_to_move_this_time_bankjob2 = 0

target3_to_move_this_time_bankjob2 = 0
		
targ_to_move1_bankjob2 = 0

targ_to_move2_bankjob2 = 0

targ_to_move3_bankjob2 = 0

flag_choose_slots_bankjob2 = 0

counter_slot_free_bankjob2 = 0  // Tells me that all 3 slots are empty again so I can create again

target7_round3_delete_bankjob2 = 0

target8_round3_delete_bankjob2 = 0

target9_round3_delete_bankjob2 = 0

target10_round3_delete_bankjob2 = 0

target11_round3_delete_bankjob2 = 0

target12_round3_delete_bankjob2 = 0

target13_round3_delete_bankjob2 = 0 
 
// ROund2 part2 extra target movement stuff STUFF

VAR_INT target9_round3_been_left_bank2

target9_round3_been_left_bank2 = 0

VAR_INT target10_round3_been_left_bank2

target10_round3_been_left_bank2 = 0

VAR_INT target11_round3_been_down_bank2

target11_round3_been_down_bank2 = 0

VAR_INT target12_round3_been_left_bank2

target12_round3_been_left_bank2 = 0

VAR_INT target13_round3_been_left_bank2

target13_round3_been_left_bank2 = 0

// Round one target creation stuff

VAR_INT game_time_round1_bankjob2

VAR_INT create_timer_targ1_round1_bankjob2
 
create_timer_targ1_round1_bankjob2 = 0

VAR_INT timer_create_targ1_round1_bankjob2

timer_create_targ1_round1_bankjob2 = 0 

VAR_INT targ1_round1_movetime_bankjob2	   		  		
	 
targ1_round1_movetime_bankjob2 = 0

VAR_INT create_timer_targ2_round1_bankjob2
 
create_timer_targ2_round1_bankjob2 = 0

VAR_INT timer_create_targ2_round1_bankjob2

timer_create_targ2_round1_bankjob2 = 0 

VAR_INT targ2_round1_movetime_bankjob2	   		  		
	 
targ2_round1_movetime_bankjob2 = 0

VAR_INT create_timer_targ3_round1_bankjob2
 
create_timer_targ3_round1_bankjob2 = 0

VAR_INT timer_create_targ3_round1_bankjob2

timer_create_targ3_round1_bankjob2 = 0 

VAR_INT targ3_round1_movetime_bankjob2	   		  		
	 
targ3_round1_movetime_bankjob2 = 0

// New counter stuff

VAR_INT score_to_beat_bankjob2

score_to_beat_bankjob2 = 60

VAR_INT targets_really_hit_round1_bank1 // How many targets teh player hit

targets_really_hit_round1_bank1 = 0

// New player score stuff

player_score_bankjob2 = 0

final_ammo_used_bankjob2 = 0

WAIT 0

LOAD_MISSION_TEXT BANKJ2

SET_SHORTCUT_DROPOFF_POINT_FOR_MISSION 512.591 -74.900 9.573 189.24

// ****************************************START OF CUTSCENE********************************
 
LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSken
LOAD_SPECIAL_CHARACTER 3 CScamj
LOAD_SPECIAL_MODEL CUTOBJ01 gcfan
LOAD_SPECIAL_MODEL CUTOBJ02 clchr

SET_AREA_VISIBLE VIS_MALIBU_CLUB

LOAD_SCENE 481.03 -64.21 8.98

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02
	WAIT 0

ENDWHILE

LOAD_CUTSCENE bank_2a

SET_CUTSCENE_OFFSET 476.972 -65.499 8.943
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_ken
SET_CUTSCENE_ANIM cs_ken CSken

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_cam
SET_CUTSCENE_ANIM cs_cam CScamj

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_clubfan
SET_CUTSCENE_ANIM_TO_LOOP gcfan
SET_CUTSCENE_ANIM cs_clubfan gcfan

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_clubchair
SET_CUTSCENE_ANIM cs_clubchair clchr

CLEAR_AREA 493.1 -82.4 9.8 1.0 TRUE
SET_PLAYER_COORDINATES player1 493.1 -82.4 9.8
SET_PLAYER_HEADING player1 220.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 4027 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_A ) 10000 1 //"We need a stick up man. You know one?

WHILE cs_time < 6132 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_B ) 10000 1 //"Hey, Tommy, Tommy, this stuff keeps you sharp, man."

WHILE cs_time < 8289 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_C ) 10000 1 //"WoooOOOooo!

WHILE cs_time < 9182 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_D ) 10000 1 //"I could be your stick up man! Stick 'em up! Stick 'em up!"

WHILE cs_time < 11691 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_E ) 10000 1 //"You ain't a stick up man, you're an idiot.

WHILE cs_time < 13719 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_F ) 10000 1 //"Now get yourself a drink and shut up.

WHILE cs_time < 16291 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_G ) 10000 1 //"Get outta my way! Ye ye ye ow ow.

WHILE cs_time < 18784 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_N ) 10000 1 //"Relax"


WHILE cs_time < 19689 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_H ) 10000 1 //"Cam, what do you think?"

WHILE cs_time < 21204 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_I ) 10000 1 //"Well, the best shooter in this town is a guy named Cassidy."

WHILE cs_time < 23822 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_J ) 10000 1 //"Is that so?"

WHILE cs_time < 24473 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_K ) 10000 1 //"Yeah. A military guy, or thinks he is.

WHILE cs_time < 27111 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_L ) 10000 1 //"I doubt he was ever in the army but he certainly knows how to get hold of guns."

WHILE cs_time < 30697 
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_M ) 10000 1 //"He'll be down at the shooting range."

WHILE cs_time < 32448
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 32758
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"

CLEAR_EXTRA_COLOURS FALSE

SWITCH_RUBBISH ON
SET_CAR_DENSITY_MULTIPLIER 1.0
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3

MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

SET_AREA_VISIBLE VIS_MAIN_MAP

LOAD_SCENE 493.1 -82.4 9.8 

// ****************************************END OF CUTSCENE**********************************

flag_player_in_malibu = 0

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 2000 FADE_IN

// Waiting for the ped models to load

PRINT_NOW ( BJM2_1 ) 5000 1 //"Go to the competition and win it!"

ADD_BLIP_FOR_COORD -667.85 1211.9 10.08 radar_blip_coord2_bankjob2  

ADD_SPHERE -667.85 1211.9 10.08 1.5 sphere_bankjob2

flag_player_on_bank_2 = 1 // Used for interior loading stuff   

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -667.8 1221.0 10.5 1.5 1.5 3.0 FALSE // SCFIX: last arg was TRUE 

	WAIT 0

	IF LOCATE_PLAYER_ON_FOOT_3D player1 -667.85 1211.9 10.08 1.5 1.5 3.0 FALSE
		REMOVE_SPHERE sphere_bankjob2
	ENDIF
		
ENDWHILE

REMOVE_SPHERE sphere_bankjob2 

REMOVE_BLIP radar_blip_coord2_bankjob2

SET_PLAYER_CONTROL player1 OFF

SWITCH_RUBBISH OFF

SWITCH_STREAMING OFF

WHILE GET_FADING_STATUS
	
	WAIT 0

ENDWHILE

GET_GAME_TIMER breakout_timer_start

breakout_diff = 0

WHILE NOT CAN_PLAYER_START_MISSION player1
AND breakout_diff < 5000  // if player is not in control after 5 secs do the cutscene anyway

	WAIT 0
	
    GET_GAME_TIMER breakout_timer                                                                                
	breakout_diff = breakout_timer - breakout_timer_start
	 	
ENDWHILE

MAKE_PLAYER_SAFE_FOR_CUTSCENE player1

DISABLE_CUTSCENE_SHADOWS

// ************************************** CUT SCENE TWO ************************************

SWITCH_STREAMING OFF

LOAD_SPECIAL_CHARACTER 1 CSplay
LOAD_SPECIAL_CHARACTER 2 CSphil
LOAD_SPECIAL_CHARACTER 3 shootra
LOAD_SPECIAL_CHARACTER 4 shootrb
LOAD_SPECIAL_MODEL CUTOBJ01 deagl
LOAD_SPECIAL_MODEL CUTOBJ02 cpyth

LOAD_SCENE -661.91 1231.87 10.08

LOAD_ALL_MODELS_NOW
						 
WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 2
OR NOT HAS_SPECIAL_CHARACTER_LOADED 3
OR NOT HAS_SPECIAL_CHARACTER_LOADED 4
OR NOT HAS_MODEL_LOADED CUTOBJ01
OR NOT HAS_MODEL_LOADED CUTOBJ02

	WAIT 0

ENDWHILE

LOAD_CUTSCENE bank_2b

SET_CUTSCENE_OFFSET -666.305 1225.687 10.031
SET_NEAR_CLIP 0.1
				
CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
SET_CUTSCENE_ANIM cs_player CSplay

CREATE_CUTSCENE_OBJECT SPECIAL02 cs_phil
SET_CUTSCENE_ANIM cs_phil CSphil

CREATE_CUTSCENE_OBJECT SPECIAL03 cs_shootra
SET_CUTSCENE_ANIM cs_shootra shootra

CREATE_CUTSCENE_OBJECT SPECIAL04 cs_shootrb
SET_CUTSCENE_ANIM cs_shootrb shootrb

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_philgun1
SET_CUTSCENE_ANIM cs_philgun1 deagl01

CREATE_CUTSCENE_OBJECT CUTOBJ01 cs_philgun2
SET_CUTSCENE_ANIM cs_philgun2 deagl02

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_gun1
SET_CUTSCENE_ANIM cs_gun1 cpyth01

CREATE_CUTSCENE_OBJECT CUTOBJ02 cs_gun2
SET_CUTSCENE_ANIM cs_gun2 cpyth02

CLEAR_AREA -666.46 1231.72 10.07 1.0 TRUE
SET_PLAYER_COORDINATES player1 -666.46 1231.72 10.07
SET_PLAYER_HEADING player1 84.0

DO_FADE 2000 FADE_IN

SWITCH_RUBBISH OFF
SWITCH_STREAMING ON
START_CUTSCENE

// Displays cutscene text

GET_CUTSCENE_TIME cs_time

WHILE cs_time < 333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.670 1227.545 11.559 -667.921 1227.529 11.568
ENDIF

WHILE cs_time < 3433
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.682 1229.793 11.764 -667.921 1229.807 11.769
ENDIF

WHILE cs_time < 11500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.742 1233.778  11.661 -667.960 1233.741 11.668
ENDIF

WHILE cs_time < 12256
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2A ) 10000 1 //"You Phil Cassidy?"

WHILE cs_time < 13731
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2B ) 10000 1 //"Why?"

WHILE cs_time < 14800
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.788 1264.023 11.613 -667.960 1234.055 11.611
ENDIF

WHILE cs_time < 15378
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2C ) 10000 1 //"I'm looking for a man who can handle a gun. From this setup, I'm too not convinced."

WHILE cs_time < 17100
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.763 1233.782 11.634 -667.977 1233.746 11.665
ENDIF

WHILE cs_time < 19500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.790 1233.966 11.617 -667.992 1234.007 11.600
ENDIF

WHILE cs_time < 20669
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2D ) 10000 1 //"Son, I could shoot a fly off your head from 80 feet."

WHILE cs_time < 24067
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2E ) 10000 1 //"Oh really?"

WHILE cs_time < 24900
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.723 1233.882 11.510 -667.925 1233.924 11.507
ENDIF

WHILE cs_time < 25633
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.621 1233.834 11.589 -667.807 1233.785 11.676
ENDIF

WHILE cs_time < 25716
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2F ) 10000 1 //"Yeah. I learnt in the army."

WHILE cs_time < 26500
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.651 1233.901 11.568 -667.851 1233.951 11.575
ENDIF

WHILE cs_time < 27333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.597 1233.878 11.597 -667.792 1233.853 11.688
ENDIF

WHILE cs_time < 27997
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2G ) 10000 1 //"Fly shooting real popular in the army? Glad I don't pay tax."

WHILE cs_time < 28333
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.668 1233.848 11.601 -667.875 1233.869 11.598
ENDIF

WHILE cs_time < 29266
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

IF NOT WAS_CUTSCENE_SKIPPED
	ADD_BIG_GUN_FLASH -667.597 1233.892 11.522 -667.802 1233.843 11.555
ENDIF

WHILE cs_time < 31594
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2H ) 10000 1 //"You tryin' to be funny kid? Ha ha ha ha ha! Let's shoot."

WHILE cs_time < 34852
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2I ) 10000 1 //"Ha ha ha ha ha!"

WHILE cs_time < 37052
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

PRINT_NOW ( BJM2_2J ) 10000 1 //"Let's shoot."

WHILE cs_time < 39168
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

CLEAR_PRINTS

WHILE cs_time < 41968
	WAIT 0
	GET_CUTSCENE_TIME cs_time
ENDWHILE

DO_FADE 2000 FADE_OUT

CLEAR_PRINTS

WHILE GET_FADING_STATUS
	WAIT 0
ENDWHILE

SWITCH_RUBBISH ON
CLEAR_CUTSCENE
SET_CAMERA_BEHIND_PLAYER

UNLOAD_SPECIAL_CHARACTER 1
UNLOAD_SPECIAL_CHARACTER 2
UNLOAD_SPECIAL_CHARACTER 3
//UNLOAD_SPECIAL_CHARACTER 4 // SCFIX: using this guy in gameplay now
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ01
MARK_MODEL_AS_NO_LONGER_NEEDED CUTOBJ02

LOAD_SCENE -663.95 1231.29 10.08

flag_player_on_bank_2 = 0

// ************************************ END OF CUTSCENE TWO ********************************

SET_PLAYER_MOOD player1 PLAYER_MOOD_CALM 60000

SHUT_PLAYER_UP player1 TRUE

SET_PLAYER_CONTROL player1 OFF // SCFIX

//REQUEST_MODEL MALE01 // SCFIX: not used anymore

REQUEST_MODEL tar_gun1

REQUEST_MODEL tar_gun2

REQUEST_MODEL COLT45

REQUEST_MODEL tar_frame

REQUEST_MODEL tar_downleft

REQUEST_MODEL tar_downright

REQUEST_MODEL tar_top

REQUEST_MODEL tar_upleft

REQUEST_MODEL tar_upright

REQUEST_MODEL faketarget

LOAD_SPECIAL_CHARACTER 5 igphil

LOAD_MISSION_AUDIO 1 ( BNK2_1 ) // Live Ammo

LOAD_MISSION_AUDIO 2 ( BNK2_2 ) // Aim 3-2-1 fire 

//WHILE NOT HAS_MODEL_LOADED MALE01 // SCFIX: not used anymore
WHILE NOT HAS_MODEL_LOADED COLT45 // SCFIX: OR became WHILE
OR NOT HAS_MODEL_LOADED tar_gun1
OR NOT HAS_SPECIAL_CHARACTER_LOADED 5
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2


	WAIT 0
      
ENDWHILE

WHILE NOT HAS_MODEL_LOADED tar_frame
OR NOT HAS_MODEL_LOADED tar_downleft
OR NOT HAS_MODEL_LOADED tar_downright
OR NOT HAS_MODEL_LOADED tar_top
OR NOT HAS_MODEL_LOADED tar_upleft
OR NOT HAS_MODEL_LOADED tar_upright 

	WAIT 0
	
ENDWHILE

WHILE NOT HAS_MODEL_LOADED faketarget
OR NOT HAS_MODEL_LOADED tar_gun2

	WAIT 0
	
ENDWHILE 

// creates phil

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL05 -665.99 1234.17 10.08 phil_bankjob2

CLEAR_CHAR_THREAT_SEARCH phil_bankjob2

GIVE_WEAPON_TO_CHAR phil_bankjob2 WEAPONTYPE_PISTOL 1

SET_CHAR_HEADING phil_bankjob2 90.0 

// creates other shooters

CREATE_CHAR PEDTYPE_CIVMALE SPECIAL04 -666.29 1229.32 10.08 gunner1_bankjob2 // SCFIX: was MALE01

CLEAR_CHAR_THREAT_SEARCH gunner1_bankjob2

GIVE_WEAPON_TO_CHAR gunner1_bankjob2 WEAPONTYPE_PISTOL 1

SET_CHAR_HEADING gunner1_bankjob2 90.0

// Creates the invisible target to stick palyer on

CREATE_OBJECT_NO_OFFSET faketarget -668.42 1231.65 10.08 object1_bankjob2
DONT_REMOVE_OBJECT object1_bankjob2
SET_OBJECT_HEADING object1_bankjob2 90.0   

CREATE_OBJECT_NO_OFFSET faketarget -664.73 1269.09 9.81 object2_bankjob2
DONT_REMOVE_OBJECT object2_bankjob2
SET_OBJECT_HEADING object2_bankjob2 90.0
   
CREATE_OBJECT_NO_OFFSET faketarget -677.75 1272.03 9.81 object3_bankjob2
DONT_REMOVE_OBJECT object3_bankjob2
SET_OBJECT_HEADING object3_bankjob2 0.0

// sets up player1 in 1st person camera mode and locks him in position.

GET_CHAR_WEAPON_IN_SLOT scplayer 4 slot4_weapon_type_bank2 slot4_ammo_bank2 slot4_model_bank2

// SCFIX: START - make sure the model is not unloaded (COLT45 is already requested for the mission)
IF NOT slot4_model_bank2 = COLT45
AND slot4_ammo_bank2 > 0
	REQUEST_MODEL slot4_model_bank2
ENDIF
// SCFIX: END

// SCFIX: START - nil player's ammo before attach
SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_PISTOL
SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 0
// SCFIX: END

SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED // SCFIX: moved before attach
ATTACH_CHAR_TO_OBJECT scplayer object1_bankjob2 0.0 -2.0 1.0 FACING_FORWARD 60.0 WEAPONTYPE_PISTOL
SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_PISTOL
SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 100
ammo_given_round1_bankjob2 = 100

// fades the screen in 

SET_FADING_COLOUR 0 0 0

WAIT 500

DO_FADE 2000 FADE_IN

// SCFIX: START - tidy up this big ass chunk
LVAR_INT bank2_tutor_state
bank2_tutor_state = 0

WHILE bank2_tutor_state < 9
	WAIT 0

	IF flag_played_bank2_before = 1
	AND bank2_tutor_state > 0

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

	IF bank2_tutor_state = 0
		IF NOT GET_FADING_STATUS
			bank2_tutor_state = 1
		ENDIF
	ENDIF

	IF bank2_tutor_state = 1
		PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!
		timera = 0
		bank2_tutor_state = 2
	ENDIF

	IF bank2_tutor_state = 2
	AND timera >= 5000
		PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!
		timera = 0
		bank2_tutor_state = 3
	ENDIF

	IF bank2_tutor_state = 3
	AND timera >= 5000
		PRINT_NOW ( BJM2_24 ) 8000 1 //The first target is worth one point.
		timera = 0
		bank2_tutor_state = 4
	ENDIF

	IF bank2_tutor_state = 4
	AND timera >= 5000
		PRINT_NOW ( BJM2_25 ) 8000 1 //The second target is worth two points.
		timera = 0
		bank2_tutor_state = 5
	ENDIF

	IF bank2_tutor_state = 5
	AND timera >= 5000
		PRINT_NOW ( BJM2_26 ) 8000 1 //The third target is worth three points.
		timera = 0
		bank2_tutor_state = 6
	ENDIF

	IF bank2_tutor_state = 6
	AND timera >= 5000
		PRINT_NOW ( BJM2_2 ) 8000 1 //"To exit the round press the ^ button."
		timera = 0
		bank2_tutor_state = 7
	ENDIF

	IF bank2_tutor_state = 7
	AND timera >= 5000
		PRINT_NOW ( BJM2_23 ) 8000 1 //"If you leave the shooting range during the competition, you will fail the mission."
		timera = 0
		bank2_tutor_state = 8
	ENDIF

	IF bank2_tutor_state = 8
	AND timera >= 5000
		bank2_tutor_state = 9
	ENDIF

ENDWHILE
// SCFIX: END

/* SCFIX: all this was rewritten above
WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!

IF flag_played_bank2_before = 1

	IF IS_BUTTON_PRESSED PAD1 CROSS
	OR IS_BUTTON_PRESSED PAD1 START
		GOTO mission_skip_bank2
	ENDIF

ENDIF

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_24 ) 8000 1 //The first target is worth one point.

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_25 ) 8000 1 //The second target is worth two points.

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_26 ) 8000 1 //The third target is worth three points.

timera = 0

WHILE timera < 5000

	WAIT 0   

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_2 ) 8000 1 //"To exit the round press the ^ button."

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_23 ) 8000 1 //"If you leave the shooting range during the competition, you will fail the mission."

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE
*/

flag_played_bank2_before = 1

mission_skip_bank2:

SET_PLAYER_CONTROL player1 ON
PRINT_NOW ( BNK2_1 ) 5000 1 //"LIVE AMMO"
PLAY_MISSION_AUDIO 1 // Live ammo

SET_POLICE_IGNORE_PLAYER player1 ON

SET_EVERYONE_IGNORE_PLAYER player1 ON

blob_flag = 1

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1 // Live ammo

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
		
ENDWHILE

CLEAR_THIS_PRINT ( BNK2_1 ) // LIVE AMMO

LOAD_MISSION_AUDIO 1 ( BNK2_5 ) // couldnt hit a barn door

PLAY_MISSION_AUDIO 2 // Aim 3-2-1 fire

PRINT_NOW ( BNK2_2 ) 5000 1 //"Aim 3-2-1 fire"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2 // aim
OR NOT HAS_MISSION_AUDIO_LOADED 1 // Area clear

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	
ENDWHILE

CLEAR_THIS_PRINT ( BNK2_2 ) // FIRE

LOAD_MISSION_AUDIO 2 ( BNK2_4 ) // Hoooeee player doing well

doing_well_audio_loaded_bankjob2 = 0

doing_bad_audio_loaded_bankjob2 = 1

DISPLAY_ONSCREEN_TIMER timer_round1_bankjob2 TIMER_DOWN

DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING score_to_beat_bankjob2 COUNTER_DISPLAY_NUMBER 2 ( BJM2_18 )

DISPLAY_NTH_ONSCREEN_COUNTER_WITH_STRING player_score_bankjob2 COUNTER_DISPLAY_NUMBER 1 ( BJM2_15 )

timera = 0

ADD_CONTINUOUS_SOUND -679.403 1232.564 11.105 SOUND_SHOOTING_RANGE_TARGET_MOVING_LOOP target_moving_sound_bank2

WHILE flag_round1_finished_bankjob2 = 0

	WAIT 0

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
		
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		flag_round1_finished_bankjob2 = 1
	ENDIF	

	IF doing_well_audio_loaded_bankjob2 = 0
	
		IF HAS_MISSION_AUDIO_LOADED 2
			doing_well_audio_loaded_bankjob2 = 1
		ENDIF
	
	ENDIF
	
	IF doing_well_audio_loaded_bankjob2 = 1

		IF doing_bad_audio_loaded_bankjob2 = 1

			IF timera >= 60000
	
				IF counter_hits_scored_round1_bankjob2 >= 20
					PLAY_MISSION_AUDIO 2 // Player doing well
					PRINT_NOW ( BNK2_4 ) 5000 1 //"Hooeee!"
					doing_well_audio_loaded_bankjob2 = 2
				ELSE
					PLAY_MISSION_AUDIO 1 // Player doing bad
					PRINT_NOW ( BNK2_5 ) 5000 1 //"Couldn't hit a barn door!"
					doing_bad_audio_loaded_bankjob2 = 2
				ENDIF

			ENDIF
		
		ENDIF
		
	ENDIF
	
	IF doing_well_audio_loaded_bankjob2 = 2
	
		IF HAS_MISSION_AUDIO_FINISHED 2
			CLEAR_THIS_PRINT ( BNK2_4 ) // Player doing well
			CLEAR_MISSION_AUDIO 1
			CLEAR_MISSION_AUDIO 2
			doing_well_audio_loaded_bankjob2 = 3
		ENDIF
		
	ENDIF
	
	IF doing_bad_audio_loaded_bankjob2 = 2
	
		IF HAS_MISSION_AUDIO_FINISHED 1
			CLEAR_THIS_PRINT ( BNK2_5 )	// Player doing badly
			CLEAR_MISSION_AUDIO 1
			CLEAR_MISSION_AUDIO 2
			doing_bad_audio_loaded_bankjob2 = 3
		ENDIF
		
	ENDIF
	
	IF doing_well_audio_loaded_bankjob2 = 3
	OR doing_bad_audio_loaded_bankjob2 = 3
	
		IF round_clear_audio_loaded_bankjob2 = 0
			LOAD_MISSION_AUDIO 1 ( BNK2_3 ) // Area clear
			LOAD_MISSION_AUDIO 2 ( BNK2_2 ) // Aim FIRe
			round_clear_audio_loaded_bankjob2 = 1
		ENDIF
		
	ENDIF
	
	IF round_clear_audio_loaded_bankjob2 = 1
	
		IF HAS_MISSION_AUDIO_LOADED 1 // Area clear
		AND HAS_MISSION_AUDIO_LOADED 2 // Aim fire
			round_clear_audio_loaded_bankjob2 = 2
		ENDIF

	ENDIF	    	
	
	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF
				
	CLEAR_WANTED_LEVEL player1

	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL ammo_round1_bankjob
	  		
	IF timer_round1_bankjob2 = 0
	OR ammo_round1_bankjob = 0

		IF flag_time_out_round1_bank2 = 0
			timera = 0
			flag_time_out_round1_bank2 = 1
		ELSE

			IF timera > 200
							
				IF round_clear_audio_loaded_bankjob2 = 2
					PLAY_MISSION_AUDIO 1 // area clear
					PRINT_NOW ( BNK2_3 ) 5000 1 //"area clear!"
					flag_round1_done_right_bankjob2 = 1
				ENDIF
						 
				flag_round1_finished_bankjob2 = 1
				
			ENDIF
			
		ENDIF
			
	ENDIF
	   	
	GET_GAME_TIMER game_time_round1_bankjob2
	   	
// slot 1
	
	IF create_timer_targ1_round1_bankjob2 = 0
		GET_GAME_TIMER game_time_round1_bankjob2
		timer_create_targ1_round1_bankjob2 = game_time_round1_bankjob2
		create_timer_targ1_round1_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ1_round1_bankjob2 = 1 
		targ1_round1_movetime_bankjob2 = game_time_round1_bankjob2 - timer_create_targ1_round1_bankjob2
	ENDIF

	IF targ1_round1_movetime_bankjob2 >= 2000
						
		IF slot1_filled_round1_bankjob2 = 0

			CREATE_OBJECT tar_frame slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_frame_bankjob2
			SET_OBJECT_HEADING target1_frame_bankjob2 90.0 

			CREATE_OBJECT tar_downleft slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part1_bankjob2
			SET_OBJECT_HEADING target1_part1_bankjob2 90.0

			CREATE_OBJECT tar_downright slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part2_bankjob2
			SET_OBJECT_HEADING target1_part2_bankjob2 90.0

			CREATE_OBJECT tar_top slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part3_bankjob2
			SET_OBJECT_HEADING target1_part3_bankjob2 90.0

			CREATE_OBJECT tar_upleft slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part4_bankjob2
			SET_OBJECT_HEADING target1_part4_bankjob2 90.0

			CREATE_OBJECT tar_upright slot1_x_bankjob2 slot1_y_bankjob2 slot1_z_bankjob2 target1_part5_bankjob2
			SET_OBJECT_HEADING target1_part5_bankjob2 90.0
		
			target_1_bankjob2_dead = 0
			target1_part1_dead_bankjob2 = 0
			target1_part2_dead_bankjob2 = 0
			target1_part3_dead_bankjob2 = 0
			target1_part4_dead_bankjob2 = 0
			target1_part5_dead_bankjob2 = 0
			target1_travel_bank2 = 0 // tells target to go left
			slot1_filled_round1_bankjob2 = 1
		ENDIF

	ENDIF
	
// Moves target one to left and right then to right if its destroyed			

	IF slot1_filled_round1_bankjob2 = 1

		IF target_1_bankjob2_dead = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target1_frame_bankjob2  
   				GET_OBJECT_COORDINATES target1_frame_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
   			ENDIF

			IF target1_travel_bank2 = 0 

  				IF targ1_y_bankjob2 <= 1228.70  // 1228.50 
  					target1_travel_bank2 = 1 // right
  				ELSE 
  					targ1_y_bankjob2 = targ1_y_bankjob2 -@ 0.06
  				ENDIF
	   
  			ELSE
		
   				IF targ1_y_bankjob2 >= 1236.50 
   					target1_travel_bank2 = 0 // left	  
   				ELSE
					targ1_y_bankjob2 = targ1_y_bankjob2 +@ 0.06
   				ENDIF

  			ENDIF

		ELSE
		
			IF NOT HAS_OBJECT_BEEN_DAMAGED target1_frame_bankjob2  
   				GET_OBJECT_COORDINATES target1_frame_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
   			
				IF targ1_y_bankjob2 >= 1239.0
					IF NOT HAS_OBJECT_BEEN_DAMAGED target1_frame_bankjob2
						DELETE_OBJECT target1_frame_bankjob2  
					ENDIF
   					slot1_filled_round1_bankjob2 = 0
   					create_timer_targ1_round1_bankjob2 = 0	  
   				ELSE
					targ1_y_bankjob2 = targ1_y_bankjob2 +@ 0.06 
   				ENDIF
			
			ENDIF

		ENDIF
   		  		
  	ENDIF 
	   
// Target One

	IF slot1_filled_round1_bankjob2 = 1
	
		SET_OBJECT_COORDINATES target1_frame_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
 		
		IF target_1_bankjob2_dead = 0
				   				
			IF target1_part1_dead_bankjob2 = 1
			AND target1_part2_dead_bankjob2 = 1
		   	AND target1_part3_dead_bankjob2 = 1
		   	AND target1_part4_dead_bankjob2 = 1
		   	AND target1_part5_dead_bankjob2 = 1
				++ targets_really_hit_round1_bank1
				++ counter_hits_scored_round1_bankjob2
				++ player_score_bankjob2
				create_timer_targ1_round1_bankjob2 = 0
				target_1_bankjob2_dead = 1
			ENDIF

// part one of the target
			
			IF target1_part1_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part1_bankjob2
					DELETE_OBJECT target1_part1_bankjob2
					++ bits_hit_bank2
					target1_part1_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part1_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF

			ENDIF 
			

// part two of the target
			
			IF target1_part2_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part2_bankjob2
					DELETE_OBJECT target1_part2_bankjob2
					++ bits_hit_bank2
					target1_part2_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part2_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
		   		ENDIF
				
			ENDIF

// part three of the target
			
			IF target1_part3_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part3_bankjob2
					DELETE_OBJECT target1_part3_bankjob2
					++ bits_hit_bank2
					target1_part3_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part3_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF
						   
			ENDIF

// part four of the target
			
			IF target1_part4_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part4_bankjob2
					DELETE_OBJECT target1_part4_bankjob2
					++ bits_hit_bank2
					target1_part4_dead_bankjob2 = 1
				ELSE
			 		SET_OBJECT_COORDINATES target1_part4_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF

			ENDIF
			
// part five of the target
			
			IF target1_part5_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target1_part5_bankjob2
					DELETE_OBJECT target1_part5_bankjob2
					++ bits_hit_bank2
					target1_part5_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target1_part5_bankjob2 targ1_x_bankjob2 targ1_y_bankjob2 targ1_z_bankjob2
				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF

// ******************************************* Slot2 ***************************************

	IF create_timer_targ2_round1_bankjob2 = 0
		GET_GAME_TIMER game_time_round1_bankjob2
		timer_create_targ2_round1_bankjob2 = game_time_round1_bankjob2
		create_timer_targ2_round1_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ2_round1_bankjob2 = 1 
		targ2_round1_movetime_bankjob2 = game_time_round1_bankjob2 - timer_create_targ2_round1_bankjob2
	ENDIF
	
	IF targ2_round1_movetime_bankjob2 >= 2000 
							
		IF slot2_filled_round1_bankjob2 = 0

			CREATE_OBJECT tar_frame slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_frame_bankjob2
			SET_OBJECT_HEADING target2_frame_bankjob2 90.0 

			CREATE_OBJECT tar_downleft slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part1_bankjob2
			SET_OBJECT_HEADING target2_part1_bankjob2 90.0

			CREATE_OBJECT tar_downright slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part2_bankjob2
			SET_OBJECT_HEADING target2_part2_bankjob2 90.0

			CREATE_OBJECT tar_top slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part3_bankjob2
			SET_OBJECT_HEADING target2_part3_bankjob2 90.0

			CREATE_OBJECT tar_upleft slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part4_bankjob2
			SET_OBJECT_HEADING target2_part4_bankjob2 90.0

			CREATE_OBJECT tar_upright slot2_x_bankjob2 slot2_y_bankjob2 slot2_z_bankjob2 target2_part5_bankjob2
			SET_OBJECT_HEADING target2_part5_bankjob2 90.0
		
			target_2_bankjob2_dead = 0
			target2_part1_dead_bankjob2 = 0
			target2_part2_dead_bankjob2 = 0
			target2_part3_dead_bankjob2 = 0
			target2_part4_dead_bankjob2 = 0
			target2_part5_dead_bankjob2 = 0
			target2_travel_bank2 = 1 // tells target to go right
			slot2_filled_round1_bankjob2 = 1
		ENDIF

	ENDIF
	
// Moves target one to left and right then to right if its destroyed			

	IF slot2_filled_round1_bankjob2 = 1

		IF target_2_bankjob2_dead = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target2_frame_bankjob2  
   				GET_OBJECT_COORDINATES target2_frame_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
   			ENDIF

			IF target2_travel_bank2 = 0 

  				IF targ2_y_bankjob2 <= 1228.70
  					target2_travel_bank2 = 1 // right
  				ELSE 
  					targ2_y_bankjob2 = targ2_y_bankjob2 -@ 0.04
  				ENDIF
	   
  			ELSE
		
   				IF targ2_y_bankjob2 >= 1236.50 
   					target2_travel_bank2 = 0 // left	  
   				ELSE
					targ2_y_bankjob2 = targ2_y_bankjob2 +@ 0.04
   				ENDIF

  			ENDIF
						
		ELSE
		
			IF NOT HAS_OBJECT_BEEN_DAMAGED target2_frame_bankjob2  
   				GET_OBJECT_COORDINATES target2_frame_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
   			
				IF targ2_y_bankjob2 <= 1227.00
					IF NOT HAS_OBJECT_BEEN_DAMAGED target2_frame_bankjob2
						DELETE_OBJECT target2_frame_bankjob2  
					ENDIF
   					slot2_filled_round1_bankjob2 = 0
   					create_timer_targ2_round1_bankjob2 = 0	  
   				ELSE
					targ2_y_bankjob2 = targ2_y_bankjob2 -@ 0.06
   				ENDIF
			
			ENDIF

		ENDIF
   		  		
  	ENDIF 
	   
// Target Two

	IF slot2_filled_round1_bankjob2 = 1
	
		SET_OBJECT_COORDINATES target2_frame_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
 		
		IF target_2_bankjob2_dead = 0
				   				
			IF target2_part1_dead_bankjob2 = 1
			AND target2_part2_dead_bankjob2 = 1
		   	AND target2_part3_dead_bankjob2 = 1
		   	AND target2_part4_dead_bankjob2 = 1
		   	AND target2_part5_dead_bankjob2 = 1
				++ targets_really_hit_round1_bank1
				++ counter_hits_scored_round1_bankjob2
				++ counter_hits_scored_round1_bankjob2
				++ player_score_bankjob2
				++ player_score_bankjob2
				create_timer_targ2_round1_bankjob2 = 0
				target_2_bankjob2_dead = 1
			ENDIF

// part one of the target
			
			IF target2_part1_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part1_bankjob2
					DELETE_OBJECT target2_part1_bankjob2
					++ bits_hit_bank2
					target2_part1_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part1_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF

			ENDIF 
			

// part two of the target
			
			IF target2_part2_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part2_bankjob2
					DELETE_OBJECT target2_part2_bankjob2
					++ bits_hit_bank2
					target2_part2_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part2_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
		   		ENDIF
				
			ENDIF

// part three of the target
			
			IF target2_part3_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part3_bankjob2
					DELETE_OBJECT target2_part3_bankjob2
					++ bits_hit_bank2
					target2_part3_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part3_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF
						   
			ENDIF

// part four of the target
			
			IF target2_part4_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part4_bankjob2
					DELETE_OBJECT target2_part4_bankjob2
					++ bits_hit_bank2
					target2_part4_dead_bankjob2 = 1
				ELSE
			 		SET_OBJECT_COORDINATES target2_part4_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF

			ENDIF
			
// part five of the target
			
			IF target2_part5_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target2_part5_bankjob2
					DELETE_OBJECT target2_part5_bankjob2
					++ bits_hit_bank2
					target2_part5_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target2_part5_bankjob2 targ2_x_bankjob2 targ2_y_bankjob2 targ2_z_bankjob2
				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF

// ***************************************** SLOT3 *****************************************

// Slot Three

	IF create_timer_targ3_round1_bankjob2 = 0
		GET_GAME_TIMER game_time_round1_bankjob2
		timer_create_targ3_round1_bankjob2 = game_time_round1_bankjob2
		create_timer_targ3_round1_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ3_round1_bankjob2 = 1 
		targ3_round1_movetime_bankjob2 = game_time_round1_bankjob2 - timer_create_targ3_round1_bankjob2
	ENDIF

	IF targ3_round1_movetime_bankjob2 >= 2000
						
		IF slot3_filled_round1_bankjob2 = 0

			CREATE_OBJECT tar_frame slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_frame_bankjob2
			SET_OBJECT_HEADING target3_frame_bankjob2 90.0 

			CREATE_OBJECT tar_downleft slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part1_bankjob2
			SET_OBJECT_HEADING target3_part1_bankjob2 90.0

			CREATE_OBJECT tar_downright slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part2_bankjob2
			SET_OBJECT_HEADING target3_part2_bankjob2 90.0

			CREATE_OBJECT tar_top slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part3_bankjob2
			SET_OBJECT_HEADING target3_part3_bankjob2 90.0

			CREATE_OBJECT tar_upleft slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part4_bankjob2
			SET_OBJECT_HEADING target3_part4_bankjob2 90.0

			CREATE_OBJECT tar_upright slot3_x_bankjob2 slot3_y_bankjob2 slot3_z_bankjob2 target3_part5_bankjob2
			SET_OBJECT_HEADING target3_part5_bankjob2 90.0
		
			target_3_bankjob2_dead = 0
			target3_part1_dead_bankjob2 = 0
			target3_part2_dead_bankjob2 = 0
			target3_part3_dead_bankjob2 = 0
			target3_part4_dead_bankjob2 = 0
			target3_part5_dead_bankjob2 = 0
			target3_travel_bank2 = 0 // tells target to go left
			slot3_filled_round1_bankjob2 = 1
		ENDIF

	ENDIF
	
// Moves target one to left and right then to right if its destroyed			

	IF slot3_filled_round1_bankjob2 = 1

		IF target_3_bankjob2_dead = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target3_frame_bankjob2  
   				GET_OBJECT_COORDINATES target3_frame_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
   			ENDIF

			IF target3_travel_bank2 = 0 

  				IF targ3_y_bankjob2 <= 1228.70
  					target3_travel_bank2 = 1 // right
  				ELSE 
  					targ3_y_bankjob2 = targ3_y_bankjob2 -@ 0.02
  				ENDIF
	   
  			ELSE
		
   				IF targ3_y_bankjob2 >= 1236.50 
   					target3_travel_bank2 = 0 // left	  
   				ELSE
					targ3_y_bankjob2 = targ3_y_bankjob2 +@ 0.02
   				ENDIF

  			ENDIF

		ELSE
		
			IF NOT HAS_OBJECT_BEEN_DAMAGED target3_frame_bankjob2  
   				GET_OBJECT_COORDINATES target3_frame_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
   			
				IF targ3_y_bankjob2 >= 1239.0
					IF NOT HAS_OBJECT_BEEN_DAMAGED target3_frame_bankjob2
						DELETE_OBJECT target3_frame_bankjob2  
					ENDIF
   					slot3_filled_round1_bankjob2 = 0
   					targ3_round1_movetime_bankjob2 = 0	  
   				ELSE
					targ3_y_bankjob2 = targ3_y_bankjob2 +@ 0.06 
   				ENDIF
			
			ENDIF

		ENDIF
   		  		
  	ENDIF 
	   
// Target Three

	IF slot3_filled_round1_bankjob2 = 1
	
		SET_OBJECT_COORDINATES target3_frame_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
 		
		IF target_3_bankjob2_dead = 0
				   				
			IF target3_part1_dead_bankjob2 = 1
			AND target3_part2_dead_bankjob2 = 1
		   	AND target3_part3_dead_bankjob2 = 1
		   	AND target3_part4_dead_bankjob2 = 1
		   	AND target3_part5_dead_bankjob2 = 1
				++ targets_really_hit_round1_bank1
				++ counter_hits_scored_round1_bankjob2
				++ counter_hits_scored_round1_bankjob2
				++ counter_hits_scored_round1_bankjob2
				++ player_score_bankjob2
				++ player_score_bankjob2
				++ player_score_bankjob2
				targ3_round1_movetime_bankjob2 = 0
				target_3_bankjob2_dead = 1
			ENDIF

// part one of the target
			
			IF target3_part1_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part1_bankjob2
					DELETE_OBJECT target3_part1_bankjob2
					++ bits_hit_bank2
					target3_part1_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part1_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF

			ENDIF 
			

// part two of the target
			
			IF target3_part2_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part2_bankjob2
					DELETE_OBJECT target3_part2_bankjob2
					++ bits_hit_bank2
					target3_part2_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part2_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
		   		ENDIF
				
			ENDIF

// part three of the target
			
			IF target3_part3_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part3_bankjob2
					DELETE_OBJECT target3_part3_bankjob2
					++ bits_hit_bank2
					target3_part3_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part3_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF
						   
			ENDIF

// part four of the target
			
			IF target3_part4_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part4_bankjob2
					DELETE_OBJECT target3_part4_bankjob2
					++ bits_hit_bank2
					target3_part4_dead_bankjob2 = 1
				ELSE
			 		SET_OBJECT_COORDINATES target3_part4_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF

			ENDIF
			
// part five of the target
			
			IF target3_part5_dead_bankjob2 = 0	
			
				IF HAS_OBJECT_BEEN_DAMAGED target3_part5_bankjob2
					DELETE_OBJECT target3_part5_bankjob2
					++ bits_hit_bank2
					target3_part5_dead_bankjob2 = 1
				ELSE
					SET_OBJECT_COORDINATES target3_part5_bankjob2 targ3_x_bankjob2 targ3_y_bankjob2 targ3_z_bankjob2
				ENDIF
							   	
			ENDIF

		ENDIF

	ENDIF
		
ENDWHILE

REMOVE_SOUND target_moving_sound_bank2

IF flag_round1_done_right_bankjob2 = 1

	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1 // Area clear

		WAIT 0
		
		IF IS_CHAR_DEAD phil_bankjob2
			PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
			GOTO mission_bankjob2_failed
		ENDIF

		IF IS_CHAR_DEAD gunner1_bankjob2
			PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
			GOTO mission_bankjob2_failed
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
			PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
			GOTO mission_bankjob2_failed
		ENDIF
   	
	ENDWHILE

ENDIF

CLEAR_THIS_PRINT ( BJM2_19 )

CLEAR_THIS_PRINT ( BJM2_20 )

CLEAR_THIS_PRINT ( BJM2_2 )

CLEAR_THIS_PRINT ( BNK2_3 ) // Area clear

ammo_used_round1_bankjob2 = ammo_given_round1_bankjob2 - ammo_round1_bankjob 

DETACH_CHAR_FROM_CAR scplayer

SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 0 // SCFIX

SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED // SCFIX: move after detach since detach restores previous weapon

DELETE_OBJECT object1_bankjob2

CLEAR_ONSCREEN_TIMER timer_round1_bankjob2 

PRINT_WITH_NUMBER_BIG ( BJM2_4 ) counter_hits_scored_round1_bankjob2 3000 1 // Score round 1


// ***************************************** ROUND TWO *************************************

// waiting for the player1 to get to round two

PRINT_NOW ( BJM2_9 ) 2000 1 //"Get to round two's starting point!

ADD_BLIP_FOR_COORD -664.73 1269.09 9.81 radar_blip_coord3_bankjob2

blob_flag = 1

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -664.73 1269.09 9.81 2.0 2.0 2.0 blob_flag

	WAIT 0
		
	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_CHAR_DEAD gunner1_bankjob2
		PRINT_NOW ( BJM2_12 ) 5000 1 //"One of the competitors is dead" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
			
ENDWHILE

REMOVE_BLIP radar_blip_coord3_bankjob2

SET_PLAYER_CONTROL player1 OFF

// SCFIX: START - remove this and delete char later
//IF NOT IS_CHAR_DEAD gunner1_bankjob2
//	MARK_CHAR_AS_NO_LONGER_NEEDED gunner1_bankjob2 
//ENDIF
// SCFIX: END

IF NOT IS_CHAR_DEAD phil_bankjob2
	SET_CHAR_HEADING phil_bankjob2 270.0
ENDIF 

// player1 is now in the starting area for round 2

SET_POLICE_IGNORE_PLAYER player1 ON

SET_EVERYONE_IGNORE_PLAYER player1 ON

WAIT 500

IF IS_CHAR_DEAD phil_bankjob2
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
	PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
	GOTO mission_bankjob2_failed
ENDIF

DELETE_CHAR gunner1_bankjob2 // SCFIX

// sets up player1 in 1st person camera mode and locks him in position.

ATTACH_CHAR_TO_OBJECT scplayer object2_bankjob2 0.0 0.0 1.0 FACING_FORWARD 60.0 WEAPONTYPE_PISTOL
SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 50
ammo_given_round2_bankjob2 = 50

DELETE_OBJECT target1_frame_bankjob2
DELETE_OBJECT target1_part1_bankjob2
DELETE_OBJECT target1_part2_bankjob2
DELETE_OBJECT target1_part3_bankjob2
DELETE_OBJECT target1_part4_bankjob2
DELETE_OBJECT target1_part5_bankjob2
DELETE_OBJECT target2_frame_bankjob2
DELETE_OBJECT target2_part1_bankjob2
DELETE_OBJECT target2_part2_bankjob2
DELETE_OBJECT target2_part3_bankjob2
DELETE_OBJECT target2_part4_bankjob2
DELETE_OBJECT target2_part5_bankjob2
DELETE_OBJECT target3_frame_bankjob2
DELETE_OBJECT target3_part1_bankjob2
DELETE_OBJECT target3_part2_bankjob2
DELETE_OBJECT target3_part3_bankjob2
DELETE_OBJECT target3_part4_bankjob2
DELETE_OBJECT target3_part5_bankjob2

// SCFIX: START - tidy up this big ass chunk
bank2_tutor_state = 0

WHILE bank2_tutor_state < 4
	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip2_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

	IF bank2_tutor_state = 0
		PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!
		timera = 0
		bank2_tutor_state = 1
	ENDIF

	IF bank2_tutor_state = 1
	AND timera >= 5000
		PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!
		timera = 0
		bank2_tutor_state = 2
	ENDIF

	IF bank2_tutor_state = 2
	AND timera >= 5000
		PRINT_NOW ( BJM2_27 ) 8000 1 //"All targets in this round are worth one point.
		timera = 0
		bank2_tutor_state = 3
	ENDIF

	IF bank2_tutor_state = 3
	AND timera >= 5000
		bank2_tutor_state = 4
	ENDIF
ENDWHILE
// SCFIX: END

/* SCFIX: all this was rewritten above
PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip2_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	
ENDWHILE 

PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip2_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_27 ) 8000 1 //"All targets in this round are worth one point.

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip2_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE
*/

mission_skip2_bank2:

LOAD_MISSION_AUDIO 2 ( BNK2_2 )
LOAD_MISSION_AUDIO 1 ( BNK2_3 ) 

WHILE NOT HAS_MISSION_AUDIO_LOADED 2
OR NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	
ENDWHILE 

SET_PLAYER_CONTROL player1 ON

PLAY_MISSION_AUDIO 2 // Aim 3 2 1 FIRE
PRINT_NOW ( BNK2_2 ) 4000 1 //"Aim fire"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
		
ENDWHILE

CLEAR_THIS_PRINT ( BNK2_2 ) // Aim

DISPLAY_ONSCREEN_TIMER timer_round2_bankjob2 TIMER_DOWN
					  
// Round two

ADD_CONTINUOUS_SOUND -682.092 1273.931 10.818 SOUND_SHOOTING_RANGE_TARGET_MOVING_LOOP target_moving_sound_bank2

WHILE round2_finished_bankjob2 = 0 

	WAIT 0

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

	IF IS_BUTTON_PRESSED PAD1 SQUARE
		round2_finished_bankjob2 = 1
	ENDIF

	GET_GAME_TIMER game_time_round2_bankjob2
	   	
// target 1
	
	IF create_timer_targ1_round2_bankjob2 = 0
		GET_GAME_TIMER game_time_round2_bankjob2
		timer_create_targ1_round2_bankjob2 = game_time_round2_bankjob2
		create_timer_targ1_round2_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ1_round2_bankjob2 = 1 
		targ1_round2_movetime_bankjob2 = game_time_round2_bankjob2 - timer_create_targ1_round2_bankjob2
	ENDIF
	
	IF targ1_round2_movetime_bankjob2 >= 500
		 
		IF flag_slot1_round2_filled_bankjob2 = 0
			CREATE_OBJECT_NO_OFFSET tar_gun1 slot1_x_round2_bankjob2 slot1_y_round2_bankjob2 slot1_z_round2_bankjob2 target1_round2_bankjob2 
			SET_OBJECT_HEADING target1_round2_bankjob2 slot1_heading_round2_bankjob2
			flag_target1_dead_round2_bankjob2 = 0
			target1_round2_removed_bankjob2 = 0
			timer_start_targ1_round2_bankjob2 = 0
			flag_slot1_round2_filled_bankjob2 = 1
		ENDIF			

		IF flag_slot1_round2_filled_bankjob2 = 1

			IF flag_target1_dead_round2_bankjob2 = 0
			AND target1_round2_removed_bankjob2 = 0
	
				IF NOT HAS_OBJECT_BEEN_DAMAGED target1_round2_bankjob2  
   					GET_OBJECT_COORDINATES target1_round2_bankjob2 targ1_round2_x_bankjob2 targ1_round2_y_bankjob2 targ1_round2_z_bankjob2

					IF timer_start_targ1_round2_bankjob2 = 0
				
						IF targ1_round2_y_bankjob2 < 1271.36
  							targ1_round2_y_bankjob2 = targ1_round2_y_bankjob2 +@ 0.02
						ELSE

							IF timer_start_targ1_round2_bankjob2 = 0
								GET_GAME_TIMER game_time_round2_bankjob2
								time_targ1_round2_in_posit_bankjob2 = game_time_round2_bankjob2  
								timer_start_targ1_round2_bankjob2 = 1
							ENDIF

						ENDIF

					ENDIF
				
					IF timer_start_targ1_round2_bankjob2 = 1
						delete_targ1_round2_time_bankjob2 = game_time_round2_bankjob2 - time_targ1_round2_in_posit_bankjob2
										
						IF delete_targ1_round2_time_bankjob2 >= 800
						
							IF targ1_round2_y_bankjob2 > 1268.74
  								targ1_round2_y_bankjob2 = targ1_round2_y_bankjob2 -@ 0.02
							ELSE
								DELETE_OBJECT target1_round2_bankjob2
								flag_slot1_round2_filled_bankjob2 = 0
								create_timer_targ1_round2_bankjob2 = 0
								target1_round2_removed_bankjob2 = 1
							ENDIF
						
						ENDIF
					
					ENDIF
				
					IF target1_round2_removed_bankjob2 = 0	
					AND flag_target1_dead_round2_bankjob2 = 0 
						SET_OBJECT_COORDINATES target1_round2_bankjob2 targ1_round2_x_bankjob2 targ1_round2_y_bankjob2 targ1_round2_z_bankjob2
					ENDIF

 				ELSE

					IF target1_round2_removed_bankjob2 = 0

						IF HAS_OBJECT_BEEN_DAMAGED target1_round2_bankjob2
			 				++ counter_hits_scored_round2_bankjob2
							++ player_score_bankjob2
							DELETE_OBJECT target1_round2_bankjob2
							create_timer_targ1_round2_bankjob2 = 0
							flag_slot1_round2_filled_bankjob2 = 0
							flag_target1_dead_round2_bankjob2 = 1
						ENDIF
		
					ENDIF

				ENDIF
			
			ENDIF

		ENDIF

	ENDIF

// Target 2
		
	IF create_timer_targ2_round2_bankjob2 = 0
		GET_GAME_TIMER game_time_round2_bankjob2
		timer_create_targ2_round2_bankjob2 = game_time_round2_bankjob2
		create_timer_targ2_round2_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ2_round2_bankjob2 = 1 
		targ2_round2_movetime_bankjob2 = game_time_round2_bankjob2 - timer_create_targ2_round2_bankjob2
	ENDIF

	IF targ2_round2_movetime_bankjob2 >= 4000
	
		IF flag_slot2_round2_filled_bankjob2 = 0
			CREATE_OBJECT_NO_OFFSET tar_gun2 slot2_x_round2_bankjob2 slot2_y_round2_bankjob2 slot2_z_round2_bankjob2 target2_round2_bankjob2 
			SET_OBJECT_HEADING target2_round2_bankjob2 slot2_heading_round2_bankjob2
			flag_target2_dead_round2_bankjob2 = 0
			target2_round2_removed_bankjob2 = 0
			timer_start_targ2_round2_bankjob2 = 0
			flag_slot2_round2_filled_bankjob2 = 1
		ENDIF
		
	ENDIF			

	IF flag_slot2_round2_filled_bankjob2 = 1

		IF flag_target2_dead_round2_bankjob2 = 0
		AND target2_round2_removed_bankjob2 = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target2_round2_bankjob2  
   				GET_OBJECT_COORDINATES target2_round2_bankjob2 targ2_round2_x_bankjob2 targ2_round2_y_bankjob2 targ2_round2_z_bankjob2

				IF timer_start_targ2_round2_bankjob2 = 0
				
					IF targ2_round2_y_bankjob2 < 1273.73
  						targ2_round2_y_bankjob2 = targ2_round2_y_bankjob2 +@ 0.02
					ELSE

						IF timer_start_targ2_round2_bankjob2 = 0
							GET_GAME_TIMER game_time_round2_bankjob2
							time_targ2_round2_in_posit_bankjob2 = game_time_round2_bankjob2  
							timer_start_targ2_round2_bankjob2 = 1
						ENDIF

					ENDIF

				ENDIF
				
				IF timer_start_targ2_round2_bankjob2 = 1
					delete_targ2_round2_time_bankjob2 = game_time_round2_bankjob2 - time_targ2_round2_in_posit_bankjob2
										
					IF delete_targ2_round2_time_bankjob2 >= 1000
						
						IF targ2_round2_y_bankjob2 > 1272.55
  							targ2_round2_y_bankjob2 = targ2_round2_y_bankjob2 -@ 0.02
						ELSE
							DELETE_OBJECT target2_round2_bankjob2
							create_timer_targ2_round2_bankjob2 = 0
							flag_slot2_round2_filled_bankjob2 = 0
							target2_round2_removed_bankjob2 = 1
						ENDIF
						
					ENDIF
					
				ENDIF
				
				IF target2_round2_removed_bankjob2 = 0	
				AND flag_target2_dead_round2_bankjob2 = 0 
					SET_OBJECT_COORDINATES target2_round2_bankjob2 targ2_round2_x_bankjob2 targ2_round2_y_bankjob2 targ2_round2_z_bankjob2
				ENDIF

 			ELSE

				IF target2_round2_removed_bankjob2 = 0

					IF HAS_OBJECT_BEEN_DAMAGED target2_round2_bankjob2
			 			++ counter_hits_scored_round2_bankjob2
						++ player_score_bankjob2
						DELETE_OBJECT target2_round2_bankjob2
						create_timer_targ2_round2_bankjob2 = 0
						flag_slot2_round2_filled_bankjob2 = 0
						flag_target2_dead_round2_bankjob2 = 1
					ENDIF
		
				ENDIF

			ENDIF
			
		ENDIF

	ENDIF
	
// Target 3

	IF create_timer_targ3_round2_bankjob2 = 0
		GET_GAME_TIMER game_time_round2_bankjob2
		timer_create_targ3_round2_bankjob2 = game_time_round2_bankjob2
		create_timer_targ3_round2_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ3_round2_bankjob2 = 1 
		targ3_round2_movetime_bankjob2 = game_time_round2_bankjob2 - timer_create_targ3_round2_bankjob2
	ENDIF

	IF targ3_round2_movetime_bankjob2 >= 1300
			
		IF flag_slot3_round2_filled_bankjob2 = 0
			CREATE_OBJECT_NO_OFFSET tar_gun1 slot3_x_round2_bankjob2 slot3_y_round2_bankjob2 slot3_z_round2_bankjob2 target3_round2_bankjob2 
			SET_OBJECT_HEADING target3_round2_bankjob2 slot3_heading_round2_bankjob2
			flag_target3_dead_round2_bankjob2 = 0
			target3_round2_removed_bankjob2 = 0
			timer_start_targ3_round2_bankjob2 = 0
			flag_slot3_round2_filled_bankjob2 = 1
		ENDIF
		
	ENDIF			

	IF flag_slot3_round2_filled_bankjob2 = 1

		IF flag_target3_dead_round2_bankjob2 = 0
		AND target3_round2_removed_bankjob2 = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target3_round2_bankjob2  
   				GET_OBJECT_COORDINATES target3_round2_bankjob2 targ3_round2_x_bankjob2 targ3_round2_y_bankjob2 targ3_round2_z_bankjob2

				IF timer_start_targ3_round2_bankjob2 = 0
				
					IF targ3_round2_y_bankjob2 < 1276.80 // 1277.37
  						targ3_round2_y_bankjob2 = targ3_round2_y_bankjob2 +@ 0.02
					ELSE

						IF timer_start_targ3_round2_bankjob2 = 0
							GET_GAME_TIMER game_time_round2_bankjob2
							time_targ3_round2_in_posit_bankjob2 = game_time_round2_bankjob2  
							timer_start_targ3_round2_bankjob2 = 1
						ENDIF

					ENDIF

				ENDIF
				
				IF timer_start_targ3_round2_bankjob2 = 1
					delete_targ3_round2_time_bankjob2 = game_time_round2_bankjob2 - time_targ3_round2_in_posit_bankjob2
										
					IF delete_targ3_round2_time_bankjob2 >= 1500
						
						IF targ3_round2_y_bankjob2 > 1275.01
  							targ3_round2_y_bankjob2 = targ3_round2_y_bankjob2 -@ 0.02
						ELSE
							DELETE_OBJECT target3_round2_bankjob2
							create_timer_targ3_round2_bankjob2 = 0
							flag_slot3_round2_filled_bankjob2 = 0
							target3_round2_removed_bankjob2 = 1
						ENDIF
						
					ENDIF
					
				ENDIF
				
				IF target3_round2_removed_bankjob2 = 0	
				AND flag_target3_dead_round2_bankjob2 = 0 
					SET_OBJECT_COORDINATES target3_round2_bankjob2 targ3_round2_x_bankjob2 targ3_round2_y_bankjob2 targ3_round2_z_bankjob2
				ENDIF

 			ELSE

				IF target3_round2_removed_bankjob2 = 0

					IF HAS_OBJECT_BEEN_DAMAGED target3_round2_bankjob2
			 			++ counter_hits_scored_round2_bankjob2
						++ player_score_bankjob2
						DELETE_OBJECT target3_round2_bankjob2
						create_timer_targ3_round2_bankjob2 = 0
						flag_slot3_round2_filled_bankjob2 = 0
						flag_target3_dead_round2_bankjob2 = 1
					ENDIF
		
				ENDIF

			ENDIF
			
		ENDIF

	ENDIF
	
// Target4

	IF create_timer_targ4_round2_bankjob2 = 0
		GET_GAME_TIMER game_time_round2_bankjob2
		timer_create_targ4_round2_bankjob2 = game_time_round2_bankjob2
		create_timer_targ4_round2_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ4_round2_bankjob2 = 1 
		targ4_round2_movetime_bankjob2 = game_time_round2_bankjob2 - timer_create_targ4_round2_bankjob2
	ENDIF
	
	IF targ4_round2_movetime_bankjob2 >= 2800
	
		IF flag_slot4_round2_filled_bankjob2 = 0
			CREATE_OBJECT_NO_OFFSET tar_gun2 slot4_x_round2_bankjob2 slot4_y_round2_bankjob2 slot4_z_round2_bankjob2 target4_round2_bankjob2 
			SET_OBJECT_HEADING target4_round2_bankjob2 slot4_heading_round2_bankjob2
			flag_target4_dead_round2_bankjob2 = 0
			target4_round2_removed_bankjob2 = 0
			timer_start_targ4_round2_bankjob2 = 0
			flag_slot4_round2_filled_bankjob2 = 1
		ENDIF
		
	ENDIF			

	IF flag_slot4_round2_filled_bankjob2 = 1

		IF flag_target4_dead_round2_bankjob2 = 0
		AND target4_round2_removed_bankjob2 = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target4_round2_bankjob2  
   				GET_OBJECT_COORDINATES target4_round2_bankjob2 targ4_round2_x_bankjob2 targ4_round2_y_bankjob2 targ4_round2_z_bankjob2

				IF timer_start_targ4_round2_bankjob2 = 0
				
					IF targ4_round2_y_bankjob2 > 1276.80
  						targ4_round2_y_bankjob2 = targ4_round2_y_bankjob2 -@ 0.02
					ELSE

						IF timer_start_targ4_round2_bankjob2 = 0
							GET_GAME_TIMER game_time_round2_bankjob2
							time_targ4_round2_in_posit_bankjob2 = game_time_round2_bankjob2  
							timer_start_targ4_round2_bankjob2 = 1
						ENDIF

					ENDIF

				ENDIF
				
				IF timer_start_targ4_round2_bankjob2 = 1
					delete_targ4_round2_time_bankjob2 = game_time_round2_bankjob2 - time_targ4_round2_in_posit_bankjob2
										
					IF delete_targ4_round2_time_bankjob2 >= 1250
						
						IF targ4_round2_y_bankjob2 < 1281.10 // 1278.10
  							targ4_round2_y_bankjob2 = targ4_round2_y_bankjob2 +@ 0.02
						ELSE
							DELETE_OBJECT target4_round2_bankjob2
							create_timer_targ4_round2_bankjob2 = 0
							flag_slot4_round2_filled_bankjob2 = 0
							target4_round2_removed_bankjob2 = 1
						ENDIF
						
					ENDIF
					
				ENDIF
				
				IF target4_round2_removed_bankjob2 = 0	
				AND flag_target4_dead_round2_bankjob2 = 0 
					SET_OBJECT_COORDINATES target4_round2_bankjob2 targ4_round2_x_bankjob2 targ4_round2_y_bankjob2 targ4_round2_z_bankjob2
				ENDIF

 			ELSE

				IF target4_round2_removed_bankjob2 = 0

					IF HAS_OBJECT_BEEN_DAMAGED target4_round2_bankjob2
			 			++ counter_hits_scored_round2_bankjob2
						++ player_score_bankjob2
						DELETE_OBJECT target4_round2_bankjob2
						create_timer_targ4_round2_bankjob2 = 0
						flag_slot4_round2_filled_bankjob2 = 0
						flag_target4_dead_round2_bankjob2 = 1
					ENDIF
		
				ENDIF

			ENDIF
			
		ENDIF

	ENDIF

// Target5 Round2

	IF create_timer_targ5_round2_bankjob2 = 0
		GET_GAME_TIMER game_time_round2_bankjob2
		timer_create_targ5_round2_bankjob2 = game_time_round2_bankjob2
		create_timer_targ5_round2_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ5_round2_bankjob2 = 1 
		targ5_round2_movetime_bankjob2 = game_time_round2_bankjob2 - timer_create_targ5_round2_bankjob2
	ENDIF

	IF targ5_round2_movetime_bankjob2 >= 600
	
		IF flag_slot5_round2_filled_bankjob2 = 0
			CREATE_OBJECT_NO_OFFSET tar_gun1 slot5_x_round2_bankjob2 slot5_y_round2_bankjob2 slot5_z_round2_bankjob2 target5_round2_bankjob2 
			SET_OBJECT_HEADING target5_round2_bankjob2 slot5_heading_round2_bankjob2
			flag_target5_dead_round2_bankjob2 = 0
			target5_round2_removed_bankjob2 = 0
			timer_start_targ5_round2_bankjob2 = 0
			flag_slot5_round2_filled_bankjob2 = 1
		ENDIF
		
	ENDIF			

	IF flag_slot5_round2_filled_bankjob2 = 1

		IF flag_target5_dead_round2_bankjob2 = 0
		AND target5_round2_removed_bankjob2 = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target5_round2_bankjob2  
   				GET_OBJECT_COORDINATES target5_round2_bankjob2 targ5_round2_x_bankjob2 targ5_round2_y_bankjob2 targ5_round2_z_bankjob2

				IF timer_start_targ5_round2_bankjob2 = 0
				
					IF targ5_round2_y_bankjob2 > 1273.87
  						targ5_round2_y_bankjob2 = targ5_round2_y_bankjob2 -@ 0.02
					ELSE

						IF timer_start_targ5_round2_bankjob2 = 0
							GET_GAME_TIMER game_time_round2_bankjob2
							time_targ5_round2_in_posit_bankjob2 = game_time_round2_bankjob2  
							timer_start_targ5_round2_bankjob2 = 1
						ENDIF

					ENDIF

				ENDIF
				
				IF timer_start_targ5_round2_bankjob2 = 1
					delete_targ5_round2_time_bankjob2 = game_time_round2_bankjob2 - time_targ5_round2_in_posit_bankjob2
										
					IF delete_targ5_round2_time_bankjob2 >= 1500
						
						IF targ5_round2_y_bankjob2 < 1275.25
  							targ5_round2_y_bankjob2 = targ5_round2_y_bankjob2 +@ 0.02
						ELSE
							DELETE_OBJECT target5_round2_bankjob2
							create_timer_targ5_round2_bankjob2 = 0
							flag_slot5_round2_filled_bankjob2 = 0
							target5_round2_removed_bankjob2 = 1
						ENDIF
						
					ENDIF
					
				ENDIF
				
				IF target5_round2_removed_bankjob2 = 0	
				AND flag_target5_dead_round2_bankjob2 = 0 
					SET_OBJECT_COORDINATES target5_round2_bankjob2 targ5_round2_x_bankjob2 targ5_round2_y_bankjob2 targ5_round2_z_bankjob2
				ENDIF

 			ELSE

				IF target5_round2_removed_bankjob2 = 0

					IF HAS_OBJECT_BEEN_DAMAGED target5_round2_bankjob2
			 			++ counter_hits_scored_round2_bankjob2
						++ player_score_bankjob2
						DELETE_OBJECT target5_round2_bankjob2
						create_timer_targ5_round2_bankjob2 = 0
						flag_slot5_round2_filled_bankjob2 = 0
						flag_target5_dead_round2_bankjob2 = 1
					ENDIF
		
				ENDIF

			ENDIF
			
		ENDIF

	ENDIF
	
// Target6 Round2

	IF create_timer_targ6_round2_bankjob2 = 0
		GET_GAME_TIMER game_time_round2_bankjob2
		timer_create_targ6_round2_bankjob2 = game_time_round2_bankjob2
		create_timer_targ6_round2_bankjob2 = 1
	ENDIF
		  		
	IF create_timer_targ6_round2_bankjob2 = 1 
		targ6_round2_movetime_bankjob2 = game_time_round2_bankjob2 - timer_create_targ6_round2_bankjob2
	ENDIF

	IF targ6_round2_movetime_bankjob2 >= 2000
	
		IF flag_slot6_round2_filled_bankjob2 = 0
			CREATE_OBJECT_NO_OFFSET tar_gun1 slot6_x_round2_bankjob2 slot6_y_round2_bankjob2 slot6_z_round2_bankjob2 target6_round2_bankjob2 
			SET_OBJECT_HEADING target6_round2_bankjob2 slot6_heading_round2_bankjob2
			flag_target6_dead_round2_bankjob2 = 0
			target6_round2_removed_bankjob2 = 0
			timer_start_targ6_round2_bankjob2 = 0
			flag_slot6_round2_filled_bankjob2 = 1
		ENDIF
		
	ENDIF			

	IF flag_slot6_round2_filled_bankjob2 = 1

		IF flag_target6_dead_round2_bankjob2 = 0
		AND target6_round2_removed_bankjob2 = 0
	
			IF NOT HAS_OBJECT_BEEN_DAMAGED target6_round2_bankjob2  
   				GET_OBJECT_COORDINATES target6_round2_bankjob2 targ6_round2_x_bankjob2 targ6_round2_y_bankjob2 targ6_round2_z_bankjob2

				IF timer_start_targ6_round2_bankjob2 = 0
				
					IF targ6_round2_y_bankjob2 > 1270.67 //1271.82
  						targ6_round2_y_bankjob2 = targ6_round2_y_bankjob2 -@ 0.02
					ELSE

						IF timer_start_targ6_round2_bankjob2 = 0
							GET_GAME_TIMER game_time_round2_bankjob2
							time_targ6_round2_in_posit_bankjob2 = game_time_round2_bankjob2  
							timer_start_targ6_round2_bankjob2 = 1
						ENDIF

					ENDIF

				ENDIF
				
				IF timer_start_targ6_round2_bankjob2 = 1
					delete_targ6_round2_time_bankjob2 = game_time_round2_bankjob2 - time_targ6_round2_in_posit_bankjob2
										
					IF delete_targ6_round2_time_bankjob2 >= 500
						
						IF targ6_round2_y_bankjob2 < 1272.29
  							targ6_round2_y_bankjob2 = targ6_round2_y_bankjob2 +@ 0.02
						ELSE
							DELETE_OBJECT target6_round2_bankjob2
							create_timer_targ6_round2_bankjob2 = 0
							flag_slot6_round2_filled_bankjob2 = 0
							target6_round2_removed_bankjob2 = 1
						ENDIF
						
					ENDIF
					
				ENDIF
				
				IF target6_round2_removed_bankjob2 = 0	
				AND flag_target6_dead_round2_bankjob2 = 0 
					SET_OBJECT_COORDINATES target6_round2_bankjob2 targ6_round2_x_bankjob2 targ6_round2_y_bankjob2 targ6_round2_z_bankjob2
				ENDIF

 			ELSE

				IF target6_round2_removed_bankjob2 = 0

					IF HAS_OBJECT_BEEN_DAMAGED target6_round2_bankjob2
			 			++ counter_hits_scored_round2_bankjob2
						++ player_score_bankjob2
						DELETE_OBJECT target6_round2_bankjob2
						create_timer_targ6_round2_bankjob2 = 0
						flag_slot6_round2_filled_bankjob2 = 0
						flag_target6_dead_round2_bankjob2 = 1
					ENDIF
		
				ENDIF

			ENDIF
			
		ENDIF

	ENDIF
			
	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF
		
	CLEAR_WANTED_LEVEL player1
	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL ammo_round2_bankjob2
		
	IF timer_round2_bankjob2 = 0
	OR ammo_round2_bankjob2 = 0

		IF flag_time_out_round2_bank2 = 0
			timera = 0
			flag_time_out_round2_bank2 = 1
		ELSE
		
			IF timera > 200	
				PLAY_MISSION_AUDIO 1 // Area clear
				PRINT_NOW ( BNK2_3 ) 5000 1 //Area clear!"
				flag_round2_done_right_bankjob2 = 1
				round2_finished_bankjob2 = 1
			ENDIF

		ENDIF

	ENDIF
				
ENDWHILE

REMOVE_SOUND target_moving_sound_bank2

IF flag_round2_done_right_bankjob2 = 1

	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1 // Area clear

		WAIT 0

		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
			PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
			GOTO mission_bankjob2_failed
		ENDIF

		IF IS_CHAR_DEAD phil_bankjob2
			PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
			GOTO mission_bankjob2_failed
		ENDIF
		
	ENDWHILE

ENDIF

PRINT_WITH_NUMBER_BIG ( BJM2_6 ) counter_hits_scored_round2_bankjob2 5000 1 // targets hit round two

score_round2_bankjob2 = counter_hits_scored_round2_bankjob2

CLEAR_THIS_PRINT ( BNK2_3 )

ammo_used_round2_bankjob2 = ammo_given_round2_bankjob2 - ammo_round2_bankjob2

// removes the wepaon from the player1

DETACH_CHAR_FROM_CAR scplayer

SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 0 // SCFIX

SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED // SCFIX: move after detach since detach restores previous weapon

DELETE_OBJECT object2_bankjob2

SET_CHAR_COORDINATES scplayer -664.73 1269.09 9.81 
 
CLEAR_ONSCREEN_TIMER timer_round2_bankjob2

// *************************** PLAYER MOVES ON TO ROUND3  **********************************

PRINT_NOW ( BJM2_14 ) 5000 1 //"move to the next area!"

ADD_BLIP_FOR_COORD -677.75 1272.03 9.81 radar_blip_area3_bankjob2

LOAD_MISSION_AUDIO 1 ( BNK2_3 ) // Round clear
LOAD_MISSION_AUDIO 2 ( BNK2_2 ) // Aim

blob_flag = 1

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -677.75 1272.03 9.81 2.0 2.0 2.0 blob_flag
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2
	
	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
      			
ENDWHILE

REMOVE_BLIP radar_blip_area3_bankjob2

SET_PLAYER_CONTROL player1 OFF

SET_POLICE_IGNORE_PLAYER player1 ON

SET_EVERYONE_IGNORE_PLAYER player1 ON

WAIT 500

IF IS_CHAR_DEAD phil_bankjob2
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
	PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
	GOTO mission_bankjob2_failed
ENDIF

ATTACH_CHAR_TO_OBJECT scplayer object3_bankjob2 0.0 0.0 1.0 FACING_FORWARD 50.0 WEAPONTYPE_PISTOL
SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 30
ammo_given_round3_bankjob2 = 30

CLEAR_THIS_BIG_PRINT ( BJM2_6 )

DELETE_OBJECT target1_round2_bankjob2

DELETE_OBJECT target2_round2_bankjob2

DELETE_OBJECT target3_round2_bankjob2

DELETE_OBJECT target4_round2_bankjob2

DELETE_OBJECT target5_round2_bankjob2

DELETE_OBJECT target6_round2_bankjob2

// SCFIX: START - tidy up this big ass chunk
bank2_tutor_state = 0

WHILE bank2_tutor_state < 4
	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip3_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

	IF bank2_tutor_state = 0
		PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!
		timera = 0
		bank2_tutor_state = 1
	ENDIF

	IF bank2_tutor_state = 1
	AND timera >= 5000
		PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!
		timera = 0
		bank2_tutor_state = 2
	ENDIF

	IF bank2_tutor_state = 2
	AND timera >= 5000
		PRINT_NOW ( BJM2_27 ) 8000 1 //"All targets in this round are worth one point.
		timera = 0
		bank2_tutor_state = 3
	ENDIF

	IF bank2_tutor_state = 3
	AND timera >= 5000
		bank2_tutor_state = 4
	ENDIF
ENDWHILE

// SCFIX: END

/* SCFIX: all this was rewritten above
PRINT_NOW ( BJM2_19 ) 8000 1 //"Hit as many targets as you can in the time limit!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip3_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	
ENDWHILE 

PRINT_NOW ( BJM2_20 ) 8000 1 //"When you run out of time or ammo the round is over!

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip3_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

PRINT_NOW ( BJM2_27 ) 8000 1 //"All targets in this round are worth one point.

timera = 0

WHILE timera < 5000

	WAIT 0

	IF flag_played_bank2_before = 1

		IF IS_BUTTON_PRESSED PAD1 CROSS
		OR IS_BUTTON_PRESSED PAD1 START
			GOTO mission_skip3_bank2
		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE
*/

mission_skip3_bank2:

SET_PLAYER_CONTROL player1 ON

// ROUND2 PART2

PLAY_MISSION_AUDIO 2 // Fire
PRINT_NOW ( BNK2_2 ) 4000 1 //"AIM FIRE"

WHILE NOT HAS_MISSION_AUDIO_FINISHED 2

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
      
ENDWHILE

CLEAR_THIS_PRINT ( BNK2_2 ) // AIM FIRE

timerb = 0

DISPLAY_ONSCREEN_TIMER timer_round3_bankjob2 TIMER_DOWN

ADD_CONTINUOUS_SOUND -670.111 1291.234 10.818 SOUND_SHOOTING_RANGE_TARGET_MOVING_LOOP target_moving_sound_bank2

WHILE round3_finished_bankjob2 = 0 

	WAIT 0
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

// Radnom slots to move

	IF flag_choose_slots_bankjob2 = 0
		
		IF target1_to_move_this_time_bankjob2 = 0
			target_number_bankjob2 = 0
			GENERATE_RANDOM_INT_IN_RANGE 1 8 target_number_bankjob2
			targ_to_move1_bankjob2 = target_number_bankjob2 
			target1_to_move_this_time_bankjob2 = 1 
		ENDIF

		IF target1_to_move_this_time_bankjob2 = 1 

			IF target2_to_move_this_time_bankjob2 = 0
				target_number_bankjob2 = 0
				GENERATE_RANDOM_INT_IN_RANGE 1 8 target_number_bankjob2

				IF NOT target_number_bankjob2 = targ_to_move1_bankjob2  
					targ_to_move2_bankjob2 = target_number_bankjob2 
					target2_to_move_this_time_bankjob2 = 1
				ELSE
					target2_to_move_this_time_bankjob2 = 0
				ENDIF
			 
			ENDIF

		ENDIF

		IF target2_to_move_this_time_bankjob2 = 1 

			IF target3_to_move_this_time_bankjob2 = 0
				target_number_bankjob2 = 0
				GENERATE_RANDOM_INT_IN_RANGE 1 8 target_number_bankjob2

				IF NOT target_number_bankjob2 = targ_to_move1_bankjob2
				AND NOT target_number_bankjob2 = targ_to_move2_bankjob2  
					targ_to_move3_bankjob2 = target_number_bankjob2 
					target3_to_move_this_time_bankjob2 = 1
				ELSE
					target3_to_move_this_time_bankjob2 = 0
				ENDIF
			 
			ENDIF

		ENDIF
		
	ENDIF

	IF target1_to_move_this_time_bankjob2 = 1
	AND target2_to_move_this_time_bankjob2 = 1
	AND target3_to_move_this_time_bankjob2 = 1
		flag_choose_slots_bankjob2 = 1	
	ENDIF

	IF counter_slot_free_bankjob2 = 3
		slot7_filled_round3_bankjob2 = 0
		slot8_filled_round3_bankjob2 = 0
		slot9_filled_round3_bankjob2 = 0
		slot10_filled_round3_bankjob2 = 0
		slot11_filled_round3_bankjob2 = 0
		slot12_filled_round3_bankjob2 = 0
		slot13_filled_round3_bankjob2 = 0
		target9_round3_been_left_bank2 = 0
		target10_round3_been_left_bank2 = 0
		target11_round3_been_down_bank2 = 0
		target12_round3_been_left_bank2 = 0
		target13_round3_been_left_bank2 = 0
		target1_to_move_this_time_bankjob2 = 0
		target2_to_move_this_time_bankjob2 = 0
		target3_to_move_this_time_bankjob2 = 0
		flag_choose_slots_bankjob2 = 0
		counter_slot_free_bankjob2 = 0
	ENDIF
	
	IF IS_BUTTON_PRESSED PAD1 SQUARE
		round3_finished_bankjob2 = 1
	ENDIF

	//GET_GAME_TIMER game_time_round3_bankjob2

// Target checking stuff

// Target7 Round2

	IF flag_choose_slots_bankjob2 = 1 

		IF targ_to_move1_bankjob2 = 1
		OR targ_to_move2_bankjob2 = 1
		OR targ_to_move3_bankjob2 = 1

			IF slot7_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun2 slot7_round3_x_bankjob2 slot7_round3_y_bankjob2 slot7_round3_z_bankjob2 target7_round3_bankjob2 
				SET_OBJECT_HEADING target7_round3_bankjob2 0.0
				target7_round3_delete_bankjob2 = 0
				target7_round3_dead_bankjob2 = 0
				target7_round3_travel_bank2 = 0 // tells target to go left
				slot7_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot7_filled_round3_bankjob2 = 1

			IF target7_round3_dead_bankjob2 = 0
							
				IF NOT HAS_OBJECT_BEEN_DAMAGED target7_round3_bankjob2  
   					GET_OBJECT_COORDINATES target7_round3_bankjob2 targ7_round3_x_bankjob2 targ7_round3_y_bankjob2 targ7_round3_z_bankjob2
   				
					IF target7_round3_travel_bank2 = 0 

  						IF targ7_round3_x_bankjob2 <= -676.53
  							target7_round3_travel_bank2 = 1 // right
  						ELSE 
  							targ7_round3_x_bankjob2 = targ7_round3_x_bankjob2 -@ 0.03
  						ENDIF
	   
  					ELSE
		
   						IF targ7_round3_x_bankjob2 >= -674.16
   							target7_round3_delete_bankjob2 = 1  
   							target7_round3_travel_bank2 = 0 // left	  
   						ELSE
							targ7_round3_x_bankjob2 = targ7_round3_x_bankjob2 +@ 0.03
   						ENDIF

  					ENDIF

					IF target7_round3_delete_bankjob2 = 1
						DELETE_OBJECT target7_round3_bankjob2
						++ counter_slot_free_bankjob2
						target7_round3_dead_bankjob2 = 1
					ELSE 																	
						SET_OBJECT_COORDINATES target7_round3_bankjob2 targ7_round3_x_bankjob2 targ7_round3_y_bankjob2 targ7_round3_z_bankjob2
					ENDIF
								
				ELSE
					
					IF HAS_OBJECT_BEEN_DAMAGED target7_round3_bankjob2
						DELETE_OBJECT target7_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target7_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
			   				   		  		
  		ENDIF 
	
// Target 8

		IF targ_to_move1_bankjob2 = 2
		OR targ_to_move2_bankjob2 = 2
		OR targ_to_move3_bankjob2 = 2
			
			IF slot8_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun1 slot8_round3_x_bankjob2 slot8_round3_y_bankjob2 slot8_round3_z_bankjob2 target8_round3_bankjob2 
				SET_OBJECT_HEADING target8_round3_bankjob2 0.0
				target8_round3_delete_bankjob2 = 0
				target8_round3_dead_bankjob2 = 0
				target8_round3_travel_bank2 = 0 // tells target to go left
				slot8_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot8_filled_round3_bankjob2 = 1

			IF target8_round3_dead_bankjob2 = 0
				
				IF NOT HAS_OBJECT_BEEN_DAMAGED target8_round3_bankjob2  
   			   		GET_OBJECT_COORDINATES target8_round3_bankjob2 targ8_round3_x_bankjob2 targ8_round3_y_bankjob2 targ8_round3_z_bankjob2
   				
					IF target8_round3_travel_bank2 = 0 

  						IF targ8_round3_x_bankjob2 <= -677.95
							target8_round3_travel_bank2 = 1 // right
  						ELSE 
  							targ8_round3_x_bankjob2 = targ8_round3_x_bankjob2 -@ 0.04
  						ENDIF
	   
  					ELSE
		
   						IF targ8_round3_x_bankjob2 >= -673.46
   							target8_round3_delete_bankjob2 = 1   
   							target8_round3_travel_bank2 = 0 // left	  
   						ELSE
							targ8_round3_x_bankjob2 = targ8_round3_x_bankjob2 +@ 0.04
   						ENDIF

  					ENDIF

					IF target8_round3_delete_bankjob2 = 1
						DELETE_OBJECT target8_round3_bankjob2
						++ counter_slot_free_bankjob2
						target8_round3_dead_bankjob2 = 1
					ELSE	
						SET_OBJECT_COORDINATES target8_round3_bankjob2 targ8_round3_x_bankjob2 targ8_round3_y_bankjob2 targ8_round3_z_bankjob2
					ENDIF

				ELSE
					
					IF HAS_OBJECT_BEEN_DAMAGED target8_round3_bankjob2
						DELETE_OBJECT target8_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target8_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
	   		  		
  		ENDIF 
	
// target 9

		IF targ_to_move1_bankjob2 = 3
		OR targ_to_move2_bankjob2 = 3
		OR targ_to_move3_bankjob2 = 3
						

			IF slot9_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun1 slot9_round3_x_bankjob2 slot9_round3_y_bankjob2 slot9_round3_z_bankjob2 target9_round3_bankjob2 
				SET_OBJECT_HEADING target9_round3_bankjob2 0.0
				target9_round3_delete_bankjob2 = 0
				target9_round3_dead_bankjob2 = 0
				target9_round3_travel_bank2 = 0 // tells target to go left
				slot9_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot9_filled_round3_bankjob2 = 1

			IF target9_round3_dead_bankjob2 = 0
				
				IF NOT HAS_OBJECT_BEEN_DAMAGED target9_round3_bankjob2  
   					GET_OBJECT_COORDINATES target9_round3_bankjob2 targ9_round3_x_bankjob2 targ9_round3_y_bankjob2 targ9_round3_z_bankjob2
   				
					IF target9_round3_travel_bank2 = 0 

  						IF targ9_round3_x_bankjob2 <= -683.24

							IF target9_round3_been_left_bank2 = 1 
								target9_round3_delete_bankjob2 = 1
							ENDIF

  							target9_round3_travel_bank2 = 1 // right
						ELSE 
  							targ9_round3_x_bankjob2 = targ9_round3_x_bankjob2 -@ 0.06
  						ENDIF
	   
  					ELSE
		
   						IF targ9_round3_x_bankjob2 >= -680.49
   							target9_round3_travel_bank2 = 0 // left
   							target9_round3_been_left_bank2 = 1	  
   						ELSE
							targ9_round3_x_bankjob2 = targ9_round3_x_bankjob2 +@ 0.06
   						ENDIF

  					ENDIF

					IF target9_round3_delete_bankjob2 = 1
						DELETE_OBJECT target9_round3_bankjob2
						++ counter_slot_free_bankjob2
						target9_round3_dead_bankjob2 = 1
					ELSE	
						SET_OBJECT_COORDINATES target9_round3_bankjob2 targ9_round3_x_bankjob2 targ9_round3_y_bankjob2 targ9_round3_z_bankjob2
					ENDIF
								
				ELSE

					IF HAS_OBJECT_BEEN_DAMAGED target9_round3_bankjob2
						DELETE_OBJECT target9_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target9_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
   		  		
  		ENDIF 
	
// Target10

		IF targ_to_move1_bankjob2 = 4
		OR targ_to_move2_bankjob2 = 4
		OR targ_to_move3_bankjob2 = 4
			
			IF slot10_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun2 slot10_round3_x_bankjob2 slot10_round3_y_bankjob2 slot10_round3_z_bankjob2 target10_round3_bankjob2 
				SET_OBJECT_HEADING target10_round3_bankjob2 0.0
				target10_round3_delete_bankjob2 = 0
				target10_round3_dead_bankjob2 = 0
				target10_round3_travel_bank2 = 0 // tells target to go left
				slot10_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot10_filled_round3_bankjob2 = 1

			IF target10_round3_dead_bankjob2 = 0
	
				IF NOT HAS_OBJECT_BEEN_DAMAGED target10_round3_bankjob2  
   					GET_OBJECT_COORDINATES target10_round3_bankjob2 targ10_round3_x_bankjob2 targ10_round3_y_bankjob2 targ10_round3_z_bankjob2
   				
					IF target10_round3_travel_bank2 = 0 

  						IF targ10_round3_x_bankjob2 <= -683.73

							IF target10_round3_been_left_bank2 = 1
								target10_round3_delete_bankjob2 = 1
							ENDIF

  							target10_round3_travel_bank2 = 1 // right
  						ELSE 
  							targ10_round3_x_bankjob2 = targ10_round3_x_bankjob2 -@ 0.05
  						ENDIF
	   
  					ELSE
		
   						IF targ10_round3_x_bankjob2 >= -681.59
							target10_round3_travel_bank2 = 0 // left
							target10_round3_been_left_bank2 = 1	  
   						ELSE
							targ10_round3_x_bankjob2 = targ10_round3_x_bankjob2 +@ 0.05
   				   		ENDIF

  					ENDIF

					IF target10_round3_delete_bankjob2 = 1
						DELETE_OBJECT target10_round3_bankjob2
						++ counter_slot_free_bankjob2
						target10_round3_dead_bankjob2 = 1
					ELSE	
						SET_OBJECT_COORDINATES target10_round3_bankjob2 targ10_round3_x_bankjob2 targ10_round3_y_bankjob2 targ10_round3_z_bankjob2
					ENDIF
								
				ELSE

					IF HAS_OBJECT_BEEN_DAMAGED target10_round3_bankjob2
						DELETE_OBJECT target10_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target10_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
   		  		
  		ENDIF 
	
// Target 11

		IF targ_to_move1_bankjob2 = 5
		OR targ_to_move2_bankjob2 = 5
		OR targ_to_move3_bankjob2 = 5
			
			IF slot11_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun1 slot11_round3_x_bankjob2 slot11_round3_y_bankjob2 slot11_round3_z_bankjob2 target11_round3_bankjob2 
				SET_OBJECT_HEADING target11_round3_bankjob2 0.0
				target11_round3_delete_bankjob2 = 0
				target11_round3_dead_bankjob2 = 0
				target11_round3_travel_bank2 = 0 // tells target to go left
				slot11_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot11_filled_round3_bankjob2 = 1

			IF target11_round3_dead_bankjob2 = 0
	
				IF NOT HAS_OBJECT_BEEN_DAMAGED target11_round3_bankjob2  
   					GET_OBJECT_COORDINATES target11_round3_bankjob2 targ11_round3_x_bankjob2 targ11_round3_y_bankjob2 targ11_round3_z_bankjob2
   				
					IF target11_round3_travel_bank2 = 0 

  						IF targ11_round3_z_bankjob2 <= 8.0

							IF target11_round3_been_down_bank2 = 1
								target11_round3_delete_bankjob2 = 1
							ENDIF

  							target11_round3_travel_bank2 = 1 // UP
  						ELSE 
  							targ11_round3_z_bankjob2 = targ11_round3_z_bankjob2 -@ 0.06
  						ENDIF
	   
  					ELSE
		
   						IF targ11_round3_z_bankjob2 >= 15.0
   							target11_round3_travel_bank2 = 0 // DOWN
   							target11_round3_been_down_bank2 = 1	  
   						ELSE
							targ11_round3_z_bankjob2 = targ11_round3_z_bankjob2 +@ 0.06
   						ENDIF

  					ENDIF

					IF target11_round3_delete_bankjob2 = 1
						DELETE_OBJECT target11_round3_bankjob2
						++ counter_slot_free_bankjob2
						target11_round3_dead_bankjob2 = 1
					ELSE	
						SET_OBJECT_COORDINATES target11_round3_bankjob2 targ11_round3_x_bankjob2 targ11_round3_y_bankjob2 targ11_round3_z_bankjob2
					ENDIF

				ELSE

					IF HAS_OBJECT_BEEN_DAMAGED target11_round3_bankjob2
						DELETE_OBJECT target11_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target11_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
   		  		
  		ENDIF 
	
// Target 12

		IF targ_to_move1_bankjob2 = 6
		OR targ_to_move2_bankjob2 = 6
		OR targ_to_move3_bankjob2 = 6
			
			IF slot12_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun2 slot12_round3_x_bankjob2 slot12_round3_y_bankjob2 slot12_round3_z_bankjob2 target12_round3_bankjob2 
				SET_OBJECT_HEADING target12_round3_bankjob2 90.0
				target12_round3_delete_bankjob2 = 0
				target12_round3_dead_bankjob2 = 0
				target12_round3_travel_bank2 = 0 // tells target to go left
				slot12_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot12_filled_round3_bankjob2 = 1

			IF target12_round3_dead_bankjob2 = 0
	
				IF NOT HAS_OBJECT_BEEN_DAMAGED target12_round3_bankjob2  
   					GET_OBJECT_COORDINATES target12_round3_bankjob2 targ12_round3_x_bankjob2 targ12_round3_y_bankjob2 targ12_round3_z_bankjob2
	   				
					IF target12_round3_travel_bank2 = 0 

  						IF targ12_round3_y_bankjob2 <= 1279.42

							IF target12_round3_been_left_bank2 = 1
  								target12_round3_delete_bankjob2 = 1
							ENDIF

  							target12_round3_travel_bank2 = 1 // right
  						ELSE 
  							targ12_round3_y_bankjob2 = targ12_round3_y_bankjob2 -@ 0.05
  						ENDIF
	   
  					ELSE
		
   						IF targ12_round3_y_bankjob2 >= 1283.70
   							target12_round3_travel_bank2 = 0 // left
   							target12_round3_been_left_bank2 = 1	  
   						ELSE
							targ12_round3_y_bankjob2 = targ12_round3_y_bankjob2 +@ 0.05
   						ENDIF

  					ENDIF

					IF target12_round3_delete_bankjob2 = 1
						DELETE_OBJECT target12_round3_bankjob2
						++ counter_slot_free_bankjob2
						target12_round3_dead_bankjob2 = 1
					ELSE	
						SET_OBJECT_COORDINATES target12_round3_bankjob2 targ12_round3_x_bankjob2 targ12_round3_y_bankjob2 targ12_round3_z_bankjob2
					ENDIF
								
				ELSE

					IF HAS_OBJECT_BEEN_DAMAGED target12_round3_bankjob2
						DELETE_OBJECT target12_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target12_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
   		  		
  		ENDIF
	
// Target 13

		IF targ_to_move1_bankjob2 = 7
		OR targ_to_move2_bankjob2 = 7
		OR targ_to_move3_bankjob2 = 7
			
			IF slot13_filled_round3_bankjob2 = 0
				CREATE_OBJECT_NO_OFFSET tar_gun1 slot13_round3_x_bankjob2 slot13_round3_y_bankjob2 slot13_round3_z_bankjob2 target13_round3_bankjob2 
				SET_OBJECT_HEADING target13_round3_bankjob2 90.0
				target13_round3_delete_bankjob2 = 0
				target13_round3_dead_bankjob2 = 0
				target13_round3_travel_bank2 = 0 // tells target to go left
			   	slot13_filled_round3_bankjob2 = 1
			ENDIF

		ENDIF
	
		IF slot13_filled_round3_bankjob2 = 1

			IF target13_round3_dead_bankjob2 = 0
	
				IF NOT HAS_OBJECT_BEEN_DAMAGED target13_round3_bankjob2  
   					GET_OBJECT_COORDINATES target13_round3_bankjob2 targ13_round3_x_bankjob2 targ13_round3_y_bankjob2 targ13_round3_z_bankjob2
   				
					IF target13_round3_travel_bank2 = 0 

  						IF targ13_round3_y_bankjob2 <= 1277.80 //1282.51

							IF target13_round3_been_left_bank2 = 1
  								target13_round3_delete_bankjob2 = 1
  							ENDIF
  							 
  							target13_round3_travel_bank2 = 1 // right
  						ELSE 
  							targ13_round3_y_bankjob2 = targ13_round3_y_bankjob2 -@ 0.04
  						ENDIF
	   
  					ELSE
		
   						IF targ13_round3_y_bankjob2 >= 1282.51 //1277.80
   							target13_round3_travel_bank2 = 0 // left
   							target13_round3_been_left_bank2 = 1	  
   						ELSE
							targ13_round3_y_bankjob2 = targ13_round3_y_bankjob2 +@ 0.04
   						ENDIF

  					ENDIF

					IF target13_round3_delete_bankjob2 = 1
						DELETE_OBJECT target13_round3_bankjob2
						++ counter_slot_free_bankjob2
						target13_round3_dead_bankjob2 = 1
					ELSE	
						SET_OBJECT_COORDINATES target13_round3_bankjob2 targ13_round3_x_bankjob2 targ13_round3_y_bankjob2 targ13_round3_z_bankjob2
					ENDIF
								
				ELSE

					IF HAS_OBJECT_BEEN_DAMAGED target13_round3_bankjob2
						DELETE_OBJECT target13_round3_bankjob2
						++ counter_hits_scored_round3_bankjob2
						++ player_score_bankjob2
						++ counter_slot_free_bankjob2
						target13_round3_dead_bankjob2 = 1
					ENDIF
				
				ENDIF	 
						
			ENDIF
   		  		
  		ENDIF

	ENDIF

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF
		
	CLEAR_WANTED_LEVEL player1

	GET_AMMO_IN_PLAYER_WEAPON player1 WEAPONTYPE_PISTOL ammo_round3_bankjob2
	
	IF timer_round3_bankjob2 = 0 			
	OR ammo_round3_bankjob2 = 0

		IF flag_time_out_round3_bank2 = 0
			timera = 0
			flag_time_out_round3_bank2 = 1
		ELSE

			IF timera > 200
				PLAY_MISSION_AUDIO 1 // Area clear
				PRINT_NOW ( BNK2_3 ) 5000 1 //ARea clear!"
				flag_round3_done_right_bankjob2 = 1
				round3_finished_bankjob2 = 1
			ENDIF

		ENDIF

	ENDIF

ENDWHILE

REMOVE_SOUND target_moving_sound_bank2

IF flag_round3_done_right_bankjob2 = 1

	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

		WAIT 0

		IF IS_CHAR_DEAD phil_bankjob2
			PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
			GOTO mission_bankjob2_failed
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
			PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
			GOTO mission_bankjob2_failed
		ENDIF
		
	ENDWHILE

ENDIF

CLEAR_ONSCREEN_TIMER timer_round3_bankjob2

CLEAR_THIS_PRINT ( BNK2_3 )

ammo_used_round3_bankjob2 = ammo_given_round3_bankjob2 - ammo_round3_bankjob2

// removes the wepaon from the player1

SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED

SET_CAMERA_IN_FRONT_OF_PLAYER
								 
PRINT_WITH_NUMBER_BIG ( BJM2_28 ) counter_hits_scored_round3_bankjob2 4000 1 // targets hit round three

score_round3_bankjob2 = counter_hits_scored_round3_bankjob2 

CLEAR_ONSCREEN_COUNTER player_score_bankjob2

CLEAR_ONSCREEN_COUNTER score_to_beat_bankjob2

WAIT 4000

IF IS_CHAR_DEAD phil_bankjob2
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
	PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
	GOTO mission_bankjob2_failed
ENDIF

CLEAR_THIS_BIG_PRINT ( BJM2_6 )

PRINT_WITH_NUMBER_BIG ( BJM2_7 ) player_score_bankjob2 4000 1 // Score round 1 + 2 + 3

WAIT 4000

IF IS_CHAR_DEAD phil_bankjob2
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
	PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
	GOTO mission_bankjob2_failed
ENDIF

CLEAR_THIS_BIG_PRINT ( BJM2_7 )

// totals up players percentage of hits

total_ammo_used_bankjob2 = ammo_used_round1_bankjob2 + ammo_used_round2_bankjob2

final_ammo_used_bankjob2 = total_ammo_used_bankjob2 + ammo_used_round3_bankjob2

total_hits_bankjob2 = bits_hit_bank2 + score_round2_bankjob2

final_hits_bankjob2 = total_hits_bankjob2 + score_round3_bankjob2  

percentage_hits_bankjob2 = final_hits_bankjob2 * 100

IF total_ammo_used_bankjob2 > 0  
	percentage_hits_bankjob2 = percentage_hits_bankjob2 / final_ammo_used_bankjob2
ELSE
	percentage_hits_bankjob2 = 0
ENDIF	

PRINT_WITH_NUMBER_BIG ( BJM2_3 ) percentage_hits_bankjob2 4000 1 // percent hit rate

WAIT 4000

IF IS_CHAR_DEAD phil_bankjob2
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
	PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
	GOTO mission_bankjob2_failed
ENDIF

CLEAR_THIS_BIG_PRINT ( BJM2_3 )

DETACH_CHAR_FROM_CAR scplayer

SET_PLAYER_AMMO player1 WEAPONTYPE_PISTOL 0 // SCFIX

SET_CURRENT_PLAYER_WEAPON player1 WEAPONTYPE_UNARMED // SCFIX: move after detach since detach restores previous weapon

DELETE_OBJECT object3_bankjob2 

SET_CHAR_COORDINATES scplayer -677.75 1272.03 9.81 

// Player goes to talk to phil to see what he says

PRINT_NOW ( BJM2_17 ) 5000 1 //"Go and talk to Phil to see how he thought you did!"

ADD_BLIP_FOR_COORD -665.99 1234.17 10.08 radar_blip_coord4_bankjob2

blob_flag = 1

LOAD_MISSION_AUDIO 1 ( BNK2_7 ) // player 
LOAD_MISSION_AUDIO 2 ( BNK2_8 ) // Phil will help

WHILE NOT LOCATE_PLAYER_ON_FOOT_3D player1 -651.18 1260.08 9.82 3.0 3.0 6.0 FALSE
OR NOT HAS_MISSION_AUDIO_LOADED 1
OR NOT HAS_MISSION_AUDIO_LOADED 2 
										   
	WAIT 0
	
	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF
	
	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	
ENDWHILE

SET_FADING_COLOUR 0 0 0

DO_FADE 1000 FADE_OUT

IF NOT IS_CHAR_DEAD phil_bankjob2
	SET_CURRENT_CHAR_WEAPON phil_bankjob2 WEAPONTYPE_UNARMED
ELSE
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

SET_PLAYER_CONTROL player1 OFF

WHILE GET_FADING_STATUS

 	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF

ENDWHILE

CLEAR_PRINTS

SET_CURRENT_CHAR_WEAPON scplayer WEAPONTYPE_UNARMED

SWITCH_WIDESCREEN ON

DELETE_OBJECT target7_round3_bankjob2
DELETE_OBJECT target8_round3_bankjob2
DELETE_OBJECT target9_round3_bankjob2
DELETE_OBJECT target10_round3_bankjob2
DELETE_OBJECT target11_round3_bankjob2
DELETE_OBJECT target12_round3_bankjob2
DELETE_OBJECT target13_round3_bankjob2

SET_POLICE_IGNORE_PLAYER player1 ON
SET_EVERYONE_IGNORE_PLAYER player1 ON
GET_PLAYER_CHAR player1 scplayer
REMOVE_BLIP radar_blip_coord4_bankjob2

LOAD_SCENE -665.99 1234.17 9.08
CHAR_SET_IDLE scplayer
SET_CHAR_OBJ_NO_OBJ scplayer
SET_CHAR_COORDINATES scplayer -664.58 1233.74 10.10
SET_CHAR_HEADING scplayer 87.36
CHAR_SET_IDLE scplayer 

IF NOT IS_CHAR_DEAD phil_bankjob2 
	TURN_CHAR_TO_FACE_CHAR scplayer phil_bankjob2   
ELSE
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF

SET_FADING_COLOUR 0 0 0

IF NOT IS_CHAR_DEAD phil_bankjob2 
	TURN_CHAR_TO_FACE_CHAR phil_bankjob2 scplayer   
ELSE
	PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
	GOTO mission_bankjob2_failed
ENDIF 

DO_FADE 1000 FADE_IN

SET_FIXED_CAMERA_POSITION -662.67 1229.52 10.84 0.0 0.0 0.0
POINT_CAMERA_AT_POINT -663.27 1230.30 11.06 JUMP_CUT

WHILE GET_FADING_STATUS

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	
ENDWHILE 

PLAY_MISSION_AUDIO 1 // Player hasking
PRINT_NOW ( BNK2_7 ) 5000 1 //"So you fancy doing me a favour, and helping me put together a job?"
SET_CHAR_WAIT_STATE scplayer WAITSTATE_PLAYANIM_CHAT 1000000

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
					
ENDWHILE

SET_CHAR_WAIT_STATE scplayer WAITSTATE_FALSE 1
CLEAR_THIS_PRINT ( BNK2_7 )
LOAD_MISSION_AUDIO 1 ( BNK2_9 ) // Phil wont help

WHILE NOT HAS_MISSION_AUDIO_LOADED 1

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
	   	   		
ENDWHILE 

IF player_score_bankjob2 > score_to_beat_bankjob2
	PLAY_MISSION_AUDIO 2 // Phile will do it
	PRINT_NOW ( BNK2_8 ) 5000 1 //"Son, after shooting like that, if you asked me to be your wife, I'd say yes
	SET_CHAR_WAIT_STATE phil_bankjob2 WAITSTATE_PLAYANIM_CHAT 1000000 
ELSE
	PLAY_MISSION_AUDIO 1 // Phil wont help
	PRINT_NOW ( BNK2_9A ) 10000 1 //"Son, you better get your fancy talking and big ideas and shove 'em where there ain't no sun."
	SET_CHAR_WAIT_STATE phil_bankjob2 WAITSTATE_PLAYANIM_CHAT 1000000
ENDIF

IF player_score_bankjob2 > score_to_beat_bankjob2

	WHILE NOT HAS_MISSION_AUDIO_FINISHED 2
	
		WAIT 0

		IF IS_CHAR_DEAD phil_bankjob2
			CLEAR_THIS_PRINT ( BNK2_8 )
			CLEAR_THIS_PRINT ( BNK2_9A )
			CLEAR_THIS_PRINT ( BNK2_9B )
			PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
			GOTO mission_bankjob2_failed
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
			PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
			GOTO mission_bankjob2_failed
		ENDIF
					
	ENDWHILE

	IF NOT IS_CHAR_DEAD phil_bankjob2 
		SET_CHAR_WAIT_STATE phil_bankjob2 WAITSTATE_FALSE 1
	ELSE
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed	
	ENDIF

	CLEAR_THIS_PRINT ( BNK2_8 )

ELSE

	WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	
		WAIT 0

		IF IS_CHAR_DEAD phil_bankjob2
			CLEAR_THIS_PRINT ( BNK2_8 )
			CLEAR_THIS_PRINT ( BNK2_9A )
			CLEAR_THIS_PRINT ( BNK2_9B )
			PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
			GOTO mission_bankjob2_failed
		ENDIF

		IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
			PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
			GOTO mission_bankjob2_failed
		ENDIF
		
	ENDWHILE

	IF NOT IS_CHAR_DEAD phil_bankjob2 
		SET_CHAR_WAIT_STATE phil_bankjob2 WAITSTATE_FALSE 1
	ELSE
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed	
	ENDIF

	CLEAR_THIS_PRINT ( BNK2_9A )
	CLEAR_THIS_PRINT ( BNK2_9B )
	
ENDIF

SET_CHAR_OBJ_GOTO_COORD_ON_FOOT phil_bankjob2 -664.41 1228.08

timera = 0

WHILE NOT LOCATE_CHAR_ON_FOOT_2D phil_bankjob2 -664.41 1228.08 2.0 2.0 FALSE

	WAIT 0

	IF IS_CHAR_DEAD phil_bankjob2
		PRINT_NOW ( BJM2_11 ) 5000 1 //"Phil's dead!" 
		GOTO mission_bankjob2_failed
	ELSE

		IF timera >= 10000
			
			IF NOT LOCATE_CHAR_ON_FOOT_2D phil_bankjob2 -664.41 1228.08 2.0 2.0 FALSE
				SET_CHAR_COORDINATES phil_bankjob2 -664.41 1228.08 10.08
				GOTO mini_jump_bankjob2
			ENDIF

		ENDIF

	ENDIF

	IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1210.0 10.5 3.0 3.0 3.0 FALSE
		PRINT_NOW ( BJM2_22 ) 5000 1 //"You have left the competition!
		GOTO mission_bankjob2_failed
	ENDIF
		
ENDWHILE

mini_jump_bankjob2:

DELETE_CHAR phil_bankjob2  
SWITCH_WIDESCREEN OFF
RESTORE_CAMERA_JUMPCUT
SET_PLAYER_CONTROL player1 ON
SET_POLICE_IGNORE_PLAYER player1 OFF
SET_EVERYONE_IGNORE_PLAYER player1 OFF

IF player_score_bankjob2 > score_to_beat_bankjob2
	GOTO mission_bankjob2_passed	
ELSE
	GOTO mission_bankjob2_failed
ENDIF 

// ****************************************** Mission Failed *******************************

mission_bankjob2_failed:

PRINT_BIG ( M_FAIL ) 5000 1 //"Mission Failed!"

RETURN


   

// *************************************** Mission Passed **********************************

mission_bankjob2_passed:

flag_bankjob_mission2_passed = 1
SET_CAR_DENSITY_MULTIPLIER 1.0
REGISTER_MISSION_PASSED ( BANK_2 )
PLAYER_MADE_PROGRESS 1
PRINT_WITH_NUMBER_BIG ( M_PASS ) 2000 5000 1 //"Mission Passed!"
ADD_SCORE player1 2000
PLAY_MISSION_PASSED_TUNE 1
CLEAR_WANTED_LEVEL player1
REGISTER_HIGHEST_SCORE 0 player_score_bankjob2
REGISTER_HIGHEST_SCORE 1 percentage_hits_bankjob2
START_NEW_SCRIPT bankjob_mission3_loop
START_NEW_SCRIPT shoot_range_loop

RETURN
	


// *************************************** Mission Cleanup *********************************

mission_cleanup_bankjob2:

REMOVE_SOUND target_moving_sound_bank2
REMOVE_CHAR_ELEGANTLY phil_bankjob2 
REMOVE_CHAR_ELEGANTLY gunner1_bankjob2 // SCFIX

DELETE_OBJECT target1_frame_bankjob2
DELETE_OBJECT target1_part1_bankjob2
DELETE_OBJECT target1_part2_bankjob2
DELETE_OBJECT target1_part3_bankjob2
DELETE_OBJECT target1_part4_bankjob2
DELETE_OBJECT target1_part5_bankjob2
DELETE_OBJECT target2_frame_bankjob2
DELETE_OBJECT target2_part1_bankjob2
DELETE_OBJECT target2_part2_bankjob2
DELETE_OBJECT target2_part3_bankjob2
DELETE_OBJECT target2_part4_bankjob2
DELETE_OBJECT target2_part5_bankjob2
DELETE_OBJECT target3_frame_bankjob2
DELETE_OBJECT target3_part1_bankjob2
DELETE_OBJECT target3_part2_bankjob2
DELETE_OBJECT target3_part3_bankjob2
DELETE_OBJECT target3_part4_bankjob2
DELETE_OBJECT target3_part5_bankjob2

DELETE_OBJECT target1_round2_bankjob2
DELETE_OBJECT target2_round2_bankjob2
DELETE_OBJECT target3_round2_bankjob2
DELETE_OBJECT target4_round2_bankjob2
DELETE_OBJECT target5_round2_bankjob2
DELETE_OBJECT target6_round2_bankjob2
DELETE_OBJECT target7_round3_bankjob2
DELETE_OBJECT target8_round3_bankjob2
DELETE_OBJECT target9_round3_bankjob2
DELETE_OBJECT target10_round3_bankjob2
DELETE_OBJECT target11_round3_bankjob2
DELETE_OBJECT target12_round3_bankjob2
DELETE_OBJECT target13_round3_bankjob2

DETACH_CHAR_FROM_CAR scplayer

IF slot4_ammo_bank2 > 0
	//REQUEST_MODEL slot4_model_bank2 // SCFIX: removed now, we leave the model loaded
	
	//LOAD_ALL_MODELS_NOW // SCFIX: removed now, we leave the model loaded

	GIVE_WEAPON_TO_PLAYER player1 slot4_weapon_type_bank2 slot4_ammo_bank2 // SCFIX: moved into if block
	
	IF NOT slot4_model_bank2 = COLT45 // SCFIX: COLT45 will be unloaded below
		MARK_MODEL_AS_NO_LONGER_NEEDED slot4_model_bank2 // SCFIX: moved into if block
	ENDIF // SCFIX

	SET_PLAYER_AMMO player1 slot4_weapon_type_bank2 slot4_ammo_bank2 // SCFIX: make sure we aren't duping ammo
ENDIF

flag_player_on_mission = 0
flag_player_on_bank_2 = 0 // Used for interior loading stuff
SHUT_PLAYER_UP player1 FALSE
REMOVE_SPHERE sphere_bankjob2
DELETE_OBJECT object1_bankjob2
DELETE_OBJECT object2_bankjob2
DELETE_OBJECT object3_bankjob2
REMOVE_BLIP radar_blip_coord2_bankjob2
REMOVE_BLIP radar_blip_coord3_bankjob2
REMOVE_BLIP radar_blip_coord4_bankjob2
REMOVE_BLIP radar_blip_area3_bankjob2
CLEAR_ONSCREEN_COUNTER player_score_bankjob2
CLEAR_ONSCREEN_COUNTER score_to_beat_bankjob2
CLEAR_ONSCREEN_TIMER timer_round1_bankjob2
CLEAR_ONSCREEN_TIMER timer_round2_bankjob2
CLEAR_ONSCREEN_TIMER timer_round3_bankjob2
//MARK_MODEL_AS_NO_LONGER_NEEDED MALE01 // SCFIX: not used anymore
MARK_MODEL_AS_NO_LONGER_NEEDED COLT45
MARK_MODEL_AS_NO_LONGER_NEEDED tar_gun1
MARK_MODEL_AS_NO_LONGER_NEEDED tar_gun2
MARK_MODEL_AS_NO_LONGER_NEEDED tar_frame
MARK_MODEL_AS_NO_LONGER_NEEDED tar_downleft
MARK_MODEL_AS_NO_LONGER_NEEDED tar_downright
MARK_MODEL_AS_NO_LONGER_NEEDED tar_top
MARK_MODEL_AS_NO_LONGER_NEEDED tar_upleft
MARK_MODEL_AS_NO_LONGER_NEEDED tar_upright
MARK_MODEL_AS_NO_LONGER_NEEDED faketarget
UNLOAD_SPECIAL_CHARACTER 4 // SCFIX: cutscene ped used in gameplay now
UNLOAD_SPECIAL_CHARACTER 5
GET_GAME_TIMER timer_mobile_start
MISSION_HAS_FINISHED
RETURN

}