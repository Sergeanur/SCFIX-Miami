MISSION_START

// ********** DECLARE VARIABLES *************************************

VAR_INT	wanted_interior
VAR_INT	flag_player_in_bank 
VAR_INT	flag_player_in_malibu 
VAR_INT	flag_player_in_cop_shop 
VAR_INT	flag_player_in_shooting_range
VAR_INT flag_player_in_cafe
VAR_INT flag_player_in_apartment3c
VAR_INT flag_player_in_mansion

VAR_INT	flag_eject 

//VAR_INT flag_bank_job
VAR_INT flag_player_on_lawyer_2
VAR_INT flag_player_on_counter_1
VAR_INT flag_player_on_bank_2
VAR_INT flag_kent_mission_active
VAR_INT flag_player_on_bank1_mission
VAR_INT flag_player_control
VAR_INT flag_membership
VAR_INT flag_player_on_colonel1_mission	flag_open_mansion

VAR_INT flag_player_in_stripclub flag_player_in_mall player_car_interiors
VAR_INT flag_strip_doors_closed flag_strip_doors_open strip_doors

VAR_INT flag_cop_doors_closed flag_cop_doors_open cop_doors
VAR_INT flag_malibu_doors_closed flag_malibu_doors_open malibu_doors

VAR_INT flag_strip_populate
VAR_INT ped_routine_1 ped_routine_2 ped_routine_3 ped_routine_4 ped_routine_5
//VAR_INT ped_routine_6 ped_routine_7 ped_routine_8 ped_routine_9 ped_routine_10

VAR_INT s_punter_1 s_punter_2 s_punter_3 s_punter_4
VAR_INT s_punter_5 s_punter_6 //s_punter_7 s_punter_8

VAR_INT bar_staff1 bar_staff2 flag_arm_barstaff
VAR_INT bouncer_1 bouncer_2 bouncer_3 bouncer_4
VAR_INT	flag_launch_bouncers flag_arm_bouncers
VAR_INT ped_rumble ped_flee	//ped_cancel_wait
VAR_INT door_man1 door_man2	flag_create_doorman flag_launch_doorman

VAR_INT dancer_1 dancer_2 dancer_3 dancer_4
VAR_INT dancer_5 dancer_6 dancer_7 dancer_8
VAR_INT dancer_9 dancer_10 dancer_11 dancer_12
VAR_INT dancer_13 dancer_14 dancer_15 dancer_16
VAR_INT dancer_17 dancer_18 dancer_19 dancer_20
VAR_INT dancer_21 dancer_22 dancer_23 dancer_24
VAR_INT dancer_25 dancer_26 dancer_27 dancer_28
VAR_INT dancer_29 dancer_30
VAR_INT club_owner
VAR_INT flag_arm_dancer2

VAR_INT jobby_1 jobby_2 jobby_3 jobby_4
VAR_INT jobby_5 jobby_6 jobby_7 jobby_8
VAR_INT jobby_9 stroop weapon_strip

VAR_INT flag_player_on_rc_mission //enables interiors to handle RC vehicles

//VAR_INT testblip_1 testblip_2 testblip_3 testblip_4
//VAR_INT testblip_5 testblip_6 testblip_7 testblip_8

VAR_INT timer_populate_start //flag_ws_set_once timer_populate_now timer_populate_lapsed

VAR_INT counter_tittycash_spent counter_strip_cam
VAR_INT flag_player_in_hotel

VAR_INT flag_malibu_populate counter_dancers var_dancer 	flag_bought_malibu
VAR_INT flag_ymca //var_pedstat

VAR_INT	flag_interiors_cleanup

VAR_INT pooz_counter
VAR_INT flag_strip_asset_cutscene private_dancer
VAR_INT counter_private_dancer
 
//VAR_FLOAT dancefloor_x dancefloor_y dancefloor_z
VAR_FLOAT dancer_x dancer_y dancer_z
VAR_FLOAT radial_float radius	//radial_step radius_increment
VAR_FLOAT float_heading

//VAR_INT flag_shooting_range_blob
//VAR_FLOAT 

// ********** SET FLAGS AND VARIABLES *******************************

wanted_interior = 0
//flag_player_inside = 0
flag_player_on_bank_2 = 0
flag_player_on_bank1_mission = 0
flag_player_on_colonel1_mission = 0
//flag_player_on_kent_1 = 0
flag_player_on_lawyer_2 = 0
flag_player_on_counter_1 = 0
flag_kent_mission_active = 0

flag_player_in_stripclub = 0
flag_player_in_mall = 0
flag_player_in_hotel = 0
flag_player_in_shooting_range = 0
flag_player_in_cop_shop = 0
flag_player_in_cafe = 0
flag_player_in_mansion = 0
flag_player_in_malibu = 0
flag_player_in_bank = 0
flag_player_in_apartment3c = 0

flag_open_mansion = 0

flag_strip_doors_open = 0
flag_strip_doors_closed = 0
flag_cop_doors_open = 0
flag_cop_doors_closed = 0
flag_malibu_doors_closed = 0
flag_malibu_doors_open = 0

flag_strip_populate = 0
//flag_ws_set_once = 0

flag_launch_bouncers = 0
flag_arm_barstaff = 0
flag_arm_dancer2 = 0
flag_membership = 0
//flag_membership = 1 // TEST TO COME OUT!!!
flag_arm_bouncers = 0

flag_create_doorman = 0
flag_launch_doorman = 0

counter_tittycash_spent = 0
counter_strip_cam = 0

flag_malibu_populate = 0

//dancefloor_x = 477.0
//dancefloor_y = -64.7
//dancefloor_z = 9.98

dancer_z = 9.0
radial_float = 0.0
radius = 0.0

counter_dancers = 0
flag_bought_malibu = 0
flag_ymca = 0

flag_interiors_cleanup = 0
//flag_stripper_create = 0
flag_strip_asset_cutscene = 0

pooz_counter = 0
counter_private_dancer = 0

flag_player_on_rc_mission = 0


// ********** MAIN SCRIPT *******************************************

SCRIPT_NAME	INTERIO

SET_DEATHARREST_STATE OFF //stops script being terminated if Player dies/arrested


mission_start_interiors:

{
	START_NEW_SCRIPT interiors
	//START_NEW_SCRIPT airport_security
	//START_NEW_SCRIPT aport2_security
	START_NEW_SCRIPT force_extra_colors_script // SCFIX

	MISSION_END
}
  


interiors:

flag_eject = 0
{
SCRIPT_NAME SHIT



GOTO bingle_bongle
CREATE_OBJECT_NO_OFFSET stripclbdropen 97.203 -1469.731 10.578 strip_doors
CREATE_OBJECT_NO_OFFSET od_clbdr_open 490.34 -77.017 11.598 malibu_doors
CREATE_OBJECT_NO_OFFSET cop_dr_closed 396.545 -472.883 12.6 cop_doors
CREATE_OBJECT_NO_OFFSET strpbckdrclsd 68.988 -1444.242 10.727 strip_door_poledance
bingle_bongle:

VAR_INT flag_is_in_transition1
flag_is_in_transition1 = 0

interiors_inner:

	WAIT 0
	++ pooz_counter

		// **************************** THE STRIP CLUB ********************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF pooz_counter = 1
				IF IS_PLAYER_IN_ZONE player1 BEACH1
				OR flag_player_on_rc_mission = 1
					IF flag_membership = 1 
						IF flag_player_on_mission = 0
							IF flag_strip_doors_open = 0
								DELETE_OBJECT strip_doors 
								CREATE_OBJECT_NO_OFFSET stripclbdropen 97.203 -1469.731 10.578 strip_doors
								DONT_REMOVE_OBJECT strip_doors
								flag_strip_doors_open = 1
								flag_strip_doors_closed = 0
							ENDIF
						ELSE
							IF flag_strip_doors_closed = 0
								DELETE_OBJECT strip_doors 
								CREATE_OBJECT_NO_OFFSET stripclbdrclsd 97.203 -1469.731 10.578 strip_doors
								DONT_REMOVE_OBJECT strip_doors
								flag_strip_doors_closed	= 1
								flag_strip_doors_open = 0
							ENDIF
						ENDIF
						IF IS_PLAYER_PLAYING player1
							IF flag_player_in_stripclub = 0
							AND flag_player_on_mission = 0
								IF IS_PLAYER_IN_REMOTE_MODE player1
									GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
									IF NOT IS_CAR_DEAD player_car_interiors
										IF LOCATE_CAR_3D player_car_interiors 95.3 -1468.3 9.5 1.5 1.5 3.0 FALSE
											BLOW_UP_RC_BUGGY
										ENDIF
									ENDIF
								ELSE
									IF LOCATE_PLAYER_ANY_MEANS_3D player1 95.3 -1468.3 9.5 1.5 1.5 3.0 FALSE

										IF IS_PLAYER_IN_ANY_CAR player1
										AND NOT IS_PLAYER_ON_ANY_BIKE player1
										AND NOT IS_PLAYER_IN_MODEL player1 CADDY
											GOTO interiors_inner
										ENDIF
										flag_player_in_stripclub = 1
										PRINT_BIG ( STRIP ) 3000 2 //"The Malibu1"
										GOSUB transition_1
										IF IS_PLAYER_PLAYING player1
											IF IS_PLAYER_ON_ANY_BIKE player1
											OR IS_PLAYER_IN_MODEL player1 CADDY
												STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
												WARP_PLAYER_FROM_CAR_TO_COORD player1 91.2 -1460.9 10.0
												DELETE_CAR player_car_interiors
											ENDIF
										ENDIF
										IF IS_AUSTRALIAN_GAME
											GET_CHAR_WEAPON_IN_SLOT scplayer 1 jobby_1 ammo_slot_1 weapon_model_slot_1
											GET_CHAR_WEAPON_IN_SLOT scplayer 2 jobby_2 ammo_slot_2 weapon_model_slot_2
											GET_CHAR_WEAPON_IN_SLOT scplayer 3 jobby_3 ammo_slot_3 weapon_model_slot_3
											GET_CHAR_WEAPON_IN_SLOT scplayer 4 jobby_4 ammo_slot_4 weapon_model_slot_4
											GET_CHAR_WEAPON_IN_SLOT scplayer 5 jobby_5 ammo_slot_5 weapon_model_slot_5
											GET_CHAR_WEAPON_IN_SLOT scplayer 6 jobby_6 ammo_slot_6 weapon_model_slot_6
											GET_CHAR_WEAPON_IN_SLOT scplayer 7 jobby_7 ammo_slot_7 weapon_model_slot_7
											GET_CHAR_WEAPON_IN_SLOT scplayer 8 jobby_8 ammo_slot_8 weapon_model_slot_8
											GET_CHAR_WEAPON_IN_SLOT scplayer 9 jobby_9 ammo_slot_9 weapon_model_slot_9

											REMOVE_ALL_PLAYER_WEAPONS player1
										ENDIF
	

										IF flag_eject = 0
											SET_AREA_VISIBLE VIS_STRIP_CLUB
											LOAD_SCENE 91.2  -1460.9 10.6
											SET_PLAYER_COORDINATES player1 91.2 -1460.9 10.0
											SET_PLAYER_HEADING player1 40.0
											//SET_CAMERA_IN_FRONT_OF_PLAYER
											SET_EXTRA_COLOURS 2 FALSE
											SET_CAR_DENSITY_MULTIPLIER 0.1
											SWITCH_RUBBISH OFF
										ELSE
											GOTO interiors_inner
										ENDIF
										GOSUB transition_2
									ENDIF
								ENDIF
							ENDIF

							IF flag_player_in_stripclub = 1
								IF LOCATE_PLAYER_ANY_MEANS_3D	player1 92.23 -1463.1 9.5 1.5 1.5 3.0 FALSE
									IF IS_PLAYER_IN_ANY_CAR player1
									//AND NOT IS_PLAYER_ON_ANY_BIKE player1
										GOTO interiors_inner
									ENDIF
									PRINT_BIG ( BEACH1 ) 3000 2 //"The Malibu1"
									GOSUB transition_1
									IF flag_eject = 0
										flag_player_in_stripclub = 0
										GOSUB outgoing
										CLEAR_AREA 97.7  -1472.2 10.5 1.0 FALSE
										LOAD_SCENE 97.7  -1472.2 10.5
										SET_PLAYER_COORDINATES player1 97.7  -1472.2 9.7
										SET_PLAYER_HEADING player1 280.0
										SET_CAMERA_IN_FRONT_OF_PLAYER
										
										IF IS_AUSTRALIAN_GAME
											GET_CHAR_WEAPON_IN_SLOT scplayer 1 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_1
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_1 ammo_slot_1
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 2 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_2
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_2 ammo_slot_2
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 3 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_3
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_3 ammo_slot_3
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 4 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_4
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_4 ammo_slot_4
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 5 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_5
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_5 ammo_slot_5
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 6 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_6
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_6 ammo_slot_6
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 7 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_7
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_7 ammo_slot_7
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 8 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_8
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_8 ammo_slot_8
												ENDIF
												GOSUB aussie2
											ENDIF
											GET_CHAR_WEAPON_IN_SLOT scplayer 9 stroop stroop weapon_strip
											IF NOT weapon_strip = WEAPONTYPE_UNARMED
												weapon_strip = weapon_model_slot_9
												GOSUB aussie
												IF IS_PLAYER_PLAYING player1
													GIVE_WEAPON_TO_PLAYER player1 jobby_9 ammo_slot_9
												ENDIF
												GOSUB aussie2
											ENDIF
										ENDIF
										
									ELSE
										GOTO interiors_inner
									ENDIF
									GOSUB transition_2
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
		
		// ******************************* HOTEL **************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF pooz_counter = 2
				IF IS_PLAYER_IN_ZONE player1 BEACH1
				OR flag_player_on_rc_mission = 1
					IF flag_player_in_hotel = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 229.5 -1277.7 11.5 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF IS_PLAYER_IN_AREA_3D player1 222.0 -1274.0 11.0 229.0 -1280.7 14.0 FALSE 
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( HOTEL ) 3000 2 //"The Malibu1"
								GOSUB transition_1
								IF IS_PLAYER_PLAYING player1
									IF IS_PLAYER_ON_ANY_BIKE player1
										STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
										WARP_PLAYER_FROM_CAR_TO_COORD player1 225.0 -1277.3 11.5
										DELETE_CAR player_car_interiors
									ENDIF
								ENDIF
								IF flag_eject = 0
									flag_player_in_hotel = 1
									SET_AREA_VISIBLE VIS_HOTEL
									SWITCH_RUBBISH OFF
									LOAD_SCENE 225.0 -1277.3 12.0
									SET_PLAYER_COORDINATES player1 225.0 -1277.3 11.5
									SET_PLAYER_HEADING player1 80.0
									SET_EXTRA_COLOURS 3 FALSE
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_hotel = 1
						IF IS_PLAYER_IN_AREA_3D player1 235.0 -1274.0 11.0 227.5.0 -1280.7 16.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH1 ) 3000 2 //"Ocean Drive"
							GOSUB transition_1
							IF flag_eject = 0
								GOSUB outgoing
								flag_player_in_hotel = 0
								CLEAR_AREA 233.5  -1278.45 11.0 1.0 FALSE
								LOAD_SCENE 233.5  -1278.45 11.0
								SET_PLAYER_COORDINATES player1 233.5  -1278.45 11.0
								SET_PLAYER_HEADING player1 270.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
			
		// ******************************* SCAR FACE **************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF pooz_counter = 1
				IF IS_PLAYER_IN_ZONE player1 BEACH1
				OR flag_player_on_rc_mission = 1
					IF flag_player_in_apartment3c = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 26.73 -1329.8 13.0 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D	player1 26.95 -1328.3 13.0 1.0 1.0 2.0 FALSE
								IF IS_PLAYER_PLAYING player1
									IF IS_PLAYER_ON_ANY_BIKE player1
									//OR IS_PLAYER_IN_MODEL player1 CADDY
										STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
										WARP_PLAYER_FROM_CAR_TO_COORD player1 27.19 -1327.0 12.0
										DELETE_CAR player_car_interiors
									ENDIF
								ENDIF
								IF IS_PLAYER_IN_ANY_CAR player1
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( SCARF ) 3000 2 //"The Malibu1"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_apartment3c = 1
									SET_AREA_VISIBLE VIS_BIKER_BAR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 27.19 -1327.0 12.0
									SET_PLAYER_COORDINATES player1 27.19 -1327.0 12.0
									SET_PLAYER_HEADING player1 23.0
									SET_EXTRA_COLOURS 3 FALSE
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_apartment3c = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D	player1 26.73 -1329.8 13.0 1.0 1.0 2.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH1 ) 3000 2 //"The Malibu1"
							GOSUB transition_1
							IF flag_eject = 0
								GOSUB outgoing
								flag_player_in_apartment3c = 0
								CLEAR_AREA 27.33 -1331.1 11.8 1.0 FALSE
								LOAD_SCENE 27.33 -1331.1 11.8
								SET_PLAYER_COORDINATES player1 27.33 -1331.1 11.8
								SET_PLAYER_HEADING player1 160.0
								SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
		
		// **************************** THE POLICE HQ ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH2
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 1
					IF flag_player_on_mission = 0
					OR flag_player_on_bank1_mission = 1
					OR flag_player_on_colonel1_mission = 1
						IF flag_cop_doors_open = 0
							DELETE_OBJECT cop_doors
							CREATE_OBJECT_NO_OFFSET cop_dr_open 396.458 -473.047 12.6 cop_doors
							DONT_REMOVE_OBJECT cop_doors
							flag_cop_doors_open = 1
							flag_cop_doors_closed = 0
						ENDIF
					ELSE
						IF flag_cop_doors_closed = 0
							DELETE_OBJECT cop_doors
							CREATE_OBJECT_NO_OFFSET cop_dr_closed 396.545 -472.883 12.6 cop_doors
							DONT_REMOVE_OBJECT cop_doors
							flag_cop_doors_closed = 1
							flag_cop_doors_open = 0
						ENDIF
					ENDIF
					IF IS_PLAYER_PLAYING player1
						IF flag_player_on_mission = 0
						OR flag_player_on_bank1_mission = 1
						OR flag_player_on_colonel1_mission = 1
							IF flag_player_in_cop_shop = 0
								IF IS_PLAYER_IN_REMOTE_MODE player1
									GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
									IF NOT IS_CAR_DEAD player_car_interiors
										IF LOCATE_CAR_3D player_car_interiors 397.0 -472.0 12.0 1.5 1.5 3.0 FALSE
											BLOW_UP_RC_BUGGY
										ENDIF
									ENDIF
								ELSE
									IF IS_PLAYER_IN_ANGLED_AREA_3D player1 399.0 -474.5 11.0 394.3 -470.8 14.5 2.5 FALSE
										IF IS_PLAYER_IN_ANY_CAR player1
										AND NOT IS_PLAYER_ON_ANY_BIKE player1
											GOTO interiors_inner
										ENDIF
										PRINT_BIG ( POL_HQ ) 3000 2 //"Diaz's Mansion"
										GOSUB transition_1
										IF IS_PLAYER_PLAYING player1
											IF IS_PLAYER_ON_ANY_BIKE player1
												STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
												WARP_PLAYER_FROM_CAR_TO_COORD player1 393.8 -475.8 11.4
												DELETE_CAR player_car_interiors
											ENDIF
										ENDIF
										IF flag_eject = 0
											SET_AREA_VISIBLE VIS_POLICE_STATION
											flag_player_in_cop_shop = 1
											IF flag_player_on_bank1_mission = 0
												SET_ZONE_PED_INFO STREET2 DAY   (14) 0 0 0 0 0 0 0 0 0 1000   
											    SET_ZONE_PED_INFO STREET2 NIGHT (16) 0 0 0 0 0 0 0 0 0 1000
												SWITCH_PED_ROADS_ON 354.9 -483.1 21.0 406.0 -490.0 0.0
												SWITCH_PED_ROADS_ON 376.66 -453.85 -10.0 328.91 -504.02 30.0 //Cop Shop (Used in bank1)
												CLEAR_AREA 400.0 -486.5 10.0 5.0 TRUE
											ENDIF
											SWITCH_RUBBISH OFF
											LOAD_SCENE 393.8 -475.8 11.4
											SET_PLAYER_COORDINATES player1 393.8 -475.8 11.4
											SET_PLAYER_HEADING player1 137.0
											SET_EXTRA_COLOURS 5 FALSE
											//SET_CAMERA_IN_FRONT_OF_PLAYER
										ELSE
											GOTO interiors_inner
										ENDIF
										GOSUB transition_2
									ENDIF
								ENDIF
							ENDIF
						ENDIF

						IF flag_player_in_cop_shop = 1
							IF IS_PLAYER_IN_ANGLED_AREA_3D player1 399.3 -472.9 11.0 394.8 -469.3 14.5 1.5 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( BEACH2 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									GOSUB outgoing
									SWITCH_PED_ROADS_OFF 354.9 -483.1 21.0 406.0 -490.0 10.0 // LOWER FLOOR
									CLEAR_AREA 399.38 -468.6 10.7 1.0 FALSE
									flag_player_in_cop_shop = 0
									//CLEAR_AREA_OF_CHARS MinX MinY MinZ MaxX MaxY MaxZ
									IF flag_player_on_bank1_mission = 0
										SET_ZONE_PED_INFO STREET2 DAY   (14) 0 0 0 0 0 0 0 0 0 20 //POLICE STATION  
									    SET_ZONE_PED_INFO STREET2 NIGHT (16) 0 0 0 0 0 0 0 0 0 10
										SWITCH_PED_ROADS_OFF 354.9 -483.1 21.0 406.0 -490.0 0.0
										SWITCH_PED_ROADS_OFF 376.66 -453.85 -10.00 328.91 -504.02 30.0 //Cop Shop (Used in bank1)
									ENDIF
									LOAD_SCENE 399.38 -468.6 10.7
									SET_PLAYER_COORDINATES player1 399.38 -468.6 10.7
									SET_PLAYER_HEADING player1 330.0
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
		
		// **************************** THE MALIBU ************************************************	   flag_malibu_doors_closed
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF pooz_counter = 1
				IF IS_PLAYER_IN_ZONE player1 BEACH3
				OR flag_player_on_rc_mission = 1
					
					IF flag_player_on_mission = 0
					//AND flag_kent_mission_active = 0
						IF flag_player_in_malibu = 0
							ground_z = 0.0000
							GET_GROUND_Z_FOR_3D_COORD 492.5 -76.17 10.5 ground_z
							IF ground_z > 0.0000
								IF flag_create_doorman = 0
									IF NOT IS_POINT_ON_SCREEN 489.6 -79.8 10.5 2.0
										IF NOT IS_POINT_ON_SCREEN 492.5 -76.17 10.5 2.0
											LOAD_SPECIAL_CHARACTER 15 BGb
											WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 15
												WAIT 0
												LOAD_SPECIAL_CHARACTER 15 BGb
											ENDWHILE
											CREATE_CHAR PEDTYPE_CIVMALE SPECIAL15 489.6 -79.8 10.5 door_man1
											SET_CHAR_HEADING door_man1 225.0
											SET_CHAR_PERSONALITY door_man1 PEDSTAT_PSYCHO
											SET_CHAR_HEALTH door_man1 200
											//ADD_ARMOUR_TO_CHAR door_man1 100
											CLEAR_CHAR_THREAT_SEARCH door_man1
											SET_CHAR_HEED_THREATS door_man1 TRUE
											SET_CHAR_PERSONALITY door_man1 PEDSTAT_STREET_GUY
										
											CREATE_CHAR PEDTYPE_CIVMALE SPECIAL15 492.5 -76.17 10.5 door_man2
											SET_CHAR_HEADING door_man2 225.0
											SET_CHAR_PERSONALITY door_man2 PEDSTAT_PSYCHO
											SET_CHAR_HEALTH door_man2 200
											//ADD_ARMOUR_TO_CHAR door_man2 100
											CLEAR_CHAR_THREAT_SEARCH door_man2
											SET_CHAR_HEED_THREATS door_man2 TRUE
											SET_CHAR_PERSONALITY door_man2 PEDSTAT_STREET_GUY
											flag_create_doorman = 1
										ENDIF
									ENDIF
								ENDIF
							ELSE
								GOSUB doorman_delete
							ENDIF
							IF flag_create_doorman = 1
							AND flag_launch_doorman = 0
								IF NOT IS_CHAR_DEAD door_man1
									IF NOT IS_CHAR_HEALTH_GREATER door_man1 199
										IF NOT IS_CHAR_DEAD door_man2
											SET_CHAR_THREAT_SEARCH door_man2 THREAT_PLAYER1
											flag_launch_doorman = 1
										ENDIF
									ENDIF
								ENDIF
								IF NOT IS_CHAR_DEAD door_man2
									IF NOT IS_CHAR_HEALTH_GREATER door_man2 199
										IF NOT IS_CHAR_DEAD door_man1
											SET_CHAR_THREAT_SEARCH door_man1 THREAT_PLAYER1
											flag_launch_doorman = 1
										ENDIF
									ENDIF
								ENDIF
							ENDIF
						ELSE
							GOSUB doorman_delete
						ENDIF

						IF flag_malibu_doors_open = 0
							DELETE_OBJECT malibu_doors 
							CREATE_OBJECT_NO_OFFSET od_clbdr_open 490.34 -77.017 11.598 malibu_doors
							SET_OBJECT_AREA_VISIBLE malibu_doors VIS_MAIN_MAP // SCFIX
							DONT_REMOVE_OBJECT malibu_doors
							flag_malibu_doors_open = 1
							flag_malibu_doors_closed = 0
						ENDIF
					ELSE
						IF flag_malibu_doors_closed = 0
						AND	flag_player_on_lawyer_2 = 0
						AND	flag_player_on_counter_1 = 0
						AND	flag_kent_script_cut = 0 // SCFIX
							DELETE_OBJECT malibu_doors 
							CREATE_OBJECT_NO_OFFSET od_clbdr_close 490.34 -77.017 11.598 malibu_doors
							SET_OBJECT_AREA_VISIBLE malibu_doors VIS_MAIN_MAP // SCFIX
							DONT_REMOVE_OBJECT malibu_doors
							flag_malibu_doors_closed = 1
							flag_malibu_doors_open = 0
						ENDIF
						GOSUB doorman_delete
					ENDIF
					IF flag_kent_mission_active = 0
						IF IS_PLAYER_PLAYING player1
							IF flag_player_in_malibu = 0
							AND flag_player_on_mission = 0
								IF IS_PLAYER_IN_REMOTE_MODE player1
									GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
									IF NOT IS_CAR_DEAD player_car_interiors
										IF LOCATE_CAR_3D player_car_interiors 491.0 -77.7 10.4 1.5 1.5 3.0 FALSE
											BLOW_UP_RC_BUGGY
										ENDIF
									ENDIF
								ELSE
									IF LOCATE_PLAYER_ANY_MEANS_3D player1 491.0 -77.7 10.4 1.5 1.5 3.0 FALSE
										IF IS_PLAYER_IN_ANY_CAR player1
										AND NOT IS_PLAYER_ON_ANY_BIKE player1
											GOTO interiors_inner
										ENDIF
										flag_player_in_malibu = 1
										PRINT_BIG ( MALIBU ) 3000 2 //"The Malibu"
										GOSUB transition_1
										IF IS_PLAYER_PLAYING player1
											IF IS_PLAYER_ON_ANY_BIKE player1
											OR IS_PLAYER_IN_MODEL player1 CADDY
												STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
												WARP_PLAYER_FROM_CAR_TO_COORD player1 484.2 -72.5 9.5
												DELETE_CAR player_car_interiors
											ENDIF
										ENDIF
										IF flag_eject = 0
											SET_AREA_VISIBLE VIS_MALIBU_CLUB
											SWITCH_PED_ROADS_ON 468.0 -77.0 0.0 490.0 -54.0 30.0
											SWITCH_RUBBISH OFF
											LOAD_SCENE 484.2 -72.5 9.5
											SET_PLAYER_COORDINATES player1 484.2 -72.5 9.5
											SET_PLAYER_HEADING player1 60.0
											SET_EXTRA_COLOURS 1 FALSE
											CLEAR_AREA 491.0 -77.7 10.4 1.0 TRUE
											//WAIT 50
											//SET_CAMERA_IN_FRONT_OF_PLAYER
										ELSE
											GOTO interiors_inner
										ENDIF
										IF flag_player_on_counter_1 = 0
										AND flag_player_on_lawyer_2 = 0
											GOSUB transition_2
										ENDIF
									ENDIF
								ENDIF
							ENDIF

							IF flag_player_in_malibu = 1
								IF LOCATE_PLAYER_ANY_MEANS_3D player1 488.6 -75.4 10.4 1.5 1.5 3.0 FALSE
									IF IS_PLAYER_IN_ANY_CAR player1
									AND NOT IS_PLAYER_ON_ANY_BIKE player1
										GOTO interiors_inner
									ENDIF
									IF flag_player_on_counter_1 = 0				   
									AND flag_player_on_lawyer_2 = 0
										GOSUB transition_1
										PRINT_BIG ( BEACH3 ) 3000 2 //"Vice Point"
									ENDIF
									IF flag_eject = 0
										flag_player_in_malibu = 0
										GOSUB outgoing
										SWITCH_PED_ROADS_OFF 468.0 -77.0 0.0 490.0 -54.0 30.0
										CLEAR_AREA 493.1 -82.4 10.8 1.0 FALSE
										LOAD_SCENE 493.1 -82.4 10.8
										SET_PLAYER_COORDINATES player1 493.1  -82.4 9.8
										SET_PLAYER_HEADING player1 220.0
										//SET_CAMERA_IN_FRONT_OF_PLAYER
									ELSE
										GOTO interiors_inner
									ENDIF
									GOSUB transition_2
								ENDIF
							ENDIF
						ENDIF
					ENDIF
				ELSE
					GOSUB doorman_delete
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
		
		// [[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ UMBERTO'S COFFEE SHOP ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
		// [[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ UMBERTO'S COFFEE SHOP ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
		// [[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ UMBERTO'S COFFEE SHOP ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]
		
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 HAVANA
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 2
					IF IS_PLAYER_IN_REMOTE_MODE player1
						GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
						IF NOT IS_CAR_DEAD player_car_interiors
							IF LOCATE_CAR_3D player_car_interiors -1170.0 -609.0 11.0 1.5 1.5 3.0 FALSE
								BLOW_UP_RC_BUGGY
							ENDIF
						ENDIF
					ELSE
						IF flag_player_in_cafe = 0
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1170.0 -609.0 11.0 1.5 1.5 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( UMBERTO ) 3000 2 //Cafe Robina
								GOSUB transition_1
								IF IS_PLAYER_PLAYING player1
									IF IS_PLAYER_ON_ANY_BIKE player1
										STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
										WARP_PLAYER_FROM_CAR_TO_COORD player1 -1170.0 -611.0 11.0
										DELETE_CAR player_car_interiors
									ENDIF
								ENDIF
								IF flag_eject = 0
									flag_player_in_cafe = 1
									SET_AREA_VISIBLE VIS_COFFEE_SHOP
									LOAD_SCENE -1170.0 -611.0 11.0
									CLEAR_AREA -1170.0 -611.0 11.0 1.0 FALSE
									SWITCH_RUBBISH OFF
									SET_PLAYER_COORDINATES player1 -1170.0 -611.5 11.0
									SET_PLAYER_HEADING player1 180.0
									//SET_EXTRA_COLOURS 6 FALSE
									//SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_cafe = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 -1170.0 -606.5 11.0 1.5 1.5 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( HAVANA ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_cafe = 0
								GOSUB outgoing
								CLEAR_AREA -1170.0 -605.0 11.0 1.0 FALSE
								LOAD_SCENE -1170.0 -605.0 11.0
								SET_PLAYER_COORDINATES player1 -1170.0 -605.0 11.0
								SET_PLAYER_HEADING player1 0.0
								SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
			
			
		// **************************** THE MALL DOOR 1 ************************************************
		// **************************** THE MALL DOOR 1 ************************************************
		// **************************** THE MALL DOOR 1 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 2
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 449.76 996.22 18.4 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 448.8 999.9 18.4 3.5 3.5 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 448.3 1030.0 18.0
									SET_PLAYER_COORDINATES player1 448.3 1006.0 18.0
									float_heading = 0.0
									GOSUB vehicle_heading
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 448.8 999.9 18.4 3.5 3.5 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 449.7 992.2 17.0 1.0 FALSE
								LOAD_SCENE 449.7 992.2 17.0
								SET_PLAYER_COORDINATES player1 449.7 992.2 17.0
								float_heading = 180.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 180.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF

		// **************************** THE MALL DOOR 2 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 1
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 379.1 995.16 17.4 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 380.1 999.0 19.4 3.5 3.5 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 380.0 1026.4 18.2
									SET_PLAYER_COORDINATES player1 380.0 1006.4 18.2
									float_heading = 0.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 0.0
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D	player1 380.1 999.0 19.4 3.5 3.5 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 379.3 991.4 17.2 1.0 FALSE
								LOAD_SCENE 379.3 991.4 17.2
								SET_PLAYER_COORDINATES player1 379.3 991.4 17.0
								float_heading = 180.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 180.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF


		// **************************** THE MALL DOOR 3 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 1
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 350.3 1124.0 17.4 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 353.3 1124.5 19.4 3.2 3.2 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 390.0 1124.4 17.5
									SET_PLAYER_COORDINATES player1 363.0 1124.4 17.5
									float_heading = 270.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 270.0
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 353.3 1124.5 19.4 3.2 3.2 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 344.5 1123.5 17.0 1.0 FALSE
								LOAD_SCENE 344.5 1123.5 17.0
								SET_PLAYER_COORDINATES player1 344.5 1123.5 17.0
								float_heading = 90.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 90.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF

		// **************************** THE MALL DOOR 4 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 2
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 364.0 1210.0 24.0 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 367.8 1210.3 26.0 2.7 2.7 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 395.0 1212.0 24.4
									SET_PLAYER_COORDINATES player1 372.0 1210.0 24.4
									float_heading = 270.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 270.0
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 367.8 1210.3 26.0 2.7 2.70 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 366.0 1210.0 24.0 1.0 FALSE
								LOAD_SCENE 343.0 1210.0 24.0
								SET_PLAYER_COORDINATES player1 364.0 1210.0 24.0
								float_heading = 90.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 90.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF

		// **************************** THE MALL DOOR 5 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 2
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 378.6 1256.9 17.5 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 380.6 1253.5 17.5 3.5 3.5 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 385.0 1230.7 18.0
									SET_PLAYER_COORDINATES player1 380.0 1246.7 18.0
									float_heading = 180.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 180.0
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 380.6 1253.5 17.5 3.5 3.5 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 378.0 1263.6 16.5 1.0 FALSE
								LOAD_SCENE 378.0 1263.6 16.5
								SET_PLAYER_COORDINATES player1 378.0 1263.6 16.5
								float_heading = 0.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 0.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF

		// **************************** THE MALL DOOR 6 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 1
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 449.37 1256.2 17.2 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 448.0 1253.0 19.2 3.0 3.0 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 448.5 1230.0 18.0
									SET_PLAYER_COORDINATES player1 448.5 1245.0 18.0
									float_heading = 180.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 180.0
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 448.0 1253.0 19.2 3.0 3.0 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 449.0 1263.0 16.5 1.0 FALSE
								LOAD_SCENE 449.0 1263.0 16.5
								SET_PLAYER_COORDINATES player1 449.0 1263.0 16.5
								float_heading = 0.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 0.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF

				// **************************** THE MALL DOOR 7 ************************************************
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 BEACH3
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 2
					IF flag_player_in_mall = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors 477.6 1124.4 16.3 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 474.5 1124.0 19.3 3.5 3.5 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( MALL1 ) 3000 2 //"Diaz's Mansion"
								GOSUB transition_1
								IF flag_eject = 0
									flag_player_in_mall = 1
									SET_AREA_VISIBLE VIS_MALL
									SWITCH_PED_ROADS_ON 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
									SWITCH_RUBBISH OFF
									LOAD_SCENE 444.4 1123.7 17.0
									SET_PLAYER_COORDINATES player1 467.4 1123.7 17.0
									float_heading = 90.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 90.0
									SET_EXTRA_COLOURS 6 FALSE
									SET_CAR_DENSITY_MULTIPLIER 0.1
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_mall = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 474.5 1124.0 19.3 3.5 3.5 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
							AND NOT IS_PLAYER_IN_MODEL player1 CADDY
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( BEACH3 ) 3000 2 //
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_mall = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
								CLEAR_AREA 482.0 1124.5 15.3 1.0 FALSE
								LOAD_SCENE 482.0 1124.5 15.3
								SET_PLAYER_COORDINATES player1 482.0 1124.5 15.3
								float_heading = 0.0
								GOSUB vehicle_heading
								//SET_PLAYER_HEADING player1 0.0
								//SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
			
		// **************************** THE SHOOTING RANGE ************************************************
		// **************************** THE SHOOTING RANGE ************************************************
		// **************************** THE SHOOTING RANGE ************************************************
		
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 DTOWN
			OR flag_player_on_rc_mission = 1
				IF pooz_counter = 1
					IF flag_player_in_shooting_range = 0
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors -667.85 1211.9 11.0 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE

							IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.85 1211.9 11.0 1.5 1.5 3.0 FALSE
								PRINT_BIG ( RANGE ) 3000 2 //"The Malibu1"
								GOSUB transition_1
								IF IS_PLAYER_PLAYING player1
									IF IS_PLAYER_ON_ANY_BIKE player1
										STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
										WARP_PLAYER_FROM_CAR_TO_COORD player1 -667.8 1221.0 10.5
										DELETE_CAR player_car_interiors
									ENDIF
								ENDIF
								IF flag_eject = 0
									SET_AREA_VISIBLE VIS_RIFLE_RANGE
									flag_player_in_shooting_range = 1
									SWITCH_RUBBISH OFF
									LOAD_SCENE -667.8 1221.0 11.0
									SET_PLAYER_COORDINATES player1 -667.8 1221.0 10.3
									SET_PLAYER_HEADING player1 0.0
									SET_EXTRA_COLOURS 7 FALSE
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								IF flag_player_on_bank_2 = 0
									GOSUB transition_2
								ENDIF
							ENDIF
						ENDIF
					ENDIF

					IF flag_player_in_shooting_range = 1
						IF LOCATE_PLAYER_ANY_MEANS_3D player1 -667.8 1217.8 11.0 1.5 1.5 3.0 FALSE
							//IF IS_PLAYER_IN_ANY_CAR player1
							//AND NOT IS_PLAYER_ON_ANY_BIKE player1
								//GOTO interiors_inner
							//ENDIF
							PRINT_BIG ( DTOWN ) 3000 2 //"The Malibu1"
							GOSUB transition_1
							IF flag_eject = 0
								flag_player_in_shooting_range = 0
								GOSUB outgoing
								CLEAR_AREA -667.8 1210.0 11.0 1.0 FALSE
								LOAD_SCENE -667.8 1210.0 11.0
								SET_PLAYER_COORDINATES player1 -667.8 1210.0 10.3
								SET_PLAYER_HEADING player1 140.0
								SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF
							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
			
			
				
		// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO DIAZ'S MANSION OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO DIAZ'S MANSION OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
		// OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO DIAZ'S MANSION OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
			
		IF IS_PLAYER_PLAYING player1
			flag_interiors_cleanup = 0
			IF IS_PLAYER_IN_ZONE player1 STARI
			OR flag_player_on_rc_mission = 1
				IF flag_open_mansion > 0
					IF flag_open_mansion > 1
						// **************************** DIAZ'S MANSION FRONT DOOR************************************************
						IF pooz_counter = 1
							IF flag_player_in_mansion = 0
								IF IS_PLAYER_IN_REMOTE_MODE player1
									GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
									IF NOT IS_CAR_DEAD player_car_interiors
										IF LOCATE_CAR_3D player_car_interiors -378.5 -554.382 18.3 1.5 1.5 3.0 FALSE
											BLOW_UP_RC_BUGGY
										ENDIF
									ENDIF
								ELSE
									IF IS_PLAYER_IN_AREA_3D player1 -382.0 -558.5 18.537 -375.0 -554.5 24.537 FALSE
										IF flag_baron_mission5_passed = 0
											PRINT_BIG ( MANSION ) 3000 2 //"Diaz's Mansion"
										ELSE
											PRINT_BIG ( TMANS ) 3000 2 //"Chez Tommy"
										ENDIF
										GOSUB transition_1
										/*
										IF IS_PLAYER_PLAYING player1
											IF IS_PLAYER_IN_ANY_CAR player1
											AND NOT IS_PLAYER_ON_ANY_BIKE player1
											AND NOT IS_PLAYER_IN_MODEL player1 CADDY
												STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
												WARP_PLAYER_FROM_CAR_TO_COORD player1 -378.5 -560.0 19.0
												DELETE_CAR player_car_interiors
											ENDIF
										ENDIF
										*/
										IF flag_eject = 0
											SET_AREA_VISIBLE VIS_MANSION
											flag_player_in_mansion = 1
											IF flag_ped_roads_off_in_finale = 0 // SCFIX
												SWITCH_PED_ROADS_ON -414.0 -597.0 12.0 -332.0 -555.0 30.0 // LOWER FLOOR
											ENDIF // SCFIX
											SWITCH_RUBBISH OFF
											LOAD_SCENE -378.5 -560.03 19.0
											SET_PLAYER_COORDINATES player1 -378.5 -560.0 19.0
											float_heading = 190.0
											GOSUB vehicle_heading
											//SET_PLAYER_HEADING player1 190.0
											SET_EXTRA_COLOURS 8 FALSE
											//SET_CAMERA_IN_FRONT_OF_PLAYER
										ELSE
											GOTO interiors_inner
										ENDIF
										GOSUB transition_2
									ENDIF
								ENDIF
							ENDIF

							IF flag_player_in_mansion = 1
								IF IS_PLAYER_IN_AREA_3D player1 -382.0 -554.5 18.537 -375.0 -550.5 24.537 FALSE	
									PRINT_BIG ( STARI ) 3000 2
									GOSUB transition_1
									IF flag_eject = 0
										GOSUB outgoing
										flag_player_in_mansion = 0
										IF flag_ped_roads_off_in_finale = 0 // SCFIX
											SWITCH_PED_ROADS_OFF -414.0 -597.0 12.0 -332.0 -555.0 30.0 // LOWER FLOOR
										ENDIF // SCFIX
										CLEAR_AREA -377.06 -545.43 17.0 1.0 FALSE
										LOAD_SCENE -377.06 -545.43 17.0
										SET_PLAYER_COORDINATES player1 -377.06 -545.43 16.0
										SET_PLAYER_HEADING player1 345.0
										//SET_CAMERA_IN_FRONT_OF_PLAYER
									ELSE
										GOTO interiors_inner
									ENDIF
									GOSUB transition_2
								ENDIF
							ENDIF
						ENDIF 
					ENDIF
					
					
					// **************************** DIAZ'S MANSION ROOFTOP ENTRY************************************************
					IF pooz_counter = 2
						IF flag_player_in_mansion = 0
							IF IS_PLAYER_IN_REMOTE_MODE player1
								GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
								IF NOT IS_CAR_DEAD player_car_interiors
									IF LOCATE_CAR_3D player_car_interiors -331.0 -576.6 36.5 1.5 1.5 3.0 FALSE
										BLOW_UP_RC_BUGGY
									ENDIF
								ENDIF
							ELSE
								//IF IS_PLAYER_IN_AREA_3D	player1 -336.902 -577.589 34.52 -331.269 -569.893 38.113 FALSE
								IF IS_PLAYER_IN_AREA_3D	player1 -340.402 -579.221 34.52 -331.269 -568.389 38.113 FALSE
									
									IF IS_PLAYER_IN_ANY_CAR player1
									AND NOT IS_PLAYER_ON_ANY_BIKE player1
										GOTO interiors_inner
									ENDIF
									
									IF flag_baron_mission5_passed = 0
										PRINT_BIG ( MANSION ) 3000 2 //"Diaz's Mansion"
									ELSE
										PRINT_BIG ( TMANS ) 3000 2 //"Chez Tommy"
									ENDIF
									GOSUB transition_1
									IF IS_PLAYER_PLAYING player1
										IF IS_PLAYER_ON_ANY_BIKE player1
											STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
											WARP_PLAYER_FROM_CAR_TO_COORD player1 -329.24 -582.5 34.5
											DELETE_CAR player_car_interiors
										ENDIF
									ENDIF
									IF flag_eject = 0
										SET_AREA_VISIBLE VIS_MANSION
										flag_player_in_mansion = 1
										IF flag_ped_roads_off_in_finale = 0 // SCFIX
											SWITCH_PED_ROADS_ON -414.0 -597.0 12.0 -332.0 -555.0 30.0 // LOWER FLOOR
										ENDIF // SCFIX
										SWITCH_RUBBISH OFF
										LOAD_SCENE -329.24 -582.5 34.5
										SET_PLAYER_COORDINATES player1 -329.24 -582.5 34.5
										SET_PLAYER_HEADING player1 270.0
										SET_EXTRA_COLOURS 8 FALSE
										//SET_CAMERA_IN_FRONT_OF_PLAYER
									ELSE
										GOTO interiors_inner
									ENDIF
									GOSUB transition_2
								ENDIF
							ENDIF
						ENDIF

						IF flag_player_in_mansion = 1
							IF LOCATE_PLAYER_ANY_MEANS_3D player1 -330.1 -578.9 34.5 2.0 2.0 3.0 FALSE
								PRINT_BIG ( STARI ) 3000 2
								GOSUB transition_1
								IF flag_eject = 0
									GOSUB outgoing
									flag_player_in_mansion = 0
									IF flag_ped_roads_off_in_finale = 0 // SCFIX
										SWITCH_PED_ROADS_OFF -414.0 -597.0 12.0 -332.0 -555.0 30.0 // LOWER FLOOR
									ENDIF // SCFIX
									CLEAR_AREA -343.3 -572.8 36.0 1.0 FALSE
									LOAD_SCENE -343.3 -572.8 36.0
									//SET_PLAYER_COORDINATES player1 -338.738 -573.984 35.305
									SET_PLAYER_COORDINATES player1 -341.738 -573.984 35.305
								
									SET_PLAYER_HEADING player1 90.0
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF 
						ENDIF
					ENDIF
						// **************************** DIAZ'S MANSION POOL SIDE 1************************************************
					IF pooz_counter = 1
						IF flag_player_in_mansion = 0
							IF IS_PLAYER_IN_REMOTE_MODE player1
								GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
								IF NOT IS_CAR_DEAD player_car_interiors
									IF LOCATE_CAR_3D player_car_interiors -354.0 -580.6 11.0 1.5 1.5 3.0 FALSE
										BLOW_UP_RC_BUGGY
									ENDIF
								ENDIF
							ELSE
								IF LOCATE_PLAYER_ANY_MEANS_3D	player1 -354.0 -580.6 11.0 1.5 1.5 3.0 FALSE
									
									IF IS_PLAYER_IN_ANY_CAR player1
									AND NOT IS_PLAYER_ON_ANY_BIKE player1
									AND NOT IS_PLAYER_IN_MODEL player1 CADDY 
										GOTO interiors_inner
									ENDIF
									
									IF flag_baron_mission5_passed = 0
										PRINT_BIG ( MANSION ) 3000 2 //"Diaz's Mansion"
									ELSE
										PRINT_BIG ( TMANS ) 3000 2 //"Chez Tommy"
									ENDIF
									GOSUB transition_1
									/*
									IF IS_PLAYER_PLAYING player1
										IF IS_PLAYER_ON_ANY_BIKE player1
										OR IS_PLAYER_IN_MODEL player1 CADDY
											STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
											WARP_PLAYER_FROM_CAR_TO_COORD player1 -338.5 -578.8 10.6
											DELETE_CAR player_car_interiors
										ENDIF
									ENDIF
									*/
									IF flag_eject = 0
										SET_AREA_VISIBLE VIS_MANSION
										flag_player_in_mansion = 1
										IF flag_ped_roads_off_in_finale = 0 // SCFIX
											SWITCH_PED_ROADS_ON -414.0 -597.0 12.0 -332.0 -555.0 30.0 // LOWER FLOOR
										ENDIF // SCFIX
										SWITCH_RUBBISH OFF
										LOAD_SCENE -338.5 -578.8 10.6
										SET_PLAYER_COORDINATES player1 -338.5 -578.8 10.6
										float_heading = 270.0
										GOSUB vehicle_heading
										//SET_PLAYER_HEADING player1 270.0
										SET_EXTRA_COLOURS 8 FALSE
										//SET_CAMERA_IN_FRONT_OF_PLAYER
									ELSE
										GOTO interiors_inner
									ENDIF
									GOSUB transition_2
								ENDIF
							ENDIF
						ENDIF

						IF flag_player_in_mansion = 1
							IF LOCATE_PLAYER_ANY_MEANS_3D	player1 -346.3 -578.8 10.6 1.5 1.5 3.0 FALSE
								PRINT_BIG ( STARI ) 3000 2 
								GOSUB transition_1
								IF flag_eject = 0
									GOSUB outgoing
									flag_player_in_mansion = 0
									IF flag_ped_roads_off_in_finale = 0 // SCFIX
										SWITCH_PED_ROADS_OFF -414.0 -597.0 12.0 -332.0 -555.0 30.0 // LOWER FLOOR
									ENDIF // SCFIX
									CLEAR_AREA -354.0 -586.0 10.6 1.0 FALSE
									LOAD_SCENE -354.0 -586.0 10.6
									SET_PLAYER_COORDINATES player1 -354.0 -586.0 10.6
									float_heading = 180.0
									GOSUB vehicle_heading
									//SET_PLAYER_HEADING player1 180.0
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
				
			
			
		IF IS_PLAYER_PLAYING player1
			IF flag_bankjob_mission4_passed = 1	
				IF IS_PLAYER_IN_ZONE player1 HAVANA
				OR flag_player_on_rc_mission = 1
					IF pooz_counter = 2
						// ******************** THE BANK ***********************************************************
						IF IS_PLAYER_IN_REMOTE_MODE player1
							GET_REMOTE_CONTROLLED_CAR player1 player_car_interiors
							IF NOT IS_CAR_DEAD player_car_interiors
								IF LOCATE_CAR_3D player_car_interiors -896.5 -341.0 13.4 1.5 1.5 3.0 FALSE
									BLOW_UP_RC_BUGGY
								ENDIF
							ENDIF
						ELSE
							IF LOCATE_PLAYER_ANY_MEANS_3D	player1 -896.5 -341.0 13.4 1.4 1.4 3.0 FALSE
								IF IS_PLAYER_IN_ANY_CAR player1
								AND NOT IS_PLAYER_ON_ANY_BIKE player1
								AND NOT IS_PLAYER_IN_MODEL player1 CADDY
									GOTO interiors_inner
								ENDIF
								PRINT_BIG ( BANKINT ) 3000 2 
								GOSUB transition_1
								IF IS_PLAYER_PLAYING player1
									IF IS_PLAYER_ON_ANY_BIKE player1
									OR IS_PLAYER_IN_MODEL player1 CADDY
										STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
										WARP_PLAYER_FROM_CAR_TO_COORD player1 -903.0 -341.0 12.5
										DELETE_CAR player_car_interiors
									ENDIF
								ENDIF
								IF flag_eject = 0
									SET_AREA_VISIBLE VIS_BANK
									SWITCH_RUBBISH OFF
									IF flag_player_on_mission = 0
										SWITCH_PED_ROADS_ON -918.5 -355.0 5.0 -898.0 -328.0 16.0 // LOWER FLOOR
									ENDIF
									LOAD_SCENE -903.0 -341.0 13.4
									SET_PLAYER_COORDINATES player1 -903.0 -341.0 12.5
									flag_player_in_bank = 1
									SET_PLAYER_HEADING player1 90.0
									SET_EXTRA_COLOURS 4 FALSE
									//SET_CAMERA_IN_FRONT_OF_PLAYER
								ELSE
									GOTO interiors_inner
								ENDIF
								GOSUB transition_2
							ENDIF
						ENDIF

						IF LOCATE_PLAYER_ANY_MEANS_3D	player1 -900.0 -340.9 13.4 1.5 1.5 3.0 FALSE
							IF IS_PLAYER_IN_ANY_CAR player1
							AND NOT IS_PLAYER_ON_ANY_BIKE player1
								GOTO interiors_inner
							ENDIF
							PRINT_BIG ( HAVANA ) 3000 2 
							GOSUB transition_1
							IF flag_eject = 0
								GOSUB outgoing
								SWITCH_PED_ROADS_OFF -956.0 -355.0 5.0 -898.0 -328.0 25.0
								CLEAR_AREA -893.0 -341.0 13.5 1.0 FALSE
								LOAD_SCENE -893.0 -341.0 13.5
								SET_PLAYER_COORDINATES player1 -893.0 -341.0 12.0
								flag_player_in_bank = 0
								SET_PLAYER_HEADING player1 270.0
								SET_CAMERA_IN_FRONT_OF_PLAYER
							ELSE
								GOTO interiors_inner
							ENDIF

							GOSUB transition_2
						ENDIF
					ENDIF
				ENDIF
			ENDIF
		ELSE
			GOSUB interiors_cleanup
		ENDIF
	
	GOSUB populate_strip
	GOSUB populate_malibu
	IF pooz_counter > 1
		pooz_counter = 0
	ENDIF
	//GOSUB populate_shops
GOTO interiors_inner	






transition_1:
IF IS_PLAYER_PLAYING player1
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 ON
	//STORE_WANTED_LEVEL player1 wanted_interior
	//CLEAR_WANTED_LEVEL player1
	SET_FADING_COLOUR 0 0 1
	IF flag_player_on_bank_2 = 0
	AND flag_player_on_lawyer_2 = 0
	AND flag_player_on_counter_1 = 0
		DO_FADE 500 FADE_OUT
	ELSE
		IF flag_player_in_malibu = 1
			SET_FADING_COLOUR 0 0 0
			DO_FADE 1500 FADE_OUT
		ELSE
			DO_FADE 500 FADE_OUT
		ENDIF
	ENDIF

	flag_is_in_transition1 = 1 // SCFIX
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			//GOSUB interiors_cleanup
			flag_eject = 1
		ELSE
			flag_eject = 0
		ENDIF
		IF flag_player_in_stripclub = 1
			GOSUB populate_strip
		ENDIF
		IF flag_player_in_malibu = 1
			GOSUB populate_malibu
		ENDIF
	ENDWHILE
	flag_is_in_transition1 = 0 // SCFIX
	SET_CAR_DENSITY_MULTIPLIER 0.0
ENDIF
RETURN




transition_2:
	SET_FADING_COLOUR 0 0 1
	IF flag_player_on_bank_2 = 0
	AND flag_player_on_lawyer_2 = 0
	AND flag_player_on_counter_1 = 0
		DO_FADE 500 FADE_IN
	ELSE
		IF flag_player_in_malibu = 1
			SET_FADING_COLOUR 0 0 0
			DO_FADE 1500 FADE_IN
		ELSE
			DO_FADE 500 FADE_IN
		ENDIF
	ENDIF
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			//GOSUB interiors_cleanup
			flag_eject = 1
		ELSE
			flag_eject = 0
		ENDIF
	ENDWHILE
	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
	ENDIF
RETURN

outgoing:
	CLEAR_EXTRA_COLOURS FALSE
	SET_CAR_DENSITY_MULTIPLIER 1.0
	SWITCH_RUBBISH ON
	SET_AREA_VISIBLE VIS_MAIN_MAP
RETURN


interiors_cleanup:
			
	IF flag_interiors_cleanup = 0
		// SCFIX: START - wait until wasted/busted cam is over
		WHILE NOT IS_PLAYER_PLAYING player1
			WAIT 0
		ENDWHILE
		// SCFIX: END

		//SET_AREA_VISIBLE VIS_MAIN_MAP
		SWITCH_RUBBISH ON
		//CLEAR_MISSION_AUDIO 1
		//CLEAR_MISSION_AUDIO 2
		CLEAR_EXTRA_COLOURS FALSE
		SWITCH_PED_ROADS_OFF -956.0 -355.0 5.0 -898.0 -328.0 25.0 // BANK
		SWITCH_PED_ROADS_OFF -414.0 -597.0 12.0 -332.0 -555.0 30.0 // MANSION
		SWITCH_PED_ROADS_OFF 474.0 1250.0 17.0 356.0 1003.0 32.0 // LOWER FLOOR
		SWITCH_PED_ROADS_OFF 354.9 -483.1 21.0 406.0 -490.0 0.0 //POLICE STATION
		SWITCH_PED_ROADS_OFF 468.0 -77.0 0.0 490.0 -54.0 30.0

		SET_ZONE_PED_INFO STREET2 DAY   (14) 0 0 0 0 0 0 0 0 0 20 //POLICE STATION  
	    SET_ZONE_PED_INFO STREET2 NIGHT (16) 0 0 0 0 0 0 0 0 0 10

		//SET_PLAYER_CONTROL player1 ON
		//SET_EVERYONE_IGNORE_PLAYER player1 OFF
		//SET_CHAR_WAIT_STATE player_char	WAITSTATE_FALSE	0
		//CLEAR_PRINTS
		//CLEAR_HELP
		flag_player_in_cafe = 0
		flag_player_in_malibu = 0
		flag_player_in_stripclub = 0
		flag_player_in_mall = 0
		flag_player_in_hotel = 0
		flag_player_in_cop_shop = 0
		flag_player_in_shooting_range = 0
		flag_player_in_apartment3c = 0
		flag_player_in_mansion = 0
		flag_player_in_bank = 0 // SCFIX
		SET_CAR_DENSITY_MULTIPLIER 1.0
		flag_interiors_cleanup = 1
	ENDIF


RETURN




populate_strip:
	
	IF flag_player_in_stripclub = 1
		IF flag_strip_populate = 1
			GOSUB waitstate_every_frame
			IF IS_PLAYER_PLAYING player1
			AND IS_SCORE_GREATER player1 5
			AND flag_player_on_mission = 0  
				IF LOCATE_PLAYER_ON_FOOT_2D player1 69.3 -1455.9 1.0 1.0 TRUE
				AND CAN_PLAYER_START_MISSION player1
					//MAKE_PLAYER_SAFE_FOR_CUTSCENE player1
					GOSUB the_groovy_room
				ENDIF
			ENDIF
			IF IS_PLAYER_PLAYING player1
			AND flag_strip_asset_cutscene = 1  
			AND flag_player_on_mission = 0  
				IF LOCATE_PLAYER_ON_FOOT_2D player1 70.0 -1443.64 1.0 1.0 TRUE
				AND CAN_PLAYER_START_MISSION player1
					MAKE_PLAYER_SAFE_FOR_CUTSCENE player1
					GOSUB the_groovier_room
				ENDIF
			ENDIF
			/*
			GET_GAME_TIMER timer_populate_now
			timer_populate_lapsed = timer_populate_now - timer_populate_start
			IF timer_populate_lapsed > 300000
				GOSUB waitstate_every_frame
			ENDIF
			*/
		ENDIF
		IF flag_strip_populate = 0
			ped_routine_1 =	24 //sit down
			ped_routine_2 =	24 //sit idle
			ped_routine_3 =	25 //ATm
			ped_routine_4 =	29 //riot
			ped_routine_5 =	19 //chat
			//ped_routine_6 =
			//ped_routine_7 =
			//ped_routine_8 =
			//ped_routine_9 =
			//ped_routine_10 =
			
			REQUEST_MODEL WFYG1	//
			REQUEST_MODEL WFYBE	//
			REQUEST_MODEL BFYPR
			REQUEST_MODEL WFOBE	// dancers


			WHILE NOT HAS_MODEL_LOADED WFYG1
			OR NOT HAS_MODEL_LOADED WFYBE
			OR NOT HAS_MODEL_LOADED BFYPR
			OR NOT HAS_MODEL_LOADED WFOBE
				REQUEST_MODEL WFYG1
				REQUEST_MODEL WFYBE
				REQUEST_MODEL BFYPR
				REQUEST_MODEL WFOBE
				WAIT 0
			ENDWHILE

			REQUEST_MODEL BFYRI	// bar staff
			REQUEST_MODEL HFYMD	// bar staff
			REQUEST_MODEL WMOCA	// punter
			REQUEST_MODEL BKa	// punter

			WHILE NOT HAS_MODEL_LOADED BFYRI // bar staff
			OR NOT HAS_MODEL_LOADED HFYMD // bar staff
			OR NOT HAS_MODEL_LOADED WMOCA // punter
			OR NOT HAS_MODEL_LOADED BKa	// punter
				REQUEST_MODEL BFYRI	// bar staff
				REQUEST_MODEL HFYMD	// bar staff
				REQUEST_MODEL WMOCA	// punter
				REQUEST_MODEL BKa	// punter

				WAIT 0
			ENDWHILE

			REQUEST_MODEL BKb	 // PUNTERS
			REQUEST_MODEL WMOST	 // PUNTERS
			REQUEST_MODEL WMOBE	 // Punter
			REQUEST_MODEL BMYBB 	 // punter

			WHILE NOT HAS_MODEL_LOADED BKb // PUNTERS
			OR NOT HAS_MODEL_LOADED WMOST // PUNTERS
			OR NOT HAS_MODEL_LOADED WMOBE // Punter
			OR NOT HAS_MODEL_LOADED BMYBB  // punter
				REQUEST_MODEL BKb	 // PUNTERS
				REQUEST_MODEL WMOST	 // PUNTERS
				REQUEST_MODEL WMOBE	 // Punter
				REQUEST_MODEL BMYBB 	 // punter
				WAIT 0
			ENDWHILE

			REQUEST_MODEL HMOST	 // bouncer
			REQUEST_MODEL WMYBU	 // bouncer

			WHILE NOT HAS_MODEL_LOADED HMOST // bouncer
			OR NOT HAS_MODEL_LOADED WMYBU // bouncer
				REQUEST_MODEL HMOST	 // bouncer
				REQUEST_MODEL WMYBU	 // bouncer
				WAIT 0
			ENDWHILE

			REQUEST_ANIMATION RIOT //riot
			REQUEST_ANIMATION STRIP //STRIP					 

			WHILE NOT HAS_ANIMATION_LOADED RIOT
			OR NOT HAS_ANIMATION_LOADED STRIP
				REQUEST_ANIMATION RIOT //riot
				REQUEST_ANIMATION STRIP //STRIP					 
				WAIT 0
			ENDWHILE
			
			
			// ********************* BOUNCERS **************************************************

			CREATE_CHAR PEDTYPE_CIVMALE HMOST 89.8 -1456.2 9.4 bouncer_1 // back room far right
			SET_CHAR_HEADING bouncer_1 287.0
			CLEAR_CHAR_THREAT_SEARCH bouncer_1
			
			CREATE_CHAR PEDTYPE_CIVMALE WMYBU 89.15 -1461.3 9.6 bouncer_2 // back room far right
			SET_CHAR_HEADING bouncer_2 48.7
			CLEAR_CHAR_THREAT_SEARCH bouncer_2
			
			// ********************************************************************************
			/*
			CREATE_CHAR PEDTYPE_CIVMALE WFYG1 90.8 -1456.15 9.6 dancer_4 // back room far right
			SET_CHAR_HEADING dancer_4 168.0
			CLEAR_CHAR_THREAT_SEARCH dancer_4
			//CHAR_SET_IDLE dancer_4
			///ADD_BLIP_FOR_CHAR  dancer_4	testblip_4
			SET_CHAR_WAIT_STATE dancer_4 32 999999
			*/
			// *********************** FAT BLOKE **********************************************
			
			CREATE_CHAR PEDTYPE_CIVFEMALE BFYPR 79.67 -1461.34 10.6 dancer_2 // far left pole
			SET_CHAR_HEADING dancer_2 168.0
			CLEAR_CHAR_THREAT_SEARCH dancer_2
			//CHAR_SET_IDLE dancer_2
			//ADD_BLIP_FOR_CHAR  dancer_2	testblip_2
			SET_CHAR_WAIT_STATE dancer_2 WAITSTATE_STRIPPER 999999
			
			CREATE_CHAR PEDTYPE_CIVMALE WMOST 79.5 -1463.1 9.6 s_punter_6 // back room far left
			SET_CHAR_HEADING s_punter_6 5.0
			CLEAR_CHAR_THREAT_SEARCH s_punter_6
			//CHAR_SET_IDLE s_punter_3
			//CHAR_LOOK_AT_CHAR_ALWAYS s_punter_6 dancer_2
			SET_CHAR_WAIT_STATE s_punter_6 29 999999
			
			// ************ WEE CAB DRIVER ****************************

			CREATE_CHAR PEDTYPE_CIVMALE WMOCA 87.3 -1462.85 9.6 s_punter_1
			SET_CHAR_HEADING s_punter_1 117.0
			CLEAR_CHAR_THREAT_SEARCH s_punter_1
			//CHAR_SET_IDLE s_punter_1
			//ADD_BLIP_FOR_CHAR  s_punter_1 testblip_6
			
			CREATE_CHAR PEDTYPE_CIVFEMALE WFYBE 86.06 -1463.6 10.4 dancer_3 // far left pole
			SET_CHAR_HEADING dancer_3 295.0
			CLEAR_CHAR_THREAT_SEARCH dancer_3
			//CHAR_SET_IDLE dancer_3
			//ADD_BLIP_FOR_CHAR  dancer_3	testblip_3
			SET_CHAR_WAIT_STATE dancer_3 WAITSTATE_STRIPPER 999999

			// ***************** BIKERS & FAT BINT **************************************

			CREATE_CHAR PEDTYPE_CIVMALE BKb 79.0 -1466.31 9.6 s_punter_2 // back room far right
			SET_CHAR_HEADING s_punter_2 58.0			  
			CLEAR_CHAR_THREAT_SEARCH s_punter_2
			//CHAR_SET_IDLE s_punter_2
			//ADD_BLIP_FOR_CHAR  s_punter_2 testblip_7

			CREATE_CHAR PEDTYPE_CIVMALE BKa 77.46 -1466.06 9.6 s_punter_3 // back room far left
			SET_CHAR_HEADING s_punter_3 265.0
			CLEAR_CHAR_THREAT_SEARCH s_punter_3
			//CHAR_SET_IDLE s_punter_3
			//ADD_BLIP_FOR_CHAR  s_punter_3 testblip_8
			
			CREATE_CHAR PEDTYPE_CIVFEMALE WFOBE 78.07 -1465.7 10.4 dancer_5 // back room far left
			SET_CHAR_HEADING dancer_5 168.0
			CLEAR_CHAR_THREAT_SEARCH dancer_5
			//CHAR_SET_IDLE dancer_5
			//ADD_BLIP_FOR_CHAR  dancer_5	testblip_5
			SET_CHAR_WAIT_STATE dancer_5 WAITSTATE_STRIPPER 999999

			// ************************** EXCITED PUNTERS & DANCER ***************************
			
			CREATE_CHAR PEDTYPE_CIVMALE BMYBB  81.35 -1459.9 9.6 s_punter_4 // back room far left
			SET_CHAR_HEADING s_punter_4 5.0
			CLEAR_CHAR_THREAT_SEARCH s_punter_4
			//CHAR_SET_IDLE s_punter_3
			SET_CHAR_WAIT_STATE s_punter_4 29 999999
			
			CREATE_CHAR PEDTYPE_CIVMALE WMOBE 83.4 -1458.9 9.6 s_punter_5 // back room far left
			SET_CHAR_HEADING s_punter_5 60.0
			CLEAR_CHAR_THREAT_SEARCH s_punter_5
			//CHAR_SET_IDLE s_punter_3
			SET_CHAR_WAIT_STATE s_punter_5 29 999999
			
			CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 81.45 -1457.44 10.6 dancer_1 // Central pole
			SET_CHAR_HEADING dancer_1 210.0
			CLEAR_CHAR_THREAT_SEARCH dancer_1
			//CHAR_SET_IDLE dancer_1
			//ADD_BLIP_FOR_CHAR dancer_1 testblip_1
			SET_CHAR_WAIT_STATE dancer_1 WAITSTATE_STRIPPER 999999

			// ****************** BAR STAFF **************************************************

			CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI 88.6 -1450.0 9.6 bar_staff1
			SET_CHAR_HEADING bar_staff1 325.0
			CLEAR_CHAR_THREAT_SEARCH bar_staff1
			CHAR_SET_IDLE bar_staff1

			CREATE_CHAR PEDTYPE_CIVFEMALE HFYMD 91.44 -1455.3 9.6 bar_staff2
			SET_CHAR_HEADING bar_staff2 128.0
			CLEAR_CHAR_THREAT_SEARCH bar_staff2
			CHAR_SET_IDLE bar_staff2
			
			GOSUB waitstate_every_frame  
			flag_strip_populate = 1
		ENDIF
	ELSE
		IF flag_strip_populate > 0
			
			WHILE NOT IS_PLAYER_PLAYING	player1
				WAIT 0
			ENDWHILE
			/*
			WAIT 500
			WHILE GET_FADING_STATUS
				WAIT 0
			ENDWHILE
			*/
			DELETE_CHAR dancer_1
			DELETE_CHAR dancer_2
			DELETE_CHAR dancer_3
			//DELETE_CHAR dancer_4
			DELETE_CHAR dancer_5
			//DELETE_CHAR dancer_6
			//DELETE_CHAR dancer_7
			//DELETE_CHAR dancer_8

			DELETE_CHAR s_punter_1
			DELETE_CHAR s_punter_2
			DELETE_CHAR s_punter_3
			DELETE_CHAR s_punter_4
			DELETE_CHAR s_punter_5
			DELETE_CHAR s_punter_6
			//DELETE_CHAR s_punter_7
			//DELETE_CHAR s_punter_8

			DELETE_CHAR bar_staff1
			DELETE_CHAR bar_staff2
			
			DELETE_CHAR bouncer_1
			DELETE_CHAR bouncer_2

			/*
			REQUEST_MODEL WFYPR	// dancers
			REQUEST_MODEL WFYG1
			REQUEST_MODEL HFYBE
			REQUEST_MODEL WFYBE
			REQUEST_MODEL BFYPR
			REQUEST_MODEL WFOBE	// dancers
			REQUEST_MODEL BFYRI	// bar staff
			REQUEST_MODEL HFYMD	// bar staff
			REQUEST_MODEL WMOCA	// punter
			REQUEST_MODEL BKb	 // PUNTERS
			REQUEST_MODEL HMORI
			REQUEST_MODEL BMYST
			REQUEST_MODEL BMYBU
			*/
			/*
			ped_cancel_wait = dancer_1
			GOSUB ped_cleanup
			ped_cancel_wait = dancer_2
			GOSUB ped_cleanup
			ped_cancel_wait = dancer_3
			GOSUB ped_cleanup
			ped_cancel_wait = dancer_4
			GOSUB ped_cleanup
			ped_cancel_wait = dancer_5
			GOSUB ped_cleanup
			ped_cancel_wait = s_punter_1
			GOSUB ped_cleanup
			ped_cancel_wait = s_punter_2
			GOSUB ped_cleanup
			ped_cancel_wait = s_punter_3
			GOSUB ped_cleanup
			ped_cancel_wait = s_punter_4
			GOSUB ped_cleanup
			ped_cancel_wait = s_punter_5
			GOSUB ped_cleanup
			ped_cancel_wait = s_punter_6
			GOSUB ped_cleanup
			ped_cancel_wait = bar_staff1
			GOSUB ped_cleanup
			ped_cancel_wait = bar_staff2
			GOSUB ped_cleanup
			*/
			
			/*
			MARK_CHAR_AS_NO_LONGER_NEEDED dancer_1
			MARK_CHAR_AS_NO_LONGER_NEEDED dancer_2
			MARK_CHAR_AS_NO_LONGER_NEEDED dancer_3
			MARK_CHAR_AS_NO_LONGER_NEEDED dancer_4
			MARK_CHAR_AS_NO_LONGER_NEEDED dancer_5
			MARK_CHAR_AS_NO_LONGER_NEEDED s_punter_1
			MARK_CHAR_AS_NO_LONGER_NEEDED s_punter_2
			MARK_CHAR_AS_NO_LONGER_NEEDED s_punter_3
			MARK_CHAR_AS_NO_LONGER_NEEDED s_punter_4
			MARK_CHAR_AS_NO_LONGER_NEEDED s_punter_5
			MARK_CHAR_AS_NO_LONGER_NEEDED s_punter_6
			MARK_CHAR_AS_NO_LONGER_NEEDED bar_staff1
			MARK_CHAR_AS_NO_LONGER_NEEDED bar_staff2

			 WFYPR	// dancers
			 WFYG1	//
			 WFYBE	//
			 BFYPR
			 WFOBE	// dancers
			 BFYRI	// bar staff
			 HFYMD	// bar staff
			 WMOCA	// punter
			 BKa	// punter
			 BKb	 // PUNTERS
			 HMOBE	 // PUNTERS
			 BMYST	 // Punter
			 BMYBU	 // punter
			 HMOST	 // bouncer
			 WMYBU	 // bouncer

			*/

			//MARK_MODEL_AS_NO_LONGER_NEEDED WFYPR
			MARK_MODEL_AS_NO_LONGER_NEEDED WFYG1
			MARK_MODEL_AS_NO_LONGER_NEEDED WFYBE
			MARK_MODEL_AS_NO_LONGER_NEEDED BFYPR
			MARK_MODEL_AS_NO_LONGER_NEEDED WFOBE
			MARK_MODEL_AS_NO_LONGER_NEEDED BFYRI
			MARK_MODEL_AS_NO_LONGER_NEEDED HFYMD
			MARK_MODEL_AS_NO_LONGER_NEEDED WMOCA
			MARK_MODEL_AS_NO_LONGER_NEEDED BKa
			MARK_MODEL_AS_NO_LONGER_NEEDED BKb
			MARK_MODEL_AS_NO_LONGER_NEEDED WMOST
			MARK_MODEL_AS_NO_LONGER_NEEDED WMOBE
			MARK_MODEL_AS_NO_LONGER_NEEDED BMYBB 
			MARK_MODEL_AS_NO_LONGER_NEEDED HMOST
			MARK_MODEL_AS_NO_LONGER_NEEDED WMYBU
			
			MARK_MODEL_AS_NO_LONGER_NEEDED machete
			MARK_MODEL_AS_NO_LONGER_NEEDED knifecur
			
			UNLOAD_SPECIAL_CHARACTER 19
			UNLOAD_SPECIAL_CHARACTER 18
			UNLOAD_SPECIAL_CHARACTER 17
			
			REMOVE_ANIMATION RIOT
			REMOVE_ANIMATION STRIP
			//SET_NEAR_CLIP 1.0
			flag_arm_bouncers = 0
			flag_launch_bouncers = 0
			flag_arm_barstaff = 0
			flag_strip_populate = 0
		ENDIF
	ENDIF
		
RETURN




waitstate_every_frame:

	IF IS_PLAYER_PLAYING player1
		
		IF NOT IS_CHAR_DEAD bouncer_1
		AND NOT IS_CHAR_DEAD bouncer_2
			IF NOT IS_CHAR_HEALTH_GREATER bouncer_1 95
			OR NOT IS_CHAR_HEALTH_GREATER bouncer_2 95
				GOSUB bouncers
			ENDIF
		ELSE
			GOSUB bouncers
		ENDIF
		
		// ******************* The Wide-eyed Oggler & Blade Bitch **********

		IF NOT IS_CHAR_DEAD dancer_2
		AND NOT IS_CHAR_DEAD s_punter_6
			IF NOT IS_CHAR_HEALTH_GREATER dancer_2 95
			OR NOT IS_CHAR_HEALTH_GREATER s_punter_6 95
				GOSUB geeble
			ENDIF
		ELSE
			GOSUB geeble
		ENDIF

		// ************ WEE CAB DRIVER ****************************
		IF NOT IS_CHAR_DEAD s_punter_1
		AND NOT IS_CHAR_DEAD dancer_3
			IF IS_CHAR_HEALTH_GREATER s_punter_1 95
			AND IS_CHAR_HEALTH_GREATER dancer_3 95
				SET_CHAR_WAIT_STATE s_punter_1 ped_routine_2 999999
			ELSE
				GOSUB gubble
			ENDIF
		ELSE
			GOSUB gubble
		ENDIF
		// ************ BIKERS & FAT CHICK ************************
		IF NOT IS_CHAR_DEAD s_punter_2
		AND NOT IS_CHAR_DEAD s_punter_3
		AND NOT IS_CHAR_DEAD dancer_5
			IF IS_CHAR_HEALTH_GREATER s_punter_2 95
			AND IS_CHAR_HEALTH_GREATER s_punter_3 95
			AND	IS_CHAR_HEALTH_GREATER dancer_5 95
				SET_CHAR_WAIT_STATE s_punter_2 ped_routine_2 999999
				SET_CHAR_WAIT_STATE s_punter_3 ped_routine_2 999999
			ELSE
				GOSUB gobble
			ENDIF
		ELSE
			GOSUB gobble
		ENDIF

		// ****************** EXCITED PUNTERS *********************
		IF NOT IS_CHAR_DEAD s_punter_4
		AND NOT IS_CHAR_DEAD s_punter_5
		AND NOT IS_CHAR_DEAD dancer_1
			IF NOT IS_CHAR_HEALTH_GREATER s_punter_4 95
			OR NOT IS_CHAR_HEALTH_GREATER s_punter_5 95
			OR NOT IS_CHAR_HEALTH_GREATER dancer_1 95
				GOSUB gibble
			ENDIF
		ELSE
			GOSUB gibble
		ENDIF

		/*
		IF NOT IS_CHAR_DEAD s_punter_6
			SET_CHAR_WAIT_STATE s_punter_6 ped_routine_1 999999
		ENDIF
		IF NOT IS_CHAR_DEAD s_punter_7
			SET_CHAR_WAIT_STATE s_punter_7 ped_routine_1 999999
		ENDIF
		IF NOT IS_CHAR_DEAD s_punter_8
			SET_CHAR_WAIT_STATE s_punter_8 ped_routine_1 999999
		ENDIF
		*/
		// ****************** BAR STAFF ***************************
		IF NOT IS_CHAR_DEAD bar_staff1
		AND NOT IS_CHAR_DEAD bar_staff2
			IF IS_CHAR_HEALTH_GREATER bar_staff1 95
			AND IS_CHAR_HEALTH_GREATER bar_staff2 95
				SET_CHAR_WAIT_STATE bar_staff1 ped_routine_3 999999
				SET_CHAR_WAIT_STATE bar_staff2 ped_routine_5 999999
			ELSE
				GOSUB gabble
			ENDIF
		ELSE
			GOSUB gabble
		ENDIF
		/*
		IF NOT IS_CHAR_DEAD bouncer_1
			SET_CHAR_WAIT_STATE bouncer_1 ped_routine_4 999999
		ENDIF
		IF NOT IS_CHAR_DEAD bouncer_2
			SET_CHAR_WAIT_STATE bouncer_2 ped_routine_4 999999
		ENDIF
		*/
	ENDIF
	GET_GAME_TIMER timer_populate_start

RETURN

bouncers:
	IF flag_arm_bouncers = 0
		REQUEST_MODEL bat
		WHILE NOT HAS_MODEL_LOADED bat
			REQUEST_MODEL bat
			WAIT 0
		ENDWHILE
		flag_arm_bouncers = 1
	ENDIF
	ped_rumble = bouncer_1
	IF NOT IS_AUSTRALIAN_GAME
		GOSUB battage
	ENDIF
	GOSUB rumble
	ped_rumble = bouncer_2
	IF NOT IS_AUSTRALIAN_GAME
		GOSUB battage
	ENDIF
	GOSUB rumble

RETURN

battage:
	IF NOT IS_CHAR_DEAD ped_rumble
		GIVE_WEAPON_TO_CHAR ped_rumble WEAPONTYPE_BASEBALLBAT 0
	ENDIF
RETURN

geeble:
	IF NOT IS_CHAR_DEAD s_punter_6
		STOP_CHAR_LOOKING s_punter_6
	ENDIF
	ped_flee = s_punter_6
	GOSUB flee
	IF flag_arm_dancer2 = 0
		IF NOT IS_AUSTRALIAN_GAME
			REQUEST_MODEL knifecur
			WHILE NOT HAS_MODEL_LOADED knifecur
				REQUEST_MODEL knifecur
				WAIT 0
			ENDWHILE
		ENDIF
		IF NOT IS_CHAR_DEAD dancer_2
			IF NOT IS_AUSTRALIAN_GAME
				GIVE_WEAPON_TO_CHAR dancer_2 WEAPONTYPE_KNIFE 0
			ENDIF
			ped_rumble = dancer_2
			GOSUB rumble
		ENDIF
		flag_arm_dancer2 = 1
	ENDIF
	GOSUB bouncers
RETURN

gubble:
	ped_flee = s_punter_1
	GOSUB flee
	ped_rumble = dancer_3
	GOSUB rumble
	GOSUB bouncers
RETURN

gibble:
	ped_rumble = s_punter_4
	GOSUB rumble
	ped_rumble = s_punter_5
	GOSUB rumble
	ped_flee = dancer_1
	GOSUB flee
	GOSUB bouncers
RETURN

gobble:
	ped_rumble = s_punter_2
	GOSUB rumble
	ped_rumble = s_punter_3
	GOSUB rumble
	ped_flee = dancer_5
	GOSUB flee
	GOSUB bouncers
RETURN

gabble:
	IF flag_arm_barstaff = 0
		IF NOT IS_AUSTRALIAN_GAME
			REQUEST_MODEL machete
			WHILE NOT HAS_MODEL_LOADED machete
				REQUEST_MODEL machete
				WAIT 0
			ENDWHILE
		ENDIF
		IF NOT IS_CHAR_DEAD bar_staff1
			IF NOT IS_AUSTRALIAN_GAME
				GIVE_WEAPON_TO_CHAR bar_staff1 WEAPONTYPE_MACHETE 0
			ENDIF
			ped_rumble = bar_staff1
			GOSUB rumble
		ENDIF
		flag_arm_barstaff = 1
	ENDIF
	ped_rumble = bar_staff2
	GOSUB rumble
	GOSUB bouncers
RETURN


rumble:
IF NOT IS_CHAR_DEAD ped_rumble
	SET_CHAR_WAIT_STATE ped_rumble 0 0
	IF IS_PLAYER_PLAYING player1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT ped_rumble player1
	ENDIF
	//TURN_CHAR_TO_FACE_PLAYER ped_rumble player1
	//SET_CHAR_THREAT_SEARCH ped_rumble THREAT_PLAYER1
ENDIF
RETURN

flee:
IF NOT IS_CHAR_DEAD ped_flee
	SET_CHAR_WAIT_STATE ped_flee 0 0
	SET_CHAR_OBJ_RUN_TO_COORD ped_flee 65.8 -1444.0
	MARK_CHAR_AS_NO_LONGER_NEEDED ped_flee
ENDIF
RETURN
/*
ped_cleanup:
	IF NOT IS_CHAR_DEAD ped_cancel_wait
		CLEAR_CHAR_WAIT_STATE ped_cancel_wait
		SET_CHAR_WAIT_STATE ped_cancel_wait 0 0
		MARK_CHAR_AS_NO_LONGER_NEEDED ped_cancel_wait
	ENDIF
RETURN
*/

the_groovy_room:
IF IS_PLAYER_PLAYING player1
	flag_player_on_mission = 1
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 ON
	SET_NEAR_CLIP 0.1
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	IF counter_tittycash_spent < 100
		LOAD_SPECIAL_CHARACTER 19 stripc

		WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 19
			LOAD_SPECIAL_CHARACTER 19 stripc
			WAIT 0
		ENDWHILE
		CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 66.6 -1455.46 9.56 dancer_4 // back room far right
		//flag_stripper_create = 1
	ENDIF
	IF counter_tittycash_spent > 99
	AND counter_tittycash_spent < 200
		LOAD_SPECIAL_CHARACTER 19 stripa
		WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 19
			LOAD_SPECIAL_CHARACTER 19 stripa
			WAIT 0
		ENDWHILE
		CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 66.6 -1455.46 9.56 dancer_4 // back room far right
		//flag_stripper_create = 1
	ENDIF
	IF counter_tittycash_spent > 199
		LOAD_SPECIAL_CHARACTER 19 stripb
		WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 19
			LOAD_SPECIAL_CHARACTER 19 stripb
			WAIT 0
		ENDWHILE
		CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 66.6 -1455.46 9.56 dancer_4 // back room far right
		//flag_stripper_create = 1
	ENDIF
	SET_CHAR_HEADING dancer_4 33.0
	CLEAR_CHAR_THREAT_SEARCH dancer_4
	SET_CHAR_WAIT_STATE dancer_4 WAITSTATE_STRIPPER 999999
	IF NOT IS_CHAR_DEAD scplayer
		SET_CHAR_COORDINATES scplayer 65.5 -1453.7 9.6
		SET_CHAR_WAIT_STATE scplayer ped_routine_2 999999
		SET_CHAR_HEADING scplayer 210.0
		//CHAR_LOOK_AT_CHAR_ALWAYS scplayer dancer_4
	ENDIF
	counter_strip_cam = 0
	
	SET_FIXED_CAMERA_POSITION 68.45 -1456.37 12.0 0.0 0.0 0.0
	POINT_CAMERA_AT_POINT 66.0 -1454.5 10.5 JUMP_CUT

	DO_FADE 500 FADE_IN
	
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	PRINT_HELP (EXIT_1)  // Press X button to exit.
	
	timera = 5000 
	WHILE IS_SCORE_GREATER player1 5
		WAIT 0
		//GOSUB waitstate_every_frame
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ELSE
			SET_CHAR_WAIT_STATE scplayer ped_routine_2 999999
		ENDIF

		IF timera > 5000
			ADD_SCORE player1 -5
			timera = 0
			counter_tittycash_spent = counter_tittycash_spent + 5
			++ counter_strip_cam
			IF counter_strip_cam = 6
				counter_strip_cam = 0
			ENDIF
			IF counter_strip_cam = 1
				SET_FIXED_CAMERA_POSITION 68.45 -1456.37 12.0 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 66.0 -1454.5 10.5 JUMP_CUT
				GOSUB play_stripper_line // SCFIX
			ENDIF
			IF counter_strip_cam = 2
				SET_FIXED_CAMERA_POSITION 65.21 -1454.1 9.56 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 67.36 -1456.33 11.58 JUMP_CUT
			ENDIF
			IF counter_strip_cam = 3
				SET_FIXED_CAMERA_POSITION 68.0 -1455.6 10.0 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 64.9 -1454.5 10.89 JUMP_CUT
			ENDIF
			IF counter_strip_cam = 4
				SET_FIXED_CAMERA_POSITION 67.47 -1456.14 10.0 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 65.4 -1454.25 11.37 JUMP_CUT
			ENDIF
			IF counter_strip_cam = 5
				SET_FIXED_CAMERA_POSITION 65.93 -1454.6 11.65 0.0 0.0 0.0
				POINT_CAMERA_AT_POINT 68.42 -1458.24 8.36 JUMP_CUT
			ENDIF
		ENDIF
		IF IS_BUTTON_PRESSED PAD1 CROSS
			GOTO prude
		ENDIF

	ENDWHILE
	
	PRINT_NOW (STRIP_1) 5000 1 // Not ehough cash, you cheap sleezebag.
	GOTO prude_2
	prude:
	WHILE IS_BUTTON_PRESSED PAD1 CROSS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	prude_2:
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	DELETE_CHAR dancer_4
	UNLOAD_SPECIAL_CHARACTER 19
	
	//counter_tittycash_spent = 600  // TEST! TEST! TEST!
	CLEAR_HELP

	IF counter_tittycash_spent > 299
	AND flag_strip_asset_cutscene = 0
		GOSUB outgoing
		LOAD_SCENE 93.3 -1472.14 strpbuyZ
		SET_FIXED_CAMERA_POSITION 103.0 -1488.0 15.7 0.0 0.0 0.0
		POINT_CAMERA_AT_POINT 99.5 -1476.6 16.75 JUMP_CUT

		//REMOVE_BLIP bankjob_contact_blip
		//ADD_SHORT_RANGE_SPRITE_BLIP_FOR_COORD strpbuyX strpbuyY strpbuyZ the_bankjob_blip bankjob_contact_blip
		CREATE_PROTECTION_PICKUP 93.3 -1472.14 strpbuyZ stripclub_revenue stripclub_revenue strip_cash_pickup

		DO_FADE 1000 FADE_IN

		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE

		timera = 0
		WHILE timera < 3000
			WAIT 0
		ENDWHILE
		PRINT_BIG ASSET_C 12000 6//BANK HEIST ASSET COMPLETED!
		PRINT_WITH_NUMBER_NOW ASSET_D stripclub_revenue 10000 1

		//SET_FIXED_CAMERA_POSITION 511.1 -61.0 14.0 0.0 0.0 0.0

		POINT_CAMERA_AT_POINT 93.3 -1472.14 strpbuyZ INTERPOLATION
		PLAY_MISSION_PASSED_TUNE 1

		timera = 0
		WHILE timera < 5500
			WAIT 0
		ENDWHILE

		DO_FADE 500 FADE_OUT

		WHILE GET_FADING_STATUS
			WAIT 0
		ENDWHILE

		LOAD_SCENE 72.0 -1454.7 9.45
		
		DELETE_OBJECT strip_door_poledance

		SET_AREA_VISIBLE VIS_STRIP_CLUB
		SET_EXTRA_COLOURS 2 FALSE
		SET_CAR_DENSITY_MULTIPLIER 0.1
		SWITCH_RUBBISH OFF
		flag_strip_asset_cutscene = 1
		flag_first_asset_complete = 1 // SCFIX: fix Ken's phonecall
		GET_GAME_TIMER timer_mobile_start // SCFIX
		++ counter_60_percent
		PLAYER_MADE_PROGRESS 1
	ENDIF

	IF IS_PLAYER_PLAYING player1
		SET_CHAR_WAIT_STATE scplayer 0 0
		SET_PLAYER_COORDINATES player1 72.0 -1454.7 9.45
		SET_PLAYER_HEADING player1 208.0
	ENDIF
	CLEAR_PRINTS
	RESTORE_CAMERA_JUMPCUT
	SET_CAMERA_BEHIND_PLAYER
	//SET_NEAR_CLIP 1.0
	DO_FADE 500 FADE_IN
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE
	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
		flag_player_on_mission = 0
	ENDIF
ENDIF
RETURN

the_groovier_room:
	flag_player_on_mission = 1
	SWITCH_WIDESCREEN ON
	SET_PLAYER_CONTROL player1 OFF
	SET_EVERYONE_IGNORE_PLAYER player1 ON
	SET_NEAR_CLIP 0.1
	SET_FADING_COLOUR 0 0 1
	DO_FADE 500 FADE_OUT
	WHILE GET_FADING_STATUS
		WAIT 0
		IF NOT IS_PLAYER_PLAYING player1
			RETURN
		ENDIF
	ENDWHILE

	SWITCH_STREAMING OFF

	LOAD_SPECIAL_CHARACTER 1 CSplay
	IF counter_private_dancer = 0
		//LOAD_SPECIAL_CHARACTER 19 stripc
		LOAD_SPECIAL_CHARACTER 19 stripa
	ENDIF
	IF counter_private_dancer = 1
		LOAD_SPECIAL_CHARACTER 19 stripa
		//LOAD_SPECIAL_CHARACTER 19 stripc
	ENDIF
	IF counter_private_dancer = 2
		LOAD_SPECIAL_CHARACTER 19 stripa
		//LOAD_SPECIAL_CHARACTER 19 stripb
	ENDIF

	LOAD_ALL_MODELS_NOW
							 
	WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 1
	OR NOT HAS_SPECIAL_CHARACTER_LOADED 19
		LOAD_SPECIAL_CHARACTER 1 CSplay
		LOAD_SPECIAL_CHARACTER 19 stripa
		WAIT 0
	ENDWHILE

	LOAD_CUTSCENE STRIPA

	SET_CUTSCENE_OFFSET 69.5133 -1444.6984 9.5255 
					
	CREATE_CUTSCENE_OBJECT SPECIAL01 cs_player
	SET_CUTSCENE_ANIM cs_player CSplay

	CREATE_CUTSCENE_OBJECT SPECIAL19 private_dancer
	SET_CUTSCENE_ANIM private_dancer stripa

	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_COORDINATES player1 66.5 -1445.5 9.6
		SET_PLAYER_HEADING player1 220.0
	ENDIF


	DO_FADE 1500 FADE_IN

	SWITCH_RUBBISH OFF
	SWITCH_STREAMING ON
	START_CUTSCENE

	// Displays cutscene text
	GET_CUTSCENE_TIME cs_time
	WHILE cs_time < 25000
		WAIT 0
		GET_CUTSCENE_TIME cs_time
	ENDWHILE



	DO_FADE 1500 FADE_OUT

	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE

	WHILE NOT HAS_CUTSCENE_FINISHED
		WAIT 0
	ENDWHILE

	CLEAR_CUTSCENE
	SWITCH_WIDESCREEN OFF
	RESTORE_CAMERA_JUMPCUT
	SET_CAMERA_IN_FRONT_OF_PLAYER

	UNLOAD_SPECIAL_CHARACTER 1
	UNLOAD_SPECIAL_CHARACTER 19
	DO_FADE 1500 FADE_IN
	++ counter_private_dancer
	IF counter_private_dancer > 2
		counter_private_dancer = 0
	ENDIF
	WHILE GET_FADING_STATUS
		WAIT 0
	ENDWHILE
	IF IS_PLAYER_PLAYING player1
		SET_PLAYER_CONTROL player1 ON
		SET_EVERYONE_IGNORE_PLAYER player1 OFF
		flag_player_on_mission = 0
	ENDIF
RETURN



// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo
// oooo    oooo    oooo    oooo    oooo    oooo      POPULATE MALIBU       oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo
// oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    
//     oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo    oooo

populate_malibu:
	IF flag_player_in_malibu = 1
		IF flag_malibu_populate = 0
			ped_routine_1 =	24 //sit down
			ped_routine_2 =	24 //sit idle
			ped_routine_3 =	25 //ATm
			ped_routine_4 =	29 //riot
			ped_routine_5 =	19 //chat
			//ped_routine_6 =
			//ped_routine_7 =
			//ped_routine_8 =					
			//ped_routine_9 =
			//ped_routine_10 =
			
			REQUEST_MODEL WFYG1	//
			//REQUEST_MODEL BFYST	//
			REQUEST_MODEL HFYRI	//
			REQUEST_MODEL BFYRI	//


			WHILE NOT HAS_MODEL_LOADED WFYG1
			OR NOT HAS_MODEL_LOADED HFYRI
			OR NOT HAS_MODEL_LOADED BFYRI
			//OR NOT HAS_MODEL_LOADED BFYST
				REQUEST_MODEL WFYG1	//
				//REQUEST_MODEL BFYST	//
				REQUEST_MODEL HFYRI	//
				REQUEST_MODEL BFYRI	//
				WAIT 0
			ENDWHILE

			REQUEST_MODEL CBa	//
			REQUEST_MODEL BMYRI	//
			REQUEST_MODEL BMYBB	//
			//REQUEST_MODEL BGa	//


			WHILE NOT HAS_MODEL_LOADED CBa
			OR NOT HAS_MODEL_LOADED BMYRI
			OR NOT HAS_MODEL_LOADED BMYBB
			//OR NOT HAS_MODEL_LOADED BGa
				REQUEST_MODEL CBa	//
				REQUEST_MODEL BMYRI	//
				REQUEST_MODEL BMYBB	//
				WAIT 0
			ENDWHILE
			
			REQUEST_MODEL FIREMAN
			REQUEST_MODEL WMYCW
			REQUEST_MODEL ARMY
			REQUEST_MODEL BKa
			
			WHILE NOT HAS_MODEL_LOADED FIREMAN
			OR NOT HAS_MODEL_LOADED WMYCW
			OR NOT HAS_MODEL_LOADED ARMY
			OR NOT HAS_MODEL_LOADED BKa
				REQUEST_MODEL FIREMAN
				REQUEST_MODEL WMYCW
				REQUEST_MODEL ARMY
				REQUEST_MODEL BKa
				WAIT 0
			ENDWHILE

			LOAD_SPECIAL_CHARACTER 19 BGa

			WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 19
				LOAD_SPECIAL_CHARACTER 19 BGa
				WAIT 0
			ENDWHILE


			REQUEST_ANIMATION STRIP //STRIP					 

			WHILE NOT HAS_ANIMATION_LOADED STRIP
				REQUEST_ANIMATION STRIP //STRIP					 
				WAIT 0
			ENDWHILE

			REQUEST_MODEL brassknuckle
			WHILE NOT HAS_MODEL_LOADED brassknuckle
				REQUEST_MODEL brassknuckle
				WAIT 0
			ENDWHILE

			
			WHILE counter_dancers < 26
				WAIT 0
				GOSUB dance_floor_boogey
				
				IF counter_dancers = 1
					CREATE_CHAR PEDTYPE_CIVMALE CBa dancer_x dancer_y dancer_z dancer_1 // far left pole
					var_dancer = dancer_1
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 2
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI dancer_x dancer_y dancer_z dancer_2 // far left pole
					var_dancer = dancer_2
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 3
					CREATE_CHAR PEDTYPE_CIVFEMALE HFYRI dancer_x dancer_y dancer_z dancer_3 // far left pole
					var_dancer = dancer_3
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 4
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI dancer_x dancer_y dancer_z dancer_4 // far left pole
					var_dancer = dancer_4
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 5
					CREATE_CHAR PEDTYPE_CIVMALE CBa dancer_x dancer_y dancer_z dancer_5 // far left pole
					var_dancer = dancer_5
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 6
					CREATE_CHAR PEDTYPE_CIVMALE BMYRI dancer_x dancer_y dancer_z dancer_6 // far left pole
					var_dancer = dancer_6
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 7
					CREATE_CHAR PEDTYPE_CIVMALE BMYBB dancer_x dancer_y dancer_z dancer_7 // far left pole
					var_dancer = dancer_7
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 8
					CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 dancer_x dancer_y dancer_z dancer_8 // far left pole
					var_dancer = dancer_8
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 9
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI dancer_x dancer_y dancer_z dancer_9 // far left pole
					var_dancer = dancer_9
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 10
					CREATE_CHAR PEDTYPE_CIVFEMALE HFYRI dancer_x dancer_y dancer_z dancer_10 // far left pole
					var_dancer = dancer_10
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 11
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI dancer_x dancer_y dancer_z dancer_11 // far left pole
					var_dancer = dancer_11
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 12
					CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 dancer_x dancer_y dancer_z dancer_12 // far left pole
					var_dancer = dancer_12
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 13
					CREATE_CHAR PEDTYPE_CIVMALE BMYRI dancer_x dancer_y dancer_z dancer_13 // far left pole
					var_dancer = dancer_13
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 14
					CREATE_CHAR PEDTYPE_CIVMALE BMYBB dancer_x dancer_y dancer_z dancer_14 // far left pole
					var_dancer = dancer_14
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 15
					CREATE_CHAR PEDTYPE_CIVFEMALE HFYRI dancer_x dancer_y dancer_z dancer_15 // far left pole
					var_dancer = dancer_15
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 16
					CREATE_CHAR PEDTYPE_CIVMALE BMYBB dancer_x dancer_y dancer_z dancer_16 // far left pole
					var_dancer = dancer_16
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 17
					CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 dancer_x dancer_y dancer_z dancer_17 // far left pole
					var_dancer = dancer_17
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 18
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI dancer_x dancer_y dancer_z dancer_18 // far left pole
					var_dancer = dancer_18
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 19
					CREATE_CHAR PEDTYPE_CIVFEMALE HFYRI dancer_x dancer_y dancer_z dancer_19 // far left pole
					var_dancer = dancer_19
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 20
					CREATE_CHAR PEDTYPE_CIVMALE BFYRI dancer_x dancer_y dancer_z dancer_20 // far left pole
					var_dancer = dancer_20
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 21
					CREATE_CHAR PEDTYPE_CIVMALE BMYRI dancer_x dancer_y dancer_z dancer_21 // far left pole
					var_dancer = dancer_21
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 22
					CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 dancer_x dancer_y dancer_z dancer_22 // far left pole
					var_dancer = dancer_22
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 23
					CREATE_CHAR PEDTYPE_CIVFEMALE HFYRI dancer_x dancer_y dancer_z dancer_23 // far left pole
					var_dancer = dancer_23
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 24
					CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 dancer_x dancer_y dancer_z dancer_24 // far left pole
					var_dancer = dancer_24
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 25
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI dancer_x dancer_y dancer_z dancer_25 // far left pole
					var_dancer = dancer_25
					GOSUB dancer_stuff
				ENDIF
				/*
				IF counter_dancers = 26
					CREATE_CHAR PEDTYPE_CIVMALE BMYRI dancer_x dancer_y dancer_z dancer_26 // far left pole
					var_dancer = dancer_26
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 27
					CREATE_CHAR PEDTYPE_CIVMALE CBa dancer_x dancer_y dancer_z dancer_27 // far left pole
					var_dancer = dancer_27
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 28
					CREATE_CHAR PEDTYPE_CIVFEMALE HFYRI dancer_x dancer_y dancer_z dancer_28 // far left pole
					var_dancer = dancer_28
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 29
					CREATE_CHAR PEDTYPE_CIVFEMALE WFYG1 dancer_x dancer_y dancer_z dancer_29 // far left pole
					var_dancer = dancer_29
					GOSUB dancer_stuff
				ENDIF
				IF counter_dancers = 30
					CREATE_CHAR PEDTYPE_CIVFEMALE BFYST dancer_x dancer_y dancer_z dancer_30 // far left pole
					var_dancer = dancer_30
					GOSUB dancer_stuff
				ENDIF
				*/
			ENDWHILE
			
			// ************************** VILLAGE PEOPLE ******************************************************************

			CREATE_CHAR PEDTYPE_CIVMALE FIREMAN 474.0 -72.14 9.5 dancer_26
			SET_CHAR_HEADING dancer_26 310.0
			var_dancer = dancer_26
			GOSUB dancer_stuff
			
			CREATE_CHAR PEDTYPE_CIVMALE WMYCW 473.2 -70.9 9.5 dancer_27
			SET_CHAR_HEADING dancer_27 310.0
			var_dancer = dancer_27
			GOSUB dancer_stuff
			
			CREATE_CHAR PEDTYPE_CIVMALE BKa 472.4 -69.65 9.5 dancer_28
			SET_CHAR_HEADING dancer_28 310.0
			var_dancer = dancer_28
			GOSUB dancer_stuff
			
			CREATE_CHAR PEDTYPE_CIVMALE ARMY 471.6 -68.4 9.5 dancer_29
			SET_CHAR_HEADING dancer_29 310.0
			var_dancer = dancer_29
			GOSUB dancer_stuff
			
			CREATE_CHAR PEDTYPE_CIVMALE COP 470.8 -67.15 9.5 dancer_30
			SET_CHAR_HEADING dancer_30 310.0
			var_dancer = dancer_30
			GOSUB dancer_stuff
			
			// ************************** BOUNCERS *************************************************************************

			CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 487.8 -77.3 10.5 bouncer_1
			SET_CHAR_HEADING bouncer_1 55.0
			SET_CHAR_PERSONALITY bouncer_1 PEDSTAT_PSYCHO
			GIVE_WEAPON_TO_CHAR bouncer_1 WEAPONTYPE_BRASSKNUCKLE 0
			
			CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 490.9 -74.4 10.5 bouncer_2
			SET_CHAR_HEADING bouncer_2 55.0
			SET_CHAR_PERSONALITY bouncer_2 PEDSTAT_PSYCHO
			GIVE_WEAPON_TO_CHAR bouncer_2 WEAPONTYPE_BRASSKNUCKLE 0
			
			IF flag_bought_malibu = 0
				CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 463.2 -58.16 10.5 bouncer_3
				SET_CHAR_HEADING bouncer_3 250.0
				SET_CHAR_PERSONALITY bouncer_3 PEDSTAT_PSYCHO
				SET_CHAR_HEALTH bouncer_3 200
				GIVE_WEAPON_TO_CHAR bouncer_3 WEAPONTYPE_BRASSKNUCKLE 0
				
				CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 465.5 -51.7 14.7 bouncer_4
				SET_CHAR_HEADING bouncer_4 134.0
				SET_CHAR_PERSONALITY bouncer_4 PEDSTAT_PSYCHO
				GIVE_WEAPON_TO_CHAR bouncer_4 WEAPONTYPE_BRASSKNUCKLE 0

				CREATE_CHAR PEDTYPE_CIVFEMALE BFYRI 465.25 -54.66 10.5 bar_staff1
				SET_CHAR_HEADING bar_staff1 50.0
				SET_CHAR_PERSONALITY bar_staff1 PEDSTAT_PSYCHO
				
			ELSE
				CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 467.65 -60.36 9.5 bouncer_3
				SET_CHAR_HEADING bouncer_3 250.0
				SET_CHAR_PERSONALITY bouncer_3 PEDSTAT_PSYCHO
				GIVE_WEAPON_TO_CHAR bouncer_3 WEAPONTYPE_BRASSKNUCKLE 0
				
				CREATE_CHAR PEDTYPE_CIVMALE SPECIAL19 468.0 -55.6 10.5 bouncer_4
				SET_CHAR_HEADING bouncer_4 60.0
				SET_CHAR_PERSONALITY bouncer_4 PEDSTAT_PSYCHO	
				GIVE_WEAPON_TO_CHAR bouncer_4 WEAPONTYPE_BRASSKNUCKLE 0
		
				LOAD_SPECIAL_CHARACTER 18 stripa
				WHILE NOT HAS_SPECIAL_CHARACTER_LOADED 18
					LOAD_SPECIAL_CHARACTER 18 stripa
					WAIT 0
				ENDWHILE

				CREATE_CHAR PEDTYPE_CIVFEMALE SPECIAL18 466.6 -54.56 10.5 bar_staff1
				SET_CHAR_HEADING bar_staff1 245.0
				SET_CHAR_PERSONALITY bar_staff1 PEDSTAT_PSYCHO	
				SET_CHAR_WAIT_STATE bar_staff1 25 8000

			ENDIF
			timera = 0
			flag_malibu_populate = 1
		ENDIF
		
		
		IF flag_malibu_populate = 1
			IF IS_PLAYER_PLAYING player1
				IF IS_PLAYER_SHOOTING player1
				OR IS_WANTED_LEVEL_GREATER player1 0
					IF flag_bought_malibu = 0
						GOSUB attack_the_bastard
//					ELSE
//						IF NOT IS_CHAR_DEAD bouncer_1
//							SET_PLAYER_AS_LEADER bouncer_1 player1
//						ENDIF
//						IF NOT IS_CHAR_DEAD bouncer_2
//							SET_PLAYER_AS_LEADER bouncer_2 player1
//						ENDIF
//						IF NOT IS_CHAR_DEAD bouncer_3
//							SET_PLAYER_AS_LEADER bouncer_3 player1
//						ENDIF
//						IF NOT IS_CHAR_DEAD bouncer_4
//							SET_PLAYER_AS_LEADER bouncer_4 player1
//						ENDIF
					ENDIF
				ENDIF
				
				IF timera > 10000
				AND flag_launch_bouncers = 0
					IF NOT IS_CHAR_DEAD bar_staff1
						SET_CHAR_WAIT_STATE bar_staff1 25 8000
					ENDIF
				ENDIF
				
				IF flag_bought_malibu = 0
				AND flag_launch_bouncers = 0
				AND NOT IS_CHAR_DEAD bar_staff1
					IF LOCATE_PLAYER_ON_FOOT_3D player1 462.7 -57.3 11.5 1.5 1.5 2.0 FALSE
						REQUEST_MODEL buddyshot
						WHILE NOT HAS_MODEL_LOADED buddyshot
							REQUEST_MODEL buddyshot
							WAIT 0
						ENDWHILE
						IF NOT IS_CHAR_DEAD bar_staff1
						AND IS_PLAYER_PLAYING player1
							GIVE_WEAPON_TO_CHAR bar_staff1 WEAPONTYPE_STUBBY_SHOTGUN 20
							SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bar_staff1 player1
						ENDIF
						GOSUB attack_the_bastard
						flag_launch_bouncers = 1
					ENDIF
				ENDIF
				
				IF timera > 10000
					
					flag_ymca = 1
					
					GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 360.0 radial_float

					IF NOT IS_CHAR_DEAD	dancer_26
						var_dancer = dancer_26
						GOSUB dancer_stuff
					ENDIF
					IF NOT IS_CHAR_DEAD	dancer_27
						var_dancer = dancer_27
						GOSUB dancer_stuff
					ENDIF
					IF NOT IS_CHAR_DEAD	dancer_28
						var_dancer = dancer_28
						GOSUB dancer_stuff
					ENDIF
					IF NOT IS_CHAR_DEAD	dancer_29
						var_dancer = dancer_29
						GOSUB dancer_stuff
					ENDIF
					IF NOT IS_CHAR_DEAD	dancer_30
						var_dancer = dancer_30
						GOSUB dancer_stuff
					ENDIF
					
					timera = 0

				ENDIF
				 
			ENDIF
		ENDIF
	ELSE
		IF flag_malibu_populate > 0
			
			WHILE NOT IS_PLAYER_PLAYING	player1
				WAIT 0
			ENDWHILE
			DELETE_CHAR dancer_1
			DELETE_CHAR dancer_2
			DELETE_CHAR dancer_3
			DELETE_CHAR dancer_4
			DELETE_CHAR dancer_5
			DELETE_CHAR dancer_6
			DELETE_CHAR dancer_7
			DELETE_CHAR dancer_8
			DELETE_CHAR dancer_9
			DELETE_CHAR dancer_10
			DELETE_CHAR dancer_11
			DELETE_CHAR dancer_12
			DELETE_CHAR dancer_13
			DELETE_CHAR dancer_14
			DELETE_CHAR dancer_15
			DELETE_CHAR dancer_16
			DELETE_CHAR dancer_17
			DELETE_CHAR dancer_18
			DELETE_CHAR dancer_19
			DELETE_CHAR dancer_20
			DELETE_CHAR dancer_21
			DELETE_CHAR dancer_22
			DELETE_CHAR dancer_23
			DELETE_CHAR dancer_24
			DELETE_CHAR dancer_25
			DELETE_CHAR dancer_26
			DELETE_CHAR dancer_27
			DELETE_CHAR dancer_28
			DELETE_CHAR dancer_29
			DELETE_CHAR dancer_30

			DELETE_CHAR bar_staff1
			//DELETE_CHAR bar_staff2
			
			DELETE_CHAR bouncer_1
			DELETE_CHAR bouncer_2
			DELETE_CHAR bouncer_3
			DELETE_CHAR bouncer_4
			/*
			REQUEST_MODEL FIREMAN
			REQUEST_MODEL WMYCW
			REQUEST_MODEL ARMYSKIN
			REQUEST_MODEL BKa
			REQUEST_MODEL BGa

			REQUEST_MODEL WFYG1	//
			REQUEST_MODEL BFYST	//
			REQUEST_MODEL HFYRI	//
			REQUEST_MODEL BFYRI	//
			REQUEST_MODEL CBa	//
			REQUEST_MODEL BMYRI	//
			REQUEST_MODEL BMYBB	//
			*/
			MARK_MODEL_AS_NO_LONGER_NEEDED FIREMAN
			MARK_MODEL_AS_NO_LONGER_NEEDED WMYCW
			MARK_MODEL_AS_NO_LONGER_NEEDED ARMY
			MARK_MODEL_AS_NO_LONGER_NEEDED BKa
			//MARK_MODEL_AS_NO_LONGER_NEEDED BGa

			MARK_MODEL_AS_NO_LONGER_NEEDED WFYG1
			//MARK_MODEL_AS_NO_LONGER_NEEDED BFYST
			MARK_MODEL_AS_NO_LONGER_NEEDED HFYRI
			MARK_MODEL_AS_NO_LONGER_NEEDED BFYRI
			MARK_MODEL_AS_NO_LONGER_NEEDED CBa
			MARK_MODEL_AS_NO_LONGER_NEEDED BMYRI
			MARK_MODEL_AS_NO_LONGER_NEEDED BMYBB
			
			MARK_MODEL_AS_NO_LONGER_NEEDED brassknuckle
			//MARK_MODEL_AS_NO_LONGER_NEEDED PSYCHO
			//MARK_MODEL_AS_NO_LONGER_NEEDED WFYBE
			
			UNLOAD_SPECIAL_CHARACTER 19
			IF flag_bought_malibu = 0
				IF flag_launch_bouncers = 1
					MARK_MODEL_AS_NO_LONGER_NEEDED buddyshot
				ENDIF
			ELSE
				UNLOAD_SPECIAL_CHARACTER 18
			ENDIF
				
			REMOVE_ANIMATION STRIP
			flag_malibu_populate = 0
			counter_dancers = 0
			dancer_x = 0.0
			dancer_y = 0.0
			radius = 0.0
			radial_float = 0.0
			flag_launch_bouncers = 0
			flag_ymca = 0
		ENDIF
	ENDIF

RETURN



dance_floor_boogey:

	GENERATE_RANDOM_FLOAT_IN_RANGE 474.0 481.0 dancer_x
	GENERATE_RANDOM_FLOAT_IN_RANGE -69.0 -61.0 dancer_y
	GENERATE_RANDOM_FLOAT_IN_RANGE 0.0 360.0 radial_float
	/*
	radial_float = radial_float + radial_step
	radius = radius + radius_increment 
	SIN radial_float dancer_x
	dancer_x = dancer_x * radius
	dancer_x = dancer_x + dancefloor_x
	COS radial_float dancer_y
	dancer_y = dancer_y * radius
	dancer_y = dancer_y + dancefloor_y
	*/
	++ counter_dancers
RETURN

dancer_stuff:
	IF flag_ymca < 1
		CLEAR_CHAR_THREAT_SEARCH var_dancer
		SET_CHAR_HEED_THREATS var_dancer TRUE
		SET_CHAR_PERSONALITY var_dancer PEDSTAT_STREET_GUY
		SET_CHAR_WAIT_STATE var_dancer WAITSTATE_STRIPPER 999999
		/*
		GENERATE_RANDOM_INT_IN_RANGE 1 3 var_pedstat
		IF var_pedstat = 1
			SET_CHAR_PERSONALITY var_dancer PEDSTAT_TOUGH_GUY
		ENDIF
		IF var_pedstat = 2
			SET_CHAR_PERSONALITY var_dancer PEDSTAT_STREET_GUY
		ENDIF
		IF var_pedstat = 3
			SET_CHAR_PERSONALITY var_dancer PEDSTAT_GEEK_GIRL
		ENDIF
		*/
	ENDIF
	IF flag_ymca < 2
		SET_CHAR_HEADING var_dancer radial_float
	ENDIF
	//TURN_CHAR_TO_FACE_COORD var_dancer dancefloor_x dancefloor_y dancefloor_z

RETURN


doorman_delete:
	IF flag_create_doorman = 1
		UNLOAD_SPECIAL_CHARACTER 15 
		//DELETE_CHAR door_man1
		//DELETE_CHAR door_man2
		REMOVE_CHAR_ELEGANTLY door_man1
		REMOVE_CHAR_ELEGANTLY door_man2
		flag_create_doorman = 0
		flag_launch_doorman = 0
	ENDIF
RETURN

attack_the_bastard:
IF IS_PLAYER_PLAYING player1
	IF NOT IS_CHAR_DEAD bouncer_1
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bouncer_1 player1
	ENDIF
	IF NOT IS_CHAR_DEAD bouncer_2
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bouncer_2 player1
	ENDIF
	IF NOT IS_CHAR_DEAD bouncer_3
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bouncer_3 player1
	ENDIF
	IF NOT IS_CHAR_DEAD bouncer_4
		SET_CHAR_OBJ_KILL_PLAYER_ON_FOOT bouncer_4 player1
	ENDIF
ENDIF
RETURN


aussie:
	REQUEST_MODEL weapon_strip
	WHILE NOT HAS_MODEL_LOADED weapon_strip
		WAIT 0
	ENDWHILE
RETURN

aussie2:
	MARK_MODEL_AS_NO_LONGER_NEEDED weapon_strip
RETURN


vehicle_heading:
IF IS_PLAYER_PLAYING player1
	IF IS_PLAYER_ON_ANY_BIKE player1
	OR IS_PLAYER_IN_MODEL player1 CADDY
		STORE_CAR_PLAYER_IS_IN_NO_SAVE player1 player_car_interiors
		SET_CAR_HEADING player_car_interiors float_heading
	ELSE
		SET_PLAYER_HEADING player1 float_heading
	ENDIF
ENDIF
RETURN

// SCFIX: START
play_stripper_line:
LVAR_INT stripper_line
GENERATE_RANDOM_INT_IN_RANGE 1 10 stripper_line
IF stripper_line = 1
	LOAD_MISSION_AUDIO 1 STRIP_1
ENDIF
IF stripper_line = 2
	LOAD_MISSION_AUDIO 1 STRIP_2
ENDIF
IF stripper_line = 3
	LOAD_MISSION_AUDIO 1 STRIP_3
ENDIF
IF stripper_line = 4
	LOAD_MISSION_AUDIO 1 STRIP_4
ENDIF
IF stripper_line = 5
	LOAD_MISSION_AUDIO 1 STRIP_5
ENDIF
IF stripper_line = 6
	LOAD_MISSION_AUDIO 1 STRIP_6
ENDIF
IF stripper_line = 7
	LOAD_MISSION_AUDIO 1 STRIP_7
ENDIF
IF stripper_line = 8
	LOAD_MISSION_AUDIO 1 STRIP_8
ENDIF
IF stripper_line = 9
	LOAD_MISSION_AUDIO 1 STRIP_9
ENDIF

WHILE NOT HAS_MISSION_AUDIO_LOADED 1
	WAIT 0
	IF NOT IS_PLAYER_PLAYING player1
		RETURN
	ENDIF
ENDWHILE

PLAY_MISSION_AUDIO 1

WHILE NOT HAS_MISSION_AUDIO_FINISHED 1
	WAIT 0
	IF NOT IS_PLAYER_PLAYING player1
		CLEAR_MISSION_AUDIO 1
		RETURN
	ENDIF
ENDWHILE

RETURN
}

{
force_extra_colors: // SCFIX
IF flag_is_in_transition1 = 1
	RETURN
ENDIF

IF flag_player_in_malibu = 1
	SET_EXTRA_COLOURS 1 FALSE
	RETURN
ENDIF

IF flag_player_in_stripclub = 1
	SET_EXTRA_COLOURS 2 FALSE
	RETURN
ENDIF

IF flag_player_in_hotel = 1
OR flag_player_in_apartment3c = 1
	SET_EXTRA_COLOURS 3 FALSE
	RETURN
ENDIF

IF flag_player_in_bank = 1
	SET_EXTRA_COLOURS 4 FALSE
	RETURN
ENDIF

IF flag_player_in_cop_shop = 1
	SET_EXTRA_COLOURS 5 FALSE
	RETURN
ENDIF

IF flag_player_in_mall = 1
	SET_EXTRA_COLOURS 6 FALSE
	RETURN
ENDIF

IF flag_player_in_shooting_range = 1
	SET_EXTRA_COLOURS 7 FALSE
	RETURN
ENDIF

IF flag_player_in_mansion = 1
	SET_EXTRA_COLOURS 8 FALSE
	RETURN
ENDIF

RETURN

force_extra_colors_script:
	GOSUB force_extra_colors
	WAIT 0
	GOTO force_extra_colors_script

// SCFIX: END


}